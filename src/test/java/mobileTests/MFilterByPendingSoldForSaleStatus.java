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


public class MFilterByPendingSoldForSaleStatus extends TestBase{
	
    //****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Apr 2018  ***//
	//***                                  ***//
	//****************************************//
	
	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = LogManager.getLogger(MFilterByPendingSoldForSaleStatus.class);
	
	
	static String className = MFilterByPendingSoldForSaleStatus.class.getSimpleName();
 	static Date date1= new Date();
 	static String originaltimestamp = new Timestamp(date1.getTime()).toString();
 	static String timestamp = originaltimestamp.replace(':', 'x').substring(11);
	static String foldername = className+timestamp;
	static String errorname = "";

	@Test(groups= {"smoke", "regression"}, dataProvider = "getMobileData") 
	public void mFilterPending (String searchkeyword) throws IOException, InterruptedException
	{
		MLogin_Page.allowDeviceLocationAccess(driver);
		MSearch.searchhomes(driver, searchkeyword);
	    MFilterResults_Page.clickFilterOption(driver);
	    MFilterResults_Page.uncheckAllStatus(driver);
	    MFilterResults_Page.checkPendingStatus(driver);
	    MFilterResults_Page.clickApplyFilter(driver);
		String diditfilter = MFilterResults_Page.verifyPendingStatus(driver);

		try{
			Assert.assertEquals(diditfilter, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't filter by pending sales correctly.", e.getMessage());
			errorname = "didntfilterybypendingcorrectly";
			ScreenshotURL.screenshotURL(driver, foldername, errorname);
			softAssert.fail();
		}


		   softAssert.assertAll();
	}

	@Test(groups= {"smoke", "regression"}, dataProvider = "getMobileData") 
	public void mFilterSold (String searchkeyword) throws IOException, InterruptedException
	{
		MLogin_Page.allowDeviceLocationAccess(driver);
		MSearch.searchhomes(driver, searchkeyword);
	    MFilterResults_Page.clickFilterOption(driver);
	    MFilterResults_Page.uncheckAllStatus(driver);
	    MFilterResults_Page.checkSoldStatus(driver);
	    MFilterResults_Page.clickApplyFilter(driver);
		String diditfilter = MFilterResults_Page.verifySoldStatus(driver);

		try{
			Assert.assertEquals(diditfilter, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't filter by sold correctly.", e.getMessage());
			errorname = "didntfilterybysoldcorrectly";
			ScreenshotURL.screenshotURL(driver, foldername, errorname);
			softAssert.fail();
		}


		   softAssert.assertAll();
	}

	@Test(groups= {"smoke", "regression"}, dataProvider = "getMobileData") 
	public void mFilterForSale (String searchkeyword) throws IOException, InterruptedException
	{
		MLogin_Page.allowDeviceLocationAccess(driver);
		MSearch.searchhomes(driver, searchkeyword);
	    MFilterResults_Page.clickFilterOption(driver);
	    MFilterResults_Page.uncheckAllStatus(driver);
	    MFilterResults_Page.checkForSaleStatus(driver);
	    MFilterResults_Page.clickApplyFilter(driver);
		String diditfilter = MFilterResults_Page.verifyForSaleStatus(driver);
		
		try{
			Assert.assertEquals(diditfilter, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't filter by for sale correctly.", e.getMessage());
			errorname = "didntfilterybyforsalecorrectly";
			ScreenshotURL.screenshotURL(driver, foldername, errorname);
			softAssert.fail();
		}


		   softAssert.assertAll();
	}
	
}
