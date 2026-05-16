package soptkathon_iOS1.domain.funeral.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "장례식장 주인 정보")
public record FuneralOwnerResponse(
        @Schema(description = "사용자 ID", example = "1")
        Long userId,
        @Schema(description = "닉네임", example = "민수")
        String nickname
) {
}
