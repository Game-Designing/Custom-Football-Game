package com.mopub.nativeads;

import android.widget.ImageView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader.ImageContainer;
import com.mopub.volley.toolbox.ImageLoader.ImageListener;

/* renamed from: com.mopub.nativeads.sa */
/* compiled from: NativeImageHelper */
class C11641sa implements ImageListener {

    /* renamed from: a */
    final /* synthetic */ ImageView f36232a;

    C11641sa(ImageView imageView) {
        this.f36232a = imageView;
    }

    public void onResponse(ImageContainer imageContainer, boolean isImmediate) {
        if (!isImmediate) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Image was not loaded immediately into your ad view. You should call preCacheImages as part of your custom event loading process.");
        }
        this.f36232a.setImageBitmap(imageContainer.getBitmap());
    }

    public void onErrorResponse(VolleyError volleyError) {
        MoPubLog.log(SdkLogEvent.CUSTOM, "Failed to load image.", volleyError);
        this.f36232a.setImageDrawable(null);
    }
}
