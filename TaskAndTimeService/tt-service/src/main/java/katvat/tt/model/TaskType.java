package katvat.tt.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TaskType implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long taskTypeId;
	
	private String taskTypeName;
	
	private String taskTypeAbbr;
	
	private double taskTypeHourPriceExVat;
        
        @ManyToOne
        private ValueAddedTax taskTypeVat;
	
	public Long getTaskTypeId() {
		return taskTypeId;
	}

	public void setTaskTypeId(Long taskTypeId) {
		this.taskTypeId = taskTypeId;
	}

	public String getTaskTypeName() {
		return taskTypeName;
	}

	public void setTaskTypeName(String taskTypeName) {
		this.taskTypeName = taskTypeName;
	}

	public String getTaskTypeAbbr() {
		return taskTypeAbbr;
	}

	public void setTaskTypeAbbr(String taskTypeAbbr) {
		this.taskTypeAbbr = taskTypeAbbr;
	}

	public double getTaskTypeHourPriceExVat() {
		return taskTypeHourPriceExVat;
	}

	public void setTaskTypeHourPriceExVat(double taskTypeHourPriceExVat) {
		this.taskTypeHourPriceExVat = taskTypeHourPriceExVat;
	}

	public String getTaskTypeDesc() {
		return taskTypeDesc;
	}

	public void setTaskTypeDesc(String taskTypeDesc) {
		this.taskTypeDesc = taskTypeDesc;
	}

	private String taskTypeDesc;

    /**
     * @return the taskTypeVat
     */
    public ValueAddedTax getTaskTypeVat() {
        return taskTypeVat;
    }

    /**
     * @param taskTypeVat the taskTypeVat to set
     */
    public void setTaskTypeVat(ValueAddedTax taskTypeVat) {
        this.taskTypeVat = taskTypeVat;
    }
}
