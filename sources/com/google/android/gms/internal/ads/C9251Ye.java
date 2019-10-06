package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzwl.zza.zzb;
import com.google.android.gms.internal.ads.zzwt.zzv;
import com.mopub.mobileads.VastIconXmlManager;
import com.unity3d.ads.metadata.MediationMetaData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.install.installer.RootCommandOnSubscribe;

@VisibleForTesting
@zzard
/* renamed from: com.google.android.gms.internal.ads.Ye */
final class C9251Ye extends WebView implements OnGlobalLayoutListener, DownloadListener, zzbgz {

    /* renamed from: A */
    private zzadx f21943A;

    /* renamed from: B */
    private zzadv f21944B;

    /* renamed from: C */
    private int f21945C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public int f21946D;

    /* renamed from: E */
    private zzadg f21947E;

    /* renamed from: F */
    private zzadg f21948F;

    /* renamed from: G */
    private zzadg f21949G;

    /* renamed from: H */
    private zzadh f21950H;

    /* renamed from: I */
    private WeakReference<OnClickListener> f21951I;

    /* renamed from: J */
    private zzd f21952J;

    /* renamed from: K */
    private boolean f21953K;

    /* renamed from: L */
    private zzazs f21954L;

    /* renamed from: M */
    private int f21955M = -1;

    /* renamed from: N */
    private int f21956N = -1;

    /* renamed from: O */
    private int f21957O = -1;

    /* renamed from: P */
    private int f21958P = -1;

    /* renamed from: Q */
    private Map<String, zzbft> f21959Q;

    /* renamed from: R */
    private final WindowManager f21960R;

    /* renamed from: S */
    private final zzwj f21961S;

    /* renamed from: a */
    private final zzbim f21962a;

    /* renamed from: b */
    private final zzdh f21963b;

    /* renamed from: c */
    private final zzbai f21964c;

    /* renamed from: d */
    private final zzj f21965d;

    /* renamed from: e */
    private final zza f21966e;

    /* renamed from: f */
    private final DisplayMetrics f21967f;

    /* renamed from: g */
    private final float f21968g;

    /* renamed from: h */
    private boolean f21969h = false;

    /* renamed from: i */
    private boolean f21970i = false;

    /* renamed from: j */
    private zzbha f21971j;

    /* renamed from: k */
    private zzd f21972k;

    /* renamed from: l */
    private IObjectWrapper f21973l;

    /* renamed from: m */
    private zzbin f21974m;

    /* renamed from: n */
    private String f21975n;

    /* renamed from: o */
    private boolean f21976o;

    /* renamed from: p */
    private boolean f21977p;

    /* renamed from: q */
    private boolean f21978q;

    /* renamed from: r */
    private boolean f21979r;

    /* renamed from: s */
    private Boolean f21980s;

    /* renamed from: t */
    private int f21981t;

    /* renamed from: u */
    private boolean f21982u = true;

    /* renamed from: v */
    private boolean f21983v = false;

    /* renamed from: w */
    private String f21984w = "";

    /* renamed from: x */
    private zzbhq f21985x;

    /* renamed from: y */
    private boolean f21986y;

    /* renamed from: z */
    private boolean f21987z;

    /* renamed from: a */
    static C9251Ye m23250a(Context context, zzbin zzbin, String str, boolean z, boolean z2, zzdh zzdh, zzbai zzbai, zzadi zzadi, zzj zzj, zza zza, zzwj zzwj) {
        Context context2 = context;
        C9251Ye ye = new C9251Ye(new zzbim(context), zzbin, str, z, z2, zzdh, zzbai, zzadi, zzj, zza, zzwj);
        return ye;
    }

    @VisibleForTesting
    private C9251Ye(zzbim zzbim, zzbin zzbin, String str, boolean z, boolean z2, zzdh zzdh, zzbai zzbai, zzadi zzadi, zzj zzj, zza zza, zzwj zzwj) {
        super(zzbim);
        this.f21962a = zzbim;
        this.f21974m = zzbin;
        this.f21975n = str;
        this.f21978q = z;
        this.f21981t = -1;
        this.f21963b = zzdh;
        this.f21964c = zzbai;
        this.f21965d = zzj;
        this.f21966e = zza;
        this.f21960R = (WindowManager) getContext().getSystemService("window");
        zzk.zzlg();
        this.f21967f = zzaxi.m26100a(this.f21960R);
        this.f21968g = this.f21967f.density;
        this.f21961S = zzwj;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            zzbad.m26356b("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        zzk.zzlg().mo30231a((Context) zzbim, zzbai.f25057a, settings);
        zzk.zzli().mo30254a(getContext(), settings);
        setDownloadListener(this);
        m23241M();
        if (PlatformVersion.m22110d()) {
            addJavascriptInterface(zzbht.m26964a((zzbgz) this), "googleAdsJsInterface");
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.f21954L = new zzazs(this.f21962a.mo30645b(), this, this, null);
        m23245Q();
        this.f21950H = new zzadh(new zzadi(true, "make_wv", this.f21975n));
        this.f21950H.mo29614a().mo29619a(zzadi);
        this.f21948F = zzadb.m24798a(this.f21950H.mo29614a());
        this.f21950H.mo29615a("native:view_create", this.f21948F);
        this.f21949G = null;
        this.f21947E = null;
        zzk.zzli().mo30258b((Context) zzbim);
        zzk.zzlk().mo30174f();
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzbha) {
            this.f21971j = (zzbha) webViewClient;
        }
    }

    public final WebView getWebView() {
        return this;
    }

    public final View getView() {
        return this;
    }

    /* renamed from: o */
    public final zza mo28768o() {
        return this.f21966e;
    }

    /* renamed from: J */
    private final boolean m23238J() {
        int i;
        int i2;
        boolean z = false;
        if (!this.f21971j.mo30608b() && !this.f21971j.mo30617j()) {
            return false;
        }
        zzyt.m31532a();
        DisplayMetrics displayMetrics = this.f21967f;
        int b = zzazt.m26312b(displayMetrics, displayMetrics.widthPixels);
        zzyt.m31532a();
        DisplayMetrics displayMetrics2 = this.f21967f;
        int b2 = zzazt.m26312b(displayMetrics2, displayMetrics2.heightPixels);
        Activity b3 = this.f21962a.mo30645b();
        if (b3 == null || b3.getWindow() == null) {
            i2 = b;
            i = b2;
        } else {
            zzk.zzlg();
            int[] a = zzaxi.m26119a(b3);
            zzyt.m31532a();
            int b4 = zzazt.m26312b(this.f21967f, a[0]);
            zzyt.m31532a();
            i = zzazt.m26312b(this.f21967f, a[1]);
            i2 = b4;
        }
        if (this.f21956N == b && this.f21955M == b2 && this.f21957O == i2 && this.f21958P == i) {
            return false;
        }
        if (!(this.f21956N == b && this.f21955M == b2)) {
            z = true;
        }
        this.f21956N = b;
        this.f21955M = b2;
        this.f21957O = i2;
        this.f21958P = i;
        new zzaqb(this).mo29990a(b, b2, i2, i, this.f21967f.density, this.f21960R.getDefaultDisplay().getRotation());
        return z;
    }

    /* renamed from: a */
    public final void mo28729a(String str, Map<String, ?> map) {
        try {
            mo28730a(str, zzk.zzlg().mo30230a(map));
        } catch (JSONException e) {
            zzbad.m26359d("Could not convert parameters to JSON.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        return;
     */
    @android.annotation.TargetApi(19)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void evaluateJavascript(java.lang.String r2, android.webkit.ValueCallback<java.lang.String> r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.isDestroyed()     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0014
            java.lang.String r2 = "#004 The webview is destroyed. Ignoring action."
            com.google.android.gms.internal.ads.zzbad.m26361e(r2)     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0012
            r2 = 0
            r3.onReceiveValue(r2)     // Catch:{ all -> 0x0019 }
        L_0x0012:
            monitor-exit(r1)
            return
        L_0x0014:
            super.evaluateJavascript(r2, r3)     // Catch:{ all -> 0x0019 }
            monitor-exit(r1)
            return
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9251Ye.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    /* renamed from: c */
    private final synchronized void m23255c(String str) {
        if (!isDestroyed()) {
            loadUrl(str);
        } else {
            zzbad.m26359d("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void loadUrl(String str) {
        if (!isDestroyed()) {
            try {
                super.loadUrl(str);
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e) {
                zzk.zzlk().mo30168a(e, "AdWebViewImpl.loadUrl");
                zzbad.m26358c("Could not call loadUrl. ", e);
            }
        } else {
            zzbad.m26359d("#004 The webview is destroyed. Ignoring action.");
        }
    }

    /* renamed from: d */
    private final synchronized void m23256d(String str) {
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError | UnsatisfiedLinkError e) {
            zzk.zzlk().mo30168a(e, "AdWebViewImpl.loadUrlUnsafe");
            zzbad.m26358c("Could not call loadUrl. ", e);
        }
    }

    public final synchronized void loadData(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadData(str, str2, str3);
        } else {
            zzbad.m26359d("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzbad.m26359d("#004 The webview is destroyed. Ignoring action.");
        }
    }

    /* renamed from: a */
    public final synchronized void mo28728a(String str, String str2, String str3) {
        String str4;
        if (!isDestroyed()) {
            if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23999Ra)).booleanValue()) {
                str4 = zzbid.m26990a(str2, zzbid.m26989a());
            } else {
                str4 = str2;
            }
            super.loadDataWithBaseURL(str, str4, "text/html", "UTF-8", str3);
            return;
        }
        zzbad.m26359d("#004 The webview is destroyed. Ignoring action.");
    }

    @TargetApi(19)
    /* renamed from: a */
    private final synchronized void m23252a(String str, ValueCallback<String> valueCallback) {
        if (!isDestroyed()) {
            evaluateJavascript(str, null);
        } else {
            zzbad.m26359d("#004 The webview is destroyed. Ignoring action.");
        }
    }

    /* renamed from: e */
    private final void m23257e(String str) {
        String str2 = "javascript:";
        if (PlatformVersion.m22112f()) {
            if (m23246R() == null) {
                m23239K();
            }
            if (m23246R().booleanValue()) {
                m23252a(str, null);
                return;
            }
            String valueOf = String.valueOf(str);
            m23255c(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return;
        }
        String valueOf2 = String.valueOf(str);
        m23255c(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
    }

    /* renamed from: a */
    public final void mo28724a(String str) {
        m23257e(str);
    }

    /* renamed from: K */
    private final synchronized void m23239K() {
        this.f21980s = zzk.zzlk().mo30172d();
        if (this.f21980s == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                m23251a(Boolean.valueOf(true));
            } catch (IllegalStateException e) {
                m23251a(Boolean.valueOf(false));
            }
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    private final void m23251a(Boolean bool) {
        synchronized (this) {
            this.f21980s = bool;
        }
        zzk.zzlk().mo30167a(bool);
    }

    @VisibleForTesting
    /* renamed from: R */
    private final synchronized Boolean m23246R() {
        return this.f21980s;
    }

    /* renamed from: b */
    public final void mo28740b(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(jSONObject2).length());
        sb.append(str);
        sb.append("(");
        sb.append(jSONObject2);
        sb.append(");");
        m23257e(sb.toString());
    }

    /* renamed from: a */
    public final void mo28730a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String str2 = "Dispatching AFMA event: ";
        String valueOf = String.valueOf(sb.toString());
        zzbad.m26352a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        m23257e(sb.toString());
    }

    /* renamed from: s */
    public final void mo28782s() {
        m23240L();
        HashMap hashMap = new HashMap(1);
        hashMap.put(MediationMetaData.KEY_VERSION, this.f21964c.f25057a);
        mo28729a("onhide", (Map<String, ?>) hashMap);
    }

    /* renamed from: a */
    public final void mo28715a(int i) {
        if (i == 0) {
            zzadb.m24799a(this.f21950H.mo29614a(), this.f21948F, "aebb2");
        }
        m23240L();
        if (this.f21950H.mo29614a() != null) {
            this.f21950H.mo29614a().mo29620a("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put(MediationMetaData.KEY_VERSION, this.f21964c.f25057a);
        mo28729a("onhide", (Map<String, ?>) hashMap);
    }

    /* renamed from: L */
    private final void m23240L() {
        zzadb.m24799a(this.f21950H.mo29614a(), this.f21948F, "aeh2");
    }

    /* renamed from: w */
    public final void mo28790w() {
        if (this.f21947E == null) {
            zzadb.m24799a(this.f21950H.mo29614a(), this.f21948F, "aes2");
            this.f21947E = zzadb.m24798a(this.f21950H.mo29614a());
            this.f21950H.mo29615a("native:view_show", this.f21947E);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(MediationMetaData.KEY_VERSION, this.f21964c.f25057a);
        mo28729a("onshow", (Map<String, ?>) hashMap);
    }

    /* renamed from: t */
    public final void mo28787t() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzk.zzll().mo30265b()));
        hashMap.put("app_volume", String.valueOf(zzk.zzll().mo30262a()));
        hashMap.put("device_volume", String.valueOf(zzaya.m26209a(getContext())));
        mo28729a("volume", (Map<String, ?>) hashMap);
    }

    /* renamed from: a */
    public final void mo28734a(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION, z ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
        hashMap.put(VastIconXmlManager.DURATION, Long.toString(j));
        mo28729a("onCacheAccessComplete", (Map<String, ?>) hashMap);
    }

    /* renamed from: i */
    public final synchronized zzd mo28758i() {
        return this.f21972k;
    }

    /* renamed from: v */
    public final synchronized IObjectWrapper mo28789v() {
        return this.f21973l;
    }

    /* renamed from: l */
    public final synchronized zzd mo28762l() {
        return this.f21952J;
    }

    /* renamed from: m */
    public final synchronized zzbin mo28766m() {
        return this.f21974m;
    }

    /* renamed from: b */
    public final synchronized String mo28737b() {
        return this.f21975n;
    }

    /* renamed from: c */
    public final WebViewClient mo28743c() {
        return this.f21971j;
    }

    /* renamed from: d */
    public final synchronized boolean mo28746d() {
        return this.f21976o;
    }

    /* renamed from: e */
    public final zzdh mo28748e() {
        return this.f21963b;
    }

    /* renamed from: z */
    public final zzbai mo28793z() {
        return this.f21964c;
    }

    /* renamed from: x */
    public final synchronized boolean mo28791x() {
        return this.f21978q;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzk.zzlg();
            zzaxi.m26109a(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length());
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            zzbad.m26352a(sb.toString());
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f21971j.mo30617j()) {
            synchronized (this) {
                if (this.f21943A != null) {
                    this.f21943A.mo28871a(motionEvent);
                }
            }
        } else {
            zzdh zzdh = this.f21963b;
            if (zzdh != null) {
                zzdh.mo31484a(motionEvent);
            }
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() != 8 || ((axisValue <= 0.0f || canScrollVertically(-1)) && ((axisValue >= 0.0f || canScrollVertically(1)) && ((axisValue2 <= 0.0f || canScrollHorizontally(-1)) && (axisValue2 >= 0.0f || canScrollHorizontally(1)))))) {
            return super.onGenericMotionEvent(motionEvent);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0202, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01e0 A[SYNTHETIC, Splitter:B:113:0x01e0] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0147  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:64:0x00e2=Splitter:B:64:0x00e2, B:123:0x0203=Splitter:B:123:0x0203} */
    @android.annotation.SuppressLint({"DrawAllocation"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.isDestroyed()     // Catch:{ all -> 0x0208 }
            r1 = 0
            if (r0 == 0) goto L_0x000d
            r7.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x0208 }
            monitor-exit(r7)
            return
        L_0x000d:
            boolean r0 = r7.isInEditMode()     // Catch:{ all -> 0x0208 }
            if (r0 != 0) goto L_0x0203
            boolean r0 = r7.f21978q     // Catch:{ all -> 0x0208 }
            if (r0 != 0) goto L_0x0203
            com.google.android.gms.internal.ads.zzbin r0 = r7.f21974m     // Catch:{ all -> 0x0208 }
            boolean r0 = r0.mo30651f()     // Catch:{ all -> 0x0208 }
            if (r0 == 0) goto L_0x0021
            goto L_0x0203
        L_0x0021:
            com.google.android.gms.internal.ads.zzbin r0 = r7.f21974m     // Catch:{ all -> 0x0208 }
            boolean r0 = r0.mo30653h()     // Catch:{ all -> 0x0208 }
            if (r0 == 0) goto L_0x002e
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x0208 }
            monitor-exit(r7)
            return
        L_0x002e:
            com.google.android.gms.internal.ads.zzbin r0 = r7.f21974m     // Catch:{ all -> 0x0208 }
            boolean r0 = r0.mo30652g()     // Catch:{ all -> 0x0208 }
            if (r0 == 0) goto L_0x0094
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzacu.f23989Pc     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzacr r1 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ all -> 0x0208 }
            java.lang.Object r0 = r1.mo29599a(r0)     // Catch:{ all -> 0x0208 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0208 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0208 }
            if (r0 == 0) goto L_0x004d
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x0208 }
            monitor-exit(r7)
            return
        L_0x004d:
            com.google.android.gms.internal.ads.zzbhq r0 = r7.mo28754g()     // Catch:{ all -> 0x0208 }
            r1 = 0
            if (r0 == 0) goto L_0x005a
            float r0 = r0.mo29364K()     // Catch:{ all -> 0x0208 }
            goto L_0x005b
        L_0x005a:
            r0 = 0
        L_0x005b:
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0064
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x0208 }
            monitor-exit(r7)
            return
        L_0x0064:
            int r8 = android.view.View.MeasureSpec.getSize(r8)     // Catch:{ all -> 0x0208 }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x0208 }
            float r1 = (float) r9     // Catch:{ all -> 0x0208 }
            float r1 = r1 * r0
            int r1 = (int) r1     // Catch:{ all -> 0x0208 }
            float r2 = (float) r8     // Catch:{ all -> 0x0208 }
            float r2 = r2 / r0
            int r2 = (int) r2     // Catch:{ all -> 0x0208 }
            if (r9 != 0) goto L_0x007e
            if (r2 == 0) goto L_0x007e
            float r9 = (float) r2     // Catch:{ all -> 0x0208 }
            float r9 = r9 * r0
            int r1 = (int) r9     // Catch:{ all -> 0x0208 }
            r9 = r2
            goto L_0x0087
        L_0x007e:
            if (r8 != 0) goto L_0x0087
            if (r1 == 0) goto L_0x0087
            float r8 = (float) r1     // Catch:{ all -> 0x0208 }
            float r8 = r8 / r0
            int r2 = (int) r8     // Catch:{ all -> 0x0208 }
            r8 = r1
        L_0x0087:
            int r8 = java.lang.Math.min(r1, r8)     // Catch:{ all -> 0x0208 }
            int r9 = java.lang.Math.min(r2, r9)     // Catch:{ all -> 0x0208 }
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x0208 }
            monitor-exit(r7)
            return
        L_0x0094:
            com.google.android.gms.internal.ads.zzbin r0 = r7.f21974m     // Catch:{ all -> 0x0208 }
            boolean r0 = r0.mo30649a()     // Catch:{ all -> 0x0208 }
            if (r0 == 0) goto L_0x00e7
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzacu.f24007Sc     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzacr r1 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ all -> 0x0208 }
            java.lang.Object r0 = r1.mo29599a(r0)     // Catch:{ all -> 0x0208 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0208 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0208 }
            if (r0 != 0) goto L_0x00e2
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.m22110d()     // Catch:{ all -> 0x0208 }
            if (r0 != 0) goto L_0x00b5
            goto L_0x00e2
        L_0x00b5:
            java.lang.String r0 = "/contentHeight"
            com.google.android.gms.internal.ads._e r1 = new com.google.android.gms.internal.ads._e     // Catch:{ all -> 0x0208 }
            r1.<init>(r7)     // Catch:{ all -> 0x0208 }
            r7.mo28726a(r0, r1)     // Catch:{ all -> 0x0208 }
            java.lang.String r0 = "(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();"
            r7.m23257e(r0)     // Catch:{ all -> 0x0208 }
            android.util.DisplayMetrics r0 = r7.f21967f     // Catch:{ all -> 0x0208 }
            float r0 = r0.density     // Catch:{ all -> 0x0208 }
            int r8 = android.view.View.MeasureSpec.getSize(r8)     // Catch:{ all -> 0x0208 }
            int r1 = r7.f21946D     // Catch:{ all -> 0x0208 }
            r2 = -1
            if (r1 == r2) goto L_0x00d8
            int r9 = r7.f21946D     // Catch:{ all -> 0x0208 }
            float r9 = (float) r9     // Catch:{ all -> 0x0208 }
            float r9 = r9 * r0
            int r9 = (int) r9     // Catch:{ all -> 0x0208 }
            goto L_0x00dd
        L_0x00d8:
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x0208 }
        L_0x00dd:
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x0208 }
            monitor-exit(r7)
            return
        L_0x00e2:
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x0208 }
            monitor-exit(r7)
            return
        L_0x00e7:
            com.google.android.gms.internal.ads.zzbin r0 = r7.f21974m     // Catch:{ all -> 0x0208 }
            boolean r0 = r0.mo30650e()     // Catch:{ all -> 0x0208 }
            if (r0 == 0) goto L_0x00fc
            android.util.DisplayMetrics r8 = r7.f21967f     // Catch:{ all -> 0x0208 }
            int r8 = r8.widthPixels     // Catch:{ all -> 0x0208 }
            android.util.DisplayMetrics r9 = r7.f21967f     // Catch:{ all -> 0x0208 }
            int r9 = r9.heightPixels     // Catch:{ all -> 0x0208 }
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x0208 }
            monitor-exit(r7)
            return
        L_0x00fc:
            int r0 = android.view.View.MeasureSpec.getMode(r8)     // Catch:{ all -> 0x0208 }
            int r8 = android.view.View.MeasureSpec.getSize(r8)     // Catch:{ all -> 0x0208 }
            int r2 = android.view.View.MeasureSpec.getMode(r9)     // Catch:{ all -> 0x0208 }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x0208 }
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r4) goto L_0x011d
            if (r0 != r3) goto L_0x0119
            goto L_0x011d
        L_0x0119:
            r0 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x011e
        L_0x011d:
            r0 = r8
        L_0x011e:
            if (r2 == r4) goto L_0x0123
            if (r2 != r3) goto L_0x0124
        L_0x0123:
            r5 = r9
        L_0x0124:
            com.google.android.gms.internal.ads.zzbin r2 = r7.f21974m     // Catch:{ all -> 0x0208 }
            int r2 = r2.f25379c     // Catch:{ all -> 0x0208 }
            r3 = 1
            if (r2 > r0) goto L_0x0134
            com.google.android.gms.internal.ads.zzbin r2 = r7.f21974m     // Catch:{ all -> 0x0208 }
            int r2 = r2.f25378b     // Catch:{ all -> 0x0208 }
            if (r2 <= r5) goto L_0x0132
            goto L_0x0134
        L_0x0132:
            r2 = 0
            goto L_0x0135
        L_0x0134:
            r2 = 1
        L_0x0135:
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zzacu.f24117je     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzacr r6 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ all -> 0x0208 }
            java.lang.Object r4 = r6.mo29599a(r4)     // Catch:{ all -> 0x0208 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x0208 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x0208 }
            if (r4 == 0) goto L_0x016f
            com.google.android.gms.internal.ads.zzbin r4 = r7.f21974m     // Catch:{ all -> 0x0208 }
            int r4 = r4.f25379c     // Catch:{ all -> 0x0208 }
            float r4 = (float) r4     // Catch:{ all -> 0x0208 }
            float r6 = r7.f21968g     // Catch:{ all -> 0x0208 }
            float r4 = r4 / r6
            float r0 = (float) r0     // Catch:{ all -> 0x0208 }
            float r6 = r7.f21968g     // Catch:{ all -> 0x0208 }
            float r0 = r0 / r6
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0169
            com.google.android.gms.internal.ads.zzbin r0 = r7.f21974m     // Catch:{ all -> 0x0208 }
            int r0 = r0.f25378b     // Catch:{ all -> 0x0208 }
            float r0 = (float) r0     // Catch:{ all -> 0x0208 }
            float r4 = r7.f21968g     // Catch:{ all -> 0x0208 }
            float r0 = r0 / r4
            float r4 = (float) r5     // Catch:{ all -> 0x0208 }
            float r5 = r7.f21968g     // Catch:{ all -> 0x0208 }
            float r4 = r4 / r5
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0169
            r0 = 1
            goto L_0x016a
        L_0x0169:
            r0 = 0
        L_0x016a:
            if (r2 == 0) goto L_0x016d
            goto L_0x0171
        L_0x016d:
            goto L_0x0170
        L_0x016f:
        L_0x0170:
            r0 = r2
        L_0x0171:
            r2 = 8
            if (r0 == 0) goto L_0x01e0
            com.google.android.gms.internal.ads.zzbin r0 = r7.f21974m     // Catch:{ all -> 0x0208 }
            int r0 = r0.f25379c     // Catch:{ all -> 0x0208 }
            float r0 = (float) r0     // Catch:{ all -> 0x0208 }
            float r4 = r7.f21968g     // Catch:{ all -> 0x0208 }
            float r0 = r0 / r4
            int r0 = (int) r0     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzbin r4 = r7.f21974m     // Catch:{ all -> 0x0208 }
            int r4 = r4.f25378b     // Catch:{ all -> 0x0208 }
            float r4 = (float) r4     // Catch:{ all -> 0x0208 }
            float r5 = r7.f21968g     // Catch:{ all -> 0x0208 }
            float r4 = r4 / r5
            int r4 = (int) r4     // Catch:{ all -> 0x0208 }
            float r8 = (float) r8     // Catch:{ all -> 0x0208 }
            float r5 = r7.f21968g     // Catch:{ all -> 0x0208 }
            float r8 = r8 / r5
            int r8 = (int) r8     // Catch:{ all -> 0x0208 }
            float r9 = (float) r9     // Catch:{ all -> 0x0208 }
            float r5 = r7.f21968g     // Catch:{ all -> 0x0208 }
            float r9 = r9 / r5
            int r9 = (int) r9     // Catch:{ all -> 0x0208 }
            r5 = 103(0x67, float:1.44E-43)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0208 }
            r6.<init>(r5)     // Catch:{ all -> 0x0208 }
            java.lang.String r5 = "Not enough space to show ad. Needs "
            r6.append(r5)     // Catch:{ all -> 0x0208 }
            r6.append(r0)     // Catch:{ all -> 0x0208 }
            java.lang.String r0 = "x"
            r6.append(r0)     // Catch:{ all -> 0x0208 }
            r6.append(r4)     // Catch:{ all -> 0x0208 }
            java.lang.String r0 = " dp, but only has "
            r6.append(r0)     // Catch:{ all -> 0x0208 }
            r6.append(r8)     // Catch:{ all -> 0x0208 }
            java.lang.String r8 = "x"
            r6.append(r8)     // Catch:{ all -> 0x0208 }
            r6.append(r9)     // Catch:{ all -> 0x0208 }
            java.lang.String r8 = " dp."
            r6.append(r8)     // Catch:{ all -> 0x0208 }
            java.lang.String r8 = r6.toString()     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzbad.m26359d(r8)     // Catch:{ all -> 0x0208 }
            int r8 = r7.getVisibility()     // Catch:{ all -> 0x0208 }
            if (r8 == r2) goto L_0x01ce
            r8 = 4
            r7.setVisibility(r8)     // Catch:{ all -> 0x0208 }
        L_0x01ce:
            r7.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x0208 }
            boolean r8 = r7.f21969h     // Catch:{ all -> 0x0208 }
            if (r8 != 0) goto L_0x0201
            com.google.android.gms.internal.ads.zzwj r8 = r7.f21961S     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzwl$zza$zzb r9 = com.google.android.gms.internal.ads.zzwl.zza.zzb.BANNER_SIZE_INVALID     // Catch:{ all -> 0x0208 }
            r8.mo32330a(r9)     // Catch:{ all -> 0x0208 }
            r7.f21969h = r3     // Catch:{ all -> 0x0208 }
            monitor-exit(r7)
            return
        L_0x01e0:
            int r8 = r7.getVisibility()     // Catch:{ all -> 0x0208 }
            if (r8 == r2) goto L_0x01e9
            r7.setVisibility(r1)     // Catch:{ all -> 0x0208 }
        L_0x01e9:
            boolean r8 = r7.f21970i     // Catch:{ all -> 0x0208 }
            if (r8 != 0) goto L_0x01f6
            com.google.android.gms.internal.ads.zzwj r8 = r7.f21961S     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzwl$zza$zzb r9 = com.google.android.gms.internal.ads.zzwl.zza.zzb.BANNER_SIZE_VALID     // Catch:{ all -> 0x0208 }
            r8.mo32330a(r9)     // Catch:{ all -> 0x0208 }
            r7.f21970i = r3     // Catch:{ all -> 0x0208 }
        L_0x01f6:
            com.google.android.gms.internal.ads.zzbin r8 = r7.f21974m     // Catch:{ all -> 0x0208 }
            int r8 = r8.f25379c     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzbin r9 = r7.f21974m     // Catch:{ all -> 0x0208 }
            int r9 = r9.f25378b     // Catch:{ all -> 0x0208 }
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x0208 }
        L_0x0201:
            monitor-exit(r7)
            return
        L_0x0203:
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x0208 }
            monitor-exit(r7)
            return
        L_0x0208:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9251Ye.onMeasure(int, int):void");
    }

    public final void onGlobalLayout() {
        boolean J = m23238J();
        zzd i = mo28758i();
        if (i != null && J) {
            i.zztk();
        }
    }

    /* renamed from: b */
    public final synchronized void mo28738b(zzd zzd) {
        this.f21972k = zzd;
    }

    /* renamed from: a */
    public final synchronized void mo28719a(IObjectWrapper iObjectWrapper) {
        this.f21973l = iObjectWrapper;
    }

    /* renamed from: a */
    public final synchronized void mo28718a(zzd zzd) {
        this.f21952J = zzd;
    }

    /* renamed from: a */
    public final synchronized void mo28723a(zzbin zzbin) {
        this.f21974m = zzbin;
        requestLayout();
    }

    /* renamed from: e */
    public final synchronized void mo28749e(boolean z) {
        boolean z2 = z != this.f21978q;
        this.f21978q = z;
        m23241M();
        if (z2) {
            new zzaqb(this).mo29994c(z ? "expanded" : BuildConfig.APTOIDE_THEME);
        }
    }

    /* renamed from: p */
    public final void mo28779p() {
        this.f21954L.mo30310c();
    }

    /* access modifiers changed from: protected */
    public final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.f21954L.mo30307a();
        }
        boolean z = this.f21986y;
        if (this.f21971j != null && this.f21971j.mo30617j()) {
            if (!this.f21987z) {
                this.f21971j.mo30618k();
                this.f21971j.mo30619l();
                this.f21987z = true;
            }
            m23238J();
            z = true;
        }
        m23258g(z);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        synchronized (this) {
            if (!isDestroyed()) {
                this.f21954L.mo30309b();
            }
            super.onDetachedFromWindow();
            if (this.f21987z && this.f21971j != null && this.f21971j.mo30617j() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.f21971j.mo30618k();
                this.f21971j.mo30619l();
                this.f21987z = false;
            }
        }
        m23258g(false);
    }

    /* renamed from: a */
    public final void mo28716a(Context context) {
        this.f21962a.setBaseContext(context);
        this.f21954L.mo30308a(this.f21962a.mo30645b());
    }

    /* renamed from: d */
    public final synchronized void mo28745d(boolean z) {
        if (this.f21972k != null) {
            this.f21972k.zza(this.f21971j.mo30608b(), z);
        } else {
            this.f21976o = z;
        }
    }

    public final synchronized void setRequestedOrientation(int i) {
        this.f21981t = i;
        if (this.f21972k != null) {
            this.f21972k.setRequestedOrientation(this.f21981t);
        }
    }

    /* renamed from: q */
    public final Activity mo28780q() {
        return this.f21962a.mo30645b();
    }

    /* renamed from: f */
    public final Context mo28751f() {
        return this.f21962a.mo30644a();
    }

    /* renamed from: M */
    private final synchronized void m23241M() {
        if (!this.f21978q) {
            if (!this.f21974m.mo30650e()) {
                if (VERSION.SDK_INT < 18) {
                    zzbad.m26352a("Disabling hardware acceleration on an AdView.");
                    m23242N();
                    return;
                }
                zzbad.m26352a("Enabling hardware acceleration on an AdView.");
                m23243O();
                return;
            }
        }
        zzbad.m26352a("Enabling hardware acceleration on an overlay.");
        m23243O();
    }

    /* renamed from: N */
    private final synchronized void m23242N() {
        if (!this.f21979r) {
            zzk.zzli();
            setLayerType(1, null);
        }
        this.f21979r = true;
    }

    /* renamed from: O */
    private final synchronized void m23243O() {
        if (this.f21979r) {
            zzk.zzli();
            setLayerType(0, null);
        }
        this.f21979r = false;
    }

    public final synchronized void destroy() {
        m23245Q();
        this.f21954L.mo30311d();
        if (this.f21972k != null) {
            this.f21972k.close();
            this.f21972k.onDestroy();
            this.f21972k = null;
        }
        this.f21973l = null;
        this.f21971j.mo30616i();
        if (!this.f21977p) {
            zzk.zzmc();
            zzbfs.m26706a((zzbdf) this);
            m23244P();
            this.f21977p = true;
            zzawz.m26003f("Initiating WebView self destruct sequence in 3...");
            zzawz.m26003f("Loading blank page in WebView, 2...");
            m23256d("about:blank");
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.f21977p) {
                    this.f21971j.mo30616i();
                    zzk.zzmc();
                    zzbfs.m26706a((zzbdf) this);
                    m23244P();
                    m23247S();
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    /* renamed from: y */
    public final synchronized void mo28792y() {
        zzawz.m26003f("Destroying WebView!");
        m23247S();
        zzaxi.f24961a.post(new C9314af(this));
    }

    /* renamed from: S */
    private final synchronized void m23247S() {
        if (!this.f21953K) {
            this.f21953K = true;
            zzk.zzlk().mo30175g();
        }
    }

    public final synchronized boolean isDestroyed() {
        return this.f21977p;
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public final void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
            }
        }
    }

    /* renamed from: r */
    public final void mo28781r() {
        if (this.f21949G == null) {
            this.f21949G = zzadb.m24798a(this.f21950H.mo29614a());
            this.f21950H.mo29615a("native:view_load", this.f21949G);
        }
    }

    public final void onPause() {
        if (!isDestroyed()) {
            try {
                super.onPause();
            } catch (Exception e) {
                zzbad.m26356b("Could not pause webview.", e);
            }
        }
    }

    public final void onResume() {
        if (!isDestroyed()) {
            try {
                super.onResume();
            } catch (Exception e) {
                zzbad.m26356b("Could not resume webview.", e);
            }
        }
    }

    /* renamed from: j */
    public final void mo28760j() {
        zzawz.m26003f("Cannot add text view to inner AdWebView");
    }

    /* renamed from: a */
    public final void mo28731a(boolean z) {
        this.f21971j.mo30610c(z);
    }

    public final void stopLoading() {
        if (!isDestroyed()) {
            try {
                super.stopLoading();
            } catch (Exception e) {
                zzbad.m26356b("Could not stop loading webview.", e);
            }
        }
    }

    /* renamed from: b */
    public final synchronized void mo28741b(boolean z) {
        this.f21982u = z;
    }

    /* renamed from: A */
    public final synchronized boolean mo28705A() {
        return this.f21982u;
    }

    public final synchronized void zzlc() {
        this.f21983v = true;
        if (this.f21965d != null) {
            this.f21965d.zzlc();
        }
    }

    public final synchronized void zzld() {
        this.f21983v = false;
        if (this.f21965d != null) {
            this.f21965d.zzld();
        }
    }

    /* renamed from: P */
    private final synchronized void m23244P() {
        if (this.f21959Q != null) {
            for (zzbft a : this.f21959Q.values()) {
                a.mo27353a();
            }
        }
        this.f21959Q = null;
    }

    /* renamed from: a */
    public final synchronized void mo28727a(String str, zzbft zzbft) {
        if (this.f21959Q == null) {
            this.f21959Q = new HashMap();
        }
        this.f21959Q.put(str, zzbft);
    }

    /* renamed from: b */
    public final synchronized zzbft mo28736b(String str) {
        if (this.f21959Q == null) {
            return null;
        }
        return (zzbft) this.f21959Q.get(str);
    }

    /* renamed from: F */
    public final synchronized String mo28710F() {
        return this.f21984w;
    }

    /* renamed from: E */
    public final zzbcw mo28709E() {
        return null;
    }

    /* renamed from: C */
    public final synchronized void mo28707C() {
        if (this.f21944B != null) {
            this.f21944B.mo29638hb();
        }
    }

    /* renamed from: a */
    public final synchronized void mo28720a(zzadv zzadv) {
        this.f21944B = zzadv;
    }

    /* renamed from: G */
    public final zzadg mo28711G() {
        return this.f21948F;
    }

    /* renamed from: B */
    public final zzadh mo28706B() {
        return this.f21950H;
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.f21951I = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    /* renamed from: a */
    public final synchronized void mo28721a(zzadx zzadx) {
        this.f21943A = zzadx;
    }

    /* renamed from: u */
    public final synchronized zzadx mo28788u() {
        return this.f21943A;
    }

    /* renamed from: g */
    public final synchronized zzbhq mo28754g() {
        return this.f21985x;
    }

    /* renamed from: a */
    public final synchronized void mo28722a(zzbhq zzbhq) {
        if (this.f21985x != null) {
            zzbad.m26355b("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.f21985x = zzbhq;
        }
    }

    /* renamed from: n */
    public final synchronized boolean mo28767n() {
        return this.f21945C > 0;
    }

    /* renamed from: c */
    public final synchronized void mo28744c(boolean z) {
        this.f21945C += z ? 1 : -1;
        if (this.f21945C <= 0 && this.f21972k != null) {
            this.f21972k.zztn();
        }
    }

    /* renamed from: Q */
    private final void m23245Q() {
        zzadh zzadh = this.f21950H;
        if (zzadh != null) {
            zzadi a = zzadh.mo29614a();
            if (!(a == null || zzk.zzlk().mo30171c() == null)) {
                zzk.zzlk().mo30171c().mo29610a(a);
            }
        }
    }

    /* renamed from: h */
    public final void mo28757h() {
        setBackgroundColor(0);
    }

    /* renamed from: f */
    public final void mo28752f(boolean z) {
        this.f21971j.mo30607b(z);
    }

    /* renamed from: D */
    public final void mo28708D() {
        zzd i = mo28758i();
        if (i != null) {
            i.zztm();
        }
    }

    /* renamed from: I */
    public final int mo28713I() {
        return getMeasuredHeight();
    }

    /* renamed from: H */
    public final int mo28712H() {
        return getMeasuredWidth();
    }

    /* renamed from: a */
    public final void mo28717a(zzc zzc) {
        this.f21971j.mo30596a(zzc);
    }

    /* renamed from: b */
    public final void mo28742b(boolean z, int i) {
        this.f21971j.mo30603a(z, i);
    }

    /* renamed from: a */
    public final void mo28732a(boolean z, int i, String str) {
        this.f21971j.mo30604a(z, i, str);
    }

    /* renamed from: a */
    public final void mo28733a(boolean z, int i, String str, String str2) {
        this.f21971j.mo30605a(z, i, str, str2);
    }

    /* renamed from: a */
    public final void mo28694a(zzud zzud) {
        synchronized (this) {
            this.f21986y = zzud.f29465m;
        }
        m23258g(zzud.f29465m);
    }

    /* renamed from: g */
    private final void m23258g(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
        mo28729a("onAdVisibilityChanged", (Map<String, ?>) hashMap);
    }

    /* renamed from: a */
    public final void mo28726a(String str, zzaho<? super zzbgz> zzaho) {
        zzbha zzbha = this.f21971j;
        if (zzbha != null) {
            zzbha.mo30601a(str, zzaho);
        }
    }

    /* renamed from: b */
    public final void mo28739b(String str, zzaho<? super zzbgz> zzaho) {
        zzbha zzbha = this.f21971j;
        if (zzbha != null) {
            zzbha.mo30606b(str, zzaho);
        }
    }

    /* renamed from: a */
    public final void mo28725a(String str, Predicate<zzaho<? super zzbgz>> predicate) {
        zzbha zzbha = this.f21971j;
        if (zzbha != null) {
            zzbha.mo30600a(str, predicate);
        }
    }

    /* renamed from: a */
    public final boolean mo28735a(boolean z, int i) {
        destroy();
        this.f21961S.mo32329a((zzwk) new C9272Ze(z, i));
        this.f21961S.mo32330a(zzb.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    /* renamed from: k */
    public final boolean mo28761k() {
        return false;
    }

    /* renamed from: a */
    public final /* synthetic */ zzbii mo28714a() {
        return this.f21971j;
    }

    /* renamed from: a */
    static final /* synthetic */ void m23253a(boolean z, int i, zzxn zzxn) {
        zzv.zza m = zzv.m31474m();
        if (m.mo32358m() != z) {
            m.mo32357a(z);
        }
        m.mo32356a(i);
        zzxn.f29697n = (zzv) m.mo31612g();
    }
}
