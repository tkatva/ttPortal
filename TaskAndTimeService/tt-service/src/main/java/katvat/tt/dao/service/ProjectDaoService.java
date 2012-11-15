package katvat.tt.dao.service;

import java.util.List;

import katvat.tt.model.*;

public interface ProjectDaoService {

	public Project saveProject(Project project);
	
	public int deleteProject(Project project);
	
	public List<Project> findAllProjects();
	
	public List<Project> findByProjectName(String projectName);
	
}
