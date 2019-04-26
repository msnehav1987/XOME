package webPageObjects;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Gmail {
	
	//Selenium 3.11 doesn't work with actions click for these gmail methods below. I had to revert back to Selenium 3.6.
	//Tested using latest firefox browser 59.0.2 with the same code in both test runs.
	
	        //****************************************//
			//***                                  ***//
			//*** Created by Angela Tong Apr 2018  ***//
			//***                                  ***//
			//****************************************//
			final static Logger log = LogManager.getLogger(Gmail.class);
			
			static By loginemail = By.cssSelector("div.Xb9hP>input.whsOnd.zHQkBf");
			static By nextbtn = By.cssSelector("div#identifierNext>content.CwaK9>span.RveJvd.snByac");
			static By pwd = By.cssSelector("div#password>div.aCsJod.oJeWuf>div.aXBtI.Wic03c>div.Xb9hP>input.whsOnd.zHQkBf");
			static By pwdnextbtn = By.cssSelector("div#passwordNext>content.CwaK9>span.RveJvd.snByac");
			
			static By searchemailfield = By.cssSelector("input#gbqfq");
			static By searchemailbutton = By.cssSelector("button#gbqfb");
			static By emailfrom = By.xpath(".//table[@class='F cf zt']/tbody/tr[1]/td[4]/div[2]/span");
			static By emailtitle = By.cssSelector("table.F.cf.zt>tbody>tr:nth-of-type(1)>td:nth-of-type(6)>div>div>div:nth-of-type(2)>span:nth-of-type(1)>b");
			static By thankyoutext1 = By.xpath("(.//sup[1]/parent::td)[1]");//Thank you for registering for
			//alternate By.cssSelector("td.m_-5217904043742698481message_header3.m_-5217904043742698481content");
		    static By emailtext = By.xpath(".//strong/parent::td"); //Your username is:
			
		    static By moreoptionsdropdownpic = By.cssSelector("img.hA.T-I-J3[role='menu']");
		    static By dropdownoptions = By.cssSelector("div.b7.J-M");
		    static By deletethismessage = By.cssSelector("img.dS.J-N-JX");
		    //static By deleteemailbtn = By.cssSelector("div.T-I.J-J5-Ji.nX.T-I-ax7.T-I-Js-Gs.ar7>div.asa>div.ar9.T-I-J3.J-J5-Ji");
		    static By expandmorebtn = By.cssSelector("span.CJ");
		    static By trashlink = By.cssSelector("div.TO>div>div:nth-of-type(2)>span>a[title='Trash']");
		    static By emptytrashnowlink = By.cssSelector("span.x2[role='button']");
		    static By clickalertdialog = By.cssSelector("div.Kj-JD");
		    static By emptytrashokbtn = By.cssSelector("button.J-at1-auR.J-at1-atl");
		    
		    public static String [] checkRegisterEmail (WebDriver webdriver, String email, String gmailpwd, String gmailsearch) 
		    {
		    		webdriver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Ftab%3Dwm&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		    		WebDriverWait wait = new WebDriverWait (webdriver, 90);
		    		WebElement login = wait.until(ExpectedConditions.elementToBeClickable(loginemail));
		    		WebElement next1 = wait.until(ExpectedConditions.elementToBeClickable(nextbtn));
		        login.clear();
		        login.sendKeys(email);
			    next1.click();
			    
			    WebElement password = wait.until(ExpectedConditions.elementToBeClickable(pwd));
			    password.click();
			    password.clear();
			    password.sendKeys(gmailpwd);
			    WebElement next2 = wait.until(ExpectedConditions.elementToBeClickable(pwdnextbtn));
			    next2.click();
			    
			    WebElement search_field = wait.until(ExpectedConditions.elementToBeClickable(searchemailfield));
			    WebElement searchbtn = wait.until(ExpectedConditions.elementToBeClickable(searchemailbutton));
			    search_field.click();
			    search_field.clear();
			    search_field.sendKeys(gmailsearch);
			    searchbtn.click();
			    
			    
			    //Wait up to 3 minutes for registration email to come into gmail inbox.
			    
			    WebDriverWait wait2 = new WebDriverWait (webdriver, 240);
			    WebElement email_from = wait2.until(ExpectedConditions.presenceOfElementLocated(emailfrom));
			    WebElement email_title = wait2.until(ExpectedConditions.elementToBeClickable(emailtitle));
			    
			    String xomename = email_from.getAttribute("innerHTML");
			    String welcometoxome = email_title.getText();
			    
			    String [] emailarray = new String [4];
			    emailarray[0] = xomename;
			    emailarray[1]= welcometoxome;
			    
			    email_title.click();
			    
			    WebElement thankyou1 = wait.until(ExpectedConditions.presenceOfElementLocated(thankyoutext1));
			    WebElement yourusernameis = wait.until(ExpectedConditions.presenceOfElementLocated(emailtext));
			    
			    String thanks = thankyou1.getText();
			    String yourusername = yourusernameis.getText();
	    
			    emailarray[2] = thanks;
			    emailarray[3] = yourusername;
			    
			    return emailarray;
			    
		    }
		    

		    public static void deleteGmail (WebDriver webdriver) 
		    {
	    			WebDriverWait wait = new WebDriverWait (webdriver, 60);
	    			WebElement moreoptionsdropdownbtn = wait.until(ExpectedConditions.elementToBeClickable(moreoptionsdropdownpic));
	    			moreoptionsdropdownbtn.click();
	    			
	    			webdriver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
	    			WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(dropdownoptions));
	    		    Actions action = new Actions(webdriver);
			    action.moveToElement(dropdown).perform();
			    action.sendKeys(Keys.ARROW_DOWN);
			    action.sendKeys(Keys.ARROW_DOWN);
			    action.sendKeys(Keys.ARROW_DOWN);
			    action.sendKeys(Keys.ARROW_DOWN);
			    action.sendKeys(Keys.ARROW_DOWN);
			    action.sendKeys(Keys.ARROW_DOWN);
			    action.sendKeys(Keys.ARROW_DOWN).click().perform();

    			    webdriver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);

		    	    WebElement expandbtn = wait.until(ExpectedConditions.presenceOfElementLocated(expandmorebtn));
		    	    action.moveToElement(expandbtn).click().perform();
	    			webdriver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS); //needed wait time so it can eventually click the trash link or else it clicks the spam link
			    action.sendKeys(Keys.ARROW_DOWN);
			    WebElement trash_link = wait.until(ExpectedConditions.presenceOfElementLocated(trashlink));
	    	    		action.moveToElement(trash_link).click().perform();
	    			webdriver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
	    	    		
		    	    WebElement emptytrashnow = wait.until(ExpectedConditions.elementToBeClickable(emptytrashnowlink));
		    	    emptytrashnow.click();
    			    webdriver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS); //needed wait time so it can eventually click the ok to delete btn
    			    
		    	    WebElement emptytrashok_btn = wait.until(ExpectedConditions.elementToBeClickable(emptytrashokbtn));
		    	    emptytrashok_btn.click();

		    }
		    
}
