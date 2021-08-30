import com.java.spring.controller.PersonController;
import com.java.spring.service.impl.PersonSerciceImpl;
import com.java.spring.service.impl.StudentServiceImpl;
import com.java.spring.service.impl.TeacherServiceImpl;
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
    public void test02(){
        StudentServiceImpl studentServiceImpl = context.getBean("studentServiceImpl", StudentServiceImpl.class);
        studentServiceImpl.save();
        TeacherServiceImpl teacherServiceImpl = context.getBean("teacherServiceImpl", TeacherServiceImpl.class);
        teacherServiceImpl.save();
    }
}
