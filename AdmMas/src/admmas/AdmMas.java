/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admmas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import model.dao.ProdutoDAO;
/**
 *
 * @author Guilherme Freire
 */
public class AdmMas {

    public static void main(String[] args) { 
        ProdutoDAO props = new ProdutoDAO();
        //Exibir a janela para o usuario
            Object[] opt ={"Recadastro do login do bibliotecário","Cadastrar novo bibliotecário","Mostrar todos os bibliotecário"};
            String s= String.valueOf(JOptionPane.showInputDialog(null,"Escolha a opção:","Escolha",JOptionPane.INFORMATION_MESSAGE,null,opt,opt[2]));
            if(s == opt[1]){
                 new BibCa().setVisible(true);    
              }else if(s == opt[2]){
                   new ViusaBi().setVisible(true);
             }else if (s == opt[0]){
                 new RecBib().setVisible(true);
             }else{
             }  
    }
    
}
