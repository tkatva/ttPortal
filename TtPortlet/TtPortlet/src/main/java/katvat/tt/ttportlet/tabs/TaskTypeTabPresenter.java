

package katvat.tt.ttportlet.tabs;

import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;
import java.util.List;
import katvat.tt.dao.service.VatTaskTypeService;
import katvat.tt.model.TaskType;
import katvat.tt.model.ValueAddedTax;
import katvat.tt.ttportlet.helper.I18N;
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
    private VatTaskTypeService ttDao;
    
    
    private TaskTypeTab presenterView;
    
    public TaskTypeTabPresenter() {
        
    }
    
    public void setView(TaskTypeTab tab) {
        presenterView = tab;
    }
    
    protected final Logger log = LoggerFactory.getLogger(getClass());
    
    public void loadTableData() {
        
        presenterView.setTableData(convertModelToBeanItem(getTtDao().findAllVats()));
    }
    
    private boolean checkIfVatIsUsed(ValueAddedTax vat) {
        List<TaskType> types = getTtDao().getVatTaskTypes(vat);
        if (types != null && types.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public void removeVat(ValueAddedTax vat) {
        
        if (!checkIfVatIsUsed(vat)) {
        ttDao.removeValueAddedTax(vat);
        presenterView.removeVatFromTable(vat);
        presenterView.removeVatEditWindow();
        } else {
        presenterView.removeVatEditWindow();
        presenterView.showErrorMessage(I18N.getMessage("VatEdit.save.vat.used"));
        }
    }
    
    public void saveVat(ValueAddedTax vat)  {
        getTtDao().saveValueAddedTax(vat);
        presenterView.removeVatFromTable(vat);
        presenterView.addVatToTable(vat);
        presenterView.removeVatEditWindow();
        presenterView.showMessage(I18N.getMessage("VatEdit.save.ok.msg"));
        
    }
    
    public void cancelVatSave() {
        presenterView.removeVatEditWindow();
    }
    
    private BeanItemContainer<ValueAddedTax> convertModelToBeanItem(List<ValueAddedTax> vats) {
        BeanItemContainer<ValueAddedTax> container = new BeanItemContainer<ValueAddedTax>(ValueAddedTax.class);
        
        for (ValueAddedTax vat:vats) {
            
            container.addBean(vat);
        }
        
        return container;
    }

    /**
     * @return the ttDao
     */
    public VatTaskTypeService getTtDao() {
        return ttDao;
    }

    /**
     * @param ttDao the ttDao to set
     */
    public void setTtDao(VatTaskTypeService ttDao) {
        this.ttDao = ttDao;
    }
    
}
