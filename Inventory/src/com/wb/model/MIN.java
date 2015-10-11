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
public class MIN {
    
    private String MIN_No;
    private String Date;
    private String Description;
    private String Destination;
    private String Item_ID;
    private String Issued_By;
    private double Quantity;
    private double Unit_Price;
    private double Total;
    private List <Item>items;

    /**
     * @return the MIN_No
     */
    public String getMIN_No() {
        return MIN_No;
    }

    /**
     * @param MIN_No the MIN_No to set
     */
    public void setMIN_No(String MIN_No) {
        this.MIN_No = MIN_No;
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
     * @return the Issued_By
     */
    public String getIssued_By() {
        return Issued_By;
    }

    /**
     * @param Issued_By the Issued_By to set
     */
    public void setIssued_By(String Issued_By) {
        this.Issued_By = Issued_By;
    }

    /**
     * @return the Quantity
     */
    public double getQuantity() {
        return Quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MIN other = (MIN) obj;
        if ((this.MIN_No == null) ? (other.MIN_No != null) : !this.MIN_No.equals(other.MIN_No)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.MIN_No != null ? this.MIN_No.hashCode() : 0);
        return hash;
    }

    /**
     * @param Quantity the Quantity to set
     */
    public void setQuantity(double Quantity) {
        this.Quantity = Quantity;
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
    
}
