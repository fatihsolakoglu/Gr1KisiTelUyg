
package tr.gov.ptt.gr1kisiteluyg.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import tr.gov.ptt.gr1kisiteluyg.entity.Kisi;
import tr.gov.ptt.gr1kisiteluyg.entity.Telefon;
import tr.gov.ptt.gr1kisiteluyg.service.KisiService;



@ManagedBean
@RequestScoped
public class KisiBean {
    
 private Kisi kisi;
 private Telefon evTel;
 private Telefon cepTel;
 
 @EJB
 private KisiService kisiService;
 
 public KisiBean() {
        kisi=new Kisi();
        evTel=new Telefon();
        cepTel=new Telefon();
        cepTel.setTur("CEP");
    }
 
 

    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    public Telefon getEvTel() {
        return evTel;
    }

    public void setEvTel(Telefon evTel) {
        this.evTel = evTel;
    }

    public Telefon getCepTel() {
        return cepTel;
    }

    public void setCepTel(Telefon cepTel) {
        this.cepTel = cepTel;
    }

    
    public String kisiEkle()
    {
        List<Telefon> telefonListe=new ArrayList<Telefon>();
        telefonListe.add(evTel);
        telefonListe.add(cepTel);
        
        kisi.setTelefonList(telefonListe);
        evTel.setKisi(kisi);
        cepTel.setKisi(kisi);
        
        kisiService.kisiEkle(kisi);
        return "kisiListele.xhtml?faces-redirect=true";
    }
    
}
