import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Twitter {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "/home/sibi/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://twitter.com/");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='signin-email']")).sendKeys("user_name");//please enter user name 
		driver.findElement(By.xpath("//*[@id='signin-password']")).sendKeys("password");//enter password
		
		driver.findElement(By.xpath("//*[@id='front-container']/div[2]/div[2]/form/table/tbody/tr/td[2]/button")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@id='search-query']")).sendKeys("#hash-tag");//specify the hash tag that you want to search
		driver.findElement(By.xpath("//*[@id='global-nav-search']/span/button")).click();
		Thread.sleep(12000);
		
		String tweet = driver.findElement(By.xpath("//*[@id='page-container']/div[4]/div[2]/div/ol/li[1]/ol/li/div/div[2]/p")).getText();
		System.out.println("Top Tweet : "+tweet);
		driver.findElement(By.xpath("//*[@id='global-new-tweet-button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='tweet-box-global']")).sendKeys(tweet);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='global-tweet-dialog-dialog']/div[2]/div[4]/form/div[2]/div[2]/button")).click();
		driver.quit();
	}

}
