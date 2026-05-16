package soptkathon_iOS1.domain.user.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import soptkathon_iOS1.global.exception.BaseErrorCode;

@Getter
@AllArgsConstructor
public enum UserErrorCode implements BaseErrorCode {
    USER_NOT_FOUND(404, "USER_001", "사용자를 찾을 수 없습니다.");

    private final int status;
    private final String code;
    private final String message;
}
