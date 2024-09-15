package pe.com.matichelo.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

// @SpringBootApplication: se utiliza para marcar una clase de configuración principal que inicia una aplicación Spring Boot.
@SpringBootApplication
// @PropertySource: se utiliza para cargar un archivo de propiedades en un entorno de aplicación Spring. En este caso, se carga el archivo values.properties.
@PropertySources({
//                @PropertySource(value="classpath:values.properties", encoding = "UTF-8")
                @PropertySource(value="classpath:values.properties")
        })

public class SpringMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcApplication.class, args);
    }

}
