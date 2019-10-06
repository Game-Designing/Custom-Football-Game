package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout.C0239e;
import android.support.p000v4.view.C0592M;
import android.support.p000v4.view.C0623f;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;
import p002b.p003c.p053g.p058c.C1226a;

/* renamed from: android.support.design.widget.N */
/* compiled from: HeaderScrollingViewBehavior */
abstract class C0261N extends C0291fa<View> {

    /* renamed from: d */
    final Rect f1013d = new Rect();

    /* renamed from: e */
    final Rect f1014e = new Rect();

    /* renamed from: f */
    private int f1015f = 0;

    /* renamed from: g */
    private int f1016g;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract View mo4242a(List<View> list);

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public abstract float mo4245b(View view);

    public C0261N() {
    }

    public C0261N(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /* renamed from: a */
    public boolean mo4227a(CoordinatorLayout parent, View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        int availableHeight;
        int childLpHeight = child.getLayoutParams().height;
        if (childLpHeight == -1 || childLpHeight == -2) {
            View header = mo4242a(parent.mo4368b(child));
            if (header != null) {
                if (!C0646w.m2972f(header)) {
                    View view = child;
                } else if (!C0646w.m2972f(child)) {
                    C0646w.m2961a(child, true);
                    if (C0646w.m2972f(child)) {
                        child.requestLayout();
                        return true;
                    }
                } else {
                    View view2 = child;
                }
                int availableHeight2 = MeasureSpec.getSize(parentHeightMeasureSpec);
                if (availableHeight2 == 0) {
                    availableHeight = parent.getHeight();
                } else {
                    availableHeight = availableHeight2;
                }
                parent.mo4360a(child, parentWidthMeasureSpec, widthUsed, MeasureSpec.makeMeasureSpec((availableHeight - header.getMeasuredHeight()) + mo4247c(header), childLpHeight == -1 ? 1073741824 : LinearLayoutManager.INVALID_OFFSET), heightUsed);
                return true;
            }
            View view3 = child;
        } else {
            View view4 = child;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4537b(CoordinatorLayout parent, View child, int layoutDirection) {
        View header = mo4242a(parent.mo4368b(child));
        if (header != null) {
            C0239e lp = (C0239e) child.getLayoutParams();
            Rect available = this.f1013d;
            available.set(parent.getPaddingLeft() + lp.leftMargin, header.getBottom() + lp.topMargin, (parent.getWidth() - parent.getPaddingRight()) - lp.rightMargin, ((parent.getHeight() + header.getBottom()) - parent.getPaddingBottom()) - lp.bottomMargin);
            C0592M parentInsets = parent.getLastWindowInsets();
            if (parentInsets != null && C0646w.m2972f(parent) && !C0646w.m2972f(child)) {
                available.left += parentInsets.mo5487c();
                available.right -= parentInsets.mo5488d();
            }
            Rect out = this.f1014e;
            C0623f.m2882a(m1598c(lp.f929c), child.getMeasuredWidth(), child.getMeasuredHeight(), available, out, layoutDirection);
            int overlap = mo4535a(header);
            child.layout(out.left, out.top - overlap, out.right, out.bottom - overlap);
            this.f1015f = out.top - header.getBottom();
            return;
        }
        super.mo4537b(parent, child, layoutDirection);
        this.f1015f = 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final int mo4535a(View header) {
        if (this.f1016g == 0) {
            return 0;
        }
        float b = mo4245b(header);
        int i = this.f1016g;
        return C1226a.m5823a((int) (b * ((float) i)), 0, i);
    }

    /* renamed from: c */
    private static int m1598c(int gravity) {
        if (gravity == 0) {
            return 8388659;
        }
        return gravity;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo4247c(View v) {
        return v.getMeasuredHeight();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final int mo4539d() {
        return this.f1015f;
    }

    /* renamed from: b */
    public final void mo4536b(int overlayTop) {
        this.f1016g = overlayTop;
    }

    /* renamed from: c */
    public final int mo4538c() {
        return this.f1016g;
    }
}
