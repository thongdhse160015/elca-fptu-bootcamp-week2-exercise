package vn.elca.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.elca.training.model.entity.GroupLeader;

public interface GroupRepository extends JpaRepository<GroupLeader, Long> {
}
