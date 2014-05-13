
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class SayfaKontrolcusu implements Serializable {

    private static final long serialVersionUID = 1L;

    public String gitSayfa1() {
        return "basarili";
    }

    public String gitSayfa2() {
        return "basarili";
    }

    public String gitSayfa3() {
        return "olumlu";
    }

    public SayfaKontrolcusu() {
    }
}
