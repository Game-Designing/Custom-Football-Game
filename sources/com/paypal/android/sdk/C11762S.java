package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.paypal.android.sdk.S */
public final class C11762S {

    /* renamed from: a */
    private String f37009a;

    /* renamed from: b */
    private String f37010b;

    /* renamed from: c */
    private Map f37011c = new HashMap();

    public C11762S(String str, String str2) {
        this.f37009a = str;
        this.f37010b = str2;
    }

    /* renamed from: a */
    public final String mo38622a() {
        return this.f37009a;
    }

    /* renamed from: b */
    public final String mo38623b() {
        return this.f37010b;
    }

    /* renamed from: c */
    public final Map mo38624c() {
        return this.f37011c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(C11762S.class.getSimpleName());
        sb.append("(");
        sb.append(this.f37009a);
        sb.append(",mEndpoints=");
        sb.append(this.f37011c);
        sb.append(")");
        return sb.toString();
    }
}
