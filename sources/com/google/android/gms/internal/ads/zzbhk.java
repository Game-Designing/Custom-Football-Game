package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.impl.C8581R;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

@zzard
public final class zzbhk extends FrameLayout implements zzbgz {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzbgz f25354a;

    /* renamed from: b */
    private final zzbcw f25355b;

    /* renamed from: c */
    private final AtomicBoolean f25356c = new AtomicBoolean();

    public zzbhk(zzbgz zzbgz) {
        super(zzbgz.getContext());
        this.f25354a = zzbgz;
        this.f25355b = new zzbcw(zzbgz.mo28751f(), this, this);
        addView(this.f25354a.getView());
    }

    /* renamed from: E */
    public final zzbcw mo28709E() {
        return this.f25355b;
    }

    public final View getView() {
        return this;
    }

    public final void onPause() {
        this.f25355b.mo30415b();
        this.f25354a.onPause();
    }

    /* renamed from: y */
    public final void mo28792y() {
        this.f25355b.mo30412a();
        this.f25354a.mo28792y();
    }

    /* renamed from: h */
    public final void mo28757h() {
        setBackgroundColor(0);
        this.f25354a.setBackgroundColor(0);
    }

    /* renamed from: I */
    public final int mo28713I() {
        return getMeasuredHeight();
    }

    /* renamed from: H */
    public final int mo28712H() {
        return getMeasuredWidth();
    }

    /* renamed from: C */
    public final void mo28707C() {
        this.f25354a.mo28707C();
    }

    public final WebView getWebView() {
        return this.f25354a.getWebView();
    }

    /* renamed from: a */
    public final void mo28729a(String str, Map<String, ?> map) {
        this.f25354a.mo28729a(str, map);
    }

    /* renamed from: a */
    public final void mo28730a(String str, JSONObject jSONObject) {
        this.f25354a.mo28730a(str, jSONObject);
    }

    /* renamed from: a */
    public final void mo28726a(String str, zzaho<? super zzbgz> zzaho) {
        this.f25354a.mo28726a(str, zzaho);
    }

    /* renamed from: b */
    public final void mo28739b(String str, zzaho<? super zzbgz> zzaho) {
        this.f25354a.mo28739b(str, zzaho);
    }

    /* renamed from: a */
    public final void mo28725a(String str, Predicate<zzaho<? super zzbgz>> predicate) {
        this.f25354a.mo28725a(str, predicate);
    }

    /* renamed from: s */
    public final void mo28782s() {
        this.f25354a.mo28782s();
    }

    /* renamed from: a */
    public final void mo28715a(int i) {
        this.f25354a.mo28715a(i);
    }

    /* renamed from: w */
    public final void mo28790w() {
        this.f25354a.mo28790w();
    }

    /* renamed from: t */
    public final void mo28787t() {
        this.f25354a.mo28787t();
    }

    /* renamed from: a */
    public final void mo28734a(boolean z, long j) {
        this.f25354a.mo28734a(z, j);
    }

    /* renamed from: a */
    public final void mo28724a(String str) {
        this.f25354a.mo28724a(str);
    }

    /* renamed from: b */
    public final void mo28740b(String str, JSONObject jSONObject) {
        this.f25354a.mo28740b(str, jSONObject);
    }

    /* renamed from: q */
    public final Activity mo28780q() {
        return this.f25354a.mo28780q();
    }

    /* renamed from: f */
    public final Context mo28751f() {
        return this.f25354a.mo28751f();
    }

    /* renamed from: o */
    public final zza mo28768o() {
        return this.f25354a.mo28768o();
    }

    /* renamed from: i */
    public final zzd mo28758i() {
        return this.f25354a.mo28758i();
    }

    /* renamed from: v */
    public final IObjectWrapper mo28789v() {
        return this.f25354a.mo28789v();
    }

    /* renamed from: l */
    public final zzd mo28762l() {
        return this.f25354a.mo28762l();
    }

    /* renamed from: m */
    public final zzbin mo28766m() {
        return this.f25354a.mo28766m();
    }

    /* renamed from: b */
    public final String mo28737b() {
        return this.f25354a.mo28737b();
    }

    /* renamed from: a */
    public final zzbii mo28714a() {
        return this.f25354a.mo28714a();
    }

    /* renamed from: c */
    public final WebViewClient mo28743c() {
        return this.f25354a.mo28743c();
    }

    /* renamed from: d */
    public final boolean mo28746d() {
        return this.f25354a.mo28746d();
    }

    /* renamed from: e */
    public final zzdh mo28748e() {
        return this.f25354a.mo28748e();
    }

    /* renamed from: z */
    public final zzbai mo28793z() {
        return this.f25354a.mo28793z();
    }

    /* renamed from: x */
    public final boolean mo28791x() {
        return this.f25354a.mo28791x();
    }

    public final boolean isDestroyed() {
        return this.f25354a.isDestroyed();
    }

    /* renamed from: A */
    public final boolean mo28705A() {
        return this.f25354a.mo28705A();
    }

    public final void zzld() {
        this.f25354a.zzld();
    }

    public final void zzlc() {
        this.f25354a.zzlc();
    }

    /* renamed from: F */
    public final String mo28710F() {
        return this.f25354a.mo28710F();
    }

    /* renamed from: G */
    public final zzadg mo28711G() {
        return this.f25354a.mo28711G();
    }

    /* renamed from: B */
    public final zzadh mo28706B() {
        return this.f25354a.mo28706B();
    }

    /* renamed from: g */
    public final zzbhq mo28754g() {
        return this.f25354a.mo28754g();
    }

    /* renamed from: b */
    public final void mo28738b(zzd zzd) {
        this.f25354a.mo28738b(zzd);
    }

    /* renamed from: a */
    public final void mo28719a(IObjectWrapper iObjectWrapper) {
        this.f25354a.mo28719a(iObjectWrapper);
    }

    /* renamed from: a */
    public final void mo28723a(zzbin zzbin) {
        this.f25354a.mo28723a(zzbin);
    }

    /* renamed from: e */
    public final void mo28749e(boolean z) {
        this.f25354a.mo28749e(z);
    }

    /* renamed from: p */
    public final void mo28779p() {
        this.f25354a.mo28779p();
    }

    /* renamed from: a */
    public final void mo28716a(Context context) {
        this.f25354a.mo28716a(context);
    }

    /* renamed from: d */
    public final void mo28745d(boolean z) {
        this.f25354a.mo28745d(z);
    }

    public final void setRequestedOrientation(int i) {
        this.f25354a.setRequestedOrientation(i);
    }

    /* renamed from: a */
    public final void mo28718a(zzd zzd) {
        this.f25354a.mo28718a(zzd);
    }

    /* renamed from: b */
    public final void mo28741b(boolean z) {
        this.f25354a.mo28741b(z);
    }

    /* renamed from: a */
    public final void mo28727a(String str, zzbft zzbft) {
        this.f25354a.mo28727a(str, zzbft);
    }

    /* renamed from: b */
    public final zzbft mo28736b(String str) {
        return this.f25354a.mo28736b(str);
    }

    /* renamed from: r */
    public final void mo28781r() {
        this.f25354a.mo28781r();
    }

    public final void destroy() {
        IObjectWrapper v = mo28789v();
        if (v != null) {
            zzk.zzlv().mo30000b(v);
            zzaxi.f24961a.postDelayed(new C9230Xe(this), (long) ((Integer) zzyt.m31536e().mo29599a(zzacu.f24050Zd)).intValue());
            return;
        }
        this.f25354a.destroy();
    }

    public final void loadData(String str, String str2, String str3) {
        this.f25354a.loadData(str, str2, str3);
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.f25354a.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public final void loadUrl(String str) {
        this.f25354a.loadUrl(str);
    }

    /* renamed from: a */
    public final void mo28728a(String str, String str2, String str3) {
        this.f25354a.mo28728a(str, str2, str3);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.f25354a.setOnClickListener(onClickListener);
    }

    public final void setOnTouchListener(OnTouchListener onTouchListener) {
        this.f25354a.setOnTouchListener(onTouchListener);
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f25354a.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.f25354a.setWebViewClient(webViewClient);
    }

    public final void onResume() {
        this.f25354a.onResume();
    }

    /* renamed from: j */
    public final void mo28760j() {
        String str;
        TextView textView = new TextView(getContext());
        Resources b = zzk.zzlk().mo30169b();
        if (b != null) {
            str = b.getString(C8581R.string.f19076s7);
        } else {
            str = "Test Ad";
        }
        textView.setText(str);
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        if (VERSION.SDK_INT >= 16) {
            textView.setBackground(gradientDrawable);
        } else {
            textView.setBackgroundDrawable(gradientDrawable);
        }
        addView(textView, new LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    /* renamed from: a */
    public final void mo28731a(boolean z) {
        this.f25354a.mo28731a(z);
    }

    /* renamed from: a */
    public final void mo28720a(zzadv zzadv) {
        this.f25354a.mo28720a(zzadv);
    }

    /* renamed from: a */
    public final void mo28694a(zzud zzud) {
        this.f25354a.mo28694a(zzud);
    }

    /* renamed from: a */
    public final void mo28721a(zzadx zzadx) {
        this.f25354a.mo28721a(zzadx);
    }

    /* renamed from: u */
    public final zzadx mo28788u() {
        return this.f25354a.mo28788u();
    }

    /* renamed from: a */
    public final void mo28722a(zzbhq zzbhq) {
        this.f25354a.mo28722a(zzbhq);
    }

    /* renamed from: n */
    public final boolean mo28767n() {
        return this.f25354a.mo28767n();
    }

    /* renamed from: c */
    public final void mo28744c(boolean z) {
        this.f25354a.mo28744c(z);
    }

    /* renamed from: f */
    public final void mo28752f(boolean z) {
        this.f25354a.mo28752f(z);
    }

    /* renamed from: D */
    public final void mo28708D() {
        this.f25354a.mo28708D();
    }

    /* renamed from: a */
    public final void mo28717a(zzc zzc) {
        this.f25354a.mo28717a(zzc);
    }

    /* renamed from: b */
    public final void mo28742b(boolean z, int i) {
        this.f25354a.mo28742b(z, i);
    }

    /* renamed from: a */
    public final void mo28732a(boolean z, int i, String str) {
        this.f25354a.mo28732a(z, i, str);
    }

    /* renamed from: a */
    public final void mo28733a(boolean z, int i, String str, String str2) {
        this.f25354a.mo28733a(z, i, str, str2);
    }

    /* renamed from: a */
    public final boolean mo28735a(boolean z, int i) {
        if (!this.f25356c.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24023Va)).booleanValue()) {
            return false;
        }
        removeView(this.f25354a.getView());
        return this.f25354a.mo28735a(z, i);
    }

    /* renamed from: k */
    public final boolean mo28761k() {
        return this.f25356c.get();
    }
}
