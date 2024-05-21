package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseHRMClass {

	public static Properties prop=new Properties();
	public static WebDriver driver;
	
	// step1: constructor of this class
	
	public BaseHRMClass()  {
		try {
		FileInputStream file= new FileInputStream("C:\\Users\\1Onkar\\eclipse-workspace\\HRmanagement\\src\\test\\java\\enivironmentvariable\\config.properties");
		
		prop.load(file);
		}
		catch(FileNotFoundException e) {e.printStackTrace();}
		
		catch (IOException a) {a.printStackTrace();}
	}
		//step2: creating method for keeping all common commands
	
	
		public static void initiate() {
		String browsername=	prop.getProperty("browser");
		
		if(browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			
			driver=new ChromeDriver();}
		
			else if (browsername.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver","geckodriver.exe");
				driver=new FirefoxDriver();}
		
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(prop.getProperty("url"));
				
		}
		//code for screenshot
	public static void screenshots(String Filename) {
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(file, new File("C:\\Users\\1Onkar\\eclipse-workspace\\HRmanagement\\src\\test\\java\\screenshot\\Screenshots"+"Filename"+".jpg"));}
		catch (IOException e) {e.printStackTrace();
	}
		
}}