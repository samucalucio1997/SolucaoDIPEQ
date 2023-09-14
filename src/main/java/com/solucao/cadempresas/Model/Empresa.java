package com.solucao.cadempresas.Model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class Empresa {
    
    private String CNPJ;
    private String RazaoSocial;
    private String Nome_Fantasia;
    private String AreaAtuacao;
    private int tempoAtu;
    private BigDecimal CapitalSocial;
    private int qtdFuncCLT;
    private int qtdFunc3;
    private int Estagirs;
    private int NSocio;
    private String Socios;
    private String WSite;
    private String Insta;
    private String Face;
    private String Twitter;
    private String Linkedin;  
    private String Whats;
    private String email;




    public String getCNPJ() {
        return CNPJ;
    }
    public void setCNPJ(String cNPJ) {
        CNPJ = cNPJ;
    }
    public String getRazaoSocial() {
        return RazaoSocial;
    }
    public void setRazaoSocial(String razaoSocial) {
        RazaoSocial = razaoSocial;
    }
    public String getNome_Fantasia() {
        return Nome_Fantasia;
    }
    public void setNome_Fantasia(String nome_Fantasia) {
        Nome_Fantasia = nome_Fantasia;
    }
    public String getAreaAtuacao() {
        return AreaAtuacao;
    }
    public void setAreaAtuacao(String areaAtuacao) {
        AreaAtuacao = areaAtuacao;
    }
    public int getTempoAtu() {
        return tempoAtu;
    }
    public void setTempoAtu(int tempoAtu) {
        this.tempoAtu = tempoAtu;
    }
    public BigDecimal getCapitalSocial() {
        return CapitalSocial;
    }
    public void setCapitalSocial(BigDecimal capitalSocial) {
        CapitalSocial = capitalSocial;
    }
    public int getQtdFuncCLT() {
        return qtdFuncCLT;
    }
    public void setQtdFuncCLT(int qtdFuncCLT) {
        this.qtdFuncCLT = qtdFuncCLT;
    }
    public int getQtdFunc3() {
        return qtdFunc3;
    }
    public void setQtdFunc3(int qtdFunc3) {
        this.qtdFunc3 = qtdFunc3;
    }
    public int getEstagirs() {
        return Estagirs;
    }
    public void setEstagirs(int estagirs) {
        Estagirs = estagirs;
    }
    public int getNSocio() {
        return NSocio;
    }
    public void setNSocio(int nSocio) {
        NSocio = nSocio;
    }
    public String getSocios() {
        return Socios;
    }
    public void setSocios(String socios) {
        Socios = socios;
    }
    public String getWSite() {
        return WSite;
    }
    public void setWSite(String wSite) {
        WSite = wSite;
    }
    public String getInsta() {
        return Insta;
    }
    public void setInsta(String insta) {
        Insta = insta;
    }
    public String getFace() {
        return Face;
    }
    public void setFace(String face) {
        Face = face;
    }
    public String getTwitter() {
        return Twitter;
    }
    public void setTwitter(String twitter) {
        Twitter = twitter;
    }
    public String getLinkedin() {
        return Linkedin;
    }
    public void setLinkedin(String linkedin) {
        Linkedin = linkedin;
    }
    public String getWhats() {
        return Whats;
    }
    public void setWhats(String whats) {
        Whats = whats;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    } 

}
