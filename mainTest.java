import org.junit.jupiter.api.Test;
import junit.framework.*;

class mainTest extends TestCase 
{
	@Test
	public void Test() 
	{
		main main = new main();
		int result_3 = main.add(2134654,465416);
		assertEquals(result_3,2600070);
	}
}
