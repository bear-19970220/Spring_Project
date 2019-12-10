import com.dfbz.controller.Dog;
import com.dfbz.service.UserService;
import com.dfbz.util.JdbcUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/10 12:06
 */

public class DemoTest {

    ApplicationContext ac;


    @Before
    public void before() {
        ac = new ClassPathXmlApplicationContext("spring.xml");
    }


    @Test
    public void test_dj() {
        Dog dog = ac.getBean("dog", Dog.class);
        dog.say();

    }


    @Test
    public void test000(){
        JdbcUtils jdbcUtils = ac.getBean("jdbcUtils", JdbcUtils.class);
        System.out.println(jdbcUtils.getConnection());
    }


    @Test
    public void test(){
        UserService userService = ac.getBean("userService", UserService.class);
        userService.callDao();
    }

}
