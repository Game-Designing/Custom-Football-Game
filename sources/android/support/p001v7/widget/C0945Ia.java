package android.support.p001v7.widget;

import android.support.p001v7.widget.RecyclerView.C0981i;
import android.support.p001v7.widget.RecyclerView.C0984j;
import android.view.View;

/* renamed from: android.support.v7.widget.Ia */
/* compiled from: RecyclerView */
class C0945Ia implements C0935b {

    /* renamed from: a */
    final /* synthetic */ C0981i f3016a;

    C0945Ia(C0981i this$0) {
        this.f3016a = this$0;
    }

    /* renamed from: a */
    public View mo7242a(int index) {
        return this.f3016a.getChildAt(index);
    }

    /* renamed from: a */
    public int mo7240a() {
        return this.f3016a.getPaddingLeft();
    }

    /* renamed from: b */
    public int mo7243b() {
        return this.f3016a.getWidth() - this.f3016a.getPaddingRight();
    }

    /* renamed from: a */
    public int mo7241a(View view) {
        return this.f3016a.getDecoratedLeft(view) - ((C0984j) view.getLayoutParams()).leftMargin;
    }

    /* renamed from: b */
    public int mo7244b(View view) {
        return this.f3016a.getDecoratedRight(view) + ((C0984j) view.getLayoutParams()).rightMargin;
    }
}
