package com.inmobi.ads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.utilities.p225b.C10691b;
import com.integralads.avid.library.inmobi.session.AvidAdSessionManager;
import com.integralads.avid.library.inmobi.session.AvidManagedVideoAdSession;
import com.integralads.avid.library.inmobi.session.ExternalAvidAdSessionContext;
import com.integralads.avid.library.inmobi.video.AvidVideoPlaybackListener;
import java.lang.ref.WeakReference;
import java.util.Set;

/* renamed from: com.inmobi.ads.w */
/* compiled from: IasTrackedNativeV2VideoAd */
class C10604w extends C10477bz {

    /* renamed from: d */
    private static final String f32297d = C10604w.class.getSimpleName();

    /* renamed from: e */
    private final WeakReference<Activity> f32298e;

    /* renamed from: f */
    private final C10503ca f32299f;

    /* renamed from: g */
    private final AvidManagedVideoAdSession f32300g;

    /* renamed from: h */
    private C10606a f32301h;

    /* renamed from: i */
    private WeakReference<View> f32302i;

    /* renamed from: com.inmobi.ads.w$a */
    /* compiled from: IasTrackedNativeV2VideoAd */
    private static final class C10606a extends ContentObserver {

        /* renamed from: a */
        private Context f32306a;

        /* renamed from: b */
        private int f32307b = -1;

        /* renamed from: c */
        private WeakReference<C10604w> f32308c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public boolean f32309d = false;

        C10606a(Context context, C10604w wVar) {
            super(new Handler());
            this.f32306a = context;
            this.f32308c = new WeakReference<>(wVar);
        }

        public final void onChange(boolean z) {
            super.onChange(z);
            Context context = this.f32306a;
            if (context != null) {
                int a = C10691b.m35100a(context);
                if (a != this.f32307b) {
                    this.f32307b = a;
                    C10604w wVar = (C10604w) this.f32308c.get();
                    if (!this.f32309d && wVar != null) {
                        C10604w.m34785a(wVar, a);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    static AvidManagedVideoAdSession m34783a(Context context, Set<String> set) {
        AvidManagedVideoAdSession startAvidManagedVideoAdSession = AvidAdSessionManager.startAvidManagedVideoAdSession(context, new ExternalAvidAdSessionContext("7.2.7", true));
        if (context instanceof Activity) {
            startAvidManagedVideoAdSession.registerAdView(null, (Activity) context);
        } else {
            startAvidManagedVideoAdSession.registerAdView(null, null);
        }
        for (String injectJavaScriptResource : set) {
            startAvidManagedVideoAdSession.injectJavaScriptResource(injectJavaScriptResource);
        }
        return startAvidManagedVideoAdSession;
    }

    C10604w(Activity activity, C10503ca caVar, C10445bd bdVar, AvidManagedVideoAdSession avidManagedVideoAdSession) {
        super(bdVar);
        this.f32298e = new WeakReference<>(activity);
        this.f32299f = caVar;
        this.f32300g = avidManagedVideoAdSession;
    }

    /* renamed from: a */
    public final View mo34004a() {
        return this.f32299f.mo34004a();
    }

    /* renamed from: a */
    public final View mo33956a(View view, ViewGroup viewGroup, boolean z) {
        return this.f32299f.mo33956a(view, viewGroup, z);
    }

    /* renamed from: b */
    public final View mo33960b() {
        return this.f32299f.mo33960b();
    }

    /* renamed from: f */
    public final C10504a mo33964f() {
        return this.f32299f.mo33964f();
    }

    /* renamed from: c */
    public final C10478c mo33961c() {
        return this.f32299f.mo33961c();
    }

    /* renamed from: a */
    public final void mo33959a(View... viewArr) {
        try {
            if (this.f32299f.mo33961c().f31899k.f31973j) {
                m34787g();
                try {
                    if (this.f32300g.getAvidDeferredAdSessionListener() != null) {
                        this.f32300g.getAvidDeferredAdSessionListener().recordReadyEvent();
                    }
                } catch (Exception e) {
                }
                if (this.f32300g.getAvidVideoPlaybackListener() != null) {
                    this.f32300g.getAvidVideoPlaybackListener().recordAdLoadedEvent();
                }
            }
        } catch (Exception e2) {
            new StringBuilder("Exception in startTrackingForImpression with message : ").append(e2.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e2));
        } catch (Throwable th) {
            this.f32299f.mo33959a(viewArr);
            throw th;
        }
        this.f32299f.mo33959a(viewArr);
    }

    /* renamed from: d */
    public final void mo33962d() {
        try {
            if (!((C10445bd) this.f32007a).mo34024i()) {
                this.f32300g.unregisterAdView(this.f32302i == null ? null : (View) this.f32302i.get());
                this.f32300g.endSession();
                new StringBuilder("Unregistered VideoView to IAS AdSession : ").append(this.f32300g.hashCode());
            }
            Activity activity = (Activity) this.f32298e.get();
            if (!(activity == null || this.f32301h == null)) {
                activity.getContentResolver().unregisterContentObserver(this.f32301h);
            }
        } catch (Exception e) {
            new StringBuilder("Exception in stopTrackingForImpression with message : ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        } catch (Throwable th) {
            this.f32299f.mo33962d();
            throw th;
        }
        this.f32299f.mo33962d();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34784a(ViewGroup viewGroup, NativeVideoWrapper nativeVideoWrapper) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (!childAt.equals(nativeVideoWrapper)) {
                this.f32300g.registerFriendlyObstruction(childAt);
                if (childAt instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) childAt;
                    if (viewGroup2.getChildCount() > 0) {
                        m34784a(viewGroup2, nativeVideoWrapper);
                    }
                }
            }
        }
    }

    /* renamed from: g */
    private void m34787g() {
        Activity activity = (Activity) this.f32298e.get();
        if (activity != null) {
            AdContainer adContainer = this.f32007a;
            if (adContainer instanceof C10445bd) {
                final NativeVideoWrapper nativeVideoWrapper = (NativeVideoWrapper) adContainer.getVideoContainerView();
                if (nativeVideoWrapper != null) {
                    this.f32302i = new WeakReference<>(nativeVideoWrapper);
                    final View b = this.f32299f.mo33960b();
                    if (!(nativeVideoWrapper == null || b == null || !(b instanceof ViewGroup))) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public final void run() {
                                C10604w.this.m34784a((ViewGroup) b, nativeVideoWrapper);
                            }
                        });
                    }
                    this.f32300g.registerAdView((View) this.f32302i.get(), activity);
                    if (this.f32301h == null) {
                        this.f32301h = new C10606a(activity.getApplicationContext(), this);
                        activity.getContentResolver().registerContentObserver(System.CONTENT_URI, true, this.f32301h);
                    }
                    new StringBuilder("Registered ad view with AVID Video AdSession ").append(this.f32300g.hashCode());
                }
            }
        }
    }

    @SuppressLint({"SwitchIntDef"})
    /* renamed from: a */
    public final void mo33957a(int i) {
        try {
            if (this.f32300g.getAvidVideoPlaybackListener() != null) {
                StringBuilder sb = new StringBuilder("Sending event (");
                sb.append(i);
                sb.append(") to IAS AdSession : ");
                sb.append(this.f32300g.hashCode());
                switch (i) {
                    case 0:
                        this.f32300g.getAvidVideoPlaybackListener().recordAdImpressionEvent();
                        break;
                    case 1:
                        this.f32300g.getAvidVideoPlaybackListener().recordAdExpandedChangeEvent();
                        this.f32300g.getAvidVideoPlaybackListener().recordAdEnteredFullscreenEvent();
                        break;
                    case 2:
                        this.f32300g.getAvidVideoPlaybackListener().recordAdExitedFullscreenEvent();
                        this.f32300g.getAvidVideoPlaybackListener().recordAdUserMinimizeEvent();
                        break;
                    case 3:
                        this.f32300g.getAvidVideoPlaybackListener().recordAdUserCloseEvent();
                        break;
                    case 4:
                        this.f32300g.getAvidVideoPlaybackListener().recordAdClickThruEvent();
                        break;
                    case 6:
                        this.f32300g.getAvidVideoPlaybackListener().recordAdStartedEvent();
                        this.f32300g.getAvidVideoPlaybackListener().recordAdVideoStartEvent();
                        break;
                    case 7:
                        this.f32300g.getAvidVideoPlaybackListener().recordAdPausedEvent();
                        this.f32300g.unregisterAdView(this.f32302i == null ? null : (View) this.f32302i.get());
                        break;
                    case 8:
                        this.f32300g.getAvidVideoPlaybackListener().recordAdPlayingEvent();
                        break;
                    case 9:
                        this.f32300g.getAvidVideoPlaybackListener().recordAdVideoFirstQuartileEvent();
                        break;
                    case 10:
                        this.f32300g.getAvidVideoPlaybackListener().recordAdVideoMidpointEvent();
                        break;
                    case 11:
                        this.f32300g.getAvidVideoPlaybackListener().recordAdVideoThirdQuartileEvent();
                        break;
                    case 12:
                        this.f32300g.getAvidVideoPlaybackListener().recordAdCompleteEvent();
                        this.f32300g.getAvidVideoPlaybackListener().recordAdStoppedEvent();
                        break;
                    case 13:
                    case 14:
                        AvidVideoPlaybackListener avidVideoPlaybackListener = this.f32300g.getAvidVideoPlaybackListener();
                        boolean z = true;
                        int i2 = 13 == i ? 0 : this.f32301h != null ? C10691b.m35100a((Context) this.f32298e.get()) : 1;
                        avidVideoPlaybackListener.recordAdVolumeChangeEvent(Integer.valueOf(i2));
                        if (this.f32301h != null) {
                            C10606a aVar = this.f32301h;
                            if (13 != i) {
                                z = false;
                            }
                            aVar.f32309d = z;
                            break;
                        }
                        break;
                    case 15:
                        this.f32300g.getAvidVideoPlaybackListener().recordAdSkippedEvent();
                        break;
                    case 16:
                        m34787g();
                        break;
                    case 17:
                        this.f32300g.getAvidVideoPlaybackListener().recordAdError("Unknown Player error");
                        break;
                }
            }
        } catch (Exception e) {
            new StringBuilder("Exception in onAdEvent with message : ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        } catch (Throwable th) {
            this.f32299f.mo33957a(i);
            throw th;
        }
        this.f32299f.mo33957a(i);
    }

    /* renamed from: a */
    public final void mo33958a(Context context, int i) {
        this.f32299f.mo33958a(context, i);
    }

    /* renamed from: e */
    public final void mo33963e() {
        super.mo33963e();
        try {
            this.f32298e.clear();
            if (this.f32302i != null) {
                this.f32302i.clear();
            }
            this.f32301h = null;
        } catch (Exception e) {
            new StringBuilder("Exception in destroy with message : ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        } catch (Throwable th) {
            this.f32299f.mo33963e();
            throw th;
        }
        this.f32299f.mo33963e();
    }

    /* renamed from: a */
    static /* synthetic */ void m34785a(C10604w wVar, int i) {
        try {
            if (wVar.f32300g.getAvidVideoPlaybackListener() != null) {
                StringBuilder sb = new StringBuilder("Sending volumeChange to IAS AdSession(");
                sb.append(wVar.f32300g.hashCode());
                sb.append(") with volume - ");
                sb.append(i);
                wVar.f32300g.getAvidVideoPlaybackListener().recordAdVolumeChangeEvent(Integer.valueOf(i));
            }
        } catch (Exception e) {
            new StringBuilder("Exception in onVolumeChange with message : ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        }
    }
}
