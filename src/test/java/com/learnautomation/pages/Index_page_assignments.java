package com.learnautomation.pages;


import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Index_page_assignments {
	
	WebDriver driver;
	public Index_page_assignments(WebDriver driver)
	{
		this.driver=driver;
	}

	public int count_no_box()
	{
		List<WebElement> box=driver.findElements(By.cssSelector(".boxed_style.block>li>a>figure"));
		int box_size=box.size();
		return box_size;
		
	}
	
	public int count_no_box_widget()
	{
		WebElement box=driver.findElement(By.xpath(".//*[@id='wrapper']/div[2]/div[2]/div[2]/ul"));
		String count =box.getText();
		int size=count.split("\n").length;
		System.out.println("Hi:Aiisgnment2 "+size);
		return size;
	}
}
