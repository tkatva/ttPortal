package katvat.test;


import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import katvat.tt.model.*;
import katvat.tt.dao.service.*;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjectDaoTester {

     private final static Logger LOGGER = LoggerFactory.getLogger(ProjectDaoTester.class);
	@Test
	public void test() {
		ClassPathXmlApplicationContext cpx =	new ClassPathXmlApplicationContext("META-INF/spring/application-ttservice-context.xml");
		ProjectService service = (ProjectService) cpx.getBean("projectService");
		Project retVal = null;
		
		try {
			List<Project> pros = service.findByProjectName("Tst1");
			for (Project pro:pros) {
				retVal = pro;
			}
		} catch (Exception exp) {
			retVal = null;
		}
		if (retVal == null) {
		Project project = new Project();
		project.setProjectName("Tst1");
		project.setProjectDescription("Test project 1");
		
		
		retVal = service.saveProject(project);
		}
		assertEquals("Tst1", retVal.getProjectName());
	}
        
        @Test
        public void addChangeRequest() {
            ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("spring/application-context.xml");
            ProjectService service = (ProjectService) cpx.getBean("projectService");
            Project project = new Project();
            project.setProjectId(new Long(1));
            
            List<ChangeRequest> requests = service.findProjectChangeRequests(project, false);
            if (requests.size() > 1) {
                
                LOGGER.info("REQUEST FOUND : " + requests.get(0).getChangeRequestName());
                assertTrue(true);
            } else {
            
            ChangeRequest request = new ChangeRequest();
            request.setChangeRequestProject(project);
            request.setChangeRequestClosed(false);
            request.setChangeRequestCreationDate(new Date());
            request.setChangeRequestCreatorId("TKATVA");
            request.setChangeRequestDescription("Hello world");
            request.setChangeRequestName("Test request");
            request.setChangeRequestPriority(1);
            
            service.saveChangeRequest(request);
            }
        }
	
	@Test 
	public void tstTask() {
		ClassPathXmlApplicationContext cpx =	new ClassPathXmlApplicationContext("spring/application-context.xml");
		ProjectService service = (ProjectService) cpx.getBean("projectService");

		Task selectedTask = null;
		
		try {
			List<Task> tasks = service.findWithTaskName("Test task");
			for (Task task : tasks) {
				selectedTask = task;
			}
		} catch (Exception exp) {
			
		}
		
		if (selectedTask == null) {
		

		Project selectedProject = new Project();
		selectedProject.setProjectId(new Long(1));
		Task task = new Task();
		task.setTaskName("Test task");
		task.setTaskDescription("Test task description");
		task.setTaskStartDate(new Date());
		task.setTaskEndDate(new Date());
		task.setLastUpdated(new Date());
		task.setTaskPriority(1);
		task.setTaskStatus(Task.TaskStatus.STARTED);
		
		task.setTaskProject(selectedProject);
		selectedTask = service.saveTask(task);
		}
		double l = 1.2;
		assertEquals("Test task", selectedTask.getTaskName());
	}
	
	@Test
	public void tstTaskHourAdd() {
		ClassPathXmlApplicationContext cpx =	new ClassPathXmlApplicationContext("spring/application-context.xml");
		ProjectService service = (ProjectService) cpx.getBean("projectService");
		Task selectedTask = null; 
		List<Task> tasks = service.findWithTaskName("Test task");
		if (tasks != null) {
			for (Task task:tasks) {
				selectedTask = task;
			}
		}
		if (selectedTask != null) {
			if (service.listUserTaskHours(false, "1").size() < 1) {
			TaskHour taskHour = new TaskHour();
			taskHour.setHourComments("Test task creation");
			taskHour.setHoursInvoiced(false);
			taskHour.setTaskHours(6.5);
			taskHour.setTaskHoursTask(selectedTask);
			taskHour.setUserId("1");
			TaskHour th = service.saveTaskHour(taskHour);
			assertEquals("Test task creation", th.getHourComments());
			} else {
				TaskHour foundTaskHour = null;
				for (TaskHour taskHour : service.listUserTaskHours(false, "1")) {
					foundTaskHour = taskHour;
				}
				if (foundTaskHour != null) {
					assertEquals("Test task creation", foundTaskHour.getHourComments());
				} else {
					fail("Test task hours not found");
				}
			}
		} else {
			fail();
		}
	}
	
	


}
