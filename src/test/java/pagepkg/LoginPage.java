package pagepkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//*[@id=\"main__Header_nav\"]/div/div[2]/div[2]/div[1]/span")
	WebElement loginPage;
	
	@FindBy(xpath = "//*[@id=\"simple-tab-0\"]")
	WebElement mobileTab;
	
	@FindBy(name = "senderMobile")
	WebElement mobileNumber;
	
	@FindBy(xpath = "//*[@id=\"simple-tab-1\"]")
	WebElement emailTab;
	
	@FindBy(name = "senderEmail")
	WebElement emailId;
	
	@FindBy(xpath = "//*[@id=\"simple-tab-2\"]")
	WebElement membershipTab;
	
	@FindBy(xpath = "//li[@role='option' and @data-value='NeuPass']")
	WebElement neupass;

	@FindBy(xpath = "//li[@role='option' and @data-value='Epicure']")
	WebElement epicure;

	@FindBy(xpath = "//li[@role='option' and @data-value='The Chambers']")
	WebElement theChambers;
	
	@FindBy(xpath = "//input[@placeholder='Enter your membership number']")
	WebElement membershipNum;
	
	@FindBy(xpath = "//button[normalize-space()='CONTINUE']")
	WebElement continueBtn;
	
	@FindBy(xpath = "//*[@id='simple-tabpanel-2']/div/p/div/div[1]/div[1]")
	WebElement membershipDropdown;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    PageFactory.initElements(driver, this);
	}
	
	public void loginMthd() {
		wait.until(ExpectedConditions.elementToBeClickable(loginPage));
		loginPage.click();
	}
	
	public void mobileMthd(String mobNum) {
		wait.until(ExpectedConditions.elementToBeClickable(mobileTab));
		mobileTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(mobileNumber));
		mobileNumber.sendKeys(mobNum);
	}
	
	public void emailMthd(String email) {
	    wait.until(ExpectedConditions.elementToBeClickable(emailTab));
	    emailTab.click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='senderEmail' and @placeholder='Enter your email']")));
	    WebElement emailField = driver.findElement(By.xpath("//input[@name='senderEmail' and @placeholder='Enter your email']"));
	    emailField.clear();
	    emailField.sendKeys(email);
	}
	
	public void memMthd(String membershipType, String memNum) {
	    wait.until(ExpectedConditions.elementToBeClickable(membershipTab));
	    membershipTab.click();
	    wait.until(ExpectedConditions.elementToBeClickable(membershipDropdown));
	    membershipDropdown.click();
	    if (membershipType.equalsIgnoreCase("NeuPass")) {
	        wait.until(ExpectedConditions.elementToBeClickable(neupass));
	        neupass.click();
	    } else if (membershipType.equalsIgnoreCase("Epicure")) {
	        wait.until(ExpectedConditions.elementToBeClickable(epicure));
	        epicure.click();
	    } else if (membershipType.equalsIgnoreCase("The Chambers")) {
	        wait.until(ExpectedConditions.elementToBeClickable(theChambers));
	        theChambers.click();
	    }
	    wait.until(ExpectedConditions.visibilityOf(membershipNum));
	    membershipNum.clear();
	    membershipNum.sendKeys(memNum);
	}
	
	public void continueMthd() {
		wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
		continueBtn.click();
	}

}
