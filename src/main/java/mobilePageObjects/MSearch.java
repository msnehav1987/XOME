package mobilePageObjects;


import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MSearch {
	    //****************************************//
		//***                                  ***//
		//*** Created by Angela Tong Apr 2018  ***//
		//***                                  ***//
		//****************************************//
		final static Logger log = LogManager.getLogger(MSearch.class);

		static By searchfield = By.id("com.xome.android:id/search_bar");
		static By searchfield2 = By.id("com.xome.android:id/suggest_search_bar");
		static By searchfield2text = By.id("com.xome.android:id/etSuggest");
		static By autosuggestion = By.xpath(".//android.widget.TextView[contains(@resource-id,'tvTitle') and @index='1']");
		static By propertyaddress = By.id("listing_summary_address_textView");
		static By propertyimage = By.className("android.widget.ImageView");
		
		static String diditfilter = "";
		
		public static void clickSearchtoDismissLeftMenu (AppiumDriver<?> driver) throws InterruptedException
		{	
			WebDriverWait wait = new WebDriverWait (driver, 60);
			WebElement searchfieldelement = wait.until(ExpectedConditions.elementToBeClickable(searchfield));
			searchfieldelement.click();
		}	
		
		public static void searchhomes (AppiumDriver<?> driver, String searchkeyword) throws InterruptedException
		{	
			WebDriverWait wait = new WebDriverWait (driver, 60);
			WebElement searchfieldelement = wait.until(ExpectedConditions.elementToBeClickable(searchfield));
			searchfieldelement.click();
			WebElement searchfield2element = wait.until(ExpectedConditions.elementToBeClickable(searchfield2));
			searchfield2element.click();
			WebElement searchfield2textelement = wait.until(ExpectedConditions.presenceOfElementLocated(searchfield2text));
			searchfield2textelement.clear();
			searchfield2textelement.sendKeys(searchkeyword);
			WebElement autosuggestionelement = wait.until(ExpectedConditions.elementToBeClickable(autosuggestion));
			autosuggestionelement.click();	
			Thread.sleep(4000); //Must wait for this time to load
		}
		
		public static String verifySearchResults(AppiumDriver<?> driver, String searchkeyword) throws InterruptedException
		{	
			
			@SuppressWarnings("unchecked")
			List <MobileElement> addresslist = (List<MobileElement>) driver.findElements(propertyaddress);
			String property1address = addresslist.get(0).getText();
			String property2address = addresslist.get(1).getText();
			String property3address = addresslist.get(2).getText();
				
			WebElement property2 = addresslist.get(1);

	        Dimension size = driver.manage().window().getSize();
	        int starty = (int) (size.height * 0.8);
	        int endy = (int) (size.height * 0.2);
	        int startx = size.width / 2;

			new TouchAction(driver).longPress((LongPressOptions) property2).moveTo(PointOption.point(startx, endy)).release().perform();

			List <MobileElement> addresslist2 = (List<MobileElement>) driver.findElements(propertyaddress);
			
			WebElement property3b = addresslist2.get(2);
			new TouchAction(driver).longPress((LongPressOptions) property3b).moveTo(PointOption.point(startx, endy)).release().perform();
			
			List <MobileElement> addresslist3 = (List<MobileElement>) driver.findElements(propertyaddress);
			String property4address = addresslist3.get(0).getText();
			String property5address = addresslist3.get(1).getText();
			String property6address = addresslist3.get(2).getText();
			
			
			if ((property1address.contains(searchkeyword)) && (property2address.contains(searchkeyword)) && (property3address.contains(searchkeyword)) && (property4address.contains(searchkeyword)) && (property5address.contains(searchkeyword)) && (property6address.contains(searchkeyword)))
			{
				diditfilter="yes";
				log.info("It filtered out the addresses correctly.");
			}
			else
			{
				diditfilter="no";
				log.info("It filter out the addresses incorrectly.");
			}
			
			
			return diditfilter;
		}
}
