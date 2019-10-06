package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.C6665h;
import com.facebook.C6787r;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.facebook.internal.C6694S;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import java.util.Collection;
import java.util.Locale;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.account.view.LoginActivity;

abstract class WebLoginMethodHandler extends LoginMethodHandler {

    /* renamed from: c */
    private String f12407c;

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public abstract C6665h mo20003e();

    /* renamed from: f */
    private static final String m13753f() {
        StringBuilder sb = new StringBuilder();
        sb.append("fb");
        sb.append(C6787r.m13816f());
        sb.append("://authorize");
        return sb.toString();
    }

    WebLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    WebLoginMethodHandler(Parcel source) {
        super(source);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo20001d() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Bundle mo20089b(Request request) {
        Bundle parameters = new Bundle();
        if (!C6694S.m13430a((Collection<T>) request.mo20071h())) {
            String scope = TextUtils.join(",", request.mo20071h());
            String str = "scope";
            parameters.putString(str, scope);
            mo20083a(str, scope);
        }
        parameters.putString("default_audience", request.mo20066d().mo20097e());
        parameters.putString("state", mo20081a(request.mo20064b()));
        AccessToken previousToken = AccessToken.m12820c();
        String previousTokenString = previousToken != null ? previousToken.mo19631k() : null;
        String str2 = "access_token";
        if (previousTokenString == null || !previousTokenString.equals(m13754g())) {
            C6694S.m13415a((Context) this.f12406b.mo20048c());
            mo20083a(str2, BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
        } else {
            parameters.putString(str2, previousTokenString);
            mo20083a(str2, "1");
        }
        return parameters;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Bundle mo20087a(Bundle parameters, Request request) {
        parameters.putString("redirect_uri", m13753f());
        parameters.putString("client_id", request.mo20061a());
        LoginClient loginClient = this.f12406b;
        parameters.putString("e2e", LoginClient.m13687e());
        parameters.putString("response_type", "token,signed_request");
        parameters.putString("return_scopes", "true");
        parameters.putString(LoginActivity.AUTH_TYPE, request.mo20065c());
        if (mo20001d() != null) {
            parameters.putString("sso", mo20001d());
        }
        return parameters;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo20088a(Request request, Bundle values, FacebookException error) {
        Result outcome;
        this.f12407c = null;
        if (values != null) {
            String str = "e2e";
            if (values.containsKey(str)) {
                this.f12407c = values.getString(str);
            }
            try {
                AccessToken token = LoginMethodHandler.m13734a(request.mo20071h(), values, mo20003e(), request.mo20061a());
                outcome = Result.m13725a(this.f12406b.mo20055i(), token);
                CookieSyncManager.createInstance(this.f12406b.mo20048c()).sync();
                m13752d(token.mo19631k());
            } catch (FacebookException ex) {
                outcome = Result.m13727a(this.f12406b.mo20055i(), null, ex.getMessage());
            }
        } else if (error instanceof FacebookOperationCanceledException) {
            outcome = Result.m13726a(this.f12406b.mo20055i(), "User canceled log in.");
        } else {
            this.f12407c = null;
            String errorCode = null;
            String errorMessage = error.getMessage();
            if (error instanceof FacebookServiceException) {
                FacebookRequestError requestError = ((FacebookServiceException) error).mo19671a();
                errorCode = String.format(Locale.ROOT, "%d", new Object[]{Integer.valueOf(requestError.mo19661b())});
                errorMessage = requestError.toString();
            }
            outcome = Result.m13728a(this.f12406b.mo20055i(), null, errorMessage, errorCode);
        }
        if (!C6694S.m13436b(this.f12407c)) {
            mo20084c(this.f12407c);
        }
        this.f12406b.mo20045b(outcome);
    }

    /* renamed from: g */
    private String m13754g() {
        return this.f12406b.mo20048c().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", "");
    }

    /* renamed from: d */
    private void m13752d(String token) {
        this.f12406b.mo20048c().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString("TOKEN", token).apply();
    }
}
