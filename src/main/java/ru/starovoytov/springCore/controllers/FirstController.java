package ru.starovoytov.springCore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")//данная аннотация добаыляет в методы к запросу ещё "/first" и получаем - "/first/hello" и "/first/goodbye"
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam (value = "name", required = false) String name,//required = false - позволяет доставать value = "name", где name будет равен null
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){

        //System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message", "Hello " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam (value = "a") double a,//required = false - позволяет доставать value = "name", где name будет равен null
                            @RequestParam(value = "b") double b,
                            @RequestParam(value = "operation") String operation,
                            Model model){
        String result;
        switch (operation){
            case "multi":
                result = String.valueOf(a * b);
                break;
            case "add":
                result = String.valueOf(a + b);
                break;
            case "sub":
                result = String.valueOf(a - b);
                break;
            case "div":
                if (b == 0) result = "You cannot divide by zero";
                else result = String.valueOf(a / b);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operation);
        }
        model.addAttribute("result", result);
        return "first/calculator";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }
}
