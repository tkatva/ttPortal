
package katvat.tt.model;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
/**
 *
 * @author Tuomas Katva
 */
@Entity
public class PaymentTerm {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentTermId;
    
    private String paymentTermName;
    
    private Integer paymentTermDays;
    
    private String paymentTermDetails;
    
    private Double penaltyInterest;

    /**
     * @return the paymentTermId
     */
    public Long getPaymentTermId() {
        return paymentTermId;
    }

    /**
     * @param paymentTermId the paymentTermId to set
     */
    public void setPaymentTermId(Long paymentTermId) {
        this.paymentTermId = paymentTermId;
    }

    /**
     * @return the paymentTermName
     */
    public String getPaymentTermName() {
        return paymentTermName;
    }

    /**
     * @param paymentTermName the paymentTermName to set
     */
    public void setPaymentTermName(String paymentTermName) {
        this.paymentTermName = paymentTermName;
    }

    /**
     * @return the paymentTermDays
     */
    public Integer getPaymentTermDays() {
        return paymentTermDays;
    }

    /**
     * @param paymentTermDays the paymentTermDays to set
     */
    public void setPaymentTermDays(Integer paymentTermDays) {
        this.paymentTermDays = paymentTermDays;
    }

    /**
     * @return the paymentTermDetails
     */
    public String getPaymentTermDetails() {
        return paymentTermDetails;
    }

    /**
     * @param paymentTermDetails the paymentTermDetails to set
     */
    public void setPaymentTermDetails(String paymentTermDetails) {
        this.paymentTermDetails = paymentTermDetails;
    }

    /**
     * @return the penaltyInterest
     */
    public Double getPenaltyInterest() {
        return penaltyInterest;
    }

    /**
     * @param penaltyInterest the penaltyInterest to set
     */
    public void setPenaltyInterest(Double penaltyInterest) {
        this.penaltyInterest = penaltyInterest;
    }
    
    
    
}
