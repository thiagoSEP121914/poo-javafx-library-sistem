package com.application.javafx2.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB  {
    private static Connection conn;

    public static Connection getConn() {
        if (conn == null) {
            try {
                Properties prop = loadProps();
                String URL = prop.getProperty("dburl");
                String USER = prop.getProperty("user");
                String PASSWORD = prop.getProperty("password");
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException("NÃO FOI POSSIVEL CONECTAR COM O BANCO DE DADOS!!" + e.getMessage());
            }
        }
        System.out.println("BANCO DE DADOS CONECTADO COM SUCESSO!");
        return conn;
    }

    private static Properties loadProps () {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new RuntimeException("NÃO FOI POSSIVEL LER O ARQUIVO DE CONFIDURAÇÃO");
        }
    }

    public static void closeStatement (PreparedStatement ps) {
        if (ps != null ) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException("ERRO AO FECHAR O PREPARE STATEMENT" + e.getMessage());
            }
        }
    }

    public static void closeResultSet (ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException("ERRO NO RESULT SET" + e.getMessage());
            }
        }
    }

    public static void main (String[] args) {
        Connection conn = getConn();
    }
}
