package com.fyber.inneractive.sdk.p166g.p171e;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.C7994ah;

/* renamed from: com.fyber.inneractive.sdk.g.e.d */
public final class C7859d extends C7864i {
    public C7859d(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo24602a(C7994ah ahVar, int i, int i2) {
        if (this.f15864c == UnitDisplayType.DEFAULT && this.f15888p) {
            mo24618a(ahVar, this.f15886n, this.f15887o, i, i2);
        }
        ahVar.f16318a = 0;
        ahVar.f16319b = 0;
    }

    /* renamed from: d */
    public final void mo24614d() {
        this.f15873A = new C7994ah(0, 0);
        if (this.f15864c == UnitDisplayType.SQUARE) {
            int min = Math.min(this.f15898z.f16318a, this.f15862a);
            ViewGroup viewGroup = this.f15880h;
            if (viewGroup != null) {
                viewGroup.getLayoutParams().width = min;
                this.f15880h.getLayoutParams().height = min;
            }
            ImageView imageView = this.f15879g;
            if (imageView != null) {
                imageView.getLayoutParams().width = min;
                this.f15879g.getLayoutParams().height = min;
            }
            mo24618a(this.f15873A, this.f15886n, this.f15887o, min, min);
            return;
        }
        C7994ah ahVar = this.f15873A;
        int i = this.f15886n;
        int i2 = this.f15887o;
        C7994ah ahVar2 = this.f15898z;
        mo24618a(ahVar, i, i2, ahVar2.f16318a, ahVar2.f16319b);
        ImageView imageView2 = this.f15879g;
        if (imageView2 != null) {
            imageView2.getLayoutParams().width = this.f15873A.f16318a;
            this.f15879g.getLayoutParams().height = this.f15873A.f16319b;
        }
    }
}
