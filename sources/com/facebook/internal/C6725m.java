package com.facebook.internal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.C6787r;
import p002b.p003c.p049c.C1163b;
import p002b.p003c.p049c.C1163b.C1164a;

/* renamed from: com.facebook.internal.m */
/* compiled from: CustomTab */
public class C6725m {

    /* renamed from: a */
    private Uri f12294a;

    public C6725m(String action, Bundle parameters) {
        if (parameters == null) {
            parameters = new Bundle();
        }
        String b = C6690N.m13388b();
        StringBuilder sb = new StringBuilder();
        sb.append(C6787r.m13824n());
        sb.append("/");
        sb.append("dialog/");
        sb.append(action);
        this.f12294a = C6694S.m13397a(b, sb.toString(), parameters);
    }

    /* renamed from: a */
    public void mo19967a(Activity activity, String packageName) {
        C1163b customTabsIntent = new C1164a().mo8787b();
        customTabsIntent.f3816a.setPackage(packageName);
        customTabsIntent.f3816a.addFlags(1073741824);
        customTabsIntent.mo8779a(activity, this.f12294a);
    }
}
