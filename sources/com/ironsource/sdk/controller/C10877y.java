package com.ironsource.sdk.controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.MutableContextWrapper;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.ironsource.sdk.data.AdUnitsState;
import com.ironsource.sdk.data.C10888a;
import com.ironsource.sdk.data.C10890c;
import com.ironsource.sdk.data.C10891d;
import com.ironsource.sdk.data.C10893f;
import com.ironsource.sdk.data.C10894g;
import com.ironsource.sdk.data.C10895h;
import com.ironsource.sdk.data.C10896i;
import com.ironsource.sdk.data.C10897j;
import com.mopub.common.GpsHelper;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;
import p005cm.aptoide.p006pt.database.realm.Notification;
import p005cm.aptoide.p006pt.install.installer.RootCommandOnSubscribe;
import p019d.p273h.p274a.C12723a;
import p019d.p273h.p274a.C12724b;
import p019d.p273h.p274a.C12725c;
import p019d.p273h.p274a.C12727e;
import p019d.p273h.p274a.C12731g;
import p019d.p273h.p285d.p290d.C12977a;
import p019d.p273h.p285d.p292f.C12987c;
import p019d.p273h.p285d.p292f.C12989e;
import p019d.p273h.p285d.p292f.C12991g;
import p019d.p273h.p285d.p292f.p293a.C12982a;
import p019d.p273h.p285d.p292f.p293a.C12983b;
import p019d.p273h.p285d.p292f.p293a.C12984c;
import p019d.p273h.p285d.p292f.p293a.C12985d;
import p019d.p273h.p285d.p294g.C12992a;
import p019d.p273h.p285d.p294g.C12992a.C12995c;
import p019d.p273h.p285d.p295h.C12998a;
import p019d.p273h.p285d.p295h.C12999b;
import p019d.p273h.p285d.p295h.C13001d;
import p019d.p273h.p285d.p295h.C13002e;
import p019d.p273h.p285d.p295h.C13003f;
import p019d.p273h.p285d.p295h.C13004g;

/* renamed from: com.ironsource.sdk.controller.y */
/* compiled from: IronSourceWebView */
public class C10877y extends WebView implements C12995c, DownloadListener {

    /* renamed from: a */
    public static int f33143a = 0;

    /* renamed from: b */
    public static String f33144b = "is_store";

    /* renamed from: c */
    public static String f33145c = "is_store_close";

    /* renamed from: d */
    public static String f33146d = "webview_type";

    /* renamed from: e */
    public static String f33147e = "external_url";

    /* renamed from: f */
    public static String f33148f = "secondary_web_view";

    /* renamed from: g */
    public static int f33149g = 0;

    /* renamed from: h */
    public static int f33150h = 1;

    /* renamed from: i */
    public static String f33151i = "appIds";

    /* renamed from: j */
    public static String f33152j = "requestId";

    /* renamed from: k */
    public static String f33153k = "isInstalled";

    /* renamed from: l */
    public static String f33154l = "result";
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static String f33155m = RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public static String f33156n = "fail";
    /* access modifiers changed from: private */

    /* renamed from: A */
    public CountDownTimer f33157A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public CountDownTimer f33158B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public CountDownTimer f33159C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public int f33160D = 50;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public int f33161E = 50;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public String f33162F = "top-right";

    /* renamed from: G */
    private C10878a f33163G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public View f33164H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public FrameLayout f33165I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public CustomViewCallback f33166J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public FrameLayout f33167K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public C10884f f33168L;

    /* renamed from: M */
    private String f33169M;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public C12985d f33170N;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public C12987c f33171O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public C12984c f33172P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public C12989e f33173Q;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public C12983b f33174R;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public C10893f f33175S = C10893f.None;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public Boolean f33176T = null;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public String f33177U;
    /* access modifiers changed from: private */

    /* renamed from: V */
    public C10863la f33178V;
    /* access modifiers changed from: private */

    /* renamed from: W */
    public AdUnitsState f33179W;

    /* renamed from: aa */
    private Object f33180aa = new Object();

    /* renamed from: ba */
    Context f33181ba;

    /* renamed from: ca */
    Handler f33182ca;
    /* access modifiers changed from: private */

    /* renamed from: da */
    public boolean f33183da = false;
    /* access modifiers changed from: private */

    /* renamed from: ea */
    public C10859k f33184ea;
    /* access modifiers changed from: private */

    /* renamed from: fa */
    public C10851ga f33185fa;
    /* access modifiers changed from: private */

    /* renamed from: ga */
    public C10860ka f33186ga;
    /* access modifiers changed from: private */

    /* renamed from: ha */
    public C10839b f33187ha;

    /* renamed from: ia */
    private ArrayList<String> f33188ia;

    /* renamed from: ja */
    private C10865ma f33189ja;

    /* renamed from: ka */
    private BroadcastReceiver f33190ka = new C10867o(this);
    /* access modifiers changed from: private */

    /* renamed from: la */
    public C12991g f33191la;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public String f33192o = C10877y.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: p */
    public String f33193p = "IronSource";

    /* renamed from: q */
    private final String f33194q = "We're sorry, some error occurred. we will investigate it";
    /* access modifiers changed from: private */

    /* renamed from: r */
    public String f33195r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public String f33196s;

    /* renamed from: t */
    private Map<String, String> f33197t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public C12992a f33198u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f33199v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f33200w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f33201x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f33202y;

    /* renamed from: z */
    private String f33203z = "interrupt";

    /* renamed from: com.ironsource.sdk.controller.y$a */
    /* compiled from: IronSourceWebView */
    private class C10878a extends WebChromeClient {
        private C10878a() {
        }

        /* synthetic */ C10878a(C10877y x0, C10869q x1) {
            this();
        }

        public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
            WebView childView = new WebView(view.getContext());
            childView.setWebChromeClient(this);
            childView.setWebViewClient(new C10879b(C10877y.this, null));
            ((WebViewTransport) resultMsg.obj).setWebView(childView);
            resultMsg.sendToTarget();
            String str = "onCreateWindow";
            C13003f.m42438c(str, str);
            return true;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            StringBuilder sb = new StringBuilder();
            sb.append(consoleMessage.message());
            sb.append(" -- From line ");
            sb.append(consoleMessage.lineNumber());
            sb.append(" of ");
            sb.append(consoleMessage.sourceId());
            C13003f.m42438c("MyApplication", sb.toString());
            return true;
        }

        public void onShowCustomView(View view, CustomViewCallback callback) {
            String str = "Test";
            C13003f.m42438c(str, "onShowCustomView");
            C10877y.this.setVisibility(8);
            if (C10877y.this.f33164H != null) {
                C13003f.m42438c(str, "mCustomView != null");
                callback.onCustomViewHidden();
                return;
            }
            C13003f.m42438c(str, "mCustomView == null");
            C10877y.this.f33165I.addView(view);
            C10877y.this.f33164H = view;
            C10877y.this.f33166J = callback;
            C10877y.this.f33165I.setVisibility(0);
        }

        public View getVideoLoadingProgressView() {
            FrameLayout frameLayout = new FrameLayout(C10877y.this.getCurrentActivityContext());
            frameLayout.setLayoutParams(new LayoutParams(-1, -1));
            return frameLayout;
        }

        public void onHideCustomView() {
            C13003f.m42438c("Test", "onHideCustomView");
            if (C10877y.this.f33164H != null) {
                C10877y.this.f33164H.setVisibility(8);
                C10877y.this.f33165I.removeView(C10877y.this.f33164H);
                C10877y.this.f33164H = null;
                C10877y.this.f33165I.setVisibility(8);
                C10877y.this.f33166J.onCustomViewHidden();
                C10877y.this.setVisibility(0);
            }
        }
    }

    /* renamed from: com.ironsource.sdk.controller.y$b */
    /* compiled from: IronSourceWebView */
    private class C10879b extends WebViewClient {
        private C10879b() {
        }

        /* synthetic */ C10879b(C10877y x0, C10869q x1) {
            this();
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Context ctx = C10877y.this.getCurrentActivityContext();
            Intent intent = new Intent(ctx, OpenUrlActivity.class);
            intent.putExtra(C10877y.f33147e, url);
            intent.putExtra(C10877y.f33148f, false);
            ctx.startActivity(intent);
            return true;
        }
    }

    /* renamed from: com.ironsource.sdk.controller.y$c */
    /* compiled from: IronSourceWebView */
    public class C10880c {

        /* renamed from: a */
        volatile int f33206a = 0;

        /* renamed from: com.ironsource.sdk.controller.y$c$a */
        /* compiled from: IronSourceWebView */
        class C10881a {
            C10881a() {
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public void mo35606a(boolean isSuccess, String callbackFunction, String messageData) {
                C10897j res = new C10897j();
                res.mo35668a(isSuccess ? C10877y.f33155m : C10877y.f33156n, callbackFunction);
                res.mo35668a("data", messageData);
                C10877y.this.m35491a(res.toString(), isSuccess, (String) null, (String) null);
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public void mo35605a(boolean isSuccess, String callbackFunction, C10897j messageData) {
                messageData.mo35668a(isSuccess ? C10877y.f33155m : C10877y.f33156n, callbackFunction);
                C10877y.this.m35491a(messageData.toString(), isSuccess, (String) null, (String) null);
            }
        }

        public C10880c(Context context) {
        }

        @JavascriptInterface
        public void initController(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("initController(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10897j ssaObj = new C10897j(value);
            String str = "stage";
            if (ssaObj.mo35670a(str)) {
                String stage = ssaObj.mo35673d(str);
                if ("ready".equalsIgnoreCase(stage)) {
                    mo35532c();
                } else if ("loaded".equalsIgnoreCase(stage)) {
                    mo35530b();
                } else if ("failed".equalsIgnoreCase(stage)) {
                    mo35523a();
                } else {
                    C13003f.m42438c(C10877y.this.f33192o, "No STAGE mentioned! Should not get here!");
                }
                C10877y.this.mo35461a((Runnable) new C10820J(this));
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo35530b() {
            C10877y.this.f33175S = C10893f.Loaded;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo35532c() {
            C10877y.this.f33175S = C10893f.Ready;
            C10877y.this.f33159C.cancel();
            if (C10877y.this.f33158B != null) {
                C10877y.this.f33158B.cancel();
            }
            C10877y.this.m35543o();
            C10877y yVar = C10877y.this;
            yVar.mo35458a(yVar.f33179W);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo35523a() {
            C10877y.this.f33175S = C10893f.Failed;
            Iterator it = C10877y.this.f33184ea.mo35439a(C10895h.RewardedVideo).iterator();
            while (it.hasNext()) {
                C10890c demandSource = (C10890c) it.next();
                if (demandSource.mo35650b() == 1) {
                    C10877y.this.m35505c(C10895h.RewardedVideo, demandSource);
                }
            }
            Iterator it2 = C10877y.this.f33184ea.mo35439a(C10895h.Interstitial).iterator();
            while (it2.hasNext()) {
                C10890c demandSource2 = (C10890c) it2.next();
                if (demandSource2.mo35650b() == 1) {
                    C10877y.this.m35505c(C10895h.Interstitial, demandSource2);
                }
            }
            Iterator it3 = C10877y.this.f33184ea.mo35439a(C10895h.Banner).iterator();
            while (it3.hasNext()) {
                C10890c demandSource3 = (C10890c) it3.next();
                if (demandSource3.mo35650b() == 1) {
                    C10877y.this.m35505c(C10895h.Banner, demandSource3);
                }
            }
            if (C10877y.this.f33199v) {
                C10877y.this.m35505c(C10895h.OfferWall, (C10890c) null);
            }
            if (C10877y.this.f33200w) {
                C10877y.this.m35505c(C10895h.OfferWallCredits, (C10890c) null);
            }
        }

        @JavascriptInterface
        public void alert(String message) {
        }

        @JavascriptInterface
        public void getDeviceStatus(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("getDeviceStatus(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            String successFunToCall = C10877y.this.m35530i(value);
            String failFunToCall = C10877y.this.m35528h(value);
            Object[] objArr = new Object[2];
            C10877y yVar = C10877y.this;
            Object[] resultArr = yVar.m35516e(yVar.getContext());
            String params = (String) resultArr[0];
            String funToCall = null;
            if (((Boolean) resultArr[1]).booleanValue()) {
                if (!TextUtils.isEmpty(failFunToCall)) {
                    funToCall = failFunToCall;
                }
            } else if (!TextUtils.isEmpty(successFunToCall)) {
                funToCall = successFunToCall;
            }
            if (!TextUtils.isEmpty(funToCall)) {
                C10877y.this.m35536l(C10877y.this.m35484a(funToCall, params, "onGetDeviceStatusSuccess", "onGetDeviceStatusFail"));
            }
        }

        @JavascriptInterface
        public void setMixedContentAlwaysAllow(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("setMixedContentAlwaysAllow(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10877y.this.mo35461a((Runnable) new C10832V(this));
        }

        @JavascriptInterface
        public void setAllowFileAccessFromFileURLs(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("setAllowFileAccessFromFileURLs(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10877y.this.mo35461a((Runnable) new C10834X(this, new C10897j(value).mo35672c("allowFileAccess")));
        }

        @JavascriptInterface
        public void getControllerConfig(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("getControllerConfig(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            String successFunToCall = new C10897j(value).mo35673d(C10877y.f33155m);
            if (!TextUtils.isEmpty(successFunToCall)) {
                String params = C13004g.m42455c();
                String testerParameters = C13004g.m42467j();
                if (areTesterParametersValid(testerParameters)) {
                    try {
                        params = addTesterParametersToConfig(params, testerParameters);
                    } catch (JSONException e) {
                        C13003f.m42436a(C10877y.this.f33192o, "getControllerConfig Error while parsing Tester AB Group parameters");
                    }
                }
                C10877y.this.m35536l(C10877y.this.m35510d(successFunToCall, params));
            }
        }

        @JavascriptInterface
        public String addTesterParametersToConfig(String originalConfiguration, String testerParameters) throws JSONException {
            JSONObject config = new JSONObject(originalConfiguration);
            JSONObject testerParams = new JSONObject(testerParameters);
            String str = "testerABGroup";
            config.putOpt(str, testerParams.get(str));
            String str2 = "testFriendlyName";
            config.putOpt(str2, testerParams.get(str2));
            return config.toString();
        }

        @JavascriptInterface
        public boolean areTesterParametersValid(String testerParameters) {
            if (!TextUtils.isEmpty(testerParameters) && !testerParameters.contains("-1")) {
                try {
                    JSONObject testerParams = new JSONObject(testerParameters);
                    if (!testerParams.getString("testerABGroup").isEmpty() && !testerParams.getString("testFriendlyName").isEmpty()) {
                        return true;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }

        @JavascriptInterface
        public void getApplicationInfo(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("getApplicationInfo(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            String successFunToCall = C10877y.this.m35530i(value);
            String failFunToCall = C10877y.this.m35528h(value);
            C10897j ssaObj = new C10897j(value);
            String funToCall = null;
            Object[] objArr = new Object[2];
            Object[] resultArr = C10877y.this.m35517e(ssaObj.mo35673d("productType"), C13004g.m42442a(ssaObj));
            String params = (String) resultArr[0];
            if (((Boolean) resultArr[1]).booleanValue()) {
                if (!TextUtils.isEmpty(failFunToCall)) {
                    funToCall = failFunToCall;
                }
            } else if (!TextUtils.isEmpty(successFunToCall)) {
                funToCall = successFunToCall;
            }
            if (!TextUtils.isEmpty(funToCall)) {
                C10877y.this.m35536l(C10877y.this.m35484a(funToCall, params, "onGetApplicationInfoSuccess", "onGetApplicationInfoFail"));
            }
        }

        @JavascriptInterface
        public void checkInstalledApps(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("checkInstalledApps(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            String successFunToCall = C10877y.this.m35530i(value);
            String failFunToCall = C10877y.this.m35528h(value);
            String funToCall = null;
            C10897j ssaObj = new C10897j(value);
            Object[] resultArr = C10877y.this.m35521f(ssaObj.mo35673d(C10877y.f33151i), ssaObj.mo35673d(C10877y.f33152j));
            String params = (String) resultArr[0];
            if (((Boolean) resultArr[1]).booleanValue()) {
                if (!TextUtils.isEmpty(failFunToCall)) {
                    funToCall = failFunToCall;
                }
            } else if (!TextUtils.isEmpty(successFunToCall)) {
                funToCall = successFunToCall;
            }
            if (!TextUtils.isEmpty(funToCall)) {
                C10877y.this.m35536l(C10877y.this.m35484a(funToCall, params, "onCheckInstalledAppsSuccess", "onCheckInstalledAppsFail"));
            }
        }

        @JavascriptInterface
        public void saveFile(String value) {
            String folder;
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("saveFile(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10896i ssaFile = new C10896i(value);
            if (C12725c.m41084a(C10877y.this.f33177U) <= 0) {
                C10877y.this.m35491a(value, false, "no_disk_space", (String) null);
            } else if (!C13004g.m42468k()) {
                C10877y.this.m35491a(value, false, "sotrage_unavailable", (String) null);
            } else if (C13002e.m42424a(C10877y.this.f33177U, ssaFile)) {
                C10877y.this.m35491a(value, false, "file_already_exist", (String) null);
            } else if (!C12724b.m41078f(C10877y.this.getContext())) {
                C10877y.this.m35491a(value, false, "no_network_connection", (String) null);
            } else {
                C10877y.this.m35491a(value, true, (String) null, (String) null);
                Object lastUpdateTimeObj = ssaFile.mo35663d();
                if (lastUpdateTimeObj != null) {
                    String lastUpdateTimeStr = String.valueOf(lastUpdateTimeObj);
                    if (!TextUtils.isEmpty(lastUpdateTimeStr)) {
                        String path = ssaFile.mo35664e();
                        String str = "/";
                        if (path.contains(str)) {
                            String[] splitArr = ssaFile.mo35664e().split(str);
                            folder = splitArr[splitArr.length - 1];
                        } else {
                            folder = path;
                        }
                        C13001d.m42395g().mo41895a(folder, lastUpdateTimeStr);
                    }
                }
                C10877y.this.f33198u.mo41860a(ssaFile);
            }
        }

        @JavascriptInterface
        public void adUnitsReady(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("adUnitsReady(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            String demandSourceId = C13004g.m42442a(new C10897j(value));
            C10888a adUnitsReady = new C10888a(value);
            if (!adUnitsReady.mo35639d()) {
                C10877y.this.m35491a(value, false, "Num Of Ad Units Do Not Exist", (String) null);
                return;
            }
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            String product = adUnitsReady.mo35638c();
            if (C10895h.RewardedVideo.toString().equalsIgnoreCase(product) && C10877y.this.m35539m(product)) {
                C10877y.this.mo35461a((Runnable) new C10835Y(this, adUnitsReady, demandSourceId));
            }
        }

        @JavascriptInterface
        public void deleteFolder(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("deleteFolder(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10896i file = new C10896i(value);
            if (!C13002e.m42431c(C10877y.this.f33177U, file.mo35664e())) {
                C10877y.this.m35491a(value, false, "Folder not exist", "1");
                return;
            }
            C10877y.this.m35491a(value, C13002e.m42425a(C10877y.this.f33177U, file.mo35664e()), (String) null, (String) null);
        }

        @JavascriptInterface
        public void deleteFile(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("deleteFile(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10896i file = new C10896i(value);
            if (!C13002e.m42431c(C10877y.this.f33177U, file.mo35664e())) {
                C10877y.this.m35491a(value, false, "File not exist", "1");
                return;
            }
            C10877y.this.m35491a(value, C13002e.m42426a(C10877y.this.f33177U, file.mo35664e(), file.mo35662c()), (String) null, (String) null);
        }

        @JavascriptInterface
        public void displayWebView(String value) {
            Intent intent;
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("displayWebView(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            C10897j ssaObj = new C10897j(value);
            boolean display = ((Boolean) ssaObj.mo35671b("display")).booleanValue();
            String str = "productType";
            String productType = ssaObj.mo35673d(str);
            boolean isStandaloneView = ssaObj.mo35672c("standaloneView");
            String demandSourceId = C13004g.m42442a(ssaObj);
            if (display) {
                String str2 = "immersive";
                C10877y.this.f33183da = ssaObj.mo35672c(str2);
                boolean isActivityThemeTranslucent = ssaObj.mo35672c("activityThemeTranslucent");
                C10884f state = C10877y.this.getState();
                C10884f fVar = C10884f.Display;
                String str3 = "State: ";
                if (state != fVar) {
                    C10877y.this.setState(fVar);
                    String z2 = C10877y.this.f33192o;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str3);
                    sb2.append(C10877y.this.f33168L);
                    C13003f.m42438c(z2, sb2.toString());
                    Context context = C10877y.this.getCurrentActivityContext();
                    String orientation = C10877y.this.getOrientationState();
                    int rotation = C12725c.m41092c(context);
                    if (isStandaloneView) {
                        C10857j controllerView = new C10857j(context);
                        controllerView.addView(C10877y.this.f33167K);
                        controllerView.mo35434a(C10877y.this);
                        return;
                    }
                    if (isActivityThemeTranslucent) {
                        intent = new Intent(context, InterstitialActivity.class);
                    } else {
                        intent = new Intent(context, ControllerActivity.class);
                    }
                    String str4 = "application";
                    if (C10895h.RewardedVideo.toString().equalsIgnoreCase(productType)) {
                        if (str4.equals(orientation)) {
                            orientation = C13004g.m42456c(C12725c.m41082a(C10877y.this.getCurrentActivityContext()));
                        }
                        intent.putExtra(str, C10895h.RewardedVideo.toString());
                        C10877y.this.f33179W.mo35615a(C10895h.RewardedVideo.ordinal());
                        C10877y.this.f33179W.mo35616a(demandSourceId);
                        if (C10877y.this.m35539m(C10895h.RewardedVideo.toString())) {
                            C10877y.this.f33170N.mo41824a(C10895h.RewardedVideo, demandSourceId);
                        }
                    } else if (C10895h.OfferWall.toString().equalsIgnoreCase(productType)) {
                        intent.putExtra(str, C10895h.OfferWall.toString());
                        C10877y.this.f33179W.mo35615a(C10895h.OfferWall.ordinal());
                    } else if (C10895h.Interstitial.toString().equalsIgnoreCase(productType)) {
                        if (str4.equals(orientation)) {
                            orientation = C13004g.m42456c(C12725c.m41082a(C10877y.this.getCurrentActivityContext()));
                        }
                        intent.putExtra(str, C10895h.Interstitial.toString());
                    }
                    intent.setFlags(536870912);
                    intent.putExtra(str2, C10877y.this.f33183da);
                    intent.putExtra("orientation_set_flag", orientation);
                    intent.putExtra("rotation_set_flag", rotation);
                    context.startActivity(intent);
                    return;
                }
                String z3 = C10877y.this.f33192o;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str3);
                sb3.append(C10877y.this.f33168L);
                C13003f.m42438c(z3, sb3.toString());
                return;
            }
            C10877y.this.setState(C10884f.Gone);
            C10877y.this.m35541n();
        }

        @JavascriptInterface
        public void getOrientation(String value) {
            String funToCall = C10877y.this.m35530i(value);
            String params = C13004g.m42447a(C10877y.this.getCurrentActivityContext()).toString();
            if (!TextUtils.isEmpty(funToCall)) {
                C10877y.this.m35536l(C10877y.this.m35484a(funToCall, params, "onGetOrientationSuccess", "onGetOrientationFail"));
            }
        }

        @JavascriptInterface
        public void setOrientation(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("setOrientation(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            String orientation = new C10897j(value).mo35673d(AdUnitActivity.EXTRA_ORIENTATION);
            C10877y.this.setOrientationState(orientation);
            int rotation = C12725c.m41092c(C10877y.this.getCurrentActivityContext());
            if (C10877y.this.f33191la != null) {
                C10877y.this.f33191la.mo35354a(orientation, rotation);
            }
        }

        @JavascriptInterface
        public void getCachedFilesMap(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("getCachedFilesMap(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            String funToCall = C10877y.this.m35530i(value);
            if (!TextUtils.isEmpty(funToCall)) {
                C10897j ssaObj = new C10897j(value);
                String str = "path";
                if (!ssaObj.mo35670a(str)) {
                    C10877y.this.m35491a(value, false, "path key does not exist", (String) null);
                    return;
                }
                String mapPath = (String) ssaObj.mo35671b(str);
                if (!C13002e.m42431c(C10877y.this.f33177U, mapPath)) {
                    C10877y.this.m35491a(value, false, "path file does not exist on disk", (String) null);
                    return;
                }
                C10877y.this.m35536l(C10877y.this.m35484a(funToCall, C13002e.m42429b(C10877y.this.f33177U, mapPath), "onGetCachedFilesMapSuccess", "onGetCachedFilesMapFail"));
            }
        }

        /* renamed from: a */
        private void m35604a(String funToCall, String params) {
            if (!TextUtils.isEmpty(funToCall)) {
                C10877y.this.m35536l(C10877y.this.m35510d(funToCall, params));
            }
        }

        @JavascriptInterface
        public void getDemandSourceState(String value) {
            String funToCall;
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("getMediationState(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10897j ssaObj = new C10897j(value);
            String str = "demandSourceName";
            String demandSourceName = ssaObj.mo35673d(str);
            String demandSourceId = C13004g.m42442a(ssaObj);
            String str2 = "productType";
            String product = ssaObj.mo35673d(str2);
            if (product != null && demandSourceName != null) {
                try {
                    C10895h productType = C13004g.m42458d(product);
                    if (productType != null) {
                        C10890c demandSource = C10877y.this.f33184ea.mo35437a(productType, demandSourceId);
                        JSONObject obj = new JSONObject();
                        obj.put(str2, product);
                        obj.put(str, demandSourceName);
                        obj.put("demandSourceId", demandSourceId);
                        if (demandSource == null || demandSource.mo35649a(-1)) {
                            funToCall = C10877y.this.m35528h(value);
                        } else {
                            funToCall = C10877y.this.m35530i(value);
                            obj.put("state", demandSource.mo35657g());
                        }
                        m35604a(funToCall, obj.toString());
                    }
                } catch (Exception ex) {
                    C10877y.this.m35491a(value, false, ex.getMessage(), (String) null);
                    ex.printStackTrace();
                }
            }
        }

        @JavascriptInterface
        public void adCredited(String value) {
            String totalCreditsStr;
            boolean md5Signature;
            String latestCompeltionsTime;
            boolean totalCreditsFlag;
            boolean md5Signature2;
            String str = value;
            String u = C10877y.this.f33193p;
            StringBuilder sb = new StringBuilder();
            sb.append("adCredited(");
            sb.append(str);
            sb.append(")");
            Log.d(u, sb.toString());
            C10897j ssaObj = new C10897j(str);
            String creditsStr = ssaObj.mo35673d("credits");
            int credits = creditsStr != null ? Integer.parseInt(creditsStr) : 0;
            String demandSourceId = C13004g.m42442a(ssaObj);
            String product = ssaObj.mo35673d("productType");
            if (TextUtils.isEmpty(product)) {
                Log.d(C10877y.this.f33193p, "adCredited | not product NAME !!!!");
            }
            if (C10895h.Interstitial.toString().equalsIgnoreCase(product)) {
                m35603a(demandSourceId, credits);
                return;
            }
            String totalCreditsStr2 = ssaObj.mo35673d("total");
            int totalCredits = totalCreditsStr2 != null ? Integer.parseInt(totalCreditsStr2) : 0;
            boolean c = ssaObj.mo35672c("externalPoll");
            if (C10895h.OfferWall.toString().equalsIgnoreCase(product)) {
                String str2 = "signature";
                if (!ssaObj.mo35674e(str2)) {
                    String str3 = "timestamp";
                    if (!ssaObj.mo35674e(str3)) {
                        String str4 = "totalCreditsFlag";
                        if (ssaObj.mo35674e(str4)) {
                            String str5 = totalCreditsStr2;
                            C10877y.this.m35491a(str, false, "One of the keys are missing: signature/timestamp/totalCreditsFlag", (String) null);
                            return;
                        }
                        String controllerMD5 = ssaObj.mo35673d(str2);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(totalCreditsStr2);
                        sb2.append(C10877y.this.f33195r);
                        StringBuilder sig = sb2.append(C10877y.this.f33196s);
                        if (controllerMD5.equalsIgnoreCase(C13004g.m42457c(sig.toString()))) {
                            md5Signature2 = true;
                            StringBuilder sb3 = sig;
                            totalCreditsStr = totalCreditsStr2;
                        } else {
                            StringBuilder sb4 = sig;
                            totalCreditsStr = totalCreditsStr2;
                            C10877y.this.m35491a(str, false, "Controller signature is not equal to SDK signature", (String) null);
                            md5Signature2 = false;
                        }
                        totalCreditsFlag = ssaObj.mo35672c(str4);
                        latestCompeltionsTime = ssaObj.mo35673d(str3);
                        md5Signature = md5Signature2;
                    }
                }
                String str6 = totalCreditsStr2;
                C10877y.this.m35491a(str, false, "One of the keys are missing: signature/timestamp/totalCreditsFlag", (String) null);
                return;
            }
            totalCreditsFlag = false;
            latestCompeltionsTime = null;
            md5Signature = false;
            totalCreditsStr = totalCreditsStr2;
            if (C10877y.this.m35539m(product)) {
                boolean mTotalCreditsFlag = totalCreditsFlag;
                String mlatestCompeltionsTime = latestCompeltionsTime;
                boolean mMd5Signature = md5Signature;
                C10877y yVar = C10877y.this;
                C10836Z z = r0;
                C10877y yVar2 = yVar;
                String str7 = totalCreditsStr;
                String str8 = product;
                C10836Z z2 = new C10836Z(this, product, demandSourceId, credits, mMd5Signature, totalCredits, mTotalCreditsFlag, mlatestCompeltionsTime, value);
                yVar2.mo35461a((Runnable) z);
            } else {
                String str9 = totalCreditsStr;
            }
        }

        /* renamed from: a */
        private void m35603a(String demandSourceId, int credits) {
            if (C10877y.this.m35539m(C10895h.Interstitial.toString())) {
                C10890c demandSource = C10877y.this.f33184ea.mo35437a(C10895h.Interstitial, demandSourceId);
                if (demandSource != null && demandSource.mo35658h()) {
                    C10877y.this.mo35461a((Runnable) new C10838aa(this, demandSourceId, credits));
                }
            }
        }

        @JavascriptInterface
        public void removeCloseEventHandler(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("removeCloseEventHandler(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            if (C10877y.this.f33157A != null) {
                C10877y.this.f33157A.cancel();
            }
            C10877y.this.f33202y = true;
        }

        @JavascriptInterface
        public void onGetDeviceStatusSuccess(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onGetDeviceStatusSuccess(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            C10877y.this.m35529h("onGetDeviceStatusSuccess", value);
        }

        @JavascriptInterface
        public void onGetDeviceStatusFail(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onGetDeviceStatusFail(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            C10877y.this.m35529h("onGetDeviceStatusFail", value);
        }

        @JavascriptInterface
        public void onInitRewardedVideoSuccess(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onInitRewardedVideoSuccess(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C13001d.m42395g().mo41893a(new C10891d(value));
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            C10877y.this.m35529h("onInitRewardedVideoSuccess", value);
        }

        @JavascriptInterface
        public void onInitRewardedVideoFail(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onInitRewardedVideoFail(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10897j ssaObj = new C10897j(value);
            String message = ssaObj.mo35673d("errMsg");
            String demandSourceId = C13004g.m42442a(ssaObj);
            C10890c demandSource = C10877y.this.f33184ea.mo35437a(C10895h.RewardedVideo, demandSourceId);
            if (demandSource != null) {
                demandSource.mo35651b(3);
            }
            if (C10877y.this.m35539m(C10895h.RewardedVideo.toString())) {
                C10877y.this.mo35461a((Runnable) new C10840ba(this, message, demandSourceId));
            }
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            C10877y.this.m35529h("onInitRewardedVideoFail", value);
        }

        @JavascriptInterface
        public void onGetApplicationInfoSuccess(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onGetApplicationInfoSuccess(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            C10877y.this.m35529h("onGetApplicationInfoSuccess", value);
        }

        @JavascriptInterface
        public void onGetApplicationInfoFail(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onGetApplicationInfoFail(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            C10877y.this.m35529h("onGetApplicationInfoFail", value);
        }

        @JavascriptInterface
        public void onShowRewardedVideoSuccess(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onShowRewardedVideoSuccess(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            C10877y.this.m35529h("onShowRewardedVideoSuccess", value);
        }

        @JavascriptInterface
        public void onShowRewardedVideoFail(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onShowRewardedVideoFail(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10897j ssaObj = new C10897j(value);
            String message = ssaObj.mo35673d("errMsg");
            String demandSourceId = C13004g.m42442a(ssaObj);
            if (C10877y.this.m35539m(C10895h.RewardedVideo.toString())) {
                C10877y.this.mo35461a((Runnable) new C10843ca(this, message, demandSourceId));
            }
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            C10877y.this.m35529h("onShowRewardedVideoFail", value);
        }

        @JavascriptInterface
        public void onGetCachedFilesMapSuccess(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onGetCachedFilesMapSuccess(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            C10877y.this.m35529h("onGetCachedFilesMapSuccess", value);
        }

        @JavascriptInterface
        public void onGetCachedFilesMapFail(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onGetCachedFilesMapFail(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            C10877y.this.m35529h("onGetCachedFilesMapFail", value);
        }

        @JavascriptInterface
        public void onShowOfferWallSuccess(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onShowOfferWallSuccess(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10877y.this.f33179W.mo35615a(C10895h.OfferWall.ordinal());
            String placementId = C13004g.m42453b(value, "placementId");
            if (C10877y.this.m35539m(C10895h.OfferWall.toString())) {
                C10877y.this.mo35461a((Runnable) new C10845da(this, placementId));
            }
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            C10877y.this.m35529h("onShowOfferWallSuccess", value);
        }

        @JavascriptInterface
        public void onShowOfferWallFail(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onShowOfferWallFail(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            String message = new C10897j(value).mo35673d("errMsg");
            if (C10877y.this.m35539m(C10895h.OfferWall.toString())) {
                C10877y.this.mo35461a((Runnable) new C10887z(this, message));
            }
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            C10877y.this.m35529h("onShowOfferWallFail", value);
        }

        @JavascriptInterface
        public void onInitInterstitialSuccess(String value) {
            C13003f.m42438c(C10877y.this.f33192o, "onInitInterstitialSuccess()");
            C10877y.this.m35529h("onInitInterstitialSuccess", "true");
            String demandSourceId = C13004g.m42442a(new C10897j(value));
            if (TextUtils.isEmpty(demandSourceId)) {
                C13003f.m42438c(C10877y.this.f33192o, "onInitInterstitialSuccess failed with no demand source");
                return;
            }
            if (C10877y.this.m35539m(C10895h.Interstitial.toString())) {
                C10877y.this.mo35461a((Runnable) new C10811A(this, demandSourceId));
            }
        }

        @JavascriptInterface
        public void onInitInterstitialFail(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onInitInterstitialFail(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10897j ssaObj = new C10897j(value);
            String message = ssaObj.mo35673d("errMsg");
            String demandSourceId = C13004g.m42442a(ssaObj);
            if (TextUtils.isEmpty(demandSourceId)) {
                C13003f.m42438c(C10877y.this.f33192o, "onInitInterstitialSuccess failed with no demand source");
                return;
            }
            C10890c demandSource = C10877y.this.f33184ea.mo35437a(C10895h.Interstitial, demandSourceId);
            if (demandSource != null) {
                demandSource.mo35651b(3);
            }
            if (C10877y.this.m35539m(C10895h.Interstitial.toString())) {
                C10877y.this.mo35461a((Runnable) new C10812B(this, message, demandSourceId));
            }
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            C10877y.this.m35529h("onInitInterstitialFail", value);
        }

        @JavascriptInterface
        public void adClicked(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("adClicked(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10897j ssaObj = new C10897j(value);
            String productType = ssaObj.mo35673d("productType");
            String demandSourceId = C13004g.m42442a(ssaObj);
            if (!TextUtils.isEmpty(demandSourceId)) {
                C10895h eProductType = C10877y.this.m35535k(productType);
                C12982a listener = C10877y.this.m35476a(eProductType);
                if (!(eProductType == null || listener == null)) {
                    C10877y.this.mo35461a((Runnable) new C10813C(this, listener, eProductType, demandSourceId));
                }
            }
        }

        @JavascriptInterface
        public void onShowInterstitialSuccess(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onShowInterstitialSuccess(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            String demandSourceId = C13004g.m42442a(new C10897j(value));
            if (TextUtils.isEmpty(demandSourceId)) {
                C13003f.m42438c(C10877y.this.f33192o, "onShowInterstitialSuccess called with no demand");
                return;
            }
            C10877y.this.f33179W.mo35615a(C10895h.Interstitial.ordinal());
            C10877y.this.f33179W.mo35616a(demandSourceId);
            if (C10877y.this.m35539m(C10895h.Interstitial.toString())) {
                C10877y.this.mo35461a((Runnable) new C10814D(this, demandSourceId));
                C10877y.this.m35529h("onShowInterstitialSuccess", value);
            }
            m35606a(demandSourceId, false);
        }

        /* renamed from: a */
        private void m35606a(String demandSourceId, boolean isAvailable) {
            C10890c demandSource = C10877y.this.f33184ea.mo35437a(C10895h.Interstitial, demandSourceId);
            if (demandSource != null) {
                demandSource.mo35647a(isAvailable);
            }
        }

        @JavascriptInterface
        public void onInitOfferWallSuccess(String value) {
            C10877y.this.m35529h("onInitOfferWallSuccess", "true");
            C10877y.this.f33179W.mo35619a(true);
            if (C10877y.this.f33179W.mo35633h()) {
                C10877y.this.f33179W.mo35622b(false);
                if (C10877y.this.m35539m(C10895h.OfferWall.toString())) {
                    C10877y.this.mo35461a((Runnable) new C10815E(this));
                }
            }
        }

        @JavascriptInterface
        public void onInitOfferWallFail(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onInitOfferWallFail(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10877y.this.f33179W.mo35619a(false);
            String message = new C10897j(value).mo35673d("errMsg");
            if (C10877y.this.f33179W.mo35633h()) {
                C10877y.this.f33179W.mo35622b(false);
                if (C10877y.this.m35539m(C10895h.OfferWall.toString())) {
                    C10877y.this.mo35461a((Runnable) new C10816F(this, message));
                }
            }
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            C10877y.this.m35529h("onInitOfferWallFail", value);
        }

        @JavascriptInterface
        public void onLoadInterstitialSuccess(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onLoadInterstitialSuccess(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            String demandSourceId = C13004g.m42442a(new C10897j(value));
            m35606a(demandSourceId, true);
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            if (C10877y.this.m35539m(C10895h.Interstitial.toString())) {
                C10877y.this.mo35461a((Runnable) new C10817G(this, demandSourceId));
            }
            C10877y.this.m35529h("onLoadInterstitialSuccess", "true");
        }

        @JavascriptInterface
        public void onLoadInterstitialFail(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onLoadInterstitialFail(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10897j ssaObj = new C10897j(value);
            String message = ssaObj.mo35673d("errMsg");
            String demandSourceId = C13004g.m42442a(ssaObj);
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            if (!TextUtils.isEmpty(demandSourceId)) {
                m35606a(demandSourceId, false);
                if (C10877y.this.m35539m(C10895h.Interstitial.toString())) {
                    C10877y.this.mo35461a((Runnable) new C10818H(this, message, demandSourceId));
                }
                C10877y.this.m35529h("onLoadInterstitialFail", "true");
            }
        }

        @JavascriptInterface
        public void onShowInterstitialFail(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onShowInterstitialFail(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10897j ssaObj = new C10897j(value);
            String message = ssaObj.mo35673d("errMsg");
            String demandSourceId = C13004g.m42442a(ssaObj);
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            if (!TextUtils.isEmpty(demandSourceId)) {
                m35606a(demandSourceId, false);
                if (C10877y.this.m35539m(C10895h.Interstitial.toString())) {
                    C10877y.this.mo35461a((Runnable) new C10819I(this, message, demandSourceId));
                }
                C10877y.this.m35529h("onShowInterstitialFail", value);
            }
        }

        @JavascriptInterface
        public void onInitBannerSuccess(String value) {
            C13003f.m42438c(C10877y.this.f33192o, "onInitBannerSuccess()");
            C10877y.this.m35529h("onInitBannerSuccess", "true");
            String demandSourceId = C13004g.m42442a(new C10897j(value));
            if (TextUtils.isEmpty(demandSourceId)) {
                C13003f.m42438c(C10877y.this.f33192o, "onInitBannerSuccess failed with no demand source");
                return;
            }
            if (C10877y.this.m35539m(C10895h.Banner.toString())) {
                C10877y.this.mo35461a((Runnable) new C10821K(this, demandSourceId));
            }
        }

        @JavascriptInterface
        public void onInitBannerFail(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onInitBannerFail(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10897j ssaObj = new C10897j(value);
            String message = ssaObj.mo35673d("errMsg");
            String demandSourceId = C13004g.m42442a(ssaObj);
            if (TextUtils.isEmpty(demandSourceId)) {
                C13003f.m42438c(C10877y.this.f33192o, "onInitBannerFail failed with no demand source");
                return;
            }
            C10890c demandSource = C10877y.this.f33184ea.mo35437a(C10895h.Banner, demandSourceId);
            if (demandSource != null) {
                demandSource.mo35651b(3);
            }
            if (C10877y.this.m35539m(C10895h.Banner.toString())) {
                C10877y.this.mo35461a((Runnable) new C10822L(this, message, demandSourceId));
            }
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            C10877y.this.m35529h("onInitBannerFail", value);
        }

        @JavascriptInterface
        public void onLoadBannerSuccess(String value) {
            C13003f.m42438c(C10877y.this.f33192o, "onLoadBannerSuccess()");
            String demandSourceId = C13004g.m42442a(new C10897j(value));
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            if (C10877y.this.m35539m(C10895h.Banner.toString())) {
                C10877y.this.mo35461a((Runnable) new C10823M(this, demandSourceId));
            }
        }

        @JavascriptInterface
        public void onLoadBannerFail(String value) {
            C13003f.m42438c(C10877y.this.f33192o, "onLoadBannerFail()");
            C10897j ssaObj = new C10897j(value);
            String message = ssaObj.mo35673d("errMsg");
            String demandSourceId = C13004g.m42442a(ssaObj);
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            if (!TextUtils.isEmpty(demandSourceId) && C10877y.this.m35539m(C10895h.Banner.toString())) {
                C10877y.this.mo35461a((Runnable) new C10824N(this, message, demandSourceId));
            }
        }

        @JavascriptInterface
        public void onGenericFunctionSuccess(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onGenericFunctionSuccess(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            if (C10877y.this.f33171O == null) {
                C13003f.m42436a(C10877y.this.f33192o, "genericFunctionListener was not found");
                return;
            }
            C10877y.this.mo35461a((Runnable) new C10825O(this));
            C10877y.this.m35491a(value, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onGenericFunctionFail(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onGenericFunctionFail(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            if (C10877y.this.f33171O == null) {
                C13003f.m42436a(C10877y.this.f33192o, "genericFunctionListener was not found");
                return;
            }
            C10877y.this.mo35461a((Runnable) new C10827P(this, new C10897j(value).mo35673d("errMsg")));
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            C10877y.this.m35529h("onGenericFunctionFail", value);
        }

        @JavascriptInterface
        public void createCalendarEvent(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("createCalendarEvent(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
        }

        @JavascriptInterface
        public void openUrl(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("openUrl(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10897j ssaObj = new C10897j(value);
            String url = ssaObj.mo35673d("url");
            String method = ssaObj.mo35673d("method");
            Context context = C10877y.this.getCurrentActivityContext();
            try {
                if (method.equalsIgnoreCase("external_browser")) {
                    C12731g.m41114a(context, url);
                } else if (method.equalsIgnoreCase("webview")) {
                    Intent intent = new Intent(context, OpenUrlActivity.class);
                    intent.putExtra(C10877y.f33147e, url);
                    intent.putExtra(C10877y.f33148f, true);
                    intent.putExtra("immersive", C10877y.this.f33183da);
                    context.startActivity(intent);
                } else if (method.equalsIgnoreCase("store")) {
                    Intent intent2 = new Intent(context, OpenUrlActivity.class);
                    intent2.putExtra(C10877y.f33147e, url);
                    intent2.putExtra(C10877y.f33144b, true);
                    intent2.putExtra(C10877y.f33148f, true);
                    context.startActivity(intent2);
                }
            } catch (Exception ex) {
                C10877y.this.m35491a(value, false, ex.getMessage(), (String) null);
                ex.printStackTrace();
            }
        }

        @JavascriptInterface
        public void setForceClose(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("setForceClose(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10897j ssaObj = new C10897j(value);
            String width = ssaObj.mo35673d("width");
            String hight = ssaObj.mo35673d("height");
            C10877y.this.f33160D = Integer.parseInt(width);
            C10877y.this.f33161E = Integer.parseInt(hight);
            C10877y.this.f33162F = ssaObj.mo35673d("position");
        }

        @JavascriptInterface
        public void setBackButtonState(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("setBackButtonState(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C13001d.m42395g().mo41907e(new C10897j(value).mo35673d("state"));
        }

        @JavascriptInterface
        public void setStoreSearchKeys(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("setStoreSearchKeys(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C13001d.m42395g().mo41910g(value);
        }

        @JavascriptInterface
        public void setWebviewBackgroundColor(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("setWebviewBackgroundColor(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10877y.this.setWebviewBackground(value);
        }

        @JavascriptInterface
        public void toggleUDIA(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("toggleUDIA(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10897j ssaObj = new C10897j(value);
            String str = "toggle";
            if (!ssaObj.mo35670a(str)) {
                C10877y.this.m35491a(value, false, "toggle key does not exist", (String) null);
                return;
            }
            int toggle = Integer.parseInt(ssaObj.mo35673d(str));
            if (toggle != 0) {
                String binaryToggle = Integer.toBinaryString(toggle);
                if (TextUtils.isEmpty(binaryToggle)) {
                    C10877y.this.m35491a(value, false, "fialed to convert toggle", (String) null);
                    return;
                }
                if (binaryToggle.toCharArray()[3] == '0') {
                    C13001d.m42395g().mo41896a(true);
                } else {
                    C13001d.m42395g().mo41896a(false);
                }
            }
        }

        @JavascriptInterface
        public void getUDIA(String value) {
            this.f33206a = 0;
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("getUDIA(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            String funToCall = C10877y.this.m35530i(value);
            C10897j ssaObj = new C10897j(value);
            String str = "getByFlag";
            if (!ssaObj.mo35670a(str)) {
                C10877y.this.m35491a(value, false, "getByFlag key does not exist", (String) null);
                return;
            }
            int getByFlag = Integer.parseInt(ssaObj.mo35673d(str));
            if (getByFlag != 0) {
                String binaryToggle = Integer.toBinaryString(getByFlag);
                if (TextUtils.isEmpty(binaryToggle)) {
                    C10877y.this.m35491a(value, false, "fialed to convert getByFlag", (String) null);
                    return;
                }
                char[] binaryToggleArr = new StringBuilder(binaryToggle).reverse().toString().toCharArray();
                JSONArray jsArr = new JSONArray();
                if (binaryToggleArr[3] == '0') {
                    JSONObject jsObj = new JSONObject();
                    try {
                        jsObj.put("sessions", C13001d.m42395g().mo41908f());
                        C13001d.m42395g().mo41892a();
                        jsArr.put(jsObj);
                    } catch (JSONException e) {
                    }
                }
                if (binaryToggleArr[2] == '1') {
                    this.f33206a++;
                    Location location = C12727e.m41108a(C10877y.this.getContext());
                    if (location != null) {
                        JSONObject jsObj2 = new JSONObject();
                        try {
                            jsObj2.put("latitude", location.getLatitude());
                            jsObj2.put("longitude", location.getLongitude());
                            jsArr.put(jsObj2);
                            this.f33206a--;
                            m35607b(funToCall, jsArr);
                            C13003f.m42438c(C10877y.this.f33192o, "done location");
                        } catch (JSONException e2) {
                        }
                    } else {
                        this.f33206a--;
                    }
                }
            }
        }

        /* renamed from: b */
        private void m35607b(String funToCall, JSONArray jsArr) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("sendResults: ");
            sb.append(this.f33206a);
            C13003f.m42438c(z, sb.toString());
            if (this.f33206a <= 0) {
                m35605a(funToCall, jsArr);
            }
        }

        @JavascriptInterface
        public void onUDIASuccess(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onUDIASuccess(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
        }

        @JavascriptInterface
        public void onUDIAFail(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onUDIAFail(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
        }

        @JavascriptInterface
        public void onGetUDIASuccess(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onGetUDIASuccess(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
        }

        @JavascriptInterface
        public void onGetUDIAFail(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onGetUDIAFail(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
        }

        @JavascriptInterface
        public void setUserUniqueId(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("setUserUniqueId(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10897j ssaObj = new C10897j(value);
            String str = "userUniqueId";
            if (!ssaObj.mo35670a(str) || !ssaObj.mo35670a("productType")) {
                C10877y.this.m35491a(value, false, "uniqueId or productType does not exist", (String) null);
                return;
            }
            if (C13001d.m42395g().mo41911h(ssaObj.mo35673d(str))) {
                C10877y.this.m35491a(value, true, (String) null, (String) null);
            } else {
                C10877y.this.m35491a(value, false, "setUserUniqueId failed", (String) null);
            }
        }

        @JavascriptInterface
        public void getUserUniqueId(String value) {
            String str = value;
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("getUserUniqueId(");
            sb.append(str);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10897j ssaObj = new C10897j(str);
            String str2 = "productType";
            if (!ssaObj.mo35670a(str2)) {
                C10877y.this.m35491a(str, false, "productType does not exist", (String) null);
                return;
            }
            String funToCall = C10877y.this.m35530i(str);
            if (!TextUtils.isEmpty(funToCall)) {
                String productType = ssaObj.mo35673d(str2);
                C10877y.this.m35536l(C10877y.this.m35484a(funToCall, C10877y.this.m35485a("userUniqueId", C13001d.m42395g().mo41900b(productType), "productType", productType, null, null, null, null, null, false), "onGetUserUniqueIdSuccess", "onGetUserUniqueIdFail"));
            }
        }

        @JavascriptInterface
        public void getAppsInstallTime(String value) {
            String dataToSend;
            boolean failed = true;
            String funToCall = null;
            try {
                dataToSend = C12725c.m41085a(C10877y.this.getContext(), Boolean.parseBoolean(new C10897j(value).mo35673d("systemApps"))).toString();
                failed = false;
            } catch (Exception e) {
                String z = C10877y.this.f33192o;
                StringBuilder sb = new StringBuilder();
                sb.append("getAppsInstallTime failed(");
                sb.append(e.getLocalizedMessage());
                sb.append(")");
                C13003f.m42438c(z, sb.toString());
                dataToSend = e.getLocalizedMessage();
            }
            if (failed) {
                String failFunToCall = C10877y.this.m35528h(value);
                if (!TextUtils.isEmpty(failFunToCall)) {
                    funToCall = failFunToCall;
                }
            } else {
                String successFunToCall = C10877y.this.m35530i(value);
                if (!TextUtils.isEmpty(successFunToCall)) {
                    funToCall = successFunToCall;
                }
            }
            if (!TextUtils.isEmpty(funToCall)) {
                try {
                    dataToSend = URLDecoder.decode(dataToSend, Charset.defaultCharset().name());
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                C10877y.this.m35536l(C10877y.this.m35510d(funToCall, dataToSend));
            }
        }

        @JavascriptInterface
        public void onGetUserUniqueIdSuccess(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onGetUserUniqueIdSuccess(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
        }

        @JavascriptInterface
        public void onGetUserUniqueIdFail(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onGetUserUniqueIdFail(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
        }

        /* renamed from: a */
        private void m35605a(String funToCall, JSONArray jsonArr) {
            if (!TextUtils.isEmpty(funToCall)) {
                C10877y.this.m35536l(C10877y.this.m35484a(funToCall, jsonArr.toString(), "onGetUDIASuccess", "onGetUDIAFail"));
            }
        }

        @JavascriptInterface
        public void onOfferWallGeneric(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onOfferWallGeneric(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            if (C10877y.this.m35539m(C10895h.OfferWall.toString())) {
                String str = "";
                C10877y.this.f33173Q.onOWGeneric(str, str);
            }
        }

        @JavascriptInterface
        public void setUserData(String value) {
            String str = value;
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("setUserData(");
            sb.append(str);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10897j ssaObj = new C10897j(str);
            String str2 = Notification.KEY;
            if (!ssaObj.mo35670a(str2)) {
                C10877y.this.m35491a(str, false, "key does not exist", (String) null);
                return;
            }
            String str3 = DonationsAnalytics.VALUE;
            if (!ssaObj.mo35670a(str3)) {
                C10877y.this.m35491a(str, false, "value does not exist", (String) null);
                return;
            }
            String mKey = ssaObj.mo35673d(str2);
            String mValue = ssaObj.mo35673d(str3);
            if (C13001d.m42395g().mo41901b(mKey, mValue)) {
                C10877y.this.m35536l(C10877y.this.m35510d(C10877y.this.m35530i(str), C10877y.this.m35485a(mKey, mValue, null, null, null, null, null, null, null, false)));
            } else {
                C10877y.this.m35491a(str, false, "SetUserData failed writing to shared preferences", (String) null);
            }
        }

        @JavascriptInterface
        public void getUserData(String value) {
            String str = value;
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("getUserData(");
            sb.append(str);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10897j ssaObj = new C10897j(str);
            String str2 = Notification.KEY;
            if (!ssaObj.mo35670a(str2)) {
                C10877y.this.m35491a(str, false, "key does not exist", (String) null);
                return;
            }
            String failFunToCall = C10877y.this.m35530i(str);
            String mKey = ssaObj.mo35673d(str2);
            C10877y.this.m35536l(C10877y.this.m35510d(failFunToCall, C10877y.this.m35485a(mKey, C13001d.m42395g().mo41903c(mKey), null, null, null, null, null, null, null, false)));
        }

        @JavascriptInterface
        public void onGetUserCreditsFail(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onGetUserCreditsFail(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            String message = new C10897j(value).mo35673d("errMsg");
            if (C10877y.this.m35539m(C10895h.OfferWall.toString())) {
                C10877y.this.mo35461a((Runnable) new C10828Q(this, message));
            }
            C10877y.this.m35491a(value, true, (String) null, (String) null);
            C10877y.this.m35529h("onGetUserCreditsFail", value);
        }

        @JavascriptInterface
        public void onAdWindowsClosed(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onAdWindowsClosed(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            C10877y.this.f33179W.mo35614a();
            C10877y.this.f33179W.mo35616a((String) null);
            C10897j ssaObj = new C10897j(value);
            String product = ssaObj.mo35673d("productType");
            String demandSourceId = C13004g.m42442a(ssaObj);
            C10895h type = C10877y.this.m35535k(product);
            String u = C10877y.this.f33193p;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onAdClosed() with type ");
            sb2.append(type);
            Log.d(u, sb2.toString());
            if (C10877y.this.m35539m(product)) {
                C10877y.this.mo35461a((Runnable) new C10829S(this, type, demandSourceId));
            }
        }

        @JavascriptInterface
        public void onVideoStatusChanged(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("onVideoStatusChanged(");
            sb.append(value);
            sb.append(")");
            Log.d(z, sb.toString());
            C10897j ssaObj = new C10897j(value);
            String product = ssaObj.mo35673d("productType");
            if (C10877y.this.f33178V != null && !TextUtils.isEmpty(product)) {
                String status = ssaObj.mo35673d("status");
                if ("started".equalsIgnoreCase(status)) {
                    C10877y.this.f33178V.mo35358c();
                } else if ("paused".equalsIgnoreCase(status)) {
                    C10877y.this.f33178V.mo35359d();
                } else if ("playing".equalsIgnoreCase(status)) {
                    C10877y.this.f33178V.mo35362g();
                } else if ("ended".equalsIgnoreCase(status)) {
                    C10877y.this.f33178V.mo35360e();
                } else if ("stopped".equalsIgnoreCase(status)) {
                    C10877y.this.f33178V.mo35361f();
                } else {
                    String z2 = C10877y.this.f33192o;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onVideoStatusChanged: unknown status: ");
                    sb2.append(status);
                    C13003f.m42438c(z2, sb2.toString());
                }
            }
        }

        @JavascriptInterface
        public void postAdEventNotification(String value) {
            String str = value;
            try {
                String z = C10877y.this.f33192o;
                StringBuilder sb = new StringBuilder();
                sb.append("postAdEventNotification(");
                sb.append(str);
                sb.append(")");
                C13003f.m42438c(z, sb.toString());
                C10897j ssaObj = new C10897j(str);
                String eventName = ssaObj.mo35673d("eventName");
                if (TextUtils.isEmpty(eventName)) {
                    C10877y.this.m35491a(str, false, "eventName does not exist", (String) null);
                    return;
                }
                String demandSourceName = ssaObj.mo35673d("dsName");
                String tempDemandSourceId = C13004g.m42442a(ssaObj);
                String demandSourceId = !TextUtils.isEmpty(tempDemandSourceId) ? tempDemandSourceId : demandSourceName;
                JSONObject extData = (JSONObject) ssaObj.mo35671b("extData");
                String productType = ssaObj.mo35673d("productType");
                C10895h type = C10877y.this.m35535k(productType);
                if (C10877y.this.m35539m(productType)) {
                    String funToCall = C10877y.this.m35530i(str);
                    if (!TextUtils.isEmpty(funToCall)) {
                        C10877y.this.m35536l(C10877y.this.m35484a(funToCall, C10877y.this.m35485a("productType", productType, "eventName", eventName, "demandSourceName", demandSourceName, "demandSourceId", demandSourceId, null, false), "postAdEventNotificationSuccess", "postAdEventNotificationFail"));
                    }
                    C10877y yVar = C10877y.this;
                    String str2 = funToCall;
                    String str3 = productType;
                    C10830T t = new C10830T(this, type, demandSourceId, eventName, extData);
                    yVar.mo35461a((Runnable) t);
                } else {
                    C10877y.this.m35491a(str, false, "productType does not exist", (String) null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JavascriptInterface
        public void bannerViewAPI(String value) {
            try {
                C10877y.this.f33187ha.mo35411a(value);
            } catch (Exception e) {
                e.printStackTrace();
                String z = C10877y.this.f33192o;
                StringBuilder sb = new StringBuilder();
                sb.append("bannerViewAPI failed with exception ");
                sb.append(e.getMessage());
                C13003f.m42437b(z, sb.toString());
            }
        }

        @JavascriptInterface
        public void moatAPI(String value) {
            C10877y.this.mo35461a((Runnable) new C10831U(this, value));
        }

        @JavascriptInterface
        public void permissionsAPI(String value) {
            try {
                String z = C10877y.this.f33192o;
                StringBuilder sb = new StringBuilder();
                sb.append("permissionsAPI(");
                sb.append(value);
                sb.append(")");
                C13003f.m42438c(z, sb.toString());
                C10877y.this.f33186ga.mo35440a(new C10897j(value).toString(), new C10881a());
            } catch (Exception e) {
                e.printStackTrace();
                String z2 = C10877y.this.f33192o;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("permissionsAPI failed with exception ");
                sb2.append(e.getMessage());
                C13003f.m42438c(z2, sb2.toString());
            }
        }

        @JavascriptInterface
        public void getDeviceVolume(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("getDeviceVolume(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            try {
                float currVolume = C12998a.m42384b(C10877y.this.getCurrentActivityContext()).mo41881a(C10877y.this.getCurrentActivityContext());
                C10897j ssaObj = new C10897j(value);
                ssaObj.mo35668a("deviceVolume", String.valueOf(currVolume));
                C10877y.this.m35491a(ssaObj.toString(), true, (String) null, (String) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JavascriptInterface
        public void locationServicesEnabled(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("locationServicesEnabled(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            try {
                boolean locationServicesEnabled = C12727e.m41110b(C10877y.this.getContext());
                C10897j ssaObj = new C10897j(value);
                ssaObj.mo35668a("status", String.valueOf(locationServicesEnabled));
                C10877y.this.m35491a(ssaObj.toString(), true, (String) null, (String) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JavascriptInterface
        public void getDeviceLocation(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("getDeviceLocation(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            try {
                C10877y.this.m35491a(C10877y.this.m35474a(value, C12727e.m41108a(C10877y.this.getContext())).toString(), true, (String) null, (String) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JavascriptInterface
        public void getDevicePreciseLocation(String value) {
            String z = C10877y.this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("getDevicePreciseLocation(");
            sb.append(value);
            sb.append(")");
            C13003f.m42438c(z, sb.toString());
            try {
                C12727e.m41109a(C10877y.this.getContext(), new C10833W(this, value));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.ironsource.sdk.controller.y$d */
    /* compiled from: IronSourceWebView */
    private interface C10882d {
        /* renamed from: a */
        void mo35452a(String str, C10895h hVar, C10890c cVar);
    }

    /* renamed from: com.ironsource.sdk.controller.y$e */
    /* compiled from: IronSourceWebView */
    static class C10883e {

        /* renamed from: a */
        String f33209a;

        /* renamed from: b */
        String f33210b;

        C10883e() {
        }
    }

    /* renamed from: com.ironsource.sdk.controller.y$f */
    /* compiled from: IronSourceWebView */
    public enum C10884f {
        Display,
        Gone
    }

    /* renamed from: com.ironsource.sdk.controller.y$g */
    /* compiled from: IronSourceWebView */
    private class C10885g implements OnTouchListener {
        private C10885g() {
        }

        /* synthetic */ C10885g(C10877y x0, C10869q x1) {
            this();
        }

        public boolean onTouch(View v, MotionEvent event) {
            int actualTouchY;
            int actualTouchX;
            if (event.getAction() == 1) {
                float xTouch = event.getX();
                float yTouch = event.getY();
                String z = C10877y.this.f33192o;
                StringBuilder sb = new StringBuilder();
                sb.append("X:");
                sb.append((int) xTouch);
                sb.append(" Y:");
                sb.append((int) yTouch);
                C13003f.m42438c(z, sb.toString());
                int width = C12725c.m41101h();
                int height = C12725c.m41093d();
                String z2 = C10877y.this.f33192o;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Width:");
                sb2.append(width);
                sb2.append(" Height:");
                sb2.append(height);
                C13003f.m42438c(z2, sb2.toString());
                int boundsTouchAreaX = C13004g.m42440a((long) C10877y.this.f33160D);
                int boundsTouchAreaY = C13004g.m42440a((long) C10877y.this.f33161E);
                if ("top-right".equalsIgnoreCase(C10877y.this.f33162F)) {
                    actualTouchX = width - ((int) xTouch);
                    actualTouchY = (int) yTouch;
                } else {
                    if ("top-left".equalsIgnoreCase(C10877y.this.f33162F)) {
                        actualTouchX = (int) xTouch;
                        actualTouchY = (int) yTouch;
                    } else {
                        if ("bottom-right".equalsIgnoreCase(C10877y.this.f33162F)) {
                            actualTouchX = width - ((int) xTouch);
                            actualTouchY = height - ((int) yTouch);
                        } else {
                            if ("bottom-left".equalsIgnoreCase(C10877y.this.f33162F)) {
                                actualTouchX = (int) xTouch;
                                actualTouchY = height - ((int) yTouch);
                            } else {
                                actualTouchX = 0;
                                actualTouchY = 0;
                            }
                        }
                    }
                }
                if (actualTouchX <= boundsTouchAreaX && actualTouchY <= boundsTouchAreaY) {
                    C10877y.this.f33202y = false;
                    if (C10877y.this.f33157A != null) {
                        C10877y.this.f33157A.cancel();
                    }
                    C10877y yVar = C10877y.this;
                    C10847ea eaVar = new C10847ea(this, 2000, 500);
                    yVar.f33157A = eaVar.start();
                }
            }
            return false;
        }
    }

    /* renamed from: com.ironsource.sdk.controller.y$h */
    /* compiled from: IronSourceWebView */
    private class C10886h extends WebViewClient {
        private C10886h() {
        }

        /* synthetic */ C10886h(C10877y x0, C10869q x1) {
            this();
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            C13003f.m42438c("onPageStarted", url);
            super.onPageStarted(view, url, favicon);
        }

        public void onPageFinished(WebView view, String url) {
            C13003f.m42438c("onPageFinished", url);
            if (url.contains("adUnit") || url.contains("index.html")) {
                C10877y.this.mo35504j();
            }
            super.onPageFinished(view, url);
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            StringBuilder sb = new StringBuilder();
            sb.append(failingUrl);
            sb.append(" ");
            sb.append(description);
            C13003f.m42438c("onReceivedError", sb.toString());
            super.onReceivedError(view, errorCode, description, failingUrl);
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            C13003f.m42438c("shouldOverrideUrlLoading", url);
            try {
                if (C10877y.this.mo35482c(url)) {
                    C10877y.this.mo35503i();
                    return true;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return super.shouldOverrideUrlLoading(view, url);
        }

        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
            String str = "mraid.js";
            C13003f.m42438c("shouldInterceptRequest", url);
            boolean mraidCall = false;
            try {
                if (new URL(url).getFile().contains(str)) {
                    mraidCall = true;
                }
            } catch (MalformedURLException e) {
            }
            if (mraidCall) {
                StringBuilder sb = new StringBuilder();
                sb.append("file://");
                sb.append(C10877y.this.f33177U);
                sb.append(File.separator);
                sb.append(str);
                String filePath = sb.toString();
                try {
                    new FileInputStream(new File(filePath));
                    return new WebResourceResponse("text/javascript", "UTF-8", getClass().getResourceAsStream(filePath));
                } catch (FileNotFoundException e2) {
                }
            }
            return super.shouldInterceptRequest(view, url);
        }
    }

    /* renamed from: c */
    private Map<String, String> m35504c(C10895h type) {
        if (type == C10895h.OfferWall) {
            return this.f33197t;
        }
        return null;
    }

    public C10877y(Context context, C10859k demandSourceManager) {
        super(context.getApplicationContext());
        C13003f.m42438c(this.f33192o, "C'tor");
        this.f33188ia = new ArrayList<>();
        this.f33177U = mo35473b(context.getApplicationContext());
        this.f33181ba = context;
        this.f33184ea = demandSourceManager;
        m35519f(this.f33181ba);
        this.f33179W = new AdUnitsState();
        this.f33198u = getDownloadManager();
        this.f33198u.mo41861a((C12995c) this);
        this.f33163G = new C10878a(this, null);
        setWebViewClient(new C10886h(this, null));
        setWebChromeClient(this.f33163G);
        m35549r();
        addJavascriptInterface(mo35453a(context), "Android");
        setDownloadListener(this);
        setOnTouchListener(new C10885g(this, null));
        this.f33182ca = mo35478c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C10880c mo35453a(Context context) {
        return new C10880c(context);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Handler mo35478c() {
        return new Handler(Looper.getMainLooper());
    }

    /* access modifiers changed from: 0000 */
    public C12992a getDownloadManager() {
        return C12992a.m42361a(this.f33177U);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo35473b(Context context) {
        return C13002e.m42421a(context.getApplicationContext());
    }

    /* renamed from: a */
    public void mo35456a(C10851ga moatjsAdapter) {
        this.f33185fa = moatjsAdapter;
    }

    /* renamed from: a */
    public void mo35457a(C10860ka permissionsJSAdapter) {
        this.f33186ga = permissionsJSAdapter;
    }

    /* renamed from: a */
    public void mo35455a(C10839b bannerJSAdapter) {
        this.f33187ha = bannerJSAdapter;
    }

    /* renamed from: c */
    public void mo35480c(String productType, String event) {
        m35536l(m35510d("onNativeLifeCycleEvent", m35485a("lifeCycleEvent", event, "productType", productType, null, null, null, null, null, false)));
    }

    public C10865ma getControllerDelegate() {
        if (this.f33189ja == null) {
            this.f33189ja = new C10869q(this);
        }
        return this.f33189ja;
    }

    /* renamed from: f */
    private void m35519f(Context context) {
        LayoutParams coverScreenParams = new LayoutParams(-1, -1);
        this.f33167K = new FrameLayout(context);
        this.f33165I = new FrameLayout(context);
        this.f33165I.setLayoutParams(new LayoutParams(-1, -1));
        this.f33165I.setVisibility(8);
        FrameLayout mContentView = new FrameLayout(context);
        mContentView.setLayoutParams(new LayoutParams(-1, -1));
        mContentView.addView(this);
        this.f33167K.addView(this.f33165I, coverScreenParams);
        this.f33167K.addView(mContentView);
    }

    /* renamed from: r */
    private void m35549r() {
        WebSettings s = getSettings();
        s.setLoadWithOverviewMode(true);
        s.setUseWideViewPort(true);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        if (VERSION.SDK_INT >= 16) {
            try {
                getSettings().setAllowFileAccessFromFileURLs(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        s.setBuiltInZoomControls(false);
        s.setJavaScriptEnabled(true);
        s.setSupportMultipleWindows(true);
        s.setJavaScriptCanOpenWindowsAutomatically(true);
        s.setGeolocationEnabled(true);
        s.setGeolocationDatabasePath("/data/data/org.itri.html5webview/databases/");
        s.setDomStorageEnabled(true);
        try {
            setDisplayZoomControls(s);
            setMediaPlaybackJellyBean(s);
        } catch (Throwable e2) {
            String str = this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("setWebSettings - ");
            sb.append(e2.toString());
            C13003f.m42437b(str, sb.toString());
        }
    }

    private void setDisplayZoomControls(WebSettings s) {
        if (VERSION.SDK_INT > 11) {
            s.setDisplayZoomControls(false);
        }
    }

    public WebBackForwardList saveState(Bundle outState) {
        return super.saveState(outState);
    }

    @SuppressLint({"NewApi"})
    private void setMediaPlaybackJellyBean(WebSettings s) {
        if (VERSION.SDK_INT >= 17) {
            s.setMediaPlaybackRequiresUserGesture(false);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: q */
    private void m35547q() {
        if (VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    /* renamed from: d */
    public void mo35483d() {
        C13002e.m42426a(this.f33177U, "", "mobileController.html");
        String controllerUrl = C13004g.m42460e();
        C10896i indexHtml = new C10896i(controllerUrl, "");
        C10870r rVar = new C10870r(this, 200000, 1000);
        this.f33159C = rVar.start();
        if (!this.f33198u.mo41864c()) {
            String str = this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("Download Mobile Controller: ");
            sb.append(controllerUrl);
            C13003f.m42438c(str, sb.toString());
            this.f33198u.mo41863b(indexHtml);
            return;
        }
        C13003f.m42438c(this.f33192o, "Download Mobile Controller: already alive");
    }

    public void setDebugMode(int debugMode) {
        f33143a = debugMode;
    }

    public int getDebugMode() {
        return f33143a;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public boolean m35539m(String product) {
        boolean shouldNotify = false;
        boolean z = false;
        if (TextUtils.isEmpty(product)) {
            C13003f.m42436a(this.f33192o, "Trying to trigger a listener - no product was found");
            return false;
        }
        if (product.equalsIgnoreCase(C10895h.Interstitial.toString())) {
            if (this.f33172P != null) {
                z = true;
            }
            shouldNotify = z;
        } else if (product.equalsIgnoreCase(C10895h.RewardedVideo.toString())) {
            if (this.f33170N != null) {
                z = true;
            }
            shouldNotify = z;
        } else if (product.equalsIgnoreCase(C10895h.Banner.toString())) {
            if (this.f33174R != null) {
                z = true;
            }
            shouldNotify = z;
        } else if (product.equalsIgnoreCase(C10895h.OfferWall.toString()) || product.equalsIgnoreCase(C10895h.OfferWallCredits.toString())) {
            if (this.f33173Q != null) {
                z = true;
            }
            shouldNotify = z;
        }
        if (!shouldNotify) {
            String str = this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("Trying to trigger a listener - no listener was found for product ");
            sb.append(product);
            C13003f.m42436a(str, sb.toString());
        }
        return shouldNotify;
    }

    public void setOrientationState(String orientation) {
        this.f33169M = orientation;
    }

    public String getOrientationState() {
        return this.f33169M;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m35543o() {
        while (this.f33188ia.size() > 0) {
            m35536l((String) this.f33188ia.get(0));
            this.f33188ia.remove(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C10897j m35474a(String value, Location location) {
        C10897j ssaObj = new C10897j(value);
        if (location != null) {
            ssaObj.mo35668a("provider", location.getProvider());
            ssaObj.mo35668a("latitude", Double.toString(location.getLatitude()));
            ssaObj.mo35668a("longitude", Double.toString(location.getLongitude()));
            ssaObj.mo35668a("altitude", Double.toString(location.getAltitude()));
            ssaObj.mo35668a("time", Long.toString(location.getTime()));
            ssaObj.mo35668a("accuracy", Float.toString(location.getAccuracy()));
            ssaObj.mo35668a("bearing", Float.toString(location.getBearing()));
            ssaObj.mo35668a("speed", Float.toString(location.getSpeed()));
        } else {
            ssaObj.mo35668a("error", "location data is not available");
        }
        return ssaObj;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C12982a m35476a(C10895h type) {
        if (type == C10895h.Interstitial) {
            return this.f33172P;
        }
        if (type == C10895h.RewardedVideo) {
            return this.f33170N;
        }
        if (type == C10895h.Banner) {
            return this.f33174R;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public C10895h m35535k(String productType) {
        if (TextUtils.isEmpty(productType)) {
            return null;
        }
        if (productType.equalsIgnoreCase(C10895h.Interstitial.toString())) {
            return C10895h.Interstitial;
        }
        if (productType.equalsIgnoreCase(C10895h.RewardedVideo.toString())) {
            return C10895h.RewardedVideo;
        }
        if (productType.equalsIgnoreCase(C10895h.OfferWall.toString())) {
            return C10895h.OfferWall;
        }
        if (productType.equalsIgnoreCase(C10895h.Banner.toString())) {
            return C10895h.Banner;
        }
        return null;
    }

    public static void setEXTERNAL_URL(String EXTERNAL_URL) {
        f33147e = EXTERNAL_URL;
    }

    public void setVideoEventsListener(C10863la listener) {
        this.f33178V = listener;
    }

    /* renamed from: l */
    public void mo35506l() {
        this.f33178V = null;
    }

    /* access modifiers changed from: private */
    public void setWebviewBackground(String value) {
        String keyColor = new C10897j(value).mo35673d("color");
        int bgColor = 0;
        if (!"transparent".equalsIgnoreCase(keyColor)) {
            bgColor = Color.parseColor(keyColor);
        }
        setBackgroundColor(bgColor);
    }

    /* renamed from: a */
    public void mo35454a(int loadAttemp) {
        String str = "WebViewController:: load: ";
        try {
            loadUrl("about:blank");
        } catch (Throwable e) {
            String str2 = this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(e.toString());
            C13003f.m42437b(str2, sb.toString());
            new C12999b().execute(new String[]{"https://www.supersonicads.com/mobile/sdk5/log?method=webviewLoadBlank"});
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("file://");
        sb2.append(this.f33177U);
        sb2.append(File.separator);
        String str3 = "mobileController.html";
        sb2.append(str3);
        String controllerPath = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.f33177U);
        sb3.append(File.separator);
        sb3.append(str3);
        if (new File(sb3.toString()).exists()) {
            JSONObject configObject = C13004g.m42459d();
            setWebDebuggingEnabled(configObject);
            String requestParameters = m35515e(configObject);
            StringBuilder sb4 = new StringBuilder();
            sb4.append(controllerPath);
            sb4.append("?");
            sb4.append(requestParameters);
            String controllerPathWithParams = sb4.toString();
            C10871s sVar = new C10871s(this, 50000, 1000, loadAttemp);
            this.f33158B = sVar.start();
            try {
                loadUrl(controllerPathWithParams);
            } catch (Throwable th) {
                Throwable e2 = th;
                String str4 = this.f33192o;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append(e2.toString());
                C13003f.m42437b(str4, sb5.toString());
                new C12999b().execute(new String[]{"https://www.supersonicads.com/mobile/sdk5/log?method=webviewLoadWithPath"});
            }
            String str5 = this.f33192o;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("load(): ");
            sb6.append(controllerPathWithParams);
            C13003f.m42438c(str5, sb6.toString());
            return;
        }
        C13003f.m42438c(this.f33192o, "load(): Mobile Controller HTML Does not exist");
        new C12999b().execute(new String[]{"https://www.supersonicads.com/mobile/sdk5/log?method=htmlControllerDoesNotExistOnFileSystem"});
    }

    private void setWebDebuggingEnabled(JSONObject configObject) {
        if (configObject.optBoolean("inspectWebview")) {
            m35547q();
        }
    }

    /* renamed from: a */
    private void m35490a(String applicationKey, String userId, C10895h productType, C10890c demandSource, C10882d handler) {
        if (TextUtils.isEmpty(userId) || TextUtils.isEmpty(applicationKey)) {
            handler.mo35452a("User id or Application key are missing", productType, demandSource);
        } else if (this.f33175S == C10893f.Failed) {
            handler.mo35452a(C13004g.m42444a(m35499b(productType), "Initiating Controller"), productType, demandSource);
        } else {
            C13001d.m42395g().mo41905d(applicationKey);
            C10883e result = m35495b(productType, demandSource);
            m35525g(result.f33209a, result.f33210b);
            if (!m35544p()) {
                mo35459a(productType, demandSource);
                if (this.f33201x) {
                    mo35483d();
                    C13003f.m42438c(this.f33192o, "initProduct | downloadController");
                }
            }
        }
    }

    /* renamed from: a */
    public void mo35466a(String applicationKey, String userId, C10890c demandSource, C12985d listener) {
        this.f33195r = applicationKey;
        this.f33196s = userId;
        this.f33170N = listener;
        this.f33179W.mo35627d(applicationKey);
        this.f33179W.mo35630e(userId);
        m35490a(applicationKey, userId, C10895h.RewardedVideo, demandSource, (C10882d) new C10872t(this));
    }

    /* renamed from: a */
    public void mo35465a(String applicationKey, String userId, C10890c demandSource, C12984c listener) {
        this.f33195r = applicationKey;
        this.f33196s = userId;
        this.f33172P = listener;
        this.f33179W.mo35621b(this.f33195r);
        this.f33179W.mo35624c(this.f33196s);
        m35490a(this.f33195r, this.f33196s, C10895h.Interstitial, demandSource, (C10882d) new C10873u(this));
    }

    /* renamed from: e */
    public void mo35489e(String demandSourceName) {
        Map<String, String> productParamsMap = new HashMap<>();
        productParamsMap.put("demandSourceName", demandSourceName);
        String params = C13004g.m42445a(productParamsMap);
        this.f33179W.mo35617a(demandSourceName, true);
        m35536l(m35484a("loadInterstitial", params, "onLoadInterstitialSuccess", "onLoadInterstitialFail"));
    }

    /* renamed from: b */
    public void mo35477b(JSONObject showParams) {
        m35536l(m35483a(C10895h.Interstitial, showParams));
    }

    /* renamed from: d */
    public boolean mo35486d(String demandSourceName) {
        C10890c demandSource = this.f33184ea.mo35437a(C10895h.Interstitial, demandSourceName);
        return demandSource != null && demandSource.mo35648a();
    }

    /* renamed from: a */
    public void mo35469a(String applicationKey, String userId, Map<String, String> extraParameters, C12989e listener) {
        this.f33195r = applicationKey;
        this.f33196s = userId;
        this.f33197t = extraParameters;
        this.f33173Q = listener;
        this.f33179W.mo35618a(this.f33197t);
        this.f33179W.mo35622b(true);
        m35490a(this.f33195r, this.f33196s, C10895h.OfferWall, (C10890c) null, (C10882d) new C10874v(this));
    }

    /* renamed from: a */
    public void mo35470a(Map<String, String> extraParameters) {
        this.f33197t = extraParameters;
        m35536l(m35500b("showOfferWall", "onShowOfferWallSuccess", "onShowOfferWallFail"));
    }

    /* renamed from: a */
    public void mo35467a(String applicationKey, String userId, C12989e listener) {
        this.f33195r = applicationKey;
        this.f33196s = userId;
        this.f33173Q = listener;
        m35490a(this.f33195r, this.f33196s, C10895h.OfferWallCredits, (C10890c) null, (C10882d) new C10875w(this));
    }

    /* renamed from: a */
    public void mo35464a(String applicationKey, String userId, C10890c demandSource, C12983b listener) {
        this.f33195r = applicationKey;
        this.f33196s = userId;
        this.f33174R = listener;
        m35490a(applicationKey, userId, C10895h.Banner, demandSource, (C10882d) new C10876x(this));
    }

    /* renamed from: a */
    public void mo35471a(JSONObject loadParams) {
        if (loadParams != null) {
            m35536l(m35484a("loadBanner", loadParams.toString(), "onLoadBannerSuccess", "onLoadBannerFail"));
        }
    }

    /* renamed from: d */
    public void mo35485d(JSONObject consentParams) {
        String str = "updateConsentInfo";
        m35525g(str, m35510d(str, consentParams != null ? consentParams.toString() : null));
    }

    /* renamed from: b */
    private C10883e m35495b(C10895h type, C10890c demandSource) {
        C10895h hVar = type;
        C10883e result = new C10883e();
        String str = "";
        if (hVar == C10895h.RewardedVideo || hVar == C10895h.Interstitial || hVar == C10895h.OfferWall || hVar == C10895h.Banner) {
            Map<String, String> productParamsMap = new HashMap<>();
            productParamsMap.put("applicationKey", this.f33195r);
            productParamsMap.put("applicationUserId", this.f33196s);
            if (demandSource != null) {
                if (demandSource.mo35654d() != null) {
                    productParamsMap.putAll(demandSource.mo35654d());
                }
                productParamsMap.put("demandSourceName", demandSource.mo35652c());
                productParamsMap.put("demandSourceId", demandSource.mo35655e());
            }
            Map<String, String> extraParams = m35504c(type);
            if (extraParams != null) {
                productParamsMap.putAll(extraParams);
            }
            String params = C13004g.m42445a(productParamsMap);
            C12977a method = C12977a.m42323a(type);
            String script = m35484a(method.f39932a, params, method.f39933b, method.f39934c);
            result.f33209a = method.f39932a;
            result.f33210b = script;
        } else if (hVar == C10895h.OfferWallCredits) {
            String params2 = m35485a("productType", "OfferWall", "applicationKey", this.f33195r, "applicationUserId", this.f33196s, null, null, null, false);
            String str2 = "getUserCredits";
            String script2 = m35484a(str2, params2, "null", "onGetUserCreditsFail");
            result.f33209a = str2;
            result.f33210b = script2;
        }
        return result;
    }

    /* renamed from: a */
    private String m35483a(C10895h type, JSONObject showParams) {
        Map<String, String> paramsMap = new HashMap<>();
        String str = "sessionDepth";
        paramsMap.put(str, Integer.toString(showParams.optInt(str)));
        String str2 = "demandSourceName";
        String demandSourceName = showParams.optString(str2);
        String demandSourceId = C13004g.m42446a(showParams);
        C10890c demandSource = this.f33184ea.mo35437a(type, demandSourceId);
        if (demandSource != null) {
            if (demandSource.mo35654d() != null) {
                paramsMap.putAll(demandSource.mo35654d());
            }
            if (!TextUtils.isEmpty(demandSourceName)) {
                paramsMap.put(str2, demandSourceName);
            }
            if (!TextUtils.isEmpty(demandSourceId)) {
                paramsMap.put("demandSourceId", demandSourceId);
            }
        }
        Map<String, String> extraParams = m35504c(type);
        if (extraParams != null) {
            paramsMap.putAll(extraParams);
        }
        String params = C13004g.m42445a(paramsMap);
        C12977a method = C12977a.m42324b(type);
        return m35484a(method.f39932a, params, method.f39933b, method.f39934c);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35459a(C10895h type, C10890c demandSource) {
        if (type == C10895h.RewardedVideo || type == C10895h.Interstitial || type == C10895h.Banner) {
            if (demandSource != null) {
                demandSource.mo35651b(1);
            }
        } else if (type == C10895h.OfferWall) {
            this.f33199v = true;
        } else if (type == C10895h.OfferWallCredits) {
            this.f33200w = true;
        }
        String str = this.f33192o;
        StringBuilder sb = new StringBuilder();
        sb.append("setMissProduct(");
        sb.append(type);
        sb.append(")");
        C13003f.m42438c(str, sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35489a(String message, C10895h productType, C10890c demandSource) {
        if (m35539m(productType.toString())) {
            mo35461a((Runnable) new C10862l(this, productType, demandSource, message));
        }
    }

    /* renamed from: c */
    public void mo35481c(JSONObject showParams) {
        m35536l(m35483a(C10895h.RewardedVideo, showParams));
    }

    /* renamed from: a */
    public void mo35463a(String file, String path) {
        m35536l(m35510d("assetCached", m35485a("file", file, "path", path, null, null, null, null, null, false)));
    }

    /* renamed from: a */
    public void mo35468a(String file, String path, String errorMsg) {
        m35536l(m35510d("assetCachedFailed", m35485a("file", file, "path", path, "errMsg", errorMsg, null, null, null, false)));
    }

    /* renamed from: e */
    public void mo35488e() {
        if (this.f33175S == C10893f.Ready) {
            m35536l(m35533j("enterBackground"));
        }
    }

    /* renamed from: f */
    public void mo35490f() {
        if (this.f33175S == C10893f.Ready) {
            m35536l(m35533j("enterForeground"));
        }
    }

    /* renamed from: a */
    public void mo35472a(boolean visibility, String webview) {
        m35536l(m35510d("viewableChange", m35485a("webview", webview, null, null, null, null, null, null, "isViewable", visibility)));
    }

    /* renamed from: f */
    public void mo35491f(String action) {
        m35536l(m35510d("nativeNavigationPressed", m35485a("action", action, null, null, null, null, null, null, null, false)));
    }

    /* renamed from: j */
    public void mo35504j() {
        m35536l(m35533j("pageFinished"));
    }

    /* renamed from: i */
    public void mo35503i() {
        m35536l(m35533j("interceptedUrlToStore"));
    }

    /* renamed from: b */
    public void mo35476b(String errorMessage, String failedUrl) {
        m35536l(m35510d("failedToStartStoreActivity", m35485a("errMsg", TextUtils.isEmpty(errorMessage) ? "activity failed to open with unspecified reason" : errorMessage, "url", TextUtils.isEmpty(failedUrl) ? "unknown url" : failedUrl, null, null, null, null, null, false)));
    }

    /* renamed from: g */
    private void m35525g(String command, String script) {
        if (!m35544p()) {
            String str = this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("injectJavascript | ControllerCommandsQueue | adding command to queue | ");
            sb.append(command);
            C13003f.m42436a(str, sb.toString());
            this.f33188ia.add(script);
            return;
        }
        m35536l(script);
    }

    /* renamed from: p */
    private boolean m35544p() {
        return C10893f.Ready.equals(this.f33175S);
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m35536l(String script) {
        if (!TextUtils.isEmpty(script)) {
            String catchClosure = "empty";
            if (getDebugMode() == C10894g.MODE_0.mo35660e()) {
                catchClosure = "console.log(\"JS exeption: \" + JSON.stringify(e));";
            } else if (getDebugMode() >= C10894g.MODE_1.mo35660e() && getDebugMode() <= C10894g.MODE_3.mo35660e()) {
                catchClosure = "console.log(\"JS exeption: \" + JSON.stringify(e));";
            }
            StringBuilder scriptBuilder = new StringBuilder();
            scriptBuilder.append("try{");
            scriptBuilder.append(script);
            scriptBuilder.append("}catch(e){");
            scriptBuilder.append(catchClosure);
            scriptBuilder.append("}");
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:");
            sb.append(scriptBuilder.toString());
            mo35461a((Runnable) new C10864m(this, sb.toString(), scriptBuilder));
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: g */
    public void m35524g(String script) {
        evaluateJavascript(script, null);
    }

    public Context getCurrentActivityContext() {
        return ((MutableContextWrapper) this.f33181ba).getBaseContext();
    }

    /* renamed from: e */
    private String m35515e(JSONObject configObject) {
        String host;
        C12998a properties = C12998a.m42384b(getContext());
        StringBuilder builder = new StringBuilder();
        String sdkVer = C12998a.m42385g();
        String str = "&";
        String str2 = "=";
        if (!TextUtils.isEmpty(sdkVer)) {
            builder.append("SDKVersion");
            builder.append(str2);
            builder.append(sdkVer);
            builder.append(str);
        }
        String osType = properties.mo41886e();
        if (!TextUtils.isEmpty(osType)) {
            builder.append("deviceOs");
            builder.append(str2);
            builder.append(osType);
        }
        Uri downloadUri = Uri.parse(C13004g.m42460e());
        if (downloadUri != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(downloadUri.getScheme());
            String str3 = ":";
            sb.append(str3);
            String scheme = sb.toString();
            String host2 = downloadUri.getHost();
            int port = downloadUri.getPort();
            if (port != -1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(host2);
                sb2.append(str3);
                sb2.append(port);
                host = sb2.toString();
            } else {
                host = host2;
            }
            builder.append(str);
            builder.append("protocol");
            builder.append(str2);
            builder.append(scheme);
            builder.append(str);
            builder.append("domain");
            builder.append(str2);
            builder.append(host);
            if (configObject.keys().hasNext()) {
                try {
                    try {
                        String config = new JSONObject(configObject, new String[]{"isSecured", "applicationKey"}).toString();
                        if (!TextUtils.isEmpty(config)) {
                            builder.append(str);
                            builder.append("controllerConfig");
                            builder.append(str2);
                            builder.append(config);
                        }
                    } catch (JSONException e) {
                        e = e;
                        e.printStackTrace();
                        builder.append(str);
                        builder.append("debug");
                        builder.append(str2);
                        builder.append(getDebugMode());
                        return builder.toString();
                    }
                } catch (JSONException e2) {
                    e = e2;
                    JSONObject jSONObject = configObject;
                    e.printStackTrace();
                    builder.append(str);
                    builder.append("debug");
                    builder.append(str2);
                    builder.append(getDebugMode());
                    return builder.toString();
                }
            } else {
                JSONObject jSONObject2 = configObject;
            }
            builder.append(str);
            builder.append("debug");
            builder.append(str2);
            builder.append(getDebugMode());
        } else {
            JSONObject jSONObject3 = configObject;
        }
        return builder.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m35541n() {
        C12991g gVar = this.f33191la;
        if (gVar != null) {
            gVar.mo35357b();
        }
    }

    /* access modifiers changed from: private */
    public WebView getWebview() {
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35491a(String value, boolean result, String errorMessage, String errorCode) {
        C10897j ssaObj = new C10897j(value);
        String success = ssaObj.mo35673d(f33155m);
        String fail = ssaObj.mo35673d(f33156n);
        String funToCall = null;
        if (result) {
            if (!TextUtils.isEmpty(success)) {
                funToCall = success;
            }
        } else if (!TextUtils.isEmpty(fail)) {
            funToCall = fail;
        }
        if (!TextUtils.isEmpty(funToCall)) {
            if (!TextUtils.isEmpty(errorMessage)) {
                try {
                    value = new JSONObject(value).put("errMsg", errorMessage).toString();
                } catch (JSONException e) {
                }
            }
            if (!TextUtils.isEmpty(errorCode)) {
                try {
                    value = new JSONObject(value).put("errCode", errorCode).toString();
                } catch (JSONException e2) {
                }
            }
            m35536l(m35510d(funToCall, value));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public String m35530i(String jsonStr) {
        return new C10897j(jsonStr).mo35673d(f33155m);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public String m35528h(String jsonStr) {
        return new C10897j(jsonStr).mo35673d(f33156n);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m35485a(String key1, String value1, String key2, String value2, String key3, String value3, String key4, String value4, String key5, boolean value5) {
        JSONObject jsObj = new JSONObject();
        try {
            if (TextUtils.isEmpty(key1) || TextUtils.isEmpty(value1)) {
                String str = key1;
            } else {
                String str2 = key1;
                try {
                    jsObj.put(key1, C13004g.m42443a(value1));
                } catch (JSONException e) {
                    e = e;
                    String str3 = key2;
                    String str4 = key3;
                    String str5 = key4;
                    String str6 = key5;
                    boolean z = value5;
                    e.printStackTrace();
                    C12999b bVar = new C12999b();
                    StringBuilder sb = new StringBuilder();
                    sb.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
                    sb.append(e.getStackTrace()[0].getMethodName());
                    bVar.execute(new String[]{sb.toString()});
                    return jsObj.toString();
                }
            }
            if (TextUtils.isEmpty(key2) || TextUtils.isEmpty(value2)) {
                String str7 = key2;
            } else {
                try {
                    jsObj.put(key2, C13004g.m42443a(value2));
                } catch (JSONException e2) {
                    e = e2;
                    String str42 = key3;
                    String str52 = key4;
                    String str62 = key5;
                    boolean z2 = value5;
                    e.printStackTrace();
                    C12999b bVar2 = new C12999b();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
                    sb2.append(e.getStackTrace()[0].getMethodName());
                    bVar2.execute(new String[]{sb2.toString()});
                    return jsObj.toString();
                }
            }
            if (TextUtils.isEmpty(key3) || TextUtils.isEmpty(value3)) {
                String str8 = key3;
            } else {
                try {
                    jsObj.put(key3, C13004g.m42443a(value3));
                } catch (JSONException e3) {
                    e = e3;
                    String str522 = key4;
                    String str622 = key5;
                    boolean z22 = value5;
                    e.printStackTrace();
                    C12999b bVar22 = new C12999b();
                    StringBuilder sb22 = new StringBuilder();
                    sb22.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
                    sb22.append(e.getStackTrace()[0].getMethodName());
                    bVar22.execute(new String[]{sb22.toString()});
                    return jsObj.toString();
                }
            }
            if (TextUtils.isEmpty(key4) || TextUtils.isEmpty(value4)) {
                String str9 = key4;
            } else {
                try {
                    jsObj.put(key4, C13004g.m42443a(value4));
                } catch (JSONException e4) {
                    e = e4;
                    String str6222 = key5;
                    boolean z222 = value5;
                    e.printStackTrace();
                    C12999b bVar222 = new C12999b();
                    StringBuilder sb222 = new StringBuilder();
                    sb222.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
                    sb222.append(e.getStackTrace()[0].getMethodName());
                    bVar222.execute(new String[]{sb222.toString()});
                    return jsObj.toString();
                }
            }
            if (!TextUtils.isEmpty(key5)) {
                try {
                    jsObj.put(key5, value5);
                } catch (JSONException e5) {
                    e = e5;
                }
            } else {
                String str10 = key5;
                boolean z3 = value5;
            }
        } catch (JSONException e6) {
            e = e6;
            String str11 = key1;
            String str32 = key2;
            String str422 = key3;
            String str5222 = key4;
            String str62222 = key5;
            boolean z2222 = value5;
            e.printStackTrace();
            C12999b bVar2222 = new C12999b();
            StringBuilder sb2222 = new StringBuilder();
            sb2222.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
            sb2222.append(e.getStackTrace()[0].getMethodName());
            bVar2222.execute(new String[]{sb2222.toString()});
            return jsObj.toString();
        }
        return jsObj.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public Object[] m35516e(Context context) {
        char c;
        String str;
        String str2;
        String connectionType;
        String width;
        String str3;
        boolean fail = false;
        C12998a deviceProperties = C12998a.m42384b(context);
        JSONObject jsObj = new JSONObject();
        jsObj.put("appOrientation", C13004g.m42456c(C12725c.m41082a(getCurrentActivityContext())));
        String deviceOem = deviceProperties.mo41885d();
        if (deviceOem != null) {
            try {
                jsObj.put(C13004g.m42443a("deviceOEM"), C13004g.m42443a(deviceOem));
            } catch (JSONException e) {
                e = e;
                C12998a aVar = deviceProperties;
            }
        }
        try {
            String deviceModel = deviceProperties.mo41884c();
            if (deviceModel != null) {
                jsObj.put(C13004g.m42443a("deviceModel"), C13004g.m42443a(deviceModel));
            } else {
                fail = true;
            }
            C13004g.m42454b(context);
            String advertiserId = C13004g.m42450b();
            Boolean isLAT = Boolean.valueOf(C13004g.m42469l());
            str = "]";
            str2 = "[";
            if (!TextUtils.isEmpty(advertiserId)) {
                C13003f.m42438c(this.f33192o, "add AID and LAT");
                jsObj.put(GpsHelper.IS_LIMIT_AD_TRACKING_ENABLED_KEY, isLAT);
                StringBuilder aid = new StringBuilder();
                aid.append("deviceIds");
                aid.append(str2);
                aid.append("AID");
                aid.append(str);
                jsObj.put(aid.toString(), C13004g.m42443a(advertiserId));
            }
            String deviceOSType = deviceProperties.mo41886e();
            if (deviceOSType != null) {
                jsObj.put(C13004g.m42443a("deviceOs"), C13004g.m42443a(deviceOSType));
            } else {
                fail = true;
            }
            String deviceOSVersion = deviceProperties.mo41887f();
            if (deviceOSVersion != null) {
                jsObj.put(C13004g.m42443a("deviceOSVersion"), deviceOSVersion.replaceAll("[^0-9/.]", ""));
            } else {
                fail = true;
            }
            String deviceApiLevel = String.valueOf(deviceProperties.mo41882a());
            if (deviceApiLevel != null) {
                jsObj.put(C13004g.m42443a("deviceApiLevel"), deviceApiLevel);
            } else {
                fail = true;
            }
            String ssaSDKVersion = C12998a.m42385g();
            if (ssaSDKVersion != null) {
                jsObj.put(C13004g.m42443a("SDKVersion"), C13004g.m42443a(ssaSDKVersion));
            }
            if (deviceProperties.mo41883b() != null) {
                if (deviceProperties.mo41883b().length() > 0) {
                    jsObj.put(C13004g.m42443a("mobileCarrier"), C13004g.m42443a(deviceProperties.mo41883b()));
                }
            }
            connectionType = C12724b.m41073a(context);
            if (!TextUtils.isEmpty(connectionType)) {
                String str4 = deviceOem;
                jsObj.put(C13004g.m42443a("connectionType"), C13004g.m42443a(connectionType));
            } else {
                fail = true;
            }
            String deviceLanguage = context.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(deviceLanguage)) {
                String str5 = deviceLanguage;
                jsObj.put(C13004g.m42443a("deviceLanguage"), C13004g.m42443a(deviceLanguage.toUpperCase()));
            }
            if (C13004g.m42468k()) {
                jsObj.put(C13004g.m42443a("diskFreeSize"), C13004g.m42443a(String.valueOf(C12725c.m41084a(this.f33177U))));
            } else {
                fail = true;
            }
            int deviceWidth = C12725c.m41101h();
            width = String.valueOf(deviceWidth);
            str3 = "deviceScreenSize";
            if (!TextUtils.isEmpty(width)) {
                StringBuilder key = new StringBuilder();
                int i = deviceWidth;
                StringBuilder key2 = key;
                key2.append(C13004g.m42443a(str3));
                key2.append(str2);
                key2.append(C13004g.m42443a("width"));
                key2.append(str);
                StringBuilder sb = key2;
                jsObj.put(key2.toString(), C13004g.m42443a(width));
            } else {
                fail = true;
            }
        } catch (JSONException e2) {
            e = e2;
            C12998a aVar2 = deviceProperties;
            e.printStackTrace();
            C12999b bVar = new C12999b();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
            c = 0;
            sb2.append(e.getStackTrace()[0].getMethodName());
            bVar.execute(new String[]{sb2.toString()});
            Object[] result = new Object[2];
            result[c] = jsObj.toString();
            result[1] = Boolean.valueOf(fail);
            return result;
        }
        try {
            int deviceHeight = C12725c.m41093d();
            String height = String.valueOf(deviceHeight);
            StringBuilder key3 = new StringBuilder();
            int i2 = deviceHeight;
            String a = C13004g.m42443a(str3);
            boolean fail2 = fail;
            StringBuilder key4 = key3;
            key4.append(a);
            key4.append(str2);
            key4.append(C13004g.m42443a("height"));
            key4.append(str);
            jsObj.put(key4.toString(), C13004g.m42443a(height));
            String packageName = C12723a.m41072f(getContext());
            if (!TextUtils.isEmpty(packageName)) {
                try {
                    jsObj.put(C13004g.m42443a("bundleId"), C13004g.m42443a(packageName));
                } catch (JSONException e3) {
                    e = e3;
                    C12998a aVar3 = deviceProperties;
                    fail = fail2;
                }
            }
            try {
                String scaleStr = String.valueOf(C12725c.m41091c());
                if (!TextUtils.isEmpty(scaleStr)) {
                    String str6 = packageName;
                    String str7 = height;
                    jsObj.put(C13004g.m42443a("deviceScreenScale"), C13004g.m42443a(scaleStr));
                } else {
                    String str8 = height;
                }
                boolean isRoot = C12725c.m41104i();
                String rootStr = String.valueOf(isRoot);
                if (!TextUtils.isEmpty(rootStr)) {
                    boolean z = isRoot;
                    StringBuilder sb3 = key4;
                    jsObj.put(C13004g.m42443a("unLocked"), C13004g.m42443a(rootStr));
                } else {
                    StringBuilder sb4 = key4;
                }
                float deviceVolume = C12998a.m42384b(context).mo41881a(context);
                if (!TextUtils.isEmpty(rootStr)) {
                    String str9 = rootStr;
                    C12998a aVar4 = deviceProperties;
                    try {
                        jsObj.put(C13004g.m42443a("deviceVolume"), (double) deviceVolume);
                    } catch (JSONException e4) {
                        e = e4;
                        fail = fail2;
                        e.printStackTrace();
                        C12999b bVar2 = new C12999b();
                        StringBuilder sb22 = new StringBuilder();
                        sb22.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
                        c = 0;
                        sb22.append(e.getStackTrace()[0].getMethodName());
                        bVar2.execute(new String[]{sb22.toString()});
                        Object[] result2 = new Object[2];
                        result2[c] = jsObj.toString();
                        result2[1] = Boolean.valueOf(fail);
                        return result2;
                    }
                } else {
                    C12998a aVar5 = deviceProperties;
                }
                Context ctx = getCurrentActivityContext();
                if (VERSION.SDK_INT >= 19 && (ctx instanceof Activity)) {
                    jsObj.put(C13004g.m42443a("immersiveMode"), C12725c.m41086a((Activity) ctx));
                }
                jsObj.put(C13004g.m42443a("batteryLevel"), C12725c.m41094d(ctx));
                jsObj.put(C13004g.m42443a("mcc"), C12724b.m41074b(ctx));
                jsObj.put(C13004g.m42443a("mnc"), C12724b.m41075c(ctx));
                jsObj.put(C13004g.m42443a("phoneType"), C12724b.m41076d(ctx));
                jsObj.put(C13004g.m42443a("simOperator"), C13004g.m42443a(C12724b.m41077e(ctx)));
                String str10 = connectionType;
                String str11 = width;
                jsObj.put(C13004g.m42443a("lastUpdateTime"), C12723a.m41071e(ctx));
                jsObj.put(C13004g.m42443a("firstInstallTime"), C12723a.m41068c(ctx));
                jsObj.put(C13004g.m42443a("appVersion"), C13004g.m42443a(C12723a.m41066b(ctx)));
                String installerPackageName = C12723a.m41070d(ctx);
                if (!TextUtils.isEmpty(installerPackageName)) {
                    jsObj.put(C13004g.m42443a("installerPackageName"), C13004g.m42443a(installerPackageName));
                }
                fail = fail2;
                c = 0;
            } catch (JSONException e5) {
                e = e5;
                C12998a aVar6 = deviceProperties;
                fail = fail2;
                e.printStackTrace();
                C12999b bVar22 = new C12999b();
                StringBuilder sb222 = new StringBuilder();
                sb222.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
                c = 0;
                sb222.append(e.getStackTrace()[0].getMethodName());
                bVar22.execute(new String[]{sb222.toString()});
                Object[] result22 = new Object[2];
                result22[c] = jsObj.toString();
                result22[1] = Boolean.valueOf(fail);
                return result22;
            }
        } catch (JSONException e6) {
            e = e6;
            boolean z2 = fail;
            C12998a aVar7 = deviceProperties;
            e.printStackTrace();
            C12999b bVar222 = new C12999b();
            StringBuilder sb2222 = new StringBuilder();
            sb2222.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
            c = 0;
            sb2222.append(e.getStackTrace()[0].getMethodName());
            bVar222.execute(new String[]{sb2222.toString()});
            Object[] result222 = new Object[2];
            result222[c] = jsObj.toString();
            result222[1] = Boolean.valueOf(fail);
            return result222;
        }
        Object[] result2222 = new Object[2];
        result2222[c] = jsObj.toString();
        result2222[1] = Boolean.valueOf(fail);
        return result2222;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public Object[] m35517e(String productType, String demandSourceId) {
        boolean fail = false;
        JSONObject jsObj = new JSONObject();
        Map<String, String> productExtraParams = null;
        if (!TextUtils.isEmpty(productType)) {
            C10895h type = m35535k(productType);
            if (type == C10895h.OfferWall) {
                productExtraParams = this.f33197t;
            } else {
                C10890c demandSource = this.f33184ea.mo35437a(type, demandSourceId);
                if (demandSource != null) {
                    productExtraParams = demandSource.mo35654d();
                    productExtraParams.put("demandSourceName", demandSource.mo35652c());
                    productExtraParams.put("demandSourceId", demandSource.mo35655e());
                }
            }
            try {
                jsObj.put("productType", productType);
            } catch (JSONException e) {
                e.printStackTrace();
                new C12999b().execute(new String[]{"https://www.supersonicads.com/mobile/sdk5/log?method=noProductType"});
            }
            try {
                Map initParams = C13004g.m42465h();
                if (initParams != null) {
                    jsObj = C13004g.m42448a(jsObj, new JSONObject(initParams));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                new C12999b().execute(new String[]{"https://www.supersonicads.com/mobile/sdk5/log?method=Bad merged params objects"});
            }
        } else {
            fail = true;
        }
        if (!TextUtils.isEmpty(this.f33196s)) {
            try {
                jsObj.put(C13004g.m42443a("applicationUserId"), C13004g.m42443a(this.f33196s));
            } catch (JSONException e3) {
                e3.printStackTrace();
                new C12999b().execute(new String[]{"https://www.supersonicads.com/mobile/sdk5/log?method=encodeAppUserId"});
            }
        } else {
            fail = true;
        }
        if (!TextUtils.isEmpty(this.f33195r)) {
            try {
                jsObj.put(C13004g.m42443a("applicationKey"), C13004g.m42443a(this.f33195r));
            } catch (JSONException e4) {
                e4.printStackTrace();
                new C12999b().execute(new String[]{"https://www.supersonicads.com/mobile/sdk5/log?method=encodeAppKey"});
            }
        } else {
            fail = true;
        }
        if (productExtraParams != null && !productExtraParams.isEmpty()) {
            for (Entry<String, String> entry : productExtraParams.entrySet()) {
                if (((String) entry.getKey()).equalsIgnoreCase("sdkWebViewCache")) {
                    setWebviewCache((String) entry.getValue());
                }
                try {
                    jsObj.put(C13004g.m42443a((String) entry.getKey()), C13004g.m42443a((String) entry.getValue()));
                } catch (JSONException e5) {
                    e5.printStackTrace();
                    new C12999b().execute(new String[]{"https://www.supersonicads.com/mobile/sdk5/log?method=extraParametersToJson"});
                }
            }
        }
        return new Object[]{jsObj.toString(), Boolean.valueOf(fail)};
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public Object[] m35521f(String appIds, String requestId) {
        String str = appIds;
        String str2 = requestId;
        String str3 = "null";
        boolean fail = false;
        JSONObject result = new JSONObject();
        try {
            String str4 = "error";
            if (!TextUtils.isEmpty(appIds)) {
                if (!str.equalsIgnoreCase(str3)) {
                    if (TextUtils.isEmpty(requestId) || str2.equalsIgnoreCase(str3)) {
                        fail = true;
                        result.put(str4, "requestId is null or empty");
                        return new Object[]{result.toString(), Boolean.valueOf(fail)};
                    }
                    List<ApplicationInfo> packages = C12725c.m41100g(getContext());
                    JSONArray appIdsArray = new JSONArray(str);
                    JSONObject bundleIds = new JSONObject();
                    for (int i = 0; i < appIdsArray.length(); i++) {
                        String appId = appIdsArray.getString(i).trim();
                        if (!TextUtils.isEmpty(appId)) {
                            JSONObject isInstalled = new JSONObject();
                            boolean found = false;
                            Iterator it = packages.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                } else if (appId.equalsIgnoreCase(((ApplicationInfo) it.next()).packageName)) {
                                    isInstalled.put(f33153k, true);
                                    bundleIds.put(appId, isInstalled);
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                isInstalled.put(f33153k, false);
                                bundleIds.put(appId, isInstalled);
                            }
                        }
                    }
                    result.put(f33154l, bundleIds);
                    result.put(f33152j, str2);
                    return new Object[]{result.toString(), Boolean.valueOf(fail)};
                }
            }
            fail = true;
            result.put(str4, "appIds is null or empty");
        } catch (Exception e) {
            fail = true;
        }
        return new Object[]{result.toString(), Boolean.valueOf(fail)};
    }

    /* renamed from: a */
    public void mo35460a(C10896i file) {
        if (file.mo35662c().contains("mobileController.html")) {
            mo35454a(1);
        } else {
            mo35463a(file.mo35662c(), file.mo35664e());
        }
    }

    /* renamed from: b */
    public void mo35474b(C10896i file) {
        if (file.mo35662c().contains("mobileController.html")) {
            this.f33159C.cancel();
            Iterator it = this.f33184ea.mo35439a(C10895h.RewardedVideo).iterator();
            while (it.hasNext()) {
                C10890c demandSource = (C10890c) it.next();
                if (demandSource.mo35650b() == 1) {
                    m35505c(C10895h.RewardedVideo, demandSource);
                }
            }
            Iterator it2 = this.f33184ea.mo35439a(C10895h.Interstitial).iterator();
            while (it2.hasNext()) {
                C10890c demandSource2 = (C10890c) it2.next();
                if (demandSource2.mo35650b() == 1) {
                    m35505c(C10895h.Interstitial, demandSource2);
                }
            }
            Iterator it3 = this.f33184ea.mo35439a(C10895h.Banner).iterator();
            while (it3.hasNext()) {
                C10890c demandSource3 = (C10890c) it3.next();
                if (demandSource3.mo35650b() == 1) {
                    m35505c(C10895h.Banner, demandSource3);
                }
            }
            if (this.f33199v) {
                m35505c(C10895h.OfferWall, (C10890c) null);
            }
            if (this.f33200w) {
                m35505c(C10895h.OfferWallCredits, (C10890c) null);
                return;
            }
            return;
        }
        mo35468a(file.mo35662c(), file.mo35664e(), file.mo35661b());
    }

    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
        String str = this.f33192o;
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append(" ");
        sb.append(mimetype);
        C13003f.m42438c(str, sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m35529h(String methodName, String value) {
        String message = new C10897j(value).mo35673d("errMsg");
        if (!TextUtils.isEmpty(message)) {
            mo35461a((Runnable) new C10866n(this, methodName, message));
        }
    }

    public void setControllerKeyPressed(String value) {
        this.f33203z = value;
    }

    public String getControllerKeyPressed() {
        String keyPressed = this.f33203z;
        setControllerKeyPressed("interrupt");
        return keyPressed;
    }

    /* renamed from: a */
    public void mo35462a(String networkType) {
        m35536l(m35510d("deviceStatusChanged", m35485a("connectionType", networkType, null, null, null, null, null, null, null, false)));
    }

    /* renamed from: b */
    public void mo35475b(String action) {
        if (action.equals("forceClose")) {
            m35541n();
        }
        m35536l(m35510d("engageEnd", m35485a("action", action, null, null, null, null, null, null, null, false)));
    }

    /* renamed from: c */
    public void mo35479c(Context context) {
        context.registerReceiver(this.f33190ka, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    /* renamed from: d */
    public void mo35484d(Context context) {
        try {
            context.unregisterReceiver(this.f33190ka);
        } catch (IllegalArgumentException e) {
        } catch (Exception e1) {
            String str = this.f33192o;
            StringBuilder sb = new StringBuilder();
            sb.append("unregisterConnectionReceiver - ");
            sb.append(e1);
            Log.e(str, sb.toString());
            C12999b bVar = new C12999b();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
            sb2.append(e1.getStackTrace()[0].getMethodName());
            bVar.execute(new String[]{sb2.toString()});
        }
    }

    /* renamed from: k */
    public void mo35505k() {
        if (VERSION.SDK_INT > 10) {
            try {
                onPause();
            } catch (Throwable e) {
                String str = this.f33192o;
                StringBuilder sb = new StringBuilder();
                sb.append("WebViewController: pause() - ");
                sb.append(e);
                C13003f.m42438c(str, sb.toString());
                new C12999b().execute(new String[]{"https://www.supersonicads.com/mobile/sdk5/log?method=webviewPause"});
            }
        }
    }

    /* renamed from: m */
    public void mo35507m() {
        if (VERSION.SDK_INT > 10) {
            try {
                onResume();
            } catch (Throwable e) {
                String str = this.f33192o;
                StringBuilder sb = new StringBuilder();
                sb.append("WebViewController: onResume() - ");
                sb.append(e);
                C13003f.m42438c(str, sb.toString());
                new C12999b().execute(new String[]{"https://www.supersonicads.com/mobile/sdk5/log?method=webviewResume"});
            }
        }
    }

    public void setOnWebViewControllerChangeListener(C12991g listener) {
        this.f33191la = listener;
    }

    public FrameLayout getLayout() {
        return this.f33167K;
    }

    /* renamed from: h */
    public boolean mo35502h() {
        return this.f33164H != null;
    }

    /* renamed from: g */
    public void mo35492g() {
        this.f33163G.onHideCustomView();
    }

    private void setWebviewCache(String value) {
        if (value.equalsIgnoreCase(BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID)) {
            getSettings().setCacheMode(2);
        } else {
            getSettings().setCacheMode(-1);
        }
    }

    /* renamed from: c */
    public boolean mo35482c(String url) {
        List<String> searchKeys = C13001d.m42395g().mo41906e();
        if (searchKeys != null) {
            try {
                if (!searchKeys.isEmpty()) {
                    for (String key : searchKeys) {
                        if (url.contains(key)) {
                            C12731g.m41114a(getCurrentActivityContext(), url);
                            return true;
                        }
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public void setState(C10884f state) {
        this.f33168L = state;
    }

    public C10884f getState() {
        return this.f33168L;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m35505c(C10895h type, C10890c demandSource) {
        m35489a(C13004g.m42444a(m35499b(type), "Initiating Controller"), type, demandSource);
    }

    /* renamed from: b */
    private String m35499b(C10895h type) {
        String action = "";
        int i = C10868p.f33133a[type.ordinal()];
        if (i == 1) {
            return "Init RV";
        }
        if (i == 2) {
            return "Init IS";
        }
        if (i == 3) {
            return "Init OW";
        }
        if (i == 4) {
            return "Show OW Credits";
        }
        if (i != 5) {
            return action;
        }
        return "Init BN";
    }

    public void destroy() {
        super.destroy();
        C12992a aVar = this.f33198u;
        if (aVar != null) {
            aVar.mo41865d();
        }
        if (this.f33190ka != null) {
            this.f33190ka = null;
        }
        this.f33182ca = null;
        this.f33181ba = null;
    }

    /* renamed from: j */
    private String m35533j(String funToCall) {
        StringBuilder script = new StringBuilder();
        script.append("SSA_CORE.SDKController.runFunction('");
        script.append(funToCall);
        script.append("');");
        return script.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public String m35510d(String funToCall, String parameters) {
        StringBuilder script = new StringBuilder();
        script.append("SSA_CORE.SDKController.runFunction('");
        script.append(funToCall);
        script.append("?parameters=");
        script.append(parameters);
        script.append("');");
        return script.toString();
    }

    /* renamed from: b */
    private String m35500b(String funToCall, String successFunc, String failFunc) {
        StringBuilder script = new StringBuilder();
        script.append("SSA_CORE.SDKController.runFunction('");
        script.append(funToCall);
        String str = "','";
        script.append(str);
        script.append(successFunc);
        script.append(str);
        script.append(failFunc);
        script.append("');");
        return script.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m35484a(String funToCall, String parameters, String successFunc, String failFunc) {
        StringBuilder script = new StringBuilder();
        script.append("SSA_CORE.SDKController.runFunction('");
        script.append(funToCall);
        script.append("?parameters=");
        script.append(parameters);
        String str = "','";
        script.append(str);
        script.append(successFunc);
        script.append(str);
        script.append(failFunc);
        script.append("');");
        return script.toString();
    }

    public AdUnitsState getSavedState() {
        return this.f33179W;
    }

    /* renamed from: a */
    public void mo35458a(AdUnitsState state) {
        synchronized (this.f33180aa) {
            if (state.mo35634i() && this.f33175S.equals(C10893f.Ready)) {
                String str = this.f33192o;
                StringBuilder sb = new StringBuilder();
                sb.append("restoreState(state:");
                sb.append(state);
                sb.append(")");
                Log.d(str, sb.toString());
                int lastAd = state.mo35623c();
                if (lastAd != -1) {
                    if (lastAd == C10895h.RewardedVideo.ordinal()) {
                        Log.d(this.f33192o, "onRVAdClosed()");
                        C10895h type = C10895h.RewardedVideo;
                        String demandSourceId = state.mo35620b();
                        C12982a listener = m35476a(type);
                        if (listener != null && !TextUtils.isEmpty(demandSourceId)) {
                            listener.mo41840b(type, demandSourceId);
                        }
                    } else if (lastAd == C10895h.Interstitial.ordinal()) {
                        Log.d(this.f33192o, "onInterstitialAdClosed()");
                        C10895h type2 = C10895h.Interstitial;
                        String demandSourceId2 = state.mo35620b();
                        C12982a listener2 = m35476a(type2);
                        if (listener2 != null && !TextUtils.isEmpty(demandSourceId2)) {
                            listener2.mo41840b(type2, demandSourceId2);
                        }
                    } else if (lastAd == C10895h.OfferWall.ordinal()) {
                        Log.d(this.f33192o, "onOWAdClosed()");
                        if (this.f33173Q != null) {
                            this.f33173Q.onOWAdClosed();
                        }
                    }
                    state.mo35615a(-1);
                    state.mo35616a((String) null);
                } else {
                    Log.d(this.f33192o, "No ad was opened");
                }
                String appKey = state.mo35626d();
                String userId = state.mo35629e();
                Iterator it = this.f33184ea.mo35439a(C10895h.Interstitial).iterator();
                while (it.hasNext()) {
                    C10890c demandSource = (C10890c) it.next();
                    if (demandSource.mo35650b() == 2) {
                        String str2 = this.f33192o;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("initInterstitial(appKey:");
                        sb2.append(appKey);
                        sb2.append(", userId:");
                        sb2.append(userId);
                        sb2.append(", demandSource:");
                        sb2.append(demandSource.mo35652c());
                        sb2.append(")");
                        Log.d(str2, sb2.toString());
                        mo35465a(appKey, userId, demandSource, this.f33172P);
                    }
                }
                String appKey2 = state.mo35631f();
                String userId2 = state.mo35632g();
                for (C10890c demandSource2 : this.f33184ea.mo35439a(C10895h.RewardedVideo)) {
                    if (demandSource2.mo35650b() == 2) {
                        String demandSourceName = demandSource2.mo35652c();
                        Log.d(this.f33192o, "onRVNoMoreOffers()");
                        this.f33170N.mo41841b(demandSourceName);
                        String str3 = this.f33192o;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("initRewardedVideo(appKey:");
                        sb3.append(appKey2);
                        sb3.append(", userId:");
                        sb3.append(userId2);
                        sb3.append(", demandSource:");
                        sb3.append(demandSourceName);
                        sb3.append(")");
                        Log.d(str3, sb3.toString());
                        mo35466a(appKey2, userId2, demandSource2, this.f33170N);
                    }
                }
                state.mo35625c(false);
            }
            this.f33179W = state;
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4) {
            return super.onKeyDown(keyCode, event);
        }
        if (!this.f33191la.mo35356a()) {
            return super.onKeyDown(keyCode, event);
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35461a(Runnable task) {
        this.f33182ca.post(task);
    }
}
