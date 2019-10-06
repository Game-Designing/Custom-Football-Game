package com.inmobi.rendering.p226a;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.ads.C10478c;
import com.inmobi.ads.C10478c.C10483e;
import com.inmobi.commons.core.configs.C10639a;
import com.inmobi.commons.core.configs.C10641b;
import com.inmobi.commons.core.configs.C10641b.C10644c;
import com.inmobi.commons.core.configs.C10652h;
import com.inmobi.commons.core.network.C10676c;
import com.inmobi.commons.core.network.C10677d;
import com.inmobi.commons.core.network.C10678e;
import com.inmobi.commons.core.network.NetworkError;
import com.inmobi.commons.core.network.NetworkError.ErrorCode;
import com.inmobi.commons.core.network.WebViewNetworkTask;
import com.inmobi.commons.core.network.WebViewNetworkTask.NetworkTaskWebView;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p221d.C10656b;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.p222e.C10659b;
import com.inmobi.commons.core.utilities.C10700d;
import com.inmobi.commons.core.utilities.C10703g;
import com.inmobi.commons.core.utilities.C10703g.C10706b;
import com.inmobi.commons.p217a.C10619a;
import com.inmobi.p207a.C10299n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.inmobi.rendering.a.c */
/* compiled from: ClickManager */
public class C10738c implements C10644c {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f32802a = C10738c.class.getSimpleName();

    /* renamed from: b */
    private static C10738c f32803b;

    /* renamed from: c */
    private static final Object f32804c = new Object();

    /* renamed from: d */
    private static ExecutorService f32805d;

    /* renamed from: e */
    private static C10746a f32806e;

    /* renamed from: f */
    private static HandlerThread f32807f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static List<C10736a> f32808g = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static C10737b f32809h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static AtomicBoolean f32810i = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static C10483e f32811j;

    /* renamed from: k */
    private static final Object f32812k = new Object();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public long f32813l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final C10755d f32814m = new C10755d() {
        /* renamed from: a */
        public final void mo34659a(C10736a aVar) {
            if (aVar != null) {
                C10738c.f32802a;
                StringBuilder sb = new StringBuilder("Processing click (");
                sb.append(aVar.f32792b);
                sb.append(") completed");
                C10738c.f32809h;
                C10737b.m35276a(aVar);
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("url", aVar.f32792b);
                    hashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - C10738c.this.f32813l));
                    C10659b.m34983a();
                    C10659b.m34987a("ads", "PingLatency", hashMap);
                } catch (Exception e) {
                    C10738c.f32802a;
                    StringBuilder sb2 = new StringBuilder("Error in submitting telemetry event : (");
                    sb2.append(e.getMessage());
                    sb2.append(")");
                }
            }
        }

        /* renamed from: b */
        public final void mo34660b(C10736a aVar) {
            if (aVar != null) {
                C10738c.f32802a;
                StringBuilder sb = new StringBuilder("Pinging click (");
                sb.append(aVar.f32792b);
                sb.append(") failed! Updating retry counts and timestamps ...");
                C10738c.m35284a(aVar);
                C10738c.this.mo34654b();
            }
        }
    };

    /* renamed from: com.inmobi.rendering.a.c$a */
    /* compiled from: ClickManager */
    final class C10746a extends Handler {
        public C10746a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            Message message2 = message;
            try {
                int i = message2.what;
                int i2 = 3;
                if (i != 1) {
                    String str = " for click (";
                    String str2 = "Pinging click (";
                    String str3 = "Retry attempt #";
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i == 5) {
                                    C10736a aVar = (C10736a) message2.obj;
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("pingUrl", aVar.f32792b);
                                    int i3 = message2.arg1;
                                    String str4 = "errorCode";
                                    if (i3 == 1) {
                                        hashMap.put(str4, "MaxRetryCountReached");
                                    } else if (i3 == 2) {
                                        hashMap.put(str4, "ExpiredClick");
                                    }
                                    try {
                                        C10659b.m34983a();
                                        C10659b.m34987a("ads", "PingDiscarded", hashMap);
                                    } catch (Exception e) {
                                        C10738c.f32802a;
                                        StringBuilder sb = new StringBuilder("Error in submitting telemetry event : (");
                                        sb.append(e.getMessage());
                                        sb.append(")");
                                    }
                                }
                            }
                            C10736a aVar2 = (C10736a) message2.obj;
                            C10738c.f32802a;
                            StringBuilder sb2 = new StringBuilder("Processing click (");
                            sb2.append(aVar2.f32792b);
                            sb2.append(") completed");
                            C10738c.f32809h;
                            C10737b.m35276a(aVar2);
                            C10738c.f32808g.remove(aVar2);
                            if (C10738c.f32808g.isEmpty()) {
                                C10738c.f32809h;
                                if (C10737b.m35277a()) {
                                    C10738c.f32802a;
                                    C10738c.f32810i.set(false);
                                    return;
                                }
                                Message obtain = Message.obtain();
                                obtain.what = 1;
                                sendMessage(obtain);
                                return;
                            }
                            C10736a aVar3 = (C10736a) C10738c.f32808g.get(0);
                            Message obtain2 = Message.obtain();
                            if (!aVar3.f32798h) {
                                i2 = 2;
                            }
                            obtain2.what = i2;
                            obtain2.obj = aVar3;
                            sendMessage(obtain2);
                        } else if (!C10700d.m35146a()) {
                            C10738c.f32810i.set(false);
                            C10738c.m35295i();
                        } else {
                            C10736a aVar4 = (C10736a) message2.obj;
                            if (aVar4.f32796f == 0) {
                                m35303a(aVar4, 1);
                            } else if (aVar4.mo34651a(C10738c.f32811j.f31933f)) {
                                m35303a(aVar4, 2);
                            } else {
                                int i4 = (C10738c.f32811j.f31928a - aVar4.f32796f) + 1;
                                if (i4 == 0) {
                                    C10738c.f32802a;
                                    StringBuilder sb3 = new StringBuilder(str2);
                                    sb3.append(aVar4.f32792b);
                                    sb3.append(") in WebView");
                                } else {
                                    C10738c.f32802a;
                                    StringBuilder sb4 = new StringBuilder(str3);
                                    sb4.append(i4);
                                    sb4.append(str);
                                    sb4.append(aVar4.f32792b);
                                    sb4.append(") using WebView");
                                }
                                new C10749b(new C10755d() {
                                    /* renamed from: a */
                                    public final void mo34659a(C10736a aVar) {
                                        C10746a.m35304a(C10746a.this, aVar);
                                    }

                                    /* renamed from: b */
                                    public final void mo34660b(C10736a aVar) {
                                        C10738c.f32802a;
                                        StringBuilder sb = new StringBuilder("Pinging click (");
                                        sb.append(aVar.f32792b);
                                        sb.append(") via WebView failed ...");
                                        C10738c.m35284a(aVar);
                                        C10746a.m35305b(C10746a.this, aVar);
                                    }
                                }).mo34662a(aVar4);
                            }
                        }
                    } else if (!C10700d.m35146a()) {
                        C10738c.f32810i.set(false);
                        C10738c.m35295i();
                    } else {
                        C10736a aVar5 = (C10736a) message2.obj;
                        if (aVar5.f32796f == 0) {
                            m35303a(aVar5, 1);
                        } else if (aVar5.mo34651a(C10738c.f32811j.f31933f)) {
                            m35303a(aVar5, 2);
                        } else {
                            int i5 = (C10738c.f32811j.f31928a - aVar5.f32796f) + 1;
                            String str5 = ") over HTTP";
                            if (i5 == 0) {
                                C10738c.f32802a;
                                StringBuilder sb5 = new StringBuilder(str2);
                                sb5.append(aVar5.f32792b);
                                sb5.append(str5);
                            } else {
                                C10738c.f32802a;
                                StringBuilder sb6 = new StringBuilder(str3);
                                sb6.append(i5);
                                sb6.append(str);
                                sb6.append(aVar5.f32792b);
                                sb6.append(str5);
                            }
                            new C10754c(new C10755d() {
                                /* renamed from: a */
                                public final void mo34659a(C10736a aVar) {
                                    C10746a.m35304a(C10746a.this, aVar);
                                }

                                /* renamed from: b */
                                public final void mo34660b(C10736a aVar) {
                                    C10738c.f32802a;
                                    StringBuilder sb = new StringBuilder("Pinging click (");
                                    sb.append(aVar.f32792b);
                                    sb.append(") via HTTP failed ...");
                                    C10738c.m35284a(aVar);
                                    C10746a.m35305b(C10746a.this, aVar);
                                }
                            }).mo34673a(aVar5);
                        }
                    }
                } else {
                    C10652h hVar = new C10652h();
                    String str6 = null;
                    C10641b.m34915a().mo34452a((C10639a) hVar, (C10644c) null);
                    if (!hVar.f32477g) {
                        C10738c.f32809h;
                        int i6 = C10738c.f32811j.f31932e;
                        int i7 = C10738c.f32811j.f31929b;
                        ArrayList arrayList = new ArrayList();
                        C10656b a = C10656b.m34962a();
                        if (a.mo34468a("click") != 0) {
                            if (-1 != i6) {
                                str6 = Integer.toString(i6);
                            }
                            String str7 = str6;
                            StringBuilder sb7 = new StringBuilder("ts < ");
                            sb7.append(System.currentTimeMillis() - ((long) i7));
                            C10656b bVar = a;
                            List<ContentValues> a2 = a.mo34470a("click", C10737b.f32800a, null, null, "ts", sb7.toString(), "ts ASC ", str7);
                            bVar.mo34476b();
                            for (ContentValues a3 : a2) {
                                arrayList.add(C10737b.m35274a(a3));
                            }
                        }
                        C10738c.f32808g = arrayList;
                        if (C10738c.f32808g.isEmpty()) {
                            C10738c.f32809h;
                            if (C10737b.m35277a()) {
                                C10738c.f32810i.set(false);
                                return;
                            }
                            Message obtain3 = Message.obtain();
                            obtain3.what = 1;
                            sendMessageDelayed(obtain3, (long) (C10738c.f32811j.f31929b * 1000));
                            return;
                        }
                        C10736a aVar6 = (C10736a) C10738c.f32808g.get(0);
                        Message obtain4 = Message.obtain();
                        if (!aVar6.f32798h) {
                            i2 = 2;
                        }
                        obtain4.what = i2;
                        obtain4.obj = aVar6;
                        long currentTimeMillis = System.currentTimeMillis() - aVar6.f32794d;
                        if (currentTimeMillis < ((long) (C10738c.f32811j.f31929b * 1000))) {
                            sendMessageDelayed(obtain4, ((long) (C10738c.f32811j.f31929b * 1000)) - currentTimeMillis);
                        } else {
                            sendMessage(obtain4);
                        }
                    }
                }
            } catch (Exception e2) {
                C10738c.f32802a;
                new StringBuilder("SDK encountered unexpected error in processing ping; ").append(e2.getMessage());
            }
        }

        /* renamed from: a */
        private void m35303a(C10736a aVar, int i) {
            Message obtain = Message.obtain();
            obtain.what = 5;
            obtain.obj = aVar;
            obtain.arg1 = i;
            sendMessage(obtain);
        }

        /* renamed from: a */
        static /* synthetic */ void m35304a(C10746a aVar, C10736a aVar2) {
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.obj = aVar2;
            aVar.sendMessage(obtain);
        }

        /* renamed from: b */
        static /* synthetic */ void m35305b(C10746a aVar, C10736a aVar2) {
            int indexOf = C10738c.f32808g.indexOf(aVar2);
            if (-1 != indexOf) {
                C10736a aVar3 = (C10736a) C10738c.f32808g.get(indexOf == C10738c.f32808g.size() + -1 ? 0 : indexOf + 1);
                Message obtain = Message.obtain();
                obtain.what = aVar3.f32798h ? 3 : 2;
                obtain.obj = aVar3;
                if (System.currentTimeMillis() - aVar3.f32794d < ((long) (C10738c.f32811j.f31929b * 1000))) {
                    aVar.sendMessageDelayed(obtain, (long) (C10738c.f32811j.f31929b * 1000));
                    return;
                }
                aVar.sendMessage(obtain);
            }
        }
    }

    /* renamed from: com.inmobi.rendering.a.c$b */
    /* compiled from: ClickManager */
    static final class C10749b {

        /* renamed from: a */
        C10755d f32833a;

        public C10749b(C10755d dVar) {
            this.f32833a = dVar;
        }

        /* renamed from: a */
        public final void mo34662a(final C10736a aVar) {
            aVar.f32797g.set(false);
            final Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                public final void run() {
                    C10676c cVar = new C10676c("GET", aVar.f32792b);
                    HashMap b = C10738c.m35289c(aVar);
                    if (!b.isEmpty()) {
                        cVar.mo34502a((Map<String, String>) b);
                    }
                    WebViewNetworkTask webViewNetworkTask = new WebViewNetworkTask(cVar, new WebViewClient() {

                        /* renamed from: a */
                        AtomicBoolean f32837a = new AtomicBoolean(false);

                        /* renamed from: b */
                        boolean f32838b;

                        /* renamed from: c */
                        boolean f32839c;

                        public final void onPageStarted(final WebView webView, String str, Bitmap bitmap) {
                            this.f32839c = true;
                            this.f32838b = false;
                            new Thread(new Runnable() {
                                public final void run() {
                                    try {
                                        Thread.sleep((long) (C10738c.f32811j.f31930c * 1000));
                                    } catch (InterruptedException e) {
                                    }
                                    if (!C107511.this.f32837a.get()) {
                                        C10738c.f32802a;
                                        StringBuilder sb = new StringBuilder("Pinging click (");
                                        sb.append(aVar.f32792b);
                                        sb.append(") via WebView timed out!");
                                        aVar.f32797g.set(true);
                                        handler.post(new Runnable() {
                                            public final void run() {
                                                try {
                                                    NetworkTaskWebView networkTaskWebView = (NetworkTaskWebView) webView;
                                                    if (networkTaskWebView != null && !networkTaskWebView.f32559a) {
                                                        webView.stopLoading();
                                                    }
                                                } catch (Throwable th) {
                                                    C10621a.m34854a().mo34423a(new C10658a(th));
                                                }
                                            }
                                        });
                                        C107501 r0 = C107501.this;
                                        C10749b.this.f32833a.mo34660b(aVar);
                                    }
                                }
                            }).start();
                        }

                        public final void onPageFinished(WebView webView, String str) {
                            boolean z = true;
                            this.f32837a.set(true);
                            if (this.f32838b || aVar.f32797g.get()) {
                                z = false;
                            } else {
                                C107501 r3 = C107501.this;
                                C10749b.this.f32833a.mo34659a(aVar);
                            }
                            if (!this.f32839c) {
                                String str2 = z ? "PageNotStartedWithSuccess" : "PageNotStartedWithError";
                                try {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("url", str);
                                    C10659b.m34983a();
                                    C10659b.m34987a("ads", str2, hashMap);
                                } catch (Exception e) {
                                    C10738c.f32802a;
                                    StringBuilder sb = new StringBuilder("Error in submitting telemetry event : (");
                                    sb.append(e.getMessage());
                                    sb.append(")");
                                }
                            }
                        }

                        @TargetApi(22)
                        public final void onReceivedError(WebView webView, int i, String str, String str2) {
                            this.f32838b = true;
                            C107501 r1 = C107501.this;
                            C10749b.this.f32833a.mo34660b(aVar);
                        }

                        @TargetApi(23)
                        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                            this.f32838b = true;
                            C107501 r1 = C107501.this;
                            C10749b.this.f32833a.mo34660b(aVar);
                        }

                        @TargetApi(23)
                        public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                            this.f32838b = true;
                            C107501 r1 = C107501.this;
                            C10749b.this.f32833a.mo34660b(aVar);
                        }

                        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                            if (VERSION.SDK_INT < 21 || aVar.f32799i || webResourceRequest.getUrl().toString().equals(aVar.f32792b)) {
                                return false;
                            }
                            return true;
                        }

                        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                            C10736a aVar = aVar;
                            if (aVar.f32799i || str.equals(aVar.f32792b)) {
                                return false;
                            }
                            return true;
                        }
                    });
                    try {
                        webViewNetworkTask.f32558c = new NetworkTaskWebView(C10619a.m34839b());
                        webViewNetworkTask.f32558c.setWebViewClient(webViewNetworkTask.f32557b);
                        webViewNetworkTask.f32558c.getSettings().setJavaScriptEnabled(true);
                        webViewNetworkTask.f32558c.getSettings().setCacheMode(2);
                        webViewNetworkTask.f32558c.loadUrl(webViewNetworkTask.f32556a.mo34507e(), webViewNetworkTask.f32556a.mo34506d());
                    } catch (Exception e) {
                        new StringBuilder("SDK encountered unexpected error in WebViewNetworkTask.execute() method; ").append(e.getMessage());
                    }
                }
            });
        }
    }

    /* renamed from: com.inmobi.rendering.a.c$c */
    /* compiled from: ClickManager */
    static final class C10754c {

        /* renamed from: a */
        private C10755d f32844a;

        public C10754c(C10755d dVar) {
            this.f32844a = dVar;
        }

        /* renamed from: a */
        public final void mo34673a(C10736a aVar) {
            try {
                C10676c cVar = new C10676c("GET", aVar.f32792b);
                HashMap b = C10738c.m35289c(aVar);
                if (!b.isEmpty()) {
                    cVar.mo34502a((Map<String, String>) b);
                }
                cVar.f32583u = false;
                cVar.mo34504b(aVar.f32793c);
                cVar.f32582t = aVar.f32799i;
                cVar.f32580r = C10738c.f32811j.f31930c * 1000;
                cVar.f32581s = C10738c.f32811j.f31930c * 1000;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                C10677d a = new C10678e(cVar).mo34514a();
                try {
                    C10299n.m33566a().mo33663a(cVar.mo34509g());
                    C10299n.m33566a().mo33664b(a.mo34513c());
                    C10299n.m33566a().mo33665c(SystemClock.elapsedRealtime() - elapsedRealtime);
                } catch (Exception e) {
                    C10738c.f32802a;
                    new StringBuilder("Error in setting request-response data size. ").append(e.getMessage());
                }
                if (a.mo34510a()) {
                    ErrorCode errorCode = a.f32591b.f32552a;
                    if (ErrorCode.GENERIC_HTTP_2XX == errorCode) {
                        this.f32844a.mo34659a(aVar);
                    } else if (aVar.f32799i || !(ErrorCode.HTTP_SEE_OTHER == errorCode || ErrorCode.HTTP_MOVED_TEMP == errorCode)) {
                        C10755d dVar = this.f32844a;
                        NetworkError networkError = a.f32591b;
                        dVar.mo34660b(aVar);
                    } else {
                        this.f32844a.mo34659a(aVar);
                    }
                } else {
                    this.f32844a.mo34659a(aVar);
                }
            } catch (Exception e2) {
                C10738c.f32802a;
                new StringBuilder("SDK encountered unexpected error in executing ping over HTTP; ").append(e2.getMessage());
                C10755d dVar2 = this.f32844a;
                new NetworkError(ErrorCode.UNKNOWN_ERROR, "Unknown error");
                dVar2.mo34660b(aVar);
            }
        }
    }

    /* renamed from: com.inmobi.rendering.a.c$d */
    /* compiled from: ClickManager */
    interface C10755d {
        /* renamed from: a */
        void mo34659a(C10736a aVar);

        /* renamed from: b */
        void mo34660b(C10736a aVar);
    }

    /* renamed from: a */
    static /* synthetic */ void m35284a(C10736a aVar) {
        int i = aVar.f32796f;
        if (i > 0) {
            aVar.f32796f = i - 1;
            aVar.f32794d = System.currentTimeMillis();
            C10656b a = C10656b.m34962a();
            String str = "click";
            a.mo34474b(str, C10737b.m35278b(aVar), "id = ?", new String[]{String.valueOf(aVar.f32791a)});
            a.mo34476b();
        }
    }

    /* renamed from: a */
    public static C10738c m35282a() {
        C10738c cVar = f32803b;
        if (cVar == null) {
            synchronized (f32804c) {
                cVar = f32803b;
                if (cVar == null) {
                    cVar = new C10738c();
                    f32803b = cVar;
                }
            }
        }
        return cVar;
    }

    /* renamed from: a */
    public final void mo33666a(C10639a aVar) {
        f32811j = ((C10478c) aVar).f31896h;
    }

    /* renamed from: b */
    public final void mo34654b() {
        try {
            if (C10700d.m35146a()) {
                synchronized (f32812k) {
                    if (f32810i.compareAndSet(false, true)) {
                        if (f32807f == null) {
                            HandlerThread handlerThread = new HandlerThread("pingHandlerThread");
                            f32807f = handlerThread;
                            handlerThread.start();
                        }
                        if (f32806e == null) {
                            f32806e = new C10746a(f32807f.getLooper());
                        }
                        if (C10737b.m35277a()) {
                            f32810i.set(false);
                            m35295i();
                        } else {
                            Message obtain = Message.obtain();
                            obtain.what = 1;
                            f32806e.sendMessage(obtain);
                        }
                    }
                }
            }
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in starting the ping component; ").append(e.getMessage());
        }
    }

    /* renamed from: a */
    public final void mo34653a(final String str, final Map<String, String> map) {
        new Thread() {

            /* renamed from: c */
            final /* synthetic */ boolean f32820c = true;

            public final void run() {
                try {
                    C10652h hVar = new C10652h();
                    C10641b.m34915a().mo34452a((C10639a) hVar, (C10644c) null);
                    if (!hVar.f32477g) {
                        C10736a aVar = new C10736a(str, map, this.f32820c, C10738c.f32811j.f31928a + 1);
                        C10738c.f32802a;
                        StringBuilder sb = new StringBuilder("Received click (");
                        sb.append(aVar.f32792b);
                        sb.append(") for pinging over HTTP");
                        C10738c.m35285a(C10738c.this, aVar);
                    }
                } catch (Exception e) {
                    C10738c.f32802a;
                    new StringBuilder("SDK encountered unexpected error in pinging click; ").append(e.getMessage());
                    C10621a.m34854a().mo34423a(new C10658a(e));
                }
            }
        }.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public static void m35295i() {
        try {
            f32810i.set(false);
            synchronized (f32812k) {
                if (!f32810i.get()) {
                    if (f32807f != null) {
                        f32807f.getLooper().quit();
                        f32807f.interrupt();
                        f32807f = null;
                        f32806e = null;
                    }
                    f32808g.clear();
                }
            }
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in stopping the ping component; ").append(e.getMessage());
        }
    }

    public C10738c() {
        try {
            f32805d = Executors.newFixedThreadPool(5);
            HandlerThread handlerThread = new HandlerThread("pingHandlerThread");
            f32807f = handlerThread;
            handlerThread.start();
            f32806e = new C10746a(f32807f.getLooper());
            C10478c cVar = new C10478c();
            C10641b.m34915a().mo34452a((C10639a) cVar, (C10644c) this);
            f32811j = cVar.f31896h;
            f32809h = new C10737b();
            C10703g.m35152a().mo34523a((C10706b) new C10706b() {
                /* renamed from: a */
                public final void mo34229a(boolean z) {
                    if (z) {
                        C10738c.this.mo34654b();
                    }
                }
            });
            if (VERSION.SDK_INT >= 23) {
                C10703g.m35152a().mo34524a("android.os.action.DEVICE_IDLE_MODE_CHANGED", (C10706b) new C10706b() {
                    /* renamed from: a */
                    public final void mo34229a(boolean z) {
                        if (!z) {
                            C10738c.this.mo34654b();
                        }
                    }
                });
            }
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in initializing the ping component; ").append(e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static HashMap<String, String> m35289c(C10736a aVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            int i = (f32811j.f31928a - aVar.f32796f) + 1;
            if (i > 0) {
                hashMap.put("X-im-retry-count", String.valueOf(i));
            }
        } catch (Exception e) {
        }
        return hashMap;
    }

    /* renamed from: a */
    static /* synthetic */ void m35285a(C10738c cVar, final C10736a aVar) {
        f32809h.mo34652a(aVar, f32811j.f31931d);
        if (!C10700d.m35146a()) {
            f32810i.set(false);
            m35295i();
            return;
        }
        f32805d.submit(new Runnable() {
            public final void run() {
                C10738c.this.f32813l = SystemClock.elapsedRealtime();
                if (aVar.f32798h) {
                    new C10749b(C10738c.this.f32814m).mo34662a(aVar);
                } else {
                    new C10754c(C10738c.this.f32814m).mo34673a(aVar);
                }
            }
        });
    }
}
