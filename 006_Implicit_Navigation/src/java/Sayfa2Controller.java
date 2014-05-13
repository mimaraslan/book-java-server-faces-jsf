
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Sayfa2Controller implements Serializable {

    public String sayfa2yiAc() {
        return "sayfa2"; //outcome çıkış
    }

    public Sayfa2Controller() {
    }
}

