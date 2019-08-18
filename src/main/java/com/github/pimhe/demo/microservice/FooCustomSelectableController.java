package com.github.pimhe.demo.microservice;

import com.github.pimhe.demo.microservice.conditionals.ConditionalOnConfigCenterProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pimhe
 */
@ConditionalOnConfigCenterProperty(name = "ctrl.selector", havingValue = "foo")
@RestController
@RequestMapping("custom")
public class FooCustomSelectableController {

    @RequestMapping(value = "/")
    public String select() {
        return "Foo";
    }

}
