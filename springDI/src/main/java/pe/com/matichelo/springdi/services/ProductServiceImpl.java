package pe.com.matichelo.springdi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pe.com.matichelo.springdi.models.Product;
import pe.com.matichelo.springdi.repositories.IProductRepository;
import pe.com.matichelo.springdi.repositories.ProductRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductServiceImpl implements IProductService {

    private IProductRepository productRepository;

    // Value solo funciona si son parte del contexto de Spring, es decir, si son beans.
    @Value("${valor.impuesto}")
    private Double impuesto;

    // Otra forma de inyectar es por el método de setter.
//    @Autowired
//    public void setProductRepository(IProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    // Otra forma de inyectar es por el constructor.
    // @Qualifier: es una anotación que se utiliza para seleccionar un bean específico cuando hay veinte beans del mismo tipo.
//    public ProductServiceImpl(@Qualifier("productRepositoryJson") IProductRepository iProductRepository){
//        this.productRepository = iProductRepository;
//    }
    public ProductServiceImpl(@Qualifier("productJson") IProductRepository iProductRepository){
        this.productRepository = iProductRepository;
    }

    public List<Product> findAll(){
        // stream(): es un método de la clase List que permite trabajar con los elementos de la lista de forma funcional.
        // map(): es un método de la clase Stream que permite transformar los elementos de la lista.
        // collect(): es un método de la clase Stream que permite convertir los elementos de la lista en una colección.
        // Collectors.toList(): es un método de la clase Collectors que permite convertir los elementos de la lista
        //  de Stream en una lista.
        return productRepository.findAll().stream().map(
                p-> {
                    Product newProduct = new Product(p.getId(), p.getName(), p.getPrice() * impuesto);
                    return newProduct;
//                    p.setPrice(p.getPrice() * 1.25d);
//                    return p;
                }
        ).collect(Collectors.toList());
    }

    public Product findById(Integer id){
        return productRepository.findById(id);
    }

}
