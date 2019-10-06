package p019d.p143b.p144a.p145a;

import com.mopub.mobileads.VastIconXmlManager;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p019d.p143b.p144a.p147c.C7178l;
import p019d.p143b.p144a.p147c.C7209sc;
import p019d.p143b.p144a.p147c.C7217uc;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.a.l */
public class C6936l {

    /* renamed from: a */
    private String f12800a;

    /* renamed from: b */
    private String f12801b;

    /* renamed from: c */
    private String f12802c;

    /* renamed from: d */
    private long f12803d = -1;

    /* renamed from: e */
    private int f12804e = -1;

    private C6936l() {
    }

    /* renamed from: a */
    private static int m14194a(String str, C6931g gVar) {
        if ("start".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("firstQuartile".equalsIgnoreCase(str)) {
            return 25;
        }
        if ("midpoint".equalsIgnoreCase(str)) {
            return 50;
        }
        if ("thirdQuartile".equalsIgnoreCase(str)) {
            return 75;
        }
        if (!"complete".equalsIgnoreCase(str)) {
            return -1;
        }
        return gVar != null ? gVar.mo22446i() : 95;
    }

    /* renamed from: a */
    public static C6936l m14195a(C7217uc ucVar, C6931g gVar, C7267q qVar) {
        TimeUnit timeUnit;
        long seconds;
        String str = ":";
        String str2 = "VastTracker";
        if (ucVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (qVar != null) {
            try {
                String c = ucVar.mo23352c();
                if (C7269s.m15819a(c)) {
                    C6936l lVar = new C6936l();
                    lVar.f12802c = c;
                    lVar.f12800a = (String) ucVar.mo23350b().get("id");
                    lVar.f12801b = (String) ucVar.mo23350b().get("event");
                    lVar.f12804e = m14194a(lVar.mo22459a(), gVar);
                    String str3 = (String) ucVar.mo23350b().get(VastIconXmlManager.OFFSET);
                    if (C7269s.m15819a(str3)) {
                        String trim = str3.trim();
                        if (trim.contains("%")) {
                            lVar.f12804e = C7209sc.m15491f(trim.substring(0, trim.length() - 1));
                        } else if (trim.contains(str)) {
                            List a = C7178l.m15310a(trim, str);
                            int size = a.size();
                            if (size > 0) {
                                long j = 0;
                                int i = size - 1;
                                for (int i2 = i; i2 >= 0; i2--) {
                                    String str4 = (String) a.get(i2);
                                    if (C7209sc.m15490e(str4)) {
                                        int parseInt = Integer.parseInt(str4);
                                        if (i2 == i) {
                                            seconds = (long) parseInt;
                                        } else {
                                            if (i2 == size - 2) {
                                                timeUnit = TimeUnit.MINUTES;
                                            } else if (i2 == size - 3) {
                                                timeUnit = TimeUnit.HOURS;
                                            }
                                            seconds = timeUnit.toSeconds((long) parseInt);
                                        }
                                        j += seconds;
                                    }
                                }
                                lVar.f12803d = j;
                                lVar.f12804e = -1;
                            }
                        } else {
                            C7262l b = qVar.mo23049b();
                            StringBuilder sb = new StringBuilder();
                            sb.append("Unable to parse time offset from rawOffsetString = ");
                            sb.append(trim);
                            b.mo22916b(str2, sb.toString());
                        }
                    }
                    return lVar;
                }
                qVar.mo23049b().mo22916b(str2, "Unable to create tracker. Could not find URL.");
                return null;
            } catch (Throwable th) {
                qVar.mo23049b().mo22917b(str2, "Error occurred while initializing", th);
            }
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    public String mo22459a() {
        return this.f12801b;
    }

    /* renamed from: a */
    public boolean mo22460a(long j, int i) {
        boolean z = this.f12803d >= 0;
        boolean z2 = j >= this.f12803d;
        boolean z3 = this.f12804e >= 0;
        boolean z4 = i >= this.f12804e;
        if (!z || !z2) {
            return z3 && z4;
        }
        return true;
    }

    /* renamed from: b */
    public String mo22461b() {
        return this.f12802c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6936l)) {
            return false;
        }
        C6936l lVar = (C6936l) obj;
        if (this.f12803d != lVar.f12803d || this.f12804e != lVar.f12804e) {
            return false;
        }
        String str = this.f12800a;
        if (str == null ? lVar.f12800a != null : !str.equals(lVar.f12800a)) {
            return false;
        }
        String str2 = this.f12801b;
        if (str2 == null ? lVar.f12801b == null : str2.equals(lVar.f12801b)) {
            return this.f12802c.equals(lVar.f12802c);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f12800a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f12801b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int hashCode2 = (((hashCode + i) * 31) + this.f12802c.hashCode()) * 31;
        long j = this.f12803d;
        return ((hashCode2 + ((int) (j ^ (j >>> 32)))) * 31) + this.f12804e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VastTracker{identifier='");
        sb.append(this.f12800a);
        sb.append('\'');
        sb.append(", event='");
        sb.append(this.f12801b);
        sb.append('\'');
        sb.append(", uriString='");
        sb.append(this.f12802c);
        sb.append('\'');
        sb.append(", offsetSeconds=");
        sb.append(this.f12803d);
        sb.append(", offsetPercent=");
        sb.append(this.f12804e);
        sb.append('}');
        return sb.toString();
    }
}
