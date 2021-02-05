/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Guilherme Freire
 */
public class LivroBean {
    public  String titulo;
    public String origem; 
    public String data_aq;  
    public String autor  ;
    public long cod_tomb ;
    public String editora;
    public boolean status;
    
     public LivroBean(){
         this.status= true;
     }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getData_aq() {
        return data_aq;
    }

    public void setData_aq(String data_aq) {
        this.data_aq = data_aq;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public long getCod_tomb() {
        return cod_tomb;
    }

    public void setCod_tomb(long cod_tomb) {
        this.cod_tomb = cod_tomb;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public String sexRe(){
            String chec;
        if(true != this.isStatus()){
            chec = "Indiponivel";
        }else{
            chec = "Disponivel";
        }
        return chec;
    } 
}
