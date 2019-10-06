package com.mopub.mobileads;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask.Status;
import android.widget.ImageView;
import android.widget.VideoView;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.AsyncTasks;

public class VastVideoView extends VideoView {

    /* renamed from: a */
    private VastVideoBlurLastVideoFrameTask f35070a;

    /* renamed from: b */
    private MediaMetadataRetriever f35071b = new MediaMetadataRetriever();

    public VastVideoView(Context context) {
        super(context);
        Preconditions.checkNotNull(context, "context cannot be null");
    }

    public void prepareBlurredLastVideoFrame(ImageView blurredLastVideoFrameImageView, String diskMediaFileUrl) {
        MediaMetadataRetriever mediaMetadataRetriever = this.f35071b;
        if (mediaMetadataRetriever != null) {
            this.f35070a = new VastVideoBlurLastVideoFrameTask(mediaMetadataRetriever, blurredLastVideoFrameImageView, getDuration());
            try {
                AsyncTasks.safeExecuteOnExecutor(this.f35070a, diskMediaFileUrl);
            } catch (Exception e) {
                MoPubLog.log(SdkLogEvent.ERROR, "Failed to blur last video frame", e);
            }
        }
    }

    public void onDestroy() {
        VastVideoBlurLastVideoFrameTask vastVideoBlurLastVideoFrameTask = this.f35070a;
        if (vastVideoBlurLastVideoFrameTask != null && vastVideoBlurLastVideoFrameTask.getStatus() != Status.FINISHED) {
            this.f35070a.cancel(true);
        }
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    @VisibleForTesting
    public void setMediaMetadataRetriever(MediaMetadataRetriever mediaMetadataRetriever) {
        this.f35071b = mediaMetadataRetriever;
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    @VisibleForTesting
    public VastVideoBlurLastVideoFrameTask getBlurLastVideoFrameTask() {
        return this.f35070a;
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    @VisibleForTesting
    public void setBlurLastVideoFrameTask(VastVideoBlurLastVideoFrameTask blurLastVideoFrameTask) {
        this.f35070a = blurLastVideoFrameTask;
    }
}
