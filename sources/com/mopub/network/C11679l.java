package com.mopub.network;

import android.graphics.Bitmap;
import com.mopub.volley.toolbox.ImageLoader.ImageCache;
import p002b.p003c.p053g.p061f.C1260i;

/* renamed from: com.mopub.network.l */
/* compiled from: Networking */
class C11679l implements ImageCache {

    /* renamed from: a */
    final /* synthetic */ C1260i f36404a;

    C11679l(C1260i iVar) {
        this.f36404a = iVar;
    }

    public Bitmap getBitmap(String key) {
        return (Bitmap) this.f36404a.get(key);
    }

    public void putBitmap(String key, Bitmap bitmap) {
        this.f36404a.put(key, bitmap);
    }
}
