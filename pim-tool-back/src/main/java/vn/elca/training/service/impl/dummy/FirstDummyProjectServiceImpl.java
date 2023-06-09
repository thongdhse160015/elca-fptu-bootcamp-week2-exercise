package vn.elca.training.service.impl.dummy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import vn.elca.training.model.entity.Project;
import vn.elca.training.model.entity.User;
import vn.elca.training.repository.ProjectRepository;
import vn.elca.training.repository.TaskRepository;
import vn.elca.training.repository.UserRepository;
import vn.elca.training.service.ProjectService;
import vn.elca.training.util.MyLogger;

import java.util.List;

/**
 * @author gtn
 *
 */
@Component
// @Profile("dummy")
@Qualifier("firstDummyProjectServiceImpl")
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
