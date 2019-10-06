package com.fyber.inneractive.sdk.p180ui;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.widget.VideoView;

/* renamed from: com.fyber.inneractive.sdk.ui.IArichMediaVideoViewCore */
public class IArichMediaVideoViewCore extends VideoView {

    /* renamed from: a */
    String f16281a;

    /* renamed from: com.fyber.inneractive.sdk.ui.IArichMediaVideoViewCore$BaseVideoViewListener */
    public interface BaseVideoViewListener {
        void onVideoCompleted(boolean z);

        void onVideoError(boolean z);
    }

    public IArichMediaVideoViewCore(Context context, Intent intent, final BaseVideoViewListener baseVideoViewListener) {
        super(context);
        setOnCompletionListener(new OnCompletionListener() {
            public final void onCompletion(MediaPlayer mediaPlayer) {
                BaseVideoViewListener baseVideoViewListener = baseVideoViewListener;
                if (baseVideoViewListener != null) {
                    baseVideoViewListener.onVideoCompleted(true);
                }
            }
        });
        setOnErrorListener(new OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                BaseVideoViewListener baseVideoViewListener = baseVideoViewListener;
                if (baseVideoViewListener != null) {
                    baseVideoViewListener.onVideoError(false);
                }
                return false;
            }
        });
        this.f16281a = intent.getStringExtra("video_url");
        setVideoPath(this.f16281a);
    }
}
