/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBMS;


import java.sql.*;

/**
 *
 * @author saumiko
 */
public class ProfileEditDB {
    static Connection connection;
    public static boolean insert = false;
    
    public ProfileEditDB()
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
    
    public void enterImage(int id, String link)
    {
        try
        {
            Statement st = connection.createStatement();
            String queryString = "INSERT INTO image(user_id, image) VALUES(?, ?)";
            PreparedStatement pstatement = null;
            pstatement = connection.prepareStatement(queryString);
            pstatement.setInt(1, id);
            pstatement.setString(2, link);
            pstatement.executeUpdate();
            insert = true;
        }
        catch(Exception e)
        {
            insert = false;
            System.out.println("Image hoy nai!");
        }
    }
    
    public static String getMyImage(int id)
    {
        String imageLink = "dist/img/avatar-default.jpg";
        try{
            Statement st = connection.createStatement();
            String q = "select image from image where user_id = "+Integer.toString(id); 
            ResultSet rs = st.executeQuery(q);
            if(rs.next())
            {
                imageLink = rs.getString("image");
            }
        }
        catch(Exception e){}
        return imageLink;
    }
}
