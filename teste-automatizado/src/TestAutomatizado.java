import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAutomatizado {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/usr/local/share/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.bing.com");
		WebElement query = driver.findElement(By.name("q"));
		query.sendKeys("caelum");
		query.submit();
	}
}
