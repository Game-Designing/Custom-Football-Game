package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.xf */
final class C9812xf extends zzcvs {

    /* renamed from: a */
    private zzcwx f23445a;

    /* renamed from: b */
    private zzdtu<zzcvo> f23446b;

    /* renamed from: c */
    private zzdtu<String> f23447c;

    /* renamed from: d */
    private zzdtu<zzcvy> f23448d;

    /* renamed from: e */
    private zzdtu<zzcwc> f23449e;

    /* renamed from: f */
    private zzdtu<zzcwj> f23450f;

    /* renamed from: g */
    private zzdtu<Boolean> f23451g;

    /* renamed from: h */
    private zzdtu<ApplicationInfo> f23452h;

    /* renamed from: i */
    private zzdtu<zzcwq> f23453i;

    /* renamed from: j */
    private zzdtu<zzcwu> f23454j;

    /* renamed from: k */
    private zzdtu<zzcxh> f23455k;

    /* renamed from: l */
    private zzdtu<String> f23456l;

    /* renamed from: m */
    private zzdtu<zzcez> f23457m;

    /* renamed from: n */
    private zzdtu<zzcez> f23458n;

    /* renamed from: o */
    private zzdtu<zzcez> f23459o;

    /* renamed from: p */
    private zzdtu<zzcez> f23460p;

    /* renamed from: q */
    private zzdtu<Map<zzczs, zzcez>> f23461q;

    /* renamed from: r */
    private zzdtu<Set<zzbuz<zzczz>>> f23462r;

    /* renamed from: s */
    private zzdtu<Set<zzbuz<zzczz>>> f23463s;

    /* renamed from: t */
    private zzdtu f23464t;

    /* renamed from: u */
    private zzdtu<zzczt> f23465u;

    /* renamed from: v */
    private final /* synthetic */ zzbkc f23466v;

    private C9812xf(zzbkc zzbkc, zzcwx zzcwx) {
        this.f23466v = zzbkc;
        this.f23445a = zzcwx;
        this.f23446b = new zzcvr(zzbln.m27224a(), this.f23466v.f25456i, this.f23466v.f25452e, zzcyx.m29018a());
        this.f23447c = new zzcwy(zzcwx);
        this.f23448d = new zzcwa(zzbjy.m27124a(), this.f23466v.f25456i, this.f23447c, zzcyx.m29018a());
        this.f23449e = new zzcwe(zzblj.m27216a(), zzcyx.m29018a(), this.f23466v.f25456i);
        this.f23450f = new zzcwl(zzblk.m27218a(), zzcyx.m29018a(), this.f23447c);
        this.f23451g = new zzcxa(zzcwx);
        this.f23452h = new zzcwz(zzcwx);
        this.f23453i = new zzcws(zzbll.m27220a(), this.f23466v.f25452e, this.f23451g, this.f23452h);
        this.f23454j = new zzcww(zzblm.m27222a(), this.f23466v.f25452e, this.f23466v.f25456i);
        this.f23455k = new zzcxj(zzcyx.m29018a());
        this.f23456l = new zzcxb(zzcwx);
        this.f23457m = zzdth.m30107a(zzcet.m28341a());
        this.f23458n = zzdth.m30107a(zzces.m28340a());
        this.f23459o = zzdth.m30107a(zzceu.m28342a());
        this.f23460p = zzdth.m30107a(zzcev.m28343a());
        this.f23461q = zzdtk.m30110a(4).mo31700a(zzczs.GMS_SIGNALS, this.f23457m).mo31700a(zzczs.BUILD_URL, this.f23458n).mo31700a(zzczs.HTTP, this.f23459o).mo31700a(zzczs.PRE_PROCESS, this.f23460p).mo31699a();
        this.f23462r = zzdth.m30107a(new zzcew(this.f23456l, this.f23466v.f25456i, zzcyx.m29018a(), this.f23461q));
        this.f23463s = zzdtq.m30120a(0, 1).mo31706b(this.f23462r).mo31704a();
        this.f23464t = zzdab.m29070a(this.f23463s);
        this.f23465u = zzdth.m30107a(zzdaa.m29069a(zzcyx.m29018a(), this.f23466v.f25452e, this.f23464t));
    }

    /* renamed from: d */
    private final zzcwn m24258d() {
        zzach a = zzbli.m27215a();
        zzbbl b = zzcyx.m29019b();
        List e = this.f23445a.mo31278e();
        zzdto.m30114a(e, "Cannot return null from a non-@Nullable @Provides method");
        return new zzcwn(a, b, e);
    }

    /* renamed from: e */
    private final zzcvu m24259e() {
        zzawi b = zzbln.m27225b();
        zzbbl b2 = zzcyx.m29019b();
        String b3 = this.f23445a.mo31275b();
        zzdto.m30114a(b3, "Cannot return null from a non-@Nullable @Provides method");
        return new zzcvu(b, b2, b3, this.f23445a.mo31276c());
    }

    /* renamed from: a */
    public final zzcvb<JSONObject> mo29265a() {
        zzbbl b = zzcyx.m29019b();
        zzdtp a = zzdtp.m30116a(11);
        zzctz zzctz = new zzctz(new zzcwj(zzblk.m27219b(), zzcyx.m29019b(), zzcwy.m28939a(this.f23445a)), 0, (ScheduledExecutorService) this.f23466v.f25452e.get());
        String str = "Cannot return null from a non-@Nullable @Provides method";
        zzdto.m30114a(zzctz, str);
        zzdtp a2 = a.mo31701a(zzctz);
        zzctz zzctz2 = new zzctz(new zzcwq(zzbll.m27221b(), (ScheduledExecutorService) this.f23466v.f25452e.get(), this.f23445a.mo31277d(), zzcwz.m28940a(this.f23445a)), ((Long) zzyt.m31536e().mo29599a(zzacu.f24025Vc)).longValue(), (ScheduledExecutorService) this.f23466v.f25452e.get());
        zzdto.m30114a(zzctz2, str);
        zzdtp a3 = a2.mo31701a(zzctz2);
        zzctz zzctz3 = new zzctz(new zzcwu(zzblm.m27223b(), (ScheduledExecutorService) this.f23466v.f25452e.get(), zzbjq.m27122a(this.f23466v.f25449b)), ((Long) zzyt.m31536e().mo29599a(zzacu.f24122kd)).longValue(), (ScheduledExecutorService) this.f23466v.f25452e.get());
        zzdto.m30114a(zzctz3, str);
        zzdtp a4 = a3.mo31701a(zzctz3);
        zzctz zzctz4 = new zzctz(new zzcvo(zzbln.m27225b(), zzbjq.m27122a(this.f23466v.f25449b), (ScheduledExecutorService) this.f23466v.f25452e.get(), zzcyx.m29019b()), 0, (ScheduledExecutorService) this.f23466v.f25452e.get());
        zzdto.m30114a(zzctz4, str);
        zzdtp a5 = a4.mo31701a(zzctz4);
        zzctz zzctz5 = new zzctz(new zzcxh(zzcyx.m29019b()), 0, (ScheduledExecutorService) this.f23466v.f25452e.get());
        zzdto.m30114a(zzctz5, str);
        return new zzcvb<>(b, a5.mo31701a(zzctz5).mo31701a(zzcxe.m28941a()).mo31701a(new zzcvy(null, zzbjq.m27122a(this.f23466v.f25449b), zzcwy.m28939a(this.f23445a), zzcyx.m29019b())).mo31701a(new zzcwc(zzblj.m27217b(), zzcyx.m29019b(), zzbjq.m27122a(this.f23466v.f25449b))).mo31701a(m24258d()).mo31701a(m24259e()).mo31701a((zzcva) this.f23466v.f25465r.get()).mo31703a());
    }

    /* renamed from: b */
    public final zzcvb<JSONObject> mo29266b() {
        return zzcxf.m28942a(this.f23466v.f25465r.get(), m24259e(), m24258d(), zzdth.m30108b(this.f23446b), zzdth.m30108b(this.f23448d), zzdth.m30108b(this.f23449e), zzdth.m30108b(this.f23450f), zzdth.m30108b(this.f23453i), zzdth.m30108b(this.f23454j), zzdth.m30108b(this.f23455k), zzcyx.m29019b());
    }

    /* renamed from: c */
    public final zzczt mo29267c() {
        return (zzczt) this.f23465u.get();
    }
}
