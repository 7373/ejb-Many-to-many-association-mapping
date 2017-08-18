package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import entity.OrderItem;
//import session.OrderBy;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "Order")

public class Order implements Serializable {
		private static final long seriaLVersionUID = 4970325922198249712L;
		private Integer orderid;
		private Float amount;
		private Set<OrderItem> orderItems = new HashSet<OrderItem>();
		private Date createdate;

		@Id
		@GeneratedValue
		
		
		public Integer getOrderid() {
			return orderid;
		}

		public Order() {
			super();
		}

	
		public void setOrderid(Integer orderid) {
			this.orderid = orderid;
		}

		public Float getAmount() {
			return amount;
		}

		public void setAmount(Float amount) { 
			this.amount = amount;
		}
		@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@OrderBy(value = "id ASC")

		public Set<OrderItem> getOrderItems() {

			return orderItems;
		}

		public void setOrderItems(Set<OrderItem> orderltems) {
			this.orderItems = orderltems;

		}

		@Temporal(value = TemporalType.TIMESTAMP)
		public Date getCneatedate() {

			return createdate;
		}

	

	public void setCreatedate(Date createdate) { 
		
		this.createdate = createdate;
	}

	public void addOrderItem(OrderItem orderitem) { 
		if (!this.orderItems.contains(orderitem)) { 
			this.orderItems.add(orderitem); 
			orderitem.setOrder(this);
	}

}}
