import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class alldigitnumber {
//step one
DesiredCapabilities caps =new DesiredCapabilities();
	
	@BeforeTest
	public void beforetest() throws MalformedURLException {
		File app = new File("src/calculator.apk");
		
	
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");// طريقه جديده يفضل استخدامها 
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "doaa");
		//caps.setCapability("chromdriverExecutable", "C:\\Users\\User\\Desktop\\chromewebdriver\\chromedriver.exe");
		//caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());// for application
	
		
		}
		
		  @Test() public void testAppium1() throws MalformedURLException {
		  AndroidDriver driver=new AndroidDriver (new
		  URL("http://127.0.0.1:4723/wd/hub"),caps);
		  //driver.get("https://www.google.com"); String str="8";
		  List<WebElement>myBottons=driver.findElements(By.className(
		  "android.widget.ImageButton"));
		  
		  for (int i=0;i<myBottons.size();i++) {
		  //System.out.println(myBottons.get(i).getAttribute("resource-id"));
		  
		  if (myBottons.get(i).getAttribute("resource-id").contains("digit")) {
		  
		  myBottons.get(i).click();}
		  
		  }
		  
Assertion myAssert = new Assertion();
		  
		  String ExpectedValue = "7894561230"; 
		  String Actual =
		  driver.findElement(By.id("com.google.android.calculator:id/formula")).getText
		  ();
		  myAssert.assertEquals(Actual, ExpectedValue);	
		  
		  
		  
		  }
		 
	
	

			@AfterTest
			public void aftertest() {}
	
	
}
