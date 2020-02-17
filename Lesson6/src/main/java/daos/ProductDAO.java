package daos;

import geekbrains.persist.Product;
import geekbrains.persist.ProductRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ProductDAO {
    private ProductRepository productsRepository;

    @EJB
    public void setProductsRepository(ProductRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Product save(Product product) {
        return productsRepository.insert(product);
    }

    public Product findById(Long id) {
        return productsRepository.findById(id);
    }

    public List<Product> findByIds() {
        return (List<Product>)productsRepository.findAll();
    }

    public void delete(Long id) {
        productsRepository.delete(id);
    }

    public void update(Product product) {
    }
}


