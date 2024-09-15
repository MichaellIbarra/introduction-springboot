package pe.com.matichelo.springmvc.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.com.matichelo.springmvc.models.User;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    // Usando @RequestParam que es una anotación de Spring que se utiliza para vincular un parámetro de solicitud web
    // a un método de controlador y se puede usar para obtener valores de parámetros de solicitud web.

    @GetMapping("/foo")
    public User foo(@RequestParam(required = false, name = "name", defaultValue = "Valor no encontrado") String name,
                    @RequestParam String lastname, @RequestParam Integer age) {
        User user = new User(name, lastname, age);
        user.setName(name != null ? name : "eliminado");
        user.setLastname(lastname);
        user.setAge(age);
        return user;
    }

    // En parametro no cuenta con la anotación @RequestParam, por lo que se obtiene el valor directamente del método.
    @GetMapping("/name")
    public User getName(String name) {
        var user = new User();
        user.setName(name);
        return user;
    }

    // En este caso se obtiene el valor del parametro apellido y se asigna al atributo lastname del objeto user.
    @GetMapping("/lastname")
    public User getLastname(@RequestParam(name = "apellido") String lastname) {
        var user = new User();
        user.setLastname(lastname);
        return user;
    }

    // Usando HttpServletRequest para obtener el valor del parametro edad, HttpServletRequest es una interfaz que se
    // utiliza para proporcionar información sobre la solicitud HTTP.
    @GetMapping("/age")
    public User getAge(HttpServletRequest request) {
        var user = new User();
        var age = 0;
        try {
            age = Integer.parseInt(request.getParameter("age"));
        } catch (NumberFormatException numberFormatException) {
            System.out.println(numberFormatException);
        }
        user.setAge(age);
        return user;
    }
}
