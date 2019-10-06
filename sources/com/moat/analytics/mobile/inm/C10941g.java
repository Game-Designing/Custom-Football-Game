package com.moat.analytics.mobile.inm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.inm.g */
class C10941g {

    /* renamed from: a */
    WebView f33446a;

    /* renamed from: b */
    C10953j f33447b;

    /* renamed from: c */
    final String f33448c = String.format(Locale.ROOT, "_moatTracker%d", new Object[]{Integer.valueOf((int) (Math.random() * 1.0E8d))});

    /* renamed from: d */
    private final C10946a f33449d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f33450e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Handler f33451f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Runnable f33452g;

    /* renamed from: com.moat.analytics.mobile.inm.g$a */
    enum C10946a {
        DISPLAY,
        VIDEO
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    C10941g(Context context, C10946a aVar) {
        this.f33449d = aVar;
        this.f33446a = new WebView(context);
        WebSettings settings = this.f33446a.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccess(false);
        settings.setDatabaseEnabled(false);
        settings.setDomStorageEnabled(false);
        settings.setGeolocationEnabled(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setSaveFormData(false);
        if (VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(1);
        }
        C10957a aVar2 = C10957a.NATIVE_DISPLAY;
        if (aVar == C10946a.VIDEO) {
            aVar2 = C10957a.NATIVE_VIDEO;
        }
        try {
            this.f33447b = new C10953j(this.f33446a, aVar2);
        } catch (C10960m e) {
            C10960m.m36077a(e);
        }
    }

    /* renamed from: a */
    private static String m35996a(String str, String str2, Integer num, Integer num2, JSONObject jSONObject, Integer num3) {
        String str3 = "mianahwvc";
        return String.format(Locale.ROOT, "<html><head></head><body><div id=\"%s\" style=\"width: %dpx; height: %dpx;\"></div><script>(function initMoatTracking(apiname, pcode, ids, duration) {var events = [];window[pcode + '_moatElToTrack'] = document.getElementById('%s');var moatapi = {'dropTime':%d,'adData': {'ids': ids, 'duration': duration, 'url': 'n/a'},'dispatchEvent': function(ev) {if (this.sendEvent) {if (events) { events.push(ev); ev = events; events = false; }this.sendEvent(ev);} else {events.push(ev);}},'dispatchMany': function(evs){for (var i=0, l=evs.length; i<l; i++) {this.dispatchEvent(evs[i]);}}};Object.defineProperty(window, apiname, {'value': moatapi});var s = document.createElement('script');s.src = 'https://z.moatads.com/' + pcode + '/moatvideo.js?' + apiname + '#' + apiname;document.body.appendChild(s);})('%s', '%s', %s, %s);</script></body></html>", new Object[]{str3, num, num2, str3, Long.valueOf(System.currentTimeMillis()), str, str2, jSONObject.toString(), num3});
    }

    /* renamed from: b */
    private static String m36000b(String str) {
        StringBuilder sb = new StringBuilder("<!DOCTYPE html>\n<html>\n<head lang=\"en\">\n   <meta charset=\"UTF-8\">\n   <title></title>\n</head>\n<body style=\"margin:0;padding:0;\">\n    <script src=\"https://z.moatads.com/");
        sb.append(str);
        sb.append("/moatad.js\" type=\"text/javascript\"></script>\n</body>\n</html>");
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35917a() {
        C10969p.m36113a(3, "GlobalWebView", (Object) this, "Cleaning up");
        this.f33447b.mo35942b();
        this.f33447b = null;
        this.f33446a.destroy();
        this.f33446a = null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35918a(String str) {
        if (this.f33449d == C10946a.DISPLAY) {
            this.f33446a.setWebViewClient(new WebViewClient() {
                public void onPageFinished(WebView webView, String str) {
                    if (!C10941g.this.f33450e) {
                        try {
                            C10941g.this.f33450e = true;
                            C10941g.this.f33447b.mo35938a();
                        } catch (Exception e) {
                            C10960m.m36077a(e);
                        }
                    }
                }
            });
            this.f33446a.loadData(m36000b(str), "text/html", "utf-8");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35919a(String str, Map<String, String> map, Integer num, Integer num2, Integer num3) {
        if (this.f33449d == C10946a.VIDEO) {
            String str2 = "GlobalWebView";
            if (VERSION.SDK_INT >= 19) {
                C10969p.m36113a(3, str2, (Object) this, "Starting off polling interval to check for Video API instance presence");
                this.f33451f = new Handler();
                this.f33452g = new Runnable() {
                    public void run() {
                        try {
                            if (C10941g.this.f33446a != null && VERSION.SDK_INT >= 19) {
                                WebView webView = C10941g.this.f33446a;
                                StringBuilder sb = new StringBuilder("typeof ");
                                sb.append(C10941g.this.f33448c);
                                sb.append(" !== 'undefined'");
                                webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() {
                                    /* renamed from: a */
                                    public void onReceiveValue(String str) {
                                        if ("true".equals(str)) {
                                            C10969p.m36113a(3, "GlobalWebView", (Object) this, String.format("Video API instance %s detected. Flushing event queue", new Object[]{C10941g.this.f33448c}));
                                            try {
                                                C10941g.this.f33450e = true;
                                                C10941g.this.f33447b.mo35938a();
                                                C10941g.this.f33447b.mo35946c(C10941g.this.f33448c);
                                            } catch (Exception e) {
                                                C10960m.m36077a(e);
                                            }
                                        } else {
                                            C10941g.this.f33451f.postDelayed(C10941g.this.f33452g, 200);
                                        }
                                    }
                                });
                            }
                        } catch (Exception e) {
                            C10960m.m36077a(e);
                        }
                    }
                };
                this.f33451f.post(this.f33452g);
            } else {
                StringBuilder sb = new StringBuilder("Android API version is less than KitKat: ");
                sb.append(VERSION.SDK_INT);
                C10969p.m36113a(3, str2, (Object) this, sb.toString());
                this.f33446a.setWebViewClient(new WebViewClient() {
                    public void onPageFinished(WebView webView, String str) {
                        if (!C10941g.this.f33450e) {
                            C10969p.m36113a(3, "GlobalWebView", (Object) this, "onPageFinished is called for the first time. Flushing event queue");
                            try {
                                C10941g.this.f33450e = true;
                                C10941g.this.f33447b.mo35938a();
                                C10941g.this.f33447b.mo35946c(C10941g.this.f33448c);
                            } catch (Exception e) {
                                C10960m.m36077a(e);
                            }
                        }
                    }
                });
            }
            this.f33446a.loadData(m35996a(this.f33448c, str, num, num2, new JSONObject(map), num3), "text/html", null);
        }
    }
}
