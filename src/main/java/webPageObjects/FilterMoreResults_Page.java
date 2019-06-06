package webPageObjects;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterMoreResults_Page {
	
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Apr 2018  ***//
	//***                                  ***//
	//****************************************//
	final static Logger log = LogManager.getLogger(FilterMoreResults_Page.class);

	static By openmorefilters = By.cssSelector("button#criteria-toggle-filters>div.ddbtn-criteria-label.r-more-button>span.dd-info");
	static By morefiltersscreen = By.id("dd-criteria-filters-menu"); //have to click on this filters screen before you can scroll down to reach other elements
	static By savesearchbtn = By.cssSelector("div#criteria-filters-savesearch-bar>button");
	static By applybtn = By.id("filters-submit");
	static By uncheckedforsale = By.cssSelector("label.checkbox.label-status-forsale>span.status-chkbox");//don't include the next level input tag or else it fails, clickable at span level only
	static By uncheckedpending = By.cssSelector("label.checkbox.label-status-pending>span.status-chkbox");
	static By uncheckedsold = By.cssSelector("label.checkbox.label-status-sold>span.status-chkbox");
	static By checkedforsale = By.cssSelector("label.checkbox.label-status-forsale>span.status-chkbox.active");//don't include the next level input tag or else it fails, clickable at span level only
	static By checkedpending = By.cssSelector("label.checkbox.label-status-pending>span.status-chkbox.active");
	static By checkedsold = By.cssSelector("label.checkbox.label-status-sold>span.status-chkbox.active");
	static By minsquarefeet = By.cssSelector("button[data-id='filters-sqftmin']>span.filter-option.pull-left");
	static By maxsquarefeet = By.cssSelector("button[data-id='filters-sqftmax']>span.filter-option.pull-left");
	static By minsqftmenuopen = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(1)>div>div>ul");
	static By maxsqftmenuopen = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(3)>div>div>ul");
	static By minfilteryear = By.cssSelector("button[data-id='filters-minyearbuilt']>span.filter-option.pull-left");
	static By maxfilteryear = By.cssSelector("button[data-id='filters-maxyearbuilt']>span.filter-option.pull-left");
	static By minyrmenuopen = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(1)>div>div>ul");
	static By maxyrmenuopen = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(3)>div>div>ul");
	static By search_keyword = By.id("filters-keyword");
	static By propertydescription = By.cssSelector("div#property-description>div.details-info.details-text-data");
	static By propertytyperesidential = By.cssSelector("div.fieldset-icon-inputs>label.checkbox.label-proptype-residential>span.proptype-toggler.js-proptype-toggler");
	static By propertytypecommercial = By.cssSelector("div.fieldset-icon-inputs>label.checkbox.label-proptype-commercial>span.proptype-toggler.js-proptype-toggler");
	static By propertytypeland = By.cssSelector("div.fieldset-icon-inputs>label.checkbox.label-proptype-land>span.proptype-toggler.js-proptype-toggler");
	static By propertytypemultifamily = By.cssSelector("div.fieldset-icon-inputs>label.checkbox.label-proptype-multifamily>span.proptype-toggler.js-proptype-toggler");
	static By propertytyperesidential_selected = By.cssSelector("div.fieldset-icon-inputs>label.checkbox.label-proptype-residential>span.proptype-toggler.js-proptype-toggler.active");
	static By propertytypecommercial_selected = By.cssSelector("div.fieldset-icon-inputs>label.checkbox.label-proptype-commercial>span.proptype-toggler.js-proptype-toggler.active");
	static By propertytypeland_selected = By.cssSelector("div.fieldset-icon-inputs>label.checkbox.label-proptype-land>span.proptype-toggler.js-proptype-toggler.active");
	static By propertytypemultifamily_selected = By.cssSelector("div.fieldset-icon-inputs>label.checkbox.label-proptype-multifamily>span.proptype-toggler.js-proptype-toggler.active");
    static By residentialoptionsinglefamily = By.cssSelector("div.fieldset-icon-inputs>label.checkbox.label-hometype-singlefamily>span.hometype-toggler");
    static By residentialoptionsinglefamily_selected = By.cssSelector("div.fieldset-icon-inputs>label.checkbox.label-hometype-singlefamily>span.hometype-toggler.active");
    static By residentialoptioncondo = By.cssSelector("div.fieldset-icon-inputs>label.checkbox.label-hometype-condo>span.hometype-toggler");
    static By residentialoptioncondo_selected = By.cssSelector("div.fieldset-icon-inputs>label.checkbox.label-hometype-condo>span.hometype-toggler.active");
    static By residentialoptionfarm = By.cssSelector("div.fieldset-icon-inputs>label.checkbox.label-hometype-farm>span.hometype-toggler");
    static By residentialoptionfarm_selected = By.cssSelector("div.fieldset-icon-inputs>label.checkbox.label-hometype-farm>span.hometype-toggler.active");
    static By residentialoptionmobilehome = By.cssSelector("div.fieldset-icon-inputs>label.checkbox.label-hometype-mobilehome>span.hometype-toggle");
    static By residentialoptionmobilehome_selected = By.cssSelector("div.fieldset-icon-inputs>label.checkbox.label-hometype-mobilehome>span.hometype-toggler.active");
    static By residentialoptionother = By.cssSelector("div.fieldset-icon-inputs>label.checkbox.label-hometype-other>span.hometype-toggler");
    static By residentialoptionother_selected = By.cssSelector("div.fieldset-icon-inputs>label.checkbox.label-hometype-other>span.hometype-toggler.active");
	
    
    
	static By filtertoprowbuttonarea = By.className("criteria-filters-button-row");
	static By resultspagetoprowarea = By.className("criteria-basicsearch-row-2");
	
	
	static By property1pending = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(1)>div.ribbons>span.ribbon-forsale.ribbon.Pending");
	static By property2pending = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div.ribbons>span.ribbon-forsale.ribbon.Pending");
	static By property3pending = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(1)>div:nth-of-type(1)>div.ribbons>span.ribbon-forsale.ribbon.Pending");
	static By property4pending = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(1)>div:nth-of-type(1)>div.ribbons>span.ribbon-forsale.ribbon.Pending");
	static By property5pending = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(5)>div:nth-of-type(1)>div:nth-of-type(1)>div.ribbons>span.ribbon-forsale.ribbon.Pending");
	
	static By property1sold = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(1)>div.ribbons>span.ribbon-sold.ribbon");
	static By property2sold = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div.ribbons>span.ribbon-sold.ribbon");
	static By property3sold = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(1)>div:nth-of-type(1)>div.ribbons>span.ribbon-sold.ribbon");
	static By property4sold = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(1)>div:nth-of-type(1)>div.ribbons>span.ribbon-sold.ribbon");
	static By property5sold = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(5)>div:nth-of-type(1)>div:nth-of-type(1)>div.ribbons>span.ribbon-sold.ribbon");
	
	static By property1sqft = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>div>span");
	static By property2sqft = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>div>span");
	static By property3sqft = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>div>span");
	static By property4sqft = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>div>span");
	static By property5sqft = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(5)>div:nth-of-type(1)>div:nth-of-type(1)>div.attribs>div>span");

	static By noproperty1pic = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(1)>div.singleprop-media>a>div.photo-gallery-no-photo>img");
	static By property1pic = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(2)>a>div:nth-of-type(3)>div>img");
	static By property3pic = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(2)>a>div:nth-of-type(3)>div>img");
	static By property8pic = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(8)>div:nth-of-type(2)>a>div:nth-of-type(3)>div>img");
	static By detailspage_year = By.cssSelector("div#mls-yr2>span");
	static By detailspage_propertytype = By.cssSelector("div#mls-propt2>span:nth-of-type(1)");
	static By nextlistingbutton = By.id("navBar_view_next_listing");
		
	static String allunchecked = "";
	static String diditfilter ="";
	static int prop1_yr;
	static int prop2_yr;
	static int prop3_yr;
	static int prop4_yr;
	static int prop5_yr;
	static String prop1_description;
	static String prop2_description;
	static String prop3_description;
	static String prop4_description;
	static String prop5_description;
	static String prop1_proptype;
	static String prop2_proptype;
	static String prop3_proptype;
	static String prop4_proptype;
	static String prop5_proptype;
	
	public static void uncheckedAllStatus (WebDriver webdriver) 
	{

		List<WebElement> is4salechecked = webdriver.findElements(checkedforsale);
		List<WebElement> ispendingchecked = webdriver.findElements(checkedpending);
		List<WebElement> issoldchecked = webdriver.findElements(checkedsold);
		
		int is4salecheckedsize = is4salechecked.size();
		int ispendingcheckedsize = ispendingchecked.size();
		int issoldcheckedsize = issoldchecked.size();
		
		String forsale_unchecked = "";
		String pending_unchecked = "";
		String sold_unchecked = "";
		
		//Don't just use three if else if size > 0, it won't run correctly, have to use this way
		
		while (!allunchecked.equalsIgnoreCase("yes"))
		{
			if (is4salecheckedsize > 0)
			{
				WebElement checkedforsaleelement = webdriver.findElement(checkedforsale);
				Actions action = new Actions(webdriver);
				action.moveToElement(checkedforsaleelement).click().perform();
				forsale_unchecked= "yes";
			}
			else
			{
				forsale_unchecked= "yes";
			}
			
			if (ispendingcheckedsize > 0)
			{
				WebElement checkedpendingelement = webdriver.findElement(checkedpending);
				Actions action = new Actions(webdriver);
				action.moveToElement(checkedpendingelement).click().perform();
				pending_unchecked= "yes";
			}
			else
			{
				pending_unchecked= "yes";
			}
			
			if (issoldcheckedsize > 0)
			{
				WebElement checkedsoldelement = webdriver.findElement(checkedsold);
				Actions action = new Actions(webdriver);
				action.moveToElement(checkedsoldelement).click().perform();
				sold_unchecked = "yes";
			}
			else
			{
				sold_unchecked = "yes";
			}
			
			if (forsale_unchecked.equalsIgnoreCase("yes") && pending_unchecked.equalsIgnoreCase("yes") && sold_unchecked.equalsIgnoreCase("yes"))
			{
			    allunchecked="yes";
			}
			else
			{
				allunchecked="no";
			}
		}	
		
		allunchecked = "";  //need to reset this back to blank for next test to use this method

		
	}

	public static void clickOpenMoreFilters (WebDriver webdriver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait (webdriver, 60);
		WebElement morefiltersdrpdown = wait.until(ExpectedConditions.elementToBeClickable(openmorefilters));
		morefiltersdrpdown.click();
		
		Thread.sleep(4000); //Must wait for this time to load
	}
	
	public static void filterByPendingStatus (WebDriver webdriver) throws InterruptedException
	{	
		WebDriverWait wait = new WebDriverWait (webdriver, 60);
		WebElement uncheckedpendingelement = wait.until(ExpectedConditions.presenceOfElementLocated(uncheckedpending));
		Actions action = new Actions(webdriver);
		action.moveToElement(uncheckedpendingelement).click().perform();
		Thread.sleep(4000); //Must wait for this time to load
	}
	
	public static void filterBySoldStatus (WebDriver webdriver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait (webdriver, 60);
		WebElement uncheckedsoldelement = wait.until(ExpectedConditions.presenceOfElementLocated(uncheckedsold));
		Actions action = new Actions(webdriver);
		action.moveToElement(uncheckedsoldelement).click().perform();	
		Thread.sleep(4000); //Must wait for this time to load
	}
	
	public static void filterByForSaleStatus (WebDriver webdriver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait (webdriver, 60);
		WebElement uncheckedforsaleelement = wait.until(ExpectedConditions.presenceOfElementLocated(uncheckedforsale));
		Actions action = new Actions(webdriver);
		action.moveToElement(uncheckedforsaleelement).click().perform();
		Thread.sleep(4000); //Must wait for this time to load
	}
	
	public static void applyMoreFilters (WebDriver webdriver) throws InterruptedException 
	{
		WebElement applybtnelement = webdriver.findElement(applybtn);
		((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", applybtnelement);
	    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", applybtnelement);
	    
	    Thread.sleep(4000); //Must wait for this time to load
	    
	    //Have to scroll back to the top for cases like filter by square feet
	    ((JavascriptExecutor)webdriver).executeScript("scroll(500,0)");
		Thread.sleep(1000);
	
	}
	
	public static String verifyFilterByPendingStatus (WebDriver webdriver)
	{	
		WebDriverWait wait = new WebDriverWait (webdriver, 60);
		WebElement property1pendingelement = wait.until(ExpectedConditions.presenceOfElementLocated(property1pending));
		String pendingtext = property1pendingelement.getText();
		
		if (pendingtext.equalsIgnoreCase("PENDING"))
		{
			diditfilter="yes";
			log.info("It filtered by pending status correctly.");
		}
		else
		{
			diditfilter="no";
			log.info("It filtered by pending status incorrectly.");
		}
		
		return diditfilter;
	}
	
	public static String verifyFilterBySoldStatus (WebDriver webdriver)
	{	
		WebDriverWait wait = new WebDriverWait (webdriver, 60);
		WebElement property1soldelement = wait.until(ExpectedConditions.presenceOfElementLocated(property1sold));
		String soldtext = property1soldelement.getText();
		
		if (soldtext.equalsIgnoreCase("SOLD"))
		{
			diditfilter="yes";
			log.info("It filtered by sold status correctly.");
		}
		else
		{
			diditfilter="no";
			log.info("It filtered by sold status incorrectly.");
		}
		
		return diditfilter;
	}
	
	public static String verifyFilterByForSaleStatus (WebDriver webdriver)
	{	
		List <WebElement> pendingiconlist = webdriver.findElements(property1pending);
		List <WebElement> soldiconlist = webdriver.findElements(property1sold);

		int pendingiconsize = pendingiconlist.size();
		int soldiconsize = soldiconlist.size();
		
		if ((pendingiconsize == 0) && (soldiconsize == 0))
		{
			diditfilter="yes";
			log.info("It filtered by for sale status correctly.");
		}
		else
		{
			diditfilter="no";
			log.info("It filtered by for sale status incorrectly.");
		}
		
		return diditfilter;
	}
	
	public static void filterBySqFeet (WebDriver webdriver, String minsqfeet, String maxsqfeet) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait (webdriver, 60);
		WebElement minsquarefeetelement = wait.until(ExpectedConditions.elementToBeClickable(minsquarefeet));
		minsquarefeetelement.click();
		
		switch (minsqfeet)
		{
			case "500": 
			By minsqft1 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='1']>a>span.text");
			WebElement minsqft1element = webdriver.findElement(minsqft1);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minsqft1element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minsqft1element);
			break;
			
			case "750":
			By minsqft2 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='2']>a>span.text");
			WebElement minsqft2element = webdriver.findElement(minsqft2);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minsqft2element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minsqft2element);
			break;
			
			case "1000":
			By minsqft3 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='3']>a>span.text");
			WebElement minsqft3element = webdriver.findElement(minsqft3);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minsqft3element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minsqft3element);
			break;
			
			case "1250":
			By minsqft4 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='4']>a>span.text");
			WebElement minsqft4element = webdriver.findElement(minsqft4);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minsqft4element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minsqft4element);
			break;
			
			case "1500":
			By minsqft5 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='5']>a>span.text");
			WebElement minsqft5element = webdriver.findElement(minsqft5);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minsqft5element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minsqft5element);
			break;
			
			case "1750":
			By minsqft6 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='6']>a>span.text");
			WebElement minsqft6element = webdriver.findElement(minsqft6);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minsqft6element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minsqft6element);
			break;
			
			case "2000":
			By minsqft7 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='7']>a>span.text");
			WebElement minsqft7element = webdriver.findElement(minsqft7);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minsqft7element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minsqft7element);
			break;
	
			case "2250":
			By minsqft8 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='8']>a>span.text");
			WebElement minsqft8element = webdriver.findElement(minsqft8);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minsqft8element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minsqft8element);
			break;
			
			case "2500":
			By minsqft9 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='9']>a>span.text");
			WebElement minsqft9element = webdriver.findElement(minsqft9);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minsqft9element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minsqft9element);
			break;
			
			case "2750":
			By minsqft10 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='10']>a>span.text");
			WebElement minsqft10element = webdriver.findElement(minsqft10);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minsqft10element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minsqft10element);
			break;
			
			case "3000":
			By minsqft11 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='11']>a>span.text");
			WebElement minsqft11element = webdriver.findElement(minsqft11);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minsqft11element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minsqft11element);
			break;
			
			case "3500":
			By minsqft12 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='12']>a>span.text");
			WebElement minsqft12element = webdriver.findElement(minsqft12);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minsqft12element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minsqft12element);
			break;
			
			case "4000":
			By minsqft13 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='13']>a>span.text");
			WebElement minsqft13element = webdriver.findElement(minsqft13);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minsqft13element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minsqft13element);
			break;
			
			case "5000":
			By minsqft14 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='14']>a>span.text");
			WebElement minsqft14element = webdriver.findElement(minsqft14);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minsqft14element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minsqft14element);
			break;
			
			case "7500":
			By minsqft15 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='15']>a>span.text");
			WebElement minsqft15element = webdriver.findElement(minsqft15);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minsqft15element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minsqft15element);
			break;
		}
		
		Thread.sleep(1000); //wait for it to load selection
	    
		WebElement maxsquarefeetelement = wait.until(ExpectedConditions.elementToBeClickable(maxsquarefeet));
		maxsquarefeetelement.click();
		WebElement maxsqftmenuopenelement = wait.until(ExpectedConditions.presenceOfElementLocated(maxsqftmenuopen));
		Actions action = new Actions(webdriver);
		action.moveToElement(maxsqftmenuopenelement).perform();
		
		
		Thread.sleep(1000); //wait for it to load selection

		switch (maxsqfeet)
		{
			case "500": 
			By maxsqft1 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='1']>a>span.text");
			WebElement maxsqft1element = webdriver.findElement(maxsqft1);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxsqft1element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxsqft1element);
			break;
			
			case "750":
			By maxsqft2 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='2']>a>span.text");
			WebElement maxsqft2element = webdriver.findElement(maxsqft2);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxsqft2element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxsqft2element);
			break;
			
			case "1000":
			By maxsqft3 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='3']>a>span.text");
			WebElement maxsqft3element = webdriver.findElement(maxsqft3);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxsqft3element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxsqft3element);
			break;
			
			case "1250":
			By maxsqft4 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='4']>a>span.text");
			WebElement maxsqft4element = webdriver.findElement(maxsqft4);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxsqft4element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxsqft4element);
			break;
			
			case "1500":
			By maxsqft5 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='5']>a>span.text");
			WebElement maxsqft5element = webdriver.findElement(maxsqft5);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxsqft5element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxsqft5element);
			break;
			
			case "1750":
			By maxsqft6 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='6']>a>span.text");
			WebElement maxsqft6element = webdriver.findElement(maxsqft6);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxsqft6element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxsqft6element);
			break;
			
			case "2000":
			By maxsqft7 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='7']>a>span.text");
			WebElement maxsqft7element = webdriver.findElement(maxsqft7);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxsqft7element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxsqft7element);
			break;
	
			case "2250":
			By maxsqft8 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='8']>a>span.text");
			WebElement maxsqft8element = webdriver.findElement(maxsqft8);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxsqft8element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxsqft8element);
			break;
			
			case "2500":
			By maxsqft9 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='9']>a>span.text");
			WebElement maxsqft9element = webdriver.findElement(maxsqft9);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxsqft9element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxsqft9element);
			break;
			
			case "2750":
			By maxsqft10 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='10']>a>span.text");
			WebElement maxsqft10element = webdriver.findElement(maxsqft10);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxsqft10element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxsqft10element);
			break;
			
			case "3000":
			By maxsqft11 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='11']>a>span.text");
			WebElement maxsqft11element = webdriver.findElement(maxsqft11);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxsqft11element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxsqft11element);
			break;
			
			case "3500":
			By maxsqft12 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='12']>a>span.text");
			WebElement maxsqft12element = webdriver.findElement(maxsqft12);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxsqft12element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxsqft12element);
			break;
			
			case "4000":
			By maxsqft13 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='13']>a>span.text");
			WebElement maxsqft13element = webdriver.findElement(maxsqft13);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxsqft13element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxsqft13element);
			break;
			
			case "5000":
			By maxsqft14 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='14']>a>span.text");
			WebElement maxsqft14element = webdriver.findElement(maxsqft14);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxsqft14element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxsqft14element);
			break;
			
			case "7500":
			By maxsqft15 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-sqft>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='15']>a>span.text");
			WebElement maxsqft15element = webdriver.findElement(maxsqft15);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxsqft15element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxsqft15element);
			break;
		}
		
		Thread.sleep(4000); //wait for it to load selection
	    
		WebElement filtertoprowbuttonareaelement = webdriver.findElement(filtertoprowbuttonarea);
		((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", filtertoprowbuttonareaelement);

	}
	
	public static String verifyFilterBySqFeet (WebDriver webdriver, String minsqfeet, String maxsqfeet) throws InterruptedException
	{
		int min_sqft = Integer.parseInt(minsqfeet);
		int max_sqft = Integer.parseInt(maxsqfeet);
		WebDriverWait wait = new WebDriverWait (webdriver, 60);
		
		WebElement property1sqftelement = wait.until(ExpectedConditions.presenceOfElementLocated(property1sqft));
		String prop1sqft = property1sqftelement.getText().replaceAll(",", "");
		int prop1_sqft = Integer.parseInt(prop1sqft);
		
		WebElement property2sqftelement = wait.until(ExpectedConditions.presenceOfElementLocated(property2sqft));
		String prop2sqft = property2sqftelement.getText().replaceAll(",", "");
		int prop2_sqft = Integer.parseInt(prop2sqft);
		
		WebElement property3sqftelement = wait.until(ExpectedConditions.presenceOfElementLocated(property3sqft));
		String prop3sqft = property3sqftelement.getText().replaceAll(",", "");
		int prop3_sqft = Integer.parseInt(prop3sqft);
		
		WebElement property4sqftelement = wait.until(ExpectedConditions.presenceOfElementLocated(property4sqft));
		String prop4sqft = property4sqftelement.getText().replaceAll(",", "");
		int prop4_sqft = Integer.parseInt(prop4sqft);
		
		WebElement property5sqftelement = wait.until(ExpectedConditions.presenceOfElementLocated(property5sqft));
		String prop5sqft = property5sqftelement.getText().replaceAll(",", "");
		int prop5_sqft = Integer.parseInt(prop5sqft);
		
		if ((prop1_sqft >= min_sqft) && (prop1_sqft <= max_sqft) && (prop2_sqft >= min_sqft) && (prop2_sqft <= max_sqft) && (prop3_sqft >= min_sqft) && (prop3_sqft <= max_sqft) && (prop4_sqft >= min_sqft) && (prop4_sqft <= max_sqft) && (prop5_sqft >= min_sqft) && (prop5_sqft <= max_sqft))
		{
			diditfilter="yes";
			log.info("It filtered by square feet correctly");
		}
		else
	    {
			diditfilter="no";
			log.info("It filtered by square feet incorrectly");
		}
		return diditfilter;
	}
	
	
	public static void filterByYear (WebDriver webdriver, String minyear, String maxyear) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait (webdriver, 60);
		WebElement minfilteryearelement = wait.until(ExpectedConditions.elementToBeClickable(minfilteryear));
		minfilteryearelement.click();
		
		switch (minyear)
		{
			case "2017":
			By minyr1 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='1']>a>span.text");
			WebElement minyr1element = webdriver.findElement(minyr1);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minyr1element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minyr1element);
			break;
			
			case "2016":
			By minyr2 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='2']>a>span.text");
			WebElement minyr2element = webdriver.findElement(minyr2);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minyr2element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minyr2element);
			break;
			
			case "2015":
			By minyr3 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='3']>a>span.text");
			WebElement minyr3element = webdriver.findElement(minyr3);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minyr3element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minyr3element);
			break;
			
			case "2014":
			By minyr4 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='4']>a>span.text");
			WebElement minyr4element = webdriver.findElement(minyr4);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minyr4element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minyr4element);
			break;
			
			case "2005":
			By minyr5 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='5']>a>span.text");
			WebElement minyr5element = webdriver.findElement(minyr5);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minyr5element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minyr5element);
			break;
			
			case "2000":
			By minyr6 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='6']>a>span.text");
			WebElement minyr6element = webdriver.findElement(minyr6);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minyr6element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minyr6element);
			break;
			
			case "1995":
			By minyr7 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='7']>a>span.text");
			WebElement minyr7element = webdriver.findElement(minyr7);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minyr7element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minyr7element);
			break;
	
			case "1990":
			By minyr8 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='8']>a>span.text");
			WebElement minyr8element = webdriver.findElement(minyr8);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minyr8element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minyr8element);
			break;
			
			case "1980":
			By minyr9 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='9']>a>span.text");
			WebElement minyr9element = webdriver.findElement(minyr9);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minyr9element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minyr9element);
			break;
			
			case "1970":
			By minyr10 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='10']>a>span.text");
			WebElement minyr10element = webdriver.findElement(minyr10);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minyr10element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minyr10element);
			break;
			
			case "1960":
			By minyr11 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='11']>a>span.text");
			WebElement minyr11element = webdriver.findElement(minyr11);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minyr11element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minyr11element);
			break;
			
			case "1950":
			By minyr12 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='12']>a>span.text");
			WebElement minyr12element = webdriver.findElement(minyr12);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minyr12element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minyr12element);
			break;
			
			case "1940":
			By minyr13 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='13']>a>span.text");
			WebElement minyr13element = webdriver.findElement(minyr13);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minyr13element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minyr13element);
			break;
			
			case "1920":
			By minyr14 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='14']>a>span.text");
			WebElement minyr14element = webdriver.findElement(minyr14);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minyr14element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minyr14element);
			break;
			
			case "1900":
			By minyr15 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(1)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='15']>a>span.text");
			WebElement minyr15element = webdriver.findElement(minyr15);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", minyr15element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", minyr15element);
			break;
		}
		
		Thread.sleep(1000); //wait for it to load selection
	    
		WebElement maxfilteryearelement = wait.until(ExpectedConditions.elementToBeClickable(maxfilteryear));
		maxfilteryearelement.click();
		WebElement maxyrmenuopenelement = wait.until(ExpectedConditions.presenceOfElementLocated(maxyrmenuopen));
		Actions action = new Actions(webdriver);
		action.moveToElement(maxyrmenuopenelement).perform();
		
		
		Thread.sleep(1000); //wait for it to load selection

		switch (maxyear)
		{
			case "2017": 
			By maxyr1 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='1']>a>span.text");
			WebElement maxyr1element = webdriver.findElement(maxyr1);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxyr1element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxyr1element);
			break;
			
			case "2016":
			By maxyr2 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='2']>a>span.text");
			WebElement maxyr2element = webdriver.findElement(maxyr2);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxyr2element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxyr2element);
			break;
			
			case "2015":
			By maxyr3 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='3']>a>span.text");
			WebElement maxyr3element = webdriver.findElement(maxyr3);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxyr3element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxyr3element);
			break;
			
			case "2014":
			By maxyr4 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='4']>a>span.text");
			WebElement maxyr4element = webdriver.findElement(maxyr4);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxyr4element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxyr4element);
			break;
			
			case "2005":
			By maxyr5 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='5']>a>span.text");
			WebElement maxyr5element = webdriver.findElement(maxyr5);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxyr5element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxyr5element);
			break;
			
			case "2000":
			By maxyr6 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='6']>a>span.text");
			WebElement maxyr6element = webdriver.findElement(maxyr6);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxyr6element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxyr6element);
			break;
			
			case "1995":
			By maxyr7 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='7']>a>span.text");
			WebElement maxyr7element = webdriver.findElement(maxyr7);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxyr7element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxyr7element);
			break;
	
			case "1990":
			By maxyr8 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='8']>a>span.text");
			WebElement maxyr8element = webdriver.findElement(maxyr8);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxyr8element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxyr8element);
			break;
			
			case "1980":
			By maxyr9 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='9']>a>span.text");
			WebElement maxyr9element = webdriver.findElement(maxyr9);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxyr9element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxyr9element);
			break;
			
			case "1970":
			By maxyr10 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='10']>a>span.text");
			WebElement maxyr10element = webdriver.findElement(maxyr10);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxyr10element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxyr10element);
			break;
			
			case "1960":
			By maxyr11 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='11']>a>span.text");
			WebElement maxyr11element = webdriver.findElement(maxyr11);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxyr11element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxyr11element);
			break;
			
			case "1950":
			By maxyr12 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='12']>a>span.text");
			WebElement maxyr12element = webdriver.findElement(maxyr12);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxyr12element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxyr12element);
			break;
			
			case "1940":
			By maxyr13 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='13']>a>span.text");
			WebElement maxyr13element = webdriver.findElement(maxyr13);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxyr13element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxyr13element);
			break;
			
			case "1920":
			By maxyr14 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='14']>a>span.text");
			WebElement maxyr14element = webdriver.findElement(maxyr14);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxyr14element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxyr14element);
			break;
			
			case "1900":
			By maxyr15 = By.cssSelector("#criteria-filters-table>fieldset.fieldset-container.fieldset-grid.fieldset-year>div>div.filters-row>label:nth-child(3)>div>div.dropdown-menu.open>ul.dropdown-menu.inner>li[data-original-index='15']>a>span.text");
			WebElement maxyr15element = webdriver.findElement(maxyr15);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", maxyr15element);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", maxyr15element);
			break;
		}
		
		Thread.sleep(4000); //wait for it to load selection
	    
		WebElement filtertoprowbuttonareaelement = webdriver.findElement(filtertoprowbuttonarea);
		((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", filtertoprowbuttonareaelement);

	}

	public static String verifyFilterByYear (WebDriver webdriver, String minyear, String maxyear) throws InterruptedException
	{
		int min_yr = Integer.parseInt(minyear);
		int max_yr = Integer.parseInt(maxyear);
		String propyr="";
		int prop_yr;
		
		WebDriverWait wait = new WebDriverWait (webdriver, 60);
		
		//Click open the first property's image to go to details page
		List <WebElement> prop1_nopic = webdriver.findElements(noproperty1pic);
		int prop1nopicsize = prop1_nopic.size();
		
		//If first property has no pic, size=1, true, then go the 8th property and click its pic
		if (prop1nopicsize == 1)
		{
			WebElement property8picelement = wait.until(ExpectedConditions.elementToBeClickable(property8pic));
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", property8picelement);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", property8picelement);
		}
		else
		{
			WebElement property1picelement = wait.until(ExpectedConditions.elementToBeClickable(property1pic));
			property1picelement.click();
		}
		
		Thread.sleep(4000); //Wait for details page to load
		
		for (int i=1; i<6; i++)
		{
			WebElement detailspage_yearelement = webdriver.findElement(detailspage_year);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", detailspage_yearelement);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", detailspage_yearelement);
			propyr = detailspage_yearelement.getText();
			prop_yr = Integer.parseInt(propyr);
			
			switch (i)
			{
				case 1: prop1_yr=prop_yr;
				        break;
				case 2: prop2_yr=prop_yr;
		        			break;
				case 3: prop3_yr=prop_yr;
		        			break;
				case 4: prop4_yr=prop_yr;
		        			break;
				case 5: prop5_yr=prop_yr;
		        			break;
				 
			}
			
			WebElement nextlistingbtn = wait.until(ExpectedConditions.elementToBeClickable(nextlistingbutton));
			nextlistingbtn.click();
			
			
		}
		
		log.info("min year: "+min_yr);
		log.info("max year "+max_yr);
		log.info("prop1_year is : "+prop1_yr);
		log.info("prop2_year is : "+prop2_yr);
		log.info("prop3_year is : "+prop3_yr);
		log.info("prop4_year is : "+prop4_yr);
		log.info("prop5_year is : "+prop5_yr);
		
		if ((prop1_yr >= min_yr) && (prop1_yr <= max_yr) && (prop2_yr >= min_yr) && (prop2_yr <= max_yr) && (prop3_yr >= min_yr) && (prop3_yr <= max_yr) && (prop4_yr >= min_yr) && (prop4_yr <= max_yr) && (prop5_yr >= min_yr) && (prop5_yr <= max_yr))
		{
			diditfilter="yes";
			log.info("It filtered by year correctly");
		}
		else
	    {
			diditfilter="no";
			log.info("It filtered by year incorrectly");
		}
		return diditfilter;
	}

	
	public static void filterByKeyword (WebDriver webdriver, String keyword) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait (webdriver, 60);
		WebElement search_keywordelement = wait.until(ExpectedConditions.elementToBeClickable(search_keyword));
		search_keywordelement.click();
		search_keywordelement.clear();
		search_keywordelement.sendKeys(keyword);
	}
	
	public static String verifyFilterByKeyword (WebDriver webdriver, String keyword) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait (webdriver, 60);

		//Click open the first property's image to go to details page
		List <WebElement> prop1_nopic = webdriver.findElements(noproperty1pic);
		int prop1nopicsize = prop1_nopic.size();
		
		//If first property has no pic, size=1, true, then go the 8th property and click its pic
		if (prop1nopicsize == 1)
		{
			WebElement property8picelement = wait.until(ExpectedConditions.elementToBeClickable(property8pic));
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", property8picelement);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", property8picelement);
		    log.info("verify filter keyword - first property has no pic.");
		}
		else
		{
			WebElement property1picelement = wait.until(ExpectedConditions.elementToBeClickable(property1pic));
			property1picelement.click();
		    log.info("verify filter keyword - first property has pic.");
		}
		
		Thread.sleep(4000); //Wait for details page to load
		
		for (int i=1; i<6; i++)
		{
			WebElement propertydescriptionelement = webdriver.findElement(propertydescription);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", propertydescriptionelement);
			String propdescription = propertydescriptionelement.getText();
		    log.info("verify filter keyword - scroll property description text into view.");
		    
			    //Need this because keyword can be used in the details page in uppercase or lowercase
				if (Pattern.compile(Pattern.quote(keyword), Pattern.CASE_INSENSITIVE).matcher(propdescription).find())
				{
					switch (i)
					{
						case 1: prop1_description ="yes";
						        break;
						case 2: prop2_description ="yes";
				        			break;
						case 3: prop3_description ="yes";
				        			break;
						case 4: prop4_description ="yes";
				        			break;
						case 5: prop5_description ="yes";
				        			break;
					}
					
				    		log.info("verify filter keyword - scroll through properties description has keyword.");
					try
					{
					    WebElement nextlistingbtn = wait.until(ExpectedConditions.elementToBeClickable(nextlistingbutton));
						nextlistingbtn.click();
					}
					catch (Exception e)
					{
					    log.info("verify filter keyword - A property doesn't have matching keyword in description so it can't scroll into next property.");
					    break;
					}
				}
				else
				{
					switch (i)
					{
						case 1: prop1_description ="no";
						        break;
						case 2: prop2_description ="no";
				        			break;
						case 3: prop3_description ="no";
				        			break;
						case 4: prop4_description ="no";
				        			break;
						case 5: prop5_description ="no";
				        			break;
					}
					
				}
			}
		
		log.info("search keyword: "+keyword);
		log.info("prop1_description matches: "+prop1_description);
		log.info("prop2_description matches: "+prop2_description);
		log.info("prop3_description matches: "+prop3_description);
		log.info("prop4_description matches: "+prop4_description);
		log.info("prop5_description matches: "+prop5_description);
		
		if ((prop1_description.equalsIgnoreCase("yes")) && (prop2_description.equalsIgnoreCase("yes")) && (prop3_description.equalsIgnoreCase("yes")) && (prop4_description.equalsIgnoreCase("yes")) && (prop5_description.equalsIgnoreCase("yes")))
		{
			diditfilter="yes";
			log.info("It filtered by keyword correctly");
		}
		else
	    {
			diditfilter="no";
			log.info("It filtered by keyword incorrectly");
		}
		
		return diditfilter;
	
	}
	
		
	public static void uncheckAllPropertyType (WebDriver webdriver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait (webdriver, 60);
		
		List <WebElement> residentialprop = webdriver.findElements(propertytyperesidential_selected);
		List <WebElement> commercialprop = webdriver.findElements(propertytypecommercial_selected);
		List <WebElement> landprop = webdriver.findElements(propertytypeland_selected);		
		List <WebElement> multifamilyprop = webdriver.findElements(propertytypemultifamily_selected);
		
		int residentialpropsize = residentialprop.size();
		int commercialpropsize = commercialprop.size();
		int landproppropsize = landprop.size();
		int multifamilypropsize = multifamilyprop.size();

		String residentialunchecked = "";
		String commercialunchecked = "";
		String landunchecked = "";
		String multifamilyunchecked = "";
		
		//Don't just use four if else if size > 0, it won't run correctly, have to use this way
		
		while (!allunchecked.equalsIgnoreCase("yes"))
		{
				//If selected property type, click it to unselect it
				if (residentialpropsize > 0)
				{
					WebElement propertytyperesidentialelement = wait.until(ExpectedConditions.elementToBeClickable(propertytyperesidential_selected));
					Actions action = new Actions(webdriver);
			        action.moveToElement(propertytyperesidentialelement).click().perform();
			        residentialunchecked = "yes";
				}
				else //If already not checked
				{
					residentialunchecked = "yes";
				}
				
				if (commercialpropsize > 0)
				{
					WebElement propertytypecommercialelement = wait.until(ExpectedConditions.elementToBeClickable(propertytypecommercial_selected));
			        Actions action = new Actions(webdriver);
			        action.moveToElement(propertytypecommercialelement).click().perform();
			        commercialunchecked = "yes";
				}
				else
				{
			        commercialunchecked = "yes";
				}
				
				if (landproppropsize > 0)
				{
					WebElement propertytypelandelement = wait.until(ExpectedConditions.elementToBeClickable(propertytypeland_selected));
			        Actions action = new Actions(webdriver);
			        action.moveToElement(propertytypelandelement).click().perform();
			        landunchecked = "yes";
				}
				else
				{
			        landunchecked = "yes";
				}
				
				
				if (multifamilypropsize > 0)
				{
					WebElement propertytypemultifamilyelement = wait.until(ExpectedConditions.elementToBeClickable(propertytypemultifamily_selected));
			        Actions action = new Actions(webdriver);
			        action.moveToElement(propertytypemultifamilyelement).click().perform();
			        multifamilyunchecked = "yes";
				}
				else
				{
			        multifamilyunchecked = "yes";
				}
				
				
				if ( (residentialunchecked.equalsIgnoreCase("yes")) && (commercialunchecked.equalsIgnoreCase("yes")) && (landunchecked.equalsIgnoreCase("yes")) && (multifamilyunchecked.equalsIgnoreCase("yes")) )
				{
					allunchecked="yes";
				}
				else
				{
					allunchecked="no";
				}
					
		}
		
		allunchecked = "";  //need to reset this back to blank for next test to use this method
	}
	
	public static void filterByPropertyTypeLand (WebDriver webdriver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait (webdriver, 60);
		WebElement property_land = wait.until(ExpectedConditions.elementToBeClickable(propertytypeland));
        Actions action = new Actions(webdriver);
        action.moveToElement(property_land).click().perform();
	}
	

	public static String verifyFilterByPropertyTypeLand (WebDriver webdriver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait (webdriver, 60);

		//Click open the first property's image to go to details page
		List <WebElement> prop1_nopic = webdriver.findElements(noproperty1pic);
		int prop1nopicsize = prop1_nopic.size();
		
		//If first property has no pic, size=1, true, then go the 8th property and click its pic
		if (prop1nopicsize == 1)
		{
			WebElement property3picelement = wait.until(ExpectedConditions.elementToBeClickable(property3pic));
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", property3picelement);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", property3picelement);
		}
		else
		{
			WebElement property1picelement = wait.until(ExpectedConditions.elementToBeClickable(property1pic));
			property1picelement.click();
		}
		
		Thread.sleep(4000); //Wait for details page to load
		
		for (int i=1; i<6; i++)
		{
			
		    WebElement detailspage_propertytypeelement = webdriver.findElement(detailspage_propertytype);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", detailspage_propertytypeelement);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", detailspage_propertytypeelement);	
			String proptypetext = detailspage_propertytypeelement.getText();
			
				if (proptypetext.contains("Land"))
				{
					switch (i)
					{
						case 1: prop1_proptype ="yes";
						        break;
						case 2: prop2_proptype ="yes";
				        			break;
						case 3: prop3_proptype ="yes";
				        			break;
						case 4: prop4_proptype ="yes";
				        			break;
						case 5: prop5_proptype ="yes";
				        			break;
					}
					
					WebElement nextlistingbtn = wait.until(ExpectedConditions.elementToBeClickable(nextlistingbutton));
					nextlistingbtn.click();
				}
				else
				{
					switch (i)
					{
					case 1: prop1_proptype ="no";
			        			break;
					case 2: prop2_proptype ="no";
			        			break;
					case 3: prop3_proptype ="no";
			        			break;
					case 4: prop4_proptype ="no";
			        			break;
					case 5: prop5_proptype ="no";
			        			break;
					}
				}
			}
		
		log.info("Property type to filter by is Land.");
		log.info("prop1_proptype matches: "+prop1_proptype);
		log.info("prop2_proptype matches: "+prop2_proptype);
		log.info("prop3_proptype matches: "+prop3_proptype);
		log.info("prop4_proptype matches: "+prop4_proptype);
		log.info("prop5_proptype matches: "+prop5_proptype);
		
		if ((prop1_proptype.equalsIgnoreCase("yes")) && (prop2_proptype.equalsIgnoreCase("yes")) && (prop3_proptype.equalsIgnoreCase("yes")) && (prop4_proptype.equalsIgnoreCase("yes")) && (prop5_proptype.equalsIgnoreCase("yes")))
		{
			diditfilter="yes";
			log.info("It filtered by property type correctly");
		}
		else
	    {
			diditfilter="no";
			log.info("It filtered by property type incorrectly");
		}

		return diditfilter;
	}
	
    public static void scrollDownMoreFiltersPage (WebDriver webdriver)
    {
    		WebDriverWait wait = new WebDriverWait(webdriver, 60);
    	    WebElement morefiltersscreen_field = wait.until(ExpectedConditions.presenceOfElementLocated(morefiltersscreen));
    	    Actions action = new Actions (webdriver);
    	    action.moveToElement(morefiltersscreen_field).click().perform();
    	    action.sendKeys(Keys.PAGE_DOWN).perform();
    	    action.sendKeys(Keys.PAGE_DOWN).perform();
    	    action.sendKeys(Keys.PAGE_DOWN).perform();
    }
	

	
	public static void uncheckAllResidentialOptions (WebDriver webdriver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(webdriver, 60);
		
		List <WebElement> singlefamilyoption = webdriver.findElements(residentialoptionsinglefamily_selected);
		List <WebElement> condooption = webdriver.findElements(residentialoptioncondo_selected);
		List <WebElement> farmoption = webdriver.findElements(residentialoptionfarm_selected);		
		List <WebElement> mobileoption = webdriver.findElements(residentialoptionmobilehome_selected);
		List <WebElement> otheroption = webdriver.findElements(residentialoptionother_selected);
		
		int singlefamilyoptionsize = singlefamilyoption.size();
		int condooptionsize = condooption.size();
		int farmoptionsize = farmoption.size();
		int mobileoptionsize = mobileoption.size();
		int otheroptionsize = otheroption.size();
		
		log.info("singlefamilyoptionsize "+singlefamilyoptionsize);
		log.info("condooptionsize "+condooptionsize);
		log.info("farmoptionsize "+farmoptionsize);
		log.info("mobileoptionsize "+mobileoptionsize);
		log.info("otheroptionsize "+otheroptionsize);

		String singlefamilyunchecked = "";
		String condounchecked = "";
		String farmunchecked = "";
		String mobileunchecked = "";
		String otherunchecked = "";
		
		//Don't just use five if else if size > 0, it won't run correctly, have to use this way
		
		while (!allunchecked.equalsIgnoreCase("yes"))
		{
				//If selected property type, click it to unselect it
				if (singlefamilyoptionsize > 0)
				{
					WebElement singlefamilyelement = wait.until(ExpectedConditions.elementToBeClickable(residentialoptionsinglefamily_selected));
					Actions action = new Actions(webdriver);
			        action.moveToElement(singlefamilyelement).click().perform();
			        singlefamilyunchecked = "yes";
				}
				else //If already not checked
				{
					singlefamilyunchecked = "yes";
				}
				
				if (condooptionsize > 0)
				{
					WebElement condoelement = wait.until(ExpectedConditions.elementToBeClickable(residentialoptioncondo_selected));
			        Actions action = new Actions(webdriver);
			        action.moveToElement(condoelement).click().perform();
			        condounchecked = "yes";
				}
				else
				{
					condounchecked = "yes";
				}
				
				if (farmoptionsize > 0)
				{
					WebElement farmelement = wait.until(ExpectedConditions.elementToBeClickable(residentialoptionfarm_selected));
			        Actions action = new Actions(webdriver);
			        action.moveToElement(farmelement).click().perform();
			        farmunchecked = "yes";
				}
				else
				{
			        farmunchecked = "yes";
				}
				
				
				if (mobileoptionsize > 0)
				{
					WebElement mobileelement = wait.until(ExpectedConditions.elementToBeClickable(residentialoptionmobilehome_selected));
			        Actions action = new Actions(webdriver);
			        action.moveToElement(mobileelement).click().perform();
			        mobileunchecked = "yes";
				}
				else
				{
					mobileunchecked = "yes";
				}
				
				if (otheroptionsize > 0)
				{
					WebElement otherelement = wait.until(ExpectedConditions.elementToBeClickable(residentialoptionother_selected));
			        Actions action = new Actions(webdriver);
			        action.moveToElement(otherelement).click().perform();
			        otherunchecked = "yes";
				}
				else
				{
					otherunchecked = "yes";
				}

				
				if ( (singlefamilyunchecked.equalsIgnoreCase("yes")) && (condounchecked.equalsIgnoreCase("yes")) && (farmunchecked.equalsIgnoreCase("yes")) && (mobileunchecked.equalsIgnoreCase("yes")) && (otherunchecked.equalsIgnoreCase("yes")))
				{
					allunchecked="yes";
				}
				else
				{
					allunchecked="no";
				}
					
		}
		
		allunchecked = "";  //need to reset this back to blank for next test to use this method
	}
	
	
	public static void filterBySingleFamily (WebDriver webdriver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait (webdriver, 60);
		WebElement residentialoptionsinglefamilyelement = wait.until(ExpectedConditions.elementToBeClickable(residentialoptionsinglefamily));
		((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", residentialoptionsinglefamilyelement);
	    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", residentialoptionsinglefamilyelement);	
	}

	public static void filterByCondo (WebDriver webdriver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait (webdriver, 60);
		WebElement residentialoptioncondoelement = wait.until(ExpectedConditions.elementToBeClickable(residentialoptioncondo));
		((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", residentialoptioncondoelement);
	    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", residentialoptioncondoelement);	
	}
	
	public static void filterByMobile (WebDriver webdriver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait (webdriver, 60);
		WebElement residentialoptionmobileelement = wait.until(ExpectedConditions.elementToBeClickable(residentialoptionmobilehome));
		((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", residentialoptionmobileelement);
	    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", residentialoptionmobileelement);	
	}
	
	public static String verifyFilterBySingleFamily (WebDriver webdriver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait (webdriver, 60);
		
		//Click open the first property's image to go to details page
		List <WebElement> prop1_nopic = webdriver.findElements(noproperty1pic);
		int prop1nopicsize = prop1_nopic.size();
		
		//If first property has no pic, size=1, true, then go the 8th property and click its pic
		if (prop1nopicsize == 1)
		{
			WebElement property8picelement = wait.until(ExpectedConditions.elementToBeClickable(property8pic));
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", property8picelement);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", property8picelement);
		}
		else
		{
			WebElement property1picelement = wait.until(ExpectedConditions.elementToBeClickable(property1pic));
			property1picelement.click();
		}
		
		Thread.sleep(4000); //Wait for details page to load
		
		for (int i=1; i<6; i++)
		{
			WebElement propertytypeelement = webdriver.findElement(detailspage_propertytype);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", propertytypeelement);
			String proptype = propertytypeelement.getText();
			
				if (proptype.contains("Single Family") || proptype.contains("Townhouse"))
				{
					switch (i)
					{
						case 1: prop1_proptype ="yes";
						        break;
						case 2: prop2_proptype ="yes";
				        			break;
						case 3: prop3_proptype ="yes";
				        			break;
						case 4: prop4_proptype ="yes";
				        			break;
						case 5: prop5_proptype ="yes";
				        			break;
					}
					
					try
					{
						WebElement nextlistingbtn = wait.until(ExpectedConditions.elementToBeClickable(nextlistingbutton));
						nextlistingbtn.click();
					}
					catch (Exception e)
					{
						log.info("Verify FilterMoreResults_Page.verifyFilterByCondo that scrolling through description did not find condo and/or townhouse.");
					}
				}
				else
				{
					switch (i)
					{
						case 1: prop1_proptype ="no";
						        break;
						case 2: prop2_proptype ="no";
				        			break;
						case 3: prop3_proptype ="no";
				        			break;
						case 4: prop4_proptype ="no";
				        			break;
						case 5: prop5_proptype ="no";
				        			break;
					}
				}
			}
		
		log.info("Filter by single family");
		log.info("prop1_proptype matches: "+prop1_proptype);
		log.info("prop2_proptype matches: "+prop2_proptype);
		log.info("prop3_proptype matches: "+prop3_proptype);
		log.info("prop4_proptype matches: "+prop4_proptype);
		log.info("prop5_proptype matches: "+prop5_proptype);
		
		if ((prop1_proptype.equalsIgnoreCase("yes")) && (prop2_proptype.equalsIgnoreCase("yes")) && (prop3_proptype.equalsIgnoreCase("yes")) && (prop4_proptype.equalsIgnoreCase("yes")) && (prop5_proptype.equalsIgnoreCase("yes")))
		{
			diditfilter="yes";
			log.info("It filtered by single family correctly");
		}
		else
	    {
			diditfilter="no";
			log.info("It filtered by single family incorrectly");
		}
		
		
		return diditfilter;
	}

	public static String verifyFilterByCondo (WebDriver webdriver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait (webdriver, 60);
		
		//Click open the first property's image to go to details page
		List <WebElement> prop1_nopic = webdriver.findElements(noproperty1pic);
		int prop1nopicsize = prop1_nopic.size();
		
		//If first property has no pic, size=1, true, then go the 8th property and click its pic
		if (prop1nopicsize == 1)
		{
			WebElement property8picelement = wait.until(ExpectedConditions.elementToBeClickable(property8pic));
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", property8picelement);
		    ((JavascriptExecutor) webdriver).executeScript("arguments[0].click();", property8picelement);
		}
		else
		{
			WebElement property1picelement = wait.until(ExpectedConditions.elementToBeClickable(property1pic));
			property1picelement.click();
		}
		
		Thread.sleep(4000); //Wait for details page to load
		
		for (int i=1; i<6; i++)
		{
			WebElement propertytypeelement = webdriver.findElement(detailspage_propertytype);
			((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", propertytypeelement);
			String proptype = propertytypeelement.getText();
			
				if (proptype.contains("Condo") || proptype.contains("TownHouse") || proptype.contains("Townhouse"))
				{
					switch (i)
					{
						case 1: prop1_proptype ="yes";
						        break;
						case 2: prop2_proptype ="yes";
				        			break;
						case 3: prop3_proptype ="yes";
				        			break;
						case 4: prop4_proptype ="yes";
				        			break;
						case 5: prop5_proptype ="yes";
				        			break;
					}
					
					try
					{
						WebElement nextlistingbtn = wait.until(ExpectedConditions.elementToBeClickable(nextlistingbutton));
						nextlistingbtn.click();
					}
					catch (Exception e)
					{
						log.info("Verify FilterMoreResults_Page.verifyFilterByCondo that scrolling through description did not find condo and/or townhouse.");
					}
				}
				else
				{
					switch (i)
					{
						case 1: prop1_proptype ="no";
						        break;
						case 2: prop2_proptype ="no";
				        			break;
						case 3: prop3_proptype ="no";
				        			break;
						case 4: prop4_proptype ="no";
				        			break;
						case 5: prop5_proptype ="no";
				        			break;
					}
				}
			}
		
		log.info("Filter by condo/townhouse");
		log.info("prop1_proptype matches: "+prop1_proptype);
		log.info("prop2_proptype matches: "+prop2_proptype);
		log.info("prop3_proptype matches: "+prop3_proptype);
		log.info("prop4_proptype matches: "+prop4_proptype);
		log.info("prop5_proptype matches: "+prop5_proptype);
		
		if ((prop1_proptype.equalsIgnoreCase("yes")) && (prop2_proptype.equalsIgnoreCase("yes")) && (prop3_proptype.equalsIgnoreCase("yes")) && (prop4_proptype.equalsIgnoreCase("yes")) && (prop5_proptype.equalsIgnoreCase("yes")))
		{
			diditfilter="yes";
			log.info("It filtered by condo/townhouse correctly");
		}
		else
	    {
			diditfilter="no";
			log.info("It filtered by condo/townhouse incorrectly");
		}
		
		
		return diditfilter;
	}
	
}
