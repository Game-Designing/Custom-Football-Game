package p002b.p003c.p053g.p054a.p055a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: b.c.g.a.a.a */
/* compiled from: DrawableCompat */
public final class C1200a {

    /* renamed from: a */
    private static Method f3924a;

    /* renamed from: b */
    private static boolean f3925b;

    /* renamed from: c */
    private static Method f3926c;

    /* renamed from: d */
    private static boolean f3927d;

    @Deprecated
    /* renamed from: g */
    public static void m5739g(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    /* renamed from: a */
    public static void m5730a(Drawable drawable, boolean mirrored) {
        if (VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(mirrored);
        }
    }

    /* renamed from: f */
    public static boolean m5738f(Drawable drawable) {
        if (VERSION.SDK_INT >= 19) {
            return drawable.isAutoMirrored();
        }
        return false;
    }

    /* renamed from: a */
    public static void m5724a(Drawable drawable, float x, float y) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setHotspot(x, y);
        }
    }

    /* renamed from: a */
    public static void m5725a(Drawable drawable, int left, int top, int right, int bottom) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(left, top, right, bottom);
        }
    }

    /* renamed from: b */
    public static void m5734b(Drawable drawable, int tint) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTint(tint);
        } else if (drawable instanceof C1201b) {
            ((C1201b) drawable).setTint(tint);
        }
    }

    /* renamed from: a */
    public static void m5726a(Drawable drawable, ColorStateList tint) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTintList(tint);
        } else if (drawable instanceof C1201b) {
            ((C1201b) drawable).setTintList(tint);
        }
    }

    /* renamed from: a */
    public static void m5729a(Drawable drawable, Mode tintMode) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTintMode(tintMode);
        } else if (drawable instanceof C1201b) {
            ((C1201b) drawable).setTintMode(tintMode);
        }
    }

    /* renamed from: c */
    public static int m5735c(Drawable drawable) {
        if (VERSION.SDK_INT >= 19) {
            return drawable.getAlpha();
        }
        return 0;
    }

    /* renamed from: a */
    public static void m5727a(Drawable drawable, Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    /* renamed from: a */
    public static boolean m5731a(Drawable drawable) {
        if (VERSION.SDK_INT >= 21) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    /* renamed from: d */
    public static ColorFilter m5736d(Drawable drawable) {
        if (VERSION.SDK_INT >= 21) {
            return drawable.getColorFilter();
        }
        return null;
    }

    /* renamed from: b */
    public static void m5733b(Drawable drawable) {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            drawable.clearColorFilter();
        } else if (i >= 21) {
            drawable.clearColorFilter();
            if (drawable instanceof InsetDrawable) {
                m5733b(((InsetDrawable) drawable).getDrawable());
            } else if (drawable instanceof C1202c) {
                m5733b(((C1202c) drawable).mo8934a());
            } else if (drawable instanceof DrawableContainer) {
                DrawableContainerState state = (DrawableContainerState) ((DrawableContainer) drawable).getConstantState();
                if (state != null) {
                    int count = state.getChildCount();
                    for (int i2 = 0; i2 < count; i2++) {
                        Drawable child = state.getChild(i2);
                        if (child != null) {
                            m5733b(child);
                        }
                    }
                }
            }
        } else {
            drawable.clearColorFilter();
        }
    }

    /* renamed from: a */
    public static void m5728a(Drawable drawable, Resources res, XmlPullParser parser, AttributeSet attrs, Theme theme) throws XmlPullParserException, IOException {
        if (VERSION.SDK_INT >= 21) {
            drawable.inflate(res, parser, attrs, theme);
        } else {
            drawable.inflate(res, parser, attrs);
        }
    }

    /* renamed from: i */
    public static Drawable m5741i(Drawable drawable) {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            return drawable;
        }
        if (i >= 21) {
            if (!(drawable instanceof C1201b)) {
                return new C1208f(drawable);
            }
            return drawable;
        } else if (i >= 19) {
            if (!(drawable instanceof C1201b)) {
                return new C1206e(drawable);
            }
            return drawable;
        } else if (!(drawable instanceof C1201b)) {
            return new C1203d(drawable);
        } else {
            return drawable;
        }
    }

    /* renamed from: h */
    public static <T extends Drawable> T m5740h(Drawable drawable) {
        if (drawable instanceof C1202c) {
            return ((C1202c) drawable).mo8934a();
        }
        return drawable;
    }

    /* renamed from: a */
    public static boolean m5732a(Drawable drawable, int layoutDirection) {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            return drawable.setLayoutDirection(layoutDirection);
        }
        if (i < 17) {
            return false;
        }
        String str = "DrawableCompat";
        if (!f3925b) {
            try {
                f3924a = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                f3924a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i(str, "Failed to retrieve setLayoutDirection(int) method", e);
            }
            f3925b = true;
        }
        Method method = f3924a;
        if (method != null) {
            try {
                method.invoke(drawable, new Object[]{Integer.valueOf(layoutDirection)});
                return true;
            } catch (Exception e2) {
                Log.i(str, "Failed to invoke setLayoutDirection(int) via reflection", e2);
                f3924a = null;
            }
        }
        return false;
    }

    /* renamed from: e */
    public static int m5737e(Drawable drawable) {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            return drawable.getLayoutDirection();
        }
        if (i < 17) {
            return 0;
        }
        String str = "DrawableCompat";
        if (!f3927d) {
            try {
                f3926c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f3926c.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i(str, "Failed to retrieve getLayoutDirection() method", e);
            }
            f3927d = true;
        }
        Method method = f3926c;
        if (method != null) {
            try {
                return ((Integer) method.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e2) {
                Log.i(str, "Failed to invoke getLayoutDirection() via reflection", e2);
                f3926c = null;
            }
        }
        return 0;
    }
}
