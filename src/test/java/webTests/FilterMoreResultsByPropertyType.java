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

public class FilterMoreResultsByPropertyType extends TestBase{
	
    //****************************************//
	//***                                  ***//
	//*** Created by Angela Tong Apr 2018  ***//
	//***                                  ***//
	//****************************************//
	
	static SoftAssert softAssert = new SoftAssert();
	final static Logger log = LogManager.getLogger(FilterMoreResultsByPropertyType.class);
	
	
	static String className = FilterMoreResultsByPropertyType.class.getSimpleName();
 	static Date date1= new Date();
 	static String originaltimestamp = new Timestamp(date1.getTime()).toString();
 	static String timestamp = originaltimestamp.replace(':', 'x').substring(11);
	static String foldername = className+timestamp;
	static String errorname = "";

	@Test(groups= {"smoke", "regression"}, dataProvider = "getData") 
	public void filterResultsByPropertyTypeLand (String searchkeyword) throws IOException, InterruptedException
	{
		Search.searchByCity(webdriver, searchkeyword);
		FilterMoreResults_Page.clickOpenMoreFilters(webdriver);
		FilterMoreResults_Page.scrollDownMoreFiltersPage(webdriver);
		FilterMoreResults_Page.uncheckAllPropertyType(webdriver);
		FilterMoreResults_Page.filterByPropertyTypeLand(webdriver);
		FilterMoreResults_Page.applyMoreFilters(webdriver);
		String diditfilter = FilterMoreResults_Page.verifyFilterByPropertyTypeLand(webdriver);

		try{
			Assert.assertEquals(diditfilter, "yes");
		} 
		catch(AssertionError e)
		{ 
			log.error("Didn't filter by property type land.", e.getMessage());
			errorname = "didntfilterbypropertytypeland";
			ScreenshotURL.screenshotURL(webdriver, foldername, errorname);
			softAssert.fail();
		}

		   softAssert.assertAll();
	}
}
