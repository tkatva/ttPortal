package katvat.tt.dao.service;

import katvat.tt.model.*;
import java.util.List;

public interface VatTaskTypeService {
	
	ValueAddedTax saveValueAddedTax(ValueAddedTax vat);
	
	boolean removeValueAddedTax(ValueAddedTax vat);
	
	List<ValueAddedTax> findAllVats();
	
	List<TaskType> findAllTaskTypes();
	
	TaskType saveTaskType(TaskType taskType);
	
	boolean removeTaskType(TaskType taskType);
        
        List<TaskType> getVatTaskTypes(ValueAddedTax vat);

}
