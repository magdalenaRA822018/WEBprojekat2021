package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import beans.Buyer;
import beans.User;

public class BuyerDAO {
		private List<Buyer> buyers=new ArrayList<Buyer>();
	 
	    public BuyerDAO() {}
	    
	    public BuyerDAO(String contextPath) {
	      //  loadUsers(contextPath);
	    
	        
	    }
	    public List<Buyer> findAll() {
	        return buyers;
	    }
	 
	    public Buyer getBuyerById(String id) {
	        for(Buyer buyer :buyers) {
	            if(buyer.getUsername().equals(id)) 
	                return buyer;
	        }
	        return null;
	    }
	  

		public void saveBuyer(Buyer newBuyer)  {
			System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"+newBuyer.getUsername());
			buyers.add(newBuyer);
			BufferedWriter writer=null;
			
			 Gson gson = new Gson();
			   String json = gson.toJson(buyers);  
			   System.out.println(json);
			   
			 try {
				 String magdalena="C:\\Users\\computer\\Desktop\\web\\WEBprojekat2021\\veb\\WebShopREST 2\\buyers.json";
				 String s=new File("").getAbsolutePath();
				 String dajana=s+"\\web\\WEBprojekat2021\\veb\\WebShopREST 2\\buyers.json";
				 File file = new File(magdalena);
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
}