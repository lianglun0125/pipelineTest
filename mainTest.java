import org.junit.jupiter.api.Test;
import junit.framework.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class mainTest extends TestCase 
{
	@Test
	public void Test() 
	{
		main main = new main();
		int result = main.add(2134654,465416);
		assertEquals(result,2600070);
	}
}
