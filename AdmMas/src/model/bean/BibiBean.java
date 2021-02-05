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
public class BibiBean {
    private String nome_bib;
    private long matr_bib;
    private String login;
    private String senha;
    private String tel_bib;

    public String getNome_bib() {
        return nome_bib;
    }

    public void setNome_bib(String nome_bib) {
        this.nome_bib = nome_bib;
    }

    public long getMatr_bib() {
        return matr_bib;
    }

    public void setMatr_bib(long matr_bib) {
        this.matr_bib = matr_bib;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTel_bib() {
        return tel_bib;
    }

    public void setTel_bib(String tel_bib) {
        this.tel_bib = tel_bib;
    }

}
