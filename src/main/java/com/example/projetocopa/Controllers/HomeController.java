package com.example.projetocopa.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @RequestMapping("/teste")
    public String teste(){
        return "home/teste";
    }

    @RequestMapping("/login")
    public String login(){ return "home/login";
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }
}
