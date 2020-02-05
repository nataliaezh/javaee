package persist;

import geekbrains.logger.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Future;

@Stateless
public class ProductRepositoryImpl implements ProductRepository, ProductRepositoryRemote {
@PersistenceContext(unitName = "ds")
private EntityManager em;
    @PostConstruct
    public void init()  {

        if (findAll().size() == 0) {
            insert(new Product(-1L, "Product1", "Desc1", new BigDecimal(10)));
            insert(new Product(-1L, "Product2", "Desc2", new BigDecimal(102)));
            insert(new Product(-1L, "Product3", "Desc3", new BigDecimal(1030)));
            insert(new Product(-1L, "Product4", "Desc4", new BigDecimal(140)));
        }
    }
    @TransactionAttribute
    @Override
    @Interceptors({Logger.class})
    public Product insert(Product product) {
        em.persist(product);
        return product;
    }

    @TransactionAttribute
    @Override
    @Interceptors({Logger.class})
    public void update(Product product) {
        em.merge(product);
    }

    @TransactionAttribute
    @Override
    @Interceptors({Logger.class})
    public void delete(long id) {
      Product product =  em.find(Product.class,id);
      em.remove(product);
    }

    @Override
    @Interceptors({Logger.class})
    public Product findById(long id)  {
       return em.find(Product.class,id);
    }

    @Override
    @Interceptors({Logger.class})
    public List<Product> findAll()  {
        return em.createQuery("from Product", Product.class).getResultList();
    }

    @Asynchronous
    @Override
    @Interceptors({Logger.class})
    public Future<List<Product>> findAllAsync() throws InterruptedException {
        Thread.sleep(15000);
        return new AsyncResult<>(em.createQuery("from Product", Product.class).getResultList());
    }

    }
