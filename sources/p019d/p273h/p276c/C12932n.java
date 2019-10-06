package p019d.p273h.p276c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import java.util.Timer;
import p019d.p273h.p276c.p277a.C12772a;
import p019d.p273h.p276c.p280d.C12799b;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p281e.C12826q;
import p019d.p273h.p276c.p282f.C12864c;
import p019d.p273h.p276c.p282f.C12866d;

/* renamed from: d.h.c.n */
/* compiled from: BannerSmash */
public class C12932n implements C12866d {

    /* renamed from: a */
    private C12775b f39795a;

    /* renamed from: b */
    private Timer f39796b;

    /* renamed from: c */
    private long f39797c;

    /* renamed from: d */
    private C12826q f39798d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C12933a f39799e = C12933a.NO_INIT;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C12864c f39800f;

    /* renamed from: g */
    private boolean f39801g;

    /* renamed from: h */
    private C12745G f39802h;

    /* renamed from: i */
    private int f39803i;

    /* renamed from: d.h.c.n$a */
    /* compiled from: BannerSmash */
    protected enum C12933a {
        NO_INIT,
        INIT_IN_PROGRESS,
        LOAD_IN_PROGRESS,
        LOADED,
        LOAD_FAILED,
        DESTROYED
    }

    C12932n(C12864c listener, C12826q adapterConfigs, C12775b adapter, long timeout, int providerPriority) {
        this.f39803i = providerPriority;
        this.f39800f = listener;
        this.f39795a = adapter;
        this.f39798d = adapterConfigs;
        this.f39797c = timeout;
        this.f39795a.addBannerListener(this);
    }

    /* renamed from: g */
    public boolean mo41734g() {
        return this.f39801g;
    }

    /* renamed from: b */
    public void mo41729b(boolean isReadyToLoad) {
        this.f39801g = isReadyToLoad;
    }

    /* renamed from: e */
    public int mo41732e() {
        return this.f39803i;
    }

    /* renamed from: d */
    public String mo41731d() {
        if (this.f39798d.mo41556m()) {
            return this.f39798d.mo41552i();
        }
        return this.f39798d.mo41551h();
    }

    /* renamed from: b */
    public String mo41727b() {
        if (!TextUtils.isEmpty(this.f39798d.mo41532a())) {
            return this.f39798d.mo41532a();
        }
        return mo41731d();
    }

    /* renamed from: f */
    public String mo41733f() {
        return this.f39798d.mo41555l();
    }

    /* renamed from: c */
    public C12775b mo41730c() {
        return this.f39795a;
    }

    /* renamed from: a */
    public void mo41725a(C12745G bannerLayout, Activity activity, String appKey, String userId) {
        m42062a("loadBanner()");
        this.f39801g = false;
        if (bannerLayout == null) {
            this.f39800f.mo41631a(new C12799b(610, "banner==null"), this, false);
        } else if (this.f39795a == null) {
            this.f39800f.mo41631a(new C12799b(611, "adapter==null"), this, false);
        } else {
            this.f39802h = bannerLayout;
            m42066j();
            if (this.f39799e == C12933a.NO_INIT) {
                m42059a(C12933a.INIT_IN_PROGRESS);
                m42065i();
                this.f39795a.initBanners(activity, appKey, userId, this.f39798d.mo41547d(), this);
            } else {
                m42059a(C12933a.LOAD_IN_PROGRESS);
                this.f39795a.loadBanner(bannerLayout, this.f39798d.mo41547d(), this);
            }
        }
    }

    /* renamed from: h */
    public void mo41735h() {
        m42062a("reloadBanner()");
        m42066j();
        this.f39795a.reloadBanner(this.f39798d.mo41547d());
    }

    /* renamed from: i */
    private void m42065i() {
        if (this.f39795a != null) {
            try {
                Integer age = C12747I.m41186g().mo41217b();
                if (age != null) {
                    this.f39795a.setAge(age.intValue());
                }
                String gender = C12747I.m41186g().mo41229f();
                if (!TextUtils.isEmpty(gender)) {
                    this.f39795a.setGender(gender);
                }
                String segment = C12747I.m41186g().mo41236j();
                if (!TextUtils.isEmpty(segment)) {
                    this.f39795a.setMediationSegment(segment);
                }
                String pluginType = C12772a.m41416a().mo41311c();
                if (!TextUtils.isEmpty(pluginType)) {
                    this.f39795a.setPluginData(pluginType, C12772a.m41416a().mo41310b());
                }
                Boolean consent = C12747I.m41186g().mo41221c();
                if (consent != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("setConsent(");
                    sb.append(consent);
                    sb.append(")");
                    m42062a(sb.toString());
                    this.f39795a.setConsent(consent.booleanValue());
                }
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(":setCustomParams():");
                sb2.append(e.toString());
                m42062a(sb2.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m42059a(C12933a state) {
        this.f39799e = state;
        StringBuilder sb = new StringBuilder();
        sb.append("state=");
        sb.append(state.name());
        m42062a(sb.toString());
    }

    /* renamed from: k */
    private void m42067k() {
        try {
            if (this.f39796b != null) {
                this.f39796b.cancel();
            }
        } catch (Exception e) {
            m42063a("stopLoadTimer", e.getLocalizedMessage());
        } catch (Throwable th) {
            this.f39796b = null;
            throw th;
        }
        this.f39796b = null;
    }

    /* renamed from: j */
    private void m42066j() {
        try {
            m42067k();
            this.f39796b = new Timer();
            this.f39796b.schedule(new C12930m(this), this.f39797c);
        } catch (Exception e) {
            m42063a("startLoadTimer", e.getLocalizedMessage());
        }
    }

    public void onBannerInitSuccess() {
        m42067k();
        if (this.f39799e == C12933a.INIT_IN_PROGRESS) {
            m42066j();
            m42059a(C12933a.LOAD_IN_PROGRESS);
            this.f39795a.loadBanner(this.f39802h, this.f39798d.mo41547d(), this);
        }
    }

    /* renamed from: b */
    public void mo41639b(C12799b error) {
        m42067k();
        if (this.f39799e == C12933a.INIT_IN_PROGRESS) {
            this.f39800f.mo41631a(new C12799b(612, "Banner init failed"), this, false);
            m42059a(C12933a.NO_INIT);
        }
    }

    /* renamed from: a */
    public void mo41637a(View adView, LayoutParams frameLayoutParams) {
        m42062a("onBannerAdLoaded()");
        m42067k();
        C12933a aVar = this.f39799e;
        if (aVar == C12933a.LOAD_IN_PROGRESS) {
            m42059a(C12933a.LOADED);
            this.f39800f.mo41633a(this, adView, frameLayoutParams);
        } else if (aVar == C12933a.LOADED) {
            this.f39800f.mo41632a(this);
        }
    }

    /* renamed from: a */
    public void mo41638a(C12799b error) {
        m42062a("onBannerAdLoadFailed()");
        m42067k();
        boolean isNoFillError = error.mo41428a() == 606;
        C12933a aVar = this.f39799e;
        if (aVar == C12933a.LOAD_IN_PROGRESS) {
            m42059a(C12933a.LOAD_FAILED);
            this.f39800f.mo41631a(error, this, isNoFillError);
        } else if (aVar == C12933a.LOADED) {
            this.f39800f.mo41634b(error, this, isNoFillError);
        }
    }

    /* renamed from: a */
    public void mo41636a() {
        C12864c cVar = this.f39800f;
        if (cVar != null) {
            cVar.mo41635b(this);
        }
    }

    /* renamed from: a */
    public void mo41726a(boolean consent) {
        if (this.f39795a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("setConsent(");
            sb.append(consent);
            sb.append(")");
            m42062a(sb.toString());
            this.f39795a.setConsent(consent);
        }
    }

    /* renamed from: a */
    public void mo41724a(Activity activity) {
        C12775b bVar = this.f39795a;
        if (bVar != null) {
            bVar.onPause(activity);
        }
    }

    /* renamed from: b */
    public void mo41728b(Activity activity) {
        C12775b bVar = this.f39795a;
        if (bVar != null) {
            bVar.onResume(activity);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m42062a(String text) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.ADAPTER_API;
        StringBuilder sb = new StringBuilder();
        sb.append("BannerSmash ");
        sb.append(mo41731d());
        sb.append(" ");
        sb.append(text);
        c.mo41427b(aVar, sb.toString(), 1);
    }

    /* renamed from: a */
    private void m42063a(String methodName, String errorMessage) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(methodName);
        sb.append(" Banner exception: ");
        sb.append(mo41731d());
        sb.append(" | ");
        sb.append(errorMessage);
        c.mo41427b(aVar, sb.toString(), 3);
    }
}
