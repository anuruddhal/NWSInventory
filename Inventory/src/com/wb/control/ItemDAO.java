/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wb.control;

import com.wb.model.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Anuruddha
 */
public class ItemDAO {

    public boolean insert(Item i) {
        boolean ok = false;
        try {
            String sql = "INSERT INTO `item`"
                    + "(`item_ID`, `item_Name`, `item_Des`, `item_Cat`, `item_Unit`, "
                    + "`item_Location`, `item_Uprice`, `item_Qty`, `item_Rlevel`) "
                    + "VALUES "
                    + "(?,?,?,?,?,?,"
                    + "?,?,?)"; //?? - stands for empty parameters

            Connection con = DBFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, i.getItemId());
            ps.setString(2, i.getName());
            ps.setString(3, i.getDesc());
            ps.setString(4, i.getCategory());
            ps.setString(5, i.getUnit());
            ps.setString(6, i.getLocation());
            ps.setDouble(7, i.getUnitPrice());
            ps.setDouble(8, i.getQuantity());
            ps.setDouble(9, i.getReorderLevel());
            if (ps.executeUpdate() > 0) {
                ok = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error :" + e.getMessage());
        }
        return ok;
    }

    public boolean update(Item i) {
        boolean ok = false;
        try {
            String sql = "UPDATE `item` SET "
                    + "`item_Name`=?,`item_Des`=?, "
                    + "`item_Cat`=?,`item_Unit`=?, "
                    + "`item_Location`=?,`item_Uprice`=?, "
                    + "`item_Qty`=?,`item_Rlevel`=?"
                    + "WHERE `item_ID`=?"; //?? - stands for empty parameters
            Connection con = DBFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(9, i.getItemId());
            ps.setString(1, i.getName());
            ps.setString(2, i.getDesc());
            ps.setString(3, i.getCategory());
            ps.setString(4, i.getUnit());
            ps.setString(5, i.getLocation());
            ps.setDouble(6, i.getUnitPrice());
            ps.setDouble(7, i.getQuantity());
            ps.setDouble(8, i.getReorderLevel());
            if (ps.executeUpdate() > 0) {
                ok = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error :" + e.getMessage());
        }
        return ok;

        //To change body of generated methods, choose Tools | Templates.
    }

    public Item search(String id) {
        Item i = null;
        try {
            String sql = "select * from item where item_ID=?;"; //?? - stands for empty parameters
            Connection con = DBFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet r = ps.executeQuery();
            if (r.next()) {
                i = new Item();
                i.setItemId(id);
                i.setCategory(r.getString("item_Cat"));
                i.setDesc(r.getString("item_Des"));
                i.setLocation(r.getString("item_Location"));
                i.setUnit(r.getString("item_Unit"));
                i.setName(r.getString("item_Name"));
                i.setQuantity(r.getDouble("item_Qty"));
                i.setUnitPrice(r.getDouble("item_Uprice"));
                i.setReorderLevel(r.getDouble("item_Rlevel"));

            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error :" + e.getMessage());
        }
        return i; //To change body of generated methods, choose Tools | Templates.
    }

    public boolean delete(Item i) {
        boolean ok = false;
        try {
            String sql = "delete from item where item_id=?"; //?? - stands for empty parameters
            Connection con = DBFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, i.getItemId());
            if (ps.executeUpdate() > 0) {
                ok = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error :" + e.getMessage());
        }
        return ok; //To change body of generated methods, choose Tools | Templates.
    }

    public List<Item> listAll() {
        List<Item> l = new ArrayList<Item>();
        try {
            String sql = "select * from item;"; //?? - stands for empty parameters
            Connection con = DBFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet r = ps.executeQuery();
            while (r.next()) {
                Item c = new Item();
                c.setItemId(r.getString("item_ID"));
                c.setName(r.getString("item_Name"));
                c.setDesc(r.getString("item_Des"));
                c.setUnit(r.getString("item_Unit"));
                c.setUnitPrice(r.getDouble("item_Uprice"));
                c.setLocation(r.getString("item_Location"));
                c.setReorderLevel(r.getDouble("item_Rlevel"));
                l.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error :" + e.getMessage());
        }
        return l;
    }
    public Item getItem(String ID){
     
        String sql = "select * from item where item_ID ='"+ID+"';";
        Item i =null;
        try {
            Connection con = DBFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet r = ps.executeQuery();
            if (r.next()){
             i = new Item();
             i.setUnit(r.getString("item_Unit"));
            
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error :" + ex.getMessage());
        }
        
    return i;
    }
}
