package logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class Logger {
    @AroundInvoke
    public Object printLog(InvocationContext ctx) throws Exception{
        System.out.println("Вызван метод " + ctx.getMethod().getName());
        return ctx.proceed();
    }

}
