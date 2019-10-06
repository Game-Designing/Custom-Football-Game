package com.fyber.inneractive.sdk.util;

import android.net.Uri;

/* renamed from: com.fyber.inneractive.sdk.util.z */
public abstract class C8046z {

    /* renamed from: a */
    private boolean f16405a = true;

    /* renamed from: n */
    protected StringBuilder f16406n;

    public C8046z(String str) {
        this.f16406n = new StringBuilder(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo24876a(String str, String str2) {
        String str3;
        if (!C8017o.m18100a(str2)) {
            StringBuilder sb = this.f16406n;
            if (this.f16405a) {
                this.f16405a = false;
                str3 = "?";
            } else {
                str3 = "&";
            }
            sb.append(str3);
            this.f16406n.append(str);
            this.f16406n.append("=");
            this.f16406n.append(Uri.encode(str2));
        }
    }
}
