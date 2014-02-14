package LRUCache;

import static org.junit.Assert.*;

import org.junit.Test;

public class LRUCacheTest {

	@Test
	public void testSetGet() {
		LRUCache cache = new LRUCache(2);
		cache.set(2, 1);
		cache.set(1,1);
		assertEquals("value not correct", 1, cache.get(2));
		cache.set(4,1);
		assertEquals("value not correct", -1, cache.get(1));
		assertEquals("value not correct", 1, cache.get(2));
	}

}
