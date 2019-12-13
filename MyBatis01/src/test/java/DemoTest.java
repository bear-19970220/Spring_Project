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
import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/12 17:31
 */
public class DemoTest {

    @Test
    public void test() throws IOException {
//        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
//        InputStream ins = Resources.getResourceAsStream("mybatis.cfg.xml");
//        SqlSessionFactory factory = factoryBuilder.build(ins);
//        SqlSession sqlSession = factory.openSession();

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
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        userMapper.findAllUser().forEach(user-> System.out.println(user));


        // 增
//        User user = new User(3, "小白狼");
//        sqlSession.insert("addUser", user);


        // 多参数
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserByIdAndName(1, "极光之域");
//        User user = userMapper.findUserById(2);
        System.out.println(user);


        sqlSession.commit();
        sqlSession.close();

    }


}
