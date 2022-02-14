package com.pages;

import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class CalculatorPage extends BasePage {

    private static final String groupName = "//li[@class='list-group-item']/button";
    private static final String operation = "//p[@class='card-text']/button[contains(@class,'btn btn-primary')]";
    private static final String continueButton = "//p[@class='card-text']/button[@id='Calculate']";
    private static final String result = "//div[@id='Result']";
    private static final String textArea = "//textarea[@id='Query']";

    public void selectInput(List<String> data) {
        List<String> groupNameList = getWebElements(groupName).stream().map(x -> x.getText()).collect(Collectors.toList());
        List<String> operationList = getWebElements(operation).stream().map(x -> x.getAttribute("id")).collect(Collectors.toList());
        List<String> operationList1 = getWebElements(operation).stream().map(x -> x.getText()).collect(Collectors.toList());

        data.forEach(j -> {
            if (groupNameList.contains(j)) {
                getWebElements(groupName).stream().filter(x -> x.getText().equalsIgnoreCase(j)).findFirst().get().click();
            } else if (operationList.contains(j)) {
                getWebElements(operation).stream().filter(x -> x.getAttribute("id").equalsIgnoreCase(j)).findFirst().get().click();
            } else if (operationList1.contains(j)) {
                getWebElements(operation).stream().filter(x -> x.getText().equalsIgnoreCase(j)).findFirst().get().click();
            }
            else if(j.isEmpty())
            {
                System.out.println("inside empty");
            }
            else {
                Assert.fail("invalid input " + j);
            }
        });
    }

    public void clickCalculateButton() {
        getWebElement(continueButton).click();
    }

    public void validateResponse(String input) {
        String actual = getWebElement(result).getText();
        Assert.assertTrue(input.equalsIgnoreCase(actual), "Expected Value is "+input+" and the Actual result is "+actual);
    }

    public void clearTextArea() {
        getWebElement(textArea).click();
        getWebElement(textArea).clear();
    }
}
