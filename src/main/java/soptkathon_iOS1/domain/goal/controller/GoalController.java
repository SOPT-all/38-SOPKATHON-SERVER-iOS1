package soptkathon_iOS1.domain.goal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soptkathon_iOS1.domain.goal.dto.response.GoalListResponse;
import soptkathon_iOS1.domain.goal.service.GoalService;
import soptkathon_iOS1.global.common.dto.BaseResponse;
import soptkathon_iOS1.global.common.entity.SuccessCode;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class GoalController {
    private final GoalService goalService;

    @GetMapping("/{userId}/goals")
    public ResponseEntity<BaseResponse<List<GoalListResponse>>> getGoals(@PathVariable Long userId) {
        List<GoalListResponse> goals = goalService.getGoalsByUserId(userId);
        return ResponseEntity.ok(BaseResponse.success(SuccessCode.GET_GOAL_LIST_SUCCESS, goals));
    }
}
