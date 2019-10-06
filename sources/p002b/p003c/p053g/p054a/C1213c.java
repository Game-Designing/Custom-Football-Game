package p002b.p003c.p053g.p054a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.p000v4.content.p036a.C0500a.C0501a;
import android.support.p000v4.content.p036a.C0500a.C0502b;
import android.support.p000v4.content.p036a.C0500a.C0504d;
import android.support.p000v4.content.p036a.C0507d.C0508a;
import p002b.p003c.p053g.p059d.C1232f;
import p002b.p003c.p053g.p059d.C1232f.C1234b;
import p002b.p003c.p053g.p061f.C1260i;

/* renamed from: b.c.g.a.c */
/* compiled from: TypefaceCompat */
public class C1213c {

    /* renamed from: a */
    private static final C1214a f3944a;

    /* renamed from: b */
    private static final C1260i<String, Typeface> f3945b = new C1260i<>(16);

    /* renamed from: b.c.g.a.c$a */
    /* compiled from: TypefaceCompat */
    interface C1214a {
        /* renamed from: a */
        Typeface mo8976a(Context context, Resources resources, int i, String str, int i2);

        /* renamed from: a */
        Typeface mo8977a(Context context, CancellationSignal cancellationSignal, C1234b[] bVarArr, int i);

        /* renamed from: a */
        Typeface mo8978a(Context context, C0502b bVar, Resources resources, int i);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 26) {
            f3944a = new C1217f();
        } else if (i >= 24 && C1216e.m5781a()) {
            f3944a = new C1216e();
        } else if (VERSION.SDK_INT >= 21) {
            f3944a = new C1215d();
        } else {
            f3944a = new C1220i();
        }
    }

    /* renamed from: a */
    public static Typeface m5773a(Resources resources, int id, int style) {
        return (Typeface) f3945b.get(m5774b(resources, id, style));
    }

    /* renamed from: b */
    private static String m5774b(Resources resources, int id, int style) {
        StringBuilder sb = new StringBuilder();
        sb.append(resources.getResourcePackageName(id));
        String str = "-";
        sb.append(str);
        sb.append(id);
        sb.append(str);
        sb.append(style);
        return sb.toString();
    }

    /* renamed from: a */
    public static Typeface m5772a(Context context, C0501a entry, Resources resources, int id, int style, C0508a fontCallback, Handler handler, boolean isRequestFromLayoutInflator) {
        Typeface typeface;
        C0501a aVar = entry;
        C0508a aVar2 = fontCallback;
        Handler handler2 = handler;
        if (aVar instanceof C0504d) {
            C0504d providerEntry = (C0504d) aVar;
            typeface = C1232f.m5836a(context, providerEntry.mo5282b(), fontCallback, handler, !isRequestFromLayoutInflator ? aVar2 == null : providerEntry.mo5281a() == 0, isRequestFromLayoutInflator ? providerEntry.mo5283c() : -1, style);
            Context context2 = context;
            Resources resources2 = resources;
            int i = style;
        } else {
            Context context3 = context;
            Resources resources3 = resources;
            int i2 = style;
            typeface = f3944a.mo8978a(context, (C0502b) aVar, resources, style);
            if (aVar2 != null) {
                if (typeface != null) {
                    aVar2.mo5289a(typeface, handler2);
                } else {
                    aVar2.mo5287a(-3, handler2);
                }
            }
        }
        if (typeface != null) {
            f3945b.put(m5774b(resources, id, style), typeface);
        }
        return typeface;
    }

    /* renamed from: a */
    public static Typeface m5770a(Context context, Resources resources, int id, String path, int style) {
        Typeface typeface = f3944a.mo8976a(context, resources, id, path, style);
        if (typeface != null) {
            f3945b.put(m5774b(resources, id, style), typeface);
        }
        return typeface;
    }

    /* renamed from: a */
    public static Typeface m5771a(Context context, CancellationSignal cancellationSignal, C1234b[] fonts, int style) {
        return f3944a.mo8977a(context, cancellationSignal, fonts, style);
    }
}
