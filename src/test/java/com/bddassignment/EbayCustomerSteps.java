package com.bddassignment;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;


/**
 * Created by eloyrouraperez on 21/04/16.
 */
public class EbayCustomerSteps {

    private static final double DELTA = 1e-15;
    private EbayDriver ebayDriver;

    @Given("^I open the website$")
    public void i_open_the_website() {
        ebayDriver = new EbayDriver();
    }

    @When("^I search for (.+)$")
    public void search(String item) {
        ebayDriver.searchBy(item);
    }

    @And("^I sort by \"([^\"]*)\"$")
    public void sortBy(String sortingType) {
        ebayDriver.sortBy(sortingType);
    }

    @And("^I list the \"([^\"]*)\"$")
    public void list(String listingType) {
        ebayDriver.list(listingType);
    }

    //@Then("^I see the fist item at £([1-9][0-9]*\\.?[0-9]{0,2})$")
    @Then("^I see the fist item at £(\\d+.\\d+)$")
    public void i_see_the_fist_item_at_£(double expected) throws Throwable {
        assertEquals(expected, ebayDriver.getItem(1).getPrice(), DELTA);
        ebayDriver.close();
    }

}
