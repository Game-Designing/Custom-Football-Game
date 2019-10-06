package com.bumptech.glide.load.p113c.p116c;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.engine.C6342z;
import com.bumptech.glide.load.p113c.p118e.C6208c;
import com.bumptech.glide.p107h.C6024i;

/* renamed from: com.bumptech.glide.load.c.c.b */
/* compiled from: DrawableResource */
public abstract class C6198b<T extends Drawable> implements C6236E<T>, C6342z {

    /* renamed from: a */
    protected final T f10930a;

    public C6198b(T drawable) {
        C6024i.m11264a(drawable);
        this.f10930a = (Drawable) drawable;
    }

    public final T get() {
        ConstantState state = this.f10930a.getConstantState();
        if (state == null) {
            return this.f10930a;
        }
        return state.newDrawable();
    }

    public void initialize() {
        T t = this.f10930a;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof C6208c) {
            ((C6208c) t).mo19047c().prepareToDraw();
        }
    }
}
