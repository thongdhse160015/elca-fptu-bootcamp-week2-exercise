package vn.elca.training.repository;

import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Hibernate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import vn.elca.training.ApplicationWebConfig;
import vn.elca.training.model.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@ContextConfiguration(classes = {ApplicationWebConfig.class})
@RunWith(value = SpringRunner.class)
public class ProjectRepositoryTest {
    @Autowired
    GroupRepository groupRepository;
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;

    //Test verify the saving of one project via projectRepository

    @Test
    @Transactional
    public void testSaveMultipleProjectsRepresentedByRequirementTree() {
        //Group Leader users
        User glQMV = new User("QMV", Role.GL);
        User glHNH = new User("HNH", Role.GL);
        //Project Leader users
        User plHTV = new User("HTV", Role.PL);
        User plQKP = new User("QKP", Role.PL);
        User plMKN = new User("MKN", Role.PL);
        User plAPL = new User("APL", Role.PL);
        User plXHP = new User("XHP", Role.PL);
        //Developers
        User devTQP = new User("TQP", Role.DEV);
        User devNQN = new User("NQN", Role.DEV);
        User devHNL = new User("HNL", Role.DEV);
        User devTDN = new User("TDN", Role.DEV);
        User devHPN = new User("HPN", Role.DEV);
        User devBNN = new User("BNN", Role.DEV);
        User devPNH = new User("PNH", Role.DEV);
        User devVVT = new User("VVT", Role.DEV);
        //QA users
        User qaHNH = new User("HNH", Role.QA);
        User qaPLH = new User("PLH", Role.QA);
        User qaTBH = new User("TBH", Role.QA);
        User qaHUN = new User("HUN", Role.QA);
        User qaQMV = new User("QMV", Role.QA);

        //Projects
        Project projectEFV = new Project("EFV", LocalDate.now());
        Project projectCXTRANET = new Project("CXTRANET", LocalDate.now());
        Project projectCRYSTALBALL = new Project("CRYSTALBALL", LocalDate.now());
        Project projectIOCCLIENTEXTRANET = new Project("IOCCLIENTEXTRANET", LocalDate.now());
        Project projectKISTAMIGRATION = new Project("KISTAMIGRATION", LocalDate.now());

        //Set users for each project
        Set<User> usersEFV = new HashSet<>();
        usersEFV.add(devTQP);
        usersEFV.add(qaHNH);
        usersEFV.add(devNQN);
        Set<User> usersCXTRANET = new HashSet<>();
        usersCXTRANET.add(qaPLH);
        usersCXTRANET.add(devHNL);
        Set<User> usersCRYSTALBALL = new HashSet<>();
        usersCRYSTALBALL.add(qaTBH);
        usersCRYSTALBALL.add(devTDN);
        Set<User> usersIOCCLIENTEXTRANET = new HashSet<>();
        usersIOCCLIENTEXTRANET.add(devHPN);
        usersIOCCLIENTEXTRANET.add(qaHUN);
        usersIOCCLIENTEXTRANET.add(devBNN);
        usersIOCCLIENTEXTRANET.add(devPNH);
        Set<User> usersKISTAMIGRATION = new HashSet<>();
        usersIOCCLIENTEXTRANET.add(qaQMV);
        usersIOCCLIENTEXTRANET.add(devVVT);

        //Set project leaders and users
        projectEFV.setProjectLeader(plHTV);
        projectEFV.setUsers(usersEFV);
        projectCXTRANET.setProjectLeader(plQKP);
        projectCXTRANET.setUsers(usersCXTRANET);
        projectCRYSTALBALL.setProjectLeader(plMKN);
        projectCRYSTALBALL.setUsers(usersCRYSTALBALL);
        projectIOCCLIENTEXTRANET.setProjectLeader(plAPL);
        projectIOCCLIENTEXTRANET.setUsers(usersIOCCLIENTEXTRANET);
        projectKISTAMIGRATION.setProjectLeader(plXHP);
        projectKISTAMIGRATION.setUsers(usersKISTAMIGRATION);

        //Group's projects
        Set<Project> projectsQMV = new HashSet<>();
        projectsQMV.add(projectEFV);
        projectsQMV.add(projectCXTRANET);
        projectsQMV.add(projectCRYSTALBALL);
        Set<Project> projectsHNH = new HashSet<>();
        projectsHNH.add(projectIOCCLIENTEXTRANET);
        projectsHNH.add(projectKISTAMIGRATION);

        //Groups
        GroupLeader groupQMV = new GroupLeader();
        groupQMV.setGroupLeader(glQMV);
        groupQMV.setProjects(projectsQMV);
        GroupLeader groupHNH = new GroupLeader();
        groupHNH.setGroupLeader(glHNH);
        groupHNH.setProjects(projectsHNH);

        //Save all users by using userRepository
        long currentUsers = userRepository.count();
        userRepository.save(glQMV);
        userRepository.save(glHNH);
        userRepository.save(plHTV);
        userRepository.save(plQKP);
        userRepository.save(plMKN);
        userRepository.save(plAPL);
        userRepository.save(plXHP);
        userRepository.save(devTQP);
        userRepository.save(devNQN);
        userRepository.save(devHNL);
        userRepository.save(devTDN);
        userRepository.save(devHPN);
        userRepository.save(devBNN);
        userRepository.save(devPNH);
        userRepository.save(devVVT);
        userRepository.save(qaHNH);
        userRepository.save(qaPLH);
        userRepository.save(qaTBH);
        userRepository.save(qaHUN);
        userRepository.save(qaQMV);
        long newUsers = currentUsers + 20;
        //Test the number of users after saving
        Assert.assertEquals(newUsers, userRepository.count());

        long currentProject = projectRepository.count();
        projectRepository.save(projectEFV);
        projectRepository.save(projectCXTRANET);
        projectRepository.save(projectCRYSTALBALL);
        projectRepository.save(projectIOCCLIENTEXTRANET);
        projectRepository.save(projectKISTAMIGRATION);
        long numberOfAddedProject = 5;
        //Test the number of projects after saving
        Assert.assertEquals(currentProject + numberOfAddedProject, projectRepository.count());
        //Test the number of groups after saving
        long currentGroup = 0;
        groupRepository.save(groupQMV);
        groupRepository.save(groupHNH);
        long numberOfAddedGroups = 2;
        Assert.assertEquals(currentGroup + numberOfAddedGroups, groupRepository.count());

        Logger logger = Logger.getLogger(this.getClass().getName());
        groupRepository.findAll().forEach(groupLeader -> {
            logger.log(Level.INFO, groupLeader.getGroupLeader().getUsername()
                    + "(Group Leader)");
            Hibernate.initialize(groupLeader.getProjects());
            groupLeader.getProjects().forEach(project -> {
                logger.log(Level.INFO, project.getName()
                        + " (PL:" + project.getProjectLeader().getUsername() + ")");
                Hibernate.initialize(project.getUsers());
                project.getUsers().forEach(user -> {
                    logger.log(Level.INFO, user.getUsername() + "(" + user.getRole() + ")");
                });
            });
        });

    }

    @Test
    public void testSaveOneProject() {
        final String PROJECT_NAME = "testSaveOneProject";
        projectRepository.save(new Project(PROJECT_NAME, LocalDate.now()));
        Project project = projectRepository.findByName(PROJECT_NAME);
        Assert.assertEquals(PROJECT_NAME, project.getName());
    }

    @Test
    public void testCountAll() {
        int currentCount = (int) projectRepository.count();
        projectRepository.save(new Project("KSTA", LocalDate.now()));
        projectRepository.save(new Project("LAGAPEO", LocalDate.now()));
        projectRepository.save(new Project("ZHQUEST", LocalDate.now()));
        projectRepository.save(new Project("SECUTIX", LocalDate.now()));
        int newCount = currentCount + 4;
        Assert.assertEquals(newCount, projectRepository.count());
    }

    @Test
    public void testFindOneWithQueryDSL() {
        final String PROJECT_NAME = "KSTA";
        projectRepository.save(new Project(PROJECT_NAME, LocalDate.now()));
        Project project = new JPAQuery<Project>(em)
                .from(QProject.project)
                .where(QProject.project.name.eq(PROJECT_NAME))
                .fetchFirst();
        Assert.assertEquals(PROJECT_NAME, project.getName());
    }
}
