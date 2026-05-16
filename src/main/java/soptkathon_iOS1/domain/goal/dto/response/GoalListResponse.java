package soptkathon_iOS1.domain.goal.dto.response;

import soptkathon_iOS1.domain.goal.entity.Goal;
import soptkathon_iOS1.domain.goal.entity.GoalStatus;

import java.time.LocalDateTime;

public record GoalListResponse(
        Long goalId,
        String title,
        String dDay,
        GoalStatus status,
        LocalDateTime expiredAt
) {
    public static GoalListResponse of(Goal goal, String dDay) {
        return new GoalListResponse(
                goal.getId(),
                goal.getTitle(),
                dDay,
                goal.getStatus(),
                goal.getExpiredAt()
        );
    }
}
