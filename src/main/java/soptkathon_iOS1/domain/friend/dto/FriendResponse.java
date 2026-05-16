package soptkathon_iOS1.domain.friend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@Schema(description = "친구 목록 조회 응답")
public class FriendResponse {
    @Schema(description = "친구 사용자 ID", example = "2")
    private final Long friendId;

    @Schema(description = "친구 닉네임", example = "민지")
    private final String nickname;

    @Schema(description = "친구 관계 ID", example = "10")
    private final Long friendshipId;

    @Schema(description = "친구 관계 생성 시각", example = "2026-05-17T09:30:00")
    private final LocalDateTime createdAt;
}
