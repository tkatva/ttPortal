

package katvat.tt.ttportlet;

import com.vaadin.Application;
import com.vaadin.ui.Component;
import com.vaadin.ui.Window;
import katvat.tt.dao.TaskTypeDao;
import org.springframework.beans.factory.annotation.Configurable;
import katvat.tt.ttportlet.MainTabSheet;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Tuomas Katva
 */
@Configurable
public class TtWebApplication extends Application {

   
    @Override
    public void init() {
       Window mainWindow = new Window();
       MainTabSheet tabs = new MainTabSheet();
       mainWindow.addComponent(tabs);
       setMainWindow(mainWindow);
    }

}
