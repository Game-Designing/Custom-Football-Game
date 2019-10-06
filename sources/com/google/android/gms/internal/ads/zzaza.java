package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzaza extends zzr<zzp> {

    /* renamed from: p */
    private final zzbbr<zzp> f25009p;

    /* renamed from: q */
    private final Map<String, String> f25010q;

    /* renamed from: r */
    private final zzazx f25011r;

    public zzaza(String str, zzbbr<zzp> zzbbr) {
        this(str, null, zzbbr);
    }

    private zzaza(String str, Map<String, String> map, zzbbr<zzp> zzbbr) {
        super(0, str, new C9851zc(zzbbr));
        this.f25010q = null;
        this.f25009p = zzbbr;
        this.f25011r = new zzazx();
        this.f25011r.mo30317a(str, "GET", null, null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final zzy<zzp> mo30196a(zzp zzp) {
        return zzy.m31506a(zzp, zzaq.m25652a(zzp));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ void mo29242a(Object obj) {
        zzp zzp = (zzp) obj;
        this.f25011r.mo30320a(zzp.f29062c, zzp.f29060a);
        zzazx zzazx = this.f25011r;
        byte[] bArr = zzp.f29061b;
        if (zzazx.m26334a() && bArr != null) {
            zzazx.mo30321a(bArr);
        }
        this.f25009p.mo30338b(zzp);
    }
}
