package katvat.tt.ttportlet;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.vaadin.terminal.gwt.server.PortletRequestListener;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import com.vaadin.service.ApplicationContext;

@SuppressWarnings("serial")
@Configurable(preConstruction=false)
public class TtPortlet extends Application implements PortletRequestListener {

    private String userName = "";
    private long userId;
   protected final Logger log = LoggerFactory.getLogger(getClass());
   protected Window mainWindow;
   protected MainTabSheet tabs = new MainTabSheet();
    
    @Override
    public void init() {
        mainWindow = new Window();

        
//        Button button = new Button("Click me!");
//        button.addListener(new Button.ClickListener() {
//            public void buttonClick(ClickEvent event) {
//                event.getButton().getWindow()
//                        .addComponent(new Label("Hello Vaadin user : " + userName));
//
//            }
//        });
        mainWindow.addComponent(tabs);
        setMainWindow(mainWindow);

    }

    public void onRequestStart(PortletRequest request, PortletResponse response) {
        try {
            User usr = PortalUtil.getUser(request);
            userName = usr.getLogin();
            userId = usr.getUserId();
        } catch (PortalException ex) {
            log.warn("Portal exception occurred : " + ex.toString());
        } catch (SystemException ex) {
            log.warn("System exception occurred : "+ ex.toString());
        }
    }

    public void onRequestEnd(PortletRequest request, PortletResponse response) {
        
    }

  

    
}
