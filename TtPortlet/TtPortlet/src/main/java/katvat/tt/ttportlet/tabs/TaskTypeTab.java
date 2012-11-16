package katvat.tt.ttportlet.tabs;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
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
@Configurable(preConstruction = true)
public class TaskTypeTab extends CustomComponent {

    VerticalLayout rootLayout;
    Panel panel;
    Table vatTable;
    @Autowired(required = true)
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
    
     public void removeVatFromTable(ValueAddedTax vat) {
        vatTable.getContainerDataSource().removeItem(vat);
    }


    private VerticalLayout buildVatTable() {
        VerticalLayout vatTableLayout = new VerticalLayout();
        vatTableLayout.setSizeUndefined();


        vatTable = new Table(I18N.getMessage("TaskTypeTab.vat.table.title"));
        vatTable.setHeight("200px");
        vatTable.setWidth("500px");
        vatTable.setSelectable(true);
        vatTable.setImmediate(true);

        setColumnNames();

        //TODO
        Button newVatButton = new Button(I18N.getMessage("TaskTypeTab.vat.new.vat"));
        newVatButton.addListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                showVatEditWindow(new ValueAddedTax());
            }
        });
        vatTableLayout.addComponent(vatTable);
        vatTableLayout.addComponent(newVatButton);
        configureTableListeners();

        return vatTableLayout;
    }

    private void showVatEditWindow(ValueAddedTax vat) {
        vatAddWindow = new Window();
        VatEditForm vatEdit = new VatEditForm(vat);
        vatAddWindow.getContent().setSizeUndefined();
        getWindow().addWindow(vatAddWindow);
        vatAddWindow.addComponent(vatEdit);
    }
    
   public void setTableData(BeanItemContainer<ValueAddedTax> vats) {
        vatTable.setContainerDataSource(vats);
        setVisibleColumns();
    }

    public void showMessage(String msg) {
        getWindow().showNotification(msg);
        
    }
    
    public void showErrorMessage(String msg) {
        getWindow().showNotification(msg, Window.Notification.TYPE_ERROR_MESSAGE);
    }

    public void removeVatEditWindow() {
        if (vatAddWindow != null) {
            getWindow().removeWindow(vatAddWindow);
        }
    }

    private void configureTableListeners() {
        if (vatTable != null) {
            vatTable.addListener(new Property.ValueChangeListener() {
                public void valueChange(ValueChangeEvent event) {
                    if(vatTable.getValue() != null) {
                    showVatEditWindow((ValueAddedTax) vatTable.getValue());
                    }
                }
            });
        }
    }

    private void setColumnNames() {

        vatTable.setColumnHeader("vatName", I18N.getMessage("TaskTypeTab.vat.table.vatName"));
        vatTable.setColumnHeader("vatCode", I18N.getMessage("TaskTypeTab.vat.table.vatCode"));
        vatTable.setColumnHeader("vatPercent", I18N.getMessage("TaskTypeTab.vat.table.vatPercent"));
    }

    private void setVisibleColumns() {
        vatTable.setVisibleColumns(new Object[]{"vatName", "vatCode", "vatPercent"});
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
