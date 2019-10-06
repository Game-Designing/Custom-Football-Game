package android.support.p001v7.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

/* renamed from: android.support.v7.widget.J */
/* compiled from: CardView */
class C0947J implements C0965P {

    /* renamed from: a */
    private Drawable f3018a;

    /* renamed from: b */
    final /* synthetic */ CardView f3019b;

    C0947J(CardView this$0) {
        this.f3019b = this$0;
    }

    /* renamed from: a */
    public void mo7339a(Drawable drawable) {
        this.f3018a = drawable;
        this.f3019b.setBackgroundDrawable(drawable);
    }

    /* renamed from: a */
    public boolean mo7340a() {
        return this.f3019b.getUseCompatPadding();
    }

    /* renamed from: c */
    public boolean mo7342c() {
        return this.f3019b.getPreventCornerOverlap();
    }

    /* renamed from: a */
    public void mo7338a(int left, int top, int right, int bottom) {
        this.f3019b.f2937h.set(left, top, right, bottom);
        CardView cardView = this.f3019b;
        Rect rect = cardView.f2936g;
        C0947J.super.setPadding(rect.left + left, rect.top + top, rect.right + right, rect.bottom + bottom);
    }

    /* renamed from: a */
    public void mo7337a(int width, int height) {
        CardView cardView = this.f3019b;
        if (width > cardView.f2934e) {
            C0947J.super.setMinimumWidth(width);
        }
        CardView cardView2 = this.f3019b;
        if (height > cardView2.f2935f) {
            C0947J.super.setMinimumHeight(height);
        }
    }

    /* renamed from: b */
    public Drawable mo7341b() {
        return this.f3018a;
    }

    /* renamed from: d */
    public View mo7343d() {
        return this.f3019b;
    }
}
