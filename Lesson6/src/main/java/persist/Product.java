package persist;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity

@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private BigDecimal price;

    public Product() {
    }

    public Product(long l, String product1, String desc1, BigDecimal bigDecimal) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

  /*

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    //указывает, что у каждого производителя может быть много товаров и привязывает производителя к продуктам
    @ManyToOne
    @JoinColumn(name="manufacturer_id")
    private Manufacturer manufacturer;



    public List<Client> getClients() {
        return clients;
    }

    @ManyToMany
    @JoinTable    (
            name = "clients_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn (name = "client_id")

    )




    private List<Client> clients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", manufacturer=" + manufacturer +
                '}';
    }

     */
}
