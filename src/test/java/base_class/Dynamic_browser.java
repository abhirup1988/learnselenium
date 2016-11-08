package base_class;
import Get_properties.Get_property;

import com.learnautomation.pages.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



//This program will dynamically select based on property file


public class Dynamic_browser {
WebDriver driver;
@BeforeTest
	public void open_browser()
	  {
		Get_property all_info=new Get_property();
		String[] all_information=all_info.credentials().split(",",5);
		String browser=all_information[0];
		String url=all_information[1];		
		String current_dir=System.getProperty("user.dir");
		System.out.println("Current directory is "+current_dir);
		
		try{
		if (browser.equals("Mozilla"))
		    {
				System.setProperty("webdriver.gecko.driver", current_dir+"\\browserdriver\\geckodriver.exe");
				driver=new FirefoxDriver();
				driver.get(url);
		    }
		else if (browser.equals("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", current_dir+"\\browserdriver\\chromedriver.exe");
			 driver=new ChromeDriver();
			driver.get(url);
			}
	   else if (browser.equals("IE"))
	   	{
	   System.setProperty("webdriver.ie.driver", current_dir+"\\browserdriver\\IEDriverServer.exe");
	        driver=new InternetExplorerDriver();
	        driver.get(url);
	       }
		}catch(Exception e){System.out.println("Unable to open Url");
			}
      driver.get(url);
	  }


@Test(priority=0)
private void ver_title(){
	verify_title title=new verify_title(driver);
	String title1=title.get_title();
	Assert.assertEquals("Welcome", title1);
}
		
@Test(priority=1)
private void Registration(){
	Registration reg=new Registration(driver);
	reg.Register_user();
		
}
@Test(priority=2)
private void Login(){
	Registration reg=new Registration(driver);
	reg.Login();	
}

@Test(priority=3)
private void Index_Assignment1_count_no_of_box(){
	Index_page_assignments box_count=new Index_page_assignments(driver);
int count=box_count.count_no_box();
	System.out.println(count);
	Assert.assertEquals(17, count);
}
	
@Test(priority=4)

public void Index_Assignment2() {
	Index_page_assignments reg=new Index_page_assignments(driver);
	int count=reg.count_no_box_widget();
	if(count==7)
	{
	driver.findElement(By.xpath(".//*[@id='wrapper']/div[2]/div[2]/div[4]/ul/li[2]/a/h2")).click();
	
	driver.navigate().to("http://way2automation.com/way2auto_jquery/index.php");
	}
	else
	{
		Assert.fail("Count_no_box_widget are not matching:Found- "+count+", Expected- 7");
	}
	
}

}
      

