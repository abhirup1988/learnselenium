package com.learnautomation.pages;
import org.openqa.selenium.WebDriver;

import base_class.Dynamic_browser;

import com.learnautomation.pages.*;

public class verify_title {
	WebDriver driver;
	public verify_title(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public String get_title(){
	
		return driver.getTitle();
	
	}

}
