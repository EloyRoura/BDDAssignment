package com.bddassignment;

import java.util.Scanner;

/**
 * This is the main class of the BDD test assignment.
 *
 * This allows to use the ebay driver and item classes implemented in this Maven project
 * to allow the navigation on www.ebay.co.uk. The user is able to look for a specific item
 * sorting the list by different filters and list them depending on the selling format.
 *
 * At the moment we only show the first 50 items present in the first page, navigation of the
 * rest of pages is not implemented yet. We also allow to select one of these items to show
 * its properties in the browser and also in the command line.
 *
 * Created by Eloy Roura Perez on 17/04/16.
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        EbayDriver ebayDriver = new EbayDriver();

        //Input parameters
        String itemName;
        int sortType;
        int listing;
        int itemNumber;

        System.out.println("Type the item you want to search:");
        itemName = sc.next();
        ebayDriver.searchBy(itemName);

        System.out.println("Type how do you want to sort the search:");
        System.out.println("\t1. Best Match");
        System.out.println("\t2. Lowest price + P&P");
        System.out.println("\t3. Highest price");
        System.out.println("\t4. Newly listed");

        sortType = sc.nextInt();

        switch (sortType){
            case 1:
                ebayDriver.sortBestMatch();
                break;
            case 2:
                ebayDriver.sortLowestPrice();
                break;
            case 3:
                ebayDriver.sortHighestPrice();
                break;
            case 4:
                ebayDriver.sortNewlyListed();
                break;
            default:
                System.out.println("Bad input, Best Match sorting is applied.");
                break;
        }


        System.out.println("Type how do you what type of sell do you want to list:");
        System.out.println("\t1. All listings");
        System.out.println("\t2. Auction");
        System.out.println("\t3. Buy it now");

        listing = sc.nextInt();

        switch (listing){
            case 1:
                ebayDriver.listAll();
                break;
            case 2:
                ebayDriver.listAuctions();
                break;
            case 3:
                ebayDriver.listBuyNow();
                break;
            default:
                System.out.println("Bad input, all listings are shown.");
                break;
        }


        System.out.println("There are " + ebayDriver.getNumItems() + " on sell with this filter, 50 in this page! Which one do you want to see?");

        itemNumber = sc.nextInt();
        ebayDriver.getItem(itemNumber).showItem();


    }
}
