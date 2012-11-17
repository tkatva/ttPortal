package katvat.tt.ttportlet.tabs;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import katvat.tt.model.TaskType;
import org.springframework.beans.factory.annotation.Configurable;
import org.vaadin.addon.formbinder.FormFieldMatch;
import org.vaadin.addon.formbinder.FormView;
import org.vaadin.addon.formbinder.PropertyId;

/**
 *
 * @author Tuomas Katva
 */
@FormView(matchFieldsBy = FormFieldMatch.ANNOTATION)
@Configurable(preConstruction = true)
public class TaskTypeEditForm extends CustomComponent {

    @PropertyId("taskTypeAbbr")
    private TextField taskTypeAbbrField;
    @PropertyId("taskTypeDesc")
    private TextArea taskTypeDesc;
    @PropertyId("taskTypeHourPriceExVat")
    private TextField taskTypeHourPrice;
    @PropertyId("taskTypeName")
    private TextField taskTypeName;
    @PropertyId("taskTypeVat")
    private ComboBox taskTypeVat;
    
    private TaskType model;
    
    public TaskTypeEditForm(TaskType taskTypeParam) {
        model = taskTypeParam;
    }
}
