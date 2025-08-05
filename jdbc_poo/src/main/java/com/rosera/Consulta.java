package com.rosera;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Consulta {

    public static class App {
        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/jdbc_poo";
            String user = "root";
            String password = "univille";

            try {
                Connection con = DriverManager.getConnection(url, user, password);
                System.out.println("Conectou!");

                String sql = "SELECT Identificador, Nome, CPF FROM pessoa WHERE Identificador = ? ORDER BY Nome";
                PreparedStatement pre = con.prepareStatement(sql);

                pre.setInt(1, 1); // buscar registro com Identificador = 1

                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("Identificador");
                    String nome = rs.getString("Nome");
                    String cpf = rs.getString("CPF");
                    System.out.println(id + " " + nome + " " + cpf);
                }

                rs.close();
                pre.close();
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
