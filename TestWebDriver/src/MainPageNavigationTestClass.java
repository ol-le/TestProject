import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;
//small test suite for testing navigations on the main page

public class MainPageNavigationTestClass extends MySelenium{
		
	MainPage mainPage;
		
	//Testing of navigation on See how it works button
	@Test
	public void MainPageNavigation_NavigateToSeeHowItWorksPageIsValid_Test(){
		String expectedUrl = "https://www.concur.com/en-us/love-business-travel-again";
		mainPage = new MainPage();
		mainPage.seeHowItWorksButton.click();
		assertEquals(getCurrentUrl(), expectedUrl);
	}
	
	//Testing of navigation of Learn how button after clicking on scroll button
	@Test
	public void MainPageNavigation_NavigateToLearnHowPageIsValid_Test(){
		String expectedUrl = "https://www.concur.com/en-us/professional-services";
		mainPage = new MainPage();
		mainPage.scrollItem.click();
		mainPage.InitializeLearnHowButton();
		mainPage.learnHowButton.click();
		assertEquals(getCurrentUrl(), expectedUrl);
	}
	
}


