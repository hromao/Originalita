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
public class Duplicata implements ImetodosPadrao {

    private int dup_id;
    private String dup_numero;
    private Date dtEmissao;
    private Date dtPagamento;
    private Date dtVcto;
    private double dup_valor;
    private int cli_id;
    private String cli_nome;
    private double dup_saldo;
    private int ped_id;
    private String cli_cod;
    private String cli_endereco;
    private String cli_comple;
    private String cli_numero;
    private String cli_cep;
    private String cli_bairro;
    private String cli_cidade;
    private String cli_uf;
    private String cli_cpf;

    public Duplicata() {
        this(0, "", new Date(), new Date(), new Date(), 0, 0, "", 0, 0, "", "", "", "", "", "", "", "", "");
    }

    public Duplicata(int dup_id, String dup_numero, Date dtEmissao, Date dtPagamento, Date dtVcto, double dup_valor,
            int cli_id, String cli_nome, double dup_saldo, int ped_id, String cli_cod, String cli_endereco,
            String cli_comple,
            String cli_numero,
            String cli_cep,
            String cli_bairro,
            String cli_cidade,
            String cli_uf,
            String cli_cpf) {
        this.dup_id = dup_id;
        this.dup_numero = dup_numero;
        this.dtEmissao = dtEmissao;
        this.dtPagamento = dtPagamento;
        this.dtVcto = dtVcto;
        this.dup_valor = dup_valor;
        this.cli_id = cli_id;
        this.cli_nome = cli_nome;
        this.dup_saldo = dup_saldo;
        this.ped_id = ped_id;
        this.cli_cod = cli_cod;
        this.cli_endereco = cli_endereco;
        this.cli_numero = cli_numero;
        this.cli_comple = cli_comple;
        this.cli_cep = cli_cep;
        this.cli_bairro = cli_bairro;
        this.cli_cidade = cli_cidade;
        this.cli_uf = cli_uf;
        this.cli_cpf = cli_cpf;
    }

    public int getDup_id() {
        return dup_id;
    }

    public void setDup_id(int dup_id) {
        this.dup_id = dup_id;
    }

    public String getDup_numero() {
        return dup_numero;
    }

    public void setDup_numero(String dup_numero) {
        this.dup_numero = dup_numero;
    }

    public Date getDtEmissao() {
        return dtEmissao;
    }

    public void setDtEmissao(Date dtEmissao) {
        this.dtEmissao = dtEmissao;
    }

    public Date getDtPagamento() {
        return dtPagamento;
    }

    public void setDtPagamento(Date dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    public Date getDtVcto() {
        return dtVcto;
    }

    public void setDtVcto(Date dtVcto) {
        this.dtVcto = dtVcto;
    }

    public double getDup_valor() {
        return dup_valor;
    }

    public void setDup_valor(double dup_valor) {
        this.dup_valor = dup_valor;
    }

    public int getCli_id() {
        return cli_id;
    }

    public String getCli_nome() {
        return cli_nome;
    }

    public void setCli_nome(String cli_nome) {
        this.cli_nome = cli_nome;
    }

    public void setCli_id(int cli_id) {
        this.cli_id = cli_id;
    }

    public double getDup_saldo() {
        return dup_saldo;
    }

    public void setDup_saldo(double dup_saldo) {
        this.dup_saldo = dup_saldo;
    }

    public int getPed_id() {
        return ped_id;
    }

    public void setPed_id(int ped_id) {
        this.ped_id = ped_id;
    }

    public String getCli_cod() {
        return cli_cod;
    }

    public void setCli_cod(String cli_cod) {
        this.cli_cod = cli_cod;
    }

    public String getCli_endereco() {
        return cli_endereco;
    }

    public void setCli_endereco(String cli_endereco) {
        this.cli_endereco = cli_endereco;
    }

    public String getCli_comple() {
        return cli_comple;
    }

    public void setCli_comple(String cli_comple) {
        this.cli_comple = cli_comple;
    }

    public String getCli_numero() {
        return cli_numero;
    }

    public void setCli_numero(String cli_numero) {
        this.cli_numero = cli_numero;
    }

    public String getCli_cep() {
        return cli_cep;
    }

    public void setCli_cep(String cli_cep) {
        this.cli_cep = cli_cep;
    }

    public String getCli_bairro() {
        return cli_bairro;
    }

    public void setCli_bairro(String cli_bairro) {
        this.cli_bairro = cli_bairro;
    }

    public String getCli_cidade() {
        return cli_cidade;
    }

    public void setCli_cidade(String cli_cidade) {
        this.cli_cidade = cli_cidade;
    }

    public String getCli_uf() {
        return cli_uf;
    }

    public void setCli_uf(String cli_uf) {
        this.cli_uf = cli_uf;
    }

    public String getCli_cpf() {
        return cli_cpf;
    }

    public void setCli_cpf(String cli_cpf) {
        this.cli_cpf = cli_cpf;
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
