package com.bddassignment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * In this class we represent the essential feature of an item. This allows to store the basic
 * information as title, price, shipping fees, selling format and number of bids in case this
 * is an auction. Only getters and setters have been implemented so far.
 *
 * Created by Eloy Roura Perez on 17/04/16.
 */
public class Item {
    String title;
    double price;
    boolean postage;
    boolean buyItNow;
    int numberOfBids;

    public Item() {
        this.title="";
        this.price=0.0;
        this.postage=false;
        this.buyItNow=false;
        this.numberOfBids=0;
    }

    /*
    * Set the title of the item with the string argument.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /*
    * The price of the item is set from the string price, using regex expressions to
    * find the double representing the price.
     */
    public void setPrice(String price) {
        String pattern = "\\d+,{0,1}\\d*.{0,1}\\d*";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(price);
        if (m.find( ))
            this.price=Double.parseDouble(m.group(0).replaceAll(",",""));
        else
            this.price=0.0;

    }

    /*
    * The postage is set by evaluating the content of the string argument.
     */
    public void setPostage(String postage) {
        String pattern = "Free Postage";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(postage);
        if (m.find( ))
            this.postage = true;
        else
            this.postage = false;
    }

    /*
    * The method detects the selling format is set by evaluating the
    * content of the string argument.
     */
    public void setBuyItNow(String format) {
        this.buyItNow = format.compareTo("Buy it now")==0;
    }

    /*
    * The method detects if this item is under auction and sets the number of bids.
     */
    public void setNumberOfBids(String format) {
        String pattern = "\\d+";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(format);
        if (m.find( ))
            this.numberOfBids = Integer.parseInt(m.group(0));
        else
            this.numberOfBids = 0;
    }


    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPostage() {
        return postage;
    }

    public boolean isBuyItNow() {
        return buyItNow;
    }

    public int getNumberOfBids() {
        return numberOfBids;
    }

    /*
    * This method shows in the command line the values of all the atributes.
     */
    public void showItem(){
        System.out.println("Title: " + this.title);
        System.out.println("Price: " + this.price);
        if(this.postage)
            System.out.println("This item has postage fee!");
        else
            System.out.println("This item has free postage.");
        if(!buyItNow)
            System.out.println("There are " + numberOfBids + " bids.");
    }
}
