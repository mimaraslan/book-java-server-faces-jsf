package com.mimaraslan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class JDBCBaglantisi4_Delete {

    static Connection con = null;
    //---------------------------------------------	
    public static Connection veritabaninaBaglantiKur() {
 
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/firmaveritabani", 
                    "katerina", "123");

           if (!con.isClosed()) {
                System.out.println("Veritabanına başarılı olarak bağlandık.");
            } else {
                System.err.println("Veritabanına bağlantı kurulamadı.");
            }
            return con;

        } catch (Exception e) {
            System.out.println("Bağlantı kurulma hatası: " + e.getMessage());
            return null;
        }finally {
                System.out.println("Teşekkür ederiz.");
        }
    }
    //---------------------------------------------	
    public String veriOku() {
        veritabaninaBaglantiKur();
        String personelBilgisi = "";
        try {
            PreparedStatement statement =
                    (PreparedStatement) 
                    con.prepareStatement("SELECT * FROM personel");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
              System.out.println(
                  resultSet.getInt(1)    + " " + resultSet.getString(2) + " "
                + resultSet.getString(3) + " " + resultSet.getString(4) + " "
                + resultSet.getString(5) + " " + resultSet.getString(6));

            personelBilgisi = personelBilgisi + "&" 
               + resultSet.getInt(1)     + "&" + resultSet.getString(2)  + " "
               + resultSet.getString(3)  + "&" + resultSet.getString(4)  + "&"
               + resultSet.getString(5)  + " " + resultSet.getString(6);
            }

        } catch (SQLException e) {
             System.out.println("Hata: " + e);
        }
        return personelBilgisi;
    }
 
//---------------------------------------------	
    public void veriEkle(String personeladi, String personelsoyadi,
                           String personeleposta, String personelgorevi, 
                           String personelmaasi) {
        
        veritabaninaBaglantiKur();
        String durumbilgisi = "";
        try {        
              String eklemeSorgusu = ("INSERT INTO personel "
                    + "(personeladi, personelsoyadi, "
                    + "personeleposta, personelgorevi, personelmaasi) "
                    + "VALUES (?,?,?,?,?)");
    
PreparedStatement  preparedStatement = con.prepareStatement(eklemeSorgusu);
            preparedStatement.setString(1, personeladi);
            preparedStatement.setString(2, personelsoyadi);
            preparedStatement.setString(3, personeleposta);
            preparedStatement.setString(4, personelgorevi);
            preparedStatement.setString(5, personelmaasi);
            boolean resultSet = preparedStatement.execute();
            if (resultSet) {
                durumbilgisi = "Tebrikler ekleme işlemi başarılı.";
            } else {
                durumbilgisi = "Ekleme işlemi başarısız!";
            }
        } catch (SQLException e) {
             System.out.println("Hata: " + e);
        }
        System.out.println(durumbilgisi);
    }
//---------------------------------------------	

   public void veriDuzenle(String personeladi, String personelsoyadi,
                           String personeleposta, String personelgorevi, 
                           String personelmaasi, String personelid) {
        veritabaninaBaglantiKur();
        String durumbilgisi = "";
        try {
            String duzenlemeSorgusu = "UPDATE personel "
                    + "SET personeladi     = ? "
                    + ",personelsoyadi  = ? "
                    + ",personeleposta  = ? "
                    + ",personelgorevi  = ? "
                    + ",personelmaasi   = ? "
                    + " WHERE personelid = ?";
PreparedStatement preparedStatement = con.prepareStatement(duzenlemeSorgusu);          
            preparedStatement.setString(1, personeladi);
            preparedStatement.setString(2, personelsoyadi);
            preparedStatement.setString(3, personeleposta);
            preparedStatement.setString(4, personelgorevi);
            preparedStatement.setString(5, personelmaasi);
            preparedStatement.setString(6, personelid);

             int resultSet =  preparedStatement.executeUpdate();
             if (resultSet == 1) {
                durumbilgisi = resultSet + " Kayıt Gücellendi.";               
            } else {
                durumbilgisi = "Gücellenemedi!";
            }  
        } catch (Exception e) {
           System.out.println("Hata: " + e);
        }
        System.out.println(durumbilgisi);
    }  
   
//---------------------------------------------	
   
 public void veriSil(int personelid) {
     veritabaninaBaglantiKur();
    String durumbilgisi = "";
    try {      
      String silmeSorgusu = "DELETE FROM personel WHERE personelid = ?";   
      
      PreparedStatement preparedStatement = con.prepareStatement(silmeSorgusu);    
      preparedStatement.setInt(1, personelid);
      
      boolean resultSet =  preparedStatement.execute();
           if (resultSet) {
                durumbilgisi = "Silme işlemi başarısız!";
            } else {
                durumbilgisi = "Tebrikler silme işlemi başarılı.";
            }
        } catch (SQLException e) {
             System.out.println("Hata: " + e);
        }
        System.out.println(durumbilgisi);
    }
//---------------------------------------------	
    public static void main(String args[]) {
        JDBCBaglantisi4_Delete nesne = new JDBCBaglantisi4_Delete();
        nesne.veriOku();            
//---------------------------------------------			 
        nesne.veriSil(3);
//---------------------------------------------	
        nesne.veriOku();      
    }  
}













