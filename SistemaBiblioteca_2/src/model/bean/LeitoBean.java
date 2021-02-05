/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Guilherme Freire
 */
public class LeitoBean {
    public String nome_lei;
    public long matri_lei;
    public String email_lei;
    public String sexo_lei;
    public boolean staus_lei;
    public String turma;
    public String tele_lei;

    public LeitoBean() {
        this.nome_lei = getNome_lei();
        this.matri_lei = getMatri_lei();
        this.email_lei = getEmail_lei();
        this.sexo_lei = getSexo_lei();
        this.staus_lei = true;
        this.turma = getTurma();
        this.tele_lei = getTele_lei();
    }

    
    public String getNome_lei() {
        return nome_lei;
    }

    public void setNome_lei(String nome_lei) {
        this.nome_lei = nome_lei;
    }

    public long getMatri_lei() {
        return matri_lei;
    }

    public void setMatri_lei(long matri_lei) {
        this.matri_lei = matri_lei;
    }

    public String getEmail_lei() {
        return email_lei;
    }

    public void setEmail_lei(String email_lei) {
        this.email_lei = email_lei;
    }

    public String getSexo_lei() {
        return sexo_lei;
    }

    public void setSexo_lei(boolean sexo_lei) {
        if(sexo_lei == true){
        this.sexo_lei = "Feminino";
        }else{
         this.sexo_lei = "Masculino";
        }
    }

    public boolean isStaus_lei() {
        return staus_lei;
    }

    public void setStaus_lei(boolean staus_lei){
        this.staus_lei = staus_lei;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getTele_lei() {
        return tele_lei;
    }

    public void setTele_lei(String tele_lei) {
        this.tele_lei = tele_lei;
    }
     public String sexRe(){
            String chec;
        if(true != this.isStaus_lei()){
            chec = "Indiponivel";
        }else{
            chec = "Disponivel";
        }
        return chec;
    }
}
