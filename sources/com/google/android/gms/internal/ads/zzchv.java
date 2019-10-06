package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

public final class zzchv extends zzchx {
    public zzchv(Context context) {
        this.f26654f = new zzarf(context, zzk.zzlu().mo30298b(), this, this);
    }

    /* renamed from: a */
    public final zzbbh<InputStream> mo31166a(zzarx zzarx) {
        synchronized (this.f26650b) {
            if (this.f26651c) {
                zzbbr<InputStream> zzbbr = this.f26649a;
                return zzbbr;
            }
            this.f26651c = true;
            this.f26653e = zzarx;
            this.f26654f.checkAvailabilityAndConnect();
            this.f26649a.mo28811a(new C9296_i(this), zzbbm.f25065b);
            zzbbr<InputStream> zzbbr2 = this.f26649a;
            return zzbbr2;
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzbad.m26352a("Cannot connect to remote service, fallback to local instance.");
        this.f26649a.mo30337a(new zzcie(0));
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.f26650b) {
            if (!this.f26652d) {
                this.f26652d = true;
                try {
                    this.f26654f.mo27780j().mo30023a(this.f26653e, (zzarr) new zzchy(this));
                } catch (RemoteException e) {
                } catch (IllegalArgumentException e2) {
                } catch (Throwable th) {
                    zzk.zzlk().mo30168a(th, "RemoteAdRequestClientTask.onConnected");
                    this.f26649a.mo30337a(new zzcie(0));
                }
            }
        }
        this.f26649a.mo30337a(new zzcie(0));
    }
}
