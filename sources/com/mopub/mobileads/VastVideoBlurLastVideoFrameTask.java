package com.mopub.mobileads;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.ImageUtils;

public class VastVideoBlurLastVideoFrameTask extends AsyncTask<String, Void, Boolean> {

    /* renamed from: a */
    private final MediaMetadataRetriever f35004a;

    /* renamed from: b */
    private final ImageView f35005b;

    /* renamed from: c */
    private int f35006c;

    /* renamed from: d */
    private Bitmap f35007d;

    /* renamed from: e */
    private Bitmap f35008e;

    public VastVideoBlurLastVideoFrameTask(MediaMetadataRetriever mediaMetadataRetriever, ImageView blurredLastVideoFrameImageView, int videoDuration) {
        this.f35004a = mediaMetadataRetriever;
        this.f35005b = blurredLastVideoFrameImageView;
        this.f35006c = videoDuration;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Boolean doInBackground(String... videoPaths) {
        Boolean valueOf = Boolean.valueOf(false);
        if (videoPaths == null || videoPaths.length == 0 || videoPaths[0] == null) {
            return valueOf;
        }
        try {
            this.f35004a.setDataSource(videoPaths[0]);
            this.f35007d = this.f35004a.getFrameAtTime((long) ((this.f35006c * 1000) - 200000), 3);
            if (this.f35007d == null) {
                return valueOf;
            }
            Bitmap bitmap = this.f35007d;
            ImageUtils.applyFastGaussianBlurToBitmap(bitmap, 4);
            this.f35008e = bitmap;
            return Boolean.valueOf(true);
        } catch (Exception e) {
            MoPubLog.log(SdkLogEvent.ERROR, "Failed to blur last video frame", e);
            return valueOf;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Boolean success) {
        if (isCancelled()) {
            onCancelled();
            return;
        }
        if (success != null && success.booleanValue()) {
            this.f35005b.setImageBitmap(this.f35008e);
            this.f35005b.setImageAlpha(100);
        }
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        MoPubLog.log(SdkLogEvent.CUSTOM, "VastVideoBlurLastVideoFrameTask was cancelled.");
    }
}
