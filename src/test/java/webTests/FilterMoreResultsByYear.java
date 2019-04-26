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
import webPageObjects.FilterMoreResults_Page;
import webPageObjects.Search;

public class FilterMoreResultsByYear extends TestBase{
	
    //****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Apr 2018  ***//
	//***                                  ***//
	//****************************************//
	
	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = LogManager.getLogger(FilterMoreResultsByYear.class);
	
	
	static String className = FilterMoreResultsByYear.class.getSimpleName();
 	static Date date1= new Date();
 	static String originaltimestamp = new Timestamp(date1.getTime()).toString();
 	static String timestamp = originaltimestamp.replace(':', 'x').substring(11);
	static String foldername = className+timestamp;
	static String errorname = "";

	@Test(groups= {"smoke", "regression"}, dataProvider = "getData") 
	public void filterResultsByYear (String searchkeyword, String minyear, String maxyear) throws IOException, InterruptedException
	{
		Search.searchByCity(webdriver, searchkeyword);
		FilterMoreResults_Page.clickOpenMoreFilters(webdriver);
		FilterMoreResults_Page.filterByYear(webdriver, minyear, maxyear);
		FilterMoreResults_Page.applyMoreFilters(webdriver);
		String diditfilter = FilterMoreResults_Page.verifyFilterByYear(webdriver, minyear, maxyear);

		try{
			Assert.assertEquals(diditfilter, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't filter by year.", e.getMessage());
			errorname = "didntfilterbyyear";
			ScreenshotURL.screenshotURL(webdriver, foldername, errorname);
			softAssert.fail();
		}

		   softAssert.assertAll();
		
	}
}
