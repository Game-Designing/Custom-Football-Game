package p002b.p003c.p053g.p054a;

import android.graphics.Path;
import android.support.v4.graphics.PathParser.PathDataNode;
import android.util.Log;
import java.util.ArrayList;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: b.c.g.a.b */
/* compiled from: PathParser */
public class C1210b {

    /* renamed from: b.c.g.a.b$a */
    /* compiled from: PathParser */
    private static class C1211a {

        /* renamed from: a */
        int f3940a;

        /* renamed from: b */
        boolean f3941b;

        C1211a() {
        }
    }

    /* renamed from: b.c.g.a.b$b */
    /* compiled from: PathParser */
    public static class C1212b {

        /* renamed from: a */
        public char f3942a;

        /* renamed from: b */
        public float[] f3943b;

        C1212b(char type, float[] params) {
            this.f3942a = type;
            this.f3943b = params;
        }

        C1212b(C1212b n) {
            this.f3942a = n.f3942a;
            float[] fArr = n.f3943b;
            this.f3943b = C1210b.m5759a(fArr, 0, fArr.length);
        }

        /* renamed from: a */
        public static void m5768a(C1212b[] node, Path path) {
            float[] current = new float[6];
            char previousCommand = 'm';
            for (int i = 0; i < node.length; i++) {
                m5767a(path, current, previousCommand, node[i].f3942a, node[i].f3943b);
                previousCommand = node[i].f3942a;
            }
        }

        /* renamed from: a */
        public void mo8975a(C1212b nodeFrom, C1212b nodeTo, float fraction) {
            int i = 0;
            while (true) {
                float[] fArr = nodeFrom.f3943b;
                if (i < fArr.length) {
                    this.f3943b[i] = (fArr[i] * (1.0f - fraction)) + (nodeTo.f3943b[i] * fraction);
                    i++;
                } else {
                    return;
                }
            }
        }

        /* renamed from: a */
        private static void m5767a(Path path, float[] current, char previousCmd, char cmd, float[] val) {
            int incr;
            int k;
            float reflectiveCtrlPointY;
            float reflectiveCtrlPointX;
            float reflectiveCtrlPointY2;
            float reflectiveCtrlPointX2;
            Path path2 = path;
            char c = cmd;
            float[] fArr = val;
            float currentX = current[0];
            float currentY = current[1];
            float ctrlPointX = current[2];
            float ctrlPointY = current[3];
            float currentSegmentStartX = current[4];
            float currentSegmentStartY = current[5];
            switch (c) {
                case 'A':
                case 'a':
                    incr = 7;
                    break;
                case 'C':
                case 'c':
                    incr = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    incr = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                    incr = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    incr = 4;
                    break;
                case 'Z':
                case Opcodes.ISHR /*122*/:
                    path.close();
                    currentX = currentSegmentStartX;
                    currentY = currentSegmentStartY;
                    ctrlPointX = currentSegmentStartX;
                    ctrlPointY = currentSegmentStartY;
                    path2.moveTo(currentX, currentY);
                    incr = 2;
                    break;
                default:
                    incr = 2;
                    break;
            }
            int k2 = 0;
            float currentX2 = currentX;
            float currentY2 = currentY;
            float ctrlPointX2 = ctrlPointX;
            float ctrlPointY2 = ctrlPointY;
            float currentSegmentStartX2 = currentSegmentStartX;
            float currentSegmentStartY2 = currentSegmentStartY;
            char previousCmd2 = previousCmd;
            while (k2 < fArr.length) {
                if (c == 'A') {
                    k = k2;
                    m5766a(path, currentX2, currentY2, fArr[k + 5], fArr[k + 6], fArr[k + 0], fArr[k + 1], fArr[k + 2], fArr[k + 3] != 0.0f, fArr[k + 4] != 0.0f);
                    currentX2 = fArr[k + 5];
                    currentY2 = fArr[k + 6];
                    ctrlPointX2 = currentX2;
                    ctrlPointY2 = currentY2;
                } else if (c == 'C') {
                    float f = currentY2;
                    float f2 = currentX2;
                    k = k2;
                    path.cubicTo(fArr[k + 0], fArr[k + 1], fArr[k + 2], fArr[k + 3], fArr[k + 4], fArr[k + 5]);
                    currentX2 = fArr[k + 4];
                    currentY2 = fArr[k + 5];
                    ctrlPointX2 = fArr[k + 2];
                    ctrlPointY2 = fArr[k + 3];
                } else if (c == 'H') {
                    float f3 = currentX2;
                    k = k2;
                    path2.lineTo(fArr[k + 0], currentY2);
                    currentX2 = fArr[k + 0];
                } else if (c == 'Q') {
                    float f4 = currentY2;
                    float f5 = currentX2;
                    k = k2;
                    path2.quadTo(fArr[k + 0], fArr[k + 1], fArr[k + 2], fArr[k + 3]);
                    float ctrlPointX3 = fArr[k + 0];
                    float ctrlPointY3 = fArr[k + 1];
                    currentX2 = fArr[k + 2];
                    currentY2 = fArr[k + 3];
                    ctrlPointX2 = ctrlPointX3;
                    ctrlPointY2 = ctrlPointY3;
                } else if (c == 'V') {
                    float f6 = currentY2;
                    k = k2;
                    path2.lineTo(currentX2, fArr[k + 0]);
                    currentY2 = fArr[k + 0];
                } else if (c == 'a') {
                    float f7 = fArr[k2 + 5] + currentX2;
                    float f8 = fArr[k2 + 6] + currentY2;
                    float f9 = fArr[k2 + 0];
                    float f10 = fArr[k2 + 1];
                    float currentY3 = currentY2;
                    float currentX3 = currentX2;
                    k = k2;
                    m5766a(path, currentX2, currentY2, f7, f8, f9, f10, fArr[k2 + 2], fArr[k2 + 3] != 0.0f, fArr[k2 + 4] != 0.0f);
                    currentX2 = currentX3 + fArr[k + 5];
                    currentY2 = currentY3 + fArr[k + 6];
                    ctrlPointX2 = currentX2;
                    ctrlPointY2 = currentY2;
                } else if (c == 'c') {
                    path.rCubicTo(fArr[k2 + 0], fArr[k2 + 1], fArr[k2 + 2], fArr[k2 + 3], fArr[k2 + 4], fArr[k2 + 5]);
                    float ctrlPointX4 = fArr[k2 + 2] + currentX2;
                    float ctrlPointY4 = fArr[k2 + 3] + currentY2;
                    currentX2 += fArr[k2 + 4];
                    currentY2 += fArr[k2 + 5];
                    ctrlPointX2 = ctrlPointX4;
                    ctrlPointY2 = ctrlPointY4;
                    k = k2;
                } else if (c == 'h') {
                    path2.rLineTo(fArr[k2 + 0], 0.0f);
                    currentX2 += fArr[k2 + 0];
                    k = k2;
                } else if (c == 'q') {
                    path2.rQuadTo(fArr[k2 + 0], fArr[k2 + 1], fArr[k2 + 2], fArr[k2 + 3]);
                    float ctrlPointX5 = fArr[k2 + 0] + currentX2;
                    float ctrlPointY5 = fArr[k2 + 1] + currentY2;
                    currentX2 += fArr[k2 + 2];
                    currentY2 += fArr[k2 + 3];
                    ctrlPointX2 = ctrlPointX5;
                    ctrlPointY2 = ctrlPointY5;
                    k = k2;
                } else if (c == 'v') {
                    path2.rLineTo(0.0f, fArr[k2 + 0]);
                    currentY2 += fArr[k2 + 0];
                    k = k2;
                } else if (c == 'L') {
                    path2.lineTo(fArr[k2 + 0], fArr[k2 + 1]);
                    currentX2 = fArr[k2 + 0];
                    currentY2 = fArr[k2 + 1];
                    k = k2;
                } else if (c == 'M') {
                    currentX2 = fArr[k2 + 0];
                    currentY2 = fArr[k2 + 1];
                    if (k2 > 0) {
                        path2.lineTo(fArr[k2 + 0], fArr[k2 + 1]);
                        k = k2;
                    } else {
                        path2.moveTo(fArr[k2 + 0], fArr[k2 + 1]);
                        currentSegmentStartX2 = currentX2;
                        currentSegmentStartY2 = currentY2;
                        k = k2;
                    }
                } else if (c == 'S') {
                    char previousCmd3 = previousCmd2;
                    float reflectiveCtrlPointX3 = currentX2;
                    float reflectiveCtrlPointY3 = currentY2;
                    if (previousCmd3 == 'c' || previousCmd3 == 's' || previousCmd3 == 'C' || previousCmd3 == 'S') {
                        reflectiveCtrlPointX = (currentX2 * 2.0f) - ctrlPointX2;
                        reflectiveCtrlPointY = (2.0f * currentY2) - ctrlPointY2;
                    } else {
                        reflectiveCtrlPointX = reflectiveCtrlPointX3;
                        reflectiveCtrlPointY = reflectiveCtrlPointY3;
                    }
                    path.cubicTo(reflectiveCtrlPointX, reflectiveCtrlPointY, fArr[k2 + 0], fArr[k2 + 1], fArr[k2 + 2], fArr[k2 + 3]);
                    float ctrlPointX6 = fArr[k2 + 0];
                    float ctrlPointY6 = fArr[k2 + 1];
                    currentX2 = fArr[k2 + 2];
                    currentY2 = fArr[k2 + 3];
                    ctrlPointX2 = ctrlPointX6;
                    ctrlPointY2 = ctrlPointY6;
                    k = k2;
                } else if (c == 'T') {
                    char previousCmd4 = previousCmd2;
                    float reflectiveCtrlPointX4 = currentX2;
                    float reflectiveCtrlPointY4 = currentY2;
                    if (previousCmd4 == 'q' || previousCmd4 == 't' || previousCmd4 == 'Q' || previousCmd4 == 'T') {
                        reflectiveCtrlPointX4 = (currentX2 * 2.0f) - ctrlPointX2;
                        reflectiveCtrlPointY4 = (2.0f * currentY2) - ctrlPointY2;
                    }
                    path2.quadTo(reflectiveCtrlPointX4, reflectiveCtrlPointY4, fArr[k2 + 0], fArr[k2 + 1]);
                    float ctrlPointX7 = reflectiveCtrlPointX4;
                    float ctrlPointY7 = reflectiveCtrlPointY4;
                    currentX2 = fArr[k2 + 0];
                    currentY2 = fArr[k2 + 1];
                    ctrlPointX2 = ctrlPointX7;
                    ctrlPointY2 = ctrlPointY7;
                    k = k2;
                } else if (c == 'l') {
                    path2.rLineTo(fArr[k2 + 0], fArr[k2 + 1]);
                    currentX2 += fArr[k2 + 0];
                    currentY2 += fArr[k2 + 1];
                    k = k2;
                } else if (c == 'm') {
                    currentX2 += fArr[k2 + 0];
                    currentY2 += fArr[k2 + 1];
                    if (k2 > 0) {
                        path2.rLineTo(fArr[k2 + 0], fArr[k2 + 1]);
                        k = k2;
                    } else {
                        path2.rMoveTo(fArr[k2 + 0], fArr[k2 + 1]);
                        currentSegmentStartX2 = currentX2;
                        currentSegmentStartY2 = currentY2;
                        k = k2;
                    }
                } else if (c == 's') {
                    if (previousCmd2 == 'c' || previousCmd2 == 's' || previousCmd2 == 'C' || previousCmd2 == 'S') {
                        reflectiveCtrlPointX2 = currentX2 - ctrlPointX2;
                        reflectiveCtrlPointY2 = currentY2 - ctrlPointY2;
                    } else {
                        reflectiveCtrlPointX2 = 0.0f;
                        reflectiveCtrlPointY2 = 0.0f;
                    }
                    char c2 = previousCmd2;
                    path.rCubicTo(reflectiveCtrlPointX2, reflectiveCtrlPointY2, fArr[k2 + 0], fArr[k2 + 1], fArr[k2 + 2], fArr[k2 + 3]);
                    float ctrlPointX8 = fArr[k2 + 0] + currentX2;
                    float ctrlPointY8 = fArr[k2 + 1] + currentY2;
                    currentX2 += fArr[k2 + 2];
                    currentY2 += fArr[k2 + 3];
                    ctrlPointX2 = ctrlPointX8;
                    ctrlPointY2 = ctrlPointY8;
                    k = k2;
                } else if (c != 't') {
                    char c3 = previousCmd2;
                    k = k2;
                } else {
                    float reflectiveCtrlPointX5 = 0.0f;
                    float reflectiveCtrlPointY5 = 0.0f;
                    if (previousCmd2 == 'q' || previousCmd2 == 't' || previousCmd2 == 'Q' || previousCmd2 == 'T') {
                        reflectiveCtrlPointX5 = currentX2 - ctrlPointX2;
                        reflectiveCtrlPointY5 = currentY2 - ctrlPointY2;
                    }
                    path2.rQuadTo(reflectiveCtrlPointX5, reflectiveCtrlPointY5, fArr[k2 + 0], fArr[k2 + 1]);
                    float ctrlPointX9 = currentX2 + reflectiveCtrlPointX5;
                    float ctrlPointY9 = currentY2 + reflectiveCtrlPointY5;
                    currentX2 += fArr[k2 + 0];
                    currentY2 += fArr[k2 + 1];
                    ctrlPointX2 = ctrlPointX9;
                    ctrlPointY2 = ctrlPointY9;
                    char c4 = previousCmd2;
                    k = k2;
                }
                previousCmd2 = cmd;
                k2 = k + incr;
            }
            char c5 = previousCmd2;
            float currentY4 = currentY2;
            int i = k2;
            current[0] = currentX2;
            current[1] = currentY4;
            current[2] = ctrlPointX2;
            current[3] = ctrlPointY2;
            current[4] = currentSegmentStartX2;
            current[5] = currentSegmentStartY2;
        }

        /* renamed from: a */
        private static void m5766a(Path p, float x0, float y0, float x1, float y1, float a, float b, float theta, boolean isMoreThanHalf, boolean isPositiveArc) {
            double cy;
            double cx;
            float f = x0;
            float f2 = y0;
            float f3 = x1;
            float f4 = y1;
            float f5 = a;
            float f6 = b;
            boolean z = isPositiveArc;
            double thetaD = Math.toRadians((double) theta);
            double cosTheta = Math.cos(thetaD);
            double sinTheta = Math.sin(thetaD);
            double d = (double) f;
            Double.isNaN(d);
            double d2 = d * cosTheta;
            double d3 = (double) f2;
            Double.isNaN(d3);
            double d4 = d2 + (d3 * sinTheta);
            double d5 = (double) f5;
            Double.isNaN(d5);
            double x0p = d4 / d5;
            double d6 = (double) (-f);
            Double.isNaN(d6);
            double d7 = d6 * sinTheta;
            double d8 = (double) f2;
            Double.isNaN(d8);
            double d9 = d7 + (d8 * cosTheta);
            double d10 = (double) f6;
            Double.isNaN(d10);
            double y0p = d9 / d10;
            double d11 = (double) f3;
            Double.isNaN(d11);
            double d12 = d11 * cosTheta;
            double d13 = (double) f4;
            Double.isNaN(d13);
            double d14 = d12 + (d13 * sinTheta);
            double d15 = (double) f5;
            Double.isNaN(d15);
            double x1p = d14 / d15;
            double d16 = (double) (-f3);
            Double.isNaN(d16);
            double d17 = d16 * sinTheta;
            double d18 = (double) f4;
            Double.isNaN(d18);
            double d19 = d17 + (d18 * cosTheta);
            double d20 = (double) f6;
            Double.isNaN(d20);
            double y1p = d19 / d20;
            double dx = x0p - x1p;
            double dy = y0p - y1p;
            double xm = (x0p + x1p) / 2.0d;
            double ym = (y0p + y1p) / 2.0d;
            double dsq = (dx * dx) + (dy * dy);
            String str = "PathParser";
            if (dsq == 0.0d) {
                Log.w(str, " Points are coincident");
                return;
            }
            double disc = (1.0d / dsq) - 0.25d;
            if (disc < 0.0d) {
                StringBuilder sb = new StringBuilder();
                sb.append("Points are too far apart ");
                sb.append(dsq);
                Log.w(str, sb.toString());
                float adjust = (float) (Math.sqrt(dsq) / 1.99999d);
                float f7 = adjust;
                double d21 = dsq;
                boolean z2 = z;
                m5766a(p, x0, y0, x1, y1, f5 * adjust, f6 * adjust, theta, isMoreThanHalf, isPositiveArc);
                return;
            }
            boolean z3 = z;
            double s = Math.sqrt(disc);
            double sdx = s * dx;
            double sdy = s * dy;
            if (isMoreThanHalf == z3) {
                cx = xm - sdy;
                cy = ym + sdx;
            } else {
                cx = xm + sdy;
                cy = ym - sdx;
            }
            double d22 = s;
            double eta0 = Math.atan2(y0p - cy, x0p - cx);
            double d23 = sdx;
            double eta1 = Math.atan2(y1p - cy, x1p - cx);
            double sweep = eta1 - eta0;
            if (z3 != (sweep >= 0.0d)) {
                if (sweep > 0.0d) {
                    sweep -= 6.283185307179586d;
                } else {
                    sweep += 6.283185307179586d;
                }
            }
            double d24 = eta1;
            double eta12 = (double) f5;
            Double.isNaN(eta12);
            double cx2 = cx * eta12;
            double d25 = (double) f6;
            Double.isNaN(d25);
            double cy2 = d25 * cy;
            double cy3 = (cx2 * sinTheta) + (cy2 * cosTheta);
            double d26 = cy3;
            m5765a(p, (cx2 * cosTheta) - (cy2 * sinTheta), cy3, (double) f5, (double) f6, (double) f, (double) f2, thetaD, eta0, sweep);
        }

        /* renamed from: a */
        private static void m5765a(Path p, double cx, double cy, double a, double b, double e1x, double e1y, double theta, double start, double sweep) {
            double d = a;
            int numSegments = (int) Math.ceil(Math.abs((sweep * 4.0d) / 3.141592653589793d));
            double eta1 = start;
            double cosTheta = Math.cos(theta);
            double sinTheta = Math.sin(theta);
            double cosEta1 = Math.cos(eta1);
            double sinEta1 = Math.sin(eta1);
            double ep1x = (((-d) * cosTheta) * sinEta1) - ((b * sinTheta) * cosEta1);
            double ep1y = ((-d) * sinTheta * sinEta1) + (b * cosTheta * cosEta1);
            double ep1y2 = (double) numSegments;
            Double.isNaN(ep1y2);
            double anglePerSegment = sweep / ep1y2;
            double ep1x2 = ep1x;
            double ep1y3 = ep1y;
            double e1x2 = e1x;
            double e1y2 = e1y;
            double d2 = eta1;
            int i = 0;
            double eta12 = d2;
            while (i < numSegments) {
                double eta2 = eta12 + anglePerSegment;
                double sinEta2 = Math.sin(eta2);
                double cosEta2 = Math.cos(eta2);
                double anglePerSegment2 = anglePerSegment;
                double e2x = (cx + ((d * cosTheta) * cosEta2)) - ((b * sinTheta) * sinEta2);
                double cosEta12 = cosEta1;
                double cosEta13 = cy + (d * sinTheta * cosEta2) + (b * cosTheta * sinEta2);
                double sinEta12 = sinEta1;
                double ep2x = (((-d) * cosTheta) * sinEta2) - ((b * sinTheta) * cosEta2);
                int numSegments2 = numSegments;
                int i2 = i;
                double ep2y = ((-d) * sinTheta * sinEta2) + (b * cosTheta * cosEta2);
                double tanDiff2 = Math.tan((eta2 - eta12) / 2.0d);
                double alpha = (Math.sin(eta2 - eta12) * (Math.sqrt(((tanDiff2 * 3.0d) * tanDiff2) + 4.0d) - 1.0d)) / 3.0d;
                double q1x = e1x2 + (alpha * ep1x2);
                int numSegments3 = numSegments2;
                double cosTheta2 = cosTheta;
                double q1y = e1y2 + (alpha * ep1y3);
                double sinTheta2 = sinTheta;
                double q2x = e2x - (alpha * ep2x);
                double ep2y2 = ep2y;
                double q2y = cosEta13 - (alpha * ep2y);
                p.rLineTo(0.0f, 0.0f);
                double d3 = q1x;
                double d4 = q1y;
                double d5 = q2y;
                p.cubicTo((float) q1x, (float) q1y, (float) q2x, (float) q2y, (float) e2x, (float) cosEta13);
                eta12 = eta2;
                e1x2 = e2x;
                e1y2 = cosEta13;
                ep1x2 = ep2x;
                ep1y3 = ep2y2;
                i = i2 + 1;
                d = a;
                numSegments = numSegments3;
                sinEta1 = sinEta12;
                anglePerSegment = anglePerSegment2;
                cosEta1 = cosEta12;
                cosTheta = cosTheta2;
                sinTheta = sinTheta2;
            }
            Path path = p;
            double d6 = anglePerSegment;
            int i3 = numSegments;
            int i4 = i;
            double d7 = cosTheta;
            double d8 = sinTheta;
            double d9 = cosEta1;
            double d10 = sinEta1;
        }
    }

    /* renamed from: a */
    static float[] m5759a(float[] original, int start, int end) {
        if (start <= end) {
            int originalLength = original.length;
            if (start < 0 || start > originalLength) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int resultLength = end - start;
            float[] result = new float[resultLength];
            System.arraycopy(original, start, result, 0, Math.min(resultLength, originalLength - start));
            return result;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: b */
    public static Path m5762b(String pathData) {
        Path path = new Path();
        C1212b[] nodes = m5760a(pathData);
        if (nodes == null) {
            return null;
        }
        try {
            C1212b.m5768a(nodes, path);
            return path;
        } catch (RuntimeException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error in parsing ");
            sb.append(pathData);
            throw new RuntimeException(sb.toString(), e);
        }
    }

    /* renamed from: a */
    public static C1212b[] m5760a(String pathData) {
        if (pathData == null) {
            return null;
        }
        int start = 0;
        int end = 1;
        ArrayList<PathDataNode> list = new ArrayList<>();
        while (end < pathData.length()) {
            int end2 = m5755a(pathData, end);
            String s = pathData.substring(start, end2).trim();
            if (s.length() > 0) {
                m5757a(list, s.charAt(0), m5764c(s));
            }
            start = end2;
            end = end2 + 1;
        }
        if (end - start == 1 && start < pathData.length()) {
            m5757a(list, pathData.charAt(start), new float[0]);
        }
        return (C1212b[]) list.toArray(new C1212b[list.size()]);
    }

    /* renamed from: a */
    public static C1212b[] m5761a(C1212b[] source) {
        if (source == null) {
            return null;
        }
        C1212b[] copy = new C1212b[source.length];
        for (int i = 0; i < source.length; i++) {
            copy[i] = new C1212b(source[i]);
        }
        return copy;
    }

    /* renamed from: a */
    public static boolean m5758a(C1212b[] nodesFrom, C1212b[] nodesTo) {
        if (nodesFrom == null || nodesTo == null || nodesFrom.length != nodesTo.length) {
            return false;
        }
        for (int i = 0; i < nodesFrom.length; i++) {
            if (nodesFrom[i].f3942a != nodesTo[i].f3942a || nodesFrom[i].f3943b.length != nodesTo[i].f3943b.length) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static void m5763b(C1212b[] target, C1212b[] source) {
        for (int i = 0; i < source.length; i++) {
            target[i].f3942a = source[i].f3942a;
            for (int j = 0; j < source[i].f3943b.length; j++) {
                target[i].f3943b[j] = source[i].f3943b[j];
            }
        }
    }

    /* renamed from: a */
    private static int m5755a(String s, int end) {
        while (end < s.length()) {
            char c = s.charAt(end);
            if (((c - 'A') * (c - 'Z') <= 0 || (c - 'a') * (c - 'z') <= 0) && c != 'e' && c != 'E') {
                return end;
            }
            end++;
        }
        return end;
    }

    /* renamed from: a */
    private static void m5757a(ArrayList<C1212b> list, char cmd, float[] val) {
        list.add(new C1212b(cmd, val));
    }

    /* renamed from: c */
    private static float[] m5764c(String s) {
        if (s.charAt(0) == 'z' || s.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] results = new float[s.length()];
            int count = 0;
            int startPosition = 1;
            C1211a result = new C1211a();
            int totalLength = s.length();
            while (startPosition < totalLength) {
                m5756a(s, startPosition, result);
                int endPosition = result.f3940a;
                if (startPosition < endPosition) {
                    int count2 = count + 1;
                    results[count] = Float.parseFloat(s.substring(startPosition, endPosition));
                    count = count2;
                }
                if (result.f3941b != 0) {
                    startPosition = endPosition;
                } else {
                    startPosition = endPosition + 1;
                }
            }
            return m5759a(results, 0, count);
        } catch (NumberFormatException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("error in parsing \"");
            sb.append(s);
            sb.append("\"");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003b A[LOOP:0: B:1:0x0007->B:20:0x003b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m5756a(java.lang.String r7, int r8, p002b.p003c.p053g.p054a.C1210b.C1211a r9) {
        /*
            r0 = r8
            r1 = 0
            r2 = 0
            r9.f3941b = r2
            r2 = 0
            r3 = 0
        L_0x0007:
            int r4 = r7.length()
            if (r0 >= r4) goto L_0x003e
            r4 = r3
            r3 = 0
            char r5 = r7.charAt(r0)
            r6 = 32
            if (r5 == r6) goto L_0x0036
            r6 = 69
            if (r5 == r6) goto L_0x0034
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L_0x0034
            r6 = 1
            switch(r5) {
                case 44: goto L_0x0036;
                case 45: goto L_0x002c;
                case 46: goto L_0x0024;
                default: goto L_0x0023;
            }
        L_0x0023:
            goto L_0x0038
        L_0x0024:
            if (r2 != 0) goto L_0x0028
            r2 = 1
            goto L_0x0038
        L_0x0028:
            r1 = 1
            r9.f3941b = r6
            goto L_0x0038
        L_0x002c:
            if (r0 == r8) goto L_0x0038
            if (r4 != 0) goto L_0x0038
            r1 = 1
            r9.f3941b = r6
            goto L_0x0038
        L_0x0034:
            r3 = 1
            goto L_0x0038
        L_0x0036:
            r1 = 1
        L_0x0038:
            if (r1 == 0) goto L_0x003b
            goto L_0x003e
        L_0x003b:
            int r0 = r0 + 1
            goto L_0x0007
        L_0x003e:
            r9.f3940a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p002b.p003c.p053g.p054a.C1210b.m5756a(java.lang.String, int, b.c.g.a.b$a):void");
    }
}
