package entity;


import java.io.Serializable;
 
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@SuppressWarnings("serial")
@Entity
@Table(name = "OrderItem")
public class OrderItem implements Serializable {
    private Integer id;
    private String productname;
    private Float price;
    private Order order;
 
    public OrderItem() {
    }
 
    public OrderItem(String productname, Float price) {
       this.productname = productname;
       this.price = price;
    }
 
    @Id
    @GeneratedValue
    public Integer getId() {
       return id;
 
    }
 
    public void setId(Integer id) {
       this.id = id;
    }
 
    public String getProductname() {
       return productname;
    }
 
    public void setProductname(String productname) {
       this.productname = productname;
    }
 
    public Float getPrice() {
       return price;
    }
 
    public void setPrice(Float price) {
       this.price = price;
    }
 
    //注释@ManyToOne 指明OrderItem 和Order 之间为多对一关系，多个OrderItem 实例关联的都是同一个Order 对象。
    @ManyToOne(cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "order_id")
    public Order getOrder() {
       return order;
    }
 
    public void setOrder(Order order) {
       this.order = order;
    }
}