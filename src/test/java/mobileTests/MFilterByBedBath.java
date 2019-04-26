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

public class MFilterByBedBath extends TestBase{
	
    //****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Apr 2018  ***//
	//***                                  ***//
	//****************************************//
	
	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = LogManager.getLogger(MFilterByBedBath.class);
	
	
	static String className = MFilterByBedBath.class.getSimpleName();
 	static Date date1= new Date();
 	static String originaltimestamp = new Timestamp(date1.getTime()).toString();
 	static String timestamp = originaltimestamp.replace(':', 'x').substring(11);
	static String foldername = className+timestamp;
	static String errorname = "";

	@Test(groups= {"smoke", "regression"}, dataProvider = "getMobileData") 
	public void mFilterBed (String searchkeyword, String beds) throws IOException, InterruptedException
	{
		MLogin_Page.allowDeviceLocationAccess(driver);
		MSearch.searchhomes(driver, searchkeyword);
	    MFilterResults_Page.clickFilterOption(driver);
	    MFilterResults_Page.clickFilterByBed(driver, beds);
	    MFilterResults_Page.clickApplyFilter(driver);
		String diditfilter = MFilterResults_Page.verifyFilterByBeds(driver, beds);

		try{
			Assert.assertEquals(diditfilter, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't filter by beds correctly.", e.getMessage());
			errorname = "didntfilterybybedscorrectly";
			ScreenshotURL.screenshotURL(driver, foldername, errorname);
			softAssert.fail();
		}


		   softAssert.assertAll();
	}

	
	@Test(groups= {"smoke", "regression"}, dataProvider = "getMobileData") 
	public void mFilterBath (String searchkeyword, String baths) throws IOException, InterruptedException
	{
		MLogin_Page.allowDeviceLocationAccess(driver);
		MSearch.searchhomes(driver, searchkeyword);
	    MFilterResults_Page.clickFilterOption(driver);
	    MFilterResults_Page.clickFilterByBath(driver, baths);
	    MFilterResults_Page.clickApplyFilter(driver);
	    String diditfilter = MFilterResults_Page.verifyFilterByBaths(driver, baths);

		try{
			Assert.assertEquals(diditfilter, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't filter by baths correctly.", e.getMessage());
			errorname = "didntfilterybybathscorrectly";
			ScreenshotURL.screenshotURL(driver, foldername, errorname);
			softAssert.fail();
		}


		   softAssert.assertAll();
	}


}
