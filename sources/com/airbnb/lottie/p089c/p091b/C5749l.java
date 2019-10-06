package com.airbnb.lottie.p089c.p091b;

import android.graphics.PointF;
import com.airbnb.lottie.C5718c;
import com.airbnb.lottie.p089c.C5719a;
import com.airbnb.lottie.p095f.C5828e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.airbnb.lottie.c.b.l */
/* compiled from: ShapeData */
public class C5749l {

    /* renamed from: a */
    private final List<C5719a> f9921a = new ArrayList();

    /* renamed from: b */
    private PointF f9922b;

    /* renamed from: c */
    private boolean f9923c;

    public C5749l(PointF initialPoint, boolean closed, List<C5719a> curves) {
        this.f9922b = initialPoint;
        this.f9923c = closed;
        this.f9921a.addAll(curves);
    }

    public C5749l() {
    }

    /* renamed from: a */
    private void m10266a(float x, float y) {
        if (this.f9922b == null) {
            this.f9922b = new PointF();
        }
        this.f9922b.set(x, y);
    }

    /* renamed from: b */
    public PointF mo18049b() {
        return this.f9922b;
    }

    /* renamed from: c */
    public boolean mo18050c() {
        return this.f9923c;
    }

    /* renamed from: a */
    public List<C5719a> mo18047a() {
        return this.f9921a;
    }

    /* renamed from: a */
    public void mo18048a(C5749l shapeData1, C5749l shapeData2, float percentage) {
        float f = percentage;
        if (this.f9922b == null) {
            this.f9922b = new PointF();
        }
        this.f9923c = shapeData1.mo18050c() || shapeData2.mo18050c();
        if (shapeData1.mo18047a().size() != shapeData2.mo18047a().size()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Curves must have the same number of control points. Shape 1: ");
            sb.append(shapeData1.mo18047a().size());
            sb.append("\tShape 2: ");
            sb.append(shapeData2.mo18047a().size());
            C5718c.m10179d(sb.toString());
        }
        if (this.f9921a.isEmpty()) {
            int points = Math.min(shapeData1.mo18047a().size(), shapeData2.mo18047a().size());
            for (int i = 0; i < points; i++) {
                this.f9921a.add(new C5719a());
            }
        }
        PointF initialPoint1 = shapeData1.mo18049b();
        PointF initialPoint2 = shapeData2.mo18049b();
        m10266a(C5828e.m10533c(initialPoint1.x, initialPoint2.x, f), C5828e.m10533c(initialPoint1.y, initialPoint2.y, f));
        int i2 = this.f9921a.size() - 1;
        while (i2 >= 0) {
            C5719a curve1 = (C5719a) shapeData1.mo18047a().get(i2);
            C5719a curve2 = (C5719a) shapeData2.mo18047a().get(i2);
            PointF cp11 = curve1.mo17978a();
            PointF cp21 = curve1.mo17980b();
            PointF vertex1 = curve1.mo17982c();
            PointF cp12 = curve2.mo17978a();
            PointF cp22 = curve2.mo17980b();
            PointF vertex2 = curve2.mo17982c();
            PointF initialPoint12 = initialPoint1;
            ((C5719a) this.f9921a.get(i2)).mo17979a(C5828e.m10533c(cp11.x, cp12.x, f), C5828e.m10533c(cp11.y, cp12.y, f));
            ((C5719a) this.f9921a.get(i2)).mo17981b(C5828e.m10533c(cp21.x, cp22.x, f), C5828e.m10533c(cp21.y, cp22.y, f));
            ((C5719a) this.f9921a.get(i2)).mo17983c(C5828e.m10533c(vertex1.x, vertex2.x, f), C5828e.m10533c(vertex1.y, vertex2.y, f));
            i2--;
            initialPoint1 = initialPoint12;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShapeData{numCurves=");
        sb.append(this.f9921a.size());
        sb.append("closed=");
        sb.append(this.f9923c);
        sb.append('}');
        return sb.toString();
    }
}
