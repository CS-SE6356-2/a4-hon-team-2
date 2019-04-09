import static org.junit.Assert.fail;

import org.junit.Test;

public class TestProductNotFoundException {

	@Test
	public void testRemove() {
		ShoppingCart s = new ShoppingCart();
		Product p = new Product("Banana", 2.99);
		
		try {
			s.removeItem(p);
			fail();
		} catch(ProductNotFoundException ex) { }
	}
}
