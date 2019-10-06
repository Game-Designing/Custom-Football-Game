package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class GoogleSignInResult implements Result {

    /* renamed from: a */
    private Status f19457a;

    /* renamed from: b */
    private GoogleSignInAccount f19458b;

    public GoogleSignInResult(GoogleSignInAccount googleSignInAccount, Status status) {
        this.f19458b = googleSignInAccount;
        this.f19457a = status;
    }

    /* renamed from: a */
    public GoogleSignInAccount mo27209a() {
        return this.f19458b;
    }

    public Status getStatus() {
        return this.f19457a;
    }

    /* renamed from: c */
    public boolean mo27210c() {
        return this.f19457a.mo27421e();
    }
}
