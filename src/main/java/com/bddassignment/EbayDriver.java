package com.bddassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * In this class we manage the access to the ebay website by using the WebDriver. We navigate
 * through the website on the safari browser. However, other approaches like using the html code
 * or using the API from ebay would be faster, since we would not need to load the pages on the
 * browser.
 *
 * We allow to search for any item, sorting them with four different filters and also list them
 * depending on the sell format.
 *
 * Cucumber-JVM could be used to test the behaviour of the user by using this class by using
 * the step definitions.
 *
 * Also, we could use the Mockito library to test the methods in this class.
 *
 * Created by Eloy Roura Perez on 17/04/16.
 */
public class EbayDriver {
    private WebDriver webDriver;
    private WebDriverWait wait;

    /*
    * This is the constructor of the class EbayDriver. This opens the safari browser into the
    * ebay.co.uk site.
     */
    public EbayDriver(){
        this.webDriver = new SafariDriver();
        wait = new WebDriverWait(webDriver, 20);
        webDriver.get("http://www.ebay.co.uk");
    }

    public void close(){
        this.webDriver.close();
        this.webDriver.quit();
    }

    /*
    * Search into the ebay.co.uk for the itemName.
     */
    public void searchBy(String itemName){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("gh-ac"))).sendKeys(itemName);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("gh-btn"))).click();
    }

    public int numberOfItems(){
        int numItems = 0;
        WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='listingscnt']")));
        String pattern = "\\d+,{0,1}\\d*";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(elem.getText());
        if (m.find( ))
            numItems = Integer.parseInt(m.group(0).replaceAll(",",""));

        return numItems;
    }

    /*
    *   Sorting:
    *       Best Match
    *       Lowest Price + P&P
    *       Highest Price
    *       Newly listed
     */

    /*
    * Sort all the search by the sorting type filter (Default Best Match). In case the page is not loaded it
    * waits 20 seconds. Once done, it also waits 10 more seconds until the next page is loaded.
     */
    public void sortBy(String sortingType){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='sel']"))).click();

        WebElement currentSort=webDriver.findElement(By.xpath("//ul[@class='sel']/li/a"));

        if(currentSort.getText().compareTo(sortingType)==0) {
            currentSort.click();
        }else{
            if (sortingType.compareTo("Lowest Price + P&P") == 0) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='SortMenu']/li/a[@value='15']"))).click();
            } else if (sortingType.compareTo("Highest Price") == 0) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='SortMenu']/li/a[@value='3']"))).click();
            } else if (sortingType.compareTo("Newly listed") == 0) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='SortMenu']/li/a[@value='10']"))).click();
            } else if (sortingType.compareTo("Best Match") == 0) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='SortMenu']/li/a[@value='12']"))).click();
            }
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ul[@id='SortMenu']")));
    }

    /*
    * Sort all the search by the best match items (Default). In case the page is not loaded it
    * waits 20 seconds. Once done, it also waits 10 more seconds until the next page is loaded.
     */
    public void sortBestMatch(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='sel']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='SortMenu']/li/a[@value='12']"))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ul[@id='SortMenu']")));
    }

    /*
    * Sort all the search by the lowest price and P&P items. In case the page is not loaded it
    * waits 20 seconds. Once done, it also waits 10 more seconds until the next page is loaded.
     */
    public void sortLowestPrice(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='sel']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='SortMenu']/li/a[@value='15']"))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ul[@id='SortMenu']")));
    }

    /*
    * Sort all the search by the highest price items. In case the page is not loaded it
    * waits 20 seconds. Once done, it also waits 10 more seconds until the next page is loaded.
     */
    public void sortHighestPrice(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='sel']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='SortMenu']/li/a[@value='3']"))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ul[@id='SortMenu']")));
    }

    /*
    * Sort all the search by the newly listed items. In case the page is not loaded it
    * waits 20 seconds. Once done, it also waits 10 more seconds until the next page is loaded
     */
    public void sortNewlyListed(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='sel']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='SortMenu']/li/a[@value='10']"))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//ul[@id='SortMenu']")));
    }


    /*
    *   Listing:
    *       All listings
    *       Auction
    *       Buy it now
     */


    /*
    * List all the items depending on the listing type (Auction | Buy it now).
     */
    public void list(String listingType){
        if(listingType.compareTo("Auction")==0){
            //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Auction']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Auction"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='Auction']")));
        }else if(listingType.compareTo("Buy it now")==0){
            wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Buy it now"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='Buy it now']")));
        }
        else if(listingType.compareTo("All listings")==0){
            wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("All listings"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='All listings']")));
        }
    }

    /*
    * List all the items.
     */
    public void listAll(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='All listings']"))).click();
    }

    /*
    * List all the items that are under an auction.
     */
    public void listAuctions(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Auction']"))).click();
    }

    /*
    * List all the items that can be bought without a bid.
     */
    public void listBuyNow(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Buy it now']"))).click();
    }

    /*
    * Return the number of items found in the search.
     */
    public Item getItem(int itemNumber){

        Item item = new Item();

        WebElement title = webDriver.findElement(By.xpath("//ul[@id='ListViewInner']/li[@r='"+itemNumber+"']/h3/a"));
        item.setTitle(title.getText());

        WebElement price = webDriver.findElement(By.xpath("//ul[@id='ListViewInner']/li[@r='"+itemNumber+"']/ul[@class='lvprices left space-zero']/li[@class='lvprice prc']/span"));
        item.setPrice(price.getText());

        String textFormat = getItemFormat(itemNumber);
        item.setBuyItNow(textFormat);
        item.setNumberOfBids(textFormat);

        String postage = getItemPostage(itemNumber);
        item.setPostage(postage);

        webDriver.findElement(By.xpath("//ul[@id='ListViewInner']/li[@r='"+itemNumber+"']/h3/a")).click();

        return item;
    }

    public String getItemFormat(int itemNumber){
        WebElement format = webDriver.findElement(By.xpath("//ul[@id='ListViewInner']/li[@r='"+itemNumber+"']/ul[@class='lvprices left space-zero']/li[@class='lvformat']/span"));
        String textFormat = format.getText();
        try{
            format = webDriver.findElement(By.xpath("//ul[@id='ListViewInner']/li[@r='"+itemNumber+"']/ul[@class='lvprices left space-zero']/li[@class='lvformat']/span/span"));
            textFormat=format.getAttribute("title");
        }catch(Exception ex){}
        return textFormat;
    }

    public String getItemPostage(int itemNumber){
        WebElement postage = webDriver.findElement(By.xpath("//ul[@id='ListViewInner']/li[@r='"+itemNumber+"']/ul[@class='lvprices left space-zero']/li[@class='lvshipping']/span"));

        if(postage.getText().compareTo("")==0){
            postage = webDriver.findElement(By.xpath("//ul[@id='ListViewInner']/li[@r='"+itemNumber+"']/ul[@class='lvprices left space-zero']/li[@class='lvshipping']/span/span"));
        }

        if(postage.getText().compareTo("")==0){
            postage = webDriver.findElement(By.xpath("//ul[@id='ListViewInner']/li[@r='"+itemNumber+"']/ul[@class='lvprices left space-zero']/li[@class='lvshipping']/span/span"));
        }

        return postage.getText();
    }

}
