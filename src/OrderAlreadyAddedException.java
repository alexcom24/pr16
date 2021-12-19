public class OrderAlreadyAddedException extends Exception{
    public OrderAlreadyAddedException() {
    }

    public OrderAlreadyAddedException(String message) {
        super(message);
    }

    public OrderAlreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderAlreadyAddedException(Throwable cause) {
        super(cause);
    }

    public OrderAlreadyAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
