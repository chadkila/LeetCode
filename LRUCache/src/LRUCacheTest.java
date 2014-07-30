import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author yu
 * 
 */
public class LRUCacheTest {

	/**
	 * Test method for {@link LRUCache#LRUCache(int)}.
	 */
	// @Test
	public void testLRUCache() {
		LRUCache test = new LRUCache(5);
		test.set(2, 3);
		test.set(4, 6);
		test.set(5, 7);
		test.set(4, 1);
		test.set(1, 9);
		System.out.println(test.get(4));
		test.set(6, 8);
		test.set(2, 5);
		System.out.println(test.get(4));
		System.out.println(test.get(1));
		System.out.println(test.get(9));
	}

	// @Test
	public void testLRUCache1() {
		LRUCache test = new LRUCache(5);
		test.set(2, 1);
		System.out.println(test.get(2));
	}

	@Test
	public void testLRUCache3() {
		LRUCache test = new LRUCache(2);
		test.set(2, 1);
		test.set(2, 2);
		System.out.println(test.get(2));
		test.set(1, 1);
		test.set(4, 1);
		System.out.println(test.get(2));
	}

}
