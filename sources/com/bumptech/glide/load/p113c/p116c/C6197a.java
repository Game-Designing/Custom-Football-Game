package com.bumptech.glide.load.p113c.p116c;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.p000v4.content.C0510b;
import android.support.p000v4.content.p036a.C0507d;
import p002b.p003c.p062h.p064b.p065a.C1282b;
import p002b.p003c.p062h.p071g.C1303d;

/* renamed from: com.bumptech.glide.load.c.c.a */
/* compiled from: DrawableDecoderCompat */
public final class C6197a {

    /* renamed from: a */
    private static volatile boolean f10929a = true;

    /* renamed from: a */
    public static Drawable m11772a(Context ourContext, Context targetContext, int id) {
        return m11773a(ourContext, targetContext, id, null);
    }

    /* renamed from: a */
    public static Drawable m11771a(Context ourContext, int id, Theme theme) {
        return m11773a(ourContext, ourContext, id, theme);
    }

    /* renamed from: a */
    private static Drawable m11773a(Context ourContext, Context targetContext, int id, Theme theme) {
        try {
            if (f10929a) {
                return m11775c(targetContext, id, theme);
            }
        } catch (NoClassDefFoundError e) {
            f10929a = false;
        } catch (IllegalStateException e2) {
            if (!ourContext.getPackageName().equals(targetContext.getPackageName())) {
                return C0510b.m2572c(targetContext, id);
            }
            throw e2;
        } catch (NotFoundException e3) {
        }
        return m11774b(targetContext, id, theme != null ? theme : targetContext.getTheme());
    }

    /* renamed from: c */
    private static Drawable m11775c(Context context, int id, Theme theme) {
        return C1282b.m6000b(theme != null ? new C1303d(context, theme) : context, id);
    }

    /* renamed from: b */
    private static Drawable m11774b(Context context, int id, Theme theme) {
        return C0507d.m2542a(context.getResources(), id, theme);
    }
}
