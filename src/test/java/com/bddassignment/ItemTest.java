package com.bddassignment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class aims to test the methods implemented in Item.java by using Junit.
 *
 * Created by eloyrouraperez on 17/04/16.
 */
public class ItemTest {
    private Item item;

    @Before
    public void setUp() throws Exception {
        item = new Item();
    }

    @Test
    public void test_Postage(){
        item.setPostage("Collection Only");
        assertFalse(item.isPostage());

        item.setPostage("+ $10.23 postage");
        assertFalse(item.isPostage());

        item.setPostage("Free Postage");
        assertTrue(item.isPostage());
    }

    @Test
    public void test_Price(){
        item.setPrice("$1,214.99");
        assertTrue(item.getPrice()==1214.99);

        item.setPrice("$1,214");
        assertTrue(item.getPrice()==1214);

        item.setPrice("$1.214");
        assertTrue(item.getPrice()==1.214);

        item.setPrice("$dadas");
        assertTrue(item.getPrice()==0.0);
    }

    @Test
    public void test_BuyItNow(){
        item.setBuyItNow("Buy it now");
        assertTrue(item.isBuyItNow());

        item.setBuyItNow("Buy it now or best offer");
        assertFalse(item.isBuyItNow());

        item.setBuyItNow("13 bids");
        assertFalse(item.isBuyItNow());
    }

    @Test
    public void test_NumberOfBids(){
        item.setNumberOfBids("13 bids");
        assertTrue(item.getNumberOfBids()==13);

        item.setNumberOfBids("Buy it now");
        assertTrue(item.getNumberOfBids()==0);
    }
}