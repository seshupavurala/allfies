package primusbank;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class basic {
WebDriver driver;
	public void browserlaunch(String url) {
	//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
public  void login(String uname,String pword) {
	driver.findElement(By.name("txtuId")).sendKeys(uname);
	driver.findElement(By.name("txtPword")).sendKeys(pword);
	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.name("login")).click();
	if(driver.findElement(By.xpath("//tbody[1]/tr[1]/td[4]/table[1]/tbody[1]/tr[1]/td[1]/a[1]/img[1]")).isDisplayed()) {
		System.out.println(" login success");
	}
	else {
		System.out.println(" login failed");
	}
		
	}
public void clickonbranch() {
	driver.findElement(By.xpath("//*[@id=\"Table_01\"]/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")).click();
	
}
public void newbranch(String bname,String ad1,String ad2,String ad3,String areaname ,String zipcode) {
	driver.findElement(By.id("BtnNewBR")).click();
	driver.findElement(By.id("txtbName")).sendKeys(bname);
	driver.findElement(By.id("txtAdd1")).sendKeys(ad1);
	driver.findElement(By.id("Txtadd2")).sendKeys(ad2);
	driver.findElement(By.id("txtadd3")).sendKeys(ad3);
	driver.findElement(By.id("txtArea")).sendKeys(areaname);
	driver.findElement(By.id("txtZip")).sendKeys(zipcode);
	Select s1 = new Select(driver.findElement(By.id("lst_counrtyU")));
	s1.selectByIndex(1);
	Select s2 = new Select(driver.findElement(By.id("lst_stateI")));
	s2.selectByIndex(1);
	Select s3 = new Select(driver.findElement(By.id("lst_cityI")));
	s3.selectByIndex(1);
	driver.findElement(By.id("btn_insert")).click();
	 String getmessage =driver.switchTo().alert().getText();
	 System.out.println(getmessage);
	 driver.switchTo().alert().accept();
	if(getmessage.contains("New")) {
		System.out.println("created");
	}else {
		System.out.println("not created");
	}
}
public void logout() {
	driver.findElement(By.xpath("//tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[3]/table[1]/tbody[1]/tr[1]/td[3]/a[1]/img[1]")).click();

}
	public static void main(String[] args) throws Exception {
	
	basic pb = new basic();	
	pb.browserlaunch("http://primusbank.qedgetech.com/");
	Thread.sleep(5000);
	pb.login("Admin", "Admin");
	Thread.sleep(5000);
	pb.clickonbranch();
	Thread.sleep(5000);
	pb.newbranch("primusbanks", "khammams", "srnagarr","kphbb", "begumpett", "500038");
	pb.logout();
		

	}

}
