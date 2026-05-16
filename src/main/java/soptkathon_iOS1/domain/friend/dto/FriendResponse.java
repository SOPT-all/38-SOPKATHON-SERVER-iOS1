package soptkathon_iOS1.domain.friend.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class FriendResponse {
    private final Long friendId;
    private final String nickname;
    private final Long friendshipId;
    private final LocalDateTime createdAt;
}
