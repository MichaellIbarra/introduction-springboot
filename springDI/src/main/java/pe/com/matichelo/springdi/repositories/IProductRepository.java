package pe.com.matichelo.springdi.repositories;

import pe.com.matichelo.springdi.models.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(Integer id);
}
