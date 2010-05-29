package com.mycompany.test.features;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.mycompany.test.pageObjects.HomePage;
import com.mycompany.test.pageObjects.WebSite;
import cuke4duke.annotation.I18n.EN.*;
import cuke4duke.spring.StepDefinitions;
import org.springframework.beans.factory.annotation.Autowired;

@StepDefinitions
public class HelloWorldSteps {

	@Autowired WebSite webSite;
	private HomePage homePage;

	@Given("I have a skeleton web application")
	public void haveSkeletonWebApplication() {
		assertNotNull(webSite);
	}

	@When("I open the home page")
	public void openHomePage() {
		homePage = webSite.openHomePage();
	}

	@Then("the page heading should be \"(.*)\"")
	public void shouldHavePageHeading(String expectedTitle) {
		assertTrue(homePage.hasPageHeading(expectedTitle));
	}
}
