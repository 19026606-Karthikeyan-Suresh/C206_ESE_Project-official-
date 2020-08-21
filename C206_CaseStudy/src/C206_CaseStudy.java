
public class C206_CaseStudy {

	public static void main(String[] args) {
		
		int option = 0;
		
		while (option != 5) {
			
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				userTypeMenu();
				
				
			} else if (option == 2) {
				userTypeMenu();
				
			} else if (option == 3) {
				userTypeMenu();
				
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
	public void viewAllOrder() {

	}

	public void addOrder() {

	}

	public void deleteOrder() {

	}
	
	// Karthik
	public void viewAllPurchaseOrder() {

	}

	public void addPurchaseOrder() {

	}

	public void deletePurchaseOrder() {

	}

}
