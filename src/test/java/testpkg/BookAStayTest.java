package testpkg;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepkg.TajBaseClass;
import pagepkg.BookAStayPage;
import utilspkg.Excelutils;

public class BookAStayTest extends TajBaseClass{
	
	@DataProvider(name = "bookingData")
	public Object[][] bookingData() throws IOException {
	    String filePath = "./src/test/resources/testdata/TajBookAStay.xlsx";
	    String sheetName = "Sheet1";
	    return Excelutils.getTestData(filePath, sheetName);
	}
	@Test(dataProvider = "bookingData")
	public void bookAStayTest(String hotelName, String checkIn, String checkOut, String adults, String children) 
	{
		test = extent.createTest("Book A Stay - " + hotelName);
		int adultCount = Integer.parseInt(adults);
		int childCount = Integer.parseInt(children);
		BookAStayPage page = new BookAStayPage(driver);
		page.bookMthd();
		page.findHotelMthd(hotelName);
		page.clickDateField();
		page.selectDate(checkIn);
		page.selectDate(checkOut);
		page.closeCalendar();
		page.membersMthd(adultCount, childCount);
		page.checkRatesMthd(hotelName);
	    
	}

}
