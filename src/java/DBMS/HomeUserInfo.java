/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

/**
 *
 * @author saumiko
 */
public class HomeUserInfo {
    static Connection connection;
    static StringTokenizer stoken;
    
    public HomeUserInfo()
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
    
    public static String getUserType(int id)
    {
        String userType = null;
        int typeId;
        try{
            Statement st = connection.createStatement();
            String q = "select usertype from user where user_id = "+Integer.toString(id);
            ResultSet rs = st.executeQuery(q);
            if(rs.next())
            {
                typeId = rs.getInt("usertype");
                if(typeId == 1)
                    userType = "Student";
                else if(typeId == 2)
                    userType = "Teacher";
                else if(typeId == 3)
                    userType = "Employee";
                else
                    userType = "Unknown";
            }
        }
        catch(Exception e){}
        return userType;
    }
    
    public static String getUserSemester(int id)
    {
        String userSemester = null;
        String userRegistration = null;
        String userYear;
        try{
            Statement st = connection.createStatement();
            String q = "select regno from info where user_id = "+Integer.toString(id);
            ResultSet rs = st.executeQuery(q);
            if(rs.next())
            {
                userRegistration = rs.getString("regno");
                userYear = userRegistration.substring(0,4);
                if(userYear.equals("2012"))
                    userSemester = "CSE 4/2";
                else if(userYear.equals("2013"))
                    userSemester = "CSE 3/2";
                else if(userYear.equals("2014"))
                    userSemester = "CSE 2/2";
                else if(userYear.equals("2015"))
                    userSemester = "CSE 1/2";
                else if(userYear.equals("2016"))
                    userSemester = "CSE 1/1";
            }
        }
        catch(Exception e){}
        return userSemester;
    }
    
    public static String getUserReg(int id)
    {
        String userRegistration = null;
        try{
            Statement st = connection.createStatement();
            String q = "select regno from info where user_id = "+Integer.toString(id);
            ResultSet rs = st.executeQuery(q);
            if(rs.next())
            {
                userRegistration = rs.getString("regno");
            }
        }
        catch(Exception e){}
        return userRegistration;
    }
    
    public static String getUserMail(int id)
    {
        String userMail = null;
        try{
            Statement st = connection.createStatement();
            String q = "select mail from info where user_id = "+Integer.toString(id);
            ResultSet rs = st.executeQuery(q);
            if(rs.next())
            {
                userMail = rs.getString("mail");
            }
        }
        catch(Exception e){}
        return userMail;
    }
    
    public static String getUserDOB(int id)
    {
        String userDOB = null;
        java.sql.Date dob = null;
        DateFormat df = new SimpleDateFormat("MM dd yyyy");
        String text = null;
        String month = null;
        String day = null;
        String year = null;
        try{
            Statement st = connection.createStatement();
            String q = "select dob from info where user_id = "+Integer.toString(id);
            ResultSet rs = st.executeQuery(q);
            if(rs.next())
            {
                dob = rs.getDate("dob");
                text = df.format(dob);
                stoken = new StringTokenizer(text);
                if(stoken.hasMoreElements())
                {
                    month = (String)stoken.nextElement();
                    switch (month) {
                        case "01":
                            month = "January";
                            break;
                        case "02":
                            month = "February";
                            break;
                        case "03":
                            month = "March";
                            break;
                        case "04":
                            month = "April";
                            break;
                        case "05":
                            month = "May";
                            break;
                        case "06":
                            month = "June";
                            break;
                        case "07":
                            month = "July";
                            break;
                        case "08":
                            month = "August";
                            break;
                        case "09":
                            month = "September";
                            break;
                        case "10":
                            month = "October";
                            break;
                        case "11":
                            month = "November";
                            break;
                        case "12":
                            month = "December";
                            break;
                        default:
                            break;
                    }
                    day = (String)stoken.nextElement();
                    year = (String)stoken.nextElement();
                    userDOB = month+" "+day+", "+year;
                }
            }
        }
        catch(Exception e){}
        return userDOB;
    }
    
    public static String getUserBlood(int id)
    {
        String userBlood = null;
        String finalBlood = null;
        String type = null;
        try{
            Statement st = connection.createStatement();
            String q = "select blood from info where user_id = "+Integer.toString(id);
            ResultSet rs = st.executeQuery(q);
            if(rs.next())
            {
                userBlood = rs.getString("blood");
            }
            if(userBlood.endsWith("+"))
            {
                type = userBlood.substring(0, userBlood.length()-1);
                finalBlood = type+"(+)ve";
            }
            if(userBlood.endsWith("-"))
            {
                type = userBlood.substring(0, userBlood.length()-1);
                finalBlood = type+"(-)ve";
            }
        }
        catch(Exception e){}
        return finalBlood;
    }
    
    public static String getName(int id)
    {
        String Name = null;
        try{
            Statement st = connection.createStatement();
            String q = "select name from info where user_id = "+Integer.toString(id);
            ResultSet rs = st.executeQuery(q);
            if(rs.next())
            {
                Name = rs.getString("name");
            }
        }
        catch(Exception e){}
        return Name;
    }
}
