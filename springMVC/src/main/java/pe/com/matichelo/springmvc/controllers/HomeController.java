package pe.com.matichelo.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /*
    Forward vs Redirect:
    La diferencia es que con el Forward se mantiene dentro de la misma petición http, y no pierdes los parámetros
    que tienes dentro del request, tampoco cambia la ruta url, ya que no hace un refresh, sino que despacha a otra
    acción del controlador pero sin recargar la página, mientras que el redirect cambia la ruta url, reinicia el
    request y refresca el navegador, además que todos los parámetros del request que teníamos antes del redirect se
    pierden en este nuevo request.
     */

    @GetMapping({"", "/", "/home"})
    public String home(){
        return "redirect:/details";
    }

    @GetMapping({"/contact", "/contacto"})
    public String contact(){
        return "forward:/details";
    }
}
