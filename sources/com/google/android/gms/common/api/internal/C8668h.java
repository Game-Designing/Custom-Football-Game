package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.api.internal.h */
final class C8668h implements ConnectionProgressReportCallbacks {

    /* renamed from: a */
    private final WeakReference<zaak> f19754a;

    /* renamed from: b */
    private final Api<?> f19755b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final boolean f19756c;

    public C8668h(zaak zaak, Api<?> api, boolean z) {
        this.f19754a = new WeakReference<>(zaak);
        this.f19755b = api;
        this.f19756c = z;
    }

    /* renamed from: a */
    public final void mo27483a(ConnectionResult connectionResult) {
        zaak zaak = (zaak) this.f19754a.get();
        if (zaak != null) {
            Preconditions.m21868b(Looper.myLooper() == zaak.f19791a.f19852n.mo27388g(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            zaak.f19792b.lock();
            try {
                if (zaak.m21451a(0)) {
                    if (!connectionResult.mo27281f()) {
                        zaak.m21457b(connectionResult, this.f19755b, this.f19756c);
                    }
                    if (zaak.m21458b()) {
                        zaak.m21461c();
                    }
                    zaak.f19792b.unlock();
                }
            } finally {
                zaak.f19792b.unlock();
            }
        }
    }
}
