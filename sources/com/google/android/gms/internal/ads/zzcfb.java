package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.net.Uri.Builder;
import java.util.Map;
import java.util.Map.Entry;

public final class zzcfb implements zzbro, zzbsr, zzbtk {

    /* renamed from: a */
    private final zzcfi f26511a;

    /* renamed from: b */
    private final String f26512b = ((String) zzyt.m31536e().mo29599a(zzacu.f24089fa));

    /* renamed from: c */
    private final zzdae f26513c;

    public zzcfb(zzcfi zzcfi, zzdae zzdae) {
        this.f26511a = zzcfi;
        this.f26513c = zzdae;
    }

    public final void onAdLoaded() {
        m28351a(this.f26511a.mo31142a());
    }

    public final void onAdFailedToLoad(int i) {
        m28351a(this.f26511a.mo31142a());
    }

    /* renamed from: a */
    private final void m28351a(Map<String, String> map) {
        Builder buildUpon = Uri.parse(this.f26512b).buildUpon();
        for (Entry entry : map.entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        String uri = buildUpon.build().toString();
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24083ea)).booleanValue()) {
            this.f26513c.mo31342a(uri);
        }
        zzawz.m26003f(uri);
    }

    /* renamed from: a */
    public final void mo28900a(zzarx zzarx) {
        this.f26511a.mo31143a(zzarx.f24715a);
    }

    /* renamed from: a */
    public final void mo28901a(zzcxu zzcxu) {
        this.f26511a.mo31144a(zzcxu);
    }
}
