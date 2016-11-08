package com.learnautomation.pages;
import Get_properties.Get_property;

import org.testng.Assert;
import org.testng.SkipException;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registration {

	WebDriver driver;
	public Registration(WebDriver driver)
	{
		this.driver=driver;
	}
	
	Get_property all_info=new Get_property();
	protected String[] all_information=all_info.credentials().split(",",9);
	protected String name=all_information[2];
	protected String phone=all_information[3];
	protected String email=all_information[4];
	protected String country=all_information[5];
	protected String city=all_information[6];
	protected String username=all_information[7];
	protected String password=all_information[8];
	
public void Register_user()
	{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@id='wrapper']/div[2]/div[2]/div[1]/ul/li[1]/a/figure")).click();
	System.out.println("Hi" +name);
	String title=driver.getTitle();
	System.out.println(title);
	LinkedList<String> tabs2 = new LinkedList<String>(driver.getWindowHandles());
	try
		{
		////Switch to Index Page
		String title2=driver.switchTo().window(tabs2.get(1)).getTitle();
		System.out.println(title2);
		//Thread.sleep(5000);
		}catch(Exception e){Assert.fail("Unable to open the Index Page");}
		
	//Switch to registration Page
	try{
		
	    driver.switchTo().activeElement();
	    Thread.sleep(5000);
	} 
	catch(Exception e){throw new SkipException("Skipping this exception as the user is already logged in");}
	
		driver.findElement(By.cssSelector("div[id=load_box]>form>fieldset>input[name=name][type=text]")).sendKeys(name);
		driver.findElement(By.cssSelector("#load_form>fieldset>input[name=phone]")).sendKeys(phone);
		driver.findElement(By.cssSelector("#load_form>fieldset>input[name=email]")).sendKeys(email);
		WebElement cou_drop=driver.findElement(By.xpath(".//*[@id='load_form']/fieldset[4]/select"));
		List<WebElement> drop=cou_drop.findElements(By.tagName("option"));
		int drop_size=drop.size();
		for(int i=0;i<drop_size;i++)
			{   
			String select_value=drop.get(i).getText();
			if (select_value.equals(country))
				{
				drop.get(i).click();
				}	
			else{	}
}

	
driver.findElement(By.xpath(".//*[@id='load_form']/fieldset[5]/input")).sendKeys(city);
driver.findElement(By.xpath(".//*[@id='load_form']/fieldset[6]/input")).sendKeys(username);
driver.findElement(By.xpath(".//*[@id='load_form']/fieldset[7]/input")).sendKeys(password);
try
{
driver.findElement(By.cssSelector("div[id=load_box]>form[id=load_form]>div[class='bottom row']>div[align=center]>input[class=button]")).click();
Thread.sleep(5000);
}catch(Exception e){System.out.println("not found");}
}

public void Login()
{

String pageText = driver.findElement(By.xpath(".//*[@id='alert']")).getText();
System.out.print(pageText);
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
if(pageText.equals("Username or Password already exists."))
	
{
	
	driver.findElement(By.partialLinkText("Signin")).click();
	driver.findElement(By.cssSelector("div[id=login]>#load_form>fieldset>input[name=username]")).sendKeys(username);
	driver.findElement(By.cssSelector("div[id=login]>#load_form>fieldset>input[name=password]")).sendKeys(password);
	driver.findElement(By.cssSelector("div[id=login]>form[id=load_form]>div[class='bottom row']>div[align=center]>input[class=button]")).click();
}
else
	Assert.fail("you wandered onto the wrong path");
}

}


