package com.airbnb.lottie.p085a.p086a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p087b.C5698a;
import com.airbnb.lottie.p085a.p087b.C5698a.C5699a;
import com.airbnb.lottie.p089c.C5776e;
import com.airbnb.lottie.p089c.p091b.C5747j;
import com.airbnb.lottie.p089c.p091b.C5757r.C5758a;
import com.airbnb.lottie.p089c.p092c.C5762c;
import com.airbnb.lottie.p095f.C5828e;
import com.airbnb.lottie.p095f.C5829f;
import com.airbnb.lottie.p096g.C5833c;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.a.r */
/* compiled from: RectangleContent */
public class C5693r implements C5699a, C5686k, C5690o {

    /* renamed from: a */
    private final Path f9744a = new Path();

    /* renamed from: b */
    private final RectF f9745b = new RectF();

    /* renamed from: c */
    private final String f9746c;

    /* renamed from: d */
    private final C5851x f9747d;

    /* renamed from: e */
    private final C5698a<?, PointF> f9748e;

    /* renamed from: f */
    private final C5698a<?, PointF> f9749f;

    /* renamed from: g */
    private final C5698a<?, Float> f9750g;

    /* renamed from: h */
    private C5697v f9751h;

    /* renamed from: i */
    private boolean f9752i;

    public C5693r(C5851x lottieDrawable, C5762c layer, C5747j rectShape) {
        this.f9746c = rectShape.mo18039b();
        this.f9747d = lottieDrawable;
        this.f9748e = rectShape.mo18040c().mo17984a();
        this.f9749f = rectShape.mo18041d().mo17984a();
        this.f9750g = rectShape.mo18038a().mo17984a();
        layer.mo18084a(this.f9748e);
        layer.mo18084a(this.f9749f);
        layer.mo18084a(this.f9750g);
        this.f9748e.mo17951a((C5699a) this);
        this.f9749f.mo17951a((C5699a) this);
        this.f9750g.mo17951a((C5699a) this);
    }

    public String getName() {
        return this.f9746c;
    }

    /* renamed from: a */
    public void mo17932a() {
        m10088b();
    }

    /* renamed from: b */
    private void m10088b() {
        this.f9752i = false;
        this.f9747d.invalidateSelf();
    }

    /* renamed from: a */
    public void mo17937a(List<C5678c> contentsBefore, List<C5678c> list) {
        for (int i = 0; i < contentsBefore.size(); i++) {
            C5678c content = (C5678c) contentsBefore.get(i);
            if ((content instanceof C5697v) && ((C5697v) content).mo17947e() == C5758a.Simultaneously) {
                this.f9751h = (C5697v) content;
                this.f9751h.mo17943a(this);
            }
        }
    }

    public Path getPath() {
        if (this.f9752i) {
            return this.f9744a;
        }
        this.f9744a.reset();
        PointF size = (PointF) this.f9749f.mo17955d();
        float halfWidth = size.x / 2.0f;
        float halfHeight = size.y / 2.0f;
        C5698a<?, Float> aVar = this.f9750g;
        float radius = aVar == null ? 0.0f : ((Float) aVar.mo17955d()).floatValue();
        float maxRadius = Math.min(halfWidth, halfHeight);
        if (radius > maxRadius) {
            radius = maxRadius;
        }
        PointF position = (PointF) this.f9748e.mo17955d();
        this.f9744a.moveTo(position.x + halfWidth, (position.y - halfHeight) + radius);
        this.f9744a.lineTo(position.x + halfWidth, (position.y + halfHeight) - radius);
        if (radius > 0.0f) {
            RectF rectF = this.f9745b;
            float f = position.x;
            float f2 = (f + halfWidth) - (radius * 2.0f);
            float f3 = position.y;
            rectF.set(f2, (f3 + halfHeight) - (radius * 2.0f), f + halfWidth, f3 + halfHeight);
            this.f9744a.arcTo(this.f9745b, 0.0f, 90.0f, false);
        }
        this.f9744a.lineTo((position.x - halfWidth) + radius, position.y + halfHeight);
        if (radius > 0.0f) {
            RectF rectF2 = this.f9745b;
            float f4 = position.x;
            float f5 = f4 - halfWidth;
            float f6 = position.y;
            rectF2.set(f5, (f6 + halfHeight) - (radius * 2.0f), (f4 - halfWidth) + (radius * 2.0f), f6 + halfHeight);
            this.f9744a.arcTo(this.f9745b, 90.0f, 90.0f, false);
        }
        this.f9744a.lineTo(position.x - halfWidth, (position.y - halfHeight) + radius);
        if (radius > 0.0f) {
            RectF rectF3 = this.f9745b;
            float f7 = position.x;
            float f8 = f7 - halfWidth;
            float f9 = position.y;
            rectF3.set(f8, f9 - halfHeight, (f7 - halfWidth) + (radius * 2.0f), (f9 - halfHeight) + (radius * 2.0f));
            this.f9744a.arcTo(this.f9745b, 180.0f, 90.0f, false);
        }
        this.f9744a.lineTo((position.x + halfWidth) - radius, position.y - halfHeight);
        if (radius > 0.0f) {
            RectF rectF4 = this.f9745b;
            float f10 = position.x;
            float f11 = (f10 + halfWidth) - (radius * 2.0f);
            float f12 = position.y;
            rectF4.set(f11, f12 - halfHeight, f10 + halfWidth, (f12 - halfHeight) + (2.0f * radius));
            this.f9744a.arcTo(this.f9745b, 270.0f, 90.0f, false);
        }
        this.f9744a.close();
        C5829f.m10539a(this.f9744a, this.f9751h);
        this.f9752i = true;
        return this.f9744a;
    }

    /* renamed from: a */
    public void mo17935a(C5776e keyPath, int depth, List<C5776e> accumulator, C5776e currentPartialKeyPath) {
        C5828e.m10530a(keyPath, depth, accumulator, currentPartialKeyPath, this);
    }

    /* renamed from: a */
    public <T> void mo17936a(T t, C5833c<T> cVar) {
    }
}
