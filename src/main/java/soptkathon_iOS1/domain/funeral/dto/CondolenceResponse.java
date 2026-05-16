package soptkathon_iOS1.domain.funeral.dto;

import java.time.LocalDateTime;

public record CondolenceResponse(
        Long commentId,
        Long userId,
        String nickname,
        String content,
        LocalDateTime createdAt
) {
}
