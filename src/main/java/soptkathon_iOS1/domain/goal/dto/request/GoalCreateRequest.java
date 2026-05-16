package soptkathon_iOS1.domain.goal.dto.request;

public record GoalCreateRequest(
        String title,
        String expiredAt
) {
}
