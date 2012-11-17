

package katvat.tt.ttportlet.tabs;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import java.util.List;
import katvat.tt.model.SettingGroup;
import katvat.tt.ttportlet.helper.I18N;
import katvat.tt.ttportlet.tabs.forms.SettingGroupEditForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
/**
 *
 * @author Tuomas Katva
 */
@Configurable(preConstruction = true)
public class SettingTab extends CustomComponent{

    private VerticalLayout rootLayout;
    private Panel panel;
    private Button addSettingGroupBtn;
    private ComboBox settingGroupCombo;
    
    @Autowired(required=true)
    private SettingPresenter presenter;
    
    private Window settingGroupEditWindow;
    
    public SettingTab() {
        
    }
    
    @Override
    public void attach() {
        super.attach();
        buildRootLayout();
        presenter.setView(this);
        constructButtonListeners();
        presenter.loadSettingGroups();
    }
    
    
    private void buildRootLayout() {
        rootLayout = new VerticalLayout();
        
        panel = new Panel(I18N.getMessage("SettingTab.panel.title"));
        rootLayout.addComponent(panel);
        settingGroupCombo = new ComboBox("SettingTab.settingGroupCombo");
        panel.addComponent(settingGroupCombo);
        
        rootLayout.addComponent(buildButtonLayout());
        setCompositionRoot(rootLayout);
    }
    
    public void showMessage(String msg) {
        getWindow().showNotification(msg);
    }
    
    public void setSettingGroupComboData(List<SettingGroup> settingGroupsParam) {
        BeanItemContainer<SettingGroup> settingGroups;
        settingGroups = new BeanItemContainer<SettingGroup>(settingGroupsParam);
        
        if (settingGroupCombo != null) {
            settingGroupCombo.removeAllItems();
            settingGroupCombo.setContainerDataSource(settingGroups);
            settingGroupCombo.setItemCaptionPropertyId("settingGroupName");
        }
    }
    
    private HorizontalLayout buildButtonLayout() {
        HorizontalLayout btnLayout = new HorizontalLayout();
        
        addSettingGroupBtn = new Button(I18N.getMessage("SettingTab.addSettingGroupBtn.title"));
        btnLayout.addComponent(addSettingGroupBtn);
        
        return  btnLayout;
    }
    
    private void showSettingGroupEditDialog(SettingGroup settingGroup) {
        settingGroupEditWindow = new Window();
        SettingGroupEditForm settingGroupEditForm = new SettingGroupEditForm(settingGroup);
        settingGroupEditWindow.getContent().setSizeUndefined();
        getWindow().addWindow(settingGroupEditWindow);
        settingGroupEditWindow.addComponent(settingGroupEditForm);
    }
    
    private void constructButtonListeners() {
        addSettingGroupBtn.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                showSettingGroupEditDialog(new SettingGroup());
            }
        });
    }
    
    public void removeSettingGroupWindow() {
        if (settingGroupEditWindow != null) {
            getWindow().removeWindow(settingGroupEditWindow);
        }
    }

    /**
     * @return the presenter
     */
    public SettingPresenter getPresenter() {
        return presenter;
    }

    /**
     * @param presenter the presenter to set
     */
    public void setPresenter(SettingPresenter presenter) {
        this.presenter = presenter;
    }
    
}
