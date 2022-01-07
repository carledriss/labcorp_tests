package org.example.labcorp.steps;

import io.cucumber.java.en.When;
import org.example.core.ui.SharedDriver;
import org.example.labcorp.pages.JobsLabCorp;

public class JobsLabCorpStepDefs {

    public JobsLabCorpStepDefs(final SharedDriver sharedDriver) {
    }

    @When("I search {string} job")
    public void iSearchJob(final String jobName) {
        JobsLabCorp jobsLabCorp = new JobsLabCorp();
        jobsLabCorp.setKeywordSearchInput(jobName);
        jobsLabCorp.clickSubmitButton();
        jobsLabCorp.openJobLink(jobName);
    }

}
