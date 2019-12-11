import org.omg.CORBA.portable.InvokeHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/11 17:03
 */
public class ProxyFactory implements InvocationHandler {

    private Object sourceObject;

    public ProxyFactory(Object sourceObject) {
        this.sourceObject = sourceObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("被代理的对象的方法代理执行-前");
        Object result = method.invoke(sourceObject, args);
        System.out.println("被代理的对象的方法代理执行-后");
        return result;
    }

    public Object createProxyObject() {
        return Proxy.newProxyInstance(
                sourceObject.getClass().getClassLoader(),
                sourceObject.getClass().getInterfaces(),
                this
        );
    }

}
