package katvat.tt.model;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Project implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long projectId;
	
	private String projectName;
	
	private String projectDescription;
	
	private int projectPriority;
	
	private Long version;
	
	private int budjetedHours;
	
	private String lastUpdatedBy;
	
	private boolean projectClosed;
	
	private double projectBudget;
	
	private String projectManagerUserId;
	
	@OneToMany(mappedBy="taskProject")
	private List<Task> projectTasks;
	
	@OneToMany(mappedBy="changeRequestProject")
	private List<ChangeRequest> projectChangeRequests;
	
	public boolean isProjectClosed() {
		return projectClosed;
	}

	public void setProjectClosed(boolean projectClosed) {
		this.projectClosed = projectClosed;
	}

	public double getProjectBudget() {
		return projectBudget;
	}

	public void setProjectBudget(double projectBudget) {
		this.projectBudget = projectBudget;
	}

	@Temporal(TemporalType.DATE)
	private Date updateDate;
	
	@Temporal(TemporalType.DATE)
	private Date projectStartDate;
	
	@Temporal(TemporalType.DATE)
	private Date projectEndDate;
	
	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectManagerId() {
		return projectManagerId;
	}

	public void setProjectManagerId(String projectManagerId) {
		this.projectManagerId = projectManagerId;
	}

	private String projectManagerId;
	
	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public int getProjectPriority() {
		return projectPriority;
	}

	public void setProjectPriority(int projectPriority) {
		this.projectPriority = projectPriority;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public int getBudjetedHours() {
		return budjetedHours;
	}

	public void setBudjetedHours(int budjetedHours) {
		this.budjetedHours = budjetedHours;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public Date getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public String getProjectManagerUserId() {
		return projectManagerUserId;
	}

	public void setProjectManagerUserId(String projectManagerUserId) {
		this.projectManagerUserId = projectManagerUserId;
	}

	public List<Task> getProjectTasks() {
		return projectTasks;
	}

	public void setProjectTasks(List<Task> projectTasks) {
		this.projectTasks = projectTasks;
	}

	public List<ChangeRequest> getProjectChangeRequests() {
		return projectChangeRequests;
	}

	public void setProjectChangeRequests(List<ChangeRequest> projectChangeRequests) {
		this.projectChangeRequests = projectChangeRequests;
	}

	
}
