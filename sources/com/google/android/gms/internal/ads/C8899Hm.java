package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;

/* renamed from: com.google.android.gms.internal.ads.Hm */
final class C8899Hm implements BaseConnectionCallbacks, BaseOnConnectionFailedListener {

    /* renamed from: a */
    private final zzdba f21214a;

    /* renamed from: b */
    private final zzdau f21215b;

    /* renamed from: c */
    private final Object f21216c = new Object();

    /* renamed from: d */
    private boolean f21217d = false;

    /* renamed from: e */
    private boolean f21218e = false;

    C8899Hm(Context context, Looper looper, zzdau zzdau) {
        this.f21215b = zzdau;
        this.f21214a = new zzdba(context, looper, this, this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28320a() {
        synchronized (this.f21216c) {
            if (!this.f21217d) {
                this.f21217d = true;
                this.f21214a.checkAvailabilityAndConnect();
            }
        }
    }

    /* renamed from: b */
    private final void m22667b() {
        synchronized (this.f21216c) {
            if (this.f21214a.isConnected() || this.f21214a.isConnecting()) {
                this.f21214a.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.f21216c) {
            if (!this.f21218e) {
                this.f21218e = true;
                try {
                    this.f21214a.mo27780j().mo31368a(new zzday(this.f21215b.toByteArray()));
                    m22667b();
                } catch (Exception e) {
                    m22667b();
                } catch (Throwable th) {
                    m22667b();
                    throw th;
                }
            }
        }
    }

    public final void onConnectionSuspended(int i) {
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
    }
}
