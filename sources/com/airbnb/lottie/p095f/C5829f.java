package com.airbnb.lottie.p095f;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.C5718c;
import com.airbnb.lottie.p085a.p086a.C5697v;
import java.io.Closeable;

/* renamed from: com.airbnb.lottie.f.f */
/* compiled from: Utils */
public final class C5829f {

    /* renamed from: a */
    private static final PathMeasure f10105a = new PathMeasure();

    /* renamed from: b */
    private static final Path f10106b = new Path();

    /* renamed from: c */
    private static final Path f10107c = new Path();

    /* renamed from: d */
    private static final float[] f10108d = new float[4];

    /* renamed from: e */
    private static final float f10109e = ((float) Math.sqrt(2.0d));

    /* renamed from: f */
    private static float f10110f = -1.0f;

    /* renamed from: a */
    public static Path m10537a(PointF startPoint, PointF endPoint, PointF cp1, PointF cp2) {
        Path path = new Path();
        path.moveTo(startPoint.x, startPoint.y);
        if (cp1 == null || cp2 == null || (cp1.length() == 0.0f && cp2.length() == 0.0f)) {
            path.lineTo(endPoint.x, endPoint.y);
        } else {
            float f = cp1.x + startPoint.x;
            float f2 = cp1.y + startPoint.y;
            float f3 = endPoint.x;
            float f4 = f3 + cp2.x;
            float f5 = endPoint.y;
            path.cubicTo(f, f2, f4, f5 + cp2.y, f3, f5);
        }
        return path;
    }

    /* renamed from: a */
    public static void m10540a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException rethrown) {
                throw rethrown;
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public static float m10535a(Matrix matrix) {
        float[] fArr = f10108d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f = f10109e;
        fArr[2] = f;
        fArr[3] = f;
        matrix.mapPoints(fArr);
        float[] fArr2 = f10108d;
        return ((float) Math.hypot((double) (fArr2[2] - fArr2[0]), (double) (fArr2[3] - fArr2[1]))) / 2.0f;
    }

    /* renamed from: a */
    public static void m10539a(Path path, C5697v trimPath) {
        if (trimPath != null) {
            m10538a(path, ((Float) trimPath.mo17946d().mo17955d()).floatValue() / 100.0f, ((Float) trimPath.mo17944b().mo17955d()).floatValue() / 100.0f, ((Float) trimPath.mo17945c().mo17955d()).floatValue() / 360.0f);
        }
    }

    /* renamed from: a */
    public static void m10538a(Path path, float startValue, float endValue, float offsetValue) {
        String str = "applyTrimPathIfNeeded";
        C5718c.m10176a(str);
        f10105a.setPath(path, false);
        float length = f10105a.getLength();
        if (startValue == 1.0f && endValue == 0.0f) {
            C5718c.m10178c(str);
        } else if (length < 1.0f || ((double) Math.abs((endValue - startValue) - 1.0f)) < 0.01d) {
            C5718c.m10178c(str);
        } else {
            float start = length * startValue;
            float end = length * endValue;
            float offset = offsetValue * length;
            float newStart = Math.min(start, end) + offset;
            float newEnd = Math.max(start, end) + offset;
            if (newStart >= length && newEnd >= length) {
                newStart = (float) C5828e.m10524a(newStart, length);
                newEnd = (float) C5828e.m10524a(newEnd, length);
            }
            if (newStart < 0.0f) {
                newStart = (float) C5828e.m10524a(newStart, length);
            }
            if (newEnd < 0.0f) {
                newEnd = (float) C5828e.m10524a(newEnd, length);
            }
            if (newStart == newEnd) {
                path.reset();
                C5718c.m10178c(str);
                return;
            }
            if (newStart >= newEnd) {
                newStart -= length;
            }
            f10106b.reset();
            f10105a.getSegment(newStart, newEnd, f10106b, true);
            if (newEnd > length) {
                f10107c.reset();
                f10105a.getSegment(0.0f, newEnd % length, f10107c, true);
                f10106b.addPath(f10107c);
            } else if (newStart < 0.0f) {
                f10107c.reset();
                f10105a.getSegment(length + newStart, length, f10107c, true);
                f10106b.addPath(f10107c);
            }
            path.set(f10106b);
            C5718c.m10178c(str);
        }
    }

    /* renamed from: a */
    public static boolean m10541a(int major, int minor, int patch, int minMajor, int minMinor, int minPatch) {
        boolean z = false;
        if (major < minMajor) {
            return false;
        }
        if (major > minMajor) {
            return true;
        }
        if (minor < minMinor) {
            return false;
        }
        if (minor > minMinor) {
            return true;
        }
        if (patch >= minPatch) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public static int m10536a(float a, float b, float c, float d) {
        int result = 17;
        if (a != 0.0f) {
            result = (int) (((float) (17 * 31)) * a);
        }
        if (b != 0.0f) {
            result = (int) (((float) (result * 31)) * b);
        }
        if (c != 0.0f) {
            result = (int) (((float) (result * 31)) * c);
        }
        if (d != 0.0f) {
            return (int) (((float) (result * 31)) * d);
        }
        return result;
    }

    /* renamed from: a */
    public static float m10534a() {
        if (f10110f == -1.0f) {
            f10110f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f10110f;
    }
}
