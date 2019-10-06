package com.fyber.inneractive.sdk.p179l;

import android.content.Context;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.p161c.C7668f;
import com.fyber.inneractive.sdk.p179l.C7927c.C7929a;
import com.fyber.inneractive.sdk.p179l.C7949g;
import com.fyber.inneractive.sdk.p180ui.IAgestureDetector;
import com.fyber.inneractive.sdk.p180ui.IAgestureDetector.Listener;
import com.fyber.inneractive.sdk.util.C8016n;
import com.fyber.inneractive.sdk.util.C8017o;
import com.fyber.inneractive.sdk.util.C8034w;
import com.fyber.inneractive.sdk.util.C8034w.C8039b;
import com.fyber.inneractive.sdk.util.IAlog;

/* renamed from: com.fyber.inneractive.sdk.l.a */
public abstract class C7922a<L extends C7949g> implements C7926b, C7929a, Listener, C8039b {

    /* renamed from: a */
    private boolean f16133a;
    /* access modifiers changed from: protected */

    /* renamed from: h */
    public C7927c f16134h;

    /* renamed from: i */
    C7947e f16135i;

    /* renamed from: j */
    C7948f f16136j;

    /* renamed from: k */
    protected C7925a f16137k;
    /* access modifiers changed from: protected */

    /* renamed from: l */
    public L f16138l;

    /* renamed from: m */
    float f16139m = 0.0f;

    /* renamed from: n */
    Rect f16140n = new Rect();

    /* renamed from: o */
    IAgestureDetector f16141o;

    /* renamed from: p */
    protected boolean f16142p;

    /* renamed from: q */
    protected boolean f16143q;

    /* renamed from: r */
    Runnable f16144r;

    /* renamed from: s */
    long f16145s;

    /* renamed from: t */
    long f16146t;

    /* renamed from: u */
    AsyncTask<Void, Void, String> f16147u;

    /* renamed from: v */
    protected String f16148v;

    /* renamed from: w */
    protected String f16149w;

    /* renamed from: x */
    protected Handler f16150x;

    /* renamed from: y */
    protected InneractiveAdRequest f16151y;

    /* renamed from: z */
    protected C7668f f16152z;

    /* renamed from: com.fyber.inneractive.sdk.l.a$a */
    public interface C7925a {
        /* renamed from: a */
        void mo24108a(InneractiveErrorCode inneractiveErrorCode);

        /* renamed from: a */
        void mo24109a(C7922a aVar);
    }

    /* renamed from: a */
    public abstract String mo24647a(String str, String str2, String str3);

    /* renamed from: a */
    public abstract boolean mo24651a(String str);

    /* renamed from: a */
    static /* synthetic */ void m17872a(C7922a aVar) {
        AsyncTask<Void, Void, String> asyncTask = aVar.f16147u;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            aVar.f16147u = null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) aVar));
        sb.append("onLoadTimeout after ");
        sb.append(aVar.f16145s);
        sb.append(" msec");
        IAlog.m18021b(sb.toString());
        InneractiveErrorCode inneractiveErrorCode = InneractiveErrorCode.LOAD_TIMEOUT;
        C7925a aVar2 = aVar.f16137k;
        if (aVar2 != null) {
            aVar2.mo24108a(inneractiveErrorCode);
        }
        aVar.mo24652b();
    }

    protected C7922a(Context context, boolean z, boolean z2) {
        this.f16143q = z;
        this.f16134h = new C7927c(context);
        this.f16133a = z2;
        this.f16150x = new Handler(context.getMainLooper());
    }

    /* renamed from: b */
    public void mo24652b() {
        AsyncTask<Void, Void, String> asyncTask = this.f16147u;
        if (asyncTask != null) {
            asyncTask.cancel(true);
        }
        if (this.f16134h != null) {
            C8034w.m18120a().mo24869a(this.f16134h);
            C8017o.m18097a((View) this.f16134h);
            this.f16134h.destroy();
        }
        Handler handler = this.f16150x;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f16138l = null;
        this.f16137k = null;
        this.f16134h = null;
        this.f16152z = null;
        this.f16151y = null;
    }

    /* renamed from: a */
    public final void mo24737a(String str, String str2, String str3, String str4, C7925a aVar, int i) {
        this.f16137k = aVar;
        this.f16145s = (long) i;
        mo24648a();
        final String str5 = str2;
        final String str6 = str3;
        final String str7 = str4;
        final String str8 = str;
        C79231 r0 = new AsyncTask<Void, Void, String>() {
            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                long currentTimeMillis = System.currentTimeMillis();
                String a = C7922a.this.mo24647a(str5, str6, str7);
                StringBuilder sb = new StringBuilder();
                sb.append(IAlog.m18018a((Object) C7922a.this));
                sb.append("build html string took ");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                sb.append(" msec");
                IAlog.m18021b(sb.toString());
                return a;
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                String str = (String) obj;
                String str2 = C8016n.m18093a() ? "http://" : "https://";
                if (!TextUtils.isEmpty(str) && !isCancelled()) {
                    C7922a.this.f16147u = null;
                    if (!C8017o.m18100a(str8)) {
                        C7922a aVar = C7922a.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(str2);
                        sb.append(str8);
                        aVar.f16148v = sb.toString();
                    } else {
                        C7922a aVar2 = C7922a.this;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append("wv.inner-active.mobi/");
                        aVar2.f16148v = sb2.toString();
                    }
                    C7922a aVar3 = C7922a.this;
                    aVar3.f16134h.loadDataWithBaseURL(aVar3.f16148v, str, "text/html", "utf-8", null);
                    C7922a.this.f16149w = str;
                }
            }
        };
        this.f16147u = r0;
        this.f16147u.execute(new Void[0]);
        StringBuilder sb = new StringBuilder("IAWebViewController: Starting load timeout with ");
        sb.append(this.f16145s);
        IAlog.m18021b(sb.toString());
        this.f16146t = System.currentTimeMillis();
        this.f16144r = new Runnable() {
            public final void run() {
                C7922a.m17872a(C7922a.this);
            }
        };
        mo24736a(this.f16144r, this.f16145s);
    }

    public void setListener(L l) {
        this.f16138l = l;
    }

    /* renamed from: i */
    public final C7927c mo24745i() {
        return this.f16134h;
    }

    /* renamed from: a */
    public final void mo24733a(ViewGroup viewGroup, LayoutParams layoutParams, boolean z) {
        C7927c cVar = this.f16134h;
        if (cVar != null) {
            if (layoutParams != null) {
                viewGroup.addView(cVar, layoutParams);
            } else {
                viewGroup.addView(cVar);
            }
            C8034w.m18120a().mo24868a(viewGroup.getContext(), (View) this.f16134h, (C8039b) this);
            mo24740c(z);
        }
    }

    /* renamed from: c */
    public final void mo24740c(boolean z) {
        if (this.f16141o == null) {
            this.f16141o = new IAgestureDetector(this.f16134h);
            IAgestureDetector iAgestureDetector = this.f16141o;
            iAgestureDetector.f16274a.setOnTouchListener(new OnTouchListener(z) {

                /* renamed from: a */
                final /* synthetic */ boolean f16279a;

                {
                    this.f16279a = r2;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    IAgestureDetector.m18009a(IAgestureDetector.this, motionEvent);
                    int action = motionEvent.getAction();
                    if (action != 0) {
                        if (action == 1) {
                            if (IAgestureDetector.this.f16277d != null) {
                                IAgestureDetector.this.f16277d.mo24743g();
                            } else {
                                IAlog.m18019a("onClickOccurs() is not registered.");
                            }
                            IAgestureDetector iAgestureDetector = IAgestureDetector.this;
                            iAgestureDetector.f16275b.removeCallbacks(iAgestureDetector.f16276c);
                            IAgestureDetector.m18011c(IAgestureDetector.this);
                        } else if (action == 3) {
                            IAgestureDetector iAgestureDetector2 = IAgestureDetector.this;
                            iAgestureDetector2.f16275b.removeCallbacks(iAgestureDetector2.f16276c);
                        }
                    } else if (this.f16279a) {
                        IAgestureDetector iAgestureDetector3 = IAgestureDetector.this;
                        iAgestureDetector3.f16275b.postDelayed(iAgestureDetector3.f16276c, 6000);
                        IAgestureDetector.m18011c(IAgestureDetector.this);
                    }
                    return false;
                }
            });
            this.f16141o.setClickListener(this);
        }
    }

    /* renamed from: e */
    public final void mo24741e(String str) {
        C7927c cVar = this.f16134h;
        if (cVar != null) {
            cVar.mo24754a(str);
        }
    }

    /* renamed from: a */
    public void mo24648a() {
        WebSettings settings = this.f16134h.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (!IAConfigManager.m16957H() && C8016n.m18093a() && VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        if (this.f16133a && VERSION.SDK_INT >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        C7927c cVar = this.f16134h;
        cVar.setHorizontalScrollBarEnabled(false);
        cVar.setHorizontalScrollbarOverlay(false);
        cVar.setVerticalScrollBarEnabled(false);
        cVar.setVerticalScrollbarOverlay(false);
        cVar.getSettings().setSupportZoom(false);
        C7927c cVar2 = this.f16134h;
        if (VERSION.SDK_INT < 18) {
            try {
                cVar2.getSettings().setPluginState(PluginState.ON);
            } catch (Exception e) {
                IAlog.m18021b("Failed to modify WebView plugin state.");
            }
        }
        this.f16134h.setFocusable(true);
        this.f16134h.setBackgroundColor(0);
        this.f16135i = new C7947e();
        this.f16134h.setWebChromeClient(this.f16135i);
        this.f16136j = new C7948f(this);
        this.f16134h.setWebViewClient(this.f16136j);
        try {
            if (VERSION.SDK_INT >= 19) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
        } catch (Exception e2) {
            IAlog.m18021b("Could not set web contents debugging flag");
        }
        this.f16134h.setListener(this);
    }

    /* renamed from: a */
    public final void mo24708a(float f, Rect rect) {
        if (f != this.f16139m || !rect.equals(this.f16140n)) {
            this.f16139m = f;
            this.f16140n.set(rect);
            C7927c cVar = this.f16134h;
            if (cVar != null) {
                cVar.mo24755a();
            }
        }
    }

    /* renamed from: a */
    public boolean mo24738a(WebView webView, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("handleUrl called with: ");
        sb.append(str);
        IAlog.m18021b(sb.toString());
        if (mo24651a(str)) {
            return true;
        }
        if (!mo24656e()) {
            StringBuilder sb2 = new StringBuilder("Web view requested navigation, without a real user click! - ");
            sb2.append(str);
            IAlog.m18021b(sb2.toString());
            mo24734a((Object) str);
            if (IAConfigManager.m17012z()) {
                return true;
            }
        }
        return mo24654c(str);
    }

    /* renamed from: c */
    public boolean mo24654c(String str) {
        L l = this.f16138l;
        if (l != null) {
            return l.mo24521a(str);
        }
        return false;
    }

    /* renamed from: e */
    public boolean mo24656e() {
        return this.f16142p;
    }

    /* renamed from: b */
    public void mo24739b(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("onWebViewVisibilityChanged called with: ");
        sb.append(z);
        IAlog.m18021b(sb.toString());
        L l = this.f16138l;
        if (l != null) {
            l.mo24441c(z);
        }
    }

    /* renamed from: f */
    public final void mo24742f(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("http://") && !C8016n.m18093a()) {
            StringBuilder sb = new StringBuilder();
            sb.append(IAlog.m18018a((Object) this));
            sb.append(" Found a portential unsecure resource url: ");
            sb.append(str);
            IAlog.m18021b(sb.toString());
        }
    }

    /* renamed from: g */
    public final void mo24743g() {
        this.f16142p = true;
    }

    /* renamed from: h */
    public final void mo24744h() {
        if (this.f16138l != null) {
            C7668f fVar = this.f16152z;
            if (fVar != null && fVar.getAdRequest() != null) {
                this.f16138l.mo24533k();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo24734a(Object obj) {
        L l = this.f16138l;
        if (l != null) {
            l.mo24469a(obj);
        }
        if (C7640a.f15157a.f15150a) {
            String str = "AD_AUTO_CLICK_DETECTED";
            Log.v("IA_CI_LOG", str);
            C7640a.f15157a.mo24033b(str);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo24735a(Runnable runnable) {
        Handler handler = this.f16150x;
        if (handler != null) {
            handler.post(runnable);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("tried to post runnable but handler is null - ");
        sb.append(runnable);
        IAlog.m18021b(sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo24736a(Runnable runnable, long j) {
        Handler handler = this.f16150x;
        if (handler != null) {
            handler.postDelayed(runnable, j);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("tried to post runnable but handler is null - ");
        sb.append(runnable);
        IAlog.m18021b(sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public final void mo24746j() {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("IAWebViewController: onWebviewLoaded - load took ");
        sb.append(System.currentTimeMillis() - this.f16146t);
        sb.append(" msec");
        IAlog.m18021b(sb.toString());
        Runnable runnable = this.f16144r;
        if (runnable != null) {
            this.f16150x.removeCallbacks(runnable);
            this.f16144r = null;
        }
        C7925a aVar = this.f16137k;
        if (aVar != null) {
            aVar.mo24109a(this);
        }
    }

    public void setAdRequest(InneractiveAdRequest inneractiveAdRequest) {
        this.f16151y = inneractiveAdRequest;
    }

    public void setAdContent(C7668f fVar) {
        this.f16152z = fVar;
    }
}
