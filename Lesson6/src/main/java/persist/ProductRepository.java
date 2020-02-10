package persist;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductRepository {

    Product insert(Product product);


    void update(Product product);


    void delete(long id);

    Product findById(long id);

    List<Product> findAll();
}
