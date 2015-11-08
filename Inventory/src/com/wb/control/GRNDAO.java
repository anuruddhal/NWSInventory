/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wb.control;

import com.wb.model.GRN;
import com.wb.model.Item;
import com.wb.model.MIN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class GRNDAO {

    public boolean insert(GRN i) {

        boolean ok = false;
        try {

            String sql = "INSERT INTO recieved (`grn_No`, `grn_Description`, `grn_Price`, `grn_FromLocation`, `grn_dateRecieved`)"
                    + " VALUES (?,?,?,?,?)";
            Connection con = DBFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            con.setAutoCommit(false);
            ps.setString(1, i.getGRN_No());
            ps.setString(2, i.getDestination());
            ps.setDouble(3, i.getTotal());
            ps.setString(4, i.getDestination());
            ps.setString(5, i.getDate());
       

            if (ps.executeUpdate() > 0) {
                ok = true;
            }
            List<Item> k = i.getItems();
            String sql1 = "INSERT INTO nwsdb.recieved_item (`grn_No`, `item_ID`, `grn_itemQty`, `grn_itemUprice`)"
                    + " VALUES (?,?,?,?)";
            PreparedStatement ps1 = con.prepareStatement(sql1);

            String sql2 = "update item set item_Qty=item_Qty+? where item_ID=?;";

            PreparedStatement ps2 = con.prepareStatement(sql2);

            for (Item c : k) {

                ps1.setString(1, i.getGRN_No());
                ps1.setString(2, c.getItemId());
                ps1.setDouble(3, c.getQuantity());
                ps1.setDouble(4, c.getUnitPrice());

                //setting values to remove item quatity when issued
                ps2.setDouble(1, c.getQuantity());
                ps2.setString(2, c.getItemId());

                if (ps1.executeUpdate() > 0 & ps2.executeUpdate() > 0) {
                    ok = true;
                    con.commit();
                } else {
                    con.rollback();
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error :" + ex.getMessage());
        }

        return ok;
    }
}
