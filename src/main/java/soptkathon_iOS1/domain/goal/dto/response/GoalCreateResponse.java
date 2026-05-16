package soptkathon_iOS1.domain.goal.dto.response;

import soptkathon_iOS1.domain.goal.entity.Goal;

import java.time.LocalDateTime;

public record GoalCreateResponse(
        Long goalId,
        String title,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime expiredAt
) {
    public static GoalCreateResponse from(Goal goal) {
        return new GoalCreateResponse(
                goal.getId(),
                goal.getTitle(),
                goal.getCreatedAt(),
                goal.getUpdatedAt(),
                goal.getExpiredAt()
        );
    }
}
