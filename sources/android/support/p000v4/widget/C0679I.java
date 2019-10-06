package android.support.p000v4.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* renamed from: android.support.v4.widget.I */
/* compiled from: ViewGroupUtils */
public class C0679I {

    /* renamed from: a */
    private static final ThreadLocal<Matrix> f1909a = new ThreadLocal<>();

    /* renamed from: b */
    private static final ThreadLocal<RectF> f1910b = new ThreadLocal<>();

    /* renamed from: b */
    static void m3165b(ViewGroup parent, View descendant, Rect rect) {
        Matrix m = (Matrix) f1909a.get();
        if (m == null) {
            m = new Matrix();
            f1909a.set(m);
        } else {
            m.reset();
        }
        m3164a((ViewParent) parent, descendant, m);
        RectF rectF = (RectF) f1910b.get();
        if (rectF == null) {
            rectF = new RectF();
            f1910b.set(rectF);
        }
        rectF.set(rect);
        m.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    /* renamed from: a */
    public static void m3163a(ViewGroup parent, View descendant, Rect out) {
        out.set(0, 0, descendant.getWidth(), descendant.getHeight());
        m3165b(parent, descendant, out);
    }

    /* renamed from: a */
    private static void m3164a(ViewParent target, View view, Matrix m) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != target) {
            View vp = (View) parent;
            m3164a(target, vp, m);
            m.preTranslate((float) (-vp.getScrollX()), (float) (-vp.getScrollY()));
        }
        m.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            m.preConcat(view.getMatrix());
        }
    }
}
