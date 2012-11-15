

package katvat.tt.userservice.helper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import java.util.logging.Level;
import java.util.logging.Logger;

import katvat.tt.userapi.ttuserapi.model.TtRole;
import katvat.tt.userapi.ttuserapi.model.TtUser;

/**
 *
 * @author Tuomas Katva
 */
public class UserServiceConversionHelper {

    public static TtRole convertPortalRoleToTtRole(Role role) {
        TtRole ttRole = new TtRole();
        ttRole.setRoleId(role.getRoleId());
        ttRole.setRoleName(role.getName());
        
        
        return ttRole;
    }
    
    public static TtUser convertPortalUserToTtUser(User user) {
        TtUser ttUser = new TtUser();
        
        ttUser.setUserId(user.getUserId());
        try {
            ttUser.setUserName(user.getLogin());
        } catch (PortalException ex) {
            Logger.getLogger(UserServiceConversionHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(UserServiceConversionHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return ttUser;
    }
    
}
