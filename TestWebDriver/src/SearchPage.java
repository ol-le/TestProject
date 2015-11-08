//SearchPage class, contains WebElements that are used in tests 
//and are located on the search result page 

import org.openqa.selenium.WebElement;


public class SearchPage extends MySelenium{
	
	public WebElement searchResult;
	
	public SearchPage(){}
	
	//searching for search result elements by title and by content
	
	public WebElement findSearchResultTitleItemByTitle(String title){
		WebElement titleItem = getElementByXpath("//a[contains(.,'" + title+ "')]");
		return waitForElement(titleItem);
	}
	
	public WebElement findSearchResultContentItemByContent(String content){
		WebElement contentItem = getElementByXpath("//span[contains(.,'" + content+ "')]");
		return waitForElement(contentItem);
	}
	
}
