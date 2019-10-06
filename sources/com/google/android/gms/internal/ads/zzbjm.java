package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzbkw.zza;
import java.util.concurrent.Executor;

public abstract class zzbjm implements zzblp {

    /* renamed from: a */
    private static zzbjm f25414a;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract zzcvs mo30692a(zzcwx zzcwx);

    /* renamed from: a */
    public abstract Executor mo30693a();

    /* renamed from: b */
    public abstract zzbbl mo30694b();

    /* renamed from: c */
    public abstract zzbtb mo30695c();

    /* renamed from: d */
    public abstract zzclc mo30696d();

    /* renamed from: e */
    public abstract zzbkz mo30697e();

    /* renamed from: f */
    public abstract zzbod mo30698f();

    /* renamed from: g */
    public abstract zzbwt mo30699g();

    /* renamed from: h */
    public abstract zzbxp mo30700h();

    /* renamed from: i */
    public abstract zzcdg mo30701i();

    /* renamed from: j */
    public abstract zzcqp mo30702j();

    /* renamed from: a */
    public static zzbjm m27099a(Context context, zzamp zzamp, int i) {
        zzbjm a = m27098a(context, i);
        a.mo30696d().mo31202a(zzamp);
        return a;
    }

    @Deprecated
    /* renamed from: a */
    public static zzbjm m27098a(Context context, int i) {
        synchronized (zzbjm.class) {
            if (f25414a == null) {
                return m27100a(new zzbai(15000000, i, true, false), context, (zza) new zzbkb());
            }
            zzbjm zzbjm = f25414a;
            return zzbjm;
        }
    }

    @Deprecated
    /* renamed from: a */
    private static zzbjm m27100a(zzbai zzbai, Context context, zza zza) {
        zzbjm zzbjm;
        synchronized (zzbjm.class) {
            if (f25414a == null) {
                f25414a = new zzbkn().mo30722a(new zzbjn(new zzbjn.zza().mo30708a(zzbai).mo30707a(context))).mo30723a(new zzbkw(zza)).mo30721a();
                zzacu.m24782a(context);
                zzk.zzlk().mo30166a(context, zzbai);
                zzk.zzlm().mo32316a(context);
                zzk.zzlg().mo30234a(context);
                zzk.zzlg().mo30238b(context);
                zzawx.m26000a(context);
                zzk.zzlj().mo32285a(context);
                zzk.zzmb().mo30304a(context);
                if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24033We)).booleanValue()) {
                    new zzcjr(context, zzbai, new zzwj(new zzwo(context)), new zzcjc(new zzcja(context), f25414a.mo30694b())).mo31184a();
                }
            }
            zzbjm = f25414a;
        }
        return zzbjm;
    }

    /* renamed from: a */
    public final zzcvs mo30691a(zzarx zzarx) {
        return mo30692a(new zzcwx(zzarx));
    }
}
