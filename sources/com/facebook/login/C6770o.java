package com.facebook.login;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.C6694S.C6695a;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.login.o */
/* compiled from: GetTokenLoginMethodHandler */
class C6770o implements C6695a {

    /* renamed from: a */
    final /* synthetic */ Bundle f12436a;

    /* renamed from: b */
    final /* synthetic */ Request f12437b;

    /* renamed from: c */
    final /* synthetic */ GetTokenLoginMethodHandler f12438c;

    C6770o(GetTokenLoginMethodHandler this$0, Bundle bundle, Request request) {
        this.f12438c = this$0;
        this.f12436a = bundle;
        this.f12437b = request;
    }

    /* renamed from: a */
    public void mo19650a(JSONObject userInfo) {
        try {
            this.f12436a.putString("com.facebook.platform.extra.USER_ID", userInfo.getString("id"));
            this.f12438c.mo20034c(this.f12437b, this.f12436a);
        } catch (JSONException ex) {
            LoginClient loginClient = this.f12438c.f12406b;
            loginClient.mo20041a(Result.m13727a(loginClient.mo20055i(), "Caught exception", ex.getMessage()));
        }
    }

    /* renamed from: a */
    public void mo19649a(FacebookException error) {
        LoginClient loginClient = this.f12438c.f12406b;
        loginClient.mo20041a(Result.m13727a(loginClient.mo20055i(), "Caught exception", error.getMessage()));
    }
}
