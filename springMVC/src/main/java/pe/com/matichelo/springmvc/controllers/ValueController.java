package pe.com.matichelo.springmvc.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/value")
public class ValueController {

    // @Value es una anotación de Spring que se utiliza para inyectar valores de propiedades de un archivo de propiedades en un campo de una clase. En este caso, se inyectan los valores de las propiedades username, age, message y listOfValues en los campos de la clase ValueController.
    @Value("${config.username}")
    private String username;
    @Value("${config.age}")
    private int age;
//    @Value("${config.message}")
//    private String message;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;
// El uso de #{} permite evaluar una expresión de SpEL (Spring Expression Language) en el valor de la propiedad. El uso eso nos ayuda a modificar el valor de la propiedad antes de inyectarlo en el campo de la clase.
    // El uso de ${} permite acceder a una propiedad de un archivo de propiedades. En este caso. se accede a la propiedad config.listOfValues.
    @Value("#{ '${config.listOfValues}'.toUpperCase().split(',')  }")
    private List<String> listValue;

    @Value("#{ '${config.listOfValues}'.toUpperCase() }")
    private String stringValues;

    // en SpEl dentro de ${} no lleva comillas simples porque ya se está evaluando una expresión de SpEL y si se coloca comillas simples, se evaluará como un String.
    @Value("#{ ${config.valuesMap} }")
    private Map<String,Object> valuesMap;

    @Value("#{ ${config.valuesMap}.product }")
    private String nameProduct;

//    @Value("${config.listOfValues}")
//    private String[]listOfValues;


    @GetMapping("/person")
    public Map<String, Object> getPerson(@Value("${config.message}") String message ){
        Map<String, Object> person = new LinkedHashMap<>();
        person.put("username", username);
        person.put("age", age);
        person.put("message", message);
        person.put("listOfValues", listOfValues);
        person.put("listValue", listValue);
        person.put("stringValues", stringValues);
        person.put("'valuesMap'", valuesMap);
        person.put("nameProduct",nameProduct);
        return person;
    }

}
