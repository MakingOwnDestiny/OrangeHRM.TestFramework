package ObjectRepository;

import org.openqa.selenium.By;

public class LoginPage {
	
	public static final By username = By.xpath("//input[@id='txtUsername']");
	public static final By password = By.xpath("//input[@id='txtPassword']");
	public static final By LoginBtn = By.xpath("//input[@id='btnLogin']");
	public static final By invalid_Credentials = By.xpath("//span [text() = 'Invalid credentials']");
}