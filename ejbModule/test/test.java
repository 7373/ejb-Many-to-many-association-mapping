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
			// ��������
			System.out.println("3");
			orderdao.insertOrder();
			// ��ѯ����
			List list = orderdao.getAllOrder();
			
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					Order od = (Order) list.get(i);
					if (od != null) {
						System.out.println("==============�����ţ�" + od.getOrderid() + "=================<br>");
						// ���ϵò������ǹ���order
						Iterator iterator = od.getOrderItems().iterator();
						while (iterator.hasNext()) {
							OrderItem SubOrder = (OrderItem) iterator.next();
							System.out.println("������Ʒ:" + SubOrder.getProductname() + "<br>");
						}
					}
				}
			} else {
				System.out.println("��ȡ���������б�");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}