package ru.starovoytov.springCore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    private String sayHello(){
        return "hello";
    }
}
