package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="small-searchterms")
	WebElement searchTextBox;

	@FindBy(css="input.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(id="ui-id-1")
	List<WebElement> productList;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement productTitle;
	
	public void ProductSearch (String proudctName) 
	{
		setTextElementText(searchTextBox, proudctName);
		clickButton(searchBtn);
	}
	public void OpenProductDetailsPage() 
	{
		clickButton(productTitle);
	}
	public void ProductSearchUsingAutoSuggest(String saerchText)
	{
		setTextElementText(searchTextBox, saerchText);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		productList.get(0).click();
	}

}
