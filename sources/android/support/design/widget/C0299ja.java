package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* renamed from: android.support.design.widget.ja */
/* compiled from: VisibilityAwareImageButton */
class C0299ja extends ImageButton {

    /* renamed from: a */
    private int f1105a;

    public C0299ja(Context context) {
        this(context, null);
    }

    public C0299ja(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public C0299ja(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f1105a = getVisibility();
    }

    public void setVisibility(int visibility) {
        mo4666a(visibility, true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo4666a(int visibility, boolean fromUser) {
        super.setVisibility(visibility);
        if (fromUser) {
            this.f1105a = visibility;
        }
    }

    /* access modifiers changed from: 0000 */
    public final int getUserSetVisibility() {
        return this.f1105a;
    }
}
