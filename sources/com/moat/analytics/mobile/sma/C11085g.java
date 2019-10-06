package com.moat.analytics.mobile.sma;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.sma.g */
class C11085g {

    /* renamed from: a */
    WebView f33878a;

    /* renamed from: b */
    C11095j f33879b;

    /* renamed from: c */
    final String f33880c = String.format(Locale.ROOT, "_moatTracker%d", new Object[]{Integer.valueOf((int) (Math.random() * 1.0E8d))});

    /* renamed from: d */
    private final C11088a f33881d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f33882e = false;

    /* renamed from: com.moat.analytics.mobile.sma.g$a */
    enum C11088a {
        DISPLAY,
        VIDEO
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    C11085g(Context context, C11088a aVar) {
        this.f33881d = aVar;
        this.f33878a = new WebView(context);
        WebSettings settings = this.f33878a.getSettings();
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
        C11099a aVar2 = C11099a.NATIVE_DISPLAY;
        if (aVar == C11088a.VIDEO) {
            aVar2 = C11099a.NATIVE_VIDEO;
        }
        this.f33879b = new C11095j(this.f33878a, aVar2);
    }

    /* renamed from: a */
    private static String m36473a(String str, String str2, Integer num, Integer num2, JSONObject jSONObject, Integer num3) {
        String str3 = "mianahwvc";
        return String.format(Locale.ROOT, "<html><head></head><body><div id=\"%s\" style=\"width: %dpx; height: %dpx;\"></div><script>(function initMoatTracking(apiname, pcode, ids, duration) {var events = [];window[pcode + '_moatElToTrack'] = document.getElementById('%s');var moatapi = {'dropTime':%d,'adData': {'ids': ids, 'duration': duration, 'url': 'n/a'},'dispatchEvent': function(ev) {if (this.sendEvent) {if (events) { events.push(ev); ev = events; events = false; }this.sendEvent(ev);} else {events.push(ev);}},'dispatchMany': function(evs){for (var i=0, l=evs.length; i<l; i++) {this.dispatchEvent(evs[i]);}}};Object.defineProperty(window, apiname, {'value': moatapi});var s = document.createElement('script');s.src = 'https://z.moatads.com/' + pcode + '/moatvideo.js?' + apiname + '#' + apiname;document.body.appendChild(s);})('%s', '%s', %s, %s);</script></body></html>", new Object[]{str3, num, num2, str3, Long.valueOf(System.currentTimeMillis()), str, str2, jSONObject.toString(), num3});
    }

    /* renamed from: b */
    private static String m36476b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n<html>\n<head lang=\"en\">\n   <meta charset=\"UTF-8\">\n   <title></title>\n</head>\n<body style=\"margin:0;padding:0;\">\n    <script src=\"https://z.moatads.com/");
        sb.append(str);
        sb.append("/moatad.js\" type=\"text/javascript\"></script>\n");
        sb.append("</body>\n");
        sb.append("</html>");
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36204a() {
        this.f33879b = null;
        this.f33878a.destroy();
        this.f33878a = null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36205a(String str) {
        if (this.f33881d == C11088a.DISPLAY) {
            this.f33878a.setWebViewClient(new WebViewClient() {
                public void onPageFinished(WebView webView, String str) {
                    if (!C11085g.this.f33882e) {
                        try {
                            C11085g.this.f33882e = true;
                            C11085g.this.f33879b.mo36221a();
                        } catch (Exception e) {
                            C11102m.m36543a(e);
                        }
                    }
                }
            });
            this.f33878a.loadData(m36476b(str), "text/html", "utf-8");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36206a(String str, Map<String, String> map, Integer num, Integer num2, Integer num3) {
        if (this.f33881d == C11088a.VIDEO) {
            this.f33878a.setWebViewClient(new WebViewClient() {
                public void onPageFinished(WebView webView, String str) {
                    if (!C11085g.this.f33882e) {
                        try {
                            C11085g.this.f33882e = true;
                            C11085g.this.f33879b.mo36221a();
                            C11085g.this.f33879b.mo36227c(C11085g.this.f33880c);
                        } catch (Exception e) {
                            C11102m.m36543a(e);
                        }
                    }
                }
            });
            this.f33878a.loadData(m36473a(this.f33880c, str, num, num2, new JSONObject(map), num3), "text/html", null);
        }
    }
}
