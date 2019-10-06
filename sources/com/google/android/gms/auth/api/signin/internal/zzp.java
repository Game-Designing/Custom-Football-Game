package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzp {

    /* renamed from: a */
    private static zzp f19491a = null;
    @VisibleForTesting

    /* renamed from: b */
    private Storage f19492b;
    @VisibleForTesting

    /* renamed from: c */
    private GoogleSignInAccount f19493c = this.f19492b.mo27229b();
    @VisibleForTesting

    /* renamed from: d */
    private GoogleSignInOptions f19494d = this.f19492b.mo27230c();

    private zzp(Context context) {
        this.f19492b = Storage.m20992a(context);
    }

    /* renamed from: a */
    public static synchronized zzp m21031a(Context context) {
        zzp b;
        synchronized (zzp.class) {
            b = m21032b(context.getApplicationContext());
        }
        return b;
    }

    /* renamed from: b */
    private static synchronized zzp m21032b(Context context) {
        zzp zzp;
        synchronized (zzp.class) {
            if (f19491a == null) {
                f19491a = new zzp(context);
            }
            zzp = f19491a;
        }
        return zzp;
    }

    /* renamed from: a */
    public final synchronized void mo27249a() {
        this.f19492b.mo27227a();
        this.f19493c = null;
        this.f19494d = null;
    }

    /* renamed from: a */
    public final synchronized void mo27250a(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.f19492b.mo27228a(googleSignInAccount, googleSignInOptions);
        this.f19493c = googleSignInAccount;
        this.f19494d = googleSignInOptions;
    }
}
