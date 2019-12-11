import com.dfbz.dao.UserDao;
import com.dfbz.domain.User;
import com.dfbz.service.UserService;
import com.dfbz.util.JdbcUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/10 18:35
 */
public class UserTest {

    @Test
    public void test_dao() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = ac.getBean("userService", UserService.class);
//        for (User user : userDao.findAllUser()) {
//            System.out.println(user);
//        }
        userService.listUser().forEach(x -> System.out.println(x));
    }

}
