package katvat.tt.model;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;

@Entity
public class ValueAddedTax implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vatId;
	
	private String vatName;
	
	private String vatCode;
	
	private int vatPercent;

	public Long getVatId() {
		return vatId;
	}

	public void setVatId(Long vatId) {
		this.vatId = vatId;
	}

	public String getVatName() {
		return vatName;
	}

	public void setVatName(String vatName) {
		this.vatName = vatName;
	}

	public String getVatCode() {
		return vatCode;
	}

	public void setVatCode(String vatCode) {
		this.vatCode = vatCode;
	}

	public int getVatPercent() {
		return vatPercent;
	}

	public void setVatPercent(int vatPercent) {
		this.vatPercent = vatPercent;
	}

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.vatId != null ? this.vatId.hashCode() : 0);
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
        final ValueAddedTax other = (ValueAddedTax) obj;
        if (this.vatId != other.vatId && (this.vatId == null || !this.vatId.equals(other.vatId))) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return vatCode;
    }
        
        
}
