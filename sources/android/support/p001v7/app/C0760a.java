package android.support.p001v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.p001v7.appcompat.C0793R;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import p002b.p003c.p062h.p071g.C1300b;
import p002b.p003c.p062h.p071g.C1300b.C1301a;

/* renamed from: android.support.v7.app.a */
/* compiled from: ActionBar */
public abstract class C0760a {

    /* renamed from: android.support.v7.app.a$a */
    /* compiled from: ActionBar */
    public static class C0761a extends MarginLayoutParams {

        /* renamed from: a */
        public int f2312a;

        public C0761a(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.f2312a = 0;
            TypedArray a = c.obtainStyledAttributes(attrs, C0793R.styleable.ActionBarLayout);
            this.f2312a = a.getInt(C0793R.styleable.ActionBarLayout_android_layout_gravity, 0);
            a.recycle();
        }

        public C0761a(int width, int height) {
            super(width, height);
            this.f2312a = 0;
            this.f2312a = 8388627;
        }

        public C0761a(C0761a source) {
            super(source);
            this.f2312a = 0;
            this.f2312a = source.f2312a;
        }

        public C0761a(LayoutParams source) {
            super(source);
            this.f2312a = 0;
        }
    }

    /* renamed from: android.support.v7.app.a$b */
    /* compiled from: ActionBar */
    public interface C0762b {
        void onMenuVisibilityChanged(boolean z);
    }

    @Deprecated
    /* renamed from: android.support.v7.app.a$c */
    /* compiled from: ActionBar */
    public static abstract class C0763c {
        /* renamed from: a */
        public abstract CharSequence mo6201a();

        /* renamed from: b */
        public abstract View mo6202b();

        /* renamed from: c */
        public abstract Drawable mo6203c();

        /* renamed from: d */
        public abstract CharSequence mo6204d();

        /* renamed from: e */
        public abstract void mo6205e();
    }

    /* renamed from: a */
    public abstract void mo6146a(Drawable drawable);

    /* renamed from: a */
    public abstract void mo6147a(CharSequence charSequence);

    /* renamed from: a */
    public abstract boolean mo6148a(int i, KeyEvent keyEvent);

    /* renamed from: b */
    public abstract void mo6150b(CharSequence charSequence);

    /* renamed from: b */
    public abstract void mo6151b(boolean z);

    /* renamed from: c */
    public abstract void mo6152c(boolean z);

    /* renamed from: d */
    public abstract void mo6153d(boolean z);

    /* renamed from: e */
    public abstract void mo6154e(boolean z);

    /* renamed from: f */
    public abstract void mo6156f(boolean z);

    /* renamed from: f */
    public abstract boolean mo6157f();

    /* renamed from: g */
    public abstract int mo6158g();

    /* renamed from: g */
    public abstract void mo6159g(boolean z);

    /* renamed from: h */
    public abstract Context mo6160h();

    /* renamed from: a */
    public void mo6145a(Configuration config) {
    }

    /* renamed from: a */
    public C1300b mo6170a(C1301a callback) {
        return null;
    }

    /* renamed from: k */
    public boolean mo6163k() {
        return false;
    }

    /* renamed from: e */
    public boolean mo6155e() {
        return false;
    }

    /* renamed from: i */
    public boolean mo6161i() {
        return false;
    }

    /* renamed from: a */
    public boolean mo6149a(KeyEvent event) {
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo6162j() {
    }
}
