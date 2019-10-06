package com.inmobi.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.ads.C10545i.C10575b;
import com.inmobi.ads.C10545i.C10578e;
import com.inmobi.ads.InMobiAdRequest.MonetizationContext;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.ads.listeners.BannerAdEventListener;
import com.inmobi.commons.core.p222e.C10659b;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.commons.core.utilities.p225b.C10692c;
import com.inmobi.commons.p217a.C10619a;
import com.inmobi.rendering.RenderView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;

public final class InMobiBanner extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f31270a = InMobiBanner.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: q */
    public static ConcurrentHashMap<C10591p, WeakReference<BannerAdRequestListener>> f31271q = new ConcurrentHashMap<>(5, 0.9f, 3);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public BannerAdListener f31272b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public BannerAdEventListener f31273c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C10313b f31274d;

    /* renamed from: e */
    private C10591p f31275e;

    /* renamed from: f */
    private C10591p f31276f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C10591p f31277g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C10591p f31278h;

    /* renamed from: i */
    private boolean f31279i = false;

    /* renamed from: j */
    private int f31280j;

    /* renamed from: k */
    private boolean f31281k = true;

    /* renamed from: l */
    private C10594q f31282l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f31283m = 0;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f31284n = 0;

    /* renamed from: o */
    private AnimationType f31285o = AnimationType.ROTATE_HORIZONTAL_AXIS;

    /* renamed from: p */
    private long f31286p = 0;

    /* renamed from: r */
    private C10579j f31287r;

    /* renamed from: s */
    private WeakReference<Activity> f31288s;

    /* renamed from: t */
    private C10455bi f31289t;

    /* renamed from: u */
    private boolean f31290u;

    /* renamed from: v */
    private boolean f31291v = true;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public final C10575b f31292w = new C10575b() {
        /* renamed from: a */
        public final void mo33747a() {
            try {
                if (InMobiBanner.this.f31277g == null || !InMobiBanner.this.f31277g.mo34389P()) {
                    InMobiBanner.m33601a(InMobiBanner.this, (C10312a) new C10312a() {
                        /* renamed from: a */
                        public final void mo33756a() {
                            try {
                                InMobiBanner.this.mo33714a("AR", "");
                                InMobiBanner.this.f31274d.sendEmptyMessage(1);
                                InMobiBanner.this.mo33717b();
                            } catch (Exception e) {
                                Logger.m35065a(InternalLogLevel.ERROR, InMobiBanner.f31270a, "Encountered unexpected error in scheduling refresh for banner ad");
                                InMobiBanner.f31270a;
                                new StringBuilder("InMobiBanner$5.onSuccess() handler threw unexpected error: ").append(e.getMessage());
                            }
                        }
                    });
                }
            } catch (Exception e) {
                Logger.m35065a(InternalLogLevel.ERROR, InMobiBanner.f31270a, "Encountered unexpected error in loading banner ad");
                InMobiBanner.f31270a;
                new StringBuilder("InMobiBanner$2.onAdLoadSucceeded() handler threw unexpected error: ").append(e.getMessage());
            }
        }

        /* renamed from: a */
        public final void mo33748a(InMobiAdRequestStatus inMobiAdRequestStatus) {
            try {
                int i = C103115.f31298a[inMobiAdRequestStatus.getStatusCode().ordinal()];
                String str = "ART";
                if (i == 1) {
                    InMobiBanner.this.mo33714a(str, "NetworkNotAvailable");
                } else if (i == 2 || i == 3) {
                    InMobiBanner.this.mo33714a(str, "LoadInProgress");
                } else if (i == 4) {
                    InMobiBanner.this.mo33714a(str, "FrequentRequests");
                } else if (i != 5) {
                    InMobiBanner.this.mo33714a("AF", "");
                } else {
                    InMobiBanner.this.mo33714a(str, "MonetizationDisabled");
                }
                if (!InMobiBanner.m33606c()) {
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    obtain.obj = inMobiAdRequestStatus;
                    InMobiBanner.this.f31274d.sendMessage(obtain);
                }
                InMobiBanner.this.mo33717b();
            } catch (Exception e) {
                Logger.m35065a(InternalLogLevel.ERROR, InMobiBanner.f31270a, "Encountered unexpected error in loading banner ad");
                InMobiBanner.f31270a;
                new StringBuilder("InMobiBanner$2.onAdLoadFailed() handler threw unexpected error: ").append(e.getMessage());
            }
        }

        /* renamed from: d */
        public final void mo33753d() {
            InMobiBanner.this.f31274d.sendEmptyMessage(3);
        }

        /* renamed from: e */
        public final void mo33754e() {
            try {
                InMobiBanner.this.mo33717b();
                InMobiBanner.this.f31274d.sendEmptyMessage(4);
            } catch (Exception e) {
                Logger.m35065a(InternalLogLevel.ERROR, InMobiBanner.f31270a, "Encountered unexpected error in closing banner ad");
                InMobiBanner.f31270a;
                new StringBuilder("InMobiBanner$2.onAdDismissed() handler threw unexpected error: ").append(e.getMessage());
            }
        }

        /* renamed from: a */
        public final void mo33749a(Map<Object, Object> map) {
            InMobiBanner.this.mo33714a("AVCL", "");
            Message obtain = Message.obtain();
            obtain.what = 5;
            obtain.obj = map;
            InMobiBanner.this.f31274d.sendMessage(obtain);
        }

        /* renamed from: f */
        public final void mo33755f() {
            InMobiBanner.this.f31274d.sendEmptyMessage(6);
        }

        /* renamed from: b */
        public final void mo33752b(Map<Object, Object> map) {
            Message obtain = Message.obtain();
            obtain.what = 7;
            obtain.obj = map;
            InMobiBanner.this.f31274d.sendMessage(obtain);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public final void mo33750a(byte[] bArr) {
            Message obtain = Message.obtain();
            obtain.what = 8;
            obtain.obj = bArr;
            InMobiBanner.this.f31274d.sendMessage(obtain);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public final void mo33751b(InMobiAdRequestStatus inMobiAdRequestStatus) {
            Message obtain = Message.obtain();
            obtain.what = 9;
            obtain.obj = inMobiAdRequestStatus;
            InMobiBanner.this.f31274d.sendMessage(obtain);
        }
    };

    /* renamed from: com.inmobi.ads.InMobiBanner$5 */
    static /* synthetic */ class C103115 {

        /* renamed from: a */
        static final /* synthetic */ int[] f31298a = new int[StatusCode.values().length];

        static {
            try {
                f31298a[StatusCode.NETWORK_UNREACHABLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f31298a[StatusCode.REQUEST_PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f31298a[StatusCode.AD_ACTIVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f31298a[StatusCode.EARLY_REFRESH_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f31298a[StatusCode.MONETIZATION_DISABLED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public enum AnimationType {
        ANIMATION_OFF,
        ROTATE_HORIZONTAL_AXIS,
        ANIMATION_ALPHA,
        ROTATE_VERTICAL_AXIS
    }

    public interface BannerAdListener {
        void onAdDismissed(InMobiBanner inMobiBanner);

        void onAdDisplayed(InMobiBanner inMobiBanner);

        void onAdInteraction(InMobiBanner inMobiBanner, Map<Object, Object> map);

        void onAdLoadFailed(InMobiBanner inMobiBanner, InMobiAdRequestStatus inMobiAdRequestStatus);

        void onAdLoadSucceeded(InMobiBanner inMobiBanner);

        void onAdRewardActionCompleted(InMobiBanner inMobiBanner, Map<Object, Object> map);

        void onUserLeftApplication(InMobiBanner inMobiBanner);
    }

    public interface BannerAdRequestListener {
        void onAdRequestCompleted(InMobiAdRequestStatus inMobiAdRequestStatus, InMobiBanner inMobiBanner);
    }

    /* renamed from: com.inmobi.ads.InMobiBanner$a */
    private interface C10312a {
        /* renamed from: a */
        void mo33756a();
    }

    /* renamed from: com.inmobi.ads.InMobiBanner$b */
    static final class C10313b extends Handler {

        /* renamed from: a */
        private WeakReference<InMobiBanner> f31299a;

        C10313b(InMobiBanner inMobiBanner) {
            super(Looper.getMainLooper());
            this.f31299a = new WeakReference<>(inMobiBanner);
        }

        public final void handleMessage(Message message) {
            InMobiBanner inMobiBanner = (InMobiBanner) this.f31299a.get();
            if (inMobiBanner != null) {
                try {
                    Map map = null;
                    switch (message.what) {
                        case 1:
                            if (inMobiBanner.f31273c != null) {
                                inMobiBanner.f31273c.onAdLoadSucceeded(inMobiBanner);
                                return;
                            } else if (inMobiBanner.f31272b != null) {
                                inMobiBanner.f31272b.onAdLoadSucceeded(inMobiBanner);
                                return;
                            }
                            break;
                        case 2:
                            InMobiAdRequestStatus inMobiAdRequestStatus = (InMobiAdRequestStatus) message.obj;
                            if (inMobiBanner.f31273c != null) {
                                inMobiBanner.f31273c.onAdLoadFailed(inMobiBanner, inMobiAdRequestStatus);
                                return;
                            } else if (inMobiBanner.f31272b != null) {
                                inMobiBanner.f31272b.onAdLoadFailed(inMobiBanner, inMobiAdRequestStatus);
                                return;
                            }
                            break;
                        case 3:
                            if (inMobiBanner.f31273c != null) {
                                inMobiBanner.f31273c.onAdDisplayed(inMobiBanner);
                                return;
                            } else if (inMobiBanner.f31272b != null) {
                                inMobiBanner.f31272b.onAdDisplayed(inMobiBanner);
                                return;
                            }
                            break;
                        case 4:
                            if (inMobiBanner.f31273c != null) {
                                inMobiBanner.f31273c.onAdDismissed(inMobiBanner);
                                return;
                            } else if (inMobiBanner.f31272b != null) {
                                inMobiBanner.f31272b.onAdDismissed(inMobiBanner);
                                return;
                            }
                            break;
                        case 5:
                            if (message.obj != null) {
                                map = (Map) message.obj;
                            }
                            if (inMobiBanner.f31273c != null) {
                                inMobiBanner.f31273c.onAdClicked(inMobiBanner, map);
                                return;
                            } else if (inMobiBanner.f31272b != null) {
                                inMobiBanner.f31272b.onAdInteraction(inMobiBanner, map);
                                return;
                            }
                            break;
                        case 6:
                            if (inMobiBanner.f31273c != null) {
                                inMobiBanner.f31273c.onUserLeftApplication(inMobiBanner);
                                return;
                            } else if (inMobiBanner.f31272b != null) {
                                inMobiBanner.f31272b.onUserLeftApplication(inMobiBanner);
                                return;
                            }
                            break;
                        case 7:
                            if (message.obj != null) {
                                map = (Map) message.obj;
                            }
                            if (inMobiBanner.f31273c != null) {
                                inMobiBanner.f31273c.onRewardsUnlocked(inMobiBanner, map);
                                return;
                            } else if (inMobiBanner.f31272b != null) {
                                inMobiBanner.f31272b.onAdRewardActionCompleted(inMobiBanner, map);
                                return;
                            }
                            break;
                        case 8:
                            if (inMobiBanner.f31273c != null) {
                                inMobiBanner.f31273c.onRequestPayloadCreated((byte[]) message.obj);
                                return;
                            }
                            break;
                        case 9:
                            if (inMobiBanner.f31273c != null) {
                                inMobiBanner.f31273c.onRequestPayloadCreationFailed((InMobiAdRequestStatus) message.obj);
                                return;
                            }
                            break;
                        default:
                            InMobiBanner.f31270a;
                            break;
                    }
                } catch (Exception e) {
                    Logger.m35065a(InternalLogLevel.ERROR, InMobiBanner.f31270a, "Publisher handler caused unexpected error");
                    InMobiBanner.f31270a;
                    new StringBuilder("Callback threw unexpected error: ").append(e.getMessage());
                }
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m33601a(InMobiBanner inMobiBanner, C10312a aVar) {
        C10591p pVar = inMobiBanner.f31277g;
        if (pVar == null) {
            inMobiBanner.f31277g = inMobiBanner.f31275e;
            inMobiBanner.f31278h = inMobiBanner.f31276f;
        } else if (pVar.equals(inMobiBanner.f31275e)) {
            inMobiBanner.f31277g = inMobiBanner.f31276f;
            inMobiBanner.f31278h = inMobiBanner.f31275e;
        } else if (inMobiBanner.f31277g.equals(inMobiBanner.f31276f)) {
            inMobiBanner.f31277g = inMobiBanner.f31275e;
            inMobiBanner.f31278h = inMobiBanner.f31276f;
        }
        try {
            if (inMobiBanner.f31291v) {
                AnimationType animationType = inMobiBanner.f31285o;
                float width = (float) inMobiBanner.getWidth();
                float height = (float) inMobiBanner.getHeight();
                Animation animation = 0;
                if (animationType == AnimationType.ANIMATION_ALPHA) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
                    alphaAnimation.setDuration(1000);
                    alphaAnimation.setFillAfter(false);
                    alphaAnimation.setInterpolator(new DecelerateInterpolator());
                    animation = alphaAnimation;
                } else if (animationType == AnimationType.ROTATE_HORIZONTAL_AXIS) {
                    Animation aVar2 = new C10584a(width / 2.0f, height / 2.0f);
                    aVar2.setDuration(500);
                    aVar2.setFillAfter(false);
                    aVar2.setInterpolator(new AccelerateInterpolator());
                    animation = aVar2;
                } else if (animationType == AnimationType.ROTATE_VERTICAL_AXIS) {
                    Animation bVar = new C10585b(width / 2.0f, height / 2.0f);
                    bVar.setDuration(500);
                    bVar.setFillAfter(false);
                    bVar.setInterpolator(new AccelerateInterpolator());
                    animation = bVar;
                }
                if (inMobiBanner.getContext() != null) {
                    if (inMobiBanner.f31277g != null) {
                        RenderView renderView = (RenderView) inMobiBanner.f31277g.mo34302j();
                        if (renderView != null) {
                            C10503ca viewableAd = renderView.getViewableAd();
                            if (inMobiBanner.f31277g.f32271z) {
                                renderView.mo33678a();
                            }
                            ViewGroup viewGroup = (ViewGroup) renderView.getParent();
                            LayoutParams layoutParams = new LayoutParams(-1, -1);
                            View a = viewableAd.mo34004a();
                            viewableAd.mo33959a(new View[0]);
                            if (inMobiBanner.f31278h != null) {
                                inMobiBanner.f31278h.mo34390Q();
                            }
                            if (viewGroup == null) {
                                inMobiBanner.addView(a, layoutParams);
                            } else {
                                viewGroup.removeAllViews();
                                viewGroup.addView(a, layoutParams);
                            }
                            inMobiBanner.f31278h.mo33995v();
                        }
                    }
                }
                if (animation != 0) {
                    inMobiBanner.startAnimation(animation);
                }
            }
            aVar.mo33756a();
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "Unexpected error while displaying Banner Ad.");
            new StringBuilder("Unexpected error while displaying Banner Ad : ").append(e.getMessage());
        }
    }

    public InMobiBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "Please initialize the SDK before creating a Banner ad");
            return;
        }
        boolean z = context instanceof Activity;
        if (z) {
            this.f31288s = new WeakReference<>((Activity) context);
        }
        this.f31274d = new C10313b(this);
        String str = "http://schemas.android.com/apk/lib/com.inmobi.ads";
        String attributeValue = attributeSet.getAttributeValue(str, "placementId");
        String attributeValue2 = attributeSet.getAttributeValue(str, "refreshInterval");
        if (attributeValue != null) {
            long a = m33597a(attributeValue);
            if (a != Long.MIN_VALUE) {
                this.f31289t = C10455bi.m34229a(a, null, "banner", null);
                this.f31289t.f31806f = z ? MonetizationContext.MONETIZATION_CONTEXT_ACTIVITY : MonetizationContext.MONETIZATION_CONTEXT_OTHER;
                m33598a(context, this.f31289t);
                this.f31279i = true;
            }
        } else {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "Placement id value is not supplied in XML layout. Banner creation failed.");
        }
        if (attributeValue2 != null) {
            try {
                setRefreshInterval(Integer.parseInt(attributeValue2.trim()));
            } catch (NumberFormatException e) {
                Logger.m35065a(InternalLogLevel.ERROR, f31270a, "Refresh interval value supplied in XML layout is not valid. Falling back to default value.");
            }
        }
    }

    /* renamed from: a */
    private static long m33597a(String str) {
        String str2 = " Placement id value supplied in XML layout is not valid. Please make sure placement id is in plid-0123456789 format.";
        String str3 = "Invalid Placement id: ";
        try {
            StringBuilder sb = new StringBuilder(str.trim());
            if ("plid-".equalsIgnoreCase(sb.substring(0, 5))) {
                return Long.parseLong(sb.substring(5, sb.length()).trim());
            }
            InternalLogLevel internalLogLevel = InternalLogLevel.ERROR;
            String str4 = f31270a;
            StringBuilder sb2 = new StringBuilder(str3);
            sb2.append(str);
            sb2.append(str2);
            Logger.m35065a(internalLogLevel, str4, sb2.toString());
            return Long.MIN_VALUE;
        } catch (NumberFormatException e) {
            InternalLogLevel internalLogLevel2 = InternalLogLevel.ERROR;
            String str5 = f31270a;
            StringBuilder sb3 = new StringBuilder(str3);
            sb3.append(str);
            sb3.append(" Placement id value supplied in XML layout is not valid. Banner creation failed.");
            Logger.m35065a(internalLogLevel2, str5, sb3.toString());
        } catch (StringIndexOutOfBoundsException e2) {
            InternalLogLevel internalLogLevel3 = InternalLogLevel.ERROR;
            String str6 = f31270a;
            StringBuilder sb4 = new StringBuilder(str3);
            sb4.append(str);
            sb4.append(str2);
            Logger.m35065a(internalLogLevel3, str6, sb4.toString());
        }
    }

    public InMobiBanner(Context context, long j) {
        super(context);
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "Please initialize the SDK before creating a Banner ad");
        } else if (context == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "Unable to create InMobiBanner ad with null context object.");
        } else {
            boolean z = context instanceof Activity;
            if (z) {
                this.f31288s = new WeakReference<>((Activity) context);
            }
            this.f31274d = new C10313b(this);
            this.f31289t = C10455bi.m34229a(j, null, "banner", null);
            this.f31289t.f31806f = z ? MonetizationContext.MONETIZATION_CONTEXT_ACTIVITY : MonetizationContext.MONETIZATION_CONTEXT_OTHER;
            m33598a(context, this.f31289t);
            this.f31279i = true;
        }
    }

    /* renamed from: b */
    private boolean m33604b(boolean z) {
        if (!this.f31279i) {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "InMobiBanner is not initialized. Ignoring your call");
        } else if (!z || this.f31273c != null) {
            return true;
        } else {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "Listener supplied is null, Ignoring your call.");
        }
        return false;
    }

    public final void getSignals() {
        if (m33604b(true)) {
            setEnableAutoRefresh(false);
            mo33714a("ARR", "");
            C10591p pVar = this.f31278h;
            if (pVar != null) {
                pVar.f32267A = getFrameSizeString();
                C10591p pVar2 = this.f31278h;
                pVar2.f32270y = false;
                pVar2.mo34303o();
            }
        }
    }

    public final void load(byte[] bArr) {
        boolean z = !m33604b(false);
        C10591p pVar = this.f31278h;
        if (pVar == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "Please make sure getSignals is called before calling Load");
            return;
        }
        if (!z) {
            pVar.f32187w = false;
            pVar.mo34291a(bArr);
        }
    }

    public final void load() {
        if (m33604b(false)) {
            mo33715a(false);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo33715a(final boolean z) {
        try {
            if (!C10619a.m34838a()) {
                Logger.m35065a(InternalLogLevel.ERROR, f31270a, "InMobiBanner is not initialized. Ignoring InMobiBanner.load()");
                return;
            }
            if (this.f31279i) {
                mo33714a("ARR", "");
                if (this.f31277g == null || !this.f31277g.mo34389P()) {
                    if (!mo33716a()) {
                        if (getLayoutParams() == null) {
                            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "The layout params of the banner must be set before calling load or call setBannerSize(int widthInDp, int heightInDp) before load");
                            this.f31292w.mo33748a(new InMobiAdRequestStatus(StatusCode.REQUEST_INVALID));
                            return;
                        }
                        if (getLayoutParams().width != -2) {
                            if (getLayoutParams().height != -2) {
                                m33614g();
                            }
                        }
                        Logger.m35065a(InternalLogLevel.ERROR, f31270a, "The height or width of a Banner ad can't be WRAP_CONTENT or call setBannerSize(int widthInDp, int heightInDp) before load");
                        this.f31292w.mo33748a(new InMobiAdRequestStatus(StatusCode.REQUEST_INVALID));
                        return;
                    }
                    if (!mo33716a()) {
                        new Handler().postDelayed(new Runnable() {
                            public final void run() {
                                try {
                                    if (InMobiBanner.this.mo33716a()) {
                                        InMobiBanner.this.m33616h();
                                        if (InMobiBanner.this.m33612f() && InMobiBanner.this.f31278h != null) {
                                            InMobiBanner.this.f31278h.f32267A = InMobiBanner.this.getFrameSizeString();
                                            InMobiBanner.this.f31278h.mo34393b(z);
                                        }
                                    } else {
                                        Logger.m35065a(InternalLogLevel.ERROR, InMobiBanner.f31270a, "The height or width of the banner can not be determined");
                                        C10575b d = InMobiBanner.this.f31292w;
                                        InMobiBanner.this.f31278h;
                                        d.mo33748a(new InMobiAdRequestStatus(StatusCode.INTERNAL_ERROR));
                                    }
                                } catch (Exception e) {
                                    Logger.m35065a(InternalLogLevel.ERROR, InMobiBanner.f31270a, "SDK encountered unexpected error while loading an ad");
                                    InMobiBanner.f31270a;
                                    new StringBuilder("InMobiBanner$4.run() threw unexpected error: ").append(e.getMessage());
                                }
                            }
                        }, 200);
                        return;
                    }
                    m33616h();
                    if (m33612f() && this.f31278h != null) {
                        this.f31278h.f32267A = getFrameSizeString();
                        this.f31278h.mo34393b(z);
                    }
                } else {
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    obtain.obj = new InMobiAdRequestStatus(StatusCode.AD_ACTIVE);
                    mo33714a("ART", "LoadInProgress");
                    this.f31274d.sendMessage(obtain);
                    this.f31277g.mo34292b("AdActive");
                    Logger.m35065a(InternalLogLevel.ERROR, f31270a, "An ad is currently being viewed by the user. Please wait for the user to close the ad before requesting for another ad.");
                }
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "Unable to load ad; SDK encountered an unexpected error");
            new StringBuilder("Load failed with unexpected error: ").append(e.getMessage());
        }
    }

    public final void load(Context context) {
        if (m33604b(false)) {
            boolean z = context instanceof Activity;
            if (z) {
                this.f31288s = new WeakReference<>((Activity) context);
            } else {
                this.f31288s = null;
            }
            C10455bi biVar = this.f31289t;
            if (biVar != null) {
                biVar.f31806f = z ? MonetizationContext.MONETIZATION_CONTEXT_ACTIVITY : MonetizationContext.MONETIZATION_CONTEXT_OTHER;
                m33598a(context, this.f31289t);
            }
            mo33715a(false);
        }
    }

    /* access modifiers changed from: private */
    public void setMonetizationContext(MonetizationContext monetizationContext) {
        C10591p pVar = this.f31275e;
        if (pVar != null && this.f31276f != null) {
            pVar.mo33972a(monetizationContext);
            this.f31276f.mo33972a(monetizationContext);
        }
    }

    @Deprecated
    public static void requestAd(Context context, InMobiAdRequest inMobiAdRequest, BannerAdRequestListener bannerAdRequestListener) {
        if (!C10619a.m34838a()) {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "Please initialize the SDK before calling requestAd. Ignoring request");
        } else if (context == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "Please supply a non null Context. Aborting request");
        } else if (inMobiAdRequest == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "Please supply a non  null InMobiAdRequest. Ignoring request");
        } else if (bannerAdRequestListener == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "Please supply a non null BannerAdRequestListener. Ignoring request");
        } else if (inMobiAdRequest.f31256c > 0 || inMobiAdRequest.f31257d > 0) {
            C103072 r0 = new C10578e() {
                /* renamed from: a */
                public final void mo33744a(C10545i iVar) {
                    if (iVar instanceof C10591p) {
                        try {
                            WeakReference weakReference = (WeakReference) InMobiBanner.f31271q.get(iVar);
                            if (weakReference != null) {
                                InMobiBanner.f31271q.remove(iVar);
                                BannerAdRequestListener bannerAdRequestListener = (BannerAdRequestListener) weakReference.get();
                                if (bannerAdRequestListener != null) {
                                    InMobiBanner inMobiBanner = new InMobiBanner(iVar.mo34283a(), iVar.f32168d);
                                    inMobiBanner.setExtras(iVar.f32170f);
                                    inMobiBanner.setKeywords(iVar.f32169e);
                                    inMobiBanner.setMonetizationContext(iVar.mo33991l());
                                    bannerAdRequestListener.onAdRequestCompleted(new InMobiAdRequestStatus(StatusCode.NO_ERROR), inMobiBanner);
                                }
                            }
                        } catch (Exception e) {
                            InMobiBanner.f31270a;
                            new StringBuilder("SDK encountered unexpected error in onAdPrefetchSucceeded ").append(e.getMessage());
                        }
                    }
                }

                /* renamed from: a */
                public final void mo33745a(C10545i iVar, InMobiAdRequestStatus inMobiAdRequestStatus) {
                    try {
                        if (iVar instanceof C10591p) {
                            WeakReference weakReference = (WeakReference) InMobiBanner.f31271q.get(iVar);
                            if (weakReference != null) {
                                InMobiBanner.f31271q.remove(iVar);
                                BannerAdRequestListener bannerAdRequestListener = (BannerAdRequestListener) weakReference.get();
                                if (bannerAdRequestListener != null) {
                                    bannerAdRequestListener.onAdRequestCompleted(inMobiAdRequestStatus, null);
                                }
                            }
                        }
                    } catch (Exception e) {
                        InMobiBanner.f31270a;
                        new StringBuilder("SDK encountered unexpected error in onAdPrefetchFailed ").append(e.getMessage());
                    }
                }
            };
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(Repo.COLUMN_DESCRIPTION, "requestAd Api called");
                try {
                    C10659b.m34983a();
                    C10659b.m34987a("ads", "GenericEvents", hashMap);
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder("Error in submitting telemetry event : (");
                    sb.append(e.getMessage());
                    sb.append(")");
                }
                C10455bi a = C10455bi.m34229a(inMobiAdRequest.f31254a, inMobiAdRequest.f31259f, "banner", inMobiAdRequest.f31258e);
                a.f31806f = inMobiAdRequest.f31255b;
                C10591p a2 = C10591p.m34724a(context.getApplicationContext(), a, null, 2);
                a2.f32170f = inMobiAdRequest.f31259f;
                a2.mo33972a(inMobiAdRequest.f31255b);
                a2.f32169e = inMobiAdRequest.f31258e;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(inMobiAdRequest.f31256c);
                sb2.append("x");
                sb2.append(inMobiAdRequest.f31257d);
                a2.f32267A = sb2.toString();
                a2.f32181q = r0;
                a2.f32178n = true;
                f31271q.put(a2, new WeakReference(bannerAdRequestListener));
                a2.mo33993q();
            } catch (Exception e2) {
                new StringBuilder("SDK encountered unexpected error in requestAd").append(e2.getMessage());
            }
        } else {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "Please provide positive width and height for banner. Ignoring request");
        }
    }

    /* access modifiers changed from: 0000 */
    public final void setTrcCollector(C10579j jVar) {
        this.f31287r = jVar;
    }

    private C10579j getAdUnitTRCCollector() {
        if (this.f31287r == null) {
            this.f31287r = new C10580k(this.f31278h);
        }
        return this.f31287r;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo33714a(String str, String str2) {
        getAdUnitTRCCollector().mo34335a(this.f31292w, str, str2);
    }

    public final JSONObject getAdMetaInfo() {
        if (this.f31279i) {
            C10591p pVar = this.f31277g;
            if (pVar != null) {
                return pVar.f32173i;
            }
        }
        return new JSONObject();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean m33612f() {
        C10591p pVar = this.f31278h;
        if (pVar == null) {
            return false;
        }
        if (this.f31286p != 0) {
            int i = pVar.f32171g.f31891c;
            if (SystemClock.elapsedRealtime() - this.f31286p < ((long) (i * 1000))) {
                C10591p pVar2 = this.f31278h;
                InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(StatusCode.EARLY_REFRESH_REQUEST);
                String str = "Ad cannot be refreshed before ";
                StringBuilder sb = new StringBuilder(str);
                sb.append(i);
                sb.append(" seconds");
                pVar2.mo33973a(inMobiAdRequestStatus.setCustomMessage(sb.toString()), false);
                InternalLogLevel internalLogLevel = InternalLogLevel.ERROR;
                String str2 = f31270a;
                StringBuilder sb2 = new StringBuilder(str);
                sb2.append(i);
                sb2.append(" seconds (Placement Id = ");
                sb2.append(this.f31278h.f32168d);
                sb2.append(")");
                Logger.m35065a(internalLogLevel, str2, sb2.toString());
                return false;
            }
        }
        this.f31286p = SystemClock.elapsedRealtime();
        return true;
    }

    public final void setExtras(Map<String, String> map) {
        if (this.f31279i && this.f31289t != null) {
            this.f31275e.f32170f = map;
            this.f31276f.f32170f = map;
        }
    }

    public final void setKeywords(String str) {
        if (this.f31279i && this.f31289t != null) {
            this.f31275e.f32169e = str;
            this.f31276f.f32169e = str;
        }
    }

    @Deprecated
    public final void setListener(BannerAdListener bannerAdListener) {
        if (bannerAdListener == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "Please pass a non-null listener to the banner.");
        } else {
            this.f31272b = bannerAdListener;
        }
    }

    public final void setListener(BannerAdEventListener bannerAdEventListener) {
        if (bannerAdEventListener == null) {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "Please pass a non-null listener to the banner.");
        } else {
            this.f31273c = bannerAdEventListener;
        }
    }

    public final void setEnableAutoRefresh(boolean z) {
        try {
            if (this.f31279i && this.f31281k != z) {
                this.f31281k = z;
                if (this.f31281k) {
                    mo33717b();
                } else {
                    m33616h();
                }
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "Unable to setup auto-refresh on the ad; SDK encountered an unexpected error");
            new StringBuilder("Setting up auto-refresh failed with unexpected error: ").append(e.getMessage());
        }
    }

    public final void setRefreshInterval(int i) {
        try {
            if (this.f31279i && this.f31278h != null) {
                if (i < this.f31278h.f32171g.f31891c) {
                    i = this.f31278h.f32171g.f31891c;
                }
                this.f31280j = i;
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "Unable to set refresh interval for the ad; SDK encountered an unexpected error");
            new StringBuilder("Setting refresh interval failed with unexpected error: ").append(e.getMessage());
        }
    }

    public final void setAnimationType(AnimationType animationType) {
        if (this.f31279i) {
            this.f31285o = animationType;
        }
    }

    public final void disableHardwareAcceleration() {
        this.f31290u = true;
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
            if (this.f31275e != null) {
                C10619a.m34833a(getContext(), (ActivityLifecycleCallbacks) this.f31275e);
            }
            if (this.f31276f != null) {
                C10619a.m34833a(getContext(), (ActivityLifecycleCallbacks) this.f31276f);
            }
            if (this.f31279i) {
                m33614g();
                if (!mo33716a()) {
                    getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                        public final void onGlobalLayout() {
                            try {
                                InMobiBanner.this.f31283m = C10692c.m35106b(InMobiBanner.this.getMeasuredWidth());
                                InMobiBanner.this.f31284n = C10692c.m35106b(InMobiBanner.this.getMeasuredHeight());
                                if (InMobiBanner.this.mo33716a()) {
                                    if (VERSION.SDK_INT >= 16) {
                                        InMobiBanner.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                        return;
                                    }
                                    InMobiBanner.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                                }
                            } catch (Exception e) {
                                Logger.m35065a(InternalLogLevel.ERROR, InMobiBanner.f31270a, "InMobiBanner$1.onGlobalLayout() handler threw unexpected error");
                                InMobiBanner.f31270a;
                                new StringBuilder("InMobiBanner$1.onGlobalLayout() handler threw unexpected error: ").append(e.getMessage());
                            }
                        }
                    });
                }
                mo33717b();
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "InMobiBanner#onAttachedToWindow() handler threw unexpected error");
            new StringBuilder("InMobiBanner#onAttachedToWindow() handler threw unexpected error: ").append(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            if (this.f31279i) {
                m33616h();
            }
            if (this.f31275e != null) {
                this.f31275e.mo34392S();
            }
            if (this.f31276f != null) {
                this.f31276f.mo34392S();
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "InMobiBanner.onDetachedFromWindow() handler threw unexpected error");
            new StringBuilder("InMobiBanner.onDetachedFromWindow() handler threw unexpected error: ").append(e.getMessage());
        }
    }

    /* renamed from: g */
    private void m33614g() {
        if (getLayoutParams() != null) {
            this.f31283m = C10692c.m35106b(getLayoutParams().width);
            this.f31284n = C10692c.m35106b(getLayoutParams().height);
        }
    }

    public final void setBannerSize(int i, int i2) {
        if (this.f31279i) {
            this.f31283m = i;
            this.f31284n = i2;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo33716a() {
        return this.f31283m > 0 && this.f31284n > 0;
    }

    /* access modifiers changed from: 0000 */
    public final String getFrameSizeString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f31283m);
        sb.append("x");
        sb.append(this.f31284n);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final void onVisibilityChanged(View view, int i) {
        try {
            super.onVisibilityChanged(view, i);
            if (this.f31279i) {
                if (i == 0) {
                    mo33717b();
                    return;
                }
                m33616h();
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "InMobiBanner$1.onVisibilityChanged() handler threw unexpected error");
            new StringBuilder("InMobiBanner$1.onVisibilityChanged() handler threw unexpected error: ").append(e.getMessage());
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        try {
            super.onWindowFocusChanged(z);
            if (this.f31279i) {
                if (z) {
                    mo33717b();
                    return;
                }
                m33616h();
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, f31270a, "InMobiBanner$1.onWindowFocusChanged() handler threw unexpected error");
            new StringBuilder("InMobiBanner$1.onWindowFocusChanged() handler threw unexpected error: ").append(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m33598a(Context context, C10455bi biVar) {
        C10591p pVar = this.f31275e;
        if (pVar == null || this.f31276f == null) {
            this.f31275e = C10591p.m34724a(context, biVar, this.f31292w, 0);
            this.f31276f = C10591p.m34724a(context, biVar, this.f31292w, 0);
            this.f31278h = this.f31275e;
            this.f31280j = this.f31278h.f32171g.f31892d;
        } else {
            pVar.mo34080a(context);
            this.f31276f.mo34080a(context);
            boolean z = context instanceof Activity;
            this.f31275e.mo33972a(z ? MonetizationContext.MONETIZATION_CONTEXT_ACTIVITY : MonetizationContext.MONETIZATION_CONTEXT_OTHER);
            this.f31276f.mo33972a(z ? MonetizationContext.MONETIZATION_CONTEXT_ACTIVITY : MonetizationContext.MONETIZATION_CONTEXT_OTHER);
        }
        this.f31282l = new C10594q(this);
        C10591p pVar2 = this.f31275e;
        pVar2.f32178n = false;
        this.f31276f.f32178n = false;
        if (this.f31290u) {
            pVar2.mo33969O();
            this.f31276f.mo33969O();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo33717b() {
        if (isShown() && hasWindowFocus() && this.f31278h != null) {
            C10594q qVar = this.f31282l;
            if (qVar != null) {
                qVar.removeMessages(1);
            }
            int i = this.f31278h.f32165a;
            if (!(i == 1 || i == 2)) {
                C10591p pVar = this.f31277g;
                if ((pVar == null || pVar.f32165a != 8) && this.f31281k) {
                    C10594q qVar2 = this.f31282l;
                    if (qVar2 != null) {
                        qVar2.sendEmptyMessageDelayed(1, (long) (this.f31280j * 1000));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m33616h() {
        C10594q qVar = this.f31282l;
        if (qVar != null) {
            qVar.removeMessages(1);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void setAnimateAndDisplayAd(boolean z) {
        this.f31291v = z;
    }

    public final void resume() {
        try {
            if (this.f31277g != null && this.f31288s == null) {
                this.f31277g.mo34391R();
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Could not resume ad; SDK encountered an unexpected error");
            new StringBuilder("SDK encountered unexpected error in resuming ad; ").append(e.getMessage());
        }
    }

    public final void pause() {
        try {
            if (this.f31277g != null && this.f31288s == null) {
                this.f31277g.mo34390Q();
            }
        } catch (Exception e) {
            Logger.m35065a(InternalLogLevel.ERROR, "InMobi", "Could not pause ad; SDK encountered an unexpected error");
            new StringBuilder("SDK encountered unexpected error in pausing ad; ").append(e.getMessage());
        }
    }

    public final String getCreativeId() {
        if (this.f31279i) {
            C10591p pVar = this.f31277g;
            if (pVar != null) {
                return pVar.f32188x;
            }
        }
        return "";
    }

    /* renamed from: c */
    static boolean m33606c() {
        return Message.obtain() == null;
    }

    /* access modifiers changed from: 0000 */
    public final void setClientCallbackHandler(C10313b bVar) {
        this.f31274d = bVar;
    }
}
