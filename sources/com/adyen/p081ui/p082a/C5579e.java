package com.adyen.p081ui.p082a;

import android.graphics.Bitmap;
import p019d.p135a.p136a.p142e.C6907g.C6908a;

/* renamed from: com.adyen.ui.a.e */
/* compiled from: PaymentListAdapter */
class C5579e implements C6908a {

    /* renamed from: a */
    final /* synthetic */ C5581a f9392a;

    /* renamed from: b */
    final /* synthetic */ C5580f f9393b;

    C5579e(C5580f this$0, C5581a aVar) {
        this.f9393b = this$0;
        this.f9392a = aVar;
    }

    /* renamed from: a */
    public void mo17708a(Bitmap bitmap, String url) {
        if (url.equals(this.f9392a.f9400c)) {
            this.f9392a.f9399b.setImageBitmap(bitmap);
        }
    }
}
