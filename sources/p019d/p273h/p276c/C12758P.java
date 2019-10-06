package p019d.p273h.p276c;

import android.app.Activity;
import android.text.TextUtils;
import com.vungle.warren.p267ui.VungleActivity;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import p019d.p273h.p275b.C12733b;
import p019d.p273h.p276c.p278b.C12787k;
import p019d.p273h.p276c.p280d.C12799b;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p281e.C12826q;
import p019d.p273h.p276c.p282f.C12861aa;
import p019d.p273h.p276c.p282f.C12876i;
import p019d.p273h.p276c.p282f.C12878j;
import p019d.p273h.p276c.p284h.C12913g;
import p019d.p273h.p276c.p284h.C12916j;
import p019d.p273h.p276c.p284h.C12917k;

/* renamed from: d.h.c.P */
/* compiled from: OfferwallManager */
class C12758P implements C12876i, C12878j {

    /* renamed from: a */
    private final String f39184a = getClass().getName();

    /* renamed from: b */
    private C12861aa f39185b;

    /* renamed from: c */
    private C12878j f39186c;

    /* renamed from: d */
    private C12802d f39187d = C12802d.m41613c();

    /* renamed from: e */
    private AtomicBoolean f39188e = new AtomicBoolean(true);

    /* renamed from: f */
    private AtomicBoolean f39189f = new AtomicBoolean(false);

    /* renamed from: g */
    private C12917k f39190g;

    /* renamed from: h */
    private C12826q f39191h;

    /* renamed from: i */
    private String f39192i;

    /* renamed from: j */
    private Activity f39193j;

    C12758P() {
    }

    /* renamed from: a */
    public synchronized void mo41252a(Activity activity, String appKey, String userId) {
        C12802d dVar = this.f39187d;
        C12801a aVar = C12801a.NATIVE;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f39184a);
        sb.append(":initOfferwall(appKey: ");
        sb.append(appKey);
        sb.append(", userId: ");
        sb.append(userId);
        sb.append(")");
        dVar.mo41427b(aVar, sb.toString(), 1);
        this.f39193j = activity;
        this.f39190g = C12747I.m41186g().mo41224d();
        if (this.f39190g == null) {
            m41288a(C12913g.m41923b("Please check configurations for Offerwall adapters", "Offerwall"));
            return;
        }
        this.f39191h = this.f39190g.mo41695d().mo41560b("SupersonicAds");
        if (this.f39191h == null) {
            m41288a(C12913g.m41923b("Please check configurations for Offerwall adapters", "Offerwall"));
            return;
        }
        C12775b offerwallAdapter = m41286a();
        if (offerwallAdapter == null) {
            m41288a(C12913g.m41923b("Please check configurations for Offerwall adapters", "Offerwall"));
            return;
        }
        m41287a(offerwallAdapter);
        offerwallAdapter.setLogListener(this.f39187d);
        this.f39185b = (C12861aa) offerwallAdapter;
        this.f39185b.setInternalOfferwallListener(this);
        this.f39185b.initOfferwall(activity, appKey, userId, this.f39191h.mo41554k());
    }

    /* renamed from: a */
    public void mo41253a(C12878j listener) {
        this.f39186c = listener;
    }

    /* renamed from: b */
    public void mo41256b(boolean isAvailable) {
        mo41254a(isAvailable, null);
    }

    /* renamed from: a */
    public void mo41254a(boolean isAvailable, C12799b error) {
        C12802d dVar = this.f39187d;
        C12801a aVar = C12801a.ADAPTER_CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onOfferwallAvailable(isAvailable: ");
        sb.append(isAvailable);
        sb.append(")");
        dVar.mo41427b(aVar, sb.toString(), 1);
        if (isAvailable) {
            this.f39189f.set(true);
            C12878j jVar = this.f39186c;
            if (jVar != null) {
                jVar.mo41256b(true);
                return;
            }
            return;
        }
        m41288a(error);
    }

    /* renamed from: f */
    public void mo41259f() {
        this.f39187d.mo41427b(C12801a.ADAPTER_CALLBACK, "onOfferwallOpened()", 1);
        JSONObject data = C12916j.m41965a(false);
        try {
            if (!TextUtils.isEmpty(this.f39192i)) {
                data.put(VungleActivity.PLACEMENT_EXTRA, this.f39192i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C12787k.m41517g().mo41369d(new C12733b(305, data));
        C12878j jVar = this.f39186c;
        if (jVar != null) {
            jVar.mo41259f();
        }
    }

    /* renamed from: e */
    public void mo41258e(C12799b error) {
        C12802d dVar = this.f39187d;
        C12801a aVar = C12801a.ADAPTER_CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onOfferwallShowFailed(");
        sb.append(error);
        sb.append(")");
        dVar.mo41427b(aVar, sb.toString(), 1);
        C12878j jVar = this.f39186c;
        if (jVar != null) {
            jVar.mo41258e(error);
        }
    }

    /* renamed from: a */
    public boolean mo41255a(int credits, int totalCredits, boolean totalCreditsFlag) {
        this.f39187d.mo41427b(C12801a.ADAPTER_CALLBACK, "onOfferwallAdCredited()", 1);
        C12878j jVar = this.f39186c;
        if (jVar != null) {
            return jVar.mo41255a(credits, totalCredits, totalCreditsFlag);
        }
        return false;
    }

    /* renamed from: d */
    public void mo41257d(C12799b error) {
        C12802d dVar = this.f39187d;
        C12801a aVar = C12801a.ADAPTER_CALLBACK;
        StringBuilder sb = new StringBuilder();
        sb.append("onGetOfferwallCreditsFailed(");
        sb.append(error);
        sb.append(")");
        dVar.mo41427b(aVar, sb.toString(), 1);
        C12878j jVar = this.f39186c;
        if (jVar != null) {
            jVar.mo41257d(error);
        }
    }

    /* renamed from: g */
    public void mo41260g() {
        this.f39187d.mo41427b(C12801a.ADAPTER_CALLBACK, "onOfferwallClosed()", 1);
        C12878j jVar = this.f39186c;
        if (jVar != null) {
            jVar.mo41260g();
        }
    }

    /* renamed from: a */
    private synchronized void m41288a(C12799b error) {
        if (this.f39189f != null) {
            this.f39189f.set(false);
        }
        if (this.f39188e != null) {
            this.f39188e.set(true);
        }
        if (this.f39186c != null) {
            this.f39186c.mo41254a(false, error);
        }
    }

    /* renamed from: a */
    private C12775b m41286a() {
        String str = "SupersonicAds";
        try {
            C12747I sso = C12747I.m41186g();
            C12775b providerAdapter = sso.mo41216b(str);
            if (providerAdapter == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("com.ironsource.adapters.");
                sb.append(str.toLowerCase());
                sb.append(".");
                sb.append(str);
                sb.append("Adapter");
                Class<?> mAdapterClass = Class.forName(sb.toString());
                providerAdapter = (C12775b) mAdapterClass.getMethod("startAdapter", new Class[]{String.class}).invoke(mAdapterClass, new Object[]{str});
                if (providerAdapter == null) {
                    return null;
                }
            }
            sso.mo41209a(providerAdapter);
            return providerAdapter;
        } catch (Throwable e) {
            this.f39187d.mo41427b(C12801a.API, "SupersonicAds initialization failed - please verify that required dependencies are in you build path.", 2);
            C12802d dVar = this.f39187d;
            C12801a aVar = C12801a.API;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f39184a);
            sb2.append(":startOfferwallAdapter");
            dVar.mo41426a(aVar, sb2.toString(), e);
            return null;
        }
    }

    /* renamed from: a */
    private void m41287a(C12775b providerAdapter) {
        try {
            Integer age = C12747I.m41186g().mo41217b();
            if (age != null) {
                providerAdapter.setAge(age.intValue());
            }
            String gender = C12747I.m41186g().mo41229f();
            if (gender != null) {
                providerAdapter.setGender(gender);
            }
            String segment = C12747I.m41186g().mo41236j();
            if (segment != null) {
                providerAdapter.setMediationSegment(segment);
            }
            Boolean consent = C12747I.m41186g().mo41221c();
            if (consent != null) {
                C12802d dVar = this.f39187d;
                C12801a aVar = C12801a.ADAPTER_API;
                StringBuilder sb = new StringBuilder();
                sb.append("Offerwall | setConsent(consent:");
                sb.append(consent);
                sb.append(")");
                dVar.mo41427b(aVar, sb.toString(), 1);
                providerAdapter.setConsent(consent.booleanValue());
            }
        } catch (Exception e) {
            C12802d dVar2 = this.f39187d;
            C12801a aVar2 = C12801a.INTERNAL;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(":setCustomParams():");
            sb2.append(e.toString());
            dVar2.mo41427b(aVar2, sb2.toString(), 3);
        }
    }
}
