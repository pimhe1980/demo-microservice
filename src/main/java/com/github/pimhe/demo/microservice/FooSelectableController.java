package com.github.pimhe.demo.microservice;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pimhe
 */
@ConditionalOnProperty(name = "ctrl.selector", havingValue = "foo")
@RestController
public class FooSelectableController {

    @RequestMapping("/")
    public String select() {
        return "Foo";
    }
}
