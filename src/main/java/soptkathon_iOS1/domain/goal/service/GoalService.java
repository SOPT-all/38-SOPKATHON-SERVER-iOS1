package soptkathon_iOS1.domain.goal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soptkathon_iOS1.domain.goal.dto.response.GoalListResponse;
import soptkathon_iOS1.domain.goal.entity.Goal;
import soptkathon_iOS1.domain.goal.repository.GoalRepository;
import soptkathon_iOS1.domain.user.exception.UserErrorCode;
import soptkathon_iOS1.domain.user.exception.UserException;
import soptkathon_iOS1.domain.user.repository.UserRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GoalService {
    private final GoalRepository goalRepository;
    private final UserRepository userRepository;

    public List<GoalListResponse> getGoalsByUserId(Long userId) {
        if(!userRepository.existsById(userId)) {
            throw new UserException(UserErrorCode.USER_NOT_FOUND);
        }

        List<Goal> goals = goalRepository.findAllByUserId(userId);
        List<GoalListResponse> response = goals.stream()
                .map(goal -> GoalListResponse.of(goal, calculateDDay(goal)))
                .toList();

        return response;
    }

    private String calculateDDay(Goal goal) {
        long diff = ChronoUnit.DAYS.between(LocalDate.now(), goal.getExpiredAt().toLocalDate());

        if (diff == 0) {
            return "D-Day";
        } else if (diff > 0) {
            return "D-" + diff;
        } else {
            return "D+" + Math.abs(diff);
        }
    }

}
