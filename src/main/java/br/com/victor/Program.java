package br.com.victor;

import br.com.victor.dao.BilheteAereoDAO;
import br.com.victor.entities.BilheteAereo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;

public class Program {

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/3esoft2019", "postgres", "unicesumar");

            BilheteAereoDAO.criarTabela();
            BilheteAereoDAO.insere(connection, new BilheteAereo(111,"Maringá","Curitiba",new Date()));
            BilheteAereoDAO.insere(connection, new BilheteAereo(222,"Curitiba","Rio De Janeiro",new Date()));
            BilheteAereoDAO.insere(connection, new BilheteAereo(111,"Londrina","Londres",new Date()));
            BilheteAereoDAO.mostrarTodos();
            BilheteAereoDAO.excluirTodos();
            BilheteAereoDAO.mostrarTodos();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}