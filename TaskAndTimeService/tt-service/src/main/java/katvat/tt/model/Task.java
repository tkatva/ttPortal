package katvat.tt.model;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Task implements Serializable {

    /**
     * @return the privateTask
     */
    public boolean isPrivateTask() {
        return privateTask;
    }

    /**
     * @param privateTask the privateTask to set
     */
    public void setPrivateTask(boolean privateTask) {
        this.privateTask = privateTask;
    }

    public enum TaskStatus {

        NOT_STARTED, STARTED, COMPLETED, CLOSED
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;
    private String taskName;
    private String taskDescription;
    private Integer taskVersion;
    private int budjetedTaskHours;
    private TaskStatus taskStatus;
    @Temporal(TemporalType.DATE)
    private Date taskStartDate;
    @Temporal(TemporalType.DATE)
    private Date taskEndDate;
    @Temporal(TemporalType.DATE)
    private Date completedDate;
    @Temporal(TemporalType.DATE)
    private Date dateSynced;
    private boolean teamTask;
    @ManyToOne
    private Project taskProject;
    @OneToMany(mappedBy = "taskHoursTask")
    private List<TaskHour> taskHours;
    private String assignedUserId;
    private boolean userTask;
    private boolean taskClosed;
    @OneToMany(cascade= CascadeType.ALL)
    private List<Comment> taskComments;
    @OneToMany(cascade= CascadeType.ALL)
    private List<Task> subTasks;
    private boolean privateTask;
    
    /**
     * @return the taskComments
     */
    public List<Comment> getTaskComments() {
        return taskComments;
    }

    /**
     * @param taskComments the taskComments to set
     */
    public void setTaskComments(List<Comment> taskComments) {
        this.taskComments = taskComments;
    }

    /**
     * @return the taskVersion
     */
    public Integer getTaskVersion() {
        return taskVersion;
    }

    /**
     * @param taskVersion the taskVersion to set
     */
    public void setTaskVersion(Integer taskVersion) {
        this.taskVersion = taskVersion;
    }

    /**
     * @return the completedDate
     */
    public Date getCompletedDate() {
        return completedDate;
    }

    /**
     * @param completedDate the completedDate to set
     */
    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    /**
     * @return the dateSynced
     */
    public Date getDateSynced() {
        return dateSynced;
    }

    /**
     * @param dateSynced the dateSynced to set
     */
    public void setDateSynced(Date dateSynced) {
        this.dateSynced = dateSynced;
    }

    /**
     * @return the teamTask
     */
    public boolean isTeamTask() {
        return teamTask;
    }

    /**
     * @param teamTask the teamTask to set
     */
    public void setTeamTask(boolean teamTask) {
        this.teamTask = teamTask;
    }

    /**
     * @return the subTasks
     */
    public List<Task> getSubTasks() {
        return subTasks;
    }

    /**
     * @param subTasks the subTasks to set
     */
    public void setSubTasks(List<Task> subTasks) {
        this.subTasks = subTasks;
    }

    public boolean isTaskClosedFlag() {
        return taskClosedFlag;
    }

    public void setTaskClosedFlag(boolean taskClosedFlag) {
        this.taskClosedFlag = taskClosedFlag;
    }
    private boolean taskClosedFlag;

    public String getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(String assignedUserId) {
        this.assignedUserId = assignedUserId;
    }

    public boolean isUserTask() {
        return userTask;
    }

    public void setUserTask(boolean userTask) {
        this.userTask = userTask;
    }

    public List<TaskHour> getTaskHours() {
        return taskHours;
    }

    public void setTaskHours(List<TaskHour> taskHours) {
        this.taskHours = taskHours;
    }
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    private int taskPercentComplete;
    private String lastUpdatedBy;

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
    @Temporal(TemporalType.DATE)
    private Date lastUpdated;

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    private int taskPriority;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getBudjetedTaskHours() {
        return budjetedTaskHours;
    }

    public void setBudjetedTaskHours(int budjetedTaskHours) {
        this.budjetedTaskHours = budjetedTaskHours;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Date getTaskStartDate() {
        return taskStartDate;
    }

    public void setTaskStartDate(Date taskStartDate) {
        this.taskStartDate = taskStartDate;
    }

    public Date getTaskEndDate() {
        return taskEndDate;
    }

    public void setTaskEndDate(Date taskEndDate) {
        this.taskEndDate = taskEndDate;
    }

    public Project getTaskProject() {
        return taskProject;
    }

    public void setTaskProject(Project taskProject) {
        this.taskProject = taskProject;
    }

    public int getTaskPercentComplete() {
        return taskPercentComplete;
    }

    public void setTaskPercentComplete(int taskPercentComplete) {
        this.taskPercentComplete = taskPercentComplete;
    }

    public int getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(int taskPriority) {
        this.taskPriority = taskPriority;
    }

    /**
     * @return the taskClosed
     */
    public boolean isTaskClosed() {
        return taskClosed;
    }

    /**
     * @param taskClosed the taskClosed to set
     */
    public void setTaskClosed(boolean taskClosed) {
        this.taskClosed = taskClosed;
    }
}
