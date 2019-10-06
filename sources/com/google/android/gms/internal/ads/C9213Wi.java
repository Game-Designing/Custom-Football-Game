package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

/* renamed from: com.google.android.gms.internal.ads.Wi */
final class C9213Wi implements zzban<zzcxu> {

    /* renamed from: a */
    private final /* synthetic */ zzchl f21899a;

    C9213Wi(zzchl zzchl) {
        this.f21899a = zzchl;
    }

    /* renamed from: a */
    public final void mo27999a(Throwable th) {
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24033We)).booleanValue()) {
            Matcher matcher = zzchl.f26629b.matcher(th.getMessage());
            if (matcher.matches()) {
                this.f21899a.f26634g.mo31175a(Integer.parseInt(matcher.group(1)));
            }
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27998a(Object obj) {
        zzcxu zzcxu = (zzcxu) obj;
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24033We)).booleanValue()) {
            this.f21899a.f26634g.mo31175a(zzcxu.f27596b.f27591b.f27583e);
            this.f21899a.f26634g.mo31176a(zzcxu.f27596b.f27591b.f27584f);
        }
    }
}
