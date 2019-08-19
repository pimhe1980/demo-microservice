package microservice;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pimhe
 */
@RestController
@RequestMapping("param")
public class ParameterSelectableController {

    @RequestMapping("/")
    public String select() {
        return "No token";
    }

    @RequestMapping(value = "/", headers = "token=1234567890")
    public String selectByNoneParam() {
        return "Parameter: none";
    }

    @RequestMapping(value = "/", headers = "token=1234567890", params = "game=basketball")
    public String selectByHeaderBasketball() {
        return "Parameter: Basketball";
    }

    @RequestMapping(value = "/", headers = "token=1234567890", params = "game=football")
    public String selectByHeaderFootball() {
        return "Parameter: Football";
    }
}
