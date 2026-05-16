package soptkathon_iOS1.domain.goal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soptkathon_iOS1.domain.goal.dto.request.GoalCreateRequest;
import soptkathon_iOS1.domain.goal.dto.response.GoalCreateResponse;
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

    @PostMapping("/{userId}/goals")
    public ResponseEntity<BaseResponse<GoalCreateResponse>> createGoal(
            @PathVariable Long userId,
            @RequestBody GoalCreateRequest request
    ) {
        GoalCreateResponse response = goalService.createGoal(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BaseResponse.success(SuccessCode.CREATE_GOAL_SUCCESS, response));
    }
}
