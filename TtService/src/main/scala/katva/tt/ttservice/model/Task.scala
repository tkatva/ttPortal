/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package katva.tt.ttservice.model


import javax.persistence._
import scala.reflect.BeanProperty

class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @BeanProperty
  var taskId : Int = _
  
  @BeanProperty
  var taskName : String = _
  
  @BeanProperty
  var taskDescription : String = _
}
