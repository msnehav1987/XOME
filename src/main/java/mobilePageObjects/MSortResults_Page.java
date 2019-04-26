package mobilePageObjects;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;

public class MSortResults_Page {
	//****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Apr 2018  ***//
	//***                                  ***//
	//****************************************//
	final static Logger log = LogManager.getLogger(MSortResults_Page.class);

	static By sortoption = By.id("com.xome.android:id/tvSortOption");
	static By mostrecent = By.xpath(".//android.widget.CheckedTextView[@text='Most Recent']");
	static By pricelowtohigh = By.xpath(".//android.widget.CheckedTextView[@text='Price, Low to High']");
	static By pricehightolow = By.xpath(".//android.widget.CheckedTextView[@text='Price, High to Low']");
	static By beds = By.xpath(".//android.widget.CheckedTextView[@text='Beds']");
	static By baths = By.xpath(".//android.widget.CheckedTextView[@text='Baths']");
	static By squarefeet = By.xpath(".//android.widget.CheckedTextView[@text='Square Feet']");
	
	static By propertyprice = By.id("com.xome.android:id/listing_summary_price_textView");
	static By propertybed = By.id("com.xome.android:id/listing_summary_bedrooms_textView");
	static By propertybath = By.id("com.xome.android:id/listing_summary_bathrooms_textView");
	static By propertysquarefeet = By.id("com.xome.android:id/listing_summary_square_feet_textView");
	static By property1newtag = By.xpath(".//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout/android.widget.RelativeLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@text='NEW']");
	static By property2newtag = By.xpath(".//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout/android.widget.RelativeLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@text='NEW']");
	static By property3newtag = By.xpath(".//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[@index='2']/android.widget.RelativeLayout/android.widget.RelativeLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@text='NEW']");
	static By property1openhousetag = By.xpath(".//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout/android.widget.RelativeLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@text='OPEN HOUSE']");
	static By property2openhousetag = By.xpath(".//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[@index='1']/android.widget.RelativeLayout/android.widget.RelativeLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@text='OPEN HOUSE']");
	static By property3openhousetag = By.xpath(".//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[@index='2']/android.widget.RelativeLayout/android.widget.RelativeLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@text='OPEN HOUSE']");
		
	
	static String diditsort = "";

	public static void clickSortOption (AppiumDriver<?> driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait (driver, 60);
		WebElement sortoptionelement = wait.until(ExpectedConditions.elementToBeClickable(sortoption));
		sortoptionelement.click();
		Thread.sleep(4000); //Must wait for this time to load
	}
	
	
	public static void sortByBeds (AppiumDriver<?> driver) throws InterruptedException
	{	
		WebDriverWait wait = new WebDriverWait (driver, 60);
		MSortResults_Page.clickSortOption(driver);
		
		WebElement bedselement = wait.until(ExpectedConditions.elementToBeClickable(beds));
		bedselement.click();
		Thread.sleep(4000);
	}
	
	public static void sortByBaths (AppiumDriver<?> driver) throws InterruptedException
	{	
		WebDriverWait wait = new WebDriverWait (driver, 60);
		MSortResults_Page.clickSortOption(driver);
		
		WebElement bathselement = wait.until(ExpectedConditions.elementToBeClickable(baths));
		bathselement.click();
		Thread.sleep(4000);
	}
	
	
	public static void sortByLowtoHighPrice (AppiumDriver<?> driver) throws InterruptedException
	{	
		WebDriverWait wait = new WebDriverWait (driver, 60);
		MSortResults_Page.clickSortOption(driver);
		
		WebElement pricelowtohighelement = wait.until(ExpectedConditions.elementToBeClickable(pricelowtohigh));
		pricelowtohighelement.click();
		Thread.sleep(4000);
	}
	
	public static void sortByHightoLowPrice (AppiumDriver<?> driver) throws InterruptedException
	{	
		WebDriverWait wait = new WebDriverWait (driver, 60);
		MSortResults_Page.clickSortOption(driver);
		
		WebElement pricehightolowelement = wait.until(ExpectedConditions.elementToBeClickable(pricehightolow));
		pricehightolowelement.click();
		Thread.sleep(4000);
	}
	
	
	public static void sortBySqFt (AppiumDriver<?> driver) throws InterruptedException
	{	
		WebDriverWait wait = new WebDriverWait (driver, 60);
		MSortResults_Page.clickSortOption(driver);
		
		WebElement squarefeetelement = wait.until(ExpectedConditions.elementToBeClickable(squarefeet));
		squarefeetelement.click();
		Thread.sleep(4000);
	}
	
	
	public static void sortByMostRecent (AppiumDriver<?> driver) throws InterruptedException
	{	
		WebDriverWait wait = new WebDriverWait (driver, 60);
		MSortResults_Page.clickSortOption(driver);
		
		WebElement mostrecentelement = wait.until(ExpectedConditions.elementToBeClickable(mostrecent));
		mostrecentelement.click();
		Thread.sleep(4000);
	}
	
	
	public static String verifySortByLowtoHighPrice (AppiumDriver<?> driver) 
	{	
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement sortoptionelement = wait.until(ExpectedConditions.elementToBeClickable(sortoption));
		String sorttext = sortoptionelement.getText();
		
		List <WebElement> propertypricelist = (List<WebElement>) driver.findElements(propertyprice);
		WebElement prop1priceelement = propertypricelist.get(0);
		String prop1pricestring = prop1priceelement.getText();
		prop1pricestring = prop1pricestring.replaceAll("\\$", "");
		prop1pricestring = prop1pricestring.replaceAll(",", "");
		int prop1price = Integer.parseInt(prop1pricestring);
		
		WebElement prop2priceelement = propertypricelist.get(1);
		String prop2pricestring = prop2priceelement.getText();
		prop2pricestring = prop2pricestring.replaceAll("\\$", "");
		prop2pricestring = prop2pricestring.replaceAll(",", "");
		int prop2price = Integer.parseInt(prop2pricestring);
		
		WebElement prop3priceelement = propertypricelist.get(2);
		String prop3pricestring = prop3priceelement.getText();
		prop3pricestring = prop3pricestring.replaceAll("\\$", "");
		prop3pricestring = prop3pricestring.replaceAll(",", "");
		int prop3price = Integer.parseInt(prop3pricestring);

		if ( sorttext.equalsIgnoreCase("Sort: Price, Low to High") && (prop1price <= prop2price) && (prop2price <= prop3price))
		{
			diditsort="yes";
			log.info("It sorted by low to high price successfully.");
		}
		else
		{
			diditsort="no";
			log.info("It sorted by low to high price unsuccessfully.");
		}
		
		return diditsort;
	}
	
	
	public static String verifySortByHightoLowPrice (AppiumDriver<?> driver)
	{	
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement sortoptionelement = wait.until(ExpectedConditions.elementToBeClickable(sortoption));
		String sorttext = sortoptionelement.getText();
		
		List <WebElement> propertypricelist = (List<WebElement>) driver.findElements(propertyprice);
		WebElement prop1priceelement = propertypricelist.get(0);
		String prop1pricestring = prop1priceelement.getText();
		prop1pricestring = prop1pricestring.replaceAll("\\$", "");
		prop1pricestring = prop1pricestring.replaceAll(",", "");
		int prop1price = Integer.parseInt(prop1pricestring);
		
		WebElement prop2priceelement = propertypricelist.get(1);
		String prop2pricestring = prop2priceelement.getText();
		prop2pricestring = prop2pricestring.replaceAll("\\$", "");
		prop2pricestring = prop2pricestring.replaceAll(",", "");
		int prop2price = Integer.parseInt(prop2pricestring);
		
		WebElement prop3priceelement = propertypricelist.get(2);
		String prop3pricestring = prop3priceelement.getText();
		prop3pricestring = prop3pricestring.replaceAll("\\$", "");
		prop3pricestring = prop3pricestring.replaceAll(",", "");
		int prop3price = Integer.parseInt(prop3pricestring);

		if ( sorttext.equalsIgnoreCase("Sort: Price, High to Low") && (prop1price >= prop2price) && (prop2price >= prop3price))
		{
			diditsort="yes";
			log.info("It sorted by high to low price successfully.");
		}
		else
		{
			diditsort="no";
			log.info("It sorted by high to low price unsuccessfully.");
		}
		
		return diditsort;
	}
		
	
	public static String verifySortBySquareFeet (AppiumDriver<?> driver) 
	{	
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement sortoptionelement = wait.until(ExpectedConditions.elementToBeClickable(sortoption));
		String sorttext = sortoptionelement.getText();
		
		List <WebElement> propertysquarefeetlist = (List<WebElement>) driver.findElements(propertysquarefeet);
		WebElement prop1squarefeetelement = propertysquarefeetlist.get(0);
		String prop1squarefeetstring = prop1squarefeetelement.getText();
		int prop1squarefeet = Integer.parseInt(prop1squarefeetstring);
		
		WebElement prop2squarefeetelement = propertysquarefeetlist.get(1);
		String prop2squarefeetstring = prop2squarefeetelement.getText();
		int prop2squarefeet = Integer.parseInt(prop2squarefeetstring);
		
		WebElement prop3squarefeetelement = propertysquarefeetlist.get(2);
		String prop3squarefeetstring = prop3squarefeetelement.getText();
		int prop3squarefeet = Integer.parseInt(prop3squarefeetstring);

		if ( sorttext.equalsIgnoreCase("Sort: Square Feet") && (prop1squarefeet <= prop2squarefeet) && (prop2squarefeet <= prop3squarefeet))
		{
			diditsort="yes";
			log.info("It sorted by square feet successfully.");
		}
		else
		{
			diditsort="no";
			log.info("It sorted by square feet unsuccessfully.");
		}
		
		return diditsort;
	}
	
	public static String verifySortByMostRecent (AppiumDriver<?> driver) throws InterruptedException 
	{	
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement sortoptionelement = wait.until(ExpectedConditions.elementToBeClickable(sortoption));
		String sorttext = sortoptionelement.getText();
		
		List <WebElement> property1newtaglist = (List<WebElement>) driver.findElements(property1newtag);
		List <WebElement> property2newtaglist = (List<WebElement>) driver.findElements(property2newtag);
		List <WebElement> property3newtaglist = (List<WebElement>) driver.findElements(property3newtag);

		List <WebElement> property1openhousetaglist = (List<WebElement>) driver.findElements(property1openhousetag);
		List <WebElement> property2openhousetaglist = (List<WebElement>) driver.findElements(property2openhousetag);
		List <WebElement> property3openhousetaglist = (List<WebElement>) driver.findElements(property3openhousetag);
		
		String prop1newtag = "";
		String prop2newtag = "";
		String prop3newtag = "";
		String prop1newtagsort = "";
		String prop2newtagsort = "";
		String prop3newtagsort = "";
		
		String prop1openhousetag = "";
		String prop2openhousetag = "";
		String prop3openhousetag = "";
		String prop1openhousetagsort = "";
		String prop2openhousetagsort = "";
		String prop3openhousetagsort = "";
		
		if (property1newtaglist.size() >0)
		{
			WebElement property1newtag = property1newtaglist.get(0);
			prop1newtag = property1newtag.getText();
		}
		else
		{
			prop1newtagsort = "no";
		}

		if (property2newtaglist.size() >0)
		{
			WebElement property2newtag = property2newtaglist.get(0);
			prop2newtag = property2newtag.getText();
		}
		else
		{
			prop2newtagsort = "no";
		}
		
		if (property3newtaglist.size() >0)
		{
			WebElement property3newtag = property3newtaglist.get(0);
			prop3newtag = property3newtag.getText();
		}
		else
		{
			prop3newtagsort = "no";
		}
		
		
		
		
		if (property1openhousetaglist.size() >0)
		{
			WebElement property1openhousetag = property1openhousetaglist.get(0);
			prop1openhousetag = property1openhousetag.getText();
		}
		else
		{
			prop1openhousetagsort = "no";
		}

		if (property2openhousetaglist.size() >0)
		{
			WebElement property2openhousetag = property2openhousetaglist.get(0);
			prop2openhousetag = property2openhousetag.getText();
		}
		else
		{
			prop2openhousetagsort = "no";
		}
		
		if (property3openhousetaglist.size() >0)
		{
			WebElement property3openhousetag = property3openhousetaglist.get(0);
			prop3openhousetag = property3openhousetag.getText();
		}
		else
		{
			prop3openhousetagsort = "no";
		}
		
		if  (sorttext.equalsIgnoreCase("Sort: Most Recent") && ((prop1newtag.equalsIgnoreCase("NEW") || prop1openhousetag.equalsIgnoreCase("OPEN HOUSE")) && (prop2newtag.equalsIgnoreCase("NEW") || prop2openhousetag.equalsIgnoreCase("OPEN HOUSE")) && (prop3newtag.equalsIgnoreCase("NEW") || prop3openhousetag.equalsIgnoreCase("OPEN HOUSE"))) )
		{
			diditsort="yes";
			log.info("It sorted by most recent successfully.");
		}
		else
		{
			diditsort="no";
			log.info("It sorted by most recent unsuccessfully.");
		}
		
		return diditsort;
	}

	
	public static String sortAndVerifyByBeds (AppiumDriver<?> driver) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		//Have to sort by high price to get large bedrooms then sort by beds to compare with smaller number of bedrooms
		MSortResults_Page.sortByHightoLowPrice(driver);
		Thread.sleep(4000);
				
		List <WebElement> highpricepropertybedlist = (List<WebElement>) driver.findElements(propertybed);
		WebElement highpriceprop1bedelement = highpricepropertybedlist.get(0);
		String highpriceprop1bedstring = highpriceprop1bedelement.getText();
		int highpriceprop1bed = Integer.parseInt(highpriceprop1bedstring);

		WebElement sortoptionelement = wait.until(ExpectedConditions.elementToBeClickable(sortoption));
		sortoptionelement.click();
		Thread.sleep(4000); //Must wait for this time to load

		WebElement bedselement = wait.until(ExpectedConditions.elementToBeClickable(beds));
		bedselement.click();
		Thread.sleep(4000);
	
		sortoptionelement = wait.until(ExpectedConditions.elementToBeClickable(sortoption));
		String sorttext = sortoptionelement.getText();
		
		List <WebElement> propertybedlist = (List<WebElement>) driver.findElements(propertybed);
		WebElement prop1bedelement = propertybedlist.get(0);
		String prop1bedstring = prop1bedelement.getText();
		int prop1bed = Integer.parseInt(prop1bedstring);
		log.info("prop1bed: "+prop1bed);
		
		WebElement prop2bedelement = propertybedlist.get(1);
		String prop2bedstring = prop2bedelement.getText();
		int prop2bed = Integer.parseInt(prop2bedstring);
		log.info("prop2bed: "+prop2bed);
		
		WebElement prop3bedelement = propertybedlist.get(2);
		String prop3bedstring = prop3bedelement.getText();
		int prop3bed = Integer.parseInt(prop3bedstring);
		log.info("prop3bed: "+prop3bed);
		
		if (sorttext.equalsIgnoreCase("Sort: Beds") && (prop1bed <=highpriceprop1bed) && (prop2bed <= highpriceprop1bed) && (prop3bed <= highpriceprop1bed))
		{
			diditsort="yes";
			log.info("It sorted by bed successfully.");
		}
		else
		{
			diditsort="no";
			log.info("It sorted by bed unsuccessfully.");
		}
		
		return diditsort;
	}
	
	public static String sortAndVerifyByBaths (AppiumDriver<?> driver) throws InterruptedException
	{	
		WebDriverWait wait = new WebDriverWait(driver, 60);
		//Have to sort by high price to get large bathrooms then sort by baths to compare with smaller number of bathrooms
		MSortResults_Page.sortByHightoLowPrice(driver);
		Thread.sleep(4000);
				
		List <WebElement> highpricepropertybathlist = (List<WebElement>) driver.findElements(propertybath);
		WebElement highpriceprop1bathelement = highpricepropertybathlist.get(0);
		String highpriceprop1bathstring = highpriceprop1bathelement.getText();
		int highpriceprop1bath = Integer.parseInt(highpriceprop1bathstring);

		WebElement sortoptionelement = wait.until(ExpectedConditions.elementToBeClickable(sortoption));
		sortoptionelement.click();
		Thread.sleep(4000); //Must wait for this time to load
				
		WebElement bathselement = wait.until(ExpectedConditions.elementToBeClickable(baths));
		bathselement.click();
		Thread.sleep(4000);
	
		sortoptionelement = wait.until(ExpectedConditions.elementToBeClickable(sortoption));
		String sorttext = sortoptionelement.getText();
		
		List <WebElement> propertybathlist = (List<WebElement>) driver.findElements(propertybath);
		WebElement prop1bathelement = propertybathlist.get(0);
		String prop1bathstring = prop1bathelement.getText();
		int prop1bath = Integer.parseInt(prop1bathstring);
		log.info("prop1bath: "+prop1bath);
		
		WebElement prop2bathelement = propertybathlist.get(1);
		String prop2bathstring = prop2bathelement.getText();
		int prop2bath = Integer.parseInt(prop2bathstring);
		log.info("prop2bath: "+prop2bath);
		
		WebElement prop3bathelement = propertybathlist.get(2);
		String prop3bathstring = prop3bathelement.getText();
		int prop3bath = Integer.parseInt(prop3bathstring);
		log.info("prop3bath: "+prop3bath);
		
		if (sorttext.equalsIgnoreCase("Sort: Baths") && (prop1bath <=highpriceprop1bath) && (prop2bath <= highpriceprop1bath) && (prop3bath <= highpriceprop1bath))
		{
			diditsort="yes";
			log.info("It sorted by bath successfully.");
		}
		else
		{
			diditsort="no";
			log.info("It sorted by bath unsuccessfully.");
		}
		
		return diditsort;
	}
	
	
	
}
