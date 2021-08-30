import com.java.spring.controller.PersonController;
import com.java.spring.proxy.CalculatorProxy;
import com.java.spring.service.Calculator;
import com.java.spring.service.impl.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
//        System.out.println(myCalculatorImpl.getClass());
//        myCalculatorImpl.div(1,0);
    }
}
