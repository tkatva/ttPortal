

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
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;
    
    private String addressName;
    
    private String addressStreet;
    
    private String addressAddlStreet;
    
    private String addressPostNumber;
    
    private String addressCity;
    
    private String addressCountry;
    
    /**
     * @return the addressId
     */
    public Long getAddressId() {
        return addressId;
    }

    /**
     * @param addressId the addressId to set
     */
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    /**
     * @return the addressName
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * @param addressName the addressName to set
     */
    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    /**
     * @return the addressStreet
     */
    public String getAddressStreet() {
        return addressStreet;
    }

    /**
     * @param addressStreet the addressStreet to set
     */
    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    /**
     * @return the addressAddlStreet
     */
    public String getAddressAddlStreet() {
        return addressAddlStreet;
    }

    /**
     * @param addressAddlStreet the addressAddlStreet to set
     */
    public void setAddressAddlStreet(String addressAddlStreet) {
        this.addressAddlStreet = addressAddlStreet;
    }

    /**
     * @return the addressPostNumber
     */
    public String getAddressPostNumber() {
        return addressPostNumber;
    }

    /**
     * @param addressPostNumber the addressPostNumber to set
     */
    public void setAddressPostNumber(String addressPostNumber) {
        this.addressPostNumber = addressPostNumber;
    }

    /**
     * @return the addressCity
     */
    public String getAddressCity() {
        return addressCity;
    }

    /**
     * @param addressCity the addressCity to set
     */
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    /**
     * @return the addressCountry
     */
    public String getAddressCountry() {
        return addressCountry;
    }

    /**
     * @param addressCountry the addressCountry to set
     */
    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    
}
