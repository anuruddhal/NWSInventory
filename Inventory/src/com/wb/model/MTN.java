/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wb.model;

import java.util.List;

/**
 *
 * @author user
 */
public class MTN {
    
    private String MTN_No;
    private String Date;
    private String Description;
    private String Destination;
    private String Item_ID;
    private String Issued_by;
    private double Quatity;
    private double Unit_Price;
    private double Total;
    private List <Item>items;

    /**
     * @return the MTN_No
     * 
     */
    public String getMTN_No() {
        return MTN_No;
    }

    /**
     * @param MTN_No the MTN_No to set
     */
    public void setMTN_No(String MTN_No) {
        this.MTN_No = MTN_No;
    }

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(String Date) {
        this.Date = Date;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the Destination
     */
    public String getDestination() {
        return Destination;
    }

    /**
     * @param Destination the Destination to set
     */
    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    /**
     * @return the Item_ID
     */
    public String getItem_ID() {
        return Item_ID;
    }

    /**
     * @param Item_ID the Item_ID to set
     */
    public void setItem_ID(String Item_ID) {
        this.Item_ID = Item_ID;
    }

    /**
     * @return the Quatity
     */
    public double getQuatity() {
        return Quatity;
    }

    /**
     * @param Quatity the Quatity to set
     */
    public void setQuatity(double Quatity) {
        this.Quatity = Quatity;
    }

    /**
     * @return the Unit_Price
     */
    public double getUnit_Price() {
        return Unit_Price;
    }

    /**
     * @param Unit_Price the Unit_Price to set
     */
    public void setUnit_Price(double Unit_Price) {
        this.Unit_Price = Unit_Price;
    }

    /**
     * @return the items
     */
    public List <Item> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List <Item> items) {
        this.items = items;
    }

    /**
     * @return the Issued_by
     */
    public String getIssued_by() {
        return Issued_by;
    }

    /**
     * @param Issued_by the Issued_by to set
     */
    public void setIssued_by(String Issued_by) {
        this.Issued_by = Issued_by;
    }

    /**
     * @return the Total
     */
    public double getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(double Total) {
        this.Total = Total;
    }
    
    
    
}
