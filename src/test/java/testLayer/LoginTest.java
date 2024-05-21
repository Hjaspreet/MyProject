package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseHRMClass;
import Pompackage.PomLogin;
import testdata.ExcelSheet;
 
public class LoginTest extends BaseHRMClass {
	PomLogin Log;
	// make constructor of this class parent class
	public LoginTest () {
		
		super();// specify to read properties of config.properties file
		}
	
	@BeforeMethod
	public void initialsetup() {initiate();
	
	screenshots("login");
	
	Log=new PomLogin();
	}
	
	
	@Test
	public void Title() {
		String actual=Log.verify();
		Assert.assertEquals(actual, "OrangeHRM");		
	}
	@DataProvider
	public Object[][] Details(){
		Object result[][]=ExcelSheet.readdata("sheet1");//make all methods to read data from excel sheet in excelsheet class
		return result;
	}
	
	
	
	@Test(dataProvider="Details")
	public void Login(String name ,String password) {
		Log.typeusername(name);
		Log.typepassword(password);
	    //Log.clickbtn();
	    
	    }
	
	@AfterMethod
	public void close() {
		driver.close();}
	}
	
	
	
