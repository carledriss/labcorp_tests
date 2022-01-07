package org.example.labcorp.pages;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobApply extends AbstractPage {

    @FindBy(css = ".jobTitle")
    private WebElement jobTitleLabel;

    @FindBy(css = "span[jcity='jobheader.city'] .resultfootervalue")
    private WebElement jobLocationLabel;

    @FindBy(css = ".jobnum")
    private WebElement jobIdLabel;

    @FindBy(css = ".content > p")
    private WebElement descriptionIntroduction;

    @FindBy(css = "button[ng-click*='Return']")
    private WebElement returnToJobSearchButton;

    public String getJobTitleLabel() {
        return action.getText(jobTitleLabel);
    }

    public String getJobLocationLabel() {
        return action.getText(jobLocationLabel);
    }

    public String getJobIdLabel() {
        return action.getText(jobIdLabel);
    }

    public String getDescriptionIntroduction(int position) {
        String[] sentences = action.getText(descriptionIntroduction).split("\\.");
        return sentences[position - 1].trim();
    }

    public String getDescriptionBullets(int position) {
        return action.getText(By.cssSelector(String.format("div[id*='left'] .content > ul li:nth-child(%d)", position)));
    }

    public String getDescriptionRequirements(int position) {
        return action.getText(By.cssSelector(String.format("div[id*='right'] .content > ul li:nth-child(%d)", position)));
    }

    public void clickReturnToJobSearch() {
        returnToJobSearchButton.click();
    }

}
