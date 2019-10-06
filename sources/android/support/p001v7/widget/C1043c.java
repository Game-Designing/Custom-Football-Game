package android.support.p001v7.widget;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v7.widget.c */
/* compiled from: ActionBarBackgroundDrawableV21 */
class C1043c extends C1040b {
    public C1043c(ActionBarContainer container) {
        super(container);
    }

    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f3465a;
        if (actionBarContainer.f2819h) {
            Drawable drawable = actionBarContainer.f2818g;
            if (drawable != null) {
                drawable.getOutline(outline);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f2816e;
        if (drawable2 != null) {
            drawable2.getOutline(outline);
        }
    }
}
