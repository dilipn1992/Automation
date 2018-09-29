package script;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.LoginPage;

public class TestDemo extends BaseTest{
	@Test
	public void testA() {
		String data=Utility.getXLData(INPUT_PATH,"sheet1",0,0);
		Reporter.log("Data:"+data,true);
		//System.out.println(data);
		int r=Utility.getXLRowCount(INPUT_PATH,"sheet1");
		Reporter.log("Row:"+r,true);
		//Assert.fail();
//		String p=Utility.getPhoto(driver, PHOTO_PATH);
//		Reporter.log("Photo:"+p,true);
		LoginPage loginPage=new LoginPage(driver);
		String un=Utility.getXLData(INPUT_PATH, "sheet1", 1, 0);
		loginPage.setName(un);
		String pw=Utility.getXLData(INPUT_PATH, "sheet1", 1, 1);
		loginPage.setPwd(pw);
		loginPage.clickLogin();
	}

}
