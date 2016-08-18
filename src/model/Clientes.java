/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.sql.SQLException;

/**
 *
 * @author Henrique
 */
public class Clientes implements ImetodosPadrao{
    
    private int id_cli;
    private String cod_cli;
    private String nome_cli;
    private String endereco_cli;
    private String numero_cli;
    private String comple_cli;
    private String rua_cli;
    private String bairro_cli;
    private String cidade_cli;
    private String uf_cli;
    private String cep_cli;
    private String cpf_cli;
    private String cnpj_cli;
    private String email_cli;
    private String telefone_cli;
    private String contato_cli;
    private String ativo_cli;
    private Date dataCadastro_cli;
    
    public Clientes(){
        this(0, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Date());
    }

    public Clientes(int id_cli, String cod_cli, String nome_cli, String endereco_cli, String numero_cli, String comple_cli, String rua_cli, String bairro_cli, String cidade_cli, String uf_cli, String cep_cli, String cpf_cli, String cnpj_cli, String email_cli, String telefone_cli, String contato_cli, String ativo_cli, Date dataCadastro_cli) {
        this.id_cli = id_cli;
        this.cod_cli = cod_cli;
        this.nome_cli = nome_cli;
        this.endereco_cli = endereco_cli;
        this.numero_cli = numero_cli;
        this.comple_cli = comple_cli;
        this.rua_cli = rua_cli;
        this.bairro_cli = bairro_cli;
        this.cidade_cli = cidade_cli;
        this.uf_cli = uf_cli;
        this.cep_cli = cep_cli;
        this.cpf_cli = cpf_cli;
        this.cnpj_cli = cnpj_cli;
        this.email_cli = email_cli;
        this.telefone_cli = telefone_cli;
        this.contato_cli = contato_cli;
        this.ativo_cli = ativo_cli;
        this.dataCadastro_cli = dataCadastro_cli;
    }

    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }

    public String getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(String cod_cli) {
        this.cod_cli = cod_cli;
    }

    public String getNome_cli() {
        return nome_cli;
    }

    public void setNome_cli(String nome_cli) {
        this.nome_cli = nome_cli;
    }

    public String getEndereco_cli() {
        return endereco_cli;
    }

    public void setEndereco_cli(String endereco_cli) {
        this.endereco_cli = endereco_cli;
    }

    public String getNumero_cli() {
        return numero_cli;
    }

    public void setNumero_cli(String numero_cli) {
        this.numero_cli = numero_cli;
    }

    public String getComple_cli() {
        return comple_cli;
    }

    public void setComple_cli(String comple_cli) {
        this.comple_cli = comple_cli;
    }

    public String getRua_cli() {
        return rua_cli;
    }

    public void setRua_cli(String rua_cli) {
        this.rua_cli = rua_cli;
    }

    public String getBairro_cli() {
        return bairro_cli;
    }

    public void setBairro_cli(String bairro_cli) {
        this.bairro_cli = bairro_cli;
    }

    public String getCidade_cli() {
        return cidade_cli;
    }

    public void setCidade_cli(String cidade_cli) {
        this.cidade_cli = cidade_cli;
    }

    public String getUf_cli() {
        return uf_cli;
    }

    public void setUf_cli(String uf_cli) {
        this.uf_cli = uf_cli;
    }

    public String getCep_cli() {
        return cep_cli;
    }

    public void setCep_cli(String cep_cli) {
        this.cep_cli = cep_cli;
    }

    public String getCpf_cli() {
        return cpf_cli;
    }

    public void setCpf_cli(String cpf_cli) {
        this.cpf_cli = cpf_cli;
    }

    public String getCnpj_cli() {
        return cnpj_cli;
    }

    public void setCnpj_cli(String cnpj_cli) {
        this.cnpj_cli = cnpj_cli;
    }

    public String getEmail_cli() {
        return email_cli;
    }

    public void setEmail_cli(String email_cli) {
        this.email_cli = email_cli;
    }

    public String getTelefone_cli() {
        return telefone_cli;
    }

    public void setTelefone_cli(String telefone_cli) {
        this.telefone_cli = telefone_cli;
    }

    public String getContato_cli() {
        return contato_cli;
    }

    public void setContato_cli(String contato_cli) {
        this.contato_cli = contato_cli;
    }

    public String getAtivo_cli() {
        return ativo_cli;
    }

    public void setAtivo_cli(String ativo_cli) {
        this.ativo_cli = ativo_cli;
    }

    public Date getDataCadastro_cli() {
        return dataCadastro_cli;
    }

    public void setDataCadastro_cli(Date dataCadastro_cli) {
        this.dataCadastro_cli = dataCadastro_cli;
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
