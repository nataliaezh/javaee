package main.java.com.geekbrains.cart;

import com.geekbrains.persist.Product;


import java.util.Objects;

public class LineItem {
    private Product product;

    public LineItem(Product product, String color) {
        this.product = product;

        this.color = color;
    }

    public LineItem() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private Integer qty;

    private String color;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return Objects.equals(product, lineItem.product) &&
                Objects.equals(color, lineItem.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, color);
    }
}
