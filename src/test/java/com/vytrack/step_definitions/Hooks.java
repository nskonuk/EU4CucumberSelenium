package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //@Before // it runs before EVERY test case
   // public void setUp(){
     //   System.out.println("\tthis is coming from BEFORE");
   // }
    @After // it runs after EVERY test case
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte [] screenshot = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Driver.closeDriver();
    }
    @Before("@DataBase")// it runs only before labelled test case
    public void setUpDataBase(){
        System.out.println("\tConnecting to Database");
    }
    @After("@DataBase") // it runs only after labelled test case
    public void CloseDataBase(){
        System.out.println("\tDisconnecting from database.....");
    }
}
