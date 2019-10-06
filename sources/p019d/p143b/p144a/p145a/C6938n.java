package p019d.p143b.p144a.p145a;

import android.net.Uri;
import android.webkit.URLUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import p019d.p143b.p144a.p147c.C7142c;
import p019d.p143b.p144a.p147c.C7209sc;
import p019d.p143b.p144a.p147c.C7217uc;
import p019d.p143b.p150d.C7254d;
import p019d.p143b.p150d.C7262l;
import p019d.p143b.p150d.C7267q;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.a.n */
public class C6938n {

    /* renamed from: a */
    private static DateFormat f12806a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    /* renamed from: b */
    private static Random f12807b = new Random(System.currentTimeMillis());

    /* renamed from: a */
    public static Uri m14199a(String str, long j, Uri uri, C6932h hVar, C7267q qVar) {
        String str2 = "VastUtils";
        if (URLUtil.isValidUrl(str)) {
            try {
                String replace = str.replace("[ERRORCODE]", Integer.toString(hVar.mo22447a()));
                if (j >= 0) {
                    replace = replace.replace("[CONTENTPLAYHEAD]", m14202a(j));
                }
                if (uri != null) {
                    replace = replace.replace("[ASSETURI]", uri.toString());
                }
                return Uri.parse(replace.replace("[CACHEBUSTING]", m14201a()).replace("[TIMESTAMP]", m14214b()));
            } catch (Throwable th) {
                C7262l b = qVar.mo23049b();
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to replace macros in URL string ");
                sb.append(str);
                b.mo22917b(str2, sb.toString(), th);
                return null;
            }
        } else {
            qVar.mo23049b().mo22916b(str2, "Unable to replace macros in invalid URL string.");
            return null;
        }
    }

    /* renamed from: a */
    public static C6932h m14200a(C6925a aVar) {
        if (m14215b(aVar) || m14217c(aVar)) {
            return null;
        }
        return C6932h.GENERAL_WRAPPER_ERROR;
    }

    /* renamed from: a */
    private static String m14201a() {
        return Integer.toString(f12807b.nextInt(89999999) + 10000000);
    }

    /* renamed from: a */
    private static String m14202a(long j) {
        if (j <= 0) {
            return "00:00:00.000";
        }
        return String.format("%02d:%02d:%02d.000", new Object[]{Long.valueOf(TimeUnit.SECONDS.toHours(j)), Long.valueOf(TimeUnit.SECONDS.toMinutes(j) % TimeUnit.MINUTES.toSeconds(1)), Long.valueOf(j % TimeUnit.MINUTES.toSeconds(1))});
    }

    /* renamed from: a */
    public static String m14203a(C6931g gVar) {
        if (gVar != null) {
            List b = gVar.mo22439b();
            int size = gVar.mo22439b().size();
            if (size > 0) {
                C7217uc c = ((C7217uc) b.get(size - 1)).mo23351c("VASTAdTagURI");
                if (c != null) {
                    return c.mo23352c();
                }
            }
            return null;
        }
        throw new IllegalArgumentException("Unable to get resolution uri string for fetching the next wrapper or inline response in the chain");
    }

    /* renamed from: a */
    public static String m14204a(C7217uc ucVar, String str, String str2) {
        C7217uc b = ucVar.mo23349b(str);
        if (b != null) {
            String c = b.mo23352c();
            if (C7269s.m15819a(c)) {
                return c;
            }
        }
        return str2;
    }

    /* renamed from: a */
    private static Set<C6936l> m14205a(C6931g gVar, C7267q qVar) {
        if (gVar == null) {
            return null;
        }
        List<C7217uc> b = gVar.mo22439b();
        HashSet hashSet = new HashSet(b.size());
        for (C7217uc ucVar : b) {
            C7217uc c = ucVar.mo23351c("Wrapper");
            if (c == null) {
                c = ucVar.mo23351c("InLine");
            }
            String str = "Error";
            m14206a((Set<C6936l>) hashSet, c != null ? c.mo23348a(str) : ucVar.mo23348a(str), gVar, qVar);
        }
        C7262l b2 = qVar.mo23049b();
        StringBuilder sb = new StringBuilder();
        sb.append("Retrieved ");
        sb.append(hashSet.size());
        sb.append(" top level error trackers: ");
        sb.append(hashSet);
        b2.mo22918c("VastUtils", sb.toString());
        return hashSet;
    }

    /* renamed from: a */
    private static Set<C6936l> m14206a(Set<C6936l> set, List<C7217uc> list, C6931g gVar, C7267q qVar) {
        if (list != null) {
            for (C7217uc a : list) {
                C6936l a2 = C6936l.m14195a(a, gVar, qVar);
                if (a2 != null) {
                    set.add(a2);
                }
            }
        }
        return set;
    }

    /* renamed from: a */
    public static void m14207a(C6931g gVar, C7254d dVar, C6932h hVar, int i, C7142c cVar) {
        if (cVar != null) {
            C7209sc.m15473a(dVar, gVar.mo22444g(), i, cVar);
            m14211a(m14205a(gVar, (C7267q) cVar), hVar, cVar);
            return;
        }
        throw new IllegalArgumentException("Unable to handle failure. No sdk specified.");
    }

    /* renamed from: a */
    public static void m14208a(C7217uc ucVar, Map<String, Set<C6936l>> map, C6931g gVar, C7267q qVar) {
        C7262l b;
        String str;
        if (qVar != null) {
            String str2 = "VastUtils";
            if (ucVar == null) {
                b = qVar.mo23049b();
                str = "Unable to render event trackers; null node provided";
            } else if (map == null) {
                b = qVar.mo23049b();
                str = "Unable to render event trackers; null event trackers provided";
            } else {
                C7217uc b2 = ucVar.mo23349b("TrackingEvents");
                if (b2 != null) {
                    List<C7217uc> a = b2.mo23348a("Tracking");
                    if (a != null) {
                        for (C7217uc ucVar2 : a) {
                            String str3 = (String) ucVar2.mo23350b().get("event");
                            if (C7269s.m15819a(str3)) {
                                C6936l a2 = C6936l.m14195a(ucVar2, gVar, qVar);
                                if (a2 != null) {
                                    Set set = (Set) map.get(str3);
                                    if (set != null) {
                                        set.add(a2);
                                    } else {
                                        HashSet hashSet = new HashSet();
                                        hashSet.add(a2);
                                        map.put(str3, hashSet);
                                    }
                                }
                            } else {
                                C7262l b3 = qVar.mo23049b();
                                StringBuilder sb = new StringBuilder();
                                sb.append("Could not find event for tracking node = ");
                                sb.append(ucVar2);
                                b3.mo22916b(str2, sb.toString());
                            }
                        }
                    }
                }
                return;
            }
            b.mo22916b(str2, str);
            return;
        }
        throw new IllegalArgumentException("Unable to render event trackers. No sdk specified.");
    }

    /* renamed from: a */
    public static void m14209a(List<C7217uc> list, Set<C6936l> set, C6931g gVar, C7267q qVar) {
        C7262l b;
        String str;
        if (qVar != null) {
            String str2 = "VastUtils";
            if (list == null) {
                b = qVar.mo23049b();
                str = "Unable to render trackers; null nodes provided";
            } else if (set == null) {
                b = qVar.mo23049b();
                str = "Unable to render trackers; null trackers provided";
            } else {
                for (C7217uc a : list) {
                    C6936l a2 = C6936l.m14195a(a, gVar, qVar);
                    if (a2 != null) {
                        set.add(a2);
                    }
                }
                return;
            }
            b.mo22916b(str2, str);
            return;
        }
        throw new IllegalArgumentException("Unable to render trackers. No sdk specified.");
    }

    /* renamed from: a */
    public static void m14210a(Set<C6936l> set, long j, Uri uri, C6932h hVar, C7142c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("Unable to fire trackers. No sdk specified.");
        } else if (set != null && !set.isEmpty()) {
            for (C6936l b : set) {
                Uri a = m14199a(b.mo22461b(), j, uri, hVar, (C7267q) cVar);
                if (a != null) {
                    cVar.mo23077v().mo23085a(a.toString(), null, false);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m14211a(Set<C6936l> set, C6932h hVar, C7142c cVar) {
        m14210a(set, -1, (Uri) null, hVar, cVar);
    }

    /* renamed from: a */
    public static void m14212a(Set<C6936l> set, C7142c cVar) {
        m14210a(set, -1, (Uri) null, C6932h.UNSPECIFIED, cVar);
    }

    /* renamed from: a */
    public static boolean m14213a(C7217uc ucVar) {
        if (ucVar != null) {
            return ucVar.mo23351c("Wrapper") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains a wrapper response");
    }

    /* renamed from: b */
    private static String m14214b() {
        f12806a.setTimeZone(TimeZone.getDefault());
        return f12806a.format(new Date());
    }

    /* renamed from: b */
    public static boolean m14215b(C6925a aVar) {
        boolean z = false;
        if (aVar == null) {
            return false;
        }
        C6939o oa = aVar.mo22409oa();
        if (oa != null) {
            List a = oa.mo22466a();
            if (a != null && !a.isEmpty()) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: b */
    public static boolean m14216b(C7217uc ucVar) {
        if (ucVar != null) {
            return ucVar.mo23351c("InLine") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains an inline response");
    }

    /* renamed from: c */
    public static boolean m14217c(C6925a aVar) {
        boolean z = false;
        if (aVar == null) {
            return false;
        }
        C6930f ra = aVar.mo22411ra();
        if (ra != null) {
            C6933i b = ra.mo22432b();
            if (b != null && (b.mo22451b() != null || C7269s.m15819a(b.mo22452c()))) {
                z = true;
            }
        }
        return z;
    }
}
