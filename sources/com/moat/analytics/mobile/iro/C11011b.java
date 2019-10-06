package com.moat.analytics.mobile.iro;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.moat.analytics.mobile.iro.b */
final class C11011b {

    /* renamed from: ˊ */
    final String f33636;

    /* renamed from: ˋ */
    C11019f f33637;

    /* renamed from: ˎ */
    private final int f33638;

    /* renamed from: ˏ */
    WebView f33639;
    /* access modifiers changed from: private */

    /* renamed from: ॱ */
    public boolean f33640;

    /* renamed from: com.moat.analytics.mobile.iro.b$a */
    enum C11014a {
        ;
        

        /* renamed from: ˎ */
        public static final int f33643 = 0;

        /* renamed from: ˏ */
        public static final int f33644 = 0;

        static {
            f33644 = 1;
            f33643 = 2;
            int[] iArr = {1, 2};
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    C11011b(Application application, int i) {
        this.f33638 = i;
        this.f33640 = false;
        this.f33636 = String.format(Locale.ROOT, "_moatTracker%d", new Object[]{Integer.valueOf((int) (Math.random() * 1.0E8d))});
        this.f33639 = new WebView(application);
        WebSettings settings = this.f33639.getSettings();
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
        int i2 = C11023b.f33696;
        if (i == C11014a.f33643) {
            i2 = C11023b.f33695;
        }
        try {
            this.f33637 = new C11019f(this.f33639, i2);
        } catch (C11043o e) {
            C11043o.m36351(e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˋ */
    public final void mo36038(String str) {
        if (this.f33638 == C11014a.f33644) {
            this.f33639.setWebViewClient(new WebViewClient() {
                public final void onPageFinished(WebView webView, String str) {
                    if (!C11011b.this.f33640) {
                        try {
                            C11011b.this.f33640 = true;
                            C11011b.this.f33637.mo36084();
                        } catch (Exception e) {
                            C11043o.m36351(e);
                        }
                    }
                }
            });
            WebView webView = this.f33639;
            StringBuilder sb = new StringBuilder("<!DOCTYPE html>\n<html>\n<head lang=\"en\">\n   <meta charset=\"UTF-8\">\n   <title></title>\n</head>\n<body style=\"margin:0;padding:0;\">\n    <script src=\"https://z.moatads.com/");
            sb.append(str);
            sb.append("/moatad.js\" type=\"text/javascript\"></script>\n</body>\n</html>");
            webView.loadData(sb.toString(), "text/html", "utf-8");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˎ */
    public final void mo36039(String str, Map<String, String> map, Integer num, Integer num2, Integer num3) {
        if (this.f33638 == C11014a.f33643) {
            this.f33639.setWebViewClient(new WebViewClient() {
                public final void onPageFinished(WebView webView, String str) {
                    if (!C11011b.this.f33640) {
                        try {
                            C11011b.this.f33640 = true;
                            C11011b.this.f33637.mo36084();
                            C11011b.this.f33637.mo36086(C11011b.this.f33636);
                        } catch (Exception e) {
                            C11043o.m36351(e);
                        }
                    }
                }
            });
            JSONObject jSONObject = new JSONObject(map);
            WebView webView = this.f33639;
            String str2 = this.f33636;
            String str3 = "mianahwvc";
            webView.loadData(String.format(Locale.ROOT, "<html><head></head><body><div id=\"%s\" style=\"width: %dpx; height: %dpx;\"></div><script>(function initMoatTracking(apiname, pcode, ids, duration) {var events = [];window[pcode + '_moatElToTrack'] = document.getElementById('%s');var moatapi = {'dropTime':%d,'adData': {'ids': ids, 'duration': duration, 'url': 'n/a'},'dispatchEvent': function(ev) {if (this.sendEvent) {if (events) { events.push(ev); ev = events; events = false; }this.sendEvent(ev);} else {events.push(ev);}},'dispatchMany': function(evs){for (var i=0, l=evs.length; i<l; i++) {this.dispatchEvent(evs[i]);}}};Object.defineProperty(window, apiname, {'value': moatapi});var s = document.createElement('script');s.src = 'https://z.moatads.com/' + pcode + '/moatvideo.js?' + apiname + '#' + apiname;document.body.appendChild(s);})('%s', '%s', %s, %s);</script></body></html>", new Object[]{str3, num, num2, str3, Long.valueOf(System.currentTimeMillis()), str2, str, jSONObject.toString(), num3}), "text/html", null);
        }
    }

    C11011b() {
    }

    /* renamed from: ˏ */
    static void m36234(int i, String str, Object obj, String str2) {
        if (C11054t.m36390().f33796) {
            String str3 = VastExtensionXmlManager.MOAT;
            if (obj == null) {
                StringBuilder sb = new StringBuilder(str3);
                sb.append(str);
                Log.println(i, sb.toString(), String.format("message = %s", new Object[]{str2}));
                return;
            }
            StringBuilder sb2 = new StringBuilder(str3);
            sb2.append(str);
            Log.println(i, sb2.toString(), String.format("id = %s, message = %s", new Object[]{Integer.valueOf(obj.hashCode()), str2}));
        }
    }

    /* renamed from: ˏ */
    static void m36235(String str, Object obj, String str2) {
        Object obj2;
        if (C11054t.m36390().f33797) {
            StringBuilder sb = new StringBuilder(VastExtensionXmlManager.MOAT);
            sb.append(str);
            String sb2 = sb.toString();
            Object[] objArr = new Object[2];
            if (obj == null) {
                obj2 = "null";
            } else {
                obj2 = Integer.valueOf(obj.hashCode());
            }
            objArr[0] = obj2;
            objArr[1] = str2;
            Log.println(2, sb2, String.format("id = %s, message = %s", objArr));
        }
    }

    /* renamed from: ˊ */
    static void m36230(String str, Object obj, String str2, Exception exc) {
        if (C11054t.m36390().f33796) {
            StringBuilder sb = new StringBuilder(VastExtensionXmlManager.MOAT);
            sb.append(str);
            Log.e(sb.toString(), String.format("id = %s, message = %s", new Object[]{Integer.valueOf(obj.hashCode()), str2}), exc);
        }
    }

    /* renamed from: ˎ */
    static void m36232(String str, String str2) {
        if (!C11054t.m36390().f33796 && ((C11031j) MoatAnalytics.getInstance()).f33735) {
            int i = 2;
            if (str.equals("[ERROR] ")) {
                i = 6;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            Log.println(i, "MoatAnalytics", sb.toString());
        }
    }

    /* renamed from: ॱ */
    static String m36236(View view) {
        if (view == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(view.getClass().getSimpleName());
        sb.append("@");
        sb.append(view.hashCode());
        return sb.toString();
    }
}
