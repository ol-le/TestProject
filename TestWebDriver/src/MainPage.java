import org.openqa.selenium.WebElement;
//MainPage class, contains WebElements that are used in tests 
//and are located on the main page 
class MainPage extends MySelenium{
	public WebElement searchButton;
	public WebElement searchField;
	public WebElement submitButton;
	public WebElement seeHowItWorksButton;
	public WebElement learnHowButton;
	public WebElement scrollItem;
	
 	public MainPage(){		//initialization of items in constructor
 		searchButton = getSearchButton();
 		seeHowItWorksButton = getSeeHowItWorksButton();
 		scrollItem = getScrollItem();
	}
 	
 	
	private WebElement getSeeHowItWorksButton() {
		seeHowItWorksButton = getElementByLinkText("See how it works");
		return waitForElement(seeHowItWorksButton);
	}

	private WebElement getSearchButton(){
		searchButton = getElementByXpath("//div[@class='search-glass bg-icon']");
		return waitForElement(searchButton);
	}
	
	private WebElement getSearchField(){
		searchField = getElementByXpath("//input[@id = 'e-search-input']");
		return waitForElement(searchField);
	}
	
	private WebElement getSubmitButton(){
		submitButton = getElementByXpath("//input[@type='submit']");
		return waitForElement(submitButton);
	}
	
	private WebElement getScrollItem(){
		scrollItem = getElementByXpath("//p[contains(.,'SCROLL')]");
		return waitForElement(scrollItem);
	}
	
	public void InitializeSearchMenu(){
 		searchField = getSearchField();
 		submitButton = getSubmitButton();
 		seeHowItWorksButton = getSeeHowItWorksButton();
 	}
	
	public WebElement InitializeLearnHowButton() {
 		learnHowButton = getElementByLinkText("Learn how");
		return waitForElement(learnHowButton);
	}
	
}

