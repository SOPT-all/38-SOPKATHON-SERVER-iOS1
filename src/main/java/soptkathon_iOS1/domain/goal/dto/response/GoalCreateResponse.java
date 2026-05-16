package soptkathon_iOS1.domain.goal.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import soptkathon_iOS1.domain.goal.entity.Goal;

import java.time.LocalDateTime;

@Schema(description = "목표 생성 응답")
public record GoalCreateResponse(
        @Schema(description = "목표 ID", example = "1")
        Long goalId,

        @Schema(description = "목표 제목", example = "다이어트")
        String title,

        @Schema(description = "생성일시", example = "2026-05-17T10:00:00")
        LocalDateTime createdAt,

        @Schema(description = "수정일시", example = "2026-05-17T10:00:00")
        LocalDateTime updatedAt,

        @Schema(description = "목표 마감일시", example = "2026-06-17T23:59:59")
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
