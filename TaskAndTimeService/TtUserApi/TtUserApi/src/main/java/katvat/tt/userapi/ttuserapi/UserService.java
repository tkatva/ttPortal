
package katvat.tt.userapi.ttuserapi;

import java.util.List;
import katvat.tt.userapi.ttuserapi.model.*;
/**
 *
 * @author Tuomas Katva
 */
public interface UserService {
    
    TtUser getLoggedInUser();
    
    List<TtRole> getAllApplicationRoles();
    
    List<TtRole> getUserRoles(TtUser user);
    
    boolean isUserInRole(TtRole role, TtUser user);
    
    List<TtUser> getUsersForRole(String roleName, long userId);
    
}
