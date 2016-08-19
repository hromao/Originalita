package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Duplicata;

/**
 *
 * @author Henrique
 */
public class DaoDuplicata extends Duplicata {

    private Connection conn = null;
    private PreparedStatement comando = null;
    Date dataEmissao = null;
    Date dataPgto = null;
    Date dataVcto = null;
    Conexao conexao = new Conexao();

    @Override
    public void incluir() throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO duplicata (dup_id, dup_numero, dup_dtEmissao,"
                + "dup_dtVcto, dup_dtPagamento, dup_valor, cli_id, dup_saldo, ped_id) "
                + "VALUES "
                + "(?,?,?,?,?,?,?,?,?)";
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, this.getDup_id());
        comando.setString(2, this.getDup_numero());
        dataEmissao = new Date(this.getDtEmissao().getTime());
        //dataPgto = new Date(this.getDtPagamento().getTime());
        dataVcto = new Date(this.getDtVcto().getTime());
        comando.setDate(3, dataEmissao);
        comando.setDate(4, dataVcto);
        comando.setNull(5, java.sql.Types.DATE);
        comando.setDouble(6, this.getDup_valor());
        comando.setInt(7, this.getCli_id());
        comando.setDouble(8, this.getDup_saldo());
        comando.setInt(9, this.getPed_id());
        comando.execute();
        comando.close();
        this.conn.close();
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        String sql = "UPDATE duplicata SET "
                + "dup_numero = ?,"
                + "dup_dtEmissao=?,"
                + "dup_dtVcto=?,"
                //+ "dup_dtPagamento=?,"
                + "dup_valor=?,"
                + "cli_id=?,"
                + "dup_saldo=? "
                + "WHERE dup_id=?";
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setString(1, this.getDup_numero());
        dataEmissao = new Date(this.getDtEmissao().getTime());
        //dataPgto = new Date(this.getDtPagamento().getTime());
        dataVcto = new Date(this.getDtVcto().getTime());
        comando.setDate(2, dataEmissao);
        comando.setDate(3, dataVcto);
        comando.setDate(4, dataPgto);
        comando.setDouble(5, this.getDup_valor());
        comando.setInt(6, this.getCli_id());
        comando.setDouble(7, this.getDup_saldo());
        comando.setInt(8, this.getDup_id());
        comando.execute();
        comando.close();
        this.conn.close();
    }

    @Override
    public boolean excluir() throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM duplicata WHERE dup_id=?";
        try {
            this.conn = conexao.getConnection();
            comando = conn.prepareStatement(sql);
            comando.setInt(1, this.getDup_id());
            boolean apagou = comando.execute();
            comando.close();
            return apagou;
        } catch (SQLException ex) {
            throw ex;
        } catch (ClassNotFoundException e) {
            throw e;
        } finally {
            this.conn.close();
        }
    }

    /*@Override
     public int pegaUltimaID() throws SQLException, ClassNotFoundException {
     int ultimoId = 0;
     String sql = "INSERT INTO duplicata (dup_id) VALUE (null)";
     String sqlSelect = "SELECT MAX(dup_id) AS ultimoId FROM duplicata";
     try {
     this.conn = Conexao.getConnection();
     comando = conn.prepareStatement(sql);
     ResultSet rs = comando.executeQuery();
     if (rs.next()) {
     ultimoId = rs.getInt("ultimoId");
     } else {
     ultimoId = 0;
     }
     } finally {
     comando.close();
     this.conn.close();
     }
     return ultimoId;
     }
     */
    public ArrayList<DaoDuplicata> retornaItensPedido(int id) throws SQLException, ClassNotFoundException {
        DaoDuplicata dupRetorno = null;
        String sql = "SELECT dup_numero, dup_dtVcto, dup_valor FROM duplicata "
                + "WHERE ped_id=?";
        ArrayList<DaoDuplicata> listaDup = new ArrayList<DaoDuplicata>();
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, id);
        ResultSet rs = comando.executeQuery();
        while (rs.next()) {
            dupRetorno = new DaoDuplicata();
            dupRetorno.setDup_numero(rs.getString("dup_numero"));
            dupRetorno.setDtVcto(rs.getDate("dup_dtVcto"));
            dupRetorno.setDup_valor(rs.getDouble("dup_valor"));

            listaDup.add(dupRetorno);
        }
        rs.close();
        comando.close();
        this.conn.close();
        return listaDup;
    }

    /* public void atualizaPgto(Date dataPgto) throws SQLException, ClassNotFoundException {
     String sql = "UPDATE duplicata SET dup_dtPagamento = ? WHERE dup_id = ?";
     this.conn = Conexao.getConnection();
     comando = conn.prepareStatement(sql);
     comando.setDate(1, dataPgto);
     comando.setInt(2, this.getDup_id());
     comando.execute();
     comando.close();
     this.conn.close();
     }*/
    public ArrayList<DaoDuplicata> retornaTodasDuplicatas() throws SQLException, ClassNotFoundException {
        DaoDuplicata dupRetorno = null;
        String sql = "SELECT duplicata.dup_id, duplicata.dup_numero, cliente.cli_cod, cliente.cli_nome, "
                + "duplicata.dup_dtEmissao, duplicata.dup_dtVcto, duplicata.dup_valor, duplicata.dup_saldo "
                + "FROM duplicata "
                + "INNER JOIN cliente ON duplicata.cli_id = cliente.cli_id";
        ArrayList<DaoDuplicata> listaDup = new ArrayList<>();
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        ResultSet rs = comando.executeQuery();
        while (rs.next()) {
            dupRetorno = new DaoDuplicata();
            dupRetorno.setDup_id(rs.getInt("dup_id"));
            dupRetorno.setDup_numero(rs.getString("dup_numero"));
            dupRetorno.setCli_cod(rs.getString("cli_cod"));
            dupRetorno.setCli_nome(rs.getString("cli_nome"));
            dupRetorno.setDtEmissao(rs.getDate("dup_dtEmissao"));
            dupRetorno.setDtVcto(rs.getDate("dup_dtVcto"));
            dupRetorno.setDup_valor(rs.getDouble("dup_valor"));
            dupRetorno.setDup_saldo(rs.getDouble("dup_saldo"));

            listaDup.add(dupRetorno);
        }
        comando.close();
        rs.close();
        this.conn.close();
        return listaDup;
    }

    public void retornaDadosDuplicata(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT duplicata.dup_id, duplicata.dup_numero, cliente.cli_nome,"
                + " duplicata.dup_dtEmissao, duplicata.dup_dtVcto, duplicata.dup_valor, "
                + "duplicata.dup_saldo, duplicata.dup_dtPagamento "
                + "FROM duplicata "
                + "INNER JOIN cliente ON duplicata.cli_id = cliente.cli_id "
                + "WHERE dup_id = ?";
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, id);
        ResultSet rs = comando.executeQuery();
        if (rs.next()) {
            setDup_id(rs.getInt("dup_id"));
            setDup_numero(rs.getString("dup_numero"));
            setCli_nome(rs.getString("cli_nome"));
            setDtEmissao(rs.getDate("dup_dtEmissao"));
            setDtVcto(rs.getDate("dup_dtVcto"));
            setDup_valor(rs.getDouble("dup_valor"));
            setDup_saldo(rs.getDouble("dup_saldo"));
            setDtPagamento(rs.getDate("dup_dtPagamento"));
        }
        comando.executeQuery();
        comando.close();
        this.conn.close();
    }

    public void retornaDadosClienteGerarBoleto(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT duplicata.dup_id, duplicata.dup_numero, cliente.cli_nome,"
                + "cliente.cli_cpf, cliente.cli_endereco, cliente.cli_numero,cliente.cli_comple, cliente.cli_cep,"
                + "cliente.cli_bairro, cliente.cli_cidade, cliente.cli_uf "
                + "FROM duplicata "
                + "INNER JOIN cliente ON duplicata.cli_id = cliente.cli_id "
                + "WHERE dup_id = ?";
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, id);
        ResultSet rs = comando.executeQuery();
        if (rs.next()) {
            setDup_numero(rs.getString("dup_numero"));
            setCli_nome(rs.getString("cli_nome"));
            setCli_cpf(rs.getString("cli_cpf"));
            setCli_endereco(rs.getString("cli_endereco"));
            setCli_numero(rs.getString("cli_numero"));
            setCli_comple(rs.getString("cli_comple"));
            setCli_cep(rs.getString("cli_cep"));
            setCli_bairro(rs.getString("cli_bairro"));
            setCli_cidade(rs.getString("cli_cidade"));
            setCli_uf(rs.getString("cli_uf"));

        }
        comando.executeQuery();
        comando.close();
        this.conn.close();
    }

    @Override
    public int pegaUltimaID() throws SQLException, ClassNotFoundException {
        int ultimoId = 0;
        String sql = "INSERT INTO duplicata (dup_id) VALUE (null)";
        String sqlSelect = "SELECT MAX(dup_id) AS ultimoId FROM duplicata";
        try {
            this.conn = conexao.getConnection();
            comando = conn.prepareStatement(sql);
            comando.execute();
            comando = conn.prepareStatement(sqlSelect);
            ResultSet rs = comando.executeQuery();
            if (rs.next()) {
                ultimoId = rs.getInt("ultimoId");
            } else {
                ultimoId = 0;
            }
        } finally {
            comando.close();
            this.conn.close();
        }
        return ultimoId;
    }

    @Override
    public void excluirUltimoId(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM duplicata WHERE dup_id = ?";
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setInt(1, id);
        comando.execute();
        comando.close();
        this.conn.close();
    }

    public void baixaDuplicata(Date dataPgto) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE duplicata SET "
                + "dup_dtPagamento = ?,"
                + "dup_saldo = ? "
                + "WHERE dup_id = ?";
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setDate(1, dataPgto);
        comando.setDouble(2, this.getDup_saldo());
        comando.setInt(3, this.getDup_id());
        comando.execute();
        comando.close();
        this.conn.close();
    }

    public ArrayList<DaoDuplicata> pesquisarNumDup(DaoDuplicata ddup) throws SQLException, ClassNotFoundException {
        DaoDuplicata dupRetorno = null;
        String sql = "SELECT duplicata.dup_id, duplicata.dup_numero, cliente.cli_cod, cliente.cli_nome, "
                + "duplicata.dup_dtEmissao, duplicata.dup_dtVcto, duplicata.dup_valor, duplicata.dup_saldo "
                + "FROM duplicata "
                + "INNER JOIN cliente ON duplicata.cli_id = cliente.cli_id "
                + "WHERE duplicata.dup_numero LIKE ?";
        ArrayList<DaoDuplicata> listaDup = new ArrayList<>();
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setString(1, "%" + getDup_numero() + "%");
        ResultSet rs = comando.executeQuery();
        while (rs.next()) {
            dupRetorno = new DaoDuplicata();
            dupRetorno.setDup_id(rs.getInt("dup_id"));
            dupRetorno.setDup_numero(rs.getString("dup_numero"));
            dupRetorno.setCli_cod(rs.getString("cli_cod"));
            dupRetorno.setCli_nome(rs.getString("cli_nome"));
            dupRetorno.setDtEmissao(rs.getDate("dup_dtEmissao"));
            dupRetorno.setDtVcto(rs.getDate("dup_dtVcto"));
            dupRetorno.setDup_valor(rs.getDouble("dup_valor"));
            dupRetorno.setDup_saldo(rs.getDouble("dup_saldo"));

            listaDup.add(dupRetorno);
        }
        comando.close();
        rs.close();
        this.conn.close();
        return listaDup;
    }

    public ArrayList<DaoDuplicata> pesquisarCli(DaoDuplicata ddup) throws SQLException, ClassNotFoundException {
        DaoDuplicata dupRetorno = null;
        String sql = "SELECT duplicata.dup_id, duplicata.dup_numero, cliente.cli_cod, cliente.cli_nome, "
                + "duplicata.dup_dtEmissao, duplicata.dup_dtVcto, duplicata.dup_valor, duplicata.dup_saldo "
                + "FROM duplicata "
                + "INNER JOIN cliente ON duplicata.cli_id = cliente.cli_id "
                + "WHERE cliente.cli_nome LIKE ?";
        ArrayList<DaoDuplicata> listaDup = new ArrayList<>();
        this.conn = conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setString(1, "%" + getCli_nome() + "%");
        ResultSet rs = comando.executeQuery();
        while (rs.next()) {
            dupRetorno = new DaoDuplicata();
            dupRetorno.setDup_id(rs.getInt("dup_id"));
            dupRetorno.setDup_numero(rs.getString("dup_numero"));
            dupRetorno.setCli_cod(rs.getString("cli_cod"));
            dupRetorno.setCli_nome(rs.getString("cli_nome"));
            dupRetorno.setDtEmissao(rs.getDate("dup_dtEmissao"));
            dupRetorno.setDtVcto(rs.getDate("dup_dtVcto"));
            dupRetorno.setDup_valor(rs.getDouble("dup_valor"));
            dupRetorno.setDup_saldo(rs.getDouble("dup_saldo"));

            listaDup.add(dupRetorno);
        }
        comando.close();
        rs.close();
        this.conn.close();
        return listaDup;
    }

}
