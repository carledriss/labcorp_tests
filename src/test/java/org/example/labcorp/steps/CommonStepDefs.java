package org.example.labcorp.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.core.ui.SharedDriver;
import org.example.labcorp.pages.Home;

public class CommonStepDefs {

    private Home home;

    public CommonStepDefs(final SharedDriver sharedDriver) {
    }

    @Given("I navigate to LabCorp")
    public void iNavigateToCourses() {
        home = new Home();
    }

    @And("I go to {string}")
    public void iGoTo(final String link) {
        home.clickMenuItem(link);
    }
}
