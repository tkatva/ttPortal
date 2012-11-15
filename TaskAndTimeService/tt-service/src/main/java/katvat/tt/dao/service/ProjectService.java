package katvat.tt.dao.service;

import java.util.List;

import katvat.tt.model.*;

public interface ProjectService {

    Project saveProject(Project project);

    int deleteProject(Project project);

    List<Project> findAllProjects();

    List<Project> findByProjectName(String projectName);

    List<Task> findTasksByUser(String userId, boolean closed);

    List<Task> findTasksByUserAndProject(Project projectParam, String userId, boolean closed);

    List<Task> findUsersTasks(String usedId,boolean showClosed);
    
    Task saveTask(Task task);
    
    int deleteTask(Task task);

    Project findProjectById(Long projectId);

    Task findTaskById(Long taskId);

    List<Task> findWithTaskName(String taskName);

    TaskHour saveTaskHour(TaskHour taskHour);

    List<TaskHour> listUserTaskHours(boolean invoiced, String userId);

    List<ChangeRequest> findProjectChangeRequests(Project project, boolean showClosed);

    ChangeRequest saveChangeRequest(ChangeRequest changeRequest);

    List<ChangeRequest> findAllChangeRequests();
    
    
}
