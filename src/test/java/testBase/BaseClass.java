package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
//import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j

public  class BaseClass {
	
	public Logger logger;

	 static public WebDriver driver;/*to use same driver variable after creating
	 new baseclass object in extreportmanger also*/
	
	public Properties prop;
	
	@BeforeClass(groups= {"Sanity","Regression", "Master"})
	@Parameters({"operatingSystem","browser"})
public void setup(String os, String br) throws IOException {
		
		//loading properties file
		
	FileReader file=new FileReader("./src//test//resources//config.properties");// to read prop file
	prop = new Properties();
	prop.load(file);
	
	
	
	logger=LogManager.getLogger(this.getClass());//Log4j	
	
	//remote
	
	if(prop.getProperty("execution_env").equalsIgnoreCase("remote"))
	{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
		//os
		if(os.equalsIgnoreCase("windows"))
		{
			capabilities.setPlatform(Platform.WIN11);
		}
		else if (os.equalsIgnoreCase("mac"))
		{
			capabilities.setPlatform(Platform.MAC);
		}
		
		//adding linux
		else if (os.equalsIgnoreCase("linux"))
		{
			capabilities.setPlatform(Platform.LINUX);
		}
		else
		{
			System.out.println("No matching os");
			return;
		}
		
		//browser
		switch(br.toLowerCase())
		{
		case "chrome": capabilities.setBrowserName("chrome"); break;
		case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
		case "firefox": capabilities.setBrowserName("firefox"); break;
		default: System.out.println("No matching browser"); return;
		}
		
		//driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
	
		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
	
	}
	
	//local
	if(prop.getProperty("execution_env").equalsIgnoreCase("local")) {
		

		switch(br.toLowerCase()) {
		case "chrome": driver=new ChromeDriver();
		break;
		case "edge": driver=new EdgeDriver();
		break;
		case "firefox": driver=new FirefoxDriver();
		break;
		
		default: System.out.println(" wrong browser name buddy");
		return;
		}
		
	}
	
	
	
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(prop.getProperty("URL")); //reading url from prop file
	driver.manage().window().maximize();
}

@AfterClass(groups= {"Sanity","Regression", "Master"})
public void teardown() {
	driver.quit();
}

public String randomString()
{
	String generatedString=RandomStringUtils.randomAlphabetic(5);
	return generatedString;
}

public String randomNumber(){
	String generatedNumber=RandomStringUtils.randomNumeric(9);
	return generatedNumber;
}

public String randomAlphaNumber(){
	String generatedAlphaNumber=RandomStringUtils.randomAlphabetic(3);
	String generatedNumber=RandomStringUtils.randomNumeric(4);
	return generatedAlphaNumber+"@"+generatedNumber;
}

public String captureScreen(String tname) throws IOException {

	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	
	String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
	File targetFile=new File(targetFilePath);
	
	sourceFile.renameTo(targetFile);
		
	return targetFilePath;

}
}