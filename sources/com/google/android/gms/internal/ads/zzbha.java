package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.p000v4.view.C0646w;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.mopub.common.Constants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

@VisibleForTesting
@zzard
public class zzbha extends WebViewClient implements zzbii {

    /* renamed from: a */
    private static final String[] f25327a = {"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};

    /* renamed from: b */
    private static final String[] f25328b = {"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};

    /* renamed from: A */
    private OnAttachStateChangeListener f25329A;

    /* renamed from: c */
    protected zzbgz f25330c;

    /* renamed from: d */
    private final zzwj f25331d;

    /* renamed from: e */
    private final HashMap<String, List<zzaho<? super zzbgz>>> f25332e;

    /* renamed from: f */
    private final Object f25333f;

    /* renamed from: g */
    private zzxr f25334g;

    /* renamed from: h */
    private zzo f25335h;

    /* renamed from: i */
    private zzbij f25336i;

    /* renamed from: j */
    private zzbik f25337j;

    /* renamed from: k */
    private zzagv f25338k;

    /* renamed from: l */
    private zzagx f25339l;

    /* renamed from: m */
    private zzbil f25340m;

    /* renamed from: n */
    private boolean f25341n;

    /* renamed from: o */
    private boolean f25342o;

    /* renamed from: p */
    private boolean f25343p;

    /* renamed from: q */
    private boolean f25344q;

    /* renamed from: r */
    private zzu f25345r;

    /* renamed from: s */
    private final zzaqa f25346s;

    /* renamed from: t */
    private zzb f25347t;

    /* renamed from: u */
    private zzapr f25348u;

    /* renamed from: v */
    protected zzavb f25349v;

    /* renamed from: w */
    private boolean f25350w;

    /* renamed from: x */
    private boolean f25351x;

    /* renamed from: y */
    private int f25352y;

    /* renamed from: z */
    private boolean f25353z;

    public zzbha(zzbgz zzbgz, zzwj zzwj, boolean z) {
        this(zzbgz, zzwj, z, new zzaqa(zzbgz, zzbgz.mo28751f(), new zzacf(zzbgz.getContext())), null);
    }

    @VisibleForTesting
    private zzbha(zzbgz zzbgz, zzwj zzwj, boolean z, zzaqa zzaqa, zzapr zzapr) {
        this.f25332e = new HashMap<>();
        this.f25333f = new Object();
        this.f25341n = false;
        this.f25331d = zzwj;
        this.f25330c = zzbgz;
        this.f25342o = z;
        this.f25346s = zzaqa;
        this.f25348u = null;
    }

    /* renamed from: a */
    public final void mo30594a(int i, int i2, boolean z) {
        this.f25346s.mo29988a(i, i2);
        zzapr zzapr = this.f25348u;
        if (zzapr != null) {
            zzapr.mo29976a(i, i2, false);
        }
    }

    /* renamed from: a */
    public final void mo30599a(zzxr zzxr, zzagv zzagv, zzo zzo, zzagx zzagx, zzu zzu, boolean z, zzahp zzahp, zzb zzb, zzaqc zzaqc, zzavb zzavb) {
        if (zzb == null) {
            zzb = new zzb(this.f25330c.getContext(), zzavb, null);
        }
        this.f25348u = new zzapr(this.f25330c, zzaqc);
        this.f25349v = zzavb;
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24066bb)).booleanValue()) {
            mo30601a("/adMetadata", (zzaho<? super zzbgz>) new zzagu<Object>(zzagv));
        }
        mo30601a("/appEvent", (zzaho<? super zzbgz>) new zzagw<Object>(zzagx));
        mo30601a("/backButton", zzagz.f24330j);
        mo30601a("/refresh", zzagz.f24331k);
        mo30601a("/canOpenURLs", zzagz.f24321a);
        mo30601a("/canOpenIntents", zzagz.f24322b);
        mo30601a("/click", zzagz.f24323c);
        mo30601a("/close", zzagz.f24324d);
        mo30601a("/customClose", zzagz.f24325e);
        mo30601a("/instrument", zzagz.f24334n);
        mo30601a("/delayPageLoaded", zzagz.f24336p);
        mo30601a("/delayPageClosed", zzagz.f24337q);
        mo30601a("/getLocationInfo", zzagz.f24338r);
        mo30601a("/httpTrack", zzagz.f24326f);
        mo30601a("/log", zzagz.f24327g);
        mo30601a("/mraid", (zzaho<? super zzbgz>) new zzahr<Object>(zzb, this.f25348u, zzaqc));
        mo30601a("/mraidLoaded", (zzaho<? super zzbgz>) this.f25346s);
        mo30601a("/open", (zzaho<? super zzbgz>) new zzahs<Object>(zzb, this.f25348u));
        mo30601a("/precache", (zzaho<? super zzbgz>) new zzbgc<Object>());
        mo30601a("/touch", zzagz.f24329i);
        mo30601a("/video", zzagz.f24332l);
        mo30601a("/videoMeta", zzagz.f24333m);
        if (zzk.zzme().mo30134f(this.f25330c.getContext())) {
            mo30601a("/logScionEvent", (zzaho<? super zzbgz>) new zzahq<Object>(this.f25330c.getContext()));
        }
        this.f25334g = zzxr;
        this.f25335h = zzo;
        this.f25338k = zzagv;
        this.f25339l = zzagx;
        this.f25345r = zzu;
        this.f25347t = zzb;
        this.f25341n = z;
    }

    /* renamed from: d */
    public final zzb mo30611d() {
        return this.f25347t;
    }

    /* renamed from: b */
    public final boolean mo30608b() {
        boolean z;
        synchronized (this.f25333f) {
            z = this.f25342o;
        }
        return z;
    }

    /* renamed from: j */
    public final boolean mo30617j() {
        boolean z;
        synchronized (this.f25333f) {
            z = this.f25343p;
        }
        return z;
    }

    /* renamed from: k */
    public final OnGlobalLayoutListener mo30618k() {
        synchronized (this.f25333f) {
        }
        return null;
    }

    /* renamed from: l */
    public final OnScrollChangedListener mo30619l() {
        synchronized (this.f25333f) {
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        if (r1 == null) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        r1.mo28640a();
        r0.f25337j = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        m26845n();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r0.f25350w = true;
        r1 = r0.f25337j;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageFinished(android.webkit.WebView r1, java.lang.String r2) {
        /*
            r0 = this;
            java.lang.Object r1 = r0.f25333f
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzbgz r2 = r0.f25330c     // Catch:{ all -> 0x002a }
            boolean r2 = r2.isDestroyed()     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x0017
            java.lang.String r2 = "Blank page loaded, 1..."
            com.google.android.gms.internal.ads.zzawz.m26003f(r2)     // Catch:{ all -> 0x002a }
            com.google.android.gms.internal.ads.zzbgz r2 = r0.f25330c     // Catch:{ all -> 0x002a }
            r2.mo28792y()     // Catch:{ all -> 0x002a }
            monitor-exit(r1)     // Catch:{ all -> 0x002a }
            return
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x002a }
            r1 = 1
            r0.f25350w = r1
            com.google.android.gms.internal.ads.zzbik r1 = r0.f25337j
            if (r1 == 0) goto L_0x0026
            r1.mo28640a()
            r1 = 0
            r0.f25337j = r1
        L_0x0026:
            r0.m26845n()
            return
        L_0x002a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x002a }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbha.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m26840a(View view, zzavb zzavb, int i) {
        if (zzavb.mo30111c() && i > 0) {
            zzavb.mo30104a(view);
            if (zzavb.mo30111c()) {
                zzaxi.f24961a.postDelayed(new C9100Re(this, view, zzavb, i), 100);
            }
        }
    }

    /* renamed from: m */
    private final void m26844m() {
        if (this.f25329A != null) {
            this.f25330c.getView().removeOnAttachStateChangeListener(this.f25329A);
        }
    }

    /* renamed from: f */
    public final void mo30613f() {
        zzavb zzavb = this.f25349v;
        if (zzavb != null) {
            WebView webView = this.f25330c.getWebView();
            if (C0646w.m2986t(webView)) {
                m26840a((View) webView, zzavb, 10);
                return;
            }
            m26844m();
            this.f25329A = new C9121Se(this, zzavb);
            this.f25330c.getView().addOnAttachStateChangeListener(this.f25329A);
        }
    }

    /* renamed from: g */
    public final void mo30614g() {
        synchronized (this.f25333f) {
            this.f25344q = true;
        }
        this.f25352y++;
        m26845n();
    }

    /* renamed from: h */
    public final void mo30615h() {
        this.f25352y--;
        m26845n();
    }

    /* renamed from: a */
    public final void mo30592a() {
        this.f25351x = true;
        m26845n();
    }

    /* renamed from: n */
    private final void m26845n() {
        if (this.f25336i != null && ((this.f25350w && this.f25352y <= 0) || this.f25351x)) {
            this.f25336i.mo26660a(!this.f25351x);
            this.f25336i = null;
        }
        this.f25330c.mo28781r();
    }

    /* renamed from: a */
    public final void mo30596a(zzc zzc) {
        boolean x = this.f25330c.mo28791x();
        AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(zzc, (!x || this.f25330c.mo28766m().mo30650e()) ? this.f25334g : null, x ? null : this.f25335h, this.f25345r, this.f25330c.mo28793z());
        m26841a(adOverlayInfoParcel);
    }

    /* renamed from: a */
    public final void mo30603a(boolean z, int i) {
        zzxr zzxr = (!this.f25330c.mo28791x() || this.f25330c.mo28766m().mo30650e()) ? this.f25334g : null;
        zzo zzo = this.f25335h;
        zzu zzu = this.f25345r;
        zzbgz zzbgz = this.f25330c;
        AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(zzxr, zzo, zzu, zzbgz, z, i, zzbgz.mo28793z());
        m26841a(adOverlayInfoParcel);
    }

    /* renamed from: a */
    public final void mo30604a(boolean z, int i, String str) {
        zzo zzo;
        boolean x = this.f25330c.mo28791x();
        zzxr zzxr = (!x || this.f25330c.mo28766m().mo30650e()) ? this.f25334g : null;
        if (x) {
            zzo = null;
        } else {
            zzo = new C9146Te(this.f25330c, this.f25335h);
        }
        zzagv zzagv = this.f25338k;
        zzagx zzagx = this.f25339l;
        zzu zzu = this.f25345r;
        zzbgz zzbgz = this.f25330c;
        AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(zzxr, zzo, zzagv, zzagx, zzu, zzbgz, z, i, str, zzbgz.mo28793z());
        m26841a(adOverlayInfoParcel);
    }

    /* renamed from: a */
    public final void mo30605a(boolean z, int i, String str, String str2) {
        zzo zzo;
        boolean x = this.f25330c.mo28791x();
        zzxr zzxr = (!x || this.f25330c.mo28766m().mo30650e()) ? this.f25334g : null;
        if (x) {
            zzo = null;
        } else {
            zzo = new C9146Te(this.f25330c, this.f25335h);
        }
        zzagv zzagv = this.f25338k;
        zzagx zzagx = this.f25339l;
        zzu zzu = this.f25345r;
        zzbgz zzbgz = this.f25330c;
        AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(zzxr, zzo, zzagv, zzagx, zzu, zzbgz, z, i, str, str2, zzbgz.mo28793z());
        m26841a(adOverlayInfoParcel);
    }

    /* renamed from: a */
    private final void m26841a(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z;
        zzapr zzapr = this.f25348u;
        boolean z2 = false;
        if (zzapr != null) {
            z = zzapr.mo29979a();
        } else {
            z = false;
        }
        zzk.zzlf();
        Context context = this.f25330c.getContext();
        if (!z) {
            z2 = true;
        }
        zzm.zza(context, adOverlayInfoParcel, z2);
        if (this.f25349v != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null) {
                zzc zzc = adOverlayInfoParcel.zzdkl;
                if (zzc != null) {
                    str = zzc.url;
                }
            }
            this.f25349v.mo30105a(str);
        }
    }

    /* renamed from: a */
    public final void mo30601a(String str, zzaho<? super zzbgz> zzaho) {
        synchronized (this.f25333f) {
            List list = (List) this.f25332e.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.f25332e.put(str, list);
            }
            list.add(zzaho);
        }
    }

    /* renamed from: b */
    public final void mo30606b(String str, zzaho<? super zzbgz> zzaho) {
        synchronized (this.f25333f) {
            List list = (List) this.f25332e.get(str);
            if (list != null) {
                list.remove(zzaho);
            }
        }
    }

    /* renamed from: a */
    public final void mo30600a(String str, Predicate<zzaho<? super zzbgz>> predicate) {
        synchronized (this.f25333f) {
            List<zzaho> list = (List) this.f25332e.get(str);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (zzaho zzaho : list) {
                    if (predicate.apply(zzaho)) {
                        arrayList.add(zzaho);
                    }
                }
                list.removeAll(arrayList);
            }
        }
    }

    /* renamed from: i */
    public final void mo30616i() {
        zzavb zzavb = this.f25349v;
        if (zzavb != null) {
            zzavb.mo30103a();
            this.f25349v = null;
        }
        m26844m();
        synchronized (this.f25333f) {
            this.f25332e.clear();
            this.f25334g = null;
            this.f25335h = null;
            this.f25336i = null;
            this.f25337j = null;
            this.f25338k = null;
            this.f25339l = null;
            this.f25341n = false;
            this.f25342o = false;
            this.f25343p = false;
            this.f25344q = false;
            this.f25345r = null;
            this.f25340m = null;
            if (this.f25348u != null) {
                this.f25348u.mo29978a(true);
                this.f25348u = null;
            }
        }
    }

    /* renamed from: a */
    public final void mo30597a(zzbij zzbij) {
        this.f25336i = zzbij;
    }

    /* renamed from: a */
    public final void mo30598a(zzbik zzbik) {
        this.f25337j = zzbik;
    }

    public final void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        String str2 = "Loading resource: ";
        zzawz.m26003f(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme())) {
            if ("mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
                mo30595a(parse);
            }
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        String str3;
        if (i < 0) {
            int i2 = (-i) - 1;
            String[] strArr = f25327a;
            if (i2 < strArr.length) {
                str3 = strArr[i2];
                m26839a(this.f25330c.getContext(), "http_err", str3, str2);
                super.onReceivedError(webView, i, str, str2);
            }
        }
        str3 = String.valueOf(i);
        m26839a(this.f25330c.getContext(), "http_err", str3, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String str;
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            if (primaryError >= 0) {
                String[] strArr = f25328b;
                if (primaryError < strArr.length) {
                    str = strArr[primaryError];
                    Context context = this.f25330c.getContext();
                    zzk.zzli();
                    m26839a(context, "ssl_err", str, sslError.getUrl());
                }
            }
            str = String.valueOf(primaryError);
            Context context2 = this.f25330c.getContext();
            zzk.zzli();
            m26839a(context2, "ssl_err", str, sslError.getUrl());
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    /* renamed from: a */
    private final void m26839a(Context context, String str, String str2, String str3) {
        String str4;
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24018Ub)).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("err", str);
            bundle.putString("code", str2);
            if (!TextUtils.isEmpty(str3)) {
                Uri parse = Uri.parse(str3);
                if (parse.getHost() != null) {
                    str4 = parse.getHost();
                    bundle.putString("host", str4);
                    zzk.zzlg().mo30232a(context, this.f25330c.mo28793z().f25057a, "gmob-apps", bundle, true);
                }
            }
            str4 = "";
            bundle.putString("host", str4);
            zzk.zzlg().mo30232a(context, this.f25330c.mo28793z().f25057a, "gmob-apps", bundle, true);
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        String str2 = "AdWebView shouldOverrideUrlLoading: ";
        zzawz.m26003f(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme())) {
            if ("mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
                mo30595a(parse);
                return true;
            }
        }
        if (this.f25341n && webView == this.f25330c.getWebView()) {
            String scheme = parse.getScheme();
            if (Constants.HTTP.equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                zzxr zzxr = this.f25334g;
                if (zzxr != null) {
                    zzxr.onAdClicked();
                    zzavb zzavb = this.f25349v;
                    if (zzavb != null) {
                        zzavb.mo30105a(str);
                    }
                    this.f25334g = null;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        }
        if (!this.f25330c.getWebView().willNotDraw()) {
            try {
                zzdh e = this.f25330c.mo28748e();
                if (e != null && e.mo31485a(parse)) {
                    parse = e.mo31482a(parse, this.f25330c.getContext(), this.f25330c.getView(), this.f25330c.mo28780q());
                }
            } catch (zzdi e2) {
                String str3 = "Unable to append parameter to URL: ";
                String valueOf2 = String.valueOf(str);
                zzbad.m26359d(valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
            }
            zzb zzb = this.f25347t;
            if (zzb == null || zzb.zzkx()) {
                zzc zzc = new zzc("android.intent.action.VIEW", parse.toString(), null, null, null, null, null);
                mo30596a(zzc);
            } else {
                this.f25347t.zzbk(str);
            }
        } else {
            String str4 = "AdWebView unable to handle URL: ";
            String valueOf3 = String.valueOf(str);
            zzbad.m26359d(valueOf3.length() != 0 ? str4.concat(valueOf3) : new String(str4));
        }
        return true;
    }

    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return mo30591a(str, Collections.emptyMap());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final WebResourceResponse mo30591a(String str, Map<String, String> map) {
        String str2 = "";
        try {
            String a = zzavx.m25931a(str, this.f25330c.getContext(), this.f25353z);
            if (!a.equals(str)) {
                return m26843b(a, map);
            }
            zzvv a2 = zzvv.m31317a(str);
            if (a2 != null) {
                zzvs a3 = zzk.zzlm().mo32314a(a2);
                if (a3 != null && a3.mo32317a()) {
                    return new WebResourceResponse(str2, str2, a3.mo32318c());
                }
            }
            if (zzazx.m26334a()) {
                if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23946Ib)).booleanValue()) {
                    return m26843b(str, map);
                }
            }
            return null;
        } catch (Exception | NoClassDefFoundError e) {
            zzk.zzlk().mo30168a(e, "AdWebViewClient.interceptRequest");
            return m26846o();
        }
    }

    /* renamed from: o */
    private static WebResourceResponse m26846o() {
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f24011Ta)).booleanValue()) {
            return null;
        }
        String str = "";
        return new WebResourceResponse(str, str, new ByteArrayInputStream(new byte[0]));
    }

    /* renamed from: b */
    private final WebResourceResponse m26843b(String str, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        int i = 0;
        while (true) {
            i++;
            if (i <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                for (Entry entry : map.entrySet()) {
                    openConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                if (openConnection instanceof HttpURLConnection) {
                    httpURLConnection = (HttpURLConnection) openConnection;
                    zzk.zzlg().mo30233a(this.f25330c.getContext(), this.f25330c.mo28793z().f25057a, false, httpURLConnection);
                    zzazx zzazx = new zzazx();
                    zzazx.mo30319a(httpURLConnection, (byte[]) null);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzazx.mo30318a(httpURLConnection, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        zzk.zzlg();
                    } else {
                        String headerField = httpURLConnection.getHeaderField("Location");
                        if (headerField != null) {
                            URL url2 = new URL(url, headerField);
                            String protocol = url2.getProtocol();
                            if (protocol == null) {
                                zzbad.m26359d("Protocol is null");
                                return m26846o();
                            } else if (protocol.equals(Constants.HTTP) || protocol.equals("https")) {
                                String str2 = "Redirecting to ";
                                String valueOf = String.valueOf(headerField);
                                zzbad.m26352a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                                httpURLConnection.disconnect();
                                url = url2;
                            } else {
                                String str3 = "Unsupported scheme: ";
                                String valueOf2 = String.valueOf(protocol);
                                zzbad.m26359d(valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
                                return m26846o();
                            }
                        } else {
                            throw new IOException("Missing Location header in redirect");
                        }
                    }
                } else {
                    throw new IOException("Invalid protocol.");
                }
            } else {
                StringBuilder sb = new StringBuilder(32);
                sb.append("Too many redirects (20)");
                throw new IOException(sb.toString());
            }
        }
        zzk.zzlg();
        return zzaxi.m26101a(httpURLConnection);
    }

    /* renamed from: b */
    public final void mo30607b(boolean z) {
        this.f25341n = z;
    }

    /* renamed from: c */
    public final zzavb mo30609c() {
        return this.f25349v;
    }

    /* renamed from: e */
    public final void mo30612e() {
        synchronized (this.f25333f) {
            this.f25341n = false;
            this.f25342o = true;
            zzbbm.f25064a.execute(new C9080Qe(this));
        }
    }

    /* renamed from: c */
    public final void mo30610c(boolean z) {
        this.f25353z = z;
    }

    /* renamed from: a */
    public final void mo30593a(int i, int i2) {
        zzapr zzapr = this.f25348u;
        if (zzapr != null) {
            zzapr.mo29975a(i, i2);
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (!(keyCode == 79 || keyCode == 222)) {
            switch (keyCode) {
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                    break;
                default:
                    switch (keyCode) {
                        case Opcodes.IAND /*126*/:
                        case Opcodes.LAND /*127*/:
                        case 128:
                        case Opcodes.LOR /*129*/:
                        case Opcodes.IXOR /*130*/:
                            break;
                        default:
                            return false;
                    }
            }
        }
        return true;
    }

    /* renamed from: a */
    public final void mo30595a(Uri uri) {
        String path = uri.getPath();
        List<zzaho> list = (List) this.f25332e.get(path);
        if (list != null) {
            zzk.zzlg();
            Map a = zzaxi.m26107a(uri);
            if (zzbad.m26354a(2)) {
                String str = "Received GMSG: ";
                String valueOf = String.valueOf(path);
                zzawz.m26003f(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                for (String str2 : a.keySet()) {
                    String str3 = (String) a.get(str2);
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(str3).length());
                    sb.append("  ");
                    sb.append(str2);
                    sb.append(": ");
                    sb.append(str3);
                    zzawz.m26003f(sb.toString());
                }
            }
            for (zzaho a2 : list) {
                a2.mo27996a(this.f25330c, a);
            }
            return;
        }
        String valueOf2 = String.valueOf(uri);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 32);
        sb2.append("No GMSG handler found for GMSG: ");
        sb2.append(valueOf2);
        zzawz.m26003f(sb2.toString());
    }

    /* renamed from: a */
    public final void mo30602a(boolean z) {
        synchronized (this.f25333f) {
            this.f25343p = true;
        }
    }

    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.f25330c.mo28735a(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }
}
