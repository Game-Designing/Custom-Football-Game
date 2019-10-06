package android.support.p000v4.content.p036a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;

/* renamed from: android.support.v4.content.a.d */
/* compiled from: ResourcesCompat */
public final class C0507d {

    /* renamed from: android.support.v4.content.a.d$a */
    /* compiled from: ResourcesCompat */
    public static abstract class C0508a {
        /* renamed from: a */
        public abstract void mo5286a(int i);

        /* renamed from: a */
        public abstract void mo5288a(Typeface typeface);

        /* renamed from: a */
        public final void mo5289a(Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new C0505b(this, typeface));
        }

        /* renamed from: a */
        public final void mo5287a(int reason, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new C0506c(this, reason));
        }
    }

    /* renamed from: a */
    public static Drawable m2542a(Resources res, int id, Theme theme) throws NotFoundException {
        if (VERSION.SDK_INT >= 21) {
            return res.getDrawable(id, theme);
        }
        return res.getDrawable(id);
    }

    /* renamed from: a */
    public static Typeface m2539a(Context context, int id, TypedValue value, int style, C0508a fontCallback) throws NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return m2540a(context, id, value, style, fontCallback, null, true);
    }

    /* renamed from: a */
    private static Typeface m2540a(Context context, int id, TypedValue value, int style, C0508a fontCallback, Handler handler, boolean isRequestFromLayoutInflator) {
        Resources resources = context.getResources();
        resources.getValue(id, value, true);
        Typeface typeface = m2541a(context, resources, value, id, style, fontCallback, handler, isRequestFromLayoutInflator);
        if (typeface != null || fontCallback != null) {
            return typeface;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Font resource ID #0x");
        sb.append(Integer.toHexString(id));
        sb.append(" could not be retrieved.");
        throw new NotFoundException(sb.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f3  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Typeface m2541a(android.content.Context r19, android.content.res.Resources r20, android.util.TypedValue r21, int r22, int r23, android.support.p000v4.content.p036a.C0507d.C0508a r24, android.os.Handler r25, boolean r26) {
        /*
            r9 = r20
            r10 = r21
            r11 = r22
            r12 = r23
            r13 = r24
            r14 = r25
            java.lang.String r15 = "ResourcesCompat"
            java.lang.CharSequence r0 = r10.string
            if (r0 == 0) goto L_0x00f8
            java.lang.String r8 = r0.toString()
            java.lang.String r0 = "res/"
            boolean r0 = r8.startsWith(r0)
            r16 = 0
            r7 = -3
            if (r0 != 0) goto L_0x0027
            if (r13 == 0) goto L_0x0026
            r13.mo5287a(r7, r14)
        L_0x0026:
            return r16
        L_0x0027:
            android.graphics.Typeface r6 = p002b.p003c.p053g.p054a.C1213c.m5773a(r9, r11, r12)
            if (r6 == 0) goto L_0x0033
            if (r13 == 0) goto L_0x0032
            r13.mo5289a(r6, r14)
        L_0x0032:
            return r6
        L_0x0033:
            java.lang.String r0 = r8.toLowerCase()     // Catch:{ XmlPullParserException -> 0x00d6, IOException -> 0x00bb }
            java.lang.String r1 = ".xml"
            boolean r0 = r0.endsWith(r1)     // Catch:{ XmlPullParserException -> 0x00d6, IOException -> 0x00bb }
            if (r0 == 0) goto L_0x0097
            android.content.res.XmlResourceParser r0 = r9.getXml(r11)     // Catch:{ XmlPullParserException -> 0x0090, IOException -> 0x0089 }
            android.support.v4.content.a.a$a r1 = android.support.p000v4.content.p036a.C0500a.m2524a(r0, r9)     // Catch:{ XmlPullParserException -> 0x0090, IOException -> 0x0089 }
            r17 = r1
            if (r17 != 0) goto L_0x0067
            java.lang.String r1 = "Failed to find font-family tag"
            android.util.Log.e(r15, r1)     // Catch:{ XmlPullParserException -> 0x005f, IOException -> 0x0057 }
            if (r13 == 0) goto L_0x0056
            r13.mo5287a(r7, r14)     // Catch:{ XmlPullParserException -> 0x005f, IOException -> 0x0057 }
        L_0x0056:
            return r16
        L_0x0057:
            r0 = move-exception
            r1 = r19
            r18 = r6
            r10 = r8
            goto L_0x00c1
        L_0x005f:
            r0 = move-exception
            r1 = r19
            r18 = r6
            r10 = r8
            goto L_0x00dc
        L_0x0067:
            r1 = r19
            r2 = r17
            r3 = r20
            r4 = r22
            r5 = r23
            r18 = r6
            r6 = r24
            r10 = -3
            r7 = r25
            r10 = r8
            r8 = r26
            android.graphics.Typeface r1 = p002b.p003c.p053g.p054a.C1213c.m5772a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ XmlPullParserException -> 0x0084, IOException -> 0x0080 }
            return r1
        L_0x0080:
            r0 = move-exception
            r1 = r19
            goto L_0x00c1
        L_0x0084:
            r0 = move-exception
            r1 = r19
            goto L_0x00dc
        L_0x0089:
            r0 = move-exception
            r18 = r6
            r10 = r8
            r1 = r19
            goto L_0x00c1
        L_0x0090:
            r0 = move-exception
            r18 = r6
            r10 = r8
            r1 = r19
            goto L_0x00dc
        L_0x0097:
            r18 = r6
            r10 = r8
            r1 = r19
            android.graphics.Typeface r0 = p002b.p003c.p053g.p054a.C1213c.m5770a(r1, r9, r11, r10, r12)     // Catch:{ XmlPullParserException -> 0x00b9, IOException -> 0x00b7 }
            r6 = r0
            if (r13 == 0) goto L_0x00b6
            if (r6 == 0) goto L_0x00a9
            r13.mo5289a(r6, r14)     // Catch:{ XmlPullParserException -> 0x00b2, IOException -> 0x00ae }
            goto L_0x00b6
        L_0x00a9:
            r2 = -3
            r13.mo5287a(r2, r14)     // Catch:{ XmlPullParserException -> 0x00b2, IOException -> 0x00ae }
            goto L_0x00b6
        L_0x00ae:
            r0 = move-exception
            r18 = r6
            goto L_0x00c1
        L_0x00b2:
            r0 = move-exception
            r18 = r6
            goto L_0x00dc
        L_0x00b6:
            return r6
        L_0x00b7:
            r0 = move-exception
            goto L_0x00c1
        L_0x00b9:
            r0 = move-exception
            goto L_0x00dc
        L_0x00bb:
            r0 = move-exception
            r1 = r19
            r18 = r6
            r10 = r8
        L_0x00c1:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to read xml resource "
            r2.append(r3)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r15, r2, r0)
            goto L_0x00f1
        L_0x00d6:
            r0 = move-exception
            r1 = r19
            r18 = r6
            r10 = r8
        L_0x00dc:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to parse xml resource "
            r2.append(r3)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r15, r2, r0)
        L_0x00f1:
            if (r13 == 0) goto L_0x00f7
            r2 = -3
            r13.mo5287a(r2, r14)
        L_0x00f7:
            return r16
        L_0x00f8:
            r1 = r19
            android.content.res.Resources$NotFoundException r0 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Resource \""
            r2.append(r3)
            java.lang.String r3 = r9.getResourceName(r11)
            r2.append(r3)
            java.lang.String r3 = "\" ("
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r22)
            r2.append(r3)
            java.lang.String r3 = ") is not a Font: "
            r2.append(r3)
            r3 = r21
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.content.p036a.C0507d.m2541a(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, android.support.v4.content.a.d$a, android.os.Handler, boolean):android.graphics.Typeface");
    }
}
