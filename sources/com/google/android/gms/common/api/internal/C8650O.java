package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.content.DialogInterface.OnCancelListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

/* renamed from: com.google.android.gms.common.api.internal.O */
final class C8650O implements Runnable {

    /* renamed from: a */
    private final C8649N f19706a;

    /* renamed from: b */
    final /* synthetic */ zal f19707b;

    C8650O(zal zal, C8649N n) {
        this.f19707b = zal;
        this.f19706a = n;
    }

    public final void run() {
        if (this.f19707b.f19906b) {
            ConnectionResult a = this.f19706a.mo27536a();
            if (a.mo27279e()) {
                zal zal = this.f19707b;
                zal.f19696a.startActivityForResult(GoogleApiActivity.m21144a(zal.mo27513a(), a.mo27278d(), this.f19706a.mo27537b(), false), 1);
            } else if (this.f19707b.f19909e.mo27307c(a.mo27275a())) {
                zal zal2 = this.f19707b;
                zal2.f19909e.mo27301a(zal2.mo27513a(), this.f19707b.f19696a, a.mo27275a(), 2, this.f19707b);
            } else if (a.mo27275a() == 18) {
                Dialog a2 = GoogleApiAvailability.m21067a(this.f19707b.mo27513a(), (OnCancelListener) this.f19707b);
                zal zal3 = this.f19707b;
                zal3.f19909e.mo27300a(zal3.mo27513a().getApplicationContext(), (zabr) new C8651P(this, a2));
            } else {
                this.f19707b.mo27586a(a, this.f19706a.mo27537b());
            }
        }
    }
}
