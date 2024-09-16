package pe.com.matichelo.springdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.matichelo.springdi.models.Product;
import pe.com.matichelo.springdi.services.IProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    // Por defecto, los controladores son Singleton, es decir, solo se crea una instancia de la clase.
//    @Qualifier("productServiceImpl")
    @Autowired
    private IProductService productService;

    // GetMapping son por request HTTP
    @GetMapping
    public List<Product> findAll() {
//        ProductService productService = new ProductService();
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Integer id) {
//        ProductService productService = new ProductService();
        return this.productService.findById(id);
    }
}
