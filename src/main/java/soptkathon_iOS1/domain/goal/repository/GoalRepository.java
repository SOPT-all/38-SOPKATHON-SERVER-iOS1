package soptkathon_iOS1.domain.goal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soptkathon_iOS1.domain.goal.entity.Goal;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findAllByUserId(Long userId);
}
