package vn.elca.training.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.elca.training.model.dto.ProjectDto;
import vn.elca.training.service.ProjectService;

/**
 * @author thomas.dang - thongdhse160015
 *
 */
@RestController
@RequestMapping("/projects")
public class ProjectsController extends AbstractApplicationController {

    @Autowired
    @Qualifier("projectServiceImpl")
    private ProjectService projectService;

    @GetMapping("/search")
    public List<ProjectDto> search(@RequestParam String keyword) {
        return projectService.findAll()
                .stream()
                .filter(product -> product.getName().trim().toLowerCase()
                        .contains(keyword.trim().toLowerCase()))
                .map(mapper::projectToProjectDto)
                .collect(Collectors.toList());
    }
}
