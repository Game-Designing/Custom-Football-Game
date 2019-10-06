package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzu;

/* renamed from: com.google.android.gms.internal.ads.ii */
final class C9493ii implements zzo, zzu, zzagv, zzagx, zzxr {

    /* renamed from: a */
    private zzxr f22551a;

    /* renamed from: b */
    private zzagv f22552b;

    /* renamed from: c */
    private zzo f22553c;

    /* renamed from: d */
    private zzagx f22554d;

    /* renamed from: e */
    private zzu f22555e;

    private C9493ii() {
    }

    public final synchronized void onAdClicked() {
        if (this.f22551a != null) {
            this.f22551a.onAdClicked();
        }
    }

    public final synchronized void zzsz() {
        if (this.f22553c != null) {
            this.f22553c.zzsz();
        }
    }

    public final synchronized void onPause() {
        if (this.f22553c != null) {
            this.f22553c.onPause();
        }
    }

    public final synchronized void onResume() {
        if (this.f22553c != null) {
            this.f22553c.onResume();
        }
    }

    public final synchronized void zzta() {
        if (this.f22553c != null) {
            this.f22553c.zzta();
        }
    }

    public final synchronized void zztq() {
        if (this.f22555e != null) {
            this.f22555e.zztq();
        }
    }

    /* renamed from: a */
    public final synchronized void mo29003a(String str, Bundle bundle) {
        if (this.f22552b != null) {
            this.f22552b.mo29003a(str, bundle);
        }
    }

    public final synchronized void onAppEvent(String str, String str2) {
        if (this.f22554d != null) {
            this.f22554d.onAppEvent(str, str2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final synchronized void m23692a(zzxr zzxr, zzagv zzagv, zzo zzo, zzagx zzagx, zzu zzu) {
        this.f22551a = zzxr;
        this.f22552b = zzagv;
        this.f22553c = zzo;
        this.f22554d = zzagx;
        this.f22555e = zzu;
    }

    /* synthetic */ C9493ii(C9405ei eiVar) {
        this();
    }
}
