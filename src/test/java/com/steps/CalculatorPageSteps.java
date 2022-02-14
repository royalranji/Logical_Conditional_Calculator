package com.steps;

import com.pages.CalculatorPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.*;

public class CalculatorPageSteps {

        CalculatorPage calculatorPage = new CalculatorPage();

    @Given("^Customer pass the algorithm equation$")
    public void customer_validated_the_below_equation(DataTable input) throws Exception {
        List<String> query = input.column(0).get(0) != null?Arrays.asList(input.column(0).get(0).split(" ")):new ArrayList<String>(Collections.singleton(""));
        calculatorPage.selectInput(query);
    }


    @When("customer click on calculate button")
    public void customerClickOnCalculateButton() {
        calculatorPage.clickCalculateButton();
    }

    @Then("customer will get this expected result")
    public void customerWillGetThisExpectedResult(DataTable input) {
        calculatorPage.validateResponse(input.asList().get(0));
    }

    @And("Customer pass the algorithm equation and validate the result")
    public void customerPassTheAlgorithmEquationAndValidateResult(DataTable input) {
        List<Map<String,String>> query = input.asMaps();
        query.stream().forEach(data -> {
            calculatorPage.clearTextArea();
            calculatorPage.selectInput(data.get("query") != null?Arrays.asList(data.get("query").split(" ")):new ArrayList<String>(Collections.singleton("")));
            calculatorPage.clickCalculateButton();
            calculatorPage.validateResponse(data.get("result"));
        });

    }
}
