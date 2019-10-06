package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.support.p000v4.view.C0646w;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
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
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map.Entry;

@VisibleForTesting
@zzard
public final class zzbio extends zzbiz implements zzbii {

    /* renamed from: A */
    private OnAttachStateChangeListener f25380A;

    /* renamed from: d */
    protected zzbgz f25381d;

    /* renamed from: e */
    private final zzaju<zzbgz> f25382e = new zzaju<>();

    /* renamed from: f */
    private final Object f25383f = new Object();

    /* renamed from: g */
    private zzxr f25384g;

    /* renamed from: h */
    private zzo f25385h;

    /* renamed from: i */
    private zzbij f25386i;

    /* renamed from: j */
    private zzbik f25387j;

    /* renamed from: k */
    private zzagv f25388k;

    /* renamed from: l */
    private zzagx f25389l;

    /* renamed from: m */
    private zzbil f25390m;

    /* renamed from: n */
    private boolean f25391n = false;

    /* renamed from: o */
    private volatile boolean f25392o;

    /* renamed from: p */
    private boolean f25393p;

    /* renamed from: q */
    private boolean f25394q;

    /* renamed from: r */
    private zzu f25395r;

    /* renamed from: s */
    private zzaqa f25396s;

    /* renamed from: t */
    private zzb f25397t;

    /* renamed from: u */
    private zzapr f25398u;

    /* renamed from: v */
    private zzavb f25399v;

    /* renamed from: w */
    private boolean f25400w;

    /* renamed from: x */
    private boolean f25401x;

    /* renamed from: y */
    private int f25402y;

    /* renamed from: z */
    private boolean f25403z;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo30655a(zzbgz zzbgz, boolean z) {
        zzaqa zzaqa = new zzaqa(zzbgz, zzbgz.mo28751f(), new zzacf(zzbgz.getContext()));
        this.f25381d = zzbgz;
        this.f25392o = z;
        this.f25396s = zzaqa;
        this.f25398u = null;
        this.f25382e.mo29784a(zzbgz);
    }

    /* renamed from: a */
    public final void mo30594a(int i, int i2, boolean z) {
        this.f25396s.mo29988a(i, i2);
        zzapr zzapr = this.f25398u;
        if (zzapr != null) {
            zzapr.mo29976a(i, i2, false);
        }
    }

    /* renamed from: a */
    public final void mo30657a(String str, zzaho<? super zzbgz> zzaho) {
        this.f25382e.mo29786a(str, zzaho);
    }

    /* renamed from: b */
    public final void mo30661b(String str, zzaho<? super zzbgz> zzaho) {
        this.f25382e.mo29789b(str, zzaho);
    }

    /* renamed from: a */
    public final void mo30656a(String str, Predicate<zzaho<? super zzbgz>> predicate) {
        this.f25382e.mo29785a(str, predicate);
    }

    /* renamed from: a */
    public final void mo30599a(zzxr zzxr, zzagv zzagv, zzo zzo, zzagx zzagx, zzu zzu, boolean z, zzahp zzahp, zzb zzb, zzaqc zzaqc, zzavb zzavb) {
        if (zzb == null) {
            zzb = new zzb(this.f25381d.getContext(), zzavb, null);
        }
        this.f25398u = new zzapr(this.f25381d, zzaqc);
        this.f25399v = zzavb;
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24066bb)).booleanValue()) {
            mo30657a("/adMetadata", (zzaho<? super zzbgz>) new zzagu<Object>(zzagv));
        }
        mo30657a("/appEvent", (zzaho<? super zzbgz>) new zzagw<Object>(zzagx));
        mo30657a("/backButton", zzagz.f24330j);
        mo30657a("/refresh", zzagz.f24331k);
        mo30657a("/canOpenURLs", zzagz.f24321a);
        mo30657a("/canOpenIntents", zzagz.f24322b);
        mo30657a("/click", zzagz.f24323c);
        mo30657a("/close", zzagz.f24324d);
        mo30657a("/customClose", zzagz.f24325e);
        mo30657a("/instrument", zzagz.f24334n);
        mo30657a("/delayPageLoaded", zzagz.f24336p);
        mo30657a("/delayPageClosed", zzagz.f24337q);
        mo30657a("/getLocationInfo", zzagz.f24338r);
        mo30657a("/httpTrack", zzagz.f24326f);
        mo30657a("/log", zzagz.f24327g);
        mo30657a("/mraid", (zzaho<? super zzbgz>) new zzahr<Object>(zzb, this.f25398u, zzaqc));
        mo30657a("/mraidLoaded", (zzaho<? super zzbgz>) this.f25396s);
        mo30657a("/open", (zzaho<? super zzbgz>) new zzahs<Object>(zzb, this.f25398u));
        mo30657a("/precache", (zzaho<? super zzbgz>) new zzbgc<Object>());
        mo30657a("/touch", zzagz.f24329i);
        mo30657a("/video", zzagz.f24332l);
        mo30657a("/videoMeta", zzagz.f24333m);
        if (zzk.zzme().mo30134f(this.f25381d.getContext())) {
            mo30657a("/logScionEvent", (zzaho<? super zzbgz>) new zzahq<Object>(this.f25381d.getContext()));
        }
        this.f25384g = zzxr;
        this.f25385h = zzo;
        this.f25388k = zzagv;
        this.f25389l = zzagx;
        this.f25395r = zzu;
        this.f25397t = zzb;
        this.f25391n = z;
    }

    /* renamed from: d */
    public final zzb mo30611d() {
        return this.f25397t;
    }

    /* renamed from: b */
    public final boolean mo30608b() {
        return this.f25392o;
    }

    /* renamed from: j */
    public final boolean mo30666j() {
        boolean z;
        synchronized (this.f25383f) {
            z = this.f25393p;
        }
        return z;
    }

    /* renamed from: k */
    public final OnGlobalLayoutListener mo30667k() {
        synchronized (this.f25383f) {
        }
        return null;
    }

    /* renamed from: l */
    public final OnScrollChangedListener mo30668l() {
        synchronized (this.f25383f) {
        }
        return null;
    }

    /* renamed from: a */
    public final void mo28843a(zzbja zzbja) {
        this.f25400w = true;
        zzbik zzbik = this.f25387j;
        if (zzbik != null) {
            zzbik.mo28640a();
            this.f25387j = null;
        }
        m27028n();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m27023a(View view, zzavb zzavb, int i) {
        if (zzavb.mo30111c() && i > 0) {
            zzavb.mo30104a(view);
            if (zzavb.mo30111c()) {
                zzaxi.f24961a.postDelayed(new C9446gf(this, view, zzavb, i), 100);
            }
        }
    }

    /* renamed from: m */
    private final void m27027m() {
        if (this.f25380A != null) {
            this.f25381d.getView().removeOnAttachStateChangeListener(this.f25380A);
        }
    }

    /* renamed from: f */
    public final void mo30613f() {
        zzavb zzavb = this.f25399v;
        if (zzavb != null) {
            WebView webView = this.f25381d.getWebView();
            if (C0646w.m2986t(webView)) {
                m27023a((View) webView, zzavb, 10);
                return;
            }
            m27027m();
            this.f25380A = new C9468hf(this, zzavb);
            this.f25381d.getView().addOnAttachStateChangeListener(this.f25380A);
        }
    }

    /* renamed from: g */
    public final void mo30614g() {
        synchronized (this.f25383f) {
            this.f25394q = true;
        }
        this.f25402y++;
        m27028n();
    }

    /* renamed from: h */
    public final void mo30615h() {
        this.f25402y--;
        m27028n();
    }

    /* renamed from: a */
    public final void mo30592a() {
        this.f25401x = true;
        m27028n();
    }

    /* renamed from: n */
    private final void m27028n() {
        if (this.f25386i != null && ((this.f25400w && this.f25402y <= 0) || this.f25401x)) {
            this.f25386i.mo26660a(!this.f25401x);
            this.f25386i = null;
        }
        this.f25381d.mo28781r();
    }

    /* renamed from: a */
    public final void mo30654a(zzc zzc) {
        boolean x = this.f25381d.mo28791x();
        AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(zzc, (!x || this.f25381d.mo28766m().mo30650e()) ? this.f25384g : null, x ? null : this.f25385h, this.f25395r, this.f25381d.mo28793z());
        m27024a(adOverlayInfoParcel);
    }

    /* renamed from: a */
    public final void mo30658a(boolean z, int i) {
        zzxr zzxr = (!this.f25381d.mo28791x() || this.f25381d.mo28766m().mo30650e()) ? this.f25384g : null;
        zzo zzo = this.f25385h;
        zzu zzu = this.f25395r;
        zzbgz zzbgz = this.f25381d;
        AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(zzxr, zzo, zzu, zzbgz, z, i, zzbgz.mo28793z());
        m27024a(adOverlayInfoParcel);
    }

    /* renamed from: a */
    public final void mo30659a(boolean z, int i, String str) {
        zzo zzo;
        boolean x = this.f25381d.mo28791x();
        zzxr zzxr = (!x || this.f25381d.mo28766m().mo30650e()) ? this.f25384g : null;
        if (x) {
            zzo = null;
        } else {
            zzo = new C9490if(this.f25381d, this.f25385h);
        }
        zzagv zzagv = this.f25388k;
        zzagx zzagx = this.f25389l;
        zzu zzu = this.f25395r;
        zzbgz zzbgz = this.f25381d;
        AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(zzxr, zzo, zzagv, zzagx, zzu, zzbgz, z, i, str, zzbgz.mo28793z());
        m27024a(adOverlayInfoParcel);
    }

    /* renamed from: a */
    public final void mo30660a(boolean z, int i, String str, String str2) {
        zzo zzo;
        boolean x = this.f25381d.mo28791x();
        zzxr zzxr = (!x || this.f25381d.mo28766m().mo30650e()) ? this.f25384g : null;
        if (x) {
            zzo = null;
        } else {
            zzo = new C9490if(this.f25381d, this.f25385h);
        }
        zzagv zzagv = this.f25388k;
        zzagx zzagx = this.f25389l;
        zzu zzu = this.f25395r;
        zzbgz zzbgz = this.f25381d;
        AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(zzxr, zzo, zzagv, zzagx, zzu, zzbgz, z, i, str, str2, zzbgz.mo28793z());
        m27024a(adOverlayInfoParcel);
    }

    /* renamed from: a */
    private final void m27024a(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z;
        zzapr zzapr = this.f25398u;
        boolean z2 = false;
        if (zzapr != null) {
            z = zzapr.mo29979a();
        } else {
            z = false;
        }
        zzk.zzlf();
        Context context = this.f25381d.getContext();
        if (!z) {
            z2 = true;
        }
        zzm.zza(context, adOverlayInfoParcel, z2);
        if (this.f25399v != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null) {
                zzc zzc = adOverlayInfoParcel.zzdkl;
                if (zzc != null) {
                    str = zzc.url;
                }
            }
            this.f25399v.mo30105a(str);
        }
    }

    /* renamed from: i */
    public final void mo30665i() {
        zzavb zzavb = this.f25399v;
        if (zzavb != null) {
            zzavb.mo30103a();
            this.f25399v = null;
        }
        m27027m();
        this.f25382e.mo29782a();
        this.f25382e.mo29784a(null);
        synchronized (this.f25383f) {
            this.f25384g = null;
            this.f25385h = null;
            this.f25386i = null;
            this.f25387j = null;
            this.f25388k = null;
            this.f25389l = null;
            this.f25395r = null;
            this.f25390m = null;
            if (this.f25398u != null) {
                this.f25398u.mo29978a(true);
                this.f25398u = null;
            }
        }
    }

    /* renamed from: a */
    public final void mo30597a(zzbij zzbij) {
        this.f25386i = zzbij;
    }

    /* renamed from: a */
    public final void mo30598a(zzbik zzbik) {
        this.f25387j = zzbik;
    }

    /* renamed from: b */
    public final void mo28844b(zzbja zzbja) {
        this.f25382e.mo29787a(zzbja.f25408b);
    }

    /* renamed from: c */
    public final boolean mo28845c(zzbja zzbja) {
        String valueOf = String.valueOf(zzbja.f25407a);
        String str = "AdWebView shouldOverrideUrlLoading: ";
        zzawz.m26003f(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        Uri uri = zzbja.f25408b;
        if (this.f25382e.mo29787a(uri)) {
            return true;
        }
        if (this.f25391n) {
            String scheme = uri.getScheme();
            if (Constants.HTTP.equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                zzxr zzxr = this.f25384g;
                if (zzxr != null) {
                    zzxr.onAdClicked();
                    zzavb zzavb = this.f25399v;
                    if (zzavb != null) {
                        zzavb.mo30105a(zzbja.f25407a);
                    }
                    this.f25384g = null;
                }
                return false;
            }
        }
        if (!this.f25381d.getWebView().willNotDraw()) {
            try {
                zzdh e = this.f25381d.mo28748e();
                if (e != null && e.mo31485a(uri)) {
                    uri = e.mo31482a(uri, this.f25381d.getContext(), this.f25381d.getView(), this.f25381d.mo28780q());
                }
            } catch (zzdi e2) {
                String str2 = "Unable to append parameter to URL: ";
                String valueOf2 = String.valueOf(zzbja.f25407a);
                zzbad.m26359d(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
            }
            zzb zzb = this.f25397t;
            if (zzb == null || zzb.zzkx()) {
                zzc zzc = new zzc("android.intent.action.VIEW", uri.toString(), null, null, null, null, null);
                mo30654a(zzc);
            } else {
                this.f25397t.zzbk(zzbja.f25407a);
            }
        } else {
            String str3 = "AdWebView unable to handle URL: ";
            String valueOf3 = String.valueOf(zzbja.f25407a);
            zzbad.m26359d(valueOf3.length() != 0 ? str3.concat(valueOf3) : new String(str3));
        }
        return true;
    }

    /* renamed from: d */
    public final WebResourceResponse mo30664d(zzbja zzbja) {
        WebResourceResponse webResourceResponse;
        String str;
        String str2 = "";
        zzavb zzavb = this.f25399v;
        if (zzavb != null) {
            zzavb.mo30106a(zzbja.f25407a, zzbja.f25410d, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(zzbja.f25407a).getName())) {
            webResourceResponse = null;
        } else {
            mo30612e();
            if (this.f25381d.mo28766m().mo30650e()) {
                str = (String) zzyt.m31536e().mo29599a(zzacu.f24065ba);
            } else if (this.f25381d.mo28791x()) {
                str = (String) zzyt.m31536e().mo29599a(zzacu.f24058aa);
            } else {
                str = (String) zzyt.m31536e().mo29599a(zzacu.f24046Z);
            }
            zzk.zzlg();
            webResourceResponse = zzaxi.m26125c(this.f25381d.getContext(), this.f25381d.mo28793z().f25057a, str);
        }
        if (webResourceResponse != null) {
            return webResourceResponse;
        }
        try {
            if (!zzavx.m25931a(zzbja.f25407a, this.f25381d.getContext(), this.f25403z).equals(zzbja.f25407a)) {
                return m27026e(zzbja);
            }
            zzvv a = zzvv.m31317a(zzbja.f25407a);
            if (a != null) {
                zzvs a2 = zzk.zzlm().mo32314a(a);
                if (a2 != null && a2.mo32317a()) {
                    return new WebResourceResponse(str2, str2, a2.mo32318c());
                }
            }
            if (zzazx.m26334a()) {
                if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23946Ib)).booleanValue()) {
                    return m27026e(zzbja);
                }
            }
            return null;
        } catch (Exception | NoClassDefFoundError e) {
            zzk.zzlk().mo30168a(e, "AdWebViewClient.interceptRequest");
            return m27029o();
        }
    }

    /* renamed from: o */
    private static WebResourceResponse m27029o() {
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f24011Ta)).booleanValue()) {
            return null;
        }
        String str = "";
        return new WebResourceResponse(str, str, new ByteArrayInputStream(new byte[0]));
    }

    /* renamed from: e */
    private final WebResourceResponse m27026e(zzbja zzbja) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(zzbja.f25407a);
        int i = 0;
        while (true) {
            i++;
            if (i <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                for (Entry entry : zzbja.f25410d.entrySet()) {
                    openConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                if (openConnection instanceof HttpURLConnection) {
                    httpURLConnection = (HttpURLConnection) openConnection;
                    zzk.zzlg().mo30233a(this.f25381d.getContext(), this.f25381d.mo28793z().f25057a, false, httpURLConnection);
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
                                return m27029o();
                            } else if (protocol.equals(Constants.HTTP) || protocol.equals("https")) {
                                String str = "Redirecting to ";
                                String valueOf = String.valueOf(headerField);
                                zzbad.m26352a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                                httpURLConnection.disconnect();
                                url = url2;
                            } else {
                                String str2 = "Unsupported scheme: ";
                                String valueOf2 = String.valueOf(protocol);
                                zzbad.m26359d(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
                                return m27029o();
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
    public final void mo30662b(boolean z) {
        this.f25391n = z;
    }

    /* renamed from: c */
    public final zzavb mo30609c() {
        return this.f25399v;
    }

    /* renamed from: e */
    public final void mo30612e() {
        synchronized (this.f25383f) {
            this.f25391n = false;
            this.f25392o = true;
            zzbbm.f25064a.execute(new C9424ff(this));
        }
    }

    /* renamed from: c */
    public final void mo30663c(boolean z) {
        this.f25403z = z;
    }

    /* renamed from: a */
    public final void mo30593a(int i, int i2) {
        zzapr zzapr = this.f25398u;
        if (zzapr != null) {
            zzapr.mo29975a(i, i2);
        }
    }

    /* renamed from: a */
    public final void mo30602a(boolean z) {
        synchronized (this.f25383f) {
            this.f25393p = true;
        }
    }

    /* renamed from: a */
    public final void mo30595a(Uri uri) {
        this.f25382e.mo29788b(uri);
    }

    @TargetApi(26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.f25381d.mo28735a(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }
}
