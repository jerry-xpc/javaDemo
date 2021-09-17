import com.alibaba.druid.pool.DruidDataSource;
import com.java.spring.controller.PersonController;
import com.java.spring.dao.EmpDao;
import com.java.spring.entity.Emp;
import com.java.spring.proxy.CalculatorProxy;
import com.java.spring.service.BookService;
import com.java.spring.service.Calculator;
import com.java.spring.service.impl.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;
import java.util.List;

public class MyTest {
    ClassPathXmlApplicationContext context =   new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test01(){

        PersonController personController = context.getBean("personController", PersonController.class);
        System.out.println(personController);
        PersonSerciceImpl personService = context.getBean("personSerciceImpl", PersonSerciceImpl.class);
        System.out.println(personService);

        personController.save();
    }

    @Test
    public void test02() throws Exception{
        StudentServiceImpl studentServiceImpl = context.getBean("studentServiceImpl", StudentServiceImpl.class);
        studentServiceImpl.save();
        TeacherServiceImpl teacherServiceImpl = context.getBean("teacherServiceImpl", TeacherServiceImpl.class);
        teacherServiceImpl.save();


    }

    @Test
    public void test03() throws Exception{
        Calculator proxy = CalculatorProxy.getProxy(new MyCalculatorImpl());
        proxy.add(1,2);
    }

    @Test
    public void test04() throws Exception{
        Calculator calculator = context.getBean( Calculator.class);
        calculator.add(1,2);
        System.out.println(calculator.getClass());
    }

    @Test
    public void test05() throws Exception{
        MyCalculatorImpl1 myCalculatorImpl = context.getBean(MyCalculatorImpl1.class);
        myCalculatorImpl.add(1,2);
    }

    @Test
    public void test06() throws Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        MyCalculatorImpl1 bean = context.getBean("myCalculatorImpl12",MyCalculatorImpl1.class);
        bean.add(1,2);
    }

    @Test
    public void test07() throws Exception{
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        long connectCount = dataSource.getConnectCount();
        System.out.println(connectCount);
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println(jdbcTemplate);
    }

    @Test
    public void test08() throws Exception{
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into emp(EMPNO,ENAME)values(?,?)";
        int zhangsan = jdbcTemplate.update(sql, "111","zhangsan");
        System.out.println(zhangsan);
    }

    @Test
    public void test09(){
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into emp(empno,ename) values(?,?)";
        int zhangsan = jdbcTemplate.update(sql, 1111, "zhangsan");
        System.out.println(zhangsan);
    }

    @Test
    public void test10(){
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into emp(empno,ename) values(?,?)";
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{2222,"lisi"});
        list.add(new Object[]{3333,"wangwu"});
        list.add(new Object[]{4444,"maliu"});
        int[] result = jdbcTemplate.batchUpdate(sql,list);
        for (int i : result) {
            System.out.println(i);
        }
    }

    @Test
    public void test11(){
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "delete from emp where empno = ?";
        int zhangsan = jdbcTemplate.update(sql, 1111);
        System.out.println(zhangsan);
    }

    @Test
    public void test12(){
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "update  emp set ename=? where empno=?";
        int zhangsan = jdbcTemplate.update(sql,  "mashibing",2222);
        System.out.println(zhangsan);
    }

    @Test
    public void test13(){
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select * from emp where empno=?";
        Emp result = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Emp.class),7369);
        System.out.println(result);
    }

    @Test
    public void test14(){
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select * from emp where sal >?";
        List<Emp> result = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Emp.class),1500);
        for (Emp emp : result) {
            System.out.println(emp);
        }
    }

    @Test
    public void test15(){
        EmpDao empDao = context.getBean("empDao", EmpDao.class);
        empDao.save(new Emp(1114,"zhangsan"));
    }

    @Test
    public void test16() throws Exception{
        BookService bean = context.getBean(BookServiceImpl.class);
        bean.buyBook();
    }
}
