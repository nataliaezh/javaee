package controller;


import geekbrains.cart.CartService;
import geekbrains.daos.ProductDAO;
import geekbrains.persist.Product;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named
public class ProductController implements Serializable {

    @EJB
    private CartService cartService;

    @EJB
    private ProductDAO productDAO;

    private List<Product>products;
   public void preLoadProducts(ComponentSystemEvent componentSystemEvent){
    this.products= productDAO.findByIds();
   }

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

    public List<Product> getAllProducts()  {
        return products;
    }

    public String editProduct(Product product) {
        this.product = product;
        return "/product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(Product product) throws SQLException {
        productDAO.delete(product.getId());
        //     return  "/index.xhtml?faces-redirect=true";
    }

    public String saveProduct() throws SQLException {
        if (product.getId() == null) {
            productDAO.save(product);
        } else {
            productDAO.update(product);
        }
        return "/index.xhtml?faces-redirect=true";
    }
    public void addToCart(Product product){
        cartService.addProductQty(product, "green", 1);
    }
}