package p002b.p003c.p053g.p054a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.support.p000v4.content.p036a.C0500a.C0502b;
import android.support.p000v4.content.p036a.C0500a.C0503c;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import p002b.p003c.p053g.p059d.C1232f.C1234b;

/* renamed from: b.c.g.a.i */
/* compiled from: TypefaceCompatBaseImpl */
class C1220i implements C1214a {

    /* renamed from: b.c.g.a.i$a */
    /* compiled from: TypefaceCompatBaseImpl */
    private interface C1221a<T> {
        /* renamed from: a */
        boolean mo8980a(T t);

        /* renamed from: b */
        int mo8981b(T t);
    }

    C1220i() {
    }

    /* renamed from: a */
    private static <T> T m5805a(T[] fonts, int style, C1221a<T> extractor) {
        int targetWeight = (style & 1) == 0 ? 400 : 700;
        boolean isTargetItalic = (style & 2) != 0;
        int bestScore = Integer.MAX_VALUE;
        T best = null;
        for (T font : fonts) {
            int score = (Math.abs(extractor.mo8981b(font) - targetWeight) * 2) + (extractor.mo8980a(font) == isTargetItalic ? 0 : 1);
            if (best == null || bestScore > score) {
                best = font;
                bestScore = score;
            }
        }
        return best;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1234b mo8986a(C1234b[] fonts, int style) {
        return (C1234b) m5805a(fonts, style, new C1218g(this));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Typeface mo8985a(Context context, InputStream is) {
        File tmpFile = C1222j.m5813a(context);
        if (tmpFile == null) {
            return null;
        }
        try {
            if (!C1222j.m5819a(tmpFile, is)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(tmpFile.getPath());
            tmpFile.delete();
            return createFromFile;
        } catch (RuntimeException e) {
            return null;
        } finally {
            tmpFile.delete();
        }
    }

    /* renamed from: a */
    public Typeface mo8977a(Context context, CancellationSignal cancellationSignal, C1234b[] fonts, int style) {
        if (fonts.length < 1) {
            return null;
        }
        InputStream is = null;
        try {
            is = context.getContentResolver().openInputStream(mo8986a(fonts, style).mo9004c());
            return mo8985a(context, is);
        } catch (IOException e) {
            return null;
        } finally {
            C1222j.m5817a((Closeable) is);
        }
    }

    /* renamed from: a */
    private C0503c m5804a(C0502b entry, int style) {
        return (C0503c) m5805a(entry.mo5276a(), style, new C1219h(this));
    }

    /* renamed from: a */
    public Typeface mo8978a(Context context, C0502b entry, Resources resources, int style) {
        C0503c best = m5804a(entry, style);
        if (best == null) {
            return null;
        }
        return C1213c.m5770a(context, resources, best.mo5278b(), best.mo5277a(), style);
    }

    /* renamed from: a */
    public Typeface mo8976a(Context context, Resources resources, int id, String path, int style) {
        File tmpFile = C1222j.m5813a(context);
        if (tmpFile == null) {
            return null;
        }
        try {
            if (!C1222j.m5818a(tmpFile, resources, id)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(tmpFile.getPath());
            tmpFile.delete();
            return createFromFile;
        } catch (RuntimeException e) {
            return null;
        } finally {
            tmpFile.delete();
        }
    }
}
