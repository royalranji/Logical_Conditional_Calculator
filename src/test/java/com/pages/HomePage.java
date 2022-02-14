package com.pages;

import com.constants.Constants;
import com.utilities.DurationUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {


    public boolean isHomePageDisplayed() {
        return getPageTitle().contains(Constants.CALC_PAGE_TITLE);

    }

}
