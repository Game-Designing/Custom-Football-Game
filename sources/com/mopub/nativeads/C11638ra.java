package com.mopub.nativeads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader.ImageContainer;
import com.mopub.volley.toolbox.ImageLoader.ImageListener;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.mopub.nativeads.ra */
/* compiled from: NativeImageHelper */
class C11638ra implements ImageListener {

    /* renamed from: a */
    final /* synthetic */ AtomicInteger f36225a;

    /* renamed from: b */
    final /* synthetic */ AtomicBoolean f36226b;

    /* renamed from: c */
    final /* synthetic */ NativeImageHelper.ImageListener f36227c;

    C11638ra(AtomicInteger atomicInteger, AtomicBoolean atomicBoolean, NativeImageHelper.ImageListener imageListener) {
        this.f36225a = atomicInteger;
        this.f36226b = atomicBoolean;
        this.f36227c = imageListener;
    }

    public void onResponse(ImageContainer imageContainer, boolean isImmediate) {
        if (imageContainer.getBitmap() != null && this.f36225a.decrementAndGet() == 0 && !this.f36226b.get()) {
            this.f36227c.onImagesCached();
        }
    }

    public void onErrorResponse(VolleyError volleyError) {
        MoPubLog.log(SdkLogEvent.ERROR, "Failed to download a native ads image:", volleyError);
        boolean anyPreviousErrors = this.f36226b.getAndSet(true);
        this.f36225a.decrementAndGet();
        if (!anyPreviousErrors) {
            this.f36227c.onImagesFailedToCache(NativeErrorCode.IMAGE_DOWNLOAD_FAILURE);
        }
    }
}
