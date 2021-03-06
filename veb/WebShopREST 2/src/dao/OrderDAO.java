package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import beans.Buyer;
import beans.Manager;
import beans.Order;
import beans.Restaurant;
import enums.OrderStatus;

public class OrderDAO {

List<Order> orders;

 public OrderDAO() {
	 
		
 }
 
 public OrderDAO(String contextPath) {
	 orders=new ArrayList<Order>();
 	for(Order r: loadOrders(contextPath)) {
 		orders.add(r);
     
 	}
 
 }
 
 private List<Order> loadOrders(String contextPath) {
		List<Order> orderss=new ArrayList<Order>();
		Gson gson = new Gson();
		Reader in=null;
		try {
			String s=new File("").getAbsolutePath();
			System.out.println("putanja u load "+s);
		    String magdalena="C:\\Users\\computer\\Desktop\\web\\WEBprojekat2021\\veb\\WebShopREST 2\\orders.json";
		    String dajana=s+"\\web\\WEBprojekat2021\\veb\\WebShopREST 2\\orders.json";
			in=Files.newBufferedReader(Paths.get(dajana));
			orderss=Arrays.asList(gson.fromJson(in, Order[].class));
		    
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			if (in != null) {
				try {
					in.close();
				}
				catch (Exception e) { }
			}
		}
	
		return orderss;
	}
 public void saveOrders(Order newOrder)  {
	 if(getOrderById(newOrder.getId())!= null) {
			Order currentOrder= getOrderById(newOrder.getId());
			int index=orders.indexOf(currentOrder);
			orders.remove(index);
			orders.add(index, newOrder);
		}else {
			orders.add(newOrder);
		};
		BufferedWriter writer=null;
		 
		 Gson gson = new Gson();
		   String json = gson.toJson(orders);  
		   System.out.println(json);
		   
		 try {
			 String magdalena="C:\\Users\\computer\\Desktop\\web\\WEBprojekat2021\\veb\\WebShopREST 2\\orders.json";
			 String s=new File("").getAbsolutePath();
			 String dajana=s+"\\web\\WEBprojekat2021\\veb\\WebShopREST 2\\orders.json";
			 File file = new File(dajana);
			writer = new BufferedWriter(new FileWriter(file));
			  writer.write(json);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
 
 public Order getOrderById(String id) {
     for(Order order :orders) {
         if(order.getId().equals(id) && order.isDeleted()==false) 
             return order;
     }
     return null;
 }

public List<Order> getOrdersByBuyerID(String username) {
	List<Order> activeOrders=new ArrayList<Order>();
	for(Order order: orders) {
		if(order.getBuyer().getUsername().equals(username) && 
				!order.getStatus().equals(OrderStatus.CANCELED) &&
				!order.getStatus().equals(OrderStatus.DELIVERED) 
				) {
			activeOrders.add(order);
		}
	}
	return activeOrders;
}

public void buyerCancelsOrder(Order order) {
	// TODO Auto-generated method stub
	Order orderForCanceling=getOrderById(order.getId());
	orderForCanceling.setStatus(OrderStatus.CANCELED);
	saveOrders(orderForCanceling);
}

public List<Order> getOrdersForManager(String idRest) {
	List<Order> ordersForManager=new ArrayList<Order>();
	for(Order order: orders) {
		if(order.getRestaurant().getName().equals(idRest) && !order.getStatus().equals(OrderStatus.DELIVERED))
			ordersForManager.add(order);
	}
	return ordersForManager;
}

public Order setStatus(Order order) {
	// TODO Auto-generated method stu
	Order orderSet=getOrderById(order.getId());
	orderSet.setStatus(order.getStatus());
	saveOrders(orderSet);

	return orderSet;
}

public List<Order> getOrdersForDeliverer() {
	// TODO Auto-generated method stub
	List<Order>ordersForDeliverer= new ArrayList<Order>();
	for(Order order: orders) {
	if(order.getStatus().equals(OrderStatus.WAITINGFORDELIVERY)) {
			ordersForDeliverer.add(order);
		}
	}
	return ordersForDeliverer;
}

public List<Order> getDeliveredOrdersForBuyer(Buyer buyer) {
	// TODO Auto-generated method stub
	List<Order> deliveredOrders=new ArrayList<Order>();
	for(Order order: orders) {
		  if(order.getStatus().equals(OrderStatus.DELIVERED) && order.getBuyer().getUsername().equals(buyer.getUsername()) 
				  && order.isDeleted()==false) {
			  deliveredOrders.add(order);
		  }
	}
	return deliveredOrders;
}

public void delete(Order order) {
	Order orderForDeleting=getOrderById(order.getId());
	orderForDeleting.setDeleted(true);
	saveOrders(orderForDeleting);
}



}
