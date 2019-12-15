import com.dfbz.domain.User;
import com.dfbz.mapper.UserMapper;
import com.dfbz.util.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/12 17:31
 */
public class DemoTest {

    @Test
    public void test() throws IOException {

        SqlSession sqlSession = MyBatisUtils.createSqlSession();
//        System.out.println(sqlSession);

        /**
         * 古老的方式：iBatis 遗留
         */
//        List<User> findAllUser = sqlSession.selectList("findAllUser");
//        findAllUser.forEach(user -> System.out.println(user));
        /**
         * 面向接口，更好
         */
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(null, "极光");
//        User user = new User(null, null);
        List<User> users = userMapper.findUserByCondition(user);
        users.forEach(u -> System.out.println(u));

//        User user = new User(1, "极光之域");
//        userMapper.updateUser(user);

//        userMapper.findAllUser().forEach(user-> System.out.println(user));


//        List<User> users = new ArrayList<>();
//        users.add(new User(3, "张三"));
//        users.add(new User(4, "李四"));
//        users.add(new User(5, "王五"));
//        User[] users = {new User(3, "张三"),new User(4, "李四"),new User(5, "王五") };
//        userMapper.addSomeUser(users);

//        userMapper.deleteUserBatch(new Integer[]{3,4,5});


        // 增
//        User user = new User(3, "小白狼");
//        sqlSession.insert("addUser", user);


        // 多参数
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        User user = userMapper.findUserByIdAndName(1, "极光之域");
////        User user = userMapper.findUserById(2);
//        System.out.println(user);


        sqlSession.commit();
        sqlSession.close();

    }


}
