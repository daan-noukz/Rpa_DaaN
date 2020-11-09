package frameWork;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Driver {

	
	
	
	public static WebDriver driver;

	/**
	 * 
	 */
	public void iniciaChromeDrive(String url) {	
		
			
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dan\\eclipse-workspace\\Rpa_Dan\\Driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(retornaUrl(url));	
	}

	public String retornaUrl(String url) {
		HashMap<String, String> urls = new HashMap<>();		
		urls.put("google", "https://www.google.com");
		urls.put("yahoo", "https://www.yahoo.com");		
		urls.put("inmetrics", "http://www.inmrobo.tk/accounts/login/");	
		System.out.println(urls.get(url.toString()));	
		return urls.get(url.toString());		
	}
	
	
	
}
