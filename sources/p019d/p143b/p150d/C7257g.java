package p019d.p143b.p150d;

import com.mopub.common.AdType;
import java.util.List;
import java.util.Locale;
import p019d.p143b.p144a.p147c.C7178l;

/* renamed from: d.b.d.g */
public class C7257g {

    /* renamed from: a */
    public static final C7257g f14094a = new C7257g(-1, 50, "BANNER");

    /* renamed from: b */
    public static final C7257g f14095b = new C7257g(-1, 75, "LEADER");

    /* renamed from: c */
    public static final C7257g f14096c = new C7257g(-1, -1, "INTER");

    /* renamed from: d */
    public static final C7257g f14097d = new C7257g(300, 250, "MREC");

    /* renamed from: e */
    public static final C7257g f14098e = new C7257g("NATIVE");

    /* renamed from: f */
    private final int f14099f;

    /* renamed from: g */
    private final int f14100g;

    /* renamed from: h */
    private final String f14101h;

    protected C7257g(int i, int i2, String str) {
        if (i < 0 && i != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Ad width must be a positive number. Number provided: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (i > 9999) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Ad width must be less then 9999. Number provided: ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        } else if (i2 < 0 && i2 != -1) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Ad height must be a positive number. Number provided: ");
            sb3.append(i2);
            throw new IllegalArgumentException(sb3.toString());
        } else if (i2 > 9999) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Ad height must be less then 9999. Number provided: ");
            sb4.append(i2);
            throw new IllegalArgumentException(sb4.toString());
        } else if (str == null) {
            throw new IllegalArgumentException("No label specified");
        } else if (str.length() <= 9) {
            this.f14099f = i;
            this.f14100g = i2;
            this.f14101h = str;
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Provided label is too long. Label provided: ");
            sb5.append(str);
            throw new IllegalArgumentException(sb5.toString());
        }
    }

    public C7257g(String str) {
        this(0, 0, str);
    }

    /* renamed from: a */
    public static C7257g m15776a(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        if (lowerCase.equals("banner")) {
            return f14094a;
        }
        if (lowerCase.equals(AdType.INTERSTITIAL) || lowerCase.equals("inter")) {
            return f14096c;
        }
        if (lowerCase.equals("mrec")) {
            return f14097d;
        }
        if (lowerCase.equals("leader")) {
            return f14095b;
        }
        List a = C7178l.m15310a(str, "x");
        return a.size() == 2 ? new C7257g(m15777b((String) a.get(0)), m15777b((String) a.get(1)), str) : new C7257g(0, 0, str);
    }

    /* renamed from: b */
    private static int m15777b(String str) {
        if ("span".equalsIgnoreCase(str)) {
            return -1;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /* renamed from: a */
    public int mo23472a() {
        return this.f14100g;
    }

    /* renamed from: b */
    public String mo23473b() {
        return this.f14101h.toUpperCase(Locale.ENGLISH);
    }

    /* renamed from: c */
    public int mo23474c() {
        return this.f14099f;
    }

    public String toString() {
        return mo23473b();
    }
}
