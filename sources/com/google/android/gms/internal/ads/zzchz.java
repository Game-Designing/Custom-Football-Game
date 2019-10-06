package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;

public final class zzchz extends zzchx {
    public zzchz(Context context) {
        this.f26654f = new zzarf(context, zzk.zzlu().mo30298b(), this, this);
    }

    /* renamed from: a */
    public final zzbbh<InputStream> mo31168a(zzarx zzarx) {
        synchronized (this.f26650b) {
            if (this.f26651c) {
                zzbbr<InputStream> zzbbr = this.f26649a;
                return zzbbr;
            }
            this.f26651c = true;
            this.f26653e = zzarx;
            this.f26654f.checkAvailabilityAndConnect();
            this.f26649a.mo28811a(new C9340bj(this), zzbbm.f25065b);
            zzbbr<InputStream> zzbbr2 = this.f26649a;
            return zzbbr2;
        }
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.f26650b) {
            if (!this.f26652d) {
                this.f26652d = true;
                try {
                    this.f26654f.mo27780j().mo30024b(this.f26653e, new zzchy(this));
                } catch (RemoteException e) {
                } catch (IllegalArgumentException e2) {
                } catch (Throwable th) {
                    zzk.zzlk().mo30168a(th, "RemoteSignalsClientTask.onConnected");
                    this.f26649a.mo30337a(new zzcie(0));
                }
            }
        }
        this.f26649a.mo30337a(new zzcie(0));
    }
}
