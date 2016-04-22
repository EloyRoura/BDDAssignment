package com.bddassignment;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import org.junit.runner.RunWith;

/**
 * Created by eloyrouraperez on 21/04/16.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/com.bddassignment/EbayCustomer.feature"},
        format = {"pretty"},
        plugin = "json:target/cucumber-report.json"
)
public class RunCukesTest {
}
