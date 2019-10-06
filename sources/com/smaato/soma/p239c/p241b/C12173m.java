package com.smaato.soma.p239c.p241b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Patterns;
import android.webkit.JavascriptInterface;
import com.smaato.soma.C12369fa;
import com.smaato.soma.interstitial.C12428r;
import com.smaato.soma.p236a.C12125n;
import com.smaato.soma.p255d.C12316i;

/* renamed from: com.smaato.soma.c.b.m */
/* compiled from: MraidBridge */
public class C12173m {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C12125n f38166a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Handler f38167b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f38168c;

    public C12173m(Handler handler, Context context, C12125n bannerPackage) {
        this.f38167b = handler;
        this.f38168c = context;
        this.f38166a = bannerPackage;
    }

    /* renamed from: a */
    public Context mo39408a() {
        return this.f38168c;
    }

    @JavascriptInterface
    public void close() {
        new C12164d(this).execute();
    }

    @JavascriptInterface
    public void expand(int x, int y, int width, int height, String URL, boolean useCustomClose) {
        new C12165e(this, URL, useCustomClose).execute();
    }

    @JavascriptInterface
    public void open(String url) {
        new C12166f(this, url).execute();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m40012c(String url) {
        new C12167g(this, url).execute();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo39411b(String url) {
        boolean z = false;
        if (Patterns.WEB_URL.matcher(url).matches()) {
            return false;
        }
        if (mo39408a().getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)), 0) != null) {
            z = true;
        }
        return z;
    }

    @JavascriptInterface
    public void resize(int width, int height, int offsetX, int offsetY, String customClosePosition, boolean allowOffscreen) {
        C12168h hVar = new C12168h(this, width, height, offsetX, offsetY, customClosePosition, allowOffscreen);
        hVar.execute();
    }

    @JavascriptInterface
    public void setOrientationProperties(boolean allowOrientationChange, String forceOrientation) {
        new C12169i(this, allowOrientationChange, forceOrientation).execute();
    }

    @JavascriptInterface
    public void playVideo(String url) {
        new C12170j(this, url).execute();
    }

    @JavascriptInterface
    public void useCustomClose(boolean useCustomClose) {
        new C12171k(this, useCustomClose).execute();
    }

    /* renamed from: a */
    public void mo39409a(Context context) {
        this.f38168c = context;
    }

    /* renamed from: a */
    public boolean mo39410a(String message) {
        return ((Boolean) new C12172l(this, message).execute()).booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m40010b() {
        this.f38167b.sendMessage(this.f38167b.obtainMessage(102));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m40008a(C12316i fraudesType, String urlString, String errorAction) {
        return ((Boolean) new C12163c(this, fraudesType, urlString, errorAction).execute()).booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40001a(C12125n bannerPackage) {
        C12369fa baseView = bannerPackage.mo39355f();
        if (baseView != null) {
            if (baseView instanceof C12428r) {
                m40010b();
            }
            baseView.mo39822e();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40006a(String message, String action) {
        Message msg = this.f38167b.obtainMessage(108);
        Bundle bundle = new Bundle();
        bundle.putString("errorMessage", message);
        bundle.putString("errorAction", action);
        msg.setData(bundle);
        this.f38167b.sendMessage(msg);
    }
}
