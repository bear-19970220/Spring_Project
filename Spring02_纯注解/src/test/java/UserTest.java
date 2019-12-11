import com.dfbz.config.ConfigBean;
import com.dfbz.controller.UserController;
import com.dfbz.util.JdbcUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/11 12:33
 */


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {ConfigBean.class})
public class UserTest {

//    @Autowired
//    UserController userController;

    @Test
    public void test() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(ConfigBean.class);
        UserController userController = ac.getBean(UserController.class);
        userController.listUser();
    }

}
