package ru.gb.storage.server.database;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class Database {
    public static Connection connection;
    public static PreparedStatement preparedStatement;
    public static ResultSet rs;

    public static void openDB() throws ClassNotFoundException, SQLException {
        connection = null;
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:./server/db/network-storage.db");
        log.debug("Database is open");
    }

    public static void closeDB() throws SQLException  {
        connection.close();
        preparedStatement.close();
        rs.close();
        log.debug("Database is closed");
    }

    public static String getUsername(String login, String password) throws SQLException {
        if (connection == null || connection.isClosed()) return null;
        preparedStatement = connection.prepareStatement("select username from users where login = ? and pass = ?");
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            return rs.getString("username");
        } else {
            return null;
        }
    }

}
