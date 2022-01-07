package org.example.labcorp.pages;

import org.openqa.selenium.By;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobsLabCorp extends AbstractPage {

    @FindBy(className = "search-keyword")
    private WebElement keywordSearchInput;

    @FindBy(css = ".search-location")
    private WebElement locationInput;

    @FindBy(css = ".search-form__submit")
    private WebElement submitButton;

    public void setKeywordSearchInput(final String keyword) {
        action.clear(locationInput);
        action.setValue(keywordSearchInput, keyword);
    }

    public void clickSubmitButton() {
        action.click(submitButton);
    }

    public Job openJobLink(final String jobName) {
        action.click(By.xpath(String.format("//h2[text()='%s']/parent::a", jobName)));
        return new Job();
    }
}
