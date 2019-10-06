package com.inmobi.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.ads.AdContainer.C10304a;
import com.inmobi.ads.AdContainer.RenderingProperties;
import com.inmobi.ads.AdContainer.RenderingProperties.PlacementType;
import com.inmobi.ads.C10380ah.C10390c;
import com.inmobi.ads.C10391ai.C10395a;
import com.inmobi.ads.p214e.p215a.C10534b;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.p222e.C10659b;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.integralads.avid.library.inmobi.session.AvidManagedVideoAdSession;
import com.mopub.common.Constants;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@TargetApi(15)
/* renamed from: com.inmobi.ads.bd */
/* compiled from: NativeVideoAdContainer */
public class C10445bd extends C10380ah {
    /* access modifiers changed from: private */

    /* renamed from: D */
    public static final String f31774D = C10445bd.class.getSimpleName();

    /* renamed from: B */
    WeakReference<View> f31775B;

    /* renamed from: C */
    C10395a f31776C = new C10395a() {
        /* renamed from: a */
        public final void mo34045a(View view, boolean z) {
            C10445bd.this.mo34016a(z);
            C10445bd.m34181a(C10445bd.this, view, z);
        }
    };

    /* renamed from: E */
    private final C10304a f31777E = new C10304a() {
        /* renamed from: a */
        public final void mo33692a() {
            C10445bd.f31774D;
            C10390c e = C10445bd.this.mo34020e();
            if (e != null) {
                e.mo34059a();
            }
        }

        /* renamed from: a */
        public final void mo33693a(Object obj) {
            if (C10445bd.this.mo34027l() != null) {
                C10449be beVar = (C10449be) obj;
                C10445bd.f31774D;
                String str = "didRequestFullScreen";
                beVar.f31629v.put(str, Boolean.valueOf(true));
                String str2 = "isFullScreen";
                beVar.f31629v.put(str2, Boolean.valueOf(true));
                String str3 = "shouldAutoPlay";
                beVar.f31629v.put(str3, Boolean.valueOf(true));
                C10400ak akVar = beVar.f31632y;
                if (akVar != null) {
                    akVar.f31629v.put(str, Boolean.valueOf(true));
                    beVar.f31632y.f31629v.put(str2, Boolean.valueOf(true));
                    beVar.f31632y.f31629v.put(str3, Boolean.valueOf(true));
                }
                PlacementType placementType = PlacementType.PLACEMENT_TYPE_INLINE;
                C10445bd bdVar = C10445bd.this;
                if (placementType == bdVar.f31553b.f31249a) {
                    bdVar.getViewableAd().mo33957a(1);
                    beVar.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_FULLSCREEN, C10445bd.this.m34187g(beVar));
                }
                C10390c e = C10445bd.this.mo34020e();
                if (e != null) {
                    e.mo34063b();
                }
            }
        }

        /* renamed from: b */
        public final void mo33694b(Object obj) {
            C10445bd.f31774D;
            C10449be beVar = (C10449be) obj;
            Map<String, Object> map = beVar.f31629v;
            Boolean valueOf = Boolean.valueOf(false);
            String str = "didRequestFullScreen";
            map.put(str, valueOf);
            String str2 = "isFullScreen";
            beVar.f31629v.put(str2, valueOf);
            C10400ak akVar = beVar.f31632y;
            if (akVar != null) {
                akVar.f31629v.put(str, valueOf);
                beVar.f31632y.f31629v.put(str2, valueOf);
                beVar.f31632y.f31632y = null;
            }
            beVar.f31632y = null;
            C10445bd bdVar = C10445bd.this;
            if (bdVar.f31553b.f31249a == PlacementType.PLACEMENT_TYPE_INLINE) {
                bdVar.getViewableAd().mo33957a(2);
                C10380ah ahVar = C10445bd.this.f31565n;
                if (ahVar != null) {
                    ahVar.getViewableAd().mo33957a(16);
                }
                beVar.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_EXIT_FULLSCREEN, C10445bd.this.m34187g(beVar));
            } else {
                bdVar.getViewableAd().mo33957a(3);
            }
            C10390c e = C10445bd.this.mo34020e();
            if (e != null) {
                e.mo34067f();
            }
        }
    };

    /* renamed from: a */
    static /* synthetic */ void m34182a(C10445bd bdVar, NativeVideoView nativeVideoView) {
        if (bdVar.f31553b.f31249a == PlacementType.PLACEMENT_TYPE_INLINE && !bdVar.mo34024i()) {
            int videoVolume = nativeVideoView.getVideoVolume();
            if (videoVolume != nativeVideoView.getLastVolume() && nativeVideoView.isPlaying()) {
                bdVar.m34185b(videoVolume <= 0);
                nativeVideoView.setLastVolume(videoVolume);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m34183a(C10445bd bdVar, NativeVideoView nativeVideoView, C10449be beVar) {
        if (bdVar.f31553b.f31249a == PlacementType.PLACEMENT_TYPE_INLINE && !bdVar.mo34024i() && !beVar.f31786C && !nativeVideoView.isPlaying() && nativeVideoView.getState() == 5) {
            bdVar.m34180a(nativeVideoView);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m34184b(C10445bd bdVar, NativeVideoView nativeVideoView) {
        if (bdVar.f31553b.f31249a == PlacementType.PLACEMENT_TYPE_INLINE && !bdVar.mo34024i() && !bdVar.f31564m) {
            bdVar.m34180a(nativeVideoView);
        }
    }

    /* renamed from: a */
    private void m34180a(NativeVideoView nativeVideoView) {
        int videoVolume = nativeVideoView.getVideoVolume();
        int lastVolume = nativeVideoView.getLastVolume();
        if (videoVolume != lastVolume && lastVolume > 0) {
            m34185b(true);
            nativeVideoView.setLastVolume(videoVolume);
        }
    }

    /* renamed from: b */
    private void m34185b(boolean z) {
        if (this.f31553b.f31249a == PlacementType.PLACEMENT_TYPE_INLINE && !mo34024i()) {
            C10390c e = mo34020e();
            if (e != null) {
                e.mo34062a(z);
            }
        }
    }

    C10445bd(Context context, RenderingProperties renderingProperties, C10406ao aoVar, String str, String str2, Set<C10465bq> set, C10478c cVar, long j, boolean z, String str3) {
        super(context, renderingProperties, aoVar, str, str2, set, cVar, j, z, str3);
        this.f31552a = aoVar;
    }

    public void destroy() {
        if (!this.f31563l) {
            if (getVideoContainerView() != null) {
                NativeVideoWrapper nativeVideoWrapper = (NativeVideoWrapper) getVideoContainerView();
                if (nativeVideoWrapper != null) {
                    nativeVideoWrapper.getVideoView().mo33883c();
                }
            }
            super.destroy();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34009a(View view) {
        if (!mo34026k() && !this.f31563l && (view instanceof NativeVideoView)) {
            NativeVideoView nativeVideoView = (NativeVideoView) view;
            this.f31562k = true;
            HashMap hashMap = new HashMap();
            hashMap.put("type", PlacementType.PLACEMENT_TYPE_FULLSCREEN == getRenderingProperties().f31249a ? "int" : "native");
            hashMap.put("clientRequestId", this.f31559h);
            hashMap.put("impId", this.f31555d);
            C10659b.m34983a();
            C10659b.m34987a("ads", "ViewableBeaconFired", hashMap);
            m34186f((C10449be) nativeVideoView.getTag());
        }
    }

    /* renamed from: f */
    private void m34186f(C10449be beVar) {
        String str = "didImpressionFire";
        if (!((Boolean) beVar.f31629v.get(str)).booleanValue()) {
            List<NativeTracker> list = beVar.f31628u;
            Map g = m34187g(beVar);
            List<TrackerEventType> arrayList = new ArrayList<>();
            for (NativeTracker nativeTracker : list) {
                if (TrackerEventType.TRACKER_EVENT_TYPE_VIDEO_RENDER == nativeTracker.f31378b) {
                    if (nativeTracker.f31377a.startsWith(Constants.HTTP)) {
                        C10400ak.m34047a(nativeTracker, g);
                    }
                    arrayList = (List) nativeTracker.f31380d.get("referencedEvents");
                    for (TrackerEventType a : arrayList) {
                        beVar.mo34086a(a, g);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                beVar.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_PLAY, g);
                beVar.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_RENDER, g);
            }
            this.f31552a.f31654d.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_RENDER, m34187g(beVar));
            beVar.f31629v.put(str, Boolean.valueOf(true));
            this.f31561j.mo33957a(0);
            if (this.f31553b.f31249a == PlacementType.PLACEMENT_TYPE_INLINE) {
                HashMap hashMap = new HashMap();
                hashMap.put("type", "native");
                hashMap.put("clientRequestId", this.f31559h);
                hashMap.put("impId", this.f31555d);
                mo34015a("AdRendered", (Map<String, Object>) hashMap);
            }
            if (mo34020e() != null) {
                mo34020e().mo34065d();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public final boolean mo34024i() {
        return PlacementType.PLACEMENT_TYPE_INLINE == this.f31553b.f31249a && mo34027l() != null;
    }

    @SuppressLint({"SwitchIntDef"})
    public C10503ca getViewableAd() {
        Context j = mo34025j();
        if (this.f31561j == null && j != null) {
            mo34022g();
            this.f31561j = new C10364ab(this, new C10522cd(this));
            Set<C10465bq> set = this.f31560i;
            if (set != null) {
                if (j instanceof Activity) {
                    try {
                        Activity activity = (Activity) j;
                        for (C10465bq bqVar : set) {
                            int i = bqVar.f31835a;
                            if (i == 1) {
                                C10503ca caVar = this.f31561j;
                                Map<String, Object> map = bqVar.f31836b;
                                C10449be beVar = (C10449be) this.f31552a.mo34107c("VIDEO").get(0);
                                StringBuilder sb = new StringBuilder();
                                for (NativeTracker nativeTracker : beVar.f31628u) {
                                    if (TrackerEventType.TRACKER_EVENT_TYPE_MOAT == nativeTracker.f31378b) {
                                        sb.append(nativeTracker.f31377a);
                                    }
                                }
                                if (sb.length() > 0) {
                                    map.put("zMoatVASTIDs", sb.toString());
                                }
                                this.f31561j = new C10378af(activity, caVar, this, map);
                            } else if (i == 3) {
                                AvidManagedVideoAdSession avidManagedVideoAdSession = (AvidManagedVideoAdSession) bqVar.f31836b.get("avidAdSession");
                                if (avidManagedVideoAdSession != null) {
                                    this.f31561j = new C10604w(activity, this.f31561j, this, avidManagedVideoAdSession);
                                }
                            } else if (i == 6) {
                                if (((List) bqVar.f31836b.get("trackerUrls")) != null) {
                                    this.f31561j = new C10534b(this.f31561j, this);
                                }
                            }
                        }
                    } catch (Exception e) {
                        new StringBuilder("Exception occurred while creating the video viewable ad : ").append(e.getMessage());
                        C10621a.m34854a().mo34423a(new C10658a(e));
                    }
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put("type", "native");
                    hashMap.put("impId", this.f31555d);
                    C10659b.m34983a();
                    C10659b.m34987a("ads", "TrackersForService", hashMap);
                }
            }
        }
        return this.f31561j;
    }

    public C10304a getFullScreenEventsListener() {
        return this.f31777E;
    }

    public View getVideoContainerView() {
        WeakReference<View> weakReference = this.f31775B;
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public final boolean mo34029n() {
        return !this.f31569r;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo34017b(C10400ak akVar) {
        String str = "didRequestFullScreen";
        String str2 = "shouldAutoPlay";
        String str3 = "Action 2 not valid for asset of type: ";
        int i = akVar.f31619l;
        if (i == 0) {
            return;
        }
        if (i != 1) {
            String str4 = "VIDEO";
            String str5 = "InMobi";
            if (i != 3) {
                String str6 = "seekPosition";
                if (i == 4) {
                    try {
                        if (PlacementType.PLACEMENT_TYPE_INLINE == this.f31553b.f31249a) {
                            NativeVideoWrapper nativeVideoWrapper = (NativeVideoWrapper) getVideoContainerView();
                            if (nativeVideoWrapper != null) {
                                NativeVideoView videoView = nativeVideoWrapper.getVideoView();
                                C10449be beVar = (C10449be) videoView.getTag();
                                if (videoView.getState() != 1) {
                                    try {
                                        if (!this.f31563l) {
                                            if (this.f31567p.get() != null) {
                                                if (!((Boolean) beVar.f31629v.get(str)).booleanValue()) {
                                                    beVar.f31629v.put(str, Boolean.valueOf(true));
                                                    beVar.f31629v.put(str6, Integer.valueOf(videoView.getCurrentPosition()));
                                                    beVar.f31629v.put("lastMediaVolume", Integer.valueOf(videoView.getVolume()));
                                                    if (videoView.getMediaPlayer().isPlaying()) {
                                                        videoView.getMediaPlayer().pause();
                                                    }
                                                    videoView.getMediaPlayer().f31745a = 4;
                                                    beVar.f31629v.put("isFullScreen", Boolean.valueOf(true));
                                                    beVar.f31629v.put(str6, Integer.valueOf(videoView.getMediaPlayer().getCurrentPosition()));
                                                    mo34028m();
                                                }
                                            }
                                        }
                                    } catch (Exception e) {
                                        new StringBuilder("SDK encountered unexpected error in handling the onVideoRequestedFullScreen event; ").append(e.getMessage());
                                        C10621a.m34854a().mo34423a(new C10658a(e));
                                    }
                                }
                            }
                        }
                    } catch (Exception e2) {
                        new StringBuilder("Encountered unexpected error in handling fullscreen action on video: ").append(e2.getMessage());
                        Logger.m35065a(InternalLogLevel.DEBUG, str5, "SDK encountered unexpected error in expanding video to fullscreen");
                        C10621a.m34854a().mo34423a(new C10658a(e2));
                    }
                } else if (i != 5) {
                    try {
                        if (PlacementType.PLACEMENT_TYPE_FULLSCREEN == this.f31553b.f31249a) {
                            super.mo34017b(akVar);
                            if (!str4.equals(akVar.f31609b)) {
                                new StringBuilder(str3).append(akVar.f31609b);
                                return;
                            }
                            NativeVideoWrapper nativeVideoWrapper2 = (NativeVideoWrapper) getVideoContainerView();
                            if (nativeVideoWrapper2 != null) {
                                nativeVideoWrapper2.getVideoView().mo33887d();
                                NativeVideoView videoView2 = nativeVideoWrapper2.getVideoView();
                                if (videoView2.mo33882b() && videoView2.f31405c.isPlaying()) {
                                    videoView2.f31405c.pause();
                                    videoView2.f31405c.seekTo(0);
                                    if (videoView2.getTag() != null) {
                                        C10449be beVar2 = (C10449be) videoView2.getTag();
                                        beVar2.f31629v.put("didPause", Boolean.valueOf(true));
                                        beVar2.f31629v.put(str6, Integer.valueOf(0));
                                        beVar2.f31629v.put("didCompleteQ4", Boolean.valueOf(true));
                                    }
                                    videoView2.f31405c.f31745a = 4;
                                    videoView2.getPlaybackEventListener().mo33927a(4);
                                }
                                if (videoView2.f31405c != null) {
                                    videoView2.f31405c.f31746b = 4;
                                }
                            }
                            return;
                        }
                        C10390c e3 = mo34020e();
                        if (e3 != null) {
                            e3.mo34070i();
                        }
                    } catch (Exception e4) {
                        new StringBuilder(str3).append(akVar.f31609b);
                        C10621a.m34854a().mo34423a(new C10658a(e4));
                    }
                } else {
                    try {
                        NativeVideoWrapper nativeVideoWrapper3 = (NativeVideoWrapper) getVideoContainerView();
                        if (nativeVideoWrapper3 != null) {
                            C10449be beVar3 = (C10449be) nativeVideoWrapper3.getVideoView().getTag();
                            beVar3.f31629v.put(str2, Boolean.valueOf(true));
                            if (beVar3.f31632y != null) {
                                beVar3.f31632y.f31629v.put(str2, Boolean.valueOf(true));
                            }
                            nativeVideoWrapper3.getVideoView().start();
                        }
                    } catch (Exception e5) {
                        new StringBuilder("Encountered unexpected error in handling play action on video: ").append(e5.getMessage());
                        Logger.m35065a(InternalLogLevel.DEBUG, str5, "SDK encountered unexpected error in playing video");
                        C10621a.m34854a().mo34423a(new C10658a(e5));
                    }
                }
            } else {
                try {
                    if (this.f31574w != null) {
                        this.f31574w.mo34567d("window.imraid.broadcastEvent('replay');");
                    }
                    if (mo34021f() != null) {
                        View f = mo34021f();
                        NativeTimerView b = C10380ah.m33932b(f);
                        if (b != null) {
                            b.mo33859a();
                        }
                        ViewGroup viewGroup = (ViewGroup) f.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(f);
                        }
                    }
                    if (!str4.equals(akVar.f31609b)) {
                        new StringBuilder("Action 3 not valid for asset of type: ").append(akVar.f31609b);
                        return;
                    }
                    NativeVideoWrapper nativeVideoWrapper4 = (NativeVideoWrapper) getVideoContainerView();
                    if (nativeVideoWrapper4 != null) {
                        nativeVideoWrapper4.getVideoView().mo33888e();
                        nativeVideoWrapper4.getVideoView().start();
                    }
                } catch (Exception e6) {
                    new StringBuilder("Encountered unexpected error in handling replay action on video: ").append(e6.getMessage());
                    Logger.m35065a(InternalLogLevel.DEBUG, str5, "SDK encountered unexpected error in replaying video");
                    C10621a.m34854a().mo34423a(new C10658a(e6));
                }
            }
        } else {
            super.mo34017b(akVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34148a(C10449be beVar, int i) {
        if (!this.f31563l) {
            HashMap hashMap = new HashMap();
            hashMap.put("errorCode", String.valueOf(i));
            hashMap.put("reason", "Video Player Error");
            hashMap.put("url", beVar.mo34158b().mo34198b());
            mo34015a("VideoError", (Map<String, Object>) hashMap);
            beVar.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_ERROR, m34187g(beVar));
            this.f31561j.mo33957a(17);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: w */
    public final void mo34154w() {
        this.f31561j.mo33957a(5);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34147a(C10449be beVar) {
        if (!this.f31563l) {
            C10380ah.m33937c(mo34021f());
            beVar.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_PAUSE, m34187g(beVar));
            this.f31561j.mo33957a(7);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo34149b(C10449be beVar) {
        if (!this.f31563l) {
            C10380ah.m33938d(mo34021f());
            beVar.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_RESUME, m34187g(beVar));
            this.f31561j.mo33957a(8);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final void mo34151c(C10449be beVar) {
        if (!this.f31563l) {
            beVar.f31629v.put("lastMediaVolume", Integer.valueOf(0));
            beVar.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_MUTE, m34187g(beVar));
            this.f31561j.mo33957a(13);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final void mo34152d(C10449be beVar) {
        if (!this.f31563l) {
            beVar.f31629v.put("lastMediaVolume", Integer.valueOf(15));
            beVar.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_UNMUTE, m34187g(beVar));
            this.f31561j.mo33957a(14);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo34150b(C10449be beVar, int i) {
        if (!this.f31563l) {
            String str = "1";
            String str2 = "isCached";
            String str3 = "url";
            if (i == 0) {
                beVar.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_Q1, m34187g(beVar));
                HashMap hashMap = new HashMap();
                hashMap.put(str3, beVar.mo34158b().mo34198b());
                hashMap.put(str2, str);
                mo34015a("VideoQ1Completed", (Map<String, Object>) hashMap);
                this.f31561j.mo33957a(9);
            } else if (i == 1) {
                beVar.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_Q2, m34187g(beVar));
                HashMap hashMap2 = new HashMap();
                hashMap2.put(str3, beVar.mo34158b().mo34198b());
                hashMap2.put(str2, str);
                mo34015a("VideoQ2Completed", (Map<String, Object>) hashMap2);
                this.f31561j.mo33957a(10);
            } else if (i != 2) {
                if (i == 3 && !((Boolean) beVar.f31629v.get("didQ4Fire")).booleanValue()) {
                    mo34153e(beVar);
                }
            } else {
                beVar.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_Q3, m34187g(beVar));
                HashMap hashMap3 = new HashMap();
                hashMap3.put(str3, beVar.mo34158b().mo34198b());
                hashMap3.put(str2, str);
                mo34015a("VideoQ3Completed", (Map<String, Object>) hashMap3);
                this.f31561j.mo33957a(11);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public final void mo34153e(C10449be beVar) {
        new StringBuilder("Firing Q4 beacons for completion at ").append(beVar.f31788E);
        beVar.f31629v.put("didQ4Fire", Boolean.valueOf(true));
        beVar.mo34086a(TrackerEventType.TRACKER_EVENT_TYPE_Q4, m34187g(beVar));
        this.f31561j.mo33957a(12);
        HashMap hashMap = new HashMap();
        hashMap.put("url", beVar.mo34158b().mo34198b());
        hashMap.put("isCached", "1");
        hashMap.put("completeAfter", Integer.valueOf(beVar.f31788E));
        mo34015a("VideoQ4Completed", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public final void mo34039q() {
        super.mo34039q();
        NativeVideoWrapper nativeVideoWrapper = (NativeVideoWrapper) getVideoContainerView();
        if (nativeVideoWrapper != null) {
            NativeVideoView videoView = nativeVideoWrapper.getVideoView();
            if (this.f31553b.f31249a == PlacementType.PLACEMENT_TYPE_INLINE && !mo34024i() && videoView.getVideoVolume() > 0) {
                videoView.setLastVolume(-2);
                m34185b(true);
            }
            videoView.pause();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public Map<String, String> m34187g(C10449be beVar) {
        C10402am amVar = (C10402am) beVar.f31627t;
        HashMap hashMap = new HashMap(4);
        NativeVideoWrapper nativeVideoWrapper = (NativeVideoWrapper) this.f31775B.get();
        if (nativeVideoWrapper != null) {
            double duration = (double) nativeVideoWrapper.getVideoView().getDuration();
            Double.isNaN(duration);
            hashMap.put("$MD", String.valueOf((int) Math.round((duration * 1.0d) / 1000.0d)));
        }
        hashMap.put("[ERRORCODE]", "405");
        int intValue = ((Integer) beVar.f31629v.get("seekPosition")).intValue();
        long j = (long) intValue;
        hashMap.put("[CONTENTPLAYHEAD]", String.format(Locale.US, "%02d:%02d:%02d.%03d", new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toHours(j)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(j))), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j))), Long.valueOf(j - (TimeUnit.MILLISECONDS.toSeconds(j) * 1000))}));
        hashMap.put("[CACHEBUSTING]", m34189y());
        hashMap.put("[ASSETURI]", beVar.mo34158b().mo34198b());
        hashMap.put("$TS", String.valueOf(System.currentTimeMillis()));
        hashMap.put("$LTS", String.valueOf(this.f31552a.f31654d.f31647z));
        if (amVar != null) {
            hashMap.put("$STS", String.valueOf(amVar.f31647z));
        }
        return hashMap;
    }

    /* renamed from: y */
    private static String m34189y() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i == 0) {
            i = (secureRandom.nextInt() & MoPubClientPositioning.NO_REPEAT) % 10;
        }
        sb.append(i);
        for (int i2 = 1; i2 < 8; i2++) {
            sb.append((secureRandom.nextInt() & MoPubClientPositioning.NO_REPEAT) % 10);
        }
        return sb.toString();
    }

    /* renamed from: a */
    static /* synthetic */ void m34181a(C10445bd bdVar, View view, final boolean z) {
        final NativeVideoView nativeVideoView = (NativeVideoView) view.findViewById(MoPubClientPositioning.NO_REPEAT);
        if (nativeVideoView != null) {
            final C10449be beVar = (C10449be) nativeVideoView.getTag();
            if (beVar != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        beVar.f31629v.put("visible", Boolean.valueOf(z));
                        if (!z || C10445bd.this.f31564m) {
                            C10445bd.m34184b(C10445bd.this, nativeVideoView);
                            NativeVideoView nativeVideoView = nativeVideoView;
                            int i = beVar.f31789F;
                            if (!nativeVideoView.f31411i && 4 != nativeVideoView.getState()) {
                                if (nativeVideoView.f31410h == null) {
                                    nativeVideoView.f31410h = new Handler(Looper.getMainLooper());
                                }
                                if (i > 0) {
                                    nativeVideoView.f31411i = true;
                                    nativeVideoView.mo33887d();
                                    nativeVideoView.f31410h.postDelayed(new Runnable() {
                                        public final void run() {
                                            NativeVideoView.this.pause();
                                        }
                                    }, (long) (i * 1000));
                                    return;
                                }
                                nativeVideoView.pause();
                            }
                        } else {
                            beVar.f31629v.put("lastVisibleTimestamp", Long.valueOf(SystemClock.uptimeMillis()));
                            NativeVideoView nativeVideoView2 = nativeVideoView;
                            if (nativeVideoView2.f31411i && nativeVideoView2.getMediaPlayer() != null) {
                                if (beVar.mo34157a()) {
                                    nativeVideoView.mo33888e();
                                } else {
                                    nativeVideoView.mo33887d();
                                }
                            }
                            NativeVideoView nativeVideoView3 = nativeVideoView;
                            Handler handler = nativeVideoView3.f31410h;
                            if (handler != null) {
                                handler.removeMessages(0);
                            }
                            nativeVideoView3.f31411i = false;
                            C10445bd.m34182a(C10445bd.this, nativeVideoView);
                            C10445bd.m34183a(C10445bd.this, nativeVideoView, beVar);
                            if (1 == nativeVideoView.getState()) {
                                nativeVideoView.getMediaPlayer().f31746b = 3;
                            } else if (2 == nativeVideoView.getState() || 4 == nativeVideoView.getState() || (5 == nativeVideoView.getState() && beVar.f31786C)) {
                                nativeVideoView.start();
                            }
                        }
                    }
                });
            }
        }
    }
}
