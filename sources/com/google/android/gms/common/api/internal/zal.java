package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zap;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zal extends LifecycleCallback implements OnCancelListener {

    /* renamed from: b */
    protected volatile boolean f19906b;

    /* renamed from: c */
    protected final AtomicReference<C8649N> f19907c;

    /* renamed from: d */
    private final Handler f19908d;

    /* renamed from: e */
    protected final GoogleApiAvailability f19909e;

    protected zal(LifecycleFragment lifecycleFragment) {
        this(lifecycleFragment, GoogleApiAvailability.getInstance());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo27586a(ConnectionResult connectionResult, int i);

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public abstract void mo27587f();

    @VisibleForTesting
    private zal(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.f19907c = new AtomicReference<>(null);
        this.f19908d = new zap(Looper.getMainLooper());
        this.f19909e = googleApiAvailability;
    }

    public void onCancel(DialogInterface dialogInterface) {
        mo27586a(new ConnectionResult(13, null), m21630a((C8649N) this.f19907c.get()));
        mo27632g();
    }

    /* renamed from: a */
    public void mo27515a(Bundle bundle) {
        C8649N n;
        super.mo27515a(bundle);
        if (bundle != null) {
            AtomicReference<C8649N> atomicReference = this.f19907c;
            if (bundle.getBoolean("resolving_error", false)) {
                n = new C8649N(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1));
            } else {
                n = null;
            }
            atomicReference.set(n);
        }
    }

    /* renamed from: b */
    public void mo27518b(Bundle bundle) {
        super.mo27518b(bundle);
        C8649N n = (C8649N) this.f19907c.get();
        if (n != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", n.mo27537b());
            bundle.putInt("failed_status", n.mo27536a().mo27275a());
            bundle.putParcelable("failed_resolution", n.mo27536a().mo27278d());
        }
    }

    /* renamed from: d */
    public void mo27520d() {
        super.mo27520d();
        this.f19906b = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo27514a(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.common.api.internal.N> r0 = r3.f19907c
            java.lang.Object r0 = r0.get()
            com.google.android.gms.common.api.internal.N r0 = (com.google.android.gms.common.api.internal.C8649N) r0
            r1 = 1
            r2 = 0
            if (r4 == r1) goto L_0x0031
            r5 = 2
            if (r4 == r5) goto L_0x0011
            goto L_0x005a
        L_0x0011:
            com.google.android.gms.common.GoogleApiAvailability r4 = r3.f19909e
            android.app.Activity r5 = r3.mo27513a()
            int r4 = r4.isGooglePlayServicesAvailable(r5)
            if (r4 != 0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            r1 = 0
        L_0x001f:
            if (r0 != 0) goto L_0x0022
            return
        L_0x0022:
            com.google.android.gms.common.ConnectionResult r5 = r0.mo27536a()
            int r5 = r5.mo27275a()
            r6 = 18
            if (r5 != r6) goto L_0x005b
            if (r4 != r6) goto L_0x005b
            return
        L_0x0031:
            r4 = -1
            if (r5 != r4) goto L_0x0035
            goto L_0x005b
        L_0x0035:
            if (r5 != 0) goto L_0x005a
            r4 = 13
            if (r6 == 0) goto L_0x0043
            java.lang.String r5 = "<<ResolutionFailureErrorDetail>>"
            int r4 = r6.getIntExtra(r5, r4)
        L_0x0043:
            com.google.android.gms.common.api.internal.N r5 = new com.google.android.gms.common.api.internal.N
            com.google.android.gms.common.ConnectionResult r6 = new com.google.android.gms.common.ConnectionResult
            r1 = 0
            r6.<init>(r4, r1)
            int r4 = m21630a(r0)
            r5.<init>(r6, r4)
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.common.api.internal.N> r4 = r3.f19907c
            r4.set(r5)
            r0 = r5
            r1 = 0
            goto L_0x005b
        L_0x005a:
            r1 = 0
        L_0x005b:
            if (r1 == 0) goto L_0x0061
            r3.mo27632g()
            return
        L_0x0061:
            if (r0 == 0) goto L_0x006f
            com.google.android.gms.common.ConnectionResult r4 = r0.mo27536a()
            int r5 = r0.mo27537b()
            r3.mo27586a(r4, r5)
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zal.mo27514a(int, int, android.content.Intent):void");
    }

    /* renamed from: e */
    public void mo27521e() {
        super.mo27521e();
        this.f19906b = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public final void mo27632g() {
        this.f19907c.set(null);
        mo27587f();
    }

    /* renamed from: b */
    public final void mo27631b(ConnectionResult connectionResult, int i) {
        C8649N n = new C8649N(connectionResult, i);
        if (this.f19907c.compareAndSet(null, n)) {
            this.f19908d.post(new C8650O(this, n));
        }
    }

    /* renamed from: a */
    private static int m21630a(C8649N n) {
        if (n == null) {
            return -1;
        }
        return n.mo27537b();
    }
}
