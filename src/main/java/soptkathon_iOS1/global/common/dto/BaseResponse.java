package soptkathon_iOS1.global.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import soptkathon_iOS1.global.common.entity.SuccessCode;
import soptkathon_iOS1.global.exception.BaseErrorCode;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {
    private final int status;
    private final String code;
    private final String message;
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
