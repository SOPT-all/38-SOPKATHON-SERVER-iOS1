package soptkathon_iOS1.domain.friend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soptkathon_iOS1.domain.friend.dto.FriendResponse;
import soptkathon_iOS1.domain.friendship.entity.Friendship;
import soptkathon_iOS1.domain.friendship.repository.FriendshipRepository;
import soptkathon_iOS1.domain.user.entity.User;
import soptkathon_iOS1.domain.user.exception.UserErrorCode;
import soptkathon_iOS1.domain.user.exception.UserException;
import soptkathon_iOS1.domain.user.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FriendService {

    private final UserRepository userRepository;
    private final FriendshipRepository friendshipRepository;

    public List<FriendResponse> getFriends(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserException(UserErrorCode.USER_NOT_FOUND);
        }

        return friendshipRepository.findAllByUserId(userId)
                .stream()
                .map(friendship -> toFriendResponse(friendship, userId))
                .toList();
    }

    private FriendResponse toFriendResponse(Friendship friendship, Long userId) {
        User friend = friendship.getUserA().getId().equals(userId)
                ? friendship.getUserB()
                : friendship.getUserA();

        return new FriendResponse(
                friend.getId(),
                friend.getNickname(),
                friendship.getId(),
                friendship.getCreatedAt()
        );
    }
}
