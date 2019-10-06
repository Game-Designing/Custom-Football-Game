package com.moat.analytics.mobile.sma;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.support.p000v4.content.C0515e;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.unity3d.ads.metadata.MediationMetaData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.account.AdultContentAnalytics;

/* renamed from: com.moat.analytics.mobile.sma.j */
class C11095j {

    /* renamed from: a */
    boolean f33911a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f33912b = 0;

    /* renamed from: c */
    private boolean f33913c = false;

    /* renamed from: d */
    private boolean f33914d = false;

    /* renamed from: e */
    private final WeakReference<WebView> f33915e;

    /* renamed from: f */
    private final Map<C11079b, String> f33916f;

    /* renamed from: g */
    private final LinkedList<String> f33917g;

    /* renamed from: h */
    private final AtomicBoolean f33918h = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final long f33919i;

    /* renamed from: j */
    private final C11115a f33920j;

    /* renamed from: k */
    private final List<String> f33921k;

    /* renamed from: l */
    private final C11099a f33922l;

    /* renamed from: m */
    private final BroadcastReceiver f33923m = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                C11095j.this.m36505c();
            } catch (Exception e) {
                C11102m.m36543a(e);
            }
            if (System.currentTimeMillis() - C11095j.this.f33919i > 30000) {
                C11095j.this.m36510e();
            }
        }
    };

    /* renamed from: n */
    private final BroadcastReceiver f33924n = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                C11095j.this.m36506d();
            } catch (Exception e) {
                C11102m.m36543a(e);
            }
        }
    };

    /* renamed from: com.moat.analytics.mobile.sma.j$a */
    enum C11099a {
        WEBVIEW,
        NATIVE_DISPLAY,
        NATIVE_VIDEO
    }

    C11095j(WebView webView, C11099a aVar) {
        this.f33915e = new WeakReference<>(webView);
        this.f33922l = aVar;
        this.f33920j = new C11115a();
        this.f33917g = new LinkedList<>();
        this.f33921k = new ArrayList();
        this.f33916f = new WeakHashMap();
        this.f33919i = System.currentTimeMillis();
        IntentFilter intentFilter = new IntentFilter("UPDATE_METADATA");
        IntentFilter intentFilter2 = new IntentFilter("UPDATE_VIEW_INFO");
        C0515e.m2597a(C11113s.m36587c()).mo5313a(this.f33923m, intentFilter);
        C0515e.m2597a(C11113s.m36587c()).mo5313a(this.f33924n, intentFilter2);
        try {
            C11111p.m36577a(3, "JavaScriptBridge", (Object) this, m36503b() ? "bridge installed" : "bridge not installed");
        } catch (Exception e) {
            C11102m.m36543a(e);
        }
    }

    /* renamed from: a */
    private boolean m36501a(WebView webView, String str) {
        StringBuilder sb;
        String str2;
        String str3 = "JavaScriptBridge";
        if (webView == null) {
            sb = new StringBuilder();
            str2 = "WebView is null. Can't ";
        } else if (webView.getSettings().getJavaScriptEnabled()) {
            return true;
        } else {
            sb = new StringBuilder();
            str2 = "JavaScript is not enabled in the given WebView. Can't ";
        }
        sb.append(str2);
        sb.append(str);
        C11111p.m36577a(6, str3, (Object) this, sb.toString());
        return false;
    }

    /* renamed from: b */
    private boolean m36503b() {
        if (m36518h() != null && !m36501a(m36518h(), "installBridge")) {
            return false;
        }
        this.f33911a = true;
        C11092i.m36488a().mo36216a(C11113s.m36587c(), this);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m36505c() {
        String str = "JavaScriptBridge";
        try {
            if (C11124w.m36605a().f33971a != C11132d.OFF) {
                if (!this.f33914d) {
                    C11111p.m36577a(3, str, (Object) this, "Ready for communication (setting environment variables).");
                    this.f33914d = true;
                }
                String format = String.format("javascript:(function(f,k){function l(){function e(a){var b=a.c,c=a.a,e=a.b;a=a.f;var d=[];if(c)b[c]&&d.push(b[c].fn[0]);else for(key in b)if(b[key])for(var h=0,f=b[key].fn.length;h<f;h++)d.push(b[key].fn[h]);h=0;for(f=d.length;h<f;h++){var g=d[h];if('function'===typeof g)try{e?g(e):g()}catch(k){}a&&delete b[c]}}function d(a,b,c){'function'===typeof a&&(b===kuea&&c[b]?c[b].fn.push(a):c[b]={ts:+new Date,fn:[a]})}kuea=+new Date;iymv={};briz=!1;ewat=+new Date;bnkr=[];bjmk={};dptk={};uqaj={};ryup={};yhgt={};csif={};this.h=function(a){this.namespace=a.namespace;this.version=a.version;this.appName=a.appName;this.deviceOS=a.deviceOS;this.isNative=a.isNative;this.versionHash=a.versionHash;this.aqzx=a.aqzx;this.appId=a.appId};this.nvsj=function(a){briz||(d(a,ewat,iymv),briz=!0)};this.bpsy=function(a,b){var c=b||kuea;c!==kuea&&bjmk[c]||d(a,c,bjmk)};this.qmrv=function(a,b){var c=b||kuea;c!==kuea&&uqaj[c]||d(a,c,uqaj)};this.lgpr=function(a,b){d(a,b||kuea,yhgt)};this.hgen=function(a,b){d(a,b||kuea,csif)};this.xrnk=function(a){delete yhgt[a||kuea]};this.vgft=function(a){return dptk[a||kuea]||!1};this.lkpu=function(a){return ryup[a||kuea]||!1};this.crts=function(a){g();var b={c:iymv,b:a,a:ewat};briz?e(b):bnkr.push(a)};this.mqjh=function(a){g();var b=a||kuea;dptk[b]=!0;var c={c:bjmk,f:!0};b!==kuea&&(c.b=a,c.a=a);e(c)};this.egpw=function(a){var b=a||kuea;ryup[b]=!0;var c={c:uqaj,f:!0};b!==kuea&&(c.b=a,c.a=a);e(c)};this.sglu=function(a){g();var b={c:yhgt,b:a.event||a,f:!1};(a.adKey||kuea)!==kuea&&(b.a=a.adKey);e(b);return 0<Object.keys(yhgt).length};this.ucbx=function(a){e({a:a.adKey||kuea,c:csif,b:a.event,f:!1})}}function g(){if(0===parseInt(f.MoatMAK.isNative)&&!g.g)if(document.getElementById('moat-frame'))g.g=!0;else{var e=document.createElement('script');e.src='https://z.moatads.com/mmakh092348539847/moatframe.js';e.id='moat-frame';var d=document.getElementsByTagName('head')[0]||document.documentElement;d&&d.insertBefore(e,d.firstChild)}}'undefined'===typeof f.MoatMAK&&(f.MoatMAK=new l,f.MoatMAK.h(k),f.__zMoatInit__=!0)})(window,%s);", new Object[]{m36519i()});
                if (m36517g()) {
                    m36518h().loadUrl(format);
                }
            }
        } catch (Exception e) {
            C11111p.m36578a(str, (Object) this, "Failed to initialize communication (did not set environment variables).", (Throwable) e);
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(19)
    /* renamed from: d */
    public void m36506d() {
        String sb;
        try {
            if (C11124w.m36605a().f33971a != C11132d.OFF) {
                String str = "JavaScriptBridge";
                if (this.f33915e != null) {
                    if (m36517g()) {
                        if (!this.f33913c || m36518h().getUrl() != null) {
                            if (m36518h().getUrl() != null) {
                                this.f33913c = true;
                            }
                            for (Entry key : this.f33916f.entrySet()) {
                                C11079b bVar = (C11079b) key.getKey();
                                if (bVar == null || bVar.mo36187d() == null) {
                                    C11111p.m36577a(3, str, (Object) this, "Tracker has no subject");
                                    if (bVar != null) {
                                        if (!bVar.f33858c) {
                                        }
                                    }
                                    mo36228c(bVar);
                                }
                                if (bVar.f33859d) {
                                    m36515f(String.format("javascript: MoatMAK.mqjh(\"%s\")", new Object[]{bVar.f33857b}));
                                    String format = String.format("javascript: MoatMAK.sglu(%s)", new Object[]{bVar.mo36189f()});
                                    if (VERSION.SDK_INT >= 19) {
                                        m36518h().evaluateJavascript(format, new ValueCallback<String>() {
                                            /* renamed from: a */
                                            public void onReceiveValue(String str) {
                                                String str2 = "null";
                                                String str3 = "JavaScriptBridge";
                                                if (str == null || str.equalsIgnoreCase(str2) || str.equalsIgnoreCase(AdultContentAnalytics.UNLOCK)) {
                                                    C11095j jVar = C11095j.this;
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append("Received value is:");
                                                    if (str != null) {
                                                        StringBuilder sb2 = new StringBuilder();
                                                        sb2.append("(String)");
                                                        sb2.append(str);
                                                        str2 = sb2.toString();
                                                    }
                                                    sb.append(str2);
                                                    C11111p.m36577a(3, str3, (Object) jVar, sb.toString());
                                                    if (C11095j.this.f33912b >= 150) {
                                                        C11095j.this.m36514f();
                                                    }
                                                    C11095j.this.f33912b = C11095j.this.f33912b + 1;
                                                } else if (str.equalsIgnoreCase("true")) {
                                                    if (C11095j.this.f33912b != 0) {
                                                        C11111p.m36577a(3, str3, (Object) C11095j.this, "Javascript has found ad");
                                                        C11095j.this.m36510e();
                                                    }
                                                    C11095j.this.f33912b = 0;
                                                } else {
                                                    C11095j jVar2 = C11095j.this;
                                                    StringBuilder sb3 = new StringBuilder();
                                                    sb3.append("Received unusual value from Javascript:");
                                                    sb3.append(str);
                                                    C11111p.m36577a(3, str3, (Object) jVar2, sb3.toString());
                                                }
                                            }
                                        });
                                    } else {
                                        m36518h().loadUrl(format);
                                    }
                                }
                            }
                            return;
                        }
                    }
                }
                if (this.f33915e == null) {
                    sb = "WebView ref became null, stopping tracking loop";
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("WebView became null");
                    sb2.append(m36518h() == null ? "" : "based on null url");
                    sb2.append(", stopping tracking loop");
                    sb = sb2.toString();
                }
                C11111p.m36577a(3, str, (Object) this, sb);
                m36514f();
            }
        } catch (Exception e) {
            C11102m.m36543a(e);
            m36514f();
        }
    }

    /* renamed from: d */
    private void m36507d(C11079b bVar) {
        C11111p.m36577a(3, "JavaScriptBridge", (Object) this, "Stopping view update loop");
        if (bVar != null) {
            C11092i.m36488a().mo36217a(bVar);
        }
    }

    /* renamed from: d */
    private void m36509d(String str) {
        if (this.f33921k.size() >= 50) {
            this.f33921k.subList(0, 25).clear();
        }
        this.f33921k.add(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m36510e() {
        C11111p.m36577a(3, "JavaScriptBridge", (Object) this, "Stopping metadata reporting loop");
        C11092i.m36488a().mo36218a(this);
        C0515e.m2597a(C11113s.m36587c()).mo5312a(this.f33923m);
    }

    /* renamed from: e */
    private boolean m36512e(String str) {
        if (this.f33911a) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bridge is not installed in the given WebView. Can't ");
        sb.append(str);
        C11111p.m36577a(6, "JavaScriptBridge", (Object) this, sb.toString());
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m36514f() {
        C11111p.m36577a(3, "JavaScriptBridge", (Object) this, "Cleaning up");
        m36510e();
        for (Entry key : this.f33916f.entrySet()) {
            m36507d((C11079b) key.getKey());
        }
        this.f33916f.clear();
        C0515e.m2597a(C11113s.m36587c()).mo5312a(this.f33924n);
    }

    /* renamed from: f */
    private void m36515f(String str) {
        if (m36517g()) {
            m36518h().loadUrl(str);
        }
    }

    /* renamed from: g */
    private boolean m36517g() {
        return m36518h() != null;
    }

    /* renamed from: h */
    private WebView m36518h() {
        return (WebView) this.f33915e.get();
    }

    /* renamed from: i */
    private String m36519i() {
        try {
            HashMap hashMap = new HashMap();
            String a = this.f33920j.mo36251a();
            String b = this.f33920j.mo36252b();
            String num = Integer.toString(VERSION.SDK_INT);
            String b2 = C11113s.m36586b();
            String str = this.f33922l == C11099a.WEBVIEW ? BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID : "1";
            hashMap.put("versionHash", "953154ac4464acdcdc8f392f879c5bd5798cd286");
            hashMap.put("appName", a);
            hashMap.put("namespace", "SMA");
            hashMap.put(MediationMetaData.KEY_VERSION, "2.3.0");
            hashMap.put("deviceOS", num);
            hashMap.put("isNative", str);
            hashMap.put("appId", b);
            if (b2 != null) {
                hashMap.put("aqzx", b2);
            }
            return new JSONObject(hashMap).toString();
        } catch (Exception e) {
            return "{}";
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36221a() {
        C11111p.m36577a(3, "JavaScriptBridge", (Object) this, "webViewReady");
        this.f33918h.compareAndSet(false, true);
        m36510e();
        for (String f : this.f33921k) {
            m36515f(f);
        }
        this.f33921k.clear();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36222a(C11079b bVar) {
        if (bVar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("adding tracker");
            sb.append(bVar.f33857b);
            C11111p.m36577a(3, "JavaScriptBridge", (Object) this, sb.toString());
            this.f33916f.put(bVar, "");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36223a(String str) {
        String format = String.format("javascript: MoatMAK.crts(%s)", new Object[]{str});
        if (this.f33918h.get()) {
            m36515f(format);
        } else {
            m36509d(format);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36224a(String str, JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        if (!this.f33918h.get() || !m36517g()) {
            this.f33917g.add(jSONObject2);
            return;
        }
        m36515f(String.format("javascript:%s.dispatchEvent(%s);", new Object[]{str, jSONObject2}));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo36225b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("markUserInteractionEvent:");
        sb.append(str);
        C11111p.m36577a(3, "JavaScriptBridge", (Object) this, sb.toString());
        String format = String.format("javascript: MoatMAK.ucbx(%s)", new Object[]{str});
        if (this.f33918h.get()) {
            m36515f(format);
        } else {
            m36509d(format);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo36226b(C11079b bVar) {
        String str = "startTracking";
        String str2 = "JavaScriptBridge";
        try {
            if (m36517g() && m36501a(m36518h(), str)) {
                if (m36512e(str)) {
                    if (bVar.mo36187d() == null) {
                        if (!bVar.f33858c) {
                            C11111p.m36577a(3, str2, (Object) this, "Tracker subject is null, won't start tracking");
                            return false;
                        }
                        C11111p.m36577a(3, str2, (Object) this, "Tracker subject is null at start");
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Starting tracking on tracker");
                    sb.append(bVar.f33857b);
                    C11111p.m36577a(3, str2, (Object) this, sb.toString());
                    m36515f(String.format("javascript: MoatMAK.mqjh(\"%s\")", new Object[]{bVar.f33857b}));
                    C11092i.m36488a().mo36215a(C11113s.m36587c(), bVar);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            C11111p.m36578a(str2, (Object) this, "Failed to initialize impression start.", (Throwable) e);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo36227c(String str) {
        C11111p.m36577a(3, "JavaScriptBridge", (Object) this, "flushDispatchQueue");
        this.f33918h.compareAndSet(false, true);
        if (this.f33917g.size() >= 200) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < 10; i++) {
                linkedList.addFirst((String) this.f33917g.removeFirst());
            }
            int min = Math.min(Math.min(this.f33917g.size() / 200, 10) + 200, this.f33917g.size());
            for (int i2 = 0; i2 < min; i2++) {
                this.f33917g.removeFirst();
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                this.f33917g.addFirst((String) it.next());
            }
        }
        int i3 = 0;
        while (!this.f33917g.isEmpty() && i3 < 200) {
            i3++;
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            while (!this.f33917g.isEmpty() && i3 < 200) {
                i3++;
                String str2 = (String) this.f33917g.getFirst();
                if (sb.length() + str2.length() > 2000) {
                    break;
                }
                this.f33917g.removeFirst();
                if (z) {
                    z = false;
                } else {
                    sb.append(",");
                }
                sb.append(str2);
            }
            m36515f(String.format("javascript:%s.dispatchMany([%s])", new Object[]{str, sb.toString()}));
        }
        this.f33917g.clear();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo36228c(C11079b bVar) {
        String str = "JavaScriptBridge";
        boolean z = false;
        if (m36517g()) {
            String str2 = "stopTracking";
            if (m36501a(m36518h(), str2) && m36512e(str2)) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Ending tracking on tracker");
                    sb.append(bVar.f33857b);
                    C11111p.m36577a(3, str, (Object) this, sb.toString());
                    m36515f(String.format("javascript: MoatMAK.egpw(\"%s\")", new Object[]{bVar.f33857b}));
                } catch (Exception e) {
                    C11111p.m36578a(str, (Object) this, "Failed to end impression.", (Throwable) e);
                }
                z = true;
            }
        }
        if (this.f33922l == C11099a.NATIVE_DISPLAY) {
            m36507d(bVar);
        } else {
            m36514f();
        }
        this.f33916f.remove(bVar);
        return z;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            super.finalize();
            C11111p.m36577a(3, "JavaScriptBridge", (Object) this, "finalize");
            m36514f();
        } catch (Exception e) {
            C11102m.m36543a(e);
        }
    }
}
