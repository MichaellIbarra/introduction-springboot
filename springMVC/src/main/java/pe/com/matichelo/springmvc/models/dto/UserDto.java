package pe.com.matichelo.springmvc.models.dto;

import lombok.Data;
import pe.com.matichelo.springmvc.models.User;

@Data
public class UserDto {
    private String title;
//    private User user;
    private  String name;
    private String lastname;
}
