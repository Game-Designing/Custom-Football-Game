package p019d.p273h.p276c;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import p019d.p273h.p276c.p280d.C12799b;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p282f.C12862b;

/* renamed from: d.h.c.G */
/* compiled from: IronSourceBannerLayout */
public class C12745G extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public View f39086a;

    /* renamed from: b */
    private C12939q f39087b;

    /* renamed from: c */
    private String f39088c;

    /* renamed from: d */
    private Activity f39089d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f39090e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C12862b f39091f;

    public View getBannerView() {
        return this.f39086a;
    }

    public Activity getActivity() {
        return this.f39089d;
    }

    public C12939q getSize() {
        return this.f39087b;
    }

    public String getPlacementName() {
        return this.f39088c;
    }

    public void setPlacementName(String placementName) {
        this.f39088c = placementName;
    }

    public void setBannerListener(C12862b listener) {
        C12802d.m41613c().mo41427b(C12801a.API, "setBannerListener()", 1);
        this.f39091f = listener;
    }

    public C12862b getBannerListener() {
        return this.f39091f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41193a(C12932n smash) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append("onBannerAdLoaded() | internal | adapter: ");
        sb.append(smash.mo41731d());
        c.mo41427b(aVar, sb.toString(), 0);
        if (this.f39091f != null && !this.f39090e) {
            C12802d.m41613c().mo41427b(C12801a.CALLBACK, "onBannerAdLoaded()", 1);
            this.f39091f.mo41630b();
        }
        this.f39090e = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41192a(C12799b error) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onBannerAdLoadFailed()  error=");
        sb.append(error);
        c.mo41427b(aVar, sb.toString(), 1);
        new Handler(Looper.getMainLooper()).post(new C12743E(this, error));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41190a() {
        if (this.f39091f != null) {
            C12802d.m41613c().mo41427b(C12801a.CALLBACK, "onBannerAdClicked()", 1);
            this.f39091f.mo41628a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41191a(View adView, LayoutParams layoutParams) {
        new Handler(Looper.getMainLooper()).post(new C12744F(this, adView, layoutParams));
    }
}
