package com.bumptech.glide.p103f.p104a;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.p100c.C5937j;
import com.bumptech.glide.p103f.C5986c;
import com.bumptech.glide.p103f.p105b.C5983b;

/* renamed from: com.bumptech.glide.f.a.i */
/* compiled from: Target */
public interface C5976i<R> extends C5937j {
    C5986c getRequest();

    void getSize(C5975h hVar);

    void onLoadCleared(Drawable drawable);

    void onLoadFailed(Drawable drawable);

    void onLoadStarted(Drawable drawable);

    void onResourceReady(R r, C5983b<? super R> bVar);

    void removeCallback(C5975h hVar);

    void setRequest(C5986c cVar);
}
