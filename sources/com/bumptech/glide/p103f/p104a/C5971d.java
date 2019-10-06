package com.bumptech.glide.p103f.p104a;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.p103f.p105b.C5983b;
import com.bumptech.glide.p103f.p105b.C5983b.C5984a;

/* renamed from: com.bumptech.glide.f.a.d */
/* compiled from: ImageViewTarget */
public abstract class C5971d<Z> extends C5977j<ImageView, Z> implements C5984a {

    /* renamed from: h */
    private Animatable f10529h;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo18696a(Z z);

    public C5971d(ImageView view) {
        super(view);
    }

    /* renamed from: a */
    public void mo18698a(Drawable drawable) {
        ((ImageView) this.f10538c).setImageDrawable(drawable);
    }

    public void onLoadStarted(Drawable placeholder) {
        super.onLoadStarted(placeholder);
        m11056c(null);
        mo18698a(placeholder);
    }

    public void onLoadFailed(Drawable errorDrawable) {
        super.onLoadFailed(errorDrawable);
        m11056c(null);
        mo18698a(errorDrawable);
    }

    public void onLoadCleared(Drawable placeholder) {
        super.onLoadCleared(placeholder);
        Animatable animatable = this.f10529h;
        if (animatable != null) {
            animatable.stop();
        }
        m11056c(null);
        mo18698a(placeholder);
    }

    public void onResourceReady(Z resource, C5983b<? super Z> transition) {
        if (transition == null || !transition.mo18710a(resource, this)) {
            m11056c(resource);
        } else {
            m11055b(resource);
        }
    }

    public void onStart() {
        Animatable animatable = this.f10529h;
        if (animatable != null) {
            animatable.start();
        }
    }

    public void onStop() {
        Animatable animatable = this.f10529h;
        if (animatable != null) {
            animatable.stop();
        }
    }

    /* renamed from: c */
    private void m11056c(Z resource) {
        mo18696a(resource);
        m11055b(resource);
    }

    /* renamed from: b */
    private void m11055b(Z resource) {
        if (resource instanceof Animatable) {
            this.f10529h = (Animatable) resource;
            this.f10529h.start();
            return;
        }
        this.f10529h = null;
    }
}
