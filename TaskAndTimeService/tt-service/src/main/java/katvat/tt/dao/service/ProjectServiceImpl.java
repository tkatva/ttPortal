package katvat.tt.dao.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import katvat.tt.dao.ProjectDao;
import katvat.tt.dao.TaskHourDao;
import katvat.tt.dao.ChangeRequestDao;
import katvat.tt.dao.service.ProjectService;
import katvat.tt.dao.TaskDao;
import katvat.tt.model.*;

import com.mysema.query.*;
import com.mysema.query.jpa.*;
import com.mysema.query.jpa.impl.JPAQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private ProjectDao repository;
    @Autowired
    private TaskDao taskRepository;
    @Autowired
    private TaskHourDao taskHourRepository;
    @Autowired
    private ChangeRequestDao changeRequestDao;

    @Override
    public List<Task> findTasksByUser(String userId, boolean closed) {
        QTask task = QTask.task;
        JPQLQuery query = new JPAQuery(em);
        return query.from(task).where(task.userId.eq(userId.trim())
                .and(task.taskClosedFlag.eq(closed))).list(task);

    }

    @Override
    public List<Task> findTasksByUserAndProject(Project projectParam, String userId, boolean closed) {
        QTask task = QTask.task;
        QProject project = QProject.project;
        JPQLQuery query = new JPAQuery(em);
        return query.from(task, project).where(task.userId.eq(userId.trim())
                .and(task.taskClosedFlag.eq(closed).and(project.projectId.eq(projectParam.getProjectId()))))
                .innerJoin(task.taskProject, project)
                .list(task);
    }

    @Override
    public List<Task> findUsersTasks(String usedId, boolean showClosed) {
        QTask task = QTask.task;
        JPQLQuery query = new JPAQuery(em);
        return query.from(task)
                .where(task.userId.eq(usedId.trim()).and(task.taskClosedFlag.eq(showClosed)))
                .list(task);
    }

    @Override
    public List<ChangeRequest> findProjectChangeRequests(Project projectParam,
            boolean showClosed) {
        if (!showClosed) {
            QChangeRequest request = QChangeRequest.changeRequest;
            QProject project = QProject.project;
            JPQLQuery query = new JPAQuery(em);
            return query.from(request, project)
                    .where(request.changeRequestClosed.eq(false)
                    .and(project.projectId.eq(projectParam.getProjectId())))
                    .innerJoin(request.changeRequestProject, project)
                    .list(request);
        } else {
            QChangeRequest request = QChangeRequest.changeRequest;
            QProject project = QProject.project;
            JPQLQuery query = new JPAQuery(em);
            return query.from(request, project)
                    .where(project.projectId.eq(projectParam.getProjectId()))
                    .innerJoin(request.changeRequestProject, project)
                    .list(request);
        }

    }

    @Override
    public ChangeRequest saveChangeRequest(ChangeRequest changeRequest) {
        return changeRequestDao.save(changeRequest);
    }

    @Override
    public List<ChangeRequest> findAllChangeRequests() {
        return changeRequestDao.findAll();
    }

    @Override
    public TaskHour saveTaskHour(TaskHour taskHour) {
        return taskHourRepository.save(taskHour);
    }

    @Override
    public List<TaskHour> listUserTaskHours(boolean invoiced, String userId) {
        QTaskHour taskHour = QTaskHour.taskHour;
        JPQLQuery query = new JPAQuery(em);
        return query.from(taskHour)
                .where(taskHour.hoursInvoiced.eq(invoiced)
                .and(taskHour.userId.eq(userId)))
                .list(taskHour);

    }

    @Override
    public List<Task> findWithTaskName(String taskName) {
        return taskRepository.findByTaskName(taskName);
    }

    @Override
    public Project findProjectById(Long projectId) {
        return repository.findOne(projectId);
    }

    @Override
    public Task findTaskById(Long taskId) {
        return taskRepository.findOne(taskId);
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Transactional
    public Project saveProject(Project project) {
        return repository.save(project);
    }

    @Override
    public int deleteTask(Task task) {
        taskRepository.delete(task);
        return 0;
    }

    @Transactional
    public int deleteProject(Project project) {
        repository.delete(project);
        return 0;
    }

    public List<Project> findAllProjects() {
        return repository.findAll();
    }

    @Override
    public List<Project> findByProjectName(String projectName) {
        List<Project> projects = repository.findByProjectName(projectName);

        return projects;
    }

    public ProjectDao getRepository() {
        return repository;
    }

    public void setRepository(ProjectDao repository) {
        this.repository = repository;
    }

    public TaskDao getTaskRepository() {
        return taskRepository;
    }

    public void setTaskRepository(TaskDao taskRepository) {
        this.taskRepository = taskRepository;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public TaskHourDao getTaskHourRepository() {
        return taskHourRepository;
    }

    public void setTaskHourRepository(TaskHourDao taskHourRepository) {
        this.taskHourRepository = taskHourRepository;
    }

    public ChangeRequestDao getChangeRequestDao() {
        return changeRequestDao;
    }

    public void setChangeRequestDao(ChangeRequestDao changeRequestDao) {
        this.changeRequestDao = changeRequestDao;
    }
}
