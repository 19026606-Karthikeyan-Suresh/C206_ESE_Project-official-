
public class C206_CaseStudy {

	public static void main(String[] args) {
		
		// Kenneth
		ArrayList<Order> orderList = new ArrayList<Order>();
		ArrayList<MenuItem> orderMenu = new ArrayList<>();
		ArrayList<MenuItem> menuItemList2 = new ArrayList<MenuItem>();
		menuItemList2.add(new MenuItem("Soda", "Sprite", 1.50));
		menuItemList2.add(new MenuItem("Sweets", "Lollipops", 2.00));
		orderList.add(new Order("Jerry", "pending", true, orderMenu, "now"));

		
		int option = 0;
		
		while (option != 5) {
			
			C206_CaseStudy.optionMenu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				userTypeMenu();
				
				
			} else if (option == 2) {
				userTypeMenu();
				
			} else if (option == 3) {
				// Kenneth
				int itemType = 0;
				String user = Helper.readString("Enter Account Name: ");
				while(itemType != 6) {
					C206_CaseStudy.setHeader("1. View Order(s) "
							+ "\n2. Add Order "
							+ "\n3. Delete Order "
							+ "\n4. Update Order "
							+ "\n5. Set Order Delivery Time "
							+ "\n6. Quit Order Menu");
					itemType = Helper.readInt("Enter option to select type > ");
					System.out.println("");

					String itemName;
					if (itemType == 1) {
						// View All Order
						System.out.println("");
						System.out.println(C206_CaseStudy.viewAllOrder(orderList, user));

					} else if (itemType == 2) {
						// Add Order
						itemName = Helper.readString("Enter name of Item in Menu: ");
						System.out.println("");					
						C206_CaseStudy.storeOrder(orderList, user, menuItemList2, itemName);

					} else if (itemType == 3) {
						// Delete Order
						System.out.println("");
						C206_CaseStudy.deleteOrder(orderList, user);
					}else if (itemType == 4) {
						//Update Order
						String st = "";
						st = Helper.readString("Enter status of Order: ");
						char c = Helper.readChar("Enter takeaway tag of order (y/n): ");
						boolean b = false;
						if(c == 'y' || c == 'Y')
							b = true;
						else if (c == 'n' || c == 'N')
							b = false;

						if(st == "")
							C206_CaseStudy.updateOrder(orderList, user, b);
						else if(c == '\u0000' || c != 'y'|| c != 'Y'|| c != 'n'|| c != 'N')
							C206_CaseStudy.updateOrder(orderList, user, st);
						else if(st == "" && (c == '\u0000' || c != 'y'|| c != 'Y'|| c != 'n'|| c != 'N'))
							System.out.println("Please at least enter the status of the order.");
						else
							C206_CaseStudy.updateOrder(orderList, user, st, b);

					} else if(itemType == 5) {
						String time = Helper.readString("Enter desired delivery time in 24 hour format, with at least a 24 hour gap before delivery: ");
						C206_CaseStudy.deliveryOrder(orderList, user, time);
					} else if(itemType == 6) {

					} else {
						System.out.println("\nInvalid type");
					}
				}
				System.out.println(C206_CaseStudy.summaryOrder(orderList, user));

			} else if (option == 4) {
				userTypeMenu();
				
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
	public static String viewAllOrder(ArrayList<Order> orderList, String user) {
		String s = "";
		int u = 0;
		for(Order i: orderList) {
			if(user.equalsIgnoreCase(i.getUsername())) {
				u++;
				for(MenuItem j: i.getItems()) {
					String pattern = "Type: %s, Name: %s, Price: %.2f\n";
					s += String.format(pattern, j.getCategory(), j.getName(), j.getPrice());
				}
			}
		}
		if(u == 0)
			System.out.println("Invalid Account name!\n");
		return s;
	}

	// Kenneth
	public static void storeOrder(ArrayList<Order> orderList, String user, ArrayList<MenuItem> menuItemList, String itemName) {
		int u = 0;
		int k = 0;
		for(int i = 0; i< orderList.size(); i++) {
			if(user.equalsIgnoreCase(orderList.get(i).getUsername())) { 
				u++;
				for(int j = 0; j< menuItemList.size(); j++) {
					if(itemName.equalsIgnoreCase(menuItemList.get(j).getName())) {
						k++;
						orderList.get(i).getItems().add(menuItemList.get(j));	
						System.out.println("Item Stored!");
					}
				}
			}
		}
		if(u == 0)
			System.out.println("Invalid Account name!");
		else if(k == 0)
			System.out.println("Invalid Menu Item!");
	}

	// Kenneth
	public static void deleteOrder(ArrayList<Order> orderList, String user) {
		int u = 0;
		for (int i = 0; i < orderList.size(); i++) {
			if (user.equalsIgnoreCase(orderList.get(i).getUsername())) { 
				u++;
				orderList.remove(i);
				System.out.println("Orders Deleted!");
			}
//				for (int j = 0; j < orderList.get(i).getItems().size(); j++) {
//					if (itemToDelete.equalsIgnoreCase(orderList.get(i).getItems().get(j).getName())) 
//						orderList.get(i).getItems().remove(j);
			//				}
		}
		if(u == 0)
			System.out.println("Invalid Account name!");
	}

	public static void updateOrder(ArrayList<Order> orderList, String user, String status, boolean takeaway) {
		int u = 0;
		for (int i = 0; i < orderList.size(); i++) {
			if (user.equalsIgnoreCase(orderList.get(i).getUsername())) { 
				u++;
				orderList.get(i).setStatus(status);
				orderList.get(i).setTakeaway(takeaway);
				System.out.println("Status and Takeaway Tag updated!");
			}
		}
		if(u == 0)
			System.out.println("Invalid Account name!");
	}
	
	public static void updateOrder(ArrayList<Order> orderList, String user, String status) {
		int u = 0;
		for (int i = 0; i < orderList.size(); i++) {
			if (user.equalsIgnoreCase(orderList.get(i).getUsername())) { 
				u++;
				orderList.get(i).setStatus(status);
				System.out.println("Status updated!");
			}
		}
		if(u == 0)
			System.out.println("Invalid Account name!");
	}

	public static void updateOrder(ArrayList<Order> orderList, String user, boolean takeaway) {
		int u = 0;
		for (int i = 0; i < orderList.size(); i++) {
			if (user.equalsIgnoreCase(orderList.get(i).getUsername())) { 
				u++;
				orderList.get(i).setTakeaway(takeaway);
				System.out.println("Status and Takeaway Tag updated!!");
			}
		}
		if(u == 0)
			System.out.println("Invalid Account name!");
	}
	
	public static void deliveryOrder(ArrayList<Order> orderList, String user, String deliveryTime) {
		if (deliveryTime.length() == 4 && deliveryTime.split("")[0].matches("\\d")) {
			int u = 0;
			String[] dTSs = deliveryTime.split("");
			String[] dTS = new String[2];
			dTS[0] = dTSs[0] + dTSs[1] + "";
			dTS[1] = dTSs[2] + dTSs[3] + "";

			String s = dTS[0] + dTS[1];
			int[] dTI = new int[2];
			dTI[0] = Integer.valueOf(dTS[0]);
			dTI[1] = Integer.valueOf(dTS[1]);

			for (int i = 0; i < orderList.size(); i++) {
				if (user.equalsIgnoreCase(orderList.get(i).getUsername())) { 
					u++;
					if (dTI[0] >= 24 && dTI[1] < 59 && Integer.parseInt(s) > 2359) {
						orderList.get(i).setDeliveryTime(deliveryTime);
						System.out.println("Delivery Time updated!");
					} else {
						orderList.get(i).setDeliveryTime("now");
						System.out.println("Delivery Time updated to now!");
					}
				}
			}
			if(u == 0)
				System.out.println("Invalid Account name!");
		}
	}

	public static String summaryOrder(ArrayList<Order> orderList, String user) {
		String s = "";
		int u = 0;
		double tot = 0.0;
		for(Order i: orderList) {
			if(user.equalsIgnoreCase(i.getUsername())) {
				u++;
				for(MenuItem j: i.getItems()) {
					String pattern = "Category: %s, Name: %s, Price: $%.2f\n";
					tot += j.getPrice();
					s += String.format(pattern, j.getCategory(), j.getName(), j.getPrice());
				}
			}
		}
		if(u == 0)
			System.out.println("Invalid Account name!\n");
		s = String.format("Total amount: $%.2f \n%s", tot, s);
		return s;
	}
	
	// Karthik
	public void viewAllPurchaseOrder() {

	}

	public void addPurchaseOrder() {

	}

	public void deletePurchaseOrder() {

	}

}
