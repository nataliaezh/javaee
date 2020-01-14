package geekbrains.listener;
package geekbrains.listener;

import geekbrains.persist.Product;
import geekbrains.persist.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class AppListener implements ServletContextListener {

    private Logger logger = LoggerFactory.getLogger(AppListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();

        String jdbcConnectionString = ctx.getInitParameter("jdbcConnectionString");
        String dbUsername = ctx.getInitParameter("dbUsername");
        String dbPassword = ctx.getInitParameter("dbPassword");

        try {
            Connection conn = DriverManager.getConnection(jdbcConnectionString, dbUsername, dbPassword);
            ProductRepository productRepository = new ProductRepository(conn);
            ctx.setAttribute("connection", conn);
            ctx.setAttribute("productRepository", productRepository);

            if (productRepository.findAll().size() == 0) {
                productRepository.insert(new Product(-1L, "Product1", "Desc1", new BigDecimal(10)));
                productRepository.insert(new Product(-1L, "Product2", "Desc2", new BigDecimal(102)));
                productRepository.insert(new Product(-1L, "Product3", "Desc3", new BigDecimal(1030)));
                productRepository.insert(new Product(-1L, "Product4", "Desc4", new BigDecimal(140)));
                productRepository.insert(new Product(-1L, "Product5", "Desc1", new BigDecimal(106)));
                productRepository.insert(new Product(-1L, "Product6", "Desc2", new BigDecimal(1090)));
                productRepository.insert(new Product(-1L, "Product7", "Desc3", new BigDecimal(2030)));
                productRepository.insert(new Product(-1L, "Product8", "Desc4", new BigDecimal(540)));
                productRepository.insert(new Product(-1L, "Product9", "Desc1", new BigDecimal(50)));
                productRepository.insert(new Product(-1L, "Product10", "Desc2", new BigDecimal(3092)));
            }
        } catch (SQLException ex) {
            logger.error("", ex);
        }
    }


}
