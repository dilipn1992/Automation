package page;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//private WebDriver driver;

	//Declaration
			@FindBy(id="username")
			private WebElement unTB;
			@FindBy(name="pwd")
			private WebElement pwTB;
			@FindBy(xpath="//div[.='Login ']")
			private WebElement loginBTN;
			//Initialization
			public LoginPage(WebDriver driver) {
				//this.driver=driver;
				//System.out.println(this.driver);
				PageFactory.initElements(driver, this);
			}
			
			//Utilization
			public void setName(String un) {
				unTB.sendKeys(un);
			}
			
			public void setPwd(String pw) {
				pwTB.sendKeys(pw);
			}
			public void clickLogin() {
				loginBTN.click();
				//Acti_HomePage homePage=new Acti_HomePage(driver);
				//return homePage
				//return new Acti_HomePage(driver);

}
}
