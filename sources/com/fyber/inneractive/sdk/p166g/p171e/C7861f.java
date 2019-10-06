package com.fyber.inneractive.sdk.p166g.p171e;

import android.content.Context;
import android.widget.ImageView;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.C7994ah;
import com.fyber.inneractive.sdk.util.C8006j;

/* renamed from: com.fyber.inneractive.sdk.g.e.f */
public final class C7861f extends C7864i {
    public C7861f(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo24602a(C7994ah ahVar, int i, int i2) {
        if (ahVar != null) {
            UnitDisplayType unitDisplayType = this.f15864c;
            if (unitDisplayType == UnitDisplayType.SQUARE) {
                ahVar.f16318a = Math.min(i, this.f15862a) - C8006j.m18072b(this.f15863b.mo24210f().mo24218e().intValue() * 2);
                ahVar.f16319b = ahVar.f16318a;
            } else if (unitDisplayType == UnitDisplayType.LANDSCAPE) {
                ahVar.f16318a = Math.min(i, this.f15862a) - C8006j.m18072b(this.f15863b.mo24210f().mo24218e().intValue() * 2);
                ahVar.f16319b = (ahVar.f16318a * 9) / 16;
            } else if (unitDisplayType == UnitDisplayType.MRECT) {
                ahVar.f16318a = C8006j.m18072b(300);
                ahVar.f16319b = C8006j.m18072b(250);
            } else if (unitDisplayType != UnitDisplayType.DEFAULT || !this.f15888p) {
                ahVar.f16318a = 0;
                ahVar.f16319b = 0;
            } else {
                mo24618a(ahVar, this.f15886n, this.f15887o, i, i2);
            }
        }
    }

    /* renamed from: d */
    public final void mo24614d() {
        this.f15873A = new C7994ah(0, 0);
        if (this.f15864c == UnitDisplayType.SQUARE) {
            ImageView imageView = this.f15879g;
            if (imageView != null) {
                imageView.getLayoutParams().width = this.f15898z.f16318a;
                this.f15879g.getLayoutParams().height = this.f15898z.f16318a;
            }
            C7994ah ahVar = this.f15873A;
            int i = this.f15886n;
            int i2 = this.f15887o;
            int i3 = this.f15898z.f16318a;
            mo24618a(ahVar, i, i2, i3, i3);
            return;
        }
        C7994ah ahVar2 = this.f15873A;
        int i4 = this.f15886n;
        int i5 = this.f15887o;
        C7994ah ahVar3 = this.f15898z;
        mo24618a(ahVar2, i4, i5, ahVar3.f16318a, ahVar3.f16319b);
        ImageView imageView2 = this.f15879g;
        if (imageView2 != null) {
            imageView2.getLayoutParams().width = this.f15873A.f16318a;
            this.f15879g.getLayoutParams().height = this.f15873A.f16319b;
        }
    }
}
