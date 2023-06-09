package vn.elca.training.service.impl.dummy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import vn.elca.training.model.entity.Project;
import vn.elca.training.service.ProjectService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gtn
 *
 */
@Component
@Profile("dummy")
@Qualifier("firstDummyProjectServiceImpl")
public class FirstDummyProjectServiceImpl extends AbstractDummyProjectService implements ProjectService {

    @Override
    public List<Project> findAll() {
        // throw new UnsupportedOperationException("This is first dummy service");
        return new ArrayList<>();
    }

    @Override
    public long count() {
        // printCurrentActiveProfiles();
        // throw new UnsupportedOperationException("This is first dummy service");
        return 0;
    }
}
