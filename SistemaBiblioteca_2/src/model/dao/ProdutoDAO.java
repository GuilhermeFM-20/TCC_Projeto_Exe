/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;
import JFramebib.JFrame;
import db.DB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.EmpreList;
import model.bean.EpreBean;
import model.bean.LeitoBean;
import model.bean.LivroBean;
import model.bean.NewClass;
/**
 *
 * @author Guilherme Freire
 */
public class ProdutoDAO {
    public boolean checkUsu(String usua,String senha){
         Connection conn = null;
         PreparedStatement st = null;
         ResultSet rs = null;
         boolean check = false;
        try{
            conn = DB.getConnection();
            st = conn.prepareStatement("SELECT login,senha FROM bibliotecario WHERE login = ? and senha = ?");
            st.setString(1,usua);
            st.setString(2,senha);
            
            rs = st.executeQuery();
            
            if(rs.next()){
               check = true;  
            }
        }catch(SQLException e){
            e.printStackTrace();
        } finally{
            DB.closeConnection();
        }
        return check;
    }
    public boolean checkCha(int chav){
        Connection conn = null;
         PreparedStatement st = null;
         ResultSet rs = null;
         boolean check = false;
        try{
            conn = DB.getConnection();
            st = conn.prepareStatement("SELECT chave FROM bibliotecario WHERE chave = ?");
            st.setLong(1,chav);
            
            rs = st.executeQuery();
            
            if(rs.next()){
               check = true;  
            }
        }catch(SQLException e){
            e.printStackTrace();
        } finally{
            DB.closeConnection();
        }
        return check;
    }
    public void cadasLei(LeitoBean p){
         Connection conn = null;
         PreparedStatement st = null;
         ResultSet rs = null;
         boolean check = false;
        try{
            conn = DB.getConnection();
            st = conn.prepareStatement("INSERT INTO leitor(nome_leitor,matricula_leitor,"
            + "email_leitor,sexo,satus,turma,telefone_leitor) VALUES(?,?,?,?,?,?,?)");
            st.setString(1, p.getNome_lei());
            st.setLong(2, p.getMatri_lei());
            st.setString(3, p.getEmail_lei());
            st.setString(4, p.getSexo_lei());
            st.setBoolean(5, p.isStaus_lei());
            st.setString(6, p.getTurma());
            st.setString(7, p.getTele_lei());
            st.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Talvez tenha algum erro no cadastro"
             + "️, faça novamente","Erro ✅",JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Não funciono:"+e);
        }finally{
            DB.closeConnection();
        }
    }
   public void cadaLiv(LivroBean p){
        Connection conn = null;
         PreparedStatement st = null;
         ResultSet rs = null;
        try{
            conn = DB.getConnection();
            st = conn.prepareStatement("INSERT INTO item(titulo,origem,data_aq,"
            + "autor,cod_tomb,editora,satus) VALUES(?,?,?,?,?,?,?)");
            st.setString(1, p.getTitulo());
            st.setString(2,p.getOrigem());
            st.setString(3,p.getData_aq());
            st.setString(4, p.getAutor());
            st.setLong(5, p.getCod_tomb());
            st.setString(6, p.getEditora());
            st.setBoolean(7, p.isStatus());
            st.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Talvez tenha algum erro no cadastro️, faça novamente"
             ,"Erro ✅",JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Não funciono:"+e);
        }finally{
            DB.closeConnection();
        }
   }
   public boolean veriMatr(long cod) throws SQLException{
       Connection con = null;
       PreparedStatement st = null;
       ResultSet rs = null;
       boolean check = true;
       
       try{
           con = DB.getConnection();
         st = con.prepareStatement("SELECT matricula_leitor FROM leitor WHERE matricula_leitor = ?");
         st.setLong(1, cod);
           rs = st.executeQuery();
           if(rs.next()){
               check = false;
           }
       }catch(SQLException e){
           System.out.println("Não funciono:"+e);
       }finally{
           DB.closeConnection();
       }
        return check;
   }
   public boolean veriCod(long cod){
       Connection con = null;
       PreparedStatement st = null;
       ResultSet rs = null;
       boolean check = true;
       
       try{
         con = DB.getConnection();
         st = con.prepareStatement("SELECT cod_tomb FROM item WHERE cod_tomb = ?");
         st.setLong(1, cod);
           rs = st.executeQuery();
           if(rs.next()){
               check = false;
           }
       }catch(SQLException e){
           System.out.println("Não funciono:"+e);
       }finally{
           DB.closeConnection();
       }
        return check;
   }
  public boolean veriLei(String lei){
       Connection con = null;
       PreparedStatement st = null;
       ResultSet rs = null;
       boolean check = true;
       
       try{
           con = DB.getConnection();
         st = con.prepareStatement("SELECT nome_leitor FROM leitor WHERE nome_leitor = ?");
         st.setString(1, lei);
         rs = st.executeQuery();
           if(rs.next()){
               check = false;
           }
       }catch(SQLException e){
           System.out.println("Não funciono:"+e);
       }finally{
           DB.closeConnection();
       }
        return check;
   }
    public boolean veriLiv(String lei){
       Connection con = null;
       PreparedStatement st = null;
       ResultSet rs = null;
       boolean check = true;
       
       try{
           con = DB.getConnection();
         st = con.prepareStatement("SELECT titulo FROM item WHERE titulo = ?");
         st.setString(1, lei);
         rs = st.executeQuery();
           if(rs.next()){
               check = false;
           }
       }catch(SQLException e){
           System.out.println("Não funciono:"+e);
       }finally{
           DB.closeConnection();
       }
        return check;
   }
   public void exluLei(long cod,String nom){
       Connection con = null;
       PreparedStatement st = null;
       ResultSet rs = null;
       try{
           con = DB.getConnection();
           st = con.prepareStatement("DELETE FROM leitor WHERE matricula_leitor = ? and nome_leitor = ?");
           st.setLong(1, cod);
           st.setString(2, nom);
           st.executeUpdate();
       }catch(SQLException e){
           System.out.println("Não funciono:"+e);
       }finally{
           DB.closeConnection();
       }
   }
   public void exluLiv(long cod,String nom){
       Connection con = null;
       PreparedStatement st = null;
       ResultSet rs = null;
       try{
           con = DB.getConnection();
           st = con.prepareStatement("DELETE FROM item WHERE cod_tomb = ? and titulo = ?");
           st.setLong(1, cod);
           st.setString(2, nom);
           st.executeUpdate();
       }catch(SQLException e){
           System.out.println("Não funciono:"+e);
       }finally{
           DB.closeConnection();
       }
   }
   public List<LeitoBean> pesqLei(long id){
       Connection con = DB.getConnection();
       PreparedStatement st= null;
       ResultSet rs= null;
      
       List<LeitoBean> prod = new ArrayList<>();
       
       try{
           st = con.prepareStatement("SELECT * FROM leitor WHERE matricula_leitor LIKE ? ");
           st.setLong(1,id);
           rs = st.executeQuery();
           
           if(rs.next()){
                LeitoBean pro = new LeitoBean();
               pro.setNome_lei(rs.getString("nome_leitor"));
               pro.setMatri_lei(rs.getLong("matricula_leitor"));
               pro.setEmail_lei(rs.getString("email_leitor"));
               pro.setSexo_lei(rs.getBoolean("sexo"));
               pro.setStaus_lei(rs.getBoolean("satus"));
               pro.setTurma(rs.getString("turma"));
               pro.setTele_lei(rs.getString("telefone_leitor"));  
               prod.add(pro);
           }else{
               return null;
           } 
       }catch(SQLException e){
          System.out.println("Não funciono:"+e);
       }finally{
           DB.closeConnection();
       }
        return prod;
   }
   public List<LivroBean> pesqLiv(long id){
       Connection con = DB.getConnection();
       PreparedStatement st= null;
       ResultSet rs= null;
      
       List<LivroBean> prod = new ArrayList<>();
       
       try{
           st = con.prepareStatement("SELECT * FROM item WHERE cod_tomb LIKE ? ");
           st.setLong(1,id);
           rs = st.executeQuery();
           
           if(rs.next()){
                LivroBean pro = new LivroBean();
               pro.setTitulo(rs.getString("titulo"));
               pro.setCod_tomb(rs.getLong("cod_tomb"));
               pro.setOrigem(rs.getString("origem"));
               pro.setData_aq(rs.getString("data_aq"));
               pro.setAutor(rs.getString("autor"));
               pro.setEditora(rs.getString("editora"));
               pro.setStatus(rs.getBoolean("satus"));  
               prod.add(pro);
           }else{
               return null;
           } 
       }catch(SQLException e){
          System.out.println("Não funciono:"+e);
       }finally{
           DB.closeConnection();
       }
        return prod;
   }
   public List<LivroBean> pesqLivmo(){
       Connection con = DB.getConnection();
       PreparedStatement st= null;
       ResultSet rs= null;
      
       List<LivroBean> prod = new ArrayList<>();
       
       try{
           st = con.prepareStatement("SELECT * FROM item ORDER BY titulo");
           rs = st.executeQuery();
           
           while(rs.next()){
                LivroBean pro = new LivroBean();
               pro.setTitulo(rs.getString("titulo"));
               pro.setCod_tomb(rs.getLong("cod_tomb"));
               pro.setOrigem(rs.getString("origem"));
               pro.setData_aq(rs.getString("data_aq"));
               pro.setAutor(rs.getString("autor"));
               pro.setEditora(rs.getString("editora"));
               pro.setStatus(rs.getBoolean("satus"));  
               prod.add(pro);
           }
       }catch(SQLException e){
          System.out.println("Não funciono:"+e);
       }finally{
           DB.closeConnection();
       }
        return prod;
   }
    public List<LeitoBean> pesqLeimo(){
       Connection con = DB.getConnection();
       PreparedStatement st= null;
       ResultSet rs= null;
      
       List<LeitoBean> prod = new ArrayList<>();
       
       try{
           st = con.prepareStatement("SELECT * FROM leitor ORDER BY nome_leitor ");
           rs = st.executeQuery();
           
           while(rs.next()){
                LeitoBean pro = new LeitoBean();
               pro.setNome_lei(rs.getString("nome_leitor"));
               pro.setMatri_lei(rs.getLong("matricula_leitor"));
               pro.setEmail_lei(rs.getString("email_leitor"));
               pro.setSexo_lei(rs.getBoolean("sexo"));
               pro.setStaus_lei(rs.getBoolean("satus"));
               pro.setTurma(rs.getString("turma"));
               pro.setTele_lei(rs.getString("telefone_leitor"));  
               prod.add(pro);
           }
       }catch(SQLException e){
          System.out.println("Não funciono:"+e);
       }finally{
           DB.closeConnection();
       }
        return prod;
   }
    public void empresItem(EpreBean p){
         Connection conn = null;
         PreparedStatement st = null;
        try{
            conn = DB.getConnection();
            st = conn.prepareStatement("INSERT INTO emprestimos (id_emp,dat_emp,dat_dev,"
             + "cod_tomb,matricula_bib,matricula_leitor) VALUES(DEFAULT,?,?,?,?,?)");
            st.setString(1, p.getData_emp());
            st.setString(2, p.getData_dev());
            st.setLong(3, p.getCod_tomb());
            st.setLong(4, p.getMatri_bib());
            st.setLong(5, p.getMatri_lei());
            st.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Talvez tenha algum erro no empréstimo,"
             + " faça novamente","Erro ✅",JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Não funciono:"+e);
        }finally{
            DB.closeConnection();
        }
    }
    public void empre(long id1,long id2){
        Connection conn = null;
         PreparedStatement st = null;
        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("update item,leitor SET item.satus = 0, leitor.satus = 0 where cod_tomb = ? and matricula_leitor = ?");
            st.setLong(1, id1);
            st.setLong(2, id2);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            DB.closeConnection();
        }
    }
    public void devit(long cod,long cod1){
       Connection con = null;
       PreparedStatement st = null;
       ResultSet rs = null;
       try{
           con = DB.getConnection();
           st = con.prepareStatement("DELETE FROM emprestimos WHERE cod_tomb = ? and matricula_leitor = ?");
           st.setLong(1, cod);
           st.setLong(2, cod1);
           st.executeUpdate();
       }catch(SQLException e){
           System.out.println("Não funciono:"+e);
       }finally{
           DB.closeConnection();
       }
   }
    public void dev(long id1,long id2){
        Connection conn = null;
         PreparedStatement st = null;
        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("update item,leitor SET item.satus = 1, leitor.satus = 1 where cod_tomb = ? and matricula_leitor = ?");
            st.setLong(1, id1);
            st.setLong(2, id2);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            DB.closeConnection();
        }
}
   
     public int veriSta(long cod){
       Connection con = null;
       PreparedStatement st = null;
       ResultSet rs = null;
       int check = 1;
       
       try{
           con = DB.getConnection();
            st = con.prepareStatement("select satus from leitor where matricula_leitor = ?");
            st.setLong(1, cod);
            rs = st.executeQuery();
           while(rs.next()){
              int num = Integer.parseInt(rs.getString("satus"));
               check = num;              
           }
                   
       }catch(SQLException e){
           System.out.println("Não funciono:"+e);
       }finally{
           DB.closeConnection();
       }
        return check;
   }
     public int veriSta2(long cod){
       Connection con = null;
       PreparedStatement st = null;
       ResultSet rs = null;
       int check = 1;
       
       try{
           con = DB.getConnection();
            st = con.prepareStatement("select satus from item where cod_tomb = ?");
            st.setLong(1, cod);
            rs = st.executeQuery();
           while(rs.next()){
              int num = Integer.parseInt(rs.getString("satus"));
               check = num;              
           }
                   
       }catch(SQLException e){
           System.out.println("Não funciono:"+e);
       }finally{
           DB.closeConnection();
       }
        return check;
   }
      public List<EmpreList> MostEmp(){
       Connection con = DB.getConnection();
       PreparedStatement st= null;
       ResultSet rs= null;
      
       List<EmpreList> prod = new ArrayList<>();
       
       try{
           st = con.prepareStatement("select leitor.nome_leitor,item.titulo,leitor.matricula_leitor,item.cod_tomb,emprestimos.dat_emp,emprestimos.dat_dev, bibliotecario.nome_bib, bibliotecario.matricula_bib from bibliotecario join leitor join item join emprestimos on leitor.matricula_leitor = emprestimos.matricula_leitor and item.cod_tomb = emprestimos.cod_tomb and bibliotecario.matricula_bib = emprestimos.matricula_bib ORDER BY nome_leitor");
           rs = st.executeQuery();
           
           while(rs.next()){
                EmpreList pro = new EmpreList();
               pro.setNome_lei(rs.getString("nome_leitor"));
               pro.setNome_ite(rs.getString("titulo"));
               pro.setMatr_lei(rs.getLong("matricula_leitor"));
               pro.setCod_tomb(rs.getLong("cod_tomb"));
               pro.setData_emp(rs.getString("dat_emp"));
               pro.setData_dev(rs.getString("dat_dev"));
               pro.setNome_bib(rs.getString("nome_bib"));
               pro.setMatr_bib(rs.getLong("matricula_bib"));
               prod.add(pro);
           }
       }catch(SQLException e){
          System.out.println("Não funciono:"+e);
       }finally{
           DB.closeConnection();
       }
        return prod;
   }
      public void renoDa(String dat,long cod,long matr){
          Connection con = null;
       PreparedStatement st = null;
       ResultSet rs = null;
       int check = 1;
       
       try{
           con = DB.getConnection();
            st = con.prepareStatement("UPDATE emprestimos SET dat_dev = ? WHERE matricula_leitor = ? and cod_tomb = ?");
            st.setString(1, dat);
            st.setLong(2, matr);
            st.setLong(3, cod);
            st.executeUpdate();       
       }catch(SQLException e){
           System.out.println("Não funciono:"+e);
       }finally{
           DB.closeConnection();
       }
  
      }
       public boolean veriMatrbib(long cod) throws SQLException{
       Connection con = null;
       PreparedStatement st = null;
       ResultSet rs = null;
       boolean check = true;

       try{
           con = DB.getConnection();
         st = con.prepareStatement("SELECT matricula_bib FROM bibliotecario WHERE matricula_bib = ?");
         st.setLong(1, cod);
           rs = st.executeQuery();
           if(rs.next()){
               check = false;
           }
       }catch(SQLException e){
           System.out.println("Não funciono:"+e);
       }finally{
           DB.closeConnection();
       }
        return check;
   }
   public void PegMa(String usu){
       Connection con = DB.getConnection();
       PreparedStatement st = null;
       ResultSet rs = null;
       long resu;
        try {
            st = con.prepareStatement("SELECT matricula_bib FROM bibliotecario WHERE login = ?");
            st.setString(1, usu);
            rs = st.executeQuery();
            while(rs.next()){
                NewClass pro = new NewClass();
                pro.setMatr_bib(rs.getLong("matricula_bib"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
}