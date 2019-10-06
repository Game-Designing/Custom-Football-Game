package android.support.p000v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p000v4.p037os.C0569a;
import android.widget.TextView;

/* renamed from: android.support.v4.widget.C */
/* compiled from: TextViewCompat */
public final class C0665C {

    /* renamed from: a */
    static final C0672g f1878a;

    /* renamed from: android.support.v4.widget.C$a */
    /* compiled from: TextViewCompat */
    static class C0666a extends C0672g {
        C0666a() {
        }
    }

    /* renamed from: android.support.v4.widget.C$b */
    /* compiled from: TextViewCompat */
    static class C0667b extends C0666a {
        C0667b() {
        }

        /* renamed from: a */
        public void mo5760a(TextView textView, Drawable start, Drawable top, Drawable end, Drawable bottom) {
            boolean z = true;
            if (textView.getLayoutDirection() != 1) {
                z = false;
            }
            boolean rtl = z;
            textView.setCompoundDrawables(rtl ? end : start, top, rtl ? start : end, bottom);
        }

        /* renamed from: a */
        public void mo5759a(TextView textView, int start, int top, int end, int bottom) {
            boolean z = true;
            if (textView.getLayoutDirection() != 1) {
                z = false;
            }
            boolean rtl = z;
            textView.setCompoundDrawablesWithIntrinsicBounds(rtl ? end : start, top, rtl ? start : end, bottom);
        }

        /* renamed from: a */
        public Drawable[] mo5761a(TextView textView) {
            boolean z = true;
            if (textView.getLayoutDirection() != 1) {
                z = false;
            }
            boolean rtl = z;
            Drawable[] compounds = textView.getCompoundDrawables();
            if (rtl) {
                Drawable start = compounds[2];
                Drawable end = compounds[0];
                compounds[0] = start;
                compounds[2] = end;
            }
            return compounds;
        }
    }

    /* renamed from: android.support.v4.widget.C$c */
    /* compiled from: TextViewCompat */
    static class C0668c extends C0667b {
        C0668c() {
        }

        /* renamed from: a */
        public void mo5760a(TextView textView, Drawable start, Drawable top, Drawable end, Drawable bottom) {
            textView.setCompoundDrawablesRelative(start, top, end, bottom);
        }

        /* renamed from: a */
        public void mo5759a(TextView textView, int start, int top, int end, int bottom) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom);
        }

        /* renamed from: a */
        public Drawable[] mo5761a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }
    }

    /* renamed from: android.support.v4.widget.C$d */
    /* compiled from: TextViewCompat */
    static class C0669d extends C0668c {
        C0669d() {
        }

        /* renamed from: a */
        public void mo5762a(TextView textView, int resId) {
            textView.setTextAppearance(resId);
        }
    }

    /* renamed from: android.support.v4.widget.C$e */
    /* compiled from: TextViewCompat */
    static class C0670e extends C0669d {
        C0670e() {
        }
    }

    /* renamed from: android.support.v4.widget.C$f */
    /* compiled from: TextViewCompat */
    static class C0671f extends C0670e {
        C0671f() {
        }
    }

    /* renamed from: android.support.v4.widget.C$g */
    /* compiled from: TextViewCompat */
    static class C0672g {
        C0672g() {
        }

        /* renamed from: a */
        public void mo5760a(TextView textView, Drawable start, Drawable top, Drawable end, Drawable bottom) {
            textView.setCompoundDrawables(start, top, end, bottom);
        }

        /* renamed from: a */
        public void mo5759a(TextView textView, int start, int top, int end, int bottom) {
            textView.setCompoundDrawablesWithIntrinsicBounds(start, top, end, bottom);
        }

        /* renamed from: a */
        public void mo5762a(TextView textView, int resId) {
            textView.setTextAppearance(textView.getContext(), resId);
        }

        /* renamed from: a */
        public Drawable[] mo5761a(TextView textView) {
            return textView.getCompoundDrawables();
        }
    }

    static {
        if (C0569a.m2750a()) {
            f1878a = new C0671f();
            return;
        }
        int i = VERSION.SDK_INT;
        if (i >= 26) {
            f1878a = new C0670e();
        } else if (i >= 23) {
            f1878a = new C0669d();
        } else if (i >= 18) {
            f1878a = new C0668c();
        } else if (i >= 17) {
            f1878a = new C0667b();
        } else if (i >= 16) {
            f1878a = new C0666a();
        } else {
            f1878a = new C0672g();
        }
    }

    /* renamed from: a */
    public static void m3101a(TextView textView, Drawable start, Drawable top, Drawable end, Drawable bottom) {
        f1878a.mo5760a(textView, start, top, end, bottom);
    }

    /* renamed from: a */
    public static void m3100a(TextView textView, int start, int top, int end, int bottom) {
        f1878a.mo5759a(textView, start, top, end, bottom);
    }

    /* renamed from: a */
    public static void m3099a(TextView textView, int resId) {
        f1878a.mo5762a(textView, resId);
    }

    /* renamed from: a */
    public static Drawable[] m3102a(TextView textView) {
        return f1878a.mo5761a(textView);
    }
}
