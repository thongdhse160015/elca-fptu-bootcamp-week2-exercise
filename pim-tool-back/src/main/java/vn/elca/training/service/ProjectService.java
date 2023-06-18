package vn.elca.training.service;

import vn.elca.training.model.entity.Project;

import java.util.List;

/**
 * @author vlp
 */
public interface ProjectService {
    List<Project> findAll();

    Project findById(Long id);

    Project updateProject(Project project);

    void createMaintenanceProject(long oldProjectId);

    long count();
}
