package microsoftwervice.plugin;

import microservice.plugin.BasePlugin;
import org.springframework.stereotype.Service;

/**
 * @author pimhe
 */
public class FooPlugin implements BasePlugin {

    static{
        System.out.println("Initialing the class FooPlugin.");
    }

    @Override
    public String say() {
        return "say foo.";
    }
}
