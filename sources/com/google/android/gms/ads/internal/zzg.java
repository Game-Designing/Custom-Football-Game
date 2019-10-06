package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzacu;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzaxg;
import com.google.android.gms.internal.ads.zzazt;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzdc;
import com.google.android.gms.internal.ads.zzdg;
import com.google.android.gms.internal.ads.zzyt;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@zzard
public final class zzg implements zzdc, Runnable {

    /* renamed from: a */
    private final List<Object[]> f19127a = new Vector();

    /* renamed from: b */
    private final AtomicReference<zzdc> f19128b = new AtomicReference<>();

    /* renamed from: c */
    private Context f19129c;

    /* renamed from: d */
    private zzbai f19130d;

    /* renamed from: e */
    private CountDownLatch f19131e = new CountDownLatch(1);

    public zzg(Context context, zzbai zzbai) {
        this.f19129c = context;
        this.f19130d = zzbai;
        zzyt.m31532a();
        if (zzazt.m26314b()) {
            zzaxg.m26094a((Runnable) this);
        } else {
            run();
        }
    }

    /* renamed from: a */
    private final boolean m20841a() {
        try {
            this.f19131e.await();
            return true;
        } catch (InterruptedException e) {
            zzbad.m26358c("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    /* renamed from: b */
    private final void m20842b() {
        if (!this.f19127a.isEmpty()) {
            for (Object[] objArr : this.f19127a) {
                if (objArr.length == 1) {
                    ((zzdc) this.f19128b.get()).zza((MotionEvent) objArr[0]);
                } else if (objArr.length == 3) {
                    ((zzdc) this.f19128b.get()).zza(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.f19127a.clear();
        }
    }

    /* renamed from: a */
    private static Context m20840a(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final String zza(Context context) {
        if (m20841a()) {
            zzdc zzdc = (zzdc) this.f19128b.get();
            if (zzdc != null) {
                m20842b();
                return zzdc.zza(m20840a(context));
            }
        }
        return "";
    }

    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    public final String zza(Context context, String str, View view, Activity activity) {
        if (m20841a()) {
            zzdc zzdc = (zzdc) this.f19128b.get();
            if (zzdc != null) {
                m20842b();
                return zzdc.zza(m20840a(context), str, view, activity);
            }
        }
        return "";
    }

    public final void zzb(View view) {
        zzdc zzdc = (zzdc) this.f19128b.get();
        if (zzdc != null) {
            zzdc.zzb(view);
        }
    }

    public final void zza(MotionEvent motionEvent) {
        zzdc zzdc = (zzdc) this.f19128b.get();
        if (zzdc != null) {
            m20842b();
            zzdc.zza(motionEvent);
            return;
        }
        this.f19127a.add(new Object[]{motionEvent});
    }

    public final void zza(int i, int i2, int i3) {
        zzdc zzdc = (zzdc) this.f19128b.get();
        if (zzdc != null) {
            m20842b();
            zzdc.zza(i, i2, i3);
            return;
        }
        this.f19127a.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final void run() {
        boolean z;
        try {
            boolean z2 = true;
            if (this.f19130d.f25060d) {
                z = true;
            } else {
                z = false;
            }
            if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24102hb)).booleanValue() || !z) {
                z2 = false;
            }
            this.f19128b.set(zzdg.m29386a(this.f19130d.f25057a, m20840a(this.f19129c), z2));
        } finally {
            this.f19131e.countDown();
            this.f19129c = null;
            this.f19130d = null;
        }
    }
}
