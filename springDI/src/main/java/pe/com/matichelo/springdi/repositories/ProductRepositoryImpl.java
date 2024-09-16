package pe.com.matichelo.springdi.repositories;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import pe.com.matichelo.springdi.models.Product;

import java.util.Arrays;
import java.util.List;
// Diferencias entre @Component y @Repository, es que @Repository trae funcionalidades adicionales para trabajar con bases de datos y excepciones.
// @Component: es un estereotipo genérico para cualquier componente de Spring.
// @Repository: para persistencia, componentes que acceden a los datos (DAO) data access object.

// @Primary: es una anotación que se utiliza para indicar que un bean es el principal cuando hay varios beans del mismo tipo.
@Primary
// También se le puede poner el nombre del bean, si no se pone el nombre del bean, se toma el nombre de la clase con la primera letra en minúscula.
//@Repository("productRepositoryImpl")
// @RequestScope: se utiliza para indicar que un bean es de alcance de solicitud, por defecto RequestScope es un alcance de solicitud en Spring por lo que se crea un nuevo bean para cada solicitud.
//@RequestScope
// SessionScope: se utiliza para indicar que un bean es de alcance de sesión, por defecto SessionScope es un alcance de sesión en Spring por lo que se crea un nuevo bean para cada sesión.
//@SessionScope
@Repository
public class ProductRepositoryImpl implements IProductRepository {

    /*
    ¿Qué es la inyección de dependencia?
    La inyección de dependencia es un patrón de diseño que permite a los objetos recibir las dependencias que necesitan
    en lugar de crearlas.
    Es suministrar a un objeto una referencia de otros(s) objeto(s) que necesita para realizar su función.
    Resuelve el problema de reutilización y modularidad entre componentes.
    Ejemplo:
    B es inyectado en A
    objetoB -> objetoA -objetoB
    Cuando se hace inyección de dependencia, ambos objetos deben estar manejados por el contenedor de Spring.

    Cómo Funciona
    El contenedor se encarga de gestionar las instancias y dependencias de componentes mediante la relación de objetos
    En contra-oposición de la creación explícita (operador new) de objetos.
    Esto permite un bajo acoplamiento y una alta cohesión entre los componentes.
    Tiene que plasmarse mediante la anotación @Autowired en el atributo de la clase que se quiere inyectar.

    ¿Qué es un contenedor de Spring?
    Es un contenedor de inversión de control (IoC) que administra los objetos de una aplicación.
    Spring IoC es el mecanismo central de Spring para la gestión de objetos.
    Spring IoC es responsable de crear los objetos, gestionar su ciclo de vida y configurar sus dependencias.
    loC significa que los objetos no crean otros objetos, sino que se les suministran los objetos que necesitan.

    Anotación @Autowired
    Especifica que se inyectará a un objeto de spring (bean o componente) en un atributo de otro objeto.
    Es decir para inyectar un bean de spring en el componente actual
    Por defecto, la inyección falla si no encuentra candidatos disponibles.

    Anotación @Autowired
    Lugares donde se puede utilizar @Autowired
    Atributos
    Constructores
    Métodos de setter

    ¿Qué es un bean?
    Es un objeto que es instanciado, ensamblado y gestionado por un contenedor de Spring.

    ¿Qué es un componente?
    Es una clase que es un bean y que es administrada por el contenedor de Spring.

    Anotación @Component y sus derivados
    @Component: es un estereotipo genérico para cualquier componente de Spring.
    @Repository, @Service y @Controller: son especializaciones de @Component para usos más específicos
    @Repository: para persistencia, componentes que acceden a los datos (DAO) data access object.
    @Service: para servicios de la lógica de negocio.
    @Controller: para controladores de la capa de presentación.

       Componentes o Beans
       El término "bean" se utiliza para referirse a cualquier componente manejado por Spirng.
       Los beans deben ser anotado con la anotación @Component o sus derivados.
       Debe tener un constructor vacío por defecto, sin argumentos}
       Cualquier beans anotado con @Component (o sus derivados) bajo el package base serán instanciados y manejados
       por el contenedor DI de spring (Auto-scanning).

        Otra forma de registrar componente en el contenedor de Spring es mediante la anotación @Bean
        @Configuration y @Bean
        @Bean: es una anotación que se utiliza para indicar que un método de un componente de Spring devuelve un objeto
        @Configuration: es una configuración de Spring que se utiliza para definir los beans de la aplicación.
        Una clase anotada con @Configuration indica que la clase puede ser utilizada por el contenedor de Spring con una fuente
        de definición de beans.

        @configuration
        public class AppConfig{
        @Bean
        public IUserService userService(){
        return new UserServiceImpl();
          }
        }

        @Configuration y @Bean
        La anotación @Bean juega el mismo papel que anotar la clase con @Component.
        La definido anteriormente en la clase AppConfig , es equivalente a:
        @Component
        public class UserService implements IUserService{
        }

     */
    private List<Product> productList;
    public ProductRepositoryImpl(){
        this.productList = Arrays.asList(
                new Product(1, "Tv", 20.90),
                new Product(2, "Celular", 99.00)
        );
    }

    public List<Product> findAll(){
        return this.productList;
    }

    public Product findById(Integer id){
        // stream(): es un método de la clase List que permite trabajar con los elementos de la lista de forma funcional.
        // filter(): es un método de la clase Stream que permite filtrar los elementos de la lista.
        return this.productList.stream().filter(p -> p.getId().equals(id) ).findFirst().orElse(null);
    }

}
