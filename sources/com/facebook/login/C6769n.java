package com.facebook.login;

import android.os.Bundle;
import com.facebook.internal.C6687L.C6688a;
import com.facebook.login.LoginClient.Request;

/* renamed from: com.facebook.login.n */
/* compiled from: GetTokenLoginMethodHandler */
class C6769n implements C6688a {

    /* renamed from: a */
    final /* synthetic */ Request f12434a;

    /* renamed from: b */
    final /* synthetic */ GetTokenLoginMethodHandler f12435b;

    C6769n(GetTokenLoginMethodHandler this$0, Request request) {
        this.f12435b = this$0;
        this.f12434a = request;
    }

    /* renamed from: a */
    public void mo19905a(Bundle result) {
        this.f12435b.mo20033b(this.f12434a, result);
    }
}
