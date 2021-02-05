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
public class EpreBean {
    public String data_emp;
    public String data_dev;
    public long cod_tomb;
    public long matri_lei;
    public long matri_bib;
    public String getData_emp() {
        return data_emp;
    }

    public void setData_emp(String data_emp) {
        this.data_emp = data_emp;
    }

    public String getData_dev() {
        return data_dev;
    }

    public void setData_dev(String data_dev) {
        this.data_dev = data_dev;
    }

    public long getCod_tomb() {
        return cod_tomb;
    }

    public void setCod_tomb(long cod_tomb) {
        this.cod_tomb = cod_tomb;
    }
    public long getMatri_lei() {
        return matri_lei;
    }

    public void setMatri_lei(long matri_lei) {
        this.matri_lei = matri_lei;
    }

    public long getMatri_bib() {
        return matri_bib;
    }

    public void setMatri_bib(long matri_bib) {
        this.matri_bib = matri_bib;
    }
    
}
