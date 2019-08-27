package microsoftwervice.plugin;

import microservice.plugin.BasePlugin;

/**
 * @author pimhe
 */
public class FooPlugin implements BasePlugin {

    static{
        System.out.println("Initialing Foo Plugin.");
    }

    @Override
    public String say() {
        return "say foo.";
    }
}
