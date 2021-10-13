package semifir.kira.exo.tdd;

public class PyramideBadArgumentException extends RuntimeException{
    public PyramideBadArgumentException() {
    }

    public PyramideBadArgumentException(String message) {
        super(message);
    }

    public PyramideBadArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public PyramideBadArgumentException(Throwable cause) {
        super(cause);
    }

    public PyramideBadArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
