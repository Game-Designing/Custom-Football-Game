package com.inmobi.ads;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Animatable2.AnimationCallback;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import com.inmobi.ads.C10598t.C10599a;
import java.io.File;
import java.io.IOException;

/* renamed from: com.inmobi.ads.l */
/* compiled from: AnimatedDrawable */
public final class C10581l implements C10598t {

    /* renamed from: a */
    AnimatedImageDrawable f32235a;

    /* renamed from: b */
    private C10599a f32236b;

    @SuppressLint({"NewApi"})
    public C10581l(String str) throws IOException {
        this.f32235a = (AnimatedImageDrawable) ImageDecoder.decodeDrawable(ImageDecoder.createSource(new File(str)));
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public final void mo34336a() {
        this.f32235a.registerAnimationCallback(new AnimationCallback() {
            public final void onAnimationStart(Drawable drawable) {
                super.onAnimationStart(drawable);
            }

            public final void onAnimationEnd(Drawable drawable) {
                super.onAnimationEnd(drawable);
                C10581l.this.f32235a.start();
            }
        });
        this.f32235a.start();
    }

    /* renamed from: a */
    public final void mo34339a(boolean z) {
    }

    /* renamed from: b */
    public final int mo34340b() {
        return this.f32235a.getIntrinsicWidth();
    }

    /* renamed from: c */
    public final int mo34341c() {
        return this.f32235a.getIntrinsicHeight();
    }

    /* renamed from: a */
    public final void mo34337a(Canvas canvas, float f, float f2) {
        canvas.translate(f, f2);
        this.f32235a.draw(canvas);
    }

    /* renamed from: d */
    public final boolean mo34342d() {
        return this.f32235a.isRunning();
    }

    /* renamed from: e */
    public final void mo34343e() {
    }

    /* renamed from: a */
    public final void mo34338a(C10599a aVar) {
        this.f32236b = aVar;
    }
}
