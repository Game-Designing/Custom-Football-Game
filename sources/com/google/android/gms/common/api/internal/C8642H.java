package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;

/* renamed from: com.google.android.gms.common.api.internal.H */
final class C8642H implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Result f19689a;

    /* renamed from: b */
    private final /* synthetic */ zacm f19690b;

    C8642H(zacm zacm, Result result) {
        this.f19690b = zacm;
        this.f19689a = result;
    }

    public final void run() {
        try {
            BasePendingResult.f19619a.set(Boolean.valueOf(true));
            this.f19690b.f19879g.sendMessage(this.f19690b.f19879g.obtainMessage(0, this.f19690b.f19873a.mo27410a(this.f19689a)));
            BasePendingResult.f19619a.set(Boolean.valueOf(false));
            zacm.m21584b(this.f19689a);
            GoogleApiClient googleApiClient = (GoogleApiClient) this.f19690b.f19878f.get();
            if (googleApiClient != null) {
                googleApiClient.mo27379a(this.f19690b);
            }
        } catch (RuntimeException e) {
            this.f19690b.f19879g.sendMessage(this.f19690b.f19879g.obtainMessage(1, e));
            BasePendingResult.f19619a.set(Boolean.valueOf(false));
            zacm.m21584b(this.f19689a);
            GoogleApiClient googleApiClient2 = (GoogleApiClient) this.f19690b.f19878f.get();
            if (googleApiClient2 != null) {
                googleApiClient2.mo27379a(this.f19690b);
            }
        } catch (Throwable th) {
            BasePendingResult.f19619a.set(Boolean.valueOf(false));
            zacm.m21584b(this.f19689a);
            GoogleApiClient googleApiClient3 = (GoogleApiClient) this.f19690b.f19878f.get();
            if (googleApiClient3 != null) {
                googleApiClient3.mo27379a(this.f19690b);
            }
            throw th;
        }
    }
}
