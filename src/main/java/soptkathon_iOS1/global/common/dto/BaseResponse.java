package soptkathon_iOS1.global.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import soptkathon_iOS1.global.common.entity.SuccessCode;
import soptkathon_iOS1.global.exception.BaseErrorCode;

@Getter
@Schema(description = "공통 응답 형식")
public class BaseResponse<T> {
    @Schema(description = "HTTP 상태 코드", example = "200")
    private final int status;
    @Schema(description = "응답 코드", example = "GETSUCCESS")
    private final String code;
    @Schema(description = "응답 메시지", example = "조회에 성공하였습니다.")
    private final String message;
    @Schema(description = "응답 데이터")
    private final T data;

    private BaseResponse(int status, String code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> BaseResponse<T> success(SuccessCode successCode, T data) {
        return new BaseResponse<>(
                successCode.getStatus(),
                successCode.getCode(),
                successCode.getMessage(),
                data
        );
    }

    public static <T> BaseResponse<T> success(SuccessCode successCode) {
        return new BaseResponse<>(
                successCode.getStatus(),
                successCode.getCode(),
                successCode.getMessage(),
                null
        );
    }

    public static <T> BaseResponse<T> fail(BaseErrorCode errorCode) {
        return new BaseResponse<>(
                errorCode.getStatus(),
                errorCode.getCode(),
                errorCode.getMessage(),
                null
        );
    }
}
