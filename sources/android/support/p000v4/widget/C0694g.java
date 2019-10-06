package android.support.p000v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.widget.g */
/* compiled from: CompoundButtonCompat */
public final class C0694g {

    /* renamed from: a */
    private static final C0697c f2051a;

    /* renamed from: android.support.v4.widget.g$a */
    /* compiled from: CompoundButtonCompat */
    static class C0695a extends C0697c {
        C0695a() {
        }

        /* renamed from: a */
        public void mo5977a(CompoundButton button, ColorStateList tint) {
            button.setButtonTintList(tint);
        }

        /* renamed from: a */
        public void mo5978a(CompoundButton button, Mode tintMode) {
            button.setButtonTintMode(tintMode);
        }
    }

    /* renamed from: android.support.v4.widget.g$b */
    /* compiled from: CompoundButtonCompat */
    static class C0696b extends C0695a {
        C0696b() {
        }

        /* renamed from: a */
        public Drawable mo5979a(CompoundButton button) {
            return button.getButtonDrawable();
        }
    }

    /* renamed from: android.support.v4.widget.g$c */
    /* compiled from: CompoundButtonCompat */
    static class C0697c {

        /* renamed from: a */
        private static Field f2052a;

        /* renamed from: b */
        private static boolean f2053b;

        C0697c() {
        }

        /* renamed from: a */
        public void mo5977a(CompoundButton button, ColorStateList tint) {
            if (button instanceof C0673D) {
                ((C0673D) button).setSupportButtonTintList(tint);
            }
        }

        /* renamed from: a */
        public void mo5978a(CompoundButton button, Mode tintMode) {
            if (button instanceof C0673D) {
                ((C0673D) button).setSupportButtonTintMode(tintMode);
            }
        }

        /* renamed from: a */
        public Drawable mo5979a(CompoundButton button) {
            String str = "CompoundButtonCompat";
            if (!f2053b) {
                try {
                    f2052a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                    f2052a.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    Log.i(str, "Failed to retrieve mButtonDrawable field", e);
                }
                f2053b = true;
            }
            Field field = f2052a;
            if (field != null) {
                try {
                    return (Drawable) field.get(button);
                } catch (IllegalAccessException e2) {
                    Log.i(str, "Failed to get button drawable via reflection", e2);
                    f2052a = null;
                }
            }
            return null;
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f2051a = new C0696b();
        } else if (i >= 21) {
            f2051a = new C0695a();
        } else {
            f2051a = new C0697c();
        }
    }

    /* renamed from: a */
    public static void m3311a(CompoundButton button, ColorStateList tint) {
        f2051a.mo5977a(button, tint);
    }

    /* renamed from: a */
    public static void m3312a(CompoundButton button, Mode tintMode) {
        f2051a.mo5978a(button, tintMode);
    }

    /* renamed from: a */
    public static Drawable m3310a(CompoundButton button) {
        return f2051a.mo5979a(button);
    }
}
