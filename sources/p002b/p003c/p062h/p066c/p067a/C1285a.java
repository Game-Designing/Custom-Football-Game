package p002b.p003c.p062h.p066c.p067a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import p002b.p003c.p053g.p054a.p055a.C1200a;

/* renamed from: b.c.h.c.a.a */
/* compiled from: DrawableWrapper */
public class C1285a extends Drawable implements Callback {

    /* renamed from: a */
    private Drawable f4094a;

    public C1285a(Drawable drawable) {
        mo9185a(drawable);
    }

    public void draw(Canvas canvas) {
        this.f4094a.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        this.f4094a.setBounds(bounds);
    }

    public void setChangingConfigurations(int configs) {
        this.f4094a.setChangingConfigurations(configs);
    }

    public int getChangingConfigurations() {
        return this.f4094a.getChangingConfigurations();
    }

    public void setDither(boolean dither) {
        this.f4094a.setDither(dither);
    }

    public void setFilterBitmap(boolean filter) {
        this.f4094a.setFilterBitmap(filter);
    }

    public void setAlpha(int alpha) {
        this.f4094a.setAlpha(alpha);
    }

    public void setColorFilter(ColorFilter cf) {
        this.f4094a.setColorFilter(cf);
    }

    public boolean isStateful() {
        return this.f4094a.isStateful();
    }

    public boolean setState(int[] stateSet) {
        return this.f4094a.setState(stateSet);
    }

    public int[] getState() {
        return this.f4094a.getState();
    }

    public void jumpToCurrentState() {
        C1200a.m5739g(this.f4094a);
    }

    public Drawable getCurrent() {
        return this.f4094a.getCurrent();
    }

    public boolean setVisible(boolean visible, boolean restart) {
        return super.setVisible(visible, restart) || this.f4094a.setVisible(visible, restart);
    }

    public int getOpacity() {
        return this.f4094a.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f4094a.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f4094a.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f4094a.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f4094a.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f4094a.getMinimumHeight();
    }

    public boolean getPadding(Rect padding) {
        return this.f4094a.getPadding(padding);
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
        return this.f4094a.setLevel(level);
    }

    public void setAutoMirrored(boolean mirrored) {
        C1200a.m5730a(this.f4094a, mirrored);
    }

    public boolean isAutoMirrored() {
        return C1200a.m5738f(this.f4094a);
    }

    public void setTint(int tint) {
        C1200a.m5734b(this.f4094a, tint);
    }

    public void setTintList(ColorStateList tint) {
        C1200a.m5726a(this.f4094a, tint);
    }

    public void setTintMode(Mode tintMode) {
        C1200a.m5729a(this.f4094a, tintMode);
    }

    public void setHotspot(float x, float y) {
        C1200a.m5724a(this.f4094a, x, y);
    }

    public void setHotspotBounds(int left, int top, int right, int bottom) {
        C1200a.m5725a(this.f4094a, left, top, right, bottom);
    }

    /* renamed from: a */
    public Drawable mo9184a() {
        return this.f4094a;
    }

    /* renamed from: a */
    public void mo9185a(Drawable drawable) {
        Drawable drawable2 = this.f4094a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f4094a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }
}
