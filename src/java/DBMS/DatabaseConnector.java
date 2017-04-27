/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBMS;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author saumiko
 */
public class DatabaseConnector {

    Connection connection;
    public boolean insert = false;
    public boolean login = false;
    public boolean confirmuser = false;
    public int session_id = 0, id = 0;
    public String name = null;
    public boolean passReset = false;
    public String mailName = null;
    public String mailAddress = null;

    public DatabaseConnector() {
        createConnection();
    }

    public void createConnection() {
        session_id = 0;
        insert = false;
        id = 0;
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

    public void newuser(String username, String password, int usertype, String userid) {
        String newname, dob, mail, blood, phone, regno;
        newname = null;
        dob = null;
        mail = null;
        blood = null;
        phone = null;
        regno = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if (usertype == 1) //Student
        {
            try {
                Statement st = connection.createStatement();
                String q = "select * from Student where regno = '" + userid + "'";
                ResultSet rs = st.executeQuery(q);
                if (rs.next()) {
                    newname = rs.getString("name");
                    dob = rs.getString("dob");
                    mail = rs.getString("mail");
                    blood = rs.getString("blood");
                    phone = rs.getString("phone");
                    regno = rs.getString("regno");
                    System.out.println("NewUser:"+mail);
                    if(mail.equals(null))
                        return;
                }
                else
                    return;
            } catch (Exception e) {
                return;
            }
        } 
        else if (usertype == 2) //Teacher
        {
            try {
                Statement st = connection.createStatement();
                String q = "select * from Teacher where teacher_id = '" + userid + "'";
                ResultSet rs = st.executeQuery(q);
                if (rs.next()) {
                    newname = rs.getString("name");
                    dob = rs.getString("dob");
                    mail = rs.getString("mail");
                    blood = rs.getString("blood");
                    phone = rs.getString("phone");
                    regno = rs.getString("teacher_id");
                }
                else
                    return;
            } catch (Exception e) {
                return;
            }
        } else if (usertype == 3) //Employee
        {
            try {
                Statement st = connection.createStatement();
                String q = "select * from Employee where employee_id = '" + userid + "'";
                ResultSet rs = st.executeQuery(q);
                if (rs.next()) {
                    newname = rs.getString("name");
                    dob = rs.getString("dob");
                    mail = rs.getString("mail");
                    blood = rs.getString("blood");
                    phone = rs.getString("phone");
                    regno = rs.getString("employee_id");
                }
                else
                    return;
            } catch (Exception e) {
                return;
            }
        } else {
            return;
        }
        ConfirmationGenerator cgen = new ConfirmationGenerator();
        String confirmationString = cgen.getConfirmationString();
        try {
            Statement st = connection.createStatement();
            String queryString = "INSERT INTO user(username, password, usertype, randstr, cnfrm) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement pstatement = null;
            pstatement = connection.prepareStatement(queryString);
            pstatement.setString(1, username);
            pstatement.setString(2, password);
            pstatement.setInt(3, usertype);
            pstatement.setString(4, confirmationString);
            pstatement.setInt(5, 0);
            pstatement.executeUpdate();
            Statement st2 = connection.createStatement();
            ResultSet rs = st2.executeQuery("select max(user_id) from user");
            if (rs.next()) {
                id = rs.getInt("max(user_id)");
            }
        } 
        catch (Exception e) {
            return;
        }
        userinfo(id, newname, dob.substring(0, dob.length() - 11), mail, blood, phone, regno);
    }

    public void userinfo(int id, String name, String dob, String mail, String blood, String phone, String reg) {
        try {
            String dtime = dob;
            int registration = Integer.parseInt(reg);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date birth = new java.sql.Date(format.parse(dob).getTime());
            Statement st = connection.createStatement();
            String queryString = "INSERT INTO info(user_id, name, dob, mail, blood, phone, regno, dept) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstatement = null;
            pstatement = connection.prepareStatement(queryString);
            pstatement.setInt(1, id);
            pstatement.setString(2, name);
            pstatement.setDate(3, birth);
            pstatement.setString(4, mail);
            pstatement.setString(5, blood);
            pstatement.setString(6, phone);
            pstatement.setInt(7, registration);
            pstatement.setString(8, "CSE");
            pstatement.executeUpdate();
            this.insert = true;
        } catch (Exception e) {
            this.insert = false;
        }
        this.mailName = name;
        this.mailAddress = mail;
    }

    public String confirmationStr(int id) {
        String randstr = null;
        try {
            Statement st = connection.createStatement();
            String q = "select randstr from user where user_id = " + Integer.toString(id);
            ResultSet rs = st.executeQuery(q);
            if (rs.next()) {
                randstr = rs.getString("randstr");
            }
        } catch (Exception e) {
        }
        return randstr;
    }

    public void confirmUser(int id) {
        try {
            Statement st = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("update user set cnfrm=?, randstr=? where user_id=?");
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "null");
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void matchLogin(String username, String Password) {
        String pwd;
        int cnfrm;
        try {
            Statement st = connection.createStatement();
            String q = "select password, user_id, cnfrm from user where username = '" + username + "'";
            ResultSet rs = st.executeQuery(q);
            if (rs.next()) {
                pwd = rs.getString("password");
                cnfrm = rs.getInt("cnfrm");
                session_id = rs.getInt("user_id");
                if (cnfrm == 1 && Password.equals(pwd)) {
                    login = true;
                    confirmuser = true;
                    String q2 = "select name from info where user_id = " + Integer.toString(session_id);
                    Statement st2 = connection.createStatement();
                    ResultSet rs2 = st2.executeQuery(q2);
                    if (rs2.next()) {
                        name = rs2.getString("name");
                    }
                } else if (cnfrm == 0 && Password.equals(pwd)) {
                    login = true;
                    confirmuser = false;
                }

            }
        } catch (Exception e) {
        }
    }

    public void passwordreset(String mail) {
        System.out.println("PassReset:" + mail);
        String mailname = null;
        int mailuserid = 0;
        try {
            Statement st = connection.createStatement();
            String q = "select user_id, name from info where mail = '" + mail + "'";
            ResultSet rs = st.executeQuery(q);
            if (rs.next()) {
                mailuserid = rs.getInt("user_id");
                mailname = rs.getString("name");
                System.out.println("PassResetmailuserid:" + mailuserid + ", " + mailname);
            }
        } catch (Exception e) {
            return;
        }

        ConfirmationGenerator newPass = new ConfirmationGenerator();
        String newPassword = newPass.getConfirmationString();
        try {
            if (mailuserid == 0) {
                return;
            }
            Statement st = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("update user set password=? where user_id=?");
            preparedStatement.setString(1, newPassword);
            preparedStatement.setInt(2, mailuserid);
            preparedStatement.executeUpdate();
        } catch (Exception e) {

        }

        String mailusername = null;
        try {
            Statement st = connection.createStatement();
            String q = "select username from user where user_id = " + Integer.toString(mailuserid);
            ResultSet rs = st.executeQuery(q);
            if (rs.next()) {
                mailusername = rs.getString("username");
            }
        } catch (Exception e) {
        }

        ForgotPasswordMail sendPass = new ForgotPasswordMail();
        sendPass.sendingMail(mail, mailname, newPassword, mailusername);
        System.out.println("new password: " + newPassword + " Username: " + mailusername);
        this.passReset = true;
    }
}
