package com.fyber.inneractive.sdk.p166g.p171e;

import android.content.Context;
import android.view.View;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.C7994ah;
import com.fyber.inneractive.sdk.util.C8006j;

/* renamed from: com.fyber.inneractive.sdk.g.e.e */
public final class C7860e extends C7856b {

    /* renamed from: h */
    public static int f15872h = C8006j.m18072b(40);

    public C7860e(Context context, View view) {
        super(context, view);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo24602a(C7994ah ahVar, int i, int i2) {
        UnitDisplayType unitDisplayType = this.f15864c;
        if (unitDisplayType == UnitDisplayType.SQUARE) {
            ahVar.f16318a = Math.min(i, this.f15862a) - C8006j.m18072b(this.f15863b.mo24210f().mo24218e().intValue() * 2);
            ahVar.f16319b = ahVar.f16318a;
        } else if (unitDisplayType == UnitDisplayType.LANDSCAPE) {
            ahVar.f16318a = Math.min(i, this.f15862a) - C8006j.m18072b(this.f15863b.mo24210f().mo24218e().intValue() * 2);
            ahVar.f16319b = ((ahVar.f16318a * 9) / 16) + f15872h;
        } else if (unitDisplayType == UnitDisplayType.MRECT) {
            ahVar.f16318a = C8006j.m18072b(300);
            ahVar.f16319b = C8006j.m18072b(250);
        } else {
            ahVar.f16319b = 0;
            ahVar.f16318a = 0;
        }
    }
}
