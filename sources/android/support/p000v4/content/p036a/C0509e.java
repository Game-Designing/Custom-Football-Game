package android.support.p000v4.content.p036a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.v4.content.a.e */
/* compiled from: TypedArrayUtils */
public class C0509e {
    /* renamed from: a */
    public static boolean m2556a(XmlPullParser parser, String attrName) {
        return parser.getAttributeValue("http://schemas.android.com/apk/res/android", attrName) != null;
    }

    /* renamed from: a */
    public static float m2547a(TypedArray a, XmlPullParser parser, String attrName, int resId, float defaultValue) {
        if (!m2556a(parser, attrName)) {
            return defaultValue;
        }
        return a.getFloat(resId, defaultValue);
    }

    /* renamed from: a */
    public static boolean m2555a(TypedArray a, XmlPullParser parser, String attrName, int resId, boolean defaultValue) {
        if (!m2556a(parser, attrName)) {
            return defaultValue;
        }
        return a.getBoolean(resId, defaultValue);
    }

    /* renamed from: b */
    public static int m2558b(TypedArray a, XmlPullParser parser, String attrName, int resId, int defaultValue) {
        if (!m2556a(parser, attrName)) {
            return defaultValue;
        }
        return a.getInt(resId, defaultValue);
    }

    /* renamed from: a */
    public static int m2550a(TypedArray a, XmlPullParser parser, String attrName, int resId, int defaultValue) {
        if (!m2556a(parser, attrName)) {
            return defaultValue;
        }
        return a.getColor(resId, defaultValue);
    }

    /* renamed from: c */
    public static int m2561c(TypedArray a, XmlPullParser parser, String attrName, int resId, int defaultValue) {
        if (!m2556a(parser, attrName)) {
            return defaultValue;
        }
        return a.getResourceId(resId, defaultValue);
    }

    /* renamed from: a */
    public static String m2553a(TypedArray a, XmlPullParser parser, String attrName, int resId) {
        if (!m2556a(parser, attrName)) {
            return null;
        }
        return a.getString(resId);
    }

    /* renamed from: b */
    public static TypedValue m2559b(TypedArray a, XmlPullParser parser, String attrName, int resId) {
        if (!m2556a(parser, attrName)) {
            return null;
        }
        return a.peekValue(resId);
    }

    /* renamed from: a */
    public static TypedArray m2551a(Resources res, Theme theme, AttributeSet set, int[] attrs) {
        if (theme == null) {
            return res.obtainAttributes(set, attrs);
        }
        return theme.obtainStyledAttributes(set, attrs, 0, 0);
    }

    /* renamed from: a */
    public static boolean m2554a(TypedArray a, int index, int fallbackIndex, boolean defaultValue) {
        return a.getBoolean(index, a.getBoolean(fallbackIndex, defaultValue));
    }

    /* renamed from: a */
    public static Drawable m2552a(TypedArray a, int index, int fallbackIndex) {
        Drawable val = a.getDrawable(index);
        if (val == null) {
            return a.getDrawable(fallbackIndex);
        }
        return val;
    }

    /* renamed from: a */
    public static int m2549a(TypedArray a, int index, int fallbackIndex, int defaultValue) {
        return a.getInt(index, a.getInt(fallbackIndex, defaultValue));
    }

    /* renamed from: b */
    public static int m2557b(TypedArray a, int index, int fallbackIndex, int defaultValue) {
        return a.getResourceId(index, a.getResourceId(fallbackIndex, defaultValue));
    }

    /* renamed from: b */
    public static String m2560b(TypedArray a, int index, int fallbackIndex) {
        String val = a.getString(index);
        if (val == null) {
            return a.getString(fallbackIndex);
        }
        return val;
    }

    /* renamed from: c */
    public static CharSequence m2562c(TypedArray a, int index, int fallbackIndex) {
        CharSequence val = a.getText(index);
        if (val == null) {
            return a.getText(fallbackIndex);
        }
        return val;
    }

    /* renamed from: d */
    public static CharSequence[] m2563d(TypedArray a, int index, int fallbackIndex) {
        CharSequence[] val = a.getTextArray(index);
        if (val == null) {
            return a.getTextArray(fallbackIndex);
        }
        return val;
    }

    /* renamed from: a */
    public static int m2548a(Context context, int attr, int fallbackAttr) {
        TypedValue value = new TypedValue();
        context.getTheme().resolveAttribute(attr, value, true);
        if (value.resourceId != 0) {
            return attr;
        }
        return fallbackAttr;
    }
}
