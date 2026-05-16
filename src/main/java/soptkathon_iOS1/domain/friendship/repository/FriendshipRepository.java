package soptkathon_iOS1.domain.friendship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import soptkathon_iOS1.domain.friendship.entity.Friendship;

import java.util.List;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

    @Query("""
            select friendship
            from Friendship friendship
            join fetch friendship.userA
            join fetch friendship.userB
            where friendship.userA.id = :userId
               or friendship.userB.id = :userId
            order by friendship.createdAt asc
            """)
    List<Friendship> findAllByUserId(@Param("userId") Long userId);

    @Query("""
            select count(f) > 0
            from Friendship f
            where (f.userA.id = :viewerId and f.userB.id = :ownerId)
               or (f.userA.id = :ownerId and f.userB.id = :viewerId)
            """)
    boolean existsBetweenUsers(@Param("viewerId") Long viewerId, @Param("ownerId") Long ownerId);
}
