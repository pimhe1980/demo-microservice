package microservice.conditionals;


import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author pimhe
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnConfigCenterCondition.class)
public @interface ConditionalOnConfigCenterProperty {
    String name();

    String havingValue() default "";
}
