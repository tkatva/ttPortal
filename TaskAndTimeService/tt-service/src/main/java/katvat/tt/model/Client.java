

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
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;
    
    private String clientName;
    
    private String clientType;
    
    private Integer clientPriority;
    
    private boolean paymentsLate;
    
    private String clientAccessCode;
    
    private ClientStatus clientStatus;
    
    @OneToMany(cascade= CascadeType.ALL)
    private List<Address> clientAddresses;
    
    @OneToMany(cascade= CascadeType.ALL)
    private List<Contact> clientContacts;
    
    @OneToMany(cascade= CascadeType.ALL)
    private List<ContactInformation> clientContactInformations;
    
    @OneToMany(cascade= CascadeType.ALL)
    private List<TaskType> clientTaskTypes;

    /**
     * @return the clientId
     */
    public Long getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    /**
     * @return the clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * @param clientName the clientName to set
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * @return the clientType
     */
    public String getClientType() {
        return clientType;
    }

    /**
     * @param clientType the clientType to set
     */
    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    /**
     * @return the clientPriority
     */
    public Integer getClientPriority() {
        return clientPriority;
    }

    /**
     * @param clientPriority the clientPriority to set
     */
    public void setClientPriority(Integer clientPriority) {
        this.clientPriority = clientPriority;
    }

    /**
     * @return the paymentsLate
     */
    public boolean isPaymentsLate() {
        return paymentsLate;
    }

    /**
     * @param paymentsLate the paymentsLate to set
     */
    public void setPaymentsLate(boolean paymentsLate) {
        this.paymentsLate = paymentsLate;
    }

    /**
     * @return the clientStatus
     */
    public ClientStatus getClientStatus() {
        return clientStatus;
    }

    /**
     * @param clientStatus the clientStatus to set
     */
    public void setClientStatus(ClientStatus clientStatus) {
        this.clientStatus = clientStatus;
    }

    /**
     * @return the clientAddresses
     */
    public List<Address> getClientAddresses() {
        return clientAddresses;
    }

    /**
     * @param clientAddresses the clientAddresses to set
     */
    public void setClientAddresses(List<Address> clientAddresses) {
        this.clientAddresses = clientAddresses;
    }

    /**
     * @return the clientContacts
     */
    public List<Contact> getClientContacts() {
        return clientContacts;
    }

    /**
     * @param clientContacts the clientContacts to set
     */
    public void setClientContacts(List<Contact> clientContacts) {
        this.clientContacts = clientContacts;
    }

    /**
     * @return the clientContactInformations
     */
    public List<ContactInformation> getClientContactInformations() {
        return clientContactInformations;
    }

    /**
     * @param clientContactInformations the clientContactInformations to set
     */
    public void setClientContactInformations(List<ContactInformation> clientContactInformations) {
        this.clientContactInformations = clientContactInformations;
    }

    /**
     * @return the clientTaskTypes
     */
    public List<TaskType> getClientTaskTypes() {
        return clientTaskTypes;
    }

    /**
     * @param clientTaskTypes the clientTaskTypes to set
     */
    public void setClientTaskTypes(List<TaskType> clientTaskTypes) {
        this.clientTaskTypes = clientTaskTypes;
    }

    /**
     * @return the clientAccessCode
     */
    public String getClientAccessCode() {
        return clientAccessCode;
    }

    /**
     * @param clientAccessCode the clientAccessCode to set
     */
    public void setClientAccessCode(String clientAccessCode) {
        this.clientAccessCode = clientAccessCode;
    }
    
    
    public enum ClientStatus {
        LEAD,ACTIVE,NOT_ACTIVE
    }
    
    
    
}
