package mobileTests;

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
import mobilePageObjects.MLogin_Page;


public class MSignUp_NewUser extends TestBase{
	
    //****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Apr 2018  ***//
	//***                                  ***//
	//****************************************//
	
	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = LogManager.getLogger(MSignUp_NewUser.class);
	
	static String className = MSignUp_NewUser.class.getSimpleName();
 	static Date date1= new Date();
 	static String originaltimestamp = new Timestamp(date1.getTime()).toString();
 	static String timestamp = originaltimestamp.replace(':', 'x').substring(11);
	static String foldername = className+timestamp;
	static String errorname = "";

	@Test(groups= {"smoke", "regression"}, dataProvider = "getMobileData") 
	public void mSignUpNewUser (String firstname, String lastname, String email, String password) throws IOException, InterruptedException
	{
		MLogin_Page.allowDeviceLocationAccess(driver);
		String diditsignup = MLogin_Page.mobileSignUp(driver, firstname, lastname, email, password);

		try{
			Assert.assertEquals(diditsignup, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't sign up new user correctly.", e.getMessage());
			errorname = "didntsignupnewusercorrectly";
			ScreenshotURL.screenshotURL(driver, foldername, errorname);
			softAssert.fail();
		}


		   softAssert.assertAll();
	}
	

}
