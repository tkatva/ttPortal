package katvat.tt.userapi.ttuserapi.model;

import java.util.List;

/**
 *
 * @author Tuomas Katva
 */
public class TtUser {

    private long userId;
    private String userName;
    private String userDesc;
    private List<TtRole> userRoles;

    /**
     * @return the userId
     */
    public long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userDesc
     */
    public String getUserDesc() {
        return userDesc;
    }

    /**
     * @param userDesc the userDesc to set
     */
    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    /**
     * @return the userRoles
     */
    public List<TtRole> getUserRoles() {
        return userRoles;
    }

    /**
     * @param userRoles the userRoles to set
     */
    public void setUserRoles(List<TtRole> userRoles) {
        this.userRoles = userRoles;
    }
}
