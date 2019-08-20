package microservice;

import microservice.plugin.BasePlugin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ServiceLoader;

/**
 * @author pimhe
 */
@RestController
@RequestMapping("dynamic")
public class DynamicClassloadController {

    public BasePlugin getPlugin(){
        return ServiceLoader.load(BasePlugin.class).iterator().next();
    }

    @RequestMapping("/")
    public String load() {
        return getPlugin().say();
    }
}
