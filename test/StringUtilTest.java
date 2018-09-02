import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests of the StringUtil methods.
 */
public class StringUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIndexOf() {
		String[] fruit = {"Apple", "Banana", "Grapes"};
		assertEquals(0, StringUtil.indexOf("Apple", fruit));
	}
	
	@Test
	public void testFailCase() {
		String[] name = {"SKE"};
		assertEquals(-1, StringUtil.indexOf("ske", name) );
	}
	
	@Test 
	public void testEmptyCase() {
		String[] empty = {};
		assertEquals(-1,StringUtil.indexOf("", empty));
	}
	
	@Test
	public void testAllIndexOf() {
		String[] fruit = {"Apple", "Banana", "Grapes", "ORANGE", "mango"};
		for(int i = 0 ; i < fruit.length ; i++) {
			assertEquals(i, StringUtil.indexOf(fruit[i], fruit));
		}
	}
}
