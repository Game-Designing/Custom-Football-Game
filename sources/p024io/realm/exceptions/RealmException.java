package p024io.realm.exceptions;

import p024io.realm.internal.Keep;

@Keep
/* renamed from: io.realm.exceptions.RealmException */
public final class RealmException extends RuntimeException {
    public RealmException(String detailMessage) {
        super(detailMessage);
    }

    public RealmException(String detailMessage, Throwable exception) {
        super(detailMessage, exception);
    }
}
