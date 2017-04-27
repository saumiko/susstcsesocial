/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBMS;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author saumiko
 */
public class SinglePost {
    static Connection connection;
    
    public SinglePost()
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
    
    public static String getName(int post_id)
    {
        int user_id = 0;
        String name = null;
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select user_id from post where post_id ="+Integer.toString(post_id));
            if (rs.next()) {
                user_id = rs.getInt("user_id");
            }
        }
        catch(Exception e){
            System.out.println("Hoynaai!");
        }
        try{
            Statement st2 = connection.createStatement();
            ResultSet rs2 = st2.executeQuery("select name from info where user_id ="+Integer.toString(user_id));
            if (rs2.next()) {
                name = rs2.getString("name");
            }
        }
        catch(Exception e){}
        return name;
    }
    
    public static String getPrivacy(int post_id)
    {
        String privacy = null;
        int privacy_id = 0;
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select privacy_flag from post where post_id = "+Integer.toString(post_id));
            if (rs.next()) {
                privacy_id = rs.getInt("privacy_flag");
            }
            if(privacy_id == 1)
                privacy = "Shared publicly";
            else if(privacy_id == 2)
                privacy = "Shared with friends";
            else if(privacy_id == 3)
                privacy = "Only Me";
        }
        catch(Exception e){}
        return privacy;
    }
    
    public static String getPost(int post_id)
    {
        String post = null;
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select post from post where post_id ="+Integer.toString(post_id));
            if (rs.next()) {
                post = rs.getString("post");
            }
        }
        catch(Exception e){}
        return post;
    }
    
    public static int getId(int post_id)
    {
        int user_id = 0;
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select user_id from post where post_id = "+Integer.toString(post_id));
            if (rs.next()) {
                user_id = rs.getInt("user_id");
            }
        }
        catch(Exception e){}
        return user_id;
    }
    
    public static int getLikes(int post_id)
    {
        int nlikes = 0;
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select nlike from post where post_id = "+Integer.toString(post_id));
            if (rs.next()) {
                nlikes = rs.getInt("nlike");
            }
        }
        catch(Exception e){}
        return nlikes;
    }
    
    public static int getDislikes(int post_id)
    {
        int ndislikes = 0;
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select ndislike from post where post_id = "+Integer.toString(post_id));
            if (rs.next()) {
                ndislikes = rs.getInt("ndislike");
            }
        }
        catch(Exception e){}
        return ndislikes;
    }
    
    public static int getTotalComments(int post_id)
    {
        int totalComments = 0;
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select count(comment_id) from comment where post_id = "+Integer.toString(post_id));
            if (rs.next()) {
                totalComments = rs.getInt("count(comment_id)");
            }
        }
        catch(Exception e){}
        return totalComments;
    }
    
    public static void likePost(int post_id, int user_id)
    {
        boolean interacted = true;
        int pousrid;
        int nlikes = 0;
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select user_id from post_activity where post_id = "+Integer.toString(post_id));
            while(rs.next())
            {
                pousrid = rs.getInt("user_id");
                if(pousrid == user_id)
                {
                    interacted = false;
                    return;
                }
                
            }
            if(interacted)
            {
                try{
                    Statement st2 = connection.createStatement();
                    String queryString = "INSERT INTO post_activity(user_id, post_id) values (?, ?)";
                    PreparedStatement pstatement = null;
                    pstatement = connection.prepareStatement(queryString);
                    pstatement.setInt(1, user_id);
                    pstatement.setInt(2, post_id);
                    pstatement.executeUpdate();
                    
                }
                catch(Exception e){}
                try{
                    Statement st2 = connection.createStatement();
                    ResultSet rs2 = st2.executeQuery("select nlike from post where post_id = "+Integer.toString(post_id));
                    if(rs2.next())
                    {
                        nlikes = rs2.getInt("nlike");
                        nlikes++;
                    }
                }
                catch(Exception e){}
                try{
                    PreparedStatement preparedStatement = connection.prepareStatement("update post set nlike = ? where post_id = ?");
                    preparedStatement.setInt(1, nlikes);
                    preparedStatement.setInt(2, post_id);
                    preparedStatement.executeUpdate();
                }
                catch(Exception e){}
            }
        }
        catch(Exception e){}
    }
    
    public static void dislikePost(int post_id, int user_id)
    {
        boolean interacted = true;
        int pousrid;
        int ndislikes = 0;
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select user_id from post_activity where post_id = "+Integer.toString(post_id));
            while(rs.next())
            {
                pousrid = rs.getInt("user_id");
                if(pousrid == user_id)
                {
                    interacted = false;
                    return;
                }
                
            }
            if(interacted)
            {
                try{
                    Statement st2 = connection.createStatement();
                    String queryString = "INSERT INTO post_activity(user_id, post_id) values (?, ?)";
                    PreparedStatement pstatement = null;
                    pstatement = connection.prepareStatement(queryString);
                    pstatement.setInt(1, user_id);
                    pstatement.setInt(2, post_id);
                    pstatement.executeUpdate();
                    
                }
                catch(Exception e){}
                try{
                    Statement st2 = connection.createStatement();
                    ResultSet rs2 = st2.executeQuery("select ndislike from post where post_id = "+Integer.toString(post_id));
                    if(rs2.next())
                    {
                        ndislikes = rs2.getInt("ndislike");
                        ndislikes++;
                    }
                }
                catch(Exception e){}
                try{
                    PreparedStatement preparedStatement = connection.prepareStatement("update post set ndislike = ? where post_id = ?");
                    preparedStatement.setInt(1, ndislikes);
                    preparedStatement.setInt(2, post_id);
                    preparedStatement.executeUpdate();
                }
                catch(Exception e){}
            }
        }
        catch(Exception e){}
    }
    
    public static void postComment(int post_id, int user_id, String comment)
    {
        try {
            Statement st2 = connection.createStatement();
            String queryString = "INSERT INTO comment(user_id, post_id, comment, nlike, ndislike, valid, commentexist) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstatement = null;
            pstatement = connection.prepareStatement(queryString);
            pstatement.setInt(1, user_id);
            pstatement.setInt(2, post_id);
            pstatement.setString(3, comment);
            pstatement.setInt(4, 0);
            pstatement.setInt(5, 0);
            pstatement.setInt(6, 1);
            pstatement.setInt(7, 1);
            pstatement.executeUpdate();
        } 
        catch (Exception e) {}
    }
    
    public static String getPostText(int post_id)
    {
        String post = null;
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select post from post where post_id = "+Integer.toString(post_id));
            if (rs.next()) {
                post = rs.getString("post");
            }
        }
        catch(Exception e){}
        return post;
    }
    
    public static String getCommentName(int user_id)
    {
        String name = null;
        try{
            Statement st2 = connection.createStatement();
            ResultSet rs2 = st2.executeQuery("select name from info where user_id ="+Integer.toString(user_id));
            if (rs2.next()) {
                name = rs2.getString("name");
            }
        }
        catch(Exception e){}
        return name;
    }
    
    public static int getUserPostNumber(int user_id)
    {
        int totalPost = 0;
        int postNo[] = null;
        int i = 0;
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select post_id from post where user_id ="+Integer.toString(user_id));
            while (rs.next()) {
                //System.out.println(rs.getString("post"));
                //postNo[i++] = rs.getInt("post_id");
                totalPost++;
            }
        }
        catch(Exception e){}
        System.out.println("Post ID:"+postNo+"Total: "+totalPost);
        return totalPost;
    }
    
    public static float getPersonalityScore(int user_id)
    {
        float pscore = 0;
        int nlike = -2, ndislike = -1;
        try{
            Statement st1 = connection.createStatement();
            Statement st2 = connection.createStatement();
            ResultSet rs1 = st1.executeQuery("select sum(nlike) from post where user_id ="+Integer.toString(user_id));
            ResultSet rs2 = st2.executeQuery("select sum(ndislike) from post where user_id = "+Integer.toString(user_id));
            if(rs1.next())
            {
                nlike = rs1.getInt("sum(nlike)");
            }
            if(rs2.next())
            {
                ndislike = rs2.getInt("sum(ndislike)");
            }
            pscore = (float) (((float)nlike/((float)nlike+(float)ndislike))*100.0);
        }
        catch(Exception e){System.out.println(e);}
        return pscore;
    }
    
    public static String getUserPosts(int user_id, int n)
    {
        String post = null;
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select post from post where user_id ="+Integer.toString(user_id));
            for(int i = 0; i<n+1; i++)
            {
                if(rs.next()){
                    if(i==n)
                    {
                        post = rs.getString("post");
                        return post;
                    }
                    else{
                        post = rs.getString("post");
                    }
                }
                
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return post;
    }
}
