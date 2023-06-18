package vn.elca.training.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vn.elca.training.model.entity.Project;
import vn.elca.training.repository.ProjectRepository;
import vn.elca.training.util.MyLogger;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceTest {

    @Autowired
    @Qualifier("projectServiceImpl")
    private ProjectService projectService;

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void testCreateMaintenanceProject() {
        // Create a sample old project
        Project oldProject = new Project();
        oldProject.setName("Sample Project");
        oldProject.setActivated(true);
        projectRepository.save(oldProject);

        try {
            // Call the method to create the maintenance project
            projectService.createMaintenanceProject(oldProject.getId());

            // If no exception was thrown
            MyLogger.getInstance().logInfo("No exception was thrown");
            // Assert that the maintenance project was persisted in the database
            List<Project> maintenanceProjects = projectRepository.findByNameContainingIgnoreCase("Maint.");
            MyLogger.getInstance().logInfo("Size: " + maintenanceProjects.size());
            assertEquals(1, maintenanceProjects.size());

            // Assert that the old project was inactive
            Project updatedOldProject = projectRepository.findById(oldProject.getId())
                    .orElseThrow(RuntimeException::new);
            assertFalse(updatedOldProject.isActivated());
        } catch (RuntimeException e) {
            MyLogger.getInstance().logInfo(e.getMessage());
            // Assert that the maintenance project was not persisted in the database
            List<Project> maintenanceProjects = projectRepository.findByNameContainingIgnoreCase("Maint.");
            MyLogger.getInstance().logInfo("Size: " + maintenanceProjects.size());
            assertEquals(0, maintenanceProjects.size());

            // Assert that the old project is still active
            Project updatedOldProject = projectRepository.findById(oldProject.getId())
                    .orElseThrow(RuntimeException::new);
            assertTrue(updatedOldProject.isActivated());
        }
    }
}
