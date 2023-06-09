package vn.elca.training.service.impl.dummy;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.elca.training.model.entity.Project;
import vn.elca.training.service.ProjectService;

/**
 * @author thomas.dang
 *
 */
@Service
public class MyDummyProjectServiceImpl extends AbstractDummyProjectService implements ProjectService {

    @Override
    public List<Project> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

}
