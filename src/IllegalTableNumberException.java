public class IllegalTableNumberException extends Exception{
    public IllegalTableNumberException() {
    }

    public IllegalTableNumberException(String message) {
        super(message);
    }

    public IllegalTableNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalTableNumberException(Throwable cause) {
        super(cause);
    }

    public IllegalTableNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
