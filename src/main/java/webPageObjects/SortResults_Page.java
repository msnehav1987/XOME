package webPageObjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.MiscMethods;


public class SortResults_Page {
	        
	        //****************************************//
			//***                                  ***//
			//*** Created by Angela Tong Apr 2018  ***//
			//***                                  ***//
			//****************************************//
			final static Logger log = LogManager.getLogger(SortResults_Page.class);
			
			static By sortbyclicktoexpanddrpdown = By.cssSelector("div.search-results-sorter>div.btn-group.bootstrap-select>button.btn.dropdown-toggle.btn-default>span.filter-option.pull-left");
			static By dropdownarea = By.cssSelector("div.btn-group.bootstrap-select.open>div.dropdown-menu.open");
			static By sortbydropdownmostrecent = By.cssSelector("div.search-results-sorter>div.btn-group.bootstrap-select.open>div.dropdown-menu.open>ul.dropdown-menu.inner>li:nth-of-type(1)>a>span.text");
			static By sortbydropdownprice = By.cssSelector("div.search-results-sorter>div.btn-group.bootstrap-select.open>div.dropdown-menu.open>ul.dropdown-menu.inner>li:nth-of-type(2)>a>span.text");
			static By sortbydropdownbeds = By.cssSelector("div.search-results-sorter>div.btn-group.bootstrap-select.open>div.dropdown-menu.open>ul.dropdown-menu.inner>li:nth-of-type(3)>a>span.text");
			static By sortbydropdownbaths = By.cssSelector("div.search-results-sorter>div.btn-group.bootstrap-select.open>div.dropdown-menu.open>ul.dropdown-menu.inner>li:nth-of-type(4)>a>span.text");
			static By sortasc = By.cssSelector("button#search-results-sortdir"); //>i.fa.fa-long-arrow-up");
			static By sortdesc = By.cssSelector("button#search-results-sortdir"); //>i.fa.fa-long-arrow-down");
			
			
			static By property1newicon = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(1)>div.ribbons>span.ribbon-new.ribbon");
			
			static By property1price = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div:nth-of-type(1)>div.price>span");
			static By property2price = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(2)>div:nth-of-type(1)>div:nth-of-type(1)>div.price>span");
			static By property3price = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(1)>div:nth-of-type(1)>div.price>span");
			static By property4price = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(4)>div:nth-of-type(1)>div:nth-of-type(1)>div.price>span");
			static By property5price = By.cssSelector("div#mapsearch-results>div:nth-of-type(2)>div:nth-of-type(5)>div:nth-of-type(1)>div:nth-of-type(1)>div.price>span");
			
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
            
			static String diditsort ="";
			
			 public static String sortResultsByMostRecent (WebDriver webdriver) throws InterruptedException
			    {
				 
			    		WebDriverWait wait = new WebDriverWait (webdriver, 60);
			    		WebElement clicksortby = wait.until(ExpectedConditions.elementToBeClickable(sortbyclicktoexpanddrpdown));
			    		clicksortby.click();

			    		Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
			    		
			    		WebElement dropdownareabox = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownarea));
			    		Actions action = new Actions(webdriver);
			    	    action.moveToElement(dropdownareabox).perform();
		            action.sendKeys(Keys.ARROW_DOWN);
		            action.sendKeys(Keys.ARROW_DOWN);
			    		WebElement clicksortbyprice = wait.until(ExpectedConditions.elementToBeClickable(sortbydropdownprice));
			    		//first click price sorts by descending order, 2nd click on the arrow then sorts by ascending order
			        action.moveToElement(clicksortbyprice).click().perform();
			        
			        Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
		    		    
			        clicksortby.click();
			        
			        Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
		    		
			    	    action.moveToElement(dropdownareabox).perform();
		            action.sendKeys(Keys.ARROW_DOWN);
			    		WebElement clicksortbymostrecent = wait.until(ExpectedConditions.elementToBeClickable(sortbydropdownmostrecent));
			    		//first click price sorts by descending order, 2nd click on the arrow then sorts by ascending order
			        action.moveToElement(clicksortbymostrecent).click().perform();
			        
			        Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
	        
		            WebElement property1_newicon = wait.until(ExpectedConditions.presenceOfElementLocated(property1newicon));

		            String newicon = property1_newicon.getText();
  
		            log.info("Newicon says: "+newicon+"\n");
		            
		            if (newicon.equalsIgnoreCase("NEW"))
		            {
		            	    log.info("It has sorted by most recent order.");
		            	    diditsort = "yes";
		            }
		            else
		            {
		            	    log.info("It failed to sort in most recent order.");
		            	    diditsort = "no";
		            }
		            

		            return diditsort;
		    }
			
			 public static String sortResultsByDescPrice (WebDriver webdriver) throws InterruptedException
			    {
				 
			    		WebDriverWait wait = new WebDriverWait (webdriver, 60);
			    		WebElement clicksortby = wait.until(ExpectedConditions.elementToBeClickable(sortbyclicktoexpanddrpdown));
			    		clicksortby.click();
 
			    		Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
			    		
			    		WebElement dropdownareabox = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownarea));
			    		Actions action = new Actions(webdriver);
			    	    action.moveToElement(dropdownareabox).perform();
		            action.sendKeys(Keys.ARROW_DOWN);
		            action.sendKeys(Keys.ARROW_DOWN);
			    		WebElement clicksortbyprice = wait.until(ExpectedConditions.elementToBeClickable(sortbydropdownprice));
			    		//first click price sorts by descending order, 2nd click on the arrow then sorts by ascending order
			        action.moveToElement(clicksortbyprice).click().perform();
			        
			        Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
		    		
		            WebElement property1_price = wait.until(ExpectedConditions.presenceOfElementLocated(property1price));
		            WebElement property2_price = wait.until(ExpectedConditions.presenceOfElementLocated(property2price));
		            WebElement property3_price = wait.until(ExpectedConditions.presenceOfElementLocated(property3price));
		            WebElement property4_price = wait.until(ExpectedConditions.presenceOfElementLocated(property4price));
		            WebElement property5_price = wait.until(ExpectedConditions.presenceOfElementLocated(property5price));
		            
		            String priceone = property1_price.getText(); 
		            priceone=priceone.replaceAll(",", "");
		            String price1 = priceone.substring(1);
		            int prop1price = Integer.parseInt(price1);
		            
		            String pricetwo = property2_price.getText();
		            pricetwo=pricetwo.replaceAll(",", "");
		            String price2 = pricetwo.substring(1);
		            int prop2price = Integer.parseInt(price2);

		            String pricethree = property3_price.getText();
		            pricethree=pricethree.replaceAll(",", "");
		            String price3 = pricethree.substring(1);
		            int prop3price = Integer.parseInt(price3);

		            String pricefour = property4_price.getText();
		            pricefour=pricefour.replaceAll(",", "");
		            String price4 = pricefour.substring(1);
		            int prop4price = Integer.parseInt(price4);

		            String pricefive = property5_price.getText();
		            pricefive=pricefive.replaceAll(",", "");
		            String price5 = pricefive.substring(1);
		            int prop5price = Integer.parseInt(price5);
 
		            String original = "["+price1+" "+price2+" "+price3+" "+price4+" "+price5+ "]";
		            
		            ArrayList<Integer> desclist = new ArrayList<Integer> ();
		            desclist.add(prop1price);
		            desclist.add(prop2price);
		            desclist.add(prop3price);
		            desclist.add(prop4price);
		            desclist.add(prop5price);
		            
		            MiscMethods.sortDescending(desclist);
		            String sorteddesc = MiscMethods.returnsStringforIntegerArrayList(desclist);
		            
		            log.info("Original order is: "+original+"\n");
		            log.info("Sorted descending order is: "+sorteddesc+"\n");
		            
		            if (original.equalsIgnoreCase(sorteddesc))
		            {
		            	    log.info("It has sorted in descending order.");
		            	    diditsort = "yes";
		            }
		            else
		            {
		            	    log.info("It failed to sort in descending order.");
		            	    diditsort = "no";
		            }
		            

		            return diditsort;
		    }
			 
			 public static String sortResultsByAscPrice (WebDriver webdriver) throws InterruptedException
			 {
				    WebDriverWait wait = new WebDriverWait (webdriver, 60);
			    		WebElement clicksortby = wait.until(ExpectedConditions.elementToBeClickable(sortbyclicktoexpanddrpdown));
			    		clicksortby.click();
			    		
			    		Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
			    		
			    		WebElement dropdownareabox = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownarea));
			    		Actions action = new Actions(webdriver);
			    	    action.moveToElement(dropdownareabox).perform();
		            action.sendKeys(Keys.ARROW_DOWN);
		            action.sendKeys(Keys.ARROW_DOWN);
			    		WebElement clicksortbyprice = wait.until(ExpectedConditions.elementToBeClickable(sortbydropdownprice));
			        action.moveToElement(clicksortbyprice).click().perform();
	            		
			        Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
		    			        
			        WebElement uparrow = webdriver.findElement(sortasc);
	            		uparrow.click(); //first click price sorts by descending order, 2nd click on the arrow then sorts by ascending order
	            			
	            		Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
			    		
		            WebElement property1_price = wait.until(ExpectedConditions.presenceOfElementLocated(property1price));
		            String priceone = property1_price.getText(); 
		            priceone=priceone.replaceAll(",", "");
		            String price1 = priceone.substring(1);
		            int prop1price = Integer.parseInt(price1);
		            
		            WebElement property2_price = wait.until(ExpectedConditions.presenceOfElementLocated(property2price));
		            String pricetwo = property2_price.getText();
		            pricetwo=pricetwo.replaceAll(",", "");
		            String price2 = pricetwo.substring(1);
		            int prop2price = Integer.parseInt(price2);
		            
		            WebElement property3_price = wait.until(ExpectedConditions.presenceOfElementLocated(property3price));
		            String pricethree = property3_price.getText();
		            pricethree=pricethree.replaceAll(",", "");
		            String price3 = pricethree.substring(1);
		            int prop3price = Integer.parseInt(price3);
		            
		            WebElement property4_price = wait.until(ExpectedConditions.presenceOfElementLocated(property4price));
		            String pricefour = property4_price.getText();
		            pricefour=pricefour.replaceAll(",", "");
		            String price4 = pricefour.substring(1);
		            int prop4price = Integer.parseInt(price4);
		            
		            WebElement property5_price = wait.until(ExpectedConditions.presenceOfElementLocated(property5price));
		            String pricefive = property5_price.getText();
		            pricefive=pricefive.replaceAll(",", "");
		            String price5 = pricefive.substring(1);
		            int prop5price = Integer.parseInt(price5);
  
			        String original = "["+ price1+" "+price2+" "+price3+" "+price4+" "+price5+"]";
		            
		            ArrayList<Integer> asclist = new ArrayList<Integer> ();
		            asclist.add(prop1price);
		            asclist.add(prop2price);
		            asclist.add(prop3price);
		            asclist.add(prop4price);
		            asclist.add(prop5price);
		            
		            MiscMethods.sortAscending(asclist);
		            String sortedasc = MiscMethods.returnsStringforIntegerArrayList(asclist);
		            
		            
		            log.info("Original order is: "+original+"\n");
		            log.info("Sorted ascending order is: "+sortedasc+"\n");
		            
		            if (original.equalsIgnoreCase(sortedasc))
		            {
		            	    log.info("It has sorted in ascending order.");
		            	    diditsort = "yes";
		            }
		            else
		            {
		            	    log.info("It failed to sort in ascending order.");
		            	    diditsort = "no";
		            }
	           
	            return diditsort;
		    }
			 
			 public static String sortResultsByDescBeds (WebDriver webdriver) throws InterruptedException
			    {
				 
			    		WebDriverWait wait = new WebDriverWait (webdriver, 60);
			    		WebElement clicksortby = wait.until(ExpectedConditions.elementToBeClickable(sortbyclicktoexpanddrpdown));
			    		clicksortby.click();

			    		Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
			    		
			    		WebElement dropdownareabox = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownarea));
			    		Actions action = new Actions(webdriver);
			    	    action.moveToElement(dropdownareabox).perform();
		            action.sendKeys(Keys.ARROW_DOWN);
		            action.sendKeys(Keys.ARROW_DOWN);
			    		WebElement clicksortbybeds= wait.until(ExpectedConditions.elementToBeClickable(sortbydropdownbeds));
			    		//first click bed sorts by descending order, 2nd click on the arrow then sorts by ascending order
			        action.moveToElement(clicksortbybeds).click().perform();
			        
			        Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
		    		
	            		ArrayList<Integer> desclist = new ArrayList<Integer> ();
	
	            		String bed1 = "";
	            		int prop1bed;
	            	    List <WebElement> iselementpresent1  = webdriver.findElements(property1bed);
	            	    int elementsize1 = iselementpresent1.size();
	            	    if (elementsize1 == 0)
	            	    {
	            	    	    bed1 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property1_bed = wait.until(ExpectedConditions.presenceOfElementLocated(property1bed));
	    		            bed1 = property1_bed.getText(); 
	    		            bed1=bed1.replaceAll(" Bd", "");
	    		            prop1bed = Integer.parseInt(bed1);
				        desclist.add(prop1bed);
	            	    }
		           
	            		String bed2 = "";
	            		int prop2bed;
	            	    List <WebElement> iselementpresent2  = webdriver.findElements(property2bed);
	            	    int elementsize2 = iselementpresent2.size();
	            	    if (elementsize2 == 0)
	            	    {
	            	    	    bed2 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property2_bed = wait.until(ExpectedConditions.presenceOfElementLocated(property2bed));
	    		            bed2 = property2_bed.getText(); 
	    		            bed2=bed2.replaceAll(" Bd", "");
	    		            prop2bed = Integer.parseInt(bed2);
				            desclist.add(prop2bed);
	            	    }
	
	            		String bed3 = "";
	            		int prop3bed;
	            	    List <WebElement> iselementpresent3  = webdriver.findElements(property3bed);
	            	    int elementsize3 = iselementpresent3.size();
	            	    if (elementsize3 == 0)
	            	    {
	            	    	    bed3 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property3_bed = wait.until(ExpectedConditions.presenceOfElementLocated(property3bed));
	    		            bed3 = property3_bed.getText(); 
	    		            bed3=bed3.replaceAll(" Bd", "");
	    		            prop3bed = Integer.parseInt(bed3);
				            desclist.add(prop3bed);
	            	    }
	
	            		String bed4 = "";
	            		int prop4bed;
	            	    List <WebElement> iselementpresent4  = webdriver.findElements(property4bed);
	            	    int elementsize4 = iselementpresent4.size();
	            	    if (elementsize4 == 0)
	            	    {
	            	    	    bed4 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property4_bed = wait.until(ExpectedConditions.presenceOfElementLocated(property4bed));
	    		            bed4 = property4_bed.getText(); 
	    		            bed4=bed4.replaceAll(" Bd", "");
	    		            prop4bed = Integer.parseInt(bed4);
				            desclist.add(prop4bed);
	            	    }	            	    
	
	            		String bed5 = "";
	            		int prop5bed;
	            	    List <WebElement> iselementpresent5  = webdriver.findElements(property5bed);
	            	    int elementsize5 = iselementpresent5.size();
	            	    if (elementsize5 == 0)
	            	    {
	            	    	    bed5 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property5_bed = wait.until(ExpectedConditions.presenceOfElementLocated(property5bed));
	    		            bed5 = property5_bed.getText(); 
	    		            bed5=bed5.replaceAll(" Bd", "");
	    		            prop5bed = Integer.parseInt(bed5);
				            desclist.add(prop5bed);
	            	    }
	            	    
	            		String bed6 = "";
	            		int prop6bed;
	            	    List <WebElement> iselementpresent6  = webdriver.findElements(property6bed);
	            	    int elementsize6 = iselementpresent6.size();
	            	    if (elementsize6 == 0)
	            	    {
	            	    	    bed6 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property6_bed = wait.until(ExpectedConditions.presenceOfElementLocated(property6bed));
	    		            bed6 = property6_bed.getText(); 
	    		            bed6=bed6.replaceAll(" Bd", "");
	    		            prop6bed = Integer.parseInt(bed6);
				            desclist.add(prop6bed);
	            	    }
	            	    
	            		String bed7 = "";
	            		int prop7bed;
	            	    List <WebElement> iselementpresent7  = webdriver.findElements(property7bed);
	            	    int elementsize7 = iselementpresent7.size();
	            	    if (elementsize7 == 0)
	            	    {
	            	    	    bed7 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property7_bed = wait.until(ExpectedConditions.presenceOfElementLocated(property7bed));
	    		            bed7 = property7_bed.getText(); 
	    		            bed7=bed7.replaceAll(" Bd", "");
	    		            prop7bed = Integer.parseInt(bed7);
				            desclist.add(prop7bed);
	            	    }
	            	    
	            		String bed8 = "";
	            		int prop8bed;
	            	    List <WebElement> iselementpresent8  = webdriver.findElements(property8bed);
	            	    int elementsize8 = iselementpresent8.size();
	            	    if (elementsize8 == 0)
	            	    {
	            	    	    bed8 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property8_bed = wait.until(ExpectedConditions.presenceOfElementLocated(property8bed));
	    		            bed8 = property8_bed.getText(); 
	    		            bed8=bed8.replaceAll(" Bd", "");
	    		            prop8bed = Integer.parseInt(bed8);
				            desclist.add(prop8bed);
	            	    }
	            	    
	            		String bed9 = "";
	            		int prop9bed;
	            	    List <WebElement> iselementpresent9  = webdriver.findElements(property9bed);
	            	    int elementsize9 = iselementpresent9.size();
	            	    if (elementsize9 == 0)
	            	    {
	            	    	    bed9 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property9_bed = wait.until(ExpectedConditions.presenceOfElementLocated(property9bed));
	    		            bed9 = property9_bed.getText(); 
	    		            bed9=bed9.replaceAll(" Bd", "");
	    		            prop9bed = Integer.parseInt(bed9);
				            desclist.add(prop9bed);
	            	    }
	            	    
	            		String bed10 = "";
	            		int prop10bed;
	            	    List <WebElement> iselementpresent10  = webdriver.findElements(property10bed);
	            	    int elementsize10 = iselementpresent10.size();
	            	    if (elementsize10 == 0)
	            	    {
	            	    	    bed10 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property10_bed = wait.until(ExpectedConditions.presenceOfElementLocated(property10bed));
	    		            bed10 = property10_bed.getText(); 
	    		            bed10=bed10.replaceAll(" Bd", "");
	    		            prop10bed = Integer.parseInt(bed10);
				            desclist.add(prop10bed);
	            	    }

				    String original = "["+bed1+" "+bed2+" "+bed3+" "+bed4+" "+bed5+" "+bed6+" "+bed7+" "+bed8+" "+bed9+" "+bed10+"]";
				    //original = original.replace(", , ", ", ");
				         
		            MiscMethods.sortDescending(desclist);
		            String sorteddesc = MiscMethods.returnsStringforIntegerArrayList(desclist);
		            
		            
		            log.info("Original order is: "+original+"\n");
		            log.info("Sorted descending order is: "+sorteddesc+"\n");
		            
		            if (original.equalsIgnoreCase(sorteddesc))
		            {
		            	    log.info("It has sorted in descending order.");
		            	    diditsort = "yes";
		            }
		            else
		            {
		            	    log.info("It failed to sort in descending order.");
		            	    diditsort = "no";
		            }
		            

		            return diditsort;
		    }
			 
			 public static String sortResultsByAscBeds (WebDriver webdriver) throws InterruptedException
			 {
				    WebDriverWait wait = new WebDriverWait (webdriver, 60);
			    		WebElement clicksortby = wait.until(ExpectedConditions.elementToBeClickable(sortbyclicktoexpanddrpdown));
			    		clicksortby.click();
			    		
			    		Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
			    		
			    		WebElement dropdownareabox = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownarea));
			    		Actions action = new Actions(webdriver);
			    	    action.moveToElement(dropdownareabox).perform();
		            action.sendKeys(Keys.ARROW_DOWN);
		            action.sendKeys(Keys.ARROW_DOWN);
		            WebElement clicksortbybeds= wait.until(ExpectedConditions.elementToBeClickable(sortbydropdownbeds));
		    		   //first click bed sorts by descending order, 2nd click on the arrow then sorts by ascending order
		           action.moveToElement(clicksortbybeds).click().perform();
		           
		            Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
		    			        
			        WebElement uparrow = webdriver.findElement(sortasc);
	            		uparrow.click(); //first click price sorts by descending order, 2nd click on the arrow then sorts by ascending order
	            			
	            		Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
			    		
	            		ArrayList<Integer> asclist = new ArrayList<Integer> ();

	            		String bed1 = "";
	            		int prop1bed;
	            	    List <WebElement> iselementpresent1  = webdriver.findElements(property1bed);
	            	    int elementsize1 = iselementpresent1.size();
	            	    if (elementsize1 == 0)
	            	    {
	            	    	    bed1 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property1_bed = wait.until(ExpectedConditions.presenceOfElementLocated(property1bed));
        		            bed1 = property1_bed.getText(); 
        		            bed1=bed1.replaceAll(" Bd", "");
        		            prop1bed = Integer.parseInt(bed1);
    			            asclist.add(prop1bed);
	            	    }
		           
	            		String bed2 = "";
	            		int prop2bed;
	            	    List <WebElement> iselementpresent2  = webdriver.findElements(property2bed);
	            	    int elementsize2 = iselementpresent2.size();
	            	    if (elementsize2 == 0)
	            	    {
	            	    	    bed2 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property2_bed = wait.until(ExpectedConditions.presenceOfElementLocated(property2bed));
        		            bed2 = property2_bed.getText(); 
        		            bed2=bed2.replaceAll(" Bd", "");
        		            prop2bed = Integer.parseInt(bed2);
    			            asclist.add(prop2bed);
	            	    }

	            		String bed3 = "";
	            		int prop3bed;
	            	    List <WebElement> iselementpresent3  = webdriver.findElements(property3bed);
	            	    int elementsize3 = iselementpresent3.size();
	            	    if (elementsize3 == 0)
	            	    {
	            	    	    bed3 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property3_bed = wait.until(ExpectedConditions.presenceOfElementLocated(property3bed));
        		            bed3 = property3_bed.getText(); 
        		            bed3=bed3.replaceAll(" Bd", "");
        		            prop3bed = Integer.parseInt(bed3);
    			            asclist.add(prop3bed);
	            	    }

	            		String bed4 = "";
	            		int prop4bed;
	            	    List <WebElement> iselementpresent4  = webdriver.findElements(property4bed);
	            	    int elementsize4 = iselementpresent4.size();
	            	    if (elementsize4 == 0)
	            	    {
	            	    	    bed4 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property4_bed = wait.until(ExpectedConditions.presenceOfElementLocated(property4bed));
        		            bed4 = property4_bed.getText(); 
        		            bed4=bed4.replaceAll(" Bd", "");
        		            prop4bed = Integer.parseInt(bed4);
    			            asclist.add(prop4bed);
	            	    }	            	    

	            		String bed5 = "";
	            		int prop5bed;
	            	    List <WebElement> iselementpresent5  = webdriver.findElements(property5bed);
	            	    int elementsize5 = iselementpresent5.size();
	            	    if (elementsize5 == 0)
	            	    {
	            	    	    bed5 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property5_bed = wait.until(ExpectedConditions.presenceOfElementLocated(property5bed));
        		            bed5 = property5_bed.getText(); 
        		            bed5=bed5.replaceAll(" Bd", "");
        		            prop5bed = Integer.parseInt(bed5);
    			            asclist.add(prop5bed);
	            	    }
	            	    
	            		String bed6 = "";
	            		int prop6bed;
	            	    List <WebElement> iselementpresent6  = webdriver.findElements(property6bed);
	            	    int elementsize6 = iselementpresent6.size();
	            	    if (elementsize6 == 0)
	            	    {
	            	    	    bed6 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property6_bed = wait.until(ExpectedConditions.presenceOfElementLocated(property6bed));
        		            bed6 = property6_bed.getText(); 
        		            bed6=bed6.replaceAll(" Bd", "");
        		            prop6bed = Integer.parseInt(bed6);
    			            asclist.add(prop6bed);
	            	    }
	            	    
	            		String bed7 = "";
	            		int prop7bed;
	            	    List <WebElement> iselementpresent7  = webdriver.findElements(property7bed);
	            	    int elementsize7 = iselementpresent7.size();
	            	    if (elementsize7 == 0)
	            	    {
	            	    	    bed7 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property7_bed = wait.until(ExpectedConditions.presenceOfElementLocated(property7bed));
        		            bed7 = property7_bed.getText(); 
        		            bed7=bed7.replaceAll(" Bd", "");
        		            prop7bed = Integer.parseInt(bed7);
    			            asclist.add(prop7bed);
	            	    }
	            	    
	            		String bed8 = "";
	            		int prop8bed;
	            	    List <WebElement> iselementpresent8  = webdriver.findElements(property8bed);
	            	    int elementsize8 = iselementpresent8.size();
	            	    if (elementsize8 == 0)
	            	    {
	            	    	    bed8 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property8_bed = wait.until(ExpectedConditions.presenceOfElementLocated(property8bed));
        		            bed8 = property8_bed.getText(); 
        		            bed8=bed8.replaceAll(" Bd", "");
        		            prop8bed = Integer.parseInt(bed8);
    			            asclist.add(prop8bed);
	            	    }
	            	    
	            		String bed9 = "";
	            		int prop9bed;
	            	    List <WebElement> iselementpresent9  = webdriver.findElements(property9bed);
	            	    int elementsize9 = iselementpresent9.size();
	            	    if (elementsize9 == 0)
	            	    {
	            	    	    bed9 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property9_bed = wait.until(ExpectedConditions.presenceOfElementLocated(property9bed));
        		            bed9 = property9_bed.getText(); 
        		            bed9=bed9.replaceAll(" Bd", "");
        		            prop9bed = Integer.parseInt(bed9);
    			            asclist.add(prop9bed);
	            	    }
	            	    
	            		String bed10 = "";
	            		int prop10bed;
	            	    List <WebElement> iselementpresent10  = webdriver.findElements(property10bed);
	            	    int elementsize10 = iselementpresent10.size();
	            	    if (elementsize10 == 0)
	            	    {
	            	    	    bed10 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property10_bed = wait.until(ExpectedConditions.presenceOfElementLocated(property10bed));
        		            bed10 = property10_bed.getText(); 
        		            bed10=bed10.replaceAll(" Bd", "");
        		            prop10bed = Integer.parseInt(bed10);
    			            asclist.add(prop10bed);
	            	    }

			        String original = "["+bed1+" "+bed2+" "+bed3+" "+bed4+" "+bed5+" "+bed6+" "+bed7+" "+bed8+" "+bed9+" "+bed10+"]";
			        //original = original.replace(", , ", ", ");
			            
		            MiscMethods.sortAscending(asclist);
		            String sortedasc = MiscMethods.returnsStringforIntegerArrayList(asclist);
		            
		            
		            log.info("Original order is: "+original+"\n");
		            log.info("Sorted ascending order is: "+sortedasc+"\n");
		            
		            if (original.equalsIgnoreCase(sortedasc))
		            {
		            	    log.info("It has sorted in ascending order.");
		            	    diditsort = "yes";
		            }
		            else
		            {
		            	    log.info("It failed to sort in ascending order.");
		            	    diditsort = "no";
		            }
	           
	            return diditsort;
		    }
			 
			 public static String sortResultsByDescBaths (WebDriver webdriver) throws InterruptedException
			    {
				 
			    		WebDriverWait wait = new WebDriverWait (webdriver, 60);
			    		WebElement clicksortby = wait.until(ExpectedConditions.elementToBeClickable(sortbyclicktoexpanddrpdown));
			    		clicksortby.click();

			    		Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
			    		
			    		WebElement dropdownareabox = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownarea));
			    		Actions action = new Actions(webdriver);
			    	    action.moveToElement(dropdownareabox).perform();
		            action.sendKeys(Keys.ARROW_DOWN);
		            action.sendKeys(Keys.ARROW_DOWN);
			    		WebElement clicksortbybaths= wait.until(ExpectedConditions.elementToBeClickable(sortbydropdownbaths));
			    		//first click bed sorts by descending order, 2nd click on the arrow then sorts by ascending order
			        action.moveToElement(clicksortbybaths).click().perform();
			        
			        Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
		    		
		            
		            ArrayList<Integer> desclist = new ArrayList<Integer> ();

	            		String bath1 = "";
	            		int prop1bath;
	            	    List <WebElement> iselementpresent1  = webdriver.findElements(property1bath);
	            	    int elementsize1 = iselementpresent1.size();
	            	    if (elementsize1 == 0)
	            	    {
	            	    	    bath1 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property1_bath = wait.until(ExpectedConditions.presenceOfElementLocated(property1bath));
	    		            bath1 = property1_bath.getText(); 
	    		            bath1=bath1.replaceAll(" Ba", "");
	    		            bath1=bath1.replaceAll(" Full/1 Half", "");
	    		            bath1=bath1.replaceAll(" Full", "");
	    		            prop1bath = Integer.parseInt(bath1);
	    		            desclist.add(prop1bath);
	            	    }
		           
	            		String bath2 = "";
	            		int prop2bath;
	            	    List <WebElement> iselementpresent2  = webdriver.findElements(property2bath);
	            	    int elementsize2 = iselementpresent2.size();
	            	    if (elementsize2 == 0)
	            	    {
	            	    	    bath2 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property2_bath = wait.until(ExpectedConditions.presenceOfElementLocated(property2bath));
	    		            bath2 = property2_bath.getText(); 
	    		            bath2=bath2.replaceAll(" Ba", "");
	    		            bath2=bath2.replaceAll(" Full/1 Half", "");
	    		            bath2=bath2.replaceAll(" Full", "");
	    		            prop2bath = Integer.parseInt(bath2);
	    		            desclist.add(prop2bath);
	            	    }
	
	            		String bath3 = "";
	            		int prop3bath;
	            	    List <WebElement> iselementpresent3  = webdriver.findElements(property3bath);
	            	    int elementsize3 = iselementpresent3.size();
	            	    if (elementsize3 == 0)
	            	    {
	            	    	    bath3 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property3_bath = wait.until(ExpectedConditions.presenceOfElementLocated(property3bath));
	    		            bath3 = property3_bath.getText(); 
	    		            bath3=bath3.replaceAll(" Ba", "");
	    		            bath3=bath3.replaceAll(" Full/1 Half", "");
	    		            bath3=bath3.replaceAll(" Full", "");
	    		            prop3bath = Integer.parseInt(bath3);
	    		            desclist.add(prop3bath);
	            	    }
	
	            		String bath4 = "";
	            		int prop4bath;
	            	    List <WebElement> iselementpresent4  = webdriver.findElements(property4bath);
	            	    int elementsize4 = iselementpresent4.size();
	            	    if (elementsize4 == 0)
	            	    {
	            	    	    bath4 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property4_bath = wait.until(ExpectedConditions.presenceOfElementLocated(property4bath));
	    		            bath4 = property4_bath.getText(); 
	    		            bath4=bath4.replaceAll(" Ba", "");
	    		            bath4=bath4.replaceAll(" Full/1 Half", "");
	    		            bath4=bath4.replaceAll(" Full", "");
	    		            prop4bath = Integer.parseInt(bath4);
	    		            desclist.add(prop4bath);
	            	    }	            	    
	
	            		String bath5 = "";
	            		int prop5bath;
	            	    List <WebElement> iselementpresent5  = webdriver.findElements(property5bath);
	            	    int elementsize5 = iselementpresent5.size();
	            	    if (elementsize5 == 0)
	            	    {
	            	    	    bath5 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property5_bath = wait.until(ExpectedConditions.presenceOfElementLocated(property5bath));
	    		            bath5 = property5_bath.getText(); 
	    		            bath5=bath5.replaceAll(" Ba", "");
	    		            bath5=bath5.replaceAll(" Full/1 Half", "");
	    		            bath5=bath5.replaceAll(" Full", "");
	    		            prop5bath = Integer.parseInt(bath5);
	    		            desclist.add(prop5bath);
	            	    }
	            	    
	            		String bath6 = "";
	            		int prop6bath;
	            	    List <WebElement> iselementpresent6  = webdriver.findElements(property6bath);
	            	    int elementsize6 = iselementpresent6.size();
	            	    if (elementsize6 == 0)
	            	    {
	            	    	    bath6 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property6_bath = wait.until(ExpectedConditions.presenceOfElementLocated(property6bath));
	    		            bath6 = property6_bath.getText(); 
	    		            bath6=bath6.replaceAll(" Ba", "");
	    		            bath6=bath6.replaceAll(" Full/1 Half", "");
	    		            bath6=bath6.replaceAll(" Full", "");
	    		            prop6bath = Integer.parseInt(bath6);
	    		            desclist.add(prop6bath);
	            	    }
	            	    
	            		String bath7 = "";
	            		int prop7bath;
	            	    List <WebElement> iselementpresent7  = webdriver.findElements(property7bath);
	            	    int elementsize7 = iselementpresent7.size();
	            	    if (elementsize7 == 0)
	            	    {
	            	    	    bath7 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property7_bath = wait.until(ExpectedConditions.presenceOfElementLocated(property7bath));
	    		            bath7 = property7_bath.getText(); 
	    		            bath7=bath7.replaceAll(" Ba", "");
	    		            bath7=bath7.replaceAll(" Full/1 Half", "");
	    		            bath7=bath7.replaceAll(" Full", "");
	    		            prop7bath = Integer.parseInt(bath7);
	    		            desclist.add(prop7bath);
	            	    }
	            	    
	            		String bath8 = "";
	            		int prop8bath;
	            	    List <WebElement> iselementpresent8  = webdriver.findElements(property8bath);
	            	    int elementsize8 = iselementpresent8.size();
	            	    if (elementsize8 == 0)
	            	    {
	            	    	    bath8 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property8_bath = wait.until(ExpectedConditions.presenceOfElementLocated(property8bath));
	    		            bath8 = property8_bath.getText(); 
	    		            bath8=bath8.replaceAll(" Ba", "");
	    		            bath8=bath8.replaceAll(" Full/1 Half", "");
	    		            bath8=bath8.replaceAll(" Full", "");
	    		            prop8bath = Integer.parseInt(bath8);
	    		            desclist.add(prop8bath);
	            	    }
	            	    
	            		String bath9 = "";
	            		int prop9bath;
	            	    List <WebElement> iselementpresent9  = webdriver.findElements(property9bath);
	            	    int elementsize9 = iselementpresent9.size();
	            	    if (elementsize9 == 0)
	            	    {
	            	    	    bath9 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property9_bath = wait.until(ExpectedConditions.presenceOfElementLocated(property9bath));
	    		            bath9 = property9_bath.getText(); 
	    		            bath9=bath9.replaceAll(" Ba", "");
	    		            bath9=bath9.replaceAll(" Full/1 Half", "");
	    		            bath9=bath9.replaceAll(" Full", "");
	    		            prop9bath = Integer.parseInt(bath9);
	    		            desclist.add(prop9bath);
	            	    }
	            	    
	            		String bath10 = "";
	            		int prop10bath;
	            	    List <WebElement> iselementpresent10  = webdriver.findElements(property10bath);
	            	    int elementsize10 = iselementpresent10.size();
	            	    if (elementsize10 == 0)
	            	    {
	            	    	    bath10 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property10_bath = wait.until(ExpectedConditions.presenceOfElementLocated(property10bath));
	    		            bath10 = property10_bath.getText(); 
	    		            bath10=bath10.replaceAll(" Ba", "");
	    		            bath10=bath10.replaceAll(" Full/1 Half", "");
	    		            bath10=bath10.replaceAll(" Full", "");
	    		            prop10bath = Integer.parseInt(bath10);
	    		            desclist.add(prop10bath);
	            	    }

			        String original = "["+bath1+" "+bath2+" "+bath3+" "+bath4+" "+bath5+" "+bath6+" "+bath7+" "+bath8+" "+bath9+" "+bath10+"]";
			        //original = original.replace(", , ", ", ");
			            
		            MiscMethods.sortDescending(desclist);
		            String sorteddesc = MiscMethods.returnsStringforIntegerArrayList(desclist);
		            
		            
		            log.info("Original order is: "+original+"\n");
		            log.info("Sorted descending order is: "+sorteddesc+"\n");
		            
		            if (original.equalsIgnoreCase(sorteddesc))
		            {
		            	    log.info("It has sorted in descending order.");
		            	    diditsort = "yes";
		            }
		            else
		            {
		            	    log.info("It failed to sort in descending order.");
		            	    diditsort = "no";
		            }
		            

		            return diditsort;
		    }
			 
			 public static String sortResultsByAscBaths (WebDriver webdriver) throws InterruptedException
			 {
				    WebDriverWait wait = new WebDriverWait (webdriver, 60);
			    		WebElement clicksortby = wait.until(ExpectedConditions.elementToBeClickable(sortbyclicktoexpanddrpdown));
			    		clicksortby.click();
			    		
			    		Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
			    		
			    		WebElement dropdownareabox = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownarea));
			    		Actions action = new Actions(webdriver);
			    	    action.moveToElement(dropdownareabox).perform();
		            action.sendKeys(Keys.ARROW_DOWN);
		            action.sendKeys(Keys.ARROW_DOWN);
		            WebElement clicksortbybaths= wait.until(ExpectedConditions.elementToBeClickable(sortbydropdownbaths));
		    		   //first click bed sorts by descending order, 2nd click on the arrow then sorts by ascending order
		           action.moveToElement(clicksortbybaths).click().perform();
		           
		            Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
		    			        
			        WebElement uparrow = webdriver.findElement(sortasc);
	            		uparrow.click(); //first click price sorts by descending order, 2nd click on the arrow then sorts by ascending order
	            			
	            		Thread.sleep(4000); //Must wait for this time to load, cant use implicit wait, because it will find the element, but the element is not in the state i want it at yet
			    		
			            
		            ArrayList<Integer> asclist = new ArrayList<Integer> ();
	            		
	            		String bath1 = "";
	            		int prop1bath;
	            	    List <WebElement> iselementpresent1  = webdriver.findElements(property1bath);
	            	    int elementsize1 = iselementpresent1.size();
	            	    if (elementsize1 == 0)
	            	    {
	            	    	    bath1 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property1_bath = wait.until(ExpectedConditions.presenceOfElementLocated(property1bath));
        		            bath1 = property1_bath.getText(); 
        		            bath1=bath1.replaceAll(" Ba", "");
        		            bath1=bath1.replaceAll(" Full/1 Half", "");
        		            bath1=bath1.replaceAll(" Full", "");
        		            prop1bath = Integer.parseInt(bath1);
        		            asclist.add(prop1bath);
	            	    }
		           
	            		String bath2 = "";
	            		int prop2bath;
	            	    List <WebElement> iselementpresent2  = webdriver.findElements(property2bath);
	            	    int elementsize2 = iselementpresent2.size();
	            	    if (elementsize2 == 0)
	            	    {
	            	    	    bath2 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property2_bath = wait.until(ExpectedConditions.presenceOfElementLocated(property2bath));
        		            bath2 = property2_bath.getText(); 
        		            bath2=bath2.replaceAll(" Ba", "");
        		            bath2=bath2.replaceAll(" Full/1 Half", "");
        		            bath2=bath2.replaceAll(" Full", "");
        		            prop2bath = Integer.parseInt(bath2);
        		            asclist.add(prop2bath);
	            	    }

	            		String bath3 = "";
	            		int prop3bath;
	            	    List <WebElement> iselementpresent3  = webdriver.findElements(property3bath);
	            	    int elementsize3 = iselementpresent3.size();
	            	    if (elementsize3 == 0)
	            	    {
	            	    	    bath3 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property3_bath = wait.until(ExpectedConditions.presenceOfElementLocated(property3bath));
        		            bath3 = property3_bath.getText(); 
        		            bath3=bath3.replaceAll(" Ba", "");
        		            bath3=bath3.replaceAll(" Full/1 Half", "");
        		            bath3=bath3.replaceAll(" Full", "");
        		            prop3bath = Integer.parseInt(bath3);
          		        asclist.add(prop3bath);
	            	    }

	            		String bath4 = "";
	            		int prop4bath;
	            	    List <WebElement> iselementpresent4  = webdriver.findElements(property4bath);
	            	    int elementsize4 = iselementpresent4.size();
	            	    if (elementsize4 == 0)
	            	    {
	            	    	    bath4 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property4_bath = wait.until(ExpectedConditions.presenceOfElementLocated(property4bath));
        		            bath4 = property4_bath.getText(); 
        		            bath4=bath4.replaceAll(" Ba", "");
        		            bath4=bath4.replaceAll(" Full/1 Half", "");
        		            bath4=bath4.replaceAll(" Full", "");
        		            prop4bath = Integer.parseInt(bath4);
        		            asclist.add(prop4bath);
	            	    }	            	    

	            		String bath5 = "";
	            		int prop5bath;
	            	    List <WebElement> iselementpresent5  = webdriver.findElements(property5bath);
	            	    int elementsize5 = iselementpresent5.size();
	            	    if (elementsize5 == 0)
	            	    {
	            	    	    bath5 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property5_bath = wait.until(ExpectedConditions.presenceOfElementLocated(property5bath));
        		            bath5 = property5_bath.getText(); 
        		            bath5=bath5.replaceAll(" Ba", "");
        		            bath5=bath5.replaceAll(" Full/1 Half", "");
        		            bath5=bath5.replaceAll(" Full", "");
        		            prop5bath = Integer.parseInt(bath5);
        		            asclist.add(prop5bath);
	            	    }
	            	    
	            		String bath6 = "";
	            		int prop6bath;
	            	    List <WebElement> iselementpresent6  = webdriver.findElements(property6bath);
	            	    int elementsize6 = iselementpresent6.size();
	            	    if (elementsize6 == 0)
	            	    {
	            	    	    bath6 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property6_bath = wait.until(ExpectedConditions.presenceOfElementLocated(property6bath));
        		            bath6 = property6_bath.getText(); 
        		            bath6=bath6.replaceAll(" Ba", "");
        		            bath6=bath6.replaceAll(" Full/1 Half", "");
        		            bath6=bath6.replaceAll(" Full", "");
        		            prop6bath = Integer.parseInt(bath6);
        		            asclist.add(prop6bath);
	            	    }
	            	    
	            		String bath7 = "";
	            		int prop7bath;
	            	    List <WebElement> iselementpresent7  = webdriver.findElements(property7bath);
	            	    int elementsize7 = iselementpresent7.size();
	            	    if (elementsize7 == 0)
	            	    {
	            	    	    bath7 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property7_bath = wait.until(ExpectedConditions.presenceOfElementLocated(property7bath));
        		            bath7 = property7_bath.getText(); 
        		            bath7=bath7.replaceAll(" Ba", "");
        		            bath7=bath7.replaceAll(" Full/1 Half", "");
        		            bath7=bath7.replaceAll(" Full", "");
        		            prop7bath = Integer.parseInt(bath7);
        		            asclist.add(prop7bath);
	            	    }
	            	    
	            		String bath8 = "";
	            		int prop8bath;
	            	    List <WebElement> iselementpresent8  = webdriver.findElements(property8bath);
	            	    int elementsize8 = iselementpresent8.size();
	            	    if (elementsize8 == 0)
	            	    {
	            	    	    bath8 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property8_bath = wait.until(ExpectedConditions.presenceOfElementLocated(property8bath));
        		            bath8 = property8_bath.getText(); 
        		            bath8=bath8.replaceAll(" Ba", "");
        		            bath8=bath8.replaceAll(" Full/1 Half", "");
        		            bath8=bath8.replaceAll(" Full", "");
        		            prop8bath = Integer.parseInt(bath8);
        		            asclist.add(prop8bath);
	            	    }
	            	    
	            		String bath9 = "";
	            		int prop9bath;
	            	    List <WebElement> iselementpresent9  = webdriver.findElements(property9bath);
	            	    int elementsize9 = iselementpresent9.size();
	            	    if (elementsize9 == 0)
	            	    {
	            	    	    bath9 = "";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property9_bath = wait.until(ExpectedConditions.presenceOfElementLocated(property9bath));
        		            bath9 = property9_bath.getText(); 
        		            bath9=bath9.replaceAll(" Ba", "");
        		            bath9=bath9.replaceAll(" Full/1 Half", "");
        		            bath9=bath9.replaceAll(" Full", "");
        		            prop9bath = Integer.parseInt(bath9);
        		            asclist.add(prop9bath);
	            	    }
	            	    
	            		String bath10 = "";
	            		int prop10bath;
	            	    List <WebElement> iselementpresent10  = webdriver.findElements(property10bath);
	            	    int elementsize10 = iselementpresent10.size();
	            	    if (elementsize10 == 0)
	            	    {
	            	    	    bath10="";
	            	    }
	            	    else
	            	    {
	            	    		WebElement property10_bath = wait.until(ExpectedConditions.presenceOfElementLocated(property10bath));
        		            bath10 = property10_bath.getText(); 
        		            bath10=bath10.replaceAll(" Ba", "");
        		            bath10=bath10.replaceAll(" Full/1 Half", "");
        		            bath10=bath10.replaceAll(" Full", "");
        		            prop10bath = Integer.parseInt(bath10);
        		            asclist.add(prop10bath);
	            	    }

		            String original = "["+bath1+" "+bath2+" "+bath3+" "+bath4+" "+bath5+" "+bath6+" "+bath7+" "+bath8+" "+bath9+" "+bath10+"]";
		            //original = original.replace(", , ", ", ");
		            
		            MiscMethods.sortAscending(asclist);
		            String sortedasc = MiscMethods.returnsStringforIntegerArrayList(asclist);
		            
		            
		            log.info("Original order is: "+original+"\n");
		            log.info("Sorted ascending order is: "+sortedasc+"\n");
		            
		            if (original.equalsIgnoreCase(sortedasc))
		            {
		            	    log.info("It has sorted in ascending order.");
		            	    diditsort = "yes";
		            }
		            else
		            {
		            	    log.info("It failed to sort in ascending order.");
		            	    diditsort = "no";
		            }
	           
	            return diditsort;
		    }
}
