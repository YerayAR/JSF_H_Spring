package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
/**
 * Controlador que sirve la página principal.
 */
public class HomeController {

    /**
     * Atiende la ruta raíz y retorna la plantilla inicial.
     */
    @GetMapping("/")
    public String home() {
        return "index";
    }
}
