/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import DB.Conex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.BibiBean;

/**
 *
 * @author Guilherme Freire
 */
public class ProdutoDAO {
    public boolean checkcha(int chav){
         Connection conn = Conex.getConnection();;
         PreparedStatement st = null;
         ResultSet rs = null;
         boolean check = false;
        try{
             
            st = conn.prepareStatement("SELECT chave FROM bibliotecario WHERE chave = ?");
            st.setInt(1,chav);
            
            rs = st.executeQuery();
            
            if(rs.next()){
               check = true;  
            }
        }catch(SQLException e){
            e.printStackTrace();
        } finally{
            Conex.closeConnection();
        }
        return check;
    }
   public void mudaReg(String log, String sen,long id){
      Connection conn = Conex.getConnection();
      PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE bibliotecario SET login = ?,senha = ? WHERE matricula_bib = ?");
            st.setString(1, log);
            st.setString(2, sen);
            st.setLong(3, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conex.closeConnection();
        }
      
   }
   public void cadaBib(BibiBean p){
     Connection conn = Conex.getConnection();
      PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO bibliotecario"
             + "(nome_bib,matricula_bib,login,senha,telefone_bib,chave)"
             + " VALUES(?,?,?,?,?,'1979')");
            st.setString(1, p.getNome_bib());
            st.setLong(2,p.getMatr_bib());
            st.setString(3, p.getLogin());
            st.setString(4, p.getSenha());
            st.setString(5, p.getTel_bib());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conex.closeConnection();
        }
   }
    public boolean veriMatr(long cod) throws SQLException{
       Connection con = null;
       PreparedStatement st = null;
       ResultSet rs = null;
       boolean check = true;
       
       try{
           con = Conex.getConnection();
         st = con.prepareStatement("SELECT matricula_bib FROM bibliotecario WHERE matricula_bib = ?");
         st.setLong(1, cod);
           rs = st.executeQuery();
           if(rs.next()){
               check = false;
           }
       }catch(SQLException e){
           System.out.println("Não funciono:"+e);
       }finally{
           Conex.closeConnection();
       }
        return check;
   }
    public boolean veriBib(String lei){
       Connection con = Conex.getConnection();
       PreparedStatement st = null;
       ResultSet rs = null;
       boolean check = true;
       
       try{
         st = con.prepareStatement("SELECT login FROM bibliotecario WHERE login = ?");
         st.setString(1, lei);
            rs = st.executeQuery();
           if(rs.next()){
               check = false;
           }
       }catch(SQLException e){
           System.out.println("Não funciono:"+e);
       }finally{
           Conex.closeConnection();
       }
        return check;
   }
    
    public List<BibiBean> MostBib(){
      Connection conn = Conex.getConnection();
      PreparedStatement st = null;
      ResultSet rs = null;
      List<BibiBean> ben = new ArrayList<>();
      
        try {
            st = conn.prepareStatement("SELECT * FROM bibliotecario ORDER BY nome_bib");
            rs = st.executeQuery();
            while(rs.next()){
                BibiBean bib = new BibiBean();
                bib.setNome_bib(rs.getString("nome_bib"));
                bib.setMatr_bib(rs.getLong("matricula_bib"));
                bib.setLogin(rs.getString("login"));
                bib.setSenha(rs.getString("senha"));
                bib.setTel_bib(rs.getString("telefone_bib"));
                ben.add(bib);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conex.closeConnection();
        }
      return ben;
        
    }
}
