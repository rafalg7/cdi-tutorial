package pl.itcrowd.tutorials.cditutorial.framework;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: Rafal Gielczowski
 * Date: 2/18/13 Time: 4:41 PM
 */


@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Logged {
}
