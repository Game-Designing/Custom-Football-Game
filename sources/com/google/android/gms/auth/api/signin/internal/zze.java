package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.p000v4.content.C0498a;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class zze extends C0498a<Void> implements SignInConnectionListener {

    /* renamed from: p */
    private Semaphore f19487p = new Semaphore(0);

    /* renamed from: q */
    private Set<GoogleApiClient> f19488q;

    public zze(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.f19488q = set;
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public final Void mo5269t() {
        int i = 0;
        for (GoogleApiClient a : this.f19488q) {
            if (a.mo27381a((SignInConnectionListener) this)) {
                i++;
            }
        }
        try {
            this.f19487p.tryAcquire(i, 5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public final void mo5303l() {
        this.f19487p.drainPermits();
        mo5298e();
    }

    public final void onComplete() {
        this.f19487p.release();
    }
}
