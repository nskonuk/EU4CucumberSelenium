package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",// not needed to make any change
        glue = "com/vytrack/step_definitions", // not needed to make any change

        dryRun = false, // without dryRun or dryRun=false  the cucumber execute the java codes inside the step definitions
                    // only for the sake of getting the undefined step definition it is not needed to execute the whole code
                    // which is very time consuming then make it true!!

        tags ="@wip" //in this way we can run our smoke suit very easily
        //tags ="@driver and @VYT-123"
        //tags ="@feature and not @VYT-123" //on the top of feature, run all of them except @VYT-123
        //tags ="@driver and @VYT-123 and @smoke"

        //tags ="@driver or @VYT-123"

        // tags={"@driver", "@VYT-123"} //old version
        // if we want to run all the scenarios under feature then we put the label ONLY on the tup of feature



)

public class CukesRunner {


}
