package pe.com.matichelo.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.com.matichelo.springmvc.models.User;

@Controller
public class UserController {
    // Controller es una clase que maneja las solicitudes HTTP. Estas clases son anotadas con @Controller y @RestController.
    // @Controller: se utiliza para marcar una clase como un controlador de Spring MVC.
    // @RestController: se utiliza para marcar una clase como un controlador de Spring MVC que proporciona datos de forma de un objeto JSON.
    // Componente es una clase que se utiliza para marcar una clase como un bean de Spring, es decir, una clase que se va a instanciar y administrar por el contenedor de Spring.
    // DispatcherServlet es un servlet de front controller que maneja todas las solicitudes HTTP y las envía a los controladores correspondientes.
    // DTO (Data Transfer Object) es un patrón de diseño que se utiliza para transferir datos entre subsistemas de un software, generalmente entre la capa de presentación y la capa de servicios.

    // Cómo funciona Spring MVC:
    /*
    El front Controller (DispatcherServlet) recibe todas las solicitudes HTTP y las envía a los controladores correspondientes.
    Luego aplica un controlador basado en la URL (Handler Mapping) y asigna el request al controlador.
    El controlador se relaciona con componentes de la lógica de negocio y envía datos a  la vista usando el objeto Model : Model es un contenedor que contiene los datos del modelo. Se utiliza para pasar datos entre un controlador y una vista.
El Controlador retorna/asigna el nombre de la vista lógica a mostrar
Se selecciona un View Resolver, el cual aplica un determinando tipo de vista (Html, JSP, PDF, Excel, etc)
Finalmente la vista es mostrada al cliente usando los datos del modelo.

    // Cómo funciona un Controlador
    Un controlador es una clase que maneja las solicitudes HTTP. Estas clases son anotadas con @Controller y @RestController.

     */
    @GetMapping("/details")
    public String details(Model model){
        var user = new User("Michaell Estiven", "Ibarra Martinez",19);
        // El objeto Model es un contenedor que contiene los datos del modelo. Se utiliza para pasar datos entre un controlador y una vista.
        model.addAttribute("title", "User Details");
        model.addAttribute("name", "Michaell Estiven");
        model.addAttribute("lastname", "Ibarra Martinez");
        model.addAttribute("user", user);
        return "details";
    }
}
