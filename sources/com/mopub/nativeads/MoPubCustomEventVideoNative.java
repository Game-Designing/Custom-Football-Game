package com.mopub.nativeads;

import android.content.Context;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.text.TextUtils;
import android.view.View;
import com.mopub.common.DataKeys;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibilityTracker;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.VastManager;
import com.mopub.mobileads.VastManager.VastManagerListener;
import com.mopub.mobileads.VastTracker;
import com.mopub.mobileads.VastVideoConfig;
import com.mopub.mobileads.VideoViewabilityTracker;
import com.mopub.mobileads.factories.VastManagerFactory;
import com.mopub.nativeads.CustomEventNative.CustomEventNativeListener;
import com.mopub.nativeads.MediaLayout.Mode;
import com.mopub.nativeads.MediaLayout.MuteState;
import com.mopub.nativeads.NativeVideoController.NativeVideoProgressRunnable.ProgressListener;
import com.mopub.network.TrackingRequest;
import com.vungle.warren.model.Advertisement;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MoPubCustomEventVideoNative extends CustomEventNative {
    public static final String ADAPTER_NAME = MoPubCustomEventVideoNative.class.getSimpleName();

    /* renamed from: a */
    private MoPubVideoNativeAd f35829a;

    public static class MoPubVideoNativeAd extends VideoNativeAd implements VastManagerListener, ProgressListener, OnAudioFocusChangeListener {

        /* renamed from: A */
        private View f35830A;
        /* access modifiers changed from: private */

        /* renamed from: B */
        public final long f35831B;
        /* access modifiers changed from: private */

        /* renamed from: C */
        public boolean f35832C;
        /* access modifiers changed from: private */

        /* renamed from: D */
        public boolean f35833D;

        /* renamed from: E */
        private boolean f35834E;

        /* renamed from: F */
        private boolean f35835F;
        /* access modifiers changed from: private */

        /* renamed from: G */
        public int f35836G;

        /* renamed from: H */
        private boolean f35837H;
        /* access modifiers changed from: private */

        /* renamed from: I */
        public boolean f35838I;
        /* access modifiers changed from: private */

        /* renamed from: J */
        public boolean f35839J;
        /* access modifiers changed from: private */

        /* renamed from: K */
        public boolean f35840K;
        /* access modifiers changed from: private */

        /* renamed from: o */
        public final Context f35841o;

        /* renamed from: p */
        private final JSONObject f35842p;
        /* access modifiers changed from: private */

        /* renamed from: q */
        public VideoState f35843q;

        /* renamed from: r */
        private final VisibilityTracker f35844r;

        /* renamed from: s */
        private final String f35845s;
        /* access modifiers changed from: private */

        /* renamed from: t */
        public final CustomEventNativeListener f35846t;

        /* renamed from: u */
        private final C11551d f35847u;

        /* renamed from: v */
        private final C11549b f35848v;
        /* access modifiers changed from: private */

        /* renamed from: w */
        public NativeVideoController f35849w;
        /* access modifiers changed from: private */

        /* renamed from: x */
        public final VastManager f35850x;

        /* renamed from: y */
        VastVideoConfig f35851y;
        /* access modifiers changed from: private */

        /* renamed from: z */
        public MediaLayout f35852z;

        public enum VideoState {
            CREATED,
            LOADING,
            BUFFERING,
            PAUSED,
            PLAYING,
            PLAYING_MUTED,
            ENDED,
            FAILED_LOAD
        }

        /* renamed from: com.mopub.nativeads.MoPubCustomEventVideoNative$MoPubVideoNativeAd$a */
        enum C11547a {
            IMPRESSION_TRACKER("imptracker", true),
            CLICK_TRACKER("clktracker", true),
            TITLE("title", false),
            TEXT(CommandHandler.TEXT, false),
            IMAGE_URL("mainimage", false),
            ICON_URL("iconimage", false),
            CLICK_DESTINATION("clk", false),
            FALLBACK("fallback", false),
            CALL_TO_ACTION("ctatext", false),
            VAST_VIDEO(Advertisement.KEY_VIDEO, false),
            PRIVACY_INFORMATION_ICON_IMAGE_URL("privacyicon", false),
            PRIVACY_INFORMATION_ICON_CLICKTHROUGH_URL("privacyclkurl", false);
            
            @VisibleForTesting

            /* renamed from: a */
            static final Set<String> f35854a = null;

            /* renamed from: c */
            final String f35856c;

            /* renamed from: d */
            final boolean f35857d;

            static {
                int i;
                C11547a[] values;
                f35854a = new HashSet();
                for (C11547a parameter : values()) {
                    if (parameter.f35857d) {
                        f35854a.add(parameter.f35856c);
                    }
                }
            }

            private C11547a(String name, boolean required) {
                Preconditions.checkNotNull(name);
                this.f35856c = name;
                this.f35857d = required;
            }

            /* renamed from: a */
            static C11547a m38258a(String name) {
                C11547a[] values;
                Preconditions.checkNotNull(name);
                for (C11547a parameter : values()) {
                    if (parameter.f35856c.equals(name)) {
                        return parameter;
                    }
                }
                return null;
            }
        }

        public MoPubVideoNativeAd(Context context, JSONObject jsonObject, CustomEventNativeListener customEventNativeListener, C11551d videoResponseHeaders, String clickTrackingUrl) {
            this(context, jsonObject, customEventNativeListener, videoResponseHeaders, new VisibilityTracker(context), new C11549b(), clickTrackingUrl, VastManagerFactory.create(context.getApplicationContext(), false));
        }

        @VisibleForTesting
        MoPubVideoNativeAd(Context context, JSONObject jsonObject, CustomEventNativeListener customEventNativeListener, C11551d videoResponseHeaders, VisibilityTracker visibilityTracker, C11549b nativeVideoControllerFactory, String clickTrackingUrl, VastManager vastManager) {
            this.f35834E = false;
            this.f35835F = false;
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(jsonObject);
            Preconditions.checkNotNull(customEventNativeListener);
            Preconditions.checkNotNull(videoResponseHeaders);
            Preconditions.checkNotNull(visibilityTracker);
            Preconditions.checkNotNull(nativeVideoControllerFactory);
            Preconditions.checkNotNull(clickTrackingUrl);
            Preconditions.checkNotNull(vastManager);
            this.f35841o = context.getApplicationContext();
            this.f35842p = jsonObject;
            this.f35846t = customEventNativeListener;
            this.f35847u = videoResponseHeaders;
            this.f35848v = nativeVideoControllerFactory;
            this.f35845s = clickTrackingUrl;
            this.f35831B = Utils.generateUniqueId();
            this.f35832C = true;
            this.f35843q = VideoState.CREATED;
            this.f35833D = true;
            this.f35836G = 1;
            this.f35839J = true;
            this.f35844r = visibilityTracker;
            this.f35844r.setVisibilityTrackerListener(new C11561P(this));
            this.f35850x = vastManager;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public void mo37917e() throws IllegalArgumentException {
            MoPubLog.log(AdapterLogEvent.LOAD_ATTEMPTED, MoPubCustomEventVideoNative.ADAPTER_NAME);
            if (m38231a(this.f35842p)) {
                Iterator<String> keys = this.f35842p.keys();
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    C11547a parameter = C11547a.m38258a(key);
                    if (parameter != null) {
                        try {
                            m38227a(parameter, this.f35842p.opt(key));
                        } catch (ClassCastException e) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("JSONObject key (");
                            sb.append(key);
                            sb.append(") contained unexpected value.");
                            throw new IllegalArgumentException(sb.toString());
                        }
                    } else {
                        addExtra(key, this.f35842p.opt(key));
                    }
                }
                if (TextUtils.isEmpty(getPrivacyInformationIconClickThroughUrl())) {
                    setPrivacyInformationIconClickThroughUrl("https://www.mopub.com/optout/");
                }
                NativeImageHelper.preCacheImages(this.f35841o, m38245g(), new C11563Q(this));
                return;
            }
            throw new IllegalArgumentException("JSONObject did not contain required keys.");
        }

        public void onVastVideoConfigurationPrepared(VastVideoConfig vastVideoConfig) {
            if (vastVideoConfig == null) {
                MoPubLog.log(AdapterLogEvent.LOAD_FAILED, MoPubCustomEventVideoNative.ADAPTER_NAME, Integer.valueOf(NativeErrorCode.INVALID_RESPONSE.getIntCode()), NativeErrorCode.INVALID_RESPONSE);
                this.f35846t.onNativeAdFailed(NativeErrorCode.INVALID_RESPONSE);
                return;
            }
            ArrayList arrayList = new ArrayList();
            C11556b visibilityTrackingEvent = new C11556b();
            visibilityTrackingEvent.f35988a = new C11548a(this);
            visibilityTrackingEvent.f35989b = this.f35847u.mo37924a();
            visibilityTrackingEvent.f35990c = this.f35847u.mo37925b();
            arrayList.add(visibilityTrackingEvent);
            visibilityTrackingEvent.f35993f = this.f35847u.mo37926c();
            for (VastTracker vastTracker : vastVideoConfig.getImpressionTrackers()) {
                C11556b vastImpressionTrackingEvent = new C11556b();
                vastImpressionTrackingEvent.f35988a = new C11550c(this.f35841o, vastTracker.getContent());
                vastImpressionTrackingEvent.f35989b = this.f35847u.mo37924a();
                vastImpressionTrackingEvent.f35990c = this.f35847u.mo37925b();
                arrayList.add(vastImpressionTrackingEvent);
                vastImpressionTrackingEvent.f35993f = this.f35847u.mo37926c();
            }
            this.f35851y = vastVideoConfig;
            VideoViewabilityTracker vastVideoViewabilityTracker = this.f35851y.getVideoViewabilityTracker();
            if (vastVideoViewabilityTracker != null) {
                C11556b vastVisibilityTrackingEvent = new C11556b();
                vastVisibilityTrackingEvent.f35988a = new C11550c(this.f35841o, vastVideoViewabilityTracker.getContent());
                vastVisibilityTrackingEvent.f35989b = vastVideoViewabilityTracker.getPercentViewable();
                vastVisibilityTrackingEvent.f35990c = vastVideoViewabilityTracker.getViewablePlaytimeMS();
                arrayList.add(vastVisibilityTrackingEvent);
            }
            this.f35851y.setPrivacyInformationIconImageUrl(getPrivacyInformationIconImageUrl());
            this.f35851y.setPrivacyInformationIconClickthroughUrl(getPrivacyInformationIconClickThroughUrl());
            Set<String> clickTrackers = new HashSet<>();
            clickTrackers.add(this.f35845s);
            clickTrackers.addAll(mo37743a());
            ArrayList arrayList2 = new ArrayList();
            for (String clickTrackingUrl : clickTrackers) {
                arrayList2.add(new VastTracker(clickTrackingUrl, false));
            }
            this.f35851y.addClickTrackers(arrayList2);
            this.f35851y.setClickThroughUrl(getClickDestinationUrl());
            this.f35849w = this.f35848v.createForId(this.f35831B, this.f35841o, arrayList, this.f35851y);
            MoPubLog.log(AdapterLogEvent.LOAD_SUCCESS, MoPubCustomEventVideoNative.ADAPTER_NAME);
            this.f35846t.onNativeAdLoaded(this);
            JSONObject videoTrackers = this.f35847u.mo37929f();
            if (videoTrackers != null) {
                this.f35851y.addVideoTrackers(videoTrackers);
            }
        }

        /* renamed from: a */
        private boolean m38231a(JSONObject jsonObject) {
            Preconditions.checkNotNull(jsonObject);
            Set<String> keys = new HashSet<>();
            Iterator<String> jsonKeys = jsonObject.keys();
            while (jsonKeys.hasNext()) {
                keys.add(jsonKeys.next());
            }
            return keys.containsAll(C11547a.f35854a);
        }

        /* renamed from: a */
        private void m38227a(C11547a key, Object value) throws ClassCastException {
            Preconditions.checkNotNull(key);
            Preconditions.checkNotNull(value);
            try {
                switch (C11559O.f36003a[key.ordinal()]) {
                    case 1:
                        mo37748b(value);
                        return;
                    case 2:
                        setTitle((String) value);
                        return;
                    case 3:
                        setText((String) value);
                        return;
                    case 4:
                        setMainImageUrl((String) value);
                        return;
                    case 5:
                        setIconImageUrl((String) value);
                        return;
                    case 6:
                        setClickDestinationUrl((String) value);
                        return;
                    case 7:
                        m38236c(value);
                        return;
                    case 8:
                        setCallToAction((String) value);
                        return;
                    case 9:
                        setVastVideo((String) value);
                        return;
                    case 10:
                        setPrivacyInformationIconImageUrl((String) value);
                        return;
                    case 11:
                        setPrivacyInformationIconClickThroughUrl((String) value);
                        return;
                    default:
                        AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unable to add JSON key to internal mapping: ");
                        sb.append(key.f35856c);
                        MoPubLog.log(adapterLogEvent, sb.toString());
                        return;
                }
            } catch (ClassCastException e) {
                if (!key.f35857d) {
                    AdapterLogEvent adapterLogEvent2 = AdapterLogEvent.CUSTOM;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Ignoring class cast exception for optional key: ");
                    sb2.append(key.f35856c);
                    MoPubLog.log(adapterLogEvent2, sb2.toString());
                    return;
                }
                throw e;
            }
        }

        /* renamed from: c */
        private void m38236c(Object clickTrackers) {
            if (clickTrackers instanceof JSONArray) {
                mo37744a(clickTrackers);
            } else {
                addClickTracker((String) clickTrackers);
            }
        }

        public void render(MediaLayout mediaLayout) {
            MoPubLog.log(AdapterLogEvent.SHOW_ATTEMPTED, MoPubCustomEventVideoNative.ADAPTER_NAME);
            Preconditions.checkNotNull(mediaLayout);
            this.f35844r.addView(this.f35830A, mediaLayout, this.f35847u.mo37928e(), this.f35847u.mo37927d(), this.f35847u.mo37926c());
            this.f35852z = mediaLayout;
            this.f35852z.initForVideo();
            this.f35852z.setSurfaceTextureListener(new C11566S(this));
            this.f35852z.setPlayButtonClickListener(new C11569T(this));
            this.f35852z.setMuteControlClickListener(new C11571U(this));
            this.f35852z.setOnClickListener(new C11573V(this));
            if (this.f35849w.getPlaybackState() == 5) {
                this.f35849w.prepare(this);
            }
            mo37915a(VideoState.PAUSED);
        }

        public void prepare(View view) {
            Preconditions.checkNotNull(view);
            this.f35830A = view;
            this.f35830A.setOnClickListener(new C11575W(this));
        }

        public void clear(View view) {
            Preconditions.checkNotNull(view);
            this.f35849w.clear();
            m38243f();
        }

        public void destroy() {
            invalidate();
            m38243f();
            this.f35849w.setPlayWhenReady(false);
            this.f35849w.release(this);
            NativeVideoController.remove(this.f35831B);
            this.f35844r.destroy();
        }

        public void onStateChanged(boolean playWhenReady, int playbackState) {
            this.f35836G = playbackState;
            m38249i();
        }

        public void onError(Exception e) {
            MoPubLog.log(AdapterLogEvent.SHOW_FAILED, MoPubCustomEventVideoNative.ADAPTER_NAME, Integer.valueOf(NativeErrorCode.UNSPECIFIED.getIntCode()), NativeErrorCode.UNSPECIFIED);
            this.f35837H = true;
            m38249i();
        }

        public void updateProgress(int progressTenthPercent) {
            this.f35852z.updateProgress(progressTenthPercent);
        }

        public void onAudioFocusChange(int focusChange) {
            if (focusChange == -1 || focusChange == -2) {
                this.f35839J = true;
                m38249i();
            } else if (focusChange == -3) {
                this.f35849w.setAudioVolume(0.3f);
            } else if (focusChange == 1) {
                this.f35849w.setAudioVolume(1.0f);
                m38249i();
            }
        }

        /* renamed from: f */
        private void m38243f() {
            MediaLayout mediaLayout = this.f35852z;
            if (mediaLayout != null) {
                mediaLayout.setMode(Mode.IMAGE);
                this.f35852z.setSurfaceTextureListener(null);
                this.f35852z.setPlayButtonClickListener(null);
                this.f35852z.setMuteControlClickListener(null);
                this.f35852z.setOnClickListener(null);
                this.f35844r.removeView(this.f35852z);
                this.f35852z = null;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: j */
        public void m38251j() {
            MoPubLog.log(AdapterLogEvent.WILL_LEAVE_APPLICATION, MoPubCustomEventVideoNative.ADAPTER_NAME);
            this.f35832C = true;
            this.f35833D = true;
            this.f35849w.setListener(null);
            this.f35849w.setOnAudioFocusChangeListener(null);
            this.f35849w.setProgressListener(null);
            this.f35849w.clear();
            mo37916a(VideoState.PAUSED, true);
        }

        /* access modifiers changed from: private */
        /* renamed from: i */
        public void m38249i() {
            VideoState newState = this.f35843q;
            if (this.f35837H) {
                newState = VideoState.FAILED_LOAD;
            } else if (this.f35840K) {
                newState = VideoState.ENDED;
            } else {
                int i = this.f35836G;
                if (i == 1) {
                    newState = VideoState.LOADING;
                } else if (i == 2) {
                    newState = VideoState.BUFFERING;
                } else if (i == 4) {
                    this.f35840K = true;
                    newState = VideoState.ENDED;
                } else if (i == 3) {
                    if (this.f35838I) {
                        newState = this.f35839J ? VideoState.PLAYING_MUTED : VideoState.PLAYING;
                    } else {
                        newState = VideoState.PAUSED;
                    }
                }
            }
            mo37915a(newState);
        }

        /* access modifiers changed from: 0000 */
        @VisibleForTesting
        /* renamed from: a */
        public void mo37915a(VideoState videoState) {
            mo37916a(videoState, false);
        }

        /* access modifiers changed from: 0000 */
        @VisibleForTesting
        /* renamed from: a */
        public void mo37916a(VideoState videoState, boolean transitionToFullScreen) {
            Preconditions.checkNotNull(videoState);
            if (this.f35851y != null && this.f35849w != null && this.f35852z != null && this.f35843q != videoState) {
                VideoState previousState = this.f35843q;
                this.f35843q = videoState;
                switch (C11559O.f36004b[videoState.ordinal()]) {
                    case 1:
                        this.f35851y.handleError(this.f35841o, null, 0);
                        this.f35849w.setAppAudioEnabled(false);
                        this.f35852z.setMode(Mode.IMAGE);
                        break;
                    case 2:
                    case 3:
                        this.f35849w.setPlayWhenReady(true);
                        this.f35852z.setMode(Mode.LOADING);
                        break;
                    case 4:
                        this.f35849w.setPlayWhenReady(true);
                        this.f35852z.setMode(Mode.BUFFERING);
                        break;
                    case 5:
                        if (transitionToFullScreen) {
                            this.f35835F = false;
                        }
                        if (!transitionToFullScreen) {
                            this.f35849w.setAppAudioEnabled(false);
                            if (this.f35834E) {
                                TrackingRequest.makeVastTrackingHttpRequest(this.f35851y.getPauseTrackers(), null, Integer.valueOf((int) this.f35849w.getCurrentPosition()), null, this.f35841o);
                                this.f35834E = false;
                                this.f35835F = true;
                            }
                        }
                        this.f35849w.setPlayWhenReady(false);
                        this.f35852z.setMode(Mode.PAUSED);
                        break;
                    case 6:
                        m38232b(previousState);
                        this.f35849w.setPlayWhenReady(true);
                        this.f35849w.setAudioEnabled(true);
                        this.f35849w.setAppAudioEnabled(true);
                        this.f35852z.setMode(Mode.PLAYING);
                        this.f35852z.setMuteState(MuteState.UNMUTED);
                        break;
                    case 7:
                        m38232b(previousState);
                        this.f35849w.setPlayWhenReady(true);
                        this.f35849w.setAudioEnabled(false);
                        this.f35849w.setAppAudioEnabled(false);
                        this.f35852z.setMode(Mode.PLAYING);
                        this.f35852z.setMuteState(MuteState.MUTED);
                        break;
                    case 8:
                        if (this.f35849w.hasFinalFrame()) {
                            this.f35852z.setMainImageDrawable(this.f35849w.getFinalFrame());
                        }
                        this.f35834E = false;
                        this.f35835F = false;
                        this.f35851y.handleComplete(this.f35841o, 0);
                        this.f35849w.setAppAudioEnabled(false);
                        this.f35852z.setMode(Mode.FINISHED);
                        this.f35852z.updateProgress(1000);
                        break;
                }
            }
        }

        /* renamed from: b */
        private void m38232b(VideoState previousState) {
            if (!(!this.f35835F || previousState == VideoState.PLAYING || previousState == VideoState.PLAYING_MUTED)) {
                TrackingRequest.makeVastTrackingHttpRequest(this.f35851y.getResumeTrackers(), null, Integer.valueOf((int) this.f35849w.getCurrentPosition()), null, this.f35841o);
                this.f35835F = false;
            }
            this.f35834E = true;
            if (this.f35832C) {
                this.f35832C = false;
                NativeVideoController nativeVideoController = this.f35849w;
                nativeVideoController.seekTo(nativeVideoController.getCurrentPosition());
            }
        }

        /* renamed from: a */
        private boolean m38230a(String name) {
            return name != null && name.toLowerCase(Locale.US).endsWith("image");
        }

        /* renamed from: h */
        private List<String> m38247h() {
            List<String> extrasBitmapUrls = new ArrayList<>(getExtras().size());
            for (Entry<String, Object> entry : getExtras().entrySet()) {
                if (m38230a((String) entry.getKey()) && (entry.getValue() instanceof String)) {
                    extrasBitmapUrls.add((String) entry.getValue());
                }
            }
            return extrasBitmapUrls;
        }

        /* renamed from: g */
        private List<String> m38245g() {
            List<String> imageUrls = new ArrayList<>();
            if (!TextUtils.isEmpty(getMainImageUrl())) {
                imageUrls.add(getMainImageUrl());
            }
            if (!TextUtils.isEmpty(getIconImageUrl())) {
                imageUrls.add(getIconImageUrl());
            }
            if (!TextUtils.isEmpty(getPrivacyInformationIconImageUrl())) {
                imageUrls.add(getPrivacyInformationIconImageUrl());
            }
            imageUrls.addAll(m38247h());
            return imageUrls;
        }
    }

    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.MoPubCustomEventVideoNative$a */
    static class C11548a implements C11557a {

        /* renamed from: a */
        private final WeakReference<MoPubVideoNativeAd> f35858a;

        C11548a(MoPubVideoNativeAd moPubVideoNativeAd) {
            this.f35858a = new WeakReference<>(moPubVideoNativeAd);
        }

        public void execute() {
            MoPubVideoNativeAd moPubVideoNativeAd = (MoPubVideoNativeAd) this.f35858a.get();
            if (moPubVideoNativeAd != null) {
                moPubVideoNativeAd.mo37750d();
            }
        }
    }

    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.MoPubCustomEventVideoNative$b */
    static class C11549b {
        C11549b() {
        }

        public NativeVideoController createForId(long id, Context context, List<C11556b> visibilityTrackingEvents, VastVideoConfig vastVideoConfig) {
            return NativeVideoController.createForId(id, context, visibilityTrackingEvents, vastVideoConfig);
        }
    }

    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.MoPubCustomEventVideoNative$c */
    static class C11550c implements C11557a {

        /* renamed from: a */
        private final Context f35859a;

        /* renamed from: b */
        private final String f35860b;

        C11550c(Context context, String url) {
            this.f35859a = context.getApplicationContext();
            this.f35860b = url;
        }

        public void execute() {
            TrackingRequest.makeTrackingHttpRequest(this.f35860b, this.f35859a);
        }
    }

    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.MoPubCustomEventVideoNative$d */
    static class C11551d {

        /* renamed from: a */
        private boolean f35861a;

        /* renamed from: b */
        private int f35862b;

        /* renamed from: c */
        private int f35863c;

        /* renamed from: d */
        private int f35864d;

        /* renamed from: e */
        private int f35865e;

        /* renamed from: f */
        private int f35866f;

        /* renamed from: g */
        private Integer f35867g;

        /* renamed from: h */
        private JSONObject f35868h;

        C11551d(Map<String, String> serverExtras) {
            try {
                this.f35862b = Integer.parseInt((String) serverExtras.get(DataKeys.PLAY_VISIBLE_PERCENT));
                this.f35863c = Integer.parseInt((String) serverExtras.get(DataKeys.PAUSE_VISIBLE_PERCENT));
                this.f35865e = Integer.parseInt((String) serverExtras.get(DataKeys.IMPRESSION_VISIBLE_MS));
                this.f35866f = Integer.parseInt((String) serverExtras.get(DataKeys.MAX_BUFFER_MS));
                this.f35861a = true;
            } catch (NumberFormatException e) {
                this.f35861a = false;
            }
            String impressionVisiblePxString = (String) serverExtras.get(DataKeys.IMPRESSION_MIN_VISIBLE_PX);
            if (!TextUtils.isEmpty(impressionVisiblePxString)) {
                try {
                    this.f35867g = Integer.valueOf(Integer.parseInt(impressionVisiblePxString));
                } catch (NumberFormatException e2) {
                    MoPubLog.log(AdapterLogEvent.CUSTOM, "Unable to parse impression min visible px from server extras.");
                }
            }
            try {
                this.f35864d = Integer.parseInt((String) serverExtras.get(DataKeys.IMPRESSION_MIN_VISIBLE_PERCENT));
            } catch (NumberFormatException e3) {
                MoPubLog.log(AdapterLogEvent.CUSTOM, "Unable to parse impression min visible percent from server extras.");
                Integer num = this.f35867g;
                if (num == null || num.intValue() < 0) {
                    this.f35861a = false;
                }
            }
            String videoTrackers = (String) serverExtras.get(DataKeys.VIDEO_TRACKERS_KEY);
            if (!TextUtils.isEmpty(videoTrackers)) {
                try {
                    this.f35868h = new JSONObject(videoTrackers);
                } catch (JSONException e4) {
                    AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM_WITH_THROWABLE;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to parse video trackers to JSON: ");
                    sb.append(videoTrackers);
                    MoPubLog.log(adapterLogEvent, sb.toString(), e4);
                    this.f35868h = null;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: g */
        public boolean mo37930g() {
            return this.f35861a;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public int mo37928e() {
            return this.f35862b;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public int mo37927d() {
            return this.f35863c;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo37924a() {
            return this.f35864d;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public int mo37925b() {
            return this.f35865e;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public Integer mo37926c() {
            return this.f35867g;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public JSONObject mo37929f() {
            return this.f35868h;
        }
    }

    /* access modifiers changed from: protected */
    public void loadNativeAd(Context context, CustomEventNativeListener customEventNativeListener, Map<String, Object> localExtras, Map<String, String> serverExtras) {
        CustomEventNativeListener customEventNativeListener2 = customEventNativeListener;
        Map<String, Object> map = localExtras;
        Object json = map.get(DataKeys.JSON_BODY_KEY);
        if (!(json instanceof JSONObject)) {
            MoPubLog.log(AdapterLogEvent.LOAD_FAILED, ADAPTER_NAME, Integer.valueOf(NativeErrorCode.INVALID_RESPONSE.getIntCode()), NativeErrorCode.INVALID_RESPONSE);
            customEventNativeListener2.onNativeAdFailed(NativeErrorCode.INVALID_RESPONSE);
            return;
        }
        Object obj = map.get(DataKeys.EVENT_DETAILS);
        C11551d videoResponseHeaders = new C11551d(serverExtras);
        if (!videoResponseHeaders.mo37930g()) {
            MoPubLog.log(AdapterLogEvent.LOAD_FAILED, ADAPTER_NAME, Integer.valueOf(NativeErrorCode.INVALID_RESPONSE.getIntCode()), NativeErrorCode.INVALID_RESPONSE);
            customEventNativeListener2.onNativeAdFailed(NativeErrorCode.INVALID_RESPONSE);
            return;
        }
        Object clickTrackingUrlFromHeaderObject = map.get(DataKeys.CLICK_TRACKING_URL_KEY);
        if (!(clickTrackingUrlFromHeaderObject instanceof String)) {
        } else if (TextUtils.isEmpty((String) clickTrackingUrlFromHeaderObject)) {
            Object obj2 = clickTrackingUrlFromHeaderObject;
        } else {
            Object obj3 = clickTrackingUrlFromHeaderObject;
            MoPubVideoNativeAd moPubVideoNativeAd = new MoPubVideoNativeAd(context, (JSONObject) json, customEventNativeListener, videoResponseHeaders, (String) clickTrackingUrlFromHeaderObject);
            this.f35829a = moPubVideoNativeAd;
            try {
                this.f35829a.mo37917e();
            } catch (IllegalArgumentException e) {
                MoPubLog.log(AdapterLogEvent.LOAD_FAILED, ADAPTER_NAME, Integer.valueOf(NativeErrorCode.UNSPECIFIED.getIntCode()), NativeErrorCode.UNSPECIFIED);
                customEventNativeListener2.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
            }
            return;
        }
        MoPubLog.log(AdapterLogEvent.LOAD_FAILED, ADAPTER_NAME, Integer.valueOf(NativeErrorCode.UNSPECIFIED.getIntCode()), NativeErrorCode.UNSPECIFIED);
        customEventNativeListener2.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37758a() {
        MoPubVideoNativeAd moPubVideoNativeAd = this.f35829a;
        if (moPubVideoNativeAd != null) {
            moPubVideoNativeAd.invalidate();
        }
    }
}
