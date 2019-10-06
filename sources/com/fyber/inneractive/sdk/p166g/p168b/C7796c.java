package com.fyber.inneractive.sdk.p166g.p168b;

import android.content.Context;
import android.view.View;
import com.fyber.inneractive.sdk.config.C7712j;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.h.a;
import com.fyber.inneractive.sdk.p174i.C7910l.C7911a;
import com.fyber.inneractive.sdk.p179l.C7927c;
import com.fyber.inneractive.sdk.p179l.C7930d.C7939a;
import com.fyber.inneractive.sdk.p179l.C7930d.C7943e;
import com.fyber.inneractive.sdk.p179l.C7930d.C7944f;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.C7994ah;
import com.fyber.inneractive.sdk.util.C8034w;
import com.fyber.inneractive.sdk.util.C8034w.C8039b;
import p019d.p268f.p269a.p270a.C12717b;

/* renamed from: com.fyber.inneractive.sdk.g.b.c */
public final class C7796c {

    /* renamed from: a */
    public IAmraidWebViewController f15688a;

    /* renamed from: b */
    public UnitDisplayType f15689b;

    /* renamed from: c */
    public boolean f15690c;

    /* renamed from: d */
    private C7943e f15691d = C7943e.INLINE;

    /* renamed from: e */
    private int f15692e = C7939a.f16206a;

    /* renamed from: com.fyber.inneractive.sdk.g.b.c$1 */
    static /* synthetic */ class C77971 {

        /* renamed from: a */
        static final /* synthetic */ int[] f15693a = new int[UnitDisplayType.values().length];

        /* renamed from: b */
        static final /* synthetic */ int[] f15694b = new int[C7911a.m17841a().length];

        static {
            try {
                f15694b[C7911a.f16061c - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15694b[C7911a.f16060b - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15694b[C7911a.f16059a - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15693a[UnitDisplayType.INTERSTITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public C7796c(Context context, UnitDisplayType unitDisplayType, boolean z, int i, int i2, C7712j jVar, int i3) {
        this.f15689b = unitDisplayType;
        this.f15690c = z;
        if (C77971.f15693a[this.f15689b.ordinal()] != 1) {
            this.f15692e = C7939a.f16206a;
        } else {
            this.f15692e = C7939a.f16206a;
            if (z) {
                this.f15691d = C7943e.INTERSTITIAL;
            }
        }
        IAmraidWebViewController iAmraidWebViewController = new IAmraidWebViewController(context, IAConfigManager.m17012z(), this.f15691d, this.f15692e, C7944f.f16223c, true);
        this.f15688a = iAmraidWebViewController;
        C7927c i4 = this.f15688a.i();
        int i5 = C77971.f15694b[i3 - 1];
        if (i5 == 1) {
            i4.setId(C12717b.inneractive_vast_endcard_gif);
        } else if (i5 == 2) {
            i4.setId(C12717b.inneractive_vast_endcard_html);
        } else if (i5 == 3) {
            i4.setId(C12717b.inneractive_vast_endcard_iframe);
        }
        C8034w.m18120a().mo24868a(context, (View) this.f15688a.i(), (C8039b) this.f15688a);
        this.f15688a.c(true);
        C7994ah a = a.a(i, i2, jVar);
        this.f15688a.setAdDefaultSize(a.f16318a, a.f16319b);
    }
}
