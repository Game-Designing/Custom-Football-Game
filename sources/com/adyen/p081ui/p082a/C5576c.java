package com.adyen.p081ui.p082a;

import android.graphics.Bitmap;
import p019d.p135a.p136a.p142e.C6907g.C6908a;

/* renamed from: com.adyen.ui.a.c */
/* compiled from: IssuerListAdapter */
class C5576c implements C6908a {

    /* renamed from: a */
    final /* synthetic */ C5578a f9384a;

    /* renamed from: b */
    final /* synthetic */ C5577d f9385b;

    C5576c(C5577d this$0, C5578a aVar) {
        this.f9385b = this$0;
        this.f9384a = aVar;
    }

    /* renamed from: a */
    public void mo17708a(Bitmap bitmap, String url) {
        if (url.equals(this.f9384a.f9391c)) {
            this.f9384a.f9390b.setImageBitmap(bitmap);
        }
    }
}
