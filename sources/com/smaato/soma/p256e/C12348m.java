package com.smaato.soma.p256e;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.smaato.soma.C12369fa;
import com.smaato.soma.C12408ia;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p256e.C12345k.C12346a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.smaato.soma.e.m */
/* compiled from: MediationEventBannerAdapter */
public class C12348m implements C12346a {

    /* renamed from: a */
    private boolean f38579a;

    /* renamed from: b */
    private C12369fa f38580b;

    /* renamed from: c */
    private Context f38581c;

    /* renamed from: d */
    private C12345k f38582d;

    /* renamed from: e */
    private C12346a f38583e;

    /* renamed from: f */
    private C12360w f38584f;

    /* renamed from: g */
    private final Handler f38585g = new Handler();

    /* renamed from: h */
    private final Runnable f38586h;

    /* renamed from: i */
    private String f38587i;

    /* renamed from: a */
    public C12345k mo39759a() {
        return this.f38582d;
    }

    public C12348m(C12369fa mBannerView, String className, C12360w mediationNetworkInfo, C12346a mediationEventBannerListener) {
        this.f38583e = mediationEventBannerListener;
        this.f38580b = mBannerView;
        this.f38581c = mBannerView.getContext();
        this.f38584f = mediationNetworkInfo;
        this.f38586h = new C12347l(this);
        try {
            if (m40588a(mediationNetworkInfo) && className != null) {
                if (!className.isEmpty()) {
                    this.f38587i = className;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Attempting to invoke custom event: ");
                    sb.append(className);
                    C12146d.m39965a(new C12147e("MediationEventBannerAdapter", sb.toString(), 1, C12143a.DEBUG));
                    this.f38582d = C12350o.m40600a(className);
                    return;
                }
            }
            mo39597a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
        } catch (NoClassDefFoundError e) {
            m40591g();
        } catch (Exception e2) {
            m40592h();
        }
    }

    /* renamed from: d */
    public void mo39762d() {
        String str = "MediationEventBannerAdapter";
        if (mo39761c() || this.f38582d == null || this.f38587i == null || this.f38584f.mo39798g() == null || this.f38584f.mo39798g().isEmpty()) {
            mo39597a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
            mo39760b();
            return;
        }
        if (m40590f() > 0) {
            this.f38585g.postDelayed(this.f38586h, (long) m40590f());
        }
        try {
            Map i = this.f38584f.mo39801i();
            if (i == null) {
                i = new HashMap();
            }
            i.put("CUSTOM_WIDTH", String.valueOf(this.f38584f.mo39802j()));
            i.put("CUSTOM_HEIGHT", String.valueOf(this.f38584f.mo39794e()));
            this.f38582d.getClass().getMethod(this.f38584f.mo39798g(), new Class[]{Context.class, C12346a.class, Map.class}).invoke(this.f38582d, new Object[]{this.f38581c, this, i});
        } catch (RuntimeException e) {
            C12146d.m39965a(new C12147e(str, "Loading a custom event banner configuration exception.", 1, C12143a.DEBUG));
            mo39597a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
            mo39760b();
        } catch (Exception e2) {
            C12146d.m39965a(new C12147e(str, "Loading a custom event banner threw an exception.", 1, C12143a.DEBUG));
            mo39597a(C12408ia.GENERAL_ERROR);
            mo39760b();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo39760b() {
        try {
            if (this.f38582d != null) {
                try {
                    this.f38582d.mo39740a();
                } catch (Exception e) {
                    C12146d.m39965a(new C12147e("MediationEventBannerAdapter", "Invalidating a custom event banner threw an exception", 1, C12143a.DEBUG));
                }
            }
            this.f38581c = null;
            this.f38582d = null;
            this.f38579a = true;
        } catch (Exception | RuntimeException e2) {
        }
    }

    /* renamed from: a */
    private boolean m40588a(C12360w mediationNetworkInfo) {
        if (!(mediationNetworkInfo == null || mediationNetworkInfo == null)) {
            try {
                if (mediationNetworkInfo.mo39801i() != null) {
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo39761c() {
        return this.f38579a;
    }

    /* renamed from: e */
    private void m40589e() {
        this.f38585g.removeCallbacks(this.f38586h);
    }

    /* renamed from: f */
    private int m40590f() {
        return 7500;
    }

    /* renamed from: a */
    public void mo39596a(View receivedView) {
        String str = "MediationEventBannerAdapter";
        try {
            if (!mo39761c()) {
                m40589e();
                if (this.f38580b != null) {
                    this.f38583e.mo39596a(receivedView);
                    C12146d.m39965a(new C12147e(str, "onReceiveAd successfully", 1, C12143a.DEBUG));
                } else {
                    this.f38583e.mo39597a(C12408ia.NETWORK_NO_FILL);
                }
            }
        } catch (Exception e) {
            C12146d.m39965a(new C12147e(str, "Exception with View parent detachment", 1, C12143a.DEBUG));
        }
    }

    /* renamed from: a */
    public void mo39597a(C12408ia errorCode) {
        if (!mo39761c() && this.f38580b != null) {
            if (errorCode == null) {
                errorCode = C12408ia.NETWORK_NO_FILL;
            }
            m40589e();
            this.f38583e.mo39597a(errorCode);
            mo39760b();
        }
    }

    public void onBannerClicked() {
        if (!mo39761c() && this.f38580b != null) {
            C12346a aVar = this.f38583e;
            if (aVar != null) {
                aVar.onBannerClicked();
            }
        }
    }

    /* renamed from: g */
    private void m40591g() {
        C12146d.m39965a(new C12147e("MediationEventBannerAdapter", "Dependencies missing. Check configurations of you Custom Adapter Config.", 1, C12143a.ERROR));
        this.f38583e.mo39597a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
        mo39760b();
    }

    /* renamed from: h */
    private void m40592h() {
        C12146d.m39965a(new C12147e("MediationEventBannerAdapter", "Exception happened with Mediation inputs. Check you Custom Adapter Config.", 1, C12143a.ERROR));
        this.f38583e.mo39597a(C12408ia.ADAPTER_CONFIGURATION_ERROR);
        mo39760b();
    }
}
