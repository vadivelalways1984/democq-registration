package com.cucumber.demoqalogin;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;


public class Firstmodel {
	WebDriver driver;
	String dp1,dp2,dp3,dp4;
	
	
	@Given("^Enter the registration form$")
	public void enter_the_registration_form() throws Throwable {

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\vadivelkb\\eclipse-workspace\\project class\\demoqalogin\\lib\\geckodriver.exe");
		driver =new FirefoxDriver();
		driver.get("http://demoqa.com/registration/");	

			}

	@When("^User the enter the checkbox$")
	public void user_the_enter_the_checkbox() throws Throwable {
 
		driver.findElement(By.id("name_3_firstname")).sendKeys("vadivel");
		driver.findElement(By.name("last_name")).sendKeys("babu");
		driver.findElement(By.name("radio_4[]")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//input[@value='married']")).click();
		driver.findElement(By.xpath("//input[@value='divorced']")).click();
		driver.findElement(By.xpath("//input[@value='dance']")).click();
		driver.findElement(By.xpath("//input[@value='reading']")).click();
		driver.findElement(By.xpath("//input[@value='cricket ']")).click();
		WebElement dp = driver.findElement(By.name("dropdown_7"));
	
		Select s =new Select(dp);
		List <WebElement> web = s.getOptions();
		s.selectByValue("India");

		dp1 =s.getFirstSelectedOption().getText();
		
		WebElement db = driver.findElement(By.name("date_8[date][mm]"));
		Select s1 =new Select(db);
		s1.selectByValue("11");

		dp2 = s.getFirstSelectedOption().getText();
		
		WebElement day = driver.findElement(By.name("date_8[date][dd]"));
		Select dy =new Select(day);
		dy.selectByValue("11");
		
		dp3 = s.getFirstSelectedOption().getText();


		WebElement yr = driver.findElement(By.name("date_8[date][yy]"));
		Select y =new Select(yr);
		y.selectByValue("1984");
		
		dp4 = s.getFirstSelectedOption().getText();
		
		driver.findElement(By.name("phone_9")).sendKeys("9884520420");
		driver.findElement(By.name("username")).sendKeys("vadivel");
		driver.findElement(By.name("e_mail")).sendKeys("vadivelkb@gmail.com");
		driver.findElement(By.name("description")).sendKeys("demoqa registration");
		driver.findElement(By.name("password")).sendKeys("Vadivel11123");
		driver.findElement(By.id("confirm_password_password_2")).sendKeys("Vadivel11123");
			
		
	}

	@Then("^I validate the checkbox$")
	public void i_validate_the_checkbox() throws Throwable {
 
		Assert.assertEquals("vadivel", driver.findElement(By.id("name_3_firstname")).getAttribute("value"));
		Assert.assertEquals("babu", driver.findElement(By.name("last_name")).getAttribute("value"));
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='married']")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='divorced']")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='dance']")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='reading']")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='cricket ']")).isSelected());
		Assert.assertEquals("India", "dp1");
		Assert.assertEquals("11","dp2");
		Assert.assertEquals("11","dp3");
		Assert.assertEquals("1984","dp4");
		Assert.assertEquals("9884520420", driver.findElement(By.name("phone_9")).getAttribute("value"));
		Assert.assertEquals("vadivel", driver.findElement(By.name("username")).getAttribute("value"));
		Assert.assertEquals("vadivelkb@gmail.com",driver.findElement(By.name("e_mail")).getAttribute("value"));
		Assert.assertEquals("demoqa registration",driver.findElement(By.name("description")).getAttribute("value"));
		Assert.assertEquals("Vadivel11123",driver.findElement(By.name("password")).getAttribute("value"));
		Assert.assertEquals("Vadivel11123", driver.findElement(By.id("confirm_password_password_2")).getAttribute("value"));
		
	}


}
