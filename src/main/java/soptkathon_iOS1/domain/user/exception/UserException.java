package soptkathon_iOS1.domain.user.exception;

import soptkathon_iOS1.global.exception.BaseErrorCode;
import soptkathon_iOS1.global.exception.CustomException;

public class UserException extends CustomException {
    public UserException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
