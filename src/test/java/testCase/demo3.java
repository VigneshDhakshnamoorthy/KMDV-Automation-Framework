package testCase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import kmdv.Base.TestBase;
import kmdv.Common.SeleniumUtil;
import kmdv.Data.JsonUtil;
import kmdv.config.TestNG.Author;
import kmdv.config.TestNG.TestID;

public class demo3 extends TestBase {

	@Test()
	public void demo31TC() throws Exception {
		String webURL = "https://www.google.com/";
		SeleniumUtil selenium = Selenium(webURL);
		selenium.Log(selenium.getTitle());

		JsonUtil jsonUtil = new JsonUtil(pathRoot.fileFromJsonTestData("test.json"));
		PojoJSON pojo = jsonUtil.getPojo(PojoJSON.class);
		selenium.Log(pojo.getLastName());
		pojo.setLastName("Dhakshna");
		selenium.Log(pojo.getLastName());
		
		selenium.Log(jsonUtil.getValue("firstName"));
		selenium.Log(jsonUtil.getKeys());
		selenium.Log(jsonUtil.getAllValues());
	}
	
	@Author(Name = "Vignesh")
	@TestID(Name = "Number2")
	@Test()
	public void demo32TC() throws Exception {
		String webURL = "https://money.rediff.com/gainers";
		SeleniumUtil selenium = Selenium(webURL);
		selenium.Log(selenium.getTitle());
		List<WebElement> elements = selenium.getElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]/a"));
		selenium.logList(elements);
		System.out.println(Reporter.getCurrentTestResult().getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestID.class).Name().toString());
		}
	
	
	}