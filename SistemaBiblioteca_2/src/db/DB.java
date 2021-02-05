/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/*import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;*/
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql. DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Guilherme Freire
 */
public class DB {
    private static final Connection conn = null;// Criando uma variavel para a conexão 

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bibliotecasbac","root","Post_123");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Não foi possível se conectar com o banco!\nTente verificar a conexão "
                    + "ou se os serviços do MySQL estão iniciados na maquina que está como servidor ","Aviso", WIDTH);
        }
        return conn;
    } 
    // Fechando a conexão com o banco mysql
    public static void closeConnection(){
        if(conn != null){
            try{
            conn.close();
            }catch(SQLException e){
                System.out.println("erro: "+e);
            }
        }
    }
}
