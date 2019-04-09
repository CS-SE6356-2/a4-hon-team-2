import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestProductNotFoundException {

	@Test
	public void testRemove() {
		ShoppingCart s = new ShoppingCart();
		Product p = new Product("Banana", 2.99);
		
		// When a new product is added, the number of items must be incremented
		int size = s.getItemCount();
		Product apple = new Product("Apple", 1.99);
		s.addItem(apple);
		assertEquals(s.getItemCount(), size+1);
		
		// When a new product is added, the new balance must be the sum of the previous balance plus the cost of the new product
		Product orange = new Product("Orange", 0.99);
		double bal = s.getBalance();
		s.addItem(orange);
		if(s.getBalance() != bal+orange.getPrice())
			fail();
		
		
		// When a product not in the cart is removed, a ProductNotFoundException must be thrown
		try {
			s.removeItem(p);
			fail();
		} catch(ProductNotFoundException ex) { }
	}
}
