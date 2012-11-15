package katvat.tt.model;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
}
