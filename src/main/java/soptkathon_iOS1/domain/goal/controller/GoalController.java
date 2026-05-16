package soptkathon_iOS1.domain.goal.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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

@Tag(name = "Goal", description = "목표 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class GoalController {

    private final GoalService goalService;

    @Operation(summary = "목표 목록 조회", description = "사용자의 전체 목표 목록을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "목표 목록 조회 성공")
    @GetMapping("/{userId}/goals")
    public ResponseEntity<BaseResponse<List<GoalListResponse>>> getGoals(
            @Parameter(description = "사용자 ID") @PathVariable Long userId
    ) {
        List<GoalListResponse> goals = goalService.getGoalsByUserId(userId);
        return ResponseEntity.ok(BaseResponse.success(SuccessCode.GET_GOAL_LIST_SUCCESS, goals));
    }

    @Operation(summary = "목표 추가", description = "새로운 목표를 생성합니다.")
    @ApiResponse(responseCode = "201", description = "목표 생성 성공")
    @PostMapping("/{userId}/goals")
    public ResponseEntity<BaseResponse<GoalCreateResponse>> createGoal(
            @Parameter(description = "사용자 ID") @PathVariable Long userId,
            @Valid @RequestBody GoalCreateRequest request
    ) {
        GoalCreateResponse response = goalService.createGoal(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BaseResponse.success(SuccessCode.CREATE_GOAL_SUCCESS, response));
    }
}
