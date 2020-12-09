package pack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class invocation {

	public WebDriver driver;
	public Properties pro;
	public FileInputStream fis;
	
	public WebDriver open() throws IOException
	{
		pro=new Properties();
		fis=new FileInputStream(".\\Utilities\\data.properties");
		pro.load(fis);
		 String str=pro.getProperty("browser");
		 
		 if(str.equals("firefox"))
		 {
			 System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
			 driver=new FirefoxDriver();
			 
		 }
		
		 else if(str.equals("chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			 driver=new ChromeDriver();
			 
		 }
		return driver;
		
	}
	
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	} 
	
}
