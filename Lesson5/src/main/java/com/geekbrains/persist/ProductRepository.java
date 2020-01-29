package main.java.com.geekbrains.persist;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

//Означает, что данный бин существует столько, сколько выполняется приложение. Он будет хранится в
//специальном хранилище одного из аттритутов контекста приложения
@ApplicationScoped
@Named
public class ProductRepository {
@PersistenceContext(unitName = "ds")
private EntityManager em;
    @PostConstruct
    public void init() throws SQLException {

        if (findAll().size() == 0) {
            insert(new Product(-1L, "Product1", "Desc1", new BigDecimal(10)));
            insert(new Product(-1L, "Product2", "Desc2", new BigDecimal(102)));
            insert(new Product(-1L, "Product3", "Desc3", new BigDecimal(1030)));
            insert(new Product(-1L, "Product4", "Desc4", new BigDecimal(140)));
        }
    }
    @Transactional
    public void insert(Product product) {
        em.persist(product);
    }
@Transactional
    public void update(Product product) {
        em.merge(product);
    }
@Transactional
    public void delete(long id) {
      Product product =  em.find(Product.class,id);
      em.remove(product);
    }

    public Product findById(long id)  {
       return em.find(Product.class,id);
    }

    public List<Product> findAll()  {
       return em.createQuery("from Product", Product.class).getResultList();
    }

    }
