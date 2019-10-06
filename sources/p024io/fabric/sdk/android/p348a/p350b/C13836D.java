package p024io.fabric.sdk.android.p348a.p350b;

/* renamed from: io.fabric.sdk.android.a.b.D */
/* compiled from: ResponseParser */
public class C13836D {
    /* renamed from: a */
    public static int m43981a(int statusCode) {
        if (statusCode >= 200 && statusCode <= 299) {
            return 0;
        }
        if (statusCode >= 300 && statusCode <= 399) {
            return 1;
        }
        if (statusCode < 400 || statusCode > 499) {
            return statusCode >= 500 ? 1 : 1;
        }
        return 0;
    }
}
