package microservice.internal;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author pimhe
 */
@RestController
public class Controller {

    @RequestMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String get(HttpServletResponse response) {
        return "internal resource";
    }
}
