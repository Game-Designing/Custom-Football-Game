package com.mopub.mraid;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.mopub.common.AdReport;
import com.mopub.common.CloseableLayout;
import com.mopub.common.CloseableLayout.ClosePosition;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.common.UrlHandler.MoPubSchemeListener;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import com.mopub.common.util.ManifestUtils;
import com.mopub.common.util.Utils;
import com.mopub.common.util.Views;
import com.mopub.mobileads.BaseVideoPlayerActivity;
import com.mopub.mobileads.BaseWebView;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.util.WebViews;
import com.mopub.mraid.MraidBridge.MraidBridgeListener;
import com.mopub.mraid.MraidBridge.MraidWebView;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.EnumSet;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public class MraidController {

    /* renamed from: a */
    private final AdReport f35493a;

    /* renamed from: b */
    private WeakReference<Activity> f35494b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Context f35495c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final PlacementType f35496d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final FrameLayout f35497e;

    /* renamed from: f */
    private final CloseableLayout f35498f;

    /* renamed from: g */
    private ViewGroup f35499g;

    /* renamed from: h */
    private final C11478b f35500h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final C11473C f35501i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ViewState f35502j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public MraidListener f35503k;

    /* renamed from: l */
    private UseCustomCloseListener f35504l;

    /* renamed from: m */
    private MraidWebViewDebugListener f35505m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public MraidWebView f35506n;

    /* renamed from: o */
    private MraidWebView f35507o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final MraidBridge f35508p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public final MraidBridge f35509q;

    /* renamed from: r */
    private C11477a f35510r;

    /* renamed from: s */
    private Integer f35511s;

    /* renamed from: t */
    private MoPubSchemeListener f35512t;

    /* renamed from: u */
    private boolean f35513u;

    /* renamed from: v */
    private C11472B f35514v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public final MraidNativeCommandHandler f35515w;

    /* renamed from: x */
    private boolean f35516x;

    /* renamed from: y */
    private final MraidBridgeListener f35517y;

    /* renamed from: z */
    private final MraidBridgeListener f35518z;

    public interface MraidListener {
        void onClose();

        void onExpand();

        void onFailedToLoad();

        void onLoaded(View view);

        void onOpen();

        void onRenderProcessGone(MoPubErrorCode moPubErrorCode);

        void onResize(boolean z);
    }

    public interface MraidWebViewCacheListener {
        void onReady(MraidWebView mraidWebView, ExternalViewabilitySessionManager externalViewabilitySessionManager);
    }

    public interface UseCustomCloseListener {
        void useCustomCloseChanged(boolean z);
    }

    @VisibleForTesting
    /* renamed from: com.mopub.mraid.MraidController$a */
    class C11477a extends BroadcastReceiver {

        /* renamed from: a */
        private Context f35519a;

        /* renamed from: b */
        private int f35520b = -1;

        C11477a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (this.f35519a != null) {
                if ("android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction())) {
                    int orientation = MraidController.this.m38000k();
                    if (orientation != this.f35520b) {
                        this.f35520b = orientation;
                        MraidController.this.mo37638a(this.f35520b);
                    }
                }
            }
        }

        public void register(Context context) {
            Preconditions.checkNotNull(context);
            this.f35519a = context.getApplicationContext();
            Context context2 = this.f35519a;
            if (context2 != null) {
                context2.registerReceiver(this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
            }
        }

        public void unregister() {
            Context context = this.f35519a;
            if (context != null) {
                context.unregisterReceiver(this);
                this.f35519a = null;
            }
        }
    }

    @VisibleForTesting
    /* renamed from: com.mopub.mraid.MraidController$b */
    static class C11478b {

        /* renamed from: a */
        private final Handler f35522a = new Handler();

        /* renamed from: b */
        private C11479a f35523b;

        /* renamed from: com.mopub.mraid.MraidController$b$a */
        static class C11479a {
            /* access modifiers changed from: private */

            /* renamed from: a */
            public final View[] f35524a;

            /* renamed from: b */
            private final Handler f35525b;

            /* renamed from: c */
            private Runnable f35526c;

            /* renamed from: d */
            int f35527d;

            /* renamed from: e */
            private final Runnable f35528e;

            /* synthetic */ C11479a(Handler x0, View[] x1, C11494k x2) {
                this(x0, x1);
            }

            private C11479a(Handler handler, View[] views) {
                this.f35528e = new C11502s(this);
                this.f35525b = handler;
                this.f35524a = views;
            }

            /* access modifiers changed from: private */
            /* renamed from: b */
            public void m38028b() {
                this.f35527d--;
                if (this.f35527d == 0) {
                    Runnable runnable = this.f35526c;
                    if (runnable != null) {
                        runnable.run();
                        this.f35526c = null;
                    }
                }
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public void mo37675a(Runnable successRunnable) {
                this.f35526c = successRunnable;
                this.f35527d = this.f35524a.length;
                this.f35525b.post(this.f35528e);
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public void mo37674a() {
                this.f35525b.removeCallbacks(this.f35528e);
                this.f35526c = null;
            }
        }

        C11478b() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C11479a mo37672a(View... views) {
            this.f35523b = new C11479a(this.f35522a, views, null);
            return this.f35523b;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo37673a() {
            C11479a aVar = this.f35523b;
            if (aVar != null) {
                aVar.mo37674a();
                this.f35523b = null;
            }
        }
    }

    public MraidController(Context context, AdReport adReport, PlacementType placementType) {
        this(context, adReport, placementType, new MraidBridge(adReport, placementType), new MraidBridge(adReport, PlacementType.INTERSTITIAL), new C11478b());
    }

    @VisibleForTesting
    MraidController(Context context, AdReport adReport, PlacementType placementType, MraidBridge bridge, MraidBridge twoPartBridge, C11478b screenMetricsWaiter) {
        this.f35502j = ViewState.LOADING;
        this.f35510r = new C11477a();
        this.f35512t = new C11494k(this);
        this.f35513u = true;
        this.f35514v = C11472B.NONE;
        this.f35516x = true;
        this.f35517y = new C11497n(this);
        this.f35518z = new C11498o(this);
        this.f35495c = context.getApplicationContext();
        Preconditions.checkNotNull(this.f35495c);
        this.f35493a = adReport;
        if (context instanceof Activity) {
            this.f35494b = new WeakReference<>((Activity) context);
        } else {
            this.f35494b = new WeakReference<>(null);
        }
        this.f35496d = placementType;
        this.f35508p = bridge;
        this.f35509q = twoPartBridge;
        this.f35500h = screenMetricsWaiter;
        this.f35502j = ViewState.LOADING;
        this.f35501i = new C11473C(this.f35495c, this.f35495c.getResources().getDisplayMetrics().density);
        this.f35497e = new FrameLayout(this.f35495c);
        this.f35498f = new CloseableLayout(this.f35495c);
        this.f35498f.setOnCloseListener(new C11495l(this));
        View dimmingView = new View(this.f35495c);
        dimmingView.setOnTouchListener(new C11496m(this));
        this.f35498f.addView(dimmingView, new LayoutParams(-1, -1));
        this.f35510r.register(this.f35495c);
        this.f35508p.mo37602a(this.f35517y);
        this.f35509q.mo37602a(this.f35518z);
        this.f35515w = new MraidNativeCommandHandler();
    }

    public void setMraidListener(MraidListener mraidListener) {
        this.f35503k = mraidListener;
    }

    public void setUseCustomCloseListener(UseCustomCloseListener listener) {
        this.f35504l = listener;
    }

    public void setDebugListener(MraidWebViewDebugListener debugListener) {
        this.f35505m = debugListener;
    }

    public void fillContent(String htmlData, MraidWebViewCacheListener listener) {
        Preconditions.checkNotNull(htmlData, "htmlData cannot be null");
        this.f35506n = new MraidWebView(this.f35495c);
        this.f35506n.enablePlugins(true);
        if (listener != null) {
            listener.onReady(this.f35506n, null);
        }
        this.f35508p.mo37603a(this.f35506n);
        this.f35497e.addView(this.f35506n, new LayoutParams(-1, -1));
        this.f35508p.setContentHtml(htmlData);
    }

    public void onPreloadFinished(BaseWebView baseWebView) {
        this.f35506n = (MraidWebView) baseWebView;
        this.f35506n.enablePlugins(true);
        this.f35508p.mo37603a(this.f35506n);
        this.f35497e.addView(this.f35506n, new LayoutParams(-1, -1));
        mo37652d();
    }

    public void onShow(Activity activity) {
        this.f35494b = new WeakReference<>(activity);
        UseCustomCloseListener useCustomCloseListener = this.f35504l;
        if (useCustomCloseListener != null) {
            useCustomCloseListener.useCustomCloseChanged(m38004m());
        }
        try {
            mo37637a();
        } catch (C11493j e) {
            MoPubLog.m37080d("Failed to apply orientation.");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public int m38000k() {
        return ((WindowManager) this.f35495c.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public boolean mo37645a(ConsoleMessage consoleMessage) {
        MraidWebViewDebugListener mraidWebViewDebugListener = this.f35505m;
        if (mraidWebViewDebugListener != null) {
            return mraidWebViewDebugListener.onConsoleMessage(consoleMessage);
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public boolean mo37647a(String message, JsResult result) {
        MraidWebViewDebugListener mraidWebViewDebugListener = this.f35505m;
        if (mraidWebViewDebugListener != null) {
            return mraidWebViewDebugListener.onJsAlert(message, result);
        }
        result.confirm();
        return true;
    }

    public MraidWebView getCurrentWebView() {
        return this.f35509q.mo37611b() ? this.f35507o : this.f35506n;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: f */
    public boolean mo37655f() {
        Activity activity = (Activity) this.f35494b.get();
        if (activity == null || getCurrentWebView() == null) {
            return false;
        }
        if (this.f35496d != PlacementType.INLINE) {
            return true;
        }
        return this.f35515w.mo37680a(activity, (View) getCurrentWebView());
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: d */
    public void mo37652d() {
        this.f35508p.mo37608a(this.f35515w.mo37682b(this.f35495c), this.f35515w.mo37683c(this.f35495c), MraidNativeCommandHandler.m38040a(this.f35495c), MraidNativeCommandHandler.isStorePictureSupported(this.f35495c), mo37655f());
        this.f35508p.mo37605a(this.f35496d);
        MraidBridge mraidBridge = this.f35508p;
        mraidBridge.mo37607a(mraidBridge.mo37614e());
        this.f35508p.notifyScreenMetrics(this.f35501i);
        m37986a(ViewState.DEFAULT);
        this.f35508p.mo37615f();
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: e */
    public void mo37654e() {
        m37987a((Runnable) new C11499p(this));
    }

    /* renamed from: a */
    private void m37987a(Runnable successRunnable) {
        this.f35500h.mo37673a();
        View currentWebView = getCurrentWebView();
        if (currentWebView != null) {
            this.f35500h.mo37672a(this.f35497e, currentWebView).mo37675a((Runnable) new C11500q(this, currentWebView, successRunnable));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37638a(int currentRotation) {
        m37987a((Runnable) null);
    }

    public void pause(boolean isFinishing) {
        this.f35516x = true;
        MraidWebView mraidWebView = this.f35506n;
        if (mraidWebView != null) {
            WebViews.onPause(mraidWebView, isFinishing);
        }
        MraidWebView mraidWebView2 = this.f35507o;
        if (mraidWebView2 != null) {
            WebViews.onPause(mraidWebView2, isFinishing);
        }
    }

    public void resume() {
        this.f35516x = false;
        MraidWebView mraidWebView = this.f35506n;
        if (mraidWebView != null) {
            mraidWebView.onResume();
        }
        MraidWebView mraidWebView2 = this.f35507o;
        if (mraidWebView2 != null) {
            mraidWebView2.onResume();
        }
    }

    public void destroy() {
        this.f35500h.mo37673a();
        try {
            this.f35510r.unregister();
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().contains("Receiver not registered")) {
                throw e;
            }
        }
        if (!this.f35516x) {
            pause(true);
        }
        Views.removeFromParent(this.f35498f);
        m37995h();
        m37997i();
        mo37657g();
    }

    /* renamed from: h */
    private void m37995h() {
        this.f35508p.mo37600a();
        this.f35506n = null;
    }

    /* renamed from: i */
    private void m37997i() {
        this.f35509q.mo37600a();
        this.f35507o = null;
    }

    /* renamed from: a */
    private void m37986a(ViewState viewState) {
        SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("MRAID state set to ");
        sb.append(viewState);
        MoPubLog.log(sdkLogEvent, sb.toString());
        ViewState previousViewState = this.f35502j;
        this.f35502j = viewState;
        this.f35508p.mo37606a(viewState);
        if (this.f35509q.mo37613d()) {
            this.f35509q.mo37606a(viewState);
        }
        MraidListener mraidListener = this.f35503k;
        if (mraidListener != null) {
            m37985a(mraidListener, previousViewState, viewState);
        }
        m37987a((Runnable) null);
    }

    @VisibleForTesting
    /* renamed from: a */
    static void m37985a(MraidListener mraidListener, ViewState previousViewState, ViewState currentViewState) {
        Preconditions.checkNotNull(mraidListener);
        Preconditions.checkNotNull(previousViewState);
        Preconditions.checkNotNull(currentViewState);
        ViewState viewState = ViewState.EXPANDED;
        if (currentViewState == viewState) {
            mraidListener.onExpand();
        } else if (previousViewState == viewState && currentViewState == ViewState.DEFAULT) {
            mraidListener.onClose();
        } else if (currentViewState == ViewState.HIDDEN) {
            mraidListener.onClose();
        } else if (previousViewState == ViewState.RESIZED && currentViewState == ViewState.DEFAULT) {
            mraidListener.onResize(true);
        } else if (currentViewState == ViewState.RESIZED) {
            mraidListener.onResize(false);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo37636a(int min, int target, int max) {
        return Math.max(min, Math.min(target, max));
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo37639a(int widthDips, int heightDips, int offsetXDips, int offsetYDips, ClosePosition closePosition, boolean allowOffscreen) throws C11493j {
        int height;
        int i = widthDips;
        int i2 = heightDips;
        int i3 = offsetXDips;
        int i4 = offsetYDips;
        ClosePosition closePosition2 = closePosition;
        if (this.f35506n != null) {
            ViewState viewState = this.f35502j;
            if (viewState != ViewState.LOADING && viewState != ViewState.HIDDEN) {
                if (viewState == ViewState.EXPANDED) {
                    throw new C11493j("Not allowed to resize from an already expanded ad");
                } else if (this.f35496d != PlacementType.INTERSTITIAL) {
                    int width = Dips.dipsToIntPixels((float) i, this.f35495c);
                    int height2 = Dips.dipsToIntPixels((float) i2, this.f35495c);
                    int offsetX = Dips.dipsToIntPixels((float) i3, this.f35495c);
                    int offsetY = Dips.dipsToIntPixels((float) i4, this.f35495c);
                    int left = this.f35501i.mo37588b().left + offsetX;
                    int top = this.f35501i.mo37588b().top + offsetY;
                    Rect resizeRect = new Rect(left, top, left + width, top + height2);
                    String str = ")";
                    String str2 = ") and offset (";
                    String str3 = "resizeProperties specified a size (";
                    int i5 = width;
                    String str4 = ", ";
                    if (!allowOffscreen) {
                        int i6 = offsetX;
                        Rect bounds = this.f35501i.mo37592d();
                        int i7 = offsetY;
                        int i8 = left;
                        if (resizeRect.width() > bounds.width() || resizeRect.height() > bounds.height()) {
                            int i9 = top;
                            StringBuilder sb = new StringBuilder();
                            sb.append(str3);
                            sb.append(i);
                            sb.append(str4);
                            sb.append(i2);
                            sb.append(str2);
                            sb.append(i3);
                            sb.append(str4);
                            sb.append(i4);
                            sb.append(") that doesn't allow the ad to appear within the max allowed size (");
                            sb.append(this.f35501i.mo37593e().width());
                            sb.append(str4);
                            sb.append(this.f35501i.mo37593e().height());
                            sb.append(str);
                            throw new C11493j(sb.toString());
                        }
                        int i10 = top;
                        height = height2;
                        resizeRect.offsetTo(mo37636a(bounds.left, resizeRect.left, bounds.right - resizeRect.width()), mo37636a(bounds.top, resizeRect.top, bounds.bottom - resizeRect.height()));
                    } else {
                        height = height2;
                        int i11 = offsetX;
                        int i12 = offsetY;
                        int i13 = left;
                        int i14 = top;
                    }
                    Rect closeRect = new Rect();
                    this.f35498f.applyCloseRegionBounds(closePosition2, resizeRect, closeRect);
                    if (!this.f35501i.mo37592d().contains(closeRect)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str3);
                        sb2.append(i);
                        sb2.append(str4);
                        sb2.append(i2);
                        sb2.append(str2);
                        sb2.append(i3);
                        sb2.append(str4);
                        sb2.append(i4);
                        sb2.append(") that doesn't allow the close region to appear within the max allowed size (");
                        sb2.append(this.f35501i.mo37593e().width());
                        sb2.append(str4);
                        sb2.append(this.f35501i.mo37593e().height());
                        sb2.append(str);
                        throw new C11493j(sb2.toString());
                    } else if (resizeRect.contains(closeRect)) {
                        this.f35498f.setCloseVisible(false);
                        this.f35498f.setClosePosition(closePosition2);
                        LayoutParams layoutParams = new LayoutParams(resizeRect.width(), resizeRect.height());
                        layoutParams.leftMargin = resizeRect.left - this.f35501i.mo37592d().left;
                        layoutParams.topMargin = resizeRect.top - this.f35501i.mo37592d().top;
                        ViewState viewState2 = this.f35502j;
                        if (viewState2 == ViewState.DEFAULT) {
                            this.f35497e.removeView(this.f35506n);
                            this.f35497e.setVisibility(4);
                            this.f35498f.addView(this.f35506n, new LayoutParams(-1, -1));
                            m37998j().addView(this.f35498f, layoutParams);
                        } else if (viewState2 == ViewState.RESIZED) {
                            this.f35498f.setLayoutParams(layoutParams);
                        }
                        this.f35498f.setClosePosition(closePosition2);
                        m37986a(ViewState.RESIZED);
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str3);
                        sb3.append(i);
                        sb3.append(str4);
                        sb3.append(height);
                        sb3.append(str2);
                        sb3.append(i3);
                        sb3.append(str4);
                        sb3.append(i4);
                        sb3.append(") that don't allow the close region to appear within the resized ad.");
                        throw new C11493j(sb3.toString());
                    }
                } else {
                    throw new C11493j("Not allowed to resize from an interstitial ad");
                }
            }
        } else {
            throw new C11493j("Unable to resize after the WebView is destroyed");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37642a(URI uri, boolean shouldUseCustomClose) throws C11493j {
        if (this.f35506n == null) {
            throw new C11493j("Unable to expand after the WebView is destroyed");
        } else if (this.f35496d != PlacementType.INTERSTITIAL) {
            ViewState viewState = this.f35502j;
            if (viewState == ViewState.DEFAULT || viewState == ViewState.RESIZED) {
                mo37637a();
                boolean isTwoPart = uri != null;
                if (isTwoPart) {
                    this.f35507o = new MraidWebView(this.f35495c);
                    this.f35509q.mo37603a(this.f35507o);
                    this.f35509q.setContentUrl(uri.toString());
                }
                LayoutParams layoutParams = new LayoutParams(-1, -1);
                ViewState viewState2 = this.f35502j;
                if (viewState2 == ViewState.DEFAULT) {
                    if (isTwoPart) {
                        this.f35498f.addView(this.f35507o, layoutParams);
                    } else {
                        this.f35497e.removeView(this.f35506n);
                        this.f35497e.setVisibility(4);
                        this.f35498f.addView(this.f35506n, layoutParams);
                    }
                    m37998j().addView(this.f35498f, new LayoutParams(-1, -1));
                } else if (viewState2 == ViewState.RESIZED && isTwoPart) {
                    this.f35498f.removeView(this.f35506n);
                    this.f35497e.addView(this.f35506n, layoutParams);
                    this.f35497e.setVisibility(4);
                    this.f35498f.addView(this.f35507o, layoutParams);
                }
                this.f35498f.setLayoutParams(layoutParams);
                mo37643a(shouldUseCustomClose);
                m37986a(ViewState.EXPANDED);
            }
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    /* renamed from: c */
    public void mo37651c() {
        if (this.f35506n != null) {
            ViewState viewState = this.f35502j;
            if (viewState != ViewState.LOADING && viewState != ViewState.HIDDEN) {
                if (viewState == ViewState.EXPANDED || this.f35496d == PlacementType.INTERSTITIAL) {
                    mo37657g();
                }
                ViewState viewState2 = this.f35502j;
                if (viewState2 == ViewState.RESIZED || viewState2 == ViewState.EXPANDED) {
                    if (!this.f35509q.mo37611b() || this.f35507o == null) {
                        this.f35498f.removeView(this.f35506n);
                        this.f35497e.addView(this.f35506n, new LayoutParams(-1, -1));
                        this.f35497e.setVisibility(0);
                    } else {
                        MraidWebView twoPartWebView = this.f35507o;
                        m37997i();
                        this.f35498f.removeView(twoPartWebView);
                    }
                    Views.removeFromParent(this.f35498f);
                    m37986a(ViewState.DEFAULT);
                } else if (viewState2 == ViewState.DEFAULT) {
                    this.f35497e.setVisibility(4);
                    m37986a(ViewState.HIDDEN);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo37640a(MoPubErrorCode errorCode) {
        MraidListener mraidListener = this.f35503k;
        if (mraidListener != null) {
            mraidListener.onRenderProcessGone(errorCode);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public ViewGroup m38002l() {
        ViewGroup viewGroup = this.f35499g;
        if (viewGroup != null) {
            return viewGroup;
        }
        View bestRootView = Views.getTopmostView((Context) this.f35494b.get(), this.f35497e);
        return bestRootView instanceof ViewGroup ? (ViewGroup) bestRootView : this.f35497e;
    }

    /* renamed from: j */
    private ViewGroup m37998j() {
        if (this.f35499g == null) {
            this.f35499g = m38002l();
        }
        return this.f35499g;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: b */
    public void mo37650b(String videoUrl) {
        BaseVideoPlayerActivity.startMraid(this.f35495c, videoUrl);
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: b */
    public void mo37649b(int screenOrientation) throws C11493j {
        Activity activity = (Activity) this.f35494b.get();
        if (activity == null || !mo37646a(this.f35514v)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Attempted to lock orientation to unsupported value: ");
            sb.append(this.f35514v.name());
            throw new C11493j(sb.toString());
        }
        if (this.f35511s == null) {
            this.f35511s = Integer.valueOf(activity.getRequestedOrientation());
        }
        activity.setRequestedOrientation(screenOrientation);
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo37637a() throws C11493j {
        C11472B b = this.f35514v;
        if (b != C11472B.NONE) {
            mo37649b(b.mo37584e());
        } else if (this.f35513u) {
            mo37657g();
        } else {
            Activity activity = (Activity) this.f35494b.get();
            if (activity != null) {
                mo37649b(DeviceUtils.getScreenOrientation(activity));
                return;
            }
            throw new C11493j("Unable to set MRAID expand orientation to 'none'; expected passed in Activity Context.");
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: g */
    public void mo37657g() {
        Activity activity = (Activity) this.f35494b.get();
        if (activity != null) {
            Integer num = this.f35511s;
            if (num != null) {
                activity.setRequestedOrientation(num.intValue());
            }
        }
        this.f35511s = null;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public boolean mo37646a(C11472B newOrientation) {
        boolean containsNecessaryConfigChanges = true;
        if (newOrientation == C11472B.NONE) {
            return true;
        }
        Activity activity = (Activity) this.f35494b.get();
        if (activity == null) {
            return false;
        }
        try {
            ActivityInfo activityInfo = activity.getPackageManager().getActivityInfo(new ComponentName(activity, activity.getClass()), 0);
            int activityOrientation = activityInfo.screenOrientation;
            if (activityOrientation != -1) {
                if (activityOrientation != newOrientation.mo37584e()) {
                    containsNecessaryConfigChanges = false;
                }
                return containsNecessaryConfigChanges;
            }
            if (!Utils.bitMaskContainsFlag(activityInfo.configChanges, 128) || !Utils.bitMaskContainsFlag(activityInfo.configChanges, Opcodes.ACC_ABSTRACT)) {
                containsNecessaryConfigChanges = false;
            }
            return containsNecessaryConfigChanges;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    /* renamed from: a */
    public void mo37643a(boolean useCustomClose) {
        if (useCustomClose != m38004m()) {
            this.f35498f.setCloseVisible(!useCustomClose);
            UseCustomCloseListener useCustomCloseListener = this.f35504l;
            if (useCustomCloseListener != null) {
                useCustomCloseListener.useCustomCloseChanged(useCustomClose);
            }
        }
    }

    /* renamed from: m */
    private boolean m38004m() {
        return !this.f35498f.isCloseVisible();
    }

    public FrameLayout getAdContainer() {
        return this.f35497e;
    }

    public void loadJavascript(String javascript) {
        this.f35508p.mo37610b(javascript);
    }

    public Context getContext() {
        return this.f35495c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public WeakReference<Activity> mo37648b() {
        return this.f35494b;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo37644a(boolean allowOrientationChange, C11472B forceOrientation) throws C11493j {
        if (mo37646a(forceOrientation)) {
            this.f35513u = allowOrientationChange;
            this.f35514v = forceOrientation;
            if (this.f35502j == ViewState.EXPANDED || (this.f35496d == PlacementType.INTERSTITIAL && !this.f35516x)) {
                mo37637a();
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to force orientation to ");
        sb.append(forceOrientation);
        throw new C11493j(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo37641a(String url) {
        MraidListener mraidListener = this.f35503k;
        if (mraidListener != null) {
            mraidListener.onOpen();
        }
        Builder builder = new Builder();
        AdReport adReport = this.f35493a;
        if (adReport != null) {
            builder.withDspCreativeId(adReport.getDspCreativeId());
        }
        EnumSet<UrlAction> urlActions = EnumSet.of(UrlAction.IGNORE_ABOUT_SCHEME, new UrlAction[]{UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK});
        if (ManifestUtils.isDebuggable(this.f35495c)) {
            urlActions.add(UrlAction.HANDLE_MOPUB_SCHEME);
            builder.withMoPubSchemeListener(this.f35512t);
        }
        builder.withSupportedUrlActions(urlActions).build().handleUrl(this.f35495c, url);
    }
}
