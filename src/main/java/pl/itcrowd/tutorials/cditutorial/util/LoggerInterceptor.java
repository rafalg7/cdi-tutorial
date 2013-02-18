package pl.itcrowd.tutorials.cditutorial.util;

import pl.itcrowd.tutorials.cditutorial.framework.Logged;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * User: Rafal Gielczowski
 * Date: 2/18/13 Time: 4:43 PM
 */

@Logged
@Interceptor
public class LoggerInterceptor implements Serializable {

    @AroundInvoke
    public Object logInvocation(InvocationContext ic) throws Exception {
        Logger logger = Logger.getLogger(ic.getMethod().getDeclaringClass().getCanonicalName());
        logger.info("Before: "+ic.getMethod()+" with params :"+ Arrays.toString(ic.getParameters()));
        Object res = ic.proceed();
        logger.info("After: "+ic.getMethod()+" with params :"+ Arrays.toString(ic.getParameters()));
        return res;
    }

}
