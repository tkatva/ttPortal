

package katvat.tt.ttportlet.tabs;

import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;
import java.util.List;
import katvat.tt.dao.service.VatTaskTypeDao;
import katvat.tt.model.ValueAddedTax;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

/**
 *
 * @author Tuomas Katva
 */
@Component
public class TaskTypeTabPresenter implements Serializable{

    @Autowired(required=true)
    private VatTaskTypeDao ttDao;
    
    
    private TaskTypeTab presenterView;
    
    public TaskTypeTabPresenter() {
        
    }
    
    public void setView(TaskTypeTab tab) {
        presenterView = tab;
    }
    
    protected final Logger log = LoggerFactory.getLogger(getClass());
    
    public void loadTableData() {
        log.warn("DAO " + getTtDao());
        presenterView.setTableData(convertModelToBeanItem(getTtDao().findAllVats()));
    }
    
    private BeanItemContainer<ValueAddedTax> convertModelToBeanItem(List<ValueAddedTax> vats) {
        BeanItemContainer<ValueAddedTax> container = new BeanItemContainer<ValueAddedTax>(ValueAddedTax.class);
        
        for (ValueAddedTax vat:vats) {
            log.warn("FOUND VAT : " + vat.getVatCode());
            container.addBean(vat);
        }
        
        return container;
    }

    /**
     * @return the ttDao
     */
    public VatTaskTypeDao getTtDao() {
        return ttDao;
    }

    /**
     * @param ttDao the ttDao to set
     */
    public void setTtDao(VatTaskTypeDao ttDao) {
        this.ttDao = ttDao;
    }
    
}
