package com.paypal.android.sdk;

/* renamed from: com.paypal.android.sdk.aa */
public abstract class C11789aa {

    /* renamed from: a */
    private String f37116a;

    /* renamed from: b */
    private String f37117b;

    private C11789aa(String str) {
    }

    protected C11789aa(String str, String str2) {
        this(str);
        this.f37116a = str2;
        this.f37117b = null;
    }

    protected C11789aa(String str, String str2, String str3, String str4) {
        this(str);
        this.f37116a = str2;
        this.f37117b = str3;
    }

    /* renamed from: a */
    public final String mo38699a() {
        return this.f37117b;
    }

    /* renamed from: b */
    public final String mo38700b() {
        return this.f37116a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ErrorBase[mErrorCode=");
        sb.append(this.f37116a);
        sb.append(" mErrorMsgShort=");
        sb.append(this.f37117b);
        sb.append("]");
        return sb.toString();
    }
}
