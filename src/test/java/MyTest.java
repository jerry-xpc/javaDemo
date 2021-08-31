import com.alibaba.druid.pool.DruidDataSource;
import com.java.spring.controller.PersonController;
import com.java.spring.proxy.CalculatorProxy;
import com.java.spring.service.Calculator;
import com.java.spring.service.impl.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class MyTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
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
        String sql = "insert into emp(ENAME)values(?,?)";
        int zhangsan = jdbcTemplate.update(sql, "zhangsan");
        System.out.println(zhangsan);
    }
}
