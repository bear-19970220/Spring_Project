import com.dfbz.dao.UserDao;
import com.dfbz.domain.User;
import com.dfbz.service.UserService;
import com.dfbz.util.JdbcUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/10 18:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class UserTest {

    @Autowired
    UserService userService;

    @Test
    public void test_dao() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
//        UserService userService = ac.getBean("userService", UserService.class);
        userService.listUser().forEach(x -> System.out.println(x));
    }

}
