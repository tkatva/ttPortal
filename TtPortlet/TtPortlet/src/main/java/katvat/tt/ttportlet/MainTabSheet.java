

package katvat.tt.ttportlet;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.CustomComponent;
import katvat.tt.dao.TaskTypeDao;
import katvat.tt.ttportlet.helper.I18N;
import katvat.tt.ttportlet.tabs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
/**
 *
 * @author Tuomas Katva
 */
@Configurable(preConstruction=false)
public class MainTabSheet extends CustomComponent{


    
    TabSheet mainTabs = new TabSheet();
    ProjectTab projectTab = new ProjectTab();
    TaskTypeTab taskTypeTab = new TaskTypeTab();

    @Override
    public void attach() {
        super.attach();
        mainTabs.addTab(projectTab, I18N.getMessage("ProjectTab.panel.title"));
        mainTabs.addTab(taskTypeTab, I18N.getMessage("TaskTypeTab.label.title"));
    }
    
    
    
    
    public MainTabSheet() {
              
        setCompositionRoot(mainTabs);
    }
    
}
