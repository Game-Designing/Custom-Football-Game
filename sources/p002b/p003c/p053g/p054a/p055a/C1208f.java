package p002b.p003c.p053g.p054a.p055a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: b.c.g.a.a.f */
/* compiled from: WrappedDrawableApi21 */
class C1208f extends C1206e {

    /* renamed from: h */
    private static Method f3939h;

    /* renamed from: b.c.g.a.a.f$a */
    /* compiled from: WrappedDrawableApi21 */
    private static class C1209a extends C1204a {
        C1209a(C1204a orig, Resources res) {
            super(orig, res);
        }

        public Drawable newDrawable(Resources res) {
            return new C1208f(this, res);
        }
    }

    C1208f(Drawable drawable) {
        super(drawable);
        m5752d();
    }

    C1208f(C1204a state, Resources resources) {
        super(state, resources);
        m5752d();
    }

    public void setHotspot(float x, float y) {
        this.f3934g.setHotspot(x, y);
    }

    public void setHotspotBounds(int left, int top, int right, int bottom) {
        this.f3934g.setHotspotBounds(left, top, right, bottom);
    }

    public void getOutline(Outline outline) {
        this.f3934g.getOutline(outline);
    }

    public Rect getDirtyBounds() {
        return this.f3934g.getDirtyBounds();
    }

    public void setTintList(ColorStateList tint) {
        if (mo8936b()) {
            super.setTintList(tint);
        } else {
            this.f3934g.setTintList(tint);
        }
    }

    public void setTint(int tintColor) {
        if (mo8936b()) {
            super.setTint(tintColor);
        } else {
            this.f3934g.setTint(tintColor);
        }
    }

    public void setTintMode(Mode tintMode) {
        if (mo8936b()) {
            super.setTintMode(tintMode);
        } else {
            this.f3934g.setTintMode(tintMode);
        }
    }

    public boolean setState(int[] stateSet) {
        if (!super.setState(stateSet)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo8936b() {
        boolean z = false;
        if (VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f3934g;
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable)) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C1204a mo8937c() {
        return new C1209a(this.f3932e, null);
    }

    /* renamed from: d */
    private void m5752d() {
        if (f3939h == null) {
            try {
                f3939h = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception ex) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", ex);
            }
        }
    }
}
