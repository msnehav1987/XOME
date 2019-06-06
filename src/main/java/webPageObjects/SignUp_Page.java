package webPageObjects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUp_Page {
	
		//****************************************//
		//***                                  ***//
		//*** Created by Angela Tong Apr 2018  ***//
		//***                                  ***//
		//****************************************//
		final static Logger log = LogManager.getLogger(SignUp_Page.class);
		
		static By createacct = By.cssSelector("a.LinkButton.btn.btn-primary");
		static By fname = By.cssSelector("input#first-name[required='required']");
		static By lname = By.cssSelector("input#last-name[required='required']");
		static By electronicmail = By.cssSelector("input#email-address[required='required']");
		static By pwd = By.cssSelector("input#password-field[required='required']");
		static By submit = By.xpath(".//*[@id='submit-button' and @class='btn btn-primary']");	
		static By invalidemailerrmsg = By.cssSelector("div.errorMessageBox>ul>li"); //Oops, looks like the e-mail you entered is invalid.
		static By duplicateemailerrmsg = By.cssSelector("div.errorMessageBox.clearfix>ul>li");//Good news! We've already got you in our system! Please sign in using the link above.
		static By pwdreqheader = By.cssSelector("div.password-requirements-dialog>h5"); //Password Requirements
		static By eightcharsreq = By.cssSelector("div.password-requirements-dialog>div.requirement-item"); //at least 8 characters
		static By verifysignedup = By.cssSelector("div.user-section.authenticated>div.NavSubmenu.btn-group>div.NavSubmenu-button>span.NavItem.top-level.user-menu>span");
		static By pwdregistrationhint = By.className("registration-password-hint");
				
	    public static void clickSignUp (WebDriver webdriver)
	    {
	    		WebDriverWait wait = new WebDriverWait (webdriver, 60);
	    		WebElement create_acct = wait.until(ExpectedConditions.elementToBeClickable(createacct));
	        create_acct.click(); 
		    WebElement iframeSwitch = webdriver.findElement(By.id("register-iframe"));
		    webdriver.switchTo().frame(iframeSwitch);
	    }

	   
	    public static String testBlankFirstName(WebDriver webdriver)
	    {
	    	    WebDriverWait wait = new WebDriverWait (webdriver, 60);
	    	    WebElement first_name = wait.until(ExpectedConditions.elementToBeClickable(fname));
		    WebElement submitbtn = wait.until(ExpectedConditions.elementToBeClickable(submit));
	        submitbtn.click();
	    	    
            
            //By default if element is required it will show Please fill out this field when submitting a blank value for it.
            //So I just have to check the attribute is set to required.
            //There is no way to get the text because it is not listed in the code. 
            //After doing some research this is the valid way according to https://groups.google.com/forum/#!topic/webdriver/sUy6IKpQsHw
	        String fieldisrequired = first_name.getAttribute("required");
          
	    	    log.info("Check firstName field is required: "+fieldisrequired);

	    	    return fieldisrequired;
	    }

	    
	    public static String testBlankLastName(WebDriver webdriver, String firstname)
	    {
	    	    WebDriverWait wait = new WebDriverWait (webdriver, 60);
	    	    WebElement first_name = wait.until(ExpectedConditions.elementToBeClickable(fname));
	    	    WebElement last_name = wait.until(ExpectedConditions.elementToBeClickable(lname));
			WebElement submitbtn = wait.until(ExpectedConditions.elementToBeClickable(submit));
		    first_name.click();
		    first_name.clear();
		    first_name.sendKeys(firstname);
		    
		    WebElement pwdhint = wait.until(ExpectedConditions.elementToBeClickable(pwdregistrationhint));
		    pwdhint.click();
		    
	        submitbtn.click();
	    	    
	        String fieldisrequired = last_name.getAttribute("required");
          
	    	    log.info("Check lastName field is required: "+fieldisrequired);

	    	    return fieldisrequired;
	    }
	  
	    
	    public static String testBlankEmail(WebDriver webdriver, String firstname, String lastname) 
	    {
	    	    WebDriverWait wait = new WebDriverWait (webdriver, 60);
	    	    WebElement first_name = wait.until(ExpectedConditions.elementToBeClickable(fname));
	    	    WebElement last_name = wait.until(ExpectedConditions.elementToBeClickable(lname));
	    	    WebElement e_mail = wait.until(ExpectedConditions.elementToBeClickable(electronicmail));
			WebElement submitbtn = wait.until(ExpectedConditions.elementToBeClickable(submit));
			
		    first_name.click();
		    first_name.clear();
		    first_name.sendKeys(firstname);
		    
		    last_name.click();
		    last_name.clear();
		    last_name.sendKeys(lastname);
		    
		    WebElement pwdhint = wait.until(ExpectedConditions.elementToBeClickable(pwdregistrationhint));
		    pwdhint.click();
		    
	        submitbtn.click();
	    	    
	        String fieldisrequired = e_mail.getAttribute("required");
          
	    	    log.info("Check email field is required: "+fieldisrequired);

	    	    return fieldisrequired;
	    }
	    
	    
	    public static String testBlankPassword(WebDriver webdriver, String firstname, String lastname, String email) 
	    {
	    	    WebDriverWait wait = new WebDriverWait (webdriver, 60);
	    	    WebElement first_name = wait.until(ExpectedConditions.elementToBeClickable(fname));
			WebElement last_name = wait.until(ExpectedConditions.elementToBeClickable(lname));
			WebElement el_mail = wait.until(ExpectedConditions.elementToBeClickable(electronicmail));
			WebElement pass_word = wait.until(ExpectedConditions.elementToBeClickable(pwd));
			WebElement submitbtn = wait.until(ExpectedConditions.elementToBeClickable(submit));
			
		    first_name.click();
		    first_name.clear();
		    first_name.sendKeys(firstname);
		    
		    last_name.click();
		    last_name.clear();
		    last_name.sendKeys(lastname);
		    
		    el_mail.click();
		    el_mail.clear();
		    el_mail.sendKeys(email);
		    
		    WebElement pwdhint = wait.until(ExpectedConditions.elementToBeClickable(pwdregistrationhint));
		    pwdhint.click();
		    
	        submitbtn.click();
	    	    
	        String fieldisrequired = pass_word.getAttribute("required");
          
	    	    log.info("Check password field is required: "+fieldisrequired);

	    	    return fieldisrequired;
	    }
	    
	    
	    public static String testInvalidEmail (WebDriver webdriver, String firstname, String lastname, String invalid, String password) 
	    {
	    		WebDriverWait wait = new WebDriverWait (webdriver, 60);
	    		WebElement first_name = wait.until(ExpectedConditions.elementToBeClickable(fname));
	    		WebElement last_name = wait.until(ExpectedConditions.elementToBeClickable(lname));
	    		WebElement invalidemail = wait.until(ExpectedConditions.elementToBeClickable(electronicmail));
	    		WebElement pass_word = wait.until(ExpectedConditions.elementToBeClickable(pwd));
	    		WebElement submitbtn = wait.until(ExpectedConditions.elementToBeClickable(submit));
			
		    first_name.click();
		    first_name.clear();
		    first_name.sendKeys(firstname);
		    
		    last_name.click();
		    last_name.clear();
		    last_name.sendKeys(lastname);
		    
		    invalidemail.click();
		    invalidemail.clear();
		    invalidemail.sendKeys(invalid);
		    
		    pass_word.click();
		    pass_word.clear();
		    pass_word.sendKeys(password);
		    
	        submitbtn.click();	    	    
          
	        wait.until(ExpectedConditions.presenceOfElementLocated(invalidemailerrmsg));
	        String invalidmsg = webdriver.findElement(invalidemailerrmsg).getText();
	        
	    	    log.info("Got invalid email message: "+invalidmsg);

	    	    return invalidmsg;
	    	
	    }
	    
	    
	    public static String testDuplicateEmail (WebDriver webdriver, String firstname, String lastname, String duplicate, String password)
	    {
	    		WebDriverWait wait = new WebDriverWait (webdriver, 60);
	    		WebElement first_name = wait.until(ExpectedConditions.elementToBeClickable(fname));
	    		WebElement last_name = wait.until(ExpectedConditions.elementToBeClickable(lname));
	    		WebElement duplicateemail = wait.until(ExpectedConditions.elementToBeClickable(electronicmail));
	    		WebElement pass_word = wait.until(ExpectedConditions.elementToBeClickable(pwd));
	    		WebElement submitbtn = wait.until(ExpectedConditions.elementToBeClickable(submit));
			
		    first_name.click();
		    first_name.clear();
		    first_name.sendKeys(firstname);
		    
		    last_name.click();
		    last_name.clear();
		    last_name.sendKeys(lastname);
		    
		    duplicateemail.click();
		    duplicateemail.clear();
		    duplicateemail.sendKeys(duplicate);
		    
		    pass_word.click();
		    pass_word.clear();
		    pass_word.sendKeys(password);
		    
		    WebElement pwdhint = wait.until(ExpectedConditions.elementToBeClickable(pwdregistrationhint));
		    pwdhint.click();
		    
	        submitbtn.click();	    	    
          
	        wait.until(ExpectedConditions.presenceOfElementLocated(duplicateemailerrmsg));
	        String duplicatemsg = webdriver.findElement(duplicateemailerrmsg).getText();
	        
	    	    log.info("Got duplicate email message: "+duplicatemsg);

	    	    return duplicatemsg;
	    	
	    }
	    
	    
	    public static String testInvalidPassword (WebDriver webdriver, String firstname, String lastname, String email, String not8characters) 
	    {
	    		WebDriverWait wait = new WebDriverWait (webdriver, 60);
	    		WebElement first_name = wait.until(ExpectedConditions.elementToBeClickable(fname));
	    		WebElement last_name = wait.until(ExpectedConditions.elementToBeClickable(lname));
	    		WebElement validemail = wait.until(ExpectedConditions.elementToBeClickable(electronicmail));
	    		WebElement pass_word = wait.until(ExpectedConditions.elementToBeClickable(pwd));
	    		WebElement submitbtn = wait.until(ExpectedConditions.elementToBeClickable(submit));
			
		    first_name.click();
		    first_name.clear();
		    first_name.sendKeys(firstname);
		    
		    last_name.click();
		    last_name.clear();
		    last_name.sendKeys(lastname);
		    
		    validemail.click();
		    validemail.clear();
		    validemail.sendKeys(email);
		    
		    pass_word.click();
		    pass_word.clear();
		    pass_word.sendKeys(not8characters);
		    
	        submitbtn.click();	  
          
	        wait.until(ExpectedConditions.presenceOfElementLocated(pwdreqheader));
	        wait.until(ExpectedConditions.presenceOfElementLocated(eightcharsreq));
	        String pwderrmsg1 = webdriver.findElement(pwdreqheader).getText();
	        String pwderrmsg2 = webdriver.findElement(eightcharsreq).getText();
	        String pwderrmsg = pwderrmsg1+" "+pwderrmsg2;
	        
	    	    log.info("Got password requirement message: "+pwderrmsg);

	    	    return pwderrmsg;
	    	
	    }
	    
	    public static String [] testSignUpNewUser (WebDriver webdriver, String firstname, String lastname, String email, String password) 
	    {
	    		WebDriverWait wait = new WebDriverWait (webdriver, 60);
	    		WebElement first_name = wait.until(ExpectedConditions.elementToBeClickable(fname));
	    		WebElement last_name = wait.until(ExpectedConditions.elementToBeClickable(lname));
	    		WebElement validemail = wait.until(ExpectedConditions.elementToBeClickable(electronicmail));
	    		WebElement pass_word = wait.until(ExpectedConditions.elementToBeClickable(pwd));
	    		WebElement submitbtn = wait.until(ExpectedConditions.elementToBeClickable(submit));
			
		    first_name.click();
		    first_name.clear();
		    first_name.sendKeys(firstname);
		    
		    last_name.click();
		    last_name.clear();
		    last_name.sendKeys(lastname);
		    
		    String [] emailarray = email.split("@");
		    
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyyHHmmss");
			LocalDateTime now = LocalDateTime.now();
		    String append = dtf.format(now).toString();
		    
		    String newemail = emailarray[0]+"+"+append+"@"+emailarray[1];
		    
		    log.info(newemail);
		    
		    validemail.click();
		    validemail.clear();
		    validemail.sendKeys(newemail);
		    
		    pass_word.click();
		    pass_word.clear();
		    pass_word.sendKeys(password);
		    
	        submitbtn.click();	  
         
	        //Wait a bit for it to signin
			webdriver.manage().timeouts().implicitlyWait(30,TimeUnit.MILLISECONDS);
	        //Have to switch to defaultContent or can't find future elements/objects
	        webdriver.switchTo().defaultContent();
	        
            wait.until(ExpectedConditions.presenceOfElementLocated(verifysignedup));
            WebElement newuser = webdriver.findElement(verifysignedup);
            String signedupusername = newuser.getText();
            log.info("Signed up user name is: "+signedupusername);
            
            String [] signuparray = {newemail, signedupusername};
	    	    return signuparray ;
	    	
	    }
	    
	}

