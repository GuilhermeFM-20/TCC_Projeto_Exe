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
public class EmpreList {
    public String nome_lei;
    public String nome_ite;
    public long cod_tomb;
    public long matr_lei;
    public String data_dev;
    public String data_emp;
    public long matr_bib;
    public String nome_bib;

    public String getNome_lei() {
        return nome_lei;
    }

    public void setNome_lei(String nome_lei) {
        this.nome_lei = nome_lei;
    }

    public String getNome_ite() {
        return nome_ite;
    }

    public void setNome_ite(String nome_ite) {
        this.nome_ite = nome_ite;
    }

    public long getCod_tomb() {
        return cod_tomb;
    }

    public void setCod_tomb(long cod_tomb) {
        this.cod_tomb = cod_tomb;
    }

    public long getMatr_lei() {
        return matr_lei;
    }

    public void setMatr_lei(long matr_lei) {
        this.matr_lei = matr_lei;
    }

    public String getData_dev() {
        return data_dev;
    }

    public void setData_dev(String data_dev) {
        Date data = new Date();
       SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
       String hoje = forma.format(data);
        this.data_dev = data_dev;
       if(!data_dev.equals(hoje)){
           this.data_dev = data_dev;
       }else{
            this.data_dev = "Esperando devolução";
       }
    }

    public String getData_emp() {
        return data_emp;
    }

    public void setData_emp(String data_emp) {
        this.data_emp = data_emp;
    }

    public long getMatr_bib() {
        return matr_bib;
    }

    public void setMatr_bib(long matr_bib) {
        this.matr_bib = matr_bib;
    }

    public String getNome_bib() {
        return nome_bib;
    }

    public void setNome_bib(String nome_bib) {
        this.nome_bib = nome_bib;
    }
    
}
