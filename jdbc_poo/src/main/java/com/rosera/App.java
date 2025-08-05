package com.rosera;

import java.sql.*;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_poo";
        String user = "root";
        String password = "univille";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Conectou!");

            String sql = "INSERT INTO pessoa(nome, cpf) VALUES (?, ?)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, "Tom");
            pre.setString(2, "1231232123");
            pre.execute();

            System.out.println("Dados inseridos com sucesso!");

        } catch (SQLException e) {
            System.out.println("Deu erro!");
            e.printStackTrace();
        }
    }
}
