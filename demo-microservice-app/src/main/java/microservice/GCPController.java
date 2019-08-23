package microservice;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pimhe
 */
@ConditionalOnProperty(name = "cloud", havingValue = "gcp")
@RestController
public class GCPController {

    @RequestMapping("/")
    public String select() {
        return "Google Cloud Platform";
    }
}
