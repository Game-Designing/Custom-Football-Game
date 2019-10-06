package p002b.p003c.p053g.p054a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface.Builder;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.support.p000v4.content.p036a.C0500a.C0502b;
import android.support.p000v4.content.p036a.C0500a.C0503c;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import p002b.p003c.p053g.p059d.C1232f;
import p002b.p003c.p053g.p059d.C1232f.C1234b;

/* renamed from: b.c.g.a.f */
/* compiled from: TypefaceCompatApi26Impl */
public class C1217f extends C1215d {

    /* renamed from: a */
    private static final Class f3950a;

    /* renamed from: b */
    private static final Constructor f3951b;

    /* renamed from: c */
    private static final Method f3952c;

    /* renamed from: d */
    private static final Method f3953d;

    /* renamed from: e */
    private static final Method f3954e;

    /* renamed from: f */
    private static final Method f3955f;

    /* renamed from: g */
    private static final Method f3956g;

    static {
        Method abortCreationMethod;
        Method freezeMethod;
        Method addFromBufferMethod;
        Method addFontMethod;
        Constructor fontFamilyCtor;
        Method createFromFamiliesWithDefaultMethod;
        Class fontFamilyClass;
        try {
            fontFamilyClass = Class.forName("android.graphics.FontFamily");
            try {
                fontFamilyCtor = fontFamilyClass.getConstructor(new Class[0]);
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                e = e;
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to collect necessary methods for class ");
                sb.append(e.getClass().getName());
                Log.e("TypefaceCompatApi26Impl", sb.toString(), e);
                fontFamilyClass = null;
                fontFamilyCtor = null;
                addFontMethod = null;
                addFromBufferMethod = null;
                freezeMethod = null;
                abortCreationMethod = null;
                createFromFamiliesWithDefaultMethod = null;
                f3951b = fontFamilyCtor;
                f3950a = fontFamilyClass;
                f3952c = addFontMethod;
                f3953d = addFromBufferMethod;
                f3954e = freezeMethod;
                f3955f = abortCreationMethod;
                f3956g = createFromFamiliesWithDefaultMethod;
            }
            try {
                addFontMethod = fontFamilyClass.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class});
            } catch (ClassNotFoundException | NoSuchMethodException e2) {
                e = e2;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to collect necessary methods for class ");
                sb2.append(e.getClass().getName());
                Log.e("TypefaceCompatApi26Impl", sb2.toString(), e);
                fontFamilyClass = null;
                fontFamilyCtor = null;
                addFontMethod = null;
                addFromBufferMethod = null;
                freezeMethod = null;
                abortCreationMethod = null;
                createFromFamiliesWithDefaultMethod = null;
                f3951b = fontFamilyCtor;
                f3950a = fontFamilyClass;
                f3952c = addFontMethod;
                f3953d = addFromBufferMethod;
                f3954e = freezeMethod;
                f3955f = abortCreationMethod;
                f3956g = createFromFamiliesWithDefaultMethod;
            }
            try {
                addFromBufferMethod = fontFamilyClass.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE});
                try {
                    freezeMethod = fontFamilyClass.getMethod("freeze", new Class[0]);
                } catch (ClassNotFoundException | NoSuchMethodException e3) {
                    e = e3;
                    StringBuilder sb22 = new StringBuilder();
                    sb22.append("Unable to collect necessary methods for class ");
                    sb22.append(e.getClass().getName());
                    Log.e("TypefaceCompatApi26Impl", sb22.toString(), e);
                    fontFamilyClass = null;
                    fontFamilyCtor = null;
                    addFontMethod = null;
                    addFromBufferMethod = null;
                    freezeMethod = null;
                    abortCreationMethod = null;
                    createFromFamiliesWithDefaultMethod = null;
                    f3951b = fontFamilyCtor;
                    f3950a = fontFamilyClass;
                    f3952c = addFontMethod;
                    f3953d = addFromBufferMethod;
                    f3954e = freezeMethod;
                    f3955f = abortCreationMethod;
                    f3956g = createFromFamiliesWithDefaultMethod;
                }
                try {
                    abortCreationMethod = fontFamilyClass.getMethod("abortCreation", new Class[0]);
                    try {
                        createFromFamiliesWithDefaultMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(fontFamilyClass, 1).getClass(), Integer.TYPE, Integer.TYPE});
                        try {
                            createFromFamiliesWithDefaultMethod.setAccessible(true);
                        } catch (ClassNotFoundException | NoSuchMethodException e4) {
                            e = e4;
                        }
                    } catch (ClassNotFoundException | NoSuchMethodException e5) {
                        e = e5;
                        StringBuilder sb222 = new StringBuilder();
                        sb222.append("Unable to collect necessary methods for class ");
                        sb222.append(e.getClass().getName());
                        Log.e("TypefaceCompatApi26Impl", sb222.toString(), e);
                        fontFamilyClass = null;
                        fontFamilyCtor = null;
                        addFontMethod = null;
                        addFromBufferMethod = null;
                        freezeMethod = null;
                        abortCreationMethod = null;
                        createFromFamiliesWithDefaultMethod = null;
                        f3951b = fontFamilyCtor;
                        f3950a = fontFamilyClass;
                        f3952c = addFontMethod;
                        f3953d = addFromBufferMethod;
                        f3954e = freezeMethod;
                        f3955f = abortCreationMethod;
                        f3956g = createFromFamiliesWithDefaultMethod;
                    }
                } catch (ClassNotFoundException | NoSuchMethodException e6) {
                    e = e6;
                    StringBuilder sb2222 = new StringBuilder();
                    sb2222.append("Unable to collect necessary methods for class ");
                    sb2222.append(e.getClass().getName());
                    Log.e("TypefaceCompatApi26Impl", sb2222.toString(), e);
                    fontFamilyClass = null;
                    fontFamilyCtor = null;
                    addFontMethod = null;
                    addFromBufferMethod = null;
                    freezeMethod = null;
                    abortCreationMethod = null;
                    createFromFamiliesWithDefaultMethod = null;
                    f3951b = fontFamilyCtor;
                    f3950a = fontFamilyClass;
                    f3952c = addFontMethod;
                    f3953d = addFromBufferMethod;
                    f3954e = freezeMethod;
                    f3955f = abortCreationMethod;
                    f3956g = createFromFamiliesWithDefaultMethod;
                }
            } catch (ClassNotFoundException | NoSuchMethodException e7) {
                e = e7;
                StringBuilder sb22222 = new StringBuilder();
                sb22222.append("Unable to collect necessary methods for class ");
                sb22222.append(e.getClass().getName());
                Log.e("TypefaceCompatApi26Impl", sb22222.toString(), e);
                fontFamilyClass = null;
                fontFamilyCtor = null;
                addFontMethod = null;
                addFromBufferMethod = null;
                freezeMethod = null;
                abortCreationMethod = null;
                createFromFamiliesWithDefaultMethod = null;
                f3951b = fontFamilyCtor;
                f3950a = fontFamilyClass;
                f3952c = addFontMethod;
                f3953d = addFromBufferMethod;
                f3954e = freezeMethod;
                f3955f = abortCreationMethod;
                f3956g = createFromFamiliesWithDefaultMethod;
            }
        } catch (ClassNotFoundException | NoSuchMethodException e8) {
            e = e8;
            StringBuilder sb222222 = new StringBuilder();
            sb222222.append("Unable to collect necessary methods for class ");
            sb222222.append(e.getClass().getName());
            Log.e("TypefaceCompatApi26Impl", sb222222.toString(), e);
            fontFamilyClass = null;
            fontFamilyCtor = null;
            addFontMethod = null;
            addFromBufferMethod = null;
            freezeMethod = null;
            abortCreationMethod = null;
            createFromFamiliesWithDefaultMethod = null;
            f3951b = fontFamilyCtor;
            f3950a = fontFamilyClass;
            f3952c = addFontMethod;
            f3953d = addFromBufferMethod;
            f3954e = freezeMethod;
            f3955f = abortCreationMethod;
            f3956g = createFromFamiliesWithDefaultMethod;
        }
        f3951b = fontFamilyCtor;
        f3950a = fontFamilyClass;
        f3952c = addFontMethod;
        f3953d = addFromBufferMethod;
        f3954e = freezeMethod;
        f3955f = abortCreationMethod;
        f3956g = createFromFamiliesWithDefaultMethod;
    }

    /* renamed from: a */
    private static boolean m5787a() {
        if (f3952c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return f3952c != null;
    }

    /* renamed from: b */
    private static Object m5791b() {
        try {
            return f3951b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private static boolean m5788a(Context context, Object family, String fileName, int ttcIndex, int weight, int style) {
        try {
            return ((Boolean) f3952c.invoke(family, new Object[]{context.getAssets(), fileName, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(ttcIndex), Integer.valueOf(weight), Integer.valueOf(style), null})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private static boolean m5789a(Object family, ByteBuffer buffer, int ttcIndex, int weight, int style) {
        try {
            return ((Boolean) f3953d.invoke(family, new Object[]{buffer, Integer.valueOf(ttcIndex), null, Integer.valueOf(weight), Integer.valueOf(style)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: b */
    private static Typeface m5790b(Object family) {
        try {
            Object familyArray = Array.newInstance(f3950a, 1);
            Array.set(familyArray, 0, family);
            return (Typeface) f3956g.invoke(null, new Object[]{familyArray, Integer.valueOf(-1), Integer.valueOf(-1)});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: c */
    private static boolean m5792c(Object family) {
        try {
            return ((Boolean) f3954e.invoke(family, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private static void m5786a(Object family) {
        try {
            f3955f.invoke(family, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public Typeface mo8978a(Context context, C0502b entry, Resources resources, int style) {
        C0503c[] a;
        if (!m5787a()) {
            return super.mo8978a(context, entry, resources, style);
        }
        Object fontFamily = m5791b();
        for (C0503c fontFile : entry.mo5276a()) {
            if (!m5788a(context, fontFamily, fontFile.mo5277a(), 0, fontFile.mo5279c(), fontFile.mo5280d() ? 1 : 0)) {
                m5786a(fontFamily);
                return null;
            }
        }
        if (!m5792c(fontFamily)) {
            return null;
        }
        return m5790b(fontFamily);
    }

    /* renamed from: a */
    public Typeface mo8977a(Context context, CancellationSignal cancellationSignal, C1234b[] fonts, int style) {
        ParcelFileDescriptor pfd;
        Throwable th;
        Throwable th2;
        Throwable th3;
        CancellationSignal cancellationSignal2 = cancellationSignal;
        C1234b[] bVarArr = fonts;
        int i = style;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!m5787a()) {
            C1234b bestFont = mo8986a(bVarArr, i);
            try {
                pfd = context.getContentResolver().openFileDescriptor(bestFont.mo9004c(), "r", cancellationSignal2);
                if (pfd == null) {
                    if (pfd != null) {
                        pfd.close();
                    }
                    return null;
                }
                try {
                    Typeface build = new Builder(pfd.getFileDescriptor()).setWeight(bestFont.mo9005d()).setItalic(bestFont.mo9006e()).build();
                    if (pfd != null) {
                        pfd.close();
                    }
                    return build;
                } catch (Throwable th4) {
                    Throwable th5 = th3;
                    th = th4;
                    th2 = th5;
                }
            } catch (IOException e) {
                return null;
            }
        } else {
            Map<Uri, ByteBuffer> uriBuffer = C1232f.m5842a(context, bVarArr, cancellationSignal2);
            Object fontFamily = m5791b();
            boolean atLeastOneFont = false;
            for (C1234b font : bVarArr) {
                ByteBuffer fontBuffer = (ByteBuffer) uriBuffer.get(font.mo9004c());
                if (fontBuffer != null) {
                    if (!m5789a(fontFamily, fontBuffer, font.mo9003b(), font.mo9005d(), font.mo9006e() ? 1 : 0)) {
                        m5786a(fontFamily);
                        return null;
                    }
                    atLeastOneFont = true;
                }
            }
            if (!atLeastOneFont) {
                m5786a(fontFamily);
                return null;
            } else if (!m5792c(fontFamily)) {
                return null;
            } else {
                return Typeface.create(m5790b(fontFamily), i);
            }
        }
        if (pfd != null) {
            if (th2 != null) {
                try {
                    pfd.close();
                } catch (Throwable th6) {
                }
            } else {
                pfd.close();
            }
        }
        throw th;
        throw th;
    }

    /* renamed from: a */
    public Typeface mo8976a(Context context, Resources resources, int id, String path, int style) {
        if (!m5787a()) {
            return super.mo8976a(context, resources, id, path, style);
        }
        Object fontFamily = m5791b();
        if (!m5788a(context, fontFamily, path, 0, -1, -1)) {
            m5786a(fontFamily);
            return null;
        } else if (!m5792c(fontFamily)) {
            return null;
        } else {
            return m5790b(fontFamily);
        }
    }
}
