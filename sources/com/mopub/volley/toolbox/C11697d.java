package com.mopub.volley.toolbox;

import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.VolleyError;

/* renamed from: com.mopub.volley.toolbox.d */
/* compiled from: ImageLoader */
class C11697d implements ErrorListener {

    /* renamed from: a */
    final /* synthetic */ String f36554a;

    /* renamed from: b */
    final /* synthetic */ ImageLoader f36555b;

    C11697d(ImageLoader this$0, String str) {
        this.f36555b = this$0;
        this.f36554a = str;
    }

    public void onErrorResponse(VolleyError error) {
        this.f36555b.mo38458a(this.f36554a, error);
    }
}
