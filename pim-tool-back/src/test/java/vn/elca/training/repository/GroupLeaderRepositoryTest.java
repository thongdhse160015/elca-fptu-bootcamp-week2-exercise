package vn.elca.training.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import vn.elca.training.ApplicationWebConfig;
import vn.elca.training.model.entity.GroupLeader;
import vn.elca.training.model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ContextConfiguration(classes = {ApplicationWebConfig.class})
@RunWith(value = SpringRunner.class)
public class GroupLeaderRepositoryTest {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveOne() {
        User thomasDang = userRepository.findUserByUsername("thomas.dang");
        Assert.assertNotNull(thomasDang);

        GroupLeader group = new GroupLeader();
        group.setGroupLeader(thomasDang);
        groupRepository.save(group);
        Assert.assertEquals(1, groupRepository.count());
    }

}
