package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	@Test
	public void negativelogin() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver  driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://magento.com");
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		driver.findElement(By.id("email")).sendKeys("pathaksejal9@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("welcome");
	driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();
	
	Thread.sleep(5000);
	String error = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
	System.out.println(error);
	driver.quit();
	
	}
	@Test
	public void register() {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://magento.com");
	
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		driver.findElement(By.id("register")).click();
		driver.findElement(By.id("firstname")).sendKeys("Sejal");
		driver.findElement(By.id("lastname")).sendKeys("Pathak");
		driver.findElement(By.name("email")).sendKeys("pathaksejal9@gmail.com");
		driver.findElement(By.id("password")).sendKeys("welcome@9");
		driver.findElement(By.name("password_confirmation")).sendKeys("welcome@9");
		String strength = driver.findElement(By.id("password-strength-meter-label")).getText();
		System.out.println(strength);
		if (strength.equals("Weak"))
		{
			System.out.println("As Expected");
		}
		
		Select cp = new Select(driver.findElement(By.id("company_type")));
				
		cp.selectByVisibleText("Provides deployment, customization and integration services to merchants");
		
		Select ir = new Select(driver.findElement(By.id("individual_role")));
		ir.selectByIndex(1);
		
		Select country = new Select(driver.findElement(By.id("country")));
		country.selectByValue("IN");
		
		driver.findElement(By.id("password")).clear();
		
		driver.findElement(By.id("password")).sendKeys("welcomesejal@9");
		driver.findElement(By.name("password_confirmation")).clear();
		driver.findElement(By.name("password_confirmation")).sendKeys("welcomesejal@9");
		
		 strength = driver.findElement(By.id("password-strength-meter-label")).getText();
		System.out.println(strength);
		if (strength.equals("Very Strong"))
		{
			System.out.println("As Expected");
		}
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("#msp-recaptcha-d84b65fc916e7398083ea5f17089d8f1 > div > div > iframe")));
		driver.findElement(By.className("recaptcha-checkbox-border")).click();
	
		driver.switchTo().defaultContent();
		
		if(! driver.findElement(By.id("agree_terms")).isSelected())
		{
		driver.findElement(By.id("agree_terms")).click();
		}
		
		
		driver.quit();
	}
}
