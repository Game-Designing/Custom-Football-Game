package com.moat.analytics.mobile.vng;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.vng.g */
class C11159g {

    /* renamed from: a */
    WebView f34065a;

    /* renamed from: b */
    C11169j f34066b;

    /* renamed from: c */
    final String f34067c = String.format(Locale.ROOT, "_moatTracker%d", new Object[]{Integer.valueOf((int) (Math.random() * 1.0E8d))});

    /* renamed from: d */
    private final C11162a f34068d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f34069e = false;

    /* renamed from: com.moat.analytics.mobile.vng.g$a */
    enum C11162a {
        DISPLAY,
        VIDEO
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    C11159g(Context context, C11162a aVar) {
        this.f34068d = aVar;
        this.f34065a = new WebView(context);
        WebSettings settings = this.f34065a.getSettings();
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
        C11173a aVar2 = C11173a.NATIVE_DISPLAY;
        if (aVar == C11162a.VIDEO) {
            aVar2 = C11173a.NATIVE_VIDEO;
        }
        this.f34066b = new C11169j(this.f34065a, aVar2);
    }

    /* renamed from: a */
    private static String m36714a(String str, String str2, Integer num, Integer num2, JSONObject jSONObject, Integer num3) {
        String str3 = "mianahwvc";
        return String.format(Locale.ROOT, "<html><head></head><body><div id=\"%s\" style=\"width: %dpx; height: %dpx;\"></div><script>(function initMoatTracking(apiname, pcode, ids, duration) {var events = [];window[pcode + '_moatElToTrack'] = document.getElementById('%s');var moatapi = {'dropTime':%d,'adData': {'ids': ids, 'duration': duration, 'url': 'n/a'},'dispatchEvent': function(ev) {if (this.sendEvent) {if (events) { events.push(ev); ev = events; events = false; }this.sendEvent(ev);} else {events.push(ev);}},'dispatchMany': function(evs){for (var i=0, l=evs.length; i<l; i++) {this.dispatchEvent(evs[i]);}}};Object.defineProperty(window, apiname, {'value': moatapi});var s = document.createElement('script');s.src = 'https://z.moatads.com/' + pcode + '/moatvideo.js?' + apiname + '#' + apiname;document.body.appendChild(s);})('%s', '%s', %s, %s);</script></body></html>", new Object[]{str3, num, num2, str3, Long.valueOf(System.currentTimeMillis()), str, str2, jSONObject.toString(), num3});
    }

    /* renamed from: b */
    private static String m36717b(String str) {
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
    public void mo36337a() {
        this.f34066b = null;
        this.f34065a.destroy();
        this.f34065a = null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36338a(String str) {
        if (this.f34068d == C11162a.DISPLAY) {
            this.f34065a.setWebViewClient(new WebViewClient() {
                public void onPageFinished(WebView webView, String str) {
                    if (!C11159g.this.f34069e) {
                        try {
                            C11159g.this.f34069e = true;
                            C11159g.this.f34066b.mo36353a();
                        } catch (Exception e) {
                            C11176m.m36783a(e);
                        }
                    }
                }
            });
            this.f34065a.loadData(m36717b(str), "text/html", "utf-8");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36339a(String str, Map<String, String> map, Integer num, Integer num2, Integer num3) {
        if (this.f34068d == C11162a.VIDEO) {
            this.f34065a.setWebViewClient(new WebViewClient() {
                public void onPageFinished(WebView webView, String str) {
                    if (!C11159g.this.f34069e) {
                        try {
                            C11159g.this.f34069e = true;
                            C11159g.this.f34066b.mo36353a();
                            C11159g.this.f34066b.mo36359c(C11159g.this.f34067c);
                        } catch (Exception e) {
                            C11176m.m36783a(e);
                        }
                    }
                }
            });
            this.f34065a.loadData(m36714a(this.f34067c, str, num, num2, new JSONObject(map), num3), "text/html", null);
        }
    }
}
