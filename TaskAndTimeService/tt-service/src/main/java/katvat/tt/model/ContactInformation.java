

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
public class ContactInformation implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contactInformationId;
    
    private String contactInformationDescription;
    
    private String contactInformationName;
    
    private String contactInformationValue;

    /**
     * @return the contactInformationId
     */
    public Long getContactInformationId() {
        return contactInformationId;
    }

    /**
     * @param contactInformationId the contactInformationId to set
     */
    public void setContactInformationId(Long contactInformationId) {
        this.contactInformationId = contactInformationId;
    }

    /**
     * @return the contactInformationDescription
     */
    public String getContactInformationDescription() {
        return contactInformationDescription;
    }

    /**
     * @param contactInformationDescription the contactInformationDescription to set
     */
    public void setContactInformationDescription(String contactInformationDescription) {
        this.contactInformationDescription = contactInformationDescription;
    }

    /**
     * @return the contactInformationName
     */
    public String getContactInformationName() {
        return contactInformationName;
    }

    /**
     * @param contactInformationName the contactInformationName to set
     */
    public void setContactInformationName(String contactInformationName) {
        this.contactInformationName = contactInformationName;
    }

    /**
     * @return the contactInformationValue
     */
    public String getContactInformationValue() {
        return contactInformationValue;
    }

    /**
     * @param contactInformationValue the contactInformationValue to set
     */
    public void setContactInformationValue(String contactInformationValue) {
        this.contactInformationValue = contactInformationValue;
    }

}
