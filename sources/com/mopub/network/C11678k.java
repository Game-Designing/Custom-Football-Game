package com.mopub.network;

import android.graphics.Bitmap;
import p002b.p003c.p053g.p061f.C1260i;

/* renamed from: com.mopub.network.k */
/* compiled from: Networking */
class C11678k extends C1260i<String, Bitmap> {
    C11678k(int x0) {
        super(x0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo9066a(String key, Bitmap value) {
        if (value != null) {
            return value.getRowBytes() * value.getHeight();
        }
        return super.mo9066a(key, value);
    }
}
