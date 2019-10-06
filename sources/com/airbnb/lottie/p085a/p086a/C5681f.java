package com.airbnb.lottie.p085a.p086a;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.C5663B;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p087b.C5698a;
import com.airbnb.lottie.p085a.p087b.C5698a.C5699a;
import com.airbnb.lottie.p089c.C5776e;
import com.airbnb.lottie.p089c.p091b.C5735a;
import com.airbnb.lottie.p089c.p091b.C5757r.C5758a;
import com.airbnb.lottie.p089c.p092c.C5762c;
import com.airbnb.lottie.p095f.C5828e;
import com.airbnb.lottie.p095f.C5829f;
import com.airbnb.lottie.p096g.C5833c;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.a.f */
/* compiled from: EllipseContent */
public class C5681f implements C5690o, C5699a, C5686k {

    /* renamed from: a */
    private final Path f9680a = new Path();

    /* renamed from: b */
    private final String f9681b;

    /* renamed from: c */
    private final C5851x f9682c;

    /* renamed from: d */
    private final C5698a<?, PointF> f9683d;

    /* renamed from: e */
    private final C5698a<?, PointF> f9684e;

    /* renamed from: f */
    private final C5735a f9685f;

    /* renamed from: g */
    private C5697v f9686g;

    /* renamed from: h */
    private boolean f9687h;

    public C5681f(C5851x lottieDrawable, C5762c layer, C5735a circleShape) {
        this.f9681b = circleShape.mo17996a();
        this.f9682c = lottieDrawable;
        this.f9683d = circleShape.mo17998c().mo17984a();
        this.f9684e = circleShape.mo17997b().mo17984a();
        this.f9685f = circleShape;
        layer.mo18084a(this.f9683d);
        layer.mo18084a(this.f9684e);
        this.f9683d.mo17951a((C5699a) this);
        this.f9684e.mo17951a((C5699a) this);
    }

    /* renamed from: a */
    public void mo17932a() {
        m10052b();
    }

    /* renamed from: b */
    private void m10052b() {
        this.f9687h = false;
        this.f9682c.invalidateSelf();
    }

    /* renamed from: a */
    public void mo17937a(List<C5678c> contentsBefore, List<C5678c> list) {
        for (int i = 0; i < contentsBefore.size(); i++) {
            C5678c content = (C5678c) contentsBefore.get(i);
            if ((content instanceof C5697v) && ((C5697v) content).mo17947e() == C5758a.Simultaneously) {
                this.f9686g = (C5697v) content;
                this.f9686g.mo17943a(this);
            }
        }
    }

    public String getName() {
        return this.f9681b;
    }

    public Path getPath() {
        if (this.f9687h) {
            return this.f9680a;
        }
        this.f9680a.reset();
        PointF size = (PointF) this.f9683d.mo17955d();
        float halfWidth = size.x / 2.0f;
        float halfHeight = size.y / 2.0f;
        float cpW = halfWidth * 0.55228f;
        float cpH = halfHeight * 0.55228f;
        this.f9680a.reset();
        if (this.f9685f.mo17999d()) {
            this.f9680a.moveTo(0.0f, -halfHeight);
            this.f9680a.cubicTo(0.0f - cpW, -halfHeight, -halfWidth, 0.0f - cpH, -halfWidth, 0.0f);
            this.f9680a.cubicTo(-halfWidth, cpH + 0.0f, 0.0f - cpW, halfHeight, 0.0f, halfHeight);
            this.f9680a.cubicTo(cpW + 0.0f, halfHeight, halfWidth, cpH + 0.0f, halfWidth, 0.0f);
            this.f9680a.cubicTo(halfWidth, 0.0f - cpH, cpW + 0.0f, -halfHeight, 0.0f, -halfHeight);
        } else {
            this.f9680a.moveTo(0.0f, -halfHeight);
            this.f9680a.cubicTo(cpW + 0.0f, -halfHeight, halfWidth, 0.0f - cpH, halfWidth, 0.0f);
            this.f9680a.cubicTo(halfWidth, cpH + 0.0f, cpW + 0.0f, halfHeight, 0.0f, halfHeight);
            this.f9680a.cubicTo(0.0f - cpW, halfHeight, -halfWidth, cpH + 0.0f, -halfWidth, 0.0f);
            this.f9680a.cubicTo(-halfWidth, 0.0f - cpH, 0.0f - cpW, -halfHeight, 0.0f, -halfHeight);
        }
        PointF position = (PointF) this.f9684e.mo17955d();
        this.f9680a.offset(position.x, position.y);
        this.f9680a.close();
        C5829f.m10539a(this.f9680a, this.f9686g);
        this.f9687h = true;
        return this.f9680a;
    }

    /* renamed from: a */
    public void mo17935a(C5776e keyPath, int depth, List<C5776e> accumulator, C5776e currentPartialKeyPath) {
        C5828e.m10530a(keyPath, depth, accumulator, currentPartialKeyPath, this);
    }

    /* renamed from: a */
    public <T> void mo17936a(T property, C5833c<T> callback) {
        if (property == C5663B.f9601g) {
            this.f9683d.mo17952a(callback);
        } else if (property == C5663B.f9602h) {
            this.f9684e.mo17952a(callback);
        }
    }
}
