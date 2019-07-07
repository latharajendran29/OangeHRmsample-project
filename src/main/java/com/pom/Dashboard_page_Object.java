package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard_page_Object {
@FindBy(id="menu_dashboard_index")
public static WebElement dashboard;
@FindBy(xpath="//*[@id='task-list-group-panel-menu_holder']//following::td[1]")
public static WebElement pendingleaverequest;


}
