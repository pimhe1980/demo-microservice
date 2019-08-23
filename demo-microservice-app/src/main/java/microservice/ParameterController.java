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
public class ParameterController {

    @RequestMapping("/")
    public String select() {
        return "No token";
    }

    @RequestMapping(value = "/", headers = "token=1234567890")
    public String selectByOtherIndustry() {
        return "Parameter: none";
    }

    @RequestMapping(value = "/", headers = "token=1234567890", params = "game=e-retail")
    public String selectByERetail() {
        return "Parameter: Basketball";
    }

    @RequestMapping(value = "/", headers = "token=1234567890", params = "type=social")
    public String selectBySocial() {
        return "Parameter: Football";
    }
}