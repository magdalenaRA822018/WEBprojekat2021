package beans;

import java.awt.Image;

import enums.ItemType;

public class Item {
     private String name;
     private double price;
     private ItemType itemType;
     private Restaurant restaurant;
     private String quantity;
     private String description;
     private String image;
     private int numberInOrder;
     private boolean deleted;
     
     
    public int getNumberInOrder() {
		return numberInOrder;
	}
	public void setNumberInOrder(int numberInOrder) {
		this.numberInOrder = numberInOrder;
	}
	public boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public ItemType getItemType() {
        return itemType;
    }
    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
    public Restaurant getRestaurant() {
        return restaurant;
    }
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public Item(String name, double price, ItemType itemType, Restaurant restaurant, String quantity,
            String description, String image,int numberInOrder) {
        super();
        this.name = name;
        this.price = price;
        this.itemType = itemType;
        this.restaurant = restaurant;
        this.quantity = quantity;
        this.description = description;
        this.image = image;
        this.deleted=false;
        this.numberInOrder=1;
    }
    public Item() {} 
}
