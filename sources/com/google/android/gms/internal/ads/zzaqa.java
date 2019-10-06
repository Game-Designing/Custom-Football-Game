package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

@zzard
public final class zzaqa extends zzaqb implements zzaho<zzbgz> {

    /* renamed from: c */
    private final zzbgz f24568c;

    /* renamed from: d */
    private final Context f24569d;

    /* renamed from: e */
    private final WindowManager f24570e;

    /* renamed from: f */
    private final zzacf f24571f;

    /* renamed from: g */
    private DisplayMetrics f24572g;

    /* renamed from: h */
    private float f24573h;

    /* renamed from: i */
    private int f24574i = -1;

    /* renamed from: j */
    private int f24575j = -1;

    /* renamed from: k */
    private int f24576k;

    /* renamed from: l */
    private int f24577l = -1;

    /* renamed from: m */
    private int f24578m = -1;

    /* renamed from: n */
    private int f24579n = -1;

    /* renamed from: o */
    private int f24580o = -1;

    public zzaqa(zzbgz zzbgz, Context context, zzacf zzacf) {
        super(zzbgz);
        this.f24568c = zzbgz;
        this.f24569d = context;
        this.f24571f = zzacf;
        this.f24570e = (WindowManager) context.getSystemService("window");
    }

    /* renamed from: a */
    public final void mo29988a(int i, int i2) {
        int i3 = 0;
        if (this.f24569d instanceof Activity) {
            i3 = zzk.zzlg().mo30241c((Activity) this.f24569d)[0];
        }
        if (this.f24568c.mo28766m() == null || !this.f24568c.mo28766m().mo30650e()) {
            this.f24579n = zzyt.m31532a().mo30315b(this.f24569d, this.f24568c.getWidth());
            this.f24580o = zzyt.m31532a().mo30315b(this.f24569d, this.f24568c.getHeight());
        }
        mo29992b(i, i2 - i3, this.f24579n, this.f24580o);
        this.f24568c.mo28714a().mo30593a(i, i2);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27996a(Object obj, Map map) {
        this.f24572g = new DisplayMetrics();
        Display defaultDisplay = this.f24570e.getDefaultDisplay();
        defaultDisplay.getMetrics(this.f24572g);
        this.f24573h = this.f24572g.density;
        this.f24576k = defaultDisplay.getRotation();
        zzyt.m31532a();
        DisplayMetrics displayMetrics = this.f24572g;
        this.f24574i = zzazt.m26312b(displayMetrics, displayMetrics.widthPixels);
        zzyt.m31532a();
        DisplayMetrics displayMetrics2 = this.f24572g;
        this.f24575j = zzazt.m26312b(displayMetrics2, displayMetrics2.heightPixels);
        Activity q = this.f24568c.mo28780q();
        if (q == null || q.getWindow() == null) {
            this.f24577l = this.f24574i;
            this.f24578m = this.f24575j;
        } else {
            zzk.zzlg();
            int[] a = zzaxi.m26119a(q);
            zzyt.m31532a();
            this.f24577l = zzazt.m26312b(this.f24572g, a[0]);
            zzyt.m31532a();
            this.f24578m = zzazt.m26312b(this.f24572g, a[1]);
        }
        if (this.f24568c.mo28766m().mo30650e()) {
            this.f24579n = this.f24574i;
            this.f24580o = this.f24575j;
        } else {
            this.f24568c.measure(0, 0);
        }
        mo29990a(this.f24574i, this.f24575j, this.f24577l, this.f24578m, this.f24573h, this.f24576k);
        String str = "onDeviceFeaturesReceived";
        this.f24568c.mo28730a(str, new zzapx(new zzapz().mo29986d(this.f24571f.mo29585a()).mo29985c(this.f24571f.mo29586b()).mo29987e(this.f24571f.mo29588d()).mo29983a(this.f24571f.mo29587c()).mo29984b(true)).mo29982a());
        int[] iArr = new int[2];
        this.f24568c.getLocationOnScreen(iArr);
        mo29988a(zzyt.m31532a().mo30315b(this.f24569d, iArr[0]), zzyt.m31532a().mo30315b(this.f24569d, iArr[1]));
        if (zzbad.m26354a(2)) {
            zzbad.m26357c("Dispatching Ready Event.");
        }
        mo29993b(this.f24568c.mo28793z().f25057a);
    }
}
