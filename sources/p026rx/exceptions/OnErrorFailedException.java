package p026rx.exceptions;

/* renamed from: rx.exceptions.OnErrorFailedException */
public class OnErrorFailedException extends RuntimeException {
    public OnErrorFailedException(String message, Throwable e) {
        super(message, e != null ? e : new NullPointerException());
    }

    public OnErrorFailedException(Throwable e) {
        super(e != null ? e.getMessage() : null, e != null ? e : new NullPointerException());
    }
}
