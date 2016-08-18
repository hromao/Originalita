/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;

/**
 *
 * @author Henrique
 */
public class Configuracoes implements ImetodosPadrao {
    
    private int emp_id;
    private String emp_razao;
    private String emp_nome;
    private String emp_endereco;
    private String emp_num;
    private String emp_bairro;
    private String emp_cidade;
    private String emp_uf;
    private String emp_cnpj;
    private String emp_agencia;
    private String emp_digAgencia;
    private String emp_conta;
    private String emp_digConta;
    private Double emp_mora;
    private String emp_mensagem;
    private String emp_cep;
    
    public Configuracoes(){
        this(0, "", "", "", "", "", "", "", "", "", "", "", "", 0.0, "","");
    }

    public Configuracoes(int emp_id, String emp_razao, String emp_nome, String emp_endereco, String emp_num, String emp_bairro, String emp_cidade, String emp_uf, String emp_cnpj, String emp_agencia, String emp_digAgencia, String emp_conta, String emp_digConta, Double emp_mora, String emp_mensagem, String emp_cep) {
        this.emp_id = emp_id;
        this.emp_razao = emp_razao;
        this.emp_nome = emp_nome;
        this.emp_endereco = emp_endereco;
        this.emp_num = emp_num;
        this.emp_bairro = emp_bairro;
        this.emp_cidade = emp_cidade;
        this.emp_uf = emp_uf;
        this.emp_cnpj = emp_cnpj;
        this.emp_agencia = emp_agencia;
        this.emp_digAgencia = emp_digAgencia;
        this.emp_conta = emp_conta;
        this.emp_digConta = emp_digConta;
        this.emp_mora = emp_mora;
        this.emp_mensagem = emp_mensagem;
        this.emp_cep = emp_cep;
    }

    public String getEmp_cep() {
        return emp_cep;
    }

    public void setEmp_cep(String emp_cep) {
        this.emp_cep = emp_cep;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_razao() {
        return emp_razao;
    }

    public void setEmp_razao(String emp_razao) {
        this.emp_razao = emp_razao;
    }

    public String getEmp_nome() {
        return emp_nome;
    }

    public void setEmp_nome(String emp_nome) {
        this.emp_nome = emp_nome;
    }

    public String getEmp_endereco() {
        return emp_endereco;
    }

    public void setEmp_endereco(String emp_endereco) {
        this.emp_endereco = emp_endereco;
    }

    public String getEmp_num() {
        return emp_num;
    }

    public void setEmp_num(String emp_num) {
        this.emp_num = emp_num;
    }

    public String getEmp_bairro() {
        return emp_bairro;
    }

    public void setEmp_bairro(String emp_bairro) {
        this.emp_bairro = emp_bairro;
    }

    public String getEmp_cidade() {
        return emp_cidade;
    }

    public void setEmp_cidade(String emp_cidade) {
        this.emp_cidade = emp_cidade;
    }

    public String getEmp_uf() {
        return emp_uf;
    }

    public void setEmp_uf(String emp_uf) {
        this.emp_uf = emp_uf;
    }

    public String getEmp_cnpj() {
        return emp_cnpj;
    }

    public void setEmp_cnpj(String emp_cnpj) {
        this.emp_cnpj = emp_cnpj;
    }

    public String getEmp_agencia() {
        return emp_agencia;
    }

    public void setEmp_agencia(String emp_agencia) {
        this.emp_agencia = emp_agencia;
    }

    public String getEmp_digAgencia() {
        return emp_digAgencia;
    }

    public void setEmp_digAgencia(String emp_digAgencia) {
        this.emp_digAgencia = emp_digAgencia;
    }

    public String getEmp_conta() {
        return emp_conta;
    }

    public void setEmp_conta(String emp_conta) {
        this.emp_conta = emp_conta;
    }

    public String getEmp_digConta() {
        return emp_digConta;
    }

    public void setEmp_digConta(String emp_digConta) {
        this.emp_digConta = emp_digConta;
    }

    public Double getEmp_mora() {
        return emp_mora;
    }

    public void setEmp_mora(Double emp_mora) {
        this.emp_mora = emp_mora;
    }

    public String getEmp_mensagem() {
        return emp_mensagem;
    }

    public void setEmp_mensagem(String emp_mensagem) {
        this.emp_mensagem = emp_mensagem;
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
