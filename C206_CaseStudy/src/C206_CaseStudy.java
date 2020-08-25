import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		menuItemList.add(new MenuItem("Smoothies", "Strawberry", 3.50));
		menuItemList.add(new MenuItem("Smoothies", "Kiwi", 2.50));
		menuItemList.add(new MenuItem("Soda", "Sprite", 1.50));
		menuItemList.add(new MenuItem("Soda", "Coca Cola", 1.00));
		menuItemList.add(new MenuItem("Sweets", "Lollipops", 2.00));
		menuItemList.add(new MenuItem("Sweets", "Candies", 1.50));
		menuItemList.add(new MenuItem("Beverages", "Lemon Tea", 1.50));
		menuItemList.add(new MenuItem("Beverages", "Milo", 3.50));

		int option = 0;

		while (option != 5) {
			optionMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				userTypeMenu();
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
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

			} else if (option == 2) {

			} else if (option == 3) {
				;

			} else if (option == 4) {

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

	public static String retrieveAllMenuItems(ArrayList<MenuItem> menuItemList) {
		String output = "";
		for (int i = 0; i < menuItemList.size(); i++) {
			output += String.format("%-15s %-15s %-10.2f\n", menuItemList.get(i).getCategory(),
					menuItemList.get(i).getName(), menuItemList.get(i).getPrice());
		}
		return output;
	}

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
