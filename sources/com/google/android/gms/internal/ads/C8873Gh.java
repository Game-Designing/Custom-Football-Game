package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.Gh */
final /* synthetic */ class C8873Gh implements Callable {

    /* renamed from: a */
    private final zzcaq f21048a;

    /* renamed from: b */
    private final zzbbh f21049b;

    /* renamed from: c */
    private final zzbbh f21050c;

    /* renamed from: d */
    private final zzbbh f21051d;

    /* renamed from: e */
    private final zzbbh f21052e;

    /* renamed from: f */
    private final zzbbh f21053f;

    /* renamed from: g */
    private final JSONObject f21054g;

    /* renamed from: h */
    private final zzbbh f21055h;

    /* renamed from: i */
    private final zzbbh f21056i;

    /* renamed from: j */
    private final zzbbh f21057j;

    C8873Gh(zzcaq zzcaq, zzbbh zzbbh, zzbbh zzbbh2, zzbbh zzbbh3, zzbbh zzbbh4, zzbbh zzbbh5, JSONObject jSONObject, zzbbh zzbbh6, zzbbh zzbbh7, zzbbh zzbbh8) {
        this.f21048a = zzcaq;
        this.f21049b = zzbbh;
        this.f21050c = zzbbh2;
        this.f21051d = zzbbh3;
        this.f21052e = zzbbh4;
        this.f21053f = zzbbh5;
        this.f21054g = jSONObject;
        this.f21055h = zzbbh6;
        this.f21056i = zzbbh7;
        this.f21057j = zzbbh8;
    }

    public final Object call() {
        zzcaq zzcaq = this.f21048a;
        zzbbh zzbbh = this.f21049b;
        zzbbh zzbbh2 = this.f21050c;
        zzbbh zzbbh3 = this.f21051d;
        zzbbh zzbbh4 = this.f21052e;
        zzbbh zzbbh5 = this.f21053f;
        JSONObject jSONObject = this.f21054g;
        zzbbh zzbbh6 = this.f21055h;
        zzbbh zzbbh7 = this.f21056i;
        zzbbh zzbbh8 = this.f21057j;
        zzbyt zzbyt = (zzbyt) zzbbh.get();
        zzbyt.mo31000a((List) zzbbh2.get());
        zzbyt.mo30995a((zzaei) zzbbh3.get());
        zzbyt.mo31002b((zzaei) zzbbh4.get());
        zzbyt.mo30994a((zzaea) zzbbh5.get());
        zzbyt.mo31004b(zzcau.m28180a(jSONObject));
        zzbyt.mo30993a(zzcau.m28181b(jSONObject));
        zzbgz zzbgz = (zzbgz) zzbbh6.get();
        if (zzbgz != null) {
            zzbyt.mo30996a(zzbgz);
            zzbyt.mo30990a(zzbgz.getView());
            zzbyt.mo30992a((zzaar) zzbgz.mo28754g());
        }
        zzbgz zzbgz2 = (zzbgz) zzbbh7.get();
        if (zzbgz2 != null) {
            zzbyt.mo31003b(zzbgz2);
        }
        for (zzcbg zzcbg : (List) zzbbh8.get()) {
            int i = zzcbg.f26307a;
            if (i == 1) {
                zzbyt.mo30999a(zzcbg.f26308b, zzcbg.f26309c);
            } else if (i == 2) {
                zzbyt.mo30998a(zzcbg.f26308b, zzcbg.f26310d);
            }
        }
        return zzbyt;
    }
}
