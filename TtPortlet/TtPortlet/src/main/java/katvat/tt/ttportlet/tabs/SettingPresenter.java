

package katvat.tt.ttportlet.tabs;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import katvat.tt.ttportlet.helper.I18N;
import katvat.tt.dao.service.SettingService;
/**
 *
 * @author Tuomas Katva
 */

@Component
public class SettingPresenter {

    @Autowired(required=true)
    SettingService settingService;
    
    
}
