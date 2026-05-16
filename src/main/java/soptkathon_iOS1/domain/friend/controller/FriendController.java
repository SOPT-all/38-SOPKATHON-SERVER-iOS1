package soptkathon_iOS1.domain.friend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import soptkathon_iOS1.domain.friend.dto.FriendResponse;
import soptkathon_iOS1.domain.friend.service.FriendService;
import soptkathon_iOS1.global.common.dto.BaseResponse;
import soptkathon_iOS1.global.common.entity.SuccessCode;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Friend", description = "친구 관련 API")
public class FriendController {

    private final FriendService friendService;

    @GetMapping("/api/v1/{userId}/friends")
    @Operation(
            summary = "나의 친구 목록 조회",
            description = "친구 선택 모달에 노출할 사용자의 전체 친구 목록을 조회합니다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "친구 목록 조회 성공"),
            @ApiResponse(
                    responseCode = "404",
                    description = "사용자를 찾을 수 없음",
                    content = @Content(schema = @Schema(implementation = BaseResponse.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "서버 내부 오류",
                    content = @Content(schema = @Schema(implementation = BaseResponse.class))
            )
    })
    public ResponseEntity<BaseResponse<List<FriendResponse>>> getFriends(
            @Parameter(description = "친구 목록을 조회할 사용자 ID", example = "1", required = true)
            @PathVariable Long userId
    ) {
        List<FriendResponse> friends = friendService.getFriends(userId);
        return ResponseEntity.ok(BaseResponse.success(SuccessCode.GET_SUCCESS, friends));
    }
}
