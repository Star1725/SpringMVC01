package ru.starovoytov.springCore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping("/first")//данная аннотация добаыляет в методы к запросу ещё "/first" и получаем - "/first/hello" и "/first/goodbye"
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam (value = "name", required = false) String name,//required = false - позволяет доставать value = "name", где name будет равен null
                            @RequestParam(value = "surname", required = false) String surname){

        System.out.println("Hello " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }
}
