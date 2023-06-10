package vn.elca.training.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.elca.training.model.dto.ProjectDto;
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

        MyLogger.getInstance().logInfo("null");

        List<UserDto> users = new ArrayList<>();
        Project found = projectService.findAll()
                .stream()
                .filter(product -> product.getId() == id)
                .findAny().orElseThrow();
        found.getTasks().forEach(task -> {
            User user = task.getUser();
            if (user != null) {
                users.add(mapper.userToUserDto(user));
            }
        });
        return mapper.projectToProjectDto(found).toString()
                .concat(", customers: ")
                .concat(users.toString());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable long id,
            @RequestBody ProjectDto project) {
        return ResponseEntity.ok(new ProjectDto());
    }

}
