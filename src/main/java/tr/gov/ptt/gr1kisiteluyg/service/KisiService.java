
package tr.gov.ptt.gr1kisiteluyg.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.gr1kisiteluyg.FACADE.KisiFacade;
import tr.gov.ptt.gr1kisiteluyg.entity.Kisi;

@Stateless
public class KisiService {
    
    @EJB
    private KisiFacade kisiFacade;
    
    public void kisiEkle(Kisi p_kisi)
    {
        kisiFacade.create(p_kisi);
    }
}
