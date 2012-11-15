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

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class TaskHour implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskHourId;
    private Double taskHours;
    private String hourComments;
    @ManyToOne
    private Task taskHoursTask;
    @Temporal(TemporalType.DATE)
    private Date dateSynced;
    private String userId;
    private boolean hoursInvoiced;
    private boolean hoursAccepted;
    private String invoiceNumber;
    private String hourAccepter;

    public Long getTaskHourId() {
        return taskHourId;
    }

    public void setTaskHourId(Long taskHourId) {
        this.taskHourId = taskHourId;
    }

    public Double getTaskHours() {
        return taskHours;
    }

    public void setTaskHours(Double taskHours) {
        this.taskHours = taskHours;
    }

    public String getHourComments() {
        return hourComments;
    }

    public void setHourComments(String hourComments) {
        this.hourComments = hourComments;
    }

    public Task getTaskHoursTask() {
        return taskHoursTask;
    }

    public void setTaskHoursTask(Task taskHoursTask) {
        this.taskHoursTask = taskHoursTask;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isHoursInvoiced() {
        return hoursInvoiced;
    }

    public void setHoursInvoiced(boolean hoursInvoiced) {
        this.hoursInvoiced = hoursInvoiced;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    /**
     * @return the hoursAccepted
     */
    public boolean isHoursAccepted() {
        return hoursAccepted;
    }

    /**
     * @param hoursAccepted the hoursAccepted to set
     */
    public void setHoursAccepted(boolean hoursAccepted) {
        this.hoursAccepted = hoursAccepted;
    }

    /**
     * @return the hourAccepter
     */
    public String getHourAccepter() {
        return hourAccepter;
    }

    /**
     * @param hourAccepter the hourAccepter to set
     */
    public void setHourAccepter(String hourAccepter) {
        this.hourAccepter = hourAccepter;
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
}
