package com.mimaraslan;

import javax.faces.bean.ManagedBean;
import java.sql.*;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name="ub")
@SessionScoped
public class UyeBean {

    private int uyeid;
    private String uyekullaniciadi, uyeparola;
    private String uyeeposta;

    public int getUyeid() {
        return uyeid;
    }

    public void setUyeid(int uyeid) {
        this.uyeid = uyeid;
    }

    public String getUyekullaniciadi() {
        return uyekullaniciadi;
    } 

    public void setUyekullaniciadi(String uyekullaniciadi) {
        this.uyekullaniciadi = uyekullaniciadi;
    }

    public String getUyeparola() {
        return uyeparola;
    }

    public void setUyeparola(String uyeparola) {
        this.uyeparola = uyeparola;
    }

    public String getUyeeposta() {
        return uyeeposta;
    }

    public void setUyeeposta(String uyeeposta) {
        this.uyeeposta = uyeeposta;
    }
    
//-------------------------------------------- 
    

 private String dbuyeparola;
    public String getDbuyeparola() {
        return dbuyeparola;
    }
    
 private String dbuyekullaniciadi;   
    public String getDbuyekullaniciadi() {
        return dbuyekullaniciadi;
    }
    
//--------------------------------------------   
    
Connection con = null;
ResultSet resultSet = null;
PreparedStatement preparedStatement = null;

public void bigileriOnayla(String gelenKullaniciAdi, String gelenParola) {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/firmaveritabani", 
                            "katerina", "123");

String kullaniciGirisSorgusu = "SELECT * FROM uye "
+ "WHERE uyekullaniciadi = ? AND uyeparola = ?";

preparedStatement = con.prepareStatement(kullaniciGirisSorgusu);
preparedStatement.setString(1, gelenKullaniciAdi);
preparedStatement.setString(2, gelenParola);

resultSet =preparedStatement.executeQuery();
            
              if (resultSet.next()) {
                System.err.println("Kullanıcı adı ve parolası doğrulandı.");
               } else {
                System.err.println("Giriş işlemi başarısız!");
               }
            
            dbuyekullaniciadi=resultSet.getString(2).toString();
            dbuyeparola=resultSet.getString(3).toString();
            
     uyeid=resultSet.getInt("uyeid");
     uyekullaniciadi=resultSet.getString("uyekullaniciadi").toString();
     uyeparola=resultSet.getString("uyeparola").toString();
     uyeeposta=resultSet.getString("uyeeposta").toString();
    
        }
        catch(Exception e)
        {
            System.err.println("Hata :" + e);
        }
    }

//--------------------------------------------
    
    public String uyeGirisiniDenetle()
    {
        bigileriOnayla(uyekullaniciadi , uyeparola);

        if(uyekullaniciadi.equalsIgnoreCase(dbuyekullaniciadi)
                && uyeparola.equals(dbuyeparola) ){
                return "gecerli";
        }
        else {
            return "gecersiz";
        }
    }
    
    
     public String uyeCikisiniDenetle(){
     
      FacesContext context = FacesContext.getCurrentInstance(); 
      ExternalContext ec = context.getExternalContext(); 
      final HttpServletRequest request = (HttpServletRequest)ec.getRequest(); 
      request.getSession( false ).invalidate(); 

//FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
       
      return "uyecikisi?faces-redirect=true";
   }
     
}