

package katvat.tt.ttportlet.tabs;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import katvat.tt.ttportlet.helper.I18N;
import katvat.tt.model.ValueAddedTax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
/**
 *
 * @author Tuomas Katva
 */
@Configurable(preConstruction=true)
public class TaskTypeTab extends CustomComponent {
    
    

    VerticalLayout rootLayout;
    
    Panel panel;
    
    Table vatTable;
    
    @Autowired(required=true)
    private TaskTypeTabPresenter presenter;
    
    private Window vatAddWindow;

    @Override
    public void attach() {
        super.attach();

        panel.addComponent(buildVatTable());
        getPresenter().setView(this);
        getPresenter().loadTableData();
    }
    
    
    
    public TaskTypeTab() {
        rootLayout = new VerticalLayout();
        panel = new Panel();
        
        rootLayout.addComponent(panel);
        setCompositionRoot(rootLayout);
    }
   
    public void addVatToTable(ValueAddedTax vat) {
        vatTable.getContainerDataSource().addItem(vat);
    }

   
    private VerticalLayout buildVatTable() {
        VerticalLayout vatTableLayout = new VerticalLayout();
        vatTableLayout.setSizeUndefined();
        
        
        vatTable = new Table(I18N.getMessage("TaskTypeTab.vat.table.title"));
        vatTable.setHeight("200px");
        vatTable.setWidth("500px");
        
        setColumnNames();
        //TODO
        Button newVatButton = new Button(I18N.getMessage("TaskTypeTab.vat.new.vat"));
        newVatButton.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                vatAddWindow = new Window();
                VatEditForm vatEdit = new VatEditForm(new ValueAddedTax());
                vatAddWindow.addComponent(vatEdit);
                vatEdit.setSizeUndefined();
                getWindow().addWindow(vatAddWindow);
                
            }
        });
        vatTableLayout.addComponent(vatTable);
        vatTableLayout.addComponent(newVatButton);
        
        
        return vatTableLayout;
    }
    
    public void setTableData(BeanItemContainer<ValueAddedTax> vats) {
        vatTable.setContainerDataSource(vats);
    }
    
    public void showMessage(String msg) {
        getWindow().showNotification(msg);
    }
    
    public void removeVatEditWindow() {
        if (vatAddWindow != null) {
            getWindow().removeWindow(vatAddWindow);
        }
    }
    
    private void setColumnNames() {
        vatTable.setColumnHeader("vatName", I18N.getMessage("TaskTypeTab.vat.table.vatName"));
        vatTable.setColumnHeader("vatCode", I18N.getMessage("TaskTypeTab.vat.table.vatCode"));
        vatTable.setColumnHeader("TaskTypeTab.vat.table.vatPercent", I18N.getMessage("TaskTypeTab.vat.table.vatPercent"));
    }

    /**
     * @return the presenter
     */
    public TaskTypeTabPresenter getPresenter() {
       
        return presenter;
    }

    /**
     * @param presenter the presenter to set
     */
    public void setPresenter(TaskTypeTabPresenter presenter) {
        this.presenter = presenter;
    }
    
    
    
}
