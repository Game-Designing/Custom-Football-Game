package com.mopub.mobileads;

import android.graphics.Bitmap;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader.ImageContainer;
import com.mopub.volley.toolbox.ImageLoader.ImageListener;

/* renamed from: com.mopub.mobileads.Ka */
/* compiled from: VastVideoCloseButtonWidget */
class C11325Ka implements ImageListener {

    /* renamed from: a */
    final /* synthetic */ String f34822a;

    /* renamed from: b */
    final /* synthetic */ VastVideoCloseButtonWidget f34823b;

    C11325Ka(VastVideoCloseButtonWidget this$0, String str) {
        this.f34823b = this$0;
        this.f34822a = str;
    }

    public void onResponse(ImageContainer imageContainer, boolean isImmediate) {
        Bitmap bitmap = imageContainer.getBitmap();
        if (bitmap != null) {
            this.f34823b.f35010b.setImageBitmap(bitmap);
            return;
        }
        MoPubLog.log(SdkLogEvent.CUSTOM, String.format("%s returned null bitmap", new Object[]{this.f34822a}));
    }

    public void onErrorResponse(VolleyError volleyError) {
        MoPubLog.log(SdkLogEvent.ERROR, "Failed to load image.", volleyError);
    }
}
