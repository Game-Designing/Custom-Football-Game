package com.mopub.volley.toolbox;

import com.mopub.volley.toolbox.ImageLoader.ImageContainer;

/* renamed from: com.mopub.volley.toolbox.f */
/* compiled from: NetworkImageView */
class C11699f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ImageContainer f36557a;

    /* renamed from: b */
    final /* synthetic */ C11700g f36558b;

    C11699f(C11700g this$1, ImageContainer imageContainer) {
        this.f36558b = this$1;
        this.f36557a = imageContainer;
    }

    public void run() {
        this.f36558b.onResponse(this.f36557a, false);
    }
}
