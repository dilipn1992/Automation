package script;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestDemo2 {

	@Test
	public void testB()
	{
		Reporter.log("from test B",true);
		Assert.fail();
	}
}
