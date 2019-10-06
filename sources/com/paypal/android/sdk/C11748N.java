package com.paypal.android.sdk;

/* renamed from: com.paypal.android.sdk.N */
public class C11748N {

    /* renamed from: a */
    private static final String f36758a = C11748N.class.getSimpleName();

    /* renamed from: b */
    public static final C11748N f36759b = new C11748N();

    /* renamed from: c */
    private byte[] f36760c;

    private C11748N() {
        this.f36760c = null;
        this.f36760c = null;
    }

    public C11748N(String str) {
        this.f36760c = null;
        try {
            this.f36760c = new byte[((str.length() + 1) / 2)];
            int length = str.length() - 1;
            int i = 0;
            while (length >= 0) {
                int i2 = length - 1;
                if (i2 < 0) {
                    i2 = 0;
                }
                this.f36760c[i] = (byte) Integer.parseInt(str.substring(i2, length + 1), 16);
                length -= 2;
                i++;
            }
        } catch (Exception e) {
            C11754P.m38932a(f36758a, "PPRiskDataBitSet initialize failed", (Throwable) e);
            this.f36760c = null;
        }
    }

    /* renamed from: a */
    public final boolean mo38602a(C11751O o) {
        int a = o.mo38609a() / 8;
        byte[] bArr = this.f36760c;
        if (bArr == null) {
            return true;
        }
        if (a >= bArr.length) {
            return false;
        }
        byte a2 = (byte) (1 << (o.mo38609a() % 8));
        return (bArr[a] & a2) == a2;
    }
}
