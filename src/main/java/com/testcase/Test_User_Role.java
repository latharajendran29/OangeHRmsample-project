package com.testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.User_Role_page_Object;

import comonfuntions.function;

public class Test_User_Role extends function{
	static Logger x=Logger.getLogger(Test_User_Role.class);
	public void movetouserpage() {
		User_Role_page_Object up=new User_Role_page_Object(driver);
		Actions ac=new Actions(driver);
	ac.moveToElement(up.getAdmin());
	ac.moveToElement(up.getUsermanagement());
	ac.moveToElement(up.getUsers());
	ac.click().build().perform();
	}
	public void selectuserrole() {
		User_Role_page_Object up=new User_Role_page_Object(driver);
	Select select=new Select(up.getUserrole());
	select.selectByIndex(1);
	}
	public void selectstatus() {
		User_Role_page_Object up=new User_Role_page_Object(driver);
		Select select=new Select(up.getStatus());
		select.selectByIndex(1);
	}
		@Test
	public void checkuserrole() {
			
				User_Role_page_Object up=new User_Role_page_Object(driver);
				x.info("navigation to usere page");
		movetouserpage();
		x.info("selecting the user role");
		selectuserrole();
		selectstatus();
		up.getSerachbutton().click();
		
		String actualrole = up.getUserrolevalue().getText();
		String actualstatus = up.getUserstatusvalue().getText();
		x.info("verify the result");
		Assert.assertEquals(actualrole, "Admin");
		Assert.assertEquals(actualstatus, "Enabled");
		x.info("End of test case Test_User_Role");
	}
}
