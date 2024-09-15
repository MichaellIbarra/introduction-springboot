package pe.com.matichelo.springdi.services;

import pe.com.matichelo.springdi.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Integer id);
}
