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

public class MFilterByPropertyType extends TestBase{
	
    //****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Apr 2018  ***//
	//***                                  ***//
	//****************************************//
	
	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = LogManager.getLogger(MFilterByPropertyType.class);
	
	static String className = MFilterByPropertyType.class.getSimpleName();
 	static Date date1= new Date();
 	static String originaltimestamp = new Timestamp(date1.getTime()).toString();
 	static String timestamp = originaltimestamp.replace(':', 'x').substring(11);
	static String foldername = className+timestamp;
	static String errorname = "";


	@Test(groups= {"smoke", "regression"}, dataProvider = "getMobileData") 
	public void mFilterSingleFamily (String searchkeyword) throws IOException, InterruptedException
	{
		MLogin_Page.allowDeviceLocationAccess(driver);
		MSearch.searchhomes(driver, searchkeyword);
	    MFilterResults_Page.clickFilterOption(driver);
	    MFilterResults_Page.clickSingleFamily(driver);
	    MFilterResults_Page.clickApplyFilter(driver);
	    Thread.sleep(4000);
		String diditfilter = MFilterResults_Page.verifyFilterBySingleFamily(driver);

		try{
			Assert.assertEquals(diditfilter, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't filter by single family correctly.", e.getMessage());
			errorname = "didntfilterybysinglefamilycorrectly";
			ScreenshotURL.screenshotURL(driver, foldername, errorname);
			softAssert.fail();
		}


		   softAssert.assertAll();
	}

	
	@Test(groups= {"smoke", "regression"}, dataProvider = "getMobileData") 
	public void mFilterTownHome (String searchkeyword) throws IOException, InterruptedException
	{
		MLogin_Page.allowDeviceLocationAccess(driver);
		MSearch.searchhomes(driver, searchkeyword);
	    MFilterResults_Page.clickFilterOption(driver);
	    MFilterResults_Page.clickTownHome(driver);
	    MFilterResults_Page.clickApplyFilter(driver);
	    Thread.sleep(4000);
		String diditfilter = MFilterResults_Page.verifyFilterByTownHome(driver);

		try{
			Assert.assertEquals(diditfilter, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't filter by townhome correctly.", e.getMessage());
			errorname = "didntfilterybytownhomecorrectly";
			ScreenshotURL.screenshotURL(driver, foldername, errorname);
			softAssert.fail();
		}


		   softAssert.assertAll();
	}
	

	
	@Test(groups= {"smoke", "regression"}, dataProvider = "getMobileData") 
	public void mFilterCondo (String searchkeyword) throws IOException, InterruptedException
	{
		MLogin_Page.allowDeviceLocationAccess(driver);
		MSearch.searchhomes(driver, searchkeyword);
	    MFilterResults_Page.clickFilterOption(driver);
	    MFilterResults_Page.clickCondo(driver);
	    MFilterResults_Page.clickApplyFilter(driver);
	    Thread.sleep(4000);
		String diditfilter = MFilterResults_Page.verifyFilterByCondo(driver);

		try{
			Assert.assertEquals(diditfilter, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't filter by condo correctly.", e.getMessage());
			errorname = "didntfilterybycondocorrectly";
			ScreenshotURL.screenshotURL(driver, foldername, errorname);
			softAssert.fail();
		}


		   softAssert.assertAll();
	}
	
}
