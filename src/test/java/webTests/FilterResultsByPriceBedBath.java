package webTests;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.TestBase;
import common.ScreenshotURL;
import webPageObjects.FilterResults_Page;
import webPageObjects.Search;


public class FilterResultsByPriceBedBath extends TestBase{
	
    //****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Apr 2018  ***//
	//***                                  ***//
	//****************************************//
	
	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = LogManager.getLogger(FilterResultsByPriceBedBath.class);
	
	
	static String className = FilterResultsByPriceBedBath.class.getSimpleName();
 	static Date date1= new Date();
 	static String originaltimestamp = new Timestamp(date1.getTime()).toString();
 	static String timestamp = originaltimestamp.replace(':', 'x').substring(11);
	static String foldername = className+timestamp;
	static String errorname = "";

	@Test(groups= {"smoke", "regression"}, dataProvider = "getData") 
	public void filterResultsByPrice (String searchkeyword, String price1, String price2) throws IOException, InterruptedException
	{
		Search.searchByCity(webdriver, searchkeyword);
		FilterResults_Page.filterByPrice(webdriver, price1, price2);
		String diditfilter = FilterResults_Page.verifyFilterByPrice(webdriver, price1, price2);
		
		try{
			Assert.assertEquals(diditfilter, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't filter by price.", e.getMessage());
			errorname = "didntfilterbyprice";
			ScreenshotURL.screenshotURL(webdriver, foldername, errorname);
			softAssert.fail();
		}
		
		
		   softAssert.assertAll();
	}


	@Test(groups= {"smoke", "regression"}, dataProvider = "getData") 
	public void filterResultsByBeds (String searchkeyword, String bed) throws IOException, InterruptedException
	{
		Search.searchByCity(webdriver, searchkeyword);
		FilterResults_Page.filterByBeds(webdriver, bed);
		String diditfilter = FilterResults_Page.verifyFilterByBeds(webdriver, bed);
		
		try{
			Assert.assertEquals(diditfilter, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't filter by bed.", e.getMessage());
			errorname = "didntfilterbybed";
			ScreenshotURL.screenshotURL(webdriver, foldername, errorname);
			softAssert.fail();
		}
		
		
		   softAssert.assertAll();
	}
	
	@Test(groups= {"smoke", "regression"}, dataProvider = "getData") 
	public void filterResultsBybaths (String searchkeyword, String bath) throws IOException, InterruptedException
	{
		Search.searchByCity(webdriver, searchkeyword);
		FilterResults_Page.filterByBaths(webdriver, bath);
		String diditfilter = FilterResults_Page.verifyFilterByBaths(webdriver, bath);
		
		try{
			Assert.assertEquals(diditfilter, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't filter by bath.", e.getMessage());
			errorname = "didntfilterbybath";
			ScreenshotURL.screenshotURL(webdriver, foldername, errorname);
			softAssert.fail();
		}
		
		
		   softAssert.assertAll();
	}
	
}
