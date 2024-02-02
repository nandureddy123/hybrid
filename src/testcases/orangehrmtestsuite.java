package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import library.employee;
import library.loginpage;
import utils.aputils;
import utils.xlutils1;

public class orangehrmtestsuite extends aputils{
	String tcfile="C:\\selenium\\orangehrmhybrid\\testcasefiles\\OrangeHRMKeywords.xlsx";
	String tcsheet="TestCases";
	String tssheet="TestSteps";
			
	@Test
	public void checkorangehrm() throws IOException {
		int tccount=xlutils1.getRowcount(tcfile, tcsheet);
		int tscount=xlutils1.getRowcount(tcfile, tssheet);
		String tcid,tcexeflag;
		String tstcid,keyword;
		String fname,lname;
		String tcres;
		loginpage lp=new loginpage();
		employee emp=new employee();
		
		String uid,pwd;
		boolean res=false;
		String stepre;
		for(int i=1;i<=tccount;i++) {
			tcid=xlutils1.getStringdata(tcfile, tcsheet, i, 0);
			tcexeflag=xlutils1.getStringdata(tcfile, tcsheet,i, 2);
			if(tcexeflag.equalsIgnoreCase("y"))
			{
				for(int j=1;j<=tscount;j++) {
					tstcid=xlutils1.getStringdata(tcfile, tssheet, j, 0);
					if(tstcid.equalsIgnoreCase(tcid)) {
						keyword=xlutils1.getStringdata(tcfile,tssheet, j, 4);
						switch (keyword.toLowerCase()) {
						case "adminlogin":
							uid=xlutils1.getStringdata(tcfile, tssheet, j, 5);
							pwd=xlutils1.getStringdata(tcfile, tssheet, j, 6);
							lp.login(uid, pwd);
							res=lp.isadminmoduledisplayed();
							break;
						case "logout":
							res=lp.logout();
							break;
						case "invalidlogin":
							uid=xlutils1.getStringdata(tcfile, tssheet, j, 5);
							pwd=xlutils1.getStringdata(tcfile, tssheet, j, 6);
							lp.login(uid, pwd);
							res=lp.errmessage();
							break;
						case "empreg":
							fname=xlutils1.getStringdata(tcfile, tssheet, j, 5);
							lname=xlutils1.getStringdata(tcfile, tssheet, j, 6);
							res=emp.addEmployee(fname, lname);
							break;
							

						
						}
						if(res) {
							stepre="pass";
							xlutils1.setData(tcfile, tssheet, j, 3, stepre);
							xlutils1.fillGreenColor(tcfile, tssheet, j, 3);
							
						}
						else {
							stepre="fail";
							xlutils1.setData(tcfile, tssheet, j, 3, stepre);
							xlutils1.fillRedColor(tcfile, tssheet, j, 3);
							
						}
						tcres=xlutils1.getStringdata(tcfile, tssheet, i, 3);
						if(!tcres.equalsIgnoreCase("fail")) {
							xlutils1.setData(tcfile, tcsheet, i, 3, stepre);
						}
						tcres=xlutils1.getStringdata(tcfile, tssheet, i, 3);
						if(tcres.equalsIgnoreCase("pass")) {
							xlutils1.fillGreenColor(tcfile, tcsheet, i, 3);
						}
						else {
							xlutils1.fillRedColor(tcfile, tcsheet, i, 3);
						}
						
					}
				}
				
			}
			else {
				xlutils1.setData(tcfile, tcsheet,i, 3,"blocked");
				xlutils1.fillRedColor(tcfile, tcsheet, i, 3);
				
			}
			
		}
		
	}
	

}
