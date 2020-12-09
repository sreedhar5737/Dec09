package pack;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
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
}
