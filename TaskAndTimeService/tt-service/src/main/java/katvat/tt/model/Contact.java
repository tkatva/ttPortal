

package katvat.tt.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
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
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contactId;
    
    private ContactType contactType;
    
    private String contactFirstName;
    
    private String contactMiddleName;
    
    private String contactLastName;
    
    private String contactTitle;
    
    private String contactRemarks;
    
    @OneToMany(cascade= CascadeType.ALL)
    private List<ContactInformation> contactsInformation;
    
    /**
     * @return the contactId
     */
    public Long getContactId() {
        return contactId;
    }

    /**
     * @param contactId the contactId to set
     */
    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    /**
     * @return the contactType
     */
    public ContactType getContactType() {
        return contactType;
    }

    /**
     * @param contactType the contactType to set
     */
    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    /**
     * @return the contactFirstName
     */
    public String getContactFirstName() {
        return contactFirstName;
    }

    /**
     * @param contactFirstName the contactFirstName to set
     */
    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    /**
     * @return the contactMiddleName
     */
    public String getContactMiddleName() {
        return contactMiddleName;
    }

    /**
     * @param contactMiddleName the contactMiddleName to set
     */
    public void setContactMiddleName(String contactMiddleName) {
        this.contactMiddleName = contactMiddleName;
    }

    /**
     * @return the contactLastName
     */
    public String getContactLastName() {
        return contactLastName;
    }

    /**
     * @param contactLastName the contactLastName to set
     */
    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    /**
     * @return the contactTitle
     */
    public String getContactTitle() {
        return contactTitle;
    }

    /**
     * @param contactTitle the contactTitle to set
     */
    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    /**
     * @return the contactRemarks
     */
    public String getContactRemarks() {
        return contactRemarks;
    }

    /**
     * @param contactRemarks the contactRemarks to set
     */
    public void setContactRemarks(String contactRemarks) {
        this.contactRemarks = contactRemarks;
    }

    /**
     * @return the contactsInformation
     */
    public List<ContactInformation> getContactsInformation() {
        return contactsInformation;
    }

    /**
     * @param contactsInformation the contactsInformation to set
     */
    public void setContactsInformation(List<ContactInformation> contactsInformation) {
        this.contactsInformation = contactsInformation;
    }

    public enum ContactType {
        PRIMARY,SECONDARY
    }
 
}
