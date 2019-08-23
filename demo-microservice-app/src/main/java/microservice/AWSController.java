package microservice;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pimhe
 */
@ConditionalOnProperty(name = "cloud", havingValue = "aws")
@RestController
public class AWSController {

    @RequestMapping("/")
    public String select() {
        return "Amazon Web Service";
    }
}
