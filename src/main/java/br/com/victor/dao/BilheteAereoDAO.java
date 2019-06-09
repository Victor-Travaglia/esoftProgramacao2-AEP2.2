package br.com.victor.dao;

import br.com.victor.entities.BilheteAereo;

import java.sql.*;
import java.util.Date;

public class BilheteAereoDAO {

    public static void criarTabela(Connection connection) throws Exception {
        String sql = "create table if not exists bilheteAereo ("
                + "voo integer not null primary key,"
                + "origem varchar(255) not null,"
                + "destino varchar(255) not null,"
                + "data date not null"
                + ")";

        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
    }

    public static void insere(Connection connection, BilheteAereo bilheteAereo) throws SQLException {
        String sql = "insert into BilheteAereo (voo, origem, destino, data) values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
    }

    public static void excluirTodos(Connection connection) throws Exception {
        String sql = "delete from bilheteAereo";
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
    }

    public static void mostrarTodos(Connection connection) throws Exception {

        String sql = "select id, nome, nascimento from pessoa";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next())  {
            System.out.println("Voo: " + resultSet.getInt("voo")
                + "Origem: " + resultSet.getString("origem")
                + "Destino: " + resultSet.getString("destino")
                + "Data: " + new Date(resultSet.getDate("data").getTime()));
        }
        resultSet.close();
        statement.close();
    }
}