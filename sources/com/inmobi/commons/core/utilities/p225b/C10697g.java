package com.inmobi.commons.core.utilities.p225b;

import android.location.Location;
import android.support.p001v7.widget.LinearLayoutManager;
import com.inmobi.commons.core.p221d.C10657c;
import com.inmobi.commons.p217a.C10619a;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.inmobi.commons.core.utilities.b.g */
/* compiled from: PublisherProvidedUserInfoDao */
public final class C10697g {

    /* renamed from: a */
    private static int f32635a = LinearLayoutManager.INVALID_OFFSET;

    /* renamed from: b */
    private static String f32636b;

    /* renamed from: c */
    private static String f32637c;

    /* renamed from: d */
    private static String f32638d;

    /* renamed from: e */
    private static String f32639e;

    /* renamed from: f */
    private static String f32640f;

    /* renamed from: g */
    private static String f32641g;

    /* renamed from: h */
    private static int f32642h = LinearLayoutManager.INVALID_OFFSET;

    /* renamed from: i */
    private static String f32643i;

    /* renamed from: j */
    private static String f32644j;

    /* renamed from: k */
    private static String f32645k;

    /* renamed from: l */
    private static String f32646l;

    /* renamed from: m */
    private static Location f32647m;

    /* renamed from: a */
    public static String m35119a() {
        return C10657c.m34973a("user_info_store");
    }

    /* renamed from: b */
    public static void m35123b() {
        m35120a(f32635a);
        m35122a(f32636b);
        m35125b(f32637c);
        m35127c(f32638d);
        m35129d(f32639e);
        m35130e(f32640f);
        m35131f(f32641g);
        m35124b(f32642h);
        m35132g(f32643i);
        m35133h(f32644j);
        m35134i(f32645k);
        m35135j(f32646l);
        m35121a(f32647m);
    }

    /* renamed from: a */
    public static void m35120a(int i) {
        if (!C10619a.m34838a() || i == Integer.MIN_VALUE) {
            f32635a = i;
        } else {
            C10657c.m34974b("user_info_store").mo34477a("user_age", i);
        }
    }

    /* renamed from: a */
    public static void m35122a(String str) {
        if (!C10619a.m34838a() || str == null) {
            f32636b = str;
        } else {
            C10657c.m34974b("user_info_store").mo34479a("user_age_group", str);
        }
    }

    /* renamed from: b */
    public static void m35125b(String str) {
        if (!C10619a.m34838a() || str == null) {
            f32637c = str;
        } else {
            C10657c.m34974b("user_info_store").mo34479a("user_area_code", str);
        }
    }

    /* renamed from: c */
    public static void m35127c(String str) {
        if (!C10619a.m34838a() || str == null) {
            f32638d = str;
        } else {
            C10657c.m34974b("user_info_store").mo34479a("user_post_code", str);
        }
    }

    /* renamed from: d */
    public static void m35129d(String str) {
        if (!C10619a.m34838a() || str == null) {
            f32639e = str;
        } else {
            C10657c.m34974b("user_info_store").mo34479a("user_city_code", str);
        }
    }

    /* renamed from: e */
    public static void m35130e(String str) {
        if (!C10619a.m34838a() || str == null) {
            f32640f = str;
        } else {
            C10657c.m34974b("user_info_store").mo34479a("user_state_code", str);
        }
    }

    /* renamed from: f */
    public static void m35131f(String str) {
        if (!C10619a.m34838a() || str == null) {
            f32641g = str;
        } else {
            C10657c.m34974b("user_info_store").mo34479a("user_country_code", str);
        }
    }

    /* renamed from: b */
    public static void m35124b(int i) {
        if (!C10619a.m34838a() || i == Integer.MIN_VALUE) {
            f32642h = i;
        } else {
            C10657c.m34974b("user_info_store").mo34477a("user_yob", i);
        }
    }

    /* renamed from: g */
    public static void m35132g(String str) {
        if (!C10619a.m34838a() || str == null) {
            f32643i = str;
        } else {
            C10657c.m34974b("user_info_store").mo34479a("user_gender", str);
        }
    }

    /* renamed from: h */
    public static void m35133h(String str) {
        if (!C10619a.m34838a() || str == null) {
            f32644j = str;
        } else {
            C10657c.m34974b("user_info_store").mo34479a("user_education", str);
        }
    }

    /* renamed from: i */
    public static void m35134i(String str) {
        if (!C10619a.m34838a() || str == null) {
            f32645k = str;
        } else {
            C10657c.m34974b("user_info_store").mo34479a("user_language", str);
        }
    }

    /* renamed from: j */
    public static void m35135j(String str) {
        if (!C10619a.m34838a() || str == null) {
            f32646l = str;
        } else {
            C10657c.m34974b("user_info_store").mo34479a("user_interest", str);
        }
    }

    /* renamed from: c */
    public static Location m35126c() {
        Location location = f32647m;
        if (location != null) {
            return location;
        }
        String c = C10657c.m34974b("user_info_store").mo34483c("user_location");
        Location location2 = null;
        if (c == null) {
            return null;
        }
        Location location3 = new Location("");
        try {
            String[] split = c.split(",");
            location3.setLatitude(Double.parseDouble(split[0]));
            location3.setLongitude(Double.parseDouble(split[1]));
            location3.setAccuracy(Float.parseFloat(split[2]));
            location3.setTime(Long.parseLong(split[3]));
            location2 = location3;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
        }
        return location2;
    }

    /* renamed from: a */
    public static void m35121a(Location location) {
        if (!C10619a.m34838a() || location == null) {
            f32647m = location;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(location.getLatitude());
        String str = ",";
        sb.append(str);
        sb.append(location.getLongitude());
        sb.append(str);
        sb.append((int) location.getAccuracy());
        sb.append(str);
        sb.append(location.getTime());
        C10657c.m34974b("user_info_store").mo34479a("user_location", sb.toString());
    }

    /* renamed from: d */
    public static HashMap<String, String> m35128d() {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        int i = f32635a;
        String str2 = "user_info_store";
        if (i == Integer.MIN_VALUE) {
            i = C10657c.m34974b(str2).mo34484d("user_age");
        }
        if (i != Integer.MIN_VALUE && i > 0) {
            hashMap.put("u-age", String.valueOf(i));
        }
        int i2 = f32642h;
        if (i2 == Integer.MIN_VALUE) {
            i2 = C10657c.m34974b(str2).mo34484d("user_yob");
        }
        if (i2 != Integer.MIN_VALUE && i2 > 0) {
            hashMap.put("u-yearofbirth", String.valueOf(i2));
        }
        String str3 = f32639e;
        if (str3 == null) {
            str3 = C10657c.m34974b(str2).mo34483c("user_city_code");
        }
        String str4 = f32640f;
        if (str4 == null) {
            str4 = C10657c.m34974b(str2).mo34483c("user_state_code");
        }
        String str5 = f32641g;
        if (str5 == null) {
            str5 = C10657c.m34974b(str2).mo34483c("user_country_code");
        }
        if (str3 == null || str3.trim().length() == 0) {
            str = "";
        } else {
            str = str3.trim();
        }
        String str6 = "-";
        if (!(str4 == null || str4.trim().length() == 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str6);
            sb.append(str4.trim());
            str = sb.toString();
        }
        if (!(str5 == null || str5.trim().length() == 0)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(str6);
            sb2.append(str5.trim());
            str = sb2.toString();
        }
        if (!(str == null || str.trim().length() == 0)) {
            hashMap.put("u-location", str);
        }
        String str7 = f32636b;
        if (str7 == null) {
            str7 = C10657c.m34974b(str2).mo34483c("user_age_group");
        }
        if (str7 != null) {
            hashMap.put("u-agegroup", str7.toLowerCase(Locale.ENGLISH));
        }
        String str8 = f32637c;
        if (str8 == null) {
            str8 = C10657c.m34974b(str2).mo34483c("user_area_code");
        }
        if (str8 != null) {
            hashMap.put("u-areacode", str8);
        }
        String str9 = f32638d;
        if (str9 == null) {
            str9 = C10657c.m34974b(str2).mo34483c("user_post_code");
        }
        if (str9 != null) {
            hashMap.put("u-postalcode", str9);
        }
        String str10 = f32643i;
        if (str10 == null) {
            str10 = C10657c.m34974b(str2).mo34483c("user_gender");
        }
        if (str10 != null) {
            hashMap.put("u-gender", str10);
        }
        String str11 = f32644j;
        if (str11 == null) {
            str11 = C10657c.m34974b(str2).mo34483c("user_education");
        }
        if (str11 != null) {
            hashMap.put("u-education", str11);
        }
        String str12 = f32645k;
        if (str12 == null) {
            str12 = C10657c.m34974b(str2).mo34483c("user_language");
        }
        if (str12 != null) {
            hashMap.put("u-language", str12);
        }
        String str13 = f32646l;
        if (str13 == null) {
            str13 = C10657c.m34974b(str2).mo34483c("user_interest");
        }
        if (str13 != null) {
            hashMap.put("u-interests", str13);
        }
        return hashMap;
    }
}
