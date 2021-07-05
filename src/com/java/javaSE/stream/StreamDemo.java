package com.java.javaSE.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    //通过数组来生成
    public static void gen1(){
        String[] strings = {"a","b","c","d"};
        Stream stream = Stream.of(strings);
        stream.forEach(System.out::print);
        System.out.println();
    }

    //通过集合来生成
    public static void gen2(){
        List<String> list = Arrays.asList("1","2","3","4");
        Stream stream = list.stream();
        stream.forEach(System.out::print);
        System.out.println();
    }

    //generate，如果在不使用limit限制执行范围的情况下会是一个死循环，一直打印1
    public static void gen3(){
        Stream<Integer> stream = Stream.generate(()->1);
//        stream.forEach(System.out::print);
        stream.limit(10).forEach(System.out::print);
        System.out.println();
    }

    //使用iterate生成,跟gen3一样，如果不使用limit限制循环次数，会一直死循环执行
    public static void gen4(){
        Stream<Integer> stream = Stream.iterate(1,x->x+1);
//        stream.forEach(System.out::print);
        stream.limit(10).forEach(System.out::print);
        System.out.println();
    }

    //其他生成方式
    public static void gen5(){
        String str = "abcdefg";
        IntStream intStream = str.chars();
        intStream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        //-----------通过stream生成的操作--------------------------
        System.out.println("gen1()通过数组来生成---------------");
        gen1();
        System.out.println("gen2()通过集合来生成---------------");
        gen2();
        System.out.println("gen3()通过generate来生成---------------");
        gen3();
        System.out.println("gen4()通过使用iterate生成---------------");
        gen4();
        System.out.println("gen5()其他生成方式---------------");
        gen5();

        System.out.println("----------------------------------------------------------");

        //中间操作：如果调用你方法之后返回的结果是stream对象就意味着是一个中间操作
        Arrays.asList(1,2,3,4,5).stream().filter((x)-> x %2 ==0).forEach(System.out::println);
        //求出结果集合中所有偶数的和
        int count = Arrays.asList(1,2,3,4,5,6,7,8,9).stream().filter(x->x%2==0).mapToInt(x->x).sum();
        System.out.println(count);
        //求集合中最大的值
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Optional<Integer> max = list.stream().max((a,b)-> a - b);
        System.out.println(max.get());
        //求集合的最小值
        System.out.println(list.stream().min((a, b) -> a - b).get());
        //取出满足条件的任意一个数
        Optional<Integer> any = list.stream().filter(x->x%2==0).findAny();
        System.out.println(any.get());
        //取出满足条件的第一个数
        Optional<Integer> first = list.stream().filter(x->x%10==6).findFirst();
        System.out.println(first.get());
        //打印会在返回之前都会输出
        Stream<Integer> integerStream = list.stream().filter(i->{
            System.out.println("运行代码");
            return i%2==0;
        });
        System.out.println(integerStream.findAny().get());
        //获取最小值，不使用min的方式
        Optional<Integer> mi = list.stream().sorted().findFirst();
        System.out.println(mi.get());
        //获取最大值，不使用max的方式
        Optional<Integer> mx = list.stream().sorted((a,b)->b-a).findFirst();
        System.out.println(mx.get());
        //自然排序
        Arrays.asList("java","c#","python","scala").stream().sorted().forEach(System.out::println);
        //根据字符长度从小到大排序
        Arrays.asList("java","c#","python","scala").stream().sorted((a,b)->a.length()-b.length()).forEach(System.out::println);
        //将集合中的元素进行过滤同时返回一个集合对象
        List<Integer> collect = list.stream().filter(x->x%2==0).collect(Collectors.toList());
        collect.forEach(System.out::println);
        //去重
        Arrays.asList(1,2,3,3,3,4,5,2).stream().distinct().forEach(System.out::println);
        Arrays.asList(1,2,3,3,3,4,5,2).stream().collect(Collectors.toSet()).forEach(System.out::println);
        //打印20-30这样的集合数据
        Stream.iterate(1,x->x+1).limit(50).skip(20).limit(10).forEach(System.out::println);

        String st = "11,22,33,44,55";
        //计算和
        System.out.println(Stream.of(st.split(",")).mapToInt(x -> Integer.valueOf(x)).sum());
        System.out.println(Stream.of(st.split(",")).mapToInt(Integer::valueOf).sum());
        System.out.println(Stream.of(st.split(",")).map(x -> Integer.valueOf(x)).mapToInt(x -> x).sum());
        System.out.println(Stream.of(st.split(",")).map(Integer::valueOf).mapToInt(x -> x).sum());
        //创建自定义对象
        String str2 = "java,scala,python";
        Stream.of(str2.split(",")).map(x->new Person(x)).forEach(System.out::println);
        Stream.of(str2.split(",")).map(Person::new).forEach(System.out::println);
        Stream.of(str2.split(",")).map(x->Person.build(x)).forEach(System.out::println);
        Stream.of(str2.split(",")).map(Person::build).forEach(System.out::println);
        //将str中的每一个数值都打印出来，同时算出最终的求和结果
        System.out.println(Stream.of(st.split(",")).peek(System.out::println).mapToInt(Integer::valueOf).sum());
        System.out.println(list.stream().allMatch(x -> x > 0));
    }
}
