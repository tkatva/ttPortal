

package katvat.tt.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Tuomas Katva
 */
@Entity
public class SettingGroup implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long settingGroupId;
    
    private String settingGroupName;
    
    private String settingGroupDescription;
    
    @OneToMany
    private List<Setting> settings;

    /**
     * @return the settingGroupId
     */
    public Long getSettingGroupId() {
        return settingGroupId;
    }

    /**
     * @param settingGroupId the settingGroupId to set
     */
    public void setSettingGroupId(Long settingGroupId) {
        this.settingGroupId = settingGroupId;
    }

    /**
     * @return the settingGroupName
     */
    public String getSettingGroupName() {
        return settingGroupName;
    }

    /**
     * @param settingGroupName the settingGroupName to set
     */
    public void setSettingGroupName(String settingGroupName) {
        this.settingGroupName = settingGroupName;
    }

    /**
     * @return the settingGroupDescription
     */
    public String getSettingGroupDescription() {
        return settingGroupDescription;
    }

    /**
     * @param settingGroupDescription the settingGroupDescription to set
     */
    public void setSettingGroupDescription(String settingGroupDescription) {
        this.settingGroupDescription = settingGroupDescription;
    }

    /**
     * @return the settings
     */
    public List<Setting> getSettings() {
        return settings;
    }

    /**
     * @param settings the settings to set
     */
    public void setSettings(List<Setting> settings) {
        this.settings = settings;
    }

    @Override
    public String toString() {
        return settingGroupName;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.settingGroupId != null ? this.settingGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SettingGroup other = (SettingGroup) obj;
        if (this.settingGroupId != other.settingGroupId && (this.settingGroupId == null || !this.settingGroupId.equals(other.settingGroupId))) {
            return false;
        }
        return true;
    }
    
    
    
}
