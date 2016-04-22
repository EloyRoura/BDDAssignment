package com.bddassignment;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;


/**
 * This class aims to test the behaviour of a new ebay used based on an item search
 * and the filters applied on top of this search.
 *
 * Created by Eloy Roura Perez on 21/04/16.
 */
public class EbayCustomerSteps {

    private static final double DELTA = 1e-15;
    private EbayDriver ebayDriver;
    private Item item;

    @Given("^I open the website$")
    public void i_open_the_website() {
        ebayDriver = new EbayDriver();
    }

    @When("^I search for (.+)$")
    public void search(String item) {
        ebayDriver.searchBy(item);
    }

    @And("^I list the \"([^\"]*)\"$")
    public void list(String listingType) throws InterruptedException {
        ebayDriver.list(listingType);
    }

    @And("^I sort by \"([^\"]*)\"$")
    public void sortBy(String sortingType) {
        ebayDriver.sortBy(sortingType);
    }

    //@Then("^I see the fist item at £([1-9][0-9]*\\.?[0-9]{0,2})$")
    @Then("^I see the first item at £(\\d+.\\d+)$")
    public void i_see_the_fist_item_at_£(double expected) throws Throwable {
        item = ebayDriver.getItem(1);
        assertEquals(expected, item.getPrice(), DELTA);
        ebayDriver.close();
    }

    @And("^it has (\\d+) bids$")
    public void i_see_numberOfBids(int expected) {
        assertEquals(expected, item.getNumberOfBids(), DELTA);
    }
    @And("^it has \"([^\"]*)\" Postage$")
    public void i_see_numberOfBids(String expected) {
        String postageType = item.isPostage() ? "Free" : "NonFree";
        assertEquals(expected, postageType);
    }

    //This test will rarely pass since the number of items is changing so frequent... DELTA should be at least 150
    @And("^there are (\\d+) items$")
    public void i_see_numberOfItems(int expected) {
        assertEquals(expected, ebayDriver.getNumItems(), 150);
    }


}
