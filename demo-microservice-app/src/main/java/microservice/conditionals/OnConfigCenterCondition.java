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
//     @ApolloConfig
//     private Config config;

    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Object cloud = metadata.getAnnotationAttributes(ConditionalOnConfigCenterProperty.class.getName()).get("cloud");
        Object region = metadata.getAnnotationAttributes(ConditionalOnConfigCenterProperty.class.getName()).get("region");
        if (cloud != null && region !=null) {
            String envCloud = context.getEnvironment().getProperty("cloud");
            String envRegion = context.getEnvironment().getProperty("region");
//            String envCloud = config.getProperty("cloud"， null);
//            String envRegion = config.getProperty("region"， null);
            if (envCloud != null && envCloud.equals(cloud) &&
                envRegion != null && envRegion.equals(region)) {
                return new ConditionOutcome(true,
                        String.format("region is %s and cloud is %s in configuration.", envRegion, envCloud));
            }
        }
        return new ConditionOutcome(false, "none get property");
    }
}
