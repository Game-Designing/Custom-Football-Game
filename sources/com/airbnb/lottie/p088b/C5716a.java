package com.airbnb.lottie.p088b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable.Callback;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.C5674a;
import com.airbnb.lottie.p089c.C5779h;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.airbnb.lottie.b.a */
/* compiled from: FontAssetManager */
public class C5716a {

    /* renamed from: a */
    private final C5779h<String> f9808a = new C5779h<>();

    /* renamed from: b */
    private final Map<C5779h<String>, Typeface> f9809b = new HashMap();

    /* renamed from: c */
    private final Map<String, Typeface> f9810c = new HashMap();

    /* renamed from: d */
    private final AssetManager f9811d;

    /* renamed from: e */
    private C5674a f9812e;

    /* renamed from: f */
    private String f9813f = ".ttf";

    public C5716a(Callback callback, C5674a delegate) {
        this.f9812e = delegate;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.f9811d = null;
            return;
        }
        this.f9811d = ((View) callback).getContext().getAssets();
    }

    /* renamed from: a */
    public void mo17973a(C5674a assetDelegate) {
        this.f9812e = assetDelegate;
    }

    /* renamed from: a */
    public Typeface mo17972a(String fontFamily, String style) {
        this.f9808a.mo18128a(fontFamily, style);
        Typeface typeface = (Typeface) this.f9809b.get(this.f9808a);
        if (typeface != null) {
            return typeface;
        }
        Typeface typeface2 = m10167a(m10168a(fontFamily), style);
        this.f9809b.put(this.f9808a, typeface2);
        return typeface2;
    }

    /* renamed from: a */
    private Typeface m10168a(String fontFamily) {
        Typeface defaultTypeface = (Typeface) this.f9810c.get(fontFamily);
        if (defaultTypeface != null) {
            return defaultTypeface;
        }
        Typeface typeface = null;
        C5674a aVar = this.f9812e;
        if (aVar != null) {
            aVar.mo17930a(fontFamily);
            throw null;
        } else if (aVar == null || 0 != 0) {
            if (0 == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("fonts/");
                sb.append(fontFamily);
                sb.append(this.f9813f);
                typeface = Typeface.createFromAsset(this.f9811d, sb.toString());
            }
            this.f9810c.put(fontFamily, typeface);
            return typeface;
        } else {
            aVar.mo17931b(fontFamily);
            throw null;
        }
    }

    /* renamed from: a */
    private Typeface m10167a(Typeface typeface, String style) {
        int styleInt = 0;
        boolean containsItalic = style.contains("Italic");
        boolean containsBold = style.contains("Bold");
        if (containsItalic && containsBold) {
            styleInt = 3;
        } else if (containsItalic) {
            styleInt = 2;
        } else if (containsBold) {
            styleInt = 1;
        }
        if (typeface.getStyle() == styleInt) {
            return typeface;
        }
        return Typeface.create(typeface, styleInt);
    }
}
