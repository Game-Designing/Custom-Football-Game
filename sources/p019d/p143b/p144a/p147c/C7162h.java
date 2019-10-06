package p019d.p143b.p144a.p147c;

import android.text.TextUtils;
import java.util.Collection;
import java.util.HashSet;

/* renamed from: d.b.a.c.h */
class C7162h {

    /* renamed from: a */
    private static final Collection<String> f13561a = new HashSet(27);

    /* renamed from: b */
    static final C7162h f13562b = m15238a("sas");

    /* renamed from: c */
    static final C7162h f13563c = m15238a("srt");

    /* renamed from: d */
    static final C7162h f13564d = m15238a("sft");

    /* renamed from: e */
    static final C7162h f13565e = m15238a("sfs");

    /* renamed from: f */
    static final C7162h f13566f = m15238a("sadb");

    /* renamed from: g */
    static final C7162h f13567g = m15238a("sacb");

    /* renamed from: h */
    static final C7162h f13568h = m15238a("stdl");

    /* renamed from: i */
    static final C7162h f13569i = m15238a("stdi");

    /* renamed from: j */
    static final C7162h f13570j = m15238a("snas");

    /* renamed from: k */
    static final C7162h f13571k = m15238a("snat");

    /* renamed from: l */
    static final C7162h f13572l = m15238a("stah");

    /* renamed from: m */
    static final C7162h f13573m = m15238a("stas");

    /* renamed from: n */
    static final C7162h f13574n = m15238a("stac");

    /* renamed from: o */
    static final C7162h f13575o = m15238a("stbe");

    /* renamed from: p */
    static final C7162h f13576p = m15238a("stbc");

    /* renamed from: q */
    static final C7162h f13577q = m15238a("saan");

    /* renamed from: r */
    static final C7162h f13578r = m15238a("suvs");

    /* renamed from: s */
    static final C7162h f13579s = m15238a("svpv");

    /* renamed from: t */
    static final C7162h f13580t = m15238a("stpd");

    /* renamed from: u */
    static final C7162h f13581u = m15238a("sspe");

    /* renamed from: v */
    static final C7162h f13582v = m15238a("shsc");

    /* renamed from: w */
    static final C7162h f13583w = m15238a("shfc");

    /* renamed from: x */
    private final String f13584x;

    static {
        m15238a("sasw");
        m15238a("sisw");
        m15238a("surw");
        m15238a("surp");
        m15238a("swhp");
    }

    private C7162h(String str) {
        this.f13584x = str;
    }

    /* renamed from: a */
    private static C7162h m15238a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No key name specified");
        } else if (!f13561a.contains(str)) {
            f13561a.add(str);
            return new C7162h(str);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Key has already been used: ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    public String mo23158a() {
        return this.f13584x;
    }
}
