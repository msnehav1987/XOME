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

public class MFilterByYear extends TestBase{
	
    //****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Apr 2018  ***//
	//***                                  ***//
	//****************************************//
	
	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = LogManager.getLogger(MFilterByYear.class);
	
	static String className = MFilterByYear.class.getSimpleName();
 	static Date date1= new Date();
 	static String originaltimestamp = new Timestamp(date1.getTime()).toString();
 	static String timestamp = originaltimestamp.replace(':', 'x').substring(11);
	static String foldername = className+timestamp;
	static String errorname = "";

	@Test(groups= {"smoke", "regression"}, dataProvider = "getMobileData") 
	public void mFilterYear (String searchkeyword, String minyear, String maxyear) throws IOException, InterruptedException
	{
		MLogin_Page.allowDeviceLocationAccess(driver);
		MSearch.searchhomes(driver, searchkeyword);
	    MFilterResults_Page.clickFilterOption(driver);
	    MFilterResults_Page.clickFilterByMinYear(driver, minyear);
	    MFilterResults_Page.clickFilterByMaxYear(driver, maxyear);
	    MFilterResults_Page.clickSingleFamily(driver);
	    MFilterResults_Page.clickTownHome(driver);
	    MFilterResults_Page.clickCondo(driver);
	    MFilterResults_Page.clickApplyFilter(driver);
		String diditfilter = MFilterResults_Page.verifyFilterByYear(driver, minyear, maxyear);

		try{
			Assert.assertEquals(diditfilter, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't filter by year correctly.", e.getMessage());
			errorname = "didntfilterybyyearcorrectly";
			ScreenshotURL.screenshotURL(driver, foldername, errorname);
			softAssert.fail();
		}


		   softAssert.assertAll();
	}
	

}
