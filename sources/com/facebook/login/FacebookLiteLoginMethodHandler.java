package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.C6678J;
import com.facebook.login.LoginClient.Request;
import java.util.Collection;

class FacebookLiteLoginMethodHandler extends NativeAppLoginMethodHandler {
    public static final Creator<FacebookLiteLoginMethodHandler> CREATOR = new C6767l();

    FacebookLiteLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo20000b() {
        return "fb_lite_login";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo19999a(Request request) {
        String e2e = LoginClient.m13687e();
        Intent intent = C6678J.m13337a((Context) this.f12406b.mo20048c(), request.mo20061a(), (Collection<String>) request.mo20071h(), e2e, request.mo20073j(), request.mo20072i(), request.mo20066d(), mo20081a(request.mo20064b()), request.mo20065c());
        mo20083a("e2e", e2e);
        return mo20086a(intent, LoginClient.m13688h());
    }

    FacebookLiteLoginMethodHandler(Parcel source) {
        super(source);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }
}
