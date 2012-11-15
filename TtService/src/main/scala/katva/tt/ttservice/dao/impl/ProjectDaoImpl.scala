package katva.tt.ttservice.dao.impl

import org.springframework.beans.factory.annotation._
import org.springframework.stereotype._
import org.springframework.transaction.annotation.{Propagation, Transactional}
import javax.persistence._
import scala.collection.JavaConversions._
import katva.tt.ttservice.model._
import katva.tt.ttservice.dao.ProjectDao
import scala.reflect.BeanProperty
//import com.mysema.query.scala.Conversions._
//import com.mysema.query.jpa.impl.JPAQuery
 
import com.mysema.query.types.path._

@Repository("projectDao")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
class ProjectDaoImpl extends ProjectDao {

  private var entityManager: EntityManager = null
 
  
  @PersistenceContext
  def setEntityManager (em : EntityManager) {
    entityManager = em
  }
  
  
  def save (project : Project) : Unit = {
    try {
    
      project.getProjectId match {
    case 0 => entityManager.persist(project)
    case _ => entityManager.merge(project)
    }
    entityManager.flush
    } catch {
      case e: Exception => println("Exception : " + e.toString)
    }
  }
  
  def findByName (projectName : String ) : List[Project] = {
    entityManager.createQuery("From Project p Where p.projectName = :pname",classOf[Project]).setParameter("pname",projectName).getResultList.toList
  }
  
}
