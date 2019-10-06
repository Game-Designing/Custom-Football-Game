package com.airbnb.lottie.p095f;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.p085a.p086a.C5686k;
import com.airbnb.lottie.p089c.C5719a;
import com.airbnb.lottie.p089c.C5776e;
import com.airbnb.lottie.p089c.C5777f;
import com.airbnb.lottie.p089c.p091b.C5749l;
import java.util.List;

/* renamed from: com.airbnb.lottie.f.e */
/* compiled from: MiscUtils */
public class C5828e {
    /* renamed from: a */
    public static PointF m10528a(PointF p1, PointF p2) {
        return new PointF(p1.x + p2.x, p1.y + p2.y);
    }

    /* renamed from: a */
    public static void m10529a(C5749l shapeData, Path outPath) {
        Path path = outPath;
        outPath.reset();
        PointF initialPoint = shapeData.mo18049b();
        path.moveTo(initialPoint.x, initialPoint.y);
        PointF currentPoint = new PointF(initialPoint.x, initialPoint.y);
        for (int i = 0; i < shapeData.mo18047a().size(); i++) {
            C5719a curveData = (C5719a) shapeData.mo18047a().get(i);
            PointF cp1 = curveData.mo17978a();
            PointF cp2 = curveData.mo17980b();
            PointF vertex = curveData.mo17982c();
            if (!cp1.equals(currentPoint) || !cp2.equals(vertex)) {
                outPath.cubicTo(cp1.x, cp1.y, cp2.x, cp2.y, vertex.x, vertex.y);
            } else {
                path.lineTo(vertex.x, vertex.y);
            }
            currentPoint.set(vertex.x, vertex.y);
        }
        if (shapeData.mo18050c()) {
            outPath.close();
        }
    }

    /* renamed from: c */
    public static float m10533c(float a, float b, float percentage) {
        return ((b - a) * percentage) + a;
    }

    /* renamed from: a */
    public static double m10522a(double a, double b, double percentage) {
        return ((b - a) * percentage) + a;
    }

    /* renamed from: a */
    public static int m10526a(int a, int b, float percentage) {
        return (int) (((float) a) + (((float) (b - a)) * percentage));
    }

    /* renamed from: a */
    static int m10524a(float x, float y) {
        return m10531b((int) x, (int) y);
    }

    /* renamed from: b */
    private static int m10531b(int x, int y) {
        return x - (m10525a(x, y) * y);
    }

    /* renamed from: a */
    private static int m10525a(int x, int y) {
        int r = x / y;
        int mod = x % y;
        if (((x ^ y) >= 0) || mod == 0) {
            return r;
        }
        return r - 1;
    }

    /* renamed from: a */
    public static int m10527a(int number, int min, int max) {
        return Math.max(min, Math.min(max, number));
    }

    /* renamed from: a */
    public static float m10523a(float number, float min, float max) {
        return Math.max(min, Math.min(max, number));
    }

    /* renamed from: b */
    public static boolean m10532b(float number, float rangeMin, float rangeMax) {
        return number >= rangeMin && number <= rangeMax;
    }

    /* renamed from: a */
    public static void m10530a(C5776e keyPath, int depth, List<C5776e> accumulator, C5776e currentPartialKeyPath, C5686k content) {
        if (keyPath.mo18121a(content.getName(), depth)) {
            accumulator.add(currentPartialKeyPath.mo18119a(content.getName()).mo18118a((C5777f) content));
        }
    }
}
