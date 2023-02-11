package com.proyectoweb.curly.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
@Controller
public class HomeControlador {

    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/home";
    }

    @GetMapping({ "/login" })
    public String login() {
        return "login";
    }
    @GetMapping({ "/registro" })
    public String registro() {
        return "registro";
    }

}
