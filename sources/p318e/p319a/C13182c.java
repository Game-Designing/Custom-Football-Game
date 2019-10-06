package p318e.p319a;

/* renamed from: e.a.c */
/* compiled from: Preconditions */
public final class C13182c {
    /* renamed from: a */
    public static <T> T m43110a(T reference) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static <T> T m43111a(T reference, String errorMessage) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(errorMessage);
    }
}
