package microservice;

import microservice.conditionals.ConditionalOnConfigCenterProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pimhe
 */
@ConditionalOnConfigCenterProperty(cloud = "gcp", region = "global")
@RestController
@RequestMapping("custom")
public class CustomGCPController {

    @RequestMapping("/")
    public String select() {
        return "GCP Global.";
    }
}
