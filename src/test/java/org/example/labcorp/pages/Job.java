package org.example.labcorp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;

public class Job extends AbstractPage {

    @FindBy(css = ".job-description__heading")
    private WebElement jobTitleLabel;

    @FindBy(css = ".job-location.job-info")
    private WebElement jobLocationLabel;

    @FindBy(css = ".job-id.job-info")
    private WebElement jobIdLabel;

    @FindBy(css = ".ats-description > p")
    private WebElement descriptionIntroduction;

    @FindBy(css = ".job-apply")
    private WebElement applyNowButton;

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
        return action.getText(By.cssSelector(String.format(".ats-description > ul li:nth-child(%d)", position)));
    }

    public String getDescriptionRequirements(int position) {
        return action.getText(By.cssSelector(String.format(".ats-description > div li:nth-child(%d)", position)));
    }

    public JobApply clickApplyButton() {
        applyNowButton.click();
        return new JobApply();
    }
}
