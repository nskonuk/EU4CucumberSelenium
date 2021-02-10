package com.vytrack.step_definitions;

import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
       String url= ConfigurationReader.get("url");
        Driver.get().get(url);//Driver.get()=driver

    }

    @When("the user enters the driver information")
    public void the_user_enters_the_driver_information() throws InterruptedException {
        String username=ConfigurationReader.get("driver_username");
        String password=ConfigurationReader.get("driver_password");
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() throws InterruptedException {
        BrowserUtils.waitFor(5);
        String actualTitle=Driver.get().getTitle();
        String expectedTitle="Dashboard";
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @When("the user enters the sales manager information")
    public void the_user_enters_the_sales_manager_information() throws InterruptedException {
        String username=ConfigurationReader.get("sales_manager_username");
        String password=ConfigurationReader.get("sales_manager_password");
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
    }

    @When("the user enters the store manager information")
    public void the_user_enters_the_store_manager_information() throws InterruptedException {
        String username=ConfigurationReader.get("store_manager_username");
        String password=ConfigurationReader.get("store_manager_password");
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
    }


    @When("user logs in using {string} and {string}")
    public void user_logs_in_using_and(String username, String password) {
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
    }
    @Then("the title contains {string}")
    public void the_title_contains(String expectedTitle) {
        BrowserUtils.waitFor(5);
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));
    }


    @When("the user navigates to {string} {string}")
    public void the_user_navigates_to(String tab, String module) {
        new DashboardPage().navigateToModule(tab,module);
    }

    @Then("default page number should be {int}")
    public void default_page_number_should_be(Integer expectedPageNumber) {
        BrowserUtils.waitFor(20);
        ContactsPage contactsPage=new ContactsPage();
        Integer actualNumber=Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));
        Assert.assertEquals(expectedPageNumber,actualNumber);
    }



}
