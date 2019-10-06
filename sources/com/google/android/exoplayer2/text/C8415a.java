package com.google.android.exoplayer2.text;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.exoplayer2.util.C8509F;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;

/* renamed from: com.google.android.exoplayer2.text.a */
/* compiled from: CaptionStyleCompat */
public final class C8415a {

    /* renamed from: a */
    public static final C8415a f18378a;

    /* renamed from: b */
    public final int f18379b;

    /* renamed from: c */
    public final int f18380c;

    /* renamed from: d */
    public final int f18381d;

    /* renamed from: e */
    public final int f18382e;

    /* renamed from: f */
    public final int f18383f;

    /* renamed from: g */
    public final Typeface f18384g;

    static {
        C8415a aVar = new C8415a(-1, CtaButton.BACKGROUND_COLOR, 0, 0, -1, null);
        f18378a = aVar;
    }

    @TargetApi(19)
    /* renamed from: a */
    public static C8415a m20007a(CaptionStyle captionStyle) {
        if (C8509F.f18793a >= 21) {
            return m20009c(captionStyle);
        }
        return m20008b(captionStyle);
    }

    public C8415a(int foregroundColor, int backgroundColor, int windowColor, int edgeType, int edgeColor, Typeface typeface) {
        this.f18379b = foregroundColor;
        this.f18380c = backgroundColor;
        this.f18381d = windowColor;
        this.f18382e = edgeType;
        this.f18383f = edgeColor;
        this.f18384g = typeface;
    }

    @TargetApi(19)
    /* renamed from: b */
    private static C8415a m20008b(CaptionStyle captionStyle) {
        C8415a aVar = new C8415a(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
        return aVar;
    }

    @TargetApi(21)
    /* renamed from: c */
    private static C8415a m20009c(CaptionStyle captionStyle) {
        C8415a aVar = new C8415a(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f18378a.f18379b, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f18378a.f18380c, captionStyle.hasWindowColor() ? captionStyle.windowColor : f18378a.f18381d, captionStyle.hasEdgeType() ? captionStyle.edgeType : f18378a.f18382e, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f18378a.f18383f, captionStyle.getTypeface());
        return aVar;
    }
}
