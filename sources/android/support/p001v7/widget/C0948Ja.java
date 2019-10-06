package android.support.p001v7.widget;

import android.support.p001v7.widget.RecyclerView.C0981i;
import android.support.p001v7.widget.RecyclerView.C0984j;
import android.view.View;

/* renamed from: android.support.v7.widget.Ja */
/* compiled from: RecyclerView */
class C0948Ja implements C0935b {

    /* renamed from: a */
    final /* synthetic */ C0981i f3020a;

    C0948Ja(C0981i this$0) {
        this.f3020a = this$0;
    }

    /* renamed from: a */
    public View mo7242a(int index) {
        return this.f3020a.getChildAt(index);
    }

    /* renamed from: a */
    public int mo7240a() {
        return this.f3020a.getPaddingTop();
    }

    /* renamed from: b */
    public int mo7243b() {
        return this.f3020a.getHeight() - this.f3020a.getPaddingBottom();
    }

    /* renamed from: a */
    public int mo7241a(View view) {
        return this.f3020a.getDecoratedTop(view) - ((C0984j) view.getLayoutParams()).topMargin;
    }

    /* renamed from: b */
    public int mo7244b(View view) {
        return this.f3020a.getDecoratedBottom(view) + ((C0984j) view.getLayoutParams()).bottomMargin;
    }
}
