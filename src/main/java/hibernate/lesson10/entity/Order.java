package hibernate.lesson10.entity;

import hibernate.lesson10.entity.types.ProductQuality;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/*@Entity - отмечает класс как сущность, с помощью которой будет возможность взаимодействовать с записями в таблицах
 * @Table - аннотация, которая позволяет задать имя таблицы*/
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @Column(name = "ORDER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PRODUCT")
    private String product;

    /*@Enumerated - позволяет нам сохранить значение класса перечислениия в БД. В данной аннотации есть 2 варианта конфигурации
     *
     * EnumType.ORDINAL - в данном случае сохраняется ID параметра
     * EnumType.STRING - сохраняет название параметра*/
    @Column(name = "PRODUCT")
    @Enumerated(EnumType.STRING)
    private ProductQuality quality;

    @Column(name = "AMOUNT")
    private Integer amount;

    @Column(name = "PRICE")
    private Double price;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATION_DATE")
    private Date creationDate;

    public Order() {
    }

    public Order(String product, ProductQuality quality, Integer amount, Double price, Date creationDate) {
        this.product = product;
        this.quality = quality;
        this.amount = amount;
        this.price = price;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public ProductQuality getQuality() {
        return quality;
    }
    public void setQuality(ProductQuality quality) {
        this.quality = quality;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", product='").append(product).append('\'');
        sb.append(", quality=").append(quality);
        sb.append(", amount=").append(amount);
        sb.append(", price=").append(price);
        sb.append(", creationDate=").append(creationDate);
        sb.append('}');
        return sb.toString();
    }
}
