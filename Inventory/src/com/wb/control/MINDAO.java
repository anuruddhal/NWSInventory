/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wb.control;

import com.wb.model.Item;
import com.wb.model.MIN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class MINDAO {

    public boolean insert(MIN i) {

        boolean ok = false;
        try {

            String sql = "INSERT INTO `issued`(`Issued_DoRefNo`, "
                    + "`issued_ForLocation`, `issued_Description`, `Issued_Date`,"
                    + " `Issued_By`, `Total`)"
                    + " VALUES (?,?,?,?,?,?)";
            Connection con = DBFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, i.getMIN_No());
            ps.setString(2, i.getDestination());
            ps.setString(3, i.getDescription());
            ps.setString(4, i.getDate());
            ps.setString(5, i.getIssued_By());
            ps.setDouble(6, i.getTotal());

            if (ps.executeUpdate() > 0) {
                ok = true;
            }
            List<Item> k = i.getItems();
            String sql1 = "INSERT INTO `issued_item`(`issueditem_RefNo`,"
                    + " `item_ID`, `issueditem_Qty`, `issueditem_Uprice`)"
                    + " VALUES (?,?,?,?)";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            
            for (Item c : k){
            
            ps1.setString(1, i.getMIN_No());
            ps1.setString(2, c.getItemId());
            ps1.setDouble(3, c.getQuantity() );
            ps1.setDouble(4, c.getUnitPrice());
            
            if (ps1.executeUpdate()>0){
            
            ok = true;
            }
            
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error :" + ex.getMessage());
        }

        return ok;
    }
}
