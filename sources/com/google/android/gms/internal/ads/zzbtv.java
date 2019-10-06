package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.util.Clock;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

public class zzbtv {

    /* renamed from: a */
    private final Set<zzbuz<zzxr>> f25859a;

    /* renamed from: b */
    private final Set<zzbuz<zzbrl>> f25860b;

    /* renamed from: c */
    private final Set<zzbuz<zzbrw>> f25861c;

    /* renamed from: d */
    private final Set<zzbuz<zzbsr>> f25862d;

    /* renamed from: e */
    private final Set<zzbuz<zzbro>> f25863e;

    /* renamed from: f */
    private final Set<zzbuz<zzbrs>> f25864f;

    /* renamed from: g */
    private final Set<zzbuz<AdMetadataListener>> f25865g;

    /* renamed from: h */
    private final Set<zzbuz<AppEventListener>> f25866h;

    /* renamed from: i */
    private zzbrm f25867i;

    /* renamed from: j */
    private zzcmu f25868j;

    public static class zza {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public Set<zzbuz<zzxr>> f25869a = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: b */
        public Set<zzbuz<zzbrl>> f25870b = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: c */
        public Set<zzbuz<zzbrw>> f25871c = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: d */
        public Set<zzbuz<zzbsr>> f25872d = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: e */
        public Set<zzbuz<zzbro>> f25873e = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: f */
        public Set<zzbuz<AdMetadataListener>> f25874f = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: g */
        public Set<zzbuz<AppEventListener>> f25875g = new HashSet();
        /* access modifiers changed from: private */

        /* renamed from: h */
        public Set<zzbuz<zzbrs>> f25876h = new HashSet();

        /* renamed from: a */
        public final zza mo30910a(zzbrl zzbrl, Executor executor) {
            this.f25870b.add(new zzbuz(zzbrl, executor));
            return this;
        }

        /* renamed from: a */
        public final zza mo30914a(zzbsr zzbsr, Executor executor) {
            this.f25872d.add(new zzbuz(zzbsr, executor));
            return this;
        }

        /* renamed from: a */
        public final zza mo30911a(zzbro zzbro, Executor executor) {
            this.f25873e.add(new zzbuz(zzbro, executor));
            return this;
        }

        /* renamed from: a */
        public final zza mo30912a(zzbrs zzbrs, Executor executor) {
            this.f25876h.add(new zzbuz(zzbrs, executor));
            return this;
        }

        /* renamed from: a */
        public final zza mo30909a(AdMetadataListener adMetadataListener, Executor executor) {
            this.f25874f.add(new zzbuz(adMetadataListener, executor));
            return this;
        }

        /* renamed from: a */
        public final zza mo30908a(AppEventListener appEventListener, Executor executor) {
            this.f25875g.add(new zzbuz(appEventListener, executor));
            return this;
        }

        /* renamed from: a */
        public final zza mo30916a(zzzs zzzs, Executor executor) {
            if (this.f25875g != null) {
                zzcpy zzcpy = new zzcpy();
                zzcpy.mo31234a(zzzs);
                this.f25875g.add(new zzbuz(zzcpy, executor));
            }
            return this;
        }

        /* renamed from: a */
        public final zza mo30915a(zzxr zzxr, Executor executor) {
            this.f25869a.add(new zzbuz(zzxr, executor));
            return this;
        }

        /* renamed from: a */
        public final zza mo30913a(zzbrw zzbrw, Executor executor) {
            this.f25871c.add(new zzbuz(zzbrw, executor));
            return this;
        }

        /* renamed from: a */
        public final zzbtv mo30917a() {
            return new zzbtv(this);
        }
    }

    private zzbtv(zza zza2) {
        this.f25859a = zza2.f25869a;
        this.f25861c = zza2.f25871c;
        this.f25860b = zza2.f25870b;
        this.f25862d = zza2.f25872d;
        this.f25863e = zza2.f25873e;
        this.f25864f = zza2.f25876h;
        this.f25865g = zza2.f25874f;
        this.f25866h = zza2.f25875g;
    }

    /* renamed from: a */
    public final Set<zzbuz<zzbrl>> mo30900a() {
        return this.f25860b;
    }

    /* renamed from: b */
    public final Set<zzbuz<zzbsr>> mo30901b() {
        return this.f25862d;
    }

    /* renamed from: c */
    public final Set<zzbuz<zzbro>> mo30902c() {
        return this.f25863e;
    }

    /* renamed from: d */
    public final Set<zzbuz<zzbrs>> mo30903d() {
        return this.f25864f;
    }

    /* renamed from: e */
    public final Set<zzbuz<AdMetadataListener>> mo30904e() {
        return this.f25865g;
    }

    /* renamed from: f */
    public final Set<zzbuz<AppEventListener>> mo30905f() {
        return this.f25866h;
    }

    /* renamed from: g */
    public final Set<zzbuz<zzxr>> mo30906g() {
        return this.f25859a;
    }

    /* renamed from: h */
    public final Set<zzbuz<zzbrw>> mo30907h() {
        return this.f25861c;
    }

    /* renamed from: a */
    public final zzbrm mo30898a(Set<zzbuz<zzbro>> set) {
        if (this.f25867i == null) {
            this.f25867i = new zzbrm(set);
        }
        return this.f25867i;
    }

    /* renamed from: a */
    public final zzcmu mo30899a(Clock clock) {
        if (this.f25868j == null) {
            this.f25868j = new zzcmu(clock);
        }
        return this.f25868j;
    }
}
