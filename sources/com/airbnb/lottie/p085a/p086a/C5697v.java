package com.airbnb.lottie.p085a.p086a;

import com.airbnb.lottie.p085a.p087b.C5698a;
import com.airbnb.lottie.p085a.p087b.C5698a.C5699a;
import com.airbnb.lottie.p089c.p091b.C5757r;
import com.airbnb.lottie.p089c.p091b.C5757r.C5758a;
import com.airbnb.lottie.p089c.p092c.C5762c;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.a.v */
/* compiled from: TrimPathContent */
public class C5697v implements C5678c, C5699a {

    /* renamed from: a */
    private final String f9772a;

    /* renamed from: b */
    private final List<C5699a> f9773b = new ArrayList();

    /* renamed from: c */
    private final C5758a f9774c;

    /* renamed from: d */
    private final C5698a<?, Float> f9775d;

    /* renamed from: e */
    private final C5698a<?, Float> f9776e;

    /* renamed from: f */
    private final C5698a<?, Float> f9777f;

    public C5697v(C5762c layer, C5757r trimPath) {
        this.f9772a = trimPath.mo18075b();
        this.f9774c = trimPath.mo18078e();
        this.f9775d = trimPath.mo18077d().mo17984a();
        this.f9776e = trimPath.mo18074a().mo17984a();
        this.f9777f = trimPath.mo18076c().mo17984a();
        layer.mo18084a(this.f9775d);
        layer.mo18084a(this.f9776e);
        layer.mo18084a(this.f9777f);
        this.f9775d.mo17951a((C5699a) this);
        this.f9776e.mo17951a((C5699a) this);
        this.f9777f.mo17951a((C5699a) this);
    }

    /* renamed from: a */
    public void mo17932a() {
        for (int i = 0; i < this.f9773b.size(); i++) {
            ((C5699a) this.f9773b.get(i)).mo17932a();
        }
    }

    /* renamed from: a */
    public void mo17937a(List<C5678c> list, List<C5678c> list2) {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo17943a(C5699a listener) {
        this.f9773b.add(listener);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public C5758a mo17947e() {
        return this.f9774c;
    }

    /* renamed from: d */
    public C5698a<?, Float> mo17946d() {
        return this.f9775d;
    }

    /* renamed from: b */
    public C5698a<?, Float> mo17944b() {
        return this.f9776e;
    }

    /* renamed from: c */
    public C5698a<?, Float> mo17945c() {
        return this.f9777f;
    }
}
