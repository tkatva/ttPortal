

package katvat.tt.ttportlet.windows;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import java.util.List;
import java.util.Vector;
import katvat.tt.dao.service.VatTaskTypeService;
import katvat.tt.model.ValueAddedTax;
import katvat.tt.ttportlet.event.WindowClickEvent;
import katvat.tt.ttportlet.helper.I18N;
import katvat.tt.ttportlet.listeners.WindowListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;


/**
 *
 * @author Tuomas Katva
 */
@Configurable
public class VatAddWindow extends CustomComponent{

    @Autowired
    VatTaskTypeService ttDao;
    Form vatAddForm;
    
    ValueAddedTax currentVat;
    
    private List<WindowListener> listeners;
    
    public VatAddWindow() {
        vatAddForm = new Form();
        setData(new ValueAddedTax());
        vatAddForm.setVisibleItemProperties(buildVisibleFields());
        setFieldCaptions();
        vatAddForm.getFooter().addComponent(buildButtonBar());
    }
    
    private HorizontalLayout buildButtonBar() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        Button saveButton = new Button(I18N.getMessage("TaskTypeTab.vat.save"));
        saveButton.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                vatAddForm.commit();
                callListeners(new WindowClickEvent(WindowClickEvent.ClickEvent.SAVE));
            }
        });
        return buttonLayout;
    }
    
    private void setFieldCaptions() {
        vatAddForm.getField("vatName").setCaption(I18N.getMessage("TaskTypeTab.vat.table.vatName"));
        vatAddForm.getField("vatCode").setCaption(I18N.getMessage("TaskTypeTab.vat.table.vatCode"));
        vatAddForm.getField("vatPercent").setCaption(I18N.getMessage("TaskTypeTab.vat.table.vatPercent"));
    }
    
    private Vector buildVisibleFields() {
        Vector visibleFields = new Vector();
        visibleFields.add("vatName");
        visibleFields.add("vatCode");
        visibleFields.add("vatPercent");
        return visibleFields;
    }
    
    public void setData(ValueAddedTax vat) {
        if (vatAddForm != null) {
            currentVat = vat;
            BeanItem<ValueAddedTax> beanItem = new BeanItem<ValueAddedTax>(vat);
            vatAddForm.setItemDataSource(beanItem);
        }
    }
    
    private void callListeners(WindowClickEvent event) {
        for (WindowListener listener:listeners) {
            listener.WindowClicked(event);
        }
    }
    
    public void addWindowListener(WindowListener listener) {
        listeners.add(listener);
    }
    
}
