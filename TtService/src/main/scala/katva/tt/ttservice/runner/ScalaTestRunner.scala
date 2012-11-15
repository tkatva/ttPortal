package katva.tt.ttservice.runner

import org.springframework.context.support.ClassPathXmlApplicationContext
import katva.tt.ttservice.dao.ProjectDao
import katva.tt.ttservice.model._

object ScalaTestRunner  {
  def main(args:Array[String]) = {
    val ctx = new ClassPathXmlApplicationContext("spring/application-context.xml")
    
    val projectDao : ProjectDao = ctx.getBean(classOf[ProjectDao])
    
    val projects = projectDao.findByName("Test project")
    
    projects.foreach((x : Project) => println(x.projectName + " " + x.projectDesc))
    
  }
}
