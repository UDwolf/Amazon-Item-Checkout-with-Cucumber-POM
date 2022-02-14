package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.TestBase;

public class BeddingPage extends TestBase {

	public BeddingPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	public String validateBeddingPage() {
		List<WebElement> beddingList = driver.findElements(
				By.xpath("//select[@id='searchDropdownBox' and @aria-describedby='searchDropdownDescription']/option"));

		String isSelected = null;
		
		// System.out.println(beddingList.size());
		for (int i = 0; i < beddingList.size(); i++) {
			// System.out.println(beddingList.get(i).getText());
			if (beddingList.get(i).isSelected()) {
				//System.out.println(beddingList.get(i).getText() + "......Is selected");
				isSelected = beddingList.get(i).getText();
			}
		}		
		return isSelected;
	}

}
