

package katvat.tt.ttportlet.tabs.forms;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import katvat.tt.model.SettingGroup;
import katvat.tt.ttportlet.helper.I18N;
import org.springframework.beans.factory.annotation.Configurable;
import org.vaadin.addon.formbinder.FormFieldMatch;
import org.vaadin.addon.formbinder.FormView;
import katvat.tt.ttportlet.tabs.SettingPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.addon.formbinder.PropertyId;
import org.vaadin.addon.formbinder.ViewBoundForm;

/**
 *
 * @author Tuomas Katva
 */
@FormView(matchFieldsBy = FormFieldMatch.ANNOTATION)
@Configurable(preConstruction = true)
public class SettingGroupEditForm extends CustomComponent {

    @Autowired(required=true)
    private SettingPresenter settingPresenter;
    @PropertyId("settingGroupName")
    private TextField settingGroupName;
    @PropertyId("settingGroupDescription")
    private TextArea settingGroupTextArea;
    
    private VerticalLayout rootLayout;
    private Form form;
    
    private Button saveBtn;
    private Button deleteBtn;
    private Button cancelBtn;
    
    private SettingGroup model;
    
    public SettingGroupEditForm(SettingGroup param) {
        model = param;
        buildLayout();
        inintForm();
        addButtonListeners();
        checkForIsUpdating();
    }
    
    private void buildLayout() {
        rootLayout = new VerticalLayout();
        
        settingGroupName = new TextField(I18N.getMessage("SettingGroupEditForm.settingGroupName.title"));
        settingGroupName.setNullRepresentation("");
        rootLayout.addComponent(settingGroupName);
        settingGroupTextArea = new TextArea(I18N.getMessage("SettingGroupEditForm.settingGroupDesc.title"));
        settingGroupTextArea.setNullRepresentation("");
        rootLayout.addComponent(settingGroupTextArea);
        rootLayout.addComponent(buildButtonLayout());
        setCompositionRoot(rootLayout);
    }
    
    private void checkForIsUpdating() {
        if (model != null) {
            if (model.getSettingGroupId() != null) {
                deleteBtn.setVisible(true);
            } else {
                deleteBtn.setVisible(false);
            }
        }
    }

    private void addButtonListeners() {
        saveBtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                settingPresenter.saveSettingGroup(model);
            }
        });
        
        deleteBtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                settingPresenter.deleteSettingGroup(model);
            }
        });
        
        cancelBtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                settingPresenter.cancelSettingGroupEdit();
            }
        });
    }
    
    private HorizontalLayout buildButtonLayout() {
        HorizontalLayout btnLayout = new HorizontalLayout();
        btnLayout.setSpacing(true);
        saveBtn = new Button(I18N.getMessage("SettingGroupEditForm.saveBtn"));
        btnLayout.addComponent(saveBtn);
        deleteBtn = new Button(I18N.getMessage("SettingGroupEditForm.deleteBtn"));
        btnLayout.addComponent(deleteBtn);
        cancelBtn = new Button(I18N.getMessage("SettingGroupEditForm.cancelBtn"));
        btnLayout.addComponent(cancelBtn);
        return btnLayout;
    }
    
    private void inintForm() {
        BeanItem<SettingGroup> modelBean = new BeanItem<SettingGroup>(model);
        form = new ViewBoundForm(this);
        form.setItemDataSource(modelBean);
    }

    /**
     * @return the settingPresenter
     */
    public SettingPresenter getSettingPresenter() {
        return settingPresenter;
    }

    /**
     * @param settingPresenter the settingPresenter to set
     */
    public void setSettingPresenter(SettingPresenter settingPresenter) {
        this.settingPresenter = settingPresenter;
    }
}
