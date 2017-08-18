package orderbean;


import java.util.List;

import entity.Order;

public interface OrderDAO {
   public void insertOrder();
   public Order getOrderByID(Integer orderid);
   public List getAllOrder();
   public void deleteOrder(Integer orderid);
}