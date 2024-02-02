package library;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utils.aputils;

public class loginpage extends aputils{
	
	public void login(String uid,String pwd) {
		aputils.driver.findElement(By.id("txtUsername")).clear();
		aputils.driver.findElement(By.id("txtUsername")).sendKeys(uid);
		aputils.driver.findElement(By.id("txtPassword")).clear();;
		aputils.driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		aputils.driver.findElement(By.id("btnLogin")).click();
		
	}
	public boolean isadminmoduledisplayed() {
		if(driver.findElement(By.linkText("Admin")).isDisplayed()){
			return true;
			}
		else {
			return false;
		}
	}
	public boolean logout() {
		aputils.driver.findElement(By.id("welcome")).click();
		aputils.driver.findElement(By.linkText("Logout")).click();
		if(driver.findElement(By.id("btnLogin")).isDisplayed()) {
			return true;
		
		}
		else {
			return false;
		}
			
		
		
	}
	public boolean errmessage() {
		String errmsg;
		errmsg=driver.findElement(By.id("spanMessage")).getText();
		if(errmsg.toLowerCase().contains("invalid")||errmsg.toLowerCase().contains("empty")) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public boolean isEmpModuleDisplayed()
	{
		try 
		{
			driver.findElement(By.linkText("Admin")).isDisplayed();
			return false;
			
		} catch (Exception e)
		{
			return true;
		}
		
	}

	
	
	

}
