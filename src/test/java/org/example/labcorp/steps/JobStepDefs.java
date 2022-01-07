package org.example.labcorp.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.core.ui.SharedDriver;
import org.example.labcorp.pages.Job;
import org.example.labcorp.pages.JobApply;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JobStepDefs {

    private Job job;
    private JobApply jobApply;

    public JobStepDefs(final SharedDriver sharedDriver, final Job job) {
        this.job = job;
    }

    @And("I should see {string} job title")
    public void iShouldSeeJobTitle(final String jobTitle) {
        assertEquals(jobTitle, job.getJobTitleLabel(), "job title doesn't match:");
    }

    @And("I should see {string} job location")
    public void iShouldSeeJobLocation(final String jobLocation) {
        assertTrue(job.getJobLocationLabel().contains(jobLocation), "job location doesn't contains:");
    }

    @And("I should see {string} job id")
    public void iShouldSeeJobId(final String jobId) {
        assertTrue(job.getJobIdLabel().contains(jobId));
    }

    @And("The job description sentence number {int} should be")
    public void theJobDescriptionSentenceNumberShouldBe(int position, final String jobDescription) {
        assertEquals(jobDescription, job.getDescriptionIntroduction(position),
                String.format("job description sentence number %d doesn't match:", position));
    }

    @And("The job description bullet number {int} should be {string}")
    public void theJobDescriptionBulletNumberShouldBe(int position, final String jobBullet) {
        assertEquals(jobBullet, job.getDescriptionBullets(position),
                String.format("job description bullet doesn't match on position %d:", position));
    }

    @And("The job requirements number {int} should be {string}")
    public void theJobRequirementsNumberShouldBe(int position, final String jobRequirement) {
        assertEquals(jobRequirement, job.getDescriptionRequirements(position),
                String.format("job requirements doesn't match on position %d:", position));
    }

    @And("I click Apply button")
    public void iClickApplyButton() {
         jobApply = job.clickApplyButton();
    }

    @Then("I should see {string} job title on Apply page")
    public void iShouldSeeJobTitleOnApplyPage(final String jobTitle) {
        assertEquals(jobTitle, jobApply.getJobTitleLabel(), "job title doesn't match:");
    }

    @And("I should see {string} job location on Apply page")
    public void iShouldSeeJobLocationOnApplyPage(final String jobLocation) {
        assertTrue(jobApply.getJobLocationLabel().contains(jobLocation), "job location doesn't contains:");
    }

    @And("I should see {string} job id on Apply page")
    public void iShouldSeeJobIdOnApplyPage(final String jobId) {
        assertTrue(jobApply.getJobIdLabel().contains(jobId));
    }

    @And("The job description sentence number {int} on Apply page should be")
    public void theJobDescriptionSentenceNumberOnApplyPageShouldBe(int position, final String jobDescription) {
        assertEquals(jobDescription, jobApply.getDescriptionIntroduction(position),
                String.format("job description sentence number %d doesn't match:", position));
    }

    @And("The job description bullet number {int} on Apply page should be {string}")
    public void theJobDescriptionBulletNumberOnApplyPageShouldBe(int position, final String jobBullet) {
        assertEquals(jobBullet, jobApply.getDescriptionBullets(position),
                String.format("job description bullet doesn't match on position %d:", position));
    }

    @And("The job requirements number {int} on Apply page should be {string}")
    public void theJobRequirementsNumberOnApplyPageShouldBe(int position, final String jobRequirement) {
        assertEquals(jobRequirement, jobApply.getDescriptionRequirements(position),
                String.format("job requirements doesn't match on position %d:", position));
    }

    @And("I click Return To Job search button")
    public void iClickReturnToJobSearchButton() {
        jobApply.clickReturnToJobSearch();
    }
}
