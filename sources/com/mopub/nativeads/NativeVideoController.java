package com.mopub.nativeads;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.exoplayer2.C8281e.C8282a;
import com.google.android.exoplayer2.C8320g;
import com.google.android.exoplayer2.C8321h;
import com.google.android.exoplayer2.C8363p;
import com.google.android.exoplayer2.C8438u;
import com.google.android.exoplayer2.C8543v.C8544a;
import com.google.android.exoplayer2.C8543v.C8545b;
import com.google.android.exoplayer2.C8569x;
import com.google.android.exoplayer2.C8569x.C8571b;
import com.google.android.exoplayer2.C8572y;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.audio.C8141v;
import com.google.android.exoplayer2.mediacodec.C8341d;
import com.google.android.exoplayer2.p183b.C8263j;
import com.google.android.exoplayer2.source.C8391p.C8392a;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.C8434i;
import com.google.android.exoplayer2.trackselection.C8435j;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.upstream.C8487i.C8488a;
import com.google.android.exoplayer2.upstream.C8490k;
import com.google.android.exoplayer2.video.C8559m;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibilityTracker.VisibilityChecker;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.mobileads.RepeatingHandlerRunnable;
import com.mopub.mobileads.VastTracker;
import com.mopub.mobileads.VastVideoConfig;
import com.mopub.network.TrackingRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NativeVideoController extends C8544a implements OnAudioFocusChangeListener {
    public static final long RESUME_FINISHED_THRESHOLD = 750;
    public static final int STATE_BUFFERING = 2;
    public static final int STATE_CLEARED = 5;
    public static final int STATE_ENDED = 4;
    public static final int STATE_IDLE = 1;
    public static final int STATE_READY = 3;

    /* renamed from: a */
    private static final Map<Long, NativeVideoController> f35957a = new HashMap(4);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f35958b;

    /* renamed from: c */
    private final Handler f35959c;

    /* renamed from: d */
    private final C11555a f35960d;

    /* renamed from: e */
    private VastVideoConfig f35961e;

    /* renamed from: f */
    private NativeVideoProgressRunnable f35962f;

    /* renamed from: g */
    private AudioManager f35963g;

    /* renamed from: h */
    private Listener f35964h;

    /* renamed from: i */
    private OnAudioFocusChangeListener f35965i;

    /* renamed from: j */
    private Surface f35966j;

    /* renamed from: k */
    private TextureView f35967k;

    /* renamed from: l */
    private WeakReference<Object> f35968l;

    /* renamed from: m */
    private volatile C8320g f35969m;

    /* renamed from: n */
    private BitmapDrawable f35970n;

    /* renamed from: o */
    private C8141v f35971o;

    /* renamed from: p */
    private C8559m f35972p;

    /* renamed from: q */
    private boolean f35973q;

    /* renamed from: r */
    private boolean f35974r;

    /* renamed from: s */
    private boolean f35975s;

    /* renamed from: t */
    private int f35976t;

    /* renamed from: u */
    private boolean f35977u;

    public interface Listener {
        void onError(Exception exc);

        void onStateChanged(boolean z, int i);
    }

    static class NativeVideoProgressRunnable extends RepeatingHandlerRunnable {

        /* renamed from: d */
        private final Context f35978d;

        /* renamed from: e */
        private final VisibilityChecker f35979e;

        /* renamed from: f */
        private final List<C11556b> f35980f;

        /* renamed from: g */
        private final VastVideoConfig f35981g;

        /* renamed from: h */
        private C8320g f35982h;

        /* renamed from: i */
        private TextureView f35983i;

        /* renamed from: j */
        private ProgressListener f35984j;

        /* renamed from: k */
        private long f35985k;

        /* renamed from: l */
        private long f35986l;

        /* renamed from: m */
        private boolean f35987m;

        public interface ProgressListener {
            void updateProgress(int i);
        }

        NativeVideoProgressRunnable(Context context, Handler handler, List<C11556b> visibilityTrackingEvents, VastVideoConfig vastVideoConfig) {
            this(context, handler, visibilityTrackingEvents, new VisibilityChecker(), vastVideoConfig);
        }

        @VisibleForTesting
        NativeVideoProgressRunnable(Context context, Handler handler, List<C11556b> visibilityTrackingEvents, VisibilityChecker visibilityChecker, VastVideoConfig vastVideoConfig) {
            super(handler);
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(handler);
            Preconditions.checkNotNull(visibilityTrackingEvents);
            Preconditions.checkNotNull(vastVideoConfig);
            this.f35978d = context.getApplicationContext();
            this.f35980f = visibilityTrackingEvents;
            this.f35979e = visibilityChecker;
            this.f35981g = vastVideoConfig;
            this.f35986l = -1;
            this.f35987m = false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo38049a(C8320g exoPlayer) {
            this.f35982h = exoPlayer;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo38048a(TextureView textureView) {
            this.f35983i = textureView;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo38050a(ProgressListener progressListener) {
            this.f35984j = progressListener;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo38047a(long currentPosition) {
            this.f35985k = currentPosition;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public long mo38046a() {
            return this.f35985k;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public long mo38052b() {
            return this.f35986l;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo38053c() {
            this.f35987m = true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo38051a(boolean forceTrigger) {
            int trackedCount = 0;
            for (C11556b event : this.f35980f) {
                if (event.f35992e) {
                    trackedCount++;
                } else {
                    if (!forceTrigger) {
                        VisibilityChecker visibilityChecker = this.f35979e;
                        TextureView textureView = this.f35983i;
                        if (!visibilityChecker.isVisible(textureView, textureView, event.f35989b, event.f35993f)) {
                        }
                    }
                    event.f35991d = (int) (((long) event.f35991d) + this.f34912c);
                    if (forceTrigger || event.f35991d >= event.f35990c) {
                        event.f35988a.execute();
                        event.f35992e = true;
                        trackedCount++;
                    }
                }
            }
            if (trackedCount == this.f35980f.size() && this.f35987m) {
                stop();
            }
        }

        public void doWork() {
            C8320g gVar = this.f35982h;
            if (gVar != null && gVar.mo25484l()) {
                this.f35985k = this.f35982h.getCurrentPosition();
                this.f35986l = this.f35982h.getDuration();
                mo38051a(false);
                ProgressListener progressListener = this.f35984j;
                if (progressListener != null) {
                    progressListener.updateProgress((int) ((((float) this.f35985k) / ((float) this.f35986l)) * 1000.0f));
                }
                List<VastTracker> trackers = this.f35981g.getUntriggeredTrackersBefore((int) this.f35985k, (int) this.f35986l);
                if (!trackers.isEmpty()) {
                    List<String> trackingUrls = new ArrayList<>();
                    for (VastTracker tracker : trackers) {
                        if (!tracker.isTracked()) {
                            trackingUrls.add(tracker.getContent());
                            tracker.setTracked();
                        }
                    }
                    TrackingRequest.makeTrackingHttpRequest((Iterable<String>) trackingUrls, this.f35978d);
                }
            }
        }
    }

    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.NativeVideoController$a */
    static class C11555a {
        C11555a() {
        }

        public C8320g newInstance(C8572y[] renderers, C8435j trackSelector, C8363p loadControl) {
            return C8321h.m19449a(renderers, trackSelector, loadControl);
        }
    }

    /* renamed from: com.mopub.nativeads.NativeVideoController$b */
    static class C11556b {

        /* renamed from: a */
        C11557a f35988a;

        /* renamed from: b */
        int f35989b;

        /* renamed from: c */
        int f35990c;

        /* renamed from: d */
        int f35991d;

        /* renamed from: e */
        boolean f35992e;

        /* renamed from: f */
        Integer f35993f;

        /* renamed from: com.mopub.nativeads.NativeVideoController$b$a */
        interface C11557a {
            void execute();
        }

        C11556b() {
        }
    }

    public static NativeVideoController createForId(long id, Context context, List<C11556b> visibilityTrackingEvents, VastVideoConfig vastVideoConfig) {
        NativeVideoController nvc = new NativeVideoController(context, visibilityTrackingEvents, vastVideoConfig);
        f35957a.put(Long.valueOf(id), nvc);
        return nvc;
    }

    @VisibleForTesting
    public static NativeVideoController createForId(long id, Context context, VastVideoConfig vastVideoConfig, NativeVideoProgressRunnable nativeVideoProgressRunnable, C11555a moPubExoPlayerFactory, AudioManager audioManager) {
        NativeVideoController nvc = new NativeVideoController(context, vastVideoConfig, nativeVideoProgressRunnable, moPubExoPlayerFactory, audioManager);
        f35957a.put(Long.valueOf(id), nvc);
        return nvc;
    }

    @VisibleForTesting
    public static void setForId(long id, NativeVideoController nativeVideoController) {
        f35957a.put(Long.valueOf(id), nativeVideoController);
    }

    public static NativeVideoController getForId(long id) {
        return (NativeVideoController) f35957a.get(Long.valueOf(id));
    }

    public static NativeVideoController remove(long id) {
        return (NativeVideoController) f35957a.remove(Long.valueOf(id));
    }

    private NativeVideoController(Context context, List<C11556b> visibilityTrackingEvents, VastVideoConfig vastVideoConfig) {
        this(context, vastVideoConfig, new NativeVideoProgressRunnable(context, new Handler(Looper.getMainLooper()), visibilityTrackingEvents, vastVideoConfig), new C11555a(), (AudioManager) context.getSystemService("audio"));
    }

    private NativeVideoController(Context context, VastVideoConfig vastVideoConfig, NativeVideoProgressRunnable nativeVideoProgressRunnable, C11555a moPubExoPlayerFactory, AudioManager audioManager) {
        this.f35976t = 1;
        this.f35977u = true;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(vastVideoConfig);
        Preconditions.checkNotNull(moPubExoPlayerFactory);
        Preconditions.checkNotNull(audioManager);
        this.f35958b = context.getApplicationContext();
        this.f35959c = new Handler(Looper.getMainLooper());
        this.f35961e = vastVideoConfig;
        this.f35962f = nativeVideoProgressRunnable;
        this.f35960d = moPubExoPlayerFactory;
        this.f35963g = audioManager;
    }

    public void setListener(Listener listener) {
        this.f35964h = listener;
    }

    public void setProgressListener(ProgressListener progressListener) {
        this.f35962f.mo38050a(progressListener);
    }

    public void setOnAudioFocusChangeListener(OnAudioFocusChangeListener onAudioFocusChangeListener) {
        this.f35965i = onAudioFocusChangeListener;
    }

    public void setPlayWhenReady(boolean playWhenReady) {
        if (this.f35973q != playWhenReady) {
            this.f35973q = playWhenReady;
            m38321f();
        }
    }

    public int getPlaybackState() {
        if (this.f35969m == null) {
            return 5;
        }
        return this.f35969m.mo25481i();
    }

    public void setAudioEnabled(boolean audioEnabled) {
        this.f35974r = audioEnabled;
        m38320e();
    }

    public void setAppAudioEnabled(boolean audioEnabled) {
        if (this.f35975s != audioEnabled) {
            this.f35975s = audioEnabled;
            if (this.f35975s) {
                this.f35963g.requestAudioFocus(this, 3, 1);
            } else {
                this.f35963g.abandonAudioFocus(this);
            }
        }
    }

    public void setAudioVolume(float volume) {
        if (this.f35974r) {
            m38316a(volume);
        }
    }

    public void onAudioFocusChange(int focusChange) {
        OnAudioFocusChangeListener onAudioFocusChangeListener = this.f35965i;
        if (onAudioFocusChangeListener != null) {
            onAudioFocusChangeListener.onAudioFocusChange(focusChange);
        }
    }

    public void setTextureView(TextureView textureView) {
        Preconditions.checkNotNull(textureView);
        this.f35966j = new Surface(textureView.getSurfaceTexture());
        this.f35967k = textureView;
        this.f35962f.mo38048a(this.f35967k);
        m38317a(this.f35966j);
    }

    public void prepare(Object owner) {
        Preconditions.checkNotNull(owner);
        this.f35968l = new WeakReference<>(owner);
        m38318c();
        m38319d();
        m38317a(this.f35966j);
    }

    public void clear() {
        setPlayWhenReady(false);
        this.f35966j = null;
        m38318c();
    }

    public void release(Object owner) {
        Preconditions.checkNotNull(owner);
        WeakReference<Object> weakReference = this.f35968l;
        if ((weakReference == null ? null : weakReference.get()) == owner) {
            m38318c();
        }
    }

    public void onTracksChanged(TrackGroupArray trackGroups, C8434i trackSelections) {
    }

    public void onLoadingChanged(boolean isLoading) {
    }

    public void onPlayerStateChanged(boolean playWhenReady, int newState) {
        if (newState == 4 && this.f35970n == null) {
            if (this.f35969m == null || this.f35966j == null || this.f35967k == null) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "onPlayerStateChanged called afer view has been recycled.");
                return;
            }
            this.f35970n = new BitmapDrawable(this.f35958b.getResources(), this.f35967k.getBitmap());
            this.f35962f.mo38053c();
        }
        this.f35976t = newState;
        if (newState == 3) {
            this.f35977u = false;
        } else if (newState == 1) {
            this.f35977u = true;
        }
        Listener listener = this.f35964h;
        if (listener != null) {
            listener.onStateChanged(playWhenReady, newState);
        }
    }

    public void seekTo(long ms) {
        if (this.f35969m != null) {
            this.f35969m.mo25180a(ms);
            this.f35962f.mo38047a(ms);
        }
    }

    public long getCurrentPosition() {
        return this.f35962f.mo38046a();
    }

    public long getDuration() {
        return this.f35962f.mo38052b();
    }

    public void onPlayerError(ExoPlaybackException e) {
        Listener listener = this.f35964h;
        if (listener != null) {
            listener.onError(e);
            this.f35962f.mo38053c();
        }
    }

    public void onPlaybackParametersChanged(C8438u playbackParameters) {
    }

    public void handleCtaClick(Context context) {
        mo38026b();
        this.f35961e.handleClickWithoutResult(context, 0);
    }

    public boolean hasFinalFrame() {
        return this.f35970n != null;
    }

    public Drawable getFinalFrame() {
        return this.f35970n;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo38026b() {
        this.f35962f.mo38051a(true);
    }

    /* renamed from: c */
    private void m38318c() {
        if (this.f35969m != null) {
            m38317a((Surface) null);
            this.f35969m.stop();
            this.f35969m.mo25469a();
            this.f35969m = null;
            this.f35962f.stop();
            this.f35962f.mo38049a((C8320g) null);
        }
    }

    /* renamed from: d */
    private void m38319d() {
        if (this.f35969m == null) {
            C8559m mVar = new C8559m(this.f35958b, C8341d.f18069a, 0, this.f35959c, null, 10);
            this.f35972p = mVar;
            this.f35971o = new C8141v(this.f35958b, C8341d.f18069a);
            C8490k allocator = new C8490k(true, 65536, 32);
            C8282a defaultLoadControlBuilder = new C8282a();
            defaultLoadControlBuilder.mo25421a(allocator);
            this.f35969m = this.f35960d.newInstance(new C8572y[]{this.f35972p, this.f35971o}, new DefaultTrackSelector(), defaultLoadControlBuilder.mo25422a());
            this.f35962f.mo38049a(this.f35969m);
            this.f35969m.mo25473a((C8545b) this);
            C8488a dataSourceFactory = new C11653wa(this);
            C8263j extractorsFactory = new C11656xa(this);
            C8392a extractorMediaSourceFactory = new C8392a(dataSourceFactory);
            extractorMediaSourceFactory.mo25722a(extractorsFactory);
            this.f35969m.mo25467a(extractorMediaSourceFactory.mo25723a(Uri.parse(this.f35961e.getNetworkMediaFileUrl())));
            this.f35962f.startRepeating(50);
        }
        m38320e();
        m38321f();
    }

    /* renamed from: f */
    private void m38321f() {
        if (this.f35969m != null) {
            this.f35969m.mo25474a(this.f35973q);
        }
    }

    /* renamed from: e */
    private void m38320e() {
        m38316a(this.f35974r ? 1.0f : 0.0f);
    }

    /* renamed from: a */
    private void m38316a(float volume) {
        C8320g exoPlayer = this.f35969m;
        C8141v audioRenderer = this.f35971o;
        if (exoPlayer != null && audioRenderer != null) {
            C8569x playerMessage = exoPlayer.mo25466a((C8571b) audioRenderer);
            if (playerMessage == null) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "ExoPlayer.createMessage returned null.");
                return;
            }
            playerMessage.mo26230a(2);
            playerMessage.mo26231a((Object) Float.valueOf(volume));
            playerMessage.mo26242j();
        }
    }

    /* renamed from: a */
    private void m38317a(Surface surface) {
        C8320g exoPlayer = this.f35969m;
        C8559m videoRenderer = this.f35972p;
        if (exoPlayer != null && videoRenderer != null) {
            C8569x playerMessage = exoPlayer.mo25466a((C8571b) videoRenderer);
            if (playerMessage == null) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "ExoPlayer.createMessage returned null.");
                return;
            }
            playerMessage.mo26230a(1);
            playerMessage.mo26231a((Object) surface);
            playerMessage.mo26242j();
        }
    }
}
