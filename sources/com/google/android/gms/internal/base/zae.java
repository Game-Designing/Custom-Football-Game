package com.google.android.gms.internal.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;

public final class zae extends Drawable implements Callback {

    /* renamed from: a */
    private int f29903a;

    /* renamed from: b */
    private long f29904b;

    /* renamed from: c */
    private int f29905c;

    /* renamed from: d */
    private int f29906d;

    /* renamed from: e */
    private int f29907e;

    /* renamed from: f */
    private int f29908f;

    /* renamed from: g */
    private boolean f29909g;

    /* renamed from: h */
    private boolean f29910h;

    /* renamed from: i */
    private C9884a f29911i;

    /* renamed from: j */
    private Drawable f29912j;

    /* renamed from: k */
    private Drawable f29913k;

    /* renamed from: l */
    private boolean f29914l;

    /* renamed from: m */
    private boolean f29915m;

    /* renamed from: n */
    private boolean f29916n;

    /* renamed from: o */
    private int f29917o;

    public final void invalidateDrawable(Drawable drawable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        C9884a aVar = this.f29911i;
        return changingConfigurations | aVar.f29897a | aVar.f29898b;
    }

    public final void setAlpha(int i) {
        if (this.f29908f == this.f29906d) {
            this.f29908f = i;
        }
        this.f29906d = i;
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f29912j.setColorFilter(colorFilter);
        this.f29913k.setColorFilter(colorFilter);
    }

    public final int getIntrinsicWidth() {
        return Math.max(this.f29912j.getIntrinsicWidth(), this.f29913k.getIntrinsicWidth());
    }

    public final int getIntrinsicHeight() {
        return Math.max(this.f29912j.getIntrinsicHeight(), this.f29913k.getIntrinsicHeight());
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        this.f29912j.setBounds(rect);
        this.f29913k.setBounds(rect);
    }

    public final ConstantState getConstantState() {
        if (!m31709a()) {
            return null;
        }
        this.f29911i.f29897a = getChangingConfigurations();
        return this.f29911i;
    }

    public final int getOpacity() {
        if (!this.f29916n) {
            this.f29917o = Drawable.resolveOpacity(this.f29912j.getOpacity(), this.f29913k.getOpacity());
            this.f29916n = true;
        }
        return this.f29917o;
    }

    /* renamed from: a */
    private final boolean m31709a() {
        if (!this.f29914l) {
            this.f29915m = (this.f29912j.getConstantState() == null || this.f29913k.getConstantState() == null) ? false : true;
            this.f29914l = true;
        }
        return this.f29915m;
    }

    public final Drawable mutate() {
        if (!this.f29910h && super.mutate() == this) {
            if (m31709a()) {
                this.f29912j.mutate();
                this.f29913k.mutate();
                this.f29910h = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return this;
    }

    public final void draw(Canvas canvas) {
        int i = this.f29903a;
        boolean z = true;
        if (i == 1) {
            this.f29904b = SystemClock.uptimeMillis();
            this.f29903a = 2;
            z = false;
        } else if (i == 2 && this.f29904b >= 0) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f29904b)) / ((float) this.f29907e);
            if (uptimeMillis < 1.0f) {
                z = false;
            }
            if (z) {
                this.f29903a = 0;
            }
            this.f29908f = (int) ((((float) this.f29905c) * Math.min(uptimeMillis, 1.0f)) + 0.0f);
        }
        int i2 = this.f29908f;
        boolean z2 = this.f29909g;
        Drawable drawable = this.f29912j;
        Drawable drawable2 = this.f29913k;
        if (z) {
            if (!z2 || i2 == 0) {
                drawable.draw(canvas);
            }
            int i3 = this.f29906d;
            if (i2 == i3) {
                drawable2.setAlpha(i3);
                drawable2.draw(canvas);
            }
            return;
        }
        if (z2) {
            drawable.setAlpha(this.f29906d - i2);
        }
        drawable.draw(canvas);
        if (z2) {
            drawable.setAlpha(this.f29906d);
        }
        if (i2 > 0) {
            drawable2.setAlpha(i2);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.f29906d);
        }
        invalidateSelf();
    }
}
