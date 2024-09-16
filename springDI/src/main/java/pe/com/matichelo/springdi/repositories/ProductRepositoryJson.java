package pe.com.matichelo.springdi.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import pe.com.matichelo.springdi.models.Product;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryJson implements IProductRepository{

    private List<Product> list;

    public ProductRepositoryJson() throws IOException {
        // Resource: nos permite acceder a archivos de recursos en el classpath de la aplicación.
        Resource resource = new ClassPathResource("json/product.json");
        // ObjectMapper: nos permite convertir objetos Java a JSON y viceversa.
        ObjectMapper objectMapper = new ObjectMapper();
        // Arrays.asList: convierte un array en una lista.
        // readValue: convierte un archivo en un objeto.
        // getFile: obtiene el archivo.
        // Product[].class: convierte el archivo en un array de Product.
        // list: guarda la lista de productos.
        list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
    }

    @Override
    public List<Product> findAll() {
        return this.list;
    }

    @Override
    public Product findById(Integer id) {
        // stream: nos permite trabajar con colecciones de datos.
        // filter: nos permite filtrar los datos.
        // p -> p.getId().equals(id): condición para filtrar.
        // findFirst: obtiene el primer elemento que cumple la condición.
        // orElse: si no encuentra el elemento, devuelve null.
        return this.list.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
