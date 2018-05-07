package com.cucumber.demoqalogin;

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

		WebElement db = driver.findElement(By.name("date_8[date][mm]"));
		Select s1 =new Select(db);
		s1.selectByValue("11");

		WebElement day = driver.findElement(By.name("date_8[date][dd]"));
		Select dy =new Select(day);
		dy.selectByValue("11");

		WebElement yr = driver.findElement(By.name("date_8[date][yy]"));
		Select y =new Select(yr);
		y.selectByValue("1984");
		
		driver.findElement(By.name("phone_9")).sendKeys("9884520420");
		driver.findElement(By.name("username")).sendKeys("vadivel");
		driver.findElement(By.name("e_mail")).sendKeys("vadivelkb@gmail.com");
		driver.findElement(By.name("description")).sendKeys("demoqa registration");
		driver.findElement(By.name("password")).sendKeys("Vadivel11123");
		driver.findElement(By.id("confirm_password_password_2"));
		driver.findElement(By.className("input_fields  piereg_validate[required,equals[password_2]]")).sendKeys("Vadivel11123");	
		
	}

	@Then("^I validate the checkbox$")
	public void i_validate_the_checkbox() throws Throwable {
 
		Assert.assertTrue("submit", true);
		
	}


}
