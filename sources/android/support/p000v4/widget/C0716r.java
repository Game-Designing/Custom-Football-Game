package android.support.p000v4.widget;

import android.os.Build.VERSION;
import android.support.p000v4.view.C0623f;
import android.support.p000v4.view.C0646w;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.widget.r */
/* compiled from: PopupWindowCompat */
public final class C0716r {

    /* renamed from: a */
    static final C0720d f2066a;

    /* renamed from: android.support.v4.widget.r$a */
    /* compiled from: PopupWindowCompat */
    static class C0717a extends C0720d {
        C0717a() {
        }

        /* renamed from: a */
        public void mo6024a(PopupWindow popup, View anchor, int xoff, int yoff, int gravity) {
            popup.showAsDropDown(anchor, xoff, yoff, gravity);
        }
    }

    /* renamed from: android.support.v4.widget.r$b */
    /* compiled from: PopupWindowCompat */
    static class C0718b extends C0717a {

        /* renamed from: c */
        private static Field f2067c;

        C0718b() {
        }

        static {
            try {
                f2067c = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f2067c.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
            }
        }

        /* renamed from: a */
        public void mo6025a(PopupWindow popupWindow, boolean overlapAnchor) {
            Field field = f2067c;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(overlapAnchor));
                } catch (IllegalAccessException e) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
                }
            }
        }
    }

    /* renamed from: android.support.v4.widget.r$c */
    /* compiled from: PopupWindowCompat */
    static class C0719c extends C0718b {
        C0719c() {
        }

        /* renamed from: a */
        public void mo6025a(PopupWindow popupWindow, boolean overlapAnchor) {
            popupWindow.setOverlapAnchor(overlapAnchor);
        }

        /* renamed from: a */
        public void mo6026a(PopupWindow popupWindow, int layoutType) {
            popupWindow.setWindowLayoutType(layoutType);
        }
    }

    /* renamed from: android.support.v4.widget.r$d */
    /* compiled from: PopupWindowCompat */
    static class C0720d {

        /* renamed from: a */
        private static Method f2068a;

        /* renamed from: b */
        private static boolean f2069b;

        C0720d() {
        }

        /* renamed from: a */
        public void mo6024a(PopupWindow popup, View anchor, int xoff, int yoff, int gravity) {
            if ((C0623f.m2881a(gravity, C0646w.m2974h(anchor)) & 7) == 5) {
                xoff -= popup.getWidth() - anchor.getWidth();
            }
            popup.showAsDropDown(anchor, xoff, yoff);
        }

        /* renamed from: a */
        public void mo6025a(PopupWindow popupWindow, boolean overlapAnchor) {
        }

        /* renamed from: a */
        public void mo6026a(PopupWindow popupWindow, int layoutType) {
            if (!f2069b) {
                try {
                    f2068a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                    f2068a.setAccessible(true);
                } catch (Exception e) {
                }
                f2069b = true;
            }
            Method method = f2068a;
            if (method != null) {
                try {
                    method.invoke(popupWindow, new Object[]{Integer.valueOf(layoutType)});
                } catch (Exception e2) {
                }
            }
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f2066a = new C0719c();
        } else if (i >= 21) {
            f2066a = new C0718b();
        } else if (i >= 19) {
            f2066a = new C0717a();
        } else {
            f2066a = new C0720d();
        }
    }

    /* renamed from: a */
    public static void m3355a(PopupWindow popup, View anchor, int xoff, int yoff, int gravity) {
        f2066a.mo6024a(popup, anchor, xoff, yoff, gravity);
    }

    /* renamed from: a */
    public static void m3356a(PopupWindow popupWindow, boolean overlapAnchor) {
        f2066a.mo6025a(popupWindow, overlapAnchor);
    }

    /* renamed from: a */
    public static void m3354a(PopupWindow popupWindow, int layoutType) {
        f2066a.mo6026a(popupWindow, layoutType);
    }
}
