package p002b.p003c.p053g.p054a;

import android.graphics.Color;

/* renamed from: b.c.g.a.a */
/* compiled from: ColorUtils */
public final class C1199a {

    /* renamed from: a */
    private static final ThreadLocal<double[]> f3923a = new ThreadLocal<>();

    /* renamed from: a */
    public static int m5718a(int foreground, int background) {
        int bgAlpha = Color.alpha(background);
        int fgAlpha = Color.alpha(foreground);
        int a = m5723c(fgAlpha, bgAlpha);
        return Color.argb(a, m5720a(Color.red(foreground), fgAlpha, Color.red(background), bgAlpha, a), m5720a(Color.green(foreground), fgAlpha, Color.green(background), bgAlpha, a), m5720a(Color.blue(foreground), fgAlpha, Color.blue(background), bgAlpha, a));
    }

    /* renamed from: c */
    private static int m5723c(int foregroundAlpha, int backgroundAlpha) {
        return 255 - (((255 - backgroundAlpha) * (255 - foregroundAlpha)) / 255);
    }

    /* renamed from: a */
    private static int m5720a(int fgC, int fgA, int bgC, int bgA, int a) {
        if (a == 0) {
            return 0;
        }
        return (((fgC * 255) * fgA) + ((bgC * bgA) * (255 - fgA))) / (a * 255);
    }

    /* renamed from: a */
    public static int m5721a(float[] hsl) {
        float h = hsl[0];
        float s = hsl[1];
        float l = hsl[2];
        float c = (1.0f - Math.abs((l * 2.0f) - 1.0f)) * s;
        float m = l - (0.5f * c);
        float x = (1.0f - Math.abs(((h / 60.0f) % 2.0f) - 1.0f)) * c;
        int r = 0;
        int g = 0;
        int b = 0;
        switch (((int) h) / 60) {
            case 0:
                r = Math.round((c + m) * 255.0f);
                g = Math.round((x + m) * 255.0f);
                b = Math.round(255.0f * m);
                break;
            case 1:
                r = Math.round((x + m) * 255.0f);
                g = Math.round((c + m) * 255.0f);
                b = Math.round(255.0f * m);
                break;
            case 2:
                r = Math.round(m * 255.0f);
                g = Math.round((c + m) * 255.0f);
                b = Math.round((x + m) * 255.0f);
                break;
            case 3:
                r = Math.round(m * 255.0f);
                g = Math.round((x + m) * 255.0f);
                b = Math.round((c + m) * 255.0f);
                break;
            case 4:
                r = Math.round((x + m) * 255.0f);
                g = Math.round(m * 255.0f);
                b = Math.round((c + m) * 255.0f);
                break;
            case 5:
            case 6:
                r = Math.round((c + m) * 255.0f);
                g = Math.round(m * 255.0f);
                b = Math.round((x + m) * 255.0f);
                break;
        }
        return Color.rgb(m5719a(r, 0, 255), m5719a(g, 0, 255), m5719a(b, 0, 255));
    }

    /* renamed from: b */
    public static int m5722b(int color, int alpha) {
        if (alpha >= 0 && alpha <= 255) {
            return (16777215 & color) | (alpha << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    /* renamed from: a */
    private static int m5719a(int amount, int low, int high) {
        if (amount < low) {
            return low;
        }
        return amount > high ? high : amount;
    }
}
