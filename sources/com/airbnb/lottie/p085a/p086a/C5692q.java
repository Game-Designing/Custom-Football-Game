package com.airbnb.lottie.p085a.p086a;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.C5663B;
import com.airbnb.lottie.C5851x;
import com.airbnb.lottie.p085a.p087b.C5698a;
import com.airbnb.lottie.p085a.p087b.C5698a.C5699a;
import com.airbnb.lottie.p089c.C5776e;
import com.airbnb.lottie.p089c.p091b.C5745i;
import com.airbnb.lottie.p089c.p091b.C5745i.C5746a;
import com.airbnb.lottie.p089c.p091b.C5757r.C5758a;
import com.airbnb.lottie.p089c.p092c.C5762c;
import com.airbnb.lottie.p095f.C5828e;
import com.airbnb.lottie.p095f.C5829f;
import com.airbnb.lottie.p096g.C5833c;
import java.util.List;

/* renamed from: com.airbnb.lottie.a.a.q */
/* compiled from: PolystarContent */
public class C5692q implements C5690o, C5699a, C5686k {

    /* renamed from: a */
    private final Path f9731a = new Path();

    /* renamed from: b */
    private final String f9732b;

    /* renamed from: c */
    private final C5851x f9733c;

    /* renamed from: d */
    private final C5746a f9734d;

    /* renamed from: e */
    private final C5698a<?, Float> f9735e;

    /* renamed from: f */
    private final C5698a<?, PointF> f9736f;

    /* renamed from: g */
    private final C5698a<?, Float> f9737g;

    /* renamed from: h */
    private final C5698a<?, Float> f9738h;

    /* renamed from: i */
    private final C5698a<?, Float> f9739i;

    /* renamed from: j */
    private final C5698a<?, Float> f9740j;

    /* renamed from: k */
    private final C5698a<?, Float> f9741k;

    /* renamed from: l */
    private C5697v f9742l;

    /* renamed from: m */
    private boolean f9743m;

    public C5692q(C5851x lottieDrawable, C5762c layer, C5745i polystarShape) {
        this.f9733c = lottieDrawable;
        this.f9732b = polystarShape.mo18031c();
        this.f9734d = polystarShape.mo18037i();
        this.f9735e = polystarShape.mo18034f().mo17984a();
        this.f9736f = polystarShape.mo18035g().mo17984a();
        this.f9737g = polystarShape.mo18036h().mo17984a();
        this.f9739i = polystarShape.mo18032d().mo17984a();
        this.f9741k = polystarShape.mo18033e().mo17984a();
        if (this.f9734d == C5746a.Star) {
            this.f9738h = polystarShape.mo18029a().mo17984a();
            this.f9740j = polystarShape.mo18030b().mo17984a();
        } else {
            this.f9738h = null;
            this.f9740j = null;
        }
        layer.mo18084a(this.f9735e);
        layer.mo18084a(this.f9736f);
        layer.mo18084a(this.f9737g);
        layer.mo18084a(this.f9739i);
        layer.mo18084a(this.f9741k);
        if (this.f9734d == C5746a.Star) {
            layer.mo18084a(this.f9738h);
            layer.mo18084a(this.f9740j);
        }
        this.f9735e.mo17951a((C5699a) this);
        this.f9736f.mo17951a((C5699a) this);
        this.f9737g.mo17951a((C5699a) this);
        this.f9739i.mo17951a((C5699a) this);
        this.f9741k.mo17951a((C5699a) this);
        if (this.f9734d == C5746a.Star) {
            this.f9738h.mo17951a((C5699a) this);
            this.f9740j.mo17951a((C5699a) this);
        }
    }

    /* renamed from: a */
    public void mo17932a() {
        m10083d();
    }

    /* renamed from: d */
    private void m10083d() {
        this.f9743m = false;
        this.f9733c.invalidateSelf();
    }

    /* renamed from: a */
    public void mo17937a(List<C5678c> contentsBefore, List<C5678c> list) {
        for (int i = 0; i < contentsBefore.size(); i++) {
            C5678c content = (C5678c) contentsBefore.get(i);
            if ((content instanceof C5697v) && ((C5697v) content).mo17947e() == C5758a.Simultaneously) {
                this.f9742l = (C5697v) content;
                this.f9742l.mo17943a(this);
            }
        }
    }

    public Path getPath() {
        if (this.f9743m) {
            return this.f9731a;
        }
        this.f9731a.reset();
        int i = C5691p.f9730a[this.f9734d.ordinal()];
        if (i == 1) {
            m10082c();
        } else if (i == 2) {
            m10081b();
        }
        this.f9731a.close();
        C5829f.m10539a(this.f9731a, this.f9742l);
        this.f9743m = true;
        return this.f9731a;
    }

    public String getName() {
        return this.f9732b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x022c  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0255  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10082c() {
        /*
            r46 = this;
            r0 = r46
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r1 = r0.f9735e
            java.lang.Object r1 = r1.mo17955d()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r2 = r0.f9737g
            if (r2 != 0) goto L_0x0015
            r2 = 0
            goto L_0x0020
        L_0x0015:
            java.lang.Object r2 = r2.mo17955d()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            double r2 = (double) r2
        L_0x0020:
            r4 = 4636033603912859648(0x4056800000000000, double:90.0)
            double r2 = r2 - r4
            double r2 = java.lang.Math.toRadians(r2)
            r4 = 4618760256179416344(0x401921fb54442d18, double:6.283185307179586)
            double r6 = (double) r1
            java.lang.Double.isNaN(r6)
            double r4 = r4 / r6
            float r4 = (float) r4
            r5 = 1073741824(0x40000000, float:2.0)
            float r6 = r4 / r5
            int r7 = (int) r1
            float r7 = (float) r7
            float r7 = r1 - r7
            r8 = 0
            int r9 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r9 == 0) goto L_0x004c
            r9 = 1065353216(0x3f800000, float:1.0)
            float r9 = r9 - r7
            float r9 = r9 * r6
            double r9 = (double) r9
            java.lang.Double.isNaN(r9)
            double r2 = r2 + r9
        L_0x004c:
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r9 = r0.f9739i
            java.lang.Object r9 = r9.mo17955d()
            java.lang.Float r9 = (java.lang.Float) r9
            float r9 = r9.floatValue()
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r10 = r0.f9738h
            java.lang.Object r10 = r10.mo17955d()
            java.lang.Float r10 = (java.lang.Float) r10
            float r10 = r10.floatValue()
            r11 = 0
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r12 = r0.f9740j
            r13 = 1120403456(0x42c80000, float:100.0)
            if (r12 == 0) goto L_0x0077
            java.lang.Object r12 = r12.mo17955d()
            java.lang.Float r12 = (java.lang.Float) r12
            float r12 = r12.floatValue()
            float r11 = r12 / r13
        L_0x0077:
            r12 = 0
            com.airbnb.lottie.a.b.a<?, java.lang.Float> r14 = r0.f9741k
            if (r14 == 0) goto L_0x0088
            java.lang.Object r14 = r14.mo17955d()
            java.lang.Float r14 = (java.lang.Float) r14
            float r14 = r14.floatValue()
            float r14 = r14 / r13
            r12 = r14
        L_0x0088:
            r13 = 0
            int r14 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r14 == 0) goto L_0x00c1
            float r14 = r9 - r10
            float r14 = r14 * r7
            float r13 = r10 + r14
            double r14 = (double) r13
            double r16 = java.lang.Math.cos(r2)
            java.lang.Double.isNaN(r14)
            double r14 = r14 * r16
            float r14 = (float) r14
            r16 = r9
            double r8 = (double) r13
            double r17 = java.lang.Math.sin(r2)
            java.lang.Double.isNaN(r8)
            double r8 = r8 * r17
            float r8 = (float) r8
            android.graphics.Path r9 = r0.f9731a
            r9.moveTo(r14, r8)
            float r9 = r4 * r7
            float r9 = r9 / r5
            r18 = r6
            double r5 = (double) r9
            java.lang.Double.isNaN(r5)
            double r2 = r2 + r5
            r5 = r16
            r6 = r18
            r16 = r8
            goto L_0x00eb
        L_0x00c1:
            r18 = r6
            r16 = r9
            r5 = r16
            double r8 = (double) r5
            double r19 = java.lang.Math.cos(r2)
            java.lang.Double.isNaN(r8)
            double r8 = r8 * r19
            float r14 = (float) r8
            double r8 = (double) r5
            double r19 = java.lang.Math.sin(r2)
            java.lang.Double.isNaN(r8)
            double r8 = r8 * r19
            float r8 = (float) r8
            android.graphics.Path r6 = r0.f9731a
            r6.moveTo(r14, r8)
            r16 = r8
            r6 = r18
            double r8 = (double) r6
            java.lang.Double.isNaN(r8)
            double r2 = r2 + r8
        L_0x00eb:
            r8 = 0
            r18 = r2
            double r2 = (double) r1
            double r2 = java.lang.Math.ceil(r2)
            r20 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r2 = r2 * r20
            r9 = 0
        L_0x00f8:
            r22 = r1
            double r0 = (double) r9
            int r23 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r23 >= 0) goto L_0x026f
            if (r8 == 0) goto L_0x0103
            r0 = r5
            goto L_0x0104
        L_0x0103:
            r0 = r10
        L_0x0104:
            r1 = r6
            r15 = 0
            int r23 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r23 == 0) goto L_0x011e
            r23 = r0
            r24 = r1
            double r0 = (double) r9
            double r25 = r2 - r20
            int r27 = (r0 > r25 ? 1 : (r0 == r25 ? 0 : -1))
            if (r27 != 0) goto L_0x011b
            float r0 = r4 * r7
            r1 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r1
            goto L_0x0126
        L_0x011b:
            r1 = 1073741824(0x40000000, float:2.0)
            goto L_0x0124
        L_0x011e:
            r23 = r0
            r24 = r1
            r1 = 1073741824(0x40000000, float:2.0)
        L_0x0124:
            r0 = r24
        L_0x0126:
            r24 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r15 = 0
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 == 0) goto L_0x013a
            r17 = r4
            r26 = r5
            double r4 = (double) r9
            double r27 = r2 - r24
            int r29 = (r4 > r27 ? 1 : (r4 == r27 ? 0 : -1))
            if (r29 != 0) goto L_0x013e
            r4 = r13
            goto L_0x0140
        L_0x013a:
            r17 = r4
            r26 = r5
        L_0x013e:
            r4 = r23
        L_0x0140:
            r5 = r14
            r23 = r16
            r27 = r2
            double r1 = (double) r4
            double r29 = java.lang.Math.cos(r18)
            java.lang.Double.isNaN(r1)
            double r1 = r1 * r29
            float r1 = (float) r1
            double r2 = (double) r4
            double r29 = java.lang.Math.sin(r18)
            java.lang.Double.isNaN(r2)
            double r2 = r2 * r29
            float r2 = (float) r2
            r3 = 0
            int r14 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r14 != 0) goto L_0x017b
            int r14 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r14 != 0) goto L_0x017b
            r3 = r46
            android.graphics.Path r14 = r3.f9731a
            r14.lineTo(r1, r2)
            r39 = r4
            r40 = r5
            r36 = r11
            r37 = r12
            r38 = r13
            r16 = r23
            r23 = r10
            goto L_0x024b
        L_0x017b:
            r3 = r46
            r36 = r11
            r14 = r23
            r23 = r10
            double r10 = (double) r14
            r37 = r12
            r38 = r13
            double r12 = (double) r5
            double r10 = java.lang.Math.atan2(r10, r12)
            r12 = 4609753056924675352(0x3ff921fb54442d18, double:1.5707963267948966)
            double r10 = r10 - r12
            float r10 = (float) r10
            double r12 = (double) r10
            double r11 = java.lang.Math.cos(r12)
            float r11 = (float) r11
            double r12 = (double) r10
            double r12 = java.lang.Math.sin(r12)
            float r12 = (float) r12
            r16 = r14
            double r13 = (double) r2
            r39 = r4
            r40 = r5
            double r4 = (double) r1
            double r4 = java.lang.Math.atan2(r13, r4)
            r13 = 4609753056924675352(0x3ff921fb54442d18, double:1.5707963267948966)
            double r4 = r4 - r13
            float r4 = (float) r4
            double r13 = (double) r4
            double r13 = java.lang.Math.cos(r13)
            float r5 = (float) r13
            double r13 = (double) r4
            double r13 = java.lang.Math.sin(r13)
            float r13 = (float) r13
            if (r8 == 0) goto L_0x01c4
            r14 = r36
            goto L_0x01c6
        L_0x01c4:
            r14 = r37
        L_0x01c6:
            if (r8 == 0) goto L_0x01cb
            r29 = r37
            goto L_0x01cd
        L_0x01cb:
            r29 = r36
        L_0x01cd:
            r41 = r29
            if (r8 == 0) goto L_0x01d4
            r29 = r23
            goto L_0x01d6
        L_0x01d4:
            r29 = r26
        L_0x01d6:
            r42 = r29
            if (r8 == 0) goto L_0x01dd
            r29 = r26
            goto L_0x01df
        L_0x01dd:
            r29 = r23
        L_0x01df:
            r43 = r29
            float r29 = r42 * r14
            r30 = 1056236141(0x3ef4e26d, float:0.47829)
            float r29 = r29 * r30
            float r29 = r29 * r11
            float r31 = r42 * r14
            float r31 = r31 * r30
            float r31 = r31 * r12
            float r32 = r43 * r41
            float r32 = r32 * r30
            float r32 = r32 * r5
            float r33 = r43 * r41
            float r33 = r33 * r30
            float r33 = r33 * r13
            r15 = 0
            int r30 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r30 == 0) goto L_0x022c
            if (r9 != 0) goto L_0x0214
            float r29 = r29 * r7
            float r31 = r31 * r7
            r44 = r4
            r45 = r5
            r4 = r29
            r5 = r31
            r24 = r32
            r25 = r33
            goto L_0x0238
        L_0x0214:
            r44 = r4
            r45 = r5
            double r4 = (double) r9
            double r24 = r27 - r24
            int r30 = (r4 > r24 ? 1 : (r4 == r24 ? 0 : -1))
            if (r30 != 0) goto L_0x0230
            float r32 = r32 * r7
            float r33 = r33 * r7
            r4 = r29
            r5 = r31
            r24 = r32
            r25 = r33
            goto L_0x0238
        L_0x022c:
            r44 = r4
            r45 = r5
        L_0x0230:
            r4 = r29
            r5 = r31
            r24 = r32
            r25 = r33
        L_0x0238:
            android.graphics.Path r15 = r3.f9731a
            float r30 = r40 - r4
            float r31 = r16 - r5
            float r32 = r1 + r24
            float r33 = r2 + r25
            r29 = r15
            r34 = r1
            r35 = r2
            r29.cubicTo(r30, r31, r32, r33, r34, r35)
        L_0x024b:
            double r4 = (double) r0
            java.lang.Double.isNaN(r4)
            double r18 = r18 + r4
            if (r8 != 0) goto L_0x0255
            r4 = 1
            goto L_0x0256
        L_0x0255:
            r4 = 0
        L_0x0256:
            r8 = r4
            int r9 = r9 + 1
            r14 = r1
            r16 = r2
            r0 = r3
            r4 = r17
            r1 = r22
            r10 = r23
            r5 = r26
            r2 = r27
            r11 = r36
            r12 = r37
            r13 = r38
            goto L_0x00f8
        L_0x026f:
            r27 = r2
            r17 = r4
            r26 = r5
            r23 = r10
            r36 = r11
            r37 = r12
            r38 = r13
            r3 = r46
            com.airbnb.lottie.a.b.a<?, android.graphics.PointF> r0 = r3.f9736f
            java.lang.Object r0 = r0.mo17955d()
            android.graphics.PointF r0 = (android.graphics.PointF) r0
            android.graphics.Path r1 = r3.f9731a
            float r2 = r0.x
            float r4 = r0.y
            r1.offset(r2, r4)
            android.graphics.Path r1 = r3.f9731a
            r1.close()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.p085a.p086a.C5692q.m10082c():void");
    }

    /* renamed from: b */
    private void m10081b() {
        float anglePerPoint;
        double currentAngle;
        double numPoints;
        int points;
        int points2 = (int) Math.floor((double) ((Float) this.f9735e.mo17955d()).floatValue());
        C5698a<?, Float> aVar = this.f9737g;
        double currentAngle2 = Math.toRadians((aVar == null ? 0.0d : (double) ((Float) aVar.mo17955d()).floatValue()) - 90.0d);
        double d = (double) points2;
        Double.isNaN(d);
        float anglePerPoint2 = (float) (6.283185307179586d / d);
        float roundedness = ((Float) this.f9741k.mo17955d()).floatValue() / 100.0f;
        float radius = ((Float) this.f9739i.mo17955d()).floatValue();
        double d2 = (double) radius;
        double cos = Math.cos(currentAngle2);
        Double.isNaN(d2);
        float x = (float) (d2 * cos);
        double d3 = (double) radius;
        double sin = Math.sin(currentAngle2);
        Double.isNaN(d3);
        float y = (float) (d3 * sin);
        this.f9731a.moveTo(x, y);
        double d4 = (double) anglePerPoint2;
        Double.isNaN(d4);
        double currentAngle3 = currentAngle2 + d4;
        double numPoints2 = Math.ceil((double) points2);
        int i = 0;
        while (((double) i) < numPoints2) {
            float previousX = x;
            float previousY = y;
            double d5 = (double) radius;
            double cos2 = Math.cos(currentAngle3);
            Double.isNaN(d5);
            x = (float) (d5 * cos2);
            double d6 = (double) radius;
            double sin2 = Math.sin(currentAngle3);
            Double.isNaN(d6);
            y = (float) (d6 * sin2);
            if (roundedness != 0.0f) {
                numPoints = numPoints2;
                float cp1Theta = (float) (Math.atan2((double) previousY, (double) previousX) - 1.5707963267948966d);
                points = points2;
                currentAngle = currentAngle3;
                anglePerPoint = anglePerPoint2;
                float cp2Theta = (float) (Math.atan2((double) y, (double) x) - 1.5707963267948966d);
                float f = cp2Theta;
                this.f9731a.cubicTo(previousX - (((radius * roundedness) * 0.25f) * ((float) Math.cos((double) cp1Theta))), previousY - (((radius * roundedness) * 0.25f) * ((float) Math.sin((double) cp1Theta))), x + (radius * roundedness * 0.25f * ((float) Math.cos((double) cp2Theta))), y + (radius * roundedness * 0.25f * ((float) Math.sin((double) cp2Theta))), x, y);
            } else {
                points = points2;
                currentAngle = currentAngle3;
                anglePerPoint = anglePerPoint2;
                numPoints = numPoints2;
                this.f9731a.lineTo(x, y);
            }
            float anglePerPoint3 = anglePerPoint;
            double d7 = (double) anglePerPoint3;
            Double.isNaN(d7);
            currentAngle3 = currentAngle + d7;
            i++;
            anglePerPoint2 = anglePerPoint3;
            points2 = points;
            numPoints2 = numPoints;
        }
        double d8 = currentAngle3;
        float f2 = anglePerPoint2;
        double d9 = numPoints2;
        PointF position = (PointF) this.f9736f.mo17955d();
        this.f9731a.offset(position.x, position.y);
        this.f9731a.close();
    }

    /* renamed from: a */
    public void mo17935a(C5776e keyPath, int depth, List<C5776e> accumulator, C5776e currentPartialKeyPath) {
        C5828e.m10530a(keyPath, depth, accumulator, currentPartialKeyPath, this);
    }

    /* renamed from: a */
    public <T> void mo17936a(T property, C5833c<T> callback) {
        if (property == C5663B.f9609o) {
            this.f9735e.mo17952a(callback);
        } else if (property == C5663B.f9610p) {
            this.f9737g.mo17952a(callback);
        } else if (property == C5663B.f9602h) {
            this.f9736f.mo17952a(callback);
        } else {
            if (property == C5663B.f9611q) {
                C5698a<?, Float> aVar = this.f9738h;
                if (aVar != null) {
                    aVar.mo17952a(callback);
                    return;
                }
            }
            if (property == C5663B.f9612r) {
                this.f9739i.mo17952a(callback);
                return;
            }
            if (property == C5663B.f9613s) {
                C5698a<?, Float> aVar2 = this.f9740j;
                if (aVar2 != null) {
                    aVar2.mo17952a(callback);
                    return;
                }
            }
            if (property == C5663B.f9614t) {
                this.f9741k.mo17952a(callback);
            }
        }
    }
}
