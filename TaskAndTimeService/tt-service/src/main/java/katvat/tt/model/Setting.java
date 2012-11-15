

package katvat.tt.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Tuomas Katva
 */
@Entity
public class Setting implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long settingId;
    
    private String settingName;
    
    private String settingValue;
    
    private String settingDescription;

    /**
     * @return the settingName
     */
    public String getSettingName() {
        return settingName;
    }

    /**
     * @param settingName the settingName to set
     */
    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }

    /**
     * @return the settingValue
     */
    public String getSettingValue() {
        return settingValue;
    }

    /**
     * @param settingValue the settingValue to set
     */
    public void setSettingValue(String settingValue) {
        this.settingValue = settingValue;
    }

    /**
     * @return the settingDescription
     */
    public String getSettingDescription() {
        return settingDescription;
    }

    /**
     * @param settingDescription the settingDescription to set
     */
    public void setSettingDescription(String settingDescription) {
        this.settingDescription = settingDescription;
    }

    /**
     * @return the settingId
     */
    public Long getSettingId() {
        return settingId;
    }

    /**
     * @param settingId the settingId to set
     */
    public void setSettingId(Long settingId) {
        this.settingId = settingId;
    }
    
    
    
}
