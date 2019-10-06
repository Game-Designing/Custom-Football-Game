package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.vk */
final class C9775vk implements zzbvo {

    /* renamed from: a */
    private final /* synthetic */ zzcxu f23333a;

    /* renamed from: b */
    private final /* synthetic */ zzcxm f23334b;

    /* renamed from: c */
    private final /* synthetic */ zzcjy f23335c;

    /* renamed from: d */
    final /* synthetic */ zzcnw f23336d;

    C9775vk(zzcnw zzcnw, zzcxu zzcxu, zzcxm zzcxm, zzcjy zzcjy) {
        this.f23336d = zzcnw;
        this.f23333a = zzcxu;
        this.f23334b = zzcxm;
        this.f23335c = zzcjy;
    }

    public final void onInitializationSucceeded() {
        this.f23336d.f27101b.execute(new C9796wk(this, this.f23333a, this.f23334b, this.f23335c));
    }

    /* renamed from: a */
    public final void mo29236a(int i) {
        String valueOf = String.valueOf(this.f23335c.f26728a);
        String str = "Fail to initialize adapter ";
        zzbad.m26359d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}
