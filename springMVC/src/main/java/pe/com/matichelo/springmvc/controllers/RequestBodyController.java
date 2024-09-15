package pe.com.matichelo.springmvc.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.matichelo.springmvc.models.User;

@RestController
@RequestMapping("/api/requestbody")
public class RequestBodyController {

    @PostMapping("/createuser")
    public User createUser(@RequestBody User user){
        User user1 = new User(user.getName(), user.getLastname(), user.getAge());
        return user1;
    }

}
