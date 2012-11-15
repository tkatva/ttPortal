

package katvat.tt.ttportlet.tabs;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import java.util.List;
import javax.annotation.PostConstruct;
import katvat.tt.ttportlet.helper.I18N;
import katvat.tt.dao.service.VatTaskTypeDao;
import katvat.tt.model.ValueAddedTax;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Override
    public void attach() {
        super.attach();

        panel.addComponent(buildVatTable());
        getPresenter().setView(this);
       
    }
    
    
    
    public TaskTypeTab() {
        rootLayout = new VerticalLayout();
        panel = new Panel();
        
        rootLayout.addComponent(panel);
        setCompositionRoot(rootLayout);
    }
   

   
    private VerticalLayout buildVatTable() {
        VerticalLayout vatTableLayout = new VerticalLayout();
        vatTableLayout.setSizeUndefined();
        Button loadData = new Button(I18N.getMessage("TaskTypeTab.vat.load"));
        loadData.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                getPresenter().loadTableData();
            }
        });
        vatTableLayout.addComponent(loadData);
        vatTable = new Table(I18N.getMessage("TaskTypeTab.vat.table.title"));
        vatTable.setHeight("200px");
        vatTable.setWidth("500px");
        
        setColumnNames();
        //TODO
        Button newVatButton = new Button(I18N.getMessage("TaskTypeTab.vat.new.vat"));
        vatTableLayout.addComponent(vatTable);
        vatTableLayout.addComponent(newVatButton);
        
        
        return vatTableLayout;
    }
    
    public void setTableData(BeanItemContainer<ValueAddedTax> vats) {
        vatTable.setContainerDataSource(vats);
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
