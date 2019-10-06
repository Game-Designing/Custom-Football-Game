package com.mopub.nativeads;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Bundle;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.VideoView;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.mobileads.BaseVideoViewController;
import com.mopub.mobileads.BaseVideoViewController.BaseVideoViewControllerListener;
import com.mopub.mobileads.VastVideoConfig;
import com.mopub.nativeads.NativeFullScreenVideoView.Mode;
import com.mopub.nativeads.NativeVideoController.Listener;

public class NativeVideoViewController extends BaseVideoViewController implements SurfaceTextureListener, Listener, OnAudioFocusChangeListener {

    /* renamed from: e */
    private C11558a f35994e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public VastVideoConfig f35995f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final NativeFullScreenVideoView f35996g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final NativeVideoController f35997h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Bitmap f35998i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f35999j;

    /* renamed from: k */
    private boolean f36000k;

    /* renamed from: l */
    private int f36001l;

    /* renamed from: com.mopub.nativeads.NativeVideoViewController$a */
    enum C11558a {
        NONE,
        LOADING,
        BUFFERING,
        PAUSED,
        PLAYING,
        ENDED,
        FAILED_LOAD
    }

    public NativeVideoViewController(Context context, Bundle intentExtras, Bundle savedInstanceState, BaseVideoViewControllerListener baseVideoViewControllerListener) {
        this(context, intentExtras, savedInstanceState, baseVideoViewControllerListener, new NativeFullScreenVideoView(context, context.getResources().getConfiguration().orientation, ((VastVideoConfig) intentExtras.get(Constants.NATIVE_VAST_VIDEO_CONFIG)).getCustomCtaText()));
    }

    @VisibleForTesting
    NativeVideoViewController(Context context, Bundle intentExtras, Bundle savedInstanceState, BaseVideoViewControllerListener baseVideoViewControllerListener, NativeFullScreenVideoView fullScreenVideoView) {
        super(context, null, baseVideoViewControllerListener);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(intentExtras);
        Preconditions.checkNotNull(baseVideoViewControllerListener);
        Preconditions.checkNotNull(fullScreenVideoView);
        this.f35994e = C11558a.NONE;
        this.f35995f = (VastVideoConfig) intentExtras.get(Constants.NATIVE_VAST_VIDEO_CONFIG);
        this.f35996g = fullScreenVideoView;
        this.f35997h = NativeVideoController.getForId(((Long) intentExtras.get(Constants.NATIVE_VIDEO_ID)).longValue());
        Preconditions.checkNotNull(this.f35995f);
        Preconditions.checkNotNull(this.f35997h);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public VideoView mo36932c() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo36934e() {
        this.f35996g.setSurfaceTextureListener(this);
        this.f35996g.setMode(Mode.LOADING);
        this.f35996g.setPlayControlClickListener(new C11659ya(this));
        this.f35996g.setCloseControlListener(new C11662za(this));
        this.f35996g.setCtaClickListener(new C11511Aa(this));
        this.f35996g.setPrivacyInformationClickListener(new C11515Ba(this));
        this.f35996g.setPrivacyInformationIconImageUrl(this.f35995f.getPrivacyInformationIconImageUrl());
        this.f35996g.setLayoutParams(new LayoutParams(-1, -1));
        mo36923a().onSetContentView(this.f35996g);
        this.f35997h.setProgressListener(new C11518Ca(this));
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo36938h() {
        Bitmap bitmap = this.f35998i;
        if (bitmap != null) {
            this.f35996g.setCachedVideoFrame(bitmap);
        }
        this.f35997h.prepare(this);
        this.f35997h.setListener(this);
        this.f35997h.setOnAudioFocusChangeListener(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo36936g() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo36935f() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36926a(Bundle outState) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36925a(Configuration configuration) {
        this.f35996g.setOrientation(configuration.orientation);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo36933d() {
        mo38056a(C11558a.PAUSED, true);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        this.f35997h.setTextureView(this.f35996g.getTextureView());
        if (!this.f35999j) {
            NativeVideoController nativeVideoController = this.f35997h;
            nativeVideoController.seekTo(nativeVideoController.getCurrentPosition());
        }
        this.f35997h.setPlayWhenReady(!this.f35999j);
        if (this.f35997h.getDuration() - this.f35997h.getCurrentPosition() < 750) {
            this.f35999j = true;
            m38340i();
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        this.f35997h.release(this);
        mo38055a(C11558a.PAUSED);
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
    }

    public void onStateChanged(boolean playWhenReady, int playbackState) {
        this.f36001l = playbackState;
        m38340i();
    }

    public void onError(Exception e) {
        MoPubLog.log(SdkLogEvent.ERROR, "Error playing back video.", e);
        this.f36000k = true;
        m38340i();
    }

    public void onAudioFocusChange(int focusChange) {
        if (focusChange == -1 || focusChange == -2) {
            mo38055a(C11558a.PAUSED);
        } else if (focusChange == -3) {
            this.f35997h.setAudioVolume(0.3f);
        } else if (focusChange == 1) {
            this.f35997h.setAudioVolume(1.0f);
            m38340i();
        }
    }

    /* renamed from: i */
    private void m38340i() {
        C11558a newState = this.f35994e;
        if (this.f36000k) {
            newState = C11558a.FAILED_LOAD;
        } else if (this.f35999j) {
            newState = C11558a.ENDED;
        } else {
            int i = this.f36001l;
            if (i == 1) {
                newState = C11558a.LOADING;
            } else if (i == 2) {
                newState = C11558a.BUFFERING;
            } else if (i == 3) {
                newState = C11558a.PLAYING;
            } else if (i == 4 || i == 5) {
                newState = C11558a.ENDED;
            }
        }
        mo38055a(newState);
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo38055a(C11558a videoState) {
        mo38056a(videoState, false);
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo38056a(C11558a videoState, boolean transitionToInline) {
        Preconditions.checkNotNull(videoState);
        if (this.f35994e != videoState) {
            switch (C11521Da.f35624a[videoState.ordinal()]) {
                case 1:
                    this.f35997h.setPlayWhenReady(false);
                    this.f35997h.setAudioEnabled(false);
                    this.f35997h.setAppAudioEnabled(false);
                    this.f35996g.setMode(Mode.LOADING);
                    this.f35995f.handleError(mo36929b(), null, 0);
                    break;
                case 2:
                case 3:
                    this.f35997h.setPlayWhenReady(true);
                    this.f35996g.setMode(Mode.LOADING);
                    break;
                case 4:
                    this.f35997h.setPlayWhenReady(true);
                    this.f35997h.setAudioEnabled(true);
                    this.f35997h.setAppAudioEnabled(true);
                    this.f35996g.setMode(Mode.PLAYING);
                    break;
                case 5:
                    if (!transitionToInline) {
                        this.f35997h.setAppAudioEnabled(false);
                    }
                    this.f35997h.setPlayWhenReady(false);
                    this.f35996g.setMode(Mode.PAUSED);
                    break;
                case 6:
                    this.f35999j = true;
                    this.f35997h.setAppAudioEnabled(false);
                    this.f35996g.updateProgress(1000);
                    this.f35996g.setMode(Mode.FINISHED);
                    this.f35995f.handleComplete(mo36929b(), 0);
                    break;
            }
            this.f35994e = videoState;
        }
    }
}
