package com.paypal.android.sdk;

import java.util.Locale;

/* renamed from: com.paypal.android.sdk.Ob */
public final class C11753Ob extends C11855oa {

    /* renamed from: f */
    private final boolean f36870f;

    /* renamed from: g */
    private final int f36871g;

    public C11753Ob(C11707Ba ba, int i, boolean z, int i2) {
        super(i, ba);
        this.f36870f = z;
        this.f36871g = i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final String mo38611b() {
        int i = this.f36871g;
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 != 0) {
                sb.append(",\n");
            }
            String str = new String(new char[4]);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i2);
            String substring = str.replace("\u0000", sb2.toString()).substring(0, 4);
            sb.append(String.format(Locale.US, "    {\n        \"type\":\"sms_otp\",\n        \"token_identifier\":\"mock_token_id_%s\",\n        \"token_identifier_display\":\"xxx-xxx-%s\"\n    }\n", new Object[]{Integer.valueOf(i2), substring}));
        }
        return String.format(Locale.US, "{\n    \"nonce\":\"mock-login-nonce\",\n    \"error\":\"2fa_required\",\n    \"error_description\":\"Unable to authenticate the user. 2fa flow completion is necessary for successful login.\",\n    \"visitor_id\":\"mock-visitor_id\",\n    \"2fa_enabled\":\"true\",\n    \"2fa_token_identifier\":[\n%s    ]\n}", new Object[]{sb.toString()});
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final int mo38612c() {
        return 401;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final boolean mo38613c(C11703Aa aa) {
        return this.f36870f && (aa instanceof C11732Hb) && !((C11732Hb) aa).mo38572t();
    }
}
