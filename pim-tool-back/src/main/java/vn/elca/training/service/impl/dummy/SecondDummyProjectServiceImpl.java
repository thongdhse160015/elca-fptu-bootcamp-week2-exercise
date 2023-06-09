package vn.elca.training.service.impl.dummy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import vn.elca.training.model.entity.Project;
import vn.elca.training.repository.ProjectRepository;
import vn.elca.training.service.ProjectService;

import java.util.List;

/**
 * @author gtn
 *
 */
@Service
@Profile("dummy")
@Qualifier("secondDummyProjectServiceImpl")
public class SecondDummyProjectServiceImpl
        extends AbstractDummyProjectService
        implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAll() {
        throw new UnsupportedOperationException("This is second dummy service");
    }

    @Override
    public long count() {
        printCurrentActiveProfiles();
        throw new UnsupportedOperationException("This is second dummy service");
    }
}
