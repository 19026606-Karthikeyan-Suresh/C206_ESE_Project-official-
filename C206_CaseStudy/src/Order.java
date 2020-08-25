import java.util.ArrayList;

// Kenneth
public class Order {
	
	private String username;
	private String status;
	private boolean takeaway;
	private ArrayList<MenuItem> items;
	private String deliveryTime;
	
	
	public Order(String username, String status, boolean takeaway, ArrayList<MenuItem> items, String deliveryTime) {
		this.username = username;
		this.status = status;
		this.takeaway = takeaway;
		this.items = items;
		this.deliveryTime = deliveryTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isTakeaway() {
		return takeaway;
	}

	public void setTakeaway(boolean takeaway) {
		this.takeaway = takeaway;
	}

	public ArrayList<MenuItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<MenuItem> items) {
		this.items = items;
	}
	
	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	
	public String toString() {
		return null;
	}
	
	

}
