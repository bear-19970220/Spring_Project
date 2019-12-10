import controller.DemoController;
import controller.Dog;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import utils.DBUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/9 11:37
 */
public class DemoTest {

    ClassPathXmlApplicationContext ac;

    @Before
    public void init_test() {
        ac = new ClassPathXmlApplicationContext("bean.xml");
    }

    @Test
    public void test_array() {
        DemoController demoController = ac.getBean("demoController", DemoController.class);
        System.out.println(demoController);

        List<String> strings = demoController.getsList();
        strings.forEach(x -> System.out.println(x));


//        String[] strs = demoController.getStrs();
//        for (String str : strs) {
//            System.out.println(str);
//        }
//        System.out.println(demoController);
//        ac.close();
    }


    @Test
    public void test_factory() {
        Dog dog = ac.getBean("dog", Dog.class);
        dog.eat();
    }


    @Test
    public void test_props() {
        DBUtils dbUtils = ac.getBean("DBUtils", DBUtils.class);
        dbUtils.showMsg();
    }

}
