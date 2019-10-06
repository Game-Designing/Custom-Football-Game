package com.mopub.nativeads;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.nativeads.MoPubCustomEventVideoNative.MoPubVideoNativeAd;
import com.mopub.nativeads.MoPubCustomEventVideoNative.MoPubVideoNativeAd.VideoState;

/* renamed from: com.mopub.nativeads.S */
/* compiled from: MoPubCustomEventVideoNative */
class C11566S implements SurfaceTextureListener {

    /* renamed from: a */
    final /* synthetic */ MoPubVideoNativeAd f36028a;

    C11566S(MoPubVideoNativeAd this$0) {
        this.f36028a = this$0;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        this.f36028a.f35849w.setListener(this.f36028a);
        this.f36028a.f35849w.setOnAudioFocusChangeListener(this.f36028a);
        this.f36028a.f35849w.setProgressListener(this.f36028a);
        this.f36028a.f35849w.setTextureView(this.f36028a.f35852z.getTextureView());
        this.f36028a.f35852z.resetProgress();
        long duration = this.f36028a.f35849w.getDuration();
        long currentPosition = this.f36028a.f35849w.getCurrentPosition();
        if (this.f36028a.f35836G == 4 || (duration > 0 && duration - currentPosition < 750)) {
            this.f36028a.f35840K = true;
        }
        if (this.f36028a.f35833D) {
            this.f36028a.f35833D = false;
            this.f36028a.f35849w.prepare(this.f36028a);
        }
        this.f36028a.f35832C = true;
        this.f36028a.m38249i();
        if (this.f36028a.f35843q == VideoState.PLAYING || this.f36028a.f35843q == VideoState.PLAYING_MUTED) {
            MoPubLog.log(AdapterLogEvent.SHOW_SUCCESS, MoPubCustomEventVideoNative.ADAPTER_NAME);
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        this.f36028a.f35833D = true;
        this.f36028a.f35849w.release(this.f36028a);
        this.f36028a.mo37915a(VideoState.PAUSED);
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
    }
}
