import com.dfbz.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/11 18:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class DemoTest {

    @Autowired
    Player myPlayer;

    @Test
    public void test() {
        myPlayer.play();
        myPlayer.eat();
        myPlayer.sleep();
    }

}
