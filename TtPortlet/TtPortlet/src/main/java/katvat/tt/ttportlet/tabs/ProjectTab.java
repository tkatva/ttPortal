

package katvat.tt.ttportlet.tabs;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import katvat.tt.ttportlet.helper.I18N;
/**
 *
 * @author Tuomas Katva
 */
public class ProjectTab extends CustomComponent {

    VerticalLayout rootLayout;
    Panel contentPanel;
    
    public ProjectTab() {
        rootLayout = new VerticalLayout();
        rootLayout.addComponent(buildProjectPanel());
        setCompositionRoot(rootLayout);
    }
    
    private VerticalLayout buildProjectPanel() {
        VerticalLayout vLayout = new VerticalLayout();
        
        Label tstLabel = new Label(I18N.getMessage("ProjectTab.label.title"));
        vLayout.addComponent(tstLabel);
        
        return vLayout;
    }
    
}
