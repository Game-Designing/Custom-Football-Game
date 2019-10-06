package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

public final class zzchl extends zzchj {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Pattern f26629b = Pattern.compile("Received error HTTP response code: (.*)");

    /* renamed from: c */
    private final zzcgn f26630c;

    /* renamed from: d */
    private final zzbbl f26631d;

    /* renamed from: e */
    private final zzcxv f26632e;

    /* renamed from: f */
    private final ScheduledExecutorService f26633f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final zzcji f26634g;

    zzchl(zzbtg zzbtg, zzcxv zzcxv, zzcgn zzcgn, zzbbl zzbbl, ScheduledExecutorService scheduledExecutorService, zzcji zzcji) {
        super(zzbtg);
        this.f26632e = zzcxv;
        this.f26630c = zzcgn;
        this.f26631d = zzbbl;
        this.f26633f = scheduledExecutorService;
        this.f26634g = zzcji;
    }

    /* renamed from: a */
    public final zzbbh<zzcxu> mo31162a(zzarx zzarx) throws zzcgm {
        zzbbh<zzcxu> a = zzbar.m26379a(this.f26630c.mo31158a(zzarx), (zzbal<? super A, ? extends B>) new C9171Ui<Object,Object>(this), (Executor) this.f26631d);
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24153pe)).booleanValue()) {
            a = zzbar.m26381a(zzbar.m26378a(a, (long) ((Integer) zzyt.m31536e().mo29599a(zzacu.f24159qe)).intValue(), TimeUnit.SECONDS, this.f26633f), TimeoutException.class, C9192Vi.f21855a, zzbbm.f25065b);
        }
        zzbar.m26383a(a, (zzban<? super V>) new C9213Wi<Object>(this), zzbbm.f25065b);
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ zzbbh mo31163a(InputStream inputStream) throws Exception {
        return zzbar.m26376a(new zzcxu(new zzcxr(this.f26632e), zzcxs.m28953a(new InputStreamReader(inputStream))));
    }
}
