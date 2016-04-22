package com.bddassignment;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import org.junit.runner.RunWith;

/**
 * Class created to run all the tests
 *
 * Created by eloyrouraperez on 21/04/16.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/com.bddassignment/"},
        format = {"pretty"},
        plugin = "json:target/cucumber-report.json"
)
public class RunCukesTest {
}
