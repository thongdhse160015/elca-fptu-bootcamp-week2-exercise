package vn.elca.training.service.impl.dummy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import vn.elca.training.model.entity.Project;
import vn.elca.training.repository.ProjectRepository;
import vn.elca.training.service.ProjectService;
import java.util.List;

/**
 * @author gtn
 *
 */
@Component
@Profile("dummy")
public class FirstDummyProjectServiceImpl extends AbstractDummyProjectService implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public long count() {
        return projectRepository.count();
    }
}
