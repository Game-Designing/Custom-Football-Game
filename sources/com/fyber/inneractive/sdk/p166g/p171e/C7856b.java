package com.fyber.inneractive.sdk.p166g.p171e;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import com.fyber.inneractive.sdk.p166g.p171e.C7854a.C7855a;
import com.fyber.inneractive.sdk.util.C7994ah;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;

/* renamed from: com.fyber.inneractive.sdk.g.e.b */
public abstract class C7856b extends C7854a {

    /* renamed from: g */
    public View f15868g;

    /* renamed from: h */
    private C7855a f15869h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C7994ah f15870i = new C7994ah(0, 0);

    public C7856b(Context context, View view) {
        super(context);
        this.f15868g = view;
        setBackgroundColor(CtaButton.BACKGROUND_COLOR);
    }

    /* renamed from: a */
    public final void mo24601a() {
        super.mo24601a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        mo24602a(this.f15870i, MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
        post(new Runnable() {
            public final void run() {
                C7856b bVar = C7856b.this;
                bVar.f15868g.measure(MeasureSpec.makeMeasureSpec(bVar.f15870i.f16318a, 1073741824), MeasureSpec.makeMeasureSpec(C7856b.this.f15870i.f16319b, 1073741824));
                C7856b.this.f15868g.invalidate();
            }
        });
        C7994ah ahVar = this.f15870i;
        int i3 = ahVar.f16318a;
        if (!(i3 == 0 || ahVar.f16319b == 0)) {
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i3, 1073741824);
            i2 = MeasureSpec.makeMeasureSpec(this.f15870i.f16319b, 1073741824);
            i = makeMeasureSpec;
        }
        super.onMeasure(i, i2);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        C7855a aVar = this.f15869h;
        if (aVar != null) {
            aVar.mo24528g();
        }
    }

    public void setOnWindowFocusChangedListener(C7855a aVar) {
        this.f15869h = aVar;
    }
}
