package generic_script;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Generic_script_testng implements Framework_const
{
	public WebDriver driver;
	@BeforeMethod
	public void openapp()
	{
		System.setProperty(chrome_key,chrome_value);
		driver=new ChromeDriver();
		driver.get(base_url);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	@AfterMethod
	public void closeappIn(ITestResult res) throws IOException
	{
		if(ITestResult.FAILURE==res.getStatus())
		{
			Takesscreenshot.getphoto(driver);
		}
		driver.close();
	}
	
	

}
