package com.facebook.login;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.C6702Y.C6705c;
import com.facebook.login.LoginClient.Request;

/* renamed from: com.facebook.login.F */
/* compiled from: WebViewLoginMethodHandler */
class C6750F implements C6705c {

    /* renamed from: a */
    final /* synthetic */ Request f12371a;

    /* renamed from: b */
    final /* synthetic */ WebViewLoginMethodHandler f12372b;

    C6750F(WebViewLoginMethodHandler this$0, Request request) {
        this.f12372b = this$0;
        this.f12371a = request;
    }

    /* renamed from: a */
    public void mo19945a(Bundle values, FacebookException error) {
        this.f12372b.mo20090b(this.f12371a, values, error);
    }
}
