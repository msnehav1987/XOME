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
import webPageObjects.Gmail;
import webPageObjects.SignUp_Page;

public class SignUp_NewUser extends TestBase{
	
	        //****************************************//
			//***                                  ***//
			//*** Created by Angela Tong Apr 2018  ***//
			//***                                  ***//
			//****************************************//

			static SoftAssert softAssert = new SoftAssert();
			final static Logger log = LogManager.getLogger(SignUp_NewUser.class);
			
			
			static String className = SignUp_NewUser.class.getSimpleName();
		 	static Date date1= new Date();
		 	static String originaltimestamp = new Timestamp(date1.getTime()).toString();
		 	static String timestamp = originaltimestamp.replace(':', 'x').substring(11);
			static String foldername = className+timestamp;
			static String errorname = "";
			static String picinfo = "";

				
			@Test(groups={"smoke", "regression"}, dataProvider = "getData")
			public void signUp_NewUser (String firstname, String lastname, String email, String password, String gmailpwd, String gmailsearch) throws IOException, InterruptedException
			{

				SignUp_Page.clickSignUp(webdriver);
				String [] signedupnewuser = SignUp_Page.testSignUpNewUser(webdriver, firstname, lastname, email, password);
				String signedupemail = signedupnewuser[0];
				
				try{
					Assert.assertEquals(signedupnewuser[1], "AUTOMATION TESTER");
					log.info("Got signed up user is "+signedupnewuser[1]);
				} 
				catch(AssertionError e)
				{ 
					log.error("Didn't sign up correct user.", e.getMessage());
					errorname = "didntsignupcorrectuser";
					ScreenshotURL.screenshotURL(webdriver, foldername, errorname);
					softAssert.fail();
				}
					
				String [] registrationemail = Gmail.checkRegisterEmail(webdriver, email, gmailpwd, gmailsearch);
				
				
				try{
					Assert.assertEquals(registrationemail[0], "Xome Inc.");
					log.info("Got Xome Inc. registrationemail[0] is "+registrationemail[0]);
				} 
				catch(AssertionError e)
				{ 
					log.error("Didn't get Xome Inc.", e.getMessage());
					errorname = "didntgetXomeInc";
					ScreenshotURL.screenshotURL(webdriver, foldername, errorname);
					softAssert.fail();
				}

	
				
				try{
					Assert.assertEquals(registrationemail[1], "Welcome to Xome!");
					log.info("Got Welcome to Xome! registrationemail[1] is "+registrationemail[1]);
				} 
				catch(AssertionError e)
				{ 
					log.error("Didn't get Welcome to Xome!", e.getMessage());
					errorname = "didntgetWelcometoXome";
					ScreenshotURL.screenshotURL(webdriver, foldername, errorname);
					softAssert.fail();
				}
				

			
				String registrationemailtext = registrationemail[2]+"\n"+registrationemail[3];
				log.info("Registrationemailtext is "+registrationemailtext);

  
				try {
					Assert.assertEquals(registrationemailtext, "Thank you for registering for Xome®.\n"+"Your username is: "+signedupemail);
					log.info("Got registrationemail[2]+registrationemail[3] is "+registrationemail[2]+"\n"+registrationemail[3]);
					//Capture a picture of the email for backup, then delete the email to clean up for next test run.
					picinfo="BackupCopyOfPassingRegistrationEmail";
					ScreenshotURL.backupCopyScreenshot(webdriver, foldername, picinfo);
					Gmail.deleteGmail(webdriver);
					
				}				
				catch(AssertionError e)
				{ 
					log.error("Didn't get correct email registration text.", e.getMessage());
					errorname = "didntgetcorrectemailregistrationtext";
					ScreenshotURL.screenshotURL(webdriver, foldername, errorname);
					softAssert.fail();
				}
				

				
				softAssert.assertAll();
				
			}
}
