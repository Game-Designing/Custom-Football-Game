package com.smaato.soma.p256e;

import android.content.Context;
import com.facebook.C6787r;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.smaato.soma.C12408ia;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p256e.C12357u.C12358a;
import java.util.Map;

/* renamed from: com.smaato.soma.e.f */
/* compiled from: FacebookMediationNative */
public class C12337f extends C12357u {

    /* renamed from: a */
    private C12358a f38560a;

    /* renamed from: b */
    C12338a f38561b;

    /* renamed from: com.smaato.soma.e.f$a */
    /* compiled from: FacebookMediationNative */
    static class C12338a implements AdListener {

        /* renamed from: a */
        private final Context f38562a;

        /* renamed from: b */
        private final NativeAd f38563b;

        /* renamed from: c */
        private final C12358a f38564c;

        /* renamed from: a */
        public NativeAd mo39751a() {
            return this.f38563b;
        }

        C12338a(Context context, NativeAd nativeAd, C12358a customEventNativeListener) {
            this.f38562a = context.getApplicationContext();
            this.f38563b = nativeAd;
            this.f38564c = customEventNativeListener;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo39752b() {
            this.f38563b.setAdListener(this);
            this.f38563b.loadAd();
        }
    }

    /* renamed from: a */
    public void mo39750a(Context context, C12358a mediationEventNativeListener, Map<String, String> map, C12360w mediationNetworkInfo) {
        try {
            this.f38560a = mediationEventNativeListener;
            if (!m40554a(mediationNetworkInfo)) {
                this.f38560a.mo39589a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
                return;
            }
            C6787r.m13806a(mediationNetworkInfo.mo39786b());
            this.f38561b = new C12338a(context, new NativeAd(context, mediationNetworkInfo.mo39782a()), this.f38560a);
            this.f38561b.mo39752b();
        } catch (NoClassDefFoundError e) {
            m40555b();
        } catch (Exception e2) {
            m40556c();
        }
    }

    /* renamed from: a */
    public void mo39749a() {
        try {
            if (this.f38561b != null && this.f38561b.mo39751a() != null) {
                this.f38561b.mo39751a().destroy();
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private boolean m40554a(C12360w mediationNetworkInfo) {
        if (mediationNetworkInfo == null) {
            return false;
        }
        try {
            if (mediationNetworkInfo.mo39782a() == null || mediationNetworkInfo.mo39782a().isEmpty()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: c */
    private void m40556c() {
        C12146d.m39965a(new C12147e("FacebookNative", "Exception happened with Mediation. Check inputs forFacebookNative", 1, C12143a.ERROR));
        this.f38560a.mo39589a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
        mo39749a();
    }

    /* renamed from: b */
    private void m40555b() {
        C12146d.m39965a(new C12147e("FacebookNative", "NoClassDefFoundError happened with Mediation. Check your configurations for FacebookNative", 1, C12143a.ERROR));
        this.f38560a.mo39589a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
        mo39749a();
    }
}
