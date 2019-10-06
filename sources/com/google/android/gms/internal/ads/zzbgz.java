package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;

@VisibleForTesting
@zzard
public interface zzbgz extends zzj, zzaji, zzakg, zzbdf, zzbhx, zzbhy, zzbic, zzbif, zzbig, zzbih, zzue {
    /* renamed from: A */
    boolean mo28705A();

    /* renamed from: B */
    zzadh mo28706B();

    /* renamed from: a */
    zzbii mo28714a();

    /* renamed from: a */
    void mo28715a(int i);

    /* renamed from: a */
    void mo28716a(Context context);

    /* renamed from: a */
    void mo28718a(zzd zzd);

    /* renamed from: a */
    void mo28719a(IObjectWrapper iObjectWrapper);

    /* renamed from: a */
    void mo28720a(zzadv zzadv);

    /* renamed from: a */
    void mo28721a(zzadx zzadx);

    /* renamed from: a */
    void mo28722a(zzbhq zzbhq);

    /* renamed from: a */
    void mo28723a(zzbin zzbin);

    /* renamed from: a */
    void mo28725a(String str, Predicate<zzaho<? super zzbgz>> predicate);

    /* renamed from: a */
    void mo28726a(String str, zzaho<? super zzbgz> zzaho);

    /* renamed from: a */
    void mo28727a(String str, zzbft zzbft);

    /* renamed from: a */
    void mo28728a(String str, String str2, String str3);

    /* renamed from: a */
    void mo28731a(boolean z);

    /* renamed from: a */
    boolean mo28735a(boolean z, int i);

    /* renamed from: b */
    String mo28737b();

    /* renamed from: b */
    void mo28738b(zzd zzd);

    /* renamed from: b */
    void mo28739b(String str, zzaho<? super zzbgz> zzaho);

    /* renamed from: b */
    void mo28741b(boolean z);

    /* renamed from: c */
    WebViewClient mo28743c();

    /* renamed from: c */
    void mo28744c(boolean z);

    /* renamed from: d */
    void mo28745d(boolean z);

    /* renamed from: d */
    boolean mo28746d();

    void destroy();

    /* renamed from: e */
    zzdh mo28748e();

    /* renamed from: e */
    void mo28749e(boolean z);

    /* renamed from: f */
    Context mo28751f();

    /* renamed from: g */
    zzbhq mo28754g();

    Context getContext();

    int getHeight();

    LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    ViewParent getParent();

    View getView();

    WebView getWebView();

    int getWidth();

    /* renamed from: h */
    void mo28757h();

    /* renamed from: i */
    zzd mo28758i();

    boolean isDestroyed();

    /* renamed from: j */
    void mo28760j();

    /* renamed from: k */
    boolean mo28761k();

    /* renamed from: l */
    zzd mo28762l();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    /* renamed from: m */
    zzbin mo28766m();

    void measure(int i, int i2);

    /* renamed from: n */
    boolean mo28767n();

    /* renamed from: o */
    zza mo28768o();

    void onPause();

    void onResume();

    /* renamed from: p */
    void mo28779p();

    /* renamed from: q */
    Activity mo28780q();

    /* renamed from: r */
    void mo28781r();

    /* renamed from: s */
    void mo28782s();

    void setBackgroundColor(int i);

    void setOnClickListener(OnClickListener onClickListener);

    void setOnTouchListener(OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    /* renamed from: t */
    void mo28787t();

    /* renamed from: u */
    zzadx mo28788u();

    /* renamed from: v */
    IObjectWrapper mo28789v();

    /* renamed from: w */
    void mo28790w();

    /* renamed from: x */
    boolean mo28791x();

    /* renamed from: y */
    void mo28792y();

    /* renamed from: z */
    zzbai mo28793z();
}
