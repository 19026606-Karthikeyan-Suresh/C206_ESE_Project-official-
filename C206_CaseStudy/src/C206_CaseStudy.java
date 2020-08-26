import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		// Bernadette Menu Objects
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		menuItemList.add(new MenuItem("Smoothies", "Strawberry", 3.50));
		menuItemList.add(new MenuItem("Smoothies", "Kiwi", 2.50));
		menuItemList.add(new MenuItem("Soda", "Sprite", 1.50));
		menuItemList.add(new MenuItem("Soda", "Coca Cola", 1.00));
		menuItemList.add(new MenuItem("Sweets", "Lollipops", 2.00));
		menuItemList.add(new MenuItem("Sweets", "Candies", 1.50));
		menuItemList.add(new MenuItem("Beverages", "Lemon Tea", 1.50));
		menuItemList.add(new MenuItem("Beverages", "Milo", 3.50));

		
		// Kenneth Order Objects
		ArrayList<Order> orderList = new ArrayList<Order>();
		ArrayList<MenuItem> orderMenu = new ArrayList<>();
		ArrayList<MenuItem> menuItemList2 = new ArrayList<MenuItem>();
		menuItemList2.add(new MenuItem("Soda", "Sprite", 1.50));
		menuItemList2.add(new MenuItem("Sweets", "Lollipops", 2.00));
		orderList.add(new Order("Jerry", "pending", true, orderMenu, "now"));
		
		// Ariezal Account Objects
		ArrayList<Account> accountList = new ArrayList<Account>();
		accountList.add(new Account("James", "canteen123", "Staff"));
		accountList.add(new Account("Zac", "canteen123", "Canteen Admin"));
		accountList.add(new Account("Joe", "canteen123", "Customer"));
		accountList.add(new Account("Aaron", "canteen123", "Staff"));
		

		
		int option = 0;

		while (option != 5) {
			optionMenu();

			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				userTypeMenu();
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Bernadette
					
					C206_CaseStudy.viewAllMenuItem(menuItemList);
					optionMenuItemList();
					int optionMenuItem = Helper.readInt("Enter option for menu item > ");

					if (optionMenuItem == 1) {
						chooseUpdateMenuType();
						int chooseUpdateMenu = Helper.readInt("Choose update for menu item > ");

						if (chooseUpdateMenu == 1) {
							C206_CaseStudy.updateMenuItemName(menuItemList);
						} else if (chooseUpdateMenu == 2) {
							C206_CaseStudy.updateMenuItemPrice(menuItemList);
						} else {
							System.out.println("Invalid choose update");
						}
					} else if (optionMenuItem == 2) {
						viewMenuItemsByPriceRange(menuItemList);
					} else if (optionMenuItem == 3) {
						searchMenuItemsByCategory(menuItemList);
					}

				} else if (itemType == 2) {
					MenuItem m = inputMenuItem();
					C206_CaseStudy.addMenuItem(menuItemList, m);

				} else if (itemType == 3) {

				} else {
					System.out.println("Invalid type");
				}
// ADD, VIEW AND DELETE ACCOUNT OPTIONS FOR USER TO CHOOSE.
			} else if (option == 2) {
				// Ariezal
				C206_CaseStudy.setHeader("View, Add, Delete Account");
				userTypeMenu();

				int itemType = Helper.readInt("Enter option to select type > ");
		
				if (itemType == 1) {
					// View All Accounts
					C206_CaseStudy.viewAllAccounts(accountList);
					
				} else if (itemType == 2) {
					// Add Account
					C206_CaseStudy.addAccount(accountList);

				} else if (itemType == 3) {
					// Delete Account
					C206_CaseStudy.deleteAccount(accountList);

				} else {
					System.out.println("Invalid type");
				}
				}

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
				// Karthik

			} else if (option == 5) {

				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}
// -------------------Program Layouts -----------------
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

	public static void chooseUpdateMenuType() {
		C206_CaseStudy.setHeader("UPDATE NAME OR PRICE?");
		System.out.println("1. Update Name of Menu Item");
		System.out.println("2. Update Price of Menu Item");
	}

	public static void optionMenuItemList() {
		C206_CaseStudy.setHeader("MENU ITEM OPTION");
		System.out.println("1. Update Menu Item - Name and Price");
		System.out.println("2. View Menu Item by Price Range");
		System.out.println("3. Search Menu Item by Category");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
//-------Program Layouts------------------------------------------
	
	public static String retrieveAllMenuItems(ArrayList<MenuItem> menuItemList) {
		String output = "";
		for (int i = 0; i < menuItemList.size(); i++) {
			output += String.format("%-15s %-15s %-10.2f\n", menuItemList.get(i).getCategory(),
					menuItemList.get(i).getName(), menuItemList.get(i).getPrice());
		}
		return output;
	}
//METHODS FOR MENU------------------------------------------------------------------
	// method to view MenuItem objects in ArrayList
	public static void viewAllMenuItem(ArrayList<MenuItem> menuItemList) {
		C206_CaseStudy.setHeader("MENU ITEM LIST");
		String output = String.format("%-15s %-15s %-10s\n", "CATEGORY", "NAME", "PRICE");
		output += retrieveAllMenuItems(menuItemList);

		System.out.println(output);
	}

	// method to create MenuItem object
	public static MenuItem inputMenuItem() {
		String category = Helper.readString("Enter category > ");
		String name = Helper.readString("Enter name > ");
		double price = Helper.readDouble("Enter price > ");

		MenuItem m = new MenuItem(category, name, price);
		return m;
	}

	// method to add the MenuItem object in ArrayList
	public static void addMenuItem(ArrayList<MenuItem> menuItemList, MenuItem m) {

		menuItemList.add(m);
		System.out.println("Menu Item added");
	}

	// method to check if the menu item name is updated
	public static boolean doUpdateMenuItemName(ArrayList<MenuItem> menuItemList, String category, String name,
			double price) {
		boolean isNameUpdated = false;

		for (int i = 0; i < menuItemList.size(); i++) {
			String getCategory = menuItemList.get(i).getCategory();
			double getPrice = menuItemList.get(i).getPrice();
			if (category.equalsIgnoreCase(getCategory) && price == getPrice) {
				menuItemList.get(i).setName(name);
				isNameUpdated = true;
			}
		}
		return isNameUpdated;
	}

	// method for update menu item name
	public static void updateMenuItemName(ArrayList<MenuItem> menuItemList) {
		C206_CaseStudy.viewAllMenuItem(menuItemList);
		C206_CaseStudy.setHeader("UPDATE MENU ITEM NAME");
		String category = Helper.readString("Enter category > ");
		double price = Helper.readDouble("Enter price > ");
		String newName = Helper.readString("Enter new name > ");
		Boolean isNameUpdated = doUpdateMenuItemName(menuItemList, category, newName, price);
		if (isNameUpdated == false) {
			System.out.println("Name of menu item cannot be updated");
		} else {
			System.out.println("Name of menu item updated");
		}
	}

	// method to check if the menu item price is updated
	public static boolean doUpdateMenuItemPrice(ArrayList<MenuItem> menuItemList, String category, String name,
			double price) {
		boolean isPriceUpdated = false;

		for (int i = 0; i < menuItemList.size(); i++) {
			String getCategory = menuItemList.get(i).getCategory();
			String getName = menuItemList.get(i).getName();
			if (category.equalsIgnoreCase(getCategory) && name.equalsIgnoreCase(getName)) {
				menuItemList.get(i).setPrice(price);
				isPriceUpdated = true;
			}
		}
		return isPriceUpdated;
	}

	// method for update menu item price
	public static void updateMenuItemPrice(ArrayList<MenuItem> menuItemList) {
		C206_CaseStudy.viewAllMenuItem(menuItemList);
		C206_CaseStudy.setHeader("UPDATE MENU ITEM PRICE");
		String category = Helper.readString("Enter category > ");
		String name = Helper.readString("Enter name > ");
		double newPrice = Helper.readDouble("Enter new price > ");
		Boolean isPriceUpdated = doUpdateMenuItemPrice(menuItemList, category, name, newPrice);
		if (isPriceUpdated == false) {
			System.out.println("Price of menu item cannot be updated");
		} else {
			System.out.println("Price of menu item updated");
		}
	}

	public static boolean doViewByPriceRange(ArrayList<MenuItem> menuItemList, double minPrice,
			double maxPrice) {
		boolean canViewByPriceRange = false;

		String output = String.format("%-15s %-15s %-10s\n", "CATEGORY", "NAME", "PRICE");
		String category = "";
		String name = "";

		for (int i = 0; i < menuItemList.size(); i++) {

			category = menuItemList.get(i).getCategory();
			name = menuItemList.get(i).getName();
			double price = menuItemList.get(i).getPrice();

			if (minPrice < price && maxPrice > price) {
				output += String.format("%-15s %-15s %-10.2f\n", category, name, price);
				canViewByPriceRange = true;
			}
		}
		System.out.println(output);
		return canViewByPriceRange;
	}

	public static void viewMenuItemsByPriceRange(ArrayList<MenuItem> menuItemList) {
		C206_CaseStudy.viewAllMenuItem(menuItemList);
		C206_CaseStudy.setHeader("VIEW MENU ITEMS BY PRICE RANGE");

		if (!menuItemList.isEmpty()) {

			double minPrice = Helper.readDouble("Enter min. price > ");
			double maxPrice = Helper.readDouble("Enter max. price > ");

			Boolean canViewByPriceRange = doViewByPriceRange(menuItemList, minPrice, maxPrice);
			if (canViewByPriceRange == false) {
				System.out.println("No item falls under this range");
			}
		} else {
			System.out.println("List of items fall under this range");
		}
	}

	// method to check if menu items can search by category
	public static boolean canSearchByCategory(ArrayList<MenuItem> menuItemList, String searchCategory) {
		boolean canSearchByCategory = false;

		String output = String.format("%-15s %-15s %-10s\n", "CATEGORY", "NAME", "PRICE");
		String name = "";
		double price = 0.00;

		for (int i = 0; i < menuItemList.size(); i++) {

			String category = menuItemList.get(i).getCategory();
			name = menuItemList.get(i).getName();
			price = menuItemList.get(i).getPrice();

			if (category.equalsIgnoreCase(searchCategory)) {
				output += String.format("%-15s %-15s %-10.2f\n", category, name, price);
				canSearchByCategory = true;
			}
		}
		System.out.println(output);
		return canSearchByCategory;

	}
	
	// method to search menu items by category
	public static void searchMenuItemsByCategory(ArrayList<MenuItem> menuItemList) {
		C206_CaseStudy.viewAllMenuItem(menuItemList);
		C206_CaseStudy.setHeader("SEARCH MENU ITEMS BY CATEGORY");

		if (!menuItemList.isEmpty()) {

			String searchCategory = Helper.readString("Enter category to search > ");

			Boolean canSearchByCategory = canSearchByCategory(menuItemList, searchCategory);
			if (canSearchByCategory == false) {
				System.out.println("No category exists");
			}
		} else {
			System.out.println("Category found");
		}
	}



	}
//METHODS FOR MENU -------------------------------------------------------------------------------------------------------	

//METHODS FOR ACCOUNT
	// Add Account 
	public static void addAccount(ArrayList<Account>accountList) {
		C206_CaseStudy.setHeader("ADD NEW ACCOUNT");
		
		String username = Helper.readString("Enter Username > ");
		String password = Helper.readString("Enter a new password > ");
		String userRole = Helper.readString("Enter the role > ");
		
		// Check for duplicate account
		boolean isDuplicate = false;
		
		for (int i = 0; i < accountList.size(); i++) {
			if (username.equalsIgnoreCase(accountList.get(i).getUsername()) && 
					userRole.equalsIgnoreCase(accountList.get(i).getUserRole())) {
					System.out.println("That account already exist! Try Again!");
					isDuplicate = true;
					break;
				
			}
		}
		// If account is not duplicated, it will create the account requested by the user.
		if (isDuplicate == false) {
			accountList.add(new Account(username, password, userRole));
			System.out.println("New Account added!"); 
		}
	}	
	//View Account	
	public static void viewAllAccounts (ArrayList<Account>accountList) {
		C206_CaseStudy.setHeader("VIEW ALL ACCOUNTS");
		String output = String.format("%-30 %-30 %-30 \n", "USERNAME", "PASSWORD" , "USER ROLE");
		
		for (int i = 0; i <accountList.size();i++) {
			
			output += String.format("%-30 %-30 %-30 \n",accountList.get(i).getUsername(), accountList.get(i).getPassword(), accountList.get(i).getUserRole());
		}
			System.out.println(output);
	}
	
	
// Delete account	
	public static void deleteAccount (ArrayList<Account>accountList) {
		C206_CaseStudy.setHeader("DELETE AN ACCOUNT");
	}
//METHODS FOR ACCOUNT

		
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

	//Ariezal Methods

