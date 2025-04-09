package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Practice1 {
	
	@Test()
	
	public void ninzaHrmTest() throws Throwable {
	
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8091/");
		
		//login
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		
	//try {	
		//navigate to project
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		driver.findElement(By.name("projectName")).sendKeys("qwertyytrewq");
		driver.findElement(By.xpath("//input[@Name='createdBy']")).sendKeys("78964");
		
		WebElement dropdown=driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		
		Select sel=new Select(dropdown);
		sel.selectByVisibleText("Completed");
		
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		Thread.sleep(3000);
		//navigate to employees
		driver.findElement(By.linkText("Employees")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		driver.findElement(By.xpath("//label[text()='Name*']/following-sibling::input")).sendKeys("Shiiivvvaamm");
		driver.findElement(By.xpath("//label[text()='Email*']/following-sibling::input")).sendKeys("sasssdfg@gmail.com");
		driver.findElement(By.xpath("//label[text()='Phone*']/following-sibling::input")).sendKeys("7833654147");
		driver.findElement(By.xpath("//label[text()='Username*']/following-sibling::input")).sendKeys("sadfadfddfgh");
		driver.findElement(By.xpath("//label[text()='Designation*']/following-sibling::input")).sendKeys("adaddfgdfg");
		driver.findElement(By.xpath("//label[text()='Experience*']/following-sibling::input")).sendKeys("adsdfdf");
		
        WebElement dropdownemp=driver.findElement(By.xpath("//select[@name='project']"));
		
		Select selobj=new Select(dropdownemp);
		selobj.selectByVisibleText("ram");
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//input[@value='Add']")).click();
		
		Thread.sleep(2000);
		driver.quit();
		
//	}
//	catch(Exception e) {
//		System.out.println("handled");
//	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
