

package katvat.tt.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Tuomas Katva
 */
@Entity
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;
    
    private String commentUser;
    
    private String comment;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date commentDate;

    /**
     * @return the commentId
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * @param commentId the commentId to set
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    /**
     * @return the commentUser
     */
    public String getCommentUser() {
        return commentUser;
    }

    /**
     * @param commentUser the commentUser to set
     */
    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the commentDate
     */
    public Date getCommentDate() {
        return commentDate;
    }

    /**
     * @param commentDate the commentDate to set
     */
    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
    
    
    
}
