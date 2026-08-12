package org.example.database;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {

    private static Connection connection;
    private static Statement statement;

    private DatabaseManager(){
    }

    public static void makeConnection(){

        try {

            connection = DriverManager.getConnection("jdbc:sqlite:pacman.db");
            statement = connection.createStatement();

            createTable();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void createTable(){
        try {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS scores (id INTEGER PRIMARY KEY AUTOINCREMENT, ghostNumber INTEGER NOT NULL, mapType VARCHAR NOT NULL, score INTEGER NOT NULL);");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection(){
        if (connection != null){
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void saveScore(int ghostNumber, String mapType, int score){
        makeConnection();

        try {
            statement.executeUpdate("INSERT INTO scores (ghostNumber, mapType, score) VALUES (" + ghostNumber + ", '" + mapType + "' ," + score + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        closeConnection();
    }

    public static ArrayList<Integer> getTopScores(int ghostNumber, String mapType){
        makeConnection();

        ArrayList<Integer> topScores = new ArrayList<>();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT DISTINCT score FROM scores WHERE ghostNumber = " + ghostNumber + " AND mapType = '" + mapType + "' ORDER BY score DESC LIMIT 3");

            while (resultSet.next()){
                topScores.add(resultSet.getInt("score"));
            }
            resultSet.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }


        closeConnection();

        return topScores;
    }

}
