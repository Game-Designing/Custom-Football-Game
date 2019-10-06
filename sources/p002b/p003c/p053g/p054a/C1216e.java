package p002b.p003c.p053g.p054a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.p000v4.content.p036a.C0500a.C0502b;
import android.support.p000v4.content.p036a.C0500a.C0503c;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import p002b.p003c.p053g.p059d.C1232f.C1234b;
import p002b.p003c.p053g.p061f.C1273q;

/* renamed from: b.c.g.a.e */
/* compiled from: TypefaceCompatApi24Impl */
class C1216e extends C1220i {

    /* renamed from: a */
    private static final Class f3946a;

    /* renamed from: b */
    private static final Constructor f3947b;

    /* renamed from: c */
    private static final Method f3948c;

    /* renamed from: d */
    private static final Method f3949d;

    C1216e() {
    }

    static {
        Method addFontMethod;
        Constructor fontFamilyCtor;
        Method createFromFamiliesWithDefaultMethod;
        Class fontFamilyClass;
        try {
            fontFamilyClass = Class.forName("android.graphics.FontFamily");
            try {
                fontFamilyCtor = fontFamilyClass.getConstructor(new Class[0]);
                try {
                    addFontMethod = fontFamilyClass.getMethod("addFontWeightStyle", new Class[]{ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE});
                    try {
                        createFromFamiliesWithDefaultMethod = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(fontFamilyClass, 1).getClass()});
                    } catch (ClassNotFoundException | NoSuchMethodException e) {
                        e = e;
                        Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
                        fontFamilyClass = null;
                        fontFamilyCtor = null;
                        addFontMethod = null;
                        createFromFamiliesWithDefaultMethod = null;
                        f3947b = fontFamilyCtor;
                        f3946a = fontFamilyClass;
                        f3948c = addFontMethod;
                        f3949d = createFromFamiliesWithDefaultMethod;
                    }
                } catch (ClassNotFoundException | NoSuchMethodException e2) {
                    e = e2;
                    Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
                    fontFamilyClass = null;
                    fontFamilyCtor = null;
                    addFontMethod = null;
                    createFromFamiliesWithDefaultMethod = null;
                    f3947b = fontFamilyCtor;
                    f3946a = fontFamilyClass;
                    f3948c = addFontMethod;
                    f3949d = createFromFamiliesWithDefaultMethod;
                }
            } catch (ClassNotFoundException | NoSuchMethodException e3) {
                e = e3;
                Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
                fontFamilyClass = null;
                fontFamilyCtor = null;
                addFontMethod = null;
                createFromFamiliesWithDefaultMethod = null;
                f3947b = fontFamilyCtor;
                f3946a = fontFamilyClass;
                f3948c = addFontMethod;
                f3949d = createFromFamiliesWithDefaultMethod;
            }
        } catch (ClassNotFoundException | NoSuchMethodException e4) {
            e = e4;
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            fontFamilyClass = null;
            fontFamilyCtor = null;
            addFontMethod = null;
            createFromFamiliesWithDefaultMethod = null;
            f3947b = fontFamilyCtor;
            f3946a = fontFamilyClass;
            f3948c = addFontMethod;
            f3949d = createFromFamiliesWithDefaultMethod;
        }
        f3947b = fontFamilyCtor;
        f3946a = fontFamilyClass;
        f3948c = addFontMethod;
        f3949d = createFromFamiliesWithDefaultMethod;
    }

    /* renamed from: a */
    public static boolean m5781a() {
        if (f3948c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f3948c != null;
    }

    /* renamed from: b */
    private static Object m5783b() {
        try {
            return f3947b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private static boolean m5782a(Object family, ByteBuffer buffer, int ttcIndex, int weight, boolean style) {
        try {
            return ((Boolean) f3948c.invoke(family, new Object[]{buffer, Integer.valueOf(ttcIndex), null, Integer.valueOf(weight), Boolean.valueOf(style)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private static Typeface m5780a(Object family) {
        try {
            Object familyArray = Array.newInstance(f3946a, 1);
            Array.set(familyArray, 0, family);
            return (Typeface) f3949d.invoke(null, new Object[]{familyArray});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public Typeface mo8977a(Context context, CancellationSignal cancellationSignal, C1234b[] fonts, int style) {
        Object family = m5783b();
        SimpleArrayMap<Uri, ByteBuffer> bufferCache = new C1273q<>();
        for (C1234b font : fonts) {
            Uri uri = font.mo9004c();
            ByteBuffer buffer = (ByteBuffer) bufferCache.get(uri);
            if (buffer == null) {
                buffer = C1222j.m5815a(context, cancellationSignal, uri);
                bufferCache.put(uri, buffer);
            }
            if (!m5782a(family, buffer, font.mo9003b(), font.mo9005d(), font.mo9006e())) {
                return null;
            }
        }
        return Typeface.create(m5780a(family), style);
    }

    /* renamed from: a */
    public Typeface mo8978a(Context context, C0502b entry, Resources resources, int style) {
        C0503c[] a;
        Object family = m5783b();
        for (C0503c e : entry.mo5276a()) {
            ByteBuffer buffer = C1222j.m5814a(context, resources, e.mo5278b());
            if (buffer == null || !m5782a(family, buffer, 0, e.mo5279c(), e.mo5280d())) {
                return null;
            }
        }
        return m5780a(family);
    }
}
