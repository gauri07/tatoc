import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;



public class first{

	public static void main(String args[]) throws Exception {
		File ffExecutable=new File("/home/gaurimanglik/firefox/firefox");
		FirefoxBinary ffBinary=new FirefoxBinary(ffExecutable);
		FirefoxProfile ffProfile=new FirefoxProfile();
		WebDriver driver = new FirefoxDriver(ffBinary,ffProfile);
	driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
		
		
		//Problem 1-
		
		driver.findElement(By.className("greenbox")).click();         
	
		//if(driver.findElement(By.className("redbox")) != null);
	//	System.out.println("ERROR");
		
		
		//Problem2-
		driver.switchTo().frame("main"); //main frame 
		
		
		String class1=driver.findElement(By.cssSelector("#answer")).getAttribute("class");
		
		System.out.println(class1);
		
		driver.switchTo().frame("child"); //child frame
		
		String class2=driver.findElement(By.cssSelector("#answer")).getAttribute("class");
		
		System.out.println(class2); 
		
		while(!class1.equals(class2))
		{
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			Thread.sleep(1500);
			driver.findElement(By.linkText("Repaint Box 2")).click();
			driver.switchTo().frame("child");
			class2=driver.findElement(By.cssSelector("#answer")).getAttribute("class");
			System.out.println(class2);
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		driver.findElement(By.linkText("Proceed")).click();
		
				
		//Problem 3-
				
				WebElement element = driver.findElement(By.cssSelector("#dragbox"));
				WebElement target = driver.findElement(By.cssSelector("#dropbox"));
				(new Actions(driver)).dragAndDrop(element, target).perform();
				driver.findElement(By.linkText("Proceed")).click();
				Thread.sleep(1500);
				
		//Problem 4-
				
				driver.findElement(By.linkText("Launch Popup Window")).click();
			    

				String firstWinHandle = driver.getWindowHandle();
	            for(String webHand: driver.getWindowHandles()){
	                driver.switchTo().window(webHand);
	             }
	           Thread.sleep(2000);
	  
				WebElement name=driver.findElement(By.id("name"));
			
				name.sendKeys("QA Inoftech");
				driver.findElement(By.cssSelector("#submit")).click();
			    driver.switchTo().window(firstWinHandle);
	            driver.findElement(By.linkText("Proceed")).click();
	            
	            
	     //Problem 5-
	             driver.findElement(By.linkText("Generate Token")).click();
	             String s=driver.findElement(By.id("token")).getText();
	             Cookie token=new Cookie("Token",s.substring(7));
	             driver.manage().addCookie(token);
	             driver.findElement(By.linkText("Proceed")).click();
	             
	             
	             
				
		/*driver.close();
		driver.quit();*/

	}

	

}
