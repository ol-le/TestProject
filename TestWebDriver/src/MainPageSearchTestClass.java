import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
//Small test suite for testing search on the main page

public class MainPageSearchTestClass extends MySelenium {
	
	//string input for test
	String searchTitleContent = "SAP to Acquire Concur, Expanding the World’s Largest Business Network";
	String searchItemContent = "SAP SE and Concur Technologies, Inc. today announced that SAP’s subsidiary, SAP America, Inc., has entered into an agreement to acquire Concur.";
	
	SearchPage searchPage;
	MainPage mainPage;
		
	//Search for a valid data and check if the search result has a valid title
	@Test
	public void MainPageSearch_SearchItemByTitleIsFound_Test(){
		mainPage = new MainPage();
		mainPage.searchButton.click();
		mainPage.InitializeSearchMenu();
		mainPage.searchField.sendKeys(searchTitleContent);
		mainPage.submitButton.click();
		searchPage = new SearchPage();
		assertEquals(searchTitleContent, searchPage.findSearchResultTitleItemByTitle(searchTitleContent).getText());
	}
	
	//Search for a valid data and check if the search result has a valid content
	@Test
	public void MainPageSearch_SearchItemByContentIsFound_Test(){
		mainPage = new MainPage();
		mainPage.searchButton.click();
		mainPage.InitializeSearchMenu();
		mainPage.searchField.sendKeys(searchTitleContent);
		mainPage.submitButton.click();
		searchPage = new SearchPage();
		assertEquals(searchItemContent, searchPage.findSearchResultContentItemByContent(searchItemContent).getText());
	}
	
	
	
}
