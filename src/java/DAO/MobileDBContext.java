/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Account;
import Model.Mobile;
import Ultis.Helper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kienb
 */
public class MobileDBContext extends DBContext {

    public List<Mobile> getAll(String search, String min, String max) {
        List<Mobile> mobiles = new ArrayList<>();
        try {
            List<Object> params = new ArrayList<>();
            String sql = "Select * from tbl_Mobile where 1=1";
            if (search != null && !search.trim().isEmpty()) {
                sql += " and mobileId like ? or mobileName like ?";
                params.add(search);
                params.add(search);
            }
            if (min != null && !min.trim().isEmpty()) {
                sql += " and price >= ?";
                params.add(Float.parseFloat(min));
            }
            if (max != null && !max.trim().isEmpty()) {
                sql += " and price <= ?";
                params.add(Float.parseFloat(max));
            }
            PreparedStatement ptm = connection.prepareStatement(sql);
            Helper.mapParams(ptm, params);
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                Mobile mobile = new Mobile();
                mobile.setMobileID(rs.getString(1));
                mobile.setDescription(rs.getString(2));
                mobile.setPrice(rs.getFloat(3));
                mobile.setMobileName(rs.getString(4));
                mobile.setYear(rs.getInt(5));
                mobile.setQuantity(rs.getInt(6));
                mobile.setIsSale(rs.getBoolean(7));
                mobiles.add(mobile);
            }
            return mobiles;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Mobile getByID(String id) {
        try {
            String sql = "Select * from tbl_Mobile where mobileId = ?";
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setString(1, id);
            ResultSet rs = ptm.executeQuery();
            if (rs.next()) {
                Mobile mobile = new Mobile();
                mobile.setMobileID(rs.getString(1));
                mobile.setDescription(rs.getString(2));
                mobile.setPrice(rs.getFloat(3));
                mobile.setMobileName(rs.getString(4));
                mobile.setYear(rs.getInt(5));
                mobile.setQuantity(rs.getInt(6));
                mobile.setIsSale(rs.getBoolean(7));
                return mobile;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void deleteByID(String id) {
        try {
            String sql = "DELETE FROM [dbo].[tbl_Order]\n"
                    + "      WHERE mobileId = ?";
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setString(1, id);
            ptm.executeUpdate();
            String xSQL = "DELETE FROM [dbo].[tbl_Mobile]\n"
                    + "      WHERE mobileId = ?";
            PreparedStatement xtm = connection.prepareStatement(xSQL);
            xtm.setString(1, id);
            xtm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateMobile(String id, Float price, String description, int quantity, boolean isSale) {
        try {
            String sql = "UPDATE [dbo].[tbl_Mobile]\n"
                    + "   SET \n"
                    + "       [description] = ?\n"
                    + "      ,[price] = ?\n"
                    + "      ,[quantity] = ?\n"
                    + "      ,[notSale] = ?\n"
                    + " WHERE mobileId = ?";
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setString(5, id);
            ptm.setString(1, description);
            ptm.setFloat(2, price);
            ptm.setInt(3, quantity);
            ptm.setBoolean(4, isSale);
            ptm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert(String id, String name, Float price, String description, int quantity, boolean isSale, int year) {
        try {
            String sql = "INSERT INTO [dbo].[tbl_Mobile]\n"
                    + "           ([mobileId]\n"
                    + "           ,[description]\n"
                    + "           ,[price]\n"
                    + "           ,[mobileName]\n"
                    + "           ,[yearOfProduction]\n"
                    + "           ,[quantity]\n"
                    + "           ,[notSale])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,?)";
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setString(1, id);
            ptm.setString(2, description);
            ptm.setFloat(3, price);
            ptm.setString(4, name);
            ptm.setInt(5, year);
            ptm.setInt(6, quantity);
            ptm.setBoolean(7, isSale);
            ptm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
