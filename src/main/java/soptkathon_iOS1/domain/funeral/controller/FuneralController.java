package soptkathon_iOS1.domain.funeral.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soptkathon_iOS1.domain.funeral.dto.FuneralResponse;
import soptkathon_iOS1.domain.funeral.service.FuneralService;
import soptkathon_iOS1.global.common.dto.BaseResponse;
import soptkathon_iOS1.global.common.entity.SuccessCode;

@Tag(name = "장례식장", description = "장례식장 화면 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class FuneralController {
    private final FuneralService funeralService;

    @Operation(
            summary = "장례식장 조회",
            description = "친구 뷰의 참여하기 이후 진입하는 장례식장 화면에 필요한 기본 정보와 조문 댓글 목록을 함께 조회합니다."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "장례식장 조회 성공",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "성공 응답",
                                    value = """
                                            {
                                              "status": 200,
                                              "code": "GETSUCCESS",
                                              "message": "조회에 성공하였습니다.",
                                              "data": {
                                                "goalId": 1,
                                                "title": "다이어트",
                                                "description": "너무 많이 먹어서",
                                                "owner": {
                                                  "userId": 1,
                                                  "nickname": "민수"
                                                },
                                                "createdAt": "2026-05-15T10:00:00",
                                                "expiredAt": "2026-05-16T23:59:59",
                                                "condolenceCount": 10,
                                                "condolences": [
                                                  {
                                                    "commentId": 1,
                                                    "userId": 2,
                                                    "nickname": "민수",
                                                    "content": "그렇게 될 줄 알았다 ㅋㅋㅋ",
                                                    "createdAt": "2026-05-17T11:00:00"
                                                  }
                                                ]
                                              }
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "장례식장 접근 권한 없음",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "접근 권한 없음",
                                    value = """
                                            {
                                              "status": 403,
                                              "code": "FORBIDDEN",
                                              "message": "접근 권한이 없습니다.",
                                              "data": null
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "사용자 또는 목표를 찾을 수 없음",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {
                                    @ExampleObject(
                                            name = "사용자 없음",
                                            value = """
                                                    {
                                                      "status": 404,
                                                      "code": "USER_001",
                                                      "message": "사용자를 찾을 수 없습니다.",
                                                      "data": null
                                                    }
                                                    """
                                    ),
                                    @ExampleObject(
                                            name = "목표 없음",
                                            value = """
                                                    {
                                                      "status": 404,
                                                      "code": "GOAL_001",
                                                      "message": "목표를 찾을 수 없습니다.",
                                                      "data": null
                                                    }
                                                    """
                                    )
                            }
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "서버 내부 오류",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "서버 오류",
                                    value = """
                                            {
                                              "status": 500,
                                              "code": "INTERNAL_SERVER_ERROR",
                                              "message": "서버 오류가 발생했습니다.",
                                              "data": null
                                            }
                                            """
                            )
                    )
            )
    })
    @GetMapping("/{userId}/goals/{goalId}/funeral")
    public BaseResponse<FuneralResponse> getFuneral(
            @Parameter(description = "장례식장에 접근한 사용자 ID", example = "1")
            @PathVariable Long userId,
            @Parameter(description = "장례식장을 조회할 목표 ID", example = "1")
            @PathVariable Long goalId
    ) {
        return BaseResponse.success(
                SuccessCode.GET_SUCCESS,
                funeralService.getFuneral(userId, goalId)
        );
    }
}
