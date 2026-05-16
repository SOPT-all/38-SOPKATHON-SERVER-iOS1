package soptkathon_iOS1.domain.goal.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Schema(description = "목표 생성 요청")
public record GoalCreateRequest(
        @Schema(description = "목표 제목", example = "다이어트")
        @NotBlank(message = "목표 제목은 필수입니다.")
        String title,

        @Schema(description = "목표 마감일", example = "2026.06.17")
        @NotBlank(message = "목표 마감일은 필수입니다.")
        @Pattern(regexp = "\\d{4}\\.\\d{2}\\.\\d{2}", message = "목표 마감일 형식은 yyyy.MM.dd 이어야 합니다.")
        String expiredAt
) {
}
