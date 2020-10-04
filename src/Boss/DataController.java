/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boss;

import dao.DatabaseConnector;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Rakib
 */
public class DataController {

    public static void loadAdminAccountId(JComboBox combo) {
        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rst = null;
        try {
            con = DatabaseConnector.getConnection();
            cstmt = con.prepareCall("{CALL getAllAdminAccId()}");
            cstmt.execute();
            rst = cstmt.getResultSet();
            List idlst = new ArrayList();
            while (rst.next()) {
                idlst.add(rst.getString(1));
            }
            combo.setModel(new DefaultComboBoxModel(idlst.toArray()));
            combo.insertItemAt("Select or Write ID", 0);
            combo.setSelectedIndex(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                cstmt.close();
                rst.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void addAdminAccount(String uname, String pass) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DatabaseConnector.getConnection();
            cstmt = con.prepareCall("{CALL insertAdminLogin(?, ?)}");
            cstmt.setString(1, uname);
            cstmt.setString(2, pass);

            cstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                cstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteAdminAcc(String id) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DatabaseConnector.getConnection();
            cstmt = con.prepareCall("{CALL remAdminAccount(?)}");
            cstmt.setString(1, id);
            cstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                cstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static void loadTeacherAccountId(JComboBox comTeacheAccId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
