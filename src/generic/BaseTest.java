package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
@Listeners(Result.class)
abstract public class BaseTest implements IAutoConst {
	public  WebDriver driver;
	//public String url="http://www.google.com";
	public String url=Utility.getPropertyValue(CONFIG_PATH,"URL");
	String ITO=Utility.getPropertyValue(CONFIG_PATH,"ITO");
	//public long duration=10;
	public long duration=Long.parseLong(ITO);
	static
	{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
	}
	@Parameters({"ip","browser"})
	@BeforeMethod
	public void OpenApplication(@Optional("localhost")String ip,@Optional("chrome")String browser)
	{
		//WebDriver 
		/* COmment
		 * driver=new ChromeDriver();
		   driver.manage().timeouts().implicitlyWait(duration,TimeUnit.SECONDS);
		   driver.get(url); */
		//driver=Utility.openBrowser(driver, "localhost", "chrome");
		//driver=Utility.openBrowser(driver, "ip", "chrome");
		driver=Utility.openBrowser(driver, ip, browser);
		driver.manage().timeouts().implicitlyWait(duration,TimeUnit.SECONDS);
		driver.get(url);
	}
	@AfterMethod
	public void CloseApplication(ITestResult result)
	{
		String name=result.getName();
		int status=result.getStatus();
		if(status==2)
		{
			
	   String path= Utility.getPhoto(driver, PHOTO_PATH);
	   Reporter.log("Test:"+name+" is Failed & Photo Is Taken:"+path,true);
		}
		else
		{
			 Reporter.log("Test:"+name+" is Passed & No Photo",true);
		}
		driver.quit();
	}

}
