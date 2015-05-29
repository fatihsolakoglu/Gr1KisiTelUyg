
package tr.gov.ptt.gr1kisiteluyg.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import tr.gov.ptt.gr1kisiteluyg.entity.Giris;
import tr.gov.ptt.gr1kisiteluyg.service.GirisService;
import tr.gov.ptt.gr1kisiteluyg.util.JSFUtil;


@ManagedBean
@SessionScoped
public class GirisBean {
    
    private Giris giris;
    @EJB
    private GirisService girisService;
    
    public GirisBean()
    {
        giris=new Giris();
    }

    public Giris getGiris() {
        return giris;
    }

    public void setGiris(Giris giris) {
        this.giris = giris;
    }
    
    public String girisKontrol()
    {
        boolean sonuc=girisService.girisKontrol(giris);
        if(sonuc)
        {
            HttpSession session=JSFUtil.getSession();
            session.setAttribute("username", giris.getAd());
            
            JSFUtil.mesajEkle("Giriş Başarılı.");
            return "menu.xhtml?faces-redirect=true";
        }
        else
        { 
            JSFUtil.hataMesajEkle("Kullanıcı Adı yada Şifre Hatalı");
            return "giris.xhtml?faces-redirect=true";
        }
    }
    
    public String sessionBitir()
    {
        HttpSession session=JSFUtil.getSession();
        session.invalidate();
        return "giris.xhtml?faces-redirect=true";
    }
    
}
