package p024io.realm.internal.async;

import p024io.realm.internal.Keep;

@Keep
/* renamed from: io.realm.internal.async.BadVersionException */
public class BadVersionException extends Exception {
    public BadVersionException(String detailMessage) {
        super(detailMessage);
    }

    public BadVersionException(String detailMessage, Throwable exception) {
        super(detailMessage, exception);
    }
}
