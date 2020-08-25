import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int itemType = 0;

	public static void main(String[] args) {
		
		ArrayList<PurchaseOrder> purchaseOrderList = new ArrayList<PurchaseOrder>();
		purchaseOrderList.add(new PurchaseOrder("Strawberry", 10, 10.50, "21/1/2020"));
		purchaseOrderList.add(new PurchaseOrder("Kiwi", 11, 7.50, "21/2/2020"));
		purchaseOrderList.add(new PurchaseOrder("cups", 9, 9.50, "21/1/2020"));
		purchaseOrderList.add(new PurchaseOrder("straws", 100, 10.50, "20/1/2020"));
		purchaseOrderList.add(new PurchaseOrder("Milo powder", 3, 14.50, "24/1/2020"));
		
		int option = 0;
		
		while (option != 5) {
			
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				userTypeMenu();
				
				
			} else if (option == 2) {
				userTypeMenu();
				
			} else if (option == 3) {
				userTypeMenu();
				
			} else if (option == 4) { //Karthik
				POlistMenu();
				int ItemType = Helper.readInt("Enter an option > ");
				if (ItemType == 1) {
					UpdateDeliveryDate(purchaseOrderList);
				}
					else if (ItemType == 2) {
						searchPurchaseOrderItemsByItemName(purchaseOrderList);
					
					
				}
				
				
			} else if (option == 5) {
				
				
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
			
		}

	}

	public static void userTypeMenu() {
		C206_CaseStudy.setHeader("USER TYPE MENU");
		System.out.println("1. View All");
		System.out.println("2. Add");
		System.out.println("3. Delete");


	}
	
	public static void POlistMenu() {
		C206_CaseStudy.setHeader("PURCHASE ORDER MENU");
		System.out.println("1. Change delivery date");
		System.out.println("2. Search item");
	}

	public static void optionMenu() {
		C206_CaseStudy.setHeader("OPTION MENU");
		System.out.println("1. Menu Item");
		System.out.println("2. Account");
		System.out.println("3. Order");
		System.out.println("4. Purchase Order");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// Bernadette
	public void viewAllMenuItem() {

	}

	public void addMenuItem() {

	}

	public void deleteMenuItem() {

	}
	
	// Ariezal
	public void viewAllAccount() {

	}

	public void addAccount() {

	}

	public void deleteAccount() {

	}
	
	// Kenneth
	public void viewAllOrder() {

	}

	public void addOrder() {

	}

	public void deleteOrder() {

	}
	
	// Karthik
	public static String RetrievePurchaseOrder(ArrayList<PurchaseOrder> purchaseOrderList) {
		String output = "";
		for (int i = 0; i < purchaseOrderList.size(); i++) { 
			output += String.format("%-15s %-10d %-10.2f %-10s\n", purchaseOrderList.get(i).getItemName(),
					purchaseOrderList.get(i).getItemQuantity(),purchaseOrderList.get(i).getItemUnitPrice(), purchaseOrderList.get(i).getDeliveryDate());
		}
		return output;
	}

	public static void ViewPurchaseOrder(ArrayList<PurchaseOrder> purchaseOrderList) {
		C206_CaseStudy.setHeader("PURCHASE ORDER LIST");
		String output = String.format("%-15s %-10s %-10s %-15s\n", "Name", "Quantity", "Price", "Delivery Date");
		output  +=  RetrievePurchaseOrder(purchaseOrderList);
		
		System.out.println(output);
	}
	
	public static boolean CheckUpdateDeliveryDate(ArrayList<PurchaseOrder> purchaseOrderList, String itemName, 
			int itemQuantity , double itemUnitPrice, String deliveryDate) { 
		boolean isDeliveryDateUpdated = false;
		
		for (int i = 0; i < purchaseOrderList.size(); i ++) {
			String getItemName = purchaseOrderList.get(i).getItemName();
			int getitemQuantity = purchaseOrderList.get(i).getItemQuantity();
			double getitemUnitPrice = purchaseOrderList.get(i).getItemUnitPrice();
			if (itemName.equalsIgnoreCase(getItemName) && itemQuantity == getitemQuantity && itemUnitPrice == getitemUnitPrice) {
				purchaseOrderList.get(i).setDeliveryDate(deliveryDate);
				isDeliveryDateUpdated = true;
				
			}
		}
		return isDeliveryDateUpdated;
	}

	
	public static void UpdateDeliveryDate(ArrayList<PurchaseOrder> purchaseOrderList) {
		C206_CaseStudy.ViewPurchaseOrder(purchaseOrderList);
		C206_CaseStudy.setHeader("UPDATE DELIVERY DATE");
		String itemName = Helper.readString("Enter an item name > ");
		int itemQuantity = Helper.readInt("Enter item quantity > ");
		double itemUnitPrice = Helper.readDouble("Enter item price > ");
		String newDeliveryDate = Helper.readString("Enter new delivery date >");
		Boolean isDeliveryDateUpdated = CheckUpdateDeliveryDate(purchaseOrderList, itemName, 
				itemQuantity , itemUnitPrice, newDeliveryDate);
		if (isDeliveryDateUpdated == false) {
			System.out.println("delivery date cannot be updated");
		} else {
			System.out.println("delivery date has been updated! ");
		}
		
	}
	
	public static boolean SearchByItemName(ArrayList<PurchaseOrder> purchaseOrderList, String SearchItemName) {
				boolean SearchByItemName = false;
				
				String output = String.format("%-15s %-10s %-10s %-15s\n", "Item Name", "Quantity", "Price", "Delivery Date");
				String deliveryDate = "";
				int Quantity = 0;
				double Price = 0.00;
				
				for (int i = 0; i < purchaseOrderList.size(); i ++) {
					
					String itemName = purchaseOrderList.get(i).getItemName();
					Quantity = purchaseOrderList.get(i).getItemQuantity();
					Price = purchaseOrderList.get(i).getItemUnitPrice();
					deliveryDate = purchaseOrderList.get(i).getDeliveryDate();
					
					if (itemName.equalsIgnoreCase(SearchItemName)) {
						output += String.format("%-15s %-10d %-10.2f %-15s", itemName, Quantity, Price, deliveryDate);
						SearchByItemName = true;
						
					}
					
				}
				System.out.println(output);
				return SearchByItemName;
			}

	public static void searchPurchaseOrderItemsByItemName(ArrayList<PurchaseOrder> purchaseOrderList) {
		C206_CaseStudy.ViewPurchaseOrder(purchaseOrderList);
		C206_CaseStudy.setHeader("SEARCH PURCHASE ORDER ITEMS BY ITEM NAME");
		
		if (!purchaseOrderList.isEmpty()) {
			
			String SearchItemName = Helper.readString("Enter item name > ");
			Boolean SearchByItemName = SearchByItemName(purchaseOrderList, SearchItemName);
			if (SearchByItemName == false) {
				System.out.println("Item does not exist");
				
			}
		}else {
			System.out.println("Item exists");
		}
	}


}


