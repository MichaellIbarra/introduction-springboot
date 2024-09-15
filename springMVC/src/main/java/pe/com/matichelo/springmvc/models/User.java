package pe.com.matichelo.springmvc.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
//    En Java, los métodos que comienzan con get se denominan "métodos getter". Estos métodos se utilizan para obtener el valor de una propiedad privada de una clase. En el contexto de tu clase User, los métodos getter permiten acceder a los valores de los atributos name, lastname y edad.  En el UserRestController, cuando se crea una instancia de User y se agrega al Map, los métodos getter se utilizan para recuperar los valores de los atributos del objeto User.
    private String name;
    private String lastname;
    private int age;
}
