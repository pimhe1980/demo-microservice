package com.github.pimhe.demo.microservice;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pimhe
 */
@ConditionalOnProperty(name = "ctrl.selector", havingValue = "base")
@RestController
public class SelectableController {

    @RequestMapping("/")
    public String select() {
        return "Base";
    }
}