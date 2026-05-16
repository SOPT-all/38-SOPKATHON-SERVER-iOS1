package soptkathon_iOS1.domain.goal.exception;

import soptkathon_iOS1.global.exception.BaseErrorCode;
import soptkathon_iOS1.global.exception.CustomException;

public class GoalException extends CustomException {
    public GoalException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
