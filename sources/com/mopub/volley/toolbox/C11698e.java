package com.mopub.volley.toolbox;

import com.mopub.volley.toolbox.ImageLoader.ImageContainer;

/* renamed from: com.mopub.volley.toolbox.e */
/* compiled from: ImageLoader */
class C11698e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ImageLoader f36556a;

    C11698e(ImageLoader this$0) {
        this.f36556a = this$0;
    }

    public void run() {
        for (C11693a bir : this.f36556a.f36512e.values()) {
            for (ImageContainer container : bir.f36523d) {
                if (container.f36516b != null) {
                    if (bir.getError() == null) {
                        container.f36515a = bir.f36521b;
                        container.f36516b.onResponse(container, false);
                    } else {
                        container.f36516b.onErrorResponse(bir.getError());
                    }
                }
            }
        }
        this.f36556a.f36512e.clear();
        this.f36556a.f36514g = null;
    }
}
