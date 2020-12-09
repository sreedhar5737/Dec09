package pack;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import GR1.AR1.objects;

public class fblogin extends invocation {

	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	@BeforeTest
	
		
		public static ExtentReports getreportdata()
		{
			
			
			String str=System.getProperty("user.dir")+"\\report\\sreedhar.html";
			reporter=new ExtentSparkReporter(str);
			reporter.config().setDocumentTitle("Doc title");
			reporter.config().setReportName("report namee");
			extent=new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("sreedhar","automation");
			return extent;
			
		}
	
	@AfterSuite
	public void closee()
	{
		extent.flush();
	}
	
	@Test
	public void facebooktest() throws IOException
	{
		driver=open();
	 test=extent.createTest("test");
	test.info("sredharrrr");
	
	
		objects ob=new objects(driver);
		ExcelData_FBLogin fb=new ExcelData_FBLogin();
		ArrayList<String> oer=fb.xdata("user name", "facebook");
		String uname= (String) oer.get(1);
		//ExtentReporterNG.test.info("test has been started");
		driver.get(pro.getProperty("url"));
		ob.fname(uname);
		
		ob.lname(pro.getProperty("surname"));
		ob.phno(pro.getProperty("ph"));
		
		
			ob.password(pro.getProperty("password"));
			
	
		ob.day(pro.getProperty("day"));
		ob.year(pro.getProperty("year"));
		
	}
	
	@AfterMethod
	public void close()
	{
		driver.close();
	}
	
	
	
	
}
