package microservice;

import microservice.conditionals.ConditionalOnConfigCenterProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pimhe
 */
@ConditionalOnConfigCenterProperty(cloud = "aws", region = "china")
@RestController
@RequestMapping("custom")
public class CustomAWSController {

    @RequestMapping("/")
    public String select() {
        return "AWS China.";
    }
}
