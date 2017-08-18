package test;

import orderbean.*;
import javax.naming.*;
import entity.*;
import java.util.*;

public class test {


	public static void main(String args[]) throws Exception {
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");
		InitialContext ctx = new InitialContext(props);
		try {System.out.println("2");
			OrderDAO orderdao = (OrderDAO) ctx.lookup("OrderDAOBean/remote");
			// 插入数据
			System.out.println("3");
			orderdao.insertOrder();
			// 查询数据
			List list = orderdao.getAllOrder();
			
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					Order od = (Order) list.get(i);
					if (od != null) {
						System.out.println("==============订单号：" + od.getOrderid() + "=================<br>");
						// 以上得操作都是关于order
						Iterator iterator = od.getOrderItems().iterator();
						while (iterator.hasNext()) {
							OrderItem SubOrder = (OrderItem) iterator.next();
							System.out.println("订购产品:" + SubOrder.getProductname() + "<br>");
						}
					}
				}
			} else {
				System.out.println("获取不到订单列表");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}