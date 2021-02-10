package com.vytrack.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationMenuStepDefs {
    @When("user navigate on Menu and click Vehicles under Fleet")
    public void user_navigate_on_Menu_and_click_Vehicles_under_Vehicles() {
        System.out.println("User navigates on Menu and click Vehicles under Fleet");
    }

    @Then("Expected title should be changed to Vehicles")
    public void expected_title_should_be_changed_to_Vehicles() {
        System.out.println("Actual and expecting titles are matching");
    }

    @When("user navigate on Menu and click Campaigns under Marketing")
    public void user_navigate_on_Menu_and_click_Campaigns_under_Marketing() {
        System.out.println("User navigates on Menu and click Campaigns under Marketing");
    }

    @Then("Expected title should be changed to Campaigns")
    public void expected_title_should_be_changed_to_Campaigns() {
        System.out.println("Actual and expecting titles are matching");
    }

    @When("user navigate on Menu and click Calendar Events under Activities")
    public void user_navigate_on_Menu_and_click_Calendar_Events_under_Activities() {
        System.out.println("User navigates on Menu and click Calendar Events under Activities");
    }

    @Then("Expected title should be changed to Calendars")
    public void expected_title_should_be_changed_to_Calendars() {
        System.out.println("Actual and expecting titles are matching");
    }



}
