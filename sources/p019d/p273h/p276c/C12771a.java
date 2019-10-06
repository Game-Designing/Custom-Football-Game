package p019d.p273h.p276c;

import android.app.Activity;
import android.text.TextUtils;
import com.mopub.common.AdType;
import com.vungle.warren.p267ui.VungleActivity;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import p019d.p273h.p276c.p277a.C12772a;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p282f.C12868e;
import p019d.p273h.p276c.p284h.C12912f;

/* renamed from: d.h.c.a */
/* compiled from: AbstractAdUnitManager */
abstract class C12771a implements C12868e {

    /* renamed from: a */
    final String f39255a = "reason";

    /* renamed from: b */
    final String f39256b = "status";

    /* renamed from: c */
    final String f39257c = VungleActivity.PLACEMENT_EXTRA;

    /* renamed from: d */
    final String f39258d = "rewardName";

    /* renamed from: e */
    final String f39259e = "rewardAmount";

    /* renamed from: f */
    final String f39260f = "providerPriority";

    /* renamed from: g */
    C12912f f39261g = new C12912f(AdType.REWARDED_VIDEO, this);

    /* renamed from: h */
    int f39262h;

    /* renamed from: i */
    final CopyOnWriteArrayList<C12791c> f39263i = new CopyOnWriteArrayList<>();

    /* renamed from: j */
    private C12791c f39264j;

    /* renamed from: k */
    private C12791c f39265k;

    /* renamed from: l */
    Activity f39266l;

    /* renamed from: m */
    String f39267m;

    /* renamed from: n */
    String f39268n;

    /* renamed from: o */
    C12802d f39269o = C12802d.m41613c();

    /* renamed from: p */
    boolean f39270p = false;

    /* renamed from: q */
    Boolean f39271q;

    /* renamed from: r */
    boolean f39272r;

    /* renamed from: s */
    boolean f39273s = true;

    /* renamed from: t */
    AtomicBoolean f39274t = new AtomicBoolean();

    /* renamed from: u */
    AtomicBoolean f39275u = new AtomicBoolean();

    /* renamed from: v */
    boolean f39276v = false;

    C12771a() {
    }

    /* renamed from: b */
    public void mo41301b(Activity activity) {
        this.f39274t.set(true);
        if (activity != null) {
            this.f39266l = activity;
        }
        synchronized (this.f39263i) {
            if (this.f39263i != null) {
                Iterator it = this.f39263i.iterator();
                while (it.hasNext()) {
                    ((C12791c) it.next()).mo41392b(activity);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo41298a(Activity activity) {
        this.f39275u.set(true);
        synchronized (this.f39263i) {
            if (this.f39263i != null) {
                Iterator it = this.f39263i.iterator();
                while (it.hasNext()) {
                    ((C12791c) it.next()).mo41386a(activity);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41297a(int numberOfAdaptersToLoad) {
        this.f39262h = numberOfAdaptersToLoad;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41299a(C12791c smash) {
        this.f39263i.add(smash);
        C12912f fVar = this.f39261g;
        if (fVar != null) {
            fVar.mo41687a(smash);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo41303c(C12791c backfill) {
        C12802d dVar = this.f39269o;
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(backfill.mo41398o());
        sb.append(" is set as backfill");
        dVar.mo41427b(aVar, sb.toString(), 0);
        this.f39264j = backfill;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo41308e(C12791c premium) {
        C12802d dVar = this.f39269o;
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(premium.mo41398o());
        sb.append(" is set as premium");
        dVar.mo41427b(aVar, sb.toString(), 0);
        this.f39265k = premium;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C12791c mo41305d() {
        return this.f39264j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public C12791c mo41307e() {
        return this.f39265k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo41306d(C12791c smash) {
        try {
            Integer age = C12747I.m41186g().mo41217b();
            if (age != null) {
                smash.mo41385a(age.intValue());
            }
            String gender = C12747I.m41186g().mo41229f();
            if (!TextUtils.isEmpty(gender)) {
                smash.mo41389a(gender);
            }
            String segment = C12747I.m41186g().mo41236j();
            if (!TextUtils.isEmpty(segment)) {
                smash.mo41393b(segment);
            }
            String pluginType = C12772a.m41416a().mo41311c();
            if (!TextUtils.isEmpty(pluginType)) {
                smash.mo41394b(pluginType, C12772a.m41416a().mo41310b());
            }
            Boolean consent = C12747I.m41186g().mo41221c();
            if (consent != null) {
                smash.mo41395b(consent.booleanValue());
            }
        } catch (Exception e) {
            C12802d dVar = this.f39269o;
            C12801a aVar = C12801a.INTERNAL;
            StringBuilder sb = new StringBuilder();
            sb.append(":setCustomParams():");
            sb.append(e.toString());
            dVar.mo41427b(aVar, sb.toString(), 3);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public synchronized boolean mo41304c() {
        return this.f39273s;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public synchronized C12775b mo41300b(C12791c smash) {
        C12775b providerAdapter;
        try {
            providerAdapter = C12747I.m41186g().mo41216b(smash.mo41403t());
            if (providerAdapter == null) {
                C12802d dVar = this.f39269o;
                C12801a aVar = C12801a.INTERNAL;
                StringBuilder sb = new StringBuilder();
                sb.append("loading ");
                sb.append(smash.mo41403t());
                sb.append(" with reflection");
                dVar.mo41427b(aVar, sb.toString(), 0);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("com.ironsource.adapters.");
                sb2.append(smash.mo41404u().toLowerCase());
                sb2.append(".");
                sb2.append(smash.mo41404u());
                sb2.append("Adapter");
                Class<?> mAdapterClass = Class.forName(sb2.toString());
                providerAdapter = (C12775b) mAdapterClass.getMethod("startAdapter", new Class[]{String.class}).invoke(mAdapterClass, new Object[]{smash.mo41403t()});
            } else {
                C12802d dVar2 = this.f39269o;
                C12801a aVar2 = C12801a.INTERNAL;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("using previously loaded ");
                sb3.append(smash.mo41403t());
                dVar2.mo41427b(aVar2, sb3.toString(), 0);
            }
        } catch (Exception e) {
            return null;
        }
        return providerAdapter;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo41302b(boolean consent) {
        Iterator it = this.f39263i.iterator();
        while (it.hasNext()) {
            C12791c smash = (C12791c) it.next();
            if (smash != null) {
                smash.mo41395b(consent);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo41309f() {
        if (!this.f39275u.get()) {
            this.f39269o.mo41427b(C12801a.NATIVE, "IronSource.onPause() wasn't overridden in your activity lifecycle!", 3);
        }
        if (!this.f39274t.get()) {
            this.f39269o.mo41427b(C12801a.NATIVE, "IronSource.onResume() wasn't overridden in your activity lifecycle!", 3);
        }
    }
}
