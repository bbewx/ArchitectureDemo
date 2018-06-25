/*
 * 创建 WJL 2017-04-04 18:08
 */
package exception;

/**
 * 。
 * <p>
 */
public class UserException extends RuntimeException {
    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }
}
