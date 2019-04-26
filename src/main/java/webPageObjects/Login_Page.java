package webPageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page {
	
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Apr 2018  ***//
	//***                                  ***//
	//****************************************//
	final static Logger log = LogManager.getLogger(Login_Page.class);
	
	static By signinlink = By.cssSelector("a.LinkButton.btn.btn-secondary");
	static By emaillogin = By.id("security_loginname");
	static By pwdlogin = By.id("security_password");
	static By submitbtn = By.cssSelector("input.btn.btn-primary");
	static By emailpwddoesntmatchtext = By.cssSelector("div.row-fluid.errorMessageBox.errorMessageBoxServerSide>ul>li"); //Oops, the e-mail or password doesn't match.
	static By onemoreloginchancetext = By.cssSelector("div.row-fluid.errorMessageBox.errorMessageBoxServerSide>ul>li"); //You have 1 more login attempt before your account is locked. Please enter your login credentials properly, reset your password by clicking the \"Forgot your password ? \" link or contact Customer Service at 1-844-400-9663 for assistance.
	static By verifysignedin = By.cssSelector("div.user-section.authenticated>div.NavSubmenu.btn-group>div.NavSubmenu-button>span.NavItem.top-level.user-menu>span");
	
	
    public static void clickSignIn (WebDriver webdriver)
    {
    		WebDriverWait wait = new WebDriverWait (webdriver, 60);
    		WebElement signin = wait.until(ExpectedConditions.elementToBeClickable(signinlink));
        signin.click(); 
	    WebElement iframeSwitch = webdriver.findElement(By.id("login-iframe"));
	    webdriver.switchTo().frame(iframeSwitch);
    }

    
    public static String signinBlankFields (WebDriver webdriver)
    {
    		WebDriverWait wait = new WebDriverWait (webdriver, 60);
		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(submitbtn));
    		
        submit.click();
        
    		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(emaillogin));
        String fieldisrequired = email.getAttribute("required");
        
	    log.info("Check email field is required: "+fieldisrequired);

	    return fieldisrequired;
    }
    
    public static String signinBlankEmail (WebDriver webdriver, String password)
    {
    		WebDriverWait wait = new WebDriverWait (webdriver, 60);
    		WebElement email = wait.until(ExpectedConditions.presenceOfElementLocated(emaillogin));
    		WebElement pwd = wait.until(ExpectedConditions.elementToBeClickable(pwdlogin));
    		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(submitbtn));
        pwd.click();
    		pwd.clear();
        pwd.sendKeys(password);

        submit.click();
	    
        String fieldisrequired = email.getAttribute("required");
        
	    log.info("Check email field is required: "+fieldisrequired);

	    return fieldisrequired;
    }
    
    public static String signinBlankPwd (WebDriver webdriver, String login)
    {
    		WebDriverWait wait = new WebDriverWait (webdriver, 60);
    		WebElement email = wait.until(ExpectedConditions.elementToBeClickable(emaillogin));
    		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(submitbtn));
        email.click();
    		email.clear();
        email.sendKeys(login);

        submit.click();
	    
        
        WebElement emailpwd_doesntmatchtext = wait.until(ExpectedConditions.presenceOfElementLocated(emailpwddoesntmatchtext));
        String wrongemailpwdtext = emailpwd_doesntmatchtext.getText();
        
	    log.info("Check wrong email pwd text: "+wrongemailpwdtext);

	    return wrongemailpwdtext;
    }
    
    public static String signinWrongPwd (WebDriver webdriver, String login, String password)
    {
    		WebDriverWait wait = new WebDriverWait (webdriver, 60);
    		WebElement email = wait.until(ExpectedConditions.elementToBeClickable(emaillogin));
    		WebElement pwd = wait.until(ExpectedConditions.elementToBeClickable(pwdlogin));
    		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(submitbtn));
        email.click();
    		email.clear();
        email.sendKeys(login);
        
        pwd.click();
        pwd.clear();
        pwd.sendKeys(password);

        submit.click();
	    
    		WebElement wrongpwd_text = wait.until(ExpectedConditions.presenceOfElementLocated(emailpwddoesntmatchtext));
        String wrongemailpwdtext = wrongpwd_text.getText();
        
	    log.info("Wrong password text is : "+wrongemailpwdtext);

	    return wrongemailpwdtext;
    }
    
    public static String login (WebDriver webdriver, String login, String password) throws InterruptedException
    {
    		WebDriverWait wait = new WebDriverWait (webdriver, 60);
    		WebElement email = wait.until(ExpectedConditions.elementToBeClickable(emaillogin));
    		WebElement pwd = wait.until(ExpectedConditions.elementToBeClickable(pwdlogin));
    		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(submitbtn));
        email.click();
    		email.clear();
        email.sendKeys(login);
        
        pwd.click();
        pwd.clear();
        pwd.sendKeys(password);

        submit.click();
        
        //Wait a bit for it to signin
        Thread.sleep(30);
        //Have to switch to defaultContent or can't find future elements/objects
        webdriver.switchTo().defaultContent();
        
        wait.until(ExpectedConditions.presenceOfElementLocated(verifysignedin));
        WebElement signedinuser = webdriver.findElement(verifysignedin);
        String signedinusername = signedinuser.getText();
        log.info("Signed in user name is: "+signedinusername);

        return signedinusername;
    }
    
}
