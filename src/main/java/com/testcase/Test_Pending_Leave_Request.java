package com.testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.Dashboard_page_Object;
import com.pom.Login_Page_Object;

import comonfuntions.function;

public class Test_Pending_Leave_Request extends function{
	String actualmessage=null;
	static Logger x=Logger.getLogger(Test_Pending_Leave_Request.class);
	public void login() {
		x.info("launching home");
		PageFactory.initElements(driver, Login_Page_Object.class);
		Login_Page_Object.username.sendKeys(properties.getProperty("username"));
		Login_Page_Object.password.sendKeys(properties.getProperty("password"));	
		Login_Page_Object.login.click();
		
	}
	public void getpendingleavereuest() {
		PageFactory.initElements(driver, Dashboard_page_Object.class);
	actualmessage = Dashboard_page_Object.pendingleaverequest.getText();
	}
	@Test
	public void verifypendingRequest() {
		login();
		x.info("getting the pending leave request details");
		getpendingleavereuest(); 
		x.info("verification");
		Assert.assertEquals(actualmessage, "No Records are Available");
		x.info("end of pending reuest");
	}
}
