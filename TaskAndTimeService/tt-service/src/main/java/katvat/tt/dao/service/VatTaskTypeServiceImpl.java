package katvat.tt.dao.service;

import java.util.List;

import katvat.tt.model.TaskType;
import katvat.tt.model.ValueAddedTax;
import com.mysema.query.*;
import com.mysema.query.jpa.*;
import com.mysema.query.jpa.impl.JPAQuery;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import katvat.tt.dao.VatDao;
import katvat.tt.dao.TaskTypeDao;
import katvat.tt.model.QTaskType;
import katvat.tt.model.QValueAddedTax;

@Repository
@Transactional
public class VatTaskTypeServiceImpl implements VatTaskTypeService {

        @PersistenceContext
        private EntityManager em;
    
	@Autowired
	private VatDao vatDao;
	
	@Autowired
	private TaskTypeDao taskTypeDao;

	@Override
	public ValueAddedTax saveValueAddedTax(ValueAddedTax vat) {
		return vatDao.save(vat);
	}
        
        public List<TaskType> getVatTaskTypes(ValueAddedTax vat) {
            QTaskType qTaskType = QTaskType.taskType;
            QValueAddedTax qVat = QValueAddedTax.valueAddedTax;
            JPQLQuery query = new JPAQuery(em);
            return query.from(qTaskType,qVat)
                    .join(qTaskType.taskTypeVat,qVat)
                    .where(qVat.vatId.eq(vat.getVatId()))
                    .list(qTaskType);
        }

	@Override
	public boolean removeValueAddedTax(ValueAddedTax vat) {
		vatDao.delete(vat);
		return true;
	}

	@Override
	public List<ValueAddedTax> findAllVats() {
		return vatDao.findAll();
	}

	@Override
	public List<TaskType> findAllTaskTypes() {
		return taskTypeDao.findAll();
	}

	@Override
	public TaskType saveTaskType(TaskType taskType) {
		return taskTypeDao.save(taskType);
	}

	@Override
	public boolean removeTaskType(TaskType taskType) {
		taskTypeDao.delete(taskType);
		return true;
	}

	public VatDao getVatDao() {
		return vatDao;
	}

	public void setVatDao(VatDao vatDao) {
		this.vatDao = vatDao;
	}

	public TaskTypeDao getTaskTypeDao() {
		return taskTypeDao;
	}

	public void setTaskTypeDao(TaskTypeDao taskTypeDao) {
		this.taskTypeDao = taskTypeDao;
	}

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }
	
}
