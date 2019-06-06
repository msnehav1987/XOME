package webPageObjects;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.MiscMethods;

public class Search {

	    //****************************************//
		//***                                  ***//
		//*** Created by Angela Tong Apr 2018  ***//
		//***                                  ***//
		//****************************************//
		final static Logger log = LogManager.getLogger(Search.class);
		
		static By xomelogo = By.className("SiteHeadLogo-image");
		static By homepagesearchfield = By.id("homepage-search-field");
		static By searchautocompletebycity = By.cssSelector("div.autocomplete-entry>div.text>span.location");
		static By searchautocompletebyaddress = By.cssSelector("div.autocomplete-entry>div.text>span.name");
		static By searchbutton = By.cssSelector("button.call-to-action.search-field-button");
		static By searchingmsg = By.cssSelector("div#mapsearch-searching-message[style='top: 163.984px']>div#display-message");
		static By nomoresearchingmsg = By.id("div#mapsearch-searching-message[style='top: 163.984px; opacity: 0; display: none;']>div#display-message");	
		
		static By firstsearchresultsaddresss1 = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div>a>h1.address-line-1");//1st house in the list
		static By firstsearchresultsaddresss2 = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div>a>span:nth-of-type(1)");//city
		static By firstsearchresultsaddress3 = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(2)>div>a>span:nth-of-type(2)");//state
		static By afterscrolledaddress1 = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(12)>div:nth-of-type(1)>div:nth-of-type(2)>div>a>h1.address-line-1");//9th house in the list
		static By afterscrolledaddress2 = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(12)>div:nth-of-type(1)>div:nth-of-type(2)>div>a>span:nth-of-type(1)");//city
		static By afterscrolledaddress3 = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(12)>div:nth-of-type(1)>div:nth-of-type(2)>div>a>span:nth-of-type(2)");//state
		static By afterscrolledhousepic = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(12)>div:nth-of-type(2)>a>div:nth-of-type(3)>div>img");
		static By address1inhousepage = By.cssSelector("h1.address-line-1.first-field.bolded");//addressline1 on details page
		static By address2inhousepage = By.cssSelector("div.address-line-2.second-field>span:nth-of-type(1)");//city on details page
		static By address3inhousepage = By.cssSelector("div.address-line-2.second-field>span:nth-of-type(2)");//state on details page
		static By address4inhousepage = By.cssSelector("div.address-line-2.second-field>span:nth-of-type(3)");//zip on details page
		static By totalpics = By.xpath(".//span[@id='ltslide-total']");
		static By picscrollrightbtn = By.cssSelector("i.fa.fa-angle-right");

		static By searchbyaddressresult_address1= By.cssSelector("div.address-line-1.first-field.bolded");
		static By searchbyaddressresult_address2= By.cssSelector("div.address-line-2.second-field");
		
	    public static void searchByCity (WebDriver webdriver, String searchkeyword)
	    {
	    		WebDriverWait wait = new WebDriverWait (webdriver, 60);
	    		WebElement searchbuy = wait.until(ExpectedConditions.elementToBeClickable(homepagesearchfield));
	        searchbuy.click(); 
            searchbuy.clear();
            searchbuy.sendKeys(searchkeyword);
            
            WebElement searchbtn = wait.until(ExpectedConditions.elementToBeClickable(searchbutton));
            searchbtn.click();

		    Boolean presentornot = MiscMethods.isElementPresent(webdriver, searchingmsg);
		    while (presentornot == true)
		    {
		    		Boolean presentornot2 = MiscMethods.isElementPresent(webdriver, searchingmsg);
		    }
            
	    }
	    
	    public static String [] loginsearchfor12thhouseinresults (WebDriver webdriver, String searchkeyword)
	    {
	    		Search.searchByCity(webdriver, searchkeyword); 
	    		
	    	    WebDriverWait wait = new WebDriverWait (webdriver, 60);
            WebElement firstaddress1 = wait.until(ExpectedConditions.elementToBeClickable(firstsearchresultsaddresss1));
            String firstsearchresultsaddress1 = firstaddress1.getText();
            
            WebElement firstaddress2 = wait.until(ExpectedConditions.elementToBeClickable(firstsearchresultsaddresss2));
            String firstsearchresultsaddress2 = firstaddress2.getText();
            
            WebElement firstaddress3 = wait.until(ExpectedConditions.elementToBeClickable(firstsearchresultsaddress3));
            String firstsearchresultsaddress3 = firstaddress3.getText();
            
            String firstsearchresultsaddress = firstsearchresultsaddress1+" "+firstsearchresultsaddress2+", "+firstsearchresultsaddress3;
            
            log.info("First search results address is: "+firstsearchresultsaddress);
            
	    	    WebElement addressafterscrollelement1 = wait.until(ExpectedConditions.presenceOfElementLocated(afterscrolledaddress1));
	    	    ((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView(true);", addressafterscrollelement1);
	    		log.info("Scrolled.");
	    	    WebElement addressafterscrollelement2 = wait.until(ExpectedConditions.presenceOfElementLocated(afterscrolledaddress2));
	    	    WebElement addressafterscrollelement3 = wait.until(ExpectedConditions.presenceOfElementLocated(afterscrolledaddress3));
	    	    
	    	    String addressafterscroll1 =  addressafterscrollelement1.getText();
	    	    String addressafterscroll2 =  addressafterscrollelement2.getText();
	    	    String addressafterscroll3 =  addressafterscrollelement3.getText();
	    	    
	    	    String addressafterscroll = addressafterscroll1+" "+addressafterscroll2+", "+addressafterscroll3;
	    		log.info("addressafterscroll: "+addressafterscroll);
	    		
            String [] housearray = new String [3];
            housearray[0] = firstsearchresultsaddress;
            housearray[1] = addressafterscroll;
            
            WebElement afterscrolled_housepic = wait.until(ExpectedConditions.elementToBeClickable(afterscrolledhousepic));
            afterscrolled_housepic.click();
            webdriver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);//Need some time for page to load in order to be able to locate some elements later.
            
            WebElement address1_inhousepage = wait.until(ExpectedConditions.visibilityOfElementLocated(address1inhousepage));
            WebElement address2_inhouspeage = wait.until(ExpectedConditions.visibilityOfElementLocated(address2inhousepage));
            WebElement address3_inhouspeage = wait.until(ExpectedConditions.visibilityOfElementLocated(address3inhousepage));
             
            String houseaddress1 = address1_inhousepage.getText();
            String houseaddress2 = address2_inhouspeage.getText();
            String houseaddress3 = address3_inhouspeage.getText();
            String houseaddress = houseaddress1+" "+houseaddress2+", "+houseaddress3;
            
            housearray[2] = houseaddress;
            
            log.info("The house address is: "+housearray[2]);

	        webdriver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS); 
            WebElement slidepicscount = wait.until(ExpectedConditions.visibilityOfElementLocated(totalpics));
            String count = slidepicscount.getText();
            log.info("The pic count is: "+count);
            
            int picscount = Integer.parseInt(count);
            
            for (int i = 0; i<picscount; i++)
            {
            	    WebElement scrollright = wait.until(ExpectedConditions.elementToBeClickable(picscrollrightbtn));
            	    scrollright.click();
            }
            
            return housearray;
	    }
	
	    
	    public static void searchSpecificAddress (WebDriver webdriver, String address)
	    {
	    		WebDriverWait wait = new WebDriverWait (webdriver, 60);
	    		WebElement searchbuy = wait.until(ExpectedConditions.elementToBeClickable(homepagesearchfield));
	        searchbuy.click(); 
            searchbuy.clear();
            searchbuy.sendKeys(address);

            WebElement autocomplete = wait.until(ExpectedConditions.elementToBeClickable(searchautocompletebyaddress));
            autocomplete.click();
            
            webdriver.manage().timeouts().implicitlyWait(60,TimeUnit.MILLISECONDS);//Need some time for page to load in order to be able to locate some elements later.
 	       
                
        }
	    
	    public static String searchandVerifyAddressSearched(WebDriver webdriver, String address)
	    {
			Search.searchSpecificAddress(webdriver,address);
			WebDriverWait wait = new WebDriverWait (webdriver, 60);
			WebElement resultaddress1 = wait.until(ExpectedConditions.visibilityOfElementLocated(searchbyaddressresult_address1));
			WebElement resultaddress2 = wait.until(ExpectedConditions.visibilityOfElementLocated(searchbyaddressresult_address2));
			String address1=resultaddress1.getText();
			String address2=resultaddress2.getText();
			String resultaddress=address1+" "+address2;
			log.info("resultaddress is: "+resultaddress);
	    		return resultaddress;
	    	
	    }
	    
}
