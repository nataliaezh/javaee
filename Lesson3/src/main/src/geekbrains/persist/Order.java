package geekbrains.persist;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    public Order() {
    }

    public enum Status {
            CREATED, PAID, SENT, RECEIVED, CANCELED
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private Long id;

        private User user;

        private List<OrderItem> items;

        private BigDecimal price;

        private String phone;


        private String address;


        private Status status;



        public void addItem(OrderItem item) {
            items.add(item);
            item.setOrder(this);
            price = price.add(item.getTotalPrice());
        }
    }
