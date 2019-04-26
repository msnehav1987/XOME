package webTests;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.TestBase;
import common.ScreenshotURL;
import webPageObjects.Login_Page;

public class Login_NegativeTests extends TestBase{
	
    //****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Apr 2018  ***//
	//***                                  ***//
	//****************************************//

	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = LogManager.getLogger(Login_NegativeTests.class);
	
	
	static String className = Login_NegativeTests.class.getSimpleName();
 	static Date date1= new Date();
 	static String originaltimestamp = new Timestamp(date1.getTime()).toString();
 	static String timestamp = originaltimestamp.replace(':', 'x').substring(11);
	static String foldername = className+timestamp;
	static String errorname = "";

		
	@Test(groups="P3", dataProvider = "getData")
	public void loginBlankFields (String login, String password) throws IOException, InterruptedException
	{
	   Login_Page.clickSignIn(webdriver);
	   String emailisrequired1 = Login_Page.signinBlankFields(webdriver);
	   
		try
		{
			   Assert.assertEquals(emailisrequired1, "true");
		}
		catch(AssertionError e)
		{ 
			log.error("Didn't get required error message tip when signin with blank fields.", e.getMessage());
			errorname = "norequirederrmsgsigninwithblankfields";
			ScreenshotURL.screenshotURL(webdriver, foldername, errorname);
			softAssert.fail();
		}
	   
		String emailisrequired2 = Login_Page.signinBlankEmail(webdriver, password);
		
		try
		{
			   Assert.assertEquals(emailisrequired2, "true");
		}
		catch(AssertionError e)
		{ 
			log.error("Didn't get required error message tip when signin with blank email.", e.getMessage());
			errorname = "norequirederrmsgsigninwithblankemail";
			ScreenshotURL.screenshotURL(webdriver, foldername, errorname);
			softAssert.fail();
		}
		
		
		String wrongemailpwdtext2 = Login_Page.signinBlankPwd(webdriver, login);
		
		try
		{
			   Assert.assertEquals(wrongemailpwdtext2, "Oops, the e-mail or password doesn't match.");
		}
		catch(AssertionError e)
		{ 
			log.error("Didn't get wrong email password text when signin with blank pwd.", e.getMessage());
			errorname = "nowrongemailpwdtextwhensigninwithblankpwd";
			ScreenshotURL.screenshotURL(webdriver, foldername, errorname);
			softAssert.fail();
		}
	   
	   softAssert.assertAll();
	   
	}
	
	@Test(groups="regression", dataProvider = "getData")
	public void loginWrongPwd (String login, String password) throws IOException, InterruptedException
	{
		Login_Page.clickSignIn(webdriver);
	    String wrongpwdtextresults = Login_Page.signinWrongPwd(webdriver, login, password);
	    String wrongpwdtext = "Oops, the e-mail or password doesn't match.";
	 
		try
		{
			Assert.assertEquals(wrongpwdtextresults, wrongpwdtext);
		}
		catch(AssertionError e)
		{ 
			log.error("Signin with wrong password text has issues.", e.getMessage());
			errorname = "signinwithwrongpwdissue";
			ScreenshotURL.screenshotURL(webdriver, foldername, errorname);
			softAssert.fail();
		}
	
		   softAssert.assertAll();
	}

	
}
