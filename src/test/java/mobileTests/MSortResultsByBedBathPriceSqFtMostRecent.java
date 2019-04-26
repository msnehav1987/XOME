package mobileTests;

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
import mobilePageObjects.MFilterResults_Page;
import mobilePageObjects.MLogin_Page;
import mobilePageObjects.MSearch;
import mobilePageObjects.MSortResults_Page;


public class MSortResultsByBedBathPriceSqFtMostRecent extends TestBase{
	
    //****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Apr 2018  ***//
	//***                                  ***//
	//****************************************//
	
	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = LogManager.getLogger(MSortResultsByBedBathPriceSqFtMostRecent.class);
	
	
	static String className = MSortResultsByBedBathPriceSqFtMostRecent.class.getSimpleName();
 	static Date date1= new Date();
 	static String originaltimestamp = new Timestamp(date1.getTime()).toString();
 	static String timestamp = originaltimestamp.replace(':', 'x').substring(11);
	static String foldername = className+timestamp;
	static String errorname = "";

	@Test(priority=1, groups= {"smoke", "regression"}, dataProvider = "getMobileData") 
	public void mSortByBed (String searchkeyword) throws IOException, InterruptedException
	{
		Thread.sleep(4000);
		MLogin_Page.allowDeviceLocationAccess(driver);
		MSearch.searchhomes(driver, searchkeyword);
		MFilterResults_Page.firstOpenAppFilterBySingleFamilyTownHomeCondo(driver);
		Thread.sleep(4000);
		String diditsort = MSortResults_Page.sortAndVerifyByBeds(driver);

		try{
			Assert.assertEquals(diditsort, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't sort by beds correctly.", e.getMessage());
			errorname = "didntsortybybedscorrectly";
			ScreenshotURL.screenshotURL(driver, foldername, errorname);
			softAssert.fail();
		}


		   softAssert.assertAll();
	}
	

	
	@Test(priority=2, groups= {"smoke", "regression"}, dataProvider = "getMobileData") 
	public void mSortByBath (String searchkeyword) throws IOException, InterruptedException
	{
		Thread.sleep(4000);
		MLogin_Page.allowDeviceLocationAccess(driver);
		MSearch.searchhomes(driver, searchkeyword);
		MFilterResults_Page.firstOpenAppFilterBySingleFamilyTownHomeCondo(driver);
		Thread.sleep(4000);
		String diditsort = MSortResults_Page.sortAndVerifyByBaths(driver);


		try{
			Assert.assertEquals(diditsort, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't sort by baths correctly.", e.getMessage());
			errorname = "didntsortbybathscorrectly";
			ScreenshotURL.screenshotURL(driver, foldername, errorname);
			softAssert.fail();
		}


		   softAssert.assertAll();
	}
	
	
	@Test(priority=3, groups= {"smoke", "regression"}, dataProvider = "getMobileData") 
	public void mSortByLowtoHighPrice (String searchkeyword) throws IOException, InterruptedException
	{
		Thread.sleep(4000);
		MLogin_Page.allowDeviceLocationAccess(driver);
		MSearch.searchhomes(driver, searchkeyword);
		MFilterResults_Page.firstOpenAppFilterBySingleFamilyTownHomeCondo(driver);
		Thread.sleep(4000);
		MSortResults_Page.sortByLowtoHighPrice(driver);
		String diditsort = MSortResults_Page.verifySortByLowtoHighPrice(driver);

		try{
			Assert.assertEquals(diditsort, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't sort by low to high price correctly.", e.getMessage());
			errorname = "didntsortbylowtohighpricecorrectly";
			ScreenshotURL.screenshotURL(driver, foldername, errorname);
			softAssert.fail();
		}


		   softAssert.assertAll();
	}


	
	@Test(priority=4, groups= {"smoke", "regression"}, dataProvider = "getMobileData") 
	public void mSortByHightoLowPrice (String searchkeyword) throws IOException, InterruptedException
	{
		Thread.sleep(4000);
		MLogin_Page.allowDeviceLocationAccess(driver);
		MSearch.searchhomes(driver, searchkeyword);
		MFilterResults_Page.firstOpenAppFilterBySingleFamilyTownHomeCondo(driver);
		Thread.sleep(4000);
		MSortResults_Page.sortByHightoLowPrice(driver);
		String diditsort = MSortResults_Page.verifySortByHightoLowPrice(driver);

		try{
			Assert.assertEquals(diditsort, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't sort by high to low price correctly.", e.getMessage());
			errorname = "didntsortbyhightolowpricecorrectly";
			ScreenshotURL.screenshotURL(driver, foldername, errorname);
			softAssert.fail();
		}


		   softAssert.assertAll();
	}


	@Test(priority=5, groups= {"smoke", "regression"}, dataProvider = "getMobileData") 
	public void mSortBySqFt (String searchkeyword) throws IOException, InterruptedException
	{
		Thread.sleep(4000);
		MLogin_Page.allowDeviceLocationAccess(driver);
		MSearch.searchhomes(driver, searchkeyword);
		MFilterResults_Page.firstOpenAppFilterBySingleFamilyTownHomeCondo(driver);
		Thread.sleep(4000);
		MSortResults_Page.sortBySqFt(driver);
		String diditsort = MSortResults_Page.verifySortBySquareFeet(driver);

		try{
			Assert.assertEquals(diditsort, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't sort by square feet correctly.", e.getMessage());
			errorname = "didntsortbysqftcorrectly";
			ScreenshotURL.screenshotURL(driver, foldername, errorname);
			softAssert.fail();
		}


		   softAssert.assertAll();
	}
	

	
	@Test(priority=6, groups= {"smoke", "regression"}, dataProvider = "getMobileData") 
	public void mSortByMostRecent (String searchkeyword) throws IOException, InterruptedException
	{
		Thread.sleep(4000);
		MLogin_Page.allowDeviceLocationAccess(driver);
		MSearch.searchhomes(driver, searchkeyword);
		MFilterResults_Page.firstOpenAppFilterBySingleFamilyTownHomeCondo(driver);
		Thread.sleep(4000);
		MSortResults_Page.sortByHightoLowPrice(driver);
		Thread.sleep(4000);
		MSortResults_Page.sortByMostRecent(driver);
		String diditsort = MSortResults_Page.verifySortByMostRecent(driver);

		try{
			Assert.assertEquals(diditsort, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't sort by most recent correctly.", e.getMessage());
			errorname = "didntsortbymostrecentcorrectly";
			ScreenshotURL.screenshotURL(driver, foldername, errorname);
			softAssert.fail();
		}


		   softAssert.assertAll();
	}


}
