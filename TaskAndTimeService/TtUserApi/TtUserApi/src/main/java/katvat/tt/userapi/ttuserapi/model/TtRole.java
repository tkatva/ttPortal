package katvat.tt.userapi.ttuserapi.model;

/**
 *
 * @author Tuomas Katva
 */
public class TtRole {

    private long roleId;
    private String roleName;
    private String roleAbbr;

    /**
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName the roleName to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * @return the roleAbbr
     */
    public String getRoleAbbr() {
        return roleAbbr;
    }

    /**
     * @param roleAbbr the roleAbbr to set
     */
    public void setRoleAbbr(String roleAbbr) {
        this.roleAbbr = roleAbbr;
    }

    /**
     * @return the roleId
     */
    public long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
    
    
}
