package microservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pimhe
 */
@RestController
@RequestMapping("dynamic")
public class DynamicClassloadController {

    @RequestMapping("/")
    public String load() {
        System.out.println("********** Starting loading ************");
        String className = "com.github.pimhe.demo.microsoftwervice.plugin.FooPlugin";
        try {
            return "Loaded class: "+Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "Not found the class "+className;
        } finally {
            System.out.println("************* Loaded ***************");
        }
    }
}
