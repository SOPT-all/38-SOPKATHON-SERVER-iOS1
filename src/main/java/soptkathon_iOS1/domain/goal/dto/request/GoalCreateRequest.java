package soptkathon_iOS1.domain.goal.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "목표 생성 요청")
public record GoalCreateRequest(
        @Schema(description = "목표 제목", example = "다이어트")
        String title,

        @Schema(description = "목표 마감일", example = "2026.06.17")
        String expiredAt
) {
}
