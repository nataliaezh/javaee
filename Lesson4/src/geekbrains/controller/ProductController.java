package geekbrains.controller;

import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

//Данный бин будет храниться в аттрибутах сессии
@SessionScoped
@Named
public class ProductController implements Serializable {

    @Inject
    private ProductRepository productRepository;


    public String creatProduct() {
        this.product = new Product();
        return "/product.xhtml?faces-redirect=true";
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private Product product;

    public List<Product> getAllProducts() throws SQLException {
        return productRepository.findAll();
    }

    public String editProduct(Product product) {
        this.product = product;
        return "/product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(Product product) throws SQLException {
        productRepository.delete(product.getId());
        //     return  "/index.xhtml?faces-redirect=true";
    }

    public String saveProduct() throws SQLException {
        if (product.getId() == null) {
            productRepository.insert(product);
        } else {
            productRepository.update(product);
        }
        return "/index.xhtml?faces-redirect=true";
    }
}