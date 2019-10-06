package android.support.p000v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;

/* renamed from: android.support.v4.widget.n */
/* compiled from: ImageViewCompat */
public class C0709n {

    /* renamed from: a */
    static final C0711b f2064a;

    /* renamed from: android.support.v4.widget.n$a */
    /* compiled from: ImageViewCompat */
    static class C0710a implements C0711b {
        C0710a() {
        }

        /* renamed from: b */
        public ColorStateList mo6021b(ImageView view) {
            if (view instanceof C0674E) {
                return ((C0674E) view).getSupportImageTintList();
            }
            return null;
        }

        /* renamed from: a */
        public void mo6019a(ImageView view, ColorStateList tintList) {
            if (view instanceof C0674E) {
                ((C0674E) view).setSupportImageTintList(tintList);
            }
        }

        /* renamed from: a */
        public void mo6020a(ImageView view, Mode mode) {
            if (view instanceof C0674E) {
                ((C0674E) view).setSupportImageTintMode(mode);
            }
        }

        /* renamed from: a */
        public Mode mo6018a(ImageView view) {
            if (view instanceof C0674E) {
                return ((C0674E) view).getSupportImageTintMode();
            }
            return null;
        }
    }

    /* renamed from: android.support.v4.widget.n$b */
    /* compiled from: ImageViewCompat */
    interface C0711b {
        /* renamed from: a */
        Mode mo6018a(ImageView imageView);

        /* renamed from: a */
        void mo6019a(ImageView imageView, ColorStateList colorStateList);

        /* renamed from: a */
        void mo6020a(ImageView imageView, Mode mode);

        /* renamed from: b */
        ColorStateList mo6021b(ImageView imageView);
    }

    /* renamed from: android.support.v4.widget.n$c */
    /* compiled from: ImageViewCompat */
    static class C0712c extends C0710a {
        C0712c() {
        }

        /* renamed from: b */
        public ColorStateList mo6021b(ImageView view) {
            return view.getImageTintList();
        }

        /* renamed from: a */
        public void mo6019a(ImageView view, ColorStateList tintList) {
            view.setImageTintList(tintList);
            if (VERSION.SDK_INT == 21) {
                Drawable imageViewDrawable = view.getDrawable();
                boolean hasTint = (view.getImageTintList() == null || view.getImageTintMode() == null) ? false : true;
                if (imageViewDrawable != null && hasTint) {
                    if (imageViewDrawable.isStateful()) {
                        imageViewDrawable.setState(view.getDrawableState());
                    }
                    view.setImageDrawable(imageViewDrawable);
                }
            }
        }

        /* renamed from: a */
        public void mo6020a(ImageView view, Mode mode) {
            view.setImageTintMode(mode);
            if (VERSION.SDK_INT == 21) {
                Drawable imageViewDrawable = view.getDrawable();
                boolean hasTint = (view.getImageTintList() == null || view.getImageTintMode() == null) ? false : true;
                if (imageViewDrawable != null && hasTint) {
                    if (imageViewDrawable.isStateful()) {
                        imageViewDrawable.setState(view.getDrawableState());
                    }
                    view.setImageDrawable(imageViewDrawable);
                }
            }
        }

        /* renamed from: a */
        public Mode mo6018a(ImageView view) {
            return view.getImageTintMode();
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f2064a = new C0712c();
        } else {
            f2064a = new C0710a();
        }
    }

    /* renamed from: a */
    public static ColorStateList m3333a(ImageView view) {
        return f2064a.mo6021b(view);
    }

    /* renamed from: a */
    public static void m3334a(ImageView view, ColorStateList tintList) {
        f2064a.mo6019a(view, tintList);
    }

    /* renamed from: b */
    public static Mode m3336b(ImageView view) {
        return f2064a.mo6018a(view);
    }

    /* renamed from: a */
    public static void m3335a(ImageView view, Mode mode) {
        f2064a.mo6020a(view, mode);
    }
}
