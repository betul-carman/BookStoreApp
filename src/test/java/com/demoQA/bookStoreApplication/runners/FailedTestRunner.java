package com.demoQA.bookStoreApplication.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features ="@target/rerun.txt",
        glue = "com/demoQA/bookStoreApplication/step_definitions"
)
public class FailedTestRunner {
}
