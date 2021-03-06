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

import beans.Item;
import beans.Order;
import beans.Restaurant;
import beans.Review;
import enums.ReviewStatus;

public class ReviewDAO {

List<Review> reviews;

 public ReviewDAO() {
	 
	
 }
 
 public ReviewDAO(String contextPath) {
	 reviews=new ArrayList<Review>();
 	for(Review r: loadReviews(contextPath)) {
 		reviews.add(r);
     
 	}
 }
 
 private List<Review> loadReviews(String contextPath) {
		List<Review> orderss=new ArrayList<Review>();
		Gson gson = new Gson();
		Reader in=null;
		try {
			String s=new File("").getAbsolutePath();
			System.out.println("putanja u load "+s);
		    String magdalena="C:\\Users\\computer\\Desktop\\web\\WEBprojekat2021\\veb\\WebShopREST 2\\reviews.json";
		    String dajana=s+"\\web\\WEBprojekat2021\\veb\\WebShopREST 2\\reviews.json";
			in=Files.newBufferedReader(Paths.get(dajana));
			orderss=Arrays.asList(gson.fromJson(in, Review[].class));
		    
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
 public void saveReview(Review newReview)  {
	 if(getById(newReview.getId())!= null) {
			Review currentReview= getById(newReview.getId());
			int index=reviews.indexOf(currentReview);
			reviews.remove(index);
			reviews.add(index, newReview);
		}else {
			reviews.add(newReview);
		}
		BufferedWriter writer=null;
		 
		 Gson gson = new Gson();
		   String json = gson.toJson(reviews);  
		   System.out.println(json);
		   
		 try {
			 String magdalena="C:\\Users\\computer\\Desktop\\web\\WEBprojekat2021\\veb\\WebShopREST 2\\reviews.json";
			 String s=new File("").getAbsolutePath();
			 String dajana=s+"\\web\\WEBprojekat2021\\veb\\WebShopREST 2\\reviews.json";
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
    
    public List<Review> findReviewsForAdmin(){
    	return sortReviews(reviews);
    }
    
    public List<Review> findReviewsForManager(String restaurantID){
    	List<Review> reviewsForRestaurant=new ArrayList<Review>();
    	for(Review r: reviews) {
    		if(r.getRestaurant().getName().equals(restaurantID))
    			reviewsForRestaurant.add(r);
    	}
    	return sortReviews(reviewsForRestaurant);
    }
    
    public List<Review> sortReviews(List<Review> unsorted){
    	List<Review> sortedReviews=new ArrayList<Review>();

    	for(Review r1: unsorted) {
    		if(r1.getStatus().equals(ReviewStatus.UNREVIEWED))
    			sortedReviews.add(r1);
    	}
    	for(Review r2: unsorted) {
    		if(!r2.getStatus().equals(ReviewStatus.UNREVIEWED))
    			sortedReviews.add(r2);
    	}
    	return sortedReviews;
    }
    
    public Review getById(String id) {
        for(Review r :reviews) {
            if(r.getId().equals(id) && r.isDeleted()==false) 
                return r;
        }
        return null;
    }


	public void setStatus(Review review) {
		// TODO Auto-generated method stub
		Review old=getById(review.getId());
		old.setStatus(review.getStatus());
		saveReview(old);
	}


	public double setAvg(Review reviewp) {
		// TODO Auto-generated method stub
		int number=0;
		int mark=0;
		double br=0;
		for(Review review: reviews) {
			if(review.getRestaurant().getName().equals(reviewp.getRestaurant().getName()) &&
					review.getStatus().equals(ReviewStatus.ACCEPTED)) {
						number++;
						mark+=review.getRating();
				
			}
		}
		if(mark==0) {
			return 0;
		}

		return mark/number;
	}
 
	  public List<Review> findReviewsForRestaurantSite(String restaurantID){
	    	List<Review> reviewsForRestaurant=new ArrayList<Review>();
	    	for(Review r: reviews) {
	    		if(r.getRestaurant().getName().equals(restaurantID) && r.getStatus().equals(ReviewStatus.ACCEPTED))
	    			reviewsForRestaurant.add(r);
	    	}
	    	return sortReviews(reviewsForRestaurant);
	    }


 

}
