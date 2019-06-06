package webPageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterResults_Page {
	
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Apr 2018  ***//
	//***                                  ***//
	//****************************************//
	final static Logger log = LogManager.getLogger(FilterResults_Page.class);
	
	static By anypricedropdown = By.id("ddbtn-criteria-pricerange");
	static By minpricefield = By.id("mapsearch-criteria-minprice");
	static By maxpricefield = By.id("mapsearch-criteria-maxprice");
	
	static By priceautosuggestion = By.cssSelector("li.ac_even.ac_over"); 
	
    static By anybedsdropdown = By.id("ddbtn-criteria-beds");
    static By selectedbedsdrpdown = By.cssSelector("button#ddbtn-criteria-beds>div.ddbtn-criteria-label>span");
	
	static By anybathsdropdown = By.id("ddbtn-criteria-baths");
    static By selectedbathsdrpdown = By.cssSelector("button#ddbtn-criteria-baths>div.ddbtn-criteria-label>span");
	
	static By sortbyclicktoexpanddrpdown = By.cssSelector("div.search-results-sorter>div.btn-group.bootstrap-select>button.btn.dropdown-toggle.btn-default>span.filter-option.pull-left");
	static By dropdownarea = By.cssSelector("div.btn-group.bootstrap-select.open>div.dropdown-menu.open");
	static By sortbydropdownmostrecent = By.cssSelector("div.search-results-sorter>div.btn-group.bootstrap-select.open>div.dropdown-menu.open>ul.dropdown-menu.inner>li:nth-of-type(1)>a>span.text");
	static By sortbydropdownprice = By.cssSelector("div.search-results-sorter>div.btn-group.bootstrap-select.open>div.dropdown-menu.open>ul.dropdown-menu.inner>li:nth-of-type(2)>a>span.text");
	static By sortbydropdownbeds = By.cssSelector("div.search-results-sorter>div.btn-group.bootstrap-select.open>div.dropdown-menu.open>ul.dropdown-menu.inner>li:nth-of-type(3)>a>span.text");
	static By sortbydropdownbaths = By.cssSelector("div.search-results-sorter>div.btn-group.bootstrap-select.open>div.dropdown-menu.open>ul.dropdown-menu.inner>li:nth-of-type(4)>a>span.text");
	static By sortasc = By.cssSelector("button#search-results-sortdir"); //>i.fa.fa-long-arrow-up");
	static By sortdesc = By.cssSelector("button#search-results-sortdir"); //>i.fa.fa-long-arrow-down");

	
	static By property1price = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(1)>div.price>span");
	
	static By property1bed = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>span:nth-of-type(1)");
	static By property2bed = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>span:nth-of-type(1)");
	static By property3bed = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>span:nth-of-type(1)");
	static By property4bed = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>span:nth-of-type(1)");
	static By property5bed = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(5)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>span:nth-of-type(1)");
	static By property6bed = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(6)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>span:nth-of-type(1)");
	static By property7bed = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(7)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>span:nth-of-type(1)");
	static By property8bed = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(8)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>span:nth-of-type(1)");
	static By property9bed = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(9)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>span:nth-of-type(1)");
	static By property10bed = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(10)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>span:nth-of-type(1)");
    
	static By property1bath = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>span:nth-of-type(2)");
	static By property2bath = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>span:nth-of-type(2)");
	static By property3bath = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>span:nth-of-type(2)");
	static By property4bath = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>span:nth-of-type(2)");
	static By property5bath = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(5)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>span:nth-of-type(2)");
	static By property6bath = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(6)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>span:nth-of-type(2)");
	static By property7bath = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(7)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>span:nth-of-type(2)");
	static By property8bath = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(8)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>span:nth-of-type(2)");
	static By property9bath = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(9)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>span:nth-of-type(2)");
	static By property10bath = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(10)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>span:nth-of-type(2)");
    
	static String diditfilter ="";
	
	public static void filterByPrice (WebDriver webdriver, String price1, String price2) throws InterruptedException 
	{
		
		WebDriverWait wait = new WebDriverWait (webdriver, 60);
		WebElement pricedrpdown = wait.until(ExpectedConditions.elementToBeClickable(anypricedropdown));
		pricedrpdown.click();
		
		Actions action = new Actions(webdriver);
		WebElement minprice = wait.until(ExpectedConditions.elementToBeClickable(minpricefield));
		action.moveToElement(minprice).click().perform();
		action.sendKeys(price1).perform();
		Thread.sleep(1000); //Needed to wait a little or won't be able to arrow down
        action.sendKeys(Keys.ARROW_DOWN).perform();
		WebElement pautosuggestion1 = wait.until(ExpectedConditions.elementToBeClickable(priceautosuggestion));
		action.moveToElement(pautosuggestion1).click().perform();
		
		WebElement maxprice = wait.until(ExpectedConditions.elementToBeClickable(maxpricefield));
		action.moveToElement(maxprice).click().perform();
		action.sendKeys(price2).perform();
		Thread.sleep(1000); //Needed to wait a little or won't be able to arrow down
        action.sendKeys(Keys.ARROW_DOWN).perform();
		WebElement pautosuggestion2 = wait.until(ExpectedConditions.elementToBeClickable(priceautosuggestion));
		action.moveToElement(pautosuggestion2).click().perform();
		
		pricedrpdown.click();
		
		WebElement clicksortby = wait.until(ExpectedConditions.elementToBeClickable(sortbyclicktoexpanddrpdown));
		clicksortby.click();

		Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
		
		WebElement dropdownareabox = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownarea));
	    action.moveToElement(dropdownareabox).perform();
	    action.sendKeys(Keys.ARROW_DOWN);
	    action.sendKeys(Keys.ARROW_DOWN);
		WebElement clicksortbyprice = wait.until(ExpectedConditions.elementToBeClickable(sortbydropdownprice));
		//first click price sorts by descending order, 2nd click on the arrow then sorts by ascending order
	    action.moveToElement(clicksortbyprice).click().perform();
	    
	    Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
	}
	
    public static String verifyFilterByPrice (WebDriver webdriver, String price1, String price2) throws InterruptedException 
	{
    		WebDriverWait wait = new WebDriverWait (webdriver, 60);
	    WebElement property1_price = wait.until(ExpectedConditions.presenceOfElementLocated(property1price));
	   
	    String highestprice = property1_price.getText(); 
	    highestprice=highestprice.replaceAll(",", "");
	    String highest_price = highestprice.substring(1);
	    int prop1pricemax = Integer.parseInt(highest_price);
	    

		log.info("Filter results max price is "+highestprice+"\n");
		
		WebElement uparrow = wait.until(ExpectedConditions.elementToBeClickable(sortasc));
		uparrow.click(); //first click price sorts by descending order, 2nd click on the arrow then sorts by ascending order
			
		Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
		
		WebElement property1_price2 = wait.until(ExpectedConditions.presenceOfElementLocated(property1price));   
		String lowestprice = property1_price2.getText(); 
	    lowestprice=lowestprice.replaceAll(",", "");
	    String lowest_price = lowestprice.substring(1);
	    int prop1pricemin = Integer.parseInt(lowest_price);
	    
		log.info("Filter results min price is "+lowestprice+"\n");
		
		int searchminprice = Integer.parseInt(price1.replaceAll(",", ""));
		int searchmaxprice = Integer.parseInt(price2.replaceAll(",", ""));
		
		log.info("Search for price between "+searchminprice+" and "+searchmaxprice +"\n");
	    
		if ((prop1pricemin >= searchminprice) && (prop1pricemax <= searchmaxprice) )
		{
			 log.info("It filtered by price correctly.");
		     diditfilter = "yes";
		}
		else
		{
			 log.info("It filtered by price incorrectly.");
			diditfilter = "no";
		}
		return diditfilter;
	 
    }

	public static void filterByBeds (WebDriver webdriver, String bed) throws InterruptedException 
    {

	    String i = bed;
	    int j = Integer.parseInt(i) + 1;
		By numberofbeds = By.cssSelector("ul#dd-criteria-beds>li:nth-of-type("+j+")"); //Have to add 1 to count the first bed selection of any
		
		WebDriverWait wait = new WebDriverWait(webdriver, 60);
		WebElement beddrpdown = wait.until(ExpectedConditions.elementToBeClickable(anybedsdropdown));
		beddrpdown.click();
		
		Thread.sleep(4000); //Must wait for this time to load	
		
		WebElement beds = wait.until(ExpectedConditions.presenceOfElementLocated(numberofbeds));
		Actions action = new Actions(webdriver);
		action.moveToElement(beds).click().perform();

		Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
    }
	
	public static String verifyFilterByBeds (WebDriver webdriver, String bed) throws InterruptedException 
    {
		WebDriverWait wait = new WebDriverWait(webdriver, 60);
		WebElement prop1bed = wait.until(ExpectedConditions.presenceOfElementLocated(property1bed));
		WebElement prop2bed = wait.until(ExpectedConditions.presenceOfElementLocated(property2bed));
		WebElement prop3bed = wait.until(ExpectedConditions.presenceOfElementLocated(property3bed));
		WebElement prop4bed = wait.until(ExpectedConditions.presenceOfElementLocated(property4bed));
		WebElement prop5bed = wait.until(ExpectedConditions.presenceOfElementLocated(property5bed));
		
		String numofbeds1 = prop1bed.getText().replaceAll(" Bd", "");
		String numofbeds2 = prop2bed.getText().replaceAll(" Bd", "");
		String numofbeds3 = prop3bed.getText().replaceAll(" Bd", "");
		String numofbeds4 = prop4bed.getText().replaceAll(" Bd", "");
		String numofbeds5 = prop5bed.getText().replaceAll(" Bd", "");
		
		int beds1 = Integer.parseInt(numofbeds1);
		int beds2 = Integer.parseInt(numofbeds2);
		int beds3 = Integer.parseInt(numofbeds3);
		int beds4 = Integer.parseInt(numofbeds4);
		int beds5 = Integer.parseInt(numofbeds5);
		int originalbed = Integer.parseInt(bed);
		
		WebElement selectedbeds = wait.until(ExpectedConditions.presenceOfElementLocated(selectedbedsdrpdown));
		String selectedbedsdrpdowntext  = selectedbeds.getText(); 
		
		
		if ((selectedbedsdrpdowntext.equalsIgnoreCase("3+ Beds"))&&(beds1 >= originalbed) && (beds2 >= originalbed) && (beds3 >= originalbed) && (beds4 >= originalbed) && (beds5 >= originalbed))
		{
			diditfilter = "yes";
			log.info("It filtered by beds correctly.");
		}
		else
		{
			diditfilter = "no";
			log.info("It filtered by beds incorrectly.");
		}


		
		return diditfilter;
	 
    }
	
	public static void filterByBaths (WebDriver webdriver, String bath) throws InterruptedException 
    {
		String i = bath;
	    int j = Integer.parseInt(i) + 1;
		By numberofbaths = By.cssSelector("ul#dd-criteria-baths>li:nth-of-type("+j+")"); //Have to add 1 to count the first bed selection of any
		
		WebDriverWait wait = new WebDriverWait(webdriver, 60);
		WebElement bathdrpdown = wait.until(ExpectedConditions.elementToBeClickable(anybathsdropdown));
		bathdrpdown.click();
		
		Thread.sleep(4000); //Must wait for this time to load	
		
		WebElement baths = wait.until(ExpectedConditions.presenceOfElementLocated(numberofbaths));
		Actions action = new Actions(webdriver);
		action.moveToElement(baths).click().perform();

		Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
    }
	
	public static String verifyFilterByBaths (WebDriver webdriver, String bath) throws InterruptedException 
    {
		WebDriverWait wait = new WebDriverWait(webdriver, 60);
		WebElement prop1bath = wait.until(ExpectedConditions.presenceOfElementLocated(property1bath));
		WebElement prop2bath = wait.until(ExpectedConditions.presenceOfElementLocated(property2bath));
		WebElement prop3bath = wait.until(ExpectedConditions.presenceOfElementLocated(property3bath));
		WebElement prop4bath = wait.until(ExpectedConditions.presenceOfElementLocated(property4bath));
		WebElement prop5bath = wait.until(ExpectedConditions.presenceOfElementLocated(property5bath));
		
		String numofbaths1 = prop1bath.getText().replaceAll(" Ba", "");
		numofbaths1 = numofbaths1.replaceAll(" Full/1 Half", "");
        numofbaths1 = numofbaths1.replaceAll(" Full", "");
        
		String numofbaths2 = prop2bath.getText().replaceAll(" Ba", "");
		numofbaths2 = numofbaths2.replaceAll(" Full/1 Half", "");
        numofbaths2 = numofbaths2.replaceAll(" Full", "");
        
		String numofbaths3 = prop3bath.getText().replaceAll(" Ba", "");
		numofbaths3 = numofbaths3.replaceAll(" Full/1 Half", "");
        numofbaths3 = numofbaths3.replaceAll(" Full", "");
        
		String numofbaths4 = prop4bath.getText().replaceAll(" Ba", "");
		numofbaths4 = numofbaths4.replaceAll(" Full/1 Half", "");
        numofbaths4 = numofbaths4.replaceAll(" Full", "");
        
		String numofbaths5 = prop5bath.getText().replaceAll(" Ba", "");
		numofbaths5 = numofbaths5.replaceAll(" Full/1 Half", "");
        numofbaths5 = numofbaths5.replaceAll(" Full", "");

		int baths1 = Integer.parseInt(numofbaths1);
		int baths2 = Integer.parseInt(numofbaths2);
		int baths3 = Integer.parseInt(numofbaths3);
		int baths4 = Integer.parseInt(numofbaths4);
		int baths5 = Integer.parseInt(numofbaths5);
		int originalbath = Integer.parseInt(bath);
		
		WebElement selectedbaths = wait.until(ExpectedConditions.presenceOfElementLocated(selectedbathsdrpdown));
		String selectedbathsdrpdowntext  = selectedbaths.getText(); 
		
		
		if ((selectedbathsdrpdowntext.equalsIgnoreCase("3+ Baths"))&&(baths1 >= originalbath) && (baths2 >= originalbath) && (baths3 >= originalbath) && (baths4 >= originalbath) && (baths5 >= originalbath))
		{
			diditfilter = "yes";
			log.info("It filtered by baths correctly.");
		}
		else
		{
			diditfilter = "no";
			log.info("It filtered by baths incorrectly.");
		}


		
		return diditfilter;
	 
	 
    }
	
}
