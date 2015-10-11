/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wb.control;

import com.wb.model.Item;
import com.wb.model.MTN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class MTNDAO {

    public boolean insert(MTN i) {
        boolean ok = false;
        try {
            String sql = "INSERT INTO `transfered`(`transfered_DNo`, "
                    + "`transfered_ForLocation`, `transfered_Description`, "
                    + "`transfered_Date`,`Issued_By`,`Total`)"
                    + " VALUES (?,?,?,?,?,?)"; //?? - stands for empty parameters

            Connection con = DBFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, i.getMTN_No());
            ps.setString(2, i.getDestination());
            ps.setString(3, i.getDescription());
            ps.setString(4, i.getDate());
            ps.setString(5, i.getIssued_by());
            ps.setDouble(6, i.getTotal());

            if (ps.executeUpdate() > 0) {
                ok = true;
            }

            List<Item> k = i.getItems();
            String sql1 = "INSERT INTO `transfered_item`"
                    + "(`transfered_No`, `item_ID`, `transfered_itemQty`, "
                    + "`transfered_itemPrice`) VALUES (?,?,"
                    + "?,?)";
            PreparedStatement ps1 = con.prepareStatement(sql1);

            for (Item c : k) {

                ps1.setString(1, i.getMTN_No());
                ps1.setString(2, c.getItemId());
                ps1.setDouble(3, c.getQuantity());
                ps1.setDouble(4, c.getUnitPrice());
            
            if (ps1.executeUpdate() > 0) {
                ok = true;
            }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error :" + e.getMessage());
        }
        return ok;

    }
}
