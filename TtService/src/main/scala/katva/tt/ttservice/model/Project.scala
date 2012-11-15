package katva.tt.ttservice.model

import javax.persistence._
import scala.reflect.BeanProperty
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
@Entity
@Table(name = "project")
class Project  {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @BeanProperty
  var projectId : Int = _
  
  @BeanProperty
  var projectName : String  = _
  
  @BeanProperty
  var projectDesc : String = _
}
