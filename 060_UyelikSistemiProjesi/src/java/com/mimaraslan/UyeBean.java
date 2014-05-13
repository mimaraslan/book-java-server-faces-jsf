package com.mimaraslan;
 
import java.sql.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name="ub")
@SessionScoped
public class UyeBean {
    
//-------------NESNELERIMIZ------------------------------    
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
    
//-------UYE SORGULAMADA BAZI DEGERLERI TUTAN YARDIMCI NESNELER----- 
 private String dbuyeparola;
    public String getDbuyeparola() {
        return dbuyeparola;
    }
    
 private String dbuyekullaniciadi;   
    public String getDbuyekullaniciadi() {
        return dbuyekullaniciadi;
    }
    
//-----VERITABANI ISLEMLERI ICIN KULLANILACAK OZEL NESNELER---------     
Connection con = null;
ResultSet resultSet = null;
PreparedStatement preparedStatement = null;

//--------------------UYE SORGULAMA METODU------------------------    
public void veriSorgula(String gelenKullaniciAdi, String gelenParola) {
try{
    Class.forName("com.mysql.jdbc.Driver");
  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/firmaveritabani", 
                                  "katerina", "123");
    String kullaniciGirisSorgusu = "SELECT * FROM uye "
       + " WHERE uyekullaniciadi = ? AND uyeparola = ?";

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
        catch(Exception e) {
            System.err.println("Hata :" + e);
        }
    }

//--------------------UYE GIRISINI DENETLE------------------------  
public String uyeGirisiniDenetle(){
    
        veriSorgula(uyekullaniciadi , uyeparola);

        if(uyekullaniciadi.equalsIgnoreCase(dbuyekullaniciadi)
                && uyeparola.equals(dbuyeparola) ){
                return "uyegirisigecerli";
        }
        else {
            return "uyegirisigecersiz";
        }
    }
    
//--------------------UYE CIKISINI DENETLE------------------------     
public String uyeCikisiniDenetle(){
    
      FacesContext context = FacesContext.getCurrentInstance(); 
      ExternalContext ec = context.getExternalContext(); 
      final HttpServletRequest request = (HttpServletRequest)ec.getRequest(); 
      request.getSession( false ).invalidate(); 
//FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

     System.out.println("Tebrikler çıkış işlemi başarılı.");
     return "uyecikisi?faces-redirect=true";
  }
    
//---------YENI KULLANICI EKLEME ICIN OLUSTURULAN NESNELER----------
   String yeniuyekullaniciadi, yeniuyeparola, yeniuyeeposta;

    public String getYeniuyekullaniciadi() {
        return yeniuyekullaniciadi;
    }

    public void setYeniuyekullaniciadi(String yeniuyekullaniciadi) {
        this.yeniuyekullaniciadi = yeniuyekullaniciadi;
    }

    public String getYeniuyeparola() {
        return yeniuyeparola;
    }

    public void setYeniuyeparola(String yeniuyeparola) {
        this.yeniuyeparola = yeniuyeparola;
    }

    public String getYeniuyeeposta() {
        return yeniuyeeposta;
    }

    public void setYeniuyeeposta(String yeniuyeeposta) {
        this.yeniuyeeposta = yeniuyeeposta;
    }
   
//------------------YENI UYE KAYDINI DENETLE--------------------------                    
public String uyeKayidiniDenetle() { 
    
    veriEkle(yeniuyekullaniciadi, yeniuyeparola, yeniuyeeposta);

    veriSorgula(yeniuyekullaniciadi , yeniuyeparola);

       if(yeniuyekullaniciadi.equalsIgnoreCase(dbuyekullaniciadi)
        && yeniuyeparola.equals(dbuyeparola) ){
        return "uyeeklemegecerli";
          }
      else {
       return "uyeeklegecersiz";
          }
    } 

//-------------------YENI UYEYI EKLEME METODU-------------------------                
private void veriEkle(String yeniuyekullaniciadi, 
                      String yeniuyeparola, String yeniuyeeposta) {
String durumbilgisi = "";  
 try {
     Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/firmaveritabani", 
                                "katerina", "123");

     String eklemeSorgusu = ("INSERT INTO uye "
                + "(uyekullaniciadi, uyeparola, uyeeposta) "
                + "VALUES (?,?,?)");

       preparedStatement = con.prepareStatement(eklemeSorgusu);
       preparedStatement.setString(1, yeniuyekullaniciadi );
       preparedStatement.setString(2, yeniuyeparola);
       preparedStatement.setString(3, yeniuyeeposta);

         boolean eklemeDurumu = preparedStatement.execute();
           if (eklemeDurumu == false) {
               durumbilgisi = "Tebrikler ekleme işlemi başarılı.";
           } else {
               durumbilgisi = "Ekleme işlemi başarısız!";
           }                  
     } catch (ClassNotFoundException ex) {
             System.out.println("Hata: " + ex);
     } catch (SQLException e) {
             System.out.println("Hata: " + e);
     }
        System.out.println(durumbilgisi);
}

//------------------UYEYI DUZENLEME METODU--------------------------    
private void veriDuzenle(String uyekullaniciadi, String uyeparola, 
                           String uyeeposta, int uyeid) {
    
 String durumbilgisi = "";  
   try {
        Class.forName("com.mysql.jdbc.Driver");       
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/firmaveritabani", 
                                "katerina", "123");                
             String duzenlemeSorgusu = "UPDATE uye "
                    + "SET uyekullaniciadi     = ? "
                    + ",uyeparola  = ? "
                    + ",uyeeposta  = ? "
                    + " WHERE uyeid = ?";
            preparedStatement = con.prepareStatement(duzenlemeSorgusu);          
            preparedStatement.setString(1, uyekullaniciadi);
            preparedStatement.setString(2, uyeparola);
            preparedStatement.setString(3, uyeeposta);
            preparedStatement.setInt(4, uyeid);
    
           int eklemeDurumu = preparedStatement.executeUpdate();
                if (eklemeDurumu == 1) {
                    durumbilgisi = "Tebrikler kayıt gücellendi.";               
                } else {
                    durumbilgisi = "Kayıt gücellenemedi!";
                }                     
         } catch (Exception e) {
           System.out.println("Hata: " + e);
        }
        System.out.println(durumbilgisi);
    }
    
//--------------------UYE DUZENLEMEYI DENETLEYEN METOD----------------    
  public String uyeDuzenlemeyiDenetle(){
   
    veriDuzenle(uyekullaniciadi, uyeparola, uyeeposta, uyeid);

        veriSorgula(uyekullaniciadi , uyeparola);

    if(uyekullaniciadi.equalsIgnoreCase(dbuyekullaniciadi)
            && uyeparola.equals(dbuyeparola) )
     {
       return "uyeduzenlemegecerli";
     }else {
       return "uyeduzenlemegecersiz";
       }             
   }

 //---------------UYE SILEN METOD-----------------------------     
private void veriSil(int uyeid) {
    
        String durumbilgisi = "";
 try{      
      String silmeSorgusu = "DELETE FROM uye WHERE uyeid = ?";   
      
      preparedStatement = con.prepareStatement(silmeSorgusu);    
      preparedStatement.setInt(1, uyeid);
      
      boolean silmeDurumu =  preparedStatement.execute();
           if (silmeDurumu  == false) {
                durumbilgisi = "Tebrikler silme işlemi başarılı.";
            } else {
                durumbilgisi = "Silme işlemi başarısız!";
            }
        } catch (SQLException e) {
             System.out.println("Hata: " + e);
        }
        System.out.println(durumbilgisi);
    }

//--------------SECILEN UYEYI DENETLEYEN METOD-----------------------        
    public String uyeSilmeyiDenetle(){
  
        veriSil(uyeid);          
        veriSorgula(uyekullaniciadi , uyeparola);
FacesContext.getCurrentInstance().getExternalContext().invalidateSession();      
        return "uyesilmebasarili?faces-redirect=true";
   }      
}