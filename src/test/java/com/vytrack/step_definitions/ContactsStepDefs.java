package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class ContactsStepDefs {
    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
       // go to login page
        Driver.get().get(ConfigurationReader.get("url"));
        //based on input enter that user information
        String username=null;
        String password=null;
        if(userType.equals("driver")){
            username=ConfigurationReader.get("driver_username");
            password=ConfigurationReader.get("driver_password");
        }else if(userType.equals("sales manager")){
            username=ConfigurationReader.get("sales_manager_username");
            password=ConfigurationReader.get("sales_manager_password");
        }else if(userType.equals("store manager")){
            username=ConfigurationReader.get("store_manager_username");
            password=ConfigurationReader.get("store_manager_password");
        }
        //send username and password and login
        new LoginPage().login(username,password);

    }

    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> mmenuOptions) {
        BrowserUtils.waitFor(5);
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,

//        System.out.println(mmenuOptions.size());
//        System.out.println(mmenuOptions);
        // get the list of webelement and convert them to list of string and assert

        List<String> actualOptions = BrowserUtils.getElementsText(new DashboardPage().menuOptions);
        Assert.assertEquals(mmenuOptions,actualOptions);



    }
    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String,String> userInfo) {

        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.

        // use map info to login and also verify firstname and lastname
        new LoginPage().login(userInfo.get("username"),userInfo.get("password"));
        BrowserUtils.waitFor(5);
        DashboardPage dashboardPage=new DashboardPage();
        String actualName=dashboardPage.getUserName();
        String expectedName=userInfo.get("firstname")+" "+userInfo.get("lastname");

        Assert.assertEquals(expectedName,actualName);
        System.out.println("actualName = " + actualName);
        System.out.println("expectedName = " + expectedName);


    }

}
