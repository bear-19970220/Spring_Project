import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/11 17:07
 */
public class DemoTest {

    @Test
    public void test() {


        Player player = new MyPlayer();
//        func.method();

        // 代理工厂
        ProxyFactory factory = new ProxyFactory(player);
        Player proxyPlayer = (Player) factory.createProxyObject();
        proxyPlayer.play();

//         内部类
        // 代理对象
//        Player proxyPlayer = (Player) Proxy.newProxyInstance(
//                player.getClass().getClassLoader(),
//                player.getClass().getInterfaces(),
//                new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        System.out.println("蓄力！");
//                        Object result = method.invoke(player, args);
//                        System.out.println("魂吸！");
//                        return result;
//                    }
//                });
//        proxyPlayer.play();


    }

}
