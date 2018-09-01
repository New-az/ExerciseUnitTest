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
	public void testLetters() {
		String[] name = {"SKE","fathalajon","ISP"};
		assertEquals(-1, StringUtil.indexOf("ske", name) );
		assertEquals(1, StringUtil.indexOf("fathalajon", name) );
		assertEquals(2, StringUtil.indexOf("isp".toUpperCase(), name) );
	}
	
	

	//TODO write more tests. Test other cases.
}
