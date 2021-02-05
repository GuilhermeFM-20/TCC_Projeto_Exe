/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Guilherme Freire
 */
public class Conex {
    private static final Connection conn = null;
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conex.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotecasbac","root","Post_123");
        } catch (SQLException ex) {
            Logger.getLogger(Conex.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    public static void closeConnection(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conex.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
}
