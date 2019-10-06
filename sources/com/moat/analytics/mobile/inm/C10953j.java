package com.moat.analytics.mobile.inm;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
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

/* renamed from: com.moat.analytics.mobile.inm.j */
class C10953j {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f33483a = 0;

    /* renamed from: b */
    private boolean f33484b = false;

    /* renamed from: c */
    private boolean f33485c = false;

    /* renamed from: d */
    private final AtomicBoolean f33486d = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f33487e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f33488f = false;

    /* renamed from: g */
    private boolean f33489g = false;

    /* renamed from: h */
    private final WeakReference<WebView> f33490h;

    /* renamed from: i */
    private final Map<C10935b, String> f33491i;

    /* renamed from: j */
    private final LinkedList<String> f33492j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final long f33493k;

    /* renamed from: l */
    private final String f33494l;

    /* renamed from: m */
    private final List<String> f33495m;

    /* renamed from: n */
    private final C10957a f33496n;

    /* renamed from: o */
    private final BroadcastReceiver f33497o = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                C10953j.this.m36034d();
            } catch (Exception e) {
                C10960m.m36077a(e);
            }
            if (System.currentTimeMillis() - C10953j.this.f33493k > 30000) {
                C10953j.this.m36049i();
            }
        }
    };

    /* renamed from: p */
    private final BroadcastReceiver f33498p = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                C10953j.this.m36038e();
            } catch (Exception e) {
                C10960m.m36077a(e);
            }
        }
    };

    /* renamed from: com.moat.analytics.mobile.inm.j$a */
    enum C10957a {
        WEBVIEW,
        NATIVE_DISPLAY,
        NATIVE_VIDEO
    }

    C10953j(WebView webView, C10957a aVar) {
        this.f33490h = new WeakReference<>(webView);
        this.f33496n = aVar;
        this.f33492j = new LinkedList<>();
        this.f33495m = new ArrayList();
        this.f33491i = new WeakHashMap();
        this.f33493k = System.currentTimeMillis();
        this.f33494l = String.format("javascript:(function(d,k){function l(){function d(a,b){var c=ipkn[b]||ipkn[kuea];if(c){var h=function(b){var c=b.b;c.ts=b.i;c.ticks=b.g;c.buffered=!0;a(c)};h(c.first);c.a.forEach(function(a){h(a)})}}function e(a){var b=a.a,c=a.c,h=a.b;a=a.f;var d=[];if(c)b[c]&&d.push(b[c].fn[0]);else for(key in b)if(b[key])for(var g=0,e=b[key].fn.length;g<e;g++)d.push(b[key].fn[g]);g=0;for(e=d.length;g<e;g++){var f=d[g];if('function'===typeof f)try{h?f(h):f()}catch(k){}a&&delete b[c]}}function f(a,b,c){'function'===typeof a&& (b===kuea&&c[b]?c[b].fn.push(a):c[b]={ts:+new Date,fn:[a]},c===yhgt&&d(a,b))}kuea=+new Date;iymv={};briz=!1;ewat=+new Date;bnkr=[];bjmk={};dptk={};uqaj={};ryup={};yhgt={};ipkn={};csif={};this.h=function(a){this.namespace=a.namespace;this.version=a.version;this.appName=a.appName;this.deviceOS=a.deviceOS;this.isNative=a.isNative;this.versionHash=a.versionHash;this.aqzx=a.aqzx;this.appId=a.appId;this.metadata=a};this.nvsj=function(a){briz||(f(a,ewat,iymv),briz=!0)};this.bpsy=function(a,b){var c=b||kuea; c!==kuea&&bjmk[c]||f(a,c,bjmk)};this.qmrv=function(a,b){var c=b||kuea;c!==kuea&&uqaj[c]||f(a,c,uqaj)};this.lgpr=function(a,b){f(a,b||kuea,yhgt)};this.hgen=function(a,b){f(a,b||kuea,csif)};this.xrnk=function(a){delete yhgt[a||kuea]};this.vgft=function(a){return dptk[a||kuea]||!1};this.lkpu=function(a){return ryup[a||kuea]||!1};this.crts=function(a){var b={a:iymv,b:a,c:ewat};briz?e(b):bnkr.push(a)};this.mqjh=function(a){var b=a||kuea;dptk[b]=!0;var c={a:bjmk,f:!0};b!==kuea&&(c.b=a,c.c=a);e(c)};this.egpw= function(a){var b=a||kuea;ryup[b]=!0;var c={a:uqaj,f:!0};b!==kuea&&(c.b=a,c.c=a);e(c)};this.sglu=function(a){var b=a.adKey||kuea,c={a:yhgt,b:a.event||a,g:1,i:+new Date,f:!1};b!==kuea&&(c.c=a.adKey);a=0<Object.keys(yhgt).length;if(!a||!this.isNative)if(ipkn[b]){var d=ipkn[b].a.slice(-1)[0]||ipkn[b].first;JSON.stringify(c.b)==JSON.stringify(d.b)?d.g+=1:(5<=ipkn[b].a.length&&ipkn[b].a.shift(),ipkn[b].a.push(c))}else ipkn[b]={first:c,a:[]};a&&e(c);return a};this.ucbx=function(a){e({c:a.adKey||kuea,a:csif, b:a.event,f:!1})}}'undefined'===typeof d.MoatMAK&&(d.MoatMAK=new l,d.MoatMAK.h(k),d.__zMoatInit__=!0)})(window,%s);", new Object[]{m36047h()});
        if (m36037d("Initialize")) {
            IntentFilter intentFilter = new IntentFilter("UPDATE_METADATA");
            IntentFilter intentFilter2 = new IntentFilter("UPDATE_VIEW_INFO");
            C0515e.m2597a(C10972s.m36126c()).mo5313a(this.f33497o, intentFilter);
            C0515e.m2597a(C10972s.m36126c()).mo5313a(this.f33498p, intentFilter2);
            m36034d();
            C10950i.m36015a().mo35933a(C10972s.m36126c(), this);
            C10969p.m36113a(3, "JavaScriptBridge", (Object) this, "bridge initialization succeeded");
        }
    }

    /* renamed from: a */
    private boolean m36028a(WebView webView) {
        return webView.getSettings().getJavaScriptEnabled();
    }

    /* renamed from: c */
    private void m36032c() {
        for (Entry key : this.f33491i.entrySet()) {
            C10935b bVar = (C10935b) key.getKey();
            if (bVar.mo35895e()) {
                m36046g(String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.mqjh(\"%s\");}", new Object[]{bVar.f33425e}));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m36034d() {
        String str = "JavaScriptBridge";
        try {
            if (C10984w.m36151a().f33561a != C10992d.OFF) {
                if (!this.f33485c) {
                    C10969p.m36113a(3, str, (Object) this, "Attempting to establish communication (setting environment variables).");
                    this.f33485c = true;
                }
                m36046g(this.f33494l);
            }
        } catch (Exception e) {
            C10969p.m36115a(str, (Object) this, "Attempt failed to establish communication (did not set environment variables).", (Throwable) e);
        }
    }

    /* renamed from: d */
    private void m36035d(C10935b bVar) {
        C10969p.m36113a(3, "JavaScriptBridge", (Object) this, "Stopping view update loop");
        if (bVar != null) {
            C10950i.m36015a().mo35934a(bVar);
        }
    }

    /* renamed from: d */
    private boolean m36037d(String str) {
        WebView g = m36044g();
        String str2 = "JavaScriptBridge";
        if (g == null) {
            StringBuilder sb = new StringBuilder("WebView is null. Can't ");
            sb.append(str);
            C10969p.m36113a(6, str2, (Object) this, sb.toString());
            throw new C10960m("WebView is null");
        } else if (m36028a(g)) {
            return true;
        } else {
            StringBuilder sb2 = new StringBuilder("JavaScript is not enabled in the given WebView. Can't ");
            sb2.append(str);
            C10969p.m36113a(6, str2, (Object) this, sb2.toString());
            throw new C10960m("JavaScript is not enabled in the WebView");
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(19)
    /* renamed from: e */
    public void m36038e() {
        try {
            if (C10984w.m36151a().f33561a != C10992d.OFF) {
                String str = "JavaScriptBridge";
                if (this.f33489g) {
                    C10969p.m36113a(3, str, (Object) this, "Can't send info, already cleaned up");
                    return;
                }
                if (m36043f()) {
                    if (!this.f33484b || m36044g().getUrl() != null) {
                        if (m36044g().getUrl() != null) {
                            this.f33484b = true;
                        }
                        for (Entry key : this.f33491i.entrySet()) {
                            C10935b bVar = (C10935b) key.getKey();
                            if (bVar == null || bVar.mo35896f() == null) {
                                C10969p.m36113a(3, str, (Object) this, "Tracker has no subject");
                                if (bVar != null) {
                                    if (!bVar.f33426f) {
                                    }
                                }
                                mo35945c(bVar);
                            }
                            if (bVar.mo35895e()) {
                                if (!this.f33486d.get()) {
                                    m36046g(String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.mqjh(\"%s\");}", new Object[]{bVar.f33425e}));
                                }
                                String format = String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.sglu(%s);}", new Object[]{bVar.mo35898h()});
                                if (VERSION.SDK_INT >= 19) {
                                    m36044g().evaluateJavascript(format, new ValueCallback<String>() {
                                        /* renamed from: a */
                                        public void onReceiveValue(String str) {
                                            String str2 = AdultContentAnalytics.UNLOCK;
                                            String str3 = "null";
                                            String str4 = "JavaScriptBridge";
                                            if (str == null || str.equalsIgnoreCase(str3) || str.equalsIgnoreCase(str2)) {
                                                C10953j jVar = C10953j.this;
                                                StringBuilder sb = new StringBuilder("Received value is:");
                                                if (str != null) {
                                                    StringBuilder sb2 = new StringBuilder("(String)");
                                                    sb2.append(str);
                                                    str3 = sb2.toString();
                                                }
                                                sb.append(str3);
                                                C10969p.m36113a(3, str4, (Object) jVar, sb.toString());
                                                if (C10953j.this.f33483a >= 150) {
                                                    C10969p.m36113a(3, str4, (Object) C10953j.this, "Giving up on finding ad");
                                                    C10953j.this.mo35942b();
                                                }
                                                C10953j.this.f33483a = C10953j.this.f33483a + 1;
                                                if (str != null && str.equalsIgnoreCase(str2) && !C10953j.this.f33487e) {
                                                    C10953j.this.f33487e = true;
                                                    C10969p.m36113a(3, str4, (Object) C10953j.this, "Bridge connection established");
                                                }
                                            } else if (str.equalsIgnoreCase("true")) {
                                                if (!C10953j.this.f33488f) {
                                                    C10953j.this.f33488f = true;
                                                    C10969p.m36113a(3, str4, (Object) C10953j.this, "Javascript has found ad");
                                                    C10953j.this.mo35938a();
                                                }
                                                C10953j.this.f33483a = 0;
                                            } else {
                                                C10953j jVar2 = C10953j.this;
                                                StringBuilder sb3 = new StringBuilder("Received unusual value from Javascript:");
                                                sb3.append(str);
                                                C10969p.m36113a(3, str4, (Object) jVar2, sb3.toString());
                                            }
                                        }
                                    });
                                } else {
                                    m36044g().loadUrl(format);
                                }
                            }
                        }
                        return;
                    }
                }
                StringBuilder sb = new StringBuilder("WebView became null");
                sb.append(m36044g() == null ? "" : "based on null url");
                sb.append(", stopping tracking loop");
                C10969p.m36113a(3, str, (Object) this, sb.toString());
                mo35942b();
            }
        } catch (Exception e) {
            C10960m.m36077a(e);
            mo35942b();
        }
    }

    /* renamed from: e */
    private void m36040e(String str) {
        if (this.f33495m.size() >= 50) {
            this.f33495m.subList(0, 25).clear();
        }
        this.f33495m.add(str);
    }

    /* renamed from: f */
    private void m36042f(String str) {
        if (this.f33486d.get()) {
            m36046g(str);
        } else {
            m36040e(str);
        }
    }

    /* renamed from: f */
    private boolean m36043f() {
        return m36044g() != null;
    }

    /* renamed from: g */
    private WebView m36044g() {
        return (WebView) this.f33490h.get();
    }

    /* renamed from: g */
    private void m36046g(String str) {
        String str2 = "JavaScriptBridge";
        if (this.f33489g) {
            C10969p.m36113a(3, str2, (Object) this, "Can't send, already cleaned up");
            return;
        }
        if (m36043f()) {
            C10969p.m36117b(2, str2, this, str);
            if (VERSION.SDK_INT >= 19) {
                m36044g().evaluateJavascript(str, null);
                return;
            }
            m36044g().loadUrl(str);
        }
    }

    /* renamed from: h */
    private String m36047h() {
        try {
            C10974a d = C10972s.m36127d();
            C10975b e = C10972s.m36128e();
            HashMap hashMap = new HashMap();
            String a = d.mo35972a();
            String b = d.mo35973b();
            String c = d.mo35974c();
            String num = Integer.toString(VERSION.SDK_INT);
            String b2 = C10972s.m36124b();
            C10957a aVar = this.f33496n;
            C10957a aVar2 = C10957a.WEBVIEW;
            String str = BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;
            String str2 = "1";
            String str3 = aVar == aVar2 ? str : str2;
            String str4 = e.f33554e ? str2 : str;
            String str5 = e.f33553d ? str2 : str;
            if (!((C10958k) MoatAnalytics.getInstance()).mo35953b()) {
                str = str2;
            }
            hashMap.put("versionHash", "c334ae83accfebb8da23104450c896463c9cfab7");
            hashMap.put("appName", a);
            hashMap.put("namespace", "INM");
            hashMap.put(MediationMetaData.KEY_VERSION, "2.5.0");
            hashMap.put("deviceOS", num);
            hashMap.put("isNative", str3);
            hashMap.put("appId", b);
            hashMap.put("source", c);
            hashMap.put("carrier", e.f33551b);
            hashMap.put("sim", e.f33550a);
            hashMap.put("phone", String.valueOf(e.f33552c));
            hashMap.put("buildFp", Build.FINGERPRINT);
            hashMap.put("buildModel", Build.MODEL);
            hashMap.put("buildMfg", Build.MANUFACTURER);
            hashMap.put("buildBrand", Build.BRAND);
            hashMap.put("buildProduct", Build.PRODUCT);
            hashMap.put("buildTags", Build.TAGS);
            hashMap.put("f1", str5);
            hashMap.put("f2", str4);
            hashMap.put("locationEnabled", str);
            if (b2 != null) {
                hashMap.put("aqzx", b2);
            }
            return new JSONObject(hashMap).toString();
        } catch (Exception e2) {
            return "{}";
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m36049i() {
        C10969p.m36113a(3, "JavaScriptBridge", (Object) this, "Stopping metadata reporting loop");
        C10950i.m36015a().mo35935a(this);
        C0515e.m2597a(C10972s.m36126c()).mo5312a(this.f33497o);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35938a() {
        String str = "JavaScriptBridge";
        C10969p.m36113a(3, str, (Object) this, "webViewReady");
        if (this.f33486d.compareAndSet(false, true)) {
            C10969p.m36113a(3, str, (Object) this, "webViewReady first time");
            m36049i();
            for (String g : this.f33495m) {
                m36046g(g);
            }
            this.f33495m.clear();
        }
        m36032c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35939a(C10935b bVar) {
        if (bVar != null) {
            StringBuilder sb = new StringBuilder("adding tracker");
            sb.append(bVar.f33425e);
            C10969p.m36113a(3, "JavaScriptBridge", (Object) this, sb.toString());
            this.f33491i.put(bVar, "");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35940a(String str) {
        m36042f(String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.crts(%s);}", new Object[]{str}));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35941a(String str, JSONObject jSONObject) {
        if (this.f33489g) {
            C10969p.m36113a(3, "JavaScriptBridge", (Object) this, "Can't dispatch, already cleaned up");
            return;
        }
        String jSONObject2 = jSONObject.toString();
        if (!this.f33486d.get() || !m36043f()) {
            this.f33492j.add(jSONObject2);
            return;
        }
        m36046g(String.format("javascript:%s.dispatchEvent(%s);", new Object[]{str, jSONObject2}));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo35942b() {
        C10969p.m36113a(3, "JavaScriptBridge", (Object) this, "Cleaning up");
        this.f33489g = true;
        m36049i();
        for (Entry key : this.f33491i.entrySet()) {
            m36035d((C10935b) key.getKey());
        }
        this.f33491i.clear();
        C0515e.m2597a(C10972s.m36126c()).mo5312a(this.f33498p);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo35943b(C10935b bVar) {
        if (m36037d("startTracking")) {
            StringBuilder sb = new StringBuilder("Starting tracking on tracker");
            sb.append(bVar.f33425e);
            C10969p.m36113a(3, "JavaScriptBridge", (Object) this, sb.toString());
            m36046g(String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.mqjh(\"%s\");}", new Object[]{bVar.f33425e}));
            C10950i.m36015a().mo35932a(C10972s.m36126c(), bVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo35944b(String str) {
        StringBuilder sb = new StringBuilder("markUserInteractionEvent:");
        sb.append(str);
        C10969p.m36113a(3, "JavaScriptBridge", (Object) this, sb.toString());
        m36042f(String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.ucbx(%s);}", new Object[]{str}));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo35945c(C10935b bVar) {
        String str = "JavaScriptBridge";
        Throwable th = null;
        if (!this.f33489g) {
            try {
                if (m36037d("stopTracking")) {
                    try {
                        StringBuilder sb = new StringBuilder("Ending tracking on tracker");
                        sb.append(bVar.f33425e);
                        C10969p.m36113a(3, str, (Object) this, sb.toString());
                        m36046g(String.format("javascript: if(typeof MoatMAK !== 'undefined'){MoatMAK.egpw(\"%s\");}", new Object[]{bVar.f33425e}));
                    } catch (Exception e) {
                        C10969p.m36115a(str, (Object) this, "Failed to end impression.", (Throwable) e);
                    }
                }
            } catch (C10960m e2) {
                th = e2;
            }
            if (this.f33496n == C10957a.NATIVE_DISPLAY) {
                m36035d(bVar);
            } else {
                mo35942b();
            }
            this.f33491i.remove(bVar);
        }
        if (th != null) {
            throw th;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo35946c(String str) {
        C10969p.m36113a(3, "JavaScriptBridge", (Object) this, "flushDispatchQueue");
        if (this.f33492j.size() >= 200) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < 10; i++) {
                linkedList.addFirst((String) this.f33492j.removeFirst());
            }
            int min = Math.min(Math.min(this.f33492j.size() / 200, 10) + 200, this.f33492j.size());
            for (int i2 = 0; i2 < min; i2++) {
                this.f33492j.removeFirst();
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                this.f33492j.addFirst((String) it.next());
            }
        }
        if (!this.f33492j.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            String str2 = "";
            int i3 = 1;
            while (!this.f33492j.isEmpty() && i3 < 200) {
                i3++;
                String str3 = (String) this.f33492j.removeFirst();
                if (sb.length() + str3.length() > 2000) {
                    break;
                }
                sb.append(str2);
                sb.append(str3);
                str2 = ",";
            }
            m36046g(String.format("javascript:%s.dispatchMany([%s])", new Object[]{str, sb.toString()}));
        }
        this.f33492j.clear();
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            super.finalize();
            C10969p.m36113a(3, "JavaScriptBridge", (Object) this, "finalize");
            mo35942b();
        } catch (Exception e) {
            C10960m.m36077a(e);
        }
    }
}
