

package katvat.tt.ttportlet.tabs;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import katvat.tt.ttportlet.helper.I18N;
import katvat.tt.dao.service.SettingService;
import katvat.tt.model.SettingGroup;
/**
 *
 * @author Tuomas Katva
 */

@Component
public class SettingPresenter {

    @Autowired(required=true)
    SettingService settingService;
    
    private SettingTab settingView;
    
    public SettingPresenter() {
       
    }
    
    public void saveSettingGroup(SettingGroup settingGroup) {
        settingService.saveSettingGroup(settingGroup);
        loadSettingGroups();
        settingView.removeSettingGroupWindow();
        settingView.showMessage(I18N.getMessage("SettingGroupEditForm.saveOk"));
    }
    
    public void deleteSettingGroup(SettingGroup settingGroup) {
        settingService.removeSettingGroup(settingGroup);
        settingView.removeSettingGroupWindow();
    }
    
    public void cancelSettingGroupEdit() {
        settingView.removeSettingGroupWindow();
    }
    
    public void loadSettingGroups() {
        settingView.setSettingGroupComboData(settingService.getSettingGroups());
    }
    
    public void setView(SettingTab view) {
        settingView = view;
    }
    
    
}
