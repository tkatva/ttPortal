
package katvat.tt.dao.service;

import java.util.List;
import katvat.tt.model.Setting;
import katvat.tt.model.SettingGroup;
/**
 *
 * @author Tuomas Katva
 */
public interface SettingService {

    void saveSettingGroup(SettingGroup settingGroup); 
    
    void saveSetting(Setting setting);
    
    void removeSetting(Setting setting);
    
    void removeSettingGroup(SettingGroup settingGroup);
    
    List<SettingGroup> getSettingGroups();
    
    List<Setting> findSettingGroupSetting(SettingGroup settingGroup);
    
    List<Setting> findSettingsWithName(String settingName);
    
    
}
