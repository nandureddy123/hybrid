package library;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utils.aputils;

public class adminutils extends aputils{
	String adminuid="Admin";
	String adminpwd="Qedge123!@#";
	public static loginpage lp;
	@BeforeTest
	public void adminlogin() {
	    lp=new loginpage();
		lp.login(adminuid,adminpwd);
		
	}
	@AfterTest
	public void adminlogout() {
		lp.logout();
	}

}
