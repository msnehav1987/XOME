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
import webPageObjects.Search;
import webPageObjects.SortResults_Page;

public class SortResultsByPriceBedBath extends TestBase{
	
    //****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Apr 2018  ***//
	//***                                  ***//
	//****************************************//
	
	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = LogManager.getLogger(SortResultsByPriceBedBath.class);
	
	
	static String className = SortResultsByPriceBedBath.class.getSimpleName();
 	static Date date1= new Date();
 	static String originaltimestamp = new Timestamp(date1.getTime()).toString();
 	static String timestamp = originaltimestamp.replace(':', 'x').substring(11);
	static String foldername = className+timestamp;
	static String errorname = "";

		
	@Test(groups= {"smoke", "regression"}, dataProvider = "getData") 
	public void sortResultsByPrice (String searchkeyword) throws IOException, InterruptedException
	{
		Search.searchByCity(webdriver, searchkeyword);
	
		String diditsortdesc = SortResults_Page.sortResultsByDescPrice(webdriver);
		
		try{
			Assert.assertEquals(diditsortdesc, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't sort price by descending order.", e.getMessage());
			errorname = "didntsortpricedesc";
			ScreenshotURL.screenshotURL(webdriver, foldername, errorname);
			softAssert.fail();
		}
		

		String diditsortasc = SortResults_Page.sortResultsByAscPrice(webdriver);
		
		try{
			Assert.assertEquals(diditsortasc, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't sort price by ascending order.", e.getMessage());
			errorname = "didntsortpriceasc";
			ScreenshotURL.screenshotURL(webdriver, foldername, errorname);
			softAssert.fail();
		}

		
		   softAssert.assertAll();
	}

	@Test(groups= {"smoke", "regression"}, dataProvider = "getData") 
	public void sortResultsByBeds (String searchkeyword) throws IOException, InterruptedException
	{
		Search.searchByCity(webdriver, searchkeyword);
	
		String diditsortdesc = SortResults_Page.sortResultsByDescBeds(webdriver);
		
		try{
			Assert.assertEquals(diditsortdesc, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't sort beds by descending order.", e.getMessage());
			errorname = "didntsortbeddesc";
			ScreenshotURL.screenshotURL(webdriver, foldername, errorname);
			softAssert.fail();
		}
		

		String diditsortasc = SortResults_Page.sortResultsByAscBeds(webdriver);
		
		try{
			Assert.assertEquals(diditsortasc, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't sort beds by ascending order.", e.getMessage());
			errorname = "didntsortbedsasc";
			ScreenshotURL.screenshotURL(webdriver, foldername, errorname);
			softAssert.fail();
		}

		
		   softAssert.assertAll();
	}
	

	
	@Test(groups= {"smoke", "regression"}, dataProvider = "getData") 
	public void sortResultsByBaths (String searchkeyword) throws IOException, InterruptedException
	{
		Search.searchByCity(webdriver, searchkeyword);
	
		String diditsortdesc = SortResults_Page.sortResultsByDescBaths(webdriver);
		
		try{
			Assert.assertEquals(diditsortdesc, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't sort baths by descending order.", e.getMessage());
			errorname = "didntsortbathdesc";
			ScreenshotURL.screenshotURL(webdriver, foldername, errorname);
			softAssert.fail();
		}
		

		String diditsortasc = SortResults_Page.sortResultsByAscBaths(webdriver);
		
		try{
			Assert.assertEquals(diditsortasc, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't sort baths by ascending order.", e.getMessage());
			errorname = "didntsortbathsasc";
			ScreenshotURL.screenshotURL(webdriver, foldername, errorname);
			softAssert.fail();
		}

		
		   softAssert.assertAll();
	}
	
	
	@Test(groups= {"smoke", "regression"}, dataProvider = "getData") 
	public void sortResultsByMostRecent (String searchkeyword) throws IOException, InterruptedException
	{
		Search.searchByCity(webdriver, searchkeyword);
	
		String diditsortmostrecent = SortResults_Page.sortResultsByMostRecent(webdriver);
		
		try{
			Assert.assertEquals(diditsortmostrecent, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't sort by most recent order.", e.getMessage());
			errorname = "didntsortmostrecent";
			ScreenshotURL.screenshotURL(webdriver, foldername, errorname);
			softAssert.fail();
		}
	
		   softAssert.assertAll();
	}
}
