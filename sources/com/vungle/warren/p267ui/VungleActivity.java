package com.vungle.warren.p267ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.moat.analytics.mobile.vng.ReactiveVideoTracker;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import com.vungle.warren.AdvertisementPresenterFactory;
import com.vungle.warren.Vungle;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.presenter.AdvertisementPresenter;
import com.vungle.warren.presenter.AdvertisementPresenter.EventListener;
import com.vungle.warren.utility.ExternalRouter;
import com.vungle.warren.utility.ViewUtility;
import com.vungle.warren.utility.ViewUtility.Asset;
import java.util.Locale;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;

/* renamed from: com.vungle.warren.ui.VungleActivity */
public class VungleActivity extends Activity implements AdView, OnPreparedListener, OnErrorListener {
    protected static final double NINE_BY_SIXTEEN_ASPECT_RATIO = 0.5625d;
    public static final String PLACEMENT_EXTRA = "placement";
    private static final String TAG = "VungleActivity";
    private static EventListener bus;
    private BroadcastReceiver broadcastReciever;
    private ImageView closeButton;
    /* access modifiers changed from: private */
    public ImageView ctaOverlay;
    /* access modifiers changed from: private */
    public AlertDialog dialog;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    /* access modifiers changed from: private */
    public MediaPlayer mediaPlayer;
    /* access modifiers changed from: private */
    public ImageView muteButton;
    /* access modifiers changed from: private */
    public boolean muted = false;
    /* access modifiers changed from: private */
    public boolean pendingPause;
    private String placementId;
    /* access modifiers changed from: private */
    public AdvertisementPresenter presenter;
    private AdvertisementPresenterFactory presenterFactory;
    private ImageView privacyOverlay;
    /* access modifiers changed from: private */
    public ProgressBar progressBar;
    private boolean released = false;
    /* access modifiers changed from: private */
    public Runnable reportProgress;
    private int videoPosition = 0;
    /* access modifiers changed from: private */
    public VideoView videoView;
    private ReactiveVideoTracker viewabilityTracker;
    /* access modifiers changed from: private */
    public WebView webView;

    public static void setEventListener(EventListener listener) {
        bus = listener;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(Bundle savedInstanceState) {
        Bundle bundle = savedInstanceState;
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(16777216, 16777216);
        Resources resources = getResources();
        RelativeLayout parentLayout = new RelativeLayout(this);
        LayoutParams matchParentLayoutParams = new LayoutParams(-1, -1);
        parentLayout.setLayoutParams(matchParentLayoutParams);
        this.videoView = new VideoView(this);
        LayoutParams videoViewLayoutParams = new LayoutParams(-1, -1);
        videoViewLayoutParams.addRule(13);
        this.videoView.setLayoutParams(videoViewLayoutParams);
        parentLayout.addView(this.videoView, videoViewLayoutParams);
        this.webView = new WebView(this);
        this.webView.setLayoutParams(matchParentLayoutParams);
        parentLayout.addView(this.webView, matchParentLayoutParams);
        this.progressBar = new ProgressBar(this, null, 16842872);
        LayoutParams progressBarLayoutParams = new LayoutParams(-1, (int) TypedValue.applyDimension(1, 4.0f, resources.getDisplayMetrics()));
        progressBarLayoutParams.addRule(12);
        this.progressBar.setLayoutParams(progressBarLayoutParams);
        this.progressBar.setMax(100);
        this.progressBar.setIndeterminate(false);
        this.progressBar.setVisibility(4);
        parentLayout.addView(this.progressBar);
        int imageViewDimension = (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics());
        LayoutParams imageViewLayoutParams = new LayoutParams(imageViewDimension, imageViewDimension);
        int imageViewMargin = (int) TypedValue.applyDimension(1, 12.0f, resources.getDisplayMetrics());
        imageViewLayoutParams.setMargins(imageViewMargin, imageViewMargin, imageViewMargin, imageViewMargin);
        this.muteButton = new ImageView(this);
        this.muteButton.setImageBitmap(ViewUtility.getBitmap(Asset.unMute, this));
        this.muteButton.setLayoutParams(imageViewLayoutParams);
        this.muteButton.setVisibility(8);
        parentLayout.addView(this.muteButton);
        LayoutParams closeLayoutParams = new LayoutParams(imageViewDimension, imageViewDimension);
        closeLayoutParams.setMargins(imageViewMargin, imageViewMargin, imageViewMargin, imageViewMargin);
        this.closeButton = new ImageView(this);
        this.closeButton.setImageBitmap(ViewUtility.getBitmap(Asset.close, this));
        closeLayoutParams.addRule(11);
        this.closeButton.setLayoutParams(closeLayoutParams);
        this.closeButton.setVisibility(8);
        parentLayout.addView(this.closeButton);
        LayoutParams ctaOverlayLayoutParams = new LayoutParams(imageViewDimension, imageViewDimension);
        ctaOverlayLayoutParams.addRule(12);
        ctaOverlayLayoutParams.addRule(11);
        ctaOverlayLayoutParams.setMargins(imageViewMargin, imageViewMargin, imageViewMargin, imageViewMargin);
        this.ctaOverlay = new ImageView(this);
        this.ctaOverlay.setLayoutParams(ctaOverlayLayoutParams);
        this.ctaOverlay.setVisibility(8);
        parentLayout.addView(this.ctaOverlay);
        LayoutParams privacyLayoutParams = new LayoutParams(imageViewDimension, imageViewDimension);
        privacyLayoutParams.addRule(12);
        privacyLayoutParams.addRule(9);
        privacyLayoutParams.setMargins(imageViewMargin, imageViewMargin, imageViewMargin, imageViewMargin);
        this.privacyOverlay = new ImageView(this);
        this.privacyOverlay.setLayoutParams(privacyLayoutParams);
        this.privacyOverlay.setVisibility(8);
        parentLayout.addView(this.privacyOverlay);
        setContentView(parentLayout, matchParentLayoutParams);
        if (!Vungle.isInitialized()) {
            Resources resources2 = resources;
        } else if (bus == null) {
            int i = imageViewMargin;
            Resources resources3 = resources;
        } else {
            String str = "userID";
            String user = getIntent().hasExtra(str) ? getIntent().getStringExtra(str) : null;
            int i2 = imageViewMargin;
            this.placementId = getIntent().getStringExtra(PLACEMENT_EXTRA);
            this.presenterFactory = new AdvertisementPresenterFactory();
            this.presenter = this.presenterFactory.getAdPresenter(this.placementId, bundle, user);
            AdvertisementPresenter advertisementPresenter = this.presenter;
            if (advertisementPresenter == null) {
                EventListener eventListener = bus;
                if (eventListener != null) {
                    Resources resources4 = resources;
                    eventListener.onError(new VungleException(10));
                }
                finish();
                return;
            }
            advertisementPresenter.setEventListener(bus);
            this.presenter.attach(this);
            this.presenter.prepare(bundle);
            prepare(savedInstanceState);
            return;
        }
        finish();
    }

    private void prepare(Bundle savedInstanceState) {
        this.videoView.setOnPreparedListener(this);
        this.webView.setWebViewClient(this.presenter.getWebViewClient());
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.addJavascriptInterface(new JavascriptBridge(this.presenter), "Android");
        if (VERSION.SDK_INT >= 17) {
            this.webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        this.videoView.setVisibility(8);
        this.webView.setVisibility(8);
    }

    private void connectBroadcastReceiver() {
        this.broadcastReciever = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String command = intent.getStringExtra("command");
                if (((command.hashCode() == -482896367 && command.equals("closeFlex")) ? (char) 0 : 65535) == 0) {
                    if (VungleActivity.this.presenter.handleExit(intent.getStringExtra(VungleActivity.PLACEMENT_EXTRA))) {
                        VungleActivity.this.close();
                        return;
                    }
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("No such command ");
                sb.append(command);
                throw new IllegalArgumentException(sb.toString());
            }
        };
        registerReceiver(this.broadcastReciever, new IntentFilter("AdvertisementBus"));
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        connectBroadcastReceiver();
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        VideoView videoView2 = this.videoView;
        if (videoView2 != null) {
            videoView2.seekTo(this.videoPosition);
        }
        setupPlayerProgressBar();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        Runnable runnable = this.reportProgress;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        unregisterReceiver(this.broadcastReciever);
        super.onStop();
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            resumeAd();
        } else {
            pauseAd();
        }
    }

    private void pauseAd() {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.onPause();
        }
        if (!this.released && this.videoView.isPlaying()) {
            this.videoView.pause();
            this.videoPosition = this.videoView.getCurrentPosition();
        }
        this.presenter.stop(isChangingConfigurations(), isFinishing());
    }

    private void resumeAd() {
        setImmersiveMode();
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.onResume();
        }
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            return;
        }
        if (this.videoView.isPlaying() || this.mediaPlayer == null) {
            this.presenter.play();
            return;
        }
        this.videoView.requestFocus();
        this.videoView.seekTo(this.videoPosition);
        this.videoView.start();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int i = newConfig.orientation;
        String str = TAG;
        if (i == 2) {
            Log.d(str, "landscape");
        } else if (i == 1) {
            Log.d(str, "portrait");
        }
        this.presenter.notifyPropertiesChanged();
    }

    @SuppressLint({"ResourceType"})
    public void onBackPressed() {
        if (this.presenter.handleExit(null)) {
            close();
        }
    }

    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        if (savedInstanceState != null) {
            this.videoPosition = savedInstanceState.getInt("videoPosition");
        }
    }

    public void onPrepared(MediaPlayer mp) {
        this.mediaPlayer = mp;
        this.muteButton.setVisibility(0);
        if (this.muted) {
            setVolume(0.0f, 0.0f);
        }
        mp.seekTo(this.videoPosition);
        mp.start();
        this.presenter.initializeViewabilityTracker(mp.getDuration(), this.videoView);
        mp.setOnCompletionListener(new OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                Log.d(VungleActivity.TAG, "mediaplayer onCompletion");
                if (VungleActivity.this.reportProgress != null) {
                    VungleActivity.this.handler.removeCallbacks(VungleActivity.this.reportProgress);
                }
                VungleActivity.this.presenter.onProgressUpdate(100);
                VungleActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        VungleActivity.this.muteButton.setEnabled(false);
                        VungleActivity.this.presenter.stopViewabilityTracker();
                    }
                });
            }
        });
        mp.setOnErrorListener(new OnErrorListener() {
            public boolean onError(MediaPlayer mp, int what, int extra) {
                if (what == 100 || what != 200) {
                }
                return true;
            }
        });
        this.presenter.reportAction("videoLength", String.format(Locale.ENGLISH, "%d", new Object[]{Integer.valueOf(mp.getDuration())}));
        setupPlayerProgressBar();
        if (!this.pendingPause) {
            AlertDialog alertDialog = this.dialog;
            if (alertDialog == null || !alertDialog.isShowing()) {
                return;
            }
        }
        this.pendingPause = false;
        this.videoView.pause();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
        this.presenter.generateSaveState(outState);
        this.presenterFactory.saveState(outState);
        if (this.videoView != null) {
            outState.putInt("videoPosition", this.videoPosition);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        StringBuilder sb = new StringBuilder();
        sb.append("onRestoreInstanceState(");
        sb.append(savedInstanceState);
        sb.append(")");
        Log.d(TAG, sb.toString());
        this.presenter.restoreFromSave(savedInstanceState);
        if (savedInstanceState != null) {
            this.videoPosition = savedInstanceState.getInt("videoPosition", 0);
        }
    }

    public void updateWindow(boolean isFlexView) {
        if (isFlexView) {
            DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            int heightPixels = metrics.heightPixels;
            int widthPixels = metrics.widthPixels;
            int orientation = getResources().getConfiguration().orientation;
            LayoutParams params = null;
            if (orientation == 1) {
                getWindow().setGravity(83);
                Window window = getWindow();
                double d = (double) widthPixels;
                Double.isNaN(d);
                window.setLayout(widthPixels, (int) Math.round(d * NINE_BY_SIXTEEN_ASPECT_RATIO));
                double d2 = (double) widthPixels;
                Double.isNaN(d2);
                params = new LayoutParams(widthPixels, (int) (d2 * NINE_BY_SIXTEEN_ASPECT_RATIO));
            } else if (orientation == 2) {
                Window window2 = getWindow();
                double d3 = (double) heightPixels;
                Double.isNaN(d3);
                window2.setLayout((int) Math.round(d3 * NINE_BY_SIXTEEN_ASPECT_RATIO), heightPixels);
                getWindow().setGravity(85);
                double d4 = (double) heightPixels;
                Double.isNaN(d4);
                params = new LayoutParams((int) Math.round(d4 * NINE_BY_SIXTEEN_ASPECT_RATIO), heightPixels);
                params.addRule(11, -1);
            }
            this.webView.setLayoutParams(params);
            getWindow().addFlags(288);
            return;
        }
        getWindow().setFlags(Opcodes.ACC_ABSTRACT, Opcodes.ACC_ABSTRACT);
        getWindow().getDecorView().setBackgroundColor(CtaButton.BACKGROUND_COLOR);
    }

    public void setVisibility(boolean isVisible) {
    }

    public boolean onError(MediaPlayer mediaPlayer2, int what, int extra) {
        StringBuilder description = new StringBuilder();
        if (what == 1) {
            description.append("MEDIA_ERROR_UNKNOWN");
        } else if (what != 100) {
            description.append("UNKNOWN");
        } else {
            description.append("MEDIA_ERROR_SERVER_DIED");
        }
        description.append(":");
        if (extra == -1010) {
            description.append("MEDIA_ERROR_UNSUPPORTED");
        } else if (extra == -1007) {
            description.append("MEDIA_ERROR_MALFORMED");
        } else if (extra == -1004) {
            description.append("MEDIA_ERROR_IO");
        } else if (extra == -110) {
            description.append("MEDIA_ERROR_TIMED_OUT");
        } else if (extra != 200) {
            description.append("MEDIA_ERROR_SYSTEM");
        } else {
            description.append("MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK");
        }
        this.presenter.reportError(description.toString());
        return true;
    }

    public void setOrientation(int orientation) {
        StringBuilder sb = new StringBuilder();
        sb.append(" requested orientation ");
        sb.append(orientation);
        Log.d(TAG, sb.toString());
        if (canRotate()) {
            setRequestedOrientation(orientation);
        }
    }

    /* access modifiers changed from: protected */
    public boolean canRotate() {
        return true;
    }

    public void playVideo(Uri uri, boolean startMuted) {
        this.videoView.setVisibility(0);
        this.videoView.setOnErrorListener(this);
        this.videoView.setVideoURI(uri);
        this.muted = startMuted;
        if (this.muted) {
            this.presenter.reportAction("mute", "true");
        }
        final Bitmap muteBitmap = ViewUtility.getBitmap(Asset.mute, this);
        final Bitmap unMuteBitmap = ViewUtility.getBitmap(Asset.unMute, this);
        this.privacyOverlay.setImageBitmap(ViewUtility.getBitmap(Asset.privacy, this));
        this.privacyOverlay.setVisibility(0);
        this.privacyOverlay.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                try {
                    ExternalRouter.launch("https://vungle.com/privacy/", VungleActivity.this);
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unable to start activity ");
                    sb.append(e.getLocalizedMessage());
                    Log.e(VungleActivity.TAG, sb.toString());
                }
            }
        });
        this.muteButton.setImageBitmap(this.muted ? muteBitmap : unMuteBitmap);
        final AudioManager audioManager = (AudioManager) getSystemService("audio");
        this.muteButton.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (VungleActivity.this.mediaPlayer != null) {
                    if (VungleActivity.this.muted) {
                        float currentVolume = ((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3));
                        VungleActivity.this.setVolume(currentVolume, currentVolume);
                        VungleActivity.this.muted = false;
                        VungleActivity.this.presenter.reportAction("unmute", AdultContentAnalytics.UNLOCK);
                    } else {
                        VungleActivity.this.setVolume(0.0f, 0.0f);
                        VungleActivity.this.muted = true;
                        VungleActivity.this.presenter.reportAction("mute", "true");
                    }
                    VungleActivity.this.muteButton.setImageBitmap(VungleActivity.this.muted ? muteBitmap : unMuteBitmap);
                }
            }
        });
        this.progressBar.setVisibility(0);
        this.progressBar.setMax(this.videoView.getDuration());
        this.closeButton.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                VungleActivity.this.onBackPressed();
            }
        });
    }

    /* access modifiers changed from: private */
    public void setVolume(float leftVolume, float rightVolume) {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            try {
                mediaPlayer2.setVolume(leftVolume, rightVolume);
            } catch (IllegalStateException e) {
                Log.i(TAG, "exception on mute", e);
            }
        }
    }

    public void showWebsite(String url) {
        StringBuilder sb = new StringBuilder();
        sb.append("loadJs: ");
        sb.append(url);
        Log.d(TAG, sb.toString());
        this.webView.loadUrl(url);
        this.webView.setVisibility(0);
        VideoView videoView2 = this.videoView;
        if (videoView2 != null) {
            videoView2.stopPlayback();
            this.handler.removeCallbacks(this.reportProgress);
            this.mediaPlayer = null;
        }
        this.videoView.setVisibility(4);
        this.progressBar.setVisibility(8);
        this.closeButton.setVisibility(8);
        this.muteButton.setVisibility(8);
        this.ctaOverlay.setVisibility(8);
    }

    public String getWebsiteUrl() {
        return this.webView.getUrl();
    }

    public void close() {
        runOnUiThread(new Runnable() {
            public void run() {
                if (VungleActivity.this.videoView != null && VungleActivity.this.videoView.isPlaying()) {
                    VungleActivity.this.presenter.stopViewabilityTracker();
                }
                VungleActivity.this.webView.removeJavascriptInterface("Android");
                VungleActivity.this.webView.loadUrl("about:blank");
            }
        });
        finish();
    }

    public void showCloseButton() {
        this.closeButton.setVisibility(0);
    }

    public void showCTAOverlay(boolean clickEnabled, boolean enabled, final int size) {
        if (clickEnabled) {
            this.videoView.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    VungleActivity.this.ctaOverlay.setVisibility(0);
                    VungleActivity.this.ctaOverlay.setImageBitmap(ViewUtility.getBitmap(Asset.cta, VungleActivity.this));
                    VungleActivity.this.ctaOverlay.setEnabled(true);
                }
            });
        } else {
            this.ctaOverlay.setVisibility(0);
            this.ctaOverlay.setImageBitmap(ViewUtility.getBitmap(enabled ? Asset.cta : Asset.ctaDisabled, this));
            this.ctaOverlay.setEnabled(enabled);
        }
        if (size == 100) {
            this.videoView.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    VungleActivity.this.presenter.reportAction("cta", "");
                    VungleActivity.this.presenter.handleAction("download");
                }
            });
        } else {
            final View parent = (View) this.ctaOverlay.getParent();
            this.ctaOverlay.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                public boolean onPreDraw() {
                    VungleActivity.this.ctaOverlay.getViewTreeObserver().removeOnPreDrawListener(this);
                    final int finalHeight = VungleActivity.this.ctaOverlay.getMeasuredHeight();
                    final int finalWidth = VungleActivity.this.ctaOverlay.getMeasuredWidth();
                    parent.post(new Runnable() {
                        public void run() {
                            Rect rect = new Rect();
                            VungleActivity.this.ctaOverlay.getHitRect(rect);
                            int i = rect.top;
                            int i2 = finalHeight;
                            int i3 = i2 / 2;
                            C1269710 r4 = C1269710.this;
                            int i4 = size;
                            rect.top = i - (i3 * i4);
                            int i5 = rect.left;
                            int i6 = finalWidth;
                            rect.left = i5 - ((i6 / 2) * i4);
                            rect.bottom += (i2 / 2) * i4;
                            rect.right += (i6 / 2) * i4;
                            parent.setTouchDelegate(new TouchDelegate(rect, VungleActivity.this.ctaOverlay));
                        }
                    });
                    return true;
                }
            });
        }
        this.ctaOverlay.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                VungleActivity.this.presenter.reportAction("cta", "");
                VungleActivity.this.presenter.handleAction("download");
            }
        });
    }

    public void open(String url) {
        StringBuilder sb = new StringBuilder();
        sb.append("Opening ");
        sb.append(url);
        String sb2 = sb.toString();
        String str = TAG;
        Log.v(str, sb2);
        try {
            ExternalRouter.launch(url, this);
        } catch (Exception e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unable to start activity ");
            sb3.append(e.getLocalizedMessage());
            Log.e(str, sb3.toString());
        }
    }

    public void showDialog(String dialogTitle, String dialogBody, String dialogContinue, String dialogClose, final DialogInterface.OnClickListener responseListener) {
        Builder dialogBuilder = new Builder(new ContextThemeWrapper(this, getApplicationInfo().theme));
        if (!TextUtils.isEmpty(dialogTitle)) {
            dialogBuilder.setTitle(dialogTitle);
        }
        if (!TextUtils.isEmpty(dialogBody)) {
            dialogBuilder.setMessage(dialogBody);
        }
        dialogBuilder.setPositiveButton(dialogContinue, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                VungleActivity.this.pendingPause = false;
                VungleActivity.this.dialog.dismiss();
                DialogInterface.OnClickListener onClickListener = responseListener;
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, i);
                }
            }
        });
        dialogBuilder.setNegativeButton(dialogClose, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                VungleActivity.this.pendingPause = false;
                VungleActivity.this.dialog.dismiss();
                DialogInterface.OnClickListener onClickListener = responseListener;
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, i);
                }
            }
        });
        dialogBuilder.setCancelable(false);
        this.dialog = dialogBuilder.create();
        if (!this.videoView.isPlaying() || this.mediaPlayer == null) {
            this.pendingPause = true;
        } else {
            this.videoView.pause();
        }
        this.videoView.pause();
        this.videoPosition = this.videoView.getCurrentPosition();
        this.dialog.show();
    }

    private void setupPlayerProgressBar() {
        this.reportProgress = new Runnable() {
            float duration = -2.0f;

            public void run() {
                if (VungleActivity.this.mediaPlayer != null) {
                    try {
                        int position = VungleActivity.this.mediaPlayer.getCurrentPosition();
                        if (this.duration == -2.0f) {
                            this.duration = (float) VungleActivity.this.mediaPlayer.getDuration();
                        }
                        VungleActivity.this.presenter.reportAction("video_viewed", String.format(Locale.ENGLISH, "%d", new Object[]{Integer.valueOf(position)}));
                        VungleActivity.this.presenter.onProgressUpdate((int) ((((float) position) / this.duration) * 100.0f));
                        VungleActivity.this.progressBar.setMax((int) this.duration);
                        VungleActivity.this.progressBar.setProgress(position);
                        VungleActivity.this.handler.postDelayed(this, 1000);
                    } catch (IllegalStateException e) {
                        Log.v(VungleActivity.TAG, "IllegalStateException while reporting progress indicates activity was killed via SIGKILL.");
                    }
                }
            }
        };
        this.handler.post(this.reportProgress);
    }

    private void setImmersiveMode() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        AdvertisementPresenter advertisementPresenter = this.presenter;
        if (advertisementPresenter != null) {
            advertisementPresenter.stop(isChangingConfigurations(), true);
        }
        this.handler.removeCallbacksAndMessages(null);
        VideoView videoView2 = this.videoView;
        if (videoView2 != null && videoView2.isPlaying()) {
            try {
                this.videoView.stopPlayback();
            } catch (Throwable t) {
                StringBuilder sb = new StringBuilder();
                sb.append("error on stopping player ");
                sb.append(t);
                Log.w(TAG, sb.toString());
            }
        }
        super.onDestroy();
    }
}
