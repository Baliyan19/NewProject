package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression"})
	@Parameters({"browser"})
	public void setup(String br) throws IOException
	{
		FileReader file=new FileReader("C:\\Users\\kashi\\OneDrive\\Desktop\\EclipseWorkPlace3\\OpecartProject\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
	
		switch(br.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver();break;
		case "firefox": driver=new FirefoxDriver();break;
		case "edge": driver=new EdgeDriver();break;
		default: System.out.println("Invalid Browser Name");return;
		
		}
		
		//driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(p.getProperty("URL"));
		
	}
	
	@AfterClass(groups= {"Sanity","Regression"})
	public void teardown() throws InterruptedException
	{
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	public String StringDataGenerator()
	{
		String StringData= RandomStringUtils.randomAlphabetic(5);
		return StringData;
	}
	
	public String NumberDataGenerator()
	{
		String NumericData= RandomStringUtils.randomNumeric(10);
		return NumericData;
	}
	
	public String AlphaNumericRandom()
	{
		String strdata=RandomStringUtils.randomAlphabetic(3);
		String numdata=RandomStringUtils.randomNumeric(3);
		
		String AlphaNumeric= strdata+"#$%"+numdata;
		return AlphaNumeric;
	}
	
	public String captureScreen(String tname)
	{
		String timeStampt= new SimpleDateFormat("yyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File sourcefile= takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStampt+".png";
		File targetFile=new File(targetFilePath);
		
		 try {
		        Files.createDirectories(targetFile.getParentFile().toPath());
		        Files.copy(sourcefile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		
		return targetFilePath;
		
	}
	

}
