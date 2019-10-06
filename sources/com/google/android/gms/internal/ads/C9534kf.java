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
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.install.installer.RootCommandOnSubscribe;

@VisibleForTesting
@zzard
/* renamed from: com.google.android.gms.internal.ads.kf */
final class C9534kf extends zzbjb implements OnGlobalLayoutListener, DownloadListener, zzajq, zzbgz {

    /* renamed from: A */
    private int f22644A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public int f22645B;

    /* renamed from: C */
    private zzadg f22646C;

    /* renamed from: D */
    private zzadg f22647D;

    /* renamed from: E */
    private zzadg f22648E;

    /* renamed from: F */
    private zzadh f22649F;

    /* renamed from: G */
    private WeakReference<OnClickListener> f22650G;

    /* renamed from: H */
    private zzd f22651H;

    /* renamed from: I */
    private zzazs f22652I;

    /* renamed from: J */
    private final AtomicReference<IObjectWrapper> f22653J = new AtomicReference<>();

    /* renamed from: K */
    private int f22654K = -1;

    /* renamed from: L */
    private int f22655L = -1;

    /* renamed from: M */
    private int f22656M = -1;

    /* renamed from: N */
    private int f22657N = -1;

    /* renamed from: O */
    private Map<String, zzbft> f22658O;

    /* renamed from: P */
    private final WindowManager f22659P;

    /* renamed from: d */
    private final zzbim f22660d;

    /* renamed from: e */
    private final zzbio f22661e;

    /* renamed from: f */
    private final zzdh f22662f;

    /* renamed from: g */
    private final zzbai f22663g;

    /* renamed from: h */
    private final zzj f22664h;

    /* renamed from: i */
    private final zza f22665i;

    /* renamed from: j */
    private final DisplayMetrics f22666j;

    /* renamed from: k */
    private final zzwj f22667k;

    /* renamed from: l */
    private zzd f22668l;

    /* renamed from: m */
    private zzbin f22669m;

    /* renamed from: n */
    private String f22670n;

    /* renamed from: o */
    private boolean f22671o;

    /* renamed from: p */
    private boolean f22672p;

    /* renamed from: q */
    private boolean f22673q;

    /* renamed from: r */
    private int f22674r;

    /* renamed from: s */
    private boolean f22675s = true;

    /* renamed from: t */
    private boolean f22676t = false;

    /* renamed from: u */
    private String f22677u = "";

    /* renamed from: v */
    private zzbhq f22678v;

    /* renamed from: w */
    private boolean f22679w;

    /* renamed from: x */
    private boolean f22680x;

    /* renamed from: y */
    private zzadx f22681y;

    /* renamed from: z */
    private zzadv f22682z;

    @VisibleForTesting
    protected C9534kf(zzbim zzbim, zzbio zzbio, zzbin zzbin, String str, boolean z, boolean z2, zzdh zzdh, zzbai zzbai, zzadi zzadi, zzj zzj, zza zza, zzwj zzwj) {
        super(zzbim, zzbio);
        this.f22660d = zzbim;
        this.f22661e = zzbio;
        this.f22669m = zzbin;
        this.f22670n = str;
        this.f22672p = z;
        this.f22674r = -1;
        this.f22662f = zzdh;
        this.f22663g = zzbai;
        this.f22664h = zzj;
        this.f22665i = zza;
        this.f22659P = (WindowManager) getContext().getSystemService("window");
        zzk.zzlg();
        this.f22666j = zzaxi.m26100a(this.f22659P);
        this.f22667k = zzwj;
        this.f22652I = new zzazs(this.f22660d.mo30645b(), this, this, null);
        zzk.zzlg().mo30231a((Context) zzbim, zzbai.f25057a, getSettings());
        setDownloadListener(this);
        m23745N();
        if (PlatformVersion.m22110d()) {
            addJavascriptInterface(zzbht.m26964a((zzbgz) this), "googleAdsJsInterface");
        }
        m23749R();
        this.f22649F = new zzadh(new zzadi(true, "make_wv", this.f22670n));
        this.f22649F.mo29614a().mo29619a(zzadi);
        this.f22647D = zzadb.m24798a(this.f22649F.mo29614a());
        this.f22649F.mo29615a("native:view_create", this.f22647D);
        this.f22648E = null;
        this.f22646C = null;
        zzk.zzli().mo30258b((Context) zzbim);
    }

    /* renamed from: a */
    public final void mo29037a(String str, String str2) {
        zzajr.m25122a((zzajq) this, str, str2);
    }

    /* renamed from: a */
    public final void mo28729a(String str, Map map) {
        zzajr.m25123a((zzajq) this, str, map);
    }

    /* renamed from: a */
    public final void mo28730a(String str, JSONObject jSONObject) {
        zzajr.m25125b(this, str, jSONObject);
    }

    /* renamed from: b */
    public final void mo28740b(String str, JSONObject jSONObject) {
        zzajr.m25124a((zzajq) this, str, jSONObject);
    }

    public final WebView getWebView() {
        return this;
    }

    public final View getView() {
        return this;
    }

    /* renamed from: o */
    public final zza mo28768o() {
        return this.f22665i;
    }

    /* renamed from: L */
    private final boolean m23743L() {
        int i;
        int i2;
        boolean z = false;
        if (!this.f22661e.mo30608b() && !this.f22661e.mo30666j()) {
            return false;
        }
        zzyt.m31532a();
        DisplayMetrics displayMetrics = this.f22666j;
        int b = zzazt.m26312b(displayMetrics, displayMetrics.widthPixels);
        zzyt.m31532a();
        DisplayMetrics displayMetrics2 = this.f22666j;
        int b2 = zzazt.m26312b(displayMetrics2, displayMetrics2.heightPixels);
        Activity b3 = this.f22660d.mo30645b();
        if (b3 == null || b3.getWindow() == null) {
            i2 = b;
            i = b2;
        } else {
            zzk.zzlg();
            int[] a = zzaxi.m26119a(b3);
            zzyt.m31532a();
            int b4 = zzazt.m26312b(this.f22666j, a[0]);
            zzyt.m31532a();
            i = zzazt.m26312b(this.f22666j, a[1]);
            i2 = b4;
        }
        if (this.f22655L == b && this.f22654K == b2 && this.f22656M == i2 && this.f22657N == i) {
            return false;
        }
        if (!(this.f22655L == b && this.f22654K == b2)) {
            z = true;
        }
        this.f22655L = b;
        this.f22654K = b2;
        this.f22656M = i2;
        this.f22657N = i;
        new zzaqb(this).mo29990a(b, b2, i2, i, this.f22666j.density, this.f22659P.getDefaultDisplay().getRotation());
        return z;
    }

    /* renamed from: a */
    public final synchronized void mo28728a(String str, String str2, String str3) {
        String str4;
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23999Ra)).booleanValue()) {
            str4 = zzbid.m26990a(str2, zzbid.m26989a());
        } else {
            str4 = str2;
        }
        super.loadDataWithBaseURL(str, str4, "text/html", "UTF-8", str3);
    }

    /* renamed from: a */
    public final synchronized void mo28724a(String str) {
        if (!isDestroyed()) {
            super.mo28724a(str);
        } else {
            zzbad.m26359d("The webview is destroyed. Ignoring action.");
        }
    }

    /* renamed from: s */
    public final void mo28782s() {
        m23744M();
        HashMap hashMap = new HashMap(1);
        hashMap.put(MediationMetaData.KEY_VERSION, this.f22663g.f25057a);
        zzajr.m25123a((zzajq) this, "onhide", (Map) hashMap);
    }

    /* renamed from: a */
    public final void mo28715a(int i) {
        if (i == 0) {
            zzadb.m24799a(this.f22649F.mo29614a(), this.f22647D, "aebb2");
        }
        m23744M();
        if (this.f22649F.mo29614a() != null) {
            this.f22649F.mo29614a().mo29620a("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put(MediationMetaData.KEY_VERSION, this.f22663g.f25057a);
        zzajr.m25123a((zzajq) this, "onhide", (Map) hashMap);
    }

    /* renamed from: M */
    private final void m23744M() {
        zzadb.m24799a(this.f22649F.mo29614a(), this.f22647D, "aeh2");
    }

    /* renamed from: w */
    public final void mo28790w() {
        if (this.f22646C == null) {
            zzadb.m24799a(this.f22649F.mo29614a(), this.f22647D, "aes2");
            this.f22646C = zzadb.m24798a(this.f22649F.mo29614a());
            this.f22649F.mo29615a("native:view_show", this.f22646C);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(MediationMetaData.KEY_VERSION, this.f22663g.f25057a);
        zzajr.m25123a((zzajq) this, "onshow", (Map) hashMap);
    }

    /* renamed from: t */
    public final void mo28787t() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzk.zzll().mo30265b()));
        hashMap.put("app_volume", String.valueOf(zzk.zzll().mo30262a()));
        hashMap.put("device_volume", String.valueOf(zzaya.m26209a(getContext())));
        zzajr.m25123a((zzajq) this, "volume", (Map) hashMap);
    }

    /* renamed from: a */
    public final void mo28734a(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION, z ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
        hashMap.put(VastIconXmlManager.DURATION, Long.toString(j));
        zzajr.m25123a((zzajq) this, "onCacheAccessComplete", (Map) hashMap);
    }

    /* renamed from: i */
    public final synchronized zzd mo28758i() {
        return this.f22668l;
    }

    /* renamed from: v */
    public final IObjectWrapper mo28789v() {
        return (IObjectWrapper) this.f22653J.get();
    }

    /* renamed from: l */
    public final synchronized zzd mo28762l() {
        return this.f22651H;
    }

    /* renamed from: m */
    public final synchronized zzbin mo28766m() {
        return this.f22669m;
    }

    /* renamed from: b */
    public final synchronized String mo28737b() {
        return this.f22670n;
    }

    /* renamed from: c */
    public final WebViewClient mo28743c() {
        return this.f22661e;
    }

    /* renamed from: d */
    public final synchronized boolean mo28746d() {
        return this.f22671o;
    }

    /* renamed from: e */
    public final zzdh mo28748e() {
        return this.f22662f;
    }

    /* renamed from: z */
    public final zzbai mo28793z() {
        return this.f22663g;
    }

    /* renamed from: x */
    public final synchronized boolean mo28791x() {
        return this.f22672p;
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
        if (this.f22661e.mo30666j()) {
            synchronized (this) {
                if (this.f22681y != null) {
                    this.f22681y.mo28871a(motionEvent);
                }
            }
        } else {
            zzdh zzdh = this.f22662f;
            if (zzdh != null) {
                zzdh.mo31484a(motionEvent);
            }
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
    /* JADX WARNING: Removed duplicated region for block: B:104:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01e2 A[SYNTHETIC, Splitter:B:110:0x01e2] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0147  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:64:0x00e2=Splitter:B:64:0x00e2, B:117:0x01f8=Splitter:B:117:0x01f8} */
    @android.annotation.SuppressLint({"DrawAllocation"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.isDestroyed()     // Catch:{ all -> 0x01fd }
            r1 = 0
            if (r0 == 0) goto L_0x000d
            r7.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01fd }
            monitor-exit(r7)
            return
        L_0x000d:
            boolean r0 = r7.isInEditMode()     // Catch:{ all -> 0x01fd }
            if (r0 != 0) goto L_0x01f8
            boolean r0 = r7.f22672p     // Catch:{ all -> 0x01fd }
            if (r0 != 0) goto L_0x01f8
            com.google.android.gms.internal.ads.zzbin r0 = r7.f22669m     // Catch:{ all -> 0x01fd }
            boolean r0 = r0.mo30651f()     // Catch:{ all -> 0x01fd }
            if (r0 == 0) goto L_0x0021
            goto L_0x01f8
        L_0x0021:
            com.google.android.gms.internal.ads.zzbin r0 = r7.f22669m     // Catch:{ all -> 0x01fd }
            boolean r0 = r0.mo30653h()     // Catch:{ all -> 0x01fd }
            if (r0 == 0) goto L_0x002e
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01fd }
            monitor-exit(r7)
            return
        L_0x002e:
            com.google.android.gms.internal.ads.zzbin r0 = r7.f22669m     // Catch:{ all -> 0x01fd }
            boolean r0 = r0.mo30652g()     // Catch:{ all -> 0x01fd }
            if (r0 == 0) goto L_0x0094
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzacu.f23989Pc     // Catch:{ all -> 0x01fd }
            com.google.android.gms.internal.ads.zzacr r1 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ all -> 0x01fd }
            java.lang.Object r0 = r1.mo29599a(r0)     // Catch:{ all -> 0x01fd }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01fd }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01fd }
            if (r0 == 0) goto L_0x004d
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01fd }
            monitor-exit(r7)
            return
        L_0x004d:
            com.google.android.gms.internal.ads.zzbhq r0 = r7.mo28754g()     // Catch:{ all -> 0x01fd }
            r1 = 0
            if (r0 == 0) goto L_0x005a
            float r0 = r0.mo29364K()     // Catch:{ all -> 0x01fd }
            goto L_0x005b
        L_0x005a:
            r0 = 0
        L_0x005b:
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0064
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01fd }
            monitor-exit(r7)
            return
        L_0x0064:
            int r8 = android.view.View.MeasureSpec.getSize(r8)     // Catch:{ all -> 0x01fd }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01fd }
            float r1 = (float) r9     // Catch:{ all -> 0x01fd }
            float r1 = r1 * r0
            int r1 = (int) r1     // Catch:{ all -> 0x01fd }
            float r2 = (float) r8     // Catch:{ all -> 0x01fd }
            float r2 = r2 / r0
            int r2 = (int) r2     // Catch:{ all -> 0x01fd }
            if (r9 != 0) goto L_0x007e
            if (r2 == 0) goto L_0x007e
            float r9 = (float) r2     // Catch:{ all -> 0x01fd }
            float r9 = r9 * r0
            int r1 = (int) r9     // Catch:{ all -> 0x01fd }
            r9 = r2
            goto L_0x0087
        L_0x007e:
            if (r8 != 0) goto L_0x0087
            if (r1 == 0) goto L_0x0087
            float r8 = (float) r1     // Catch:{ all -> 0x01fd }
            float r8 = r8 / r0
            int r2 = (int) r8     // Catch:{ all -> 0x01fd }
            r8 = r1
        L_0x0087:
            int r8 = java.lang.Math.min(r1, r8)     // Catch:{ all -> 0x01fd }
            int r9 = java.lang.Math.min(r2, r9)     // Catch:{ all -> 0x01fd }
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01fd }
            monitor-exit(r7)
            return
        L_0x0094:
            com.google.android.gms.internal.ads.zzbin r0 = r7.f22669m     // Catch:{ all -> 0x01fd }
            boolean r0 = r0.mo30649a()     // Catch:{ all -> 0x01fd }
            if (r0 == 0) goto L_0x00e7
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzacu.f24007Sc     // Catch:{ all -> 0x01fd }
            com.google.android.gms.internal.ads.zzacr r1 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ all -> 0x01fd }
            java.lang.Object r0 = r1.mo29599a(r0)     // Catch:{ all -> 0x01fd }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01fd }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01fd }
            if (r0 != 0) goto L_0x00e2
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.m22110d()     // Catch:{ all -> 0x01fd }
            if (r0 != 0) goto L_0x00b5
            goto L_0x00e2
        L_0x00b5:
            java.lang.String r0 = "/contentHeight"
            com.google.android.gms.internal.ads.mf r1 = new com.google.android.gms.internal.ads.mf     // Catch:{ all -> 0x01fd }
            r1.<init>(r7)     // Catch:{ all -> 0x01fd }
            r7.mo28726a(r0, r1)     // Catch:{ all -> 0x01fd }
            java.lang.String r0 = "(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();"
            r7.mo28724a(r0)     // Catch:{ all -> 0x01fd }
            int r8 = android.view.View.MeasureSpec.getSize(r8)     // Catch:{ all -> 0x01fd }
            int r0 = r7.f22645B     // Catch:{ all -> 0x01fd }
            r1 = -1
            if (r0 == r1) goto L_0x00d8
            int r9 = r7.f22645B     // Catch:{ all -> 0x01fd }
            float r9 = (float) r9     // Catch:{ all -> 0x01fd }
            android.util.DisplayMetrics r0 = r7.f22666j     // Catch:{ all -> 0x01fd }
            float r0 = r0.density     // Catch:{ all -> 0x01fd }
            float r9 = r9 * r0
            int r9 = (int) r9     // Catch:{ all -> 0x01fd }
            goto L_0x00dd
        L_0x00d8:
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01fd }
        L_0x00dd:
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01fd }
            monitor-exit(r7)
            return
        L_0x00e2:
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01fd }
            monitor-exit(r7)
            return
        L_0x00e7:
            com.google.android.gms.internal.ads.zzbin r0 = r7.f22669m     // Catch:{ all -> 0x01fd }
            boolean r0 = r0.mo30650e()     // Catch:{ all -> 0x01fd }
            if (r0 == 0) goto L_0x00fc
            android.util.DisplayMetrics r8 = r7.f22666j     // Catch:{ all -> 0x01fd }
            int r8 = r8.widthPixels     // Catch:{ all -> 0x01fd }
            android.util.DisplayMetrics r9 = r7.f22666j     // Catch:{ all -> 0x01fd }
            int r9 = r9.heightPixels     // Catch:{ all -> 0x01fd }
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01fd }
            monitor-exit(r7)
            return
        L_0x00fc:
            int r0 = android.view.View.MeasureSpec.getMode(r8)     // Catch:{ all -> 0x01fd }
            int r8 = android.view.View.MeasureSpec.getSize(r8)     // Catch:{ all -> 0x01fd }
            int r2 = android.view.View.MeasureSpec.getMode(r9)     // Catch:{ all -> 0x01fd }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01fd }
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
            com.google.android.gms.internal.ads.zzbin r2 = r7.f22669m     // Catch:{ all -> 0x01fd }
            int r2 = r2.f25379c     // Catch:{ all -> 0x01fd }
            r3 = 1
            if (r2 > r0) goto L_0x0134
            com.google.android.gms.internal.ads.zzbin r2 = r7.f22669m     // Catch:{ all -> 0x01fd }
            int r2 = r2.f25378b     // Catch:{ all -> 0x01fd }
            if (r2 <= r5) goto L_0x0132
            goto L_0x0134
        L_0x0132:
            r2 = 0
            goto L_0x0135
        L_0x0134:
            r2 = 1
        L_0x0135:
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zzacu.f24117je     // Catch:{ all -> 0x01fd }
            com.google.android.gms.internal.ads.zzacr r6 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ all -> 0x01fd }
            java.lang.Object r4 = r6.mo29599a(r4)     // Catch:{ all -> 0x01fd }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x01fd }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x01fd }
            if (r4 == 0) goto L_0x0177
            com.google.android.gms.internal.ads.zzbin r4 = r7.f22669m     // Catch:{ all -> 0x01fd }
            int r4 = r4.f25379c     // Catch:{ all -> 0x01fd }
            float r4 = (float) r4     // Catch:{ all -> 0x01fd }
            android.util.DisplayMetrics r6 = r7.f22666j     // Catch:{ all -> 0x01fd }
            float r6 = r6.density     // Catch:{ all -> 0x01fd }
            float r4 = r4 / r6
            float r0 = (float) r0     // Catch:{ all -> 0x01fd }
            android.util.DisplayMetrics r6 = r7.f22666j     // Catch:{ all -> 0x01fd }
            float r6 = r6.density     // Catch:{ all -> 0x01fd }
            float r0 = r0 / r6
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0170
            com.google.android.gms.internal.ads.zzbin r0 = r7.f22669m     // Catch:{ all -> 0x01fd }
            int r0 = r0.f25378b     // Catch:{ all -> 0x01fd }
            float r0 = (float) r0     // Catch:{ all -> 0x01fd }
            android.util.DisplayMetrics r4 = r7.f22666j     // Catch:{ all -> 0x01fd }
            float r4 = r4.density     // Catch:{ all -> 0x01fd }
            float r0 = r0 / r4
            float r4 = (float) r5     // Catch:{ all -> 0x01fd }
            android.util.DisplayMetrics r5 = r7.f22666j     // Catch:{ all -> 0x01fd }
            float r5 = r5.density     // Catch:{ all -> 0x01fd }
            float r4 = r4 / r5
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0170
            goto L_0x0171
        L_0x0170:
            r3 = 0
        L_0x0171:
            if (r2 == 0) goto L_0x0175
            r2 = r3
            goto L_0x0178
        L_0x0175:
            goto L_0x0178
        L_0x0177:
        L_0x0178:
            r0 = 8
            if (r2 == 0) goto L_0x01e2
            com.google.android.gms.internal.ads.zzbin r2 = r7.f22669m     // Catch:{ all -> 0x01fd }
            int r2 = r2.f25379c     // Catch:{ all -> 0x01fd }
            float r2 = (float) r2     // Catch:{ all -> 0x01fd }
            android.util.DisplayMetrics r3 = r7.f22666j     // Catch:{ all -> 0x01fd }
            float r3 = r3.density     // Catch:{ all -> 0x01fd }
            float r2 = r2 / r3
            int r2 = (int) r2     // Catch:{ all -> 0x01fd }
            com.google.android.gms.internal.ads.zzbin r3 = r7.f22669m     // Catch:{ all -> 0x01fd }
            int r3 = r3.f25378b     // Catch:{ all -> 0x01fd }
            float r3 = (float) r3     // Catch:{ all -> 0x01fd }
            android.util.DisplayMetrics r4 = r7.f22666j     // Catch:{ all -> 0x01fd }
            float r4 = r4.density     // Catch:{ all -> 0x01fd }
            float r3 = r3 / r4
            int r3 = (int) r3     // Catch:{ all -> 0x01fd }
            float r8 = (float) r8     // Catch:{ all -> 0x01fd }
            android.util.DisplayMetrics r4 = r7.f22666j     // Catch:{ all -> 0x01fd }
            float r4 = r4.density     // Catch:{ all -> 0x01fd }
            float r8 = r8 / r4
            int r8 = (int) r8     // Catch:{ all -> 0x01fd }
            float r9 = (float) r9     // Catch:{ all -> 0x01fd }
            android.util.DisplayMetrics r4 = r7.f22666j     // Catch:{ all -> 0x01fd }
            float r4 = r4.density     // Catch:{ all -> 0x01fd }
            float r9 = r9 / r4
            int r9 = (int) r9     // Catch:{ all -> 0x01fd }
            r4 = 103(0x67, float:1.44E-43)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01fd }
            r5.<init>(r4)     // Catch:{ all -> 0x01fd }
            java.lang.String r4 = "Not enough space to show ad. Needs "
            r5.append(r4)     // Catch:{ all -> 0x01fd }
            r5.append(r2)     // Catch:{ all -> 0x01fd }
            java.lang.String r2 = "x"
            r5.append(r2)     // Catch:{ all -> 0x01fd }
            r5.append(r3)     // Catch:{ all -> 0x01fd }
            java.lang.String r2 = " dp, but only has "
            r5.append(r2)     // Catch:{ all -> 0x01fd }
            r5.append(r8)     // Catch:{ all -> 0x01fd }
            java.lang.String r8 = "x"
            r5.append(r8)     // Catch:{ all -> 0x01fd }
            r5.append(r9)     // Catch:{ all -> 0x01fd }
            java.lang.String r8 = " dp."
            r5.append(r8)     // Catch:{ all -> 0x01fd }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x01fd }
            com.google.android.gms.internal.ads.zzbad.m26359d(r8)     // Catch:{ all -> 0x01fd }
            int r8 = r7.getVisibility()     // Catch:{ all -> 0x01fd }
            if (r8 == r0) goto L_0x01dd
            r8 = 4
            r7.setVisibility(r8)     // Catch:{ all -> 0x01fd }
        L_0x01dd:
            r7.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01fd }
            monitor-exit(r7)
            return
        L_0x01e2:
            int r8 = r7.getVisibility()     // Catch:{ all -> 0x01fd }
            if (r8 == r0) goto L_0x01eb
            r7.setVisibility(r1)     // Catch:{ all -> 0x01fd }
        L_0x01eb:
            com.google.android.gms.internal.ads.zzbin r8 = r7.f22669m     // Catch:{ all -> 0x01fd }
            int r8 = r8.f25379c     // Catch:{ all -> 0x01fd }
            com.google.android.gms.internal.ads.zzbin r9 = r7.f22669m     // Catch:{ all -> 0x01fd }
            int r9 = r9.f25378b     // Catch:{ all -> 0x01fd }
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01fd }
            monitor-exit(r7)
            return
        L_0x01f8:
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01fd }
            monitor-exit(r7)
            return
        L_0x01fd:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.C9534kf.onMeasure(int, int):void");
    }

    public final void onGlobalLayout() {
        boolean L = m23743L();
        zzd i = mo28758i();
        if (i != null && L) {
            i.zztk();
        }
    }

    /* renamed from: b */
    public final synchronized void mo28738b(zzd zzd) {
        this.f22668l = zzd;
    }

    /* renamed from: a */
    public final void mo28719a(IObjectWrapper iObjectWrapper) {
        this.f22653J.set(iObjectWrapper);
    }

    /* renamed from: a */
    public final synchronized void mo28718a(zzd zzd) {
        this.f22651H = zzd;
    }

    /* renamed from: a */
    public final synchronized void mo28723a(zzbin zzbin) {
        this.f22669m = zzbin;
        requestLayout();
    }

    /* renamed from: e */
    public final synchronized void mo28749e(boolean z) {
        boolean z2 = z != this.f22672p;
        this.f22672p = z;
        m23745N();
        if (z2) {
            new zzaqb(this).mo29994c(z ? "expanded" : BuildConfig.APTOIDE_THEME);
        }
    }

    /* renamed from: p */
    public final void mo28779p() {
        this.f22652I.mo30310c();
    }

    /* access modifiers changed from: protected */
    public final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.f22652I.mo30307a();
        }
        boolean z = this.f22679w;
        if (this.f22661e != null && this.f22661e.mo30666j()) {
            if (!this.f22680x) {
                this.f22661e.mo30667k();
                this.f22661e.mo30668l();
                this.f22680x = true;
            }
            m23743L();
            z = true;
        }
        m23753h(z);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        synchronized (this) {
            if (!isDestroyed()) {
                this.f22652I.mo30309b();
            }
            super.onDetachedFromWindow();
            if (this.f22680x && this.f22661e != null && this.f22661e.mo30666j() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.f22661e.mo30667k();
                this.f22661e.mo30668l();
                this.f22680x = false;
            }
        }
        m23753h(false);
    }

    /* renamed from: a */
    public final void mo28716a(Context context) {
        this.f22660d.setBaseContext(context);
        this.f22652I.mo30308a(this.f22660d.mo30645b());
    }

    /* renamed from: d */
    public final synchronized void mo28745d(boolean z) {
        if (this.f22668l != null) {
            this.f22668l.zza(this.f22661e.mo30608b(), z);
        } else {
            this.f22671o = z;
        }
    }

    /* renamed from: y */
    public final void mo28792y() {
    }

    public final synchronized void setRequestedOrientation(int i) {
        this.f22674r = i;
        if (this.f22668l != null) {
            this.f22668l.setRequestedOrientation(this.f22674r);
        }
    }

    /* renamed from: q */
    public final Activity mo28780q() {
        return this.f22660d.mo30645b();
    }

    /* renamed from: f */
    public final Context mo28751f() {
        return this.f22660d.mo30644a();
    }

    /* renamed from: N */
    private final synchronized void m23745N() {
        if (!this.f22672p) {
            if (!this.f22669m.mo30650e()) {
                if (VERSION.SDK_INT < 18) {
                    zzbad.m26352a("Disabling hardware acceleration on an AdView.");
                    m23746O();
                    return;
                }
                zzbad.m26352a("Enabling hardware acceleration on an AdView.");
                m23747P();
                return;
            }
        }
        zzbad.m26352a("Enabling hardware acceleration on an overlay.");
        m23747P();
    }

    /* renamed from: O */
    private final synchronized void m23746O() {
        if (!this.f22673q) {
            zzk.zzli();
            setLayerType(1, null);
        }
        this.f22673q = true;
    }

    /* renamed from: P */
    private final synchronized void m23747P() {
        if (this.f22673q) {
            zzk.zzli();
            setLayerType(0, null);
        }
        this.f22673q = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public final synchronized void mo29038g(boolean z) {
        if (!z) {
            m23749R();
            this.f22652I.mo30311d();
            if (this.f22668l != null) {
                this.f22668l.close();
                this.f22668l.onDestroy();
                this.f22668l = null;
            }
        }
        this.f22653J.set(null);
        this.f22661e.mo30665i();
        zzk.zzmc();
        zzbfs.m26706a((zzbdf) this);
        m23748Q();
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public final void onDraw(Canvas canvas) {
        if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
            super.onDraw(canvas);
        }
    }

    /* renamed from: r */
    public final void mo28781r() {
        if (this.f22648E == null) {
            this.f22648E = zzadb.m24798a(this.f22649F.mo29614a());
            this.f22649F.mo29615a("native:view_load", this.f22648E);
        }
    }

    public final void onPause() {
        try {
            super.onPause();
        } catch (Exception e) {
            zzbad.m26356b("Could not pause webview.", e);
        }
    }

    public final void onResume() {
        try {
            super.onResume();
        } catch (Exception e) {
            zzbad.m26356b("Could not resume webview.", e);
        }
    }

    /* renamed from: j */
    public final void mo28760j() {
        zzawz.m26003f("Cannot add text view to inner AdWebView");
    }

    /* renamed from: a */
    public final void mo28731a(boolean z) {
        this.f22661e.mo30663c(z);
    }

    public final void stopLoading() {
        try {
            super.stopLoading();
        } catch (Exception e) {
            zzbad.m26356b("Could not stop loading webview.", e);
        }
    }

    /* renamed from: b */
    public final synchronized void mo28741b(boolean z) {
        this.f22675s = z;
    }

    /* renamed from: A */
    public final synchronized boolean mo28705A() {
        return this.f22675s;
    }

    public final synchronized void zzlc() {
        this.f22676t = true;
        if (this.f22664h != null) {
            this.f22664h.zzlc();
        }
    }

    public final synchronized void zzld() {
        this.f22676t = false;
        if (this.f22664h != null) {
            this.f22664h.zzld();
        }
    }

    /* renamed from: Q */
    private final synchronized void m23748Q() {
        if (this.f22658O != null) {
            for (zzbft a : this.f22658O.values()) {
                a.mo27353a();
            }
        }
        this.f22658O = null;
    }

    /* renamed from: a */
    public final synchronized void mo28727a(String str, zzbft zzbft) {
        if (this.f22658O == null) {
            this.f22658O = new HashMap();
        }
        this.f22658O.put(str, zzbft);
    }

    /* renamed from: b */
    public final synchronized zzbft mo28736b(String str) {
        if (this.f22658O == null) {
            return null;
        }
        return (zzbft) this.f22658O.get(str);
    }

    /* renamed from: F */
    public final synchronized String mo28710F() {
        return this.f22677u;
    }

    /* renamed from: E */
    public final zzbcw mo28709E() {
        return null;
    }

    /* renamed from: G */
    public final zzadg mo28711G() {
        return this.f22647D;
    }

    /* renamed from: B */
    public final zzadh mo28706B() {
        return this.f22649F;
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.f22650G = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    /* renamed from: a */
    public final synchronized void mo28721a(zzadx zzadx) {
        this.f22681y = zzadx;
    }

    /* renamed from: u */
    public final synchronized zzadx mo28788u() {
        return this.f22681y;
    }

    /* renamed from: C */
    public final synchronized void mo28707C() {
        if (this.f22682z != null) {
            this.f22682z.mo29638hb();
        }
    }

    /* renamed from: a */
    public final synchronized void mo28720a(zzadv zzadv) {
        this.f22682z = zzadv;
    }

    /* renamed from: g */
    public final synchronized zzbhq mo28754g() {
        return this.f22678v;
    }

    /* renamed from: a */
    public final synchronized void mo28722a(zzbhq zzbhq) {
        if (this.f22678v != null) {
            zzbad.m26355b("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.f22678v = zzbhq;
        }
    }

    /* renamed from: n */
    public final synchronized boolean mo28767n() {
        return this.f22644A > 0;
    }

    /* renamed from: c */
    public final synchronized void mo28744c(boolean z) {
        this.f22644A += z ? 1 : -1;
        if (this.f22644A <= 0 && this.f22668l != null) {
            this.f22668l.zztn();
        }
    }

    /* renamed from: R */
    private final void m23749R() {
        zzadh zzadh = this.f22649F;
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
        this.f22661e.mo30662b(z);
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
        this.f22661e.mo30654a(zzc);
    }

    /* renamed from: b */
    public final void mo28742b(boolean z, int i) {
        this.f22661e.mo30658a(z, i);
    }

    /* renamed from: a */
    public final void mo28732a(boolean z, int i, String str) {
        this.f22661e.mo30659a(z, i, str);
    }

    /* renamed from: a */
    public final void mo28733a(boolean z, int i, String str, String str2) {
        this.f22661e.mo30660a(z, i, str, str2);
    }

    /* renamed from: a */
    public final void mo28694a(zzud zzud) {
        synchronized (this) {
            this.f22679w = zzud.f29465m;
        }
        m23753h(zzud.f29465m);
    }

    /* renamed from: h */
    private final void m23753h(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
        zzajr.m25123a((zzajq) this, "onAdVisibilityChanged", (Map) hashMap);
    }

    /* renamed from: a */
    public final void mo28726a(String str, zzaho<? super zzbgz> zzaho) {
        zzbio zzbio = this.f22661e;
        if (zzbio != null) {
            zzbio.mo30657a(str, zzaho);
        }
    }

    /* renamed from: b */
    public final void mo28739b(String str, zzaho<? super zzbgz> zzaho) {
        zzbio zzbio = this.f22661e;
        if (zzbio != null) {
            zzbio.mo30661b(str, zzaho);
        }
    }

    /* renamed from: a */
    public final void mo28725a(String str, Predicate<zzaho<? super zzbgz>> predicate) {
        zzbio zzbio = this.f22661e;
        if (zzbio != null) {
            zzbio.mo30656a(str, predicate);
        }
    }

    /* renamed from: a */
    public final boolean mo28735a(boolean z, int i) {
        destroy();
        this.f22667k.mo32329a((zzwk) new C9556lf(z, i));
        this.f22667k.mo32330a(zzb.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    /* renamed from: k */
    public final boolean mo28761k() {
        return false;
    }

    /* renamed from: a */
    public final /* synthetic */ zzbii mo28714a() {
        return this.f22661e;
    }

    /* renamed from: a */
    static final /* synthetic */ void m23752a(boolean z, int i, zzxn zzxn) {
        zzv.zza m = zzv.m31474m();
        if (m.mo32358m() != z) {
            m.mo32357a(z);
        }
        m.mo32356a(i);
        zzxn.f29697n = (zzv) m.mo31612g();
    }
}
