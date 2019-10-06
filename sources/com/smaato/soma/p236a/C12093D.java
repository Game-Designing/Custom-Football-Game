package com.smaato.soma.p236a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Patterns;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.AdType;
import com.smaato.soma.C12142b;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p239c.p254k.C12301p;
import com.smaato.soma.p255d.C12316i;

/* renamed from: com.smaato.soma.a.D */
/* compiled from: RedirectingWebViewClient */
public class C12093D extends WebViewClient {

    /* renamed from: a */
    private final Context f37965a;

    /* renamed from: b */
    private final C12125n f37966b;

    /* renamed from: c */
    private C12094E f37967c;

    public C12093D(Context context, C12125n banner) {
        this.f37965a = context;
        this.f37966b = banner;
    }

    public C12093D(Context context, C12125n banner, C12094E redirectionHandler) {
        this.f37965a = context;
        this.f37966b = banner;
        this.f37967c = redirectionHandler;
    }

    /* renamed from: a */
    public boolean mo39322a(String url) {
        C12146d.m39966a((Object) new C12092C(this));
        boolean isRedirectionSuccess = false;
        boolean shouldDispatchOnWillLeaveApp = false;
        if (url != null) {
            if (m39885d(url)) {
                String[] spl = url.split("details\\?");
                if (spl.length > 1) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append("market://details?");
                        sb.append(spl[1]);
                        C12142b.m39963b(sb.toString(), this.f37965a);
                    } catch (Exception e) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("https://play.google.com/store/apps/details?");
                        sb2.append(spl[1]);
                        C12142b.m39963b(sb2.toString(), this.f37965a);
                    }
                    C12125n nVar = this.f37966b;
                    if (nVar != null) {
                        nVar.mo39367r();
                    }
                    shouldDispatchOnWillLeaveApp = true;
                    isRedirectionSuccess = true;
                }
            } else if (m39886e(url)) {
                C12142b.m39962a(url, this.f37965a);
                shouldDispatchOnWillLeaveApp = true;
                isRedirectionSuccess = true;
            } else if (url.startsWith("intent:")) {
                if (m39883b(url)) {
                    C12125n nVar2 = this.f37966b;
                    if (nVar2 != null) {
                        nVar2.mo39367r();
                    }
                    shouldDispatchOnWillLeaveApp = true;
                    isRedirectionSuccess = true;
                }
            } else if (!m39884c(url)) {
                try {
                    if (!C12137x.m39951a().mo39379b()) {
                        if (!url.equalsIgnoreCase("about:blank")) {
                            C12137x.m39951a().mo39377a(true);
                            if (C12142b.m39962a(url, this.f37965a)) {
                                if (this.f37966b != null) {
                                    this.f37966b.mo39367r();
                                }
                                shouldDispatchOnWillLeaveApp = true;
                                isRedirectionSuccess = true;
                            }
                        }
                    }
                    isRedirectionSuccess = true;
                } catch (Exception e2) {
                }
            }
        }
        C12094E e3 = this.f37967c;
        if (e3 != null) {
            e3.mo39245a(isRedirectionSuccess, shouldDispatchOnWillLeaveApp);
        }
        return isRedirectionSuccess;
    }

    /* renamed from: d */
    private boolean m39885d(String url) {
        return (url.contains("play.google.com") || (url.contains("market://") && url.contains("details?"))) && !C12137x.m39951a().mo39379b();
    }

    /* renamed from: e */
    private boolean m39886e(String url) {
        return url.contains("tel:") || url.contains("mailto:") || url.contains("maps:") || url.contains("sms:");
    }

    /* renamed from: c */
    private boolean m39884c(String url) {
        return Patterns.WEB_URL.matcher(url).matches();
    }

    /* renamed from: b */
    private boolean m39883b(String url) {
        String str = "browser_fallback_url";
        String str2 = "android.intent.action.VIEW";
        try {
            Intent intent = Intent.parseUri(url, 1).setFlags(335544320);
            if (intent == null) {
                return false;
            }
            if (intent.getPackage() != null && this.f37965a.getPackageManager().getLaunchIntentForPackage(intent.getPackage()) != null) {
                this.f37965a.startActivity(intent);
                return true;
            } else if (intent.getStringExtra(str) != null) {
                this.f37965a.startActivity(new Intent(str2, Uri.parse(intent.getStringExtra(str))).setFlags(335544320));
                return true;
            } else {
                if (intent.getData() != null) {
                    this.f37965a.startActivity(new Intent(str2, intent.getData()).setFlags(335544320));
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            try {
                this.f37965a.startActivity(new Intent(str2, Uri.parse(url)).setFlags(335544320));
                return true;
            } catch (Exception e2) {
            }
        }
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        boolean redirectSucceeded = false;
        boolean z = true;
        if (url != null && (url.startsWith(AdType.MRAID) || url.startsWith("smaato"))) {
            return true;
        }
        if (!(view instanceof C12301p) || ((C12301p) view).mo39721a()) {
            redirectSucceeded = mo39322a(url);
            C12125n nVar = this.f37966b;
            if (nVar != null) {
                nVar.mo39347a(redirectSucceeded);
                if (!(this.f37966b.mo39362m() == null || this.f37966b.mo39362m().mo39328b() == null)) {
                    this.f37966b.mo39362m().mo39328b().mo39244a(redirectSucceeded);
                }
            }
        } else if (url != null && !url.equals("about:blank") && (m39885d(url) || m39886e(url) || url.startsWith("intent:") || !m39884c(url))) {
            ((C12301p) view).mo39720a(C12316i.AUTO_REDIRECT, url);
        }
        if (!redirectSucceeded && m39884c(url)) {
            z = false;
        }
        return z;
    }

    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        view.loadUrl("about:blank");
    }
}
