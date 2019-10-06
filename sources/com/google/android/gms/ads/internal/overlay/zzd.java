package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzh;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzacu;
import com.google.android.gms.internal.ads.zzagv;
import com.google.android.gms.internal.ads.zzagx;
import com.google.android.gms.internal.ads.zzaqh;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbhf;
import com.google.android.gms.internal.ads.zzbii;
import com.google.android.gms.internal.ads.zzbij;
import com.google.android.gms.internal.ads.zzbin;
import com.google.android.gms.internal.ads.zzwj;
import com.google.android.gms.internal.ads.zzyt;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.util.Collections;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

@zzard
public class zzd extends zzaqh implements zzx {
    @VisibleForTesting

    /* renamed from: b */
    private static final int f19092b = Color.argb(0, 0, 0, 0);

    /* renamed from: c */
    protected final Activity f19093c;
    @VisibleForTesting

    /* renamed from: d */
    AdOverlayInfoParcel f19094d;
    @VisibleForTesting

    /* renamed from: e */
    zzbgz f19095e;
    @VisibleForTesting

    /* renamed from: f */
    private zzj f19096f;
    @VisibleForTesting

    /* renamed from: g */
    private zzp f19097g;
    @VisibleForTesting

    /* renamed from: h */
    private boolean f19098h = false;
    @VisibleForTesting

    /* renamed from: i */
    private FrameLayout f19099i;
    @VisibleForTesting

    /* renamed from: j */
    private CustomViewCallback f19100j;
    @VisibleForTesting

    /* renamed from: k */
    private boolean f19101k = false;
    @VisibleForTesting

    /* renamed from: l */
    private boolean f19102l = false;
    @VisibleForTesting

    /* renamed from: m */
    private C8587e f19103m;
    @VisibleForTesting

    /* renamed from: n */
    private boolean f19104n = false;
    @VisibleForTesting

    /* renamed from: o */
    int f19105o = 0;

    /* renamed from: p */
    private final Object f19106p = new Object();

    /* renamed from: q */
    private Runnable f19107q;

    /* renamed from: r */
    private boolean f19108r;

    /* renamed from: s */
    private boolean f19109s;

    /* renamed from: t */
    private boolean f19110t = false;

    /* renamed from: u */
    private boolean f19111u = false;

    /* renamed from: v */
    private boolean f19112v = true;

    public zzd(Activity activity) {
        this.f19093c = activity;
    }

    public final void close() {
        this.f19105o = 2;
        this.f19093c.finish();
    }

    public final void zzte() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.f19094d;
        if (adOverlayInfoParcel != null && this.f19098h) {
            setRequestedOrientation(adOverlayInfoParcel.orientation);
        }
        if (this.f19099i != null) {
            this.f19093c.setContentView(this.f19103m);
            this.f19109s = true;
            this.f19099i.removeAllViews();
            this.f19099i = null;
        }
        CustomViewCallback customViewCallback = this.f19100j;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.f19100j = null;
        }
        this.f19098h = false;
    }

    public final void zztf() {
        this.f19105o = 1;
        this.f19093c.finish();
    }

    public final void onBackPressed() {
        this.f19105o = 0;
    }

    public final boolean zztg() {
        this.f19105o = 0;
        zzbgz zzbgz = this.f19095e;
        if (zzbgz == null) {
            return true;
        }
        boolean A = zzbgz.mo28705A();
        if (!A) {
            this.f19095e.mo28729a("onbackblocked", Collections.emptyMap());
        }
        return A;
    }

    public void onCreate(Bundle bundle) {
        this.f19093c.requestWindowFeature(1);
        this.f19101k = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            this.f19094d = AdOverlayInfoParcel.zzc(this.f19093c.getIntent());
            if (this.f19094d != null) {
                if (this.f19094d.zzbtc.f25059c > 7500000) {
                    this.f19105o = 3;
                }
                if (this.f19093c.getIntent() != null) {
                    this.f19112v = this.f19093c.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
                }
                if (this.f19094d.zzdkt != null) {
                    this.f19102l = this.f19094d.zzdkt.zzbre;
                } else {
                    this.f19102l = false;
                }
                if (this.f19102l && this.f19094d.zzdkt.zzbrj != -1) {
                    new C8588f(this).mo30195b();
                }
                if (bundle == null) {
                    if (this.f19094d.zzdkm != null && this.f19112v) {
                        this.f19094d.zzdkm.zzta();
                    }
                    if (!(this.f19094d.zzdkr == 1 || this.f19094d.zzcgi == null)) {
                        this.f19094d.zzcgi.onAdClicked();
                    }
                }
                this.f19103m = new C8587e(this.f19093c, this.f19094d.zzdks, this.f19094d.zzbtc.f25057a);
                this.f19103m.setId(1000);
                zzk.zzli().mo30250a(this.f19093c);
                int i = this.f19094d.zzdkr;
                if (i == 1) {
                    m20835o(false);
                } else if (i == 2) {
                    this.f19096f = new zzj(this.f19094d.zzdbs);
                    m20835o(false);
                } else if (i == 3) {
                    m20835o(true);
                } else {
                    throw new C8586d("Could not determine ad overlay type.");
                }
            } else {
                throw new C8586d("Could not get info for ad overlay.");
            }
        } catch (C8586d e) {
            zzbad.m26359d(e.getMessage());
            this.f19105o = 3;
            this.f19093c.finish();
        }
    }

    public final void onRestart() {
    }

    public final void onStart() {
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23972Md)).booleanValue()) {
            zzbgz zzbgz = this.f19095e;
            if (zzbgz == null || zzbgz.isDestroyed()) {
                zzbad.m26359d("The webview does not exist. Ignoring action.");
            } else {
                zzk.zzli();
                zzaxo.m26164b(this.f19095e);
            }
        }
    }

    public final void onResume() {
        zzo zzo = this.f19094d.zzdkm;
        if (zzo != null) {
            zzo.onResume();
        }
        m20830a(this.f19093c.getResources().getConfiguration());
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f23972Md)).booleanValue()) {
            zzbgz zzbgz = this.f19095e;
            if (zzbgz == null || zzbgz.isDestroyed()) {
                zzbad.m26359d("The webview does not exist. Ignoring action.");
            } else {
                zzk.zzli();
                zzaxo.m26164b(this.f19095e);
            }
        }
    }

    public final void onPause() {
        zzte();
        zzo zzo = this.f19094d.zzdkm;
        if (zzo != null) {
            zzo.onPause();
        }
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f23972Md)).booleanValue() && this.f19095e != null && (!this.f19093c.isFinishing() || this.f19096f == null)) {
            zzk.zzli();
            zzaxo.m26163a(this.f19095e);
        }
        m20832jb();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void zzac(IObjectWrapper iObjectWrapper) {
        m20830a((Configuration) ObjectWrapper.m22187H(iObjectWrapper));
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f19101k);
    }

    public final void onStop() {
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23972Md)).booleanValue() && this.f19095e != null && (!this.f19093c.isFinishing() || this.f19096f == null)) {
            zzk.zzli();
            zzaxo.m26163a(this.f19095e);
        }
        m20832jb();
    }

    public final void onDestroy() {
        zzbgz zzbgz = this.f19095e;
        if (zzbgz != null) {
            this.f19103m.removeView(zzbgz.getView());
        }
        m20832jb();
    }

    /* renamed from: n */
    private final void m20834n(boolean z) {
        int intValue = ((Integer) zzyt.m31536e().mo29599a(zzacu.f23984Od)).intValue();
        C8590h hVar = new C8590h();
        hVar.f19089e = 50;
        hVar.f19085a = z ? intValue : 0;
        hVar.f19086b = z ? 0 : intValue;
        hVar.f19087c = 0;
        hVar.f19088d = intValue;
        this.f19097g = new zzp(this.f19093c, hVar, this);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        zza(z, this.f19094d.zzdko);
        this.f19103m.addView(this.f19097g, layoutParams);
    }

    public final void zzdd() {
        this.f19109s = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0060 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(boolean r7, boolean r8) {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzacu.f24120kb
            com.google.android.gms.internal.ads.zzacr r1 = com.google.android.gms.internal.ads.zzyt.m31536e()
            java.lang.Object r0 = r1.mo29599a(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0023
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r6.f19094d
            if (r0 == 0) goto L_0x0023
            com.google.android.gms.ads.internal.zzh r0 = r0.zzdkt
            if (r0 == 0) goto L_0x0023
            boolean r0 = r0.zzbrl
            if (r0 == 0) goto L_0x0023
            r0 = 1
            goto L_0x0024
        L_0x0023:
            r0 = 0
        L_0x0024:
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzacu.f24126lb
            com.google.android.gms.internal.ads.zzacr r4 = com.google.android.gms.internal.ads.zzyt.m31536e()
            java.lang.Object r3 = r4.mo29599a(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0045
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r6.f19094d
            if (r3 == 0) goto L_0x0045
            com.google.android.gms.ads.internal.zzh r3 = r3.zzdkt
            if (r3 == 0) goto L_0x0045
            boolean r3 = r3.zzbrm
            if (r3 == 0) goto L_0x0045
            r3 = 1
            goto L_0x0046
        L_0x0045:
            r3 = 0
        L_0x0046:
            if (r7 == 0) goto L_0x005c
            if (r8 == 0) goto L_0x005c
            if (r0 == 0) goto L_0x005c
            if (r3 != 0) goto L_0x005c
            com.google.android.gms.internal.ads.zzaqb r7 = new com.google.android.gms.internal.ads.zzaqb
            com.google.android.gms.internal.ads.zzbgz r4 = r6.f19095e
            java.lang.String r5 = "useCustomClose"
            r7.<init>(r4, r5)
            java.lang.String r4 = "Custom close has been disabled for interstitial ads in this ad slot."
            r7.mo29991a(r4)
        L_0x005c:
            com.google.android.gms.ads.internal.overlay.zzp r7 = r6.f19097g
            if (r7 == 0) goto L_0x006b
            if (r3 != 0) goto L_0x0068
            if (r8 == 0) goto L_0x0067
            if (r0 != 0) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            r1 = 0
        L_0x0068:
            r7.zzaf(r1)
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzd.zza(boolean, boolean):void");
    }

    public final void zzth() {
        this.f19103m.removeView(this.f19097g);
        m20834n(true);
    }

    public final void setRequestedOrientation(int i) {
        if (this.f19093c.getApplicationInfo().targetSdkVersion >= ((Integer) zzyt.m31536e().mo29599a(zzacu.f23955Je)).intValue()) {
            if (this.f19093c.getApplicationInfo().targetSdkVersion <= ((Integer) zzyt.m31536e().mo29599a(zzacu.f23961Ke)).intValue()) {
                if (VERSION.SDK_INT >= ((Integer) zzyt.m31536e().mo29599a(zzacu.f23967Le)).intValue()) {
                    if (VERSION.SDK_INT <= ((Integer) zzyt.m31536e().mo29599a(zzacu.f23973Me)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.f19093c.setRequestedOrientation(i);
        } catch (Throwable th) {
            zzk.zzlk().mo30170b(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zza(View view, CustomViewCallback customViewCallback) {
        this.f19099i = new FrameLayout(this.f19093c);
        this.f19099i.setBackgroundColor(CtaButton.BACKGROUND_COLOR);
        this.f19099i.addView(view, -1, -1);
        this.f19093c.setContentView(this.f19099i);
        this.f19109s = true;
        this.f19100j = customViewCallback;
        this.f19098h = true;
    }

    /* renamed from: o */
    private final void m20835o(boolean z) throws C8586d {
        String str;
        zza zza;
        zzb zzb;
        if (!this.f19109s) {
            this.f19093c.requestWindowFeature(1);
        }
        Window window = this.f19093c.getWindow();
        if (window != null) {
            zzbgz zzbgz = this.f19094d.zzdbs;
            zzbii a = zzbgz != null ? zzbgz.mo28714a() : null;
            boolean z2 = false;
            boolean z3 = a != null && a.mo30608b();
            this.f19104n = false;
            if (z3) {
                int i = this.f19094d.orientation;
                zzk.zzli();
                if (i == 6) {
                    if (this.f19093c.getResources().getConfiguration().orientation == 1) {
                        z2 = true;
                    }
                    this.f19104n = z2;
                } else {
                    int i2 = this.f19094d.orientation;
                    zzk.zzli();
                    if (i2 == 7) {
                        if (this.f19093c.getResources().getConfiguration().orientation == 2) {
                            z2 = true;
                        }
                        this.f19104n = z2;
                    }
                }
            }
            boolean z4 = this.f19104n;
            StringBuilder sb = new StringBuilder(46);
            sb.append("Delay onShow to next orientation change: ");
            sb.append(z4);
            zzbad.m26352a(sb.toString());
            setRequestedOrientation(this.f19094d.orientation);
            zzk.zzli();
            window.setFlags(16777216, 16777216);
            zzbad.m26352a("Hardware acceleration on the AdActivity window enabled.");
            if (!this.f19102l) {
                this.f19103m.setBackgroundColor(CtaButton.BACKGROUND_COLOR);
            } else {
                this.f19103m.setBackgroundColor(f19092b);
            }
            this.f19093c.setContentView(this.f19103m);
            this.f19109s = true;
            if (z) {
                try {
                    zzk.zzlh();
                    Activity activity = this.f19093c;
                    zzbin m = this.f19094d.zzdbs != null ? this.f19094d.zzdbs.mo28766m() : null;
                    if (this.f19094d.zzdbs != null) {
                        str = this.f19094d.zzdbs.mo28737b();
                    } else {
                        str = null;
                    }
                    zzbai zzbai = this.f19094d.zzbtc;
                    if (this.f19094d.zzdbs != null) {
                        zza = this.f19094d.zzdbs.mo28768o();
                    } else {
                        zza = null;
                    }
                    this.f19095e = zzbhf.m26877a(activity, m, str, true, z3, null, zzbai, null, null, zza, zzwj.m31331a());
                    zzbii a2 = this.f19095e.mo28714a();
                    AdOverlayInfoParcel adOverlayInfoParcel = this.f19094d;
                    zzagv zzagv = adOverlayInfoParcel.zzczo;
                    zzagx zzagx = adOverlayInfoParcel.zzczp;
                    zzu zzu = adOverlayInfoParcel.zzdkq;
                    zzbgz zzbgz2 = adOverlayInfoParcel.zzdbs;
                    if (zzbgz2 != null) {
                        zzb = zzbgz2.mo28714a().mo30611d();
                    } else {
                        zzb = null;
                    }
                    a2.mo30599a(null, zzagv, null, zzagx, zzu, true, null, zzb, null, null);
                    this.f19095e.mo28714a().mo30597a((zzbij) new C8583a(this));
                    AdOverlayInfoParcel adOverlayInfoParcel2 = this.f19094d;
                    String str2 = adOverlayInfoParcel2.url;
                    if (str2 != null) {
                        this.f19095e.loadUrl(str2);
                    } else {
                        String str3 = adOverlayInfoParcel2.zzdkp;
                        if (str3 != null) {
                            this.f19095e.loadDataWithBaseURL(adOverlayInfoParcel2.zzdkn, str3, "text/html", "UTF-8", null);
                        } else {
                            throw new C8586d("No URL or HTML to display in ad overlay.");
                        }
                    }
                    zzbgz zzbgz3 = this.f19094d.zzdbs;
                    if (zzbgz3 != null) {
                        zzbgz3.mo28718a(this);
                    }
                } catch (Exception e) {
                    zzbad.m26356b("Error obtaining webview.", e);
                    throw new C8586d("Could not obtain webview for the overlay.");
                }
            } else {
                this.f19095e = this.f19094d.zzdbs;
                this.f19095e.mo28716a((Context) this.f19093c);
            }
            this.f19095e.mo28738b(this);
            zzbgz zzbgz4 = this.f19094d.zzdbs;
            if (zzbgz4 != null) {
                m20831a(zzbgz4.mo28789v(), this.f19103m);
            }
            ViewParent parent = this.f19095e.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.f19095e.getView());
            }
            if (this.f19102l) {
                this.f19095e.mo28757h();
            }
            this.f19103m.addView(this.f19095e.getView(), -1, -1);
            if (!z && !this.f19104n) {
                m20833kb();
            }
            m20834n(z3);
            if (this.f19095e.mo28746d()) {
                zza(z3, true);
                return;
            }
            return;
        }
        throw new C8586d("Invalid activity, no window available.");
    }

    /* renamed from: jb */
    private final void m20832jb() {
        if (this.f19093c.isFinishing() && !this.f19110t) {
            this.f19110t = true;
            zzbgz zzbgz = this.f19095e;
            if (zzbgz != null) {
                zzbgz.mo28715a(this.f19105o);
                synchronized (this.f19106p) {
                    if (!this.f19108r && this.f19095e.mo28767n()) {
                        this.f19107q = new C8584b(this);
                        zzaxi.f24961a.postDelayed(this.f19107q, ((Long) zzyt.m31536e().mo29599a(zzacu.f24114jb)).longValue());
                        return;
                    }
                }
            }
            mo26669ib();
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    /* renamed from: ib */
    public final void mo26669ib() {
        if (!this.f19111u) {
            this.f19111u = true;
            zzbgz zzbgz = this.f19095e;
            if (zzbgz != null) {
                this.f19103m.removeView(zzbgz.getView());
                zzj zzj = this.f19096f;
                if (zzj != null) {
                    this.f19095e.mo28716a(zzj.zzlj);
                    this.f19095e.mo28749e(false);
                    ViewGroup viewGroup = this.f19096f.parent;
                    View view = this.f19095e.getView();
                    zzj zzj2 = this.f19096f;
                    viewGroup.addView(view, zzj2.index, zzj2.zzdkh);
                    this.f19096f = null;
                } else if (this.f19093c.getApplicationContext() != null) {
                    this.f19095e.mo28716a(this.f19093c.getApplicationContext());
                }
                this.f19095e = null;
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.f19094d;
            if (adOverlayInfoParcel != null) {
                zzo zzo = adOverlayInfoParcel.zzdkm;
                if (zzo != null) {
                    zzo.zzsz();
                }
            }
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.f19094d;
            if (adOverlayInfoParcel2 != null) {
                zzbgz zzbgz2 = adOverlayInfoParcel2.zzdbs;
                if (zzbgz2 != null) {
                    m20831a(zzbgz2.mo28789v(), this.f19094d.zzdbs.getView());
                }
            }
        }
    }

    /* renamed from: a */
    private static void m20831a(IObjectWrapper iObjectWrapper, View view) {
        if (iObjectWrapper != null && view != null) {
            zzk.zzlv().mo29999a(iObjectWrapper, view);
        }
    }

    public final void zztk() {
        if (this.f19104n) {
            this.f19104n = false;
            m20833kb();
        }
    }

    /* renamed from: kb */
    private final void m20833kb() {
        this.f19095e.mo28790w();
    }

    public final void zztm() {
        this.f19103m.f19081b = true;
    }

    public final void zztn() {
        synchronized (this.f19106p) {
            this.f19108r = true;
            if (this.f19107q != null) {
                zzaxi.f24961a.removeCallbacks(this.f19107q);
                zzaxi.f24961a.post(this.f19107q);
            }
        }
    }

    /* renamed from: a */
    private final void m20830a(Configuration configuration) {
        zzh zzh = this.f19094d.zzdkt;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = zzh != null && zzh.zzbrf;
        boolean a = zzk.zzli().mo30253a(this.f19093c, configuration);
        if ((this.f19102l && !z3) || a) {
            z = false;
        } else if (VERSION.SDK_INT >= 19) {
            zzh zzh2 = this.f19094d.zzdkt;
            if (zzh2 != null && zzh2.zzbrk) {
                z2 = true;
            }
        }
        Window window = this.f19093c.getWindow();
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f24132mb)).booleanValue() || VERSION.SDK_INT < 19) {
            if (z) {
                window.addFlags(Opcodes.ACC_ABSTRACT);
                window.clearFlags(Opcodes.ACC_STRICT);
                if (VERSION.SDK_INT >= 19 && z2) {
                    window.getDecorView().setSystemUiVisibility(4098);
                    return;
                }
            } else {
                window.addFlags(Opcodes.ACC_STRICT);
                window.clearFlags(Opcodes.ACC_ABSTRACT);
            }
            return;
        }
        View decorView = window.getDecorView();
        int i = Opcodes.ACC_NATIVE;
        if (z) {
            i = 5380;
            if (z2) {
                i = 5894;
            }
        }
        decorView.setSystemUiVisibility(i);
    }
}
