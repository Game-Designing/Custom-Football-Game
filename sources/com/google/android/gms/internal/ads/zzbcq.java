package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.mopub.mobileads.VastIconXmlManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import p005cm.aptoide.p006pt.BuildConfig;

@zzard
public final class zzbcq extends FrameLayout implements zzbcn {

    /* renamed from: a */
    private final zzbdf f25095a;

    /* renamed from: b */
    private final FrameLayout f25096b;

    /* renamed from: c */
    private final zzadi f25097c;

    /* renamed from: d */
    private final C8806Dd f25098d;

    /* renamed from: e */
    private final long f25099e;

    /* renamed from: f */
    private zzbco f25100f;

    /* renamed from: g */
    private boolean f25101g;

    /* renamed from: h */
    private boolean f25102h;

    /* renamed from: i */
    private boolean f25103i;

    /* renamed from: j */
    private boolean f25104j;

    /* renamed from: k */
    private long f25105k;

    /* renamed from: l */
    private long f25106l;

    /* renamed from: m */
    private String f25107m;

    /* renamed from: n */
    private String[] f25108n;

    /* renamed from: o */
    private Bitmap f25109o;

    /* renamed from: p */
    private ImageView f25110p;

    /* renamed from: q */
    private boolean f25111q;

    /* renamed from: a */
    public static void m26459a(zzbdf zzbdf) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "no_video_view");
        zzbdf.mo28729a("onVideoEvent", (Map<String, ?>) hashMap);
    }

    /* renamed from: a */
    public static void m26461a(zzbdf zzbdf, Map<String, List<Map<String, Object>>> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put("mimeTypes", map);
        zzbdf.mo28729a("onVideoEvent", (Map<String, ?>) hashMap);
    }

    /* renamed from: a */
    public static void m26460a(zzbdf zzbdf, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put("error", str);
        zzbdf.mo28729a("onVideoEvent", (Map<String, ?>) hashMap);
    }

    public zzbcq(Context context, zzbdf zzbdf, int i, boolean z, zzadi zzadi, zzbde zzbde) {
        Context context2 = context;
        super(context);
        zzbdf zzbdf2 = zzbdf;
        this.f25095a = zzbdf2;
        zzadi zzadi2 = zzadi;
        this.f25097c = zzadi2;
        this.f25096b = new FrameLayout(context);
        addView(this.f25096b, new LayoutParams(-1, -1));
        Preconditions.m21857a(zzbdf.mo28768o());
        this.f25100f = zzbdf.mo28768o().zzbqs.mo30389a(context, zzbdf2, i, z, zzadi2, zzbde);
        zzbco zzbco = this.f25100f;
        if (zzbco != null) {
            this.f25096b.addView(zzbco, new LayoutParams(-1, -1, 17));
            if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23956K)).booleanValue()) {
                mo30408n();
            }
        }
        this.f25110p = new ImageView(context);
        this.f25099e = ((Long) zzyt.m31536e().mo29599a(zzacu.f23980O)).longValue();
        this.f25104j = ((Boolean) zzyt.m31536e().mo29599a(zzacu.f23968M)).booleanValue();
        zzadi zzadi3 = this.f25097c;
        if (zzadi3 != null) {
            zzadi3.mo29620a("spinner_used", this.f25104j ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID);
        }
        this.f25098d = new C8806Dd(this);
        zzbco zzbco2 = this.f25100f;
        if (zzbco2 != null) {
            zzbco2.mo30348a(this);
        }
        if (this.f25100f == null) {
            mo30374a("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    /* renamed from: a */
    public final void mo30393a(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            LayoutParams layoutParams = new LayoutParams(i3, i4);
            layoutParams.setMargins(i, i2, 0, 0);
            this.f25096b.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    /* renamed from: a */
    public final void mo30395a(String str, String[] strArr) {
        this.f25107m = str;
        this.f25108n = strArr;
    }

    /* renamed from: a */
    public final void mo30391a(float f, float f2) {
        zzbco zzbco = this.f25100f;
        if (zzbco != null) {
            zzbco.mo30347a(f, f2);
        }
    }

    /* renamed from: d */
    public final void mo30401d() {
        if (this.f25100f != null) {
            if (!TextUtils.isEmpty(this.f25107m)) {
                this.f25100f.mo30383a(this.f25107m, this.f25108n);
                return;
            }
            m26462b("no_src", new String[0]);
        }
    }

    /* renamed from: b */
    public final void mo30397b() {
        zzbco zzbco = this.f25100f;
        if (zzbco != null) {
            zzbco.mo30349b();
        }
    }

    /* renamed from: c */
    public final void mo30399c() {
        zzbco zzbco = this.f25100f;
        if (zzbco != null) {
            zzbco.mo30351c();
        }
    }

    /* renamed from: a */
    public final void mo30392a(int i) {
        zzbco zzbco = this.f25100f;
        if (zzbco != null) {
            zzbco.mo30350b(i);
        }
    }

    /* renamed from: l */
    public final void mo30406l() {
        zzbco zzbco = this.f25100f;
        if (zzbco != null) {
            zzbco.f25094b.mo30439a(true);
            zzbco.mo28179a();
        }
    }

    /* renamed from: m */
    public final void mo30407m() {
        zzbco zzbco = this.f25100f;
        if (zzbco != null) {
            zzbco.f25094b.mo30439a(false);
            zzbco.mo28179a();
        }
    }

    public final void setVolume(float f) {
        zzbco zzbco = this.f25100f;
        if (zzbco != null) {
            zzbco.f25094b.mo30438a(f);
            zzbco.mo28179a();
        }
    }

    /* renamed from: b */
    public final void mo30398b(int i) {
        this.f25100f.mo30384c(i);
    }

    /* renamed from: c */
    public final void mo30400c(int i) {
        this.f25100f.mo30385d(i);
    }

    /* renamed from: d */
    public final void mo30402d(int i) {
        this.f25100f.mo30386e(i);
    }

    /* renamed from: e */
    public final void mo30403e(int i) {
        this.f25100f.mo30387f(i);
    }

    /* renamed from: f */
    public final void mo30404f(int i) {
        this.f25100f.mo30388g(i);
    }

    @TargetApi(14)
    /* renamed from: a */
    public final void mo30394a(MotionEvent motionEvent) {
        zzbco zzbco = this.f25100f;
        if (zzbco != null) {
            zzbco.dispatchTouchEvent(motionEvent);
        }
    }

    @TargetApi(14)
    /* renamed from: n */
    public final void mo30408n() {
        zzbco zzbco = this.f25100f;
        if (zzbco != null) {
            TextView textView = new TextView(zzbco.getContext());
            String str = "AdMob - ";
            String valueOf = String.valueOf(this.f25100f.mo30353e());
            textView.setText(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            textView.setTextColor(-65536);
            textView.setBackgroundColor(-256);
            this.f25096b.addView(textView, new LayoutParams(-2, -2, 17));
            this.f25096b.bringChildToFront(textView);
        }
    }

    /* renamed from: j */
    public final void mo30380j() {
        this.f25098d.mo28118b();
        zzaxi.f24961a.post(new C9789wd(this));
    }

    /* renamed from: i */
    public final void mo30379i() {
        zzbco zzbco = this.f25100f;
        if (zzbco != null && this.f25106l == 0) {
            m26462b("canplaythrough", VastIconXmlManager.DURATION, String.valueOf(((float) zzbco.getDuration()) / 1000.0f), "videoWidth", String.valueOf(this.f25100f.getVideoWidth()), "videoHeight", String.valueOf(this.f25100f.getVideoHeight()));
        }
    }

    /* renamed from: h */
    public final void mo30378h() {
        if (this.f25095a.mo28780q() != null && !this.f25102h) {
            this.f25103i = (this.f25095a.mo28780q().getWindow().getAttributes().flags & 128) != 0;
            if (!this.f25103i) {
                this.f25095a.mo28780q().getWindow().addFlags(128);
                this.f25102h = true;
            }
        }
        this.f25101g = true;
    }

    /* renamed from: k */
    public final void mo30381k() {
        m26462b("pause", new String[0]);
        m26464q();
        this.f25101g = false;
    }

    /* renamed from: g */
    public final void mo30377g() {
        m26462b("ended", new String[0]);
        m26464q();
    }

    /* renamed from: a */
    public final void mo30374a(String str, String str2) {
        m26462b("error", "what", str, "extra", str2);
    }

    /* renamed from: f */
    public final void mo30376f() {
        if (this.f25111q && this.f25109o != null && !m26463p()) {
            this.f25110p.setImageBitmap(this.f25109o);
            this.f25110p.invalidate();
            this.f25096b.addView(this.f25110p, new LayoutParams(-1, -1));
            this.f25096b.bringChildToFront(this.f25110p);
        }
        this.f25098d.mo28117a();
        this.f25106l = this.f25105k;
        zzaxi.f24961a.post(new C9810xd(this));
    }

    /* renamed from: a */
    public final void mo30390a() {
        this.f25098d.mo28117a();
        zzbco zzbco = this.f25100f;
        if (zzbco != null) {
            zzbco.mo30352d();
        }
        m26464q();
    }

    public final void finalize() throws Throwable {
        try {
            this.f25098d.mo28117a();
            if (this.f25100f != null) {
                zzbco zzbco = this.f25100f;
                Executor executor = zzbbm.f25064a;
                zzbco.getClass();
                executor.execute(C9747ud.m24104a(zzbco));
            }
        } finally {
            super.finalize();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public final void mo30409o() {
        zzbco zzbco = this.f25100f;
        if (zzbco != null) {
            long currentPosition = (long) zzbco.getCurrentPosition();
            if (this.f25105k != currentPosition && currentPosition > 0) {
                m26462b("timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
                this.f25105k = currentPosition;
            }
        }
    }

    /* renamed from: e */
    public final void mo30375e() {
        if (this.f25101g && m26463p()) {
            this.f25096b.removeView(this.f25110p);
        }
        if (this.f25109o != null) {
            long a = zzk.zzln().mo27934a();
            if (this.f25100f.getBitmap(this.f25109o) != null) {
                this.f25111q = true;
            }
            long a2 = zzk.zzln().mo27934a() - a;
            if (zzawz.m26001a()) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Spinner frame grab took ");
                sb.append(a2);
                sb.append("ms");
                zzawz.m26003f(sb.toString());
            }
            if (a2 > this.f25099e) {
                zzbad.m26359d("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.f25104j = false;
                this.f25109o = null;
                zzadi zzadi = this.f25097c;
                if (zzadi != null) {
                    zzadi.mo29620a("spinner_jank", Long.toString(a2));
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo30373a(int i, int i2) {
        if (this.f25104j) {
            int max = Math.max(i / ((Integer) zzyt.m31536e().mo29599a(zzacu.f23974N)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzyt.m31536e().mo29599a(zzacu.f23974N)).intValue(), 1);
            Bitmap bitmap = this.f25109o;
            if (bitmap == null || bitmap.getWidth() != max || this.f25109o.getHeight() != max2) {
                this.f25109o = Bitmap.createBitmap(max, max2, Config.ARGB_8888);
                this.f25111q = false;
            }
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.f25098d.mo28118b();
        } else {
            this.f25098d.mo28117a();
            this.f25106l = this.f25105k;
        }
        zzaxi.f24961a.post(new C9768vd(this, z));
    }

    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.f25098d.mo28118b();
            z = true;
        } else {
            this.f25098d.mo28117a();
            this.f25106l = this.f25105k;
            z = false;
        }
        zzaxi.f24961a.post(new C9831yd(this, z));
    }

    /* renamed from: p */
    private final boolean m26463p() {
        return this.f25110p.getParent() != null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m26462b(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.f25095a.mo28729a("onVideoEvent", (Map<String, ?>) hashMap);
    }

    /* renamed from: q */
    private final void m26464q() {
        if (this.f25095a.mo28780q() != null && this.f25102h && !this.f25103i) {
            this.f25095a.mo28780q().getWindow().clearFlags(128);
            this.f25102h = false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo30396a(boolean z) {
        m26462b("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }
}
