package soptkathon_iOS1.domain.funeral.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "장례식장 조회 응답")
public record FuneralResponse(
        @Schema(description = "목표 ID", example = "1")
        Long goalId,
        @Schema(description = "목표 제목", example = "다이어트")
        String title,
        @Schema(description = "목표 설명", example = "너무 많이 먹어서")
        String description,
        @Schema(description = "장례식장 주인 정보")
        FuneralOwnerResponse owner,
        @Schema(description = "목표 생성 시각", example = "2026-05-15T10:00:00")
        LocalDateTime createdAt,
        @Schema(description = "목표 만료 시각", example = "2026-05-16T23:59:59")
        LocalDateTime expiredAt,
        @Schema(description = "조문 댓글 수", example = "10")
        long condolenceCount,
        @Schema(description = "조문 댓글 목록")
        List<CondolenceResponse> condolences
) {
}
