package model;

import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Henrique
 */
public class PedidosOrc implements ImetodosPadrao {

    private int ped_id;
    private int ped_num;
    private Date dt_venda;
    private Date dt_Entrega;
    private int cli_id;
    private String cli_nome;
    private double ped_total;
    private String ped_obs;
    private int stp_codigo;
    private String stp_nome;
    private String cli_endereco;
    private String cli_numero;
    private String cli_comple;
    private String cli_bairro;
    private String cli_cidade;
    private String cli_uf;
    private String cli_cep;
    private String ped_tipo;
    private String ped_orcNome;
    private String ped_orcFone;
    private String ped_orcEmail;
    private String ped_orcContato;

    public PedidosOrc() {
        this(0, 0, new Date(), new Date(), 0, "", 0, "", 0, "", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    public PedidosOrc(int ped_id, int ped_num, Date dt_venda, Date dt_Entrega, int cli_id,
            String cli_nome, double ped_total, String ped_obs, int stp_codigo, String stp_nome,
            String cli_endereco, String cli_numero, String cli_comple, String cli_bairro, String cli_cidade, 
            String cli_uf, String cli_cep, String ped_tipo, String ped_orcNome, String ped_orcFone,String ped_orcEmail,String ped_orcContato) {
        this.ped_id = ped_id;
        this.ped_num = ped_num;
        this.dt_venda = dt_venda;
        this.dt_Entrega = dt_Entrega;
        this.cli_id = cli_id;
        this.cli_nome = cli_nome;
        this.ped_total = ped_total;
        this.ped_obs = ped_obs;
        this.stp_codigo = stp_codigo;
        this.stp_nome = stp_nome;
        this.cli_endereco = cli_endereco;
        this.cli_numero = cli_numero;
        this.cli_comple = cli_comple;
        this.cli_bairro = cli_bairro;
        this.cli_cidade = cli_cidade;
        this.cli_uf = cli_uf;
        this.cli_cep = cli_cep;
        this.ped_tipo = ped_tipo;
        this.ped_orcNome = ped_orcNome;
        this.ped_orcFone = ped_orcFone;
        this.ped_orcEmail = ped_orcEmail;
        this.ped_orcContato = ped_orcContato;
    }

    public String getPed_orcNome() {
        return ped_orcNome;
    }

    public void setPed_orcNome(String ped_orcNome) {
        this.ped_orcNome = ped_orcNome;
    }

    public String getPed_orcFone() {
        return ped_orcFone;
    }

    public void setPed_orcFone(String ped_orcFone) {
        this.ped_orcFone = ped_orcFone;
    }

    public String getPed_orcEmail() {
        return ped_orcEmail;
    }

    public void setPed_orcEmail(String ped_orcEmail) {
        this.ped_orcEmail = ped_orcEmail;
    }

    public String getPed_orcContato() {
        return ped_orcContato;
    }

    public void setPed_orcContato(String ped_orcContato) {
        this.ped_orcContato = ped_orcContato;
    }

    public int getPed_id() {
        return ped_id;
    }

    public void setPed_id(int ped_id) {
        this.ped_id = ped_id;
    }

    public int getPed_num() {
        return ped_num;
    }

    public void setPed_num(int ped_num) {
        this.ped_num = ped_num;
    }

    public Date getDt_venda() {
        return dt_venda;
    }

    public void setDt_venda(Date dt_venda) {
        this.dt_venda = dt_venda;
    }

    public Date getDt_Entrega() {
        return dt_Entrega;
    }

    public void setDt_Entrega(Date dt_Entrega) {
        this.dt_Entrega = dt_Entrega;
    }

    public int getCli_id() {
        return cli_id;
    }

    public void setCli_id(int cli_id) {
        this.cli_id = cli_id;
    }

    public String getCli_nome() {
        return cli_nome;
    }

    public void setCli_nome(String cli_nome) {
        this.cli_nome = cli_nome;
    }

    public double getPed_total() {
        return ped_total;
    }

    public void setPed_total(double ped_total) {
        this.ped_total = ped_total;
    }

    public String getPed_obs() {
        return ped_obs;
    }

    public void setPed_obs(String ped_obs) {
        this.ped_obs = ped_obs;
    }

    public int getStp_codigo() {
        return stp_codigo;
    }

    public void setStp_codigo(int stp_codigo) {
        this.stp_codigo = stp_codigo;
    }

    public String getStp_nome() {
        return stp_nome;
    }

    public void setStp_nome(String stp_nome) {
        this.stp_nome = stp_nome;
    }

    public String getCli_endereco() {
        return cli_endereco;
    }

    public void setCli_endereco(String cli_endereco) {
        this.cli_endereco = cli_endereco;
    }

    public String getCli_numero() {
        return cli_numero;
    }

    public void setCli_numero(String cli_numero) {
        this.cli_numero = cli_numero;
    }

    public String getCli_comple() {
        return cli_comple;
    }

    public void setCli_comple(String cli_comple) {
        this.cli_comple = cli_comple;
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

    public String getCli_cep() {
        return cli_cep;
    }

    public void setCli_cep(String cli_cep) {
        this.cli_cep = cli_cep;
    }

    public String getPed_tipo() {
        return ped_tipo;
    }

    public void setPed_tipo(String ped_tipo) {
        this.ped_tipo = ped_tipo;
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
