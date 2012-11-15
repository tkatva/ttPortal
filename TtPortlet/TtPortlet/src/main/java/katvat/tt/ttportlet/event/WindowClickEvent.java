

package katvat.tt.ttportlet.event;

/**
 *
 * @author Tuomas Katva
 */
public class WindowClickEvent {

    public enum ClickEvent {
        SAVE,CANCEL
    }
    
    ClickEvent event;
    
    public WindowClickEvent(ClickEvent clickEvent) {
        event = clickEvent;
    }
    
    public ClickEvent getClickEvent() {
        return event;
    }
}
