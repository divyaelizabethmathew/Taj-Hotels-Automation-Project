package pagepkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//*[@id=\"main__Header_nav\"]/div/div[1]/a/img")
	WebElement logo;
	
	@FindBy(xpath = "//*[@id=\"main__Header_nav\"]/div/div[2]/div[1]/div[1]/span/a")
	WebElement destinations;
	
	@FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div[1]/div[3]/div/div/form/div/input")
	WebElement searchDestinations;
	
	@FindBy(xpath = "/html/body/div[5]/div[3]/div/div[2]/div[2]/div[2]/div[2]/div/p/div[2]/span[2]")
	WebElement destinationSugg;
	
	public HomePage (WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public void titleVeri() {
	    String actualTitle = driver.getTitle();
	    System.out.println(actualTitle);
	    String expTitle = "Luxury Hotels & Resorts in India & the World | Taj Hotels";
	    Assert.assertEquals(actualTitle, expTitle,"Title verification failed");
	    System.out.println("Title is verified");
	}
	
	public void logoVeri() {
        Assert.assertTrue(logo.isDisplayed(),"Logo is not displayed");
        System.out.println("Logo is verified");
	}
	
	public void linkCount() {
		List<WebElement> li = driver.findElements(By.tagName("a"));
		int linkCount = li.size();
		System.out.println("Total number of links: "+linkCount);
		for(WebElement temp: li) {
			String link = temp.getAttribute("href");
			String linkTxt = temp.getText();
			System.out.println(link +"-----"+linkTxt);
		}
	}
	
	public void destinationMthd(String destination) {
	    wait.until(ExpectedConditions.elementToBeClickable(destinations));
	    destinations.click();
	    By searchInput = By.xpath("//input[not(@type='hidden') and not(@disabled)]");
	    WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
	    search.sendKeys(destination);
	}

}
