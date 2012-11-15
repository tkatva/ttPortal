package katvat.tt.model;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ChangeRequest implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long changeRequestId;
	
	private String changeRequestName;
	
	private String changeRequestDescription;
	
	@Temporal(TemporalType.DATE)
	private Date changeRequestCreationDate;
	
	@Temporal(TemporalType.DATE)
	private Date changeRequestResolutionDate;
	
	private String changeRequestCreatorId;
	
	private int changeRequestPriority;
	
	private boolean changeRequestClosed;

	@ManyToOne
	private Project changeRequestProject;

	public Long getChangeRequestId() {
		return changeRequestId;
	}

	public void setChangeRequestId(Long changeRequestId) {
		this.changeRequestId = changeRequestId;
	}

	public String getChangeRequestName() {
		return changeRequestName;
	}

	public void setChangeRequestName(String changeRequestName) {
		this.changeRequestName = changeRequestName;
	}

	public String getChangeRequestDescription() {
		return changeRequestDescription;
	}

	public void setChangeRequestDescription(String changeRequestDescription) {
		this.changeRequestDescription = changeRequestDescription;
	}

	public Date getChangeRequestCreationDate() {
		return changeRequestCreationDate;
	}

	public void setChangeRequestCreationDate(Date changeRequestCreationDate) {
		this.changeRequestCreationDate = changeRequestCreationDate;
	}

	public Date getChangeRequestResolutionDate() {
		return changeRequestResolutionDate;
	}

	public void setChangeRequestResolutionDate(Date changeRequestResolutionDate) {
		this.changeRequestResolutionDate = changeRequestResolutionDate;
	}

	public String getChangeRequestCreatorId() {
		return changeRequestCreatorId;
	}

	public void setChangeRequestCreatorId(String changeRequestCreatorId) {
		this.changeRequestCreatorId = changeRequestCreatorId;
	}

	public int getChangeRequestPriority() {
		return changeRequestPriority;
	}

	public void setChangeRequestPriority(int changeRequestPriority) {
		this.changeRequestPriority = changeRequestPriority;
	}

	public Project getChangeRequestProject() {
		return changeRequestProject;
	}

	public void setChangeRequestProject(Project changeRequestProject) {
		this.changeRequestProject = changeRequestProject;
	}
	
	public boolean isChangeRequestClosed() {
		return changeRequestClosed;
	}

	public void setChangeRequestClosed(boolean changeRequestClosed) {
		this.changeRequestClosed = changeRequestClosed;
	}
	
}