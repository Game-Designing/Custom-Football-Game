package com.mopub.mraid;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebViewClient;
import com.integralads.avid.library.mopub.BuildConfig;
import com.mopub.common.AdReport;
import com.mopub.common.AdType;
import com.mopub.common.CloseableLayout.ClosePosition;
import com.mopub.common.Constants;
import com.mopub.common.VisibilityTracker;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.mobileads.BaseWebView;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.ViewGestureDetector;
import com.mopub.network.MoPubRequestUtils;
import com.mopub.network.Networking;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.DeepLinkIntentReceiver.DeepLinksKeys;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;

public class MraidBridge {

    /* renamed from: a */
    private final AdReport f35482a;

    /* renamed from: b */
    private final PlacementType f35483b;

    /* renamed from: c */
    private final MraidNativeCommandHandler f35484c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MraidBridgeListener f35485d;

    /* renamed from: e */
    private MraidWebView f35486e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ViewGestureDetector f35487f;

    /* renamed from: g */
    private boolean f35488g;

    /* renamed from: h */
    private final WebViewClient f35489h;

    public interface MraidBridgeListener {
        void onClose();

        boolean onConsoleMessage(ConsoleMessage consoleMessage);

        void onExpand(URI uri, boolean z) throws C11493j;

        boolean onJsAlert(String str, JsResult jsResult);

        void onOpen(URI uri);

        void onPageFailedToLoad();

        void onPageLoaded();

        void onPlayVideo(URI uri);

        void onRenderProcessGone(MoPubErrorCode moPubErrorCode);

        void onResize(int i, int i2, int i3, int i4, ClosePosition closePosition, boolean z) throws C11493j;

        void onSetOrientationProperties(boolean z, C11472B b) throws C11493j;

        void onUseCustomClose(boolean z);

        void onVisibilityChanged(boolean z);
    }

    public static class MraidWebView extends BaseWebView {

        /* renamed from: c */
        private OnVisibilityChangedListener f35490c;

        /* renamed from: d */
        private VisibilityTracker f35491d;

        /* renamed from: e */
        private boolean f35492e;

        public interface OnVisibilityChangedListener {
            void onVisibilityChanged(boolean z);
        }

        public MraidWebView(Context context) {
            super(context);
            if (VERSION.SDK_INT <= 22) {
                this.f35492e = getVisibility() == 0;
                return;
            }
            this.f35491d = new VisibilityTracker(context);
            this.f35491d.setVisibilityTrackerListener(new C11492i(this));
        }

        /* access modifiers changed from: 0000 */
        public void setVisibilityChangedListener(OnVisibilityChangedListener listener) {
            this.f35490c = listener;
        }

        /* access modifiers changed from: protected */
        public void onVisibilityChanged(View changedView, int visibility) {
            super.onVisibilityChanged(changedView, visibility);
            VisibilityTracker visibilityTracker = this.f35491d;
            boolean z = true;
            if (visibilityTracker == null) {
                if (visibility != 0) {
                    z = false;
                }
                setMraidViewable(z);
                return;
            }
            if (visibility == 0) {
                visibilityTracker.clear();
                this.f35491d.addView(changedView, this, 0, 0, Integer.valueOf(1));
            } else {
                visibilityTracker.removeView(this);
                setMraidViewable(false);
            }
        }

        /* access modifiers changed from: private */
        public void setMraidViewable(boolean viewable) {
            if (this.f35492e != viewable) {
                this.f35492e = viewable;
                OnVisibilityChangedListener onVisibilityChangedListener = this.f35490c;
                if (onVisibilityChangedListener != null) {
                    onVisibilityChangedListener.onVisibilityChanged(viewable);
                }
            }
        }

        public boolean isMraidViewable() {
            return this.f35492e;
        }

        public void destroy() {
            super.destroy();
            this.f35491d = null;
            this.f35490c = null;
        }
    }

    MraidBridge(AdReport adReport, PlacementType placementType) {
        this(adReport, placementType, new MraidNativeCommandHandler());
    }

    @VisibleForTesting
    MraidBridge(AdReport adReport, PlacementType placementType, MraidNativeCommandHandler mraidNativeCommandHandler) {
        this.f35489h = new C11489f(this);
        this.f35482a = adReport;
        this.f35483b = placementType;
        this.f35484c = mraidNativeCommandHandler;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37602a(MraidBridgeListener listener) {
        this.f35485d = listener;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37603a(MraidWebView mraidWebView) {
        this.f35486e = mraidWebView;
        this.f35486e.getSettings().setJavaScriptEnabled(true);
        if (VERSION.SDK_INT >= 17 && this.f35483b == PlacementType.INTERSTITIAL) {
            mraidWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        this.f35486e.setScrollContainer(false);
        this.f35486e.setVerticalScrollBarEnabled(false);
        this.f35486e.setHorizontalScrollBarEnabled(false);
        this.f35486e.setBackgroundColor(0);
        this.f35486e.setWebViewClient(this.f35489h);
        this.f35486e.setWebChromeClient(new C11486c(this));
        this.f35487f = new ViewGestureDetector(this.f35486e.getContext(), (View) this.f35486e, this.f35482a);
        this.f35486e.setOnTouchListener(new C11487d(this));
        this.f35486e.setVisibilityChangedListener(new C11488e(this));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37600a() {
        MraidWebView mraidWebView = this.f35486e;
        if (mraidWebView != null) {
            mraidWebView.destroy();
            this.f35486e = null;
        }
    }

    public void setContentHtml(String htmlData) {
        MraidWebView mraidWebView = this.f35486e;
        if (mraidWebView == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "MRAID bridge called setContentHtml before WebView was attached");
            return;
        }
        this.f35488g = false;
        StringBuilder sb = new StringBuilder();
        sb.append(Networking.getBaseUrlScheme());
        sb.append("://");
        sb.append(Constants.HOST);
        sb.append("/");
        mraidWebView.loadDataWithBaseURL(sb.toString(), htmlData, "text/html", "UTF-8", null);
    }

    public void setContentUrl(String url) {
        MraidWebView mraidWebView = this.f35486e;
        if (mraidWebView == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "MRAID bridge called setContentHtml while WebView was not attached");
            return;
        }
        this.f35488g = false;
        mraidWebView.loadUrl(url);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo37610b(String javascript) {
        if (this.f35486e == null) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("Attempted to inject Javascript into MRAID WebView while was not attached:\n\t");
            sb.append(javascript);
            MoPubLog.log(sdkLogEvent, sb.toString());
            return;
        }
        SdkLogEvent sdkLogEvent2 = SdkLogEvent.CUSTOM;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Injecting Javascript into MRAID WebView:\n\t");
        sb2.append(javascript);
        MoPubLog.log(sdkLogEvent2, sb2.toString());
        MraidWebView mraidWebView = this.f35486e;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("javascript:");
        sb3.append(javascript);
        mraidWebView.loadUrl(sb3.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37957a(MraidJavascriptCommand command, String message) {
        StringBuilder sb = new StringBuilder();
        sb.append("window.mraidbridge.notifyErrorEvent(");
        sb.append(JSONObject.quote(command.mo37677e()));
        sb.append(", ");
        sb.append(JSONObject.quote(message));
        sb.append(")");
        mo37610b(sb.toString());
    }

    /* renamed from: a */
    private void m37956a(MraidJavascriptCommand command) {
        StringBuilder sb = new StringBuilder();
        sb.append("window.mraidbridge.nativeCallComplete(");
        sb.append(JSONObject.quote(command.mo37677e()));
        sb.append(")");
        mo37610b(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public boolean mo37609a(String url) {
        try {
            new URI(url);
            Uri uri = Uri.parse(url);
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if (BuildConfig.SDK_NAME.equals(scheme)) {
                if ("failLoad".equals(host) && this.f35483b == PlacementType.INLINE) {
                    MraidBridgeListener mraidBridgeListener = this.f35485d;
                    if (mraidBridgeListener != null) {
                        mraidBridgeListener.onPageFailedToLoad();
                    }
                }
                return true;
            }
            boolean c = mo37612c();
            String str = AdType.MRAID;
            if (c && !str.equals(scheme)) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("mraid://open?url=");
                    sb.append(URLEncoder.encode(url, "UTF-8"));
                    uri = Uri.parse(sb.toString());
                    host = uri.getHost();
                    scheme = uri.getScheme();
                } catch (UnsupportedEncodingException e) {
                    SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid MRAID URL encoding: ");
                    sb2.append(url);
                    MoPubLog.log(sdkLogEvent, sb2.toString());
                    m37957a(MraidJavascriptCommand.OPEN, "Non-mraid URL is invalid");
                    return false;
                }
            }
            if (!str.equals(scheme)) {
                return false;
            }
            MraidJavascriptCommand command = MraidJavascriptCommand.m38034a(host);
            try {
                mo37604a(command, MoPubRequestUtils.getQueryParamMap(uri));
            } catch (C11493j | IllegalArgumentException exception) {
                m37957a(command, exception.getMessage());
            }
            m37956a(command);
            return true;
        } catch (URISyntaxException e2) {
            SdkLogEvent sdkLogEvent2 = SdkLogEvent.CUSTOM;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Invalid MRAID URL: ");
            sb3.append(url);
            MoPubLog.log(sdkLogEvent2, sb3.toString());
            m37957a(MraidJavascriptCommand.UNSPECIFIED, "Mraid command sent an invalid URL");
            return true;
        }
    }

    /* access modifiers changed from: private */
    @VisibleForTesting
    /* renamed from: g */
    public void m37966g() {
        if (!this.f35488g) {
            this.f35488g = true;
            MraidBridgeListener mraidBridgeListener = this.f35485d;
            if (mraidBridgeListener != null) {
                mraidBridgeListener.onPageLoaded();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @TargetApi(26)
    @VisibleForTesting
    /* renamed from: a */
    public void mo37601a(RenderProcessGoneDetail detail) {
        MoPubErrorCode errorCode = (detail == null || !detail.didCrash()) ? MoPubErrorCode.RENDER_PROCESS_GONE_UNSPECIFIED : MoPubErrorCode.RENDER_PROCESS_GONE_WITH_CRASH;
        MoPubLog.log(SdkLogEvent.CUSTOM, errorCode);
        mo37600a();
        MraidBridgeListener mraidBridgeListener = this.f35485d;
        if (mraidBridgeListener != null) {
            mraidBridgeListener.onRenderProcessGone(errorCode);
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: a */
    public void mo37604a(MraidJavascriptCommand command, Map<String, String> params) throws C11493j {
        if (command.mo37676a(this.f35483b) && !mo37612c()) {
            throw new C11493j("Cannot execute this command unless the user clicks");
        } else if (this.f35485d == null) {
            throw new C11493j("Invalid state to execute this command");
        } else if (this.f35486e != null) {
            int i = C11491h.f35569a[command.ordinal()];
            String str = DeepLinksKeys.URI;
            String str2 = "shouldUseCustomClose";
            String str3 = "url";
            switch (i) {
                case 1:
                    this.f35485d.onClose();
                    return;
                case 2:
                    this.f35485d.onResize(m37950a(m37964e((String) params.get("width")), 0, 100000), m37950a(m37964e((String) params.get("height")), 0, 100000), m37950a(m37964e((String) params.get("offsetX")), -100000, 100000), m37950a(m37964e((String) params.get("offsetY")), -100000, 100000), m37951a((String) params.get("customClosePosition"), ClosePosition.TOP_RIGHT), m37958a((String) params.get("allowOffscreen"), true));
                    return;
                case 3:
                    this.f35485d.onExpand(m37954a((String) params.get(str3), (URI) null), m37958a((String) params.get(str2), false));
                    return;
                case 4:
                    this.f35485d.onUseCustomClose(m37958a((String) params.get(str2), false));
                    return;
                case 5:
                    this.f35485d.onOpen(m37965f((String) params.get(str3)));
                    return;
                case 6:
                    this.f35485d.onSetOrientationProperties(m37962c((String) params.get("allowOrientationChange")), m37963d((String) params.get("forceOrientation")));
                    return;
                case 7:
                    this.f35485d.onPlayVideo(m37965f((String) params.get(str)));
                    return;
                case 8:
                    this.f35484c.mo37681b(this.f35486e.getContext(), m37965f((String) params.get(str)).toString(), new C11490g(this, command));
                    return;
                case 9:
                    this.f35484c.mo37679a(this.f35486e.getContext(), params);
                    return;
                case 10:
                    throw new C11493j("Unspecified MRAID Javascript command");
                default:
                    return;
            }
        } else {
            throw new C11493j("The current WebView is being destroyed");
        }
    }

    /* renamed from: a */
    private ClosePosition m37951a(String text, ClosePosition defaultValue) throws C11493j {
        if (TextUtils.isEmpty(text)) {
            return defaultValue;
        }
        if (text.equals("top-left")) {
            return ClosePosition.TOP_LEFT;
        }
        if (text.equals("top-right")) {
            return ClosePosition.TOP_RIGHT;
        }
        if (text.equals("center")) {
            return ClosePosition.CENTER;
        }
        if (text.equals("bottom-left")) {
            return ClosePosition.BOTTOM_LEFT;
        }
        if (text.equals("bottom-right")) {
            return ClosePosition.BOTTOM_RIGHT;
        }
        if (text.equals("top-center")) {
            return ClosePosition.TOP_CENTER;
        }
        if (text.equals("bottom-center")) {
            return ClosePosition.BOTTOM_CENTER;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid close position: ");
        sb.append(text);
        throw new C11493j(sb.toString());
    }

    /* renamed from: e */
    private int m37964e(String text) throws C11493j {
        try {
            return Integer.parseInt(text, 10);
        } catch (NumberFormatException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid numeric parameter: ");
            sb.append(text);
            throw new C11493j(sb.toString());
        }
    }

    /* renamed from: d */
    private C11472B m37963d(String text) throws C11493j {
        if ("portrait".equals(text)) {
            return C11472B.PORTRAIT;
        }
        if ("landscape".equals(text)) {
            return C11472B.LANDSCAPE;
        }
        if ("none".equals(text)) {
            return C11472B.NONE;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid orientation: ");
        sb.append(text);
        throw new C11493j(sb.toString());
    }

    /* renamed from: a */
    private int m37950a(int value, int min, int max) throws C11493j {
        if (value >= min && value <= max) {
            return value;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Integer parameter out of range: ");
        sb.append(value);
        throw new C11493j(sb.toString());
    }

    /* renamed from: a */
    private boolean m37958a(String text, boolean defaultValue) throws C11493j {
        if (text == null) {
            return defaultValue;
        }
        return m37962c(text);
    }

    /* renamed from: c */
    private boolean m37962c(String text) throws C11493j {
        if ("true".equals(text)) {
            return true;
        }
        if (AdultContentAnalytics.UNLOCK.equals(text)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid boolean parameter: ");
        sb.append(text);
        throw new C11493j(sb.toString());
    }

    /* renamed from: a */
    private URI m37954a(String encodedText, URI defaultValue) throws C11493j {
        if (encodedText == null) {
            return defaultValue;
        }
        return m37965f(encodedText);
    }

    /* renamed from: f */
    private URI m37965f(String encodedText) throws C11493j {
        if (encodedText != null) {
            try {
                return new URI(encodedText);
            } catch (URISyntaxException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid URL parameter: ");
                sb.append(encodedText);
                throw new C11493j(sb.toString());
            }
        } else {
            throw new C11493j("Parameter cannot be null");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37607a(boolean isViewable) {
        StringBuilder sb = new StringBuilder();
        sb.append("mraidbridge.setIsViewable(");
        sb.append(isViewable);
        sb.append(")");
        mo37610b(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37605a(PlacementType placementType) {
        StringBuilder sb = new StringBuilder();
        sb.append("mraidbridge.setPlacementType(");
        sb.append(JSONObject.quote(placementType.mo37697e()));
        sb.append(")");
        mo37610b(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37606a(ViewState state) {
        StringBuilder sb = new StringBuilder();
        sb.append("mraidbridge.setState(");
        sb.append(JSONObject.quote(state.toJavascriptString()));
        sb.append(")");
        mo37610b(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37608a(boolean sms, boolean telephone, boolean calendar, boolean storePicture, boolean inlineVideo) {
        StringBuilder sb = new StringBuilder();
        sb.append("mraidbridge.setSupports(");
        sb.append(sms);
        String str = ",";
        sb.append(str);
        sb.append(telephone);
        sb.append(str);
        sb.append(calendar);
        sb.append(str);
        sb.append(storePicture);
        sb.append(str);
        sb.append(inlineVideo);
        sb.append(")");
        mo37610b(sb.toString());
    }

    /* renamed from: a */
    private String m37953a(Rect rect) {
        StringBuilder sb = new StringBuilder();
        sb.append(rect.left);
        String str = ",";
        sb.append(str);
        sb.append(rect.top);
        sb.append(str);
        sb.append(rect.width());
        sb.append(str);
        sb.append(rect.height());
        return sb.toString();
    }

    /* renamed from: b */
    private String m37960b(Rect rect) {
        StringBuilder sb = new StringBuilder();
        sb.append(rect.width());
        sb.append(",");
        sb.append(rect.height());
        return sb.toString();
    }

    public void notifyScreenMetrics(C11473C screenMetrics) {
        StringBuilder sb = new StringBuilder();
        sb.append("mraidbridge.setScreenSize(");
        sb.append(m37960b(screenMetrics.mo37594f()));
        sb.append(");mraidbridge.setMaxSize(");
        sb.append(m37960b(screenMetrics.mo37593e()));
        sb.append(");mraidbridge.setCurrentPosition(");
        sb.append(m37953a(screenMetrics.mo37585a()));
        sb.append(");mraidbridge.setDefaultPosition(");
        sb.append(m37953a(screenMetrics.mo37590c()));
        String str = ")";
        sb.append(str);
        mo37610b(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("mraidbridge.notifySizeChangeEvent(");
        sb2.append(m37960b(screenMetrics.mo37585a()));
        sb2.append(str);
        mo37610b(sb2.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo37615f() {
        mo37610b("mraidbridge.notifyReadyEvent();");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo37612c() {
        ViewGestureDetector gDetector = this.f35487f;
        return gDetector != null && gDetector.isClicked();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo37614e() {
        MraidWebView mraidWebView = this.f35486e;
        return mraidWebView != null && mraidWebView.isMraidViewable();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo37611b() {
        return this.f35486e != null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo37613d() {
        return this.f35488g;
    }
}
