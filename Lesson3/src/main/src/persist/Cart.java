package persist;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private ProductRepository productRepository;
    private Map<Long, OrderItem> items;
    private BigDecimal totalPrice;

    public Map<Long, OrderItem> getItems() {
        return items;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @PostConstruct
    public void init() {
        items = new LinkedHashMap<>();
    }

    public void addProduct(Product product, HttpServletRequest req, HttpServletResponse resp) {
        OrderItem item = items.get(product.getId());
        if (item == null) {
            try {
                item = new OrderItem(productRepository.findById(Long.parseLong(req.getParameter("id"))));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            item.setItemPrice(product.getPrice());
            item.setProduct(product);
            item.setQuantity(0);
        }
        item.setQuantity(item.getQuantity() + 1);
        item.setTotalPrice(item.getItemPrice().multiply(new BigDecimal(item.getQuantity())));
        items.put(product.getId(), item);
        recalculate();
    }

    public void removeItem(Product product) {
        items.remove(product.getId());
        recalculate();
    }

    public void clear() {
        items.clear();
        totalPrice = new BigDecimal(0);
    }

    private void recalculate() {
        totalPrice = new BigDecimal(0);
        items.values().stream().forEach(oi -> totalPrice = totalPrice.add(oi.getTotalPrice()));
    }
}