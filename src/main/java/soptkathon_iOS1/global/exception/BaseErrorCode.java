package soptkathon_iOS1.global.exception;

public interface BaseErrorCode {
    int getStatus();
    String getCode();
    String getMessage();
}
