package vn.elca.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import vn.elca.training.model.entity.Project;

import java.util.List;
import java.util.Optional;

/**
 * @author vlp
 */
public interface ProjectRepository extends JpaRepository<Project, Long>, QuerydslPredicateExecutor<Project> {

    //define new method that find project by name
    Project findByName(String name);

    Optional<Project> findById(Long id);

    List<Project> findByNameContainingIgnoreCase(String name);
}
