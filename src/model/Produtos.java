/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Henrique
 */
public class Produtos implements ImetodosPadrao{
    
    private int pro_id;
    private String pro_cod;
    private String pro_nome;
    private double pro_preco;
    private double pro_pesoLiq;
    private double pro_pesoBruto;
    private double pro_sdAtual;
    private String pro_ativo;
    private Date pro_dataCadastro;
    private String pro_infoComple;
    
    public Produtos(){
        this(0, "", "", 0, 0, 0, 0, "", new Date(), "");
    }

    public Produtos(int pro_id, String pro_cod, String pro_nome, double pro_preco, double pro_pesoLiq, double pro_pesoBruto, double pro_sdAtual, String pro_ativo, Date pro_dataCadastro, String pro_infoComple) {
        this.pro_id = pro_id;
        this.pro_cod = pro_cod;
        this.pro_nome = pro_nome;
        this.pro_preco = pro_preco;
        this.pro_pesoLiq = pro_pesoLiq;
        this.pro_pesoBruto = pro_pesoBruto;
        this.pro_sdAtual = pro_sdAtual;
        this.pro_ativo = pro_ativo;
        this.pro_dataCadastro = pro_dataCadastro;
        this.pro_infoComple = pro_infoComple;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_cod() {
        return pro_cod;
    }

    public void setPro_cod(String pro_cod) {
        this.pro_cod = pro_cod;
    }

    public String getPro_nome() {
        return pro_nome;
    }

    public void setPro_nome(String pro_nome) {
        this.pro_nome = pro_nome;
    }

    public double getPro_preco() {
        return pro_preco;
    }

    public void setPro_preco(double pro_preco) {
        this.pro_preco = pro_preco;
    }

    public double getPro_pesoLiq() {
        return pro_pesoLiq;
    }

    public void setPro_pesoLiq(double pro_pesoLiq) {
        this.pro_pesoLiq = pro_pesoLiq;
    }

    public double getPro_pesoBruto() {
        return pro_pesoBruto;
    }

    public void setPro_pesoBruto(double pro_pesoBruto) {
        this.pro_pesoBruto = pro_pesoBruto;
    }

    public double getPro_sdAtual() {
        return pro_sdAtual;
    }

    public void setPro_sdAtual(double pro_sdAtual) {
        this.pro_sdAtual = pro_sdAtual;
    }

    public String getPro_ativo() {
        return pro_ativo;
    }

    public void setPro_ativo(String pro_ativo) {
        this.pro_ativo = pro_ativo;
    }

    public Date getPro_dataCadastro() {
        return pro_dataCadastro;
    }

    public void setPro_dataCadastro(Date pro_dataCadastro) {
        this.pro_dataCadastro = pro_dataCadastro;
    }

    public String getPro_infoComple() {
        return pro_infoComple;
    }

    public void setPro_infoComple(String pro_infoComple) {
        this.pro_infoComple = pro_infoComple;
    }

  
    
    @Override
    public void incluir() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int pegaUltimaID() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluirUltimoId(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
