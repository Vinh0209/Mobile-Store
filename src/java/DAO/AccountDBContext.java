/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kienb
 */
public class AccountDBContext extends DBContext {

    public Account login(String username, int password) {
        try {
            String sql = "Select * from tbl_User where userId = ? and [password] = ?";
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setString(1, username);
            ptm.setInt(2, password);
            ResultSet rs = ptm.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setUserID(username);
                account.setPassword(password);
                account.setRole(rs.getInt(4));
                account.setFullName(rs.getString(3));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(String userID, String mobileID, int quantity) {
        try {
            String sql = "INSERT INTO [dbo].[tbl_Order]\n"
                    + "           ([userId]\n"
                    + "           ,[mobileId]\n"
                    + "           ,[quantity])\n"
                    + "     VALUES\n"
                    + "           (?,?,?)";
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setString(1, userID);
            ptm.setString(2, mobileID);
            ptm.setInt(3, quantity);
            ptm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
