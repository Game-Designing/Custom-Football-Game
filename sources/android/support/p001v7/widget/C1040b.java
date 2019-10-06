package android.support.p001v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v7.widget.b */
/* compiled from: ActionBarBackgroundDrawable */
class C1040b extends Drawable {

    /* renamed from: a */
    final ActionBarContainer f3465a;

    public C1040b(ActionBarContainer container) {
        this.f3465a = container;
    }

    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f3465a;
        if (actionBarContainer.f2819h) {
            Drawable drawable = actionBarContainer.f2818g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f2816e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f3465a;
        Drawable drawable3 = actionBarContainer2.f2817f;
        if (drawable3 != null && actionBarContainer2.f2820i) {
            drawable3.draw(canvas);
        }
    }

    public void setAlpha(int alpha) {
    }

    public void setColorFilter(ColorFilter cf) {
    }

    public int getOpacity() {
        return 0;
    }
}
