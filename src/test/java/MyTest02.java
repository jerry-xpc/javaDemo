import com.java.spring.entity.Emp;
import com.java.spring.service.impl.BookService;
import com.java.spring.service.impl.MultService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MyTest02 {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    @Autowired
    BookService bookService;
    @Test
    public void test01() throws Exception{
        MultService bean = context.getBean(MultService.class);
        bean.mult();
    }

    @Test
    public void test02(){
        BookService bean = context.getBean(BookService.class);
        Emp emp = new Emp();
        emp.setEmpno(2);
        emp.setJob("aaa111");
        bean.updateEmp(emp);
    }

    @Test
    public void Test03(){

        try {
            Emp emp = new Emp();
            emp.setEmpno(1111);
            emp.setEname("dsdsdsd");
            emp.setJob("22222111ds");
            bookService.updateEmp(emp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
