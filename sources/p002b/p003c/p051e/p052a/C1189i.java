package p002b.p003c.p051e.p052a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.p000v4.content.p036a.C0509e;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;
import p002b.p003c.p053g.p054a.C1210b;

/* renamed from: b.c.e.a.i */
/* compiled from: PathInterpolatorCompat */
public class C1189i implements Interpolator {

    /* renamed from: a */
    private float[] f3852a;

    /* renamed from: b */
    private float[] f3853b;

    public C1189i(Context context, AttributeSet attrs, XmlPullParser parser) {
        this(context.getResources(), context.getTheme(), attrs, parser);
    }

    public C1189i(Resources res, Theme theme, AttributeSet attrs, XmlPullParser parser) {
        TypedArray a = C0509e.m2551a(res, theme, attrs, C1178a.f3836l);
        m5676a(a, parser);
        a.recycle();
    }

    /* renamed from: a */
    private void m5676a(TypedArray a, XmlPullParser parser) {
        String str = "pathData";
        if (C0509e.m2556a(parser, str)) {
            String pathData = C0509e.m2553a(a, parser, str, 4);
            Path path = C1210b.m5762b(pathData);
            if (path != null) {
                m5677a(path);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The path is null, which is created from ");
            sb.append(pathData);
            throw new InflateException(sb.toString());
        }
        String pathData2 = "controlX1";
        if (C0509e.m2556a(parser, pathData2)) {
            String str2 = "controlY1";
            if (C0509e.m2556a(parser, str2)) {
                float x1 = C0509e.m2547a(a, parser, pathData2, 0, 0.0f);
                float y1 = C0509e.m2547a(a, parser, str2, 1, 0.0f);
                String str3 = "controlX2";
                boolean hasX2 = C0509e.m2556a(parser, str3);
                String str4 = "controlY2";
                if (hasX2 != C0509e.m2556a(parser, str4)) {
                    throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
                } else if (!hasX2) {
                    m5674a(x1, y1);
                } else {
                    m5675a(x1, y1, C0509e.m2547a(a, parser, str3, 2, 0.0f), C0509e.m2547a(a, parser, str4, 3, 0.0f));
                }
            } else {
                throw new InflateException("pathInterpolator requires the controlY1 attribute");
            }
        } else {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
    }

    /* renamed from: a */
    private void m5674a(float controlX, float controlY) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(controlX, controlY, 1.0f, 1.0f);
        m5677a(path);
    }

    /* renamed from: a */
    private void m5675a(float x1, float y1, float x2, float y2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(x1, y1, x2, y2, 1.0f, 1.0f);
        m5677a(path);
    }

    /* renamed from: a */
    private void m5677a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float pathLength = pathMeasure.getLength();
        int numPoints = Math.min(3000, ((int) (pathLength / 0.002f)) + 1);
        if (numPoints > 0) {
            this.f3852a = new float[numPoints];
            this.f3853b = new float[numPoints];
            float[] position = new float[2];
            for (int i = 0; i < numPoints; i++) {
                pathMeasure.getPosTan((((float) i) * pathLength) / ((float) (numPoints - 1)), position, null);
                this.f3852a[i] = position[0];
                this.f3853b[i] = position[1];
            }
            if (((double) Math.abs(this.f3852a[0])) > 1.0E-5d || ((double) Math.abs(this.f3853b[0])) > 1.0E-5d || ((double) Math.abs(this.f3852a[numPoints - 1] - 1.0f)) > 1.0E-5d || ((double) Math.abs(this.f3853b[numPoints - 1] - 1.0f)) > 1.0E-5d) {
                StringBuilder sb = new StringBuilder();
                sb.append("The Path must start at (0,0) and end at (1,1) start: ");
                sb.append(this.f3852a[0]);
                String str = ",";
                sb.append(str);
                sb.append(this.f3853b[0]);
                sb.append(" end:");
                sb.append(this.f3852a[numPoints - 1]);
                sb.append(str);
                sb.append(this.f3853b[numPoints - 1]);
                throw new IllegalArgumentException(sb.toString());
            }
            float prevX = 0.0f;
            int componentIndex = 0;
            int i2 = 0;
            while (i2 < numPoints) {
                float[] fArr = this.f3852a;
                int componentIndex2 = componentIndex + 1;
                float x = fArr[componentIndex];
                if (x >= prevX) {
                    fArr[i2] = x;
                    prevX = x;
                    i2++;
                    componentIndex = componentIndex2;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("The Path cannot loop back on itself, x :");
                    sb2.append(x);
                    throw new IllegalArgumentException(sb2.toString());
                }
            }
            if (pathMeasure.nextContour() != 0) {
                throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
            }
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("The Path has a invalid length ");
        sb3.append(pathLength);
        throw new IllegalArgumentException(sb3.toString());
    }

    public float getInterpolation(float t) {
        if (t <= 0.0f) {
            return 0.0f;
        }
        if (t >= 1.0f) {
            return 1.0f;
        }
        int startIndex = 0;
        int endIndex = this.f3852a.length - 1;
        while (endIndex - startIndex > 1) {
            int midIndex = (startIndex + endIndex) / 2;
            if (t < this.f3852a[midIndex]) {
                endIndex = midIndex;
            } else {
                startIndex = midIndex;
            }
        }
        float[] fArr = this.f3852a;
        float xRange = fArr[endIndex] - fArr[startIndex];
        if (xRange == 0.0f) {
            return this.f3853b[startIndex];
        }
        float fraction = (t - fArr[startIndex]) / xRange;
        float[] fArr2 = this.f3853b;
        float startY = fArr2[startIndex];
        return ((fArr2[endIndex] - startY) * fraction) + startY;
    }
}
