package Proxy;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    private Object target = null;

    private DynamicProxy(Object target) {
        this.target = target;
    }

    public static Object newInstance(Object target){
        Class targetClass = target.getClass();
        Class interfaces[] = targetClass.getInterfaces();
        return Proxy.newProxyInstance(targetClass. getClassLoader(), interfaces, new DynamicProxy(target));
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        Object invocationResult = null;
        try {
            System.out.println("Before method " + method.getName());
            invocationResult = method.invoke(this.target, args);
            System.out.println("After method " + method.getName());
        }
        catch(InvocationTargetException ite)
        {
            //this is the exception thrown by the method being invoked
            //we just rethrow the wrapped exception to conform to the interface
            throw ite.getTargetException();
        }
        catch(Exception e)
        {
            System.err.println("Invocation of " + method.getName() + " failed");
            //System.err.println(e.getMesage());
        }
        finally{
            return invocationResult;
        }
    }
}