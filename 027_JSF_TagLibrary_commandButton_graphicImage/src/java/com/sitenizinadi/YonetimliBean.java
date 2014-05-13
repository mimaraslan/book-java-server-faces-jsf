package com.sitenizinadi;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
@ManagedBean(name="yb")
@SessionScoped
public class YonetimliBean {

 public String yonelenilecekSayfaGit(){
     
		return "sayfa2";
                
	}
}
 
