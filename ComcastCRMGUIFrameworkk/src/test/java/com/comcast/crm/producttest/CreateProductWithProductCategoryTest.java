package com.comcast.crm.producttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateProductWithProductCategoryTest {

	public static void main(String[] args) throws Throwable {
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		JavaUtility jlib= new JavaUtility();
		
		String BROWSER=flib.getDataFromPropertiesFile("browser");
		String URL=flib.getDataFromPropertiesFile("url");
		String USERNAME=flib.getDataFromPropertiesFile("username");
		String PASSWORD=flib.getDataFromPropertiesFile("password");
		
		String productname=elib.getDataFromExcel("products",1 , 2)+jlib.randomNumber();
		String productcategory=elib.getDataFromExcel("products",4 , 3);

		
        WebDriver driver=null;
		
		if(BROWSER.equals("chrome")) {
		driver=	new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")){
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		
        wlib.waitForPageToLoad(driver);		
        driver.get(URL);
        
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//click on leads
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("productname")).sendKeys(productname);
		WebElement websel=driver.findElement(By.name("productcategory"));
		Select sel=new Select(websel);
		sel.selectByVisibleText(productcategory);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String actproductcat=driver.findElement(By.id("dtlview_Product Category")).getText();
		if(actproductcat.equals(productcategory)) {
			System.out.println(productcategory+"  is verified  ===PASS==");
		}else {
			System.out.println(productcategory+"  is not verified  ===fail==");

		}
		
		String headerinfo=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(headerinfo.contains(productname)) {
			System.out.println(productname+"  "+"header verified==PASS==");
		}else {
			System.out.println(productname+"  "+"header not verified==FAIL==");

		}
       driver.quit();

	}

}
