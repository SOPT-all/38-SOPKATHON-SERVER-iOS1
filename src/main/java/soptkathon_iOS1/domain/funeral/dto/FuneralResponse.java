package soptkathon_iOS1.domain.funeral.dto;

import java.time.LocalDateTime;
import java.util.List;

public record FuneralResponse(
        Long goalId,
        String title,
        String description,
        FuneralOwnerResponse owner,
        LocalDateTime createdAt,
        LocalDateTime expiredAt,
        long condolenceCount,
        List<CondolenceResponse> condolences
) {
}
