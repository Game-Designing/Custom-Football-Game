package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.ta */
final class C9723ta implements zzbbv<zzajw> {

    /* renamed from: a */
    private final /* synthetic */ zzala f23004a;

    /* renamed from: b */
    private final /* synthetic */ zzakh f23005b;

    C9723ta(zzakh zzakh, zzala zzala) {
        this.f23005b = zzakh;
        this.f23004a = zzala;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28056a(Object obj) {
        synchronized (this.f23005b.f24384a) {
            this.f23005b.f24391h = 0;
            if (!(this.f23005b.f24390g == null || this.f23004a == this.f23005b.f24390g)) {
                zzawz.m26003f("New JS engine is loaded, marking previous one as destroyable.");
                this.f23005b.f24390g.mo29803e();
            }
            this.f23005b.f24390g = this.f23004a;
        }
    }
}
