package com.steps;

import com.constants.Constants;
import com.pages.HomePage;
import io.cucumber.java.en.Given;
import org.testng.Assert;

public class HomePageSteps {

    HomePage homePage = new HomePage();

    @Given("^the customer has navigated to home page in (.*)$")
    public void the_customer_has_navigated_to_home_page(String browserName) throws Exception {
        homePage.openApplication(Constants.CALCULATOR_URL, browserName);
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page isn't displayed properly");
    }
}
