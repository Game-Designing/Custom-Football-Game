package p002b.p003c.p053g.p054a.p055a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

/* renamed from: b.c.g.a.a.d */
/* compiled from: WrappedDrawableApi14 */
class C1203d extends Drawable implements Callback, C1202c, C1201b {

    /* renamed from: a */
    static final Mode f3928a = Mode.SRC_IN;

    /* renamed from: b */
    private int f3929b;

    /* renamed from: c */
    private Mode f3930c;

    /* renamed from: d */
    private boolean f3931d;

    /* renamed from: e */
    C1204a f3932e;

    /* renamed from: f */
    private boolean f3933f;

    /* renamed from: g */
    Drawable f3934g;

    /* renamed from: b.c.g.a.a.d$a */
    /* compiled from: WrappedDrawableApi14 */
    protected static abstract class C1204a extends ConstantState {

        /* renamed from: a */
        int f3935a;

        /* renamed from: b */
        ConstantState f3936b;

        /* renamed from: c */
        ColorStateList f3937c = null;

        /* renamed from: d */
        Mode f3938d = C1203d.f3928a;

        public abstract Drawable newDrawable(Resources resources);

        C1204a(C1204a orig, Resources res) {
            if (orig != null) {
                this.f3935a = orig.f3935a;
                this.f3936b = orig.f3936b;
                this.f3937c = orig.f3937c;
                this.f3938d = orig.f3938d;
            }
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public int getChangingConfigurations() {
            int i = this.f3935a;
            ConstantState constantState = this.f3936b;
            return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo8965a() {
            return this.f3936b != null;
        }
    }

    /* renamed from: b.c.g.a.a.d$b */
    /* compiled from: WrappedDrawableApi14 */
    private static class C1205b extends C1204a {
        C1205b(C1204a orig, Resources res) {
            super(orig, res);
        }

        public Drawable newDrawable(Resources res) {
            return new C1203d(this, res);
        }
    }

    C1203d(C1204a state, Resources res) {
        this.f3932e = state;
        m5744a(res);
    }

    C1203d(Drawable dr) {
        this.f3932e = mo8937c();
        mo8935a(dr);
    }

    /* renamed from: a */
    private void m5744a(Resources res) {
        C1204a aVar = this.f3932e;
        if (aVar != null) {
            ConstantState constantState = aVar.f3936b;
            if (constantState != null) {
                mo8935a(constantState.newDrawable(res));
            }
        }
    }

    public void jumpToCurrentState() {
        this.f3934g.jumpToCurrentState();
    }

    public void draw(Canvas canvas) {
        this.f3934g.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        Drawable drawable = this.f3934g;
        if (drawable != null) {
            drawable.setBounds(bounds);
        }
    }

    public void setChangingConfigurations(int configs) {
        this.f3934g.setChangingConfigurations(configs);
    }

    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        C1204a aVar = this.f3932e;
        return changingConfigurations | (aVar != null ? aVar.getChangingConfigurations() : 0) | this.f3934g.getChangingConfigurations();
    }

    public void setDither(boolean dither) {
        this.f3934g.setDither(dither);
    }

    public void setFilterBitmap(boolean filter) {
        this.f3934g.setFilterBitmap(filter);
    }

    public void setAlpha(int alpha) {
        this.f3934g.setAlpha(alpha);
    }

    public void setColorFilter(ColorFilter cf) {
        this.f3934g.setColorFilter(cf);
    }

    public boolean isStateful() {
        ColorStateList tintList;
        if (mo8936b()) {
            C1204a aVar = this.f3932e;
            if (aVar != null) {
                tintList = aVar.f3937c;
                return (tintList == null && tintList.isStateful()) || this.f3934g.isStateful();
            }
        }
        tintList = null;
        if (tintList == null) {
        }
    }

    public boolean setState(int[] stateSet) {
        return m5745a(stateSet) || this.f3934g.setState(stateSet);
    }

    public int[] getState() {
        return this.f3934g.getState();
    }

    public Drawable getCurrent() {
        return this.f3934g.getCurrent();
    }

    public boolean setVisible(boolean visible, boolean restart) {
        return super.setVisible(visible, restart) || this.f3934g.setVisible(visible, restart);
    }

    public int getOpacity() {
        return this.f3934g.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f3934g.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f3934g.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f3934g.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f3934g.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f3934g.getMinimumHeight();
    }

    public boolean getPadding(Rect padding) {
        return this.f3934g.getPadding(padding);
    }

    public ConstantState getConstantState() {
        C1204a aVar = this.f3932e;
        if (aVar == null || !aVar.mo8965a()) {
            return null;
        }
        this.f3932e.f3935a = getChangingConfigurations();
        return this.f3932e;
    }

    public Drawable mutate() {
        if (!this.f3933f && super.mutate() == this) {
            this.f3932e = mo8937c();
            Drawable drawable = this.f3934g;
            if (drawable != null) {
                drawable.mutate();
            }
            C1204a aVar = this.f3932e;
            if (aVar != null) {
                Drawable drawable2 = this.f3934g;
                aVar.f3936b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f3933f = true;
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C1204a mo8937c() {
        return new C1205b(this.f3932e, null);
    }

    public void invalidateDrawable(Drawable who) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        scheduleSelf(what, when);
    }

    public void unscheduleDrawable(Drawable who, Runnable what) {
        unscheduleSelf(what);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int level) {
        return this.f3934g.setLevel(level);
    }

    public void setTint(int tint) {
        setTintList(ColorStateList.valueOf(tint));
    }

    public void setTintList(ColorStateList tint) {
        this.f3932e.f3937c = tint;
        m5745a(getState());
    }

    public void setTintMode(Mode tintMode) {
        this.f3932e.f3938d = tintMode;
        m5745a(getState());
    }

    /* renamed from: a */
    private boolean m5745a(int[] state) {
        if (!mo8936b()) {
            return false;
        }
        C1204a aVar = this.f3932e;
        ColorStateList tintList = aVar.f3937c;
        Mode tintMode = aVar.f3938d;
        if (tintList == null || tintMode == null) {
            this.f3931d = false;
            clearColorFilter();
        } else {
            int color = tintList.getColorForState(state, tintList.getDefaultColor());
            if (!(this.f3931d && color == this.f3929b && tintMode == this.f3930c)) {
                setColorFilter(color, tintMode);
                this.f3929b = color;
                this.f3930c = tintMode;
                this.f3931d = true;
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final Drawable mo8934a() {
        return this.f3934g;
    }

    /* renamed from: a */
    public final void mo8935a(Drawable dr) {
        Drawable drawable = this.f3934g;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f3934g = dr;
        if (dr != null) {
            dr.setCallback(this);
            setVisible(dr.isVisible(), true);
            setState(dr.getState());
            setLevel(dr.getLevel());
            setBounds(dr.getBounds());
            C1204a aVar = this.f3932e;
            if (aVar != null) {
                aVar.f3936b = dr.getConstantState();
            }
        }
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo8936b() {
        return true;
    }
}
