package vn.elca.training.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.elca.training.model.dto.ProjectDto;
import vn.elca.training.model.dto.TaskDto;
import vn.elca.training.model.dto.UserDto;
import vn.elca.training.model.entity.Project;
import vn.elca.training.model.entity.User;
import vn.elca.training.service.ProjectService;
import vn.elca.training.util.MyLogger;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author thomas.dang - thongdhse160015
 *
 */
@RestController
@RequestMapping("/project")
public class ProjectController extends AbstractApplicationController {

    @Autowired
    @Qualifier("projectServiceImpl")
    private ProjectService projectService;

    @GetMapping("/search/{id}")
    public String getProjectById(@PathVariable long id) {
        StringBuilder sb = new StringBuilder();
        Project project = projectService.findById(id);
        if(project == null) {
            return "Project not found";
        }
        List<String> usernames = new ArrayList<>();
        project.getTasks().forEach(task -> {
            usernames.add(task.getUser().getUsername());
        });
        sb.append("Project id: " + project.getId());
        sb.append(", name: " + project.getName());
        sb.append(", finishing date: " + project.getFinishingDate());
        sb.append(", customers: " + String.join(", ", usernames));
        sb.append(".");
        return sb.toString();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable long id,
            @RequestBody ProjectDto project) {
        return ResponseEntity.ok(new ProjectDto());
    }

}
