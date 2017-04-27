/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBMS;

import java.sql.*;
import java.util.*;

/**
 *
 * @author saumiko
 */
public class StatusHandler {
    static Connection connection;
    
    public StatusHandler()
    {
        createConnection();
    }
    
    public void createConnection() {
        connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String URL = DatabaseInfo.URL;
            String USERNAME = DatabaseInfo.USERNAME;
            String PASSWORD = DatabaseInfo.PASSWORD;
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String qn = "SET CHARACTER SET utf8";
            Statement stn = connection.createStatement();
            ResultSet rsn = stn.executeQuery(qn);
            String qn1 = "SET SESSION collation_connection ='utf8_general_ci'";
            Statement stn1 = connection.createStatement();
            ResultSet rsn1 = stn1.executeQuery(qn1);
        } catch (Exception e) {
            System.out.println("Problem With Database Connection");
        }
    }
    
    public void postStatus(int id, String statusMessage, int privacyFlag)
    {
        try {
            Statement st = connection.createStatement();
            String queryString = "INSERT INTO post(user_id, post, nlike, ndislike, valid, postexist, privacy_flag) VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstatement = null;
            pstatement = connection.prepareStatement(queryString);
            pstatement.setInt(1, id);
            pstatement.setString(2, statusMessage);
            pstatement.setInt(3, 0);
            pstatement.setInt(4, 0);
            pstatement.setInt(5, 1);
            pstatement.setInt(6, 1);
            pstatement.setInt(7, privacyFlag);
            pstatement.executeUpdate();
        } 
        catch (Exception e) {}
    }
    
    public static int getTotalPosts()
    {
        int totalPosts=0;
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select max(post_id) from post");
            if (rs.next()) {
                totalPosts = rs.getInt("max(post_id)");
            }
        }
        catch(Exception e){
            System.out.println("Hoynaai!");
        }
        return totalPosts;
    }
}
