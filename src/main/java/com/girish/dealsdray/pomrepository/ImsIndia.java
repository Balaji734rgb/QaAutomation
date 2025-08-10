package com.girish.dealsdray.pomrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImsIndia {
WebDriver driver;
public  ImsIndia(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public WebDriver getDriver() {
	return driver;
}

@FindBy(xpath="//select[@id='city']")
private WebElement cityName;


@FindBy(xpath = "//select[@id='city']/option")
private List<WebElement> listofcities;

@FindBy(xpath="//select[@id='centernew']")
private WebElement selectCentre;

@FindBy(xpath="//h3[@class='course-cost__amt mt-3']")
private WebElement courseAmt;

@FindBy(xpath = "//select[@id='centernew']/option")
private List<WebElement> listOfCenter;


@FindBy(xpath = "//h3[@class='course-cost__amt mt-3']")
 private WebElement baseFee;

public List<WebElement> getListOfCenter() {
	return listOfCenter;
}

public List<WebElement> getListofcities() {
	return listofcities;
}

public WebElement getCityName() {
	return cityName;
}

public WebElement getSelectCentre() {
	return selectCentre;
}

public WebElement getCourseAmt() {
	return courseAmt;
}

public WebElement getBaseFee() {
	return baseFee;
}

}
