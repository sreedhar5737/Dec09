package GR1.AR1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class objects{

	
	 WebDriver driver;
	
public objects(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	
}


@FindBy(name="firstname")
WebElement fname;


@FindBy(name="lastname")
WebElement surname;

@FindBy(name="reg_email__")
WebElement phno;

@FindBy(name="reg_passwd__")
WebElement  password;


@FindBy(name="birthday_day")
WebElement day;


@FindBy(name="birthday_month")
WebElement month;


@FindBy(name="birthday_year")
WebElement year;

public WebElement fname(String firstname)
{
	 fname.sendKeys(firstname);
	return fname;
	
}

public WebElement lname(String lastname)
{
	 surname.sendKeys(lastname);
	return surname;
	
}

public WebElement phno(String phno1)
{
	 phno.sendKeys(phno1);
	return phno;
}

public WebElement password(String password1)
{
	 password.sendKeys(password1);
	return password;
}

public WebElement day(String dayy)
{
	int it1=Integer.parseInt(dayy);
	Select st=new Select(day);
	st.selectByIndex(it1);
	return day;
	
}

public WebElement year(String yearr)
{
	
	Select st=new Select(year);
	st.selectByVisibleText(yearr);
	return year;
	
}


}
