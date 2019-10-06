package com.mopub.volley.toolbox;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mopub.common.Constants;
import com.mopub.volley.AuthFailureError;

@SuppressLint({"MissingPermission"})
public class AndroidAuthenticator implements Authenticator {

    /* renamed from: a */
    private final AccountManager f36473a;

    /* renamed from: b */
    private final Account f36474b;

    /* renamed from: c */
    private final String f36475c;

    /* renamed from: d */
    private final boolean f36476d;

    public AndroidAuthenticator(Context context, Account account, String authTokenType) {
        this(context, account, authTokenType, false);
    }

    public AndroidAuthenticator(Context context, Account account, String authTokenType, boolean notifyAuthFailure) {
        this(AccountManager.get(context), account, authTokenType, notifyAuthFailure);
    }

    AndroidAuthenticator(AccountManager accountManager, Account account, String authTokenType, boolean notifyAuthFailure) {
        this.f36473a = accountManager;
        this.f36474b = account;
        this.f36475c = authTokenType;
        this.f36476d = notifyAuthFailure;
    }

    public Account getAccount() {
        return this.f36474b;
    }

    public String getAuthTokenType() {
        return this.f36475c;
    }

    public String getAuthToken() throws AuthFailureError {
        AccountManagerFuture<Bundle> future = this.f36473a.getAuthToken(this.f36474b, this.f36475c, this.f36476d, null, null);
        try {
            Bundle result = (Bundle) future.getResult();
            String authToken = null;
            if (future.isDone() && !future.isCancelled()) {
                String str = Constants.INTENT_SCHEME;
                if (!result.containsKey(str)) {
                    authToken = result.getString("authtoken");
                } else {
                    throw new AuthFailureError((Intent) result.getParcelable(str));
                }
            }
            if (authToken != null) {
                return authToken;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Got null auth token for type: ");
            sb.append(this.f36475c);
            throw new AuthFailureError(sb.toString());
        } catch (Exception e) {
            throw new AuthFailureError("Error while retrieving auth token", e);
        }
    }

    public void invalidateAuthToken(String authToken) {
        this.f36473a.invalidateAuthToken(this.f36474b.type, authToken);
    }
}
