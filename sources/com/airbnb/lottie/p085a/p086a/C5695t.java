package com.airbnb.lottie.p085a.p086a;

import android.graphics.Path;
import android.graphics.Path.FillType;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p087b.C5698a;
import com.airbnb.lottie.p085a.p087b.C5698a.C5699a;
import com.airbnb.lottie.p089c.p091b.C5752o;
import com.airbnb.lottie.p089c.p091b.C5757r.C5758a;
import com.airbnb.lottie.p089c.p092c.C5762c;
import com.airbnb.lottie.p095f.C5829f;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.a.t */
/* compiled from: ShapeContent */
public class C5695t implements C5690o, C5699a {

    /* renamed from: a */
    private final Path f9762a = new Path();

    /* renamed from: b */
    private final String f9763b;

    /* renamed from: c */
    private final C5851x f9764c;

    /* renamed from: d */
    private final C5698a<?, Path> f9765d;

    /* renamed from: e */
    private boolean f9766e;

    /* renamed from: f */
    private C5697v f9767f;

    public C5695t(C5851x lottieDrawable, C5762c layer, C5752o shape) {
        this.f9763b = shape.mo18060a();
        this.f9764c = lottieDrawable;
        this.f9765d = shape.mo18061b().mo17984a();
        layer.mo18084a(this.f9765d);
        this.f9765d.mo17951a((C5699a) this);
    }

    /* renamed from: a */
    public void mo17932a() {
        m10100b();
    }

    /* renamed from: b */
    private void m10100b() {
        this.f9766e = false;
        this.f9764c.invalidateSelf();
    }

    /* renamed from: a */
    public void mo17937a(List<C5678c> contentsBefore, List<C5678c> list) {
        for (int i = 0; i < contentsBefore.size(); i++) {
            C5678c content = (C5678c) contentsBefore.get(i);
            if ((content instanceof C5697v) && ((C5697v) content).mo17947e() == C5758a.Simultaneously) {
                this.f9767f = (C5697v) content;
                this.f9767f.mo17943a(this);
            }
        }
    }

    public Path getPath() {
        if (this.f9766e) {
            return this.f9762a;
        }
        this.f9762a.reset();
        this.f9762a.set((Path) this.f9765d.mo17955d());
        this.f9762a.setFillType(FillType.EVEN_ODD);
        C5829f.m10539a(this.f9762a, this.f9767f);
        this.f9766e = true;
        return this.f9762a;
    }
}
