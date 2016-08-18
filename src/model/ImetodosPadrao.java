/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;

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
