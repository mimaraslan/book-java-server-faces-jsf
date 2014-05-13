import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class OdemeController implements Serializable {

    private static final long serialVersionUID = 1L;
    public boolean siparisOnayi = false;
    public int siparisToplam = 50;

    public boolean isSiparisOnayi() {
        return siparisOnayi;
    }

    public void setSiparisOnayi(boolean siparisOnayi) {
        this.siparisOnayi = siparisOnayi;
    }

    public int getSiparisToplam() {
        return siparisToplam;
    }

    public void setSiparisToplam(int siparisToplam) {
        this.siparisToplam = siparisToplam;
    }

    public String odemeAc() {
        siparisToplam = this.getSiparisToplam();
        return "odeme"; //outcome çıkış
    }

    public String siparisAc() {
        return "siparis"; //outcome çıkış
    }

    public String urunlerAc() {
        return "urunler"; //outcome çıkış
    }

    public String uyeolAc() {
        return "uyeol"; //outcome çıkış
    }

    public OdemeController() {
    }
}
