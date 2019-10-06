package com.moat.analytics.mobile.vng;

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

/* renamed from: com.moat.analytics.mobile.vng.j */
class C11169j {

    /* renamed from: a */
    boolean f34098a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f34099b = 0;

    /* renamed from: c */
    private boolean f34100c = false;

    /* renamed from: d */
    private boolean f34101d = false;

    /* renamed from: e */
    private final WeakReference<WebView> f34102e;

    /* renamed from: f */
    private final Map<C11153b, String> f34103f;

    /* renamed from: g */
    private final LinkedList<String> f34104g;

    /* renamed from: h */
    private final AtomicBoolean f34105h = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final long f34106i;

    /* renamed from: j */
    private final C11189a f34107j;

    /* renamed from: k */
    private final List<String> f34108k;

    /* renamed from: l */
    private final C11173a f34109l;

    /* renamed from: m */
    private final BroadcastReceiver f34110m = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                C11169j.this.m36745c();
            } catch (Exception e) {
                C11176m.m36783a(e);
            }
            if (System.currentTimeMillis() - C11169j.this.f34106i > 10000) {
                C11169j.this.m36750e();
            }
        }
    };

    /* renamed from: n */
    private final BroadcastReceiver f34111n = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                C11169j.this.m36746d();
            } catch (Exception e) {
                C11176m.m36783a(e);
            }
        }
    };

    /* renamed from: com.moat.analytics.mobile.vng.j$a */
    enum C11173a {
        WEBVIEW,
        NATIVE_DISPLAY,
        NATIVE_VIDEO
    }

    C11169j(WebView webView, C11173a aVar) {
        this.f34102e = new WeakReference<>(webView);
        this.f34109l = aVar;
        this.f34107j = new C11189a();
        this.f34104g = new LinkedList<>();
        this.f34108k = new ArrayList();
        this.f34103f = new WeakHashMap();
        this.f34106i = System.currentTimeMillis();
        IntentFilter intentFilter = new IntentFilter("UPDATE_METADATA");
        IntentFilter intentFilter2 = new IntentFilter("UPDATE_VIEW_INFO");
        C0515e.m2597a(C11187s.m36827c()).mo5313a(this.f34110m, intentFilter);
        C0515e.m2597a(C11187s.m36827c()).mo5313a(this.f34111n, intentFilter2);
        try {
            C11185p.m36817a(3, "JavaScriptBridge", (Object) this, m36743b() ? "bridge installed" : "bridge not installed");
        } catch (Exception e) {
            C11176m.m36783a(e);
        }
    }

    /* renamed from: a */
    private boolean m36741a(WebView webView, String str) {
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
        C11185p.m36817a(6, str3, (Object) this, sb.toString());
        return false;
    }

    /* renamed from: b */
    private boolean m36743b() {
        if (m36758h() != null && !m36741a(m36758h(), "installBridge")) {
            return false;
        }
        this.f34098a = true;
        C11166i.m36728a().mo36348a(C11187s.m36827c(), this);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m36745c() {
        String str = "JavaScriptBridge";
        try {
            if (C11198w.m36845a().f34158a != C11206d.OFF) {
                if (!this.f34101d) {
                    C11185p.m36817a(3, str, (Object) this, "Ready for communication (setting environment variables).");
                    this.f34101d = true;
                }
                String format = String.format("javascript:(function(e,k){function l(){function f(a){var b=a.c,c=a.a,f=a.b;a=a.f;var d=[];if(c)b[c]&&d.push(b[c].fn[0]);else for(key in b)if(b[key])for(var g=0,e=b[key].fn.length;g<e;g++)d.push(b[key].fn[g]);g=0;for(e=d.length;g<e;g++){var h=d[g];if('function'===typeof h)try{f?h(f):h()}catch(k){}a&&delete b[c]}}function d(a,b,c){'function'===typeof a&&(b===kuea&&c[b]?c[b].fn.push(a):c[b]={ts:+new Date,fn:[a]})}kuea=+new Date;iymv={};briz=!1;ewat=+new Date;bnkr=[];bjmk={};dptk={};uqaj={};ryup={};yhgt={};csif={};this.g=function(a){this.namespace=a.namespace;this.version=a.version;this.appName=a.appName;this.deviceOS=a.deviceOS;this.isNative=a.isNative;this.versionHash=a.versionHash;this.aqzx=a.aqzx;this.appId=a.appId};this.nvsj=function(a){briz||(d(a,ewat,iymv),briz=!0)};this.bpsy=function(a,b){var c=b||kuea;c!==kuea&&bjmk[c]||d(a,c,bjmk)};this.qmrv=function(a,b){var c=b||kuea;c!==kuea&&uqaj[c]||d(a,c,uqaj)};this.lgpr=function(a,b){d(a,b||kuea,yhgt)};this.hgen=function(a,b){d(a,b||kuea,csif)};this.xrnk=function(a){delete yhgt[a||kuea]};this.vgft=function(a){return dptk[a||kuea]||!1};this.lkpu=function(a){return ryup[a||kuea]||!1};this.crts=function(a){var b={c:iymv,b:a,a:ewat};briz?f(b):bnkr.push(a)};this.mqjh=function(a){var b=a||kuea;dptk[b]=!0;var c={c:bjmk,f:!0};b!==kuea&&(c.b=a,c.a=a);f(c)};this.egpw=function(a){var b=a||kuea;ryup[b]=!0;var c={c:uqaj,f:!0};b!==kuea&&(c.b=a,c.a=a);f(c)};this.sglu=function(a){var b={c:yhgt,b:a.event||a,f:!1};(a.adKey||kuea)!==kuea&&(b.a=a.adKey);f(b);return 0<Object.keys(yhgt).length};this.ucbx=function(a){f({a:a.adKey||kuea,c:csif,b:a.event,f:!1})}}'undefined'===typeof e.MoatMAK&&(e.MoatMAK=new l,e.MoatMAK.g(k),e.__zMoatInit__=!0)})(window,%s);", new Object[]{m36759i()});
                if (m36757g()) {
                    m36758h().loadUrl(format);
                }
            }
        } catch (Exception e) {
            C11185p.m36818a(str, (Object) this, "Failed to initialize communication (did not set environment variables).", (Throwable) e);
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(19)
    /* renamed from: d */
    public void m36746d() {
        String sb;
        try {
            if (C11198w.m36845a().f34158a != C11206d.OFF) {
                String str = "JavaScriptBridge";
                if (this.f34102e != null) {
                    if (m36757g()) {
                        if (!this.f34100c || m36758h().getUrl() != null) {
                            if (m36758h().getUrl() != null) {
                                this.f34100c = true;
                            }
                            for (Entry key : this.f34103f.entrySet()) {
                                C11153b bVar = (C11153b) key.getKey();
                                if (bVar == null || bVar.mo36322d() == null) {
                                    C11185p.m36817a(3, str, (Object) this, "Tracker has no subject");
                                    if (bVar != null) {
                                        if (!bVar.f34045c) {
                                        }
                                    }
                                    mo36360c(bVar);
                                }
                                if (bVar.f34046d) {
                                    m36755f(String.format("javascript: MoatMAK.mqjh(\"%s\")", new Object[]{bVar.f34044b}));
                                    String format = String.format("javascript: MoatMAK.sglu(%s)", new Object[]{bVar.mo36324f()});
                                    if (VERSION.SDK_INT >= 19) {
                                        m36758h().evaluateJavascript(format, new ValueCallback<String>() {
                                            /* renamed from: a */
                                            public void onReceiveValue(String str) {
                                                String str2 = "null";
                                                String str3 = "JavaScriptBridge";
                                                if (str == null || str.equalsIgnoreCase(str2) || str.equalsIgnoreCase(AdultContentAnalytics.UNLOCK)) {
                                                    C11169j jVar = C11169j.this;
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append("Received value is:");
                                                    if (str != null) {
                                                        StringBuilder sb2 = new StringBuilder();
                                                        sb2.append("(String)");
                                                        sb2.append(str);
                                                        str2 = sb2.toString();
                                                    }
                                                    sb.append(str2);
                                                    C11185p.m36817a(3, str3, (Object) jVar, sb.toString());
                                                    if (C11169j.this.f34099b >= 50) {
                                                        C11169j.this.m36754f();
                                                    }
                                                    C11169j.this.f34099b = C11169j.this.f34099b + 1;
                                                } else if (str.equalsIgnoreCase("true")) {
                                                    if (C11169j.this.f34099b != 0) {
                                                        C11185p.m36817a(3, str3, (Object) C11169j.this, "Javascript has found ad");
                                                        C11169j.this.m36750e();
                                                    }
                                                    C11169j.this.f34099b = 0;
                                                } else {
                                                    C11169j jVar2 = C11169j.this;
                                                    StringBuilder sb3 = new StringBuilder();
                                                    sb3.append("Received unusual value from Javascript:");
                                                    sb3.append(str);
                                                    C11185p.m36817a(3, str3, (Object) jVar2, sb3.toString());
                                                }
                                            }
                                        });
                                    } else {
                                        m36758h().loadUrl(format);
                                    }
                                }
                            }
                            return;
                        }
                    }
                }
                if (this.f34102e == null) {
                    sb = "WebView ref became null, stopping tracking loop";
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("WebView became null");
                    sb2.append(m36758h() == null ? "" : "based on null url");
                    sb2.append(", stopping tracking loop");
                    sb = sb2.toString();
                }
                C11185p.m36817a(3, str, (Object) this, sb);
                m36754f();
            }
        } catch (Exception e) {
            C11176m.m36783a(e);
            m36754f();
        }
    }

    /* renamed from: d */
    private void m36747d(C11153b bVar) {
        C11185p.m36817a(3, "JavaScriptBridge", (Object) this, "Stopping view update loop");
        if (bVar != null) {
            C11166i.m36728a().mo36349a(bVar);
        }
    }

    /* renamed from: d */
    private void m36749d(String str) {
        if (this.f34108k.size() >= 50) {
            this.f34108k.subList(0, 25).clear();
        }
        this.f34108k.add(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m36750e() {
        C11185p.m36817a(3, "JavaScriptBridge", (Object) this, "Stopping metadata reporting loop");
        C11166i.m36728a().mo36350a(this);
        C0515e.m2597a(C11187s.m36827c()).mo5312a(this.f34110m);
    }

    /* renamed from: e */
    private boolean m36752e(String str) {
        if (this.f34098a) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bridge is not installed in the given WebView. Can't ");
        sb.append(str);
        C11185p.m36817a(6, "JavaScriptBridge", (Object) this, sb.toString());
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m36754f() {
        C11185p.m36817a(3, "JavaScriptBridge", (Object) this, "Cleaning up");
        m36750e();
        for (Entry key : this.f34103f.entrySet()) {
            m36747d((C11153b) key.getKey());
        }
        this.f34103f.clear();
        C0515e.m2597a(C11187s.m36827c()).mo5312a(this.f34111n);
    }

    /* renamed from: f */
    private void m36755f(String str) {
        if (m36757g()) {
            m36758h().loadUrl(str);
        }
    }

    /* renamed from: g */
    private boolean m36757g() {
        return m36758h() != null;
    }

    /* renamed from: h */
    private WebView m36758h() {
        return (WebView) this.f34102e.get();
    }

    /* renamed from: i */
    private String m36759i() {
        try {
            HashMap hashMap = new HashMap();
            String a = this.f34107j.mo36383a();
            String b = this.f34107j.mo36384b();
            String num = Integer.toString(VERSION.SDK_INT);
            String b2 = C11187s.m36826b();
            String str = this.f34109l == C11173a.WEBVIEW ? BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID : "1";
            hashMap.put("versionHash", "3f2ae9c1894282b5e0222f0d06bbf457191f816f");
            hashMap.put("appName", a);
            hashMap.put("namespace", "VNG");
            hashMap.put(MediationMetaData.KEY_VERSION, "2.2.0");
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
    public void mo36353a() {
        C11185p.m36817a(3, "JavaScriptBridge", (Object) this, "webViewReady");
        this.f34105h.compareAndSet(false, true);
        m36750e();
        for (String f : this.f34108k) {
            m36755f(f);
        }
        this.f34108k.clear();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36354a(C11153b bVar) {
        if (bVar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("adding tracker");
            sb.append(bVar.f34044b);
            C11185p.m36817a(3, "JavaScriptBridge", (Object) this, sb.toString());
            this.f34103f.put(bVar, "");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36355a(String str) {
        String format = String.format("javascript: MoatMAK.crts(%s)", new Object[]{str});
        if (this.f34105h.get()) {
            m36755f(format);
        } else {
            m36749d(format);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo36356a(String str, JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        if (!this.f34105h.get() || !m36757g()) {
            this.f34104g.add(jSONObject2);
            return;
        }
        m36755f(String.format("javascript:%s.dispatchEvent(%s);", new Object[]{str, jSONObject2}));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo36357b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("markUserInteractionEvent:");
        sb.append(str);
        C11185p.m36817a(3, "JavaScriptBridge", (Object) this, sb.toString());
        String format = String.format("javascript: MoatMAK.ucbx(%s)", new Object[]{str});
        if (this.f34105h.get()) {
            m36755f(format);
        } else {
            m36749d(format);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo36358b(C11153b bVar) {
        String str = "startTracking";
        String str2 = "JavaScriptBridge";
        try {
            if (m36757g() && m36741a(m36758h(), str)) {
                if (m36752e(str)) {
                    if (bVar.mo36322d() == null) {
                        if (!bVar.f34045c) {
                            C11185p.m36817a(3, str2, (Object) this, "Tracker subject is null, won't start tracking");
                            return false;
                        }
                        C11185p.m36817a(3, str2, (Object) this, "Tracker subject is null at start");
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Starting tracking on tracker");
                    sb.append(bVar.f34044b);
                    C11185p.m36817a(3, str2, (Object) this, sb.toString());
                    m36755f(String.format("javascript: MoatMAK.mqjh(\"%s\")", new Object[]{bVar.f34044b}));
                    C11166i.m36728a().mo36347a(C11187s.m36827c(), bVar);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            C11185p.m36818a(str2, (Object) this, "Failed to initialize impression start.", (Throwable) e);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo36359c(String str) {
        C11185p.m36817a(3, "JavaScriptBridge", (Object) this, "flushDispatchQueue");
        this.f34105h.compareAndSet(false, true);
        if (this.f34104g.size() >= 200) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < 10; i++) {
                linkedList.addFirst((String) this.f34104g.removeFirst());
            }
            int min = Math.min(Math.min(this.f34104g.size() / 200, 10) + 200, this.f34104g.size());
            for (int i2 = 0; i2 < min; i2++) {
                this.f34104g.removeFirst();
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                this.f34104g.addFirst((String) it.next());
            }
        }
        int i3 = 0;
        while (!this.f34104g.isEmpty() && i3 < 200) {
            i3++;
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            while (!this.f34104g.isEmpty() && i3 < 200) {
                i3++;
                String str2 = (String) this.f34104g.getFirst();
                if (sb.length() + str2.length() > 2000) {
                    break;
                }
                this.f34104g.removeFirst();
                if (z) {
                    z = false;
                } else {
                    sb.append(",");
                }
                sb.append(str2);
            }
            m36755f(String.format("javascript:%s.dispatchMany([%s])", new Object[]{str, sb.toString()}));
        }
        this.f34104g.clear();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo36360c(C11153b bVar) {
        String str = "JavaScriptBridge";
        boolean z = false;
        if (m36757g()) {
            String str2 = "stopTracking";
            if (m36741a(m36758h(), str2) && m36752e(str2)) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Ending tracking on tracker");
                    sb.append(bVar.f34044b);
                    C11185p.m36817a(3, str, (Object) this, sb.toString());
                    m36755f(String.format("javascript: MoatMAK.egpw(\"%s\")", new Object[]{bVar.f34044b}));
                } catch (Exception e) {
                    C11185p.m36818a(str, (Object) this, "Failed to end impression.", (Throwable) e);
                }
                z = true;
            }
        }
        if (this.f34109l == C11173a.NATIVE_DISPLAY) {
            m36747d(bVar);
        } else {
            m36754f();
        }
        this.f34103f.remove(bVar);
        return z;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            super.finalize();
            C11185p.m36817a(3, "JavaScriptBridge", (Object) this, "finalize");
            m36754f();
        } catch (Exception e) {
            C11176m.m36783a(e);
        }
    }
}
