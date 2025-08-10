package com.girish.dealsdray.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver; // Keep the driver private to ensure encapsulation
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize the PageFactory elements
    }
    
    public WebDriver getDriver() {
        return driver;
    }
    
    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameTf; // Keep WebElement private
    
    public WebElement getUsernameTf() {
        return usernameTf; // Provide a public getter to access the WebElement
    }
    
    @FindBy(xpath = "//input[@name='password']")
    private WebElement PasswordTF;
    
    @FindBy(xpath = "//input[@value='Log In']")
    private WebElement LoginButton;
    
    
    @FindBy(xpath = "//a[text()='Register']")
    private WebElement RegisterLink;
    @FindBy(id = "customer.firstName")
    private WebElement FristNameTF;
    
    @FindBy(id = "customer.lastName")
    private WebElement LastNameTF;
    
    @FindBy(id = "customer.address.street")
    private WebElement AddressTF;
    
    
    @FindBy(id = "customer.address.city")
    private WebElement CityTF;
    
    @FindBy(id = "customer.address.state")
    private WebElement StateTF;
    
    @FindBy(id = "customer.address.zipCode")
    private WebElement ZipCodeTF;
    
    @FindBy(id  = "customer.ssn")
    private WebElement SSNTF;
    
    
    @FindBy(id = "repeatedPassword")
    private WebElement ConfirmPasswordTF;
    
    
    @FindBy(xpath = "//input[@value='Register']")
    private WebElement RegisterButton;

	public WebElement getPasswordTF() {
		return PasswordTF;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

	public WebElement getRegisterLink() {
		return RegisterLink;
	}

	public WebElement getFristNameTF() {
		return FristNameTF;
	}

	public WebElement getLastNameTF() {
		return LastNameTF;
	}

	public WebElement getAddressTF() {
		return AddressTF;
	}

	public WebElement getCityTF() {
		return CityTF;
	}

	public WebElement getStateTF() {
		return StateTF;
	}

	public WebElement getZipCodeTF() {
		return ZipCodeTF;
	}

	public WebElement getSSNTF() {
		return SSNTF;
	}

	public WebElement getConfirmPasswordTF() {
		return ConfirmPasswordTF;
	}

	public WebElement getRegisterButton() {
		return RegisterButton;
	}
    
    @FindBy(id = "customer.phoneNumber")
    private WebElement PhoneNumberTf;

	public WebElement getPhoneNumberTf() {
		return PhoneNumberTf;
	}
    @FindBy(id = "customer.username")
    private WebElement CustomerUsernameTf;
    
    
    @FindBy(id = "customer.password")
    private WebElement customerpasswordTF;

	public WebElement getCustomerUsernameTf() {
		return CustomerUsernameTf;
	}

	public WebElement getCustomerpasswordTF() {
		return customerpasswordTF;
	}
    
    
    
    
}
