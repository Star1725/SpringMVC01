package ru.starovoytov.springCore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping("/first")//данная аннотация добаыляет в методы к запросу ещё "/first" и получаем - "/first/hello" и "/first/goodbye"
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request){
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }
}
