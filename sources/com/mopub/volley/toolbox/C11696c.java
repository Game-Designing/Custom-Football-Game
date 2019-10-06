package com.mopub.volley.toolbox;

import android.graphics.Bitmap;
import com.mopub.volley.Response.Listener;

/* renamed from: com.mopub.volley.toolbox.c */
/* compiled from: ImageLoader */
class C11696c implements Listener<Bitmap> {

    /* renamed from: a */
    final /* synthetic */ String f36552a;

    /* renamed from: b */
    final /* synthetic */ ImageLoader f36553b;

    C11696c(ImageLoader this$0, String str) {
        this.f36553b = this$0;
        this.f36552a = str;
    }

    public void onResponse(Bitmap response) {
        this.f36553b.mo38457a(this.f36552a, response);
    }
}
