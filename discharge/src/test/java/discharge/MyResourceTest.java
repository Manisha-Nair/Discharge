package discharge;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyResourceTest {
	
	@Test
	public void testgetIt() {
		MyResource resource = new MyResource();
		String s = resource.getIt();
		assertEquals("Got it!",s);
	}

}
