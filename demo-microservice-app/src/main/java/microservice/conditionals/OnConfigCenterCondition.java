package microservice.conditionals;

import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 此处可以改为从配置中心获取值，以Apollo配置中心为例：
 * <pre>
 * {@code
 * public class OnConfigCenterCondition extends SpringBootCondition {
 *     @ApolloConfig
 *     private Config config;
 *
 *     public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
 *         Object propertiesName = metadata.getAnnotationAttributes(ConditionalOnConfigCenterProperty.class.getName()).get("name");
 *         Object propertyValue = metadata.getAnnotationAttributes(ConditionalOnConfigCenterProperty.class.getName()).get("havingValue");
 *         if (propertiesName != null) {
 *             String value = config.getProperty(propertiesName.toString()， null);
 *             if (value != null && value.equals(propertyValue)) {
 *                 return new ConditionOutcome(true, "get property value was "+value);
 *             }
 *         }
 *         return new ConditionOutcome(false, "none get property");
 *     }
 * }
 * }
 * </pre>
 *
 * @author pimhe
 */
public class OnConfigCenterCondition extends SpringBootCondition {

    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Object propertyName = metadata.getAnnotationAttributes(ConditionalOnConfigCenterProperty.class.getName()).get("name");
        Object propertyValue = metadata.getAnnotationAttributes(ConditionalOnConfigCenterProperty.class.getName()).get("havingValue");
        if (propertyName != null) {
            String value = context.getEnvironment().getProperty(propertyName.toString());
            if (value != null && value.equals(propertyValue)) {
                return new ConditionOutcome(true, "get property value was "+value);
            }
        }
        return new ConditionOutcome(false, "none get property");
    }
}
