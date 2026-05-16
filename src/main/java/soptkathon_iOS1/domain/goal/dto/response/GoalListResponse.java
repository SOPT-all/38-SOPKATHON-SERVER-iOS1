package soptkathon_iOS1.domain.goal.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import soptkathon_iOS1.domain.goal.entity.Goal;
import soptkathon_iOS1.domain.goal.entity.GoalStatus;

import java.time.LocalDateTime;

@Schema(description = "목표 목록 조회 응답")
public record GoalListResponse(
        @Schema(description = "목표 ID", example = "1")
        Long goalId,

        @Schema(description = "목표 제목", example = "다이어트")
        String title,

        @Schema(description = "D-Day", example = "D-20")
        String dDay,

        @Schema(description = "목표 상태", example = "IN_PROGRESS")
        GoalStatus status,

        @Schema(description = "목표 마감일시", example = "2026-06-17T23:59:59")
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
