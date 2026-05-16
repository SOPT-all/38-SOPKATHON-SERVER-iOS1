package soptkathon_iOS1.domain.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import soptkathon_iOS1.domain.comment.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("""
            select c
            from Comment c
            join fetch c.user
            where c.goal.id = :goalId
            order by c.createdAt asc
            """)
    List<Comment> findAllWithWriterByGoalIdOrderByCreatedAtAsc(@Param("goalId") Long goalId);

    long countByGoalId(Long goalId);
}
