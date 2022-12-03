package com.example.projetocopa.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class HomeController {


    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String login(){ return "home/login";
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index(){
        return "redirect:/grupo/";
    }

}
