package android.support.p001v7.widget;

import android.support.p001v7.widget.RecyclerView.C0981i;
import android.support.p001v7.widget.RecyclerView.C0984j;
import android.view.View;

/* renamed from: android.support.v7.widget.za */
/* compiled from: OrientationHelper */
class C1139za extends C0916Ba {
    C1139za(C0981i layoutManager) {
        super(layoutManager, null);
    }

    /* renamed from: b */
    public int mo6969b() {
        return this.f2921a.getWidth() - this.f2921a.getPaddingRight();
    }

    /* renamed from: a */
    public int mo6966a() {
        return this.f2921a.getWidth();
    }

    /* renamed from: a */
    public void mo6968a(int amount) {
        this.f2921a.offsetChildrenHorizontal(amount);
    }

    /* renamed from: f */
    public int mo6977f() {
        return this.f2921a.getPaddingLeft();
    }

    /* renamed from: b */
    public int mo6970b(View view) {
        C0984j params = (C0984j) view.getLayoutParams();
        return this.f2921a.getDecoratedMeasuredWidth(view) + params.leftMargin + params.rightMargin;
    }

    /* renamed from: c */
    public int mo6972c(View view) {
        C0984j params = (C0984j) view.getLayoutParams();
        return this.f2921a.getDecoratedMeasuredHeight(view) + params.topMargin + params.bottomMargin;
    }

    /* renamed from: a */
    public int mo6967a(View view) {
        return this.f2921a.getDecoratedRight(view) + ((C0984j) view.getLayoutParams()).rightMargin;
    }

    /* renamed from: d */
    public int mo6974d(View view) {
        return this.f2921a.getDecoratedLeft(view) - ((C0984j) view.getLayoutParams()).leftMargin;
    }

    /* renamed from: e */
    public int mo6976e(View view) {
        this.f2921a.getTransformedBoundingBox(view, true, this.f2923c);
        return this.f2923c.right;
    }

    /* renamed from: f */
    public int mo6978f(View view) {
        this.f2921a.getTransformedBoundingBox(view, true, this.f2923c);
        return this.f2923c.left;
    }

    /* renamed from: g */
    public int mo6979g() {
        return (this.f2921a.getWidth() - this.f2921a.getPaddingLeft()) - this.f2921a.getPaddingRight();
    }

    /* renamed from: c */
    public int mo6971c() {
        return this.f2921a.getPaddingRight();
    }

    /* renamed from: d */
    public int mo6973d() {
        return this.f2921a.getWidthMode();
    }

    /* renamed from: e */
    public int mo6975e() {
        return this.f2921a.getHeightMode();
    }
}
