package com.bumptech.glide.load.p113c.p116c;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.C6236E;

/* renamed from: com.bumptech.glide.load.c.c.c */
/* compiled from: NonOwnedDrawableResource */
final class C6199c extends C6198b<Drawable> {
    /* renamed from: a */
    static C6236E<Drawable> m11776a(Drawable drawable) {
        if (drawable != null) {
            return new C6199c(drawable);
        }
        return null;
    }

    private C6199c(Drawable drawable) {
        super(drawable);
    }

    /* renamed from: c */
    public Class<Drawable> mo18970c() {
        return this.f10930a.getClass();
    }

    /* renamed from: a */
    public int mo18968a() {
        return Math.max(1, this.f10930a.getIntrinsicWidth() * this.f10930a.getIntrinsicHeight() * 4);
    }

    /* renamed from: b */
    public void mo18969b() {
    }
}
