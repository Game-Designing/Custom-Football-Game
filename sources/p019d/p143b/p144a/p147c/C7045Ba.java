package p019d.p143b.p144a.p147c;

import android.content.pm.ApplicationInfo;
import com.integralads.avid.library.inmobi.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import p019d.p143b.p148b.C7239b;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.c.Ba */
class C7045Ba {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Map<String, String> f13153a = new HashMap();

    /* renamed from: b */
    private final C7142c f13154b;

    /* renamed from: c */
    private final C7262l f13155c;

    /* renamed from: d */
    private final Object f13156d = new Object();

    /* renamed from: e */
    private final Map<String, C7053Da> f13157e = new HashMap();

    /* renamed from: f */
    private final Collection<String> f13158f = new HashSet();

    /* renamed from: g */
    private final Collection<C7049Ca> f13159g = new HashSet();

    static {
        f13153a.put("chartboost", "com.applovin.mediation.impl.AppLovinChartboostMediationAdapter");
        f13153a.put("facebook", "com.applovin.mediation.impl.AppLovinFacebookMediationAdapter");
        f13153a.put("google", "com.applovin.mediation.impl.AppLovinGoogleMediationAdapter");
        f13153a.put("heyzap", "com.applovin.mediation.impl.AppLovinHeyzapMediationAdapter");
        f13153a.put(BuildConfig.SDK_NAME, "com.applovin.mediation.impl.AppLovinInMobiMediationAdapter");
        f13153a.put(com.integralads.avid.library.mopub.BuildConfig.SDK_NAME, "com.applovin.mediation.impl.AppLovinMoPubMediationAdapter");
        f13153a.put("ironsource", "com.applovin.mediation.impl.AppLovinIronSourceMediationAdapter");
        f13153a.put(com.mopub.mobileads.vungle.BuildConfig.NETWORK_NAME, "com.applovin.mediation.impl.AppLovinVungleMediationAdapter");
        f13153a.put("unity", "com.applovin.mediation.impl.AppLovinUnityMediationAdapter");
    }

    C7045Ba(C7142c cVar) {
        if (cVar != null) {
            this.f13154b = cVar;
            this.f13155c = cVar.mo23049b();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* renamed from: a */
    private C7053Da m14591a(C7049Ca ca, Map<String, String> map) {
        if (ca != null) {
            synchronized (this.f13156d) {
                String a = ca.mo22766a();
                if (this.f13158f.contains(a)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Not attempting to load ");
                    sb.append(ca);
                    sb.append(" due to prior errors");
                    this.f13155c.mo22918c("MediationAdapterManager", sb.toString());
                    return null;
                } else if (this.f13157e.containsKey(a)) {
                    C7053Da da = (C7053Da) this.f13157e.get(a);
                    return da;
                } else {
                    C7053Da b = m14594b(ca, map);
                    if (b != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Loaded ");
                        sb2.append(ca);
                        this.f13155c.mo22918c("MediationAdapterManager", sb2.toString());
                        this.f13157e.put(a, b);
                        return b;
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Failed to load ");
                    sb3.append(ca);
                    this.f13155c.mo22916b("MediationAdapterManager", sb3.toString());
                    this.f13158f.add(a);
                    return null;
                }
            }
        } else {
            throw new IllegalArgumentException("No adapter spec specified");
        }
    }

    /* renamed from: a */
    private String m14592a(String str) {
        if (!C7269s.m15819a(str)) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = this.f13154b.mo23068m().getPackageManager().getApplicationInfo(this.f13154b.mo23068m().getPackageName(), 128);
            Collection<C7049Ca> b = C7049Ca.m14624b(applicationInfo.metaData.getString("applovin.mediation:load"), this.f13155c);
            if (!b.isEmpty()) {
                for (C7049Ca ca : b) {
                    if (ca.mo22767b().equalsIgnoreCase(str) && C7269s.m15819a(ca.mo22766a())) {
                        return ca.mo22766a();
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("applovin.mediation.");
            sb.append(str);
            sb.append(":");
            sb.append("class");
            return applicationInfo.metaData.getString(sb.toString());
        } catch (Throwable th) {
            C7262l lVar = this.f13155c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to retrieve classname from Android Manifest for adapter name: ");
            sb2.append(str);
            lVar.mo22917b("MediationAdapterManager", sb2.toString(), th);
            return null;
        }
    }

    /* renamed from: a */
    private void m14593a(Collection<C7049Ca> collection, String str) {
        for (C7049Ca ca : collection) {
            C7053Da a = mo22747a(ca.mo22767b(), ca.mo22766a(), null);
            if (a != null) {
                C7262l lVar = this.f13155c;
                StringBuilder sb = new StringBuilder();
                sb.append("Loaded ");
                sb.append(str);
                sb.append(" adapter: ");
                sb.append(a);
                lVar.mo22920d("MediationAdapterManager", sb.toString());
            }
        }
    }

    /* renamed from: b */
    private C7053Da m14594b(C7049Ca ca, Map<String, String> map) {
        String str = "MediationAdapterManager";
        try {
            Class cls = Class.forName(ca.mo22766a());
            if (cls != null) {
                Object newInstance = cls.newInstance();
                if (newInstance instanceof C7239b) {
                    C7053Da da = new C7053Da(ca.mo22767b(), (C7239b) newInstance, this.f13154b);
                    da.mo22786a(map);
                    if (da.mo22787b()) {
                        return da;
                    }
                    C7262l lVar = this.f13155c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to initialize ");
                    sb.append(ca);
                    lVar.mo22921e(str, sb.toString());
                    return null;
                }
                C7262l lVar2 = this.f13155c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ca);
                sb2.append(" error: not an instance of '");
                sb2.append(C7239b.class.getName());
                sb2.append("'.");
                lVar2.mo22921e(str, sb2.toString());
                return null;
            }
            C7262l lVar3 = this.f13155c;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("No class found for ");
            sb3.append(ca);
            lVar3.mo22921e(str, sb3.toString());
            return null;
        } catch (Throwable th) {
            C7262l lVar4 = this.f13155c;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Failed to load: ");
            sb4.append(ca);
            lVar4.mo22919c(str, sb4.toString(), th);
            return null;
        }
    }

    /* renamed from: e */
    private Collection<C7049Ca> m14596e() {
        C7262l lVar;
        String sb;
        C7049Ca ca;
        String str = "MediationAdapterManager";
        try {
            ApplicationInfo applicationInfo = this.f13154b.mo23068m().getPackageManager().getApplicationInfo(this.f13154b.mo23068m().getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                return Collections.emptyList();
            }
            String string = applicationInfo.metaData.getString("applovin.mediation:load");
            Collection<C7049Ca> b = C7049Ca.m14624b(string, this.f13155c);
            if (b == null || b.isEmpty()) {
                C7262l lVar2 = this.f13155c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("No adapter specs found in: '");
                sb2.append(string);
                sb2.append("'");
                lVar2.mo22918c(str, sb2.toString());
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList(b.size());
            for (C7049Ca ca2 : b) {
                if (!C7269s.m15819a(ca2.mo22767b())) {
                    lVar = this.f13155c;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Ignored loading of adapter with class ");
                    sb3.append(ca2.mo22766a());
                    sb3.append(": no name specified");
                    sb = sb3.toString();
                } else if (C7269s.m15819a(ca2.mo22766a())) {
                    arrayList.add(ca2);
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("applovin.mediation.");
                    sb4.append(ca2.mo22767b());
                    sb4.append(":");
                    sb4.append("class");
                    String string2 = applicationInfo.metaData.getString(sb4.toString());
                    if (C7269s.m15819a(string2)) {
                        ca = new C7049Ca(ca2.mo22767b(), string2);
                    } else {
                        String str2 = (String) f13153a.get(ca2.mo22767b());
                        if (C7269s.m15819a(str2)) {
                            ca = new C7049Ca(ca2.mo22767b(), str2);
                        } else {
                            lVar = this.f13155c;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("Ignored loading of ");
                            sb5.append(ca2.mo22767b());
                            sb5.append(": no default adapter class found");
                            sb = sb5.toString();
                        }
                    }
                    arrayList.add(ca);
                }
                lVar.mo22921e(str, sb);
            }
            return arrayList;
        } catch (Throwable th) {
            this.f13155c.mo22919c(str, "Unable to load applovin.mediation:loadfrom AndroidManifest.xml", th);
            return Collections.emptyList();
        }
    }

    /* renamed from: f */
    private Collection<C7049Ca> m14597f() {
        return C7049Ca.m14624b((String) this.f13154b.mo23040a(C7216ub.f13978e), this.f13155c);
    }

    /* renamed from: g */
    private void m14598g() {
        String a;
        synchronized (this.f13156d) {
            a = C7049Ca.m14623a(this.f13159g);
        }
        this.f13154b.mo23052b(C7216ub.f13978e, a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C7053Da mo22747a(String str, String str2, Map<String, String> map) {
        String str3;
        String str4;
        StringBuilder sb;
        C7262l lVar;
        String str5 = "MediationAdapterManager";
        if (!C7269s.m15819a(str)) {
            C7262l lVar2 = this.f13155c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No adapter name provided for ");
            sb2.append(str2);
            sb2.append(", not loading the adapter ");
            lVar2.mo22916b(str5, sb2.toString());
            return null;
        }
        if (C7269s.m15819a(str2)) {
            C7262l lVar3 = this.f13155c;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Loading adapter using explicit classname: ");
            sb3.append(str2);
            lVar3.mo22918c(str5, sb3.toString());
            str3 = str2;
        } else {
            String str6 = "Loading '";
            String str7 = "'";
            if (map != null) {
                String str8 = "class";
                if (map.containsKey(str8)) {
                    str3 = (String) map.get(str8);
                    if (C7269s.m15819a(str3)) {
                        lVar = this.f13155c;
                        sb = new StringBuilder();
                        sb.append(str6);
                        sb.append(str);
                        str4 = "' adapter using configured classname: ";
                        sb.append(str4);
                        sb.append(str3);
                        lVar.mo22918c(str5, sb.toString());
                    } else {
                        C7262l lVar4 = this.f13155c;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Invalid configured classname for '");
                        sb4.append(str);
                        sb4.append(str7);
                        lVar4.mo22913a(str5, sb4.toString());
                        return null;
                    }
                }
            }
            str3 = m14592a(str);
            if (!C7269s.m15819a(str3)) {
                str3 = (String) f13153a.get(str.toLowerCase(Locale.ENGLISH));
                if (C7269s.m15819a(str3)) {
                    lVar = this.f13155c;
                    sb = new StringBuilder();
                    sb.append(str6);
                    sb.append(str);
                    str4 = "' adapter using resolved default classname: ";
                    sb.append(str4);
                    sb.append(str3);
                    lVar.mo22918c(str5, sb.toString());
                } else {
                    C7262l lVar5 = this.f13155c;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Unable to find default classname for '");
                    sb5.append(str);
                    sb5.append(str7);
                    lVar5.mo22913a(str5, sb5.toString());
                    return null;
                }
            }
        }
        return m14591a(new C7049Ca(str, str3), map);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22748a() {
        synchronized (this.f13156d) {
            if (((Boolean) this.f13154b.mo23039a(C7196pb.f13703Hd)).booleanValue()) {
                m14593a(m14597f(), "last used");
            }
            if (((Boolean) this.f13154b.mo23039a(C7196pb.f13708Id)).booleanValue()) {
                m14593a(m14596e(), "AndroidManifest");
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo22749a(C7053Da da) {
        if (da != null) {
            C7049Ca ca = new C7049Ca(da.mo22781a(), da.mo22791f());
            synchronized (this.f13156d) {
                if (!this.f13159g.contains(ca)) {
                    this.f13159g.add(ca);
                    m14598g();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Collection<String> mo22750b() {
        ArrayList arrayList;
        synchronized (this.f13156d) {
            arrayList = new ArrayList(this.f13158f);
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Collection<C7053Da> mo22751c() {
        ArrayList arrayList;
        synchronized (this.f13156d) {
            arrayList = new ArrayList(this.f13157e.values());
        }
        return arrayList;
    }
}
