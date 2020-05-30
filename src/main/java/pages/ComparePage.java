package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase
{

	public ComparePage(WebDriver driver)
	{
		super(driver);
	}
   @FindBy(css="a.clear-list")
   WebElement clearListBtn;
   
   @FindBy(css="div.no-data")
   WebElement noDataLbl;
   
   @FindBy(css="table.compare-products-table")
   WebElement comparTable;
   
   @FindBy(tagName="tr")
   public List<WebElement>allRows;
   
   @FindBy(tagName="td")
   public List<WebElement>allClmn;
   
   @FindBy(linkText = "Apple MacBook Pro 13-inch")
   public WebElement firstProductName;
   
   @FindBy(linkText = "Asus N551JK-XO076H Laptop")
   public WebElement secondProductName;
   
   public void ClearCompareList()
   {
	   clickButton(clearListBtn);
   }
   public void CompareProducts() 
   {   //get all rows
	   System.out.println(allRows.size());
	   
	   // get data from each row
	   for(WebElement row : allRows) 
	   {
		 System.out.println(row.getText()+"\t");  
		 
		 for (WebElement clmn : allClmn) 
		 {
			 System.out.println(clmn.getText()+"\t");  

		 }
	   }
   }
}
