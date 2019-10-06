package com.google.android.gms.internal.ads;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.qa */
final class C9660qa implements zzaho<zzalf> {

    /* renamed from: a */
    private final /* synthetic */ zzdh f22886a;

    /* renamed from: b */
    private final /* synthetic */ zzajw f22887b;

    /* renamed from: c */
    private final /* synthetic */ zzazk f22888c;

    /* renamed from: d */
    private final /* synthetic */ zzakh f22889d;

    C9660qa(zzakh zzakh, zzdh zzdh, zzajw zzajw, zzazk zzazk) {
        this.f22889d = zzakh;
        this.f22886a = zzdh;
        this.f22887b = zzajw;
        this.f22888c = zzazk;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27996a(Object obj, Map map) {
        synchronized (this.f22889d.f24384a) {
            zzbad.m26357c("JS Engine is requesting an update");
            if (this.f22889d.f24391h == 0) {
                zzbad.m26357c("Starting reload.");
                this.f22889d.f24391h = 2;
                this.f22889d.mo29793a(this.f22886a);
            }
            this.f22887b.mo29792b("/requestReload", (zzaho) this.f22888c.mo30302a());
        }
    }
}
