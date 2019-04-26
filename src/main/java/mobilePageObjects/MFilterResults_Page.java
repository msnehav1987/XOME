package mobilePageObjects;

import java.util.List;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.MiscMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class MFilterResults_Page {
	    //****************************************//
		//***                                  ***//
		//*** Created by Angela Tong Apr 2018  ***//
		//***                                  ***//
		//****************************************//
		final static Logger log = LogManager.getLogger(MFilterResults_Page.class);

		static By filterbtn = By.id("com.xome.android:id/filter_menu_item_btn");
		static By activestatus = By.id("com.xome.android:id/active_status_tv");
		static By pendingstatus = By.id("com.xome.android:id/pending_status_tv");
		static By soldstatus = By.id("com.xome.android:id/sold_status_tv");
		static By bedsdrpdown = By.id("com.xome.android:id/beds_spinner");
		static By bedselection = By.id("android:id/text1");
		static By bathsdrpdown = By.id("com.xome.android:id/bath_spinner");
		static By bathselection = By.id("android:id/text1");
		static By sqftmin = By.id("com.xome.android:id/filter_sqr_foot_min");
		static By sqftmax = By.id("com.xome.android:id/filter_sqr_foot_max");
		static By sqftselection = By.id("android:id/text1");
		static By yrmin = By.id("com.xome.android:id/filter_year_built_min");
		static By yrmax = By.id("com.xome.android:id/filter_year_built_max");
		static By yrselection = By.id("android:id/text1");
		static By propertysinglefamily = By.id("com.xome.android:id/single_family_type_tv");
		static By propertytownhome = By.id("com.xome.android:id/townhome_type_tv");
		static By propertycondo = By.id("com.xome.android:id/condo_type_tv");
		static By keywordfield = By.id("com.xome.android:id/keyword_search_edit_text");
		static By applybtn = By.id("com.xome.android:id/apply");
		
		static By pendingtag = By.xpath(".//android.widget.TextView[contains(@resource-id, 'listing_summary_status') and @text='PENDING']");
		static By    soldtag = By.xpath(".//android.widget.TextView[contains(@resource-id, 'listing_summary_status') and @text='SOLD']");
		static By forsaletag = By.xpath(".//android.widget.TextView[contains(@resource-id, 'listing_summary_status') and @text='FOR SALE']");
		static By propertybed = By.id("com.xome.android:id/listing_summary_bedrooms_textView");
		static By propertybath = By.id("com.xome.android:id/listing_summary_bathrooms_textView");
		static By propertysqft = By.id("com.xome.android:id/listing_summary_square_feet_textView");
		static By propertypic = By.id("com.xome.android:id/listing_summary_imageViewPager");
		static By propertydescription = By.id("com.xome.android:id/description");
		static By propertydetailsmorebutton = By.id("com.xome.android:id/ldTvMoreButton");
		static By propertyyearheader6thslot = By.xpath(".//android.widget.LinearLayout[@index='6']/android.widget.TextView[@index='0' and @text='Year Built:']");
		static By propertyyearheader7thslot = By.xpath(".//android.widget.LinearLayout[@index='7']/android.widget.TextView[@index='0' and @text='Year Built:']");
		static By 	    propertyyear6thslot = By.xpath(".//android.widget.LinearLayout[@index='6']/android.widget.TextView[@index='1']");
		static By 		propertyyear7thslot = By.xpath(".//android.widget.LinearLayout[@index='7']/android.widget.TextView[@index='1']");
		static By 			   propertytype = By.xpath(".//android.widget.LinearLayout[@index='1']/android.widget.TextView[contains(@resource-id, 'row_value') and @index='1']");
		static By scrollnextproperty = By.id("com.xome.android:id/menu_filter_tv");
		
		static String diditfilter = "";
		
		public static void clickFilterOption (AppiumDriver<?> driver) throws InterruptedException 
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);
			WebElement filterbtnelement = wait.until(ExpectedConditions.elementToBeClickable(filterbtn));
			filterbtnelement.click();
			Thread.sleep(4000); //Must wait for this time to load
		}
		
		public static void uncheckAllStatus (AppiumDriver<?> driver) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);
			WebElement activestatuselement = wait.until(ExpectedConditions.elementToBeClickable(activestatus));
			WebElement pendingstatuselement = wait.until(ExpectedConditions.elementToBeClickable(activestatus));
			WebElement soldstatuselement = wait.until(ExpectedConditions.elementToBeClickable(activestatus));
			
			Boolean activeselected = activestatuselement.isSelected();
			Boolean pendingselected = pendingstatuselement.isSelected();
			Boolean soldselected = soldstatuselement.isSelected();
			
			if (activeselected.equals(true))
			{
				activestatuselement.click();
				log.info("Active status is unchecked.");
			}
			else
			{
				log.info("Active status is unchecked.");
			}
			
			
			if (pendingselected.equals(true))
			{
				pendingstatuselement.click();
				log.info("Pending status is unchecked.");
			}
			else 
			{
				log.info("Pending status is unchecked.");
			}
			
			if (soldselected.equals(true))
			{
				soldstatuselement.click();
				log.info("Sold status is unchecked.");
			}
			else
			{
				log.info("Sold status is unchecked.");
			}
			
			Thread.sleep(4000);
		}
		
		public static void checkPendingStatus (AppiumDriver<?> driver) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);
			WebElement pendingstatuselement = wait.until(ExpectedConditions.elementToBeClickable(pendingstatus));
			pendingstatuselement.click();
			log.info("Pending status is checked.");
			Thread.sleep(4000);
		}
		
		public static void checkSoldStatus (AppiumDriver<?> driver) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);
			WebElement soldstatuselement = wait.until(ExpectedConditions.elementToBeClickable(soldstatus));
			soldstatuselement.click();
			log.info("Sold status is checked.");
			Thread.sleep(4000);
		}
		
		
		public static void checkForSaleStatus (AppiumDriver<?> driver) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);
			WebElement activestatuselement = wait.until(ExpectedConditions.elementToBeClickable(activestatus));
			activestatuselement.click();
			log.info("Active status is checked.");
			Thread.sleep(4000);
		}
		
		public static void clickFilterByBed (AppiumDriver<?> driver, String beds) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);
			WebElement bedsdrpdownelement = wait.until(ExpectedConditions.elementToBeClickable(bedsdrpdown));
			bedsdrpdownelement.click();
			Thread.sleep(4000);
			
			int numofbeds = Integer.parseInt(beds);
			List <WebElement> bedslist = (List<WebElement>) driver.findElements(bedselection);
			WebElement numofbedsselection = bedslist.get(numofbeds);
			numofbedsselection.click();
			Thread.sleep(4000);
		}
		
		public static void clickFilterByBath (AppiumDriver<?> driver, String baths) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);
			WebElement bathsdrpdownelement = wait.until(ExpectedConditions.elementToBeClickable(bathsdrpdown));
			bathsdrpdownelement.click();
			Thread.sleep(4000);
			
			int numofbaths = Integer.parseInt(baths);
			List <WebElement> bathslist = (List<WebElement>) driver.findElements(bathselection);
			WebElement numofbathsselection = bathslist.get(numofbaths);
			numofbathsselection.click();
			Thread.sleep(4000);
		}
		
		public static void clickFilterByMinSqFt (AppiumDriver<?> driver, String minsqft) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);
			WebElement sqftminelement = wait.until(ExpectedConditions.elementToBeClickable(sqftmin));
			sqftminelement.click();
			Thread.sleep(4000);
			
			List <WebElement> sqftselectionlist = (List<WebElement>) driver.findElements(sqftselection);
			
			
			switch (minsqft)
			{
				case "250": 
					WebElement sqft1 = sqftselectionlist.get(1);
					sqft1.click();
					break;
				case "500":
					WebElement sqft2 = sqftselectionlist.get(2);
					sqft2.click();
					break;
				case "750":
					WebElement sqft3 = sqftselectionlist.get(3);
					sqft3.click();
					break;
				case "1000":
					WebElement sqft4 = sqftselectionlist.get(4);
					sqft4.click();
					break;
				case "1250":
					WebElement sqft5 = sqftselectionlist.get(5);
					sqft5.click();
					break;
				case "1500":
					WebElement sqft6 = sqftselectionlist.get(6);
					sqft6.click();
					break;
				case "1750":
					WebElement sqft7 = sqftselectionlist.get(7);
					sqft7.click();
					break;
				case "2000":
					WebElement sqft8 = sqftselectionlist.get(8);
					sqft8.click();
					break;
				case "2250":
					WebElement sqft9 = sqftselectionlist.get(9);
					sqft9.click();
					break;
				case "2500":
					WebElement sqft10 = sqftselectionlist.get(10);
					sqft10.click();
					break;
				case "2750":
					WebElement sqft11 = sqftselectionlist.get(11);
					sqft11.click();
					break;
				case "3000":
					WebElement sqft12 = sqftselectionlist.get(12);
					sqft12.click();
					break;
			}
			
			Thread.sleep(4000);	

		}
		
		
		public static void clickFilterByMaxSqFt (AppiumDriver<?> driver, String maxsqft) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);
			WebElement sqftmaxelement = wait.until(ExpectedConditions.elementToBeClickable(sqftmax));
			sqftmaxelement.click();
			Thread.sleep(4000);	
			
			List <WebElement> sqftselectionlist = (List<WebElement>) driver.findElements(sqftselection);
			
			
			switch (maxsqft)
			{
				case "250": 
					WebElement sqft1 = sqftselectionlist.get(1);
					sqft1.click();
					break;
				case "500":
					WebElement sqft2 = sqftselectionlist.get(2);
					sqft2.click();
					break;
				case "750":
					WebElement sqft3 = sqftselectionlist.get(3);
					sqft3.click();
					break;
				case "1000":
					WebElement sqft4 = sqftselectionlist.get(4);
					sqft4.click();
					break;
				case "1250":
					WebElement sqft5 = sqftselectionlist.get(5);
					sqft5.click();
					break;
				case "1500":
					WebElement sqft6 = sqftselectionlist.get(6);
					sqft6.click();
					break;
				case "1750":
					WebElement sqft7 = sqftselectionlist.get(7);
					sqft7.click();
					break;
				case "2000":
					WebElement sqft8 = sqftselectionlist.get(8);
					sqft8.click();
					break;
				case "2250":
					WebElement sqft9 = sqftselectionlist.get(9);
					sqft9.click();
					break;
				case "2500":
					WebElement sqft10 = sqftselectionlist.get(10);
					sqft10.click();
					break;
				case "2750":
					WebElement sqft11 = sqftselectionlist.get(11);
					sqft11.click();
					break;
				case "3000":
					WebElement sqft12 = sqftselectionlist.get(12);
					sqft12.click();
					break;
			}
			
			Thread.sleep(4000);	

		}
		
		public static void clickFilterByKeyword (AppiumDriver<?> driver, String keyword) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);
			MiscMethods.swipeDown(driver);
			WebElement keywordelement = wait.until(ExpectedConditions.elementToBeClickable(keywordfield));
			keywordelement.click();
			keywordelement.clear();
			keywordelement.sendKeys(keyword);
			Thread.sleep(4000);	
		}	
		
		public static void clickFilterByMinYear (AppiumDriver<?> driver, String minyear) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);
			WebElement yrminelement = wait.until(ExpectedConditions.elementToBeClickable(yrmin));
			yrminelement.click();
			Thread.sleep(4000);
			
			List <WebElement> yrselectionlist = (List<WebElement>) driver.findElements(yrselection);
			
			switch (minyear)
			{
				case "2017":
					WebElement yrselectionelement1 = yrselectionlist.get(1);
					yrselectionelement1.click();
					break;
				case "2016":
					WebElement yrselectionelement2 = yrselectionlist.get(2);
					yrselectionelement2.click();
					break;
				case "2015":
					WebElement yrselectionelement3 = yrselectionlist.get(3);
					yrselectionelement3.click();
					break;
				case "2014":
					WebElement yrselectionelement4 = yrselectionlist.get(4);
					yrselectionelement4.click();
					break;
				case "2005":
					WebElement yrselectionelement5 = yrselectionlist.get(5);
					yrselectionelement5.click();
					break;
				case "2000":
					WebElement yrselectionelement6 = yrselectionlist.get(6);
					yrselectionelement6.click();
					break;
				case "1995":
					WebElement yrselectionelement7 = yrselectionlist.get(7);
					yrselectionelement7.click();
					break;
				case "1990":
					WebElement yrselectionelement8 = yrselectionlist.get(8);
					yrselectionelement8.click();
					break;
				case "1980":
					WebElement yrselectionelement9 = yrselectionlist.get(9);
					yrselectionelement9.click();
					break;
				case "1970":
					WebElement yrselectionelement10 = yrselectionlist.get(10);
					yrselectionelement10.click();
					break;
				case "1960":
					WebElement yrselectionelement11 = yrselectionlist.get(11);
					yrselectionelement11.click();
					break;
				case "1950":
					WebElement yrselectionelement12 = yrselectionlist.get(12);
					yrselectionelement12.click();
					break;
				case "1940":
					WebElement yrselectionelement13 = yrselectionlist.get(13);
					yrselectionelement13.click();
					break;
				case "1920":
					WebElement yrselectionelement14 = yrselectionlist.get(14);
					yrselectionelement14.click();
					break;
				case "1900":
					WebElement yrselectionelement15 = yrselectionlist.get(15);
					yrselectionelement15.click();
					break;
			}
			
			Thread.sleep(4000);
			
		}
		
		
		public static void clickFilterByMaxYear (AppiumDriver<?> driver, String maxyear) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);
			WebElement yrmaxelement = wait.until(ExpectedConditions.elementToBeClickable(yrmax));
			yrmaxelement.click();
			Thread.sleep(4000);
			
			List <WebElement> yrselectionlist = (List<WebElement>) driver.findElements(yrselection);
			
			switch (maxyear)
			{
				case "2017":
					WebElement yrselectionelement1 = yrselectionlist.get(1);
					yrselectionelement1.click();
					break;
				case "2016":
					WebElement yrselectionelement2 = yrselectionlist.get(2);
					yrselectionelement2.click();
					break;
				case "2015":
					WebElement yrselectionelement3 = yrselectionlist.get(3);
					yrselectionelement3.click();
					break;
				case "2014":
					WebElement yrselectionelement4 = yrselectionlist.get(4);
					yrselectionelement4.click();
					break;
				case "2005":
					WebElement yrselectionelement5 = yrselectionlist.get(5);
					yrselectionelement5.click();
					break;
				case "2000":
					WebElement yrselectionelement6 = yrselectionlist.get(6);
					yrselectionelement6.click();
					break;
				case "1995":
					WebElement yrselectionelement7 = yrselectionlist.get(7);
					yrselectionelement7.click();
					break;
				case "1990":
					WebElement yrselectionelement8 = yrselectionlist.get(8);
					yrselectionelement8.click();
					break;
				case "1980":
					WebElement yrselectionelement9 = yrselectionlist.get(9);
					yrselectionelement9.click();
					break;
				case "1970":
					WebElement yrselectionelement10 = yrselectionlist.get(10);
					yrselectionelement10.click();
					break;
				case "1960":
					WebElement yrselectionelement11 = yrselectionlist.get(11);
					yrselectionelement11.click();
					break;
				case "1950":
					WebElement yrselectionelement12 = yrselectionlist.get(12);
					yrselectionelement12.click();
					break;
				case "1940":
					WebElement yrselectionelement13 = yrselectionlist.get(13);
					yrselectionelement13.click();
					break;
				case "1920":
					WebElement yrselectionelement14 = yrselectionlist.get(14);
					yrselectionelement14.click();
					break;
				case "1900":
					WebElement yrselectionelement15 = yrselectionlist.get(15);
					yrselectionelement15.click();
					break;
			}
			
			Thread.sleep(4000);
			
		}
		
		public static String verifyFilterByYear (AppiumDriver<?> driver, String minyear, String maxyear) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);
			
			List <WebElement> propertypiclist = (List<WebElement>) driver.findElements(propertypic);
			WebElement property1pic = propertypiclist.get(0);
			property1pic.click();
			Thread.sleep(4000);
			
			int min_year = Integer.parseInt(minyear);
			int max_year = Integer.parseInt(maxyear);
			int year1;
			int year2;
			int year3;
			
	        Dimension size = driver.manage().window().getSize();
	        int starty = (int) (size.height * 0.4);
	        int endy = (int) (size.height * 0.2);
	        int startx = size.width / 2;
	        new TouchAction(driver).press(PointOption.point(startx, starty)).waitAction().moveTo(PointOption.point(startx, endy)).release().perform();
	        Thread.sleep(4000);
			
			List <WebElement> property1yearheader6thslotlist = (List<WebElement>) driver.findElements(propertyyearheader6thslot);
			int property1yearheader6thslotsize = property1yearheader6thslotlist.size();
			
			if (property1yearheader6thslotsize > 0)
			{
				WebElement property1year6thslotelement = wait.until(ExpectedConditions.presenceOfElementLocated(propertyyear6thslot));
				String year6text1 = property1year6thslotelement.getText();
				year1 = Integer.parseInt(year6text1);
			}
			else
			{
				WebElement property1year7thslotelement = wait.until(ExpectedConditions.presenceOfElementLocated(propertyyear7thslot));
				String year7text1 = property1year7thslotelement.getText();
				year1 = Integer.parseInt(year7text1);
			}
		
			int yrsixth;
			int yrseventh;
			Boolean year;
			Boolean yearmatch1 = (year1 >=min_year) && (year1 <=max_year);
			Boolean yearmatch2 = false;
			Boolean yearmatch3 = false;
				
			log.info("yearmatch1 is "+yearmatch1);
			
			for (int i=0; i<2; i++)
			{
				WebElement scrollnext = wait.until(ExpectedConditions.elementToBeClickable(scrollnextproperty));
				scrollnext.click();
				Thread.sleep(4000);
				
				new TouchAction(driver).press(PointOption.point(startx, starty)).waitAction().moveTo(PointOption.point(startx, endy)).release().perform();
		        Thread.sleep(4000);
		        
				List <WebElement> propertyyearheader6thslotlist = (List<WebElement>) driver.findElements(propertyyearheader6thslot);
				int propertyyearheader6thslotsize = propertyyearheader6thslotlist.size();
				
				if (propertyyearheader6thslotsize > 0)
				{
					WebElement propertyyear6thslotelement = wait.until(ExpectedConditions.presenceOfElementLocated(propertyyear6thslot));
					String year6text = propertyyear6thslotelement.getText();
					yrsixth = Integer.parseInt(year6text);
					year = (yrsixth >= min_year) && (yrsixth <= max_year);
				}
				else
				{
					WebElement propertyyear7thslotelement = wait.until(ExpectedConditions.presenceOfElementLocated(propertyyear7thslot));
					String year7text = propertyyear7thslotelement.getText();
					yrseventh = Integer.parseInt(year7text);
					year = (yrseventh >= min_year) && (yrseventh <= max_year);
				}
				

				
				if (i==0)
				{
					yearmatch2 = year;
					log.info("yearmatch2 is "+yearmatch2);
				}
				else if (i==1)
				{
					yearmatch3 = year;
					log.info("yearmatch3 is "+yearmatch3);
				}
			}
			
			
			if (yearmatch1.equals(true) && yearmatch2.equals(true) && yearmatch3.equals(true))
			{
				diditfilter="yes";
				log.info("It filter by min year "+minyear+" and max year "+maxyear+" successfully.");
			}
			else
			{
				diditfilter="no";
				log.info("It filter by min year "+minyear+" and max year "+maxyear+" unsuccessfully.");
			}
			
			return diditfilter;
			
		}
			
		public static String verifyFilterByKeyword (AppiumDriver<?> driver, String keyword) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);
			
			List <WebElement> propertypiclist = (List<WebElement>) driver.findElements(propertypic);
			WebElement property1pic = propertypiclist.get(0);
			property1pic.click();
			Thread.sleep(4000);
			
			WebElement propertydetailsmorebuttonelement = wait.until(ExpectedConditions.elementToBeClickable(propertydetailsmorebutton));
			propertydetailsmorebuttonelement.click();
			WebElement propdescriptionelement1 = wait.until(ExpectedConditions.elementToBeClickable(propertydescription));
			String propdescriptiontext1 = propdescriptionelement1.getText();
			Boolean propkeywordmatch1 = Pattern.compile(Pattern.quote(keyword), Pattern.CASE_INSENSITIVE).matcher(propdescriptiontext1).find();
			Boolean propkeywordmatch2 = false;
			Boolean propkeywordmatch3 = false;
			
			for (int i=0; i<2; i++)
			{
				WebElement scrollnext = wait.until(ExpectedConditions.elementToBeClickable(scrollnextproperty));
				scrollnext.click();
				Thread.sleep(4000);
				
				WebElement propertydetailsmorebutton_element = wait.until(ExpectedConditions.elementToBeClickable(propertydetailsmorebutton));
				propertydetailsmorebutton_element.click();
				
				WebElement propdescriptionelement = wait.until(ExpectedConditions.elementToBeClickable(propertydescription));
				String propdescriptiontext = propdescriptionelement.getText();
				Boolean propkeywordmatch = Pattern.compile(Pattern.quote(keyword), Pattern.CASE_INSENSITIVE).matcher(propdescriptiontext).find();
				
				if (i==0)
				{
					propkeywordmatch2 = propkeywordmatch;
				}
				else if (i==1)
				{
					propkeywordmatch3 = propkeywordmatch;
				}

			}
			
			
			if (propkeywordmatch1.equals(true) && propkeywordmatch2.equals(true) && propkeywordmatch3.equals(true))
			{
				diditfilter="yes";
				log.info("It filter by keyword "+keyword+" successfully.");
			}
			else
			{
				diditfilter="no";
				log.info("It filter by keyword "+keyword+" unsuccessfully.");
			}
			
			return diditfilter;
		}
		
		public static String verifyFilterBySqFt (AppiumDriver<?> driver, String minsqft, String maxsqft) throws InterruptedException
		{
		    List <WebElement> sqftlist = (List<WebElement>) driver.findElements(propertysqft);
		    WebElement prop1sqftelement = sqftlist.get(0);
		    String prop1sqfttext = prop1sqftelement.getText();
		    prop1sqfttext = prop1sqfttext.replaceAll(",", "");
		    int prop1sqft = Integer.parseInt(prop1sqfttext);
		    
		    WebElement prop2sqftelement = sqftlist.get(0);
		    String prop2sqfttext = prop2sqftelement.getText();
		    prop2sqfttext = prop2sqfttext.replaceAll(",", "");
		    int prop2sqft = Integer.parseInt(prop2sqfttext);
		    
		    WebElement prop3sqftelement = sqftlist.get(0);
		    String prop3sqfttext = prop3sqftelement.getText();
		    prop3sqfttext = prop3sqfttext.replaceAll(",", "");
		    int prop3sqft = Integer.parseInt(prop3sqfttext);
			
		    int min_sqft = Integer.parseInt(minsqft);
		    int max_sqft = Integer.parseInt(maxsqft);
		    
		    if ((prop1sqft >= min_sqft && prop1sqft <= max_sqft) && (prop2sqft >= min_sqft && prop2sqft <= max_sqft)  && (prop3sqft >= min_sqft && prop3sqft <= max_sqft) )
		    {
		    		diditfilter="yes";
		    		log.info("It filter by min square feet  "+minsqft+" and max square feet "+maxsqft+" successfully.");
		    }
		    else
		    {
	    			diditfilter="no";
		    		log.info("It filter by min square feet "+minsqft+" and max square feet "+maxsqft+" unsuccessfully.");
		    }
		    
			return diditfilter;
		}
		
		public static String verifyFilterByBeds (AppiumDriver<?> driver, String beds) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);
			int numofbeds = Integer.parseInt(beds);
			
			List <WebElement> bedlist = (List<WebElement>) driver.findElements(propertybed);
			WebElement prop1bedelement = bedlist.get(0);
			String prop1bedtext = prop1bedelement.getText();
			int prop1bed = Integer.parseInt(prop1bedtext);
			
			WebElement prop2bedelement = bedlist.get(1);
			String prop2bedtext = prop2bedelement.getText();
			int prop2bed = Integer.parseInt(prop2bedtext);
		
			WebElement prop3bedelement = bedlist.get(2);
			String prop3bedtext = prop3bedelement.getText();
			int prop3bed = Integer.parseInt(prop3bedtext);
			
			if(prop1bed>=numofbeds && prop2bed>=numofbeds && prop3bed>=numofbeds)
			{
				diditfilter="yes";
				log.info("It filtered by "+numofbeds+" beds successfully.");
			}
			else
			{
				diditfilter="no";
				log.info("It filtered by "+numofbeds+" beds unsuccessfully.");
			}
			
			return diditfilter;
		}
		
		public static String verifyFilterByBaths (AppiumDriver<?> driver, String baths) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);
			int numofbaths = Integer.parseInt(baths);
			
			List <WebElement> bathlist = (List<WebElement>) driver.findElements(propertybath);
			WebElement prop1bathelement = bathlist.get(0);
			String prop1bathtext = prop1bathelement.getText();
			int prop1bath = Integer.parseInt(prop1bathtext);
			
			WebElement prop2bathelement = bathlist.get(1);
			String prop2bathtext = prop2bathelement.getText();
			int prop2bath = Integer.parseInt(prop2bathtext);
		
			WebElement prop3bathelement = bathlist.get(2);
			String prop3bathtext = prop3bathelement.getText();
			int prop3bath = Integer.parseInt(prop3bathtext);
			
			if(prop1bath>=numofbaths && prop2bath>=numofbaths && prop3bath>=numofbaths)
			{
				diditfilter="yes";
				log.info("It filtered by "+numofbaths+" baths successfully.");
			}
			else
			{
				diditfilter="no";
				log.info("It filtered by "+numofbaths+" baths unsuccessfully.");
			}
			
			return diditfilter;
		}
		

		public static String verifyPendingStatus (AppiumDriver<?> driver)
		{
			List<WebElement> pendinglist = (List<WebElement>) driver.findElements(pendingtag);
			
			WebElement prop1pendingelement = pendinglist.get(0);
			String prop1pending = prop1pendingelement.getText();
			
			WebElement prop2pendingelement = pendinglist.get(0);
			String prop2pending = prop2pendingelement.getText();
			
			WebElement prop3pendingelement = pendinglist.get(0);
			String prop3pending = prop3pendingelement.getText();
			
			if (prop1pending.equalsIgnoreCase("PENDING") && prop2pending.equalsIgnoreCase("PENDING") && prop3pending.equalsIgnoreCase("PENDING"))
			{
				diditfilter="yes";
				log.info("It filtered by pending status successfully.");
			}
			else
			{
				diditfilter="no";
				log.info("It filtered by pending status unsuccessfully.");
			}
			
			return diditfilter;
		}
		
		public static String verifySoldStatus (AppiumDriver<?> driver)
		{
			List<WebElement> soldlist = (List<WebElement>) driver.findElements(soldtag);
			
			WebElement prop1soldelement = soldlist.get(0);
			String prop1sold = prop1soldelement.getText();
			
			WebElement prop2soldelement = soldlist.get(0);
			String prop2sold = prop2soldelement.getText();
			
			WebElement prop3soldelement = soldlist.get(0);
			String prop3sold = prop3soldelement.getText();
			
			if (prop1sold.equalsIgnoreCase("SOLD") && prop2sold.equalsIgnoreCase("SOLD") && prop3sold.equalsIgnoreCase("SOLD"))
			{
				diditfilter="yes";
				log.info("It filtered by sold status successfully.");
			}
			else
			{
				diditfilter="no";
				log.info("It filtered by sold status unsuccessfully.");
			}
			
			return diditfilter;
		}
		
		public static String verifyForSaleStatus (AppiumDriver<?> driver)
		{
			List<WebElement> activelist = (List<WebElement>) driver.findElements(forsaletag);
			
			WebElement prop1activeelement = activelist.get(0);
			String prop1active = prop1activeelement.getText();
			
			WebElement prop2activeelement = activelist.get(0);
			String prop2active = prop2activeelement.getText();
			
			WebElement prop3activeelement = activelist.get(0);
			String prop3active = prop3activeelement.getText();
			
			if (prop1active.equalsIgnoreCase("FOR SALE") && prop2active.equalsIgnoreCase("FOR SALE") && prop3active.equalsIgnoreCase("FOR SALE"))
			{
				diditfilter="yes";
				log.info("It filtered by for sale active status successfully.");
			}
			else
			{
				diditfilter="no";
				log.info("It filtered by for sale active status unsuccessfully.");
			}
			
			return diditfilter;
		}
		
		public static void clickSingleFamily (AppiumDriver<?> driver) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);
			WebElement propertysinglefamilyelement = wait.until(ExpectedConditions.elementToBeClickable(propertysinglefamily));
			propertysinglefamilyelement.click();
		    Thread.sleep(4000);
		}
		
		public static void clickTownHome (AppiumDriver<?> driver) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);
			WebElement propertytownhomeelement = wait.until(ExpectedConditions.elementToBeClickable(propertytownhome));
			propertytownhomeelement.click();
		    Thread.sleep(4000);
		}
		
		public static void clickCondo (AppiumDriver<?> driver) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);
			WebElement propertycondoelement = wait.until(ExpectedConditions.elementToBeClickable(propertycondo));
			propertycondoelement.click();
		    Thread.sleep(4000);
		}
		
		public static String verifyFilterBySingleFamily (AppiumDriver<?> driver) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);

			List <WebElement> propertypiclist = (List<WebElement>) driver.findElements(propertypic);
			WebElement property1pic = propertypiclist.get(0);
			property1pic.click();
			Thread.sleep(6000);
			
			WebElement property1typeelement = wait.until(ExpectedConditions.visibilityOfElementLocated(propertytype));
			String property1typetext = property1typeelement.getText();
			log.info(property1typetext);
			
			Boolean propertytypematch1 = Pattern.compile(Pattern.quote("Single Family"), Pattern.CASE_INSENSITIVE).matcher(property1typetext).find();
			Boolean propertytypematch2 = false;
			Boolean propertytypematch3 = false;
			
			for (int i=0; i<2; i++)
			{
				WebElement scrollnext = wait.until(ExpectedConditions.elementToBeClickable(scrollnextproperty));
				scrollnext.click();
				Thread.sleep(6000);
				
				WebElement propertytypeelement = wait.until(ExpectedConditions.visibilityOfElementLocated(propertytype));
				String propertytypetext = propertytypeelement.getText();
				log.info(propertytypetext);
				
				Boolean propertytypematch = Pattern.compile(Pattern.quote("Single Family"), Pattern.CASE_INSENSITIVE).matcher(propertytypetext).find();
	
				if (i==0)
				{
					propertytypematch2 = propertytypematch;
				}
				else if (i==1)
				{
					propertytypematch3 = propertytypematch;
				}

			}
			
			
			if (propertytypematch1.equals(true) && propertytypematch2.equals(true) && propertytypematch3.equals(true))
			{
				diditfilter="yes";
				log.info("It filter by Single Family successfully.");
			}
			else
			{
				diditfilter="no";
				log.info("It filter by Single Family unsuccessfully.");
			}
			
			return diditfilter;

		}
		
		
		public static String verifyFilterByTownHome (AppiumDriver<?> driver) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);

			List <WebElement> propertypiclist = (List<WebElement>) driver.findElements(propertypic);
			WebElement property1pic = propertypiclist.get(0);
			property1pic.click();
			Thread.sleep(6000);
			
			WebElement property1typeelement = wait.until(ExpectedConditions.visibilityOfElementLocated(propertytype));
			String property1typetext = property1typeelement.getText();
			log.info(property1typetext);

			Boolean propertytypematch1 = Pattern.compile(Pattern.quote("Townhouse"), Pattern.CASE_INSENSITIVE).matcher(property1typetext).find();
			Boolean propertytypematch2 = false;
			Boolean propertytypematch3 = false;
			
			
			for (int i=0; i<2; i++)
			{
				WebElement scrollnext = wait.until(ExpectedConditions.elementToBeClickable(scrollnextproperty));
				scrollnext.click();
				Thread.sleep(6000);
				
				WebElement propertytypeelement = wait.until(ExpectedConditions.visibilityOfElementLocated(propertytype));
				String propertytypetext = propertytypeelement.getText();
				log.info(propertytypetext);
				
				Boolean propertytypematch = Pattern.compile(Pattern.quote("Townhouse"), Pattern.CASE_INSENSITIVE).matcher(propertytypetext).find();
	
				if (i==0)
				{
					propertytypematch2 = propertytypematch;
				}
				else if (i==1)
				{
					propertytypematch3 = propertytypematch;
				}

			}
			
			
			if (propertytypematch1.equals(true) && propertytypematch2.equals(true) && propertytypematch3.equals(true))
			{
				diditfilter="yes";
				log.info("It filter by Townhouse successfully.");
			}
			else
			{
				diditfilter="no";
				log.info("It filter by Townhouse unsuccessfully.");
			}
			
			return diditfilter;

		}
		
		
		public static String verifyFilterByCondo (AppiumDriver<?> driver) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);

			List <WebElement> propertypiclist = (List<WebElement>) driver.findElements(propertypic);
			WebElement property1pic = propertypiclist.get(0);
			property1pic.click();
			Thread.sleep(6000);
			
			WebElement property1typeelement = wait.until(ExpectedConditions.visibilityOfElementLocated(propertytype));
			String property1typetext = property1typeelement.getText();
			log.info(property1typetext);
			
			Boolean propertytypematch1 = Pattern.compile(Pattern.quote("Condo"), Pattern.CASE_INSENSITIVE).matcher(property1typetext).find();
			Boolean propertytypematch2 = false;
			Boolean propertytypematch3 = false;
			
			for (int i=0; i<2; i++)
			{
				WebElement scrollnext = wait.until(ExpectedConditions.elementToBeClickable(scrollnextproperty));
				scrollnext.click();
				Thread.sleep(6000);
				
				WebElement propertytypeelement = wait.until(ExpectedConditions.visibilityOfElementLocated(propertytype));
				String propertytypetext = propertytypeelement.getText();
				log.info(propertytypetext);
				
				Boolean propertytypematch = Pattern.compile(Pattern.quote("Condo"), Pattern.CASE_INSENSITIVE).matcher(propertytypetext).find();
	
				if (i==0)
				{
					propertytypematch2 = propertytypematch;
				}
				else if (i==1)
				{
					propertytypematch3 = propertytypematch;
				}

			}
			
			
			if (propertytypematch1.equals(true) && propertytypematch2.equals(true) && propertytypematch3.equals(true))
			{
				diditfilter="yes";
				log.info("It filter by condo successfully.");
			}
			else
			{
				diditfilter="no";
				log.info("It filter by condo unsuccessfully.");
			}
			
			return diditfilter;

		}
		
		
		public static void clickApplyFilter (AppiumDriver<?> driver) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait (driver, 60);
			WebElement applybtnelement = wait.until(ExpectedConditions.elementToBeClickable(applybtn));
			applybtnelement.click();
			
			Thread.sleep(4000); //Must wait for this time to load
		}
		
		
		public static void firstOpenAppFilterBySingleFamilyTownHomeCondo (AppiumDriver<?> driver) throws InterruptedException
		{	
            MFilterResults_Page.clickFilterOption(driver);
            MFilterResults_Page.clickSingleFamily(driver);
            MFilterResults_Page.clickTownHome(driver);
            MFilterResults_Page.clickCondo(driver);
            MFilterResults_Page.clickApplyFilter(driver);

		}
}
