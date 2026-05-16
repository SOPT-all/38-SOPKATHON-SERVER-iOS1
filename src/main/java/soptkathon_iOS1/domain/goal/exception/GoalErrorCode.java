package soptkathon_iOS1.domain.goal.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import soptkathon_iOS1.global.exception.BaseErrorCode;

@Getter
@AllArgsConstructor
public enum GoalErrorCode implements BaseErrorCode {
    GOAL_NOT_FOUND(404, "GOAL_001", "목표를 찾을 수 없습니다."),
    GOAL_ALREADY_COMPLETED(400, "GOAL_002", "이미 완료된 목표입니다."),
    GOAL_ALREADY_DEAD(400, "GOAL_003", "이미 사망한 목표입니다.");

    private final int status;
    private final String code;
    private final String message;
}
