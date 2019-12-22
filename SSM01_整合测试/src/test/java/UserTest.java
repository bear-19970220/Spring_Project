import com.dfbz.com.dfbz.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/20 9:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})

public class UserTest {

    @Autowired
    UserController userController;

    @Test
    public void test_Spring_MyBatis() {
        userController.listUser();
    }

}
