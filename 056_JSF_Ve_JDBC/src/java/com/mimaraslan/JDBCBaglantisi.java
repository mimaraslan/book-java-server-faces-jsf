package com.mimaraslan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class JDBCBaglantisi {
    static Connection con = null;
    //---------------------------------------------
    public static void main(String args[]) {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        /* con = DriverManager.getConnection(
                   "jdbc:mysql:///firmaveritabani",
                   "katerina","123");
        */ 
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/firmaveritabani", 
                    "katerina", "123");
     //---------------------------------------------	
            if (!con.isClosed()) {
                System.out.println("Veritabanına başarılı olarak bağlandık.");
            } else {
                System.err.println("Veritabanına bağlantı kurulamadı.");
            } 
     //---------------------------------------------	
            PreparedStatement statement =  (PreparedStatement) 
                    con.prepareStatement("SELECT * FROM personel");
         
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
             System.out.println(
                resultSet.getInt(1) + " " + resultSet.getString(2) + " "
                + resultSet.getString(3) + " " + resultSet.getString(4) + " "
                + resultSet.getString(5) + " " + resultSet.getString(6));
            }

        } catch (Exception e) {
             System.out.println("Tüm kayıtlar alınamadı. Hata: " + e);
        } finally {
             System.out.println("Teşekkür ederiz.");
        }
    }
}


