package soptkathon_iOS1.domain.friend.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "친구 목록 조회 응답")
public record FriendResponse(
        @Schema(description = "친구 사용자 ID", example = "2")
        Long friendId,

        @Schema(description = "친구 닉네임", example = "민지")
        String nickname,

        @Schema(description = "친구 관계 ID", example = "10")
        Long friendshipId,

        @Schema(description = "친구 관계 생성 시각", example = "2026-05-17T09:30:00")
        LocalDateTime createdAt
) {
}
