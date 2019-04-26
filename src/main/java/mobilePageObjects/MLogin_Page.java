package mobilePageObjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;

public class MLogin_Page {
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Apr 2018  ***//
	//***                                  ***//
	//****************************************//
	final static Logger log = LogManager.getLogger(MLogin_Page.class);

	static By allowdeviceacess = By.id("com.android.packageinstaller:id/permission_allow_button");
	static By hamburgericon = By.xpath(".//android.widget.ImageButton[@content-desc='Open navigation drawer']");
	static By registerbtn = By.id("com.xome.android:id/button_login_register");
	static By fname = By.id("com.xome.android:id/etFirstName");
	static By lname = By.id("com.xome.android:id/etLastName");
	static By e_mail = By.id("com.xome.android:id/etEmail");
	static By pwd = By.id("com.xome.android:id/etPassword");
	static By confirmpwd = By.id("com.xome.android:id/etConfirmPassword");
	static By phonenumber = By.id("com.xome.android:id/etPhoneNumber");
	static By finalregisterbtn = By.id("com.xome.android:id/btnRegister");
	static By signinbtn = By.id("com.xome.android:id/nav_sign_in");
	static By emaillogin = By.id("com.xome.android:id/edittext_login_email");
	static By pwdlogin = By.id("com.xome.android:id/textview_login_password");
	static By signinlogin = By.id("com.xome.android:id/button_login");
	static By amyfowlerwelcometext = By.xpath(".//android.widget.TextView[@text = 'Welcome Amy']");
	static By welcometext = By.xpath(".//android.widget.TextView[@text = 'Welcome Automation']");
	static By myxomebutton = By.xpath(".//android.widget.TextView[@text = 'MY XOME']");
	
	static String diditlogin = "";
	static String diditregister = "";
	
	public static void allowDeviceLocationAccess (AppiumDriver<?> driver) throws InterruptedException
	{	
		WebDriverWait wait = new WebDriverWait (driver, 60);
		WebElement allowdeviceacesselement = wait.until(ExpectedConditions.elementToBeClickable(allowdeviceacess));
		allowdeviceacesselement.click();
		Thread.sleep(4000); //Must wait for this time to load
	}
	
	public static String mobileSignUp (AppiumDriver<?> driver, String firstname, String lastname, String email, String password) throws InterruptedException
	{	
		WebDriverWait wait = new WebDriverWait (driver, 60);
		WebElement hamburgericonelement = wait.until(ExpectedConditions.elementToBeClickable(hamburgericon));
		hamburgericonelement.click();
		Thread.sleep(4000); //Must wait for this time to load
		
		WebElement signinbtnelement= wait.until(ExpectedConditions.elementToBeClickable(signinbtn));
		signinbtnelement.click();
		
		WebElement registerbtnelement= wait.until(ExpectedConditions.elementToBeClickable(registerbtn));
		registerbtnelement.click();
		
		WebElement firstnameelement = wait.until(ExpectedConditions.elementToBeClickable(fname));
		firstnameelement.click();
		firstnameelement.clear();
		firstnameelement.sendKeys(firstname);
		
		WebElement lastnameelement = wait.until(ExpectedConditions.elementToBeClickable(lname));
		lastnameelement.click();
		lastnameelement.clear();
		lastnameelement.sendKeys(lastname);
		
		String [] emailarray = email.split("@");
	    
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyyHHmmss");
		LocalDateTime now = LocalDateTime.now();
	    String append = dtf.format(now).toString();
	    
	    String newemail = emailarray[0]+"+"+append+"@"+emailarray[1];
	    
	    log.info(newemail);
		
		WebElement emailelement = wait.until(ExpectedConditions.elementToBeClickable(e_mail));
		emailelement.click();
		emailelement.clear();
		emailelement.sendKeys(newemail);
		
		WebElement pwdelement = wait.until(ExpectedConditions.elementToBeClickable(pwd));
		pwdelement.click();
		pwdelement.clear();
		pwdelement.sendKeys(password);
		
		WebElement confirmpwdelement = wait.until(ExpectedConditions.elementToBeClickable(confirmpwd));
		confirmpwdelement.click();
		confirmpwdelement.clear();
		confirmpwdelement.sendKeys(password);
		
		WebElement finalregisterbtnelement = wait.until(ExpectedConditions.elementToBeClickable(finalregisterbtn));
		finalregisterbtnelement.click();
		Thread.sleep(4000);
		
		hamburgericonelement = wait.until(ExpectedConditions.elementToBeClickable(hamburgericon));
		hamburgericonelement.click();
		Thread.sleep(4000); //Must wait for this time to load
		
		WebElement amyfowlerwelcometextelement = wait.until(ExpectedConditions.presenceOfElementLocated(amyfowlerwelcometext));
		String welcome_text = amyfowlerwelcometextelement.getText();
		log.info(welcome_text);
		
		WebElement myxomebuttonelement = wait.until(ExpectedConditions.elementToBeClickable(myxomebutton));
		String myxomebtntext = myxomebuttonelement.getText();

		
		if (welcome_text.equalsIgnoreCase("Welcome Amy") && myxomebtntext.equalsIgnoreCase("MY XOME"))
		{
			diditregister="yes";
			log.info("Signed up successfully.");
		}
		else 
		{
			diditregister="no";
			log.info("Signed up unsuccessfully.");
		}
		
		return diditregister;
	
	}
	
	public static String mobileLogin (AppiumDriver<?> driver, String login, String password, String searchkeyword) throws InterruptedException
	{	
		WebDriverWait wait = new WebDriverWait (driver, 60);
		WebElement hamburgericonelement = wait.until(ExpectedConditions.elementToBeClickable(hamburgericon));
		hamburgericonelement.click();
		Thread.sleep(4000); //Must wait for this time to load
		
		WebElement signinbtnelement= wait.until(ExpectedConditions.elementToBeClickable(signinbtn));
		signinbtnelement.click();
		
		WebElement emailloginelement = wait.until(ExpectedConditions.elementToBeClickable(emaillogin));
		emailloginelement.click();
		emailloginelement.clear();
		emailloginelement.sendKeys(login);
		
		WebElement pwdloginelement = wait.until(ExpectedConditions.elementToBeClickable(pwdlogin));
		pwdloginelement.click();
		pwdloginelement.clear();
		pwdloginelement.sendKeys(password);
		Thread.sleep(4000); //Must wait for this time to load
		
		WebElement signinloginelement = wait.until(ExpectedConditions.elementToBeClickable(signinlogin));
		signinloginelement.click();
		
		hamburgericonelement = wait.until(ExpectedConditions.elementToBeClickable(hamburgericon));
		hamburgericonelement.click();
		Thread.sleep(4000); //Must wait for this time to load
		
		WebElement welcometextelement = wait.until(ExpectedConditions.presenceOfElementLocated(welcometext));
		String welcome_text = welcometextelement.getText();
		
		WebElement myxomebuttonelement = wait.until(ExpectedConditions.elementToBeClickable(myxomebutton));
		String myxomebtntext = myxomebuttonelement.getText();
		
		if (welcome_text.equalsIgnoreCase("Welcome Automation") && myxomebtntext.equalsIgnoreCase("MY XOME"))
		{
			diditlogin="yes";
			log.info("Logged in successfully.");
		}
		else 
		{
			diditlogin="no";
			log.info("Logged in unsuccessfully.");
		}
		
		return diditlogin;
	}
	
}
