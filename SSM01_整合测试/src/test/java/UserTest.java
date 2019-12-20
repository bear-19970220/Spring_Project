import com.dfbz.com.dfbz.controller.UserController;
import com.dfbz.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

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
