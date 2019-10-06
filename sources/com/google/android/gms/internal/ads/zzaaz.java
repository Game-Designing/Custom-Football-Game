package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@zzard
public final class zzaaz {

    /* renamed from: a */
    private final Date f23797a;

    /* renamed from: b */
    private final String f23798b;

    /* renamed from: c */
    private final int f23799c;

    /* renamed from: d */
    private final Set<String> f23800d;

    /* renamed from: e */
    private final Location f23801e;

    /* renamed from: f */
    private final boolean f23802f;

    /* renamed from: g */
    private final Bundle f23803g;

    /* renamed from: h */
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> f23804h;

    /* renamed from: i */
    private final String f23805i;

    /* renamed from: j */
    private final String f23806j;

    /* renamed from: k */
    private final SearchAdRequest f23807k;

    /* renamed from: l */
    private final int f23808l;

    /* renamed from: m */
    private final Set<String> f23809m;

    /* renamed from: n */
    private final Bundle f23810n;

    /* renamed from: o */
    private final Set<String> f23811o;

    /* renamed from: p */
    private final boolean f23812p;

    /* renamed from: q */
    private final zzdak f23813q;

    /* renamed from: r */
    private final int f23814r;

    /* renamed from: s */
    private final String f23815s;

    public zzaaz(zzaba zzaba) {
        this(zzaba, null);
    }

    public zzaaz(zzaba zzaba, SearchAdRequest searchAdRequest) {
        this.f23797a = zzaba.f23822g;
        this.f23798b = zzaba.f23823h;
        this.f23799c = zzaba.f23824i;
        this.f23800d = Collections.unmodifiableSet(zzaba.f23816a);
        this.f23801e = zzaba.f23825j;
        this.f23802f = zzaba.f23826k;
        this.f23803g = zzaba.f23817b;
        this.f23804h = Collections.unmodifiableMap(zzaba.f23818c);
        this.f23805i = zzaba.f23827l;
        this.f23806j = zzaba.f23828m;
        this.f23807k = searchAdRequest;
        this.f23808l = zzaba.f23829n;
        this.f23809m = Collections.unmodifiableSet(zzaba.f23819d);
        this.f23810n = zzaba.f23820e;
        this.f23811o = Collections.unmodifiableSet(zzaba.f23821f);
        this.f23812p = zzaba.f23830o;
        this.f23813q = null;
        this.f23814r = zzaba.f23831p;
        this.f23815s = zzaba.f23832q;
    }

    @Deprecated
    /* renamed from: a */
    public final Date mo29384a() {
        return this.f23797a;
    }

    /* renamed from: b */
    public final String mo29387b() {
        return this.f23798b;
    }

    @Deprecated
    /* renamed from: d */
    public final int mo29390d() {
        return this.f23799c;
    }

    /* renamed from: e */
    public final Set<String> mo29391e() {
        return this.f23800d;
    }

    /* renamed from: f */
    public final Location mo29392f() {
        return this.f23801e;
    }

    /* renamed from: g */
    public final boolean mo29393g() {
        return this.f23802f;
    }

    @Deprecated
    /* renamed from: b */
    public final <T extends NetworkExtras> T mo29386b(Class<T> cls) {
        return (NetworkExtras) this.f23804h.get(cls);
    }

    /* renamed from: c */
    public final Bundle mo29389c(Class<? extends MediationExtrasReceiver> cls) {
        return this.f23803g.getBundle(cls.getName());
    }

    /* renamed from: a */
    public final Bundle mo29383a(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.f23803g.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    /* renamed from: i */
    public final String mo29395i() {
        return this.f23805i;
    }

    /* renamed from: k */
    public final String mo29397k() {
        return this.f23806j;
    }

    /* renamed from: l */
    public final SearchAdRequest mo29398l() {
        return this.f23807k;
    }

    /* renamed from: a */
    public final boolean mo29385a(Context context) {
        Set<String> set = this.f23809m;
        zzyt.m31532a();
        return set.contains(zzazt.m26304a(context));
    }

    /* renamed from: m */
    public final Map<Class<? extends NetworkExtras>, NetworkExtras> mo29399m() {
        return this.f23804h;
    }

    /* renamed from: n */
    public final Bundle mo29400n() {
        return this.f23803g;
    }

    /* renamed from: o */
    public final int mo29401o() {
        return this.f23808l;
    }

    /* renamed from: c */
    public final Bundle mo29388c() {
        return this.f23810n;
    }

    /* renamed from: p */
    public final Set<String> mo29402p() {
        return this.f23811o;
    }

    @Deprecated
    /* renamed from: j */
    public final boolean mo29396j() {
        return this.f23812p;
    }

    /* renamed from: q */
    public final int mo29403q() {
        return this.f23814r;
    }

    /* renamed from: h */
    public final String mo29394h() {
        return this.f23815s;
    }
}
