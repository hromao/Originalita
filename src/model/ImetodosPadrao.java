package model;

import java.sql.SQLException;

/**
 *
 * @author Henrique
 */
public interface ImetodosPadrao {

    public void incluir() throws SQLException, ClassNotFoundException;

    public void alterar() throws SQLException, ClassNotFoundException;

    public boolean excluir() throws SQLException, ClassNotFoundException;

    public int pegaUltimaID() throws SQLException, ClassNotFoundException;

    public void excluirUltimoId(int id) throws SQLException, ClassNotFoundException;

}
