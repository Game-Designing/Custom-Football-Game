package p019d.p273h.p276c.p277a;

import com.mopub.common.logging.MoPubLog;

/* renamed from: d.h.c.a.a */
/* compiled from: ConfigFile */
public class C12772a {

    /* renamed from: a */
    private static C12772a f39277a;

    /* renamed from: b */
    private String f39278b;

    /* renamed from: c */
    private String f39279c;

    /* renamed from: d */
    private String f39280d;

    /* renamed from: e */
    private String[] f39281e = {"Unity", "AdobeAir", "Xamarin", "Corona", "AdMob", MoPubLog.LOGTAG};

    /* renamed from: a */
    public static synchronized C12772a m41416a() {
        C12772a aVar;
        synchronized (C12772a.class) {
            if (f39277a == null) {
                f39277a = new C12772a();
            }
            aVar = f39277a;
        }
        return aVar;
    }

    /* renamed from: c */
    public String mo41311c() {
        return this.f39278b;
    }

    /* renamed from: d */
    public String mo41312d() {
        return this.f39279c;
    }

    /* renamed from: b */
    public String mo41310b() {
        return this.f39280d;
    }
}
