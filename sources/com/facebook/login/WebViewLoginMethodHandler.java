package com.facebook.login;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.p000v4.app.C0014p;
import com.facebook.C6665h;
import com.facebook.FacebookException;
import com.facebook.internal.C6694S;
import com.facebook.internal.C6702Y;
import com.facebook.internal.C6702Y.C6703a;
import com.facebook.internal.C6702Y.C6705c;
import com.facebook.internal.C6728p;
import com.facebook.login.LoginClient.Request;
import p005cm.aptoide.p006pt.account.view.LoginActivity;

class WebViewLoginMethodHandler extends WebLoginMethodHandler {
    public static final Creator<WebViewLoginMethodHandler> CREATOR = new C6751G();

    /* renamed from: d */
    private C6702Y f12408d;

    /* renamed from: e */
    private String f12409e;

    /* renamed from: com.facebook.login.WebViewLoginMethodHandler$a */
    static class C6755a extends C6703a {

        /* renamed from: h */
        private String f12410h;

        /* renamed from: i */
        private String f12411i;

        /* renamed from: j */
        private String f12412j = "fbconnect://success";

        public C6755a(Context context, String applicationId, Bundle parameters) {
            super(context, applicationId, "oauth", parameters);
        }

        /* renamed from: b */
        public C6755a mo20094b(String e2e) {
            this.f12410h = e2e;
            return this;
        }

        /* renamed from: a */
        public C6755a mo20093a(boolean isChromeOS) {
            this.f12412j = isChromeOS ? "fbconnect://chrome_os_success" : "fbconnect://success";
            return this;
        }

        /* renamed from: a */
        public C6755a mo20092a(String authType) {
            this.f12411i = authType;
            return this;
        }

        /* renamed from: a */
        public C6702Y mo19934a() {
            Bundle parameters = mo19938e();
            parameters.putString("redirect_uri", this.f12412j);
            parameters.putString("client_id", mo19935b());
            parameters.putString("e2e", this.f12410h);
            parameters.putString("response_type", "token,signed_request");
            parameters.putString("return_scopes", "true");
            parameters.putString(LoginActivity.AUTH_TYPE, this.f12411i);
            return C6702Y.m13472a(mo19936c(), "oauth", parameters, mo19939f(), mo19937d());
        }
    }

    WebViewLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo20000b() {
        return "web_view";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public C6665h mo20003e() {
        return C6665h.WEB_VIEW;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo20085c() {
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo20031a() {
        C6702Y y = this.f12408d;
        if (y != null) {
            y.cancel();
            this.f12408d = null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo19999a(Request request) {
        Bundle parameters = mo20089b(request);
        C6705c listener = new C6750F(this, request);
        this.f12409e = LoginClient.m13687e();
        mo20083a("e2e", this.f12409e);
        C0014p fragmentActivity = this.f12406b.mo20048c();
        boolean isChromeOS = C6694S.m13448e((Context) fragmentActivity);
        C6755a aVar = new C6755a(fragmentActivity, request.mo20061a(), parameters);
        aVar.mo20094b(this.f12409e);
        aVar.mo20093a(isChromeOS);
        aVar.mo20092a(request.mo20065c());
        this.f12408d = aVar.mo19933a(listener).mo19934a();
        C6728p dialogFragment = new C6728p();
        dialogFragment.setRetainInstance(true);
        dialogFragment.mo19968a((Dialog) this.f12408d);
        dialogFragment.show(fragmentActivity.getSupportFragmentManager(), "FacebookDialogFragment");
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo20090b(Request request, Bundle values, FacebookException error) {
        super.mo20088a(request, values, error);
    }

    WebViewLoginMethodHandler(Parcel source) {
        super(source);
        this.f12409e = source.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.f12409e);
    }
}
