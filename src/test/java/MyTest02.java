import com.java.spring.entity.Emp;
import com.java.spring.service.impl.BookService;
import com.java.spring.service.impl.MultService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
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
}
