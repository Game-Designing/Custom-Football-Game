package p005cm.aptoide.p006pt.utils;

/* renamed from: cm.aptoide.pt.utils.BaseException */
public abstract class BaseException extends RuntimeException {
    public BaseException() {
    }

    public BaseException(String detailMessage) {
        super(detailMessage);
    }

    public BaseException(Throwable throwable) {
        super(throwable);
    }
}
