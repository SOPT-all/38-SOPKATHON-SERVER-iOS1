package soptkathon_iOS1.domain.funeral.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soptkathon_iOS1.domain.comment.entity.Comment;
import soptkathon_iOS1.domain.comment.repository.CommentRepository;
import soptkathon_iOS1.domain.friendship.repository.FriendshipRepository;
import soptkathon_iOS1.domain.funeral.dto.CondolenceResponse;
import soptkathon_iOS1.domain.funeral.dto.FuneralOwnerResponse;
import soptkathon_iOS1.domain.funeral.dto.FuneralResponse;
import soptkathon_iOS1.domain.goal.entity.Goal;
import soptkathon_iOS1.domain.goal.repository.GoalRepository;
import soptkathon_iOS1.domain.user.entity.User;
import soptkathon_iOS1.domain.user.repository.UserRepository;
import soptkathon_iOS1.global.exception.CustomException;
import soptkathon_iOS1.global.exception.ErrorCode;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FuneralService {
    private final UserRepository userRepository;
    private final GoalRepository goalRepository;
    private final FriendshipRepository friendshipRepository;
    private final CommentRepository commentRepository;

    public FuneralResponse getFuneral(Long viewerId, Long goalId) {
        User viewer = userRepository.findById(viewerId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));
        Goal goal = goalRepository.findById(goalId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND));

        validateAccess(viewer, goal.getUser());

        List<Comment> comments = commentRepository.findAllWithWriterByGoalIdOrderByCreatedAtAsc(goalId);
        List<CondolenceResponse> condolences = comments.stream()
                .map(this::toCondolenceResponse)
                .toList();

        return new FuneralResponse(
                goal.getId(),
                goal.getTitle(),
                goal.getDescription(),
                toOwnerResponse(goal.getUser()),
                goal.getCreatedAt(),
                goal.getExpiredAt(),
                commentRepository.countByGoalId(goalId),
                condolences
        );
    }

    private void validateAccess(User viewer, User owner) {
        boolean isOwner = viewer.getId().equals(owner.getId());

        if (!isOwner && !friendshipRepository.existsBetweenUsers(viewer.getId(), owner.getId())) {
            throw new CustomException(ErrorCode.FORBIDDEN);
        }
    }

    private FuneralOwnerResponse toOwnerResponse(User user) {
        return new FuneralOwnerResponse(
                user.getId(),
                user.getNickname()
        );
    }

    private CondolenceResponse toCondolenceResponse(Comment comment) {
        return new CondolenceResponse(
                comment.getId(),
                comment.getUser().getId(),
                comment.getUser().getNickname(),
                comment.getContent(),
                comment.getCreatedAt()
        );
    }
}
