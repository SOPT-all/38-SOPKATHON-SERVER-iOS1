package soptkathon_iOS1.domain.funeral.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "조문 댓글 정보")
public record CondolenceResponse(
        @Schema(description = "댓글 ID", example = "1")
        Long commentId,
        @Schema(description = "댓글 작성자 ID", example = "2")
        Long userId,
        @Schema(description = "댓글 작성자 닉네임", example = "민수")
        String nickname,
        @Schema(description = "댓글 내용", example = "그렇게 될 줄 알았다 ㅋㅋㅋ")
        String content,
        @Schema(description = "댓글 작성 시각", example = "2026-05-17T11:00:00")
        LocalDateTime createdAt
) {
}
