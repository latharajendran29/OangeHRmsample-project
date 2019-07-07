package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_Role_page_Object {
	public WebDriver driver;
	public  User_Role_page_Object(WebDriver ldriver) {
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="searchSystemUser_userName")
	private WebElement username;
	@FindBy(id="menu_admin_viewAdminModule")
	private WebElement Admin;
	@FindBy(id="menu_admin_UserManagement")
	private WebElement usermanagement;
	@FindBy(id="menu_admin_viewSystemUsers")
	private WebElement users;
	@FindBy(id="searchSystemUser_userType")
	private WebElement userrole;
	public WebElement getUsername() {
		return username;
	}
	public WebElement getAdmin() {
		return Admin;
	}
	public WebElement getUsermanagement() {
		return usermanagement;
	}
	public WebElement getUsers() {
		return users;
	}
	public WebElement getUserrole() {
		return userrole;
	}
	public WebElement getStatus() {
		return status;
	}
	public WebElement getSerachbutton() {
		return serachbutton;
	}
	public WebElement getUserrolevalue() {
		return userrolevalue;
	}
	public WebElement getUserstatusvalue() {
		return userstatusvalue;
	}
	@FindBy(id="searchSystemUser_status")
	private WebElement status;
	@FindBy(id="searchBtn")
	private WebElement serachbutton;
	@FindBy(xpath="//tr//td[3]")
	private WebElement userrolevalue;
	@FindBy(xpath="//tr//td[5]")
	private WebElement userstatusvalue;
	

}
