package p019d.p273h.p276c.p281e;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import p019d.p273h.p276c.p284h.C12916j;

/* renamed from: d.h.c.e.r */
/* compiled from: ProviderSettingsHolder */
public class C12827r {

    /* renamed from: a */
    private static C12827r f39516a;

    /* renamed from: b */
    private ArrayList<C12826q> f39517b = new ArrayList<>();

    /* renamed from: b */
    public static synchronized C12827r m41739b() {
        C12827r rVar;
        synchronized (C12827r.class) {
            if (f39516a == null) {
                f39516a = new C12827r();
            }
            rVar = f39516a;
        }
        return rVar;
    }

    private C12827r() {
    }

    /* renamed from: a */
    public void mo41558a(C12826q providerSettings) {
        if (providerSettings != null) {
            this.f39517b.add(providerSettings);
        }
    }

    /* renamed from: b */
    public C12826q mo41560b(String providerName) {
        Iterator it = this.f39517b.iterator();
        while (it.hasNext()) {
            C12826q providerSettings = (C12826q) it.next();
            if (providerSettings.mo41551h().equals(providerName)) {
                return providerSettings;
            }
        }
        C12826q ps = new C12826q(providerName);
        mo41558a(ps);
        return ps;
    }

    /* renamed from: a */
    public boolean mo41559a(String providerName) {
        Iterator it = this.f39517b.iterator();
        while (it.hasNext()) {
            if (((C12826q) it.next()).mo41551h().equals(providerName)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo41557a() {
        Iterator it = this.f39517b.iterator();
        while (it.hasNext()) {
            C12826q providerSettings = (C12826q) it.next();
            if (providerSettings.mo41556m() && !TextUtils.isEmpty(providerSettings.mo41552i())) {
                C12826q commonProviderSettings = mo41560b(providerSettings.mo41552i());
                providerSettings.mo41542b(C12916j.m41964a(providerSettings.mo41549f(), commonProviderSettings.mo41549f()));
                providerSettings.mo41546c(C12916j.m41964a(providerSettings.mo41554k(), commonProviderSettings.mo41554k()));
                providerSettings.mo41536a(C12916j.m41964a(providerSettings.mo41547d(), commonProviderSettings.mo41547d()));
            }
        }
    }
}
