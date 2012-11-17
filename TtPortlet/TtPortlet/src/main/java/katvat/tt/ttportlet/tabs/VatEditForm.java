

package katvat.tt.ttportlet.tabs;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import katvat.tt.model.ValueAddedTax;
import katvat.tt.ttportlet.helper.I18N;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.vaadin.addon.formbinder.FormFieldMatch;
import org.vaadin.addon.formbinder.FormView;
import org.vaadin.addon.formbinder.PropertyId;
import org.vaadin.addon.formbinder.ViewBoundForm;
/**
 *
 * @author Tuomas Katva
 */
@FormView(matchFieldsBy = FormFieldMatch.ANNOTATION)
@Configurable(preConstruction = true)
public class VatEditForm extends CustomComponent {

    @PropertyId("vatName")
    private TextField vatName;
    @PropertyId("vatCode")
    private TextField vatCode;
    @PropertyId("vatPercent")
    private TextField vatPercent;
    
    
    @Autowired(required=true)
    private TaskTypeTabPresenter presenter;
    
    Button saveBtn;
    Button deleteBtn;
    Button cancelBtn;
    
    private ValueAddedTax model;
    private Form form;
    VerticalLayout rootLayout;
    
    public VatEditForm(ValueAddedTax vat) {
        model = vat;
        buildLayout();
        initForm();
    }
    
    private void buildLayout() {
        rootLayout = new VerticalLayout();
        
        vatName = new TextField();
        vatName.setNullRepresentation("");
        vatName.setCaption(I18N.getMessage("VatEditForm.vatNameLabel"));
        rootLayout.addComponent(vatName);
        
        vatCode = new TextField();
        vatCode.setNullRepresentation("");
        vatCode.setCaption(I18N.getMessage("VatEditForm.vatCodeLabel"));
        rootLayout.addComponent(vatCode);
        
        vatPercent = new TextField();
        vatPercent.setCaption(I18N.getMessage("VatEditForm.vatPercentLabel"));
        rootLayout.addComponent(vatPercent);
        
        HorizontalLayout btnLayout = new HorizontalLayout();
        btnLayout.setSpacing(true);

        saveBtn = new Button(I18N.getMessage("VatEditForm.saveBtn"));
        deleteBtn = new Button(I18N.getMessage("VatEditForm.deleteBtn"));
        cancelBtn = new Button(I18N.getMessage("VatEditForm.cancelBtn"));
        btnLayout.addComponent(saveBtn);
        btnLayout.addComponent(deleteBtn);
        btnLayout.addComponent(cancelBtn);
        rootLayout.addComponent(btnLayout);
        buildListeners();
        disableOrEnableFields();
        setCompositionRoot(rootLayout);
    }
    
    private void disableOrEnableFields() {
        if (model != null && model.getVatId() != null) {
            deleteBtn.setVisible(true);
        } else {
            deleteBtn.setVisible(false);
        }
    }
    
    private void buildListeners() {
        saveBtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                form.commit();
                if (form.isValid()) {
                presenter.saveVat(model);
                }
            }
        });
        
        deleteBtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                presenter.removeVat(model);
            }
        });
        
        cancelBtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                presenter.cancelVatSave();
            }
        });
    }
    
    private void initForm() {
        BeanItem<ValueAddedTax> bean = new BeanItem<ValueAddedTax>(model);
        form = new ViewBoundForm(this);
        form.setItemDataSource(bean);
    }
}
