package soptkathon_iOS1.global.common.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessCode {
    // 공통 조회 성공
    GET_SUCCESS(200, "GETSUCCESS", "조회에 성공하였습니다."),

    // 목표 리스트 조회 성공
    GET_GOAL_LIST_SUCCESS(200, "GET_GOAL_LIST_SUCCESS", "목표 리스트 조회에 성공하였습니다.");

    private final int status;
    private final String code;
    private final String message;
}
