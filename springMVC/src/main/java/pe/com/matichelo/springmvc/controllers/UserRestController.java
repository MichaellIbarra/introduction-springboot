package pe.com.matichelo.springmvc.controllers;

import org.springframework.web.bind.annotation.*;
import pe.com.matichelo.springmvc.models.User;
import pe.com.matichelo.springmvc.models.dto.UserDto;

import java.lang.reflect.Array;
import java.util.*;

@RestController
// @RequestMapping: se utiliza para asignar una URL base a un controlador o a un método de un controlador.
@RequestMapping("/api/v1/user")
public class UserRestController {

//    @RequestMapping(path = "/details", method = RequestMethod.GET) : Otra forma de definir en vez de @GetMapping
    @GetMapping
//    @ResponseBody  : se utiliza para indicar que el valor devuelto por un método de un controlador debe ser en el cuerpo de la respuesta HTTP, esta anotación se utiliza cuando se trabaja con controladores anotados con @Controller.
    public Map<String, Object> detailsUser(){
        // Map es una interfaz que representa un objeto que mapea claves a valores. Un mapa no puede contener claves duplicadas; cada clave puede mapear a un solo valor.
        // LinkedHashMap es una clase que implementa la interfaz Map y extiende la clase HashMap. Almacena los elementos en el orden en que se insertaron.
        // HashMap es una clase que implementa la interfaz Map. Almacena los elementos en una tabla hash, lo que proporciona un rendimiento rápido y un acceso rápido.
        Map<String, Object> details = new LinkedHashMap<>();
        details.put("title", "User Details");
        details.put("name", "Michaell Estiven");
        details.put("lastname", "Ibarra Martinez");
        return details;
    }


    @GetMapping("/userModel")
    public Map<String, Object> userModel(){
        User user = new User("Matichelo", "Ibarra", 18);
        Map<String,Object> userModel = new LinkedHashMap<>();
        userModel.put("title", "User Model");
        userModel.put("user", user);
        return userModel;
    }

    @GetMapping("/userDto")
    public UserDto userDto(){
        UserDto userDto = new UserDto();
        User user = new User("Michaell", "Martinez", 18);
        userDto.setName(user.getName().concat(" ").concat(user.getLastname()));
       userDto.setLastname(user.getLastname());
        userDto.setTitle("User DTO");
        return userDto;
    }

    @GetMapping("/users")
    public List<User> listUser(){
        User user1= new User("Estiven", "Dhamer", 19);
        User user2= new User("Javier", "Godoy", 54);
        User user3= new User("Games", "Quispe", 19);
        User user4= new User("Omar", "Rivera", 19);
        // List es una interfaz que representa una colección ordenada de elementos. Un objeto de la interfaz List puede contener elementos duplicados.
        // ArrayList es una clase que implementa la interfaz List. Almacena los elementos en un arreglo dinámico, lo que permite el acceso rápido a los elementos.
//        List<User> listUser = new ArrayList<>();
//        listUser.add(user1);
//        listUser.add(user2);
//        listUser.add(user3);
//        listUser.add(user4);

        // Arrays.asList: es un método de la clase Arrays que se utiliza para convertir una matriz en una lista, es decir, crea una lista a partir de una matriz.
        List<User> users = Arrays.asList(user1, user2, user3, user4);

        return users;
    }

}
