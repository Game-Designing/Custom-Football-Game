package p026rx.exceptions;

/* renamed from: rx.exceptions.OnCompletedFailedException */
public final class OnCompletedFailedException extends RuntimeException {
    public OnCompletedFailedException(Throwable throwable) {
        super(throwable != null ? throwable : new NullPointerException());
    }

    public OnCompletedFailedException(String message, Throwable throwable) {
        super(message, throwable != null ? throwable : new NullPointerException());
    }
}
