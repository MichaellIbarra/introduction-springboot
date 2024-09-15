package pe.com.matichelo.springmvc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.matichelo.springmvc.models.User;

@RestController
@RequestMapping("/api/pathvar")
public class PathVariableController {

    @GetMapping("/person/{name}/{lastname}/{age}")
    public User userPathVar(@PathVariable String name, @PathVariable String lastname, @PathVariable Integer age){
        User user = new User(name, lastname, age);
        return user;
    }

    @GetMapping("/name/{nombre}")
    public User userName(@PathVariable(name = "nombre") String name){
        User user = new User();
        user.setName(name);
        return user;
    }

}
