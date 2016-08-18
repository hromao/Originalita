package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Login;

/**
 *
 * @author Henrique
 */
public class DaoLogin extends Login {

    private Connection conn = null;
    private PreparedStatement comando = null;

    public boolean login(String usu, String senha) throws SQLException, ClassNotFoundException {
        boolean login = false;
        String sql = "SELECT * FROM usuario WHERE usu_login = ? AND usu_senha = ?";
        this.conn = Conexao.getConnection();
        comando = conn.prepareStatement(sql);
        comando.setString(1, usu);
        comando.setString(2, senha);
        ResultSet rs = comando.executeQuery();
        if (rs.next()) {
            login = true;
        } else {
            login = false;
        }
        return login;
    }

}
