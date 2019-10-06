package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;

public final class zzw extends zzr {

    /* renamed from: b */
    private final Context f19495b;

    public zzw(Context context) {
        this.f19495b = context;
    }

    /* renamed from: pa */
    public final void mo27251pa() {
        m21046a();
        Storage a = Storage.m20992a(this.f19495b);
        GoogleSignInAccount b = a.mo27229b();
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.f19436f;
        if (b != null) {
            googleSignInOptions = a.mo27230c();
        }
        GoogleApiClient a2 = new Builder(this.f19495b).mo27392a(Auth.f19284g, googleSignInOptions).mo27395a();
        try {
            if (a2.mo27375a().mo27281f()) {
                if (b != null) {
                    Auth.f19287j.mo27187a(a2);
                } else {
                    a2.mo27382b();
                }
            }
        } finally {
            a2.mo27386d();
        }
    }

    /* renamed from: va */
    public final void mo27252va() {
        m21046a();
        zzp.m21031a(this.f19495b).mo27249a();
    }

    /* renamed from: a */
    private final void m21046a() {
        if (!GooglePlayServicesUtilLight.isGooglePlayServicesUid(this.f19495b, Binder.getCallingUid())) {
            int callingUid = Binder.getCallingUid();
            StringBuilder sb = new StringBuilder(52);
            sb.append("Calling UID ");
            sb.append(callingUid);
            sb.append(" is not Google Play services.");
            throw new SecurityException(sb.toString());
        }
    }
}
