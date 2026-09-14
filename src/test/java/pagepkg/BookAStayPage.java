package pagepkg;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookAStayPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//*[@id=\"main__Header_nav\"]/div/div[2]/div[2]/div[2]/div/div/div/div/div/div[1]/div[1]/div[1]/input")
	WebElement findAHotel;
	
	@FindBy(xpath = "//*[@id=\"main__Header_nav\"]/div/div[2]/div[2]/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/span")
	WebElement hotelSuggestion;
	
	@FindBy(xpath = "//*[@id=\"main__Header_nav\"]/div/div[2]/div[2]/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div/div/div/div[1]/div")
	WebElement datesDetails;
	
	@FindBy(xpath = "//*[@id=\"main__Header_nav\"]/div/div[2]/div[2]/div[2]/div/div/div/div/div/div[1]/div[1]/div[3]/div/span")
	WebElement noOfMembers;
	
	@FindBy(xpath = "//*[@id=\"main__Header_nav\"]/div/div[2]/div[2]/div[2]/div/div/div/div/div/div[1]/div[1]/div[4]/div/div/div/div/div[3]/div[1]/img[2]")
	WebElement increaseAdults;
	
	@FindBy(xpath = "//*[@id=\"main__Header_nav\"]/div/div[2]/div[2]/div[2]/div/div/div/div/div/div[1]/div[1]/div[4]/div/div/div/div/div[3]/div[2]/img[2]")
	WebElement increaseChild;
	
	@FindBy(xpath = "//*[@id=\"main__Header_nav\"]/div/div[2]/div[2]/div[2]/div/div/div/div/div/div[1]/div[1]/div[4]/div/div/div/div/div[4]/span")
	WebElement addMoreRoom;
	
	@FindBy(xpath = "//*[@id=\"main__Header_nav\"]/div/div[2]/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div[1]/div[1]/div/span")
	WebElement specialCode;
	
	@FindBy(xpath = "//*[@id=\"main__Header_nav\"]/div/div[2]/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[2]")
	WebElement checkRates;
	
	
	public BookAStayPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void bookMthd() {
	    By bookStay = By.xpath("//*[@id=\"main__Header_nav\"]/div/div[2]/div[2]/div[2]/button");
	    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(bookStay));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
	    wait.until(ExpectedConditions.visibilityOf(element));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	
	public void findHotelMthd(String hotelName) {
	    wait.until(ExpectedConditions.elementToBeClickable(findAHotel));
	    findAHotel.click();
	    findAHotel.clear();
	    findAHotel.sendKeys(hotelName);
	    wait.until(ExpectedConditions.visibilityOf(hotelSuggestion));
	    hotelSuggestion.click();
	}
	
    public void clickDateField() {
        wait.until(ExpectedConditions.elementToBeClickable(datesDetails));
        datesDetails.click();
    }
    
    public void selectDate(String date) {
        By dateLocator = By.xpath("//button[normalize-space()='" + date + "']");
        WebElement dateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dateLocator));
        Actions actions = new Actions(driver);
        actions.moveToElement(dateElement)
               .click()
               .perform();
    }
    
    public void closeCalendar() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
            By.cssSelector(".react-calendar")
        ));
    }
	
    public void membersMthd(int adults, int children) {
        wait.until(ExpectedConditions.elementToBeClickable(noOfMembers));
        noOfMembers.click();
        for (int i = 1; i < adults; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(increaseAdults));
            increaseAdults.click();
        }
        for (int i = 0; i < children; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(increaseChild));
            increaseChild.click();
        }
    }
	
	public void addRoomMthd(int adults, int children) {
		for (int i = 1; i < adults; i++)
		{
			wait.until(ExpectedConditions.elementToBeClickable(increaseAdults));
			increaseAdults.click();
		}
		
	    for (int i = 0; i < children; i++) {
	        wait.until(ExpectedConditions.elementToBeClickable(increaseChild));
	        increaseChild.click();
	    }
	}
	
	public void checkRatesMthd(String hotelName) {
	    wait.until(ExpectedConditions.elementToBeClickable(checkRates));
	    checkRates.click();
	    File screenshot = ((TakesScreenshot) driver)
	            .getScreenshotAs(OutputType.FILE);
	    File folder = new File("./Screenshot");
	    if (!folder.exists()) {
	        folder.mkdirs();
	    }
	    File destination = new File(folder, hotelName + ".png");
	    try {
	        Files.copy(
	            screenshot.toPath(),
	            destination.toPath(),
	            StandardCopyOption.REPLACE_EXISTING
	        );
	        System.out.println("Screenshot saved: " + destination.getPath());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
