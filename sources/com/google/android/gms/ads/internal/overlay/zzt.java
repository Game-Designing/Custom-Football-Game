package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaqh;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzxr;

@zzard
public final class zzt extends zzaqh {

    /* renamed from: b */
    private AdOverlayInfoParcel f19115b;

    /* renamed from: c */
    private Activity f19116c;

    /* renamed from: d */
    private boolean f19117d = false;

    /* renamed from: e */
    private boolean f19118e = false;

    public zzt(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.f19115b = adOverlayInfoParcel;
        this.f19116c = activity;
    }

    public final void onCreate(Bundle bundle) {
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.f19115b;
        if (adOverlayInfoParcel == null) {
            this.f19116c.finish();
        } else if (z) {
            this.f19116c.finish();
        } else {
            if (bundle == null) {
                zzxr zzxr = adOverlayInfoParcel.zzcgi;
                if (zzxr != null) {
                    zzxr.onAdClicked();
                }
                if (this.f19116c.getIntent() != null && this.f19116c.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true)) {
                    zzo zzo = this.f19115b.zzdkm;
                    if (zzo != null) {
                        zzo.zzta();
                    }
                }
            }
            zzk.zzle();
            Activity activity = this.f19116c;
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.f19115b;
            if (!zza.zza(activity, adOverlayInfoParcel2.zzdkl, adOverlayInfoParcel2.zzdkq)) {
                this.f19116c.finish();
            }
        }
    }

    public final void onResume() throws RemoteException {
        if (this.f19117d) {
            this.f19116c.finish();
            return;
        }
        this.f19117d = true;
        zzo zzo = this.f19115b.zzdkm;
        if (zzo != null) {
            zzo.onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f19117d);
    }

    public final void onPause() throws RemoteException {
        zzo zzo = this.f19115b.zzdkm;
        if (zzo != null) {
            zzo.onPause();
        }
        if (this.f19116c.isFinishing()) {
            m20837ib();
        }
    }

    public final void onStop() throws RemoteException {
        if (this.f19116c.isFinishing()) {
            m20837ib();
        }
    }

    public final void onDestroy() throws RemoteException {
        if (this.f19116c.isFinishing()) {
            m20837ib();
        }
    }

    /* renamed from: ib */
    private final synchronized void m20837ib() {
        if (!this.f19118e) {
            if (this.f19115b.zzdkm != null) {
                this.f19115b.zzdkm.zzsz();
            }
            this.f19118e = true;
        }
    }

    public final void onRestart() throws RemoteException {
    }

    public final void onStart() throws RemoteException {
    }

    public final void zzdd() throws RemoteException {
    }

    public final void onBackPressed() throws RemoteException {
    }

    public final boolean zztg() throws RemoteException {
        return false;
    }

    public final void onActivityResult(int i, int i2, Intent intent) throws RemoteException {
    }

    public final void zzac(IObjectWrapper iObjectWrapper) throws RemoteException {
    }
}
