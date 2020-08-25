import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private MenuItem m1;
	private MenuItem m2;
	private MenuItem m3;
	private MenuItem m4;
	private MenuItem m5;
	private MenuItem m6;

	private ArrayList<MenuItem> menuItemList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		m1 = new MenuItem("Soda", "Sprite", 1.50);
		m2 = new MenuItem("Smoothies", "Banana", 3.50);
		m3 = new MenuItem("Pizzas", "Cheese", 3.00);
		m4 = new MenuItem("Pizzas", "Pepperoni", 4.00);
		m5 = new MenuItem("Sweets", "Gummies", 2.50);
		m6 = new MenuItem("Sweets", "Lollipops", 2.00);

		menuItemList = new ArrayList<MenuItem>();

	}

	@Test
	public void doUpdateMenuItemNameTest() {
		// boundary condition
		assertNotNull("Test if there is valid MenuItem arraylist to add to", menuItemList);
		C206_CaseStudy.addMenuItem(menuItemList, m1);
		// normal condition
		Boolean ok = C206_CaseStudy.doUpdateMenuItemName(menuItemList, "Soda", "Coca Cola", 1.50);
		assertTrue("Test if the existing menu item is updated its name?", ok);
		// error condition
		ok = C206_CaseStudy.doUpdateMenuItemName(menuItemList, "Soda", "Coca Cola", 2.00);
		assertFalse("Test if the existing menu item is updated its name?", ok);
	}

	@Test
	public void doUpdateMenuItemPriceTest() {
		// boundary condition
		assertNotNull("Test if there is valid MenuItem arraylist to add to", menuItemList);
		C206_CaseStudy.addMenuItem(menuItemList, m2);
		// normal condition
		Boolean ok = C206_CaseStudy.doUpdateMenuItemPrice(menuItemList, "Smoothies", "Banana", 3.50);
		assertTrue("Test if the existing menu item name is updated its price?", ok);
		// error condition
		ok = C206_CaseStudy.doUpdateMenuItemPrice(menuItemList, "Smoothies", "Blueberry", 3.50);
		assertFalse("Test if the existing menu item is updated its price?", ok);
	}

	@Test
	public void doViewMenuItemByPriceRangeTest() {
		// Given an empty list, after adding 4 items, test if the arraylist size is 6 -
		// normal condition
		C206_CaseStudy.addMenuItem(menuItemList, m1);
		C206_CaseStudy.addMenuItem(menuItemList, m2);
		C206_CaseStudy.addMenuItem(menuItemList, m3);
		C206_CaseStudy.addMenuItem(menuItemList, m4);
		C206_CaseStudy.addMenuItem(menuItemList, m5);
		C206_CaseStudy.addMenuItem(menuItemList, m6);
		assertEquals("Test that Menu Item arraylist size is 6", 6, menuItemList.size());

		// normal condition
		Boolean ok = C206_CaseStudy.doViewByPriceRange(menuItemList, 2.00, 4.00);
		assertTrue("Test if these menu items fall under the range between $2 to $3", ok);

		// error condition
		ok = C206_CaseStudy.doViewByPriceRange(menuItemList, 4.00, 5.00);
		assertFalse("Test if these menu items fall under the range between $4 to $5", ok);
	}

	@Test
	public void canSearchByCategory() {
		// Given an empty list, after adding 4 items, test if the arraylist size is 6 - normal condition
		C206_CaseStudy.addMenuItem(menuItemList, m1);
		C206_CaseStudy.addMenuItem(menuItemList, m2);
		C206_CaseStudy.addMenuItem(menuItemList, m3);
		C206_CaseStudy.addMenuItem(menuItemList, m4);
		C206_CaseStudy.addMenuItem(menuItemList, m5);
		C206_CaseStudy.addMenuItem(menuItemList, m6);
		assertEquals("Test that Menu Item arraylist size is 6", 6, menuItemList.size());
		
		// normal condition
		Boolean ok = C206_CaseStudy.canSearchByCategory(menuItemList, "Pizzas");
		assertTrue("Test if menu items can search by Pizzas category", ok);
		
		// error condition
		ok = C206_CaseStudy.canSearchByCategory(menuItemList, "Seafood");
		assertFalse("Test if menu items can search by Seafood", ok);
	}

	@After
	public void tearDown() throws Exception {
		m1 = null;
		m2 = null;
		m3 = null;
		m4 = null;
		m5 = null;
		m6 = null;

	}

}
