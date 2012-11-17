

package katvat.tt.ttportlet.tabs;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import katvat.tt.model.SettingGroup;
import katvat.tt.ttportlet.helper.I18N;
/**
 *
 * @author Tuomas Katva
 */

public class SettingTab extends CustomComponent{

    private VerticalLayout rootLayout;
    private Panel panel;
    private Button addSettingGroupBtn;
    private ComboBox settingGroupCombo;
    
    public SettingTab() {
        
    }
    
    @Override
    public void attach() {
        super.attach();
        buildRootLayout();
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
    
    public void setSettingGroupComboContainer(BeanItemContainer<SettingGroup> settingGroups) {
        if (settingGroupCombo != null) {
            settingGroupCombo.setContainerDataSource(settingGroups);
        }
    }
    
    private HorizontalLayout buildButtonLayout() {
        HorizontalLayout btnLayout = new HorizontalLayout();
        
        addSettingGroupBtn = new Button(I18N.getMessage("SettingTab.addSettingGroupBtn.title"));
        btnLayout.addComponent(addSettingGroupBtn);
        
        return  btnLayout;
    }
    
    private void constructButtonListeners() {
        
    }
    
}
