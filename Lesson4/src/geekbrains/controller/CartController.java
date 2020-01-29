package geekbrains.controller;

import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class CartController implements Serializable {
    @Inject
    private ProductRepository productRepository;

    private BigDecimal totalPrice;

    private List<Product> productList;

    @Inject
    private ProductController productController;


    @PostConstruct
  public void init(){
       productList = new ArrayList<>(); }



    public String addProductToCart(Product product) throws SQLException {
        product = productRepository.findById(product.getId());

           productList.add(product);

        return "/cart.xhtml?faces-redirect=true";

    }

    public void delete(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            product = productList.get(i);
            if (product != null) {
                productList.remove(product);
            }
        }
    }

    public List<Product> showCart(){
        return productList;
      }

    public void recalculate() {
        totalPrice = new BigDecimal(0);
        for (int i=0;i<productList.size();i++){
            Product product=productList.get(i);
            totalPrice=productList.get(i).getPrice();
        }
        //
       //     <h:column>
      //          <f:facet name="header">Total Price</f:facet>
       //         #{cartController.recalculate()}
      //      </h:column>
    }
}





