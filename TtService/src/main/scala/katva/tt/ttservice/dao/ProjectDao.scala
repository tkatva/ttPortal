package katva.tt.ttservice.dao

import katva.tt.ttservice.model.Project

trait ProjectDao {

  def save (project : Project) : Unit
  
  def findByName (projectName : String ) : List[Project]
  
  
  
}
