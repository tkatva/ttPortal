

package katvat.tt.userservice;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import java.util.List;
import katvat.tt.userapi.ttuserapi.UserService;
import katvat.tt.userapi.ttuserapi.model.TtRole;
import katvat.tt.userapi.ttuserapi.model.TtUser;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.RoleLocalService;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalService;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import katvat.tt.userservice.helper.UserServiceConversionHelper;
/**
 *
 * @author Tuomas Katva
 */
public class UserServiceImpl implements UserService{

    UserLocalService usrService = UserLocalServiceUtil.getService();
    ServiceContext serviceContext = new ServiceContext();
    RoleLocalService roleService = RoleLocalServiceUtil.getService();
    OrganizationLocalService orgService = OrganizationLocalServiceUtil.getService();
    
    public TtUser getLoggedInUser() {
        //TODO if this does not work this must be done in Vaadin application where
        //portlet request must be passed to PortalUtil class
        Long userId = serviceContext.getUserId();
        TtUser usr = new TtUser();
        usr.setUserId(userId);
        try {
        usr.setUserName(usrService.getUser(userId).getLogin());
        } catch (Exception exp) {
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<TtRole> getAllApplicationRoles() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<TtRole> getUserRoles(TtUser user) {
        List<TtRole> roles = new ArrayList<TtRole>();
        try {
            List<com.liferay.portal.model.Role> portalRoles = roleService.getUserRoles(user.getUserId());
            for (Role portalRole : portalRoles) {
                roles.add(UserServiceConversionHelper.convertPortalRoleToTtRole(portalRole));
            }
            
            
        } catch (SystemException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roles;
    }

    public boolean isUserInRole(TtRole role, TtUser user) {
        try {
            return roleService.hasUserRole(user.getUserId(), role.getRoleId());
        } catch (SystemException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
       
    }

    
    public List<TtUser> getUsersForRole(String roleName, long userId) {
        List<TtUser> roleUsrs = new ArrayList<TtUser>();
        try {
            List<Organization> usrOrgs = orgService.getUserOrganizations(userId);
            for (Organization org:usrOrgs) {
                Role role = roleService.getRole(org.getCompanyId(), roleName);
                if (role != null) {
                    List<User> usrs = usrService.getRoleUsers(role.getRoleId());
                    for (User usr:usrs) {
                     roleUsrs.add(UserServiceConversionHelper.convertPortalUserToTtUser(usr));   
                    }
                }
            }
        } catch (PortalException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roleUsrs;
    }
    
    
}
