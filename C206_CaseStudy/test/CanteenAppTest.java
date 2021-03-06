import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CanteenAppTest {

	// Bernadette
	private MenuItem menu1;
	private MenuItem menu2;
	private MenuItem menu3;
	private MenuItem menu4;
	private MenuItem menu5;
	private MenuItem menu6;

	private ArrayList<MenuItem> menuItemList;

	// Kenneth
	private Order o1;
	private MenuItem m3;
	private MenuItem m4;

	// Kenneth
	private ArrayList<Order> orderList;
	private ArrayList<MenuItem> orderMenuList;
	private ArrayList<MenuItem> orderMenuList2;

	public CanteenAppTest() {
		super();
	}	
	//Karthik
	private ArrayList<PurchaseOrder> purchaseOrderList;
	
	private PurchaseOrder PO1;
	private PurchaseOrder PO2;
	private PurchaseOrder PO3;
	
	//Ariezal
	private ArrayList<Account> accountList;
	private Account a1;
	

	@Before
	public void setUp() throws Exception {

		// Bernadette
		menu1 = new MenuItem("Soda", "Sprite", 1.50);
		menu2 = new MenuItem("Smoothies", "Banana", 3.50);
		menu3 = new MenuItem("Pizzas", "Cheese", 3.00);
		menu4 = new MenuItem("Pizzas", "Pepperoni", 4.00);
		menu5 = new MenuItem("Sweets", "Gummies", 2.50);
		menu6 = new MenuItem("Sweets", "Lollipops", 2.00);

		menuItemList = new ArrayList<MenuItem>();

		// Kenneth
		orderList = new ArrayList<Order>();
		orderMenuList = new ArrayList<MenuItem>();
		orderMenuList2 = new ArrayList<MenuItem>();
		o1 = new Order("Jerry", "pending", false, orderMenuList2, "now");
		m3 = new MenuItem("Snacks", "Biscuits", 3.70);
		m4 = new MenuItem("Desserts", "Cakes", 3.00);
		orderMenuList.add(m3);
		orderMenuList.add(m4);
		
		//Karthik
		purchaseOrderList = new ArrayList<PurchaseOrder>();
		PO1 = new PurchaseOrder("strawberry", 10, 13.50, "21/3/2020");
		PO2 = new PurchaseOrder("straws", 30, 5.0, "25/2/2020");
		PO3 = new PurchaseOrder("berry", 15, 11.50, "20/3/2020");
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@Test // Bernadette
	public void addMenuItemTest() {
		// boundary
		assertNotNull("Check if there is valid Menu Item arraylist to add to", menuItemList);
		// normal
		CanteenApp.addMenuItem(menuItemList, menu1);
		assertEquals("Check that Menu Item arraylist size is 1", 1, menuItemList.size());
		assertSame("Check that Menu Item is added", menu1, menuItemList.get(0));
		// normal
		CanteenApp.addMenuItem(menuItemList, menu2);
		assertEquals("Check that Menu Item arraylist size is 2", 2, menuItemList.size());
		assertSame("Check that Menu Item is added", menu2, menuItemList.get(1));
	}

	@Test // Bernadette
	public void viewAllMenuItemsTest() {
		// Test if Menu Item list is not null but empty - boundary
		assertNotNull("Test if there is valid Menu Item arraylist to retrieve menu item", menuItemList);
		// test if the list of menu items retrieved from the C206_CaseStudy is empty - boundary
		String allMenuItems = CanteenApp.retrieveAllMenuItems(menuItemList);
		String testOutput = "";
		assertEquals("Check that ViewAllMenuItems", testOutput, allMenuItems);
		// Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		CanteenApp.addMenuItem(menuItemList, menu1);
		CanteenApp.addMenuItem(menuItemList, menu2);
		assertEquals("Test that Menu Item arraylist size is 2", 2, menuItemList.size());
		// test if the expected output string same as the list of menu items retrieved from the C206_CaseStudy
		allMenuItems = CanteenApp.retrieveAllMenuItems(menuItemList);
		testOutput = String.format("%-15s %-15s %-10.2f\n", "Soda", "Sprite", 1.50);
		testOutput += String.format("%-15s %-15s %-10.2f\n", "Smoothies", "Banana", 3.50);
		assertEquals("Test that ViewAllMenuItems", testOutput, allMenuItems);

	}
	
	@Test // Bernadette
	public void doDeleteMenuItemTest() {
		// boundary condition
		assertNotNull("Test if there is valid MenuItem arraylist to add to", menuItemList);
		CanteenApp.addMenuItem(menuItemList, menu1);
		// normal condition
		Boolean ok = CanteenApp.doDeleteMenuItem(menuItemList, "Soda", "Sprite", 1.50);
		assertTrue("Test if the existing menu item can delete from the list", ok);
		// error condition
		ok = CanteenApp.doDeleteMenuItem(menuItemList, "Seafood", "Shrimps", 3.00);
		assertFalse("Test if the non-existing menu item can delete from the list?", ok);
	}

	@Test // Bernadette
	public void doUpdateMenuItemNameTest() {
		// boundary condition
		assertNotNull("Test if there is valid MenuItem arraylist to add to", menuItemList);
		CanteenApp.addMenuItem(menuItemList, menu1);
		
		// Test if the menu item is updated its name (both category and price remain unchanged)
		// normal condition
		Boolean ok = CanteenApp.doUpdateMenuItemName(menuItemList, "Soda", "Coca Cola", 1.50);
		assertTrue("Test if the menu item is updated its name?", ok);
		
		// Test if the menu item is updated its name (only category remains unchanged)
		// error condition
		ok = CanteenApp.doUpdateMenuItemName(menuItemList, "Soda", "Coca Cola", 2.00);
		assertFalse("Test if the menu item is updated its name?", ok);
	}

	@Test // Bernadette
	public void doUpdateMenuItemPriceTest() {
		// boundary condition
		assertNotNull("Test if there is valid MenuItem arraylist to add to", menuItemList);
		CanteenApp.addMenuItem(menuItemList, menu2);
		
		// Test if the menu item is updated its price (both category and name remain unchanged)
		// normal condition
		Boolean ok = CanteenApp.doUpdateMenuItemPrice(menuItemList, "Smoothies", "Banana", 3.50);
		assertTrue("Test if the menu item name is updated its price?", ok);
		
		// Test if the menu item is updated its price (only category remains unchanged)
		// error condition
		ok = CanteenApp.doUpdateMenuItemPrice(menuItemList, "Smoothies", "Blueberry", 3.50);
		assertFalse("Test if the menu item is updated its price?", ok);
	}

	@Test // Bernadette
	public void canViewByPriceRangeTest() {
		// Given an empty list, after adding 4 items, test if the arraylist size is 6 -
		// normal condition
		CanteenApp.addMenuItem(menuItemList, menu1);
		CanteenApp.addMenuItem(menuItemList, menu2);
		CanteenApp.addMenuItem(menuItemList, menu3);
		CanteenApp.addMenuItem(menuItemList, menu4);
		CanteenApp.addMenuItem(menuItemList, menu5);
		CanteenApp.addMenuItem(menuItemList, menu6);
		assertEquals("Test that Menu Item arraylist size is 6", 6, menuItemList.size());

		// Test if these menu items fall under the price range between $2 to $3
		// normal condition
		Boolean ok = CanteenApp.canViewByPriceRange(menuItemList, 2.00, 3.00);
		assertTrue("Test if these menu items fall under the range between $2 to $3", ok);

		// Test if these menu items fall under the price range between $4 to $4
		// error condition
		ok = CanteenApp.canViewByPriceRange(menuItemList, 4.00, 5.00);
		assertFalse("Test if these menu items fall under the range between $4 to $5", ok);
	}

	@Test // Bernadette
	public void canSearchByCategoryTest() {
		// Given an empty list, after adding 6 items, test if the arraylist size is 6 -
		// normal condition
		CanteenApp.addMenuItem(menuItemList, menu1);
		CanteenApp.addMenuItem(menuItemList, menu2);
		CanteenApp.addMenuItem(menuItemList, menu3);
		CanteenApp.addMenuItem(menuItemList, menu4);
		CanteenApp.addMenuItem(menuItemList, menu5);
		CanteenApp.addMenuItem(menuItemList, menu6);
		assertEquals("Test that Menu Item arraylist size is 6", 6, menuItemList.size());

		// Test if the menu items can search by Pizzas category (existing category)
		// normal condition
		Boolean ok = CanteenApp.canSearchByCategory(menuItemList, "Pizzas");
		assertTrue("Test if menu items can search by Pizzas category", ok);

		// Test if the menu items can search by Seafood category (non-existing category)
		// error condition
		ok = CanteenApp.canSearchByCategory(menuItemList, "Seafood");
		assertFalse("Test if menu items can search by Seafood category", ok);

	}

	@Test // Kenneth
	public void c206_testViewAllOrder() {
		// Test if Order list is not null but empty - error
		assertNotNull("Test if there is a valid Order arraylist to view all order items", orderList);

		// test if the list of order retrieved from the C206 Case Study is empty -error
		String allOrders = CanteenApp.viewAllOrder(orderList, "Jerry");
		String testOutput = "";
		assertEquals("Check that OrderList is not empty", testOutput, allOrders);

		orderList.add(o1);
		allOrders = CanteenApp.viewAllOrder(orderList, "Jerry");
		assertNotNull("Test if there is valid Order Item to view in ArrayList", allOrders);

	}

	@Test // Kenneth
	public void c206_testStoreOrder() {
		// Test if the user Order Menu Item list is null and empty - error
		orderList.add(o1);
		CanteenApp.storeOrder(orderList, "Tom", orderMenuList, "Cakes"); // Tom is not a user account
		assertNotEquals(
				"Test if the menu item is not added as username is not valid Order Item arraylist to view all order items",
				"Cakes", orderList.get(0).getItems());

		// test if the list of order menu items retrieved from the C206 Case Study is
		// empty -error
		CanteenApp.storeOrder(orderList, "Jerry", orderMenuList, "Invalid Item");
		// MenuItem testOutput = null;
		assertEquals("Check that item for orderMenuList was not added to OrderList and is empty", true,
				orderList.get(0).getItems().isEmpty());

		// test if the list of order menu items retrieved from the C206 Case Study is
		// not empty -normal
		orderList.removeAll(orderList);
		orderList.add(o1);
		CanteenApp.storeOrder(orderList, "Jerry", orderMenuList, "Cakes");
		String testOutput2 = "Cakes";
		assertEquals("Check that the item in orderMenuList was properly added to OrderList and is not empty",
				testOutput2, orderList.get(0).getItems().get(0).getName());

	}

	@Test // Kenneth
	public void c206_testDeleteOrder() {
		// Test if Order list is not null but empty - error
		orderList.add(o1);
		assertNotNull("Test if there is a valid Order arraylist to view all order items", orderList);

		// test if the invalid item from the C206 Case Study was deleted -error
		CanteenApp.deleteOrder(orderList, "Jerry");
		assertEquals("Check that invalid item for orderMenuList was not deleted from OrderList and is empty", true,
				orderList.isEmpty());

		// test if the list of order menu items retrieved from the C206 Case Study is
		// not empty -normal
		orderList.add(o1);
		orderMenuList.add(m3);
		orderMenuList.add(m4);
		CanteenApp.storeOrder(orderList, "Jerry", orderMenuList, "Cakes");
		assertEquals("Check that the item was added in OrderList and is not empty", false /* testOutput */,
				orderList.isEmpty());
		CanteenApp.deleteOrder(orderList, "Jerry");
//		String testOutput = "Cakes";
		assertEquals("Check that the item was properly deleted in OrderList and is empty", true /* testOutput */,
				orderList.isEmpty());

	}

	@Test // Kenneth
	public void c206_testUpdateOrder() {

		orderList.removeAll(orderList);
		orderList.add(o1);
		CanteenApp.storeOrder(orderList, "Jerry", orderMenuList, "Cakes");

		// Test if the item was properly updated -normal
		CanteenApp.updateOrder(orderList, "Jerry", "Cooking", true);
		assertEquals("Check that the status of the item was properly updated in OrderList", "Cooking" /* testOutput */,
				orderList.get(0).getStatus());
		assertEquals("Check that the takeaway flag of the item was properly updated in OrderList",
				true /* testOutput */, orderList.get(0).isTakeaway());

		orderList.removeAll(orderList);
		orderList.add(new Order("Jerry", "pending", false, orderMenuList2, "now"));
		CanteenApp.storeOrder(orderList, "Jerry", orderMenuList, "Biscuits");

		// Test if error will occur when there is no takeaway flag -error
		CanteenApp.updateOrder(orderList, "Jerry", "Cooking");
		assertEquals("Check that the status of the item was properly updated in OrderList", "Cooking" /* testOutput */,
				orderList.get(0).getStatus());
		assertEquals("Check that the takeaway flag of the item was not updated in OrderList", false /* testOutput */,
				orderList.get(0).isTakeaway());

		orderList.removeAll(orderList);
		orderList.add(new Order("Jerry", "pending", false, orderMenuList2, "now"));
		CanteenApp.storeOrder(orderList, "Jerry", orderMenuList, "Cakes");

		// Test if error will occur when there is no status -error
		CanteenApp.updateOrder(orderList, "Jerry", true);
		assertEquals("Check that the status of the item was not updated in OrderList", "pending" /* testOutput */,
				orderList.get(0).getStatus());
		assertEquals("Check that the takeaway flag of the item was properly updated in OrderList",
				true /* testOutput */, orderList.get(0).isTakeaway());

	}

	@Test // Kenneth
	public void c206_testDeliveryOrder() {

		orderList.removeAll(orderList);
		orderList.add(o1);

		// Test if the program will work properly when the time is at the boundary
		// -boundary
		CanteenApp.deliveryOrder(orderList, "Jerry", "2400");
		assertEquals("Check that the deliveryTime of the item was properly updated in OrderList",
				"2400" /* testOutput */, orderList.get(0).getDeliveryTime());

		// Test if the program will work properly when the time is below the boundary
		// -boundary
		CanteenApp.deliveryOrder(orderList, "Jerry", "2359");
		assertEquals("Check that the deliveryTime of the item was not updated in OrderList", "now" /* testOutput */,
				orderList.get(0).getDeliveryTime());

		// Test if error will occur when the time is invalid -error
		CanteenApp.deliveryOrder(orderList, "Jerry", "Pizza");
		assertEquals("Check that the deliveryTime of the item was not updated in OrderList", "now" /* testOutput */,
				orderList.get(0).getDeliveryTime());

		// Test if error will occur if the time is reset -normal
		CanteenApp.deliveryOrder(orderList, "Jerry", "2443");
		CanteenApp.deliveryOrder(orderList, "Jerry", "now");
		assertEquals("Check that the deliveryTime of the item was not updated in OrderList", "2443" /* testOutput */,
				orderList.get(0).getDeliveryTime());

	}

	@Test // Kenneth
	public void c206_testSummaryOrder() {
		orderList.removeAll(orderList);
		orderList.add(o1);

		// Test that order summary with no item works -error
		String output = CanteenApp.summaryOrder(orderList, "Jerry");
		String testOutput2 = "Total amount: $0.00 \n";
		assertEquals("Check that the order summary and total was properly displayed at end of order and is not empty",
				testOutput2, output);

		CanteenApp.storeOrder(orderList, "Jerry", orderMenuList, "Cakes");

		// Test that order summary with only 1 item works -normal
		output = CanteenApp.summaryOrder(orderList, "Jerry");
		testOutput2 = "Total amount: $3.00 \nCategory: Desserts, Name: Cakes, Price: $3.00\n";
		assertEquals("Check that the order summary and total was properly displayed at end of order and is not empty",
				testOutput2, output);

		CanteenApp.storeOrder(orderList, "Jerry", orderMenuList, "Cakes");

		// Test that order summary with more than 1 item works -normal
		output = CanteenApp.summaryOrder(orderList, "Jerry");
		testOutput2 = "Total amount: $6.00 \nCategory: Desserts, Name: Cakes, Price: $3.00\nCategory: Desserts, Name: Cakes, Price: $3.00\n";
		assertEquals("Check that the order summary and total was properly displayed at end of order and is not empty",
				testOutput2, output);

	}
	
	@Test // Karthik
	public void addPurchaseOrderItemTest() {
		// normal
		CanteenApp.addPurchaseOrderItem(purchaseOrderList, PO1);
		assertEquals("Check that Purchase Order Item arraylist size is 1", 1, purchaseOrderList.size());
		assertSame("Check that Purchase Order Item is added", PO1, purchaseOrderList.get(0));
		// normal
		CanteenApp.addPurchaseOrderItem(purchaseOrderList, PO2);
		assertEquals("Check that Purchase Order Item arraylist size is 2", 2, purchaseOrderList.size());
		assertSame("Check that Purchase Order Item is added", PO2, purchaseOrderList.get(1));
	}
	@Test //Karthik
	public void retrievePurchaseOrderTest() {
		// Test if PurchaseOrder list is not null but empty - boundary
		assertNotNull("Test if there is valid PurchaseOrder arraylist to retrieve PurchaseOrderItems", purchaseOrderList);
		// test if the list of Purchase Order retrieved from the C206_CaseStudy is empty - boundary
		String allPurchaseOrderItems = CanteenApp.RetrievePurchaseOrder(purchaseOrderList);
		String testOutput = "";
		assertEquals("Check that RetrievePurchaseOrder", testOutput, allPurchaseOrderItems);
		//Given an empty List after adding 2 items, test if the size of the list is 2 - normal
		CanteenApp.addPurchaseOrderItem(purchaseOrderList, PO1);
		CanteenApp.addPurchaseOrderItem(purchaseOrderList, PO2);
		assertEquals("Test that Purchase Order Item ArrayList size is 2", 2 , purchaseOrderList.size());
		// test if the expected output string same as the list of Purchase Order items retrieved from the C206_CaseStudy
		allPurchaseOrderItems = CanteenApp.RetrievePurchaseOrder(purchaseOrderList);
		testOutput = String.format("%-15s %-10d %-10.2f %-10s\n", "strawberry", 10, 13.50, "21/3/2020");
		testOutput += String.format("%-15s %-10d %-10.2f %-10s\n", "straws", 30, 5.0, "25/2/2020");
		assertEquals("Test that ViewPurchaseOrderItems", testOutput, allPurchaseOrderItems);
	}
	@Test //Karthik
	public void CheckDeletePurchaseOrderItemTest() {
		// boundary condition
		assertNotNull("Test if there is valid PurchaseOrder arraylist to add to", purchaseOrderList);
		CanteenApp.addPurchaseOrderItem(purchaseOrderList, PO1);
		// normal condition
		Boolean ok = CanteenApp.CheckDeletePurchaseOrderItem(purchaseOrderList,"strawberry", 10, 13.50, "21/3/2020");
		assertTrue("Test if the existing Purchase Order item can be deleted from the list", ok);
		// error condition
		ok = CanteenApp.CheckDeletePurchaseOrderItem(purchaseOrderList,"durian", 10, 13.50, "21/3/2020");
		assertFalse("Test if the existing purchase Order item can be deleted from the list?", ok);
	}
	@Test //Karthik
	public void CheckUpdateDeliveryDateTest() {
		// boundary condition
		assertNotNull("Test if there is valid PurchaseOrder arraylist to add to", purchaseOrderList);
		CanteenApp.addPurchaseOrderItem(purchaseOrderList, PO1);
		// normal condition
		Boolean correct = CanteenApp.CheckUpdateDeliveryDate(purchaseOrderList,"strawberry", 10, 13.50, "21/3/2020" );
		assertTrue("Test if the existing PurchaseOrder item's Delivery Date has been updated?", correct);
		// error condition
		correct = CanteenApp.CheckUpdateDeliveryDate(purchaseOrderList, "straw", 10, 13.50, "21/3/2020");
		assertFalse("Test if the existing PurchaseOrder item's Delivery Date has been updated?", correct);
		
	}
	@Test // Karthik
	public void searchPurchaseOrderByItemNameTest() {
		// Given an empty list, after adding 3 items, test if the arraylist size is 3 -
		// normal condition
		CanteenApp.addPurchaseOrderItem(purchaseOrderList, PO1);
		CanteenApp.addPurchaseOrderItem(purchaseOrderList, PO2);
		CanteenApp.addPurchaseOrderItem(purchaseOrderList, PO3);
		assertEquals("Test that  PurchaseOrder arraylist size is 3", 3, purchaseOrderList.size());

		// normal condition
		Boolean correct = CanteenApp.SearchByItemName(purchaseOrderList, "Strawberry");
		assertTrue("Test if PurchaseOrder items can search using item Name", correct);

		// error condition
		correct = CanteenApp.SearchByItemName(purchaseOrderList, "banana");
		assertFalse("Test if purchaseOrder cans search by item Name", correct);
		
	}
	@Test // Karthik
	public void searchPurchaseOrderItemsByDeliveryDateTest() {
		// Given an empty list, after adding 3 items, test if the arraylist size is 3 -
		// normal condition
		CanteenApp.addPurchaseOrderItem(purchaseOrderList, PO1);
		CanteenApp.addPurchaseOrderItem(purchaseOrderList, PO2);
		CanteenApp.addPurchaseOrderItem(purchaseOrderList, PO3);
		assertEquals("Test that  PurchaseOrder arraylist size is 3", 3, purchaseOrderList.size());

		// normal condition
		Boolean correct = CanteenApp.CheckByDeliveryDate(purchaseOrderList, "21/3/2020");
		assertTrue("Test if PurchaseOrder items can search using item Name", correct);

		// error condition
		correct = CanteenApp.CheckByDeliveryDate(purchaseOrderList, "21/4/2020");
		assertFalse("Test if purchaseOrder cans search by item Name", correct);
	}
	@After
	public void tearDown() throws Exception {

	}

}
