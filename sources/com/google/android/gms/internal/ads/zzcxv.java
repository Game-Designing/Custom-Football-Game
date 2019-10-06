package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
import java.util.Set;

public final class zzcxv {

    /* renamed from: a */
    public final zzzy f27597a;

    /* renamed from: b */
    public final zzacd f27598b;

    /* renamed from: c */
    public final zzaiy f27599c;

    /* renamed from: d */
    public final zzxz f27600d;

    /* renamed from: e */
    public final zzyd f27601e;

    /* renamed from: f */
    public final String f27602f;

    /* renamed from: g */
    public final ArrayList<String> f27603g;

    /* renamed from: h */
    public final ArrayList<String> f27604h;

    /* renamed from: i */
    public final zzady f27605i;

    /* renamed from: j */
    public final String f27606j;

    /* renamed from: k */
    public final String f27607k;

    /* renamed from: l */
    public final int f27608l;

    /* renamed from: m */
    public final PublisherAdViewOptions f27609m;

    /* renamed from: n */
    public final zzzs f27610n;

    /* renamed from: o */
    public final Set<String> f27611o;

    private zzcxv(zzcxx zzcxx) {
        zzacd zzacd;
        this.f27601e = zzcxx.f27613b;
        this.f27602f = zzcxx.f27615d;
        this.f27597a = zzcxx.f27614c;
        zzxz zzxz = new zzxz(zzcxx.f27612a.f29723a, zzcxx.f27612a.f29724b, zzcxx.f27612a.f29725c, zzcxx.f27612a.f29726d, zzcxx.f27612a.f29727e, zzcxx.f27612a.f29728f, zzcxx.f27612a.f29729g, zzcxx.f27612a.f29730h || zzcxx.f27617f, zzcxx.f27612a.f29731i, zzcxx.f27612a.f29732j, zzcxx.f27612a.f29733k, zzcxx.f27612a.f29734l, zzcxx.f27612a.f29735m, zzcxx.f27612a.f29736n, zzcxx.f27612a.f29737o, zzcxx.f27612a.f29738p, zzcxx.f27612a.f29739q, zzcxx.f27612a.f29740r, zzcxx.f27612a.f29741s, zzcxx.f27612a.f29742t, zzcxx.f27612a.f29743u);
        this.f27600d = zzxz;
        zzady zzady = null;
        if (zzcxx.f27616e != null) {
            zzacd = zzcxx.f27616e;
        } else if (zzcxx.f27620i != null) {
            zzacd = zzcxx.f27620i.f24270f;
        } else {
            zzacd = null;
        }
        this.f27598b = zzacd;
        this.f27603g = zzcxx.f27618g;
        this.f27604h = zzcxx.f27619h;
        if (zzcxx.f27618g != null) {
            if (zzcxx.f27620i == null) {
                zzady = new zzady(new Builder().build());
            } else {
                zzady = zzcxx.f27620i;
            }
        }
        this.f27605i = zzady;
        this.f27606j = zzcxx.f27623l;
        this.f27607k = zzcxx.f27624m;
        this.f27608l = zzcxx.f27625n;
        this.f27609m = zzcxx.f27621j;
        this.f27610n = zzcxx.f27622k;
        this.f27599c = zzcxx.f27626o;
        this.f27611o = zzcxx.f27627p;
    }

    /* renamed from: a */
    public final zzaga mo31285a() {
        PublisherAdViewOptions publisherAdViewOptions = this.f27609m;
        if (publisherAdViewOptions == null) {
            return null;
        }
        return publisherAdViewOptions.zzku();
    }
}
