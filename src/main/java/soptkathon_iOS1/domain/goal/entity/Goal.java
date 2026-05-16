package soptkathon_iOS1.domain.goal.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import soptkathon_iOS1.domain.user.entity.User;
import soptkathon_iOS1.global.common.entity.BaseTimeEntity;

import java.time.LocalDateTime;

@Entity
@Table(name="goals")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Goal extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private GoalStatus status;

    @Column(name = "expired_at")
    private LocalDateTime expiredAt;

    @Builder
    private Goal(User user, String title, String description, GoalStatus status, LocalDateTime expiredAt) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.status = status;
        this.expiredAt = expiredAt;
    }
}
