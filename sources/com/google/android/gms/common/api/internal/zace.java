package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zaj;
import com.google.android.gms.signin.zaa;
import com.google.android.gms.signin.zad;
import java.util.Set;

public final class zace extends zac implements ConnectionCallbacks, OnConnectionFailedListener {

    /* renamed from: b */
    private static AbstractClientBuilder<? extends zad, SignInOptions> f19865b = zaa.f30606c;

    /* renamed from: c */
    private final Context f19866c;

    /* renamed from: d */
    private final Handler f19867d;

    /* renamed from: e */
    private final AbstractClientBuilder<? extends zad, SignInOptions> f19868e;

    /* renamed from: f */
    private Set<Scope> f19869f;

    /* renamed from: g */
    private ClientSettings f19870g;

    /* renamed from: h */
    private zad f19871h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public zach f19872i;

    public zace(Context context, Handler handler, ClientSettings clientSettings) {
        this(context, handler, clientSettings, f19865b);
    }

    public zace(Context context, Handler handler, ClientSettings clientSettings, AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder) {
        this.f19866c = context;
        this.f19867d = handler;
        Preconditions.m21858a(clientSettings, (Object) "ClientSettings must not be null");
        this.f19870g = clientSettings;
        this.f19869f = clientSettings.mo27768i();
        this.f19868e = abstractClientBuilder;
    }

    /* renamed from: a */
    public final void mo27617a(zach zach) {
        zad zad = this.f19871h;
        if (zad != null) {
            zad.disconnect();
        }
        this.f19870g.mo27760a(Integer.valueOf(System.identityHashCode(this)));
        AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder = this.f19868e;
        Context context = this.f19866c;
        Looper looper = this.f19867d.getLooper();
        ClientSettings clientSettings = this.f19870g;
        this.f19871h = (zad) abstractClientBuilder.mo27090a(context, looper, clientSettings, clientSettings.mo27769j(), this, this);
        this.f19872i = zach;
        Set<Scope> set = this.f19869f;
        if (set == null || set.isEmpty()) {
            this.f19867d.post(new C8638F(this));
        } else {
            this.f19871h.connect();
        }
    }

    /* renamed from: a */
    public final zad mo27616a() {
        return this.f19871h;
    }

    /* renamed from: b */
    public final void mo27618b() {
        zad zad = this.f19871h;
        if (zad != null) {
            zad.disconnect();
        }
    }

    public final void onConnected(Bundle bundle) {
        this.f19871h.mo33153a(this);
    }

    public final void onConnectionSuspended(int i) {
        this.f19871h.disconnect();
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f19872i.mo27485b(connectionResult);
    }

    /* renamed from: a */
    public final void mo27573a(zaj zaj) {
        this.f19867d.post(new C8639G(this, zaj));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m21573b(zaj zaj) {
        ConnectionResult a = zaj.mo33168a();
        if (a.mo27281f()) {
            ResolveAccountResponse c = zaj.mo33169c();
            ConnectionResult c2 = c.mo27818c();
            if (!c2.mo27281f()) {
                String valueOf = String.valueOf(c2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(valueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                this.f19872i.mo27485b(c2);
                this.f19871h.disconnect();
                return;
            }
            this.f19872i.mo27484a(c.mo27817a(), this.f19869f);
        } else {
            this.f19872i.mo27485b(a);
        }
        this.f19871h.disconnect();
    }
}
